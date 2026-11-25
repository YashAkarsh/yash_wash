package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class g<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39716a;

    public g() {
        this("ANYTHING");
    }

    @org.hamcrest.i
    public static org.hamcrest.k<Object> e() {
        return new g();
    }

    @org.hamcrest.i
    public static org.hamcrest.k<Object> f(String str) {
        return new g(str);
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d(this.f39716a);
    }

    @Override // org.hamcrest.k
    public boolean c(Object obj) {
        return true;
    }

    public g(String str) {
        this.f39716a = str;
    }
}
