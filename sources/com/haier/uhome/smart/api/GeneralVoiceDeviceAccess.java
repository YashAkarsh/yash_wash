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
public class GeneralVoiceDeviceAccess extends AbsDeviceAccess {
    private GeneralVoiceDevice mGeneralVoiceDevice;
    private RegisterGeneralVoiceDevice mRegisterGeneralVoiceDevice;

    public GeneralVoiceDeviceAccess(RegisterGeneralVoiceDevice registerGeneralVoiceDevice) {
        super(registerGeneralVoiceDevice);
        this.mRegisterGeneralVoiceDevice = registerGeneralVoiceDevice;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkOnlineParam() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (this.mGeneralVoiceDevice == null) {
            a.h("checkOnlineParam mGeneralVoiceDevice is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("device=null");
            return error2;
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.mGeneralVoiceDevice.getDeviceId()) || this.mGeneralVoiceDevice.getDeviceId().length() > 24) {
            a.h("checkOnlineParam deviceId<%s> is invalid", this.mGeneralVoiceDevice.getDeviceId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append("deviceId=");
            sb.append(this.mGeneralVoiceDevice.getDeviceId());
        }
        if (TextUtils.isEmpty(this.mGeneralVoiceDevice.getSwVersion()) || !isDeviceVersionOk(this.mGeneralVoiceDevice.getSwVersion())) {
            a.h("checkOnlineParam swVersion<%s> is invalid", this.mGeneralVoiceDevice.getSwVersion());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" swVersion=");
            sb.append(this.mGeneralVoiceDevice.getSwVersion());
        }
        if (TextUtils.isEmpty(this.mGeneralVoiceDevice.getHwVersion()) || !isDeviceVersionOk(this.mGeneralVoiceDevice.getHwVersion())) {
            a.h("checkOnlineParam hwVersion<%s> is invalid", this.mGeneralVoiceDevice.getHwVersion());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" hwVersion=");
            sb.append(this.mGeneralVoiceDevice.getHwVersion());
        }
        if (TextUtils.isEmpty(this.mGeneralVoiceDevice.getSwType())) {
            a.h("checkOnlineParam swType<%s> is invalid", this.mGeneralVoiceDevice.getSwType());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" swType=");
            sb.append(this.mGeneralVoiceDevice.getSwType());
        }
        if (TextUtils.isEmpty(this.mGeneralVoiceDevice.getHwType())) {
            a.h("checkOnlineParam hwType<%s> is invalid", this.mGeneralVoiceDevice.getHwType());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" hwType=");
            sb.append(this.mGeneralVoiceDevice.getHwType());
        }
        if (!error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            return super.checkOnlineParam();
        }
        error.a(sb.toString());
        return error;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkRegisterParam() {
        RegisterGeneralVoiceDevice registerGeneralVoiceDevice = this.mRegisterGeneralVoiceDevice;
        if (registerGeneralVoiceDevice == null) {
            a.h("checkRegisterParam mRegisterGeneralVoiceDevice is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("mRegisterGeneralVoiceDevice=null");
            return error;
        }
        if (!TextUtils.isEmpty(registerGeneralVoiceDevice.getMac()) && this.mRegisterGeneralVoiceDevice.getMac().matches(ConstSmartDevice.REGEX_SUB_DEV_ID)) {
            return super.checkRegisterParam();
        }
        a.h("checkRegisterParam mRegisterSlaveDevice mac<%s> is invalid", this.mRegisterGeneralVoiceDevice.getMac());
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("mac=" + this.mRegisterGeneralVoiceDevice.getMac());
        return error2;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doDeviceOnline(final ICallback<String> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GeneralVoiceDeviceAccess.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().generalVoiceDeviceOnline(GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getDeviceId(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getUpCodeT(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getUplusId(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getDeviceKey(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getSwVersion(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getHwVersion(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getSwType(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getHwType(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getUpgradeVersion(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.isUprade(), GeneralVoiceDeviceAccess.this.mGeneralVoiceDevice.getDeviceName(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doRegisterDevice(final ICallback<RegisterResult> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GeneralVoiceDeviceAccess.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().registerGeneralVoiceDevice(GeneralVoiceDeviceAccess.this.mRegisterGeneralVoiceDevice.getMac(), GeneralVoiceDeviceAccess.this.mRegisterGeneralVoiceDevice.getUpCodeT(), GeneralVoiceDeviceAccess.this.mRegisterGeneralVoiceDevice.getUplusId(), GeneralVoiceDeviceAccess.this.mRegisterGeneralVoiceDevice.getDeviceKey(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    public GeneralVoiceDeviceAccess(GeneralVoiceDevice generalVoiceDevice) {
        super(generalVoiceDevice);
        this.mGeneralVoiceDevice = generalVoiceDevice;
    }
}
