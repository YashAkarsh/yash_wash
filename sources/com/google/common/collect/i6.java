package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class i6<K, V> extends e6<K, V> implements bg<K, V> {
    protected i6() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.e6
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public abstract bg<K, V> d0();

    @Override // com.google.common.collect.bg
    public Comparator<? super V> valueComparator() {
        return d0().valueComparator();
    }

    @Override // com.google.common.collect.e6, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    public SortedSet<V> a(Object obj) {
        return d0().a(obj);
    }

    @Override // com.google.common.collect.e6, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    public SortedSet<V> b(K k7, Iterable<? extends V> iterable) {
        return d0().b((Object) k7, (Iterable) iterable);
    }

    @Override // com.google.common.collect.e6, com.google.common.collect.w5, com.google.common.collect.tc, com.google.common.collect.hb
    public SortedSet<V> get(K k7) {
        return d0().get((Object) k7);
    }
}
