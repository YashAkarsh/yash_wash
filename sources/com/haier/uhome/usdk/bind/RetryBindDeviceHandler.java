package com.haier.uhome.usdk.bind;

import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.api.uSDKState;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class RetryBindDeviceHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f31468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private uSDKError f31470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f31471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f31472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TraceNode f31473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f31474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f31475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ICallback<uSDKDevice> f31476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f31477m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TraceNode f31478n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ICallback<com.haier.uhome.usdk.api.w> f31479o = new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.RetryBindDeviceHandler.3
        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
            if (RetryBindDeviceHandler.this.f31476l != null) {
                RetryBindDeviceHandler.getSingleInstance().k();
                RetryBindDeviceHandler retryBindDeviceHandler = RetryBindDeviceHandler.this;
                retryBindDeviceHandler.a(wVar, (ICallback<uSDKDevice>) retryBindDeviceHandler.f31476l);
            }
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            if (RetryBindDeviceHandler.this.f31476l != null) {
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
                RetryBindDeviceHandler retryBindDeviceHandler = RetryBindDeviceHandler.this;
                retryBindDeviceHandler.a(usdkerror, (ICallback<uSDKDevice>) retryBindDeviceHandler.f31476l);
            }
        }
    };

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final RetryBindDeviceHandler f31485a = new RetryBindDeviceHandler();

        private a() {
        }
    }

    private void b(ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        if (iCallback != null) {
            e3.a.e("retryBindInvalidParam", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Keep
    public static RetryBindDeviceHandler getSingleInstance() {
        return a.f31485a;
    }

    public RetryBindDeviceHandler c(String str) {
        this.f31467c = str;
        return this;
    }

    public long d() {
        return this.f31468d;
    }

    public int e() {
        return this.f31469e;
    }

    public uSDKError f() {
        return this.f31470f;
    }

    public boolean g() {
        return this.f31471g;
    }

    @Keep
    public String getBindType() {
        return this.f31475k;
    }

    public TraceNode h() {
        return this.f31473i;
    }

    public boolean i() {
        return this.f31474j;
    }

    public TraceNode j() {
        return this.f31478n;
    }

    public void k() {
        this.f31465a = null;
        this.f31466b = null;
        this.f31467c = null;
        this.f31468d = 0L;
        this.f31469e = -1;
        this.f31470f = null;
        this.f31471g = false;
        this.f31473i = null;
        this.f31475k = null;
        this.f31478n = null;
        this.f31472h = 0L;
        this.f31477m = 0L;
    }

    public boolean l() {
        return this.f31465a == null;
    }

    @Keep
    public void retryBindDevice(int i7, final ICallback<uSDKDevice> iCallback) {
        uSDKError usdkerror;
        e3.a.e("retryBindDevice info : %s", toString());
        if (this.f31473i != null) {
            this.f31478n = com.haier.uhome.trace.api.b.a().b(this.f31465a, "local", i7, this.f31473i);
        }
        if (uSDKState.STATE_STARTED != uSDKManager.getSingleInstance().getSDKState()) {
            a(ErrorConst.ERR_USDK_UNSTARTED.toError(), iCallback);
            return;
        }
        this.f31476l = iCallback;
        if (i7 < 10 || i7 > 180) {
            b(this.f31479o);
            return;
        }
        int i8 = i7 * 1000;
        if (l() || (usdkerror = this.f31470f) == null || !usdkerror.a(ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND)) {
            a(this.f31479o);
            return;
        }
        if (g()) {
            s.a().a(this.f31465a, this.f31466b, this.f31468d, this.f31469e, i8, this.f31478n, new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.RetryBindDeviceHandler.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                    RetryBindDeviceHandler.this.a(wVar, (ICallback<uSDKDevice>) iCallback);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror2) {
                    RetryBindDeviceHandler.this.a(usdkerror2, (ICallback<uSDKDevice>) iCallback);
                }
            });
            return;
        }
        com.haier.uhome.usdk.c.f fVarA = com.haier.uhome.usdk.c.f.a();
        String str = this.f31465a;
        long j7 = this.f31468d;
        fVarA.b(str, j7, this.f31469e, i8, this.f31478n, j7 > 0, this.f31477m, this.f31472h, new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.RetryBindDeviceHandler.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                RetryBindDeviceHandler.this.a(wVar, (ICallback<uSDKDevice>) iCallback);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror2) {
                if (usdkerror2 != null && usdkerror2.a(ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT)) {
                    usdkerror2 = ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND.toError();
                }
                RetryBindDeviceHandler.this.a(usdkerror2, (ICallback<uSDKDevice>) iCallback);
            }
        });
    }

    @Keep
    public RetryBindDeviceHandler setBindType(String str) {
        this.f31475k = str;
        return this;
    }

    public String toString() {
        return "RetryBindDeviceHandler{retryDeviceId='" + this.f31465a + "', retryUplusId='" + this.f31466b + "', retryMeshDeviceKey='" + this.f31467c + "', retryBindCode=" + this.f31468d + ", bindCodeFrom=" + this.f31469e + ", retrySdkError=" + this.f31470f + ", isUserBind=" + this.f31471g + ", retryTraceNode=" + this.f31473i + ", isNeedRetryReq=" + this.f31474j + ", retryBindType='" + this.f31475k + "', ts1=" + this.f31477m + '}';
    }

    public String c() {
        return this.f31467c;
    }

    private void a(ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        if (iCallback != null) {
            e3.a.e("retryBindError", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_NO_NEED_RETYR_BIND.toError());
        }
    }

    public RetryBindDeviceHandler b(String str) {
        this.f31466b = str;
        return this;
    }

    public RetryBindDeviceHandler b(boolean z7) {
        this.f31474j = z7;
        return this;
    }

    public String b() {
        return this.f31466b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.uhome.usdk.api.w wVar, ICallback<uSDKDevice> iCallback) {
        if (this.f31473i != null) {
            com.haier.uhome.trace.api.b.a().c(this.f31465a, wVar.b(), ErrorConst.RET_USDK_OK.getErrorId(), j());
        }
        com.haier.uhome.usdk.base.utils.b.a(iCallback, wVar.a());
    }

    public void b(long j7) {
        this.f31477m = j7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKError usdkerror, ICallback<uSDKDevice> iCallback) {
        if (this.f31473i != null) {
            com.haier.uhome.trace.api.b.a().c(this.f31465a, usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL), usdkerror.getCode(), j());
        }
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerror);
    }

    public RetryBindDeviceHandler a(String str) {
        this.f31465a = str;
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(str);
        this.f31472h = fVarA != null ? fVarA.l() : 0L;
        return this;
    }

    public RetryBindDeviceHandler a(long j7) {
        this.f31468d = j7;
        return this;
    }

    public RetryBindDeviceHandler a(int i7) {
        this.f31469e = i7;
        return this;
    }

    public RetryBindDeviceHandler a(uSDKError usdkerror) {
        this.f31470f = usdkerror;
        return this;
    }

    public RetryBindDeviceHandler a(boolean z7) {
        this.f31471g = z7;
        return this;
    }

    public RetryBindDeviceHandler a(TraceNode traceNode) {
        this.f31473i = traceNode;
        return this;
    }

    public String a() {
        return this.f31465a;
    }
}
