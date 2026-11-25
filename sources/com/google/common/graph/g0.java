package com.google.common.graph;

import com.google.common.collect.v7;
import com.google.common.collect.wb;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j(containerOf = {"N", "V"})
public final class g0<N, V> extends n<N, V> {

    static class a implements com.google.common.base.s<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y0 f21629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f21630b;

        a(y0 y0Var, Object obj) {
            this.f21629a = y0Var;
            this.f21630b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.s, java.util.function.Function
        public V apply(N n7) {
            return (V) this.f21629a.y(this.f21630b, n7, null);
        }
    }

    private g0(y0<N, V> y0Var) {
        super(z0.f(y0Var), O(y0Var), y0Var.d().size());
    }

    private static <N, V> b0<N, V> L(y0<N, V> y0Var, N n7) {
        a aVar = new a(y0Var, n7);
        return y0Var.f() ? o.q(y0Var.a((Object) n7), wb.o(y0Var.b((Object) n7), aVar)) : u0.j(wb.o(y0Var.j(n7), aVar));
    }

    @Deprecated
    public static <N, V> g0<N, V> M(g0<N, V> g0Var) {
        return (g0) com.google.common.base.e0.E(g0Var);
    }

    public static <N, V> g0<N, V> N(y0<N, V> y0Var) {
        return y0Var instanceof g0 ? (g0) y0Var : new g0<>(y0Var);
    }

    private static <N, V> v7<N, b0<N, V>> O(y0<N, V> y0Var) {
        v7.b bVarB = v7.b();
        for (N n7 : y0Var.l()) {
            bVarB.f(n7, L(y0Var, n7));
        }
        return bVarB.a();
    }

    @Override // com.google.common.graph.g, com.google.common.graph.y0
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public e0<N> q() {
        return new e0<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.g, com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // com.google.common.graph.n, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // com.google.common.graph.n, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ s g() {
        return super.g();
    }

    @Override // com.google.common.graph.n, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ Set j(Object obj) {
        return super.j(obj);
    }

    @Override // com.google.common.graph.n, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ Set l() {
        return super.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.y0
    public /* bridge */ /* synthetic */ Object y(Object obj, Object obj2, Object obj3) {
        return super.y(obj, obj2, obj3);
    }
}
