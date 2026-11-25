package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3470m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f3453e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f3453e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.f
    public void e(int i7) {
        if (this.f3458j) {
            return;
        }
        this.f3458j = true;
        this.f3455g = i7;
        for (d dVar : this.f3459k) {
            dVar.a(dVar);
        }
    }
}
