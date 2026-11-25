package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class l2 extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i5.l<Throwable, kotlin.l2> f37081a;

    /* JADX WARN: Multi-variable type inference failed */
    public l2(@a7.d i5.l<? super Throwable, kotlin.l2> lVar) {
        this.f37081a = lVar;
    }

    @Override // kotlinx.coroutines.p
    public void b(@a7.e Throwable th) {
        this.f37081a.z(th);
    }

    @a7.d
    public String toString() {
        return "InvokeOnCancel[" + a1.a(this.f37081a) + '@' + a1.b(this) + ']';
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        b(th);
        return kotlin.l2.f34958a;
    }
}
