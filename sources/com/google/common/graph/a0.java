package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class a0<N> extends d<N> {
    private a0(boolean z7) {
        super(z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N> a0<N1> c() {
        return this;
    }

    public static a0<Object> d() {
        return new a0<>(true);
    }

    public static <N> a0<N> f(z<N> zVar) {
        return (a0<N>) new a0(zVar.f()).a(zVar.i()).g(zVar.g());
    }

    public static a0<Object> h() {
        return new a0<>(false);
    }

    public a0<N> a(boolean z7) {
        this.f21605b = z7;
        return this;
    }

    public <N1 extends N> k0<N1> b() {
        return new j(this);
    }

    public a0<N> e(int i7) {
        this.f21607d = com.google.common.base.a0.g(Integer.valueOf(d0.b(i7)));
        return this;
    }

    public <N1 extends N> a0<N1> g(s<N1> sVar) {
        a0<N1> a0VarC = c();
        a0VarC.f21606c = (s) com.google.common.base.e0.E(sVar);
        return a0VarC;
    }
}
