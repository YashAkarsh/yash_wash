package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import c.m0;
import c.o0;
import c.x0;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2033a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f2034b = Executors.newFixedThreadPool(4, new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private volatile Handler f2035c;

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f2036c = "arch_disk_io_%d";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f2037a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(f2036c, Integer.valueOf(this.f2037a.getAndIncrement())));
            return thread;
        }
    }

    private static Handler e(@m0 Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // androidx.arch.core.executor.d
    public void a(Runnable runnable) {
        this.f2034b.execute(runnable);
    }

    @Override // androidx.arch.core.executor.d
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // androidx.arch.core.executor.d
    public void d(Runnable runnable) {
        if (this.f2035c == null) {
            synchronized (this.f2033a) {
                if (this.f2035c == null) {
                    this.f2035c = e(Looper.getMainLooper());
                }
            }
        }
        this.f2035c.post(runnable);
    }
}
