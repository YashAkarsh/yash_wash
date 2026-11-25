package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public class e<T> extends org.hamcrest.o<Iterable<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.hamcrest.k<? super T> f39714c;

    public e(org.hamcrest.k<? super T> kVar) {
        this.f39714c = kVar;
    }

    @org.hamcrest.i
    public static <U> org.hamcrest.k<Iterable<U>> f(org.hamcrest.k<U> kVar) {
        return new e(kVar);
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d("every item is ").b(this.f39714c);
    }

    @Override // org.hamcrest.o
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean e(Iterable<T> iterable, org.hamcrest.g gVar) {
        for (T t7 : iterable) {
            if (!this.f39714c.c(t7)) {
                gVar.d("an item ");
                this.f39714c.a(t7, gVar);
                return false;
            }
        }
        return true;
    }
}
