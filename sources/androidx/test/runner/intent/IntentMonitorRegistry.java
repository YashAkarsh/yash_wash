package androidx.test.runner.intent;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class IntentMonitorRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<IntentMonitor> f10473a = new AtomicReference<>(null);

    private IntentMonitorRegistry() {
    }

    public static IntentMonitor a() {
        IntentMonitor intentMonitor = f10473a.get();
        if (intentMonitor != null) {
            return intentMonitor;
        }
        throw new IllegalStateException("No intent monitor registered! Are you running under an Instrumentation which registers intent monitors?");
    }

    public static void b(IntentMonitor monitor) {
        f10473a.set(monitor);
    }
}
