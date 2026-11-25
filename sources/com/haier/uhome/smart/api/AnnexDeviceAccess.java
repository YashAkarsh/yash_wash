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
public class AnnexDeviceAccess extends AbsDeviceAccess {
    private AnnexDevice mAnnexDevice;
    private RegisterAnnexDevice mRegisterAnnexDevice;

    public AnnexDeviceAccess(RegisterAnnexDevice registerAnnexDevice) {
        super(registerAnnexDevice);
        this.mRegisterAnnexDevice = registerAnnexDevice;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkOnlineParam() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (this.mAnnexDevice == null) {
            a.h("checkOnlineParam mAnnexDevice is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("mAnnexDevice=null");
            return error2;
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.mAnnexDevice.getParentId())) {
            a.h("checkOnlineParam parentId<%s> is invalid", this.mAnnexDevice.getParentId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append("parentId=");
            sb.append(this.mAnnexDevice.getParentId());
        }
        if (TextUtils.isEmpty(this.mAnnexDevice.getDeviceId())) {
            a.h("checkOnlineParam deviceId<%s> is invalid", this.mAnnexDevice.getDeviceId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" deviceId=");
            sb.append(this.mAnnexDevice.getDeviceId());
        }
        if (!error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            return super.checkOnlineParam();
        }
        error.a(sb.toString());
        return error;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkRegisterParam() {
        RegisterAnnexDevice registerAnnexDevice = this.mRegisterAnnexDevice;
        if (registerAnnexDevice == null) {
            a.h("checkRegisterParam mRegisterAnnexDevice is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("mRegisterAnnexDevice=null");
            return error;
        }
        if (!TextUtils.isEmpty(registerAnnexDevice.getMac()) && this.mRegisterAnnexDevice.getMac().matches(ConstSmartDevice.REGEX_SUB_DEV_ID)) {
            return super.checkRegisterParam();
        }
        a.h("checkRegisterParam mac<%s> is invalid", this.mRegisterAnnexDevice.getMac());
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("mac=" + this.mRegisterAnnexDevice.getMac());
        return error2;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    public void deviceOnline(ICallback iCallback) {
        super.deviceOnline(iCallback);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doDeviceOnline(final ICallback<String> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.AnnexDeviceAccess.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().annexDeviceOnline(AnnexDeviceAccess.this.mAnnexDevice.getParentId(), AnnexDeviceAccess.this.mAnnexDevice.getDeviceId(), AnnexDeviceAccess.this.mAnnexDevice.getUpCodeT(), AnnexDeviceAccess.this.mAnnexDevice.getUplusId(), AnnexDeviceAccess.this.mAnnexDevice.getDeviceKey(), AnnexDeviceAccess.this.mAnnexDevice.getUpgradeVersion(), AnnexDeviceAccess.this.mAnnexDevice.isUprade(), AnnexDeviceAccess.this.mAnnexDevice.getDeviceName(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doRegisterDevice(final ICallback<RegisterResult> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.AnnexDeviceAccess.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().registerAnnexDevice(AnnexDeviceAccess.this.mRegisterAnnexDevice.getMac(), AnnexDeviceAccess.this.mRegisterAnnexDevice.getUpCodeT(), AnnexDeviceAccess.this.mRegisterAnnexDevice.getUplusId(), AnnexDeviceAccess.this.mRegisterAnnexDevice.getDeviceKey(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    public void registerDevice(ICallback iCallback) {
        super.registerDevice(iCallback);
    }

    public AnnexDeviceAccess(AnnexDevice annexDevice) {
        super(annexDevice);
        this.mAnnexDevice = annexDevice;
    }
}
