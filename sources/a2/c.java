package a2;

import com.google.zxing.m;
import com.google.zxing.t;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f24h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f25i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f26a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f27b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f29d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f30e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f31f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f32g;

    public c(com.google.zxing.common.b bVar) throws m {
        this(bVar, 10, bVar.q() / 2, bVar.m() / 2);
    }

    private t[] a(t tVar, t tVar2, t tVar3, t tVar4) {
        float fC = tVar.c();
        float fD = tVar.d();
        float fC2 = tVar2.c();
        float fD2 = tVar2.d();
        float fC3 = tVar3.c();
        float fD3 = tVar3.d();
        float fC4 = tVar4.c();
        float fD4 = tVar4.d();
        return fC < ((float) this.f28c) / 2.0f ? new t[]{new t(fC4 - 1.0f, fD4 + 1.0f), new t(fC2 + 1.0f, fD2 + 1.0f), new t(fC3 - 1.0f, fD3 - 1.0f), new t(fC + 1.0f, fD - 1.0f)} : new t[]{new t(fC4 + 1.0f, fD4 + 1.0f), new t(fC2 + 1.0f, fD2 - 1.0f), new t(fC3 - 1.0f, fD3 + 1.0f), new t(fC - 1.0f, fD - 1.0f)};
    }

    private boolean b(int i7, int i8, int i9, boolean z7) {
        if (z7) {
            while (i7 <= i8) {
                if (this.f26a.j(i7, i9)) {
                    return true;
                }
                i7++;
            }
            return false;
        }
        while (i7 <= i8) {
            if (this.f26a.j(i9, i7)) {
                return true;
            }
            i7++;
        }
        return false;
    }

    private t d(float f8, float f9, float f10, float f11) {
        int iC = a.c(a.a(f8, f9, f10, f11));
        float f12 = iC;
        float f13 = (f10 - f8) / f12;
        float f14 = (f11 - f9) / f12;
        for (int i7 = 0; i7 < iC; i7++) {
            float f15 = i7;
            int iC2 = a.c((f15 * f13) + f8);
            int iC3 = a.c((f15 * f14) + f9);
            if (this.f26a.j(iC2, iC3)) {
                return new t(iC2, iC3);
            }
        }
        return null;
    }

    public t[] c() throws m {
        int i7 = this.f29d;
        int i8 = this.f30e;
        int i9 = this.f32g;
        int i10 = this.f31f;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = true;
        while (z13) {
            boolean z14 = false;
            boolean zB = true;
            while (true) {
                if ((!zB && z8) || i8 >= this.f28c) {
                    break;
                }
                zB = b(i9, i10, i8, false);
                if (zB) {
                    i8++;
                    z8 = true;
                    z14 = true;
                } else if (!z8) {
                    i8++;
                }
            }
            if (i8 < this.f28c) {
                boolean zB2 = true;
                while (true) {
                    if ((!zB2 && z9) || i10 >= this.f27b) {
                        break;
                    }
                    zB2 = b(i7, i8, i10, true);
                    if (zB2) {
                        i10++;
                        z9 = true;
                        z14 = true;
                    } else if (!z9) {
                        i10++;
                    }
                }
                if (i10 < this.f27b) {
                    boolean zB3 = true;
                    while (true) {
                        if ((!zB3 && z10) || i7 < 0) {
                            break;
                        }
                        zB3 = b(i9, i10, i7, false);
                        if (zB3) {
                            i7--;
                            z10 = true;
                            z14 = true;
                        } else if (!z10) {
                            i7--;
                        }
                    }
                    if (i7 >= 0) {
                        z13 = z14;
                        boolean zB4 = true;
                        while (true) {
                            if ((!zB4 && z12) || i9 < 0) {
                                break;
                            }
                            zB4 = b(i7, i8, i9, true);
                            if (zB4) {
                                i9--;
                                z13 = true;
                                z12 = true;
                            } else if (!z12) {
                                i9--;
                            }
                        }
                        if (i9 >= 0) {
                            if (z13) {
                                z11 = true;
                            }
                        }
                    }
                }
            }
            z7 = true;
            break;
        }
        if (z7 || !z11) {
            throw m.a();
        }
        int i11 = i8 - i7;
        t tVarD = null;
        t tVarD2 = null;
        for (int i12 = 1; tVarD2 == null && i12 < i11; i12++) {
            tVarD2 = d(i7, i10 - i12, i7 + i12, i10);
        }
        if (tVarD2 == null) {
            throw m.a();
        }
        t tVarD3 = null;
        for (int i13 = 1; tVarD3 == null && i13 < i11; i13++) {
            tVarD3 = d(i7, i9 + i13, i7 + i13, i9);
        }
        if (tVarD3 == null) {
            throw m.a();
        }
        t tVarD4 = null;
        for (int i14 = 1; tVarD4 == null && i14 < i11; i14++) {
            tVarD4 = d(i8, i9 + i14, i8 - i14, i9);
        }
        if (tVarD4 == null) {
            throw m.a();
        }
        for (int i15 = 1; tVarD == null && i15 < i11; i15++) {
            tVarD = d(i8, i10 - i15, i8 - i15, i10);
        }
        if (tVarD != null) {
            return a(tVarD, tVarD2, tVarD4, tVarD3);
        }
        throw m.a();
    }

    public c(com.google.zxing.common.b bVar, int i7, int i8, int i9) throws m {
        this.f26a = bVar;
        int iM = bVar.m();
        this.f27b = iM;
        int iQ = bVar.q();
        this.f28c = iQ;
        int i10 = i7 / 2;
        int i11 = i8 - i10;
        this.f29d = i11;
        int i12 = i8 + i10;
        this.f30e = i12;
        int i13 = i9 - i10;
        this.f32g = i13;
        int i14 = i9 + i10;
        this.f31f = i14;
        if (i13 < 0 || i11 < 0 || i14 >= iM || i12 >= iQ) {
            throw m.a();
        }
    }
}
