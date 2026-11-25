package com.google.zxing.oned;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f23842e = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f23843f = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, com.alibaba.fastjson.asm.j.f12608d0, 448, 145, 400, 208, d4.d.f33486i, 388, 196, 168, com.alibaba.fastjson.asm.j.L, 138, 42};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f23844g = 148;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f23847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f23848d;

    public e() {
        this(false);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    private static String h(CharSequence charSequence) throws com.google.zxing.h {
        int i7;
        char c8;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i8 = 0;
        while (i8 < length) {
            char cCharAt = charSequence.charAt(i8);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i8++;
                char cCharAt2 = charSequence.charAt(i8);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c8 = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i7 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw com.google.zxing.h.a();
                                }
                                c8 = ':';
                            }
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw com.google.zxing.h.a();
                            }
                            i7 = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i7 = cCharAt2 - '&';
                    } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                        i7 = cCharAt2 - 11;
                    } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                        i7 = cCharAt2 + 16;
                    } else if (cCharAt2 >= 'P' && cCharAt2 <= 'T') {
                        i7 = cCharAt2 + '+';
                    } else if (cCharAt2 == 'U') {
                        c8 = 0;
                    } else if (cCharAt2 == 'V') {
                        c8 = '@';
                    } else if (cCharAt2 == 'W') {
                        c8 = '`';
                    } else {
                        if (cCharAt2 != 'X' && cCharAt2 != 'Y' && cCharAt2 != 'Z') {
                            throw com.google.zxing.h.a();
                        }
                        c8 = com.google.common.base.c.N;
                    }
                    sb.append(c8);
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw com.google.zxing.h.a();
                    }
                    i7 = cCharAt2 - '@';
                }
                c8 = (char) i7;
                sb.append(c8);
            } else {
                sb.append(cCharAt);
            }
            i8++;
        }
        return sb.toString();
    }

    private static int[] i(com.google.zxing.common.a aVar, int[] iArr) throws com.google.zxing.m {
        int iO = aVar.o();
        int iM = aVar.m(0);
        int length = iArr.length;
        boolean z7 = false;
        int i7 = 0;
        int i8 = iM;
        while (iM < iO) {
            if (aVar.k(iM) != z7) {
                iArr[i7] = iArr[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (k(iArr) == 148 && aVar.q(Math.max(0, i8 - ((iM - i8) / 2)), i8, false)) {
                        return new int[]{i8, iM};
                    }
                    i8 += iArr[0] + iArr[1];
                    int i9 = i7 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i9);
                    iArr[i9] = 0;
                    iArr[i7] = 0;
                    i7--;
                }
                iArr[i7] = 1;
                z7 = !z7;
            }
            iM++;
        }
        throw com.google.zxing.m.a();
    }

    private static char j(int i7) throws com.google.zxing.m {
        int i8 = 0;
        while (true) {
            int[] iArr = f23843f;
            if (i8 >= iArr.length) {
                if (i7 == 148) {
                    return '*';
                }
                throw com.google.zxing.m.a();
            }
            if (iArr[i8] == i7) {
                return f23842e.charAt(i8);
            }
            i8++;
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i7 = 0;
        while (true) {
            int i8 = Integer.MAX_VALUE;
            for (int i9 : iArr) {
                if (i9 < i8 && i9 > i7) {
                    i8 = i9;
                }
            }
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < length; i13++) {
                int i14 = iArr[i13];
                if (i14 > i8) {
                    i11 |= 1 << ((length - 1) - i13);
                    i10++;
                    i12 += i14;
                }
            }
            if (i10 == 3) {
                for (int i15 = 0; i15 < length && i10 > 0; i15++) {
                    int i16 = iArr[i15];
                    if (i16 > i8) {
                        i10--;
                        if ((i16 << 1) >= i12) {
                            return -1;
                        }
                    }
                }
                return i11;
            }
            if (i10 <= 3) {
                return -1;
            }
            i7 = i8;
        }
    }

    @Override // com.google.zxing.oned.r
    public com.google.zxing.r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m, com.google.zxing.d, com.google.zxing.h {
        int[] iArr = this.f23848d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f23847c;
        sb.setLength(0);
        int[] iArrI = i(aVar, iArr);
        int iM = aVar.m(iArrI[1]);
        int iO = aVar.o();
        while (true) {
            r.f(aVar, iM, iArr);
            int iK = k(iArr);
            if (iK < 0) {
                throw com.google.zxing.m.a();
            }
            char cJ = j(iK);
            sb.append(cJ);
            int i8 = iM;
            for (int i9 : iArr) {
                i8 += i9;
            }
            int iM2 = aVar.m(i8);
            if (cJ == '*') {
                sb.setLength(sb.length() - 1);
                int i10 = 0;
                for (int i11 : iArr) {
                    i10 += i11;
                }
                int i12 = (iM2 - iM) - i10;
                if (iM2 != iO && (i12 << 1) < i10) {
                    throw com.google.zxing.m.a();
                }
                if (this.f23845a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i13 = 0; i13 < length; i13++) {
                        iIndexOf += f23842e.indexOf(this.f23847c.charAt(i13));
                    }
                    if (sb.charAt(length) != f23842e.charAt(iIndexOf % 43)) {
                        throw com.google.zxing.d.a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw com.google.zxing.m.a();
                }
                float f8 = i7;
                return new com.google.zxing.r(this.f23846b ? h(sb) : sb.toString(), null, new com.google.zxing.t[]{new com.google.zxing.t((iArrI[1] + iArrI[0]) / 2.0f, f8), new com.google.zxing.t(iM + (i10 / 2.0f), f8)}, com.google.zxing.a.CODE_39);
            }
            iM = iM2;
        }
    }

    public e(boolean z7) {
        this(z7, false);
    }

    public e(boolean z7, boolean z8) {
        this.f23845a = z7;
        this.f23846b = z8;
        this.f23847c = new StringBuilder(20);
        this.f23848d = new int[9];
    }
}
