package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class z0<N, V> extends d<N> {
    private z0(boolean z7) {
        super(z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, V1 extends V> z0<N1, V1> c() {
        return this;
    }

    public static z0<Object, Object> d() {
        return new z0<>(true);
    }

    public static <N, V> z0<N, V> f(y0<N, V> y0Var) {
        return (z0<N, V>) new z0(y0Var.f()).a(y0Var.i()).g(y0Var.g());
    }

    public static z0<Object, Object> h() {
        return new z0<>(false);
    }

    public z0<N, V> a(boolean z7) {
        this.f21605b = z7;
        return this;
    }

    public <N1 extends N, V1 extends V> m0<N1, V1> b() {
        return new l(this);
    }

    public z0<N, V> e(int i7) {
        this.f21607d = com.google.common.base.a0.g(Integer.valueOf(d0.b(i7)));
        return this;
    }

    public <N1 extends N> z0<N1, V> g(s<N1> sVar) {
        z0<N1, V> z0Var = (z0<N1, V>) c();
        z0Var.f21606c = (s) com.google.common.base.e0.E(sVar);
        return z0Var;
    }
}
