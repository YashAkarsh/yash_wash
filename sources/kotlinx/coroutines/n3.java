package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class n3<T, R> extends v2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.selects.f<R> f37098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final i5.p<T, kotlin.coroutines.d<? super R>, Object> f37099f;

    /* JADX WARN: Multi-variable type inference failed */
    public n3(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        this.f37098e = fVar;
        this.f37099f = pVar;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) throws Throwable {
        if (this.f37098e.q()) {
            W0().o1(this.f37098e, this.f37099f);
        }
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) throws Throwable {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
