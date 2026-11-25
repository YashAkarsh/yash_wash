package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {
    private K key;
    private V value;

    protected AbstractKeyValue(K k7, V v7) {
        this.key = k7;
        this.value = v7;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    protected K setKey(K k7) {
        K k8 = this.key;
        this.key = k7;
        return k8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V setValue(V v7) {
        V v8 = this.value;
        this.value = v7;
        return v8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
