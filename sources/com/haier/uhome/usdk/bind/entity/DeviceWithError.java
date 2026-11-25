package com.haier.uhome.usdk.bind.entity;

import com.haier.uhome.usdk.api.uSDKDeviceInfo;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class DeviceWithError {

    @Keep
    private uSDKDeviceInfo device;

    @Keep
    private uSDKError error;

    @Keep
    public DeviceWithError(uSDKDeviceInfo usdkdeviceinfo, uSDKError usdkerror) {
        this.device = usdkdeviceinfo;
        this.error = usdkerror;
    }

    public void a(uSDKDeviceInfo usdkdeviceinfo) {
        this.device = usdkdeviceinfo;
    }

    @Keep
    public uSDKDeviceInfo getDevice() {
        return this.device;
    }

    @Keep
    public uSDKError getError() {
        return this.error;
    }

    public void a(uSDKError usdkerror) {
        this.error = usdkerror;
    }
}
