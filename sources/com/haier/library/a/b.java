package com.haier.library.a;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private b() {
    }

    public static long a(String str) {
        return b(str, 0, str.length());
    }

    public static long b(String str, int i7, int i8) {
        long j7;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i7);
        }
        if (i8 < i7) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i8 + " < " + i7);
        }
        if (i8 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i8 + " > " + str.length());
        }
        long j8 = 0;
        while (i7 < i8) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < 128) {
                j8++;
            } else {
                if (cCharAt < 2048) {
                    j7 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j7 = 3;
                } else {
                    int i9 = i7 + 1;
                    char cCharAt2 = i9 < i8 ? str.charAt(i9) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j8++;
                        i7 = i9;
                    } else {
                        j8 += 4;
                        i7 += 2;
                    }
                }
                j8 += j7;
            }
            i7++;
        }
        return j8;
    }
}
