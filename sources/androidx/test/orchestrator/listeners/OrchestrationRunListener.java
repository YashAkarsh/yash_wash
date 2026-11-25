package androidx.test.orchestrator.listeners;

import android.app.Instrumentation;
import androidx.test.orchestrator.junit.ParcelableDescription;
import androidx.test.orchestrator.junit.ParcelableFailure;
import androidx.test.orchestrator.junit.ParcelableResult;

/* JADX INFO: loaded from: classes.dex */
public abstract class OrchestrationRunListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Instrumentation f10297a;

    public Instrumentation a() {
        return this.f10297a;
    }

    public void b(int testCount) {
    }

    public void c(Instrumentation instrumentation) {
        if (instrumentation == null) {
            throw new IllegalArgumentException("Instrumentation should not be null");
        }
        this.f10297a = instrumentation;
    }

    public void d(ParcelableFailure failure) {
    }

    public void e(ParcelableFailure failure) {
    }

    public void f(ParcelableDescription description) {
    }

    public void g(ParcelableDescription description) {
    }

    public void h(String message) {
    }

    public void i(ParcelableResult result) {
    }

    public void j(ParcelableDescription description) {
    }

    public void k(ParcelableDescription description) {
    }
}
