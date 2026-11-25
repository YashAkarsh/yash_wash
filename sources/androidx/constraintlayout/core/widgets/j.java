package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class j extends e implements i {
    public e[] A1 = new e[4];
    public int B1 = 0;

    @Override // androidx.constraintlayout.core.widgets.i
    public void a() {
        this.B1 = 0;
        Arrays.fill(this.A1, (Object) null);
    }

    @Override // androidx.constraintlayout.core.widgets.i
    public void b(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i7 = this.B1 + 1;
        e[] eVarArr = this.A1;
        if (i7 > eVarArr.length) {
            this.A1 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.A1;
        int i8 = this.B1;
        eVarArr2[i8] = eVar;
        this.B1 = i8 + 1;
    }

    @Override // androidx.constraintlayout.core.widgets.i
    public void c(f fVar) {
    }

    public void k2(ArrayList<androidx.constraintlayout.core.widgets.analyzer.o> arrayList, int i7, androidx.constraintlayout.core.widgets.analyzer.o oVar) {
        for (int i8 = 0; i8 < this.B1; i8++) {
            oVar.a(this.A1[i8]);
        }
        for (int i9 = 0; i9 < this.B1; i9++) {
            androidx.constraintlayout.core.widgets.analyzer.i.a(this.A1[i9], i7, arrayList, oVar);
        }
    }

    public int l2(int i7) {
        int i8;
        int i9;
        for (int i10 = 0; i10 < this.B1; i10++) {
            e eVar = this.A1[i10];
            if (i7 == 0 && (i9 = eVar.S0) != -1) {
                return i9;
            }
            if (i7 == 1 && (i8 = eVar.T0) != -1) {
                return i8;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void n(e eVar, HashMap<e, e> map) {
        super.n(eVar, map);
        j jVar = (j) eVar;
        this.B1 = 0;
        int i7 = jVar.B1;
        for (int i8 = 0; i8 < i7; i8++) {
            b(map.get(jVar.A1[i8]));
        }
    }
}
