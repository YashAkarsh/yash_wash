package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f37320c = AtomicIntegerFieldUpdater.newUpdater(u.class, "_resumed");

    @a7.d
    private volatile /* synthetic */ int _resumed;

    public u(@a7.d kotlin.coroutines.d<?> dVar, @a7.e Throwable th, boolean z7) {
        if (th == null) {
            th = new CancellationException("Continuation " + dVar + " was cancelled normally");
        }
        super(th, z7);
        this._resumed = 0;
    }

    public final boolean c() {
        return f37320c.compareAndSet(this, 0, 1);
    }
}
