package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class d4<T> extends kotlinx.coroutines.internal.n0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private ThreadLocal<kotlin.u0<kotlin.coroutines.g, Object>> f35895d;

    /* JADX WARN: Illegal instructions before constructor call */
    public d4(@a7.d kotlin.coroutines.g gVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        e4 e4Var = e4.f35989a;
        super(gVar.get(e4Var) == null ? gVar.plus(e4Var) : gVar, dVar);
        this.f35895d = new ThreadLocal<>();
    }

    @Override // kotlinx.coroutines.internal.n0, kotlinx.coroutines.a
    protected void A1(@a7.e Object obj) {
        kotlin.u0<kotlin.coroutines.g, Object> u0Var = this.f35895d.get();
        if (u0Var != null) {
            kotlinx.coroutines.internal.w0.a(u0Var.a(), u0Var.b());
            this.f35895d.set(null);
        }
        Object objA = k0.a(obj, this.f37009c);
        kotlin.coroutines.d<T> dVar = this.f37009c;
        kotlin.coroutines.g gVarD = dVar.d();
        Object objC = kotlinx.coroutines.internal.w0.c(gVarD, null);
        d4<?> d4VarG = objC != kotlinx.coroutines.internal.w0.f37028a ? n0.g(dVar, gVarD, objC) : null;
        try {
            this.f37009c.w(objA);
            kotlin.l2 l2Var = kotlin.l2.f34958a;
        } finally {
            if (d4VarG == null || d4VarG.G1()) {
                kotlinx.coroutines.internal.w0.a(gVarD, objC);
            }
        }
    }

    public final boolean G1() {
        if (this.f35895d.get() == null) {
            return false;
        }
        this.f35895d.set(null);
        return true;
    }

    public final void H1(@a7.d kotlin.coroutines.g gVar, @a7.e Object obj) {
        this.f35895d.set(kotlin.p1.a(gVar, obj));
    }
}
