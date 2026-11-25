package com.google.common.base;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public final class u {

    private static class b<E> implements s<Object, E>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19544b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final E f19545a;

        public b(E e8) {
            this.f19545a = e8;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public E apply(Object obj) {
            return this.f19545a;
        }

        @Override // com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return y.a(this.f19545a, ((b) obj).f19545a);
            }
            return false;
        }

        public int hashCode() {
            E e8 = this.f19545a;
            if (e8 == null) {
                return 0;
            }
            return e8.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.f19545a + ")";
        }
    }

    private static class c<K, V> implements s<K, V>, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19546c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, ? extends V> f19547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final V f19548b;

        c(Map<K, ? extends V> map, V v7) {
            this.f19547a = (Map) e0.E(map);
            this.f19548b = v7;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public V apply(K k7) {
            V v7 = this.f19547a.get(k7);
            return (v7 != null || this.f19547a.containsKey(k7)) ? v7 : this.f19548b;
        }

        @Override // com.google.common.base.s
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f19547a.equals(cVar.f19547a) && y.a(this.f19548b, cVar.f19548b);
        }

        public int hashCode() {
            return y.b(this.f19547a, this.f19548b);
        }

        public String toString() {
            return "Functions.forMap(" + this.f19547a + ", defaultValue=" + this.f19548b + ")";
        }
    }

    private static class d<A, B, C> implements s<A, C>, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19549c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final s<B, C> f19550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final s<A, ? extends B> f19551b;

        public d(s<B, C> sVar, s<A, ? extends B> sVar2) {
            this.f19550a = (s) e0.E(sVar);
            this.f19551b = (s) e0.E(sVar2);
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public C apply(A a8) {
            return (C) this.f19550a.apply(this.f19551b.apply(a8));
        }

        @Override // com.google.common.base.s
        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f19551b.equals(dVar.f19551b) && this.f19550a.equals(dVar.f19550a);
        }

        public int hashCode() {
            return this.f19551b.hashCode() ^ this.f19550a.hashCode();
        }

        public String toString() {
            return this.f19550a + "(" + this.f19551b + ")";
        }
    }

    private static class e<K, V> implements s<K, V>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19552b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, V> f19553a;

        e(Map<K, V> map) {
            this.f19553a = (Map) e0.E(map);
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public V apply(K k7) {
            V v7 = this.f19553a.get(k7);
            e0.u(v7 != null || this.f19553a.containsKey(k7), "Key '%s' not present in map", k7);
            return v7;
        }

        @Override // com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.f19553a.equals(((e) obj).f19553a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19553a.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.f19553a + ")";
        }
    }

    private enum f implements s<Object, Object> {
        INSTANCE;

        @Override // com.google.common.base.s, java.util.function.Function
        public Object apply(Object obj) {
            return obj;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    private static class g<T> implements s<T, Boolean>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19556b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g0<T> f19557a;

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(T t7) {
            return Boolean.valueOf(this.f19557a.apply(t7));
        }

        @Override // com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof g) {
                return this.f19557a.equals(((g) obj).f19557a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19557a.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.f19557a + ")";
        }

        private g(g0<T> g0Var) {
            this.f19557a = (g0) e0.E(g0Var);
        }
    }

    private static class h<T> implements s<Object, T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19558b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p0<T> f19559a;

        @Override // com.google.common.base.s, java.util.function.Function
        public T apply(Object obj) {
            return this.f19559a.get();
        }

        @Override // com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof h) {
                return this.f19559a.equals(((h) obj).f19559a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19559a.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.f19559a + ")";
        }

        private h(p0<T> p0Var) {
            this.f19559a = (p0) e0.E(p0Var);
        }
    }

    private enum i implements s<Object, String> {
        INSTANCE;

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(Object obj) {
            e0.E(obj);
            return obj.toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }
    }

    private u() {
    }

    public static <A, B, C> s<A, C> a(s<B, C> sVar, s<A, ? extends B> sVar2) {
        return new d(sVar, sVar2);
    }

    public static <E> s<Object, E> b(E e8) {
        return new b(e8);
    }

    public static <K, V> s<K, V> c(Map<K, V> map) {
        return new e(map);
    }

    public static <K, V> s<K, V> d(Map<K, ? extends V> map, V v7) {
        return new c(map, v7);
    }

    public static <T> s<T, Boolean> e(g0<T> g0Var) {
        return new g(g0Var);
    }

    public static <T> s<Object, T> f(p0<T> p0Var) {
        return new h(p0Var);
    }

    public static <E> s<E, E> g() {
        return f.INSTANCE;
    }

    public static s<Object, String> h() {
        return i.INSTANCE;
    }
}
