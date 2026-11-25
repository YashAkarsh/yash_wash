package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigStatus;
import com.haier.uhome.usdk.scanner.ConfigType;

/* JADX INFO: loaded from: classes2.dex */
public class t extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PureBLEBindInfo f31807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TraceNode f31808g;

    protected t(PureBLEBindInfo pureBLEBindInfo) {
        super(pureBLEBindInfo);
        a(false);
        this.f31807f = pureBLEBindInfo;
    }

    private TraceNode j() {
        return com.haier.uhome.trace.api.b.a().b(this.f31807f.getConfigurableDevice().getDevId(), u());
    }

    @Override // com.haier.uhome.usdk.bind.k
    public void b(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        final c.a aVar = new c.a(iBindCallback);
        com.haier.uhome.config.a.b bVar = new com.haier.uhome.config.a.b();
        bVar.a(this.f31807f.getConfigurableDevice().getBleDevId());
        bVar.b(this.f31807f.getConfigurableDevice().getDevId());
        com.haier.uhome.config.a.c.a().a(bVar, (int) (e() / 1000), u(), new com.haier.uhome.usdk.base.api.k<com.haier.uhome.search.service.entity.d, com.haier.uhome.config.service.d>() { // from class: com.haier.uhome.usdk.bind.t.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) aVar, usdkerror);
            }

            @Override // com.haier.uhome.usdk.base.api.k
            public void a(com.haier.uhome.search.service.entity.d dVar) {
                BindProgress bindProgressB = t.this.b(dVar.k());
                if (bindProgressB != null) {
                    t.this.a(aVar, bindProgressB);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.config.service.d dVar) {
                t.this.a(dVar, aVar);
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.c, com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        if (this.f31807f.getConfigurableDevice() == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is null!", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("ConfigurableDevice is null!");
            return error;
        }
        if ((ConfigType.PURE_BLE.getMask() & this.f31807f.getConfigurableDevice().getConfigType()) == 0) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is not PURE_BLE device!", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("ConfigurableDevice is not BLE device!");
            return error2;
        }
        if (this.f31807f.getConfigurableDevice().getConfigStatus() != ConfigStatus.CONFIG_ABLE) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is in triggerConfigurable!", new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE.toError();
            error3.a("ConfigurableDevice is not in CONFIG_ABLE!");
            return error3;
        }
        if (this.f31807f.getTimeout() >= 30 && this.f31807f.getTimeout() <= 180) {
            return usdkerrorG;
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31807f.getTimeout(), new Object[0]);
        uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error4.a("timeout=" + this.f31807f.getTimeout());
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
        a(com.haier.uhome.trace.api.b.a().c(this.f31807f.getConfigurableDevice().getDevId(), this.f31807f.getTimeout(), this.f31807f.getAppCsNode()));
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31808g = j();
        b(new a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.t.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                t tVar = t.this;
                tVar.a(0, tVar.f31808g);
                t.this.a(wVar, iBindCallback);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                t.this.a(usdkerror.getCode(), t.this.f31808g);
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, usdkerror);
            }
        });
    }

    private boolean a(com.haier.uhome.config.service.d dVar) {
        return (dVar == null || dVar.e() == 0 || TextUtils.isEmpty(dVar.b()) || TextUtils.isEmpty(dVar.c()) || TextUtils.isEmpty(dVar.d())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.uhome.config.service.d dVar, final c.a aVar) {
        c(dVar.b());
        uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(a(this.f31807f.getConfigurableDevice().getDevId(), dVar.b(), this.f31807f.getConfigurableDevice().getBleDevId()), uSDKDeviceNetTypeConst.NET_BLE);
        final com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
        wVar.a(usdkdeviceA);
        wVar.a("");
        if (a(dVar)) {
            new w.a().a(dVar.e()).a(dVar.c()).b(this.f31807f.getConfigurableDevice().getDeviceInfo().I()).e(dVar.a()).c(dVar.b()).a(x()).d(this.f31807f.getConfigurableDevice().getProductCode()).a(new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.t.2
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    com.haier.uhome.usdk.base.utils.b.a(aVar, wVar);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.utils.b.b((ICallback) aVar, usdkerror);
                }
            }).a().a();
        } else {
            com.haier.uhome.usdk.base.utils.b.a(aVar, wVar);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(com.haier.uhome.usdk.api.w wVar, ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        s.a().a(wVar.a().getDeviceId(), wVar.a().getUplusId(), m(), 0, e(), this.f31808g, iCallback);
    }

    private uSDKDevice.a a(String str, String str2, String str3) {
        return new uSDKDevice.a(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i7, TraceNode traceNode) {
        com.haier.uhome.trace.api.b.a().c(i7, this.f31807f.getConfigurableDevice().getDevId(), s(), traceNode);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (str == null || str.isEmpty()) {
            str = "local";
        }
        com.haier.uhome.trace.api.b.a().a(usdkerror.getCode(), this.f31807f.getConfigurableDevice().getDevId(), u(), str);
    }
}
