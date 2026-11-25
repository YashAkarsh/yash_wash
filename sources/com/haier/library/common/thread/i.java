package com.haier.library.common.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class i implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f26496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadFactory f26497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f26498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f26499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f26500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Boolean f26501f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadFactory f26502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f26503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f26504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f26505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Boolean f26506e;

        public b a(int i7) {
            this.f26505d = Integer.valueOf(i7);
            return this;
        }

        public b b(String str) {
            i.e(str, "Naming pattern must not be null!", new Object[0]);
            this.f26504c = str;
            return this;
        }

        public b c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            i.e(uncaughtExceptionHandler, "Uncaught exception handler must not be null!", new Object[0]);
            this.f26503b = uncaughtExceptionHandler;
            return this;
        }

        public b d(ThreadFactory threadFactory) {
            i.e(threadFactory, "Wrapped ThreadFactory must not be null!", new Object[0]);
            this.f26502a = threadFactory;
            return this;
        }

        public b e(boolean z7) {
            this.f26506e = Boolean.valueOf(z7);
            return this;
        }

        public void g() {
            this.f26502a = null;
            this.f26503b = null;
            this.f26504c = null;
            this.f26505d = null;
            this.f26506e = null;
        }

        public i h() {
            i iVar = new i(this);
            g();
            return iVar;
        }
    }

    private void c(Thread thread) {
        if (d() != null) {
            thread.setName(String.format(d(), Long.valueOf(this.f26496a.incrementAndGet())));
        }
        if (h() != null) {
            thread.setUncaughtExceptionHandler(h());
        }
        if (g() != null) {
            thread.setPriority(g().intValue());
        }
        if (f() != null) {
            thread.setDaemon(f().booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void e(T t7, String str, Object... objArr) {
        if (t7 == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
    }

    public final ThreadFactory a() {
        return this.f26497b;
    }

    public final String d() {
        return this.f26499d;
    }

    public final Boolean f() {
        return this.f26501f;
    }

    public final Integer g() {
        return this.f26500e;
    }

    public final Thread.UncaughtExceptionHandler h() {
        return this.f26498c;
    }

    public long i() {
        return this.f26496a.get();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = a().newThread(runnable);
        c(threadNewThread);
        return threadNewThread;
    }

    private i(b bVar) {
        if (bVar.f26502a == null) {
            this.f26497b = Executors.defaultThreadFactory();
        } else {
            this.f26497b = bVar.f26502a;
        }
        this.f26499d = bVar.f26504c;
        this.f26500e = bVar.f26505d;
        this.f26501f = bVar.f26506e;
        this.f26498c = bVar.f26503b;
        this.f26496a = new AtomicLong();
    }
}
