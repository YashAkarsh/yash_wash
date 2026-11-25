package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final int a(@a7.d AtomicInteger atomicInteger) {
        return atomicInteger.get();
    }

    public static final void b(@a7.d AtomicInteger atomicInteger, int i7) {
        atomicInteger.set(i7);
    }
}
