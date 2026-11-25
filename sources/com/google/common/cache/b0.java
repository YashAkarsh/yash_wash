package com.google.common.cache;

import java.util.AbstractMap;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class b0<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f19591b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y f19592a;

    private b0(K k7, V v7, y yVar) {
        super(k7, v7);
        this.f19592a = (y) com.google.common.base.e0.E(yVar);
    }

    public static <K, V> b0<K, V> a(K k7, V v7, y yVar) {
        return new b0<>(k7, v7, yVar);
    }

    public y b() {
        return this.f19592a;
    }

    public boolean c() {
        return this.f19592a.a();
    }
}
