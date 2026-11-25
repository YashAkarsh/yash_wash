package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29632c;

    public String a() {
        return this.f29630a;
    }

    public String b() {
        return this.f29631b;
    }

    public int c() {
        return this.f29632c;
    }

    public String toString() {
        return "QrCodeRsp{img='" + this.f29630a + "', token='" + this.f29631b + "', sn=" + this.f29632c + '}';
    }

    public void a(String str) {
        this.f29630a = str;
    }

    public void b(String str) {
        this.f29631b = str;
    }

    public void a(int i7) {
        this.f29632c = i7;
    }
}
