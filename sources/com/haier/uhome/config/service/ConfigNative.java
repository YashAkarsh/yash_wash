package com.haier.uhome.config.service;

import com.haier.uhome.usdk.base.service.BaseNative;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigNative extends BaseNative {
    private long sAHandler;

    public static int jniSleep(int i7) {
        return com.haier.library.common.util.a0.d(i7);
    }

    public native void bleConfigInit();

    public native String getDeviceBindInfo(String str, String str2);

    public native void init();

    public native int sAConfig(long j7, String str);

    public native long sAInit();

    public native int sAUninit(long j7);

    public int softAPConfig(String str) throws com.haier.uhome.config.b.a {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "softAPConfig sAConfig <%d> <%s>", Long.valueOf(this.sAHandler), str);
        int iSAConfig = sAConfig(this.sAHandler, str);
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "softAPConfig sAConfig <%d> <%s> ret %d.", Long.valueOf(this.sAHandler), str, Integer.valueOf(iSAConfig));
        if (iSAConfig == 0) {
            return iSAConfig;
        }
        throw new com.haier.uhome.config.b.a(3, "softap config fail!");
    }

    public void softAPInit() throws com.haier.uhome.config.b.a {
        long jSAInit = sAInit();
        this.sAHandler = jSAInit;
        if (jSAInit == 0) {
            throw new com.haier.uhome.config.b.a(com.haier.uhome.config.b.a.f28453b, "soft ap init fail!");
        }
    }

    public int softAPUninit() {
        return sAUninit(this.sAHandler);
    }

    public native int startBleConfig(int i7, String str, String str2, String str3, String str4, String str5, String str6, long j7, long j8, int i8);

    public native int startBleSimpleConfig(int i7, String str, String str2, String str3, int i8, String str4);

    public native int startRxAck(int i7, String str, String str2, int i8);

    public native int startSmartConfig(String str, String str2, String str3, String str4, String str5, Object[] objArr, int i7, int i8, int i9);

    public native void stopBleAllConfig();

    public native int stopRxAck();

    public native int stopSmartConfig();
}
