package com.google.zxing.qrcode.detector;

import com.google.zxing.m;
import com.google.zxing.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f24179a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f24185g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u f24187i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f24180b = new ArrayList(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f24186h = new int[3];

    b(com.google.zxing.common.b bVar, int i7, int i8, int i9, int i10, float f8, u uVar) {
        this.f24179a = bVar;
        this.f24181c = i7;
        this.f24182d = i8;
        this.f24183e = i9;
        this.f24184f = i10;
        this.f24185g = f8;
        this.f24187i = uVar;
    }

    private static float a(int[] iArr, int i7) {
        return (i7 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private float b(int i7, int i8, int i9, int i10) {
        com.google.zxing.common.b bVar = this.f24179a;
        int iM = bVar.m();
        int[] iArr = this.f24186h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i11 = i7;
        while (i11 >= 0 && bVar.j(i8, i11)) {
            int i12 = iArr[1];
            if (i12 > i9) {
                break;
            }
            iArr[1] = i12 + 1;
            i11--;
        }
        if (i11 >= 0 && iArr[1] <= i9) {
            while (i11 >= 0 && !bVar.j(i8, i11)) {
                int i13 = iArr[0];
                if (i13 > i9) {
                    break;
                }
                iArr[0] = i13 + 1;
                i11--;
            }
            if (iArr[0] > i9) {
                return Float.NaN;
            }
            int i14 = i7 + 1;
            while (i14 < iM && bVar.j(i8, i14)) {
                int i15 = iArr[1];
                if (i15 > i9) {
                    break;
                }
                iArr[1] = i15 + 1;
                i14++;
            }
            if (i14 != iM && iArr[1] <= i9) {
                while (i14 < iM && !bVar.j(i8, i14)) {
                    int i16 = iArr[2];
                    if (i16 > i9) {
                        break;
                    }
                    iArr[2] = i16 + 1;
                    i14++;
                }
                int i17 = iArr[2];
                if (i17 <= i9 && Math.abs(((iArr[0] + iArr[1]) + i17) - i10) * 5 < i10 * 2 && d(iArr)) {
                    return a(iArr, i14);
                }
            }
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f8 = this.f24185g;
        float f9 = f8 / 2.0f;
        for (int i7 = 0; i7 < 3; i7++) {
            if (Math.abs(f8 - iArr[i7]) >= f9) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i7, int i8) {
        int i9 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i8);
        float fB = b(i7, (int) fA, iArr[1] * 2, i9);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f8 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f24180b) {
            if (aVar.f(f8, fB, fA)) {
                return aVar.g(fB, fA, f8);
            }
        }
        a aVar2 = new a(fA, fB, f8);
        this.f24180b.add(aVar2);
        u uVar = this.f24187i;
        if (uVar == null) {
            return null;
        }
        uVar.a(aVar2);
        return null;
    }

    a c() throws m {
        a aVarE;
        a aVarE2;
        int i7 = this.f24181c;
        int i8 = this.f24184f;
        int i9 = this.f24183e + i7;
        int i10 = this.f24182d + (i8 / 2);
        int[] iArr = new int[3];
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = ((i11 & 1) == 0 ? (i11 + 1) / 2 : -((i11 + 1) / 2)) + i10;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i13 = i7;
            while (i13 < i9 && !this.f24179a.j(i13, i12)) {
                i13++;
            }
            int i14 = 0;
            while (i13 < i9) {
                if (!this.f24179a.j(i13, i12)) {
                    if (i14 == 1) {
                        i14++;
                    }
                    iArr[i14] = iArr[i14] + 1;
                } else if (i14 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i14 != 2) {
                    i14++;
                    iArr[i14] = iArr[i14] + 1;
                } else {
                    if (d(iArr) && (aVarE2 = e(iArr, i12, i13)) != null) {
                        return aVarE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i14 = 1;
                }
                i13++;
            }
            if (d(iArr) && (aVarE = e(iArr, i12, i9)) != null) {
                return aVarE;
            }
        }
        if (this.f24180b.isEmpty()) {
            throw m.a();
        }
        return this.f24180b.get(0);
    }
}
