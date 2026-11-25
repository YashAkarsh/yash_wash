package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.d1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
final class i extends AtomicBoolean implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<l2> f6374a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(@a7.d kotlin.coroutines.d<? super l2> continuation) {
        super(false);
        l0.p(continuation, "continuation");
        this.f6374a = continuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.d<l2> dVar = this.f6374a;
            d1.a aVar = d1.f34719b;
            dVar.w(d1.b(l2.f34958a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @a7.d
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
