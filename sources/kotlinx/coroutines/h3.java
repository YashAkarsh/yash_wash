package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class h3 extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.internal.y f36929a;

    public h3(@a7.d kotlinx.coroutines.internal.y yVar) {
        this.f36929a = yVar;
    }

    @Override // kotlinx.coroutines.p
    public void b(@a7.e Throwable th) {
        this.f36929a.O0();
    }

    @a7.d
    public String toString() {
        return "RemoveOnCancel[" + this.f36929a + ']';
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        b(th);
        return kotlin.l2.f34958a;
    }
}
