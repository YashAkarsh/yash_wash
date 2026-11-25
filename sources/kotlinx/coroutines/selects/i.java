package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f37226a = AtomicLongFieldUpdater.newUpdater(i.class, "number");

    @a7.d
    private volatile /* synthetic */ long number = 1;

    public final long a() {
        return f37226a.incrementAndGet(this);
    }
}
