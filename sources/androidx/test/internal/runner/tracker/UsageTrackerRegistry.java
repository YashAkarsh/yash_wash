package androidx.test.internal.runner.tracker;

import androidx.test.internal.util.Checks;

/* JADX INFO: loaded from: classes.dex */
public final class UsageTrackerRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile UsageTracker f10227a = new UsageTracker.NoOpUsageTracker();

    public interface AxtVersions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f10228a = "3.3.0";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f10229b = "1.3.0";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f10230c = "1.3.0";
    }

    private UsageTrackerRegistry() {
    }

    public static UsageTracker a() {
        return f10227a;
    }

    public static void b(UsageTracker tracker) {
        f10227a = (UsageTracker) Checks.f(tracker);
    }
}
