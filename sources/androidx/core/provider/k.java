package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.w;
import c.e0;
import c.m0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
class k {

    private static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6184b;

        /* JADX INFO: renamed from: androidx.core.provider.k$a$a, reason: collision with other inner class name */
        private static class C0070a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f6185a;

            C0070a(Runnable runnable, String str, int i7) {
                super(runnable, str);
                this.f6185a = i7;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f6185a);
                super.run();
            }
        }

        a(@m0 String str, int i7) {
            this.f6183a = str;
            this.f6184b = i7;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0070a(runnable, this.f6183a, this.f6184b);
        }
    }

    private static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f6186a;

        b(@m0 Handler handler) {
            this.f6186a = (Handler) w.l(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@m0 Runnable runnable) {
            if (this.f6186a.post((Runnable) w.l(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f6186a + " is shutting down");
        }
    }

    private static class c<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private Callable<T> f6187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private androidx.core.util.e<T> f6188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private Handler f6189c;

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.core.util.e f6190a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object f6191b;

            a(androidx.core.util.e eVar, Object obj) {
                this.f6190a = eVar;
                this.f6191b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f6190a.accept(this.f6191b);
            }
        }

        c(@m0 Handler handler, @m0 Callable<T> callable, @m0 androidx.core.util.e<T> eVar) {
            this.f6187a = callable;
            this.f6188b = eVar;
            this.f6189c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T tCall;
            try {
                tCall = this.f6187a.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f6189c.post(new a(this.f6188b, tCall));
        }
    }

    private k() {
    }

    static ThreadPoolExecutor a(@m0 String str, int i7, @e0(from = 0) int i8) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i8, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i7));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor b(@m0 Handler handler) {
        return new b(handler);
    }

    static <T> void c(@m0 Executor executor, @m0 Callable<T> callable, @m0 androidx.core.util.e<T> eVar) {
        executor.execute(new c(androidx.core.provider.b.a(), callable, eVar));
    }

    static <T> T d(@m0 ExecutorService executorService, @m0 Callable<T> callable, @e0(from = 0) int i7) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i7, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e8) {
            throw e8;
        } catch (ExecutionException e9) {
            throw new RuntimeException(e9);
        } catch (TimeoutException unused) {
            throw new InterruptedException(com.alipay.sdk.data.a.f13674p);
        }
    }
}
