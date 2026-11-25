package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
final class p1 implements q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Future<?> f37109a;

    public p1(@a7.d Future<?> future) {
        this.f37109a = future;
    }

    @Override // kotlinx.coroutines.q1
    public void F() {
        this.f37109a.cancel(false);
    }

    @a7.d
    public String toString() {
        return "DisposableFutureHandle[" + this.f37109a + ']';
    }
}
