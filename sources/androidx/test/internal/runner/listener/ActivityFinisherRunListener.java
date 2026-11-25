package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.internal.util.Checks;
import androidx.test.runner.MonitoringInstrumentation;
import org.junit.runner.c;
import org.junit.runner.notification.b;

/* JADX INFO: loaded from: classes.dex */
public class ActivityFinisherRunListener extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Instrumentation f10165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MonitoringInstrumentation.ActivityFinisher f10166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f10167c;

    public ActivityFinisherRunListener(Instrumentation instrumentation, MonitoringInstrumentation.ActivityFinisher finisher, Runnable waitForActivitiesToFinishRunnable) {
        this.f10165a = (Instrumentation) Checks.f(instrumentation);
        this.f10166b = (MonitoringInstrumentation.ActivityFinisher) Checks.f(finisher);
        this.f10167c = (Runnable) Checks.f(waitForActivitiesToFinishRunnable);
    }

    @Override // org.junit.runner.notification.b
    public void c(c description) throws Exception {
        InstrumentationConnection.f().i();
        this.f10165a.runOnMainSync(this.f10166b);
        this.f10167c.run();
    }

    @Override // org.junit.runner.notification.b
    public void g(c description) throws Exception {
        this.f10165a.runOnMainSync(this.f10166b);
        this.f10167c.run();
    }
}
