package bolts;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f11328b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f11329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f11330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f11331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long f11332f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f11333a = new ExecutorC0136b();

    /* JADX INFO: renamed from: bolts.b$b, reason: collision with other inner class name */
    private static class ExecutorC0136b implements Executor {
        private ExecutorC0136b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f11329c = iAvailableProcessors;
        f11330d = iAvailableProcessors + 1;
        f11331e = (iAvailableProcessors * 2) + 1;
    }

    private b() {
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z7) {
        threadPoolExecutor.allowCoreThreadTimeOut(z7);
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f11330d, f11331e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static ExecutorService c(ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f11330d, f11331e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor d() {
        return f11328b.f11333a;
    }
}
