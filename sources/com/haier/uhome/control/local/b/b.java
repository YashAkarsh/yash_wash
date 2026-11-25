package com.haier.uhome.control.local.b;

import com.haier.uhome.control.cloud.api.FOTAInfo;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f29343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FOTAInfo f29344b;

    public b(FOTAInfo fOTAInfo) {
        this.f29344b = fOTAInfo;
    }

    public File a() {
        return this.f29343a;
    }

    public boolean b() {
        return this.f29344b.isNeedFOTA();
    }

    public int c() {
        return this.f29344b.getSize();
    }

    public String d() {
        return this.f29344b.getCurrentVersion();
    }

    public String e() {
        return this.f29344b.getNewVersion();
    }

    public String f() {
        return this.f29344b.getNewVersionDescription();
    }

    public String g() {
        return this.f29344b.getModel();
    }

    public int h() {
        return this.f29344b.getTimeoutInterval();
    }

    public String i() {
        return this.f29344b.a();
    }

    public String j() {
        return this.f29344b.b();
    }

    public String k() {
        return this.f29344b.c();
    }

    public String l() {
        return this.f29344b.d();
    }

    public String m() {
        return this.f29344b.e();
    }

    public FOTAInfo n() {
        return this.f29344b;
    }

    public String toString() {
        return "BleOtaInfoDto{otaFile=" + this.f29343a + ", fotaInfo=" + this.f29344b + '}';
    }

    public void a(File file) {
        this.f29343a = file;
    }
}
