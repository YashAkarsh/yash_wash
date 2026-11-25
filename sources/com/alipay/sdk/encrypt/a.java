package com.alipay.sdk.encrypt;

import com.alibaba.fastjson.asm.j;
import okio.r0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f13705a = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f13706b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f13707c = 24;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f13708d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f13709e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f13710f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f13711g = -128;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f13712h = '=';

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f13713i = new byte[128];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f13714j = new char[64];

    static {
        int i7;
        int i8;
        int i9 = 0;
        for (int i10 = 0; i10 < 128; i10++) {
            f13713i[i10] = -1;
        }
        for (int i11 = 90; i11 >= 65; i11--) {
            f13713i[i11] = (byte) (i11 - 65);
        }
        int i12 = 122;
        while (true) {
            i7 = 26;
            if (i12 < 97) {
                break;
            }
            f13713i[i12] = (byte) ((i12 - 97) + 26);
            i12--;
        }
        int i13 = 57;
        while (true) {
            i8 = 52;
            if (i13 < 48) {
                break;
            }
            f13713i[i13] = (byte) ((i13 - 48) + 52);
            i13--;
        }
        byte[] bArr = f13713i;
        bArr[43] = 62;
        bArr[47] = r0.f38528a;
        for (int i14 = 0; i14 <= 25; i14++) {
            f13714j[i14] = (char) (i14 + 65);
        }
        int i15 = 0;
        while (i7 <= 51) {
            f13714j[i7] = (char) (i15 + 97);
            i7++;
            i15++;
        }
        while (i8 <= 61) {
            f13714j[i8] = (char) (i9 + 48);
            i8++;
            i9++;
        }
        char[] cArr = f13714j;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            if (!c(cArr[i8])) {
                cArr[i7] = cArr[i8];
                i7++;
            }
        }
        return i7;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i7 = length % 24;
        int i8 = length / 24;
        char[] cArr = new char[(i7 != 0 ? i8 + 1 : i8) * 4];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < i8) {
            int i12 = i10 + 1;
            byte b8 = bArr[i10];
            int i13 = i12 + 1;
            byte b9 = bArr[i12];
            int i14 = i13 + 1;
            byte b10 = bArr[i13];
            byte b11 = (byte) (b9 & com.google.common.base.c.f19317q);
            byte b12 = (byte) (b8 & 3);
            int i15 = b8 & (-128);
            int i16 = b8 >> 2;
            if (i15 != 0) {
                i16 ^= j.f12606c0;
            }
            byte b13 = (byte) i16;
            int i17 = b9 & (-128);
            int i18 = b9 >> 4;
            if (i17 != 0) {
                i18 ^= 240;
            }
            byte b14 = (byte) i18;
            int i19 = (b10 & (-128)) == 0 ? b10 >> 6 : (b10 >> 6) ^ 252;
            int i20 = i11 + 1;
            char[] cArr2 = f13714j;
            cArr[i11] = cArr2[b13];
            int i21 = i20 + 1;
            cArr[i20] = cArr2[(b12 << 4) | b14];
            int i22 = i21 + 1;
            cArr[i21] = cArr2[(b11 << 2) | ((byte) i19)];
            cArr[i22] = cArr2[b10 & r0.f38528a];
            i9++;
            i11 = i22 + 1;
            i10 = i14;
        }
        if (i7 == 8) {
            byte b15 = bArr[i10];
            byte b16 = (byte) (b15 & 3);
            int i23 = b15 & (-128);
            int i24 = b15 >> 2;
            if (i23 != 0) {
                i24 ^= j.f12606c0;
            }
            int i25 = i11 + 1;
            char[] cArr3 = f13714j;
            cArr[i11] = cArr3[(byte) i24];
            int i26 = i25 + 1;
            cArr[i25] = cArr3[b16 << 4];
            cArr[i26] = f13712h;
            cArr[i26 + 1] = f13712h;
        } else if (i7 == 16) {
            byte b17 = bArr[i10];
            byte b18 = bArr[i10 + 1];
            byte b19 = (byte) (b18 & com.google.common.base.c.f19317q);
            byte b20 = (byte) (b17 & 3);
            int i27 = b17 & (-128);
            int i28 = b17 >> 2;
            if (i27 != 0) {
                i28 ^= j.f12606c0;
            }
            byte b21 = (byte) i28;
            int i29 = b18 & (-128);
            int i30 = b18 >> 4;
            if (i29 != 0) {
                i30 ^= 240;
            }
            int i31 = i11 + 1;
            char[] cArr4 = f13714j;
            cArr[i11] = cArr4[b21];
            int i32 = i31 + 1;
            cArr[i31] = cArr4[((byte) i30) | (b20 << 4)];
            cArr[i32] = cArr4[b19 << 2];
            cArr[i32 + 1] = f13712h;
        }
        return new String(cArr);
    }

    private static boolean c(char c8) {
        return c8 == ' ' || c8 == '\r' || c8 == '\n' || c8 == '\t';
    }

    public static byte[] d(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int iA = a(charArray);
        if (iA % 4 != 0) {
            return null;
        }
        int i7 = iA / 4;
        if (i7 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i7 * 3];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < i7 - 1) {
            int i11 = i9 + 1;
            char c8 = charArray[i9];
            if (f(c8)) {
                int i12 = i11 + 1;
                char c9 = charArray[i11];
                if (f(c9)) {
                    int i13 = i12 + 1;
                    char c10 = charArray[i12];
                    if (f(c10)) {
                        int i14 = i13 + 1;
                        char c11 = charArray[i13];
                        if (f(c11)) {
                            byte[] bArr2 = f13713i;
                            byte b8 = bArr2[c8];
                            byte b9 = bArr2[c9];
                            byte b10 = bArr2[c10];
                            byte b11 = bArr2[c11];
                            int i15 = i10 + 1;
                            bArr[i10] = (byte) ((b8 << 2) | (b9 >> 4));
                            int i16 = i15 + 1;
                            bArr[i15] = (byte) (((b9 & com.google.common.base.c.f19317q) << 4) | ((b10 >> 2) & 15));
                            i10 = i16 + 1;
                            bArr[i16] = (byte) ((b10 << 6) | b11);
                            i8++;
                            i9 = i14;
                        }
                    }
                }
            }
            return null;
        }
        int i17 = i9 + 1;
        char c12 = charArray[i9];
        if (!f(c12)) {
            return null;
        }
        int i18 = i17 + 1;
        char c13 = charArray[i17];
        if (!f(c13)) {
            return null;
        }
        byte[] bArr3 = f13713i;
        byte b12 = bArr3[c12];
        byte b13 = bArr3[c13];
        int i19 = i18 + 1;
        char c14 = charArray[i18];
        char c15 = charArray[i19];
        if (f(c14) && f(c15)) {
            byte b14 = bArr3[c14];
            byte b15 = bArr3[c15];
            int i20 = i10 + 1;
            bArr[i10] = (byte) ((b12 << 2) | (b13 >> 4));
            bArr[i20] = (byte) (((b13 & com.google.common.base.c.f19317q) << 4) | ((b14 >> 2) & 15));
            bArr[i20 + 1] = (byte) (b15 | (b14 << 6));
            return bArr;
        }
        if (e(c14) && e(c15)) {
            if ((b13 & com.google.common.base.c.f19317q) != 0) {
                return null;
            }
            int i21 = i8 * 3;
            byte[] bArr4 = new byte[i21 + 1];
            System.arraycopy(bArr, 0, bArr4, 0, i21);
            bArr4[i10] = (byte) ((b12 << 2) | (b13 >> 4));
            return bArr4;
        }
        if (e(c14) || !e(c15)) {
            return null;
        }
        byte b16 = bArr3[c14];
        if ((b16 & 3) != 0) {
            return null;
        }
        int i22 = i8 * 3;
        byte[] bArr5 = new byte[i22 + 2];
        System.arraycopy(bArr, 0, bArr5, 0, i22);
        bArr5[i10] = (byte) ((b12 << 2) | (b13 >> 4));
        bArr5[i10 + 1] = (byte) (((b16 >> 2) & 15) | ((b13 & com.google.common.base.c.f19317q) << 4));
        return bArr5;
    }

    private static boolean e(char c8) {
        return c8 == '=';
    }

    private static boolean f(char c8) {
        return c8 < 128 && f13713i[c8] != -1;
    }
}
