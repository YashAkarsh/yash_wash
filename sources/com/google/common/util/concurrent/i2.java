package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
@s1.c
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f22776b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f22777c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f22778d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadFactory f22779e = null;

    static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ThreadFactory f22780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicLong f22782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Boolean f22783d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Integer f22784e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f22785f;

        a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f22780a = threadFactory;
            this.f22781b = str;
            this.f22782c = atomicLong;
            this.f22783d = bool;
            this.f22784e = num;
            this.f22785f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f22780a.newThread(runnable);
            String str = this.f22781b;
            if (str != null) {
                threadNewThread.setName(i2.d(str, Long.valueOf(this.f22782c.getAndIncrement())));
            }
            Boolean bool = this.f22783d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f22784e;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f22785f;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    private static ThreadFactory c(i2 i2Var) {
        String str = i2Var.f22775a;
        Boolean bool = i2Var.f22776b;
        Integer num = i2Var.f22777c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = i2Var.f22778d;
        ThreadFactory threadFactoryDefaultThreadFactory = i2Var.f22779e;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    @u1.b
    public ThreadFactory b() {
        return c(this);
    }

    public i2 e(boolean z7) {
        this.f22776b = Boolean.valueOf(z7);
        return this;
    }

    public i2 f(String str) {
        d(str, 0);
        this.f22775a = str;
        return this;
    }

    public i2 g(int i7) {
        com.google.common.base.e0.m(i7 >= 1, "Thread priority (%s) must be >= %s", i7, 1);
        com.google.common.base.e0.m(i7 <= 10, "Thread priority (%s) must be <= %s", i7, 10);
        this.f22777c = Integer.valueOf(i7);
        return this;
    }

    public i2 h(ThreadFactory threadFactory) {
        this.f22779e = (ThreadFactory) com.google.common.base.e0.E(threadFactory);
        return this;
    }

    public i2 i(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f22778d = (Thread.UncaughtExceptionHandler) com.google.common.base.e0.E(uncaughtExceptionHandler);
        return this;
    }
}
