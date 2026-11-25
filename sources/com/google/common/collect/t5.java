package com.google.common.collect;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class t5<K, V> extends w5<K, V> implements hb<K, V> {
    protected t5() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.w5
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public abstract hb<K, V> d0();

    @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public List<V> a(Object obj) {
        return d0().a(obj);
    }

    @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public List<V> b(K k7, Iterable<? extends V> iterable) {
        return d0().b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    public List<V> get(K k7) {
        return d0().get((Object) k7);
    }
}
