package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i[] f8207a;

    CompositeGeneratedAdaptersObserver(i[] iVarArr) {
        this.f8207a = iVarArr;
    }

    @Override // androidx.lifecycle.o
    public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
        v vVar = new v();
        for (i iVar : this.f8207a) {
            iVar.a(qVar, bVar, false, vVar);
        }
        for (i iVar2 : this.f8207a) {
            iVar2.a(qVar, bVar, true, vVar);
        }
    }
}
