package com.google.zxing.oned;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f23787d = 2.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f23788e = 1.5f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f23792i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f23794a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f23795b = new int[80];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23796c = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f23789f = "0123456789-$:/.+ABCD";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final char[] f23790g = f23789f.toCharArray();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f23791h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f23793j = {'A', 'B', 'C', 'D'};

    static boolean h(char[] cArr, char c8) {
        if (cArr != null) {
            for (char c9 : cArr) {
                if (c9 == c8) {
                    return true;
                }
            }
        }
        return false;
    }

    private void i(int i7) {
        int[] iArr = this.f23795b;
        int i8 = this.f23796c;
        iArr[i8] = i7;
        int i9 = i8 + 1;
        this.f23796c = i9;
        if (i9 >= iArr.length) {
            int[] iArr2 = new int[i9 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            this.f23795b = iArr2;
        }
    }

    private int j() throws com.google.zxing.m {
        for (int i7 = 1; i7 < this.f23796c; i7 += 2) {
            int iL = l(i7);
            if (iL != -1 && h(f23793j, f23790g[iL])) {
                int i8 = 0;
                for (int i9 = i7; i9 < i7 + 7; i9++) {
                    i8 += this.f23795b[i9];
                }
                if (i7 == 1 || this.f23795b[i7 - 1] >= i8 / 2) {
                    return i7;
                }
            }
        }
        throw com.google.zxing.m.a();
    }

    private void k(com.google.zxing.common.a aVar) throws com.google.zxing.m {
        int i7 = 0;
        this.f23796c = 0;
        int iN = aVar.n(0);
        int iO = aVar.o();
        if (iN >= iO) {
            throw com.google.zxing.m.a();
        }
        boolean z7 = true;
        while (iN < iO) {
            if (aVar.k(iN) != z7) {
                i7++;
            } else {
                i(i7);
                z7 = !z7;
                i7 = 1;
            }
            iN++;
        }
        i(i7);
    }

    private int l(int i7) {
        int i8 = i7 + 7;
        if (i8 >= this.f23796c) {
            return -1;
        }
        int[] iArr = this.f23795b;
        int i9 = Integer.MAX_VALUE;
        int i10 = 0;
        int i11 = Integer.MAX_VALUE;
        int i12 = 0;
        for (int i13 = i7; i13 < i8; i13 += 2) {
            int i14 = iArr[i13];
            if (i14 < i11) {
                i11 = i14;
            }
            if (i14 > i12) {
                i12 = i14;
            }
        }
        int i15 = (i11 + i12) / 2;
        int i16 = 0;
        for (int i17 = i7 + 1; i17 < i8; i17 += 2) {
            int i18 = iArr[i17];
            if (i18 < i9) {
                i9 = i18;
            }
            if (i18 > i16) {
                i16 = i18;
            }
        }
        int i19 = (i9 + i16) / 2;
        int i20 = 128;
        int i21 = 0;
        for (int i22 = 0; i22 < 7; i22++) {
            i20 >>= 1;
            if (iArr[i7 + i22] > ((i22 & 1) == 0 ? i15 : i19)) {
                i21 |= i20;
            }
        }
        while (true) {
            int[] iArr2 = f23791h;
            if (i10 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i10] == i21) {
                return i10;
            }
            i10++;
        }
    }

    private void m(int i7) throws com.google.zxing.m {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f23794a.length() - 1;
        int i8 = 0;
        int i9 = i7;
        int i10 = 0;
        while (true) {
            int i11 = f23791h[this.f23794a.charAt(i10)];
            for (int i12 = 6; i12 >= 0; i12--) {
                int i13 = (i12 & 1) + ((i11 & 1) << 1);
                iArr[i13] = iArr[i13] + this.f23795b[i9 + i12];
                iArr2[i13] = iArr2[i13] + 1;
                i11 >>= 1;
            }
            if (i10 >= length) {
                break;
            }
            i9 += 8;
            i10++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i14 = 0; i14 < 2; i14++) {
            fArr2[i14] = 0.0f;
            int i15 = i14 + 2;
            float f8 = iArr[i14] / iArr2[i14];
            int i16 = iArr[i15];
            int i17 = iArr2[i15];
            float f9 = (f8 + (i16 / i17)) / f23787d;
            fArr2[i15] = f9;
            fArr[i14] = f9;
            fArr[i15] = ((i16 * f23787d) + f23788e) / i17;
        }
        loop3: while (true) {
            int i18 = f23791h[this.f23794a.charAt(i8)];
            for (int i19 = 6; i19 >= 0; i19--) {
                int i20 = (i19 & 1) + ((i18 & 1) << 1);
                float f10 = this.f23795b[i7 + i19];
                if (f10 < fArr2[i20] || f10 > fArr[i20]) {
                    break loop3;
                }
                i18 >>= 1;
            }
            if (i8 >= length) {
                return;
            }
            i7 += 8;
            i8++;
        }
        throw com.google.zxing.m.a();
    }

    @Override // com.google.zxing.oned.r
    public com.google.zxing.r c(int i7, com.google.zxing.common.a aVar, Map<com.google.zxing.e, ?> map) throws com.google.zxing.m {
        Arrays.fill(this.f23795b, 0);
        k(aVar);
        int iJ = j();
        this.f23794a.setLength(0);
        int i8 = iJ;
        do {
            int iL = l(i8);
            if (iL == -1) {
                throw com.google.zxing.m.a();
            }
            this.f23794a.append((char) iL);
            i8 += 8;
            if (this.f23794a.length() > 1 && h(f23793j, f23790g[iL])) {
                break;
            }
        } while (i8 < this.f23796c);
        int i9 = i8 - 1;
        int i10 = this.f23795b[i9];
        int i11 = 0;
        for (int i12 = -8; i12 < -1; i12++) {
            i11 += this.f23795b[i8 + i12];
        }
        if (i8 < this.f23796c && i10 < i11 / 2) {
            throw com.google.zxing.m.a();
        }
        m(iJ);
        for (int i13 = 0; i13 < this.f23794a.length(); i13++) {
            StringBuilder sb = this.f23794a;
            sb.setCharAt(i13, f23790g[sb.charAt(i13)]);
        }
        char cCharAt = this.f23794a.charAt(0);
        char[] cArr = f23793j;
        if (!h(cArr, cCharAt)) {
            throw com.google.zxing.m.a();
        }
        StringBuilder sb2 = this.f23794a;
        if (!h(cArr, sb2.charAt(sb2.length() - 1))) {
            throw com.google.zxing.m.a();
        }
        if (this.f23794a.length() <= 3) {
            throw com.google.zxing.m.a();
        }
        if (map == null || !map.containsKey(com.google.zxing.e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f23794a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f23794a.deleteCharAt(0);
        }
        int i14 = 0;
        for (int i15 = 0; i15 < iJ; i15++) {
            i14 += this.f23795b[i15];
        }
        float f8 = i14;
        while (iJ < i9) {
            i14 += this.f23795b[iJ];
            iJ++;
        }
        float f9 = i7;
        return new com.google.zxing.r(this.f23794a.toString(), null, new com.google.zxing.t[]{new com.google.zxing.t(f8, f9), new com.google.zxing.t(i14, f9)}, com.google.zxing.a.CODABAR);
    }
}
