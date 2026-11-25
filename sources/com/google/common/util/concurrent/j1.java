package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@y1.f(y1.f.a.FULL)
@s1.b(emulated = true)
abstract class j1<T> extends AtomicReference<Runnable> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Runnable f22788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Runnable f22789b;

    private static final class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        f22788a = new b();
        f22789b = new b();
    }

    j1() {
    }

    abstract void a(T t7, Throwable th);

    final void b() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, f22789b)) {
            ((Thread) runnable).interrupt();
            set(f22788a);
        }
    }

    abstract boolean c();

    abstract T d() throws Exception;

    abstract String e();

    @Override // java.lang.Runnable
    public final void run() {
        T tD;
        Thread threadCurrentThread = Thread.currentThread();
        if (compareAndSet(null, threadCurrentThread)) {
            boolean z7 = !c();
            if (z7) {
                try {
                    tD = d();
                } catch (Throwable th) {
                    if (!compareAndSet(threadCurrentThread, f22788a)) {
                        while (get() == f22789b) {
                            Thread.yield();
                        }
                    }
                    if (z7) {
                        a(null, th);
                        return;
                    }
                    return;
                }
            } else {
                tD = null;
            }
            if (!compareAndSet(threadCurrentThread, f22788a)) {
                while (get() == f22789b) {
                    Thread.yield();
                }
            }
            if (z7) {
                a(tD, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f22788a) {
            str = "running=[DONE]";
        } else if (runnable == f22789b) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + e();
    }
}
