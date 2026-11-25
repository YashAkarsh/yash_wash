package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigType;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g extends k implements ICallback<uSDKDevice> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f31564a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BLEMeshBindInfo f31565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31566c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IBindCallback<com.haier.uhome.usdk.api.w> f31567f;

    g(BLEMeshBindInfo bLEMeshBindInfo) {
        super(bLEMeshBindInfo);
        this.f31565b = bLEMeshBindInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        com.haier.uhome.config.a.c.a().a(k(), (TraceNode) null, com.haier.uhome.control.cloud.service.b.a(), (int) ((e() * 1.0d) / 1000.0d), new com.haier.uhome.config.a.h<Integer, String>() { // from class: com.haier.uhome.usdk.bind.g.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iBindCallback.onFailure(usdkerror);
            }

            @Override // com.haier.uhome.config.a.h
            public String a() {
                return com.haier.uhome.control.cloud.service.c.l().n().name();
            }

            @Override // com.haier.uhome.usdk.base.api.k
            public void a(Integer num) {
                BindProgress bindProgressA = g.this.a(num);
                if (bindProgressA != null) {
                    g.this.a(iBindCallback, bindProgressA);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                g.this.f31566c = str;
                uSDKDeviceManager singleInstance = uSDKDeviceManager.getSingleInstance();
                g gVar = g.this;
                uSDKDevice usdkdeviceA = singleInstance.a(gVar.a(gVar.r(), g.this.s(), g.this.f31565b.getConfigurableDevice().getBleDevId()), uSDKDeviceNetTypeConst.NET_MESH);
                com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
                wVar.a(usdkdeviceA);
                iBindCallback.onSuccess(wVar);
            }
        });
    }

    public static boolean j() {
        return f31564a.get();
    }

    private void y() {
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(r());
        if (device == null || !device.isNetTypeContain(uSDKDeviceNetTypeConst.NET_REMOTE)) {
            com.haier.uhome.usdk.c.f.a().a(r(), a(TimeUnit.MILLISECONDS), uSDKDeviceNetTypeConst.NET_REMOTE, this);
            return;
        }
        com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
        wVar.a(device);
        this.f31567f.onSuccess(wVar);
        a(0);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "Mesh bind: bindInfo is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError();
            error.a("bluetooth not Enabled or not support ble");
            return error;
        }
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        BLEMeshBindInfo bLEMeshBindInfo = this.f31565b;
        if (bLEMeshBindInfo == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "Mesh bind: bindInfo is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("bindInfo=null");
            return error2;
        }
        if (bLEMeshBindInfo.getConfigurableDevice() == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "Mesh bind: ConfigurableDevice is null!", new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error3.a("ConfigurableDevice is null!");
            return error3;
        }
        if ((ConfigType.BLE_MESH.getMask() & this.f31565b.getConfigurableDevice().getConfigType()) == 0) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "Mesh bind: ConfigurableDevice is not PURE_BLE device!", new Object[0]);
            uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error4.a("ConfigurableDevice is not BLE device!");
            return error4;
        }
        if (this.f31565b.getConfigurableDevice().isTriggerConfigurable()) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "Mesh bind:  ConfigurableDevice is in triggerConfigurable!", new Object[0]);
            uSDKError error5 = ErrorConst.ERR_USDK_DEVICE_NEED_TRIGGER_CONFIG.toError();
            error5.a("ConfigurableDevice is in triggerConfigurable!");
            return error5;
        }
        if (this.f31565b.getTimeout() >= 30 && this.f31565b.getTimeout() <= 180) {
            return super.g();
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "Mesh bind: Illegal parameter timeout :" + this.f31565b.getTimeout(), new Object[0]);
        uSDKError error6 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error6.a("timeout=" + this.f31565b.getTimeout());
        return error6;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        e3.a.e("Mesh bind: find remote device error %s", usdkerror);
        if (c()) {
            e3.a.v("Mesh bind: bind stage find device fail already timeout!", new Object[0]);
        } else {
            this.f31567f.onFailure(usdkerror);
            a(usdkerror.getCode());
        }
    }

    private com.haier.uhome.config.entity.a.a k() {
        ConfigurableDevice configurableDevice = this.f31565b.getConfigurableDevice();
        a(configurableDevice.getDevId(), configurableDevice.getUplusId());
        b(r());
        com.haier.uhome.config.entity.a.a aVar = new com.haier.uhome.config.entity.a.a();
        aVar.b(configurableDevice.getDevUuid());
        aVar.d(configurableDevice.getProductCode());
        aVar.c(configurableDevice.getUplusId());
        aVar.a(configurableDevice.getBleDevId());
        aVar.a(1);
        aVar.a(l());
        return aVar;
    }

    private com.haier.uhome.config.entity.a.b l() {
        com.haier.uhome.control.base.a.c cVarI = uSDKDeviceManager.getSingleInstance().i();
        com.haier.uhome.config.entity.a.b bVar = new com.haier.uhome.config.entity.a.b();
        com.haier.library.common.util.n.c(cVarI, bVar, new String[0]);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (com.haier.uhome.control.cloud.service.c.l().n() != com.haier.uhome.control.cloud.api.b.CONNECTED) {
            b(ErrorConst.ERR_USDK_CLOUD_OFFLINE);
        } else {
            uSDKDeviceManager.getSingleInstance().e().a(r(), s(), 0L, 0, 15, "", this.f31566c, new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.bind.t0
                @Override // com.haier.uhome.usdk.base.api.s
                public final void onCallback(uSDKError usdkerror) {
                    this.f31816a.b(usdkerror);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        uSDKDeviceManager.getSingleInstance().e().a(r(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.bind.r0
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f31721a.a(errorConst);
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.k
    public void b(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        e3.a.e("Mesh bind: config device start!", new Object[0]);
        uSDKDeviceManager.getSingleInstance().a(new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.g.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                g.this.f(iBindCallback);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iBindCallback.onFailure(usdkerror);
            }
        }, (int) a(TimeUnit.SECONDS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(uSDKError usdkerror) {
        if (c()) {
            e3.a.v("Mesh bind: bind stage receive bind resp already timeout!", new Object[0]);
        } else if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            o();
        } else {
            b(ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected boolean f() {
        boolean zCompareAndSet;
        AtomicBoolean atomicBoolean = f31564a;
        synchronized (atomicBoolean) {
            a(this.f31565b.getTimeout());
            zCompareAndSet = atomicBoolean.compareAndSet(false, true);
            if (zCompareAndSet) {
                com.haier.uhome.ble.hal.a.b.a.a().a(true);
            }
        }
        return zCompareAndSet;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31567f = iBindCallback;
        b(new a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.g.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                e3.a.e("Mesh bind: config device<%s> success", wVar.a().getDeviceId());
                g.this.a(wVar, iBindCallback);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.v("Mesh bind: Config device fail!", new Object[0]);
                iBindCallback.onFailure(usdkerror);
                g.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKDevice.a a(String str, String str2, String str3) {
        return new uSDKDevice.a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BindProgress a(Integer num) {
        if (num.intValue() == 1) {
            return BindProgress.CONNECT_DEVICE;
        }
        if (num.intValue() == 2) {
            return BindProgress.SEND_CONFIG_INFO;
        }
        return null;
    }

    private void b(ErrorConst errorConst) {
        this.f31567f.onFailure(errorConst.toError());
        a(errorConst.getErrorId());
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(com.haier.uhome.usdk.api.w wVar, ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        if (c()) {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "Mesh bind: bind stage already timeout!", new Object[0]);
        } else {
            a((IBindCallback) iCallback, BindProgress.BIND_DEVICE);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31802a.n();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorConst errorConst) {
        if (c()) {
            e3.a.v("Mesh bind: bind stage receive device info already timeout!", new Object[0]);
            return;
        }
        e3.a.e("Mesh bind: bind stage receive device info error: %s", errorConst);
        if (errorConst == ErrorConst.ERR_USDK_TIMEOUT) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31712a.o();
                }
            }, 5L);
        } else if (errorConst == ErrorConst.RET_USDK_OK) {
            y();
        } else {
            b(errorConst);
        }
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(uSDKDevice usdkdevice) {
        e3.a.e("Mesh bind: find remote device: %s", usdkdevice);
        if (c()) {
            e3.a.v("Mesh bind: bind stage find remote device success already timeout!", new Object[0]);
            return;
        }
        com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
        wVar.a(usdkdevice);
        this.f31567f.onSuccess(wVar);
        a(0);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(int i7) {
        AtomicBoolean atomicBoolean = f31564a;
        synchronized (atomicBoolean) {
            atomicBoolean.set(false);
            com.haier.uhome.ble.hal.a.b.a.a().a(false);
            d();
        }
    }

    @Override // com.haier.uhome.usdk.bind.k, com.haier.library.common.util.m
    protected void a() {
        b(ErrorConst.ERR_USDK_TIMEOUT);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(ICallback<com.haier.uhome.usdk.api.w> iCallback, uSDKError usdkerror) {
        if (iCallback == null) {
            e3.a.v("Mesh bind: BindDevice error = %s, but callback is null", usdkerror);
        } else {
            iCallback.onFailure(usdkerror);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(IBindResultCallback<com.haier.uhome.usdk.api.w> iBindResultCallback, BindProgress bindProgress) {
        iBindResultCallback.notifyProgress(bindProgress, r(), s());
    }
}
