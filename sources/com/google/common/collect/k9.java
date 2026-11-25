package com.google.common.collect;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class k9<K, V> extends v7<K, V> {
    k9() {
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, v7<K, V>> H(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, v7<K, V>> I(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> i9.c<K, V> K() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> i9.c<K, V> L(int i7) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> i9<K, V> M(K k7, V v7) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> i9<K, V> N(K k7, V v7, K k8, V v8) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> i9<K, V> O(K k7, V v7, K k8, V v8, K k9, V v9) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> i9<K, V> P(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> i9<K, V> R(K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10, K k11, V v11) {
        throw new UnsupportedOperationException();
    }
}
