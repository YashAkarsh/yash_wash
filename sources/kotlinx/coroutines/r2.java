package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public class r2 extends w2 implements c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f37119b;

    public r2(@a7.e o2 o2Var) {
        super(true);
        R0(o2Var);
        this.f37119b = A1();
    }

    private final boolean A1() {
        w wVarM0 = M0();
        x xVar = wVarM0 instanceof x ? (x) wVarM0 : null;
        w2 w2VarW0 = xVar == null ? null : xVar.W0();
        if (w2VarW0 == null) {
            return false;
        }
        while (!w2VarW0.F0()) {
            w wVarM1 = w2VarW0.M0();
            x xVar2 = wVarM1 instanceof x ? (x) wVarM1 : null;
            w2VarW0 = xVar2 == null ? null : xVar2.W0();
            if (w2VarW0 == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.w2
    public boolean F0() {
        return this.f37119b;
    }

    @Override // kotlinx.coroutines.w2
    public boolean H0() {
        return true;
    }

    @Override // kotlinx.coroutines.c0
    public boolean f(@a7.d Throwable th) {
        return Z0(new e0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.c0
    public boolean q() {
        return Z0(kotlin.l2.f34958a);
    }
}
