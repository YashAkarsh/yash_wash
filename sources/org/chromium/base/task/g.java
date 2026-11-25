package org.chromium.base.task;

import android.os.AsyncTask;
import android.os.Process;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.s0;

/* JADX INFO: loaded from: classes3.dex */
class g extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f38918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f38919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f38920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f38921d = 30;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f38922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f38923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f38924g = 32;

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f38925a = new AtomicInteger(1);

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Runnable runnable) {
            Process.setThreadPriority(10);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() { // from class: org.chromium.base.task.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.a.b(runnable);
                }
            }, "CrAsyncTask #" + this.f38925a.getAndIncrement());
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f38918a = iAvailableProcessors;
        f38919b = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f38920c = (iAvailableProcessors * 2) + 1;
        f38922e = new a();
        f38923f = new ArrayBlockingQueue(128);
    }

    g() {
        this(f38919b, f38920c, 30L, TimeUnit.SECONDS, f38923f, f38922e);
    }

    private String a(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() > 32) {
                sb.append(entry.getKey());
                sb.append(' ');
            }
        }
        return sb.length() == 0 ? "NO CLASSES FOUND" : sb.toString();
    }

    private static String b(Runnable runnable) {
        Class clsA;
        Class cls = runnable.getClass();
        try {
            if (cls != c.b.class) {
                if (cls.getEnclosingClass() == AsyncTask.class) {
                    Field declaredField = cls.getDeclaredField("this$0");
                    declaredField.setAccessible(true);
                    clsA = declaredField.get(runnable).getClass();
                }
                return cls.getName();
            }
            clsA = ((c.b) runnable).a();
            cls = clsA;
        } catch (IllegalAccessException e8) {
            if (org.chromium.base.l.f38814b) {
                throw new RuntimeException(e8);
            }
        } catch (NoSuchFieldException e9) {
            if (org.chromium.base.l.f38814b) {
                throw new RuntimeException(e9);
            }
        }
        return cls.getName();
    }

    private Map<String, Integer> c() {
        HashMap map = new HashMap();
        for (Runnable runnable : (Runnable[]) getQueue().toArray(new Runnable[0])) {
            String strB = b(runnable);
            map.put(strB, Integer.valueOf((map.containsKey(strB) ? ((Integer) map.get(strB)).intValue() : 0) + 1));
        }
        return map;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e8) {
            throw new RejectedExecutionException("Prominent classes in AsyncTask: " + a(c()), e8);
        }
    }

    @s0
    g(int i7, int i8, long j7, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i7, i8, j7, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }
}
