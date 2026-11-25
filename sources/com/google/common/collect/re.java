package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface re<R, C, V> extends oj<R, C, V> {
    @Override // com.google.common.collect.oj
    /* bridge */ /* synthetic */ Map f();

    @Override // com.google.common.collect.oj
    SortedMap<R, Map<C, V>> f();

    @Override // com.google.common.collect.oj
    /* bridge */ /* synthetic */ Set g();

    @Override // com.google.common.collect.oj
    SortedSet<R> g();
}
