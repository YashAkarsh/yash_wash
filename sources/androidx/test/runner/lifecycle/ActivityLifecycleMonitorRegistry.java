package androidx.test.runner.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityLifecycleMonitorRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<ActivityLifecycleMonitor> f10482a = new AtomicReference<>(null);

    private ActivityLifecycleMonitorRegistry() {
    }

    public static ActivityLifecycleMonitor a() {
        ActivityLifecycleMonitor activityLifecycleMonitor = f10482a.get();
        if (activityLifecycleMonitor != null) {
            return activityLifecycleMonitor;
        }
        throw new IllegalStateException("No lifecycle monitor registered! Are you running under an Instrumentation which registers lifecycle monitors?");
    }

    public static void b(ActivityLifecycleMonitor monitor) {
        f10482a.set(monitor);
    }
}
