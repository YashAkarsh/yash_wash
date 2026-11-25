package com.haier.uhome.smart.api;

import android.text.TextUtils;
import com.haier.library.common.thread.m;
import com.haier.uhome.smart.ConstSmartDevice;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import e3.a;

/* JADX INFO: loaded from: classes2.dex */
public class GatewayVoiceDeviceAccess extends AbsDeviceAccess {
    private GatewayVoiceDevice mGatewayVoiceDevice;
    private RegisterGatewayVoiceDevice mRegisterGatewayVoiceDevice;

    public GatewayVoiceDeviceAccess(RegisterGatewayVoiceDevice registerGatewayVoiceDevice) {
        super(registerGatewayVoiceDevice);
        this.mRegisterGatewayVoiceDevice = registerGatewayVoiceDevice;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkOnlineParam() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (this.mGatewayVoiceDevice == null) {
            a.h("checkOnlineParam mGatewayVoiceDevice is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("device=null");
            return error2;
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.mGatewayVoiceDevice.getDeviceId()) || !this.mGatewayVoiceDevice.getDeviceId().matches(ConstSmartDevice.REGEX_MAC)) {
            a.h("checkOnlineParam deviceId<%s> is invalid", this.mGatewayVoiceDevice.getDeviceId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append("deviceId=");
            sb.append(this.mGatewayVoiceDevice.getDeviceId());
        }
        if (TextUtils.isEmpty(this.mGatewayVoiceDevice.getSwVersion()) || !isDeviceVersionOk(this.mGatewayVoiceDevice.getSwVersion())) {
            a.h("checkOnlineParam swVersion<%s> is invalid", this.mGatewayVoiceDevice.getSwVersion());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" swVersion=");
            sb.append(this.mGatewayVoiceDevice.getSwVersion());
        }
        if (TextUtils.isEmpty(this.mGatewayVoiceDevice.getHwVersion()) || !isDeviceVersionOk(this.mGatewayVoiceDevice.getHwVersion())) {
            a.h("checkOnlineParam hwVersion<%s> is invalid", this.mGatewayVoiceDevice.getHwVersion());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" hwVersion=");
            sb.append(this.mGatewayVoiceDevice.getHwVersion());
        }
        if (TextUtils.isEmpty(this.mGatewayVoiceDevice.getSwType())) {
            a.h("checkOnlineParam swType<%s> is invalid", this.mGatewayVoiceDevice.getSwType());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" swType=");
            sb.append(this.mGatewayVoiceDevice.getSwType());
        }
        if (TextUtils.isEmpty(this.mGatewayVoiceDevice.getHwType())) {
            a.h("checkOnlineParam hwType<%s> is invalid", this.mGatewayVoiceDevice.getHwType());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" hwType=");
            sb.append(this.mGatewayVoiceDevice.getHwType());
        }
        if (!error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            return super.checkOnlineParam();
        }
        error.a(sb.toString());
        return error;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkRegisterParam() {
        if (this.mRegisterGatewayVoiceDevice != null) {
            return super.checkRegisterParam();
        }
        a.h("checkRegisterParam mRegisterGatewayVoiceDevice is null", new Object[0]);
        uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error.a("mRegisterGatewayVoiceDevice=null");
        return error;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doDeviceOnline(final ICallback<String> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GatewayVoiceDeviceAccess.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().gatewayVoiceDeviceOnline(GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getDeviceId(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getUpCodeT(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getUplusId(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getDeviceKey(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getSwVersion(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getHwVersion(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getSwType(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getHwType(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getUpgradeVersion(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.isUprade(), GatewayVoiceDeviceAccess.this.mGatewayVoiceDevice.getDeviceName(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doRegisterDevice(final ICallback<RegisterResult> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GatewayVoiceDeviceAccess.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().registerGatewayVoiceDevice(GatewayVoiceDeviceAccess.this.mRegisterGatewayVoiceDevice.getMac(), GatewayVoiceDeviceAccess.this.mRegisterGatewayVoiceDevice.getUpCodeT(), GatewayVoiceDeviceAccess.this.mRegisterGatewayVoiceDevice.getUplusId(), GatewayVoiceDeviceAccess.this.mRegisterGatewayVoiceDevice.getDeviceKey(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    public GatewayVoiceDeviceAccess(GatewayVoiceDevice gatewayVoiceDevice) {
        super(gatewayVoiceDevice);
        this.mGatewayVoiceDevice = gatewayVoiceDevice;
    }
}
