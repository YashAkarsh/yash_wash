package com.alibaba.fastjson.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f13291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13292b;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f13291a = charArray;
        int[] iArr = new int[256];
        f13292b = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i7 = 0; i7 < length; i7++) {
            f13292b[f13291a[i7]] = i7;
        }
        f13292b[61] = 0;
    }

    public static byte[] a(String str) {
        int i7;
        int i8;
        int length = str.length();
        int i9 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i10 = length - 1;
        int i11 = 0;
        while (i11 < i10 && f13292b[str.charAt(i11) & 255] < 0) {
            i11++;
        }
        while (i10 > 0 && f13292b[str.charAt(i10) & 255] < 0) {
            i10--;
        }
        if (str.charAt(i10) == '=') {
            i7 = str.charAt(i10 + (-1)) == '=' ? 2 : 1;
        } else {
            i7 = 0;
        }
        int i12 = (i10 - i11) + 1;
        if (length > 76) {
            i8 = (str.charAt(76) == '\r' ? i12 / 78 : 0) << 1;
        } else {
            i8 = 0;
        }
        int i13 = (((i12 - i8) * 6) >> 3) - i7;
        byte[] bArr = new byte[i13];
        int i14 = (i13 / 3) * 3;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i14) {
            int[] iArr = f13292b;
            int i17 = i11 + 1;
            int i18 = i17 + 1;
            int i19 = (iArr[str.charAt(i11)] << 18) | (iArr[str.charAt(i17)] << 12);
            int i20 = i18 + 1;
            int i21 = i19 | (iArr[str.charAt(i18)] << 6);
            int i22 = i20 + 1;
            int i23 = i21 | iArr[str.charAt(i20)];
            int i24 = i15 + 1;
            bArr[i15] = (byte) (i23 >> 16);
            int i25 = i24 + 1;
            bArr[i24] = (byte) (i23 >> 8);
            int i26 = i25 + 1;
            bArr[i25] = (byte) i23;
            if (i8 > 0 && (i16 = i16 + 1) == 19) {
                i22 += 2;
                i16 = 0;
            }
            i11 = i22;
            i15 = i26;
        }
        if (i15 < i13) {
            int i27 = 0;
            while (i11 <= i10 - i7) {
                i9 |= f13292b[str.charAt(i11)] << (18 - (i27 * 6));
                i27++;
                i11++;
            }
            int i28 = 16;
            while (i15 < i13) {
                bArr[i15] = (byte) (i9 >> i28);
                i28 -= 8;
                i15++;
            }
        }
        return bArr;
    }

    public static byte[] b(String str, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        if (i8 == 0) {
            return new byte[0];
        }
        int i12 = (i7 + i8) - 1;
        while (i7 < i12 && f13292b[str.charAt(i7)] < 0) {
            i7++;
        }
        while (i12 > 0 && f13292b[str.charAt(i12)] < 0) {
            i12--;
        }
        if (str.charAt(i12) == '=') {
            i9 = str.charAt(i12 + (-1)) == '=' ? 2 : 1;
        } else {
            i9 = 0;
        }
        int i13 = (i12 - i7) + 1;
        if (i8 > 76) {
            i10 = (str.charAt(76) == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i14 = (((i13 - i10) * 6) >> 3) - i9;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i15) {
            int[] iArr = f13292b;
            int i18 = i7 + 1;
            int i19 = i18 + 1;
            int i20 = (iArr[str.charAt(i7)] << 18) | (iArr[str.charAt(i18)] << 12);
            int i21 = i19 + 1;
            int i22 = i20 | (iArr[str.charAt(i19)] << 6);
            int i23 = i21 + 1;
            int i24 = i22 | iArr[str.charAt(i21)];
            int i25 = i16 + 1;
            bArr[i16] = (byte) (i24 >> 16);
            int i26 = i25 + 1;
            bArr[i25] = (byte) (i24 >> 8);
            int i27 = i26 + 1;
            bArr[i26] = (byte) i24;
            if (i10 > 0 && (i17 = i17 + 1) == 19) {
                i23 += 2;
                i17 = 0;
            }
            i7 = i23;
            i16 = i27;
        }
        if (i16 < i14) {
            int i28 = 0;
            while (i7 <= i12 - i9) {
                i11 |= f13292b[str.charAt(i7)] << (18 - (i28 * 6));
                i28++;
                i7++;
            }
            int i29 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i11 >> i29);
                i29 -= 8;
                i16++;
            }
        }
        return bArr;
    }

    public static byte[] c(char[] cArr, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        if (i8 == 0) {
            return new byte[0];
        }
        int i12 = (i7 + i8) - 1;
        while (i7 < i12 && f13292b[cArr[i7]] < 0) {
            i7++;
        }
        while (i12 > 0 && f13292b[cArr[i12]] < 0) {
            i12--;
        }
        if (cArr[i12] == '=') {
            i9 = cArr[i12 + (-1)] == '=' ? 2 : 1;
        } else {
            i9 = 0;
        }
        int i13 = (i12 - i7) + 1;
        if (i8 > 76) {
            i10 = (cArr[76] == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i14 = (((i13 - i10) * 6) >> 3) - i9;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        int i17 = 0;
        while (i16 < i15) {
            int[] iArr = f13292b;
            int i18 = i7 + 1;
            int i19 = i18 + 1;
            int i20 = (iArr[cArr[i7]] << 18) | (iArr[cArr[i18]] << 12);
            int i21 = i19 + 1;
            int i22 = i20 | (iArr[cArr[i19]] << 6);
            int i23 = i21 + 1;
            int i24 = i22 | iArr[cArr[i21]];
            int i25 = i16 + 1;
            bArr[i16] = (byte) (i24 >> 16);
            int i26 = i25 + 1;
            bArr[i25] = (byte) (i24 >> 8);
            int i27 = i26 + 1;
            bArr[i26] = (byte) i24;
            if (i10 > 0 && (i17 = i17 + 1) == 19) {
                i23 += 2;
                i17 = 0;
            }
            i7 = i23;
            i16 = i27;
        }
        if (i16 < i14) {
            int i28 = 0;
            while (i7 <= i12 - i9) {
                i11 |= f13292b[cArr[i7]] << (18 - (i28 * 6));
                i28++;
                i7++;
            }
            int i29 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i11 >> i29);
                i29 -= 8;
                i16++;
            }
        }
        return bArr;
    }
}
