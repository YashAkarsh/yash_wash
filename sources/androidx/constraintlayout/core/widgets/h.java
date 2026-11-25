package androidx.constraintlayout.core.widgets;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {
    public static final int I1 = 0;
    public static final int J1 = 1;
    public static final int K1 = 0;
    public static final int L1 = 1;
    public static final int M1 = 2;
    public static final int N1 = -1;
    protected float A1 = -1.0f;
    protected int B1 = -1;
    protected int C1 = -1;
    protected boolean D1 = true;
    private d E1 = this.R;
    private int F1 = 0;
    private int G1 = 0;
    private boolean H1;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3713a;

        static {
            int[] iArr = new int[d.b.values().length];
            f3713a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3713a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3713a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3713a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3713a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3713a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3713a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3713a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3713a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public h() {
        this.Z.clear();
        this.Z.add(this.E1);
        int length = this.Y.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.Y[i7] = this.E1;
        }
    }

    public void A2(int i7) {
        this.G1 = i7;
    }

    public void B2(int i7) {
        if (this.F1 == i7) {
            return;
        }
        this.F1 = i7;
        this.Z.clear();
        if (this.F1 == 1) {
            this.E1 = this.Q;
        } else {
            this.E1 = this.R;
        }
        this.Z.add(this.E1);
        int length = this.Y.length;
        for (int i8 = 0; i8 < length; i8++) {
            this.Y[i8] = this.E1;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public boolean G0() {
        return this.H1;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public boolean H0() {
        return this.H1;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public String f0() {
        return "Guideline";
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void g(androidx.constraintlayout.core.e eVar, boolean z7) {
        f fVar = (f) U();
        if (fVar == null) {
            return;
        }
        d dVarR = fVar.r(d.b.LEFT);
        d dVarR2 = fVar.r(d.b.RIGHT);
        e eVar2 = this.f3605c0;
        boolean z8 = eVar2 != null && eVar2.f3603b0[0] == e.b.WRAP_CONTENT;
        if (this.F1 == 0) {
            dVarR = fVar.r(d.b.TOP);
            dVarR2 = fVar.r(d.b.BOTTOM);
            e eVar3 = this.f3605c0;
            z8 = eVar3 != null && eVar3.f3603b0[1] == e.b.WRAP_CONTENT;
        }
        if (this.H1 && this.E1.o()) {
            androidx.constraintlayout.core.i iVarU = eVar.u(this.E1);
            eVar.f(iVarU, this.E1.f());
            if (this.B1 != -1) {
                if (z8) {
                    eVar.i(eVar.u(dVarR2), iVarU, 0, 5);
                }
            } else if (this.C1 != -1 && z8) {
                androidx.constraintlayout.core.i iVarU2 = eVar.u(dVarR2);
                eVar.i(iVarU, eVar.u(dVarR), 0, 5);
                eVar.i(iVarU2, iVarU, 0, 5);
            }
            this.H1 = false;
            return;
        }
        if (this.B1 != -1) {
            androidx.constraintlayout.core.i iVarU3 = eVar.u(this.E1);
            eVar.e(iVarU3, eVar.u(dVarR), this.B1, 8);
            if (z8) {
                eVar.i(eVar.u(dVarR2), iVarU3, 0, 5);
                return;
            }
            return;
        }
        if (this.C1 == -1) {
            if (this.A1 != -1.0f) {
                eVar.d(androidx.constraintlayout.core.e.w(eVar, eVar.u(this.E1), eVar.u(dVarR2), this.A1));
                return;
            }
            return;
        }
        androidx.constraintlayout.core.i iVarU4 = eVar.u(this.E1);
        androidx.constraintlayout.core.i iVarU5 = eVar.u(dVarR2);
        eVar.e(iVarU4, iVarU5, -this.C1, 8);
        if (z8) {
            eVar.i(iVarU4, eVar.u(dVarR), 0, 5);
            eVar.i(iVarU5, iVarU4, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void j2(androidx.constraintlayout.core.e eVar, boolean z7) {
        if (U() == null) {
            return;
        }
        int iO = eVar.O(this.E1);
        if (this.F1 == 1) {
            f2(iO);
            g2(0);
            y1(U().D());
            c2(0);
            return;
        }
        f2(0);
        g2(iO);
        c2(U().m0());
        y1(0);
    }

    public void k2() {
        if (this.B1 != -1) {
            t2();
        } else if (this.A1 != -1.0f) {
            s2();
        } else if (this.C1 != -1) {
            r2();
        }
    }

    public d l2() {
        return this.E1;
    }

    public int m2() {
        return this.F1;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void n(e eVar, HashMap<e, e> map) {
        super.n(eVar, map);
        h hVar = (h) eVar;
        this.A1 = hVar.A1;
        this.B1 = hVar.B1;
        this.C1 = hVar.C1;
        this.D1 = hVar.D1;
        B2(hVar.F1);
    }

    public int n2() {
        return this.B1;
    }

    public int o2() {
        if (this.A1 != -1.0f) {
            return 0;
        }
        if (this.B1 != -1) {
            return 1;
        }
        return this.C1 != -1 ? 2 : -1;
    }

    public int p2() {
        return this.C1;
    }

    public float q2() {
        return this.A1;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public d r(d.b bVar) {
        int i7 = a.f3713a[bVar.ordinal()];
        if (i7 == 1 || i7 == 2) {
            if (this.F1 == 1) {
                return this.E1;
            }
            return null;
        }
        if ((i7 == 3 || i7 == 4) && this.F1 == 0) {
            return this.E1;
        }
        return null;
    }

    void r2() {
        int iO0 = o0();
        if (this.F1 == 0) {
            iO0 = p0();
        }
        w2(iO0);
    }

    void s2() {
        int iM0 = U().m0() - o0();
        if (this.F1 == 0) {
            iM0 = U().D() - p0();
        }
        x2(iM0);
    }

    void t2() {
        float fO0 = o0() / U().m0();
        if (this.F1 == 0) {
            fO0 = p0() / U().D();
        }
        y2(fO0);
    }

    public boolean u2() {
        return this.A1 != -1.0f && this.B1 == -1 && this.C1 == -1;
    }

    public void v2(int i7) {
        this.E1.A(i7);
        this.H1 = true;
    }

    public void w2(int i7) {
        if (i7 > -1) {
            this.A1 = -1.0f;
            this.B1 = i7;
            this.C1 = -1;
        }
    }

    public void x2(int i7) {
        if (i7 > -1) {
            this.A1 = -1.0f;
            this.B1 = -1;
            this.C1 = i7;
        }
    }

    public void y2(float f8) {
        if (f8 > -1.0f) {
            this.A1 = f8;
            this.B1 = -1;
            this.C1 = -1;
        }
    }

    public void z2(int i7) {
        y2(i7 / 100.0f);
    }
}
