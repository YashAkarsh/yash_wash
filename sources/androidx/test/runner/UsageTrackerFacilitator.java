package androidx.test.runner;

import android.util.Log;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.tracker.UsageTracker;
import androidx.test.internal.runner.tracker.UsageTrackerRegistry;
import androidx.test.internal.util.Checks;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class UsageTrackerFacilitator implements UsageTracker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10471b = "UsageTrackerFacilitator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10472a;

    public UsageTrackerFacilitator(@m0 RunnerArgs runnerArgs) {
        Checks.g(runnerArgs, "runnerArgs cannot be null!");
        if (runnerArgs.A != null) {
            this.f10472a = !runnerArgs.f10014t && runnerArgs.B;
        } else {
            this.f10472a = !runnerArgs.f10014t;
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void a() {
        if (d()) {
            UsageTrackerRegistry.a().a();
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void b(String usage, String version) {
        if (d()) {
            UsageTrackerRegistry.a().b(usage, version);
        }
    }

    public void c(@o0 UsageTracker usageTracker) {
        if (usageTracker == null || !d()) {
            Log.i(f10471b, "Usage tracking disabled");
            UsageTrackerRegistry.b(new UsageTracker.NoOpUsageTracker());
        } else {
            Log.i(f10471b, "Usage tracking enabled");
            UsageTrackerRegistry.b(usageTracker);
        }
    }

    public boolean d() {
        return this.f10472a;
    }

    public UsageTrackerFacilitator(boolean shouldTrackUsage) {
        this.f10472a = shouldTrackUsage;
    }
}
