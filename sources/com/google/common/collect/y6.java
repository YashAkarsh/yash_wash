package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
class y6<K, V> extends v<K, V> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f21444c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final K f21445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final V f21446b;

    y6(K k7, V v7) {
        this.f21445a = k7;
        this.f21446b = v7;
    }

    @Override // com.google.common.collect.v, java.util.Map.Entry
    public final K getKey() {
        return this.f21445a;
    }

    @Override // com.google.common.collect.v, java.util.Map.Entry
    public final V getValue() {
        return this.f21446b;
    }

    @Override // com.google.common.collect.v, java.util.Map.Entry
    public final V setValue(V v7) {
        throw new UnsupportedOperationException();
    }
}
