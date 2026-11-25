package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface mb<K, V> {

    public interface a<V> {
        V a();

        V b();

        boolean equals(Object obj);

        int hashCode();
    }

    Map<K, V> a();

    Map<K, a<V>> b();

    Map<K, V> c();

    Map<K, V> d();

    boolean e();

    boolean equals(Object obj);

    int hashCode();
}
