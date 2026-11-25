package com.haier.library.common.thread;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f26461e = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Runnable f26462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f26463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f26464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ScheduledFuture f26465d;

    public d() {
        this.f26463b = new AtomicBoolean(false);
        this.f26464c = 1000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Runnable runnable = this.f26462a;
        if (runnable == null) {
            return;
        }
        this.f26463b.set(false);
        runnable.run();
    }

    public void c(Runnable runnable) {
        d(runnable, false);
    }

    public void d(Runnable runnable, boolean z7) {
        if (runnable == null) {
            return;
        }
        if (this.f26463b.compareAndSet(false, true)) {
            Runnable runnable2 = this.f26462a;
            this.f26462a = runnable;
            this.f26465d = m.execute(new Runnable() { // from class: com.haier.library.common.thread.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f26460a.b();
                }
            }, (runnable2 == null || z7) ? 0L : this.f26464c, TimeUnit.MILLISECONDS);
            return;
        }
        e3.a.e("task be deduplication<%s>", runnable.getClass().getPackage());
        if (z7) {
            e3.a.e("task be deduplication<%s>， but immediately", runnable.getClass().getPackage());
            ScheduledFuture scheduledFuture = this.f26465d;
            if (scheduledFuture == null) {
                m.execute(runnable);
            } else {
                if (scheduledFuture.isDone()) {
                    return;
                }
                scheduledFuture.cancel(false);
                this.f26463b.set(false);
            }
        }
    }

    public d(long j7) {
        this.f26463b = new AtomicBoolean(false);
        this.f26464c = j7;
    }
}
