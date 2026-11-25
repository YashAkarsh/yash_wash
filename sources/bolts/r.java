package bolts;

/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p<?> f11455a;

    public r(p<?> pVar) {
        this.f11455a = pVar;
    }

    public void a() {
        this.f11455a = null;
    }

    protected void finalize() throws Throwable {
        p.q qVarG;
        try {
            p<?> pVar = this.f11455a;
            if (pVar != null && (qVarG = p.G()) != null) {
                qVarG.a(pVar, new s(pVar.E()));
            }
        } finally {
            super.finalize();
        }
    }
}
