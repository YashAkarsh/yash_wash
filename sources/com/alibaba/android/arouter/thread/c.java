package com.alibaba.android.arouter.thread;

import c.m0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f12492d = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f12493a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadGroup f12494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12495c;

    class a implements Thread.UncaughtExceptionHandler {
        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th.getMessage() + "]");
        }
    }

    public c() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f12494b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f12495c = "ARouter task pool No." + f12492d.getAndIncrement() + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@m0 Runnable runnable) {
        String str = this.f12495c + this.f12493a.getAndIncrement();
        com.alibaba.android.arouter.launcher.a.f12464e.info("ARouter::", "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.f12494b, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new a());
        return thread;
    }
}
