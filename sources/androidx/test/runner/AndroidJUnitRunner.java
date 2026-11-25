package androidx.test.runner;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.TestExecutor;
import androidx.test.internal.runner.TestRequestBuilder;
import androidx.test.internal.runner.listener.ActivityFinisherRunListener;
import androidx.test.internal.runner.listener.CoverageListener;
import androidx.test.internal.runner.listener.DelayInjector;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import androidx.test.internal.runner.listener.LogRunListener;
import androidx.test.internal.runner.listener.SuiteAssignmentPrinter;
import androidx.test.internal.runner.tracker.AnalyticsBasedUsageTracker;
import androidx.test.internal.util.ReflectionUtil;
import androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry;
import androidx.test.runner.screenshot.Screenshot;
import c.g1;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.junit.runner.i;
import org.junit.runner.notification.b;

/* JADX INFO: loaded from: classes.dex */
public class AndroidJUnitRunner extends MonitoringInstrumentation implements OrchestratedInstrumentationListener.OnConnectListener {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f10435y = "AndroidJUnitRunner";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final long f10436z = TimeUnit.SECONDS.toMillis(20);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Bundle f10437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private InstrumentationResultPrinter f10438u = new InstrumentationResultPrinter();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private RunnerArgs f10439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private UsageTrackerFacilitator f10440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private OrchestratedInstrumentationListener f10441x;

    private void H(RunnerArgs args, TestExecutor.Builder builder) {
        if (args.f9997c) {
            builder.c(new CoverageListener(args.f9998d));
        }
    }

    private void I(RunnerArgs args, TestExecutor.Builder builder) {
        int i7 = args.f9999e;
        if (i7 > 0) {
            builder.c(new DelayInjector(i7));
        }
    }

    private void K(RunnerArgs args, TestExecutor.Builder builder) {
        Iterator<b> it = args.f10007m.iterator();
        while (it.hasNext()) {
            builder.c(it.next());
        }
    }

    private void L(RunnerArgs args, TestExecutor.Builder builder) {
        if (args.f10000f) {
            builder.c(R());
        } else if (args.f9996b) {
            builder.c(new SuiteAssignmentPrinter());
        } else {
            builder.c(new LogRunListener());
            OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.f10441x;
            if (orchestratedInstrumentationListener != null) {
                builder.c(orchestratedInstrumentationListener);
            } else {
                builder.c(R());
            }
            if (B()) {
                builder.c(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() { // from class: androidx.test.runner.AndroidJUnitRunner.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AndroidJUnitRunner.this.G();
                    }
                }));
            }
            I(args, builder);
            H(args, builder);
        }
        K(args, builder);
    }

    private void M(RunnerArgs args, TestExecutor.Builder builder) {
        K(args, builder);
        if (args.f10000f) {
            builder.c(R());
            return;
        }
        if (args.f9996b) {
            builder.c(new SuiteAssignmentPrinter());
            return;
        }
        builder.c(new LogRunListener());
        I(args, builder);
        H(args, builder);
        OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.f10441x;
        if (orchestratedInstrumentationListener != null) {
            builder.c(orchestratedInstrumentationListener);
        } else {
            builder.c(R());
        }
        if (B()) {
            builder.c(new ActivityFinisherRunListener(this, new MonitoringInstrumentation.ActivityFinisher(), new Runnable() { // from class: androidx.test.runner.AndroidJUnitRunner.2
                @Override // java.lang.Runnable
                public void run() {
                    AndroidJUnitRunner.this.G();
                }
            }));
        }
    }

    private void N(RunnerArgs args) {
        Screenshot.a(new HashSet(args.f10020z));
    }

    private Bundle Q() {
        return this.f10437t;
    }

    private void S(Bundle arguments) {
        this.f10439v = new RunnerArgs.Builder().G(this).F(this, arguments).E();
    }

    private void T() {
        Context targetContext = getTargetContext();
        if (targetContext != null) {
            this.f10440w.c(new AnalyticsBasedUsageTracker.Builder(targetContext).h());
        }
    }

    private boolean U(RunnerArgs arguments) {
        return arguments.f9995a && !arguments.B;
    }

    @g1
    final void J(RunnerArgs args, TestExecutor.Builder builder) {
        if (args.D) {
            M(args, builder);
        } else {
            L(args, builder);
        }
    }

    @g1
    i O(RunnerArgs runnerArgs, Bundle bundleArgs) {
        TestRequestBuilder testRequestBuilderP = P(this, bundleArgs);
        testRequestBuilderP.j(runnerArgs.f10017w);
        if (runnerArgs.f10017w.isEmpty()) {
            testRequestBuilderP.i(getContext().getPackageCodePath());
        }
        testRequestBuilderP.h(runnerArgs);
        T();
        return testRequestBuilderP.p();
    }

    TestRequestBuilder P(Instrumentation instr, Bundle arguments) {
        return new TestRequestBuilder(instr, arguments);
    }

    @g1
    InstrumentationResultPrinter R() {
        return this.f10438u;
    }

    @Override // androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener.OnConnectListener
    public void a() {
        start();
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void finish(int resultCode, Bundle results) {
        try {
            this.f10440w.b("AndroidJUnitRunner", "1.3.0");
            this.f10440w.a();
        } catch (RuntimeException e8) {
            Log.w("AndroidJUnitRunner", "Failed to send analytics.", e8);
        }
        super.finish(resultCode, results);
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        this.f10437t = arguments;
        S(arguments);
        if (U(this.f10439v)) {
            Log.i("AndroidJUnitRunner", "Waiting for debugger to connect...");
            Debug.waitForDebugger();
            Log.i("AndroidJUnitRunner", "Debugger connected.");
        }
        if (w(this.f10439v.f10019y)) {
            this.f10440w = new UsageTrackerFacilitator(this.f10439v);
        } else {
            this.f10440w = new UsageTrackerFacilitator(false);
        }
        Iterator<ApplicationLifecycleCallback> it = this.f10439v.f10015u.iterator();
        while (it.hasNext()) {
            ApplicationLifecycleMonitorRegistry.a().b(it.next());
        }
        N(this.f10439v);
        RunnerArgs runnerArgs = this.f10439v;
        if (runnerArgs.A == null || !w(runnerArgs.f10019y)) {
            start();
            return;
        }
        OrchestratedInstrumentationListener orchestratedInstrumentationListener = new OrchestratedInstrumentationListener(this);
        this.f10441x = orchestratedInstrumentationListener;
        orchestratedInstrumentationListener.k(getContext());
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public boolean onException(Object obj, Throwable e8) {
        Log.e("AndroidJUnitRunner", "An unhandled exception was thrown by the app.");
        InstrumentationResultPrinter instrumentationResultPrinterR = R();
        if (instrumentationResultPrinterR != null) {
            instrumentationResultPrinterR.n(e8);
        }
        OrchestratedInstrumentationListener orchestratedInstrumentationListener = this.f10441x;
        if (orchestratedInstrumentationListener != null) {
            orchestratedInstrumentationListener.o(f10436z);
            if (!this.f10441x.l()) {
                Log.i("AndroidJUnitRunner", "No test failure has been reported. Report the process crash.");
                this.f10441x.m(e8);
            }
        }
        Log.i("AndroidJUnitRunner", "Bringing down the entire Instrumentation process.");
        return super.onException(obj, e8);
    }

    @Override // androidx.test.runner.MonitoringInstrumentation, android.app.Instrumentation
    public void onStart() {
        z("androidx.test.espresso.web.bridge.JavaScriptBridge");
        super.onStart();
        RunnerArgs runnerArgs = this.f10439v;
        if (runnerArgs.B && w(runnerArgs.f10019y)) {
            this.f10441x.j(O(this.f10439v, Q()).h().b());
            finish(-1, new Bundle());
            return;
        }
        RunnerArgs.TestArg testArg = this.f10439v.f10018x;
        if (testArg != null) {
            ReflectionUtil.a(testArg.f10047a, testArg.f10048b);
        }
        if (!w(this.f10439v.f10019y)) {
            Log.i("AndroidJUnitRunner", "Runner is idle...");
            return;
        }
        Bundle bundle = new Bundle();
        try {
            TestExecutor.Builder builder = new TestExecutor.Builder(this);
            J(this.f10439v, builder);
            bundle = builder.d().a(O(this.f10439v, Q()));
        } catch (RuntimeException e8) {
            Log.e("AndroidJUnitRunner", "Fatal exception when running tests", e8);
            String strValueOf = String.valueOf(Log.getStackTraceString(e8));
            bundle.putString("stream", strValueOf.length() != 0 ? "Fatal exception when running tests\n".concat(strValueOf) : new String("Fatal exception when running tests\n"));
        }
        finish(-1, bundle);
    }
}
