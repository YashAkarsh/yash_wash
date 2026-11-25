package androidx.constraintlayout.core.widgets;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a extends j {
    public static final int G1 = 0;
    public static final int H1 = 1;
    public static final int I1 = 2;
    public static final int J1 = 3;
    private static final boolean K1 = true;
    private static final boolean L1 = false;
    private int C1 = 0;
    private boolean D1 = true;
    private int E1 = 0;
    boolean F1 = false;

    public a() {
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public boolean G0() {
        return this.F1;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public boolean H0() {
        return this.F1;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void g(androidx.constraintlayout.core.e eVar, boolean z7) {
        d[] dVarArr;
        boolean z8;
        int i7;
        int i8;
        int i9;
        d[] dVarArr2 = this.Y;
        dVarArr2[0] = this.Q;
        dVarArr2[2] = this.R;
        dVarArr2[1] = this.S;
        dVarArr2[3] = this.T;
        int i10 = 0;
        while (true) {
            dVarArr = this.Y;
            if (i10 >= dVarArr.length) {
                break;
            }
            d dVar = dVarArr[i10];
            dVar.f3561i = eVar.u(dVar);
            i10++;
        }
        int i11 = this.C1;
        if (i11 < 0 || i11 >= 4) {
            return;
        }
        d dVar2 = dVarArr[i11];
        if (!this.F1) {
            m2();
        }
        if (this.F1) {
            this.F1 = false;
            int i12 = this.C1;
            if (i12 == 0 || i12 == 1) {
                eVar.f(this.Q.f3561i, this.f3615h0);
                eVar.f(this.S.f3561i, this.f3615h0);
                return;
            } else {
                if (i12 == 2 || i12 == 3) {
                    eVar.f(this.R.f3561i, this.f3617i0);
                    eVar.f(this.T.f3561i, this.f3617i0);
                    return;
                }
                return;
            }
        }
        int i13 = 0;
        while (true) {
            if (i13 >= this.B1) {
                z8 = false;
                break;
            }
            e eVar2 = this.A1[i13];
            if ((this.D1 || eVar2.h()) && ((((i8 = this.C1) == 0 || i8 == 1) && eVar2.H() == e.b.MATCH_CONSTRAINT && eVar2.Q.f3558f != null && eVar2.S.f3558f != null) || (((i9 = this.C1) == 2 || i9 == 3) && eVar2.j0() == e.b.MATCH_CONSTRAINT && eVar2.R.f3558f != null && eVar2.T.f3558f != null))) {
                z8 = true;
                break;
            }
            i13++;
        }
        boolean z9 = this.Q.m() || this.S.m();
        boolean z10 = this.R.m() || this.T.m();
        int i14 = !(!z8 && (((i7 = this.C1) == 0 && z9) || ((i7 == 2 && z10) || ((i7 == 1 && z9) || (i7 == 3 && z10))))) ? 4 : 5;
        for (int i15 = 0; i15 < this.B1; i15++) {
            e eVar3 = this.A1[i15];
            if (this.D1 || eVar3.h()) {
                androidx.constraintlayout.core.i iVarU = eVar.u(eVar3.Y[this.C1]);
                d[] dVarArr3 = eVar3.Y;
                int i16 = this.C1;
                d dVar3 = dVarArr3[i16];
                dVar3.f3561i = iVarU;
                d dVar4 = dVar3.f3558f;
                int i17 = (dVar4 == null || dVar4.f3556d != this) ? 0 : dVar3.f3559g + 0;
                if (i16 == 0 || i16 == 2) {
                    eVar.j(dVar2.f3561i, iVarU, this.E1 - i17, z8);
                } else {
                    eVar.h(dVar2.f3561i, iVarU, this.E1 + i17, z8);
                }
                eVar.e(dVar2.f3561i, iVarU, this.E1 + i17, i14);
            }
        }
        int i18 = this.C1;
        if (i18 == 0) {
            eVar.e(this.S.f3561i, this.Q.f3561i, 0, 8);
            eVar.e(this.Q.f3561i, this.f3605c0.S.f3561i, 0, 4);
            eVar.e(this.Q.f3561i, this.f3605c0.Q.f3561i, 0, 0);
            return;
        }
        if (i18 == 1) {
            eVar.e(this.Q.f3561i, this.S.f3561i, 0, 8);
            eVar.e(this.Q.f3561i, this.f3605c0.Q.f3561i, 0, 4);
            eVar.e(this.Q.f3561i, this.f3605c0.S.f3561i, 0, 0);
        } else if (i18 == 2) {
            eVar.e(this.T.f3561i, this.R.f3561i, 0, 8);
            eVar.e(this.R.f3561i, this.f3605c0.T.f3561i, 0, 4);
            eVar.e(this.R.f3561i, this.f3605c0.R.f3561i, 0, 0);
        } else if (i18 == 3) {
            eVar.e(this.R.f3561i, this.T.f3561i, 0, 8);
            eVar.e(this.R.f3561i, this.f3605c0.R.f3561i, 0, 4);
            eVar.e(this.R.f3561i, this.f3605c0.T.f3561i, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public boolean h() {
        return true;
    }

    public boolean m2() {
        int i7;
        int i8;
        int i9;
        boolean z7 = true;
        int i10 = 0;
        while (true) {
            i7 = this.B1;
            if (i10 >= i7) {
                break;
            }
            e eVar = this.A1[i10];
            if ((this.D1 || eVar.h()) && ((((i8 = this.C1) == 0 || i8 == 1) && !eVar.G0()) || (((i9 = this.C1) == 2 || i9 == 3) && !eVar.H0()))) {
                z7 = false;
            }
            i10++;
        }
        if (!z7 || i7 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z8 = false;
        for (int i11 = 0; i11 < this.B1; i11++) {
            e eVar2 = this.A1[i11];
            if (this.D1 || eVar2.h()) {
                if (!z8) {
                    int i12 = this.C1;
                    if (i12 == 0) {
                        iMax = eVar2.r(d.b.LEFT).f();
                    } else if (i12 == 1) {
                        iMax = eVar2.r(d.b.RIGHT).f();
                    } else if (i12 == 2) {
                        iMax = eVar2.r(d.b.TOP).f();
                    } else if (i12 == 3) {
                        iMax = eVar2.r(d.b.BOTTOM).f();
                    }
                    z8 = true;
                }
                int i13 = this.C1;
                if (i13 == 0) {
                    iMax = Math.min(iMax, eVar2.r(d.b.LEFT).f());
                } else if (i13 == 1) {
                    iMax = Math.max(iMax, eVar2.r(d.b.RIGHT).f());
                } else if (i13 == 2) {
                    iMax = Math.min(iMax, eVar2.r(d.b.TOP).f());
                } else if (i13 == 3) {
                    iMax = Math.max(iMax, eVar2.r(d.b.BOTTOM).f());
                }
            }
        }
        int i14 = iMax + this.E1;
        int i15 = this.C1;
        if (i15 == 0 || i15 == 1) {
            q1(i14, i14);
        } else {
            t1(i14, i14);
        }
        this.F1 = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.j, androidx.constraintlayout.core.widgets.e
    public void n(e eVar, HashMap<e, e> map) {
        super.n(eVar, map);
        a aVar = (a) eVar;
        this.C1 = aVar.C1;
        this.D1 = aVar.D1;
        this.E1 = aVar.E1;
    }

    @Deprecated
    public boolean n2() {
        return this.D1;
    }

    public boolean o2() {
        return this.D1;
    }

    public int p2() {
        return this.C1;
    }

    public int q2() {
        return this.E1;
    }

    public int r2() {
        int i7 = this.C1;
        if (i7 == 0 || i7 == 1) {
            return 0;
        }
        return (i7 == 2 || i7 == 3) ? 1 : -1;
    }

    protected void s2() {
        for (int i7 = 0; i7 < this.B1; i7++) {
            e eVar = this.A1[i7];
            if (this.D1 || eVar.h()) {
                int i8 = this.C1;
                if (i8 == 0 || i8 == 1) {
                    eVar.G1(0, true);
                } else if (i8 == 2 || i8 == 3) {
                    eVar.G1(1, true);
                }
            }
        }
    }

    public void t2(boolean z7) {
        this.D1 = z7;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public String toString() {
        String str = "[Barrier] " + y() + " {";
        for (int i7 = 0; i7 < this.B1; i7++) {
            e eVar = this.A1[i7];
            if (i7 > 0) {
                str = str + ", ";
            }
            str = str + eVar.y();
        }
        return str + com.alipay.sdk.util.j.f13808d;
    }

    public void u2(int i7) {
        this.C1 = i7;
    }

    public void v2(int i7) {
        this.E1 = i7;
    }

    public a(String str) {
        j1(str);
    }
}
