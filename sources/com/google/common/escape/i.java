package com.google.common.escape;

import com.google.common.base.e0;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public abstract class i extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f21543b = 32;

    protected i() {
    }

    protected static int c(CharSequence charSequence, int i7, int i8) {
        e0.E(charSequence);
        if (i7 >= i8) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i9 = i7 + 1;
        char cCharAt = charSequence.charAt(i7);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected low surrogate character '");
            sb.append(cCharAt);
            sb.append("' with value ");
            sb.append((int) cCharAt);
            sb.append(" at index ");
            sb.append(i9 - 1);
            sb.append(" in '");
            sb.append((Object) charSequence);
            sb.append("'");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i9 == i8) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i9);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i9 + " in '" + ((Object) charSequence) + "'");
    }

    private static char[] f(char[] cArr, int i7, int i8) {
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
        int iG = g(str, 0, length);
        return iG == length ? str : e(str, iG);
    }

    protected abstract char[] d(int i7);

    protected final String e(String str, int i7) {
        int length = str.length();
        char[] cArrA = h.a();
        int i8 = 0;
        int length2 = 0;
        while (i7 < length) {
            int iC = c(str, i7, length);
            if (iC < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrD = d(iC);
            int i9 = (Character.isSupplementaryCodePoint(iC) ? 2 : 1) + i7;
            if (cArrD != null) {
                int i10 = i7 - i8;
                int i11 = length2 + i10;
                int length3 = cArrD.length + i11;
                if (cArrA.length < length3) {
                    cArrA = f(cArrA, length2, length3 + (length - i7) + 32);
                }
                if (i10 > 0) {
                    str.getChars(i8, i7, cArrA, length2);
                    length2 = i11;
                }
                if (cArrD.length > 0) {
                    System.arraycopy(cArrD, 0, cArrA, length2, cArrD.length);
                    length2 += cArrD.length;
                }
                i8 = i9;
            }
            i7 = g(str, i9, length);
        }
        int i12 = length - i8;
        if (i12 > 0) {
            int i13 = i12 + length2;
            if (cArrA.length < i13) {
                cArrA = f(cArrA, length2, i13);
            }
            str.getChars(i8, length, cArrA, length2);
            length2 = i13;
        }
        return new String(cArrA, 0, length2);
    }

    protected int g(CharSequence charSequence, int i7, int i8) {
        while (i7 < i8) {
            int iC = c(charSequence, i7, i8);
            if (iC < 0 || d(iC) != null) {
                break;
            }
            i7 += Character.isSupplementaryCodePoint(iC) ? 2 : 1;
        }
        return i7;
    }
}
