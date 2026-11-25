package com.haier.uhome.smart.api;

import android.text.TextUtils;
import com.haier.library.common.thread.m;
import com.haier.uhome.smart.ConstSmartDevice;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.utils.b;
import e3.a;

/* JADX INFO: loaded from: classes2.dex */
public class GeneralDeviceAccess extends AbsDeviceAccess {
    private GeneralDevice mGeneralDevice;
    private RegisterGeneralDevice mRegisterGeneralDevice;

    public GeneralDeviceAccess(RegisterGeneralDevice registerGeneralDevice) {
        super(registerGeneralDevice);
        this.mRegisterGeneralDevice = registerGeneralDevice;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkOnlineParam() {
        GeneralDevice generalDevice = this.mGeneralDevice;
        if (generalDevice == null) {
            a.h("checkOnlineParam mGeneralDevice is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("device=null");
            return error;
        }
        if (!TextUtils.isEmpty(generalDevice.getDeviceId())) {
            return super.checkOnlineParam();
        }
        a.h("checkOnlineParam deviceId<%s> is invalid", this.mGeneralDevice.getDeviceId());
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("deviceId=" + this.mGeneralDevice.getDeviceId() + "is invalid");
        return error2;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkRegisterParam() {
        RegisterGeneralDevice registerGeneralDevice = this.mRegisterGeneralDevice;
        if (registerGeneralDevice == null) {
            a.h("checkRegisterParam mRegisterGeneralDevice is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("mRegisterGeneralDevice=null");
            return error;
        }
        if (!TextUtils.isEmpty(registerGeneralDevice.getMac()) && this.mRegisterGeneralDevice.getMac().matches(ConstSmartDevice.REGEX_SUB_DEV_ID)) {
            return super.checkRegisterParam();
        }
        a.h("checkRegisterParam mRegisterGeneralDevice mac<%s> is invalid", this.mRegisterGeneralDevice.getMac());
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("mac=" + this.mRegisterGeneralDevice.getMac());
        return error2;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    public void deviceOnline(ICallback iCallback) {
        super.deviceOnline(iCallback);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doDeviceOnline(final ICallback<String> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GeneralDeviceAccess.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().generalDeviceOnline(GeneralDeviceAccess.this.mGeneralDevice.getDeviceId(), GeneralDeviceAccess.this.mGeneralDevice.getUpCodeT(), GeneralDeviceAccess.this.mGeneralDevice.getUplusId(), GeneralDeviceAccess.this.mGeneralDevice.getDeviceKey(), GeneralDeviceAccess.this.mGeneralDevice.getUpgradeVersion(), GeneralDeviceAccess.this.mGeneralDevice.isUprade(), GeneralDeviceAccess.this.mGeneralDevice.getDeviceName(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doRegisterDevice(final ICallback<RegisterResult> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GeneralDeviceAccess.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().registerGeneralDevice(GeneralDeviceAccess.this.mRegisterGeneralDevice.getMac(), GeneralDeviceAccess.this.mRegisterGeneralDevice.getUpCodeT(), GeneralDeviceAccess.this.mRegisterGeneralDevice.getUplusId(), GeneralDeviceAccess.this.mRegisterGeneralDevice.getDeviceKey(), new ICallback<RegisterResult>() { // from class: com.haier.uhome.smart.api.GeneralDeviceAccess.1.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        b.a(iCallback, usdkerror);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onSuccess(RegisterResult registerResult) {
                        b.a((ICallback<RegisterResult>) iCallback, registerResult);
                    }
                });
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    public void registerDevice(ICallback iCallback) {
        super.registerDevice(iCallback);
    }

    public GeneralDeviceAccess(GeneralDevice generalDevice) {
        super(generalDevice);
        this.mGeneralDevice = generalDevice;
    }

    public GeneralDeviceAccess(AbsRegisterDevice absRegisterDevice) {
        super(absRegisterDevice);
    }

    public GeneralDeviceAccess(AbsSmartDevice absSmartDevice) {
        super(absSmartDevice);
    }
}
