package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final int f31512a = 1001;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final int f31513b = 1002;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final int f31514c = 1003;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static AtomicBoolean f31515f = new AtomicBoolean(false);

    public class a<uSDKDevice> extends com.haier.uhome.usdk.c.d<uSDKDevice> implements IBindCallback<uSDKDevice> {
        public a(IBindCallback<uSDKDevice> iBindCallback) {
            super(iBindCallback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(ICallback iCallback, BindProgress bindProgress, String str, String str2) {
            ((IBindCallback) iCallback).notifyProgress(bindProgress, str, str2);
        }

        @Override // com.haier.uhome.usdk.bind.IBindResultCallback
        public void notifyProgress(final BindProgress bindProgress, final String str, final String str2) {
            final ICallback<R> iCallback = this.f31996b;
            if (iCallback == 0) {
                return;
            }
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.n0
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.a(iCallback, bindProgress, str, str2);
                }
            });
        }

        @Override // com.haier.uhome.usdk.c.d, com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            com.haier.uhome.config.a.c.a().c();
            super.onFailure(usdkerror);
        }

        @Override // com.haier.uhome.usdk.c.d, com.haier.uhome.usdk.base.api.ICallback
        public void onSuccess(uSDKDevice usdkdevice) {
            com.haier.uhome.config.a.c.a().c();
            super.onSuccess(usdkdevice);
        }

        @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
        public void switchNetworkNotify() {
            Object obj = this.f31996b;
            if (obj == null) {
                return;
            }
            com.haier.library.common.thread.a.b().c(new m0((IBindCallback) obj));
        }
    }

    protected c(BaseBindInfo baseBindInfo) {
        super(baseBindInfo);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(int i7) {
        super.a(i7);
        f31515f.set(false);
        com.haier.uhome.ble.hal.a.b.a.a().a(false);
    }

    protected BindProgress b(int i7) {
        if (i7 == 3) {
            return BindProgress.BIND_DEVICE;
        }
        if (i7 == 1001) {
            return BindProgress.CONNECT_DEVICE;
        }
        if (i7 == 1002) {
            return BindProgress.SEND_CONFIG_INFO;
        }
        e3.a.e("getProgressInfo error state = %d", Integer.valueOf(i7));
        return null;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected boolean f() {
        boolean zCompareAndSet = f31515f.compareAndSet(false, true);
        if (zCompareAndSet) {
            com.haier.uhome.ble.hal.a.b.a.a().a(true);
        }
        return zCompareAndSet;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "bindInfo is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError();
            error.a("bluetooth not Enabled or not support ble");
            return error;
        }
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        if (this.f31610e != null) {
            return super.g();
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "bindInfo is null", new Object[0]);
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("bindInfo=null");
        return error2;
    }
}
