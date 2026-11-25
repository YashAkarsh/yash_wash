package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class m<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f39722a;

    public m(T t7) {
        this.f39722a = t7;
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> e(T t7) {
        return new m(t7);
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> f(T t7) {
        return new m(t7);
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d("sameInstance(").e(this.f39722a).d(")");
    }

    @Override // org.hamcrest.k
    public boolean c(Object obj) {
        return obj == this.f39722a;
    }
}
