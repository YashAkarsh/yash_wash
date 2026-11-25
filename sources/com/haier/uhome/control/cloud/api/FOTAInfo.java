package com.haier.uhome.control.cloud.api;

import com.haier.uhome.control.cloud.json.resp.DevCheckFWVerResp;
import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FOTAInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29085c;

    @Keep
    private String currentVersion;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29086d;

    @Keep
    private String digest;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f29090h;

    @Keep
    private String newVersion;

    @Keep
    private String upgradePackageURL;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private DevCheckFWVerResp f29091a;

        public a a(DevCheckFWVerResp devCheckFWVerResp) {
            this.f29091a = devCheckFWVerResp;
            return this;
        }

        public FOTAInfo a() {
            if (this.f29091a == null) {
                return null;
            }
            FOTAInfo fOTAInfo = new FOTAInfo();
            fOTAInfo.a(this.f29091a.getVers());
            fOTAInfo.d(this.f29091a.getModel());
            DevCheckFWVerResp.Firmware firmware = this.f29091a.getFirmware();
            fOTAInfo.a(firmware != null);
            if (fOTAInfo.isNeedFOTA()) {
                fOTAInfo.b(firmware.getVers());
                fOTAInfo.c(firmware.getDesc());
                fOTAInfo.b(firmware.getTimeout());
                fOTAInfo.e(firmware.getUrl());
                fOTAInfo.f(firmware.getDigestAlg());
                fOTAInfo.g(firmware.getDigest());
                fOTAInfo.h(firmware.getKeyAlg());
                fOTAInfo.i(firmware.getKey());
                fOTAInfo.a(firmware.getSize());
            }
            return fOTAInfo;
        }
    }

    public void a(boolean z7) {
        this.f29090h = z7;
    }

    public void b(String str) {
        this.newVersion = str;
    }

    public void c(String str) {
        this.f29083a = str;
    }

    public void d(String str) {
        this.f29084b = str;
    }

    public void e(String str) {
        this.upgradePackageURL = str;
    }

    public void f(String str) {
        this.f29087e = str;
    }

    public void g(String str) {
        this.digest = str;
    }

    @Keep
    public String getCurrentVersion() {
        return this.currentVersion;
    }

    @Keep
    public String getModel() {
        return this.f29084b;
    }

    @Keep
    public String getNewVersion() {
        return this.newVersion;
    }

    @Keep
    public String getNewVersionDescription() {
        return this.f29083a;
    }

    @Keep
    public int getSize() {
        return this.f29086d;
    }

    @Keep
    public int getTimeoutInterval() {
        return this.f29085c;
    }

    public void h(String str) {
        this.f29088f = str;
    }

    public void i(String str) {
        this.f29089g = str;
    }

    @Keep
    public boolean isNeedFOTA() {
        return this.f29090h;
    }

    public String toString() {
        return "FOTAInfo{currentVersion='" + this.currentVersion + "', newVersion='" + this.newVersion + "', newVersionDescription='" + this.f29083a + "', model='" + this.f29084b + "', timeoutInterval=" + this.f29085c + ", upgradePackageURL='" + this.upgradePackageURL + "', digestAlg='" + this.f29087e + "', digest='" + this.digest + "', keyAlg='" + this.f29088f + "', key='" + this.f29089g + "', size='" + this.f29086d + "'}";
    }

    private FOTAInfo() {
    }

    public void a(int i7) {
        this.f29086d = i7;
    }

    public void b(int i7) {
        this.f29085c = i7;
    }

    public String c() {
        return this.digest;
    }

    public String d() {
        return this.f29088f;
    }

    public String e() {
        return this.f29089g;
    }

    public void a(String str) {
        this.currentVersion = str;
    }

    public String b() {
        return this.f29087e;
    }

    public String a() {
        return this.upgradePackageURL;
    }
}
