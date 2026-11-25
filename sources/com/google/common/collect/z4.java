package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class z4<K, V> extends y4<K, V> implements g5<K, V> {
    z4(ue<K, V> ueVar, com.google.common.base.g0<? super Map.Entry<K, V>> g0Var) {
        super(ueVar, g0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.y4, com.google.common.collect.x
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Set<Map.Entry<K, V>> e() {
        return af.i(d().y(), D());
    }

    @Override // com.google.common.collect.y4, com.google.common.collect.tc, com.google.common.collect.hb
    public Set<V> a(Object obj) {
        return (Set) super.a(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    public Set<V> b(K k7, Iterable<? extends V> iterable) {
        return (Set) super.b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.y4, com.google.common.collect.d5
    public ue<K, V> d() {
        return (ue) this.f21430f;
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    /* JADX INFO: renamed from: entries */
    public Set<Map.Entry<K, V>> y() {
        return (Set) super.y();
    }

    @Override // com.google.common.collect.y4, com.google.common.collect.tc, com.google.common.collect.hb
    public Set<V> get(K k7) {
        return (Set) super.get((Object) k7);
    }
}
