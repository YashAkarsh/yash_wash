package org.junit.rules;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<org.hamcrest.k<?>> f39925a = new ArrayList();

    d() {
    }

    private org.hamcrest.k<Throwable> b() {
        return this.f39925a.size() == 1 ? d(this.f39925a.get(0)) : org.hamcrest.d.a(e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private org.hamcrest.k<Throwable> d(org.hamcrest.k<?> kVar) {
        return kVar;
    }

    private List<org.hamcrest.k<? super Throwable>> e() {
        return new ArrayList(this.f39925a);
    }

    void a(org.hamcrest.k<?> kVar) {
        this.f39925a.add(kVar);
    }

    org.hamcrest.k<Throwable> c() {
        return e7.a.j(b());
    }

    boolean f() {
        return !this.f39925a.isEmpty();
    }
}
