package com.google.zxing.aztec.decoder;

import com.alipay.sdk.util.j;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.common.reedsolomon.e;
import com.google.zxing.h;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.trace.api.TraceProtocolConst;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f23341b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f23342c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f23343d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f23344e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", m0.a.f37445e, "'", "(", ")", "*", "+", ",", "-", com.alibaba.android.arouter.utils.b.f12515h, "/", ":", j.f13806b, "<", "=", ">", "?", "[", "]", "{", j.f13808d, "CTRL_UL"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f23345f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE_BLE_ADV, TraceProtocolConst.PRO_CONFIG_PROFILE_BT_SECURITY, HttpHelper.b.f29530c, "9", ",", com.alibaba.android.arouter.utils.b.f12515h, "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z1.a f23346a;

    /* JADX INFO: renamed from: com.google.zxing.aztec.decoder.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0309a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23347a;

        static {
            int[] iArr = new int[b.values().length];
            f23347a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23347a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23347a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23347a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23347a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = i(zArr, i7 << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) throws h {
        int i7;
        com.google.zxing.common.reedsolomon.a aVar;
        if (this.f23346a.d() <= 2) {
            aVar = com.google.zxing.common.reedsolomon.a.f23601j;
            i7 = 6;
        } else {
            i7 = 8;
            if (this.f23346a.d() <= 8) {
                aVar = com.google.zxing.common.reedsolomon.a.f23605n;
            } else if (this.f23346a.d() <= 22) {
                aVar = com.google.zxing.common.reedsolomon.a.f23600i;
                i7 = 10;
            } else {
                aVar = com.google.zxing.common.reedsolomon.a.f23599h;
                i7 = 12;
            }
        }
        int iC = this.f23346a.c();
        int length = zArr.length / i7;
        if (length < iC) {
            throw h.a();
        }
        int length2 = zArr.length % i7;
        int[] iArr = new int[length];
        int i8 = 0;
        while (i8 < length) {
            iArr[i8] = j(zArr, length2, i7);
            i8++;
            length2 += i7;
        }
        try {
            new c(aVar).a(iArr, length - iC);
            int i9 = (1 << i7) - 1;
            int i10 = 0;
            for (int i11 = 0; i11 < iC; i11++) {
                int i12 = iArr[i11];
                if (i12 == 0 || i12 == i9) {
                    throw h.a();
                }
                if (i12 == 1 || i12 == i9 - 1) {
                    i10++;
                }
            }
            boolean[] zArr2 = new boolean[(iC * i7) - i10];
            int i13 = 0;
            for (int i14 = 0; i14 < iC; i14++) {
                int i15 = iArr[i14];
                if (i15 == 1 || i15 == i9 - 1) {
                    Arrays.fill(zArr2, i13, (i13 + i7) - 1, i15 > 1);
                    i13 += i7 - 1;
                } else {
                    int i16 = i7 - 1;
                    while (i16 >= 0) {
                        int i17 = i13 + 1;
                        zArr2[i13] = ((1 << i16) & i15) != 0;
                        i16--;
                        i13 = i17;
                    }
                }
            }
            return zArr2;
        } catch (e e8) {
            throw h.b(e8);
        }
    }

    private boolean[] d(com.google.zxing.common.b bVar) {
        boolean zE = this.f23346a.e();
        int iD = this.f23346a.d();
        int i7 = (zE ? 11 : 14) + (iD << 2);
        int[] iArr = new int[i7];
        boolean[] zArr = new boolean[k(iD, zE)];
        int i8 = 2;
        if (zE) {
            for (int i9 = 0; i9 < i7; i9++) {
                iArr[i9] = i9;
            }
        } else {
            int i10 = i7 / 2;
            int i11 = ((i7 + 1) + (((i10 - 1) / 15) * 2)) / 2;
            for (int i12 = 0; i12 < i10; i12++) {
                int i13 = (i12 / 15) + i12;
                iArr[(i10 - i12) - 1] = (i11 - i13) - 1;
                iArr[i10 + i12] = i13 + i11 + 1;
            }
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < iD) {
            int i16 = ((iD - i14) << i8) + (zE ? 9 : 12);
            int i17 = i14 << 1;
            int i18 = (i7 - 1) - i17;
            int i19 = 0;
            while (i19 < i16) {
                int i20 = i19 << 1;
                int i21 = 0;
                while (i21 < i8) {
                    int i22 = i17 + i21;
                    int i23 = i17 + i19;
                    zArr[i15 + i20 + i21] = bVar.j(iArr[i22], iArr[i23]);
                    int i24 = iArr[i23];
                    int i25 = i18 - i21;
                    zArr[(i16 * 2) + i15 + i20 + i21] = bVar.j(i24, iArr[i25]);
                    int i26 = i18 - i19;
                    zArr[(i16 * 4) + i15 + i20 + i21] = bVar.j(iArr[i25], iArr[i26]);
                    zArr[(i16 * 6) + i15 + i20 + i21] = bVar.j(iArr[i26], iArr[i22]);
                    i21++;
                    iD = iD;
                    zE = zE;
                    i8 = 2;
                }
                i19++;
                i8 = 2;
            }
            i15 += i16 << 3;
            i14++;
            i8 = 2;
        }
        return zArr;
    }

    private static String e(b bVar, int i7) {
        int i8 = C0309a.f23347a[bVar.ordinal()];
        if (i8 == 1) {
            return f23341b[i7];
        }
        if (i8 == 2) {
            return f23342c[i7];
        }
        if (i8 == 3) {
            return f23343d[i7];
        }
        if (i8 == 4) {
            return f23344e[i7];
        }
        if (i8 == 5) {
            return f23345f[i7];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVarG = bVar;
        int i7 = 0;
        while (i7 < length) {
            if (bVar != b.BINARY) {
                int i8 = bVar == b.DIGIT ? 4 : 5;
                if (length - i7 < i8) {
                    break;
                }
                int iJ = j(zArr, i7, i8);
                i7 += i8;
                String strE = e(bVar, iJ);
                if (strE.startsWith("CTRL_")) {
                    bVarG = g(strE.charAt(5));
                    if (strE.charAt(6) != 'L') {
                        bVarG = bVar;
                        bVar = bVarG;
                    }
                } else {
                    sb.append(strE);
                }
                bVar = bVarG;
            } else {
                if (length - i7 < 5) {
                    break;
                }
                int iJ2 = j(zArr, i7, 5);
                i7 += 5;
                if (iJ2 == 0) {
                    if (length - i7 < 11) {
                        break;
                    }
                    iJ2 = j(zArr, i7, 11) + 31;
                    i7 += 11;
                }
                for (int i9 = 0; i9 < iJ2; i9++) {
                    if (length - i7 < 8) {
                        i7 = length;
                        break;
                    }
                    sb.append((char) j(zArr, i7, 8));
                    i7 += 8;
                }
                bVar = bVarG;
            }
        }
        return sb.toString();
    }

    private static b g(char c8) {
        if (c8 == 'B') {
            return b.BINARY;
        }
        if (c8 == 'D') {
            return b.DIGIT;
        }
        if (c8 == 'P') {
            return b.PUNCT;
        }
        if (c8 != 'L') {
            return c8 != 'M' ? b.UPPER : b.MIXED;
        }
        return b.LOWER;
    }

    public static String h(boolean[] zArr) {
        return f(zArr);
    }

    private static byte i(boolean[] zArr, int i7) {
        int length = zArr.length - i7;
        return (byte) (length >= 8 ? j(zArr, i7, 8) : j(zArr, i7, length) << (8 - length));
    }

    private static int j(boolean[] zArr, int i7, int i8) {
        int i9 = 0;
        for (int i10 = i7; i10 < i7 + i8; i10++) {
            i9 <<= 1;
            if (zArr[i10]) {
                i9 |= 1;
            }
        }
        return i9;
    }

    private static int k(int i7, boolean z7) {
        return ((z7 ? 88 : 112) + (i7 << 4)) * i7;
    }

    public com.google.zxing.common.e c(z1.a aVar) throws h {
        this.f23346a = aVar;
        boolean[] zArrB = b(d(aVar.a()));
        com.google.zxing.common.e eVar = new com.google.zxing.common.e(a(zArrB), f(zArrB), null, null);
        eVar.n(zArrB.length);
        return eVar;
    }
}
