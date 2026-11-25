package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class n2 extends v2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final i5.l<Throwable, kotlin.l2> f37097e;

    /* JADX WARN: Multi-variable type inference failed */
    public n2(@a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        this.f37097e = lVar;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) {
        this.f37097e.z(th);
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
