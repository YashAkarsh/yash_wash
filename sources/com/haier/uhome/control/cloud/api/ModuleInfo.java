package com.haier.uhome.control.cloud.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ModuleInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29097f;

    public void a(String str) {
        this.f29092a = str;
    }

    public void b(String str) {
        this.f29093b = str;
    }

    public void c(String str) {
        this.f29094c = str;
    }

    public void d(String str) {
        this.f29095d = str;
    }

    public void e(String str) {
        this.f29096e = str;
    }

    public void f(String str) {
        this.f29097f = str;
    }

    @Keep
    public String getDeviceAccessType() {
        return this.f29092a;
    }

    @Keep
    public String getHardwareType() {
        return this.f29096e;
    }

    @Keep
    public String getHardwareVer() {
        return this.f29097f;
    }

    @Keep
    public String getMachineId() {
        return this.f29093b;
    }

    @Keep
    public String getSoftwareType() {
        return this.f29094c;
    }

    @Keep
    public String getSoftwareVer() {
        return this.f29095d;
    }

    public String toString() {
        return "ModuleInfo{deviceAccessType='" + this.f29092a + "', machineId='" + this.f29093b + "', softwareType='" + this.f29094c + "', softwareVer='" + this.f29095d + "', hardwareType='" + this.f29096e + "', hardwareVer='" + this.f29097f + "'}";
    }
}
