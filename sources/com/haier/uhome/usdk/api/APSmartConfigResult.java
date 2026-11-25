package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class APSmartConfigResult {
    private uSDKDevice mDevice;
    private uSDKErrorConst mResultError;
    private String scm;

    public uSDKDevice getDevice() {
        return this.mDevice;
    }

    public uSDKErrorConst getResultError() {
        return this.mResultError;
    }

    public String getScm() {
        return this.scm;
    }

    public void setDevice(uSDKDevice usdkdevice) {
        this.mDevice = usdkdevice;
    }

    public void setResultError(uSDKErrorConst usdkerrorconst) {
        this.mResultError = usdkerrorconst;
    }

    public void setScm(String str) {
        this.scm = str;
    }
}
