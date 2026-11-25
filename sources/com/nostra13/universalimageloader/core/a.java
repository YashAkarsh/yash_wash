package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.nostra13.universalimageloader.core.a$a, reason: collision with other inner class name */
    private static class ThreadFactoryC0397a implements ThreadFactory {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final AtomicInteger f32625e = new AtomicInteger(1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadGroup f32626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f32627b = new AtomicInteger(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f32628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f32629d;

        ThreadFactoryC0397a(int i7) {
            this.f32629d = i7;
            SecurityManager securityManager = System.getSecurityManager();
            this.f32626a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f32628c = "uil-pool-" + f32625e.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f32626a, runnable, this.f32628c + this.f32627b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f32629d);
            return thread;
        }
    }

    public static com.nostra13.universalimageloader.core.display.a a() {
        return new com.nostra13.universalimageloader.core.display.e();
    }

    public static com.nostra13.universalimageloader.cache.disc.b b(Context context, x3.a aVar, int i7, int i8) {
        if (i7 > 0) {
            return new com.nostra13.universalimageloader.cache.disc.impl.c(com.nostra13.universalimageloader.utils.f.d(context), aVar, i7);
        }
        return i8 > 0 ? new com.nostra13.universalimageloader.cache.disc.impl.a(com.nostra13.universalimageloader.utils.f.d(context), aVar, i8) : new com.nostra13.universalimageloader.cache.disc.impl.d(com.nostra13.universalimageloader.utils.f.a(context), aVar);
    }

    public static Executor c(int i7, int i8, com.nostra13.universalimageloader.core.assist.g gVar) {
        return new ThreadPoolExecutor(i7, i7, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (gVar == com.nostra13.universalimageloader.core.assist.g.LIFO ? new com.nostra13.universalimageloader.core.assist.deque.c() : new LinkedBlockingQueue()), i(i8));
    }

    public static x3.a d() {
        return new x3.b();
    }

    public static com.nostra13.universalimageloader.core.decode.b e(boolean z7) {
        return new com.nostra13.universalimageloader.core.decode.a(z7);
    }

    public static com.nostra13.universalimageloader.core.download.c f(Context context) {
        return new com.nostra13.universalimageloader.core.download.a(context);
    }

    public static com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> g(int i7) {
        if (i7 == 0) {
            i7 = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        return new com.nostra13.universalimageloader.cache.memory.impl.f(i7);
    }

    public static com.nostra13.universalimageloader.cache.disc.b h(File file) {
        File file2 = new File(file, "uil-images");
        if (file2.exists() || file2.mkdir()) {
            file = file2;
        }
        return new com.nostra13.universalimageloader.cache.disc.impl.c(file, 2097152);
    }

    private static ThreadFactory i(int i7) {
        return new ThreadFactoryC0397a(i7);
    }
}
