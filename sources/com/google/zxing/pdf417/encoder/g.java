package com.google.zxing.pdf417.encoder;

import com.google.common.primitives.h0;
import com.google.zxing.w;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import okio.r0;

/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24098a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24099b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24100c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f24101d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24102e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24103f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f24104g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f24105h = 900;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f24106i = 901;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f24107j = 902;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f24108k = 913;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f24109l = 924;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f24110m = 925;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f24111n = 926;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f24112o = 927;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final byte[] f24115r;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f24113p = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, com.google.common.base.c.f19315o, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final byte[] f24114q = {59, 60, 62, h0.f22372a, 91, 92, 93, 95, 96, 126, 33, com.google.common.base.c.f19315o, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, r0.f38528a, 123, 125, 39, 0};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final byte[] f24116s = new byte[128];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Charset f24117t = StandardCharsets.ISO_8859_1;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24118a;

        static {
            int[] iArr = new int[c.values().length];
            f24118a = iArr;
            try {
                iArr[c.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24118a[c.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24118a[c.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        byte[] bArr = new byte[128];
        f24115r = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i7 = 0;
        int i8 = 0;
        while (true) {
            byte[] bArr2 = f24113p;
            if (i8 >= bArr2.length) {
                break;
            }
            byte b8 = bArr2[i8];
            if (b8 > 0) {
                f24115r[b8] = (byte) i8;
            }
            i8++;
        }
        Arrays.fill(f24116s, (byte) -1);
        while (true) {
            byte[] bArr3 = f24114q;
            if (i7 >= bArr3.length) {
                return;
            }
            byte b9 = bArr3[i7];
            if (b9 > 0) {
                f24116s[b9] = (byte) i7;
            }
            i7++;
        }
    }

    private g() {
    }

    private static int a(String str, int i7, Charset charset) throws w {
        int i8;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i9 = i7;
        while (i9 < length) {
            char cCharAt = str.charAt(i9);
            int i10 = 0;
            while (i10 < 13 && k(cCharAt) && (i8 = i9 + (i10 = i10 + 1)) < length) {
                cCharAt = str.charAt(i8);
            }
            if (i10 >= 13) {
                return i9 - i7;
            }
            char cCharAt2 = str.charAt(i9);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new w("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i9++;
        }
        return i9 - i7;
    }

    private static int b(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        int i8 = 0;
        if (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            while (k(cCharAt) && i7 < length) {
                i8++;
                i7++;
                if (i7 < length) {
                    cCharAt = charSequence.charAt(i7);
                }
            }
        }
        return i8;
    }

    private static int c(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        int i8 = i7;
        while (i8 < length) {
            char cCharAt = charSequence.charAt(i8);
            int i9 = 0;
            while (i9 < 13 && k(cCharAt) && i8 < length) {
                i9++;
                i8++;
                if (i8 < length) {
                    cCharAt = charSequence.charAt(i8);
                }
            }
            if (i9 < 13) {
                if (i9 <= 0) {
                    if (!n(charSequence.charAt(i8))) {
                        break;
                    }
                    i8++;
                }
            } else {
                return (i8 - i7) - i9;
            }
        }
        return i8 - i7;
    }

    private static void d(byte[] bArr, int i7, int i8, int i9, StringBuilder sb) {
        int i10;
        if (i8 == 1 && i9 == 0) {
            sb.append((char) 913);
        } else if (i8 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i8 >= 6) {
            char[] cArr = new char[5];
            i10 = i7;
            while ((i7 + i8) - i10 >= 6) {
                long j7 = 0;
                for (int i11 = 0; i11 < 6; i11++) {
                    j7 = (j7 << 8) + ((long) (bArr[i10 + i11] & 255));
                }
                for (int i12 = 0; i12 < 5; i12++) {
                    cArr[i12] = (char) (j7 % 900);
                    j7 /= 900;
                }
                for (int i13 = 4; i13 >= 0; i13--) {
                    sb.append(cArr[i13]);
                }
                i10 += 6;
            }
        } else {
            i10 = i7;
        }
        while (i10 < i7 + i8) {
            sb.append((char) (bArr[i10] & 255));
            i10++;
        }
    }

    static String e(String str, c cVar, Charset charset) throws w {
        com.google.zxing.common.d dVarA;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f24117t;
        } else if (!f24117t.equals(charset) && (dVarA = com.google.zxing.common.d.a(charset.name())) != null) {
            h(dVarA.c(), sb);
        }
        int length = str.length();
        int i7 = a.f24118a[cVar.ordinal()];
        if (i7 == 1) {
            g(str, 0, length, sb, 0);
        } else if (i7 == 2) {
            byte[] bytes = str.getBytes(charset);
            d(bytes, 0, bytes.length, 1, sb);
        } else if (i7 != 3) {
            int i8 = 0;
            int iG = 0;
            int i9 = 0;
            while (i8 < length) {
                int iB = b(str, i8);
                if (iB >= 13) {
                    sb.append((char) 902);
                    f(str, i8, iB, sb);
                    i8 += iB;
                    iG = 0;
                    i9 = 2;
                } else {
                    int iC = c(str, i8);
                    if (iC >= 5 || iB == length) {
                        if (i9 != 0) {
                            sb.append((char) 900);
                            iG = 0;
                            i9 = 0;
                        }
                        iG = g(str, i8, iC, sb, iG);
                        i8 += iC;
                    } else {
                        int iA = a(str, i8, charset);
                        if (iA == 0) {
                            iA = 1;
                        }
                        int i10 = iA + i8;
                        byte[] bytes2 = str.substring(i8, i10).getBytes(charset);
                        if (bytes2.length == 1 && i9 == 0) {
                            d(bytes2, 0, 1, 0, sb);
                        } else {
                            d(bytes2, 0, bytes2.length, i9, sb);
                            i9 = 1;
                            iG = 0;
                        }
                        i8 = i10;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            f(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static void f(String str, int i7, int i8, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i8 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i9 = 0;
        while (i9 < i8) {
            sb2.setLength(0);
            int iMin = Math.min(44, i8 - i9);
            StringBuilder sb3 = new StringBuilder("1");
            int i10 = i7 + i9;
            sb3.append(str.substring(i10, i10 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i9 += iMin;
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x00f6 A[EDGE_INSN: B:76:0x00f6->B:55:0x00f6 BREAK  A[LOOP:0: B:3:0x000f->B:93:0x000f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x000f A[SYNTHETIC] */
    private static int g(CharSequence charSequence, int i7, int i8, StringBuilder sb, int i9) {
        StringBuilder sb2 = new StringBuilder(i8);
        int i10 = i9;
        int i11 = 0;
        while (true) {
            int i12 = i7 + i11;
            char cCharAt = charSequence.charAt(i12);
            if (i10 == 0) {
                if (j(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'A'));
                    }
                } else if (i(cCharAt)) {
                    sb2.append((char) 27);
                    i10 = 1;
                } else if (l(cCharAt)) {
                    sb2.append((char) 28);
                    i10 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) f24116s[cCharAt]);
                }
                i11++;
                if (i11 >= i8) {
                    break;
                    break;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (m(cCharAt)) {
                            sb2.append((char) f24116s[cCharAt]);
                        } else {
                            sb2.append((char) 29);
                            i10 = 0;
                        }
                    } else if (l(cCharAt)) {
                        sb2.append((char) f24115r[cCharAt]);
                    } else if (j(cCharAt)) {
                        sb2.append((char) 28);
                        i10 = 0;
                    } else if (i(cCharAt)) {
                        sb2.append((char) 27);
                        i10 = 1;
                    } else {
                        int i13 = i12 + 1;
                        if (i13 >= i8 || !m(charSequence.charAt(i13))) {
                            sb2.append((char) 29);
                            sb2.append((char) f24116s[cCharAt]);
                        } else {
                            sb2.append((char) 25);
                            i10 = 3;
                        }
                    }
                } else if (i(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'a'));
                    }
                } else if (j(cCharAt)) {
                    sb2.append((char) 27);
                    sb2.append((char) (cCharAt - 'A'));
                } else if (l(cCharAt)) {
                    sb2.append((char) 28);
                    i10 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) f24116s[cCharAt]);
                }
                i11++;
                if (i11 >= i8) {
                    break;
                }
            }
        }
        int length = sb2.length();
        char cCharAt2 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            if (i14 % 2 != 0) {
                cCharAt2 = (char) ((cCharAt2 * 30) + sb2.charAt(i14));
                sb.append(cCharAt2);
            } else {
                cCharAt2 = sb2.charAt(i14);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((cCharAt2 * 30) + 29));
        }
        return i10;
    }

    private static void h(int i7, StringBuilder sb) throws w {
        if (i7 >= 0 && i7 < 900) {
            sb.append((char) 927);
            sb.append((char) i7);
        } else if (i7 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i7 / 900) - 1));
            sb.append((char) (i7 % 900));
        } else {
            if (i7 >= 811800) {
                throw new w("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i7)));
            }
            sb.append((char) 925);
            sb.append((char) (810900 - i7));
        }
    }

    private static boolean i(char c8) {
        if (c8 != ' ') {
            return c8 >= 'a' && c8 <= 'z';
        }
        return true;
    }

    private static boolean j(char c8) {
        if (c8 != ' ') {
            return c8 >= 'A' && c8 <= 'Z';
        }
        return true;
    }

    private static boolean k(char c8) {
        return c8 >= '0' && c8 <= '9';
    }

    private static boolean l(char c8) {
        return f24115r[c8] != -1;
    }

    private static boolean m(char c8) {
        return f24116s[c8] != -1;
    }

    private static boolean n(char c8) {
        if (c8 == '\t' || c8 == '\n' || c8 == '\r') {
            return true;
        }
        return c8 >= ' ' && c8 <= '~';
    }
}
