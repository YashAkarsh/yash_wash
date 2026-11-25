package com.google.common.collect;

import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class mf<K, V> extends u6<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient K f20665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient V f20666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @y1.h
    @v1.b
    transient u6<V, K> f20667h;

    mf(K k7, V v7) {
        f2.a(k7, v7);
        this.f20665f = k7;
        this.f20666g = v7;
    }

    @Override // com.google.common.collect.u6, com.google.common.collect.r0
    /* JADX INFO: renamed from: P */
    public u6<V, K> T() {
        u6<V, K> u6Var = this.f20667h;
        if (u6Var != null) {
            return u6Var;
        }
        mf mfVar = new mf(this.f20666g, this.f20665f, this);
        this.f20667h = mfVar;
        return mfVar;
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f20665f.equals(obj);
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public boolean containsValue(Object obj) {
        return this.f20666g.equals(obj);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        lf.a(com.google.common.base.e0.E(biConsumer)).accept(this.f20665f, this.f20666g);
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public V get(Object obj) {
        if (this.f20665f.equals(obj)) {
            return this.f20666g;
        }
        return null;
    }

    @Override // com.google.common.collect.v7
    u8<Map.Entry<K, V>> k() {
        return u8.B(wb.T(this.f20665f, this.f20666g));
    }

    @Override // com.google.common.collect.v7
    u8<K> l() {
        return u8.B(this.f20665f);
    }

    @Override // com.google.common.collect.v7
    boolean r() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    private mf(K k7, V v7, u6<V, K> u6Var) {
        this.f20665f = k7;
        this.f20666g = v7;
        this.f20667h = u6Var;
    }
}
