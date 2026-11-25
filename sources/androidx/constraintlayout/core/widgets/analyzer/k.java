package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class k extends p {
    public k(androidx.constraintlayout.core.widgets.e eVar) {
        super(eVar);
    }

    private void u(f fVar) {
        this.f3518h.f3459k.add(fVar);
        fVar.f3460l.add(this.f3518h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) this.f3512b;
        int iP2 = aVar.p2();
        Iterator<f> it = this.f3518h.f3460l.iterator();
        int i7 = 0;
        int i8 = -1;
        while (it.hasNext()) {
            int i9 = it.next().f3455g;
            if (i8 == -1 || i9 < i8) {
                i8 = i9;
            }
            if (i7 < i9) {
                i7 = i9;
            }
        }
        if (iP2 == 0 || iP2 == 2) {
            this.f3518h.e(i8 + aVar.q2());
        } else {
            this.f3518h.e(i7 + aVar.q2());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void d() {
        androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
        if (eVar instanceof androidx.constraintlayout.core.widgets.a) {
            this.f3518h.f3450b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) eVar;
            int iP2 = aVar.p2();
            boolean zO2 = aVar.o2();
            int i7 = 0;
            if (iP2 == 0) {
                this.f3518h.f3453e = f.a.LEFT;
                while (i7 < aVar.B1) {
                    androidx.constraintlayout.core.widgets.e eVar2 = aVar.A1[i7];
                    if (zO2 || eVar2.l0() != 8) {
                        f fVar = eVar2.f3608e.f3518h;
                        fVar.f3459k.add(this.f3518h);
                        this.f3518h.f3460l.add(fVar);
                    }
                    i7++;
                }
                u(this.f3512b.f3608e.f3518h);
                u(this.f3512b.f3608e.f3519i);
                return;
            }
            if (iP2 == 1) {
                this.f3518h.f3453e = f.a.RIGHT;
                while (i7 < aVar.B1) {
                    androidx.constraintlayout.core.widgets.e eVar3 = aVar.A1[i7];
                    if (zO2 || eVar3.l0() != 8) {
                        f fVar2 = eVar3.f3608e.f3519i;
                        fVar2.f3459k.add(this.f3518h);
                        this.f3518h.f3460l.add(fVar2);
                    }
                    i7++;
                }
                u(this.f3512b.f3608e.f3518h);
                u(this.f3512b.f3608e.f3519i);
                return;
            }
            if (iP2 == 2) {
                this.f3518h.f3453e = f.a.TOP;
                while (i7 < aVar.B1) {
                    androidx.constraintlayout.core.widgets.e eVar4 = aVar.A1[i7];
                    if (zO2 || eVar4.l0() != 8) {
                        f fVar3 = eVar4.f3610f.f3518h;
                        fVar3.f3459k.add(this.f3518h);
                        this.f3518h.f3460l.add(fVar3);
                    }
                    i7++;
                }
                u(this.f3512b.f3610f.f3518h);
                u(this.f3512b.f3610f.f3519i);
                return;
            }
            if (iP2 != 3) {
                return;
            }
            this.f3518h.f3453e = f.a.BOTTOM;
            while (i7 < aVar.B1) {
                androidx.constraintlayout.core.widgets.e eVar5 = aVar.A1[i7];
                if (zO2 || eVar5.l0() != 8) {
                    f fVar4 = eVar5.f3610f.f3519i;
                    fVar4.f3459k.add(this.f3518h);
                    this.f3518h.f3460l.add(fVar4);
                }
                i7++;
            }
            u(this.f3512b.f3610f.f3518h);
            u(this.f3512b.f3610f.f3519i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    public void e() {
        androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
        if (eVar instanceof androidx.constraintlayout.core.widgets.a) {
            int iP2 = ((androidx.constraintlayout.core.widgets.a) eVar).p2();
            if (iP2 == 0 || iP2 == 1) {
                this.f3512b.f2(this.f3518h.f3455g);
            } else {
                this.f3512b.g2(this.f3518h.f3455g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void f() {
        this.f3513c = null;
        this.f3518h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void n() {
        this.f3518h.f3458j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    boolean p() {
        return false;
    }
}
