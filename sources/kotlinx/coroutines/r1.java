package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class r1 extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final q1 f37118a;

    public r1(@a7.d q1 q1Var) {
        this.f37118a = q1Var;
    }

    @Override // kotlinx.coroutines.p
    public void b(@a7.e Throwable th) {
        this.f37118a.F();
    }

    @a7.d
    public String toString() {
        return "DisposeOnCancel[" + this.f37118a + ']';
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        b(th);
        return kotlin.l2.f34958a;
    }
}
