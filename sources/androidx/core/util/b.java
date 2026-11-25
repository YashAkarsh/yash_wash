package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.d1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
final class b<T> extends AtomicBoolean implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<T> f6346a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@a7.d kotlin.coroutines.d<? super T> continuation) {
        super(false);
        l0.p(continuation, "continuation");
        this.f6346a = continuation;
    }

    @Override // androidx.core.util.e
    public void accept(T t7) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.d<T> dVar = this.f6346a;
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
