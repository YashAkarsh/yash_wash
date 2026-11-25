package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class k1 {

    private static class a<V> extends z0<V> implements l1<V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final ThreadFactory f22802e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Executor f22803f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f22804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p0 f22805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f22806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Future<V> f22807d;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.k1$a$a, reason: collision with other inner class name */
        class RunnableC0300a implements Runnable {
            RunnableC0300a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    p2.d(a.this.f22807d);
                } catch (Throwable unused) {
                }
                a.this.f22805b.b();
            }
        }

        static {
            ThreadFactory threadFactoryB = new i2().e(true).f("ListenableFutureAdapter-thread-%d").b();
            f22802e = threadFactoryB;
            f22803f = Executors.newCachedThreadPool(threadFactoryB);
        }

        a(Future<V> future) {
            this(future, f22803f);
        }

        @Override // com.google.common.util.concurrent.l1
        public void I(Runnable runnable, Executor executor) {
            this.f22805b.a(runnable, executor);
            if (this.f22806c.compareAndSet(false, true)) {
                if (this.f22807d.isDone()) {
                    this.f22805b.b();
                } else {
                    this.f22804a.execute(new RunnableC0300a());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.z0, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Future<V> c0() {
            return this.f22807d;
        }

        a(Future<V> future, Executor executor) {
            this.f22805b = new p0();
            this.f22806c = new AtomicBoolean(false);
            this.f22807d = (Future) com.google.common.base.e0.E(future);
            this.f22804a = (Executor) com.google.common.base.e0.E(executor);
        }
    }

    private k1() {
    }

    public static <V> l1<V> a(Future<V> future) {
        return future instanceof l1 ? (l1) future : new a(future);
    }

    public static <V> l1<V> b(Future<V> future, Executor executor) {
        com.google.common.base.e0.E(executor);
        return future instanceof l1 ? (l1) future : new a(future, executor);
    }
}
