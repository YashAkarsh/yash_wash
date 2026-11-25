package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class v5<K, V> extends b6 implements Map.Entry<K, V> {
    protected v5() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.b6
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public abstract Map.Entry<K, V> c0();

    protected boolean e0(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return com.google.common.base.y.a(getKey(), entry.getKey()) && com.google.common.base.y.a(getValue(), entry.getValue());
    }

    public boolean equals(Object obj) {
        return c0().equals(obj);
    }

    protected int f0() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return c0().getKey();
    }

    public V getValue() {
        return c0().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return c0().hashCode();
    }

    @s1.a
    protected String i0() {
        return getKey() + "=" + getValue();
    }

    public V setValue(V v7) {
        return c0().setValue(v7);
    }
}
