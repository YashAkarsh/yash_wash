package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BLEAdvBindImpl extends k implements ICallback<uSDKDevice> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f31427a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BLEAdvBindInfo f31428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IBindCallback<com.haier.uhome.usdk.api.w> f31429c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ErrorConst f31430f;

    protected BLEAdvBindImpl(BLEAdvBindInfo bLEAdvBindInfo) {
        super(bLEAdvBindInfo);
        this.f31428b = bLEAdvBindInfo;
        a(false);
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(uSDKError usdkerror) {
        if (c()) {
            e3.a.v("onBindDeviceResult already timeout!", new Object[0]);
            return;
        }
        if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31509a.n();
                }
            });
        } else if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            o();
        } else {
            this.f31429c.onFailure(usdkerror);
            a(usdkerror.getCode());
        }
    }

    private void c(ErrorConst errorConst) {
        this.f31429c.onFailure(errorConst.toError());
        a(errorConst.getErrorId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f31430f = ErrorConst.ERR_USDK_SAVE_DEVICE_VERSION_FAIL;
        k();
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(int i7) {
        AtomicBoolean atomicBoolean = f31427a;
        synchronized (atomicBoolean) {
            atomicBoolean.set(false);
            d();
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected boolean f() {
        boolean zCompareAndSet;
        AtomicBoolean atomicBoolean = f31427a;
        synchronized (atomicBoolean) {
            a(this.f31428b.getTimeout());
            zCompareAndSet = atomicBoolean.compareAndSet(false, true);
        }
        return zCompareAndSet;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "token is null", new Object[0]);
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        BLEAdvBindInfo bLEAdvBindInfo = this.f31428b;
        if (bLEAdvBindInfo == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter BLEAdvBindInfo is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("bindInfo=null");
            return error;
        }
        if (bLEAdvBindInfo.getTimeout() >= 30 && this.f31428b.getTimeout() <= 180) {
            return super.g();
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31428b.getTimeout(), new Object[0]);
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("timeout=" + this.f31428b.getTimeout());
        return error2;
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
        TraceNode traceNodeD;
        BLEAdvBindInfo bLEAdvBindInfo = this.f31428b;
        if (bLEAdvBindInfo == null) {
            traceNodeD = com.haier.uhome.trace.api.b.a().h(null);
        } else {
            ConfigurableDevice configurableDevice = bLEAdvBindInfo.getConfigurableDevice();
            traceNodeD = com.haier.uhome.trace.api.b.a().d(configurableDevice == null ? r() : configurableDevice.getDevId(), this.f31428b.getTimeout(), this.f31428b.getAppCsNode());
        }
        a(traceNodeD);
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        e3.a.e("find remote device error %s", usdkerror);
        if (c()) {
            e3.a.v("bind stage find device fail already timeout!", new Object[0]);
        } else {
            this.f31429c.onFailure(usdkerror);
            a(usdkerror.getCode());
        }
    }

    private void A() {
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(r());
        if (device == null || !device.isNetTypeContain(uSDKDeviceNetTypeConst.NET_REMOTE)) {
            com.haier.uhome.usdk.c.f.a().a(r(), a(TimeUnit.MILLISECONDS), uSDKDeviceNetTypeConst.NET_REMOTE, this);
        } else {
            onSuccess(device);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ConfigurableDevice configurableDevice = this.f31428b.getConfigurableDevice();
        uSDKDeviceManager.getSingleInstance().e().a(r(), s(), configurableDevice.getProductCode(), configurableDevice.getChannel(), configurableDevice.getCompanyId(), 15, configurableDevice.getDeviceInfo().I(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.bind.f0
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f31559a.a(errorConst);
            }
        });
    }

    private void l() {
        this.f31430f = ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT;
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        uSDKDeviceManager.getSingleInstance().e().a(r(), s(), w() ? m() : 0L, 0, 15, t(), "", new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.bind.e0
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                this.f31540a.b(usdkerror);
            }
        });
    }

    private void o() {
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        uSDKDeviceManager.getSingleInstance().e().a(r(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.bind.g0
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f31574a.b(errorConst);
            }
        });
    }

    private void z() {
        A();
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31429c = iBindCallback;
        ConfigurableDevice configurableDevice = this.f31428b.getConfigurableDevice();
        a(configurableDevice.getDevId(), configurableDevice.getUplusId());
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f31491a.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ErrorConst errorConst) {
        if (c()) {
            e3.a.v("onObtainDeviceInfoResult already timeout!", new Object[0]);
            return;
        }
        if (errorConst == ErrorConst.ERR_USDK_TIMEOUT) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31517a.y();
                }
            });
        } else if (errorConst == ErrorConst.RET_USDK_OK) {
            z();
        } else {
            this.f31429c.onFailure(this.f31430f.toError());
            a(this.f31430f.getErrorId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorConst errorConst) {
        if (c()) {
            e3.a.v("onSaveVersionResult already timeout!", new Object[0]);
            return;
        }
        if (errorConst == ErrorConst.ERR_USDK_TIMEOUT) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31535a.k();
                }
            });
        } else if (errorConst == ErrorConst.RET_USDK_OK) {
            l();
        } else {
            this.f31429c.onFailure(this.f31430f.toError());
            a(this.f31430f.getErrorId());
        }
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(uSDKDevice usdkdevice) {
        e3.a.e("find remote device: %s", usdkdevice);
        if (c()) {
            e3.a.v("bind stage find remote device success already timeout!", new Object[0]);
            return;
        }
        com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
        wVar.a(usdkdevice);
        this.f31429c.onSuccess(wVar);
        a(0);
    }

    @Override // com.haier.uhome.usdk.bind.k, com.haier.library.common.util.m
    protected void a() {
        c(this.f31430f);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (str == null || str.isEmpty()) {
            str = "local";
        }
        com.haier.uhome.trace.api.b.a().e(usdkerror.getCode(), r(), str, u());
    }
}
