package com.google.common.collect;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class v6<K, V> extends v7<K, V> {
    v6() {
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, v7<K, V>> H(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, v7<K, V>> I(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        throw new UnsupportedOperationException();
    }
}
