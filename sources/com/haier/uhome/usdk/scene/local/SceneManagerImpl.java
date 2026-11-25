package com.haier.uhome.usdk.scene.local;

import com.haier.library.common.util.q;
import com.haier.library.sumhttp.response.c;
import com.haier.uhome.search.a.g;
import com.haier.uhome.search.a.n;
import com.haier.uhome.search.a.p;
import com.haier.uhome.search.service.entity.d;
import com.haier.uhome.smart.api.AbsSmartDevice;
import com.haier.uhome.smart.api.DeviceRole;
import com.haier.uhome.smart.api.SmartDeviceManager;
import com.haier.uhome.usdk.api.DeviceListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceAlarm;
import com.haier.uhome.usdk.api.uSDKDeviceAttribute;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.api.uSDKDeviceStatusConst;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.f;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.service.e;
import com.haier.uhome.usdk.scene.json.down.ActionResultInfo;
import com.haier.uhome.usdk.scene.json.down.DetailInfo;
import com.haier.uhome.usdk.scene.json.down.DeviceAttrResp;
import com.haier.uhome.usdk.scene.json.down.DeviceAttrsReport;
import com.haier.uhome.usdk.scene.json.down.ReportBean;
import com.haier.uhome.usdk.scene.json.down.SceneExecuteResp;
import com.haier.uhome.usdk.scene.json.down.SceneSubscribeResp;
import com.haier.uhome.usdk.scene.json.down.SceneUnsubscribeResp;
import com.haier.uhome.usdk.scene.json.up.ActionsBean;
import com.haier.uhome.usdk.scene.json.up.Args;
import com.haier.uhome.usdk.scene.json.up.DeviceAttrReq;
import com.haier.uhome.usdk.scene.json.up.SceneExecuteReq;
import com.haier.uhome.usdk.scene.json.up.SceneSubscribeReq;
import com.haier.uhome.usdk.scene.json.up.SceneUnsubscribeReq;
import com.haier.uhome.usdk.scene.service.SceneListener;
import com.haier.uhome.usdk.scene.service.SceneManager;
import com.haier.uhome.usdk.scene.service.SceneNativeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class SceneManagerImpl implements g, IScenesManager {
    private static final ConcurrentHashMap<String, List<uSDKDeviceAttribute>> LAST_ATTR_MAP = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer> REF_COUNT_MAP = new ConcurrentHashMap<>();
    private static final int TIMEOUT = 15;
    private boolean execResult = false;
    private DeviceListener mDeviceListener = new DeviceListener() { // from class: com.haier.uhome.usdk.scene.local.SceneManagerImpl.1
        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceAlarm(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list) {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceAttributeChange(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list) {
            ReportBean reportBean;
            e3.a.e("SceneManagerImpl onDeviceAttributeChange: devId = " + usdkdevice.getDeviceId(), new Object[0]);
            List<uSDKDeviceAttribute> list2 = (List) SceneManagerImpl.LAST_ATTR_MAP.get(usdkdevice.getDeviceId());
            SceneManagerImpl.LAST_ATTR_MAP.put(usdkdevice.getDeviceId(), list);
            DeviceAttrsReport deviceAttrsReport = new DeviceAttrsReport();
            HashMap<String, List<ReportBean>> map = null;
            for (uSDKDeviceAttribute usdkdeviceattribute : list) {
                HashMap<String, List<ReportBean>> map2 = new HashMap<>();
                ArrayList arrayList = new ArrayList();
                if (list2 != null) {
                    reportBean = null;
                    for (uSDKDeviceAttribute usdkdeviceattribute2 : list2) {
                        if (usdkdeviceattribute.getName().equals(usdkdeviceattribute2.getName())) {
                            reportBean = new ReportBean();
                            reportBean.setT(usdkdeviceattribute2.getTimeStamp());
                            reportBean.setV(usdkdeviceattribute2.getValue());
                        }
                    }
                } else {
                    reportBean = null;
                }
                ReportBean reportBean2 = new ReportBean();
                reportBean2.setT(System.currentTimeMillis());
                reportBean2.setV(usdkdeviceattribute.getValue());
                if (reportBean == null) {
                    reportBean = new ReportBean();
                    reportBean.setT(0L);
                    reportBean.setV("0");
                }
                arrayList.add(reportBean2);
                arrayList.add(reportBean);
                map2.put(usdkdeviceattribute.getName(), arrayList);
                map = map2;
            }
            deviceAttrsReport.setDeviceId(usdkdevice.getDeviceId());
            deviceAttrsReport.setChangeReport(map);
            SceneManager.getInstance().reportDeviceAttrs(deviceAttrsReport);
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceBaseInfoChange(uSDKDevice usdkdevice) {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceOnlineStatusChange(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7) {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onSubDeviceListChange(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList) {
        }
    };
    private SceneListener mScenesListener = new AnonymousClass2();
    private String masterDevId;
    private String typeId;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.scene.local.SceneManagerImpl$2, reason: invalid class name */
    class AnonymousClass2 implements SceneListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSceneSubscribeReq$0(SceneSubscribeReq sceneSubscribeReq, uSDKErrorConst usdkerrorconst) {
            e3.a.e("onSceneSubscribeReq: errorConst = %s", usdkerrorconst.toString());
            SceneSubscribeResp sceneSubscribeResp = new SceneSubscribeResp();
            sceneSubscribeResp.setSn(sceneSubscribeReq.getSn());
            sceneSubscribeResp.setDevId(sceneSubscribeReq.getDevId());
            sceneSubscribeResp.setErrNo(usdkerrorconst.getErrorId());
            SceneManager.getInstance().sendSceneSubscribeResp(sceneSubscribeResp);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSceneUnsubscribeReq$1(SceneUnsubscribeReq sceneUnsubscribeReq, uSDKErrorConst usdkerrorconst) {
            e3.a.e("onSceneUnsubscribeReq errorConst = %s", usdkerrorconst.toError());
            SceneUnsubscribeResp sceneUnsubscribeResp = new SceneUnsubscribeResp();
            sceneUnsubscribeResp.setSn(sceneUnsubscribeReq.getSn());
            sceneUnsubscribeResp.setDevId(sceneUnsubscribeReq.getDevId());
            sceneUnsubscribeResp.setErrNo(usdkerrorconst.getErrorId());
            SceneManager.getInstance().sendSceneUnsubscribeResp(sceneUnsubscribeResp);
        }

        @Override // com.haier.uhome.usdk.scene.service.SceneListener
        public void onAttrReq(DeviceAttrReq deviceAttrReq) {
            String devId = deviceAttrReq.getDevId();
            uSDKDeviceAttribute usdkdeviceattribute = uSDKDeviceManager.getSingleInstance().getDevice(devId).getAttributeMap().get(deviceAttrReq.getAttrName());
            DeviceAttrResp deviceAttrResp = new DeviceAttrResp();
            deviceAttrResp.setSn(deviceAttrReq.getSn());
            deviceAttrResp.setDeviceId(devId);
            if (usdkdeviceattribute != null) {
                deviceAttrResp.setAttrName(usdkdeviceattribute.getName());
                deviceAttrResp.setAttrValue(usdkdeviceattribute.getValue());
            } else {
                deviceAttrResp.setAttrName("");
                deviceAttrResp.setAttrValue("");
            }
            SceneManager.getInstance().sendDeviceAttrResp(deviceAttrResp);
        }

        @Override // com.haier.uhome.usdk.scene.service.SceneListener
        public void onSceneExecuteReq(SceneExecuteReq sceneExecuteReq) {
            Iterator<ActionsBean> it;
            e3.a.e("SceneManagerImpl onSceneExecuteReq sceneExecuteReq = " + sceneExecuteReq.toString(), new Object[0]);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SceneExecuteResp sceneExecuteResp = new SceneExecuteResp();
            sceneExecuteResp.setSn(sceneExecuteReq.getSceneSn().replaceAll(":", "").trim());
            sceneExecuteResp.setSceneId(sceneExecuteReq.getSceneId());
            sceneExecuteResp.setCreateTime(q.a(Long.valueOf(System.currentTimeMillis())));
            ArrayList arrayList3 = new ArrayList();
            Iterator<ActionsBean> it2 = sceneExecuteReq.getActions().iterator();
            while (true) {
                int i7 = 1;
                if (!it2.hasNext()) {
                    break;
                }
                ActionsBean next = it2.next();
                ActionResultInfo actionResultInfo = new ActionResultInfo();
                actionResultInfo.setActionSn(next.getActionSn());
                actionResultInfo.setActionId(next.getActionId());
                actionResultInfo.setCreateTime(q.a(Long.valueOf(System.currentTimeMillis())));
                ArrayList arrayList4 = new ArrayList();
                boolean z7 = true;
                for (final Args args : next.getArgs()) {
                    String deviceId = args.getDeviceId();
                    uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(deviceId);
                    if (device != null) {
                        final CountDownLatch countDownLatch = new CountDownLatch(i7);
                        final DetailInfo detailInfo = new DetailInfo();
                        detailInfo.setDeviceId(deviceId);
                        it = it2;
                        device.writeAttribute(args.getName(), args.getValue(), 15, new ICallback<Void>() { // from class: com.haier.uhome.usdk.scene.local.SceneManagerImpl.2.1
                            @Override // com.haier.uhome.usdk.base.api.ICallback
                            public void onFailure(uSDKError usdkerror) {
                                e3.a.d("devId = %s writeAttribute Failure %s", args.getDeviceId(), usdkerror.toString(), new Object[0]);
                                SceneManagerImpl.this.execResult = false;
                                detailInfo.setResultTime(System.currentTimeMillis());
                                detailInfo.setExecResultCode(String.valueOf(usdkerror.getCode()));
                                detailInfo.setExecResultInfo(usdkerror.getDescription());
                                countDownLatch.countDown();
                            }

                            @Override // com.haier.uhome.usdk.base.api.ICallback
                            public void onSuccess(Void r7) {
                                e3.a.e("devId = %s writeAttribute success", args.getDeviceId());
                                SceneManagerImpl.this.execResult = true;
                                detailInfo.setResultTime(System.currentTimeMillis());
                                detailInfo.setExecResultCode("00000");
                                detailInfo.setExecResultInfo("操作成功");
                                countDownLatch.countDown();
                            }
                        });
                        SceneManagerImpl.this.waitLatch(countDownLatch);
                        detailInfo.setExecResult(SceneManagerImpl.this.execResult);
                        arrayList4.add(detailInfo);
                        z7 = z7 && SceneManagerImpl.this.execResult;
                    } else {
                        it = it2;
                        e3.a.e("this devId = %s uSDKDevice is null", new Object[0]);
                    }
                    it2 = it;
                    i7 = 1;
                }
                Iterator<ActionsBean> it3 = it2;
                actionResultInfo.setUpdateTime(q.a(Long.valueOf(System.currentTimeMillis())));
                actionResultInfo.setDetailInfo(arrayList4);
                actionResultInfo.setBatchResult(z7);
                if (z7) {
                    arrayList.add(1);
                } else {
                    arrayList2.add(0);
                }
                arrayList3.add(actionResultInfo);
                it2 = it3;
            }
            sceneExecuteResp.setUpdateTime(q.a(Long.valueOf(System.currentTimeMillis())));
            sceneExecuteResp.setTriggerType(sceneExecuteReq.getTriggerType());
            if ("manual".equals(sceneExecuteReq.getTriggerType())) {
                sceneExecuteResp.setTriggerValue(e.a().e());
            } else {
                sceneExecuteResp.setTriggerValue(sceneExecuteReq.getTriggerValue());
            }
            sceneExecuteResp.setReportType("ALL");
            if (arrayList.size() == arrayList3.size()) {
                sceneExecuteResp.setStatus(1);
            } else if (arrayList2.size() == arrayList3.size()) {
                sceneExecuteResp.setStatus(0);
            } else {
                sceneExecuteResp.setStatus(3);
            }
            sceneExecuteResp.setActionResultInfo(arrayList3);
            SceneManager.getInstance().sendSceneExecuteResp(sceneExecuteResp);
        }

        @Override // com.haier.uhome.usdk.scene.service.SceneListener
        public void onSceneSubscribeReq(final SceneSubscribeReq sceneSubscribeReq) {
            e3.a.e("onSceneSubscribeReq: sceneSubscribeReq = %s", sceneSubscribeReq.toString());
            SceneManagerImpl.this.addDeviceListener(sceneSubscribeReq.getDevId(), SceneManagerImpl.this.mDeviceListener, new IuSDKCallback() { // from class: com.haier.uhome.usdk.scene.local.a
                @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
                public final void onCallback(uSDKErrorConst usdkerrorconst) {
                    SceneManagerImpl.AnonymousClass2.lambda$onSceneSubscribeReq$0(sceneSubscribeReq, usdkerrorconst);
                }
            });
        }

        @Override // com.haier.uhome.usdk.scene.service.SceneListener
        public void onSceneUnsubscribeReq(final SceneUnsubscribeReq sceneUnsubscribeReq) {
            e3.a.e("onSceneUnsubscribeReq sceneUnsubscribeReq = %s", sceneUnsubscribeReq.toString());
            SceneManagerImpl.this.removeDeviceListener(sceneUnsubscribeReq.getDevId(), SceneManagerImpl.this.mDeviceListener, new IuSDKCallback() { // from class: com.haier.uhome.usdk.scene.local.b
                @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
                public final void onCallback(uSDKErrorConst usdkerrorconst) {
                    SceneManagerImpl.AnonymousClass2.lambda$onSceneUnsubscribeReq$1(sceneUnsubscribeReq, usdkerrorconst);
                }
            });
        }
    }

    private static class SingletonFactory {
        protected static SceneManagerImpl mScenesManager = new SceneManagerImpl();

        private SingletonFactory() {
        }
    }

    public static SceneManagerImpl getInstance() {
        return SingletonFactory.mScenesManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitLatch(CountDownLatch countDownLatch) {
        try {
            e3.a.e("await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(15L, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("latch get excp %s ", e8);
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.haier.uhome.search.a.g
    public /* synthetic */ void a(d dVar) {
        p.a(this, dVar);
    }

    public void addDeviceListener(String str, DeviceListener deviceListener, IuSDKCallback iuSDKCallback) {
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
        if (device == null) {
            e3.a.e("Local Scene addDeviceListener sdkDevice is null", new Object[0]);
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = REF_COUNT_MAP;
        Integer num = concurrentHashMap.get(str);
        if (num == null) {
            num = 0;
        }
        Integer numValueOf = Integer.valueOf(num.intValue() + 1);
        e3.a.e("Local Scene count = %d", numValueOf);
        concurrentHashMap.put(str, numValueOf);
        device.addDeviceListener(deviceListener);
        device.connectNeedProperties(iuSDKCallback);
    }

    @Override // com.haier.uhome.usdk.scene.local.IScenesManager
    public int init() {
        int iInit = SceneNativeService.getInstance().init();
        if (iInit == 0) {
            SceneManager.getInstance().setScenesListener(this.mScenesListener);
            n.a().a(this);
            reportLocalDevice();
        }
        return iInit;
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceAdd(String str, f fVar) {
        e3.a.d("SceneManagerImpl", "onDeviceAdd: module = %s, dev = %s", str, fVar.b());
        if (str.equals("local") || str.equals(com.haier.uhome.usdk.base.a.aq) || str.equals(com.haier.uhome.usdk.base.a.as)) {
            upDevsFound(fVar.b());
        }
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceDel(String str, f fVar, int i7) {
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceUpdate(String str, f fVar) {
    }

    public void removeDeviceListener(String str, DeviceListener deviceListener, IuSDKCallback iuSDKCallback) {
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
        if (device == null) {
            e3.a.e("Local Scene removeDeviceListener sdkDevice is null", new Object[0]);
            return;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = REF_COUNT_MAP;
        Integer num = concurrentHashMap.get(str);
        if (num == null) {
            e3.a.e("Local Scene removeDeviceListener count is null", new Object[0]);
            return;
        }
        Integer numValueOf = Integer.valueOf(num.intValue() - 1);
        e3.a.e("Local Scene removeDeviceListener count = %d", numValueOf);
        concurrentHashMap.put(str, numValueOf);
        if (numValueOf.intValue() == 0) {
            device.removeDeviceListener(deviceListener);
            device.disconnect(iuSDKCallback);
        }
    }

    public void reportLocalDevice() {
        ArrayList<uSDKDevice> deviceList = uSDKDeviceManager.getSingleInstance().getDeviceList();
        ArrayList arrayList = new ArrayList();
        for (uSDKDevice usdkdevice : deviceList) {
            if (usdkdevice.getNetType() == uSDKDeviceNetTypeConst.NET_LOCAL || usdkdevice.getNetType() == uSDKDeviceNetTypeConst.NET_BLE || usdkdevice.getNetType() == uSDKDeviceNetTypeConst.NET_MESH) {
                o3.f fVar = new o3.f();
                fVar.b(usdkdevice.getDeviceId());
                arrayList.add(fVar);
            }
        }
        upDevsFound(arrayList);
    }

    @Override // com.haier.uhome.usdk.scene.local.IScenesManager
    public int unInit() {
        int iUnInit = SceneNativeService.getInstance().unInit();
        if (iUnInit == 0) {
            SceneManager.getInstance().setScenesListener(null);
            n.a().b(this);
        }
        return iUnInit;
    }

    public void upDevsFound(String str) {
        e3.a.e("SceneManagerImpl upDevsFound devId = %s", str);
        o3.f fVar = new o3.f();
        fVar.b(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar);
        upDevsFound(arrayList);
    }

    private void upDevsFound(List<o3.f> list) {
        e3.a.e("SceneManagerImpl upDevsFound: masterDevId = " + this.masterDevId + " typeId = " + this.typeId, new Object[0]);
        if (this.masterDevId == null && this.typeId == null) {
            Iterator<uSDKDevice> it = uSDKDeviceManager.getSingleInstance().getDeviceList().iterator();
            while (it.hasNext()) {
                AbsSmartDevice onlineDeviceById = SmartDeviceManager.getInstance().getOnlineDeviceById(it.next().getDeviceId());
                if (onlineDeviceById != null && DeviceRole.GATEWAY_DEVICE.equals(onlineDeviceById.getRole())) {
                    this.masterDevId = onlineDeviceById.getDeviceId();
                    this.typeId = onlineDeviceById.getUplusId();
                }
            }
        }
        if (this.masterDevId == null && this.typeId == null) {
            e3.a.e("SceneManagerImpl upDevsFound: masterDevId is null and typeId is null", new Object[0]);
            return;
        }
        o3.d dVar = new o3.d();
        dVar.c(this.masterDevId);
        dVar.d(this.typeId);
        com.haier.library.sumhttp.request.a.h().u(dVar, list, "", new m3.a<c>() { // from class: com.haier.uhome.usdk.scene.local.SceneManagerImpl.3
            @Override // m3.a
            public void onError(Exception exc) {
                e3.a.e("SceneManagerImpl upDevsFound e = %", exc.toString());
            }

            @Override // m3.a
            public void onSuccess(c cVar) {
                e3.a.e("SceneManagerImpl upDevsFound %s", cVar.a());
            }
        });
    }
}
