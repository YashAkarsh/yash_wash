package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
final class n extends v2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final Future<?> f37087e;

    public n(@a7.d Future<?> future) {
        this.f37087e = future;
    }

    @Override // kotlinx.coroutines.g0
    public void V0(@a7.e Throwable th) {
        if (th != null) {
            this.f37087e.cancel(false);
        }
    }

    @Override // i5.l
    public /* bridge */ /* synthetic */ kotlin.l2 z(Throwable th) {
        V0(th);
        return kotlin.l2.f34958a;
    }
}
