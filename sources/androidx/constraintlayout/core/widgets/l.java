package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class l extends n {
    @Override // androidx.constraintlayout.core.widgets.e
    public void g(androidx.constraintlayout.core.e eVar, boolean z7) {
        super.g(eVar, z7);
        if (this.B1 > 0) {
            e eVar2 = this.A1[0];
            eVar2.S0();
            d.b bVar = d.b.LEFT;
            eVar2.j(bVar, this, bVar);
            d.b bVar2 = d.b.RIGHT;
            eVar2.j(bVar2, this, bVar2);
            d.b bVar3 = d.b.TOP;
            eVar2.j(bVar3, this, bVar3);
            d.b bVar4 = d.b.BOTTOM;
            eVar2.j(bVar4, this, bVar4);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.n
    public void v2(int i7, int i8, int i9, int i10) {
        int iS2 = s2() + t2() + 0;
        int iU2 = u2() + r2() + 0;
        if (this.B1 > 0) {
            iS2 += this.A1[0].m0();
            iU2 += this.A1[0].D();
        }
        int iMax = Math.max(Q(), iS2);
        int iMax2 = Math.max(P(), iU2);
        if (i7 != 1073741824) {
            if (i7 == Integer.MIN_VALUE) {
                i8 = Math.min(iMax, i8);
            } else {
                i8 = i7 == 0 ? iMax : 0;
            }
        }
        if (i9 != 1073741824) {
            if (i9 == Integer.MIN_VALUE) {
                i10 = Math.min(iMax2, i10);
            } else {
                i10 = i9 == 0 ? iMax2 : 0;
            }
        }
        A2(i8, i10);
        c2(i8);
        y1(i10);
        z2(this.B1 > 0);
    }
}
