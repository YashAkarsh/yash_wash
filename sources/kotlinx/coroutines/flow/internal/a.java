package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.flow.j<?> f36261a;

    public a(@a7.d kotlinx.coroutines.flow.j<?> jVar) {
        super("Flow was aborted, no more elements needed");
        this.f36261a = jVar;
    }

    @a7.d
    public final kotlinx.coroutines.flow.j<?> a() {
        return this.f36261a;
    }

    @Override // java.lang.Throwable
    @a7.d
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
