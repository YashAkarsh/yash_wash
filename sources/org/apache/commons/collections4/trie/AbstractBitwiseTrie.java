package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import org.apache.commons.collections4.Trie;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBitwiseTrie<K, V> extends AbstractMap<K, V> implements Trie<K, V>, Serializable {
    private static final long serialVersionUID = 5826987063535505652L;
    private final KeyAnalyzer<? super K> keyAnalyzer;

    protected AbstractBitwiseTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        if (keyAnalyzer == null) {
            throw new NullPointerException("keyAnalyzer");
        }
        this.keyAnalyzer = keyAnalyzer;
    }

    static boolean compare(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    final int bitIndex(K k7, K k8) {
        return this.keyAnalyzer.bitIndex(k7, 0, lengthInBits(k7), k8, 0, lengthInBits(k8));
    }

    final int bitsPerElement() {
        return this.keyAnalyzer.bitsPerElement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final K castKey(Object obj) {
        return obj;
    }

    final boolean compareKeys(K k7, K k8) {
        if (k7 == null) {
            return k8 == null;
        }
        return k8 != null && this.keyAnalyzer.compare(k7, k8) == 0;
    }

    protected KeyAnalyzer<? super K> getKeyAnalyzer() {
        return this.keyAnalyzer;
    }

    final boolean isBitSet(K k7, int i7, int i8) {
        if (k7 == null) {
            return false;
        }
        return this.keyAnalyzer.isBitSet(k7, i7, i8);
    }

    final int lengthInBits(K k7) {
        if (k7 == null) {
            return 0;
        }
        return this.keyAnalyzer.lengthInBits(k7);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trie[");
        sb.append(size());
        sb.append("]={\n");
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append("  ");
            sb.append(entry);
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    static abstract class BasicEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = -944364551314110330L;
        protected K key;
        protected V value;

        public BasicEntry(K k7) {
            this.key = k7;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractBitwiseTrie.compare(this.key, entry.getKey()) && AbstractBitwiseTrie.compare(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public V setKeyValue(K k7, V v7) {
            this.key = k7;
            return setValue(v7);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = this.value;
            this.value = v7;
            return v8;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public BasicEntry(K k7, V v7) {
            this.key = k7;
            this.value = v7;
        }
    }
}
