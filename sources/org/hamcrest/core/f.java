package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class f<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.hamcrest.k<T> f39715a;

    public f(org.hamcrest.k<T> kVar) {
        this.f39715a = kVar;
    }

    @org.hamcrest.i
    @Deprecated
    public static <T> org.hamcrest.k<T> e(Class<T> cls) {
        return g(j.g(cls));
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> f(T t7) {
        return g(i.i(t7));
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> g(org.hamcrest.k<T> kVar) {
        return new f(kVar);
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> h(Class<T> cls) {
        return g(j.g(cls));
    }

    @Override // org.hamcrest.b, org.hamcrest.k
    public void a(Object obj, org.hamcrest.g gVar) {
        this.f39715a.a(obj, gVar);
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d("is ").b(this.f39715a);
    }

    @Override // org.hamcrest.k
    public boolean c(Object obj) {
        return this.f39715a.c(obj);
    }
}
