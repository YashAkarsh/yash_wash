package com.haier.uhome.usdk.base.c;

import com.haier.library.common.thread.m;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static Executor serialExecutor = new a();

    /* JADX INFO: Access modifiers changed from: private */
    static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayDeque<Runnable> f31243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Runnable f31244b;

        private a() {
            this.f31243a = new ArrayDeque<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f31243a.offer(new Runnable() { // from class: com.haier.uhome.usdk.base.c.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31251a.a(runnable);
                }
            });
            if (this.f31244b == null) {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        synchronized void a() {
            Runnable runnablePoll = this.f31243a.poll();
            this.f31244b = runnablePoll;
            if (runnablePoll != null) {
                m.execute(runnablePoll);
            }
        }
    }

    protected d() {
    }

    protected void dispatchToMainThread(Runnable runnable) {
        if (runnable != null) {
            com.haier.library.common.thread.a.b().c(runnable);
        }
    }

    protected void dispatchToThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        serialExecutor.execute(runnable);
    }
}
