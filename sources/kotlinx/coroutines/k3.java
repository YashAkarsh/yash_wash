package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class k3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final o0 f37071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final q<kotlin.l2> f37072b;

    /* JADX WARN: Multi-variable type inference failed */
    public k3(@a7.d o0 o0Var, @a7.d q<? super kotlin.l2> qVar) {
        this.f37071a = o0Var;
        this.f37072b = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f37072b.N(this.f37071a, kotlin.l2.f34958a);
    }
}
