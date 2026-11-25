package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class o3<R> extends v2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.selects.f<R> f37105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final i5.l<kotlin.coroutines.d<? super R>, Object> f37106f;

    /* JADX WARN: Multi-variable type inference failed */
    public o3(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar) {
        this.f37105e = fVar;
        this.f37106f = lVar;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) throws Throwable {
        if (this.f37105e.q()) {
            r5.a.c(this.f37106f, this.f37105e.G());
        }
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) throws Throwable {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
