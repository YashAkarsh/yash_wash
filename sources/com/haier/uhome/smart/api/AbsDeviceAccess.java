package com.haier.uhome.smart.api;

import android.text.TextUtils;
import com.haier.uhome.smart.ConstSmartDevice;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.utils.b;
import e3.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsDeviceAccess {
    private AbsSmartDevice mDevice;
    protected AbsRegisterDevice mRegisterInfo;

    public AbsDeviceAccess(AbsRegisterDevice absRegisterDevice) {
        this.mRegisterInfo = absRegisterDevice;
    }

    protected uSDKError checkOnlineParam() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.mDevice.getDeviceId())) {
            a.h("checkOnlineParam deviceId<%s> is invalid", this.mDevice.getDeviceId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" deviceId=");
            sb.append(this.mDevice.getDeviceId());
        }
        if (TextUtils.isEmpty(this.mDevice.getDeviceName())) {
            a.h("checkOnlineParam deviceName<%s> is invalid", this.mDevice.getDeviceName());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" deviceName=");
            sb.append(this.mDevice.getDeviceName());
        }
        if (TextUtils.isEmpty(this.mDevice.getUplusId()) || !this.mDevice.getUplusId().matches(ConstSmartDevice.REGEX_UPLUSID)) {
            a.h("checkOnlineParam uplusId<%s> is invalid", this.mDevice.getUplusId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" upludId=");
            sb.append(this.mDevice.getUplusId());
        }
        if (TextUtils.isEmpty(this.mDevice.getDeviceKey())) {
            a.h("checkOnlineParam devKey<%s> is invalid", this.mDevice.getDeviceKey());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" devKey=");
            sb.append(this.mDevice.getDeviceKey());
        }
        if (TextUtils.isEmpty(this.mDevice.getUpgradeVersion())) {
            a.h("checkOnlineParam upVers<%s> is invalid", this.mDevice.getUpgradeVersion());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" upVers=");
            sb.append(this.mDevice.getUpgradeVersion());
        }
        if (this.mDevice.getRole() == null) {
            a.h("checkOnlineParam devRole is null", new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" role=");
            sb.append(this.mDevice.getRole());
        }
        if (error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            error.a(sb.toString());
        }
        return error;
    }

    protected uSDKError checkRegisterParam() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.mRegisterInfo.getUplusId()) || !this.mRegisterInfo.getUplusId().matches(ConstSmartDevice.REGEX_UPLUSID)) {
            a.h("checkRegisterParam uplusId<%s> is invalid", this.mRegisterInfo.getUplusId());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" uplusId=");
            sb.append(this.mRegisterInfo.getUplusId());
        }
        if (TextUtils.isEmpty(this.mRegisterInfo.getDeviceKey())) {
            a.h("checkRegisterParam deviceKey<%s> is invalid", this.mRegisterInfo.getDeviceKey());
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(" deviceKey=");
            sb.append(this.mRegisterInfo.getDeviceKey());
        }
        if (error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            error.a(sb.toString());
        }
        return error;
    }

    public void deviceOnline(final ICallback<String> iCallback) {
        if (SDKState.STATE_STARTED != SmartDeviceService.getInstance().getState()) {
            b.a((ICallback) iCallback, ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        uSDKError usdkerrorCheckOnlineParam = checkOnlineParam();
        if (usdkerrorCheckOnlineParam.a(ErrorConst.RET_USDK_OK)) {
            doDeviceOnline(new ICallback<String>() { // from class: com.haier.uhome.smart.api.AbsDeviceAccess.2
                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    b.a(iCallback, usdkerror);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onSuccess(String str) {
                    SmartDeviceService.getInstance().putDeviceToMap(AbsDeviceAccess.this.mDevice);
                    b.a((ICallback<String>) iCallback, str);
                }
            });
        } else {
            b.a((ICallback) iCallback, usdkerrorCheckOnlineParam);
        }
    }

    protected abstract void doDeviceOnline(ICallback<String> iCallback);

    protected abstract void doRegisterDevice(ICallback<RegisterResult> iCallback);

    protected boolean isDeviceVersionOk(String str) {
        if (str == null || str.length() <= 0) {
            a.h("deviceVersion is invalid.", new Object[0]);
            return false;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit == null || strArrSplit.length <= 0) {
            a.h("deviceVersion<%s> is invalid.", str);
            return false;
        }
        for (String str2 : strArrSplit) {
            try {
                int iIntValue = Integer.valueOf(str2).intValue();
                if (iIntValue < 0 || iIntValue > 1000) {
                    a.h("deviceVersion<%s> is invalid.", str);
                    return false;
                }
            } catch (NumberFormatException e8) {
                e8.printStackTrace();
                a.h("deviceVersion<%s> is invalid.", str);
                return false;
            }
        }
        return true;
    }

    public void registerDevice(final ICallback iCallback) {
        if (SDKState.STATE_STARTED != SmartDeviceService.getInstance().getState()) {
            b.a(iCallback, ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        uSDKError usdkerrorCheckRegisterParam = checkRegisterParam();
        if (usdkerrorCheckRegisterParam.a(ErrorConst.RET_USDK_OK)) {
            doRegisterDevice(new ICallback() { // from class: com.haier.uhome.smart.api.AbsDeviceAccess.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    iCallback.onFailure(usdkerror);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onSuccess(Object obj) {
                    iCallback.onSuccess(obj);
                }
            });
        } else {
            b.a(iCallback, usdkerrorCheckRegisterParam);
        }
    }

    public AbsDeviceAccess(AbsSmartDevice absSmartDevice) {
        this.mDevice = absSmartDevice;
    }
}
