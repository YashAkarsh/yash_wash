package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v2 extends g0 implements q1, h2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w2 f37336d;

    @Override // kotlinx.coroutines.h2
    @a7.e
    public b3 D() {
        return null;
    }

    @Override // kotlinx.coroutines.q1
    public void F() {
        W0().n1(this);
    }

    @a7.d
    public final w2 W0() {
        w2 w2Var = this.f37336d;
        if (w2Var != null) {
            return w2Var;
        }
        kotlin.jvm.internal.l0.S("job");
        return null;
    }

    public final void X0(@a7.d w2 w2Var) {
        this.f37336d = w2Var;
    }

    @Override // kotlinx.coroutines.h2
    public boolean b() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.y
    @a7.d
    public String toString() {
        return a1.a(this) + '@' + a1.b(this) + "[job@" + a1.b(W0()) + ']';
    }
}
