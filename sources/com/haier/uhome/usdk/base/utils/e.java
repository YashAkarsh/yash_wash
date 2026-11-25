package com.haier.uhome.usdk.base.utils;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f31395a = 500;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f31396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f31397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f31398d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ScheduledFuture f31399e;

    public static abstract class a<T> extends e<T> {
        public a(long j7, long j8) {
            super(j7, j8);
        }

        public void e() {
            b(new com.haier.uhome.usdk.base.api.c<>(ErrorConst.RET_USDK_OK.toError()));
        }

        public void l() {
            b(new com.haier.uhome.usdk.base.api.c<>(new uSDKError(-9527)));
        }
    }

    public e(long j7, long j8) {
        this.f31396b = j7 + System.currentTimeMillis();
        this.f31397c = j8;
    }

    private void c(final com.haier.uhome.usdk.base.api.c<T> cVar) {
        this.f31398d.set(false);
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.base.utils.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f31425a.d(cVar);
            }
        });
    }

    public static long k() {
        return (Long.MAX_VALUE - System.currentTimeMillis()) - DateUtils.MILLIS_PER_MINUTE;
    }

    public abstract void a(long j7);

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract void d(com.haier.uhome.usdk.base.api.c<T> cVar);

    public boolean h() {
        return this.f31398d.get();
    }

    public void i() {
        a((uSDKError) null);
    }

    public void j() {
        this.f31396b = 0L;
    }

    public void a() {
        if (this.f31398d.compareAndSet(false, true)) {
            a(this.f31396b - System.currentTimeMillis(), 0L);
        } else {
            e3.a.e("duplicate start RetryDo task!!", new Object[0]);
        }
    }

    public void b(com.haier.uhome.usdk.base.api.c<T> cVar) {
        if (this.f31398d.get()) {
            if (cVar.b().getCode() == 0) {
                c(cVar);
                return;
            }
            long jCurrentTimeMillis = this.f31396b - System.currentTimeMillis();
            long j7 = f31395a;
            if (jCurrentTimeMillis < f31395a) {
                c(cVar);
                return;
            }
            long j8 = this.f31397c;
            if (jCurrentTimeMillis >= j8) {
                j7 = j8;
            }
            a(jCurrentTimeMillis, j7);
        }
    }

    private void a(final long j7, final long j8) {
        this.f31399e = com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.base.utils.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f31422a.b(j7, j8);
            }
        }, j8, TimeUnit.MILLISECONDS);
    }

    public void a(uSDKError usdkerror) {
        synchronized (this.f31398d) {
            ScheduledFuture scheduledFuture = this.f31399e;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.f31399e.cancel(false);
            }
            this.f31398d.set(false);
            if (usdkerror != null) {
                c(new com.haier.uhome.usdk.base.api.c<>(usdkerror));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(long j7, long j8) {
        a(j7 - j8);
    }
}
