package org.apache.commons.collections4;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface Put<K, V> {
    void clear();

    Object put(K k7, V v7);

    void putAll(Map<? extends K, ? extends V> map);
}
