package androidx.test.internal.runner.listener;

import android.util.Log;
import androidx.test.internal.runner.TestSize;
import c.g1;
import com.alibaba.android.arouter.utils.b;
import org.junit.runner.c;
import org.junit.runner.notification.a;

/* JADX INFO: loaded from: classes.dex */
public class SuiteAssignmentPrinter extends InstrumentationRunListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g1
    long f10196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g1
    long f10197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g1
    boolean f10198d;

    @Override // org.junit.runner.notification.b
    public void a(a failure) {
        this.f10198d = false;
    }

    @Override // org.junit.runner.notification.b
    public void b(a failure) throws Exception {
        this.f10198d = false;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x007a  */
    @Override // org.junit.runner.notification.b
    public void c(c description) throws Exception {
        long jM = m();
        this.f10197c = jM;
        if (this.f10198d) {
            long j7 = this.f10196b;
            if (j7 < 0) {
                k("F");
                Log.d("SuiteAssignmentPrinter", String.format("%s#%s: skipping suite assignment due to test failure\n", description.n(), description.p()));
            } else {
                long j8 = jM - j7;
                TestSize testSizeG = TestSize.g(j8);
                TestSize testSizeA = TestSize.a(description);
                if (testSizeG.equals(testSizeA)) {
                    k(b.f12515h);
                    Log.d("SuiteAssignmentPrinter", String.format("%s#%s assigned correctly as %s. runTime: %d ms\n", description.n(), description.p(), testSizeG.f(), Long.valueOf(j8)));
                } else {
                    k(String.format("\n%s#%s: current size: %s. suggested: %s runTime: %d ms\n", description.n(), description.p(), testSizeA, testSizeG.f(), Long.valueOf(j8)));
                }
            }
        } else {
            k("F");
            Log.d("SuiteAssignmentPrinter", String.format("%s#%s: skipping suite assignment due to test failure\n", description.n(), description.p()));
        }
        this.f10196b = -1L;
    }

    @Override // org.junit.runner.notification.b
    public void d(c description) throws Exception {
        this.f10198d = false;
    }

    @Override // org.junit.runner.notification.b
    public void g(c description) throws Exception {
        this.f10198d = true;
        this.f10196b = m();
    }

    @g1
    public long m() {
        return System.currentTimeMillis();
    }
}
