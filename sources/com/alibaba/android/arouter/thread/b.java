package com.alibaba.android.arouter.thread;

import com.alibaba.android.arouter.utils.f;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f12487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f12488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f12490d = 30;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f12491e;

    class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            com.alibaba.android.arouter.launcher.a.f12464e.error("ARouter::", "Task rejected, too many task!");
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f12487a = iAvailableProcessors;
        int i7 = iAvailableProcessors + 1;
        f12488b = i7;
        f12489c = i7;
    }

    private b(int i7, int i8, long j7, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i7, i8, j7, timeUnit, blockingQueue, threadFactory, new a());
    }

    public static b a() {
        if (f12491e == null) {
            synchronized (b.class) {
                if (f12491e == null) {
                    f12491e = new b(f12488b, f12489c, f12490d, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new c());
                }
            }
        }
        return f12491e;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e8) {
                th = e8;
            } catch (ExecutionException e9) {
                th = e9.getCause();
            }
        }
        if (th != null) {
            com.alibaba.android.arouter.launcher.a.f12464e.warning("ARouter::", "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th.getMessage() + "]\n" + f.a(th.getStackTrace()));
        }
    }
}
