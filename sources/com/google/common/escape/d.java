package com.google.common.escape;

import com.google.common.base.e0;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public abstract class d extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f21527b = 2;

    protected d() {
    }

    private static char[] e(char[] cArr, int i7, int i8) {
        if (i8 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i8];
        if (i7 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i7);
        }
        return cArr2;
    }

    @Override // com.google.common.escape.f
    public String b(String str) {
        e0.E(str);
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (c(str.charAt(i7)) != null) {
                return d(str, i7);
            }
        }
        return str;
    }

    protected abstract char[] c(char c8);

    protected final String d(String str, int i7) {
        int length = str.length();
        char[] cArrA = h.a();
        int length2 = cArrA.length;
        int i8 = 0;
        int i9 = 0;
        while (i7 < length) {
            char[] cArrC = c(str.charAt(i7));
            if (cArrC != null) {
                int length3 = cArrC.length;
                int i10 = i7 - i8;
                int i11 = i9 + i10;
                int i12 = i11 + length3;
                if (length2 < i12) {
                    length2 = ((length - i7) * 2) + i12;
                    cArrA = e(cArrA, i9, length2);
                }
                if (i10 > 0) {
                    str.getChars(i8, i7, cArrA, i9);
                    i9 = i11;
                }
                if (length3 > 0) {
                    System.arraycopy(cArrC, 0, cArrA, i9, length3);
                    i9 += length3;
                }
                i8 = i7 + 1;
            }
            i7++;
        }
        int i13 = length - i8;
        if (i13 > 0) {
            int i14 = i13 + i9;
            if (length2 < i14) {
                cArrA = e(cArrA, i9, i14);
            }
            str.getChars(i8, length, cArrA, i9);
            i9 = i14;
        }
        return new String(cArrA, 0, i9);
    }
}
