package com.haier.uhome.config.service;

import android.text.TextUtils;
import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.NoPasswordRxAckReq;
import com.haier.uhome.config.json.resp.NoPasswordRxAckResp;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f28631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f28632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f28633c;

    private enum a {
        STATUS_NOT_STARTED,
        STATUS_REQUEST_SERVER
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static i f28637a = new i();

        private b() {
        }
    }

    public static i a() {
        return b.f28637a;
    }

    private i() {
        this.f28631a = j.a();
        ConfigProtocol.registerNoPassword();
        a(a.STATUS_NOT_STARTED);
        this.f28633c = new AtomicBoolean(false);
    }

    private synchronized void a(a aVar) {
        this.f28632b = aVar;
    }

    private synchronized a b() {
        return this.f28632b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ICallback iCallback, ErrorConst errorConst) {
        if (iCallback != null) {
            iCallback.onFailure(errorConst.toError());
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ICallback iCallback) {
        if (iCallback != null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS.toError());
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword callback is null,so give up callback", new Object[0]);
        }
    }

    private ErrorConst a(String str, String str2, int i7) {
        if (i7 >= 30 && i7 <= 120) {
            if (TextUtils.isEmpty(str)) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword while devId is empty or null", new Object[0]);
                return ErrorConst.ERR_USDK_INVALID_PARAM;
            }
            if (!TextUtils.isEmpty(str2) && str2.length() != 32 && str2.length() != 64) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword while typeId is invalid", new Object[0]);
                return ErrorConst.ERR_USDK_INVALID_PARAM;
            }
            return ErrorConst.RET_USDK_OK;
        }
        return ErrorConst.ERR_USDK_INVALID_PARAM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ICallback iCallback, ErrorConst errorConst) {
        a(a.STATUS_NOT_STARTED);
        if (iCallback != null) {
            iCallback.onFailure(errorConst.toError());
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.RET_USDK_OK);
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "stopNoPasswordConfig callback is null,so give up callback", new Object[0]);
        }
    }

    public void a(final String str, final String str2, final int i7, final ICallback<com.haier.uhome.usdk.base.api.c<String>> iCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final ErrorConst errorConstA = a(str, str2, i7);
        if (errorConstA != ErrorConst.RET_USDK_OK) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.e0
                @Override // java.lang.Runnable
                public final void run() {
                    i.c(iCallback, errorConstA);
                }
            });
            return;
        }
        synchronized (this) {
            if (b() != a.STATUS_NOT_STARTED) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword error, error id is <%d>", Integer.valueOf(ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS.getErrorId()));
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b(iCallback);
                    }
                });
                return;
            }
            a(a.STATUS_REQUEST_SERVER);
            e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword begin......", new Object[0]);
            this.f28633c.set(false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            com.haier.uhome.usdk.base.hiwifi.d.a().a(arrayList, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.config.service.g0
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f28601a.a(jCurrentTimeMillis, i7, iCallback, str, str2, errorConst);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j7, int i7, final ICallback iCallback, final String str, String str2, final ErrorConst errorConst) {
        if (System.currentTimeMillis() - j7 > i7 * 1000) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28627a.a(iCallback);
                }
            });
            return;
        }
        if (this.f28633c.get()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.i0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28638a.b(iCallback, errorConst);
                }
            });
            return;
        }
        int iCurrentTimeMillis = (int) (((long) i7) - ((System.currentTimeMillis() - j7) / 1000));
        if (ErrorConst.RET_USDK_OK == errorConst) {
            NoPasswordRxAckReq noPasswordRxAckReq = new NoPasswordRxAckReq();
            try {
                noPasswordRxAckReq.setNativeSender(this.f28631a);
                noPasswordRxAckReq.setDevId(str == null ? "" : str);
                if (str2 == null) {
                    str2 = "";
                }
                noPasswordRxAckReq.setTypeId(str2);
                noPasswordRxAckReq.setTimeout(iCurrentTimeMillis - 2);
                com.haier.uhome.usdk.base.d.a.a().a(noPasswordRxAckReq, iCurrentTimeMillis, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.k0
                    @Override // com.haier.uhome.usdk.base.api.l
                    public final void onResp(BasicResp basicResp) {
                        this.f28645a.a(str, iCallback, basicResp);
                    }
                });
                return;
            } catch (Exception e8) {
                e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword Error" + e8.getMessage(), new Object[0]);
                a(a.STATUS_NOT_STARTED);
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.a(iCallback, e8);
                    }
                });
                return;
            }
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f28655a.a(iCallback, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ICallback iCallback) {
        a(a.STATUS_NOT_STARTED);
        if (iCallback != null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_TIMEOUT.toError());
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword callback is null,so give up callback", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, Exception exc) {
        if (iCallback != null) {
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a(exc.getMessage());
            iCallback.onFailure(error);
            return;
        }
        e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceBySmartLink callback is null,so give up callback", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, ICallback iCallback, BasicResp basicResp) {
        NoPasswordRxAckResp noPasswordRxAckResp = (NoPasswordRxAckResp) basicResp;
        ErrorConst errorConstById = ErrorConst.getErrorConstById(noPasswordRxAckResp.getErrNo());
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "rx ack  config .server ret is <%s>", noPasswordRxAckResp);
        a(a.STATUS_NOT_STARTED);
        if (noPasswordRxAckResp.getErrNo() == 0) {
            com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
            cVar.a(ErrorConst.RET_USDK_OK.toError());
            cVar.a(str);
            cVar.a(TraceProtocolConst.PRO_CONFIG_SCM, noPasswordRxAckResp.getScm());
            iCallback.onSuccess(cVar);
            return;
        }
        iCallback.onFailure(errorConstById.toError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ICallback iCallback, ErrorConst errorConst) {
        a(a.STATUS_NOT_STARTED);
        if (iCallback != null) {
            iCallback.onFailure(errorConst.toError());
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "configDeviceByNoPassword callback is null,so give up callback", new Object[0]);
        }
    }

    public void a(final com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.n(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "stop device config begin!", new Object[0]);
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "current smart link config state is:" + b(), new Object[0]);
        this.f28633c.set(true);
        a aVarB = b();
        a aVar = a.STATUS_NOT_STARTED;
        if (aVarB == aVar) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.m0
                @Override // java.lang.Runnable
                public final void run() {
                    i.b(oVar);
                }
            });
        }
        final int iB = this.f28631a.b();
        if (iB == 0) {
            a(aVar);
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.n0
            @Override // java.lang.Runnable
            public final void run() {
                i.a(oVar, iB);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar, int i7) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.getErrorConstById(i7));
        } else {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.H, "stopNoPasswordConfig callback is null,so give up callback", new Object[0]);
        }
    }
}
