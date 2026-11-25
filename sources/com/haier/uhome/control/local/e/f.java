package com.haier.uhome.control.local.e;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.req.BasicOpReq;
import com.haier.uhome.control.base.json.req.GetCacheAlarmReq;
import com.haier.uhome.control.base.json.req.GetCachePropertyReq;
import com.haier.uhome.control.local.json.req.GetDeviceVersionInfoReq;
import com.haier.uhome.control.local.json.req.OnlineMeshDeviceListReq;
import com.haier.uhome.control.local.json.resp.GetDeviceVersionInfoResp;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;

/* JADX INFO: loaded from: classes2.dex */
public class f extends e {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f29426a = new f();

        private a() {
        }
    }

    public static f l() {
        return a.f29426a;
    }

    @Override // com.haier.uhome.control.base.c.a, com.haier.uhome.control.base.c.c
    public void a(String str, int i7, Trace trace, ICallback<com.haier.uhome.control.base.api.r> iCallback) {
    }

    public void b(String str, int i7, final ICallback<Void> iCallback) {
        OnlineMeshDeviceListReq onlineMeshDeviceListReq = new OnlineMeshDeviceListReq();
        onlineMeshDeviceListReq.setModule(f());
        onlineMeshDeviceListReq.setDevId(str);
        onlineMeshDeviceListReq.setNativeSender(this.f31347b);
        onlineMeshDeviceListReq.setTimeout(5);
        onlineMeshDeviceListReq.setElementAddr(i7);
        onlineMeshDeviceListReq.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        com.haier.uhome.usdk.base.d.a.a().a(onlineMeshDeviceListReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.d0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                f.b(iCallback, basicResp);
            }
        });
    }

    public com.haier.uhome.control.local.api.d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (com.haier.uhome.control.local.api.d) ((com.haier.uhome.control.base.c.a) this).f28862a.get(str);
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean e() {
        return true;
    }

    @Override // com.haier.uhome.control.base.c.a
    public String f() {
        return com.haier.uhome.usdk.base.a.as;
    }

    private f() {
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void a(String str, com.haier.uhome.usdk.base.api.o oVar) {
    }

    @Override // com.haier.uhome.control.base.c.a
    public void e(com.haier.uhome.control.base.api.a aVar) {
        if (!e() || aVar == null || aVar.ah()) {
            return;
        }
        if (!g.a().b(aVar.W())) {
            e3.a.o(aVar.e() + " getAllAlarm but uplusId is not ready!!", new Object[0]);
            return;
        }
        com.haier.uhome.control.local.api.d dVar = (com.haier.uhome.control.local.api.d) aVar;
        GetCacheAlarmReq getCacheAlarmReq = new GetCacheAlarmReq();
        getCacheAlarmReq.setTimeout(15);
        getCacheAlarmReq.setTraceId("");
        getCacheAlarmReq.setNativeSender(this.f31347b);
        getCacheAlarmReq.setModule(f());
        getCacheAlarmReq.setDevId(aVar.X());
        getCacheAlarmReq.setElementAddr(dVar.d());
        getCacheAlarmReq.setProxyAddr(dVar.Q());
        final StringBuilder sb = new StringBuilder(String.format("GetCacheAlarmReq type %s start proxy<%s> devId<%s>", f(), Integer.valueOf(dVar.Q()), aVar.X()));
        e3.a.e(sb.toString(), new Object[0]);
        com.haier.uhome.usdk.base.d.a.a().a(getCacheAlarmReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.b0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                f.b(sb, basicResp);
            }
        });
    }

    @Override // com.haier.uhome.control.base.c.a
    protected uSDKError f(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            return ErrorConst.ERR_INTERNAL.toError();
        }
        return (aVar.n() == DeviceStatus.STATUS_READY || aVar.n() == DeviceStatus.STATUS_CONNECTED) ? ErrorConst.RET_USDK_OK.toError() : ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError();
    }

    @Override // com.haier.uhome.control.base.c.a
    protected uSDKError a(com.haier.uhome.control.base.api.a aVar, BasicOpReq basicOpReq) {
        uSDKError usdkerrorA = super.a(aVar, basicOpReq);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (!usdkerrorA.a(errorConst)) {
            return usdkerrorA;
        }
        basicOpReq.setElementAddr(((com.haier.uhome.control.local.api.d) aVar).d());
        return errorConst.toError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(StringBuilder sb, BasicResp basicResp) {
        if (!com.haier.uhome.usdk.base.utils.c.a(basicResp).a(ErrorConst.RET_USDK_OK)) {
            sb.append("-fail:" + basicResp.getErrNo());
        } else {
            sb.append("-success");
        }
        e3.a.e(sb.toString(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ICallback iCallback, BasicResp basicResp) {
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

    public void a(int i7, String str, int i8, final ICallback<com.haier.uhome.control.cloud.api.f> iCallback) {
        GetDeviceVersionInfoReq getDeviceVersionInfoReq = new GetDeviceVersionInfoReq();
        getDeviceVersionInfoReq.setModule(f());
        getDeviceVersionInfoReq.setDevId(str);
        getDeviceVersionInfoReq.setTimeout(i7);
        getDeviceVersionInfoReq.setElementAddr(i8);
        getDeviceVersionInfoReq.setNativeSender(this.f31347b);
        com.haier.uhome.usdk.base.d.a.a().a(getDeviceVersionInfoReq, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.e0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                f.a(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(StringBuilder sb, BasicResp basicResp) {
        if (!com.haier.uhome.usdk.base.utils.c.a(basicResp).a(ErrorConst.RET_USDK_OK)) {
            sb.append("-fail:" + basicResp.getErrNo());
        } else {
            sb.append("-success");
        }
        e3.a.e(sb.toString(), new Object[0]);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void b(com.haier.uhome.control.base.api.a aVar) {
        if (!e() || aVar == null || aVar.ah()) {
            return;
        }
        if (!g.a().b(aVar.W())) {
            e3.a.o(aVar.e() + " getAllProperty but uplusId is not ready!!", new Object[0]);
            return;
        }
        com.haier.uhome.control.local.api.d dVar = (com.haier.uhome.control.local.api.d) aVar;
        GetCachePropertyReq getCachePropertyReq = new GetCachePropertyReq();
        getCachePropertyReq.setTimeout(15);
        getCachePropertyReq.setTraceId("");
        getCachePropertyReq.setNativeSender(this.f31347b);
        getCachePropertyReq.setModule(f());
        getCachePropertyReq.setDevId(aVar.X());
        getCachePropertyReq.setElementAddr(dVar.d());
        getCachePropertyReq.setProxyAddr(dVar.Q());
        final StringBuilder sb = new StringBuilder(String.format("GetCachePropertyReq type %s start proxy<%s> devId<%s>", f(), Integer.valueOf(dVar.Q()), aVar.X()));
        e3.a.e(sb.toString(), new Object[0]);
        com.haier.uhome.usdk.base.d.a.a().a(getCachePropertyReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.c0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                f.a(sb, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        if (iCallback != null) {
            GetDeviceVersionInfoResp getDeviceVersionInfoResp = (GetDeviceVersionInfoResp) basicResp;
            if (getDeviceVersionInfoResp.getErrNo() != 0) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, com.haier.uhome.usdk.base.utils.c.a(getDeviceVersionInfoResp));
                return;
            }
            com.haier.uhome.control.cloud.api.f fVar = new com.haier.uhome.control.cloud.api.f();
            fVar.e(getDeviceVersionInfoResp.getDevVers());
            fVar.c(getDeviceVersionInfoResp.getHardType());
            fVar.d(getDeviceVersionInfoResp.getHardVer());
            fVar.a(getDeviceVersionInfoResp.getSoftType());
            fVar.b(getDeviceVersionInfoResp.getSoftVer());
            com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.control.cloud.api.f>) iCallback, fVar);
        }
    }
}
