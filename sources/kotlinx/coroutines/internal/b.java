package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d<?> f36939a;

    public abstract void a(@a7.d d<?> dVar, @a7.e Object obj);

    @a7.d
    public final d<?> b() {
        d<?> dVar = this.f36939a;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.l0.S("atomicOp");
        return null;
    }

    @a7.e
    public abstract Object c(@a7.d d<?> dVar);

    public final void d(@a7.d d<?> dVar) {
        this.f36939a = dVar;
    }
}
