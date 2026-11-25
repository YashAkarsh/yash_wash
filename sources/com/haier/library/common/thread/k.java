package com.haier.library.common.thread;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class k implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque<Runnable> f26509a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f26510b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static k f26511a = new k();

        private a() {
        }
    }

    public static k b() {
        return a.f26511a;
    }

    private synchronized void d() {
        Runnable runnablePoll = this.f26509a.poll();
        this.f26510b = runnablePoll;
        if (runnablePoll != null) {
            m.execute(runnablePoll);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            d();
        }
    }

    public void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        execute(runnable);
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.f26509a.offer(new Runnable() { // from class: com.haier.library.common.thread.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f26507a.e(runnable);
            }
        });
        if (this.f26510b == null) {
            d();
        }
    }
}
