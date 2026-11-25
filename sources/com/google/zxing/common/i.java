package com.google.zxing.common;

import com.google.zxing.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f23576a = new f();

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0038 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:55:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x007d A[SYNTHETIC] */
    protected static void a(b bVar, float[] fArr) throws m {
        int iQ = bVar.q();
        int iM = bVar.m();
        boolean z7 = true;
        for (int i7 = 0; i7 < fArr.length && z7; i7 += 2) {
            int i8 = (int) fArr[i7];
            int i9 = i7 + 1;
            int i10 = (int) fArr[i9];
            if (i8 < -1 || i8 > iQ || i10 < -1 || i10 > iM) {
                throw m.a();
            }
            if (i8 == -1) {
                fArr[i7] = 0.0f;
            } else {
                if (i8 == iQ) {
                    fArr[i7] = iQ - 1;
                } else {
                    z7 = false;
                }
                if (i10 == -1) {
                    fArr[i9] = 0.0f;
                } else {
                    if (i10 == iM) {
                        fArr[i9] = iM - 1;
                    }
                }
                z7 = true;
            }
            z7 = true;
            if (i10 == -1) {
                fArr[i9] = 0.0f;
            } else {
                if (i10 == iM) {
                    fArr[i9] = iM - 1;
                }
            }
            z7 = true;
        }
        boolean z8 = true;
        for (int length = fArr.length - 2; length >= 0 && z8; length -= 2) {
            int i11 = (int) fArr[length];
            int i12 = length + 1;
            int i13 = (int) fArr[i12];
            if (i11 < -1 || i11 > iQ || i13 < -1 || i13 > iM) {
                throw m.a();
            }
            if (i11 == -1) {
                fArr[length] = 0.0f;
            } else {
                if (i11 == iQ) {
                    fArr[length] = iQ - 1;
                } else {
                    z8 = false;
                }
                if (i13 == -1) {
                    fArr[i12] = 0.0f;
                } else {
                    if (i13 == iM) {
                        fArr[i12] = iM - 1;
                    }
                }
                z8 = true;
            }
            z8 = true;
            if (i13 == -1) {
                fArr[i12] = 0.0f;
            } else {
                if (i13 == iM) {
                    fArr[i12] = iM - 1;
                }
            }
            z8 = true;
        }
    }

    public static i b() {
        return f23576a;
    }

    public static void e(i iVar) {
        f23576a = iVar;
    }

    public abstract b c(b bVar, int i7, int i8, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23) throws m;

    public abstract b d(b bVar, int i7, int i8, k kVar) throws m;
}
