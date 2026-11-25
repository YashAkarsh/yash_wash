package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
final class m extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Future<?> f37083a;

    public m(@a7.d Future<?> future) {
        this.f37083a = future;
    }

    @Override // kotlinx.coroutines.p
    public void b(@a7.e Throwable th) {
        if (th != null) {
            this.f37083a.cancel(false);
        }
    }

    @a7.d
    public String toString() {
        return "CancelFutureOnCancel[" + this.f37083a + ']';
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        b(th);
        return kotlin.l2.f34958a;
    }
}
