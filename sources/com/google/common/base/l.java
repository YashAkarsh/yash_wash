package com.google.common.base;

import java.io.Serializable;
import java.util.function.BiPredicate;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public abstract class l<T> implements BiPredicate<T, T> {

    static final class b extends l<Object> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f19464a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19465b = 1;

        b() {
        }

        private Object readResolve() {
            return f19464a;
        }

        @Override // com.google.common.base.l
        protected boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.l
        protected int b(Object obj) {
            return obj.hashCode();
        }
    }

    private static final class c<T> implements g0<T>, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19466c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l<T> f19467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f19468b;

        c(l<T> lVar, T t7) {
            this.f19467a = (l) e0.E(lVar);
            this.f19468b = t7;
        }

        @Override // com.google.common.base.g0
        public boolean apply(T t7) {
            return this.f19467a.d(t7, this.f19468b);
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f19467a.equals(cVar.f19467a) && y.a(this.f19468b, cVar.f19468b);
        }

        public int hashCode() {
            return y.b(this.f19467a, this.f19468b);
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return this.f19467a + ".equivalentTo(" + this.f19468b + ")";
        }
    }

    static final class d extends l<Object> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f19469a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19470b = 1;

        d() {
        }

        private Object readResolve() {
            return f19469a;
        }

        @Override // com.google.common.base.l
        protected boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.l
        protected int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public static final class e<T> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19471c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l<? super T> f19472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f19473b;

        public T a() {
            return this.f19473b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f19472a.equals(eVar.f19472a)) {
                return this.f19472a.d(this.f19473b, eVar.f19473b);
            }
            return false;
        }

        public int hashCode() {
            return this.f19472a.f(this.f19473b);
        }

        public String toString() {
            return this.f19472a + ".wrap(" + this.f19473b + ")";
        }

        private e(l<? super T> lVar, T t7) {
            this.f19472a = (l) e0.E(lVar);
            this.f19473b = t7;
        }
    }

    protected l() {
    }

    public static l<Object> c() {
        return b.f19464a;
    }

    public static l<Object> g() {
        return d.f19469a;
    }

    @u1.g
    protected abstract boolean a(T t7, T t8);

    @u1.g
    protected abstract int b(T t7);

    public final boolean d(T t7, T t8) {
        if (t7 == t8) {
            return true;
        }
        if (t7 == null || t8 == null) {
            return false;
        }
        return a(t7, t8);
    }

    public final g0<T> e(T t7) {
        return new c(this, t7);
    }

    public final int f(T t7) {
        if (t7 == null) {
            return 0;
        }
        return b(t7);
    }

    public final <F> l<F> h(s<F, ? extends T> sVar) {
        return new t(sVar, this);
    }

    @s1.b(serializable = true)
    public final <S extends T> l<Iterable<S>> i() {
        return new b0(this);
    }

    public final <S extends T> e<S> j(S s7) {
        return new e<>(s7);
    }

    @Override // java.util.function.BiPredicate
    @Deprecated
    public final boolean test(T t7, T t8) {
        return d(t7, t8);
    }
}
