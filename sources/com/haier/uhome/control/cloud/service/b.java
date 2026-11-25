package com.haier.uhome.control.cloud.service;

import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CloudControlNative f29149a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f29150a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f29150a;
    }

    public void b() {
        this.f29149a.userDelete();
    }

    public int c() {
        return this.f29149a.userStart();
    }

    public int d() {
        return this.f29149a.userStop();
    }

    public long e() {
        return this.f29149a.getHandle();
    }

    public int f() {
        return this.f29149a.caeCloudState();
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        String strBuildJson = basicReq.buildJson();
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControl send req <%s>", strBuildJson);
        return this.f29149a.devControl(strBuildJson);
    }

    private b() {
        CloudControlNative cloudControlNative = new CloudControlNative();
        this.f29149a = cloudControlNative;
        cloudControlNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    public int a(String str, int i7, String str2, String str3, int i8) {
        return this.f29149a.userCreate(com.haier.uhome.usdk.base.service.d.p().t(), i7, 0, str, str2, str3, i8);
    }

    public int a(String str, String str2) {
        return this.f29149a.devLogin(str, str2);
    }

    public int a(String str) {
        return this.f29149a.devLogout(str);
    }

    public void a(int i7, int i8, String str, long j7) {
        this.f29149a.sendHttpResp(i7, i8, str, j7);
    }
}
