package com.haier.uhome.config.service;

import com.haier.uhome.config.entity.ConfigResult;
import com.haier.uhome.config.json.ApInfo;
import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.ConfigGetSmartlinkErrNoReq;
import com.haier.uhome.config.json.req.SoftapConfigReq;
import com.haier.uhome.config.json.req.SoftapGetConfigInfoReq;
import com.haier.uhome.config.json.resp.ConfigGetSmartlinkErrNoResp;
import com.haier.uhome.config.json.resp.SoftapConfigResp;
import com.haier.uhome.config.json.resp.SoftapGetConfigInfoResp;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f28670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f28671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f28672c;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static o f28673a = new o();

        private a() {
        }
    }

    public static o a() {
        return a.f28673a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.RET_USDK_OK);
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "stopService callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(final com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "startService", new Object[0]);
        int iB = this.f28670a.b();
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "startService ret %d.", Integer.valueOf(iB));
        final ErrorConst errorConstById = ErrorConst.getErrorConstById(iB);
        if (errorConstById == ErrorConst.RET_USDK_OK) {
            this.f28671b = true;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.s0
            @Override // java.lang.Runnable
            public final void run() {
                o.b(oVar, errorConstById);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.RET_USDK_OK);
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "startService callback is null,so give up callback", new Object[0]);
        }
    }

    private o() {
        this.f28670a = p.a();
        ConfigProtocol.registerSoftAP();
        this.f28671b = false;
        this.f28672c = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.usdk.base.api.o oVar, ErrorConst errorConst) {
        if (oVar != null) {
            oVar.onCallback(errorConst);
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "startService callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_MODULE_UNSTARTED);
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "getSmartLinkConfigErrorInfo callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "stopService", new Object[0]);
        int iC = this.f28670a.c();
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "stopService ret %d.", Integer.valueOf(iC));
        final ErrorConst errorConstById = ErrorConst.getErrorConstById(iC);
        if (errorConstById == ErrorConst.RET_USDK_OK) {
            this.f28671b = false;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.v0
            @Override // java.lang.Runnable
            public final void run() {
                o.a(oVar, errorConstById);
            }
        });
    }

    public void a(final com.haier.uhome.usdk.base.api.o oVar) {
        if (this.f28671b) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.w0
                @Override // java.lang.Runnable
                public final void run() {
                    o.h(oVar);
                }
            });
        } else {
            com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.config.service.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28705a.g(oVar);
                }
            });
        }
    }

    public void c(final com.haier.uhome.usdk.base.api.o oVar) {
        if (!this.f28671b) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.t0
                @Override // java.lang.Runnable
                public final void run() {
                    o.d(oVar);
                }
            });
            return;
        }
        ConfigGetSmartlinkErrNoReq configGetSmartlinkErrNoReq = new ConfigGetSmartlinkErrNoReq();
        configGetSmartlinkErrNoReq.setNativeSender(this.f28670a);
        com.haier.uhome.usdk.base.d.a.a().a(configGetSmartlinkErrNoReq, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.u0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                o.a(oVar, basicResp);
            }
        });
    }

    public void b(final com.haier.uhome.usdk.base.api.o oVar) {
        if (!this.f28671b) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.g1
                @Override // java.lang.Runnable
                public final void run() {
                    o.f(oVar);
                }
            });
        } else {
            com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.config.service.h1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28629a.e(oVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar, ErrorConst errorConst) {
        if (oVar != null) {
            oVar.onCallback(errorConst);
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "stopService callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ICallback iCallback) {
        if (iCallback != null) {
            iCallback.onFailure(ErrorConst.ERR_MODULE_UNSTARTED.toError());
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftAp callback is null,so give up callback", new Object[0]);
        }
    }

    public void a(final com.haier.uhome.config.a.f fVar, boolean z7, final boolean z8, TraceNode traceNode, final ICallback<ConfigResult> iCallback) {
        if (!this.f28671b) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.b1
                @Override // java.lang.Runnable
                public final void run() {
                    o.b(iCallback);
                }
            });
            return;
        }
        if (fVar == null) {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftAp deviceConfigInfo is null.", new Object[0]);
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.c1
                @Override // java.lang.Runnable
                public final void run() {
                    o.a(iCallback);
                }
            });
            return;
        }
        final TraceNode traceNodeA = z8 ? com.haier.uhome.trace.api.b.a().a(fVar.g(), z7, traceNode) : null;
        final uSDKError error = ErrorConst.RET_USDK_OK.toError();
        SoftapConfigReq softapConfigReq = new SoftapConfigReq();
        try {
            softapConfigReq.setNativeSender(this.f28670a);
            String traceId = "";
            softapConfigReq.setUplusId(fVar.e() == null ? "" : fVar.e());
            softapConfigReq.setPassword(fVar.l());
            softapConfigReq.setSsid(fVar.j());
            softapConfigReq.setSecurity(z7 ? 1 : 0);
            softapConfigReq.setMainGatewayDomain(fVar.a());
            softapConfigReq.setMainGatewayPort(fVar.c());
            softapConfigReq.setCountry(fVar.o());
            softapConfigReq.setBssid(fVar.k());
            softapConfigReq.setToken(fVar.q() == null ? "" : fVar.q());
            if (traceNode != null) {
                traceId = traceNode.getTraceId();
            }
            softapConfigReq.setTraceId(traceId);
            if (fVar.r()) {
                softapConfigReq.setBindCode(fVar.s());
                softapConfigReq.setTs(fVar.t());
            }
        } catch (com.haier.uhome.config.b.b e8) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftAp Error" + e8.getMessage(), new Object[0]);
            error = e8.a();
            error.a(e8.getMessage());
        } catch (Exception e9) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftAp Error" + e9.getMessage(), new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a(e9.getMessage());
        }
        if (!error.a(ErrorConst.RET_USDK_OK)) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.d1
                @Override // java.lang.Runnable
                public final void run() {
                    o.a(iCallback, error);
                }
            });
        } else {
            com.haier.uhome.usdk.base.d.a.a().a(softapConfigReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.e1
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    o.a(z8, fVar, traceNodeA, iCallback, basicResp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback) {
        if (iCallback != null) {
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("deviceConfigInfo is null");
            iCallback.onFailure(error);
            return;
        }
        e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftAp callback is null,so give up callback", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, uSDKError usdkerror) {
        if (iCallback != null) {
            iCallback.onFailure(usdkerror);
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftAp callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z7, com.haier.uhome.config.a.f fVar, TraceNode traceNode, final ICallback iCallback, final BasicResp basicResp) {
        final SoftapConfigResp softapConfigResp = (SoftapConfigResp) basicResp;
        if (z7) {
            com.haier.uhome.trace.api.b.a().a(basicResp.getErrNo(), fVar.g(), Integer.valueOf(softapConfigResp.getSoftapConfigMode()), traceNode);
        }
        final ConfigResult configResult = new ConfigResult(softapConfigResp.getSoftapConfigMode(), softapConfigResp.getLastMatch(), softapConfigResp.getLastErr());
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.r0
            @Override // java.lang.Runnable
            public final void run() {
                o.a(iCallback, softapConfigResp, configResult, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, SoftapConfigResp softapConfigResp, ConfigResult configResult, BasicResp basicResp) {
        if (iCallback != null) {
            if (softapConfigResp.getErrNo() == 0) {
                iCallback.onSuccess(configResult);
                return;
            }
            uSDKError error = ErrorConst.getErrorConstById(basicResp.getErrNo()).toError();
            error.a(com.haier.uhome.usdk.base.a.bb, com.haier.library.json.a.Z(configResult));
            iCallback.onFailure(error);
            return;
        }
        e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "configDeviceBySoftAp callback is null,so give up callback", new Object[0]);
    }

    public void a(final boolean z7, TraceNode traceNode, final ICallback<com.haier.uhome.usdk.base.api.c<com.haier.uhome.config.a.f>> iCallback) {
        if (!this.f28671b) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        if (!this.f28672c.compareAndSet(false, true)) {
            uSDKError error = ErrorConst.ERR_INTERNAL.toError();
            error.setDescription("repeat getSoftApDeviceConfigInfo");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, error);
        } else {
            final TraceNode traceNodeC = z7 ? com.haier.uhome.trace.api.b.a().c(traceNode) : null;
            SoftapGetConfigInfoReq softapGetConfigInfoReq = new SoftapGetConfigInfoReq();
            softapGetConfigInfoReq.setTraceId(traceNode == null ? "" : traceNode.getTraceId());
            softapGetConfigInfoReq.setNativeSender(this.f28670a);
            com.haier.uhome.usdk.base.d.a.a().a(softapGetConfigInfoReq, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.f1
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    this.f28595a.a(z7, traceNodeC, iCallback, basicResp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z7, TraceNode traceNode, final ICallback iCallback, BasicResp basicResp) {
        this.f28672c.set(false);
        final SoftapGetConfigInfoResp softapGetConfigInfoResp = (SoftapGetConfigInfoResp) basicResp;
        final com.haier.uhome.config.a.f fVar = new com.haier.uhome.config.a.f();
        a(softapGetConfigInfoResp, fVar);
        if (z7) {
            com.haier.uhome.trace.api.b.a().a(basicResp.getErrNo(), fVar.g(), (String) null, Integer.valueOf(softapGetConfigInfoResp.getSoftapConfigMode()), traceNode);
        }
        final ErrorConst errorConstById = ErrorConst.getErrorConstById(basicResp.getErrNo());
        if (errorConstById != ErrorConst.RET_USDK_OK) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.z0
                @Override // java.lang.Runnable
                public final void run() {
                    o.a(iCallback, errorConstById);
                }
            });
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.a1
                @Override // java.lang.Runnable
                public final void run() {
                    o.a(iCallback, fVar, softapGetConfigInfoResp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, ErrorConst errorConst) {
        if (iCallback != null) {
            iCallback.onFailure(errorConst.toError());
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "getSoftApDeviceConfigInfo callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, com.haier.uhome.config.a.f fVar, SoftapGetConfigInfoResp softapGetConfigInfoResp) {
        if (iCallback != null) {
            com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
            cVar.a(fVar);
            cVar.a(ErrorConst.RET_USDK_OK.toError());
            cVar.a(TraceProtocolConst.PRO_CONFIG_SCM, Integer.valueOf(softapGetConfigInfoResp.getSoftapConfigMode()));
            iCallback.onSuccess(cVar);
            return;
        }
        e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "getSoftApDeviceConfigInfo callback is null,so give up callback", new Object[0]);
    }

    private void a(SoftapGetConfigInfoResp softapGetConfigInfoResp, com.haier.uhome.config.a.f fVar) {
        ArrayList arrayList = new ArrayList(softapGetConfigInfoResp.getApList().size());
        for (ApInfo apInfo : softapGetConfigInfoResp.getApList()) {
            arrayList.add(new com.haier.uhome.config.a.g(apInfo.getSsid(), apInfo.getPower(), com.haier.uhome.config.a.a.a(apInfo.getEncryptionType())));
        }
        fVar.a(softapGetConfigInfoResp.geteProtocolVer(), softapGetConfigInfoResp.getUplusId(), softapGetConfigInfoResp.getDevId(), softapGetConfigInfoResp.getIp(), arrayList, softapGetConfigInfoResp.getMode());
        fVar.b(softapGetConfigInfoResp.getCapability() == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(final com.haier.uhome.usdk.base.api.o oVar, BasicResp basicResp) {
        final ConfigGetSmartlinkErrNoResp configGetSmartlinkErrNoResp = (ConfigGetSmartlinkErrNoResp) basicResp;
        e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "getSmartLinkConfigErrorInfo done,result is " + configGetSmartlinkErrNoResp.getSmartlinkErrNo(), new Object[0]);
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.y0
            @Override // java.lang.Runnable
            public final void run() {
                o.a(oVar, configGetSmartlinkErrNoResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar, ConfigGetSmartlinkErrNoResp configGetSmartlinkErrNoResp) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.getErrorConstById(configGetSmartlinkErrNoResp.getErrNo(), configGetSmartlinkErrNoResp.getSmartlinkErrNo()));
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "getSmartLinkConfigErrorInfo callback is null,so give up callback", new Object[0]);
        }
    }
}
