package com.haier.library.okhttp.b.g;

import com.haier.library.okhttp.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27142e = ":status";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f27143f = ":method";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f27144g = ":path";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f27145h = ":scheme";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f27146i = ":authority";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.haier.library.a.j f27152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.haier.library.a.j f27153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f27154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.haier.library.a.j f27141d = com.haier.library.a.j.i(":");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.haier.library.a.j f27147j = com.haier.library.a.j.i(":status");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.haier.library.a.j f27148k = com.haier.library.a.j.i(":method");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.haier.library.a.j f27149l = com.haier.library.a.j.i(":path");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.haier.library.a.j f27150m = com.haier.library.a.j.i(":scheme");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.haier.library.a.j f27151n = com.haier.library.a.j.i(":authority");

    interface a {
        void a(g0 g0Var);
    }

    public c(String str, String str2) {
        this(com.haier.library.a.j.i(str), com.haier.library.a.j.i(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f27152a.equals(cVar.f27152a) && this.f27153b.equals(cVar.f27153b);
    }

    public int hashCode() {
        return ((527 + this.f27152a.hashCode()) * 31) + this.f27153b.hashCode();
    }

    public String toString() {
        return com.haier.library.okhttp.n.d.j("%s: %s", this.f27152a.o(), this.f27153b.o());
    }

    public c(com.haier.library.a.j jVar, String str) {
        this(jVar, com.haier.library.a.j.i(str));
    }

    public c(com.haier.library.a.j jVar, com.haier.library.a.j jVar2) {
        this.f27152a = jVar;
        this.f27153b = jVar2;
        this.f27154c = jVar.Z() + 32 + jVar2.Z();
    }
}
