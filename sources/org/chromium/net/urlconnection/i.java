package org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
class i implements Executor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f39580g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f39581h = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f39583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f39584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterruptedIOException f39585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RuntimeException f39586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f39587f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<Runnable> f39582a = new LinkedBlockingQueue();

    i() {
    }

    private boolean a() {
        long j7 = this.f39587f;
        if (j7 != -1) {
            return j7 == Thread.currentThread().getId();
        }
        this.f39587f = Thread.currentThread().getId();
        return true;
    }

    private Runnable g(boolean z7, long j7) throws InterruptedIOException {
        try {
            Runnable runnableTake = !z7 ? this.f39582a.take() : this.f39582a.poll(j7, TimeUnit.NANOSECONDS);
            if (runnableTake != null) {
                return runnableTake;
            }
            throw new SocketTimeoutException();
        } catch (InterruptedException e8) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e8);
            throw interruptedIOException;
        }
    }

    public boolean b() {
        return this.f39584c;
    }

    public boolean c() {
        return this.f39583b;
    }

    public void d() throws IOException {
        e(0);
    }

    public void e(int i7) throws IOException {
        long jNanoTime = System.nanoTime();
        long jConvert = TimeUnit.NANOSECONDS.convert(i7, TimeUnit.MILLISECONDS);
        if (this.f39584c) {
            InterruptedIOException interruptedIOException = this.f39585d;
            if (interruptedIOException == null) {
                throw this.f39586e;
            }
            throw interruptedIOException;
        }
        if (this.f39583b) {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        this.f39583b = true;
        while (this.f39583b) {
            if (i7 == 0) {
                try {
                    g(false, 0L).run();
                } catch (InterruptedIOException e8) {
                    this.f39583b = false;
                    this.f39584c = true;
                    this.f39585d = e8;
                    throw e8;
                } catch (RuntimeException e9) {
                    this.f39583b = false;
                    this.f39584c = true;
                    this.f39586e = e9;
                    throw e9;
                }
            } else {
                g(true, (jConvert - System.nanoTime()) + jNanoTime).run();
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f39582a.put(runnable);
        } catch (InterruptedException e8) {
            throw new RejectedExecutionException(e8);
        }
    }

    public void f() {
        this.f39583b = false;
    }
}
