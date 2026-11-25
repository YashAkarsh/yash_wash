package com.haier.uhome.control.local.e;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.req.BeginUpdateRouterSsidPasswordReq;
import com.haier.uhome.control.base.json.req.DeviceConnectReq;
import com.haier.uhome.control.base.json.req.DeviceDisconnectReq;
import com.haier.uhome.control.base.json.req.EndUpdateRouterSsidPasswordReq;
import com.haier.uhome.control.local.json.req.CancelGetBleHistoryReq;
import com.haier.uhome.control.local.json.req.GetBleHistoryReq;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.control.local.e.a {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f29417a = new b();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    public static b l() {
        return a.f29417a;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void a(String str, com.haier.uhome.usdk.base.api.o oVar) {
    }

    public void b(String str, com.haier.uhome.usdk.base.api.o oVar) {
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
            e3.a.e("LocalBLEControlService disConnectDevice(%s)", str);
            DeviceDisconnectReq deviceDisconnectReq = new DeviceDisconnectReq();
            deviceDisconnectReq.setModule(f());
            deviceDisconnectReq.setDevId(str);
            deviceDisconnectReq.setNativeSender(this.f31347b);
            a(aVarB, deviceDisconnectReq, oVar);
        }
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean e() {
        return true;
    }

    @Override // com.haier.uhome.control.base.c.a
    public String f() {
        return com.haier.uhome.usdk.base.a.aq;
    }

    @Override // com.haier.uhome.control.base.c.a
    public int g() {
        return 5;
    }

    @Override // com.haier.uhome.control.base.c.a
    public String k() {
        return com.haier.uhome.usdk.base.utils.a.c() ? "3" : "0";
    }

    private b() {
    }

    public void a(String str, String str2, String str3, com.haier.uhome.usdk.base.api.q qVar, String str4, boolean z7, int i7, String str5, com.haier.uhome.usdk.base.api.o oVar) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.h("connect a not find device<id=%s>!!", str);
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
        e3.a.d("LocalBLEControlService connectDevice(%s,%s,%s).", str, str3, str2);
        DeviceConnectReq deviceConnectReq = new DeviceConnectReq();
        deviceConnectReq.setModule(f());
        deviceConnectReq.setDevId(str);
        deviceConnectReq.setMacAddress("");
        deviceConnectReq.setBleDevId(str2);
        deviceConnectReq.setIp("");
        deviceConnectReq.setPort(0);
        deviceConnectReq.setDeviceType(aVarB.af() != 1 ? 2 : 1);
        deviceConnectReq.setUplusId(str3);
        deviceConnectReq.setProtocol(qVar.name());
        deviceConnectReq.setToken(strG);
        deviceConnectReq.setSecurityVersion(str4);
        deviceConnectReq.setSharedPort(0);
        deviceConnectReq.setNativeSender(this.f31347b);
        deviceConnectReq.setIsAuxConfigCapability(i7);
        deviceConnectReq.setProtVers(str5);
        b(aVarB, deviceConnectReq, oVar);
    }

    @Override // com.haier.uhome.control.base.c.a
    protected uSDKError f(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            return ErrorConst.ERR_INTERNAL.toError();
        }
        return (aVar.n() == DeviceStatus.STATUS_READY || aVar.n() == DeviceStatus.STATUS_CONNECTED) ? ErrorConst.RET_USDK_OK.toError() : ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError();
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean c(com.haier.uhome.control.base.api.a aVar) {
        com.haier.uhome.control.local.api.g gVar = (com.haier.uhome.control.local.api.g) aVar;
        if (gVar != null && gVar.L()) {
            e3.a.v("LocalBLEControlService getAllProperty abort when ota!", new Object[0]);
            return false;
        }
        return super.c(aVar);
    }

    public void b(String str, final ICallback<Void> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        uSDKError usdkerrorF = f(b(str));
        if (!usdkerrorF.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorF);
            return;
        }
        GetBleHistoryReq getBleHistoryReq = new GetBleHistoryReq();
        getBleHistoryReq.setNativeSender(this.f31347b);
        getBleHistoryReq.setModule(f());
        getBleHistoryReq.setDevId(str);
        getBleHistoryReq.setTraceId("");
        getBleHistoryReq.setTimeout(15);
        com.haier.uhome.usdk.base.d.f.a().a(getBleHistoryReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.l
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                b.c(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
            return;
        }
        if (usdkerrorA.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            usdkerrorA = ErrorConst.ERR_USDK_UPDATE_SSID_PASSWORD_TIMEOUT.toError();
        }
        com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
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
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        uSDKError usdkerrorF = f(b(str));
        if (!usdkerrorF.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorF);
            return;
        }
        CancelGetBleHistoryReq cancelGetBleHistoryReq = new CancelGetBleHistoryReq();
        cancelGetBleHistoryReq.setNativeSender(this.f31347b);
        cancelGetBleHistoryReq.setDevId(str);
        cancelGetBleHistoryReq.setModule(f());
        cancelGetBleHistoryReq.setTraceId("");
        cancelGetBleHistoryReq.setTimeout(15);
        com.haier.uhome.usdk.base.d.f.a().a(cancelGetBleHistoryReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.n
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                b.d(iCallback, basicResp);
            }
        });
    }

    public void b(String str, String str2, final ICallback<Void> iCallback) {
        EndUpdateRouterSsidPasswordReq endUpdateRouterSsidPasswordReq = new EndUpdateRouterSsidPasswordReq();
        endUpdateRouterSsidPasswordReq.setModule(f());
        endUpdateRouterSsidPasswordReq.setDevId(str);
        endUpdateRouterSsidPasswordReq.setBleDevId(str2);
        endUpdateRouterSsidPasswordReq.setNativeSender(this.f31347b);
        com.haier.uhome.usdk.base.d.f.a().a(endUpdateRouterSsidPasswordReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.o
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                b.a(iCallback, basicResp);
            }
        });
    }

    @Override // com.haier.uhome.control.base.c.a, com.haier.uhome.control.base.c.c
    public void a(String str, int i7, Trace trace, ICallback<com.haier.uhome.control.base.api.r> iCallback) {
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT.toError());
    }

    public void a(String str, String str2, String str3, String str4, String str5, int i7, String str6, String str7, String str8, final ICallback<Void> iCallback) {
        String strG = com.haier.uhome.usdk.base.service.e.a().g();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jA = com.haier.uhome.usdk.base.utils.f.a();
        BeginUpdateRouterSsidPasswordReq beginUpdateRouterSsidPasswordReq = new BeginUpdateRouterSsidPasswordReq();
        try {
            beginUpdateRouterSsidPasswordReq.setModule(com.haier.uhome.usdk.base.a.aq);
            beginUpdateRouterSsidPasswordReq.setDevId(str4);
            beginUpdateRouterSsidPasswordReq.setBleDevId(str5);
            beginUpdateRouterSsidPasswordReq.setSsid(str);
            beginUpdateRouterSsidPasswordReq.setPassword(str2);
            beginUpdateRouterSsidPasswordReq.setBssid(str3);
            beginUpdateRouterSsidPasswordReq.setTimeout(i7);
            beginUpdateRouterSsidPasswordReq.setCfgVer(Integer.parseInt(str7));
            beginUpdateRouterSsidPasswordReq.setBindCode(jA);
            beginUpdateRouterSsidPasswordReq.setToken(strG);
            beginUpdateRouterSsidPasswordReq.setTraceId("");
            beginUpdateRouterSsidPasswordReq.setDomain("");
            beginUpdateRouterSsidPasswordReq.setCountry("");
            beginUpdateRouterSsidPasswordReq.setTimestamp(jCurrentTimeMillis);
            beginUpdateRouterSsidPasswordReq.setDeviceType(1);
            beginUpdateRouterSsidPasswordReq.setIsReconnection(1);
            beginUpdateRouterSsidPasswordReq.setProtocol(str6);
            beginUpdateRouterSsidPasswordReq.setUplusId(str8);
            try {
                beginUpdateRouterSsidPasswordReq.setNativeSender(this.f31347b);
            } catch (Exception unused) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            }
        } catch (Exception unused2) {
        }
        com.haier.uhome.usdk.base.d.f.a().a(beginUpdateRouterSsidPasswordReq, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.m
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                b.b(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }
}
