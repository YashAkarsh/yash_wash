package androidx.test.internal.runner.junit3;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerBuilderUtil;
import androidx.test.internal.util.AndroidRunnerParams;
import org.junit.internal.builders.e;
import org.junit.runner.l;
import org.junit.runner.notification.c;

/* JADX INFO: loaded from: classes.dex */
public class AndroidJUnit3Builder extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10112d = "AndroidJUnit3Builder";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f10113e = new l() { // from class: androidx.test.internal.runner.junit3.AndroidJUnit3Builder.1
        @Override // org.junit.runner.l
        public void a(c notifier) {
        }

        @Override // org.junit.runner.l, org.junit.runner.b
        public org.junit.runner.c b() {
            return org.junit.runner.c.f39958h;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AndroidRunnerParams f10114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10115c;

    public AndroidJUnit3Builder(AndroidRunnerParams runnerParams, boolean scanningPath) {
        this.f10114b = runnerParams;
        this.f10115c = scanningPath;
    }

    @Override // org.junit.internal.builders.e, org.junit.runners.model.h
    public l c(Class<?> testClass) throws Throwable {
        try {
            if (AndroidRunnerBuilderUtil.c(testClass)) {
                return (!this.f10115c || AndroidRunnerBuilderUtil.a(testClass)) ? new JUnit38ClassRunner(new AndroidTestSuite(testClass, this.f10114b)) : f10113e;
            }
            return null;
        } catch (Throwable th) {
            Log.e(f10112d, "Error constructing runner", th);
            throw th;
        }
    }

    @Deprecated
    public AndroidJUnit3Builder(AndroidRunnerParams runnerParams) {
        this(runnerParams, false);
    }
}
