package com.alibaba.fastjson.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import kotlin.text.h0;
import okio.r0;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13314a = "fastjson.properties";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13315b = "fastjson.compatibleWithJavaBean";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13316c = "fastjson.compatibleWithFieldName";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Properties f13317d = new Properties();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f13318e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f13319f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean[] f13320g = new boolean[256];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean[] f13321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f13322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f13323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean[] f13324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean[] f13325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final char[] f13326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final char[] f13327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final char[] f13328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final char[] f13329p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final char[] f13330q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final int[] f13331r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final char[] f13332s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f13333t;

    static class a implements PrivilegedAction<InputStream> {
        a() {
        }

        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.getResourceAsStream(f.f13314a) : ClassLoader.getSystemResourceAsStream(f.f13314a);
        }
    }

    static {
        char c8 = 0;
        while (true) {
            boolean[] zArr = f13320g;
            if (c8 >= zArr.length) {
                break;
            }
            if (c8 >= 'A' && c8 <= 'Z') {
                zArr[c8] = true;
            } else if (c8 >= 'a' && c8 <= 'z') {
                zArr[c8] = true;
            } else if (c8 == '_' || c8 == '$') {
                zArr[c8] = true;
            }
            c8 = (char) (c8 + 1);
        }
        f13321h = new boolean[256];
        char c9 = 0;
        while (true) {
            boolean[] zArr2 = f13321h;
            if (c9 < zArr2.length) {
                if (c9 >= 'A' && c9 <= 'Z') {
                    zArr2[c9] = true;
                } else if (c9 >= 'a' && c9 <= 'z') {
                    zArr2[c9] = true;
                } else if (c9 == '_') {
                    zArr2[c9] = true;
                } else if (c9 >= '0' && c9 <= '9') {
                    zArr2[c9] = true;
                }
                c9 = (char) (c9 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        o();
        byte[] bArr = new byte[161];
        f13322i = bArr;
        byte[] bArr2 = new byte[161];
        f13323j = bArr2;
        f13324k = new boolean[161];
        f13325l = new boolean[161];
        f13326m = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i7 = 14; i7 <= 31; i7++) {
            f13322i[i7] = 4;
            f13323j[i7] = 4;
        }
        for (int i8 = 127; i8 < 160; i8++) {
            f13322i[i8] = 4;
            f13323j[i8] = 4;
        }
        for (int i9 = 0; i9 < 161; i9++) {
            f13324k[i9] = f13322i[i9] != 0;
            f13325l[i9] = f13323j[i9] != 0;
        }
        char[] cArr = f13326m;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = h0.f35376b;
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        f13327n = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        f13328o = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f13329p = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        f13330q = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        f13331r = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f13332s = charArray;
        int[] iArr = new int[256];
        f13333t = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            f13333t[f13332s[i10]] = i10;
        }
        f13333t[61] = 0;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!coderResultDecode.isUnderflow()) {
                coderResultDecode.throwException();
            }
            CoderResult coderResultFlush = charsetDecoder.flush(charBuffer);
            if (coderResultFlush.isUnderflow()) {
                return;
            }
            coderResultFlush.throwException();
        } catch (CharacterCodingException e8) {
            throw new com.alibaba.fastjson.d("utf8 decode error, " + e8.getMessage(), e8);
        }
    }

    public static byte[] c(String str) {
        int i7;
        int i8;
        int length = str.length();
        int i9 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i10 = length - 1;
        int i11 = 0;
        while (i11 < i10 && f13333t[str.charAt(i11) & 255] < 0) {
            i11++;
        }
        while (i10 > 0 && f13333t[str.charAt(i10) & 255] < 0) {
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
            int[] iArr = f13333t;
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
                i9 |= f13333t[str.charAt(i11)] << (18 - (i27 * 6));
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

    public static byte[] d(String str, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        if (i8 == 0) {
            return new byte[0];
        }
        int i12 = (i7 + i8) - 1;
        while (i7 < i12 && f13333t[str.charAt(i7)] < 0) {
            i7++;
        }
        while (i12 > 0 && f13333t[str.charAt(i12)] < 0) {
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
            int[] iArr = f13333t;
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
                i11 |= f13333t[str.charAt(i7)] << (18 - (i28 * 6));
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

    public static byte[] e(char[] cArr, int i7, int i8) {
        int i9;
        int i10;
        int i11 = 0;
        if (i8 == 0) {
            return new byte[0];
        }
        int i12 = (i7 + i8) - 1;
        while (i7 < i12 && f13333t[cArr[i7]] < 0) {
            i7++;
        }
        while (i12 > 0 && f13333t[cArr[i12]] < 0) {
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
            int[] iArr = f13333t;
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
                i11 |= f13333t[cArr[i7]] << (18 - (i28 * 6));
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

    public static int f(byte[] bArr, int i7, int i8, char[] cArr) {
        int i9 = i7 + i8;
        int iMin = Math.min(i8, cArr.length);
        int i10 = 0;
        while (i10 < iMin) {
            byte b8 = bArr[i7];
            if (b8 < 0) {
                break;
            }
            i7++;
            cArr[i10] = (char) b8;
            i10++;
        }
        while (i7 < i9) {
            int i11 = i7 + 1;
            byte b9 = bArr[i7];
            if (b9 >= 0) {
                cArr[i10] = (char) b9;
                i7 = i11;
                i10++;
            } else {
                if ((b9 >> 5) != -2 || (b9 & com.google.common.base.c.H) == 0) {
                    if ((b9 >> 4) == -2) {
                        int i12 = i11 + 1;
                        if (i12 < i9) {
                            byte b10 = bArr[i11];
                            int i13 = i12 + 1;
                            byte b11 = bArr[i12];
                            if ((b9 != -32 || (b10 & 224) != 128) && (b10 & 192) == 128 && (b11 & 192) == 128) {
                                char c8 = (char) (((b9 << com.google.common.base.c.f19314n) ^ (b10 << 6)) ^ ((-123008) ^ b11));
                                if (c8 >= 55296 && c8 < 57344) {
                                    return -1;
                                }
                                cArr[i10] = c8;
                                i10++;
                                i7 = i13;
                            }
                        }
                        return -1;
                    }
                    if ((b9 >> 3) == -2 && i11 + 2 < i9) {
                        int i14 = i11 + 1;
                        byte b12 = bArr[i11];
                        int i15 = i14 + 1;
                        byte b13 = bArr[i14];
                        int i16 = i15 + 1;
                        byte b14 = bArr[i15];
                        int i17 = (((b9 << com.google.common.base.c.f19321u) ^ (b12 << com.google.common.base.c.f19314n)) ^ (b13 << 6)) ^ (3678080 ^ b14);
                        if ((b12 & 192) == 128 && (b13 & 192) == 128 && (b14 & 192) == 128 && Character.isSupplementaryCodePoint(i17)) {
                            int i18 = i10 + 1;
                            cArr[i10] = (char) ((i17 >>> 10) + r0.f38531d);
                            i10 = i18 + 1;
                            cArr[i18] = (char) ((i17 & 1023) + r0.f38532e);
                            i7 = i16;
                        }
                    }
                    return -1;
                }
                if (i11 >= i9) {
                    return -1;
                }
                int i19 = i11 + 1;
                byte b15 = bArr[i11];
                if ((b15 & 192) != 128) {
                    return -1;
                }
                cArr[i10] = (char) (((b9 << 6) ^ b15) ^ r0.f38533f);
                i7 = i19;
                i10++;
            }
        }
        return i10;
    }

    public static int g(char[] cArr, int i7, int i8, byte[] bArr) {
        int i9;
        int i10;
        int i11;
        int codePoint;
        char c8;
        int i12 = i7 + i8;
        int i13 = 0;
        int iMin = Math.min(i8, bArr.length) + 0;
        while (i13 < iMin && (c8 = cArr[i7]) < 128) {
            i7++;
            bArr[i13] = (byte) c8;
            i13++;
        }
        while (i7 < i12) {
            int i14 = i7 + 1;
            char c9 = cArr[i7];
            if (c9 < 128) {
                i9 = i13 + 1;
                bArr[i13] = (byte) c9;
            } else {
                if (c9 < 2048) {
                    int i15 = i13 + 1;
                    bArr[i13] = (byte) ((c9 >> 6) | com.alibaba.fastjson.asm.j.f12606c0);
                    i13 = i15 + 1;
                    bArr[i15] = (byte) ((c9 & '?') | 128);
                } else if (c9 < 55296 || c9 >= 57344) {
                    int i16 = i13 + 1;
                    bArr[i13] = (byte) ((c9 >> '\f') | 224);
                    int i17 = i16 + 1;
                    bArr[i16] = (byte) ((63 & (c9 >> 6)) | 128);
                    i9 = i17 + 1;
                    bArr[i17] = (byte) ((c9 & '?') | 128);
                } else {
                    int i18 = i14 - 1;
                    if (Character.isHighSurrogate(c9)) {
                        if (i12 - i18 < 2) {
                            i10 = -1;
                        } else {
                            char c10 = cArr[i18 + 1];
                            if (!Character.isLowSurrogate(c10)) {
                                throw new com.alibaba.fastjson.d("encodeUTF8 error", new MalformedInputException(1));
                            }
                            codePoint = Character.toCodePoint(c9, c10);
                        }
                    } else if (Character.isLowSurrogate(c9)) {
                        i10 = c9;
                        throw new com.alibaba.fastjson.d("encodeUTF8 error", new MalformedInputException(1));
                    }
                    if (i10 < 0) {
                        i10 = codePoint;
                        i11 = i13 + 1;
                        bArr[i13] = r0.f38528a;
                    } else {
                        i10 = codePoint;
                        int i19 = i13 + 1;
                        bArr[i13] = (byte) ((i10 >> 18) | 240);
                        int i20 = i19 + 1;
                        bArr[i19] = (byte) (((i10 >> 12) & 63) | 128);
                        int i21 = i20 + 1;
                        bArr[i20] = (byte) ((63 & (i10 >> 6)) | 128);
                        bArr[i21] = (byte) ((i10 & 63) | 128);
                        i14++;
                        i11 = i21 + 1;
                    }
                    i13 = i11;
                }
                i7 = i14;
            }
            i7 = i14;
            i13 = i9;
        }
        return i13;
    }

    public static boolean h(char c8) {
        boolean[] zArr = f13320g;
        return c8 < zArr.length && zArr[c8];
    }

    public static void i(byte b8, int i7, char[] cArr) {
        char c8;
        int i8;
        if (b8 < 0) {
            c8 = '-';
            i8 = -b8;
        } else {
            c8 = 0;
            i8 = b8;
        }
        while (true) {
            int i9 = (52429 * i8) >>> 19;
            i7--;
            cArr[i7] = f13328o[i8 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            } else {
                i8 = i9;
            }
        }
        if (c8 != 0) {
            cArr[i7 - 1] = c8;
        }
    }

    public static void j(int i7, int i8, char[] cArr) {
        char c8;
        if (i7 < 0) {
            i7 = -i7;
            c8 = '-';
        } else {
            c8 = 0;
        }
        while (i7 >= 65536) {
            int i9 = i7 / 100;
            int i10 = i7 - (((i9 << 6) + (i9 << 5)) + (i9 << 2));
            int i11 = i8 - 1;
            cArr[i11] = f13330q[i10];
            i8 = i11 - 1;
            cArr[i8] = f13329p[i10];
            i7 = i9;
        }
        while (true) {
            int i12 = (52429 * i7) >>> 19;
            i8--;
            cArr[i8] = f13328o[i7 - ((i12 << 3) + (i12 << 1))];
            if (i12 == 0) {
                break;
            } else {
                i7 = i12;
            }
        }
        if (c8 != 0) {
            cArr[i8 - 1] = c8;
        }
    }

    public static void k(long j7, int i7, char[] cArr) {
        char c8;
        if (j7 < 0) {
            j7 = -j7;
            c8 = '-';
        } else {
            c8 = 0;
        }
        while (j7 > 2147483647L) {
            long j8 = j7 / 100;
            int i8 = (int) (j7 - (((j8 << 6) + (j8 << 5)) + (j8 << 2)));
            int i9 = i7 - 1;
            cArr[i9] = f13330q[i8];
            i7 = i9 - 1;
            cArr[i7] = f13329p[i8];
            j7 = j8;
        }
        int i10 = (int) j7;
        while (i10 >= 65536) {
            int i11 = i10 / 100;
            int i12 = i10 - (((i11 << 6) + (i11 << 5)) + (i11 << 2));
            int i13 = i7 - 1;
            cArr[i13] = f13330q[i12];
            i7 = i13 - 1;
            cArr[i7] = f13329p[i12];
            i10 = i11;
        }
        while (true) {
            int i14 = (52429 * i10) >>> 19;
            i7--;
            cArr[i7] = f13328o[i10 - ((i14 << 3) + (i14 << 1))];
            if (i14 == 0) {
                break;
            } else {
                i10 = i14;
            }
        }
        if (c8 != 0) {
            cArr[i7 - 1] = c8;
        }
    }

    public static String l(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? f13317d.getProperty(str) : property;
    }

    public static boolean m(char c8) {
        boolean[] zArr = f13321h;
        return c8 < zArr.length && zArr[c8];
    }

    public static boolean n(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '.' && !m(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static void o() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a());
        if (inputStream != null) {
            try {
                f13317d.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String p(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int i7 = reader.read(cArr, 0, 2048);
                if (i7 < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, i7);
            }
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("read string from reader error", e8);
        }
    }

    public static int q(int i7) {
        int i8 = 0;
        while (i7 > f13331r[i8]) {
            i8++;
        }
        return i8 + 1;
    }

    public static int r(long j7) {
        long j8 = 10;
        for (int i7 = 1; i7 < 19; i7++) {
            if (j7 < j8) {
                return i7;
            }
            j8 *= 10;
        }
        return 19;
    }
}
