package com.haier.library.common.thread;

import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class g<R> implements com.haier.library.common.thread.b<R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f26475c = 50;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f26476d = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f26477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicReference<R> f26478b = new AtomicReference<>();

    class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f26479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f26480b;

        a(long j7) {
            this.f26480b = j7;
            this.f26479a = System.currentTimeMillis() + j7;
        }

        @Override // com.haier.library.common.thread.e
        public boolean isTimeout() {
            return System.currentTimeMillis() > this.f26479a;
        }
    }

    class b extends m<Void, Void, Void> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Runnable f26482i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f26483j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f26484k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i7, Runnable runnable, e eVar, CountDownLatch countDownLatch) {
            super(i7);
            this.f26482i = runnable;
            this.f26483j = eVar;
            this.f26484k = countDownLatch;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.haier.library.common.thread.m
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            g.this.f26478b.set(null);
            this.f26482i.run();
            int i7 = 0;
            while (g.this.f26478b.get() == null && !this.f26483j.isTimeout()) {
                int i8 = i7 + 1;
                if (i8 % 16 == 0) {
                    e3.a.e("LinearActuator loop %d ...", Integer.valueOf(i8));
                }
                long j7 = ((long) i7) + g.f26475c;
                if (j7 > g.f26476d) {
                    j7 = 500;
                }
                try {
                    Thread.sleep(j7);
                } catch (InterruptedException e8) {
                    e3.a.g("get excp %s !", e8);
                    Thread.currentThread().interrupt();
                }
                i7 = i8;
            }
            e3.a.e("LinearActuator out", new Object[0]);
            this.f26484k.countDown();
            return null;
        }
    }

    @Override // com.haier.library.common.thread.b
    public void a(R r7) {
        if (this.f26477a == null) {
            return;
        }
        this.f26478b.set(r7);
    }

    @Override // com.haier.library.common.thread.b
    public R b(Runnable runnable, R r7, long j7) {
        return c(runnable, r7, new a(j7));
    }

    public synchronized R c(Runnable runnable, R r7, e eVar) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new IllegalThreadStateException("call run LinearActuator on main thread!!");
        }
        if (runnable == null) {
            return null;
        }
        if (eVar.isTimeout()) {
            return r7;
        }
        this.f26477a = runnable;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        b bVar = new b(-2, runnable, eVar, countDownLatch);
        bVar.execute(new Void[0]);
        try {
            countDownLatch.await();
        } catch (InterruptedException e8) {
            e3.a.g("get excp %s !", e8);
            Thread.currentThread().interrupt();
        }
        bVar.cancel(true);
        this.f26477a = null;
        if (this.f26478b.get() == null) {
            this.f26478b.set(r7);
        }
        return this.f26478b.get();
    }

    @Override // com.haier.library.common.thread.b
    public R a() {
        return this.f26478b.get();
    }

    @Override // com.haier.library.common.thread.b
    public R a(Runnable runnable, R r7, long j7, TimeUnit timeUnit) {
        return b(runnable, r7, timeUnit.toMillis(j7));
    }
}
