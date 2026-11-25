package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
final class SavedStateHandleController implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8243b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d0 f8244c;

    SavedStateHandleController(String str, d0 d0Var) {
        this.f8242a = str;
        this.f8244c = d0Var;
    }

    @Override // androidx.lifecycle.o
    public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
        if (bVar == m.b.ON_DESTROY) {
            this.f8243b = false;
            qVar.getLifecycle().c(this);
        }
    }

    void h(androidx.savedstate.b bVar, m mVar) {
        if (this.f8243b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f8243b = true;
        mVar.a(this);
        bVar.j(this.f8242a, this.f8244c.o());
    }

    d0 i() {
        return this.f8244c;
    }

    boolean j() {
        return this.f8243b;
    }
}
