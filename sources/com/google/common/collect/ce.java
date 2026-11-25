package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class ce<C extends Comparable> extends i4<C> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f20088o = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final xd<C> f20089n;

    class a extends b0<C> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final C f20090b;

        a(Comparable comparable) {
            super(comparable);
            this.f20090b = (C) ce.this.last();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.b0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C a(C c8) {
            if (ce.e1(c8, this.f20090b)) {
                return null;
            }
            return (C) ce.this.f20402m.g(c8);
        }
    }

    class b extends b0<C> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final C f20092b;

        b(Comparable comparable) {
            super(comparable);
            this.f20092b = (C) ce.this.first();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.b0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C a(C c8) {
            if (ce.e1(c8, this.f20092b)) {
                return null;
            }
            return (C) ce.this.f20402m.i(c8);
        }
    }

    class c extends t6<C> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.t6
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
        public s9<C> W() {
            return ce.this;
        }

        @Override // java.util.List
        /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
        public C get(int i7) {
            com.google.common.base.e0.C(i7, size());
            ce ceVar = ce.this;
            return (C) ceVar.f20402m.h(ceVar.first(), i7);
        }
    }

    @s1.c
    private static final class d<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final xd<C> f20095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final p4<C> f20096b;

        /* synthetic */ d(xd xdVar, p4 p4Var, a aVar) {
            this(xdVar, p4Var);
        }

        private Object readResolve() {
            return new ce(this.f20095a, this.f20096b);
        }

        private d(xd<C> xdVar, p4<C> p4Var) {
            this.f20095a = xdVar;
            this.f20096b = p4Var;
        }
    }

    ce(xd<C> xdVar, p4<C> p4Var) {
        super(p4Var);
        this.f20089n = xdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e1(Comparable<?> comparable, Comparable<?> comparable2) {
        return comparable2 != null && xd.i(comparable, comparable2) == 0;
    }

    private i4<C> g1(xd<C> xdVar) {
        return this.f20089n.v(xdVar) ? i4.Q0(this.f20089n.u(xdVar), this.f20402m) : new q4(this.f20402m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i4, com.google.common.collect.s9
    /* JADX INFO: renamed from: T0 */
    public i4<C> q0(C c8, boolean z7) {
        return g1(xd.J(c8, s0.b(z7)));
    }

    @Override // com.google.common.collect.i4
    public i4<C> U0(i4<C> i4Var) {
        com.google.common.base.e0.E(i4Var);
        com.google.common.base.e0.d(this.f20402m.equals(i4Var.f20402m));
        if (i4Var.isEmpty()) {
            return i4Var;
        }
        Comparable comparable = (Comparable) td.A().t(first(), i4Var.first());
        Comparable comparable2 = (Comparable) td.A().x(last(), i4Var.last());
        return comparable.compareTo(comparable2) <= 0 ? i4.Q0(xd.g(comparable, comparable2), this.f20402m) : new q4(this.f20402m);
    }

    @Override // com.google.common.collect.i4
    public xd<C> V0() {
        s0 s0Var = s0.CLOSED;
        return W0(s0Var, s0Var);
    }

    @Override // com.google.common.collect.i4
    public xd<C> W0(s0 s0Var, s0 s0Var2) {
        return xd.l(this.f20089n.f21414a.o(s0Var, this.f20402m), this.f20089n.f21415b.p(s0Var2, this.f20402m));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i4, com.google.common.collect.s9
    /* JADX INFO: renamed from: Z0 */
    public i4<C> F0(C c8, boolean z7, C c9, boolean z8) {
        return (c8.compareTo(c9) != 0 || z7 || z8) ? g1(xd.D(c8, s0.b(z7), c9, s0.b(z8))) : new q4(this.f20402m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i4, com.google.common.collect.s9
    /* JADX INFO: renamed from: c1 */
    public i4<C> I0(C c8, boolean z7) {
        return g1(xd.m(c8, s0.b(z7)));
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f20089n.j((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return h3.c(this, collection);
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ce) {
            ce ceVar = (ce) obj;
            if (this.f20402m.equals(ceVar.f20402m)) {
                return first().equals(ceVar.first()) && last().equals(ceVar.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.s9, java.util.SortedSet
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public C first() {
        return (C) this.f20089n.f21414a.l(this.f20402m);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.s9, java.util.SortedSet
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public C last() {
        return (C) this.f20089n.f21415b.j(this.f20402m);
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public int hashCode() {
        return af.k(this);
    }

    @Override // com.google.common.collect.s9
    @s1.c
    int indexOf(Object obj) {
        if (contains(obj)) {
            return (int) this.f20402m.b(first(), (Comparable) obj);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<C> iterator() {
        return new a(first());
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: j0 */
    public ck<C> descendingIterator() {
        return new b(last());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long jB = this.f20402m.b(first(), last());
        if (jB >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) jB) + 1;
    }

    @Override // com.google.common.collect.u8
    d7<C> v() {
        return this.f20402m.f20870a ? new c() : super.v();
    }

    @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6
    @s1.c
    Object writeReplace() {
        return new d(this.f20089n, this.f20402m, null);
    }
}
