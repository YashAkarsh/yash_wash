package com.google.common.collect;

import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public abstract class i4<C extends Comparable> extends s9<C> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final p4<C> f20402m;

    i4(p4<C> p4Var) {
        super(td.A());
        this.f20402m = p4Var;
    }

    @Deprecated
    public static <E> s9.b<E> M() {
        throw new UnsupportedOperationException();
    }

    @s1.a
    public static i4<Integer> M0(int i7, int i8) {
        return Q0(xd.g(Integer.valueOf(i7), Integer.valueOf(i8)), p4.c());
    }

    @s1.a
    public static i4<Long> N0(long j7, long j8) {
        return Q0(xd.g(Long.valueOf(j7), Long.valueOf(j8)), p4.d());
    }

    @s1.a
    public static i4<Integer> O0(int i7, int i8) {
        return Q0(xd.h(Integer.valueOf(i7), Integer.valueOf(i8)), p4.c());
    }

    @s1.a
    public static i4<Long> P0(long j7, long j8) {
        return Q0(xd.h(Long.valueOf(j7), Long.valueOf(j8)), p4.d());
    }

    public static <C extends Comparable> i4<C> Q0(xd<C> xdVar, p4<C> p4Var) {
        com.google.common.base.e0.E(xdVar);
        com.google.common.base.e0.E(p4Var);
        try {
            xd<C> xdVarU = !xdVar.r() ? xdVar.u(xd.c(p4Var.f())) : xdVar;
            if (!xdVar.t()) {
                xdVarU = xdVarU.u(xd.d(p4Var.e()));
            }
            return xdVarU.w() || xd.i(xdVar.f21414a.l(p4Var), xdVar.f21415b.j(p4Var)) > 0 ? new q4(p4Var) : new ce(xdVarU, p4Var);
        } catch (NoSuchElementException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    @Override // com.google.common.collect.s9
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public i4<C> headSet(C c8) {
        return q0((Comparable) com.google.common.base.e0.E(c8), false);
    }

    @Override // com.google.common.collect.s9
    @s1.c
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public i4<C> headSet(C c8, boolean z7) {
        return q0((Comparable) com.google.common.base.e0.E(c8), z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.s9
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public abstract i4<C> q0(C c8, boolean z7);

    public abstract i4<C> U0(i4<C> i4Var);

    public abstract xd<C> V0();

    public abstract xd<C> W0(s0 s0Var, s0 s0Var2);

    @Override // com.google.common.collect.s9, java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public i4<C> subSet(C c8, C c9) {
        com.google.common.base.e0.E(c8);
        com.google.common.base.e0.E(c9);
        com.google.common.base.e0.d(comparator().compare(c8, c9) <= 0);
        return F0(c8, true, c9, false);
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public i4<C> subSet(C c8, boolean z7, C c9, boolean z8) {
        com.google.common.base.e0.E(c8);
        com.google.common.base.e0.E(c9);
        com.google.common.base.e0.d(comparator().compare(c8, c9) <= 0);
        return F0(c8, z7, c9, z8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.s9
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public abstract i4<C> F0(C c8, boolean z7, C c9, boolean z8);

    @Override // com.google.common.collect.s9, java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public i4<C> tailSet(C c8) {
        return I0((Comparable) com.google.common.base.e0.E(c8), true);
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public i4<C> tailSet(C c8, boolean z7) {
        return I0((Comparable) com.google.common.base.e0.E(c8), z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.s9
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public abstract i4<C> I0(C c8, boolean z7);

    @Override // com.google.common.collect.s9
    @s1.c
    s9<C> i0() {
        return new n4(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return V0().toString();
    }
}
