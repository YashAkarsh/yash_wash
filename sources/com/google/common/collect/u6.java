package com.google.common.collect;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public abstract class u6<K, V> extends v6<K, V> implements r0<K, V> {

    public static final class a<K, V> extends v7.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.v7.b
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public u6<K, V> a() {
            int i7 = this.f21273c;
            if (i7 == 0) {
                return u6.R();
            }
            if (i7 == 1) {
                return u6.S(this.f21272b[0].getKey(), this.f21272b[0].getValue());
            }
            if (this.f21271a != null) {
                if (this.f21274d) {
                    this.f21272b = (Map.Entry[]) Arrays.copyOf(this.f21272b, i7);
                }
                Arrays.sort(this.f21272b, 0, this.f21273c, td.i(this.f21271a).E(wb.Z0()));
            }
            this.f21274d = true;
            return ee.h0(this.f21273c, this.f21272b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v7.b
        @s1.d
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public u6<K, V> b() {
            com.google.common.base.e0.h0(this.f21271a == null, "buildJdkBacked is for tests only, doesn't support orderEntriesByValue");
            int i7 = this.f21273c;
            if (i7 == 0) {
                return u6.R();
            }
            if (i7 == 1) {
                return u6.S(this.f21272b[0].getKey(), this.f21272b[0].getValue());
            }
            this.f21274d = true;
            return ee.h0(i7, this.f21272b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v7.b
        @u1.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public a<K, V> c(v7.b<K, V> bVar) {
            super.c(bVar);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @s1.a
        @u1.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<K, V> e(Comparator<? super V> comparator) {
            super.e(comparator);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @u1.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public a<K, V> f(K k7, V v7) {
            super.f(k7, v7);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @u1.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @s1.a
        @u1.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.h(iterable);
            return this;
        }

        @Override // com.google.common.collect.v7.b
        @u1.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<K, V> i(Map<? extends K, ? extends V> map) {
            super.i(map);
            return this;
        }

        a(int i7) {
            super(i7);
        }
    }

    private static class b extends v7.e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f21170d = 0;

        b(u6<?, ?> u6Var) {
            super(u6Var);
        }

        @Override // com.google.common.collect.v7.e
        Object readResolve() {
            return a(new a());
        }
    }

    u6() {
    }

    public static <K, V> a<K, V> K() {
        return new a<>();
    }

    @s1.a
    public static <K, V> a<K, V> L(int i7) {
        f2.b(i7, "expectedSize");
        return new a<>(i7);
    }

    @s1.a
    public static <K, V> u6<K, V> M(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) ma.P(iterable, v7.f21264e);
        int length = entryArr.length;
        if (length == 0) {
            return R();
        }
        if (length != 1) {
            return ee.g0(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return S(entry.getKey(), entry.getValue());
    }

    public static <K, V> u6<K, V> N(Map<? extends K, ? extends V> map) {
        if (map instanceof u6) {
            u6<K, V> u6Var = (u6) map;
            if (!u6Var.r()) {
                return u6Var;
            }
        }
        return M(map.entrySet());
    }

    public static <K, V> u6<K, V> R() {
        return ee.f20205l;
    }

    public static <K, V> u6<K, V> S(K k7, V v7) {
        return new mf(k7, v7);
    }

    public static <K, V> u6<K, V> W(K k7, V v7, K k8, V v8) {
        return ee.g0(v7.n(k7, v7), v7.n(k8, v8));
    }

    public static <K, V> u6<K, V> X(K k7, V v7, K k8, V v8, K k9, V v9) {
        return ee.g0(v7.n(k7, v7), v7.n(k8, v8), v7.n(k9, v9));
    }

    public static <K, V> u6<K, V> Y(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        return ee.g0(v7.n(k7, v7), v7.n(k8, v8), v7.n(k9, v9), v7.n(k10, v10));
    }

    public static <K, V> u6<K, V> Z(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        return ee.g0(v7.n(k7, v7), v7.n(k8, v8), v7.n(k9, v9), v7.n(k10, v10), v7.n(k11, v11));
    }

    @s1.a
    public static <T, K, V> Collector<T, ?, u6<K, V>> a0(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return e2.m(function, function2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.v7
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final u8<V> m() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.r0
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public abstract u6<V, K> T();

    @Override // com.google.common.collect.v7, java.util.Map, java.util.SortedMap
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public u8<V> values() {
        return T().keySet();
    }

    @Override // com.google.common.collect.v7
    Object writeReplace() {
        return new b(this);
    }

    @Override // com.google.common.collect.r0
    @u1.a
    @Deprecated
    public V x(K k7, V v7) {
        throw new UnsupportedOperationException();
    }
}
