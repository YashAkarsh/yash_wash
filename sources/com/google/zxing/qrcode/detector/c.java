package com.google.zxing.qrcode.detector;

import com.google.zxing.common.g;
import com.google.zxing.common.i;
import com.google.zxing.common.k;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.qrcode.decoder.j;
import com.google.zxing.t;
import com.google.zxing.u;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f24188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f24189b;

    public c(com.google.zxing.common.b bVar) {
        this.f24188a = bVar;
    }

    private float b(t tVar, t tVar2) {
        float fM = m((int) tVar.c(), (int) tVar.d(), (int) tVar2.c(), (int) tVar2.d());
        float fM2 = m((int) tVar2.c(), (int) tVar2.d(), (int) tVar.c(), (int) tVar.d());
        if (Float.isNaN(fM)) {
            return fM2 / 7.0f;
        }
        return Float.isNaN(fM2) ? fM / 7.0f : (fM + fM2) / 14.0f;
    }

    private static int c(t tVar, t tVar2, t tVar3, float f8) throws m {
        int iC = ((a2.a.c(t.b(tVar, tVar2) / f8) + a2.a.c(t.b(tVar, tVar3) / f8)) / 2) + 7;
        int i7 = iC & 3;
        if (i7 == 0) {
            return iC + 1;
        }
        if (i7 == 2) {
            return iC - 1;
        }
        if (i7 != 3) {
            return iC;
        }
        throw m.a();
    }

    private static k d(t tVar, t tVar2, t tVar3, t tVar4, int i7) {
        float fC;
        float fD;
        float f8;
        float f9 = i7 - 3.5f;
        if (tVar4 != null) {
            fC = tVar4.c();
            fD = tVar4.d();
            f8 = f9 - 3.0f;
        } else {
            fC = (tVar2.c() - tVar.c()) + tVar3.c();
            fD = (tVar2.d() - tVar.d()) + tVar3.d();
            f8 = f9;
        }
        return k.b(3.5f, 3.5f, f9, 3.5f, f8, f8, 3.5f, f9, tVar.c(), tVar.d(), tVar2.c(), tVar2.d(), fC, fD, tVar3.c(), tVar3.d());
    }

    private static com.google.zxing.common.b k(com.google.zxing.common.b bVar, k kVar, int i7) throws m {
        return i.b().d(bVar, i7, i7, kVar);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0089  */
    /* JADX WARN: Code duplicated, block: B:43:0x0090 A[RETURN] */
    private float l(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = 1;
        boolean z7 = Math.abs(i10 - i8) > Math.abs(i9 - i7);
        if (z7) {
            i12 = i7;
            i11 = i8;
            i14 = i9;
            i13 = i10;
        } else {
            i11 = i7;
            i12 = i8;
            i13 = i9;
            i14 = i10;
        }
        int iAbs = Math.abs(i13 - i11);
        int iAbs2 = Math.abs(i14 - i12);
        int i17 = 2;
        int i18 = (-iAbs) / 2;
        int i19 = i11 < i13 ? 1 : -1;
        int i20 = i12 < i14 ? 1 : -1;
        int i21 = i13 + i19;
        int i22 = i11;
        int i23 = i12;
        int i24 = 0;
        while (i22 != i21) {
            if ((i24 == i16 ? i16 : 0) == this.f24188a.j(z7 ? i23 : i22, z7 ? i22 : i23)) {
                if (i24 == 2) {
                    return a2.a.b(i22, i23, i11, i12);
                }
                i24++;
            }
            i18 += iAbs2;
            if (i18 > 0) {
                if (i23 == i14) {
                    i15 = 2;
                    if (i24 == i15) {
                        return a2.a.b(i21, i14, i11, i12);
                    }
                    return Float.NaN;
                }
                i23 += i20;
                i18 -= iAbs;
            }
            i22 += i19;
            i21 = i21;
            z7 = z7;
            i16 = 1;
            i17 = 2;
        }
        i21 = i21;
        i15 = i17;
        if (i24 == i15) {
            return a2.a.b(i21, i14, i11, i12);
        }
        return Float.NaN;
    }

    private float m(int i7, int i8, int i9, int i10) {
        float fQ;
        float fM;
        float fL = l(i7, i8, i9, i10);
        int iQ = i7 - (i9 - i7);
        int iM = 0;
        if (iQ < 0) {
            fQ = i7 / (i7 - iQ);
            iQ = 0;
        } else if (iQ >= this.f24188a.q()) {
            fQ = ((this.f24188a.q() - 1) - i7) / (iQ - i7);
            iQ = this.f24188a.q() - 1;
        } else {
            fQ = 1.0f;
        }
        float f8 = i8;
        int i11 = (int) (f8 - ((i10 - i8) * fQ));
        if (i11 < 0) {
            fM = f8 / (i8 - i11);
        } else if (i11 >= this.f24188a.m()) {
            fM = ((this.f24188a.m() - 1) - i8) / (i11 - i8);
            iM = this.f24188a.m() - 1;
        } else {
            iM = i11;
            fM = 1.0f;
        }
        return (fL + l(i7, i8, (int) (i7 + ((iQ - i7) * fM)), iM)) - 1.0f;
    }

    protected final float a(t tVar, t tVar2, t tVar3) {
        return (b(tVar, tVar2) + b(tVar, tVar3)) / 2.0f;
    }

    public g e() throws m, h {
        return f(null);
    }

    public final g f(Map<com.google.zxing.e, ?> map) throws m, h {
        u uVar = map == null ? null : (u) map.get(com.google.zxing.e.NEED_RESULT_POINT_CALLBACK);
        this.f24189b = uVar;
        return j(new e(this.f24188a, uVar).f(map));
    }

    protected final a g(float f8, int i7, int i8, float f9) throws m {
        int i9 = (int) (f9 * f8);
        int iMax = Math.max(0, i7 - i9);
        int iMin = Math.min(this.f24188a.q() - 1, i7 + i9) - iMax;
        float f10 = 3.0f * f8;
        if (iMin < f10) {
            throw m.a();
        }
        int iMax2 = Math.max(0, i8 - i9);
        int iMin2 = Math.min(this.f24188a.m() - 1, i8 + i9) - iMax2;
        if (iMin2 >= f10) {
            return new b(this.f24188a, iMax, iMax2, iMin, iMin2, f8, this.f24189b).c();
        }
        throw m.a();
    }

    protected final com.google.zxing.common.b h() {
        return this.f24188a;
    }

    protected final u i() {
        return this.f24189b;
    }

    protected final g j(f fVar) throws m, h {
        a aVarG;
        d dVarB = fVar.b();
        d dVarC = fVar.c();
        d dVarA = fVar.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw m.a();
        }
        int iC = c(dVarB, dVarC, dVarA, fA);
        j jVarG = j.g(iC);
        int iE = jVarG.e() - 7;
        if (jVarG.d().length <= 0) {
            aVarG = null;
            break;
        }
        float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
        float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
        float f8 = 1.0f - (3.0f / iE);
        int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f8));
        int iD = (int) (dVarB.d() + (f8 * (fD - dVarB.d())));
        int i7 = 4;
        while (true) {
            if (i7 > 16) {
                aVarG = null;
                break;
            }
            try {
                aVarG = g(fA, iC2, iD, i7);
                break;
            } catch (m unused) {
                i7 <<= 1;
            }
        }
        return new g(k(this.f24188a, d(dVarB, dVarC, dVarA, aVarG, iC), iC), aVarG == null ? new t[]{dVarA, dVarB, dVarC} : new t[]{dVarA, dVarB, dVarC, aVarG});
    }
}
