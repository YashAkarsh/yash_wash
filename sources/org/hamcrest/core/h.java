package org.hamcrest.core;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class h<T> extends org.hamcrest.o<Iterable<? super T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.hamcrest.k<? super T> f39717c;

    public h(org.hamcrest.k<? super T> kVar) {
        this.f39717c = kVar;
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<Iterable<? super T>> f(T t7) {
        return new h(i.i(t7));
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<Iterable<? super T>> g(org.hamcrest.k<? super T> kVar) {
        return new h(kVar);
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<Iterable<T>> h(T... tArr) {
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t7 : tArr) {
            arrayList.add(f(t7));
        }
        return a.f(arrayList);
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<Iterable<T>> i(org.hamcrest.k<? super T>... kVarArr) {
        ArrayList arrayList = new ArrayList(kVarArr.length);
        for (org.hamcrest.k<? super T> kVar : kVarArr) {
            arrayList.add(new h(kVar));
        }
        return a.f(arrayList);
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d("a collection containing ").b(this.f39717c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.o
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean e(Iterable<? super T> iterable, org.hamcrest.g gVar) {
        boolean z7 = false;
        for (T t7 : iterable) {
            if (this.f39717c.c(t7)) {
                return true;
            }
            if (z7) {
                gVar.d(", ");
            }
            this.f39717c.a(t7, gVar);
            z7 = true;
        }
        return false;
    }
}
