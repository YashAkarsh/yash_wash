package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class MultiKey<K> implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;
    private transient int hashCode;
    private final K[] keys;

    public MultiKey(K k7, K k8) {
        this(new Object[]{k7, k8}, false);
    }

    private void calculateHashCode(Object[] objArr) {
        int iHashCode = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                iHashCode ^= obj.hashCode();
            }
        }
        this.hashCode = iHashCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiKey) {
            return Arrays.equals(this.keys, ((MultiKey) obj).keys);
        }
        return false;
    }

    public K getKey(int i7) {
        return this.keys[i7];
    }

    public K[] getKeys() {
        return (K[]) ((Object[]) this.keys.clone());
    }

    public int hashCode() {
        return this.hashCode;
    }

    protected Object readResolve() {
        calculateHashCode(this.keys);
        return this;
    }

    public int size() {
        return this.keys.length;
    }

    public String toString() {
        return "MultiKey" + Arrays.toString(this.keys);
    }

    public MultiKey(K k7, K k8, K k9) {
        this(new Object[]{k7, k8, k9}, false);
    }

    public MultiKey(K k7, K k8, K k9, K k10) {
        this(new Object[]{k7, k8, k9, k10}, false);
    }

    public MultiKey(K k7, K k8, K k9, K k10, K k11) {
        this(new Object[]{k7, k8, k9, k10, k11}, false);
    }

    public MultiKey(K[] kArr) {
        this((Object[]) kArr, true);
    }

    public MultiKey(K[] kArr, boolean z7) {
        if (kArr != null) {
            if (z7) {
                this.keys = (K[]) ((Object[]) kArr.clone());
            } else {
                this.keys = kArr;
            }
            calculateHashCode(kArr);
            return;
        }
        throw new IllegalArgumentException("The array of keys must not be null");
    }
}
