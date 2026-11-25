package com.google.common.base;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public final class q0 {

    @s1.d
    static class a<T> implements p0<T>, Serializable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f19513e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final p0<T> f19514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f19515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile transient T f19516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile transient long f19517d;

        a(p0<T> p0Var, long j7, TimeUnit timeUnit) {
            this.f19514a = (p0) e0.E(p0Var);
            this.f19515b = timeUnit.toNanos(j7);
            e0.t(j7 > 0, "duration (%s %s) must be > 0", j7, timeUnit);
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        public T get() {
            long j7 = this.f19517d;
            long jK = d0.k();
            if (j7 == 0 || jK - j7 >= 0) {
                synchronized (this) {
                    if (j7 == this.f19517d) {
                        T t7 = this.f19514a.get();
                        this.f19516c = t7;
                        long j8 = jK + this.f19515b;
                        if (j8 == 0) {
                            j8 = 1;
                        }
                        this.f19517d = j8;
                        return t7;
                    }
                }
            }
            return this.f19516c;
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.f19514a + ", " + this.f19515b + ", NANOS)";
        }
    }

    @s1.d
    static class b<T> implements p0<T>, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f19518d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final p0<T> f19519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile transient boolean f19520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient T f19521c;

        b(p0<T> p0Var) {
            this.f19519a = (p0) e0.E(p0Var);
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        public T get() {
            if (!this.f19520b) {
                synchronized (this) {
                    if (!this.f19520b) {
                        T t7 = this.f19519a.get();
                        this.f19521c = t7;
                        this.f19520b = true;
                        return t7;
                    }
                }
            }
            return this.f19521c;
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.f19520b) {
                obj = "<supplier that returned " + this.f19521c + ">";
            } else {
                obj = this.f19519a;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    @s1.d
    static class c<T> implements p0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile p0<T> f19522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile boolean f19523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f19524c;

        c(p0<T> p0Var) {
            this.f19522a = (p0) e0.E(p0Var);
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        public T get() {
            if (!this.f19523b) {
                synchronized (this) {
                    if (!this.f19523b) {
                        T t7 = this.f19522a.get();
                        this.f19524c = t7;
                        this.f19523b = true;
                        this.f19522a = null;
                        return t7;
                    }
                }
            }
            return this.f19524c;
        }

        public String toString() {
            Object obj = this.f19522a;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (obj == null) {
                obj = "<supplier that returned " + this.f19524c + ">";
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    private static class d<F, T> implements p0<T>, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19525c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final s<? super F, T> f19526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final p0<F> f19527b;

        d(s<? super F, T> sVar, p0<F> p0Var) {
            this.f19526a = (s) e0.E(sVar);
            this.f19527b = (p0) e0.E(p0Var);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f19526a.equals(dVar.f19526a) && this.f19527b.equals(dVar.f19527b);
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        public T get() {
            return this.f19526a.apply(this.f19527b.get());
        }

        public int hashCode() {
            return y.b(this.f19526a, this.f19527b);
        }

        public String toString() {
            return "Suppliers.compose(" + this.f19526a + ", " + this.f19527b + ")";
        }
    }

    private interface e<T> extends s<p0<T>, T> {
    }

    private enum f implements e<Object> {
        INSTANCE;

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(p0<Object> p0Var) {
            return p0Var.get();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }
    }

    private static class g<T> implements p0<T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19530b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T f19531a;

        g(T t7) {
            this.f19531a = t7;
        }

        public boolean equals(Object obj) {
            if (obj instanceof g) {
                return y.a(this.f19531a, ((g) obj).f19531a);
            }
            return false;
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        public T get() {
            return this.f19531a;
        }

        public int hashCode() {
            return y.b(this.f19531a);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.f19531a + ")";
        }
    }

    private static class h<T> implements p0<T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19532b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final p0<T> f19533a;

        h(p0<T> p0Var) {
            this.f19533a = (p0) e0.E(p0Var);
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        public T get() {
            T t7;
            synchronized (this.f19533a) {
                t7 = this.f19533a.get();
            }
            return t7;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.f19533a + ")";
        }
    }

    private q0() {
    }

    public static <F, T> p0<T> a(s<? super F, T> sVar, p0<F> p0Var) {
        return new d(sVar, p0Var);
    }

    public static <T> p0<T> b(p0<T> p0Var) {
        if ((p0Var instanceof c) || (p0Var instanceof b)) {
            return p0Var;
        }
        return p0Var instanceof Serializable ? new b(p0Var) : new c(p0Var);
    }

    public static <T> p0<T> c(p0<T> p0Var, long j7, TimeUnit timeUnit) {
        return new a(p0Var, j7, timeUnit);
    }

    public static <T> p0<T> d(T t7) {
        return new g(t7);
    }

    public static <T> s<p0<T>, T> e() {
        return f.INSTANCE;
    }

    public static <T> p0<T> f(p0<T> p0Var) {
        return new h(p0Var);
    }
}
