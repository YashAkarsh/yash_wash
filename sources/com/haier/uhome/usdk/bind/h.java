package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigStatus;
import com.haier.uhome.usdk.scanner.ConfigType;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
abstract class h extends k implements com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, com.haier.uhome.config.service.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f31577a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseBleBindInfo f31578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConfigurableDevice f31579c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f31580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TraceNode f31581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IBindCallback<com.haier.uhome.usdk.api.w> f31582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.haier.uhome.config.service.a.a<com.haier.uhome.config.entity.a, com.haier.uhome.config.service.d, com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, com.haier.uhome.config.service.d>> f31583i;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.bind.h$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31585a;

        static {
            int[] iArr = new int[com.haier.uhome.config.a.d.values().length];
            f31585a = iArr;
            try {
                iArr[com.haier.uhome.config.a.d.BEGIN_CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31585a[com.haier.uhome.config.a.d.BEGIN_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31585a[com.haier.uhome.config.a.d.BEGIN_BIND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    h(BaseBleBindInfo baseBleBindInfo) {
        super(baseBleBindInfo);
        this.f31578b = baseBleBindInfo;
        a(true);
    }

    private void y() {
        this.f31583i.a(r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        b(this.f31582h);
    }

    void a(int i7, TraceNode traceNode) {
    }

    public void a_(int i7) {
        e3.a.e("BLE bind: module config state = %d", Integer.valueOf(i7));
    }

    @Override // com.haier.uhome.usdk.bind.k
    public final void b(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(BindProgress.CONNECT_DEVICE);
        this.f31581g = j();
        this.f31580f = System.currentTimeMillis();
        com.haier.uhome.config.entity.a aVar = new com.haier.uhome.config.entity.a();
        aVar.a(this.f31579c.getBleDevId());
        aVar.i(this.f31579c.getDevId());
        aVar.b(this.f31579c.getDevId());
        aVar.b(this.f31579c.getProtocolVers());
        aVar.f(com.haier.uhome.usdk.base.service.e.a().g());
        aVar.c((int) (e() / 1000));
        aVar.h(u().getTraceId());
        aVar.b(w() ? this.f31580f / 1000 : 0L);
        aVar.a(m());
        aVar.a(k());
        a(aVar);
    }

    @Override // com.haier.uhome.usdk.bind.k
    public final void c(@c.m0 IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31583i = com.haier.uhome.config.a.c.a().e();
        this.f31579c = this.f31578b.getConfigurableDevice();
        super.c(iBindCallback);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected boolean f() {
        boolean zCompareAndSet = f31577a.compareAndSet(false, true);
        if (zCompareAndSet) {
            com.haier.uhome.ble.hal.a.b.a.a().a(true);
        }
        if (zCompareAndSet) {
            a(this.f31578b.getTimeout());
        }
        return zCompareAndSet;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "bindInfo is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError();
            error.a("bluetooth not Enabled or not support ble");
            return error;
        }
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        if (this.f31610e == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "bindInfo is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("bindInfo=null");
            return error2;
        }
        ConfigurableDevice configurableDeviceO = o();
        if (configurableDeviceO == null) {
            e3.a.h("BLE bind: ConfigurableDevice is null!", new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error3.a("ConfigurableDevice is null!");
            return error3;
        }
        if ((ConfigType.BLE.getMask() & configurableDeviceO.getConfigType()) == 0) {
            e3.a.h("BLE bind: configurableDevice is not BLE device!", new Object[0]);
            uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error4.a("ConfigurableDevice is not BLE device!");
            return error4;
        }
        if (ConfigStatus.CONFIG_ABLE != configurableDeviceO.getConfigStatus()) {
            e3.a.h("BLE bind: configStatus not CONFIG_ABLE: " + configurableDeviceO.getConfigStatus(), new Object[0]);
            uSDKError error5 = ErrorConst.ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE.toError();
            error5.a("device can not config~");
            return error5;
        }
        int protocolVers = configurableDeviceO.getProtocolVers();
        if (protocolVers != 5) {
            e3.a.h("BLE bind: illegal parameter protocolVers: " + protocolVers, new Object[0]);
            uSDKError error6 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error6.a("illegal parameter protocolVers " + protocolVers);
            return error6;
        }
        if (this.f31578b.getTimeout() >= 30 && this.f31578b.getTimeout() <= 180) {
            return usdkerrorG;
        }
        e3.a.h("BLE bind: illegal parameter timeout :" + this.f31578b.getTimeout(), new Object[0]);
        uSDKError error7 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error7.a("timeout=" + this.f31578b.getTimeout());
        return error7;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE != null) {
            dVarE.a(r(), w() ? m() : 0L, l(), 5, t(), 0L, this.f31580f, (ICallback<com.haier.uhome.control.base.a>) null);
        }
    }

    TraceNode j() {
        return null;
    }

    int l() {
        return 0;
    }

    @Override // com.haier.uhome.usdk.bind.k
    public long m() {
        if (w()) {
            return super.m();
        }
        return 0L;
    }

    public BaseBleBindInfo n() {
        return this.f31578b;
    }

    ConfigurableDevice o() {
        return this.f31579c;
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        com.haier.uhome.usdk.c.f.a().b();
        a(usdkerror.getCode(), this.f31581g);
        b(usdkerror);
    }

    boolean k() {
        return true;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(@c.m0 IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31582h = iBindCallback;
        b(true);
        a(this.f31579c.getDevId(), (String) null);
        b(r());
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.u0
            @Override // java.lang.Runnable
            public final void run() {
                this.f31830a.z();
            }
        });
    }

    @Override // com.haier.uhome.usdk.base.api.k
    public void a(com.haier.uhome.config.a.d dVar) {
        int i7 = AnonymousClass2.f31585a[dVar.ordinal()];
        if (i7 == 1) {
            a(BindProgress.CONNECT_DEVICE);
            return;
        }
        if (i7 == 2) {
            a(BindProgress.SEND_CONFIG_INFO);
        } else if (i7 != 3) {
            e3.a.v("BLE bind: on wrong progress %s", dVar);
        } else {
            a(BindProgress.BIND_DEVICE);
        }
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.haier.uhome.config.service.d dVar) {
        c(dVar.b());
        a(0, this.f31581g);
        h();
    }

    private void b(com.haier.uhome.config.entity.a aVar) {
        e3.a.e("BLE bind: config param is %s", aVar);
        this.f31583i.a(aVar, this);
        com.haier.uhome.usdk.c.f.a().a(r(), m(), l(), 5000 + a(TimeUnit.MILLISECONDS), u(), w(), this.f31580f, q(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.h.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                h.this.a(wVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                h.this.b(usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(int i7) {
        d();
        f31577a.set(false);
        y();
        com.haier.uhome.ble.hal.a.b.a.a().a(false);
    }

    protected void a(BindProgress bindProgress) {
        this.f31582h.notifyProgress(bindProgress, r(), s());
    }

    protected void a(com.haier.uhome.config.entity.a aVar) {
        b(aVar);
    }

    protected void a(com.haier.uhome.usdk.api.w wVar) {
        this.f31582h.onSuccess(wVar);
    }

    @Override // com.haier.uhome.usdk.bind.k, com.haier.library.common.util.m
    protected void a() {
        uSDKError usdkerrorB;
        e3.a.v("BLE bind: bind timeout!", new Object[0]);
        this.f31583i.a(r());
        uSDKError usdkerrorA = this.f31583i.a();
        if (usdkerrorA == null) {
            if (com.haier.uhome.usdk.c.f.a().a(r(), uSDKDeviceNetTypeConst.NET_LOCAL) != null) {
                b(ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND.toError());
                return;
            } else {
                b(ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT.toError());
                return;
            }
        }
        if (com.haier.library.common.util.c.j(usdkerrorA.getDescription()) && (usdkerrorB = com.haier.uhome.usdk.c.c.b(usdkerrorA.getCode())) != null) {
            usdkerrorA = usdkerrorB;
        }
        b(usdkerrorA);
    }

    void b(uSDKError usdkerror) {
        IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback = this.f31582h;
        if (iBindCallback != null) {
            iBindCallback.onFailure(usdkerror);
        }
    }

    int a(ConfigurableDevice configurableDevice) {
        com.haier.uhome.search.a.c deviceInfo;
        if (configurableDevice == null || (deviceInfo = configurableDevice.getDeviceInfo()) == null) {
            return 0;
        }
        return deviceInfo.j();
    }
}
