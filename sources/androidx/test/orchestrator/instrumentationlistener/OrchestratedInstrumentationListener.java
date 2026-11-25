package androidx.test.orchestrator.instrumentationlistener;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.test.orchestrator.callback.OrchestratorCallback;
import androidx.test.orchestrator.junit.BundleJUnitUtils;
import androidx.test.orchestrator.listeners.OrchestrationListenerManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.runner.c;
import org.junit.runner.j;
import org.junit.runner.notification.a;
import org.junit.runner.notification.b;

/* JADX INFO: loaded from: classes.dex */
public final class OrchestratedInstrumentationListener extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f10261g = "OrchestrationListener";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f10262h = "androidx.test.orchestrator";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10263i = "androidx.test.orchestrator.OrchestratorService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnConnectListener f10264a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OrchestratorCallback f10268e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConditionVariable f10265b = new ConditionVariable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f10266c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f10267d = c.f39958h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ServiceConnection f10269f = new ServiceConnection() { // from class: androidx.test.orchestrator.instrumentationlistener.OrchestratedInstrumentationListener.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            OrchestratedInstrumentationListener.this.f10268e = OrchestratorCallback.Stub.z3(service);
            Log.i(OrchestratedInstrumentationListener.f10261g, "OrchestrationListener connected to service");
            OrchestratedInstrumentationListener.this.f10264a.a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName className) {
            OrchestratedInstrumentationListener.this.f10268e = null;
            Log.i(OrchestratedInstrumentationListener.f10261g, "OrchestrationListener disconnected from service");
        }
    };

    public interface OnConnectListener {
        void a();
    }

    public OrchestratedInstrumentationListener(OnConnectListener listener) {
        this.f10264a = listener;
    }

    @Override // org.junit.runner.notification.b
    public void a(a failure) {
        try {
            n(OrchestrationListenerManager.TestEvent.TEST_ASSUMPTION_FAILURE, BundleJUnitUtils.b(failure));
        } catch (RemoteException e8) {
            throw new IllegalStateException("Unable to send TestAssumptionFailure status, terminating", e8);
        }
    }

    @Override // org.junit.runner.notification.b
    public void b(a failure) {
        if (this.f10266c.compareAndSet(false, true)) {
            if (c.f39959i.equals(failure.a())) {
                failure = new a(this.f10267d, failure.b());
            }
            String strValueOf = String.valueOf(failure.b().getMessage());
            Log.d(f10261g, strValueOf.length() != 0 ? "Sending TestFailure event: ".concat(strValueOf) : new String("Sending TestFailure event: "));
            try {
                n(OrchestrationListenerManager.TestEvent.TEST_FAILURE, BundleJUnitUtils.b(failure));
            } catch (RemoteException e8) {
                throw new IllegalStateException("Unable to send TestFailure status, terminating", e8);
            }
        }
    }

    @Override // org.junit.runner.notification.b
    public void c(c description) {
        try {
            n(OrchestrationListenerManager.TestEvent.TEST_FINISHED, BundleJUnitUtils.a(description));
            this.f10265b.open();
        } catch (RemoteException e8) {
            Log.e(f10261g, "Unable to send TestFinished Status to Orchestrator", e8);
        }
    }

    @Override // org.junit.runner.notification.b
    public void d(c description) {
        try {
            n(OrchestrationListenerManager.TestEvent.TEST_IGNORED, BundleJUnitUtils.a(description));
        } catch (RemoteException e8) {
            Log.e(f10261g, "Unable to send TestIgnored Status to Orchestrator", e8);
        }
    }

    @Override // org.junit.runner.notification.b
    public void e(j result) {
        try {
            n(OrchestrationListenerManager.TestEvent.TEST_RUN_FINISHED, BundleJUnitUtils.c(result));
        } catch (RemoteException e8) {
            Log.e(f10261g, "Unable to send TestRunFinished Status to Orchestrator", e8);
        }
    }

    @Override // org.junit.runner.notification.b
    public void f(c description) {
        try {
            n(OrchestrationListenerManager.TestEvent.TEST_RUN_STARTED, BundleJUnitUtils.a(description));
        } catch (RemoteException e8) {
            Log.e(f10261g, "Unable to send TestRunStarted Status to Orchestrator", e8);
        }
    }

    @Override // org.junit.runner.notification.b
    public void g(c description) {
        this.f10265b.close();
        this.f10266c.set(false);
        this.f10267d = description;
        try {
            n(OrchestrationListenerManager.TestEvent.TEST_STARTED, BundleJUnitUtils.a(description));
        } catch (RemoteException e8) {
            Log.e(f10261g, "Unable to send TestStarted Status to Orchestrator", e8);
        }
    }

    public void i(String test) {
        OrchestratorCallback orchestratorCallback = this.f10268e;
        if (orchestratorCallback == null) {
            throw new IllegalStateException("Unable to send test, callback is null");
        }
        try {
            orchestratorCallback.M1(test);
        } catch (RemoteException e8) {
            Log.e(f10261g, "Unable to send test", e8);
        }
    }

    public void j(c description) {
        if (description.r()) {
            return;
        }
        if (!description.u()) {
            Iterator<c> it = description.m().iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return;
        }
        String strN = description.n();
        String strP = description.p();
        StringBuilder sb = new StringBuilder(String.valueOf(strN).length() + 1 + String.valueOf(strP).length());
        sb.append(strN);
        sb.append("#");
        sb.append(strP);
        i(sb.toString());
    }

    public void k(Context context) {
        Intent intent = new Intent(f10263i);
        intent.setPackage(f10262h);
        if (!context.bindService(intent, this.f10269f, 1)) {
            throw new RuntimeException("Cannot connect to androidx.test.orchestrator.OrchestratorService");
        }
    }

    public boolean l() {
        return this.f10266c.get();
    }

    public void m(Throwable t7) {
        b(new a(this.f10267d, t7));
        c(this.f10267d);
    }

    public void n(OrchestrationListenerManager.TestEvent type, Bundle bundle) throws RemoteException {
        if (this.f10268e == null) {
            throw new IllegalStateException("Unable to send notification, callback is null");
        }
        bundle.putString(OrchestrationListenerManager.f10283f, type.toString());
        this.f10268e.j2(bundle);
    }

    public void o(long timeoutMs) {
        this.f10265b.block(timeoutMs);
    }
}
