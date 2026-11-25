package androidx.test.internal.runner.junit4;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.Method;
import org.junit.internal.builders.f;
import org.junit.m;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes.dex */
public class AndroidJUnit4Builder extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10136d = "AndroidJUnit4Builder";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AndroidRunnerParams f10137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10138c;

    public AndroidJUnit4Builder(AndroidRunnerParams runnerParams, boolean scanningPath) {
        this.f10137b = runnerParams;
        this.f10138c = scanningPath;
    }

    private static boolean h(Class<?> testClass) {
        try {
            for (Method method : testClass.getMethods()) {
                if (method.isAnnotationPresent(m.class)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.w(f10136d, String.format("%s in hasTestMethods for %s", th.toString(), testClass.getName()));
            return false;
        }
    }

    @Override // org.junit.internal.builders.f, org.junit.runners.model.h
    public l c(Class<?> testClass) throws Throwable {
        try {
            if (!this.f10138c || h(testClass)) {
                return new AndroidJUnit4ClassRunner(testClass, this.f10137b);
            }
            return null;
        } catch (Throwable th) {
            Log.e(f10136d, "Error constructing runner", th);
            throw th;
        }
    }

    @Deprecated
    public AndroidJUnit4Builder(AndroidRunnerParams runnerParams) {
        this(runnerParams, false);
    }
}
