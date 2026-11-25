package androidx.test.rule;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;
import androidx.test.runner.intercepting.SingleActivityFactory;
import androidx.test.runner.lifecycle.ActivityLifecycleCallback;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import c.g1;
import c.m0;
import c.o0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import org.junit.rules.l;
import org.junit.runner.c;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ActivityTestRule<T extends Activity> implements l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f10323k = "ActivityTestRule";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f10324l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f10325m = "mResultCode";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f10326n = "mResultData";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f10327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ActivityLifecycleCallback f10330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Instrumentation f10331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SingleActivityFactory<T> f10334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g1
    volatile WeakReference<T> f10335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile Instrumentation.ActivityResult f10336j;

    private class ActivityStatement extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f10341a;

        public ActivityStatement(j base) {
            this.f10341a = base;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            MonitoringInstrumentation monitoringInstrumentation = ActivityTestRule.this.f10331e instanceof MonitoringInstrumentation ? (MonitoringInstrumentation) ActivityTestRule.this.f10331e : null;
            try {
                if (ActivityTestRule.this.f10334h != null && monitoringInstrumentation != null) {
                    monitoringInstrumentation.r(ActivityTestRule.this.f10334h);
                }
                if (ActivityTestRule.this.f10333g) {
                    ActivityTestRule activityTestRule = ActivityTestRule.this;
                    activityTestRule.r(activityTestRule.p());
                }
                this.f10341a.a();
            } finally {
                if (monitoringInstrumentation != null) {
                    monitoringInstrumentation.F();
                }
                if (ActivityTestRule.this.f10335i.get() != null) {
                    ActivityTestRule.this.n();
                }
                ActivityTestRule.this.f10336j = null;
                ActivityLifecycleMonitorRegistry.a().c(ActivityTestRule.this.f10330d);
            }
        }
    }

    private class LifecycleCallback implements ActivityLifecycleCallback {
        private LifecycleCallback() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.test.runner.lifecycle.ActivityLifecycleCallback
        public void a(Activity activity, Stage stage) {
            if (ActivityTestRule.this.f10327a.isInstance(activity)) {
                if (Stage.RESUMED == stage) {
                    ActivityTestRule activityTestRule = ActivityTestRule.this;
                    activityTestRule.f10335i = activityTestRule.s((Activity) activityTestRule.f10327a.cast(activity));
                } else if (Stage.PAUSED == stage && activity.isFinishing() && ActivityTestRule.this.f10336j != null) {
                    ActivityTestRule activityTestRule2 = ActivityTestRule.this;
                    activityTestRule2.u((Activity) activityTestRule2.f10327a.cast(activity));
                }
            }
        }
    }

    public ActivityTestRule(Class<T> activityClass) {
        this(activityClass, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final T activity) {
        Checks.j(Looper.myLooper() == Looper.getMainLooper(), "Must be called on the main thread!");
        Checks.g(activity, "Activity wasn't created yet or already destroyed!");
        try {
            Field declaredField = Activity.class.getDeclaredField(f10325m);
            declaredField.setAccessible(true);
            Field declaredField2 = Activity.class.getDeclaredField(f10326n);
            declaredField2.setAccessible(true);
            this.f10336j = new Instrumentation.ActivityResult(((Integer) declaredField.get(activity)).intValue(), (Intent) declaredField2.get(activity));
        } catch (IllegalAccessException e8) {
            Log.e(f10323k, "Field mResultCode or mResultData is not accessible", e8);
            throw new RuntimeException("Field mResultCode or mResultData is not accessible", e8);
        } catch (NoSuchFieldException e9) {
            Log.e(f10323k, "Looks like the Android Activity class has changed itsprivate fields for mResultCode or mResultData. Time to update the reflection code.", e9);
            throw new RuntimeException("Looks like the Android Activity class has changed itsprivate fields for mResultCode or mResultData. Time to update the reflection code.", e9);
        }
    }

    @Override // org.junit.rules.l
    public j a(final j base, c description) {
        return new ActivityStatement(base);
    }

    protected void j() {
    }

    protected void k() {
    }

    protected void l() {
    }

    @g1
    void m() {
        try {
            final T t7 = this.f10335i.get();
            t(new Runnable() { // from class: androidx.test.rule.ActivityTestRule.1
                @Override // java.lang.Runnable
                public void run() {
                    Checks.j(t7 != null, "Activity was not launched. If you manually finished it, you must launch it again before finishing it. ");
                    t7.finish();
                    ActivityTestRule.this.u(t7);
                }
            });
            this.f10331e.waitForIdleSync();
        } catch (Throwable th) {
            Log.e(f10323k, "Failed to execute activity.finish() on the main thread", th);
            throw new IllegalStateException("Failed to execute activity.finish() on the main thread", th);
        }
    }

    public void n() {
        try {
            if (this.f10335i.get() != null) {
                m();
            }
        } finally {
            this.f10335i = s(null);
            j();
        }
    }

    public T o() {
        T t7 = this.f10335i.get();
        if (t7 == null) {
            Log.w(f10323k, "Activity wasn't created yet or already stopped");
        }
        return t7;
    }

    protected Intent p() {
        return null;
    }

    public Instrumentation.ActivityResult q() {
        if (this.f10336j == null) {
            final T t7 = this.f10335i.get();
            Checks.g(t7, "Activity wasn't created yet or already destroyed!");
            try {
                t(new Runnable() { // from class: androidx.test.rule.ActivityTestRule.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Checks.j(t7.isFinishing(), "Activity is not finishing!");
                        ActivityTestRule.this.u(t7);
                    }
                });
            } catch (Throwable th) {
                throw new IllegalStateException(th);
            }
        }
        return this.f10336j;
    }

    public T r(@o0 Intent startIntent) {
        this.f10331e.setInTouchMode(this.f10332f);
        if (startIntent == null && (startIntent = p()) == null) {
            Log.w(f10323k, "getActivityIntent() returned null using default: Intent(Intent.ACTION_MAIN)");
            startIntent = new Intent("android.intent.action.MAIN");
        }
        if (startIntent.getComponent() == null) {
            startIntent.setClassName(this.f10328b, this.f10327a.getName());
        }
        if (startIntent.getFlags() == 0) {
            startIntent.addFlags(this.f10329c);
        }
        l();
        T tCast = this.f10327a.cast(this.f10331e.startActivitySync(startIntent));
        this.f10335i = s(tCast);
        this.f10331e.waitForIdleSync();
        if (tCast != null) {
            ActivityLifecycleMonitorRegistry.a().a(this.f10330d);
            k();
        } else {
            String str = String.format("Activity %s, failed to launch", startIntent.getComponent());
            Bundle bundle = new Bundle();
            String strValueOf = String.valueOf(str);
            bundle.putString("stream", strValueOf.length() != 0 ? "ActivityTestRule ".concat(strValueOf) : new String("ActivityTestRule "));
            this.f10331e.sendStatus(0, bundle);
            Log.e(f10323k, str);
        }
        return tCast;
    }

    @g1
    WeakReference<T> s(T activity) {
        return new WeakReference<>(activity);
    }

    public void t(final Runnable runnable) throws Throwable {
        UiThreadStatement.f(runnable);
    }

    @g1
    void v(Instrumentation instrumentation) {
        this.f10331e = (Instrumentation) Checks.g(instrumentation, "instrumentation cannot be null!");
    }

    public ActivityTestRule(Class<T> activityClass, boolean initialTouchMode) {
        this((Class) activityClass, initialTouchMode, true);
    }

    public ActivityTestRule(Class<T> activityClass, boolean initialTouchMode, boolean launchActivity) {
        this(activityClass, InstrumentationRegistry.b().getTargetContext().getPackageName(), 268435456, initialTouchMode, launchActivity);
    }

    public ActivityTestRule(SingleActivityFactory<T> activityFactory, boolean initialTouchMode, boolean launchActivity) {
        this(activityFactory.d(), initialTouchMode, launchActivity);
        this.f10334h = activityFactory;
    }

    public ActivityTestRule(Class<T> activityClass, @m0 String targetPackage, int launchFlags, boolean initialTouchMode, boolean launchActivity) {
        this.f10330d = new LifecycleCallback();
        this.f10332f = false;
        this.f10333g = false;
        this.f10335i = s(null);
        this.f10331e = InstrumentationRegistry.b();
        this.f10327a = activityClass;
        this.f10328b = (String) Checks.g(targetPackage, "targetPackage cannot be null!");
        this.f10329c = launchFlags;
        this.f10332f = initialTouchMode;
        this.f10333g = launchActivity;
    }
}
