package com.google.android.gms.auth.api.signin.internal;

import c.m0;
import c.o0;
import g1.d0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d0
    static int f14990b = 31;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14991a = 1;

    @c1.a
    @m0
    public a a(@o0 Object obj) {
        this.f14991a = (f14990b * this.f14991a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    @c1.a
    public int b() {
        return this.f14991a;
    }

    @m0
    public final a c(boolean z7) {
        this.f14991a = (f14990b * this.f14991a) + (z7 ? 1 : 0);
        return this;
    }
}
