package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKDeviceNetQuality {
    WEAK(com.haier.uhome.control.base.api.f.WEAK),
    MIDDLE(com.haier.uhome.control.base.api.f.MIDDLE),
    GOOD(com.haier.uhome.control.base.api.f.GOOD),
    STRONG(com.haier.uhome.control.base.api.f.STRONG);

    com.haier.uhome.control.base.api.f deviceNetQuality;

    uSDKDeviceNetQuality(com.haier.uhome.control.base.api.f fVar) {
        this.deviceNetQuality = fVar;
    }

    public static uSDKDeviceNetQuality getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return WEAK;
        }
    }

    public static uSDKDeviceNetQuality getNetQuality(com.haier.uhome.control.base.api.f fVar) {
        uSDKDeviceNetQuality usdkdevicenetquality = getInstance(fVar.name());
        usdkdevicenetquality.deviceNetQuality = fVar;
        return usdkdevicenetquality;
    }
}
