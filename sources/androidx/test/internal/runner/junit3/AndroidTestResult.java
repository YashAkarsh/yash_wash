package androidx.test.internal.runner.junit3;

import android.app.Instrumentation;
import android.os.Bundle;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import java.util.concurrent.TimeoutException;
import junit.framework.b;
import junit.framework.h;
import junit.framework.i;
import junit.framework.j;
import junit.framework.m;

/* JADX INFO: loaded from: classes.dex */
class AndroidTestResult extends DelegatingTestResult {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Instrumentation f10118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Bundle f10119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f10120i;

    AndroidTestResult(Bundle bundle, Instrumentation instr, m result) {
        super(result);
        this.f10119h = bundle;
        this.f10118g = instr;
    }

    @Override // junit.framework.m
    protected void k(final j test) {
        if (test instanceof AndroidTestCase) {
            ((AndroidTestCase) test).setContext(this.f10118g.getTargetContext());
        }
        if (test instanceof InstrumentationTestCase) {
            ((InstrumentationTestCase) test).injectInstrumentation(this.f10118g);
        }
        super.k(test);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestResult, junit.framework.m
    public void m(final i test, h p7) {
        try {
            p7.a();
        } catch (InterruptedException unused) {
            super.a(test, new TimeoutException(String.format("Test timed out after %d milliseconds", Long.valueOf(this.f10120i))));
        } catch (ThreadDeath e8) {
            throw e8;
        } catch (b e9) {
            super.b(test, e9);
        } catch (Throwable th) {
            super.a(test, th);
        }
    }

    void r(long timeout) {
        this.f10120i = timeout;
    }
}
