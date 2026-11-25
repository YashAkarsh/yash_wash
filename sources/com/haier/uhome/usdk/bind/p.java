package com.haier.uhome.usdk.bind;

import android.os.Handler;
import android.text.TextUtils;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f31696a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f31697b;

    /* JADX INFO: Access modifiers changed from: private */
    static class a<D> extends com.haier.uhome.usdk.api.b.a<D> implements IBindResultCallback<D> {
        a(IBindResultCallback<D> iBindResultCallback) {
            super(iBindResultCallback);
        }

        @Override // com.haier.uhome.usdk.bind.IBindResultCallback
        public void notifyProgress(final BindProgress bindProgress, final String str, final String str2) {
            ICallback<D> iCallbackB = b();
            if (iCallbackB == null) {
                return;
            }
            final IBindResultCallback iBindResultCallback = (IBindResultCallback) iCallbackB;
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.f1
                @Override // java.lang.Runnable
                public final void run() {
                    iBindResultCallback.notifyProgress(bindProgress, str, str2);
                }
            });
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            a(usdkerror, null);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onSuccess(D d8) {
            a(ErrorConst.RET_USDK_OK.toError(), d8);
        }
    }

    p(BaseBindInfo baseBindInfo) {
        super(baseBindInfo);
        this.f31697b = new AtomicBoolean(true);
        a(true);
        b(true);
    }

    @Override // com.haier.uhome.usdk.bind.k
    public void b(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a<com.haier.uhome.usdk.api.w> aVar = new a<>(iBindCallback);
        ConfigurableDevice configurableDeviceJ = j();
        String devId = configurableDeviceJ.getDevId();
        String uplusId = configurableDeviceJ.getUplusId();
        String ip = configurableDeviceJ.getIp();
        int port = configurableDeviceJ.getPort();
        int methodId = configurableDeviceJ.getVerificationMethod().getMethodId();
        BaseBindInfo baseBindInfo = this.f31610e;
        String verificationCode = baseBindInfo instanceof NewDirectLinkVerificationCodeBindInfo ? ((NewDirectLinkVerificationCodeBindInfo) baseBindInfo).getVerificationCode() : "";
        a(devId, uplusId);
        b(r());
        this.f31697b.set(true);
        a(aVar, devId, uplusId, ip, port, methodId, verificationCode);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected boolean f() {
        return super.f() && f31696a.compareAndSet(false, true);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            uSDKError error2 = ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
            error2.a("token is empty");
            return error2;
        }
        BaseBindInfo baseBindInfo = this.f31610e;
        if (baseBindInfo == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter DirectLinkManualConfirmBindImpl is null", new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error3.a("bindInfo=null");
            return error3;
        }
        if (baseBindInfo.getTimeout() >= 30 && this.f31610e.getTimeout() <= 180) {
            return error;
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31610e.getTimeout(), new Object[0]);
        uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error4.a("timeout=" + this.f31610e.getTimeout());
        return error4;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE != null) {
            dVarE.a(r(), w() ? m() : 0L, 0, 5, t(), null);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        ConfigurableDevice configurableDeviceJ = j();
        a(com.haier.uhome.trace.api.b.a().c(k(), configurableDeviceJ == null ? "" : configurableDeviceJ.getDevId(), this.f31610e.getAppCsNode()));
    }

    protected abstract ConfigurableDevice j();

    abstract String k();

    /* JADX INFO: renamed from: com.haier.uhome.usdk.bind.p$1, reason: invalid class name */
    class AnonymousClass1 implements com.haier.uhome.usdk.base.api.k<Integer, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f31699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f31700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f31701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f31702e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f31703f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f31704g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f31705h;

        AnonymousClass1(String str, long j7, a aVar, String str2, String str3, int i7, int i8, String str4) {
            this.f31698a = str;
            this.f31699b = j7;
            this.f31700c = aVar;
            this.f31701d = str2;
            this.f31702e = str3;
            this.f31703f = i7;
            this.f31704g = i8;
            this.f31705h = str4;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            e3.a.e("onFailure -> %s", usdkerror);
            if (!Boolean.parseBoolean(usdkerror.getExtendedInfo().get("retry"))) {
                if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT)) {
                    return;
                }
                p.this.a(usdkerror.getCode());
                com.haier.uhome.usdk.c.f.a().a(p.this.r());
                this.f31700c.onFailure(usdkerror);
                return;
            }
            Handler handlerB = com.haier.uhome.usdk.base.d.f.a().b();
            final a aVar = this.f31700c;
            final String str = this.f31698a;
            final String str2 = this.f31701d;
            final String str3 = this.f31702e;
            final int i7 = this.f31703f;
            final int i8 = this.f31704g;
            final String str4 = this.f31705h;
            handlerB.postDelayed(new Runnable() { // from class: com.haier.uhome.usdk.bind.e1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31541a.a(aVar, str, str2, str3, i7, i8, str4);
                }
            }, 500L);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r9) {
            com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
            if (dVarE != null) {
                dVarE.a(this.f31698a, this.f31699b, 0, 5, p.this.t(), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(a aVar, String str, String str2, String str3, int i7, int i8, String str4) {
            p.this.a(aVar, str, str2, str3, i7, i8, str4);
        }

        @Override // com.haier.uhome.usdk.base.api.k
        public void a(Integer num) {
            if (num.intValue() == -1 && p.this.f31697b.get()) {
                p.this.f31697b.set(false);
                p.this.a((a<com.haier.uhome.usdk.api.w>) this.f31700c);
            }
            BindProgress bindProgressB = p.this.b(num.intValue());
            e3.a.e("onProcess -> %s", bindProgressB);
            if (bindProgressB != null) {
                p.this.a(this.f31700c, bindProgressB);
            }
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(int i7) {
        super.a(i7);
        f31696a.set(false);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        b(iBindCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a<com.haier.uhome.usdk.api.w> aVar, String str, String str2, String str3, int i7, int i8, String str4) {
        com.haier.uhome.config.a.c.a().a(str, str2, (int) (e() / 1000), str3, i7, com.haier.uhome.usdk.base.service.e.a().g(), i8, str4, m(), new AnonymousClass1(str, w() ? m() : 0L, aVar, str2, str3, i7, i8, str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a<com.haier.uhome.usdk.api.w> aVar) {
        com.haier.uhome.usdk.c.f.a().a(r(), e(), true, w() ? m() : 0L, 0, u(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.p.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                p.this.a(0);
                aVar.onSuccess(wVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT)) {
                    usdkerror = ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND.toError();
                }
                p.this.a(usdkerror.getCode());
                aVar.onFailure(usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BindProgress b(int i7) {
        if (i7 == -1) {
            return BindProgress.CONNECT_DEVICE;
        }
        if (i7 == 0) {
            return BindProgress.SEND_CONFIG_INFO;
        }
        if (i7 == 1) {
            return BindProgress.VERIFICATION;
        }
        if (i7 == 2) {
            return BindProgress.BIND_DEVICE;
        }
        e3.a.e("getProgressInfo error configProcess = %d", Integer.valueOf(i7));
        return null;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        ConfigurableDevice configurableDeviceJ = j();
        com.haier.uhome.trace.api.b.a().b(k(), usdkerror.getCode(), configurableDeviceJ == null ? "" : configurableDeviceJ.getDevId(), u());
    }
}
