package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends q2 implements w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public final y f37357e;

    public x(@a7.d y yVar) {
        this.f37357e = yVar;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) {
        this.f37357e.l0(W0());
    }

    @Override // kotlinx.coroutines.w
    @a7.d
    public o2 getParent() {
        return W0();
    }

    @Override // kotlinx.coroutines.w
    public boolean s(@a7.d Throwable th) {
        return W0().n0(th);
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
