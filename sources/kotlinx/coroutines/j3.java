package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class j3 extends v2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<kotlin.l2> f37062e;

    /* JADX WARN: Multi-variable type inference failed */
    public j3(@a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        this.f37062e = dVar;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) {
        kotlin.coroutines.d<kotlin.l2> dVar = this.f37062e;
        kotlin.d1.a aVar = kotlin.d1.f34719b;
        dVar.w(kotlin.d1.b(kotlin.l2.f34958a));
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
