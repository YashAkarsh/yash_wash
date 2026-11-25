package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f23396a;

    protected b(j jVar) {
        this.f23396a = jVar;
    }

    public abstract b a(j jVar);

    public abstract com.google.zxing.common.b b() throws m;

    public abstract com.google.zxing.common.a c(int i7, com.google.zxing.common.a aVar) throws m;

    public final int d() {
        return this.f23396a.b();
    }

    public final j e() {
        return this.f23396a;
    }

    public final int f() {
        return this.f23396a.e();
    }
}
