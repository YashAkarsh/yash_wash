package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f38730a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f38731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f38732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f38733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f38734e = false;

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
        if (!f38733d && !o()) {
            throw new IllegalStateException("Must be called on the UI thread.");
        }
    }

    public static Handler d() {
        Handler handler;
        synchronized (f38730a) {
            if (f38732c == null) {
                if (f38731b) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                f38732c = new Handler(Looper.getMainLooper());
            }
            handler = f38732c;
        }
        return handler;
    }

    public static Looper e() {
        return d().getLooper();
    }

    @Deprecated
    public static <T> FutureTask<T> f(FutureTask<T> futureTask) {
        d().post(futureTask);
        return futureTask;
    }

    @Deprecated
    public static void g(Runnable runnable) {
        d().post(runnable);
    }

    @Deprecated
    @s0
    public static void h(Runnable runnable, long j7) {
        d().postDelayed(runnable, j7);
    }

    @Deprecated
    public static <T> FutureTask<T> i(Callable<T> callable) {
        return j(new FutureTask(callable));
    }

    @CalledByNative
    private static boolean isThreadPriorityAudio(int i7) {
        return Process.getThreadPriority(i7) == -16;
    }

    @Deprecated
    public static <T> FutureTask<T> j(FutureTask<T> futureTask) {
        if (o()) {
            futureTask.run();
        } else {
            f(futureTask);
        }
        return futureTask;
    }

    @Deprecated
    public static void k(Runnable runnable) {
        if (o()) {
            runnable.run();
        } else {
            d().post(runnable);
        }
    }

    @Deprecated
    public static <T> T l(Callable<T> callable) throws ExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        j(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException e8) {
            throw new RuntimeException("Interrupted waiting for callable", e8);
        }
    }

    @Deprecated
    public static void m(Runnable runnable) {
        if (o()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        f(futureTask);
        try {
            futureTask.get();
        } catch (Exception e8) {
            throw new RuntimeException("Exception occurred while waiting for runnable", e8);
        }
    }

    @Deprecated
    @s0
    public static <T> T n(Callable<T> callable) {
        try {
            return (T) l(callable);
        } catch (ExecutionException e8) {
            throw new RuntimeException("Error occurred waiting for callable", e8);
        }
    }

    public static boolean o() {
        return d().getLooper() == Looper.myLooper();
    }

    public static void p(boolean z7) {
        f38733d = z7;
    }

    public static void q(Looper looper) {
        synchronized (f38730a) {
            try {
                if (looper == null) {
                    f38732c = null;
                    return;
                }
                Handler handler = f38732c;
                if (handler != null && handler.getLooper() != looper) {
                    throw new RuntimeException("UI thread looper is already set to " + f38732c.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + looper);
                }
                f38732c = new Handler(looper);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void r(boolean z7) {
        synchronized (f38730a) {
            f38731b = z7;
        }
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int i7) {
        Process.setThreadPriority(i7, -16);
    }
}
