package com.haier.uhome.usdk.bind;

import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigStatus;
import com.haier.uhome.usdk.scanner.ConfigType;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
public class u extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PureBLEBindInfo f31823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TraceNode f31824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TraceNode f31825h;

    protected u(PureBLEBindInfo pureBLEBindInfo) {
        super(pureBLEBindInfo);
        a(false);
        this.f31823f = pureBLEBindInfo;
    }

    private void f(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        String bleDevId = this.f31823f.getConfigurableDevice().getBleDevId();
        final String strG = com.haier.uhome.usdk.base.service.e.a().g();
        TraceNode traceNode = this.f31825h;
        String traceId = traceNode != null ? traceNode.getTraceId() : "";
        int iE = (int) (e() / 1000);
        final TraceNode traceNodeA = a(strG, traceId, iE);
        this.f31824g = traceNodeA;
        com.haier.uhome.config.entity.a aVar = new com.haier.uhome.config.entity.a();
        aVar.a(bleDevId);
        aVar.h(traceId);
        aVar.f(strG);
        aVar.c(iE);
        a(iBindCallback, BindProgress.SEND_CONFIG_INFO);
        com.haier.uhome.config.a.c.a().d().a(aVar, new ICallback<com.haier.uhome.config.entity.b>() { // from class: com.haier.uhome.usdk.bind.u.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.config.entity.b bVar) {
                u.this.a(0, strG, traceNodeA);
                u.this.a(bVar.a(), bVar.b(), (IBindCallback<com.haier.uhome.usdk.api.w>) iBindCallback);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                if (com.haier.uhome.usdk.base.utils.a.c()) {
                    u.this.a(usdkerror.getCode(), strG, traceNodeA);
                    com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, usdkerror);
                } else {
                    u uVar = u.this;
                    ErrorConst errorConst = ErrorConst.ERR_USDK_BLE_NOT_OPEN;
                    uVar.a(errorConst.getErrorId(), strG, traceNodeA);
                    com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, errorConst.toError());
                }
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.c, com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        if (this.f31823f.getConfigurableDevice() == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is null!", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("ConfigurableDevice is null!");
            return error;
        }
        if ((ConfigType.PURE_BLE.getMask() & this.f31823f.getConfigurableDevice().getConfigType()) == 0) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is not PURE_BLE device!", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("ConfigurableDevice is not BLE device!");
            return error2;
        }
        if (this.f31823f.getConfigurableDevice().getConfigStatus() != ConfigStatus.CONFIG_ABLE) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "ConfigurableDevice is in triggerConfigurable!", new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE.toError();
            error3.a("ConfigurableDevice is not in CONFIG_ABLE!");
            return error3;
        }
        if (this.f31823f.getTimeout() < 30 || this.f31823f.getTimeout() > 180) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31823f.getTimeout(), new Object[0]);
            uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error4.a("timeout=" + this.f31823f.getTimeout());
            return error4;
        }
        if (com.haier.library.common.util.c.j(com.haier.uhome.usdk.base.service.e.a().g())) {
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        if (com.haier.uhome.control.cloud.service.c.l().n() == com.haier.uhome.control.cloud.api.b.CONNECTED) {
            return usdkerrorG;
        }
        uSDKError error5 = ErrorConst.ERR_USDK_CLOUD_OFFLINE.toError();
        error5.a("cloud connect fail =" + com.haier.uhome.control.cloud.service.c.l().n());
        return error5;
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
        ConfigurableDevice configurableDevice = this.f31823f.getConfigurableDevice();
        TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(a(configurableDevice), configurableDevice.getDevId(), configurableDevice.getUplusId(), this.f31823f.getTimeout(), this.f31823f.getAppCsNode());
        this.f31825h = traceNodeA;
        a(traceNodeA);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(iBindCallback, BindProgress.CONNECT_DEVICE);
        f(iBindCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(str, str2);
        uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(a(str, str2, this.f31823f.getConfigurableDevice().getBleDevId()), uSDKDeviceNetTypeConst.NET_BLE);
        com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
        wVar.a(usdkdeviceA);
        wVar.a("");
        a(iBindCallback, BindProgress.BIND_DEVICE);
        a(wVar, iBindCallback);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(com.haier.uhome.usdk.api.w wVar, ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        s.a().a(wVar.a().getDeviceId(), wVar.a().getUplusId(), m(), 0, e(), this.f31824g, iCallback);
    }

    private uSDKDevice.a a(String str, String str2, String str3) {
        return new uSDKDevice.a(str, str2, str3);
    }

    private TraceNode a(String str, String str2, int i7) {
        return com.haier.uhome.trace.api.b.a().a(this.f31823f.getConfigurableDevice().getDevId(), str, str2, i7, u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i7, String str, TraceNode traceNode) {
        com.haier.uhome.trace.api.b.a().d(i7, this.f31823f.getConfigurableDevice().getDevId(), str, traceNode);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        int code = usdkerror.getCode();
        ConfigurableDevice configurableDevice = this.f31823f.getConfigurableDevice();
        com.haier.uhome.trace.api.b.a().a(code, a(configurableDevice), configurableDevice.getDevId(), u());
    }

    private int a(ConfigurableDevice configurableDevice) {
        return com.haier.uhome.usdk.base.api.f.c(configurableDevice.getDeviceInfo().w());
    }
}
