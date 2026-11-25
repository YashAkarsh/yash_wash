package com.google.android.gms.common.internal;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final z0 f15806a = new v0();

    @c1.a
    public interface a<R extends com.google.android.gms.common.api.t, T> {
        @c.o0
        @c1.a
        T a(@c.m0 R r7);
    }

    @c1.a
    @c.m0
    public static <R extends com.google.android.gms.common.api.t, T extends com.google.android.gms.common.api.s<R>> com.google.android.gms.tasks.m<T> a(@c.m0 com.google.android.gms.common.api.n<R> nVar, @c.m0 T t7) {
        return b(nVar, new x0(t7));
    }

    @c1.a
    @c.m0
    public static <R extends com.google.android.gms.common.api.t, T> com.google.android.gms.tasks.m<T> b(@c.m0 com.google.android.gms.common.api.n<R> nVar, @c.m0 a<R, T> aVar) {
        z0 z0Var = f15806a;
        com.google.android.gms.tasks.n nVar2 = new com.google.android.gms.tasks.n();
        nVar.c(new w0(nVar, nVar2, aVar, z0Var));
        return nVar2.a();
    }

    @c1.a
    @c.m0
    public static <R extends com.google.android.gms.common.api.t> com.google.android.gms.tasks.m<Void> c(@c.m0 com.google.android.gms.common.api.n<R> nVar) {
        return b(nVar, new y0());
    }
}
