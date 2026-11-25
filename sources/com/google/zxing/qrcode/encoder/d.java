package com.google.zxing.qrcode.encoder;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24213a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24214b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24215c = 40;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f24216d = 10;

    private d() {
    }

    static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z7) {
        int iD = z7 ? bVar.d() : bVar.e();
        int iE = z7 ? bVar.e() : bVar.d();
        byte[][] bArrC = bVar.c();
        int i7 = 0;
        for (int i8 = 0; i8 < iD; i8++) {
            byte b8 = -1;
            int i9 = 0;
            for (int i10 = 0; i10 < iE; i10++) {
                byte b9 = z7 ? bArrC[i8][i10] : bArrC[i10][i8];
                if (b9 == b8) {
                    i9++;
                } else {
                    if (i9 >= 5) {
                        i7 += (i9 - 5) + 3;
                    }
                    i9 = 1;
                    b8 = b9;
                }
            }
            if (i9 >= 5) {
                i7 += (i9 - 5) + 3;
            }
        }
        return i7;
    }

    static int c(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i7 = 0;
        for (int i8 = 0; i8 < iD - 1; i8++) {
            byte[] bArr = bArrC[i8];
            int i9 = 0;
            while (i9 < iE - 1) {
                byte b8 = bArr[i9];
                int i10 = i9 + 1;
                if (b8 == bArr[i10]) {
                    byte[] bArr2 = bArrC[i8 + 1];
                    if (b8 == bArr2[i9] && b8 == bArr2[i10]) {
                        i7++;
                    }
                }
                i9 = i10;
            }
        }
        return i7 * 3;
    }

    static int d(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i7 = 0;
        for (int i8 = 0; i8 < iD; i8++) {
            for (int i9 = 0; i9 < iE; i9++) {
                byte[] bArr = bArrC[i8];
                int i10 = i9 + 6;
                if (i10 < iE && bArr[i9] == 1 && bArr[i9 + 1] == 0 && bArr[i9 + 2] == 1 && bArr[i9 + 3] == 1 && bArr[i9 + 4] == 1 && bArr[i9 + 5] == 0 && bArr[i10] == 1 && (g(bArr, i9 - 4, i9) || g(bArr, i9 + 7, i9 + 11))) {
                    i7++;
                }
                int i11 = i8 + 6;
                if (i11 < iD && bArrC[i8][i9] == 1 && bArrC[i8 + 1][i9] == 0 && bArrC[i8 + 2][i9] == 1 && bArrC[i8 + 3][i9] == 1 && bArrC[i8 + 4][i9] == 1 && bArrC[i8 + 5][i9] == 0 && bArrC[i11][i9] == 1 && (h(bArrC, i9, i8 - 4, i8) || h(bArrC, i9, i8 + 7, i8 + 11))) {
                    i7++;
                }
            }
        }
        return i7 * 40;
    }

    static int e(b bVar) {
        byte[][] bArrC = bVar.c();
        int iE = bVar.e();
        int iD = bVar.d();
        int i7 = 0;
        for (int i8 = 0; i8 < iD; i8++) {
            byte[] bArr = bArrC[i8];
            for (int i9 = 0; i9 < iE; i9++) {
                if (bArr[i9] == 1) {
                    i7++;
                }
            }
        }
        int iD2 = bVar.d() * bVar.e();
        return ((Math.abs((i7 << 1) - iD2) * 10) / iD2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x003e A[RETURN] */
    static boolean f(int i7, int i8, int i9) {
        int i10;
        int i11;
        switch (i7) {
            case 0:
                i9 += i8;
                i10 = i9 & 1;
                if (i10 == 0) {
                    return true;
                }
                return false;
            case 1:
                i10 = i9 & 1;
                if (i10 == 0) {
                    return true;
                }
                return false;
            case 2:
                i10 = i8 % 3;
                if (i10 == 0) {
                    return true;
                }
                return false;
            case 3:
                i10 = (i9 + i8) % 3;
                if (i10 == 0) {
                    return true;
                }
                return false;
            case 4:
                i9 /= 2;
                i8 /= 3;
                i9 += i8;
                i10 = i9 & 1;
                if (i10 == 0) {
                    return true;
                }
                return false;
            case 5:
                int i12 = i9 * i8;
                i10 = (i12 & 1) + (i12 % 3);
                if (i10 == 0) {
                    return true;
                }
                return false;
            case 6:
                int i13 = i9 * i8;
                i11 = (i13 & 1) + (i13 % 3);
                i10 = i11 & 1;
                if (i10 == 0) {
                    return true;
                }
                return false;
            case 7:
                i11 = ((i9 * i8) % 3) + ((i9 + i8) & 1);
                i10 = i11 & 1;
                if (i10 == 0) {
                    return true;
                }
                return false;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i7)));
        }
    }

    private static boolean g(byte[] bArr, int i7, int i8) {
        int iMin = Math.min(i8, bArr.length);
        for (int iMax = Math.max(i7, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i7, int i8, int i9) {
        int iMin = Math.min(i9, bArr.length);
        for (int iMax = Math.max(i8, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i7] == 1) {
                return false;
            }
        }
        return true;
    }
}
