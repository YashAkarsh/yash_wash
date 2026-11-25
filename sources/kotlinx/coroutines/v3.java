package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final v3 f37337a = new v3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final ThreadLocal<u1> f37338b = new ThreadLocal<>();

    private v3() {
    }

    @a7.e
    public final u1 a() {
        return f37338b.get();
    }

    @a7.d
    public final u1 b() {
        ThreadLocal<u1> threadLocal = f37338b;
        u1 u1Var = threadLocal.get();
        if (u1Var != null) {
            return u1Var;
        }
        u1 u1VarA = x1.a();
        threadLocal.set(u1VarA);
        return u1VarA;
    }

    public final void c() {
        f37338b.set(null);
    }

    public final void d(@a7.d u1 u1Var) {
        f37338b.set(u1Var);
    }
}
