package com.google.zxing.oned;

import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends y {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f23797l = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int[][] f23798m = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f23799k = new int[4];

    public static String s(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c8 = cArr[5];
        switch (c8) {
            case ConstraintLayout.LayoutParams.a.W /* 48 */:
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c8);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case ConstraintLayout.LayoutParams.a.Z /* 51 */:
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case ConstraintLayout.LayoutParams.a.f4569a0 /* 52 */:
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c8);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    private static void t(StringBuilder sb, int i7) throws com.google.zxing.m {
        for (int i8 = 0; i8 <= 1; i8++) {
            for (int i9 = 0; i9 < 10; i9++) {
                if (i7 == f23798m[i8][i9]) {
                    sb.insert(0, (char) (i8 + 48));
                    sb.append((char) (i9 + 48));
                    return;
                }
            }
        }
        throw com.google.zxing.m.a();
    }

    @Override // com.google.zxing.oned.y
    protected boolean h(String str) throws com.google.zxing.h {
        return super.h(s(str));
    }

    @Override // com.google.zxing.oned.y
    protected int[] k(com.google.zxing.common.a aVar, int i7) throws com.google.zxing.m {
        return y.n(aVar, i7, true, f23797l);
    }

    @Override // com.google.zxing.oned.y
    protected int l(com.google.zxing.common.a aVar, int[] iArr, StringBuilder sb) throws com.google.zxing.m {
        int[] iArr2 = this.f23799k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iO = aVar.o();
        int i7 = iArr[1];
        int i8 = 0;
        for (int i9 = 0; i9 < 6 && i7 < iO; i9++) {
            int iJ = y.j(aVar, iArr2, i7, y.f23986j);
            sb.append((char) ((iJ % 10) + 48));
            for (int i10 : iArr2) {
                i7 += i10;
            }
            if (iJ >= 10) {
                i8 |= 1 << (5 - i9);
            }
        }
        t(sb, i8);
        return i7;
    }

    @Override // com.google.zxing.oned.y
    com.google.zxing.a q() {
        return com.google.zxing.a.UPC_E;
    }
}
