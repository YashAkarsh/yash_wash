package com.google.common.graph;

import com.google.common.collect.v7;
import com.google.common.collect.wb;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j(containerOf = {"N", "E"})
public final class f0<N, E> extends m<N, E> {

    static class a implements com.google.common.base.s<E, N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o0 f21623a;

        a(o0 o0Var) {
            this.f21623a = o0Var;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public N apply(E e8) {
            return this.f21623a.w(e8).l();
        }
    }

    static class b implements com.google.common.base.s<E, N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o0 f21624a;

        b(o0 o0Var) {
            this.f21624a = o0Var;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public N apply(E e8) {
            return this.f21624a.w(e8).m();
        }
    }

    static class c implements com.google.common.base.s<E, N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o0 f21625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f21626b;

        c(o0 o0Var, Object obj) {
            this.f21625a = o0Var;
            this.f21626b = obj;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public N apply(E e8) {
            return this.f21625a.w(e8).a(this.f21626b);
        }
    }

    private f0(o0<N, E> o0Var) {
        super(p0.i(o0Var), S(o0Var), R(o0Var));
    }

    private static <N, E> com.google.common.base.s<E, N> M(o0<N, E> o0Var, N n7) {
        return new c(o0Var, n7);
    }

    private static <N, E> q0<N, E> O(o0<N, E> o0Var, N n7) {
        if (!o0Var.f()) {
            Map mapO = wb.o(o0Var.k(n7), M(o0Var, n7));
            return o0Var.v() ? v0.q(mapO) : w0.n(mapO);
        }
        Map mapO2 = wb.o(o0Var.C(n7), T(o0Var));
        Map mapO3 = wb.o(o0Var.s(n7), U(o0Var));
        int size = o0Var.u(n7, n7).size();
        return o0Var.v() ? p.q(mapO2, mapO3, size) : q.o(mapO2, mapO3, size);
    }

    @Deprecated
    public static <N, E> f0<N, E> P(f0<N, E> f0Var) {
        return (f0) com.google.common.base.e0.E(f0Var);
    }

    public static <N, E> f0<N, E> Q(o0<N, E> o0Var) {
        return o0Var instanceof f0 ? (f0) o0Var : new f0<>(o0Var);
    }

    private static <N, E> Map<E, N> R(o0<N, E> o0Var) {
        v7.b bVarB = v7.b();
        for (E e8 : o0Var.d()) {
            bVarB.f(e8, o0Var.w(e8).f());
        }
        return bVarB.a();
    }

    private static <N, E> Map<N, q0<N, E>> S(o0<N, E> o0Var) {
        v7.b bVarB = v7.b();
        for (N n7 : o0Var.l()) {
            bVarB.f(n7, O(o0Var, n7));
        }
        return bVarB.a();
    }

    private static <N, E> com.google.common.base.s<E, N> T(o0<N, E> o0Var) {
        return new a(o0Var);
    }

    private static <N, E> com.google.common.base.s<E, N> U(o0<N, E> o0Var) {
        return new b(o0Var);
    }

    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ s A() {
        return super.A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ Set C(Object obj) {
        return super.C(obj);
    }

    @Override // com.google.common.graph.e, com.google.common.graph.o0
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public e0<N> q() {
        return new e0<>(super.q());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.r0
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.e, com.google.common.graph.o0, com.google.common.graph.s0
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }

    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ s g() {
        return super.g();
    }

    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ Set j(Object obj) {
        return super.j(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ Set k(Object obj) {
        return super.k(obj);
    }

    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ Set l() {
        return super.l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ Set s(Object obj) {
        return super.s(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.e, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ Set u(Object obj, Object obj2) {
        return super.u(obj, obj2);
    }

    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ boolean v() {
        return super.v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.m, com.google.common.graph.o0
    public /* bridge */ /* synthetic */ t w(Object obj) {
        return super.w(obj);
    }
}
