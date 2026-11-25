package com.google.common.net;

import com.google.common.base.e0;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class g extends com.google.common.escape.i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f22286e = {'+'};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f22287f = "0123456789ABCDEF".toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean[] f22289d;

    public g(String str, boolean z7) {
        e0.E(str);
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (z7 && str2.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.f22288c = z7;
        this.f22289d = h(str2);
    }

    private static boolean[] h(String str) {
        char[] charArray = str.toCharArray();
        int iMax = -1;
        for (char c8 : charArray) {
            iMax = Math.max((int) c8, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c9 : charArray) {
            zArr[c9] = true;
        }
        return zArr;
    }

    @Override // com.google.common.escape.i, com.google.common.escape.f
    public String b(String str) {
        e0.E(str);
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            boolean[] zArr = this.f22289d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return e(str, i7);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.i
    protected char[] d(int i7) {
        boolean[] zArr = this.f22289d;
        if (i7 < zArr.length && zArr[i7]) {
            return null;
        }
        if (i7 == 32 && this.f22288c) {
            return f22286e;
        }
        if (i7 <= 127) {
            char[] cArr = f22287f;
            return new char[]{'%', cArr[i7 >>> 4], cArr[i7 & 15]};
        }
        if (i7 <= 2047) {
            char[] cArr2 = f22287f;
            char[] cArr3 = {'%', cArr2[(i >>> 4) | 12], cArr2[i & 15], '%', cArr2[(i & 3) | 8], cArr2[i7 & 15]};
            int i8 = i7 >>> 4;
            int i9 = i8 >>> 2;
            return cArr3;
        }
        if (i7 <= 65535) {
            char[] cArr4 = f22287f;
            char[] cArr5 = {'%', 'E', cArr4[i >>> 2], '%', cArr4[(i & 3) | 8], cArr4[i & 15], '%', cArr4[(i & 3) | 8], cArr4[i7 & 15]};
            int i10 = i7 >>> 4;
            int i11 = i10 >>> 2;
            int i12 = i11 >>> 4;
            return cArr5;
        }
        if (i7 > 1114111) {
            throw new IllegalArgumentException("Invalid unicode character value " + i7);
        }
        char[] cArr6 = f22287f;
        char[] cArr7 = {'%', 'F', cArr6[(i >>> 2) & 7], '%', cArr6[(i & 3) | 8], cArr6[i & 15], '%', cArr6[(i & 3) | 8], cArr6[i & 15], '%', cArr6[(i & 3) | 8], cArr6[i7 & 15]};
        int i13 = i7 >>> 4;
        int i14 = i13 >>> 2;
        int i15 = i14 >>> 4;
        int i16 = i15 >>> 2;
        int i17 = i16 >>> 4;
        return cArr7;
    }

    @Override // com.google.common.escape.i
    protected int g(CharSequence charSequence, int i7, int i8) {
        e0.E(charSequence);
        while (i7 < i8) {
            char cCharAt = charSequence.charAt(i7);
            boolean[] zArr = this.f22289d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i7++;
        }
        return i7;
    }
}
