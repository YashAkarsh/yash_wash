package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final kotlinx.coroutines.internal.r0 f36776a = new kotlinx.coroutines.internal.r0("NONE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final kotlinx.coroutines.internal.r0 f36777b = new kotlinx.coroutines.internal.r0("PENDING");

    @a7.d
    public static final <T> e0<T> a(T t7) {
        if (t7 == null) {
            t7 = (T) kotlinx.coroutines.flow.internal.u.f36394a;
        }
        return new u0(t7);
    }

    @a7.d
    public static final <T> i<T> d(@a7.d t0<? extends T> t0Var, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        boolean z7 = false;
        if (i7 >= 0 && i7 < 2) {
            z7 = true;
        }
        return ((z7 || i7 == -2) && mVar == kotlinx.coroutines.channels.m.DROP_OLDEST) ? t0Var : k0.e(t0Var, gVar, i7, mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    public static final <T> T e(@a7.d e0<T> e0Var, @a7.d i5.l<? super T, ? extends T> lVar) {
        ?? r7;
        do {
            r7 = (Object) e0Var.getValue();
        } while (!e0Var.g(r7, lVar.z(r7)));
        return r7;
    }

    private static /* synthetic */ void f() {
    }

    private static /* synthetic */ void g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void h(@a7.d e0<T> e0Var, @a7.d i5.l<? super T, ? extends T> lVar) {
        a1.d dVar;
        do {
            dVar = (Object) e0Var.getValue();
        } while (!e0Var.g(dVar, lVar.z(dVar)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T i(@a7.d e0<T> e0Var, @a7.d i5.l<? super T, ? extends T> lVar) {
        a1.d dVar;
        T tZ;
        do {
            dVar = (Object) e0Var.getValue();
            tZ = lVar.z(dVar);
        } while (!e0Var.g(dVar, tZ));
        return tZ;
    }
}
