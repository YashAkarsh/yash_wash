package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class x3 {
    @a7.d
    @h1
    public static final a2 b(final int i7, @a7.d final String str) {
        if (i7 >= 1) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return c2.d(Executors.newScheduledThreadPool(i7, new ThreadFactory() { // from class: kotlinx.coroutines.w3
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return x3.c(i7, str, atomicInteger, runnable);
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i7 + " specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(int i7, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i7 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    @a7.d
    @h1
    public static final a2 d(@a7.d String str) {
        return b(1, str);
    }
}
