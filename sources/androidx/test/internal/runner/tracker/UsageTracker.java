package androidx.test.internal.runner.tracker;

/* JADX INFO: loaded from: classes.dex */
public interface UsageTracker {

    public static class NoOpUsageTracker implements UsageTracker {
        @Override // androidx.test.internal.runner.tracker.UsageTracker
        public void a() {
        }

        @Override // androidx.test.internal.runner.tracker.UsageTracker
        public void b(String unused, String unusedVersion) {
        }
    }

    void a();

    void b(String usage, String version);
}
