package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.e;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char f23747a = 65520;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char f23748b = 65521;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char f23749c = 65522;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f23750d = 65523;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f23751e = 65524;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f23752f = 65525;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f23753g = 65526;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f23754h = 65527;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char f23755i = 65528;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char f23756j = 65529;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final char f23757k = 65530;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char f23758l = 65531;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final char f23759m = 65532;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final char f23760n = 28;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final char f23761o = 29;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final char f23762p = 30;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f23763q = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private b() {
    }

    static e a(byte[] bArr, int i7) {
        String strH;
        StringBuilder sb = new StringBuilder(144);
        if (i7 == 2 || i7 == 3) {
            if (i7 == 2) {
                strH = new DecimalFormat("0000000000".substring(0, g(bArr))).format(f(bArr));
            } else {
                strH = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(c(bArr));
            String str2 = decimalFormat.format(i(bArr));
            sb.append(e(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strH + f23761o + str + f23761o + str2 + f23761o);
            } else {
                sb.insert(0, strH + f23761o + str + f23761o + str2 + f23761o);
            }
        } else if (i7 == 4) {
            sb.append(e(bArr, 1, 93));
        } else if (i7 == 5) {
            sb.append(e(bArr, 1, 77));
        }
        return new e(bArr, sb.toString(), null, String.valueOf(i7));
    }

    private static int b(int i7, byte[] bArr) {
        int i8 = i7 - 1;
        return ((1 << (5 - (i8 % 6))) & bArr[i8 / 6]) == 0 ? 0 : 1;
    }

    private static int c(byte[] bArr) {
        return d(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int d(byte[] bArr, byte[] bArr2) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int iB = 0;
        for (int i7 = 0; i7 < bArr2.length; i7++) {
            iB += b(bArr2[i7], bArr) << ((bArr2.length - i7) - 1);
        }
        return iB;
    }

    private static String e(byte[] bArr, int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        int i9 = i7;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        while (i9 < i7 + i8) {
            char cCharAt = f23763q[i11].charAt(bArr[i9]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i12 = i11;
                    i11 = cCharAt - f23747a;
                    i10 = 1;
                    break;
                case 65525:
                    i10 = 2;
                    i12 = i11;
                    i11 = 0;
                    break;
                case 65526:
                    i10 = 3;
                    i12 = i11;
                    i11 = 0;
                    break;
                case 65527:
                    i10 = -1;
                    i11 = 0;
                    break;
                case 65528:
                    i10 = -1;
                    i11 = 1;
                    break;
                case 65529:
                    i10 = -1;
                    break;
                case 65530:
                default:
                    sb.append(cCharAt);
                    break;
                case 65531:
                    int i13 = i9 + 1;
                    int i14 = bArr[i13] << com.google.common.base.c.B;
                    int i15 = i13 + 1;
                    int i16 = i14 + (bArr[i15] << com.google.common.base.c.f19321u);
                    int i17 = i15 + 1;
                    int i18 = i16 + (bArr[i17] << com.google.common.base.c.f19314n);
                    int i19 = i17 + 1;
                    int i20 = i18 + (bArr[i19] << 6);
                    i9 = i19 + 1;
                    sb.append(new DecimalFormat("000000000").format(i20 + bArr[i9]));
                    break;
            }
            int i21 = i10 - 1;
            if (i10 == 0) {
                i11 = i12;
            }
            i9++;
            i10 = i21;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int f(byte[] bArr) {
        return d(bArr, new byte[]{33, 34, 35, 36, com.google.common.base.c.C, com.google.common.base.c.D, com.google.common.base.c.E, com.google.common.base.c.F, com.google.common.base.c.G, com.google.common.base.c.H, 19, com.google.common.base.c.f19324x, com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.f19315o, com.google.common.base.c.f19316p, com.google.common.base.c.f19317q, com.google.common.base.c.f19318r, 17, com.google.common.base.c.f19321u, 7, 8, 9, 10, com.google.common.base.c.f19313m, com.google.common.base.c.f19314n, 1, 2});
    }

    private static int g(byte[] bArr) {
        return d(bArr, new byte[]{39, 40, 41, 42, com.google.common.base.c.I, 32});
    }

    private static String h(byte[] bArr) {
        String[] strArr = f23763q;
        return String.valueOf(new char[]{strArr[0].charAt(d(bArr, new byte[]{39, 40, 41, 42, com.google.common.base.c.I, 32})), strArr[0].charAt(d(bArr, new byte[]{33, 34, 35, 36, com.google.common.base.c.C, com.google.common.base.c.D})), strArr[0].charAt(d(bArr, new byte[]{com.google.common.base.c.E, com.google.common.base.c.F, com.google.common.base.c.G, com.google.common.base.c.H, 19, com.google.common.base.c.f19324x})), strArr[0].charAt(d(bArr, new byte[]{com.google.common.base.c.f19325y, com.google.common.base.c.f19326z, com.google.common.base.c.A, com.google.common.base.c.B, com.google.common.base.c.f19315o, com.google.common.base.c.f19316p})), strArr[0].charAt(d(bArr, new byte[]{com.google.common.base.c.f19317q, com.google.common.base.c.f19318r, 17, com.google.common.base.c.f19321u, 7, 8})), strArr[0].charAt(d(bArr, new byte[]{9, 10, com.google.common.base.c.f19313m, com.google.common.base.c.f19314n, 1, 2}))});
    }

    private static int i(byte[] bArr) {
        return d(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }
}
