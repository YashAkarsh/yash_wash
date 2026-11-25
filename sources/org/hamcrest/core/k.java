package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class k<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.hamcrest.k<T> f39721a;

    public k(org.hamcrest.k<T> kVar) {
        this.f39721a = kVar;
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> e(T t7) {
        return f(i.i(t7));
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> f(org.hamcrest.k<T> kVar) {
        return new k(kVar);
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d("not ").b(this.f39721a);
    }

    @Override // org.hamcrest.k
    public boolean c(Object obj) {
        return !this.f39721a.c(obj);
    }
}
