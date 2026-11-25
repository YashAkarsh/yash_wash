package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigurableDevice {
    private com.haier.uhome.search.a.k scanDevice;

    protected ConfigurableDevice(com.haier.uhome.search.a.k kVar) {
        this.scanDevice = kVar;
    }

    public String getConfigType() {
        return this.scanDevice.g();
    }

    public String getDevId() {
        return this.scanDevice.k();
    }

    public String getDevIdSuffix() {
        return this.scanDevice.d();
    }

    public uSDKDeviceTypeConst getDeviceType() {
        return uSDKDeviceTypeConst.getInstance(this.scanDevice.b().name());
    }

    public String getManufacturer() {
        return this.scanDevice.a();
    }

    public int getMiddleType() {
        return this.scanDevice.c();
    }

    public String getTag() {
        return this.scanDevice.e();
    }

    public String getVersion() {
        return this.scanDevice.f();
    }

    public boolean isSafe() {
        return this.scanDevice.h();
    }

    public boolean isSupportNoPwdConfig() {
        return this.scanDevice.j();
    }

    public String toString() {
        return super.toString();
    }
}
