package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
class j extends p {
    public j(androidx.constraintlayout.core.widgets.e eVar) {
        super(eVar);
        eVar.f3608e.f();
        eVar.f3610f.f();
        this.f3516f = ((androidx.constraintlayout.core.widgets.h) eVar).m2();
    }

    private void u(f fVar) {
        this.f3518h.f3459k.add(fVar);
        fVar.f3460l.add(this.f3518h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        f fVar = this.f3518h;
        if (fVar.f3451c && !fVar.f3458j) {
            this.f3518h.e((int) ((fVar.f3460l.get(0).f3455g * ((androidx.constraintlayout.core.widgets.h) this.f3512b).q2()) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void d() {
        androidx.constraintlayout.core.widgets.h hVar = (androidx.constraintlayout.core.widgets.h) this.f3512b;
        int iN2 = hVar.n2();
        int iP2 = hVar.p2();
        hVar.q2();
        if (hVar.m2() == 1) {
            if (iN2 != -1) {
                this.f3518h.f3460l.add(this.f3512b.f3605c0.f3608e.f3518h);
                this.f3512b.f3605c0.f3608e.f3518h.f3459k.add(this.f3518h);
                this.f3518h.f3454f = iN2;
            } else if (iP2 != -1) {
                this.f3518h.f3460l.add(this.f3512b.f3605c0.f3608e.f3519i);
                this.f3512b.f3605c0.f3608e.f3519i.f3459k.add(this.f3518h);
                this.f3518h.f3454f = -iP2;
            } else {
                f fVar = this.f3518h;
                fVar.f3450b = true;
                fVar.f3460l.add(this.f3512b.f3605c0.f3608e.f3519i);
                this.f3512b.f3605c0.f3608e.f3519i.f3459k.add(this.f3518h);
            }
            u(this.f3512b.f3608e.f3518h);
            u(this.f3512b.f3608e.f3519i);
            return;
        }
        if (iN2 != -1) {
            this.f3518h.f3460l.add(this.f3512b.f3605c0.f3610f.f3518h);
            this.f3512b.f3605c0.f3610f.f3518h.f3459k.add(this.f3518h);
            this.f3518h.f3454f = iN2;
        } else if (iP2 != -1) {
            this.f3518h.f3460l.add(this.f3512b.f3605c0.f3610f.f3519i);
            this.f3512b.f3605c0.f3610f.f3519i.f3459k.add(this.f3518h);
            this.f3518h.f3454f = -iP2;
        } else {
            f fVar2 = this.f3518h;
            fVar2.f3450b = true;
            fVar2.f3460l.add(this.f3512b.f3605c0.f3610f.f3519i);
            this.f3512b.f3605c0.f3610f.f3519i.f3459k.add(this.f3518h);
        }
        u(this.f3512b.f3610f.f3518h);
        u(this.f3512b.f3610f.f3519i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    public void e() {
        if (((androidx.constraintlayout.core.widgets.h) this.f3512b).m2() == 1) {
            this.f3512b.f2(this.f3518h.f3455g);
        } else {
            this.f3512b.g2(this.f3518h.f3455g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void f() {
        this.f3518h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void n() {
        this.f3518h.f3458j = false;
        this.f3519i.f3458j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    boolean p() {
        return false;
    }
}
