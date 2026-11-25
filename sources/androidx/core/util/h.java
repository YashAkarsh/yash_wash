package androidx.core.util;

import c.t0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.d1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@t0(24)
final class h<T> extends AtomicBoolean implements Consumer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<T> f6367a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h(@a7.d kotlin.coroutines.d<? super T> continuation) {
        super(false);
        l0.p(continuation, "continuation");
        this.f6367a = continuation;
    }

    @Override // java.util.function.Consumer
    public void accept(T t7) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.d<T> dVar = this.f6367a;
            d1.a aVar = d1.f34719b;
            dVar.w(d1.b(t7));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @a7.d
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
