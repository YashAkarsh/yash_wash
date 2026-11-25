package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h f11362d = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f11363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f11364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f11365c;

    private static class b implements Executor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f11366b = 15;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadLocal<Integer> f11367a;

        private b() {
            this.f11367a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f11367a.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                this.f11367a.remove();
            } else {
                this.f11367a.set(Integer.valueOf(iIntValue));
            }
            return iIntValue;
        }

        private int b() {
            Integer num = this.f11367a.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() + 1;
            this.f11367a.set(Integer.valueOf(iIntValue));
            return iIntValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (b() <= 15) {
                    runnable.run();
                } else {
                    h.a().execute(runnable);
                }
                a();
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
    }

    private h() {
        this.f11363a = !c() ? Executors.newCachedThreadPool() : bolts.b.b();
        this.f11364b = Executors.newSingleThreadScheduledExecutor();
        this.f11365c = new b();
    }

    public static ExecutorService a() {
        return f11362d.f11363a;
    }

    static Executor b() {
        return f11362d.f11365c;
    }

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    static ScheduledExecutorService d() {
        return f11362d.f11364b;
    }
}
