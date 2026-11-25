package org.chromium.base.task;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayDeque<Runnable> f38932a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f38933b;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f38934a;

        a(Runnable runnable) {
            this.f38934a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f38934a.run();
            } finally {
                m.this.a();
            }
        }
    }

    m() {
    }

    protected synchronized void a() {
        Runnable runnablePoll = this.f38932a.poll();
        this.f38933b = runnablePoll;
        if (runnablePoll != null) {
            c.f38898g.execute(runnablePoll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f38932a.offer(new a(runnable));
        if (this.f38933b == null) {
            a();
        }
    }
}
