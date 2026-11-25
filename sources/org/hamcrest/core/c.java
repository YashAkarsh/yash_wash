package org.hamcrest.core;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class c<T> extends org.hamcrest.o<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.hamcrest.k<? super T> f39707c;

    public static final class a<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.hamcrest.k<? super X> f39708a;

        public a(org.hamcrest.k<? super X> kVar) {
            this.f39708a = kVar;
        }

        public c<X> a(org.hamcrest.k<? super X> kVar) {
            return new c(this.f39708a).f(kVar);
        }
    }

    public static final class b<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.hamcrest.k<? super X> f39709a;

        public b(org.hamcrest.k<? super X> kVar) {
            this.f39709a = kVar;
        }

        public c<X> a(org.hamcrest.k<? super X> kVar) {
            return new c(this.f39709a).i(kVar);
        }
    }

    public c(org.hamcrest.k<? super T> kVar) {
        this.f39707c = kVar;
    }

    @org.hamcrest.i
    public static <LHS> a<LHS> g(org.hamcrest.k<? super LHS> kVar) {
        return new a<>(kVar);
    }

    @org.hamcrest.i
    public static <LHS> b<LHS> h(org.hamcrest.k<? super LHS> kVar) {
        return new b<>(kVar);
    }

    private ArrayList<org.hamcrest.k<? super T>> j(org.hamcrest.k<? super T> kVar) {
        ArrayList<org.hamcrest.k<? super T>> arrayList = new ArrayList<>();
        arrayList.add(this.f39707c);
        arrayList.add(kVar);
        return arrayList;
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.b(this.f39707c);
    }

    @Override // org.hamcrest.o
    protected boolean e(T t7, org.hamcrest.g gVar) {
        if (this.f39707c.c(t7)) {
            return true;
        }
        this.f39707c.a(t7, gVar);
        return false;
    }

    public c<T> f(org.hamcrest.k<? super T> kVar) {
        return new c<>(new org.hamcrest.core.a(j(kVar)));
    }

    public c<T> i(org.hamcrest.k<? super T> kVar) {
        return new c<>(new org.hamcrest.core.b(j(kVar)));
    }
}
