package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29658d;

    public String a() {
        return this.f29655a;
    }

    public int b() {
        return this.f29656b;
    }

    public String c() {
        return this.f29657c;
    }

    public int d() {
        return this.f29658d;
    }

    public String toString() {
        return "RefreshTokenRsp{access_token='" + this.f29655a + "', expires_in=" + this.f29656b + ", refresh_token='" + this.f29657c + "', sn=" + this.f29658d + '}';
    }

    public void a(String str) {
        this.f29655a = str;
    }

    public void b(String str) {
        this.f29657c = str;
    }

    public void a(int i7) {
        this.f29656b = i7;
    }

    public void b(int i7) {
        this.f29658d = i7;
    }
}
