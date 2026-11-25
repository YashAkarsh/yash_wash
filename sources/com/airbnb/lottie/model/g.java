package com.airbnb.lottie.model;

import c.g1;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f12085b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.collection.g<String, com.airbnb.lottie.f> f12086a = new androidx.collection.g<>(20);

    @g1
    g() {
    }

    public static g c() {
        return f12085b;
    }

    public void a() {
        this.f12086a.f();
    }

    @o0
    public com.airbnb.lottie.f b(@o0 String str) {
        if (str == null) {
            return null;
        }
        return this.f12086a.h(str);
    }

    public void d(@o0 String str, com.airbnb.lottie.f fVar) {
        if (str == null) {
            return;
        }
        this.f12086a.l(str, fVar);
    }

    public void e(int i7) {
        this.f12086a.o(i7);
    }
}
