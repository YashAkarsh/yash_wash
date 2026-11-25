package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class o extends e {
    public ArrayList<e> A1;

    public o() {
        this.A1 = new ArrayList<>();
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void Q1(int i7, int i8) {
        super.Q1(i7, i8);
        int size = this.A1.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.A1.get(i9).Q1(Y(), Z());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void R0() {
        this.A1.clear();
        super.R0();
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void W0(androidx.constraintlayout.core.c cVar) {
        super.W0(cVar);
        int size = this.A1.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.A1.get(i7).W0(cVar);
        }
    }

    public void b(e eVar) {
        this.A1.add(eVar);
        if (eVar.U() != null) {
            ((o) eVar.U()).o2(eVar);
        }
        eVar.S1(this);
    }

    public void k2(e... eVarArr) {
        for (e eVar : eVarArr) {
            b(eVar);
        }
    }

    public ArrayList<e> l2() {
        return this.A1;
    }

    public f m2() {
        e eVarU = U();
        f fVar = this instanceof f ? (f) this : null;
        while (eVarU != null) {
            e eVarU2 = eVarU.U();
            if (eVarU instanceof f) {
                fVar = (f) eVarU;
            }
            eVarU = eVarU2;
        }
        return fVar;
    }

    public void n2() {
        ArrayList<e> arrayList = this.A1;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = this.A1.get(i7);
            if (eVar instanceof o) {
                ((o) eVar).n2();
            }
        }
    }

    public void o2(e eVar) {
        this.A1.remove(eVar);
        eVar.R0();
    }

    public void p2() {
        this.A1.clear();
    }

    public o(int i7, int i8, int i9, int i10) {
        super(i7, i8, i9, i10);
        this.A1 = new ArrayList<>();
    }

    public o(int i7, int i8) {
        super(i7, i8);
        this.A1 = new ArrayList<>();
    }
}
