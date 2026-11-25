package com.haier.uhome.smart.api;

import android.text.TextUtils;
import com.haier.library.common.thread.m;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import e3.a;

/* JADX INFO: loaded from: classes2.dex */
public class GatewayDeviceAccess extends AbsDeviceAccess {
    private GatewayDevice mGatewayDevice;
    private RegisterGatewayDevice mRegisterGatewayDevice;

    public GatewayDeviceAccess(RegisterGatewayDevice registerGatewayDevice) {
        super(registerGatewayDevice);
        this.mRegisterGatewayDevice = registerGatewayDevice;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkOnlineParam() {
        GatewayDevice gatewayDevice = this.mGatewayDevice;
        if (gatewayDevice == null) {
            a.h("checkOnlineParam mGatewayDevice is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("device=null");
            return error;
        }
        if (!TextUtils.isEmpty(gatewayDevice.getDeviceId())) {
            return super.checkOnlineParam();
        }
        a.h("checkOnlineParam deviceId<%s> is invalid", this.mGatewayDevice.getDeviceId());
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("deviceId=" + this.mGatewayDevice.getDeviceId() + "is invalid");
        return error2;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkRegisterParam() {
        if (this.mRegisterGatewayDevice != null) {
            return super.checkRegisterParam();
        }
        a.h("checkRegisterParam mRegisterGatewayDevice is null", new Object[0]);
        uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error.a("checkRegisterParam mRegisterGatewayDevice=null");
        return error;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doDeviceOnline(final ICallback<String> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GatewayDeviceAccess.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().gatewayDeviceOnline(GatewayDeviceAccess.this.mGatewayDevice.getDeviceId(), GatewayDeviceAccess.this.mGatewayDevice.getUpCodeT(), GatewayDeviceAccess.this.mGatewayDevice.getUplusId(), GatewayDeviceAccess.this.mGatewayDevice.getDeviceKey(), GatewayDeviceAccess.this.mGatewayDevice.getUpgradeVersion(), GatewayDeviceAccess.this.mGatewayDevice.isUprade(), GatewayDeviceAccess.this.mGatewayDevice.getDeviceName(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doRegisterDevice(final ICallback<RegisterResult> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GatewayDeviceAccess.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().registerGatewayDevice(GatewayDeviceAccess.this.mRegisterGatewayDevice.getMac(), GatewayDeviceAccess.this.mRegisterGatewayDevice.getUpCodeT(), GatewayDeviceAccess.this.mRegisterGatewayDevice.getUplusId(), GatewayDeviceAccess.this.mRegisterGatewayDevice.getDeviceKey(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    public GatewayDeviceAccess(GatewayDevice gatewayDevice) {
        super(gatewayDevice);
        this.mGatewayDevice = gatewayDevice;
    }
}
