package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KeyAnalyzer<K> implements Comparator<K>, Serializable {
    public static final int EQUAL_BIT_KEY = -2;
    public static final int NULL_BIT_KEY = -1;
    public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
    private static final long serialVersionUID = -20497563720380683L;

    static boolean isEqualBitKey(int i7) {
        return i7 == -2;
    }

    static boolean isNullBitKey(int i7) {
        return i7 == -1;
    }

    static boolean isOutOfBoundsIndex(int i7) {
        return i7 == -3;
    }

    static boolean isValidBitIndex(int i7) {
        return i7 >= 0;
    }

    public abstract int bitIndex(K k7, int i7, int i8, K k8, int i9, int i10);

    public abstract int bitsPerElement();

    @Override // java.util.Comparator
    public int compare(K k7, K k8) {
        if (k7 == null) {
            return k8 == null ? 0 : -1;
        }
        if (k8 == null) {
            return 1;
        }
        return ((Comparable) k7).compareTo(k8);
    }

    public abstract boolean isBitSet(K k7, int i7, int i8);

    public abstract boolean isPrefix(K k7, int i7, int i8, K k8);

    public abstract int lengthInBits(K k7);
}
