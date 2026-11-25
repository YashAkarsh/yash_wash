package com.haier.uhome.usdk.bind;

import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigStatus;
import com.haier.uhome.usdk.scanner.ConfigType;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c implements com.haier.uhome.control.cloud.a.o, com.haier.uhome.search.a.g, aa {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f31521f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f31522g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BLEBindInfo f31523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ConfigurableDevice f31524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f31525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.haier.uhome.usdk.bind.a.a f31526k;

    d(BLEBindInfo bLEBindInfo) {
        super(bLEBindInfo);
        this.f31523h = bLEBindInfo;
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ICallback<com.haier.uhome.usdk.api.w> f(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        return new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.d.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                iBindCallback.onSuccess(wVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iBindCallback.onFailure(usdkerror);
            }
        };
    }

    private TraceNode k() {
        return com.haier.uhome.trace.api.b.a().e(this.f31524i.getDevId(), u());
    }

    @Override // com.haier.uhome.search.a.g
    public /* synthetic */ void a(com.haier.uhome.search.service.entity.d dVar) {
        com.haier.uhome.search.a.p.a(this, dVar);
    }

    @Override // com.haier.uhome.usdk.bind.k
    public void b(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        final TraceNode traceNodeK = k();
        this.f31525j = System.currentTimeMillis();
        long jCurrentTimeMillis = w() ? System.currentTimeMillis() : 0L;
        final long jM = w() ? m() : 0L;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.haier.uhome.config.a.c.a().a(this.f31524i.getBleDevId(), r(), this.f31523h.getSsid(), this.f31523h.getBssid(), this.f31523h.getPassword(), com.haier.uhome.usdk.base.service.e.a().g(), (int) (e() / 1000), u(), jCurrentTimeMillis, jM, this.f31524i.getProtocolVers(), new com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, com.haier.uhome.config.service.d>() { // from class: com.haier.uhome.usdk.bind.d.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            ICallback<com.haier.uhome.usdk.api.w> f31527a;

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                d.this.a(usdkerror.getCode(), traceNodeK);
                if (usdkerror.a(ErrorConst.ERR_USDK_SEND_CONFIG_REQ_TIMEOUT) && atomicBoolean.get()) {
                    a();
                } else {
                    com.haier.uhome.usdk.c.f.a().a(d.this.r());
                    iBindCallback.onFailure(usdkerror);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.config.service.d dVar) {
                d.this.a(0, traceNodeK);
                d.this.c(dVar.b());
                a();
            }

            @Override // com.haier.uhome.usdk.base.api.k
            public void a(com.haier.uhome.search.service.entity.d dVar) {
                if (1003 == dVar.h()) {
                    a();
                    atomicBoolean.set(true);
                }
                BindProgress bindProgressB = d.this.b(dVar.h());
                if (bindProgressB != null) {
                    d.this.a(iBindCallback, bindProgressB);
                }
                if (dVar.k() == 2) {
                    d.this.a(dVar.k(), dVar.h());
                }
            }

            private void a() {
                if (this.f31527a == null) {
                    this.f31527a = d.this.f(iBindCallback);
                    com.haier.uhome.usdk.c.f.a().a(d.this.r(), jM, 0, d.this.e(), d.this.u(), d.this.w(), d.this.f31525j, d.this.q(), this.f31527a);
                } else {
                    e3.a.v("Ble bind: query bind result already running!", new Object[0]);
                }
            }
        });
        com.haier.uhome.search.service.f.c().a(this);
    }

    @Override // com.haier.uhome.usdk.bind.c, com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        ConfigurableDevice configurableDevice = this.f31523h.getConfigurableDevice();
        if (configurableDevice == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is null!", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("ConfigurableDevice is null!");
            return error;
        }
        if ((ConfigType.BLE.getMask() & configurableDevice.getConfigType()) == 0) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is not BLE device!", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("ConfigurableDevice is not BLE device!");
            return error2;
        }
        if (ConfigStatus.CONFIG_ABLE != configurableDevice.getConfigStatus()) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigStatus not CONFIG_ABLE:" + configurableDevice.getConfigStatus(), new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE.toError();
            error3.a("device can not config~");
            return error3;
        }
        int protocolVers = configurableDevice.getProtocolVers();
        if (protocolVers != 1 && protocolVers != 2) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter protocolVers :" + protocolVers, new Object[0]);
            uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error4.a("illegal parameter protocolVers " + protocolVers);
            return error4;
        }
        String ssid = this.f31523h.getSsid();
        if (!com.haier.uhome.usdk.base.utils.f.b(ssid)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter ssid : " + ssid, new Object[0]);
            uSDKError error5 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error5.a("ssid=" + ssid);
            return error5;
        }
        String password = this.f31523h.getPassword();
        if (k.d(password)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter password : " + password, new Object[0]);
            uSDKError error6 = ErrorConst.ERR_USDK_PASSWORD_LENGTH_INVALID.toError();
            error6.a("password=" + password);
            return error6;
        }
        if (this.f31523h.getTimeout() >= 30 && this.f31523h.getTimeout() <= 180) {
            return usdkerrorG;
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31523h.getTimeout(), new Object[0]);
        uSDKError error7 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error7.a("timeout=" + this.f31523h.getTimeout());
        return error7;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE != null) {
            dVarE.a(r(), w() ? m() : 0L, 0, 5, t(), 0L, this.f31525j, (ICallback<com.haier.uhome.control.base.a>) null);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        TraceNode traceNodeA;
        com.haier.uhome.search.a.c deviceInfo;
        BLEBindInfo bLEBindInfo = this.f31523h;
        if (bLEBindInfo == null) {
            traceNodeA = com.haier.uhome.trace.api.b.a().d(null);
        } else {
            ConfigurableDevice configurableDevice = bLEBindInfo.getConfigurableDevice();
            traceNodeA = com.haier.uhome.trace.api.b.a().a(configurableDevice == null ? r() : configurableDevice.getDevId(), this.f31523h.getSsid(), this.f31523h.getPassword(), this.f31523h.getBssid(), this.f31523h.getTimeout(), (configurableDevice == null || (deviceInfo = configurableDevice.getDeviceInfo()) == null) ? 0 : deviceInfo.j(), this.f31523h.getAppCsNode());
        }
        a(traceNodeA);
    }

    @Override // com.haier.uhome.usdk.bind.aa
    public void j() {
        com.haier.uhome.control.cloud.a.b.a().b(this);
        com.haier.uhome.search.service.f.c().b(this);
        com.haier.uhome.config.service.e.a().a(true);
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceAdd(String str, com.haier.uhome.usdk.base.api.f fVar) {
        a(fVar);
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceDel(String str, com.haier.uhome.usdk.base.api.f fVar, int i7) {
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceUpdate(String str, com.haier.uhome.usdk.base.api.f fVar) {
        a(fVar);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        j jVar = new j(this, iBindCallback);
        com.haier.uhome.control.cloud.a.b.a().a(this);
        ConfigurableDevice configurableDevice = this.f31523h.getConfigurableDevice();
        this.f31524i = configurableDevice;
        b(configurableDevice.getProtocolVers() > 1);
        a(this.f31524i.getDevId(), (String) null);
        b(r());
        b(jVar);
    }

    @Override // com.haier.uhome.control.cloud.a.o
    public void a(int i7, int i8) {
        this.f31526k = com.haier.uhome.usdk.c.c.a(i8);
        e3.a.e("Ble bind: notify bind state: %d, stateCode: %d", Integer.valueOf(i7), Integer.valueOf(i8));
    }

    @Override // com.haier.uhome.control.cloud.a.o
    public boolean a(String str) {
        ConfigurableDevice configurableDevice = this.f31524i;
        return configurableDevice != null && configurableDevice.getDevId().equals(str);
    }

    private void a(com.haier.uhome.usdk.base.api.f fVar) {
        String strB = fVar.b();
        if (!strB.equals(r())) {
            e3.a.u("Ble bind: added device %s is not the target %s", strB, r(), new Object[0]);
        } else {
            com.haier.uhome.search.service.f.c().c(r());
        }
    }

    @Override // com.haier.uhome.usdk.bind.aa
    public uSDKError b(uSDKError usdkerror) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.c.c.a(this.f31526k);
        return usdkerrorA != null ? usdkerrorA : usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i7, TraceNode traceNode) {
        com.haier.uhome.trace.api.b.a().f(i7, this.f31524i.getDevId(), traceNode);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (str == null || str.isEmpty()) {
            str = "local";
        }
        com.haier.uhome.trace.api.b.a().b(usdkerror.getCode(), r(), u(), str);
    }
}
