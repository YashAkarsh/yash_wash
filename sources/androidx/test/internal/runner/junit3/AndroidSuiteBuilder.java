package androidx.test.internal.runner.junit3;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import junit.framework.i;
import junit.framework.n;
import org.junit.internal.builders.h;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes.dex */
public class AndroidSuiteBuilder extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10116c = "AndroidSuiteBuilder";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AndroidRunnerParams f10117b;

    public AndroidSuiteBuilder(AndroidRunnerParams runnerParams) {
        this.f10117b = runnerParams;
    }

    @Override // org.junit.internal.builders.h, org.junit.runners.model.h
    public l c(Class<?> testClass) throws Throwable {
        if (this.f10117b.d()) {
            return null;
        }
        try {
            if (!h(testClass)) {
                return null;
            }
            i iVarL = org.junit.internal.runners.i.l(testClass);
            if (iVarL instanceof n) {
                return new JUnit38ClassRunner(new AndroidTestSuite((n) iVarL, this.f10117b));
            }
            throw new IllegalArgumentException(testClass.getName().concat("#suite() did not return a TestSuite"));
        } catch (Throwable th) {
            Log.e(f10116c, "Error constructing runner", th);
            throw th;
        }
    }
}
