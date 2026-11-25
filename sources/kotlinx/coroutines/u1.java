package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u1 extends o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f37323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private kotlinx.coroutines.internal.a<k1<?>> f37325d;

    public static /* synthetic */ void A1(u1 u1Var, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        u1Var.z1(z7);
    }

    public static /* synthetic */ void i1(u1 u1Var, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        u1Var.e1(z7);
    }

    private final long q1(boolean z7) {
        return z7 ? 4294967296L : 1L;
    }

    protected boolean B1() {
        return R1();
    }

    public final boolean N1() {
        return this.f37323b >= q1(true);
    }

    public final boolean R1() {
        kotlinx.coroutines.internal.a<k1<?>> aVar = this.f37325d;
        if (aVar == null) {
            return true;
        }
        return aVar.d();
    }

    public long W1() {
        return !X1() ? Long.MAX_VALUE : 0L;
    }

    public final boolean X1() {
        k1<?> k1VarE;
        kotlinx.coroutines.internal.a<k1<?>> aVar = this.f37325d;
        if (aVar == null || (k1VarE = aVar.e()) == null) {
            return false;
        }
        k1VarE.run();
        return true;
    }

    public boolean Y1() {
        return false;
    }

    @Override // kotlinx.coroutines.o0
    @a7.d
    public final o0 a1(int i7) {
        kotlinx.coroutines.internal.t.a(i7);
        return this;
    }

    public final boolean b() {
        return this.f37323b > 0;
    }

    public final void e1(boolean z7) {
        long jQ1 = this.f37323b - q1(z7);
        this.f37323b = jQ1;
        if (jQ1 <= 0 && this.f37324c) {
            shutdown();
        }
    }

    public final void s1(@a7.d k1<?> k1Var) {
        kotlinx.coroutines.internal.a<k1<?>> aVar = this.f37325d;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f37325d = aVar;
        }
        aVar.a(k1Var);
    }

    public void shutdown() {
    }

    protected long w1() {
        kotlinx.coroutines.internal.a<k1<?>> aVar = this.f37325d;
        return (aVar == null || aVar.d()) ? Long.MAX_VALUE : 0L;
    }

    public final void z1(boolean z7) {
        this.f37323b += q1(z7);
        if (z7) {
            return;
        }
        this.f37324c = true;
    }
}
