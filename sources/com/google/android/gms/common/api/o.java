package com.google.android.gms.common.api;

import android.os.Looper;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    @c1.a
    private o() {
    }

    @m0
    public static n<Status> a() {
        com.google.android.gms.common.api.internal.z zVar = new com.google.android.gms.common.api.internal.z(Looper.getMainLooper());
        zVar.f();
        return zVar;
    }

    @m0
    public static <R extends t> n<R> b(@m0 R r7) {
        com.google.android.gms.common.internal.u.l(r7, "Result must not be null");
        com.google.android.gms.common.internal.u.b(r7.G().p0() == 16, "Status code must be CommonStatusCodes.CANCELED");
        e0 e0Var = new e0(r7);
        e0Var.f();
        return e0Var;
    }

    @c1.a
    @m0
    public static <R extends t> n<R> c(@m0 R r7, @m0 k kVar) {
        com.google.android.gms.common.internal.u.l(r7, "Result must not be null");
        com.google.android.gms.common.internal.u.b(!r7.G().G0(), "Status code must not be SUCCESS");
        f0 f0Var = new f0(kVar, r7);
        f0Var.o(r7);
        return f0Var;
    }

    @c1.a
    @m0
    public static <R extends t> m<R> d(@m0 R r7) {
        com.google.android.gms.common.internal.u.l(r7, "Result must not be null");
        g0 g0Var = new g0(null);
        g0Var.o(r7);
        return new com.google.android.gms.common.api.internal.r(g0Var);
    }

    @c1.a
    @m0
    public static <R extends t> m<R> e(@m0 R r7, @m0 k kVar) {
        com.google.android.gms.common.internal.u.l(r7, "Result must not be null");
        g0 g0Var = new g0(kVar);
        g0Var.o(r7);
        return new com.google.android.gms.common.api.internal.r(g0Var);
    }

    @c1.a
    @m0
    public static n<Status> f(@m0 Status status) {
        com.google.android.gms.common.internal.u.l(status, "Result must not be null");
        com.google.android.gms.common.api.internal.z zVar = new com.google.android.gms.common.api.internal.z(Looper.getMainLooper());
        zVar.o(status);
        return zVar;
    }

    @c1.a
    @m0
    public static n<Status> g(@m0 Status status, @m0 k kVar) {
        com.google.android.gms.common.internal.u.l(status, "Result must not be null");
        com.google.android.gms.common.api.internal.z zVar = new com.google.android.gms.common.api.internal.z(kVar);
        zVar.o(status);
        return zVar;
    }
}
