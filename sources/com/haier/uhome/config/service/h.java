package com.haier.uhome.config.service;

import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.NewDirectLinkBindReq;
import com.haier.uhome.config.json.resp.NewDirectLinkBindResp;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28608a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f28609b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f28610c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f28611d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f28612e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28613f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28614g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28615h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28616i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28617j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f28618k = 5;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f28619l = 6;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.k<Integer, Void> f28620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ErrorConst f28621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AtomicBoolean f28622o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Runnable f28623p;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f28626a = new h();

        private a() {
        }
    }

    private h() {
        this.f28623p = new Runnable() { // from class: com.haier.uhome.config.service.h.2
            @Override // java.lang.Runnable
            public void run() {
                h hVar = h.this;
                hVar.a(hVar.f28621n.toError(), false);
            }
        };
        this.f28622o = new AtomicBoolean(false);
        this.f28621n = ErrorConst.ERR_USDK_TIMEOUT;
        ConfigProtocol.registerNewDirectLink();
        com.haier.uhome.config.c.c.a().a(new com.haier.uhome.config.c.a() { // from class: com.haier.uhome.config.service.h.1
            @Override // com.haier.uhome.config.c.a, com.haier.uhome.config.c.f
            public void a(String str, int i7, int i8, int i9) {
                if (i9 != 0) {
                    h.this.a(ErrorConst.getErrorConstById(i9).toError(), true);
                    return;
                }
                if (i7 == 0 || i7 == 1) {
                    h.this.b(i7);
                    return;
                }
                if (i7 == 2) {
                    h.this.b(i7);
                } else {
                    if (i7 != 3) {
                        return;
                    }
                    h hVar = h.this;
                    hVar.a(hVar.a(i8), false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f28537a.c(i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i7) {
        com.haier.uhome.usdk.base.api.k<Integer, Void> kVar = this.f28620m;
        if (kVar != null) {
            kVar.a(Integer.valueOf(i7));
            return;
        }
        e3.a.u(com.haier.uhome.config.a.E, "LINK", "onBindProcess callback is null,so give up progress - progress:" + i7, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(uSDKError usdkerror, boolean z7) {
        if (this.f28620m == null) {
            e3.a.u(com.haier.uhome.config.a.E, "LINK", "startBind callback is null,so give up callback - result:" + usdkerror, new Object[0]);
            return;
        }
        if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            this.f28620m.onSuccess(null);
        } else {
            HashMap<String, String> map = new HashMap<>(1);
            map.put("retry", Boolean.toString(z7));
            usdkerror.a(map);
            this.f28620m.onFailure(usdkerror);
        }
        this.f28620m = null;
    }

    public static h a() {
        return a.f28626a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError a(int i7) {
        if (i7 == 0) {
            return ErrorConst.RET_USDK_OK.toError();
        }
        if (i7 == 1) {
            return ErrorConst.ERR_USDK_DEVICE_VERIFY_FAILED.toError();
        }
        if (i7 == 2) {
            return ErrorConst.ERR_USDK_DEVICE_VERIFY_TIMEOUT.toError();
        }
        if (i7 == 3) {
            return ErrorConst.ERR_USDK_DEVICE_IS_BUSY.toError();
        }
        if (i7 == 4) {
            return ErrorConst.ERR_USDK_USER_TOKEN_INVALID.toError();
        }
        if (i7 != 5) {
            return new uSDKError(i7);
        }
        return ErrorConst.ERR_USDK_USER_BIND_COUNT_LIMIT.toError();
    }

    public void a(String str, String str2, int i7, String str3, int i8, String str4, int i9, String str5, long j7, com.haier.uhome.usdk.base.api.k<Integer, Void> kVar) {
        this.f28620m = kVar;
        NewDirectLinkBindReq newDirectLinkBindReq = new NewDirectLinkBindReq();
        try {
            newDirectLinkBindReq.setModule("local");
            newDirectLinkBindReq.setDevId(str);
            newDirectLinkBindReq.setUplusId(str2);
            newDirectLinkBindReq.setTimeout(i7);
            newDirectLinkBindReq.setIp(str3);
            newDirectLinkBindReq.setPort(i8);
            newDirectLinkBindReq.setToken(str4);
            newDirectLinkBindReq.setVerificationMethod(i9);
            newDirectLinkBindReq.setVerificationCode(str5);
            newDirectLinkBindReq.setBindCode(j7);
            newDirectLinkBindReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
            a(newDirectLinkBindReq, i7);
        } catch (Exception unused) {
            a(ErrorConst.ERR_USDK_INVALID_PARAM.toError(), false);
        }
    }

    private void a(BasicReq basicReq, int i7) {
        this.f28621n = ErrorConst.ERR_USDK_TIMEOUT;
        this.f28622o.set(true);
        com.haier.uhome.usdk.base.d.f.a().b().removeCallbacks(this.f28623p);
        com.haier.uhome.usdk.base.d.f.a().b().postDelayed(this.f28623p, i7 * 1000);
        b(-1);
        com.haier.uhome.usdk.base.d.a.a().a(basicReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.d0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f28551a.a(basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BasicResp basicResp) {
        ErrorConst errorConstById = ErrorConst.getErrorConstById(((NewDirectLinkBindResp) basicResp).getErrNo());
        if (!errorConstById.toError().a(ErrorConst.RET_USDK_OK)) {
            a(errorConstById.toError(), false);
        } else {
            e3.a.e("NewDirectLinkBindReq ret ok~,wait for remote device", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final uSDKError usdkerror, final boolean z7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.config.service.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f28542a.b(usdkerror, z7);
            }
        });
    }
}
