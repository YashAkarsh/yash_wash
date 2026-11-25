package androidx.test.internal.runner.junit4;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.runner.AndroidJUnit4;
import c.g1;
import org.junit.internal.builders.b;
import org.junit.runner.k;
import org.junit.runner.l;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes.dex */
public class AndroidAnnotatedBuilder extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10134e = "AndroidAnnotatedBuilder";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AndroidRunnerParams f10135d;

    public AndroidAnnotatedBuilder(h suiteBuilder, AndroidRunnerParams runnerParams) {
        super(suiteBuilder);
        this.f10135d = runnerParams;
    }

    @Override // org.junit.internal.builders.b, org.junit.runners.model.h
    public l c(Class<?> testClass) throws Exception {
        try {
            k kVar = (k) testClass.getAnnotation(k.class);
            if (kVar != null && AndroidJUnit4.class.equals(kVar.value())) {
                Class<? extends l> clsValue = kVar.value();
                try {
                    l lVarJ = j(clsValue, testClass);
                    if (lVarJ != null) {
                        return lVarJ;
                    }
                } catch (NoSuchMethodException unused) {
                    return super.h(clsValue, testClass);
                }
            }
            return super.c(testClass);
        } catch (Throwable th) {
            Log.e(f10134e, "Error constructing runner", th);
            throw th;
        }
    }

    @g1
    public l j(Class<? extends l> runnerClass, Class<?> testClass) throws Exception {
        return runnerClass.getConstructor(Class.class, AndroidRunnerParams.class).newInstance(testClass, this.f10135d);
    }
}
