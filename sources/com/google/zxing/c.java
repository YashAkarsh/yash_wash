package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f23397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.zxing.common.b f23398b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f23397a = bVar;
    }

    public c a(int i7, int i8, int i9, int i10) {
        return new c(this.f23397a.a(this.f23397a.e().a(i7, i8, i9, i10)));
    }

    public com.google.zxing.common.b b() throws m {
        if (this.f23398b == null) {
            this.f23398b = this.f23397a.b();
        }
        return this.f23398b;
    }

    public com.google.zxing.common.a c(int i7, com.google.zxing.common.a aVar) throws m {
        return this.f23397a.c(i7, aVar);
    }

    public int d() {
        return this.f23397a.d();
    }

    public int e() {
        return this.f23397a.f();
    }

    public boolean f() {
        return this.f23397a.e().g();
    }

    public boolean g() {
        return this.f23397a.e().h();
    }

    public c h() {
        return new c(this.f23397a.a(this.f23397a.e().i()));
    }

    public c i() {
        return new c(this.f23397a.a(this.f23397a.e().j()));
    }

    public String toString() {
        try {
            return b().toString();
        } catch (m unused) {
            return "";
        }
    }
}
