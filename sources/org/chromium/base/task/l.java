package org.chromium.base.task;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes3.dex */
public class l extends TaskRunnerImpl implements j {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicInteger f38930l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f38931m;

    l(u uVar) {
        super(uVar, "SequencedTaskRunnerImpl", 1);
        this.f38930l = new AtomicInteger();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(Runnable runnable) {
        runnable.run();
        synchronized (this.f38888d) {
            int i7 = this.f38931m - 1;
            this.f38931m = i7;
            if (i7 == 0) {
                g();
            }
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl, org.chromium.base.task.r
    public void d() {
        synchronized (this.f38888d) {
            i();
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    public void j(final Runnable runnable, long j7) {
        synchronized (this.f38888d) {
            int i7 = this.f38931m;
            this.f38931m = i7 + 1;
            if (i7 == 0) {
                h();
            }
            super.j(new Runnable() { // from class: org.chromium.base.task.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f38928a.n(runnable);
                }
            }, j7);
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    protected void k() {
        super.k();
        if (this.f38930l.decrementAndGet() > 0) {
            super.l();
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    protected void l() {
        if (this.f38930l.getAndIncrement() == 0) {
            super.l();
        }
    }
}
