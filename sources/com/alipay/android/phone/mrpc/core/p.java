package com.alipay.android.phone.mrpc.core;

/* JADX INFO: loaded from: classes.dex */
public final class p extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HttpUrlHeader f13469h;

    public p(HttpUrlHeader httpUrlHeader, int i7, String str, byte[] bArr) {
        this.f13469h = httpUrlHeader;
        this.f13464c = i7;
        this.f13465d = str;
        this.f13490a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f13469h;
    }

    public final void b(long j7) {
        this.f13467f = j7;
    }

    public final void a(long j7) {
        this.f13466e = j7;
    }

    public final void a(String str) {
        this.f13468g = str;
    }
}
