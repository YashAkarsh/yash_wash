package com.haier.uhome.control.cloud.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class DeviceFOTAInfo {

    @Keep
    private String firmwareID;

    @Keep
    private String traceID;

    public String a() {
        return this.traceID;
    }

    public String b() {
        return this.firmwareID;
    }

    @Keep
    public void setFirmwareID(String str) {
        this.firmwareID = str;
    }

    @Keep
    public void setTraceID(String str) {
        this.traceID = str;
    }

    public String toString() {
        return "DeviceFOTAInfo{traceID='" + this.traceID + "', firmwareID='" + this.firmwareID + "'}";
    }
}
