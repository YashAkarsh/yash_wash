package com.haier.uhome.control.local.e;

import com.haier.uhome.control.base.json.req.BasicOpReq;
import com.haier.uhome.control.base.json.req.GetCachePropertyReq;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;

/* JADX INFO: loaded from: classes2.dex */
public class d extends e {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f29423a = new d();

        private a() {
        }
    }

    protected d() {
    }

    public static d l() {
        return a.f29423a;
    }

    @Override // com.haier.uhome.control.base.c.a, com.haier.uhome.control.base.c.c
    public void a(String str, int i7, Trace trace, ICallback<com.haier.uhome.control.base.api.r> iCallback) {
    }

    @Override // com.haier.uhome.control.base.c.a
    public void b(com.haier.uhome.control.base.api.a aVar) {
        if (!e() || aVar == null || aVar.ah()) {
            return;
        }
        if (!g.a().b(aVar.W())) {
            e3.a.n("device<%s-%s> getAllProperty but uplusId<%s> is not ready!!", aVar.X(), aVar.e(), aVar.W());
            return;
        }
        com.haier.uhome.control.local.api.i iVar = (com.haier.uhome.control.local.api.i) aVar;
        com.haier.uhome.control.local.api.h hVarS = iVar.S();
        GetCachePropertyReq getCachePropertyReq = new GetCachePropertyReq();
        getCachePropertyReq.setTimeout(15);
        getCachePropertyReq.setTraceId("");
        getCachePropertyReq.setNativeSender(this.f31347b);
        getCachePropertyReq.setModule(f());
        getCachePropertyReq.setElementAddr(iVar.d());
        getCachePropertyReq.setDevId(hVarS.X());
        final StringBuilder sb = new StringBuilder(String.format("GetCachePropertyReq type %s devId<%s> gateway<%s> start", f(), aVar.X(), hVarS.X()));
        e3.a.e(sb.toString(), new Object[0]);
        com.haier.uhome.usdk.base.d.a.a().a(getCachePropertyReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.a0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                d.a(sb, basicResp);
            }
        });
    }

    @Override // com.haier.uhome.control.base.c.a
    public void e(com.haier.uhome.control.base.api.a aVar) {
    }

    @Override // com.haier.uhome.control.base.c.a
    public String f() {
        return com.haier.uhome.usdk.base.a.at;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected void a(String str, com.haier.uhome.usdk.base.api.o oVar) {
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean e() {
        return true;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected uSDKError a(com.haier.uhome.control.base.api.a aVar, BasicOpReq basicOpReq) {
        uSDKError usdkerrorA = super.a(aVar, basicOpReq);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (!usdkerrorA.a(errorConst)) {
            return usdkerrorA;
        }
        com.haier.uhome.control.local.api.i iVar = (com.haier.uhome.control.local.api.i) aVar;
        basicOpReq.setElementAddr(iVar.d());
        com.haier.uhome.control.local.api.h hVarS = iVar.S();
        if (hVarS == null) {
            return ErrorConst.ERR_USDK_DEVICE_IS_OFFLINE.toError();
        }
        basicOpReq.setDevId(hVarS.X());
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
}
