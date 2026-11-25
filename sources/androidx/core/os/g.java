package androidx.core.os;

import android.os.OutcomeReceiver;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.d1;
import kotlin.e1;

/* JADX INFO: loaded from: classes.dex */
@c.t0(31)
final class g<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<R> f6086a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@a7.d kotlin.coroutines.d<? super R> continuation) {
        super(false);
        kotlin.jvm.internal.l0.p(continuation, "continuation");
        this.f6086a = continuation;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(@a7.d E error) {
        kotlin.jvm.internal.l0.p(error, "error");
        if (compareAndSet(false, true)) {
            kotlin.coroutines.d<R> dVar = this.f6086a;
            d1.a aVar = d1.f34719b;
            dVar.w(d1.b(e1.a(error)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r7) {
        if (compareAndSet(false, true)) {
            kotlin.coroutines.d<R> dVar = this.f6086a;
            d1.a aVar = d1.f34719b;
            dVar.w(d1.b(r7));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    @a7.d
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
