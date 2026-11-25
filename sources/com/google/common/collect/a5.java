package com.google.common.collect;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class a5<K, V> extends b5<K, V> implements hb<K, V> {
    a5(hb<K, V> hbVar, com.google.common.base.g0<? super K> g0Var) {
        super(hbVar, g0Var);
    }

    @Override // com.google.common.collect.b5, com.google.common.collect.d5
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public hb<K, V> d() {
        return (hb) super.d();
    }

    @Override // com.google.common.collect.b5, com.google.common.collect.tc, com.google.common.collect.hb
    public List<V> a(Object obj) {
        return (List) super.a(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    public List<V> b(K k7, Iterable<? extends V> iterable) {
        return (List) super.b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.b5, com.google.common.collect.tc, com.google.common.collect.hb
    public List<V> get(K k7) {
        return (List) super.get((Object) k7);
    }
}
