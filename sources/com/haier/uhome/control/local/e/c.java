package com.haier.uhome.control.local.e;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.req.DeviceBindInfoReq;
import com.haier.uhome.control.base.json.req.DeviceConnectReq;
import com.haier.uhome.control.base.json.req.DeviceDisconnectReq;
import com.haier.uhome.control.base.json.req.DeviceSetGatewayReq;
import com.haier.uhome.control.base.json.resp.DeviceBindInfoResp;
import com.haier.uhome.control.local.json.ControlBaseProtocol;
import com.haier.uhome.control.local.json.req.OnlineMeshDeviceListReq;
import com.haier.uhome.control.local.json.req.StartOTAReq;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.control.base.c.a implements com.haier.uhome.control.base.c.b, com.haier.uhome.control.base.c.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29419c = -23203;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.control.local.api.f f29420d;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f29421a = new c();

        private a() {
        }
    }

    static {
        ControlBaseProtocol.registerBLE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(com.haier.uhome.control.base.api.l lVar) {
        if (lVar == null) {
            return;
        }
        lVar.onDeviceBindInfoGet(ErrorConst.ERR_USDK_NOT_SUPPORT, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(com.haier.uhome.control.base.api.l lVar) {
        if (lVar == null) {
            return;
        }
        lVar.onDeviceBindInfoGet(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND, null);
    }

    public static c l() {
        return a.f29421a;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void a(String str, com.haier.uhome.usdk.base.api.o oVar) {
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void b(String str, List<Integer> list) {
        super.b(str, list);
        com.haier.uhome.control.local.api.f fVar = this.f29420d;
        if (fVar != null) {
            fVar.b(str, list);
        } else {
            e3.a.v("listener is null,so give up handleSubDeviceDel -%s--%s", str, list);
        }
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean e() {
        return true;
    }

    @Override // com.haier.uhome.control.base.c.a
    public String f() {
        return "local";
    }

    @Override // com.haier.uhome.control.base.c.a
    public int g() {
        return 2;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected int h() {
        return f29419c;
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(com.haier.uhome.control.base.api.l lVar) {
        if (lVar == null) {
            return;
        }
        lVar.onDeviceBindInfoGet(ErrorConst.ERR_MODULE_UNSTARTED, null);
    }

    public void a(com.haier.uhome.control.local.api.f fVar) {
        this.f29420d = fVar;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void a(String str, List<Integer> list) {
        super.a(str, list);
        com.haier.uhome.control.local.api.f fVar = this.f29420d;
        if (fVar != null) {
            fVar.a(str, list);
        } else {
            e3.a.v("listener is null,so give up handleSubDeviceAdd -%s--%s", str, list);
        }
    }

    public void b(String str, String str2, com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.h("disconnect a not find device<id=%s>!!", str);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
        } else {
            if (!e()) {
                aVarB.e(false);
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
                return;
            }
            e3.a.e("LocalControlService disConnectDevice(%s)", str);
            DeviceDisconnectReq deviceDisconnectReq = new DeviceDisconnectReq();
            deviceDisconnectReq.setModule(f());
            deviceDisconnectReq.setDevId(str);
            deviceDisconnectReq.setNativeSender(this.f31347b);
            a(aVarB, deviceDisconnectReq, oVar);
        }
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void a(String str, String str2, String str3) {
        super.a(str, str2, str3);
        com.haier.uhome.control.local.api.f fVar = this.f29420d;
        if (fVar != null) {
            fVar.a(str, str2, str3);
        } else {
            e3.a.u("listener is null,so give up handleBleAdvDeviceAdd %s--%s", str, str2, new Object[0]);
        }
    }

    @Override // com.haier.uhome.control.base.c.a
    public synchronized void a(String str) {
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            return;
        }
        List<String> listL = aVarB.l();
        if (!com.haier.library.common.util.u.h(listL)) {
            Iterator<String> it = listL.iterator();
            while (it.hasNext()) {
                com.haier.uhome.control.base.api.a aVarB2 = b(it.next());
                if (aVarB2 != null) {
                    aVarB2.a(f(), DeviceStatus.STATUS_OFFLINE, 0);
                }
            }
            b(str, com.haier.library.common.util.u.a(listL, new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.local.e.r
                @Override // com.haier.library.common.util.p
                public final Object transform(Object obj) {
                    return Integer.valueOf(com.haier.uhome.control.base.c.b((String) obj));
                }
            }));
        }
        super.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.usdk.base.api.o oVar, BasicResp basicResp) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.getErrorConstById(basicResp.getErrNo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.control.base.api.l lVar) {
        if (lVar == null) {
            return;
        }
        lVar.onDeviceBindInfoGet(ErrorConst.ERR_USDK_INVALID_PARAM, null);
    }

    public void a(String str, String str2, String str3, String str4, int i7, int i8, com.haier.uhome.usdk.base.api.q qVar, String str5, boolean z7, int i9, String str6, com.haier.uhome.usdk.base.api.o oVar) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.h("try to connect a not find device<id=%s>!!", str);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        if (qVar == null) {
            e3.a.h("try to connect device<id=%s> with null protocolType !!", str);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_INTERNAL);
            return;
        }
        aVarB.a(z7);
        String strG = com.haier.uhome.usdk.base.service.e.a().g();
        if (strG == null) {
            strG = "";
        }
        e3.a.d("LocalControlService tryConnectDevice(%s,%s,%s,%d,%s).", str, str3, str4, Integer.valueOf(i7), qVar);
        DeviceConnectReq deviceConnectReq = new DeviceConnectReq();
        deviceConnectReq.setModule(f());
        deviceConnectReq.setDevId(str);
        deviceConnectReq.setMacAddress(str2);
        deviceConnectReq.setBleDevId("");
        deviceConnectReq.setIp(str4);
        deviceConnectReq.setPort(i7);
        deviceConnectReq.setDeviceType(0);
        deviceConnectReq.setUplusId(str3);
        deviceConnectReq.setProtocol(qVar.name());
        deviceConnectReq.setToken(strG);
        deviceConnectReq.setSecurityVersion(str5 + "");
        deviceConnectReq.setSharedPort(i8);
        deviceConnectReq.setNativeSender(this.f31347b);
        deviceConnectReq.setIsMeshGW(((com.haier.uhome.control.local.api.h) aVarB).M() ? 1 : 0);
        deviceConnectReq.setIsAuxConfigCapability(i9);
        deviceConnectReq.setProtVers(str6);
        b(aVarB, deviceConnectReq, oVar);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, int i7, Trace trace, ICallback<String> iCallback) {
        a(this.f31347b, str, str2, list, str3, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, String str4, int i7, Trace trace, ICallback<Void> iCallback) {
        a(this.f31347b, str, str2, list, str3, str4, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, List<com.haier.uhome.control.base.api.c> list2, int i7, Trace trace, String str4, ICallback<Void> iCallback) {
        a(this.f31347b, str, str2, list, str3, list2, i7, trace, str4, iCallback);
    }

    public void a(String str, final ICallback<Void> iCallback) {
        OnlineMeshDeviceListReq onlineMeshDeviceListReq = new OnlineMeshDeviceListReq();
        onlineMeshDeviceListReq.setModule(f());
        onlineMeshDeviceListReq.setDevId(str);
        onlineMeshDeviceListReq.setNativeSender(this.f31347b);
        onlineMeshDeviceListReq.setTimeout(5);
        onlineMeshDeviceListReq.setElementAddr(0);
        com.haier.uhome.usdk.base.d.a.a().a(onlineMeshDeviceListReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.q
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        e3.a.e("OnlineMeshDeviceListResp = " + basicResp, new Object[0]);
        if (iCallback == null) {
            return;
        }
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            iCallback.onSuccess(null);
        } else {
            iCallback.onFailure(usdkerrorA);
        }
    }

    @Override // com.haier.uhome.control.base.c.b
    public void a(String str, String str2, String str3, int i7, String str4, int i8, String str5, String str6, com.haier.uhome.usdk.base.api.q qVar, final com.haier.uhome.usdk.base.api.o oVar) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        if (str4 != null && str4.length() > 0 && str4.length() <= 64) {
            if (!TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5)) {
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_SECURITY_DEVICE_WITHOUT_TOKEN);
                return;
            }
            DeviceSetGatewayReq deviceSetGatewayReq = new DeviceSetGatewayReq();
            try {
                deviceSetGatewayReq.setNativeSender(this.f31347b);
                deviceSetGatewayReq.setModule(f());
                deviceSetGatewayReq.setDevId(str);
                deviceSetGatewayReq.setUplusId(str2);
                deviceSetGatewayReq.setIp4hostaddress(str3);
                deviceSetGatewayReq.setPort(i7);
                deviceSetGatewayReq.setGateway(str4);
                deviceSetGatewayReq.setGatewayport(i8);
                String strName = "";
                if (str5 == null) {
                    str5 = "";
                }
                deviceSetGatewayReq.setToken(str5);
                deviceSetGatewayReq.setSecurity(str6);
                if (qVar != null) {
                    strName = qVar.name();
                }
                deviceSetGatewayReq.setProtocol(strName);
                com.haier.uhome.usdk.base.d.a.a().a(deviceSetGatewayReq, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.p
                    @Override // com.haier.uhome.usdk.base.api.l
                    public final void onResp(BasicResp basicResp) {
                        c.b(oVar, basicResp);
                    }
                });
                return;
            } catch (IllegalArgumentException e8) {
                e3.a.h("trySetDeviceGatewayAndPort error:" + e8.getMessage(), new Object[0]);
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
                return;
            }
        }
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
    }

    @Override // com.haier.uhome.control.base.c.b
    public void a(final String str, String str2, int i7, String str3, String str4, com.haier.uhome.usdk.base.api.q qVar, final boolean z7, TraceNode traceNode, final com.haier.uhome.control.base.api.l lVar) {
        if (!e()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.local.e.s
                @Override // java.lang.Runnable
                public final void run() {
                    c.e(lVar);
                }
            });
            return;
        }
        final com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.local.e.t
                @Override // java.lang.Runnable
                public final void run() {
                    c.d(lVar);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.local.e.u
                @Override // java.lang.Runnable
                public final void run() {
                    c.c(lVar);
                }
            });
            return;
        }
        if (!TextUtils.isEmpty(str3) && str3.length() <= 32) {
            DeviceBindInfoReq deviceBindInfoReq = new DeviceBindInfoReq();
            try {
                deviceBindInfoReq.setNativeSender(this.f31347b);
                deviceBindInfoReq.setDevId(str);
                deviceBindInfoReq.setIp4hostAddress(str2);
                deviceBindInfoReq.setPort(i7);
                deviceBindInfoReq.setToken(str3);
                deviceBindInfoReq.setSecurity(str4);
                deviceBindInfoReq.setIsSharePort(aVarB.Z());
                deviceBindInfoReq.setProtocol(qVar == null ? "" : qVar.name());
                final TraceNode traceNodeA = z7 ? com.haier.uhome.trace.api.b.a().a(str, ((com.haier.uhome.control.local.api.h) aVarB).K(), traceNode) : null;
                com.haier.uhome.usdk.base.d.a.a().a(deviceBindInfoReq, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.w
                    @Override // com.haier.uhome.usdk.base.api.l
                    public final void onResp(BasicResp basicResp) {
                        c.a(z7, str, aVarB, traceNodeA, lVar, basicResp);
                    }
                });
                return;
            } catch (Exception unused) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.local.e.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a(lVar);
                    }
                });
                return;
            }
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.local.e.v
            @Override // java.lang.Runnable
            public final void run() {
                c.b(lVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z7, String str, com.haier.uhome.control.base.api.a aVar, TraceNode traceNode, final com.haier.uhome.control.base.api.l lVar, BasicResp basicResp) {
        final ErrorConst errorConstById = ErrorConst.getErrorConstById(basicResp.getErrNo());
        final String info = ErrorConst.RET_USDK_OK.getErrorId() == basicResp.getErrNo() ? ((DeviceBindInfoResp) basicResp).getInfo() : null;
        if (z7) {
            com.haier.uhome.trace.api.b.a().d(basicResp.getErrNo(), str, ((com.haier.uhome.control.local.api.h) aVar).K(), traceNode);
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.local.e.z
            @Override // java.lang.Runnable
            public final void run() {
                c.a(lVar, errorConstById, info);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.l lVar, ErrorConst errorConst, String str) {
        if (lVar == null) {
            return;
        }
        lVar.onDeviceBindInfoGet(errorConst, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.l lVar) {
        if (lVar == null) {
            return;
        }
        lVar.onDeviceBindInfoGet(ErrorConst.ERR_USDK_INVALID_PARAM, null);
    }

    @Override // com.haier.uhome.control.base.c.a, com.haier.uhome.control.base.c.c
    public void a(String str, int i7, Trace trace, ICallback<com.haier.uhome.control.base.api.r> iCallback) {
        a(this.f31347b, str, i7, trace, iCallback);
    }

    public void a(String str, String str2, String str3, int i7, String str4, final com.haier.uhome.usdk.base.api.o oVar) {
        StartOTAReq startOTAReq = new StartOTAReq();
        startOTAReq.setModule(f());
        startOTAReq.setDevId(str);
        startOTAReq.setTimeout(Integer.MAX_VALUE);
        startOTAReq.setOtaFilePath(str2);
        startOTAReq.setIp(str3);
        startOTAReq.setPort(i7);
        if (str4 == null) {
            str4 = "";
        }
        startOTAReq.setSecurityVersion(str4);
        startOTAReq.setNativeSender(this.f31347b);
        com.haier.uhome.usdk.base.d.a.a().a(startOTAReq, startOTAReq.getTimeout(), new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.y
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(oVar, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar, BasicResp basicResp) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.getErrorConstById(basicResp.getErrNo()));
        }
    }
}
