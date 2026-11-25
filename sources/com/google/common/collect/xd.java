package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class xd<C extends Comparable> extends yd implements com.google.common.base.g0<C>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final xd<Comparable> f21412c = new xd<>(k4.c(), k4.a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21413d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final k4<C> f21414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final k4<C> f21415b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f21416a;

        static {
            int[] iArr = new int[s0.values().length];
            f21416a = iArr;
            try {
                iArr[s0.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21416a[s0.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class b implements com.google.common.base.s<xd, k4> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f21417a = new b();

        b() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k4 apply(xd xdVar) {
            return xdVar.f21414a;
        }
    }

    private static class c extends td<xd<?>> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final td<xd<?>> f21418c = new c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f21419d = 0;

        private c() {
        }

        @Override // com.google.common.collect.td, java.util.Comparator
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public int compare(xd<?> xdVar, xd<?> xdVar2) {
            return d4.n().i(xdVar.f21414a, xdVar2.f21414a).i(xdVar.f21415b, xdVar2.f21415b).m();
        }
    }

    static class d implements com.google.common.base.s<xd, k4> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f21420a = new d();

        d() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k4 apply(xd xdVar) {
            return xdVar.f21415b;
        }
    }

    private xd(k4<C> k4Var, k4<C> k4Var2) {
        this.f21414a = (k4) com.google.common.base.e0.E(k4Var);
        this.f21415b = (k4) com.google.common.base.e0.E(k4Var2);
        if (k4Var.compareTo(k4Var2) > 0 || k4Var == k4.a() || k4Var2 == k4.c()) {
            throw new IllegalArgumentException("Invalid range: " + I(k4Var, k4Var2));
        }
    }

    public static <C extends Comparable<?>> xd<C> B(C c8, C c9) {
        return l(k4.b(c8), k4.d(c9));
    }

    public static <C extends Comparable<?>> xd<C> C(C c8, C c9) {
        return l(k4.b(c8), k4.b(c9));
    }

    public static <C extends Comparable<?>> xd<C> D(C c8, s0 s0Var, C c9, s0 s0Var2) {
        com.google.common.base.e0.E(s0Var);
        com.google.common.base.e0.E(s0Var2);
        s0 s0Var3 = s0.OPEN;
        return l(s0Var == s0Var3 ? k4.b(c8) : k4.d(c8), s0Var2 == s0Var3 ? k4.d(c9) : k4.b(c9));
    }

    static <C extends Comparable<?>> td<xd<C>> E() {
        return (td<xd<C>>) c.f21418c;
    }

    public static <C extends Comparable<?>> xd<C> F(C c8) {
        return g(c8, c8);
    }

    private static String I(k4<?> k4Var, k4<?> k4Var2) {
        StringBuilder sb = new StringBuilder(16);
        k4Var.g(sb);
        sb.append("..");
        k4Var2.h(sb);
        return sb.toString();
    }

    public static <C extends Comparable<?>> xd<C> J(C c8, s0 s0Var) {
        int i7 = a.f21416a[s0Var.ordinal()];
        if (i7 == 1) {
            return x(c8);
        }
        if (i7 == 2) {
            return d(c8);
        }
        throw new AssertionError();
    }

    static <C extends Comparable<?>> com.google.common.base.s<xd<C>, k4<C>> K() {
        return d.f21420a;
    }

    public static <C extends Comparable<?>> xd<C> a() {
        return (xd<C>) f21412c;
    }

    public static <C extends Comparable<?>> xd<C> c(C c8) {
        return l(k4.d(c8), k4.a());
    }

    public static <C extends Comparable<?>> xd<C> d(C c8) {
        return l(k4.c(), k4.b(c8));
    }

    private static <T> SortedSet<T> f(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> xd<C> g(C c8, C c9) {
        return l(k4.d(c8), k4.b(c9));
    }

    public static <C extends Comparable<?>> xd<C> h(C c8, C c9) {
        return l(k4.d(c8), k4.d(c9));
    }

    static int i(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    static <C extends Comparable<?>> xd<C> l(k4<C> k4Var, k4<C> k4Var2) {
        return new xd<>(k4Var, k4Var2);
    }

    public static <C extends Comparable<?>> xd<C> m(C c8, s0 s0Var) {
        int i7 = a.f21416a[s0Var.ordinal()];
        if (i7 == 1) {
            return q(c8);
        }
        if (i7 == 2) {
            return c(c8);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> xd<C> n(Iterable<C> iterable) {
        com.google.common.base.e0.E(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSetF = f(iterable);
            Comparator comparator = sortedSetF.comparator();
            if (td.A().equals(comparator) || comparator == null) {
                return g((Comparable) sortedSetF.first(), (Comparable) sortedSetF.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) com.google.common.base.e0.E(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) com.google.common.base.e0.E(it.next());
            comparable = (Comparable) td.A().x(comparable, comparable3);
            comparable2 = (Comparable) td.A().t(comparable2, comparable3);
        }
        return g(comparable, comparable2);
    }

    public static <C extends Comparable<?>> xd<C> q(C c8) {
        return l(k4.b(c8), k4.a());
    }

    public static <C extends Comparable<?>> xd<C> x(C c8) {
        return l(k4.c(), k4.d(c8));
    }

    static <C extends Comparable<?>> com.google.common.base.s<xd<C>, k4<C>> y() {
        return b.f21417a;
    }

    public C A() {
        return (C) this.f21414a.i();
    }

    public xd<C> H(xd<C> xdVar) {
        int iF = this.f21414a.compareTo(xdVar.f21414a);
        int iF2 = this.f21415b.compareTo(xdVar.f21415b);
        if (iF <= 0 && iF2 >= 0) {
            return this;
        }
        if (iF < 0 || iF2 > 0) {
            return l(iF <= 0 ? this.f21414a : xdVar.f21414a, iF2 >= 0 ? this.f21415b : xdVar.f21415b);
        }
        return xdVar;
    }

    public s0 L() {
        return this.f21415b.n();
    }

    public C M() {
        return (C) this.f21415b.i();
    }

    @Override // com.google.common.base.g0
    @Deprecated
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean apply(C c8) {
        return j(c8);
    }

    public xd<C> e(p4<C> p4Var) {
        com.google.common.base.e0.E(p4Var);
        k4<C> k4VarE = this.f21414a.e(p4Var);
        k4<C> k4VarE2 = this.f21415b.e(p4Var);
        return (k4VarE == this.f21414a && k4VarE2 == this.f21415b) ? this : l(k4VarE, k4VarE2);
    }

    @Override // com.google.common.base.g0
    public boolean equals(Object obj) {
        if (!(obj instanceof xd)) {
            return false;
        }
        xd xdVar = (xd) obj;
        return this.f21414a.equals(xdVar.f21414a) && this.f21415b.equals(xdVar.f21415b);
    }

    public int hashCode() {
        return (this.f21414a.hashCode() * 31) + this.f21415b.hashCode();
    }

    public boolean j(C c8) {
        com.google.common.base.e0.E(c8);
        return this.f21414a.k(c8) && !this.f21415b.k(c8);
    }

    public boolean k(Iterable<? extends C> iterable) {
        if (ma.C(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSetF = f(iterable);
            Comparator comparator = sortedSetF.comparator();
            if (td.A().equals(comparator) || comparator == null) {
                return j((Comparable) sortedSetF.first()) && j((Comparable) sortedSetF.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!j(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean o(xd<C> xdVar) {
        return this.f21414a.compareTo(xdVar.f21414a) <= 0 && this.f21415b.compareTo(xdVar.f21415b) >= 0;
    }

    public xd<C> p(xd<C> xdVar) {
        boolean z7 = this.f21414a.compareTo(xdVar.f21414a) < 0;
        xd<C> xdVar2 = z7 ? this : xdVar;
        if (!z7) {
            xdVar = this;
        }
        return l(xdVar2.f21415b, xdVar.f21414a);
    }

    public boolean r() {
        return this.f21414a != k4.c();
    }

    Object readResolve() {
        return equals(f21412c) ? a() : this;
    }

    public boolean t() {
        return this.f21415b != k4.a();
    }

    @Override // com.google.common.base.g0, java.util.function.Predicate
    public /* synthetic */ boolean test(Object obj) {
        return com.google.common.base.f0.a(this, obj);
    }

    public String toString() {
        return I(this.f21414a, this.f21415b);
    }

    public xd<C> u(xd<C> xdVar) {
        int iF = this.f21414a.compareTo(xdVar.f21414a);
        int iF2 = this.f21415b.compareTo(xdVar.f21415b);
        if (iF >= 0 && iF2 <= 0) {
            return this;
        }
        if (iF > 0 || iF2 < 0) {
            return l(iF >= 0 ? this.f21414a : xdVar.f21414a, iF2 <= 0 ? this.f21415b : xdVar.f21415b);
        }
        return xdVar;
    }

    public boolean v(xd<C> xdVar) {
        return this.f21414a.compareTo(xdVar.f21415b) <= 0 && xdVar.f21414a.compareTo(this.f21415b) <= 0;
    }

    public boolean w() {
        return this.f21414a.equals(this.f21415b);
    }

    public s0 z() {
        return this.f21414a.m();
    }
}
