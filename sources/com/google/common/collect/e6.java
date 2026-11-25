package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class e6<K, V> extends w5<K, V> implements ue<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.w5
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public abstract ue<K, V> d0();

    @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public Set<V> a(Object obj) {
        return d0().a(obj);
    }

    @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public Set<V> b(K k7, Iterable<? extends V> iterable) {
        return d0().b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.ue
    public Set<Map.Entry<K, V>> entries() {
        return d0().entries();
    }

    @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    public Set<V> get(K k7) {
        return d0().get((Object) k7);
    }
}
