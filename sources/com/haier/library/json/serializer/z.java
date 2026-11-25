package com.haier.library.json.serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.text.h0;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends Writer {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final byte[] f26868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final byte[] f26869l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final char[] f26871n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected char[] f26872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f26873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f26874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Writer f26875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ThreadLocal<char[]> f26862e = new ThreadLocal<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f26863f = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final char[] f26864g = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final char[] f26865h = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final char[] f26866i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final char[] f26867j = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final char[] f26870m = new char[93];

    static {
        byte[] bArr = new byte[161];
        f26868k = bArr;
        byte[] bArr2 = new byte[161];
        f26869l = bArr2;
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
            f26868k[i7] = 4;
            f26869l[i7] = 4;
        }
        for (int i8 = 127; i8 <= 160; i8++) {
            f26868k[i8] = 4;
            f26869l[i8] = 4;
        }
        char[] cArr = f26870m;
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
        f26871n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public z() {
        this((Writer) null);
    }

    private void E(String str) {
        int length = str.length();
        boolean z7 = true;
        int i7 = this.f26873b + length + 1;
        if (i7 > this.f26872a.length) {
            if (this.f26875d != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        z7 = false;
                        break;
                    }
                    char cCharAt = str.charAt(i8);
                    byte[] bArr = f26868k;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (z7) {
                    write(34);
                }
                for (int i9 = 0; i9 < length; i9++) {
                    char cCharAt2 = str.charAt(i9);
                    byte[] bArr2 = f26868k;
                    if (cCharAt2 >= bArr2.length || bArr2[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(f26870m[cCharAt2]);
                    }
                }
                if (z7) {
                    write(34);
                }
                write(58);
                return;
            }
            g(i7);
        }
        if (length == 0) {
            int i10 = this.f26873b;
            if (i10 + 3 > this.f26872a.length) {
                g(i10 + 3);
            }
            char[] cArr = this.f26872a;
            int i11 = this.f26873b;
            int i12 = i11 + 1;
            cArr[i11] = h0.f35376b;
            int i13 = i12 + 1;
            cArr[i12] = h0.f35376b;
            this.f26873b = i13 + 1;
            cArr[i13] = ':';
            return;
        }
        int i14 = this.f26873b;
        int i15 = i14 + length;
        str.getChars(0, length, this.f26872a, i14);
        this.f26873b = i7;
        int i16 = i14;
        boolean z8 = false;
        while (i16 < i15) {
            char[] cArr2 = this.f26872a;
            char c8 = cArr2[i16];
            byte[] bArr3 = f26868k;
            if (c8 < bArr3.length && bArr3[c8] != 0) {
                if (z8) {
                    i7++;
                    if (i7 > cArr2.length) {
                        g(i7);
                    }
                    this.f26873b = i7;
                    char[] cArr3 = this.f26872a;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr3, i17, cArr3, i16 + 2, i15 - i16);
                    char[] cArr4 = this.f26872a;
                    cArr4[i16] = '\\';
                    cArr4[i17] = f26870m[c8];
                    i15++;
                    i16 = i17;
                } else {
                    i7 += 3;
                    if (i7 > cArr2.length) {
                        g(i7);
                    }
                    this.f26873b = i7;
                    char[] cArr5 = this.f26872a;
                    int i18 = i16 + 1;
                    System.arraycopy(cArr5, i18, cArr5, i16 + 3, (i15 - i16) - 1);
                    char[] cArr6 = this.f26872a;
                    System.arraycopy(cArr6, 0, cArr6, 1, i16);
                    char[] cArr7 = this.f26872a;
                    cArr7[i14] = h0.f35376b;
                    cArr7[i18] = '\\';
                    int i19 = i18 + 1;
                    cArr7[i19] = f26870m[c8];
                    i15 += 2;
                    cArr7[this.f26873b - 2] = h0.f35376b;
                    i16 = i19;
                    z8 = true;
                }
            }
            i16++;
        }
        this.f26872a[this.f26873b - 1] = ':';
    }

    private void F(String str) {
        int length = str.length();
        boolean z7 = true;
        int i7 = this.f26873b + length + 1;
        if (i7 > this.f26872a.length) {
            if (this.f26875d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        z7 = false;
                        break;
                    }
                    char cCharAt = str.charAt(i8);
                    byte[] bArr = f26869l;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (z7) {
                    write(39);
                }
                for (int i9 = 0; i9 < length; i9++) {
                    char cCharAt2 = str.charAt(i9);
                    byte[] bArr2 = f26869l;
                    if (cCharAt2 >= bArr2.length || bArr2[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(f26870m[cCharAt2]);
                    }
                }
                if (z7) {
                    write(39);
                }
                write(58);
                return;
            }
            g(i7);
        }
        if (length == 0) {
            int i10 = this.f26873b;
            if (i10 + 3 > this.f26872a.length) {
                g(i10 + 3);
            }
            char[] cArr = this.f26872a;
            int i11 = this.f26873b;
            int i12 = i11 + 1;
            cArr[i11] = '\'';
            int i13 = i12 + 1;
            cArr[i12] = '\'';
            this.f26873b = i13 + 1;
            cArr[i13] = ':';
            return;
        }
        int i14 = this.f26873b;
        int i15 = i14 + length;
        str.getChars(0, length, this.f26872a, i14);
        this.f26873b = i7;
        int i16 = i14;
        boolean z8 = false;
        while (i16 < i15) {
            char[] cArr2 = this.f26872a;
            char c8 = cArr2[i16];
            byte[] bArr3 = f26869l;
            if (c8 < bArr3.length && bArr3[c8] != 0) {
                if (z8) {
                    i7++;
                    if (i7 > cArr2.length) {
                        g(i7);
                    }
                    this.f26873b = i7;
                    char[] cArr3 = this.f26872a;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr3, i17, cArr3, i16 + 2, i15 - i16);
                    char[] cArr4 = this.f26872a;
                    cArr4[i16] = '\\';
                    cArr4[i17] = f26870m[c8];
                    i15++;
                    i16 = i17;
                } else {
                    i7 += 3;
                    if (i7 > cArr2.length) {
                        g(i7);
                    }
                    this.f26873b = i7;
                    char[] cArr5 = this.f26872a;
                    int i18 = i16 + 1;
                    System.arraycopy(cArr5, i18, cArr5, i16 + 3, (i15 - i16) - 1);
                    char[] cArr6 = this.f26872a;
                    System.arraycopy(cArr6, 0, cArr6, 1, i16);
                    char[] cArr7 = this.f26872a;
                    cArr7[i14] = '\'';
                    cArr7[i18] = '\\';
                    int i19 = i18 + 1;
                    cArr7[i19] = f26870m[c8];
                    i15 += 2;
                    cArr7[this.f26873b - 2] = '\'';
                    i16 = i19;
                    z8 = true;
                }
            }
            i16++;
        }
        this.f26872a[i7 - 1] = ':';
    }

    protected static void m(long j7, int i7, char[] cArr) {
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
            cArr[i9] = f26866i[i8];
            i7 = i9 - 1;
            cArr[i7] = f26865h[i8];
            j7 = j8;
        }
        int i10 = (int) j7;
        while (i10 >= 65536) {
            int i11 = i10 / 100;
            int i12 = i10 - (((i11 << 6) + (i11 << 5)) + (i11 << 2));
            int i13 = i7 - 1;
            cArr[i13] = f26866i[i12];
            i7 = i13 - 1;
            cArr[i7] = f26865h[i12];
            i10 = i11;
        }
        while (true) {
            int i14 = (52429 * i10) >>> 19;
            i7--;
            cArr[i7] = f26864g[i10 - ((i14 << 3) + (i14 << 1))];
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

    public void C(int i7) {
        if (i7 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i8 = 0;
        while ((i7 < 0 ? -i7 : i7) > f26863f[i8]) {
            i8++;
        }
        int i9 = i8 + 1;
        if (i7 < 0) {
            i9++;
        }
        int i10 = this.f26873b + i9;
        if (i10 > this.f26872a.length) {
            if (this.f26875d != null) {
                char[] cArr = new char[i9];
                m(i7, i9, cArr);
                write(cArr, 0, i9);
                return;
            }
            g(i10);
        }
        m(i7, i10, this.f26872a);
        this.f26873b = i10;
    }

    public void G(long j7) {
        if (j7 == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j8 = j7 < 0 ? -j7 : j7;
        int i7 = 1;
        long j9 = 10;
        while (true) {
            if (i7 >= 19) {
                i7 = 0;
                break;
            } else {
                if (j8 < j9) {
                    break;
                }
                j9 *= 10;
                i7++;
            }
        }
        int i8 = i7 != 0 ? i7 : 19;
        if (j7 < 0) {
            i8++;
        }
        int i9 = this.f26873b + i8;
        if (i9 > this.f26872a.length) {
            if (this.f26875d != null) {
                char[] cArr = new char[i8];
                m(j7, i8, cArr);
                write(cArr, 0, i8);
                return;
            }
            g(i9);
        }
        m(j7, i9, this.f26872a);
        this.f26873b = i9;
    }

    public void H() {
        write("null");
    }

    public void K(String str) {
        if ((this.f26874c & a0.UseSingleQuotes.f26811a) != 0) {
            g0(str);
        } else {
            Q(str, (char) 0, true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x023b A[PHI: r4 r7
      0x023b: PHI (r4v33 int) = (r4v27 int), (r4v34 int) binds: [B:150:0x028a, B:114:0x0239] A[DONT_GENERATE, DONT_INLINE]
      0x023b: PHI (r7v12 int) = (r7v7 int), (r7v13 int) binds: [B:150:0x028a, B:114:0x0239] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:116:0x023e A[PHI: r4 r7 r8
      0x023e: PHI (r4v30 int) = (r4v27 int), (r4v29 int), (r4v34 int) binds: [B:150:0x028a, B:126:0x0250, B:114:0x0239] A[DONT_GENERATE, DONT_INLINE]
      0x023e: PHI (r7v9 int) = (r7v7 int), (r7v8 int), (r7v13 int) binds: [B:150:0x028a, B:126:0x0250, B:114:0x0239] A[DONT_GENERATE, DONT_INLINE]
      0x023e: PHI (r8v16 int) = (r8v2 int), (r8v14 int), (r8v2 int) binds: [B:150:0x028a, B:126:0x0250, B:114:0x0239] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:43:0x00dd  */
    protected void Q(String str, char c8, boolean z7) {
        int i7;
        if (str == null) {
            H();
            if (c8 != 0) {
                write(c8);
                return;
            }
            return;
        }
        int length = str.length();
        int i8 = this.f26873b + length + 2;
        if (c8 != 0) {
            i8++;
        }
        int length2 = this.f26872a.length;
        char c9 = CharUtils.CR;
        char c10 = ' ';
        char c11 = '/';
        if (i8 > length2) {
            if (this.f26875d != null) {
                write(34);
                int i9 = 0;
                while (i9 < str.length()) {
                    char cCharAt = str.charAt(i9);
                    int i10 = this.f26874c;
                    if ((a0.BrowserCompatible.f26811a & i10) == 0) {
                        byte[] bArr = f26868k;
                        if ((cCharAt >= bArr.length || bArr[cCharAt] == 0) && (cCharAt != '/' || (i10 & a0.WriteSlashAsSpecial.f26811a) == 0)) {
                            write(cCharAt);
                        } else {
                            write(92);
                            write(f26870m[cCharAt]);
                        }
                    } else if (cCharAt == '\b' || cCharAt == '\f' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                        write(92);
                        write(f26870m[cCharAt]);
                    } else if (cCharAt < c10) {
                        write(92);
                        write(117);
                        write(48);
                        write(48);
                        char[] cArr = f26867j;
                        int i11 = cCharAt * 2;
                        write(cArr[i11]);
                        write(cArr[i11 + 1]);
                    } else if (cCharAt >= 127) {
                        write(92);
                        write(117);
                        char[] cArr2 = f26871n;
                        write(cArr2[(cCharAt >>> '\f') & 15]);
                        write(cArr2[(cCharAt >>> '\b') & 15]);
                        write(cArr2[(cCharAt >>> 4) & 15]);
                        write(cArr2[cCharAt & 15]);
                    } else {
                        write(cCharAt);
                    }
                    i9++;
                    c10 = ' ';
                }
                write(34);
                if (c8 != 0) {
                    write(c8);
                    return;
                }
                return;
            }
            g(i8);
        }
        int i12 = this.f26873b;
        int i13 = i12 + 1;
        int i14 = i13 + length;
        char[] cArr3 = this.f26872a;
        cArr3[i12] = h0.f35376b;
        str.getChars(0, length, cArr3, i13);
        this.f26873b = i8;
        int i15 = -1;
        if ((this.f26874c & a0.BrowserCompatible.f26811a) != 0) {
            for (int i16 = i13; i16 < i14; i16++) {
                char c12 = this.f26872a[i16];
                if (c12 == '\"' || c12 == '/' || c12 == '\\' || c12 == '\b' || c12 == '\f' || c12 == '\n' || c12 == '\r' || c12 == '\t') {
                    i8++;
                } else {
                    if (c12 < ' ' || c12 >= 127) {
                        i8 += 5;
                    }
                }
                i15 = i16;
            }
            if (i8 > this.f26872a.length) {
                g(i8);
            }
            this.f26873b = i8;
            while (i15 >= i13) {
                char[] cArr4 = this.f26872a;
                char c13 = cArr4[i15];
                if (c13 == '\b' || c13 == '\f' || c13 == '\n' || c13 == c9 || c13 == '\t') {
                    int i17 = i15 + 1;
                    System.arraycopy(cArr4, i17, cArr4, i15 + 2, (i14 - i15) - 1);
                    char[] cArr5 = this.f26872a;
                    cArr5[i15] = '\\';
                    cArr5[i17] = f26870m[c13];
                } else {
                    if (c13 == '\"' || c13 == '/' || c13 == '\\') {
                        int i18 = i15 + 1;
                        System.arraycopy(cArr4, i18, cArr4, i15 + 2, (i14 - i15) - 1);
                        char[] cArr6 = this.f26872a;
                        cArr6[i15] = '\\';
                        cArr6[i18] = c13;
                    } else {
                        if (c13 < ' ') {
                            int i19 = i15 + 1;
                            System.arraycopy(cArr4, i19, cArr4, i15 + 6, (i14 - i15) - 1);
                            char[] cArr7 = this.f26872a;
                            cArr7[i15] = '\\';
                            cArr7[i19] = 'u';
                            cArr7[i15 + 2] = '0';
                            cArr7[i15 + 3] = '0';
                            char[] cArr8 = f26867j;
                            int i20 = c13 * 2;
                            cArr7[i15 + 4] = cArr8[i20];
                            cArr7[i15 + 5] = cArr8[i20 + 1];
                        } else if (c13 >= 127) {
                            int i21 = i15 + 1;
                            System.arraycopy(cArr4, i21, cArr4, i15 + 6, (i14 - i15) - 1);
                            char[] cArr9 = this.f26872a;
                            cArr9[i15] = '\\';
                            cArr9[i21] = 'u';
                            char[] cArr10 = f26871n;
                            cArr9[i15 + 2] = cArr10[(c13 >>> '\f') & 15];
                            cArr9[i15 + 3] = cArr10[(c13 >>> '\b') & 15];
                            cArr9[i15 + 4] = cArr10[(c13 >>> 4) & 15];
                            cArr9[i15 + 5] = cArr10[c13 & 15];
                        }
                        i14 += 5;
                    }
                    i15--;
                    c9 = CharUtils.CR;
                }
                i14++;
                i15--;
                c9 = CharUtils.CR;
            }
            if (c8 == 0) {
                this.f26872a[this.f26873b - 1] = h0.f35376b;
                return;
            }
            char[] cArr11 = this.f26872a;
            int i22 = this.f26873b;
            cArr11[i22 - 2] = h0.f35376b;
            cArr11[i22 - 1] = c8;
            return;
        }
        if (z7) {
            int i23 = 0;
            char c14 = 0;
            int i24 = -1;
            int i25 = -1;
            int i26 = i13;
            while (i26 < i14) {
                char c15 = this.f26872a[i26];
                if (c15 == 8232) {
                    i23++;
                    i8 += 4;
                    if (i24 == -1) {
                        i24 = i26;
                        i25 = i24;
                    } else {
                        i25 = i26;
                    }
                    c14 = c15;
                } else if (c15 < ']') {
                    if (c15 != ' ' && ((c15 == c11 && (this.f26874c & a0.WriteSlashAsSpecial.f26811a) != 0) || ((c15 <= '#' || c15 == '\\') && (c15 <= 31 || c15 == '\\' || c15 == '\"')))) {
                        i23++;
                        byte[] bArr2 = f26868k;
                        if (c15 < bArr2.length && bArr2[c15] == 4) {
                            i8 += 4;
                        }
                        if (i24 == -1) {
                            i24 = i26;
                            i25 = i24;
                        } else {
                            i25 = i26;
                        }
                        c14 = c15;
                    }
                } else if (c15 >= 127 && c15 <= 160) {
                    if (i24 == -1) {
                        i24 = i26;
                    }
                    i23++;
                    i8 += 4;
                    i25 = i26;
                    c14 = c15;
                }
                i26++;
                c11 = '/';
            }
            if (i23 > 0) {
                int i27 = i8 + i23;
                if (i27 > this.f26872a.length) {
                    g(i27);
                }
                this.f26873b = i27;
                if (i23 == 1) {
                    if (c14 == 8232) {
                        int i28 = i25 + 1;
                        char[] cArr12 = this.f26872a;
                        System.arraycopy(cArr12, i28, cArr12, i25 + 6, (i14 - i25) - 1);
                        char[] cArr13 = this.f26872a;
                        cArr13[i25] = '\\';
                        cArr13[i28] = 'u';
                        int i29 = i28 + 1;
                        cArr13[i29] = '2';
                        int i30 = i29 + 1;
                        cArr13[i30] = '0';
                        int i31 = i30 + 1;
                        cArr13[i31] = '2';
                        cArr13[i31 + 1] = '8';
                    } else {
                        byte[] bArr3 = f26868k;
                        if (c14 >= bArr3.length || bArr3[c14] != 4) {
                            int i32 = i25 + 1;
                            char[] cArr14 = this.f26872a;
                            System.arraycopy(cArr14, i32, cArr14, i25 + 2, (i14 - i25) - 1);
                            char[] cArr15 = this.f26872a;
                            cArr15[i25] = '\\';
                            cArr15[i32] = f26870m[c14];
                        } else {
                            int i33 = i25 + 1;
                            char[] cArr16 = this.f26872a;
                            System.arraycopy(cArr16, i33, cArr16, i25 + 6, (i14 - i25) - 1);
                            char[] cArr17 = this.f26872a;
                            cArr17[i25] = '\\';
                            int i34 = i33 + 1;
                            cArr17[i33] = 'u';
                            int i35 = i34 + 1;
                            char[] cArr18 = f26871n;
                            cArr17[i34] = cArr18[(c14 >>> '\f') & 15];
                            int i36 = i35 + 1;
                            cArr17[i35] = cArr18[(c14 >>> '\b') & 15];
                            cArr17[i36] = cArr18[(c14 >>> 4) & 15];
                            cArr17[i36 + 1] = cArr18[c14 & 15];
                        }
                    }
                } else if (i23 > 1) {
                    for (int i37 = i24 - i13; i37 < str.length(); i37++) {
                        char cCharAt2 = str.charAt(i37);
                        byte[] bArr4 = f26868k;
                        if ((cCharAt2 < bArr4.length && bArr4[cCharAt2] != 0) || (cCharAt2 == '/' && (this.f26874c & a0.WriteSlashAsSpecial.f26811a) != 0)) {
                            char[] cArr19 = this.f26872a;
                            int i38 = i24 + 1;
                            cArr19[i24] = '\\';
                            if (bArr4[cCharAt2] == 4) {
                                int i39 = i38 + 1;
                                cArr19[i38] = 'u';
                                int i40 = i39 + 1;
                                char[] cArr20 = f26871n;
                                cArr19[i39] = cArr20[(cCharAt2 >>> '\f') & 15];
                                int i41 = i40 + 1;
                                cArr19[i40] = cArr20[(cCharAt2 >>> '\b') & 15];
                                int i42 = i41 + 1;
                                cArr19[i41] = cArr20[(cCharAt2 >>> 4) & 15];
                                i7 = i42 + 1;
                                cArr19[i42] = cArr20[cCharAt2 & 15];
                            } else {
                                i7 = i38 + 1;
                                cArr19[i38] = f26870m[cCharAt2];
                            }
                            i24 = i7;
                        } else if (cCharAt2 == 8232) {
                            char[] cArr21 = this.f26872a;
                            int i43 = i24 + 1;
                            cArr21[i24] = '\\';
                            int i44 = i43 + 1;
                            cArr21[i43] = 'u';
                            int i45 = i44 + 1;
                            char[] cArr22 = f26871n;
                            cArr21[i44] = cArr22[(cCharAt2 >>> '\f') & 15];
                            int i46 = i45 + 1;
                            cArr21[i45] = cArr22[(cCharAt2 >>> '\b') & 15];
                            int i47 = i46 + 1;
                            cArr21[i46] = cArr22[(cCharAt2 >>> 4) & 15];
                            i24 = i47 + 1;
                            cArr21[i47] = cArr22[cCharAt2 & 15];
                        } else {
                            this.f26872a[i24] = cCharAt2;
                            i24++;
                        }
                    }
                }
            }
        }
        if (c8 == 0) {
            this.f26872a[this.f26873b - 1] = h0.f35376b;
            return;
        }
        char[] cArr23 = this.f26872a;
        int i48 = this.f26873b;
        cArr23[i48 - 2] = h0.f35376b;
        cArr23[i48 - 1] = c8;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public z append(char c8) {
        write(c8);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public z append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f26875d != null && this.f26873b > 0) {
            flush();
        }
        char[] cArr = this.f26872a;
        if (cArr.length <= 8192) {
            f26862e.set(cArr);
        }
        this.f26872a = null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public z append(CharSequence charSequence, int i7, int i8) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i7, i8).toString();
        write(string, 0, string.length());
        return this;
    }

    public void f(a0 a0Var, boolean z7) {
        if (z7) {
            this.f26874c = a0Var.f26811a | this.f26874c;
        } else {
            this.f26874c = (~a0Var.f26811a) & this.f26874c;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.f26875d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.f26872a, 0, this.f26873b);
            this.f26875d.flush();
            this.f26873b = 0;
        } catch (IOException e8) {
            throw new com.haier.library.json.d(e8.getMessage(), e8);
        }
    }

    protected void g(int i7) {
        char[] cArr = this.f26872a;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i7) {
            i7 = length;
        }
        char[] cArr2 = new char[i7];
        System.arraycopy(cArr, 0, cArr2, 0, this.f26873b);
        this.f26872a = cArr2;
    }

    protected void g0(String str) {
        int i7 = 0;
        if (str == null) {
            int i8 = this.f26873b + 4;
            if (i8 > this.f26872a.length) {
                g(i8);
            }
            "null".getChars(0, 4, this.f26872a, this.f26873b);
            this.f26873b = i8;
            return;
        }
        int length = str.length();
        int i9 = this.f26873b + length + 2;
        if (i9 > this.f26872a.length) {
            if (this.f26875d != null) {
                write(39);
                while (i7 < str.length()) {
                    char cCharAt = str.charAt(i7);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && (this.f26874c & a0.WriteSlashAsSpecial.f26811a) != 0)) {
                        write(92);
                        write(f26870m[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i7++;
                }
                write(39);
                return;
            }
            g(i9);
        }
        int i10 = this.f26873b;
        int i11 = i10 + 1;
        int i12 = i11 + length;
        char[] cArr = this.f26872a;
        cArr[i10] = '\'';
        str.getChars(0, length, cArr, i11);
        this.f26873b = i9;
        int i13 = -1;
        char c8 = 0;
        for (int i14 = i11; i14 < i12; i14++) {
            char c9 = this.f26872a[i14];
            if (c9 <= '\r' || c9 == '\\' || c9 == '\'' || (c9 == '/' && (this.f26874c & a0.WriteSlashAsSpecial.f26811a) != 0)) {
                i7++;
                i13 = i14;
                c8 = c9;
            }
        }
        int i15 = i9 + i7;
        if (i15 > this.f26872a.length) {
            g(i15);
        }
        this.f26873b = i15;
        if (i7 == 1) {
            char[] cArr2 = this.f26872a;
            int i16 = i13 + 1;
            System.arraycopy(cArr2, i16, cArr2, i13 + 2, (i12 - i13) - 1);
            char[] cArr3 = this.f26872a;
            cArr3[i13] = '\\';
            cArr3[i16] = f26870m[c8];
        } else if (i7 > 1) {
            char[] cArr4 = this.f26872a;
            int i17 = i13 + 1;
            System.arraycopy(cArr4, i17, cArr4, i13 + 2, (i12 - i13) - 1);
            char[] cArr5 = this.f26872a;
            cArr5[i13] = '\\';
            cArr5[i17] = f26870m[c8];
            int i18 = i12 + 1;
            for (int i19 = i17 - 2; i19 >= i11; i19--) {
                char[] cArr6 = this.f26872a;
                char c10 = cArr6[i19];
                if (c10 <= '\r' || c10 == '\\' || c10 == '\'' || (c10 == '/' && (this.f26874c & a0.WriteSlashAsSpecial.f26811a) != 0)) {
                    int i20 = i19 + 1;
                    System.arraycopy(cArr6, i20, cArr6, i19 + 2, (i18 - i19) - 1);
                    char[] cArr7 = this.f26872a;
                    cArr7[i19] = '\\';
                    cArr7[i20] = f26870m[c10];
                    i18++;
                }
            }
        }
        this.f26872a[this.f26873b - 1] = '\'';
    }

    public void h0(OutputStream outputStream, String str) throws IOException {
        l0(outputStream, Charset.forName(str));
    }

    public void l0(OutputStream outputStream, Charset charset) throws IOException {
        if (this.f26875d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        outputStream.write(new String(this.f26872a, 0, this.f26873b).getBytes(charset.name()));
    }

    public void o0(Writer writer) throws IOException {
        if (this.f26875d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.f26872a, 0, this.f26873b);
    }

    public boolean q(a0 a0Var) {
        return (a0Var.f26811a & this.f26874c) != 0;
    }

    public byte[] r(String str) {
        if (this.f26875d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (str == null) {
            str = "UTF-8";
        }
        try {
            return new String(this.f26872a, 0, this.f26873b).getBytes(str);
        } catch (UnsupportedEncodingException e8) {
            throw new com.haier.library.json.d("toBytes error", e8);
        }
    }

    public void s(boolean z7) {
        write(z7 ? "true" : com.paytm.pgsdk.d.G);
    }

    public String toString() {
        return new String(this.f26872a, 0, this.f26873b);
    }

    public void u(byte[] bArr) {
        int length = bArr.length;
        boolean z7 = (this.f26874c & a0.UseSingleQuotes.f26811a) != 0;
        char c8 = z7 ? '\'' : h0.f35376b;
        if (length == 0) {
            write(z7 ? "''" : "\"\"");
            return;
        }
        char[] cArr = com.haier.library.json.parser.e.B;
        int i7 = (length / 3) * 3;
        int i8 = length - 1;
        int i9 = this.f26873b;
        int i10 = (((i8 / 3) + 1) << 2) + i9 + 2;
        if (i10 > this.f26872a.length) {
            if (this.f26875d != null) {
                write(c8);
                int i11 = 0;
                while (i11 < i7) {
                    int i12 = i11 + 1;
                    int i13 = i12 + 1;
                    int i14 = ((bArr[i11] & 255) << 16) | ((bArr[i12] & 255) << 8) | (bArr[i13] & 255);
                    write(cArr[(i14 >>> 18) & 63]);
                    write(cArr[(i14 >>> 12) & 63]);
                    write(cArr[(i14 >>> 6) & 63]);
                    write(cArr[i14 & 63]);
                    i11 = i13 + 1;
                }
                int i15 = length - i7;
                if (i15 > 0) {
                    int i16 = ((bArr[i7] & 255) << 10) | (i15 == 2 ? (bArr[i8] & 255) << 2 : 0);
                    write(cArr[i16 >> 12]);
                    write(cArr[(i16 >>> 6) & 63]);
                    write(i15 == 2 ? cArr[i16 & 63] : '=');
                    write(61);
                }
                write(c8);
                return;
            }
            g(i10);
        }
        this.f26873b = i10;
        int i17 = i9 + 1;
        this.f26872a[i9] = c8;
        int i18 = 0;
        while (i18 < i7) {
            int i19 = i18 + 1;
            int i20 = i19 + 1;
            int i21 = ((bArr[i18] & 255) << 16) | ((bArr[i19] & 255) << 8);
            int i22 = i20 + 1;
            int i23 = i21 | (bArr[i20] & 255);
            char[] cArr2 = this.f26872a;
            int i24 = i17 + 1;
            cArr2[i17] = cArr[(i23 >>> 18) & 63];
            int i25 = i24 + 1;
            cArr2[i24] = cArr[(i23 >>> 12) & 63];
            int i26 = i25 + 1;
            cArr2[i25] = cArr[(i23 >>> 6) & 63];
            i17 = i26 + 1;
            cArr2[i26] = cArr[i23 & 63];
            i18 = i22;
        }
        int i27 = length - i7;
        if (i27 > 0) {
            int i28 = ((bArr[i7] & 255) << 10) | (i27 == 2 ? (bArr[i8] & 255) << 2 : 0);
            char[] cArr3 = this.f26872a;
            cArr3[i10 - 5] = cArr[i28 >> 12];
            cArr3[i10 - 4] = cArr[(i28 >>> 6) & 63];
            cArr3[i10 - 3] = i27 == 2 ? cArr[i28 & 63] : '=';
            cArr3[i10 - 2] = '=';
        }
        this.f26872a[i10 - 1] = c8;
    }

    public void v(String str, boolean z7) {
        int i7 = this.f26874c;
        if ((a0.UseSingleQuotes.f26811a & i7) == 0) {
            if ((i7 & a0.QuoteFieldNames.f26811a) != 0) {
                Q(str, ':', z7);
                return;
            } else {
                E(str);
                return;
            }
        }
        if ((a0.QuoteFieldNames.f26811a & i7) == 0) {
            F(str);
        } else {
            g0(str);
            write(58);
        }
    }

    @Override // java.io.Writer
    public void write(int i7) {
        int i8 = 1;
        int i9 = this.f26873b + 1;
        if (i9 <= this.f26872a.length) {
            i8 = i9;
        } else if (this.f26875d == null) {
            g(i9);
            i8 = i9;
        } else {
            flush();
        }
        this.f26872a[this.f26873b] = (char) i7;
        this.f26873b = i8;
    }

    public z(Writer writer) {
        this.f26875d = writer;
        this.f26874c = com.haier.library.json.a.f26649f;
        ThreadLocal<char[]> threadLocal = f26862e;
        this.f26872a = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.f26872a == null) {
            this.f26872a = new char[1024];
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) {
        int i9;
        if (i7 < 0 || i7 > cArr.length || i8 < 0 || (i9 = i7 + i8) > cArr.length || i9 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i8 == 0) {
            return;
        }
        int i10 = this.f26873b + i8;
        if (i10 > this.f26872a.length) {
            if (this.f26875d == null) {
                g(i10);
            } else {
                do {
                    char[] cArr2 = this.f26872a;
                    int length = cArr2.length;
                    int i11 = this.f26873b;
                    int i12 = length - i11;
                    System.arraycopy(cArr, i7, cArr2, i11, i12);
                    this.f26873b = this.f26872a.length;
                    flush();
                    i8 -= i12;
                    i7 += i12;
                } while (i8 > this.f26872a.length);
                i10 = i8;
            }
        }
        System.arraycopy(cArr, i7, this.f26872a, this.f26873b, i8);
        this.f26873b = i10;
    }

    public z(a0... a0VarArr) {
        this(null, 0, a0VarArr);
    }

    public z(Writer writer, int i7, a0[] a0VarArr) {
        this.f26875d = writer;
        ThreadLocal<char[]> threadLocal = f26862e;
        char[] cArr = threadLocal.get();
        this.f26872a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.f26872a == null) {
            this.f26872a = new char[1024];
        }
        for (a0 a0Var : a0VarArr) {
            i7 |= a0Var.f26811a;
        }
        this.f26874c = i7;
    }

    public z(int i7) {
        this(null, i7);
    }

    public z(Writer writer, int i7) {
        this.f26875d = writer;
        if (i7 > 0) {
            this.f26872a = new char[i7];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i7);
    }

    @Override // java.io.Writer
    public void write(String str, int i7, int i8) {
        int i9;
        int i10 = this.f26873b + i8;
        if (i10 > this.f26872a.length) {
            if (this.f26875d == null) {
                g(i10);
            } else {
                while (true) {
                    char[] cArr = this.f26872a;
                    int length = cArr.length;
                    int i11 = this.f26873b;
                    int i12 = length - i11;
                    i9 = i7 + i12;
                    str.getChars(i7, i9, cArr, i11);
                    this.f26873b = this.f26872a.length;
                    flush();
                    i8 -= i12;
                    if (i8 <= this.f26872a.length) {
                        break;
                    } else {
                        i7 = i9;
                    }
                }
                i10 = i8;
                i7 = i9;
            }
        }
        str.getChars(i7, i8 + i7, this.f26872a, this.f26873b);
        this.f26873b = i10;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            H();
        } else {
            write(str, 0, str.length());
        }
    }
}
