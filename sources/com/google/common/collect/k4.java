package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class k4<C extends Comparable> implements Comparable<k4<C>>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f20534b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C f20535a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20536a;

        static {
            int[] iArr = new int[s0.values().length];
            f20536a = iArr;
            try {
                iArr[s0.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20536a[s0.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static final class b extends k4<Comparable<?>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final b f20537c = new b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20538d = 0;

        private b() {
            super(null);
        }

        private Object readResolve() {
            return f20537c;
        }

        @Override // com.google.common.collect.k4, java.lang.Comparable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(k4<Comparable<?>> k4Var) {
            return k4Var == this ? 0 : 1;
        }

        @Override // com.google.common.collect.k4
        void g(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.k4
        void h(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.k4
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.k4
        Comparable<?> i() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.k4
        Comparable<?> j(p4<Comparable<?>> p4Var) {
            return p4Var.e();
        }

        @Override // com.google.common.collect.k4
        boolean k(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.k4
        Comparable<?> l(p4<Comparable<?>> p4Var) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.k4
        s0 m() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.k4
        s0 n() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.k4
        k4<Comparable<?>> o(s0 s0Var, p4<Comparable<?>> p4Var) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.k4
        k4<Comparable<?>> p(s0 s0Var, p4<Comparable<?>> p4Var) {
            throw new IllegalStateException();
        }

        public String toString() {
            return "+∞";
        }
    }

    private static final class c<C extends Comparable> extends k4<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20539c = 0;

        c(C c8) {
            super((Comparable) com.google.common.base.e0.E(c8));
        }

        @Override // com.google.common.collect.k4, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((k4) obj);
        }

        @Override // com.google.common.collect.k4
        k4<C> e(p4<C> p4Var) {
            Comparable comparableL = l(p4Var);
            return comparableL != null ? k4.d(comparableL) : k4.a();
        }

        @Override // com.google.common.collect.k4
        void g(StringBuilder sb) {
            sb.append('(');
            sb.append(this.f20535a);
        }

        @Override // com.google.common.collect.k4
        void h(StringBuilder sb) {
            sb.append(this.f20535a);
            sb.append(']');
        }

        @Override // com.google.common.collect.k4
        public int hashCode() {
            return ~this.f20535a.hashCode();
        }

        @Override // com.google.common.collect.k4
        C j(p4<C> p4Var) {
            return this.f20535a;
        }

        @Override // com.google.common.collect.k4
        boolean k(C c8) {
            return xd.i(this.f20535a, c8) < 0;
        }

        @Override // com.google.common.collect.k4
        C l(p4<C> p4Var) {
            return (C) p4Var.g(this.f20535a);
        }

        @Override // com.google.common.collect.k4
        s0 m() {
            return s0.OPEN;
        }

        @Override // com.google.common.collect.k4
        s0 n() {
            return s0.CLOSED;
        }

        @Override // com.google.common.collect.k4
        k4<C> o(s0 s0Var, p4<C> p4Var) {
            int i7 = a.f20536a[s0Var.ordinal()];
            if (i7 == 1) {
                Comparable comparableG = p4Var.g(this.f20535a);
                return comparableG == null ? k4.c() : k4.d(comparableG);
            }
            if (i7 == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // com.google.common.collect.k4
        k4<C> p(s0 s0Var, p4<C> p4Var) {
            int i7 = a.f20536a[s0Var.ordinal()];
            if (i7 == 1) {
                return this;
            }
            if (i7 != 2) {
                throw new AssertionError();
            }
            Comparable comparableG = p4Var.g(this.f20535a);
            return comparableG == null ? k4.a() : k4.d(comparableG);
        }

        public String toString() {
            return "/" + this.f20535a + "\\";
        }
    }

    private static final class d extends k4<Comparable<?>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final d f20540c = new d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20541d = 0;

        private d() {
            super(null);
        }

        private Object readResolve() {
            return f20540c;
        }

        @Override // com.google.common.collect.k4
        k4<Comparable<?>> e(p4<Comparable<?>> p4Var) {
            try {
                return k4.d(p4Var.f());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.common.collect.k4, java.lang.Comparable
        /* JADX INFO: renamed from: f */
        public int compareTo(k4<Comparable<?>> k4Var) {
            return k4Var == this ? 0 : -1;
        }

        @Override // com.google.common.collect.k4
        void g(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.k4
        void h(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.k4
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.k4
        Comparable<?> i() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.k4
        Comparable<?> j(p4<Comparable<?>> p4Var) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.k4
        boolean k(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.k4
        Comparable<?> l(p4<Comparable<?>> p4Var) {
            return p4Var.f();
        }

        @Override // com.google.common.collect.k4
        s0 m() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.k4
        s0 n() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.k4
        k4<Comparable<?>> o(s0 s0Var, p4<Comparable<?>> p4Var) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.k4
        k4<Comparable<?>> p(s0 s0Var, p4<Comparable<?>> p4Var) {
            throw new AssertionError("this statement should be unreachable");
        }

        public String toString() {
            return "-∞";
        }
    }

    private static final class e<C extends Comparable> extends k4<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20542c = 0;

        e(C c8) {
            super((Comparable) com.google.common.base.e0.E(c8));
        }

        @Override // com.google.common.collect.k4, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((k4) obj);
        }

        @Override // com.google.common.collect.k4
        void g(StringBuilder sb) {
            sb.append('[');
            sb.append(this.f20535a);
        }

        @Override // com.google.common.collect.k4
        void h(StringBuilder sb) {
            sb.append(this.f20535a);
            sb.append(')');
        }

        @Override // com.google.common.collect.k4
        public int hashCode() {
            return this.f20535a.hashCode();
        }

        @Override // com.google.common.collect.k4
        C j(p4<C> p4Var) {
            return (C) p4Var.i(this.f20535a);
        }

        @Override // com.google.common.collect.k4
        boolean k(C c8) {
            return xd.i(this.f20535a, c8) <= 0;
        }

        @Override // com.google.common.collect.k4
        C l(p4<C> p4Var) {
            return this.f20535a;
        }

        @Override // com.google.common.collect.k4
        s0 m() {
            return s0.CLOSED;
        }

        @Override // com.google.common.collect.k4
        s0 n() {
            return s0.OPEN;
        }

        @Override // com.google.common.collect.k4
        k4<C> o(s0 s0Var, p4<C> p4Var) {
            int i7 = a.f20536a[s0Var.ordinal()];
            if (i7 == 1) {
                return this;
            }
            if (i7 != 2) {
                throw new AssertionError();
            }
            Comparable comparableI = p4Var.i(this.f20535a);
            return comparableI == null ? k4.c() : new c(comparableI);
        }

        @Override // com.google.common.collect.k4
        k4<C> p(s0 s0Var, p4<C> p4Var) {
            int i7 = a.f20536a[s0Var.ordinal()];
            if (i7 == 1) {
                Comparable comparableI = p4Var.i(this.f20535a);
                return comparableI == null ? k4.a() : new c(comparableI);
            }
            if (i7 == 2) {
                return this;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "\\" + this.f20535a + "/";
        }
    }

    k4(C c8) {
        this.f20535a = c8;
    }

    static <C extends Comparable> k4<C> a() {
        return b.f20537c;
    }

    static <C extends Comparable> k4<C> b(C c8) {
        return new c(c8);
    }

    static <C extends Comparable> k4<C> c() {
        return d.f20540c;
    }

    static <C extends Comparable> k4<C> d(C c8) {
        return new e(c8);
    }

    k4<C> e(p4<C> p4Var) {
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k4)) {
            return false;
        }
        try {
            return compareTo((k4) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f */
    public int compareTo(k4<C> k4Var) {
        if (k4Var == c()) {
            return 1;
        }
        if (k4Var == a()) {
            return -1;
        }
        int i7 = xd.i(this.f20535a, k4Var.f20535a);
        return i7 != 0 ? i7 : com.google.common.primitives.a.d(this instanceof c, k4Var instanceof c);
    }

    abstract void g(StringBuilder sb);

    abstract void h(StringBuilder sb);

    public abstract int hashCode();

    C i() {
        return this.f20535a;
    }

    abstract C j(p4<C> p4Var);

    abstract boolean k(C c8);

    abstract C l(p4<C> p4Var);

    abstract s0 m();

    abstract s0 n();

    abstract k4<C> o(s0 s0Var, p4<C> p4Var);

    abstract k4<C> p(s0 s0Var, p4<C> p4Var);
}
