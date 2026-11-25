package com.haier.uhome.control.local.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BleOtaInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f29297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29298d;

    public String a() {
        return this.f29295a;
    }

    public String b() {
        return this.f29296b;
    }

    public boolean c() {
        return this.f29297c;
    }

    public String d() {
        return this.f29298d;
    }

    public String toString() {
        return "BleOtaInfo{currentVersion='" + this.f29295a + "', targetVersion='" + this.f29296b + "', isNeedOTA='" + this.f29297c + "', newVersionDescription='" + this.f29298d + "'}";
    }

    public void a(String str) {
        this.f29295a = str;
    }

    public void b(String str) {
        this.f29296b = str;
    }

    public void c(String str) {
        this.f29298d = str;
    }

    public void a(boolean z7) {
        this.f29297c = z7;
    }
}
