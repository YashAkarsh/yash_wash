package org.hamcrest.core;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
abstract class n<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterable<org.hamcrest.k<? super T>> f39723a;

    public n(Iterable<org.hamcrest.k<? super T>> iterable) {
        this.f39723a = iterable;
    }

    @Override // org.hamcrest.m
    public abstract void b(org.hamcrest.g gVar);

    @Override // org.hamcrest.k
    public abstract boolean c(Object obj);

    public void e(org.hamcrest.g gVar, String str) {
        gVar.a("(", " " + str + " ", ")", this.f39723a);
    }

    protected boolean f(Object obj, boolean z7) {
        Iterator<org.hamcrest.k<? super T>> it = this.f39723a.iterator();
        while (it.hasNext()) {
            if (it.next().c(obj) == z7) {
                return z7;
            }
        }
        return !z7;
    }
}
