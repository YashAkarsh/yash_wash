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
public class SlaveDeviceAccess extends AbsDeviceAccess {
    private RegisterSlaveDevice mRegisterSlaveDevice;
    private SlaveDevice mSlaveDevice;

    public SlaveDeviceAccess(RegisterSlaveDevice registerSlaveDevice) {
        super(registerSlaveDevice);
        this.mRegisterSlaveDevice = registerSlaveDevice;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkOnlineParam() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (this.mSlaveDevice == null) {
            a.h("checkOnlineParam mSlaveDevice is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("mSlaveDevice=null");
            return error2;
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.mSlaveDevice.getParentId())) {
            a.h("checkOnlineParam parentId<%s> is invalid", this.mSlaveDevice.getParentId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append("parentId=");
            sb.append(this.mSlaveDevice.getParentId());
        }
        if (TextUtils.isEmpty(this.mSlaveDevice.getDeviceId())) {
            a.h("checkOnlineParam deviceId<%s> is invalid", this.mSlaveDevice.getDeviceId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" deviceId=");
            sb.append(this.mSlaveDevice.getDeviceId());
        }
        if (this.mSlaveDevice.getProtocol() == null) {
            a.h("checkOnlineParam protocol is null", new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" protocol=");
            sb.append(this.mSlaveDevice.getProtocol());
        }
        if (!error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            return super.checkOnlineParam();
        }
        error.a(sb.toString());
        return error;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkRegisterParam() {
        RegisterSlaveDevice registerSlaveDevice = this.mRegisterSlaveDevice;
        if (registerSlaveDevice == null) {
            a.h("checkRegisterParam mRegisterSlaveDevice is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("mRegisterSlaveDevice=null");
            return error;
        }
        if (!TextUtils.isEmpty(registerSlaveDevice.getMac()) && this.mRegisterSlaveDevice.getMac().matches(ConstSmartDevice.REGEX_SUB_DEV_ID)) {
            return super.checkRegisterParam();
        }
        a.h("checkRegisterParam mRegisterSlaveDevice mac<%s> is invalid", this.mRegisterSlaveDevice.getMac());
        uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error2.a("mac=" + this.mRegisterSlaveDevice.getMac());
        return error2;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doDeviceOnline(final ICallback<String> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.SlaveDeviceAccess.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().slaveDeviceOnline(SlaveDeviceAccess.this.mSlaveDevice.getParentId(), SlaveDeviceAccess.this.mSlaveDevice.getDeviceId(), SlaveDeviceAccess.this.mSlaveDevice.getUpCodeT(), SlaveDeviceAccess.this.mSlaveDevice.getUplusId(), SlaveDeviceAccess.this.mSlaveDevice.getDeviceKey(), SlaveDeviceAccess.this.mSlaveDevice.getUpgradeVersion(), SlaveDeviceAccess.this.mSlaveDevice.isUprade(), SlaveDeviceAccess.this.mSlaveDevice.getProtocol(), SlaveDeviceAccess.this.mSlaveDevice.getDeviceName(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doRegisterDevice(final ICallback<RegisterResult> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.SlaveDeviceAccess.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().registerSlaveDevice(SlaveDeviceAccess.this.mRegisterSlaveDevice.getMac(), SlaveDeviceAccess.this.mRegisterSlaveDevice.getUpCodeT(), SlaveDeviceAccess.this.mRegisterSlaveDevice.getUplusId(), SlaveDeviceAccess.this.mRegisterSlaveDevice.getDeviceKey(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    public SlaveDeviceAccess(SlaveDevice slaveDevice) {
        super(slaveDevice);
        this.mSlaveDevice = slaveDevice;
    }
}
