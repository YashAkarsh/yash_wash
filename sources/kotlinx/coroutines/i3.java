package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class i3<T> extends v2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final r<T> f36933e;

    /* JADX WARN: Multi-variable type inference failed */
    public i3(@a7.d r<? super T> rVar) {
        this.f36933e = rVar;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) {
        Object objN0 = W0().N0();
        if (objN0 instanceof e0) {
            r<T> rVar = this.f36933e;
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            rVar.w(kotlin.d1.b(kotlin.e1.a(((e0) objN0).f35988a)));
        } else {
            r<T> rVar2 = this.f36933e;
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            rVar2.w(kotlin.d1.b(x2.o(objN0)));
        }
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
