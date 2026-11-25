package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.KeyAnalyzer;

/* JADX INFO: loaded from: classes3.dex */
public class StringKeyAnalyzer extends KeyAnalyzer<String> {
    public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
    public static final int LENGTH = 16;
    private static final int MSB = 32768;
    private static final long serialVersionUID = -7032449491269434877L;

    private static int mask(int i7) {
        return 32768 >>> i7;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitsPerElement() {
        return 16;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitIndex(String str, int i7, int i8, String str2, int i9, int i10) {
        if (i7 % 16 != 0 || i9 % 16 != 0 || i8 % 16 != 0 || i10 % 16 != 0) {
            throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
        }
        int i11 = i7 / 16;
        int i12 = i9 / 16;
        int i13 = (i8 / 16) + i11;
        int i14 = (i10 / 16) + i12;
        int iMax = Math.max(i13, i14);
        boolean z7 = true;
        for (int i15 = 0; i15 < iMax; i15++) {
            int i16 = i11 + i15;
            int i17 = i12 + i15;
            char cCharAt = i16 >= i13 ? (char) 0 : str.charAt(i16);
            char cCharAt2 = (str2 == null || i17 >= i14) ? (char) 0 : str2.charAt(i17);
            if (cCharAt != cCharAt2) {
                return ((i15 * 16) + Integer.numberOfLeadingZeros(cCharAt ^ cCharAt2)) - 16;
            }
            if (cCharAt != 0) {
                z7 = false;
            }
        }
        return z7 ? -1 : -2;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isBitSet(String str, int i7, int i8) {
        if (str == null || i7 >= i8) {
            return false;
        }
        return (str.charAt(i7 / 16) & mask(i7 % 16)) != 0;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isPrefix(String str, int i7, int i8, String str2) {
        if (i7 % 16 == 0 && i8 % 16 == 0) {
            return str2.startsWith(str.substring(i7 / 16, i8 / 16));
        }
        throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int lengthInBits(String str) {
        if (str != null) {
            return str.length() * 16;
        }
        return 0;
    }
}
