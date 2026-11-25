package com.haier.uhome.usdk.bind;

import android.content.Context;
import android.text.TextUtils;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.nfc.service.entity.ModuleDeviceInfoResultDto;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceInfo;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.api.uSDKState;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.bind.entity.DeviceWithError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f31673b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CellularDeviceBindInfo f31674a;

    private static class a extends com.haier.library.sumhttp.plugin.l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f31675c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TraceNode f31676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final IBindCellularDeviceCallback f31677e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private b f31678f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicInteger f31679g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final com.haier.uhome.usdk.bind.entity.a f31680h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Map<String, ModuleDeviceInfoResultDto> f31681i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final ConcurrentHashMap<String, ModuleDeviceInfoResultDto> f31682j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ConcurrentHashMap<String, uSDKDevice> f31683k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final ConcurrentHashMap<String, DeviceWithError> f31684l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final BlockingQueue<ModuleDeviceInfoResultDto> f31685m;

        /* JADX INFO: Access modifiers changed from: private */
        public ModuleDeviceInfoResultDto c() throws InterruptedException {
            return this.f31685m.take();
        }

        private void d() {
            if (this.f31678f == null) {
                b bVar = new b(this);
                this.f31678f = bVar;
                com.haier.library.common.thread.m.execute(bVar);
            }
        }

        private void e() {
            b bVar = this.f31678f;
            if (bVar != null) {
                bVar.interrupt();
                this.f31678f = null;
            }
        }

        private synchronized void f() {
            List<uSDKDevice> listA = this.f31680h.a();
            Iterator<Map.Entry<String, uSDKDevice>> it = this.f31683k.entrySet().iterator();
            while (it.hasNext()) {
                listA.add(it.next().getValue());
            }
            List<DeviceWithError> listB = this.f31680h.b();
            Iterator<Map.Entry<String, DeviceWithError>> it2 = this.f31684l.entrySet().iterator();
            while (it2.hasNext()) {
                listB.add(it2.next().getValue());
            }
        }

        private synchronized String g() {
            ArrayList arrayList;
            arrayList = new ArrayList();
            for (Map.Entry<String, ModuleDeviceInfoResultDto> entry : this.f31681i.entrySet()) {
                if (entry != null) {
                    ModuleDeviceInfoResultDto value = entry.getValue();
                    com.haier.uhome.usdk.bind.entity.b bVar = new com.haier.uhome.usdk.bind.entity.b();
                    bVar.a(value.getDeviceId());
                    bVar.b(value.getModuleType());
                    arrayList.add(bVar);
                }
            }
            return com.haier.library.json.a.Z(arrayList);
        }

        private a(String str, TraceNode traceNode, IBindCellularDeviceCallback iBindCellularDeviceCallback, com.haier.library.sumhttp.plugin.a<com.haier.uhome.usdk.bind.entity.a> aVar, com.haier.library.sumhttp.plugin.b bVar) {
            super(aVar, bVar, RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
            this.f31679g = new AtomicInteger(-1);
            this.f31680h = new com.haier.uhome.usdk.bind.entity.a();
            this.f31681i = new HashMap();
            this.f31682j = new ConcurrentHashMap<>();
            this.f31683k = new ConcurrentHashMap<>();
            this.f31684l = new ConcurrentHashMap<>();
            this.f31685m = new LinkedBlockingQueue();
            this.f31675c = str;
            this.f31676d = traceNode;
            this.f31677e = iBindCellularDeviceCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, uSDKDevice usdkdevice) {
            synchronized (this.f31680h) {
                ModuleDeviceInfoResultDto moduleDeviceInfoResultDtoRemove = this.f31682j.remove(str);
                this.f31684l.remove(str);
                if (moduleDeviceInfoResultDtoRemove != null) {
                    this.f31683k.put(str, usdkdevice);
                }
            }
            this.f31677e.progressNotify(this.f31679g.get(), this.f31683k.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, ModuleDeviceInfoResultDto moduleDeviceInfoResultDto, String str2) {
            uSDKError error = ErrorConst.ERR_USDK_DEVICE_BIND_FAILED.toError();
            error.setDescription(str2);
            this.f31684l.put(str, new DeviceWithError(a(moduleDeviceInfoResultDto), error));
        }

        private void a(com.haier.uhome.usdk.bind.entity.a aVar) {
            List<uSDKDevice> listA = aVar.a();
            List<DeviceWithError> listB = aVar.b();
            ArrayList arrayList = new ArrayList(listA.size());
            for (uSDKDevice usdkdevice : listA) {
                if (usdkdevice != null) {
                    arrayList.add(usdkdevice.getDeviceId());
                }
            }
            ArrayList arrayList2 = new ArrayList(listA.size());
            for (DeviceWithError deviceWithError : listB) {
                if (deviceWithError != null && deviceWithError.getDevice() != null) {
                    arrayList2.add(deviceWithError.getDevice().getDeviceId());
                }
            }
            HashMap map = new HashMap();
            map.put("success", arrayList);
            map.put(com.alipay.sdk.util.f.f13791i, arrayList2);
            a(com.haier.library.json.a.Z(map));
        }

        private void a(String str, String str2) {
            com.haier.uhome.trace.api.b.a().a(this.f31676d, "queryDevListWindowOpened", this.f31675c, (String) null, str, str2);
        }

        private void a(String str) {
            com.haier.uhome.trace.api.b.a().a(this.f31676d, "descListDetail", this.f31675c, (String) null, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.haier.library.sumhttp.plugin.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            e3.a.e("get unbind list in http request", new Object[0]);
            com.haier.library.sumhttp.plugin.resp.c<ModuleDeviceInfoResultDto> cVarA = HttpHelper.a(this.f31675c, null);
            int iA = cVarA.a();
            String strB = cVarA.b();
            e3.a.e("get unbind list response in:" + iA, new Object[0]);
            if (iA == 10002) {
                e3.a.e("http response is error, so complete, message is:" + strB, new Object[0]);
                return c.c(iA, strB);
            }
            if (iA == 10003) {
                e3.a.e("http response is error with exception, so mark error and loop, error message is:" + strB, new Object[0]);
                this.f31680h.a(o.b(iA, strB));
                return c.f31692f;
            }
            if (iA == 200) {
                this.f31680h.a(uSDKError.RET_USDK_OK);
            }
            List<ModuleDeviceInfoResultDto> list = (List) cVarA.c();
            if (list != null && list.size() > 0) {
                a(list);
                int i7 = this.f31679g.get();
                int size = this.f31681i.size();
                e3.a.e("lastTotal:" + i7 + " currentTotal:" + size, new Object[0]);
                if (i7 != size) {
                    e3.a.e("update unbind cache", new Object[0]);
                    synchronized (this.f31680h) {
                        o.b(list, this.f31683k);
                        o.b(this.f31682j, list, this.f31685m);
                    }
                    this.f31679g.set(size);
                    int size2 = size - this.f31682j.size();
                    e3.a.e("notify total size changed [%d/%d]", Integer.valueOf(size2), Integer.valueOf(size));
                    this.f31677e.progressNotify(size, size2);
                } else {
                    e3.a.e("nothing change!", new Object[0]);
                }
                d();
                return c.f31692f;
            }
            e3.a.e("http response is empty, so loop", new Object[0]);
            return c.f31692f;
        }

        private void a(List<ModuleDeviceInfoResultDto> list) {
            for (ModuleDeviceInfoResultDto moduleDeviceInfoResultDto : list) {
                this.f31681i.put(moduleDeviceInfoResultDto.getDeviceId(), moduleDeviceInfoResultDto);
            }
        }

        private uSDKDeviceInfo a(ModuleDeviceInfoResultDto moduleDeviceInfoResultDto) {
            return new uSDKDeviceInfo(moduleDeviceInfoResultDto.getDeviceId(), moduleDeviceInfoResultDto.getTypeId(), false);
        }

        @Override // com.haier.library.sumhttp.plugin.l
        protected void a(int i7, String str) {
            String str2;
            e3.a.e("set error with code[%d] message[$s]", Integer.valueOf(i7), str);
            if (i7 == 10001) {
                str2 = "00000";
            } else {
                str2 = i7 + "";
            }
            a(str2, g());
            if (i7 == 10001) {
                if (this.f31680h.c() == null) {
                    this.f31680h.a(uSDKError.RET_USDK_OK);
                }
                f();
                a(this.f31680h);
                a((Object) this.f31680h);
            } else {
                super.a(i7, str);
            }
            e();
        }

        @Override // com.haier.library.sumhttp.plugin.l
        protected void a(Object obj) {
            super.a(obj);
            e();
        }
    }

    static class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f31686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f31687b = com.haier.uhome.usdk.base.service.e.a().b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f31688c;

        public b(a aVar) {
            this.f31686a = aVar;
            String strG = com.haier.uhome.usdk.base.service.e.a().g();
            this.f31688c = com.haier.library.common.util.a.i(strG);
            com.haier.uhome.account.a.a.c().a(strG);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!isInterrupted()) {
                try {
                    final ModuleDeviceInfoResultDto moduleDeviceInfoResultDtoC = this.f31686a.c();
                    final String deviceId = moduleDeviceInfoResultDtoC.getDeviceId();
                    e3.a.e("start bind device: %s", deviceId);
                    com.haier.uhome.account.a.a.c().a(this.f31687b, deviceId, "cellularBind", this.f31688c, new IAccountListener<RespCommonModel>() { // from class: com.haier.uhome.usdk.bind.o.b.1
                        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onResponseSuccess(RespCommonModel respCommonModel) {
                            e3.a.e("bind device success: %s", deviceId);
                            b.this.f31686a.a(deviceId, uSDKDeviceManager.getSingleInstance().a(deviceId, moduleDeviceInfoResultDtoC.getTypeId(), uSDKDeviceNetTypeConst.NET_REMOTE));
                        }

                        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                        public void onHttpError(RespCommonModel respCommonModel) {
                            e3.a.e("bind device with http error: %s", respCommonModel.toString());
                            b.this.f31686a.a(deviceId, moduleDeviceInfoResultDtoC, respCommonModel.toString());
                        }

                        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                        public void onResponseFailed(RespCommonModel respCommonModel) {
                            e3.a.e("bind device with response failed: %s", respCommonModel.toString());
                            b.this.f31686a.a(deviceId, moduleDeviceInfoResultDtoC, respCommonModel.toString());
                        }
                    });
                } catch (InterruptedException e8) {
                    e8.printStackTrace();
                    return;
                }
            }
        }
    }

    private static class c extends com.haier.library.sumhttp.plugin.h<com.haier.uhome.usdk.bind.entity.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final c f31692f = new c(com.haier.library.sumhttp.plugin.h.f27948e, "looper");

        private c(int i7, String str) {
            a(i7, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c c(int i7, String str) {
            return new c(i7, str);
        }

        @Override // com.haier.library.sumhttp.plugin.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.haier.uhome.usdk.bind.entity.a a(String str) {
            return null;
        }
    }

    @Keep
    protected o(CellularDeviceBindInfo cellularDeviceBindInfo) {
        this.f31674a = cellularDeviceBindInfo;
    }

    @Keep
    protected void bind(@c.m0 final IBindCellularDeviceCallback iBindCellularDeviceCallback) {
        uSDKError usdkerrorB = b();
        if (usdkerrorB != null) {
            e3.a.e("check bind enabled error with %s", usdkerrorB.toString());
            a(iBindCellularDeviceCallback, usdkerrorB, this.f31674a.getAppCsNode());
            return;
        }
        if (f31673b.get()) {
            e3.a.e("check bind enabled error with binder is running!", new Object[0]);
            a(iBindCellularDeviceCallback, ErrorConst.ERR_USDK_DEVICE_IS_IN_BINDING.toError(), this.f31674a.getAppCsNode());
            return;
        }
        String moduleID = this.f31674a.getModuleID();
        int timeout = this.f31674a.getTimeout();
        e3.a.e("start working with:" + moduleID, new Object[0]);
        final TraceNode traceNodeA = a();
        a aVar = new a(moduleID, traceNodeA, iBindCellularDeviceCallback, new com.haier.library.sumhttp.plugin.a() { // from class: com.haier.uhome.usdk.bind.c1
            @Override // com.haier.library.sumhttp.plugin.a
            public final void a(Object obj) {
                this.f31518a.a(iBindCellularDeviceCallback, traceNodeA, (com.haier.uhome.usdk.bind.entity.a) obj);
            }
        }, new com.haier.library.sumhttp.plugin.b() { // from class: com.haier.uhome.usdk.bind.d1
            @Override // com.haier.library.sumhttp.plugin.b
            public final void a(int i7, String str) {
                this.f31536a.a(iBindCellularDeviceCallback, traceNodeA, i7, str);
            }
        });
        f31673b.set(true);
        com.haier.library.sumhttp.plugin.i.b(aVar, timeout * 1000);
    }

    private uSDKError b() {
        String moduleID = this.f31674a.getModuleID();
        int timeout = this.f31674a.getTimeout();
        if (uSDKState.STATE_STARTED != uSDKManager.getSingleInstance().getSDKState()) {
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(moduleID)) {
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("param [moduleID] is required!");
            return error;
        }
        if (timeout < 30 || timeout > 180) {
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("param [timeout] is required!");
            return error2;
        }
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(IBindCellularDeviceCallback iBindCellularDeviceCallback, TraceNode traceNode, int i7, String str) {
        a(iBindCellularDeviceCallback, b(i7, str), traceNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IBindCellularDeviceCallback iBindCellularDeviceCallback, com.haier.uhome.usdk.bind.entity.a aVar, TraceNode traceNode) {
        String str;
        uSDKError usdkerrorC = aVar.c();
        if (usdkerrorC != uSDKError.RET_USDK_OK) {
            str = usdkerrorC.getCode() + "";
        } else {
            str = "00000";
        }
        a(traceNode, this.f31674a.getModuleID(), str);
        f31673b.set(false);
        iBindCellularDeviceCallback.completionHandler(aVar.a(), aVar.b(), usdkerrorC);
    }

    private void a(IBindCellularDeviceCallback iBindCellularDeviceCallback, uSDKError usdkerror, TraceNode traceNode) {
        a(traceNode, this.f31674a.getModuleID(), usdkerror.getCode() + "");
        f31673b.set(false);
        iBindCellularDeviceCallback.completionHandler(null, null, usdkerror);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@c.m0 ConcurrentHashMap<String, ModuleDeviceInfoResultDto> concurrentHashMap, @c.m0 List<ModuleDeviceInfoResultDto> list, @c.m0 Queue<ModuleDeviceInfoResultDto> queue) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            ModuleDeviceInfoResultDto moduleDeviceInfoResultDto = list.get(i7);
            if (moduleDeviceInfoResultDto != null) {
                String deviceId = moduleDeviceInfoResultDto.getDeviceId();
                if (concurrentHashMap.get(deviceId) == null) {
                    concurrentHashMap.put(deviceId, moduleDeviceInfoResultDto);
                    queue.add(moduleDeviceInfoResultDto);
                }
            }
        }
    }

    private TraceNode a() {
        return com.haier.uhome.trace.api.b.a().a(this.f31674a.getAppCsNode(), this.f31674a.getModuleID(), this.f31674a.getTimeout());
    }

    private void a(TraceNode traceNode, String str, String str2) {
        com.haier.uhome.trace.api.b.a().a(traceNode, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@c.m0 List<ModuleDeviceInfoResultDto> list, @c.m0 ConcurrentHashMap<String, uSDKDevice> concurrentHashMap) {
        Iterator<ModuleDeviceInfoResultDto> it = list.iterator();
        while (it.hasNext()) {
            ModuleDeviceInfoResultDto next = it.next();
            if (next != null && concurrentHashMap.get(next.getDeviceId()) != null) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static uSDKError b(int i7, String str) {
        uSDKError error = ErrorConst.ERR_INTERNAL.toError();
        error.setDescription("[" + i7 + "] [" + str + "]");
        return error;
    }
}
