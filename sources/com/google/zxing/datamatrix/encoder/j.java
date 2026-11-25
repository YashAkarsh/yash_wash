package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char f23675a = 129;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final char f23676b = 230;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final char f23677c = 231;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final char f23678d = 235;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f23679e = 236;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f23680f = 237;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final char f23681g = 238;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final char f23682h = 239;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final char f23683i = 240;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final char f23684j = 254;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final char f23685k = 254;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f23686l = "[)>\u001e05\u001d";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f23687m = "[)>\u001e06\u001d";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f23688n = "\u001e\u0004";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int f23689o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final int f23690p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final int f23691q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final int f23692r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final int f23693s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final int f23694t = 5;

    private j() {
    }

    public static int a(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        int i8 = 0;
        if (i7 < length) {
            char cCharAt = charSequence.charAt(i7);
            while (g(cCharAt) && i7 < length) {
                i8++;
                i7++;
                if (i7 < length) {
                    cCharAt = charSequence.charAt(i7);
                }
            }
        }
        return i8;
    }

    public static String b(String str) {
        return c(str, l.FORCE_NONE, null, null);
    }

    public static String c(String str, l lVar, com.google.zxing.f fVar, com.google.zxing.f fVar2) {
        int iF = 0;
        g[] gVarArr = {new a(), new c(), new m(), new n(), new f(), new b()};
        h hVar = new h(str);
        hVar.o(lVar);
        hVar.m(fVar, fVar2);
        if (str.startsWith(f23686l) && str.endsWith(f23688n)) {
            hVar.s(f23679e);
            hVar.n(2);
            hVar.f23666f += 7;
        } else if (str.startsWith(f23687m) && str.endsWith(f23688n)) {
            hVar.s(f23680f);
            hVar.n(2);
            hVar.f23666f += 7;
        }
        while (hVar.j()) {
            gVarArr[iF].b(hVar);
            if (hVar.f() >= 0) {
                iF = hVar.f();
                hVar.k();
            }
        }
        int iA = hVar.a();
        hVar.q();
        int iB = hVar.h().b();
        if (iA < iB && iF != 0 && iF != 5 && iF != 4) {
            hVar.s((char) 254);
        }
        StringBuilder sbB = hVar.b();
        if (sbB.length() < iB) {
            sbB.append(f23675a);
        }
        while (sbB.length() < iB) {
            sbB.append(p(f23675a, sbB.length() + 1));
        }
        return hVar.b().toString();
    }

    private static int d(float[] fArr, int[] iArr, int i7, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i8 = 0; i8 < 6; i8++) {
            int iCeil = (int) Math.ceil(fArr[i8]);
            iArr[i8] = iCeil;
            if (i7 > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i7 = iCeil;
            }
            if (i7 == iCeil) {
                bArr[i8] = (byte) (bArr[i8] + 1);
            }
        }
        return i7;
    }

    private static int e(byte[] bArr) {
        int i7 = 0;
        for (int i8 = 0; i8 < 6; i8++) {
            i7 += bArr[i8];
        }
        return i7;
    }

    static void f(char c8) {
        String hexString = Integer.toHexString(c8);
        throw new IllegalArgumentException("Illegal character: " + c8 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    static boolean g(char c8) {
        return c8 >= '0' && c8 <= '9';
    }

    static boolean h(char c8) {
        return c8 >= 128 && c8 <= 255;
    }

    private static boolean i(char c8) {
        if (c8 == ' ') {
            return true;
        }
        if (c8 < '0' || c8 > '9') {
            return c8 >= 'A' && c8 <= 'Z';
        }
        return true;
    }

    private static boolean j(char c8) {
        return c8 >= ' ' && c8 <= '^';
    }

    private static boolean k(char c8) {
        if (c8 == ' ') {
            return true;
        }
        if (c8 < '0' || c8 > '9') {
            return c8 >= 'a' && c8 <= 'z';
        }
        return true;
    }

    private static boolean l(char c8) {
        if (n(c8) || c8 == ' ') {
            return true;
        }
        if (c8 < '0' || c8 > '9') {
            return c8 >= 'A' && c8 <= 'Z';
        }
        return true;
    }

    private static boolean m(char c8) {
        return false;
    }

    private static boolean n(char c8) {
        return c8 == '\r' || c8 == '*' || c8 == '>';
    }

    static int o(CharSequence charSequence, int i7, int i8) {
        float[] fArr;
        char c8;
        if (i7 >= charSequence.length()) {
            return i8;
        }
        int i9 = 6;
        if (i8 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i8] = 0.0f;
        }
        int i10 = 0;
        while (true) {
            int i11 = i7 + i10;
            if (i11 == charSequence.length()) {
                byte[] bArr = new byte[i9];
                int[] iArr = new int[i9];
                int iD = d(fArr, iArr, Integer.MAX_VALUE, bArr);
                int iE = e(bArr);
                if (iArr[0] == iD) {
                    return 0;
                }
                if (iE == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (iE == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (iE != 1 || bArr[2] <= 0) {
                    return (iE != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char cCharAt = charSequence.charAt(i11);
            i10++;
            if (g(cCharAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (h(cCharAt)) {
                float fCeil = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil;
                fArr[0] = fCeil + 2.0f;
            } else {
                float fCeil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil2;
                fArr[0] = fCeil2 + 1.0f;
            }
            if (i(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (h(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (k(cCharAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (h(cCharAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (l(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (h(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (j(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (h(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (m(cCharAt)) {
                c8 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c8 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i10 >= 4) {
                int[] iArr2 = new int[i9];
                byte[] bArr2 = new byte[i9];
                d(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int iE2 = e(bArr2);
                int i12 = iArr2[0];
                int i13 = iArr2[c8];
                if (i12 < i13 && i12 < iArr2[1] && i12 < iArr2[2] && i12 < iArr2[3] && i12 < iArr2[4]) {
                    return 0;
                }
                if (i13 < i12) {
                    return 5;
                }
                byte b8 = bArr2[1];
                byte b9 = bArr2[2];
                byte b10 = bArr2[3];
                byte b11 = bArr2[4];
                if (b8 + b9 + b10 + b11 == 0) {
                    return 5;
                }
                if (iE2 == 1 && b11 > 0) {
                    return 4;
                }
                if (iE2 == 1 && b9 > 0) {
                    return 2;
                }
                if (iE2 == 1 && b10 > 0) {
                    return 3;
                }
                int i14 = iArr2[1];
                if (i14 + 1 < i12 && i14 + 1 < i13 && i14 + 1 < iArr2[4] && i14 + 1 < iArr2[2]) {
                    int i15 = iArr2[3];
                    if (i14 < i15) {
                        return 1;
                    }
                    if (i14 == i15) {
                        for (int i16 = i7 + i10 + 1; i16 < charSequence.length(); i16++) {
                            char cCharAt2 = charSequence.charAt(i16);
                            if (n(cCharAt2)) {
                                return 3;
                            }
                            if (!l(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
            i9 = 6;
        }
    }

    private static char p(char c8, int i7) {
        int i8 = c8 + ((i7 * com.alibaba.fastjson.asm.j.D) % 253) + 1;
        if (i8 > 254) {
            i8 -= 254;
        }
        return (char) i8;
    }
}
