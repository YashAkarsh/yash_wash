package com.google.common.graph;

import com.google.common.collect.v7;
import com.google.common.collect.wb;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j(containerOf = {"N"})
public class e0<N> extends v<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i<N> f21621a;

    e0(i<N> iVar) {
        this.f21621a = iVar;
    }

    private static <N> b0<N, c0.a> I(z<N> zVar, N n7) {
        com.google.common.base.s sVarB = com.google.common.base.u.b(c0.a.EDGE_EXISTS);
        return zVar.f() ? o.q(zVar.a((Object) n7), wb.o(zVar.b((Object) n7), sVarB)) : u0.j(wb.o(zVar.j(n7), sVarB));
    }

    public static <N> e0<N> J(z<N> zVar) {
        return zVar instanceof e0 ? (e0) zVar : new e0<>(new n(a0.f(zVar), L(zVar), zVar.d().size()));
    }

    @Deprecated
    public static <N> e0<N> K(e0<N> e0Var) {
        return (e0) com.google.common.base.e0.E(e0Var);
    }

    private static <N> v7<N, b0<N, c0.a>> L(z<N> zVar) {
        v7.b bVarB = v7.b();
        for (N n7 : zVar.l()) {
            bVarB.f(n7, I(zVar, n7));
        }
        return bVarB.a();
    }

    @Override // com.google.common.graph.v
    protected i<N> H() {
        return this.f21621a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.r0
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i, com.google.common.graph.s0
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int c(Object obj) {
        return super.c(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ boolean e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // com.google.common.graph.v, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // com.google.common.graph.v, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ s g() {
        return super.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int h(Object obj) {
        return super.h(obj);
    }

    @Override // com.google.common.graph.v, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.v, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ Set j(Object obj) {
        return super.j(obj);
    }

    @Override // com.google.common.graph.v, com.google.common.graph.i, com.google.common.graph.z
    public /* bridge */ /* synthetic */ Set l() {
        return super.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.v, com.google.common.graph.c, com.google.common.graph.a, com.google.common.graph.i
    public /* bridge */ /* synthetic */ int m(Object obj) {
        return super.m(obj);
    }
}
