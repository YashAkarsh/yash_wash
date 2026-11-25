package androidx.constraintlayout.core.widgets;

import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class n extends j {
    private int C1 = 0;
    private int D1 = 0;
    private int E1 = 0;
    private int F1 = 0;
    private int G1 = 0;
    private int H1 = 0;
    private int I1 = 0;
    private int J1 = 0;
    private boolean K1 = false;
    private int L1 = 0;
    private int M1 = 0;
    protected androidx.constraintlayout.core.widgets.analyzer.b.a N1 = new androidx.constraintlayout.core.widgets.analyzer.b.a();
    androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b O1 = null;

    public void A2(int i7, int i8) {
        this.L1 = i7;
        this.M1 = i8;
    }

    public void B2(int i7) {
        this.E1 = i7;
        this.C1 = i7;
        this.F1 = i7;
        this.D1 = i7;
        this.G1 = i7;
        this.H1 = i7;
    }

    public void C2(int i7) {
        this.D1 = i7;
    }

    public void D2(int i7) {
        this.H1 = i7;
    }

    public void E2(int i7) {
        this.E1 = i7;
        this.I1 = i7;
    }

    public void F2(int i7) {
        this.F1 = i7;
        this.J1 = i7;
    }

    public void G2(int i7) {
        this.G1 = i7;
        this.I1 = i7;
        this.J1 = i7;
    }

    public void H2(int i7) {
        this.C1 = i7;
    }

    @Override // androidx.constraintlayout.core.widgets.j, androidx.constraintlayout.core.widgets.i
    public void c(f fVar) {
        n2();
    }

    public void m2(boolean z7) {
        int i7 = this.G1;
        if (i7 > 0 || this.H1 > 0) {
            if (z7) {
                this.I1 = this.H1;
                this.J1 = i7;
            } else {
                this.I1 = i7;
                this.J1 = this.H1;
            }
        }
    }

    public void n2() {
        for (int i7 = 0; i7 < this.B1; i7++) {
            e eVar = this.A1[i7];
            if (eVar != null) {
                eVar.I1(true);
            }
        }
    }

    public boolean o2(HashSet<e> hashSet) {
        for (int i7 = 0; i7 < this.B1; i7++) {
            if (hashSet.contains(this.A1[i7])) {
                return true;
            }
        }
        return false;
    }

    public int p2() {
        return this.M1;
    }

    public int q2() {
        return this.L1;
    }

    public int r2() {
        return this.D1;
    }

    public int s2() {
        return this.I1;
    }

    public int t2() {
        return this.J1;
    }

    public int u2() {
        return this.C1;
    }

    public void v2(int i7, int i8, int i9, int i10) {
    }

    protected void w2(e eVar, e.b bVar, int i7, e.b bVar2, int i8) {
        while (this.O1 == null && U() != null) {
            this.O1 = ((f) U()).G2();
        }
        androidx.constraintlayout.core.widgets.analyzer.b.a aVar = this.N1;
        aVar.f3427a = bVar;
        aVar.f3428b = bVar2;
        aVar.f3429c = i7;
        aVar.f3430d = i8;
        this.O1.b(eVar, aVar);
        eVar.c2(this.N1.f3431e);
        eVar.y1(this.N1.f3432f);
        eVar.x1(this.N1.f3434h);
        eVar.g1(this.N1.f3433g);
    }

    protected boolean x2() {
        e eVar = this.f3605c0;
        androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b interfaceC0040bG2 = eVar != null ? ((f) eVar).G2() : null;
        if (interfaceC0040bG2 == null) {
            return false;
        }
        int i7 = 0;
        while (true) {
            if (i7 >= this.B1) {
                return true;
            }
            e eVar2 = this.A1[i7];
            if (eVar2 != null && !(eVar2 instanceof h)) {
                e.b bVarZ = eVar2.z(0);
                e.b bVarZ2 = eVar2.z(1);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (!(bVarZ == bVar && eVar2.f3644w != 1 && bVarZ2 == bVar && eVar2.f3646x != 1)) {
                    if (bVarZ == bVar) {
                        bVarZ = e.b.WRAP_CONTENT;
                    }
                    if (bVarZ2 == bVar) {
                        bVarZ2 = e.b.WRAP_CONTENT;
                    }
                    androidx.constraintlayout.core.widgets.analyzer.b.a aVar = this.N1;
                    aVar.f3427a = bVarZ;
                    aVar.f3428b = bVarZ2;
                    aVar.f3429c = eVar2.m0();
                    this.N1.f3430d = eVar2.D();
                    interfaceC0040bG2.b(eVar2, this.N1);
                    eVar2.c2(this.N1.f3431e);
                    eVar2.y1(this.N1.f3432f);
                    eVar2.g1(this.N1.f3433g);
                }
            }
            i7++;
        }
    }

    public boolean y2() {
        return this.K1;
    }

    protected void z2(boolean z7) {
        this.K1 = z7;
    }
}
