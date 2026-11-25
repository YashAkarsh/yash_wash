package androidx.test.internal.runner;

import androidx.test.internal.runner.junit3.JUnit38ClassRunner;
import androidx.test.internal.runner.junit3.NonExecutingTestSuite;
import androidx.test.internal.util.AndroidRunnerBuilderUtil;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.internal.util.Checks;
import java.util.List;
import junit.framework.i;
import junit.framework.n;
import org.junit.internal.runners.b;
import org.junit.runner.l;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes.dex */
class AndroidLogOnlyBuilder extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AndroidRunnerBuilder f9923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AndroidRunnerParams f9924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9926e = 0;

    AndroidLogOnlyBuilder(AndroidRunnerParams runnerParams, boolean scanningPath, List<Class<? extends h>> customRunnerBuilderClasses) {
        this.f9924c = (AndroidRunnerParams) Checks.g(runnerParams, "runnerParams cannot be null!");
        this.f9925d = scanningPath;
        this.f9923b = new AndroidRunnerBuilder(this, runnerParams, scanningPath, customRunnerBuilderClasses);
    }

    @Override // org.junit.runners.model.h
    public l c(Class<?> testClass) throws Exception {
        this.f9926e++;
        if (AndroidRunnerBuilderUtil.c(testClass)) {
            if (!this.f9925d || AndroidRunnerBuilderUtil.a(testClass)) {
                return new JUnit38ClassRunner(new NonExecutingTestSuite(testClass));
            }
            return null;
        }
        if (!AndroidRunnerBuilderUtil.b(testClass)) {
            int i7 = this.f9926e;
            l lVarC = this.f9923b.c(testClass);
            if (lVarC == null) {
                return null;
            }
            return (!(lVarC instanceof b) && this.f9926e <= i7) ? new NonExecutingRunner(lVarC) : lVarC;
        }
        if (this.f9924c.d()) {
            return null;
        }
        i iVarL = org.junit.internal.runners.i.l(testClass);
        if (iVarL instanceof n) {
            return new JUnit38ClassRunner(new NonExecutingTestSuite((n) iVarL));
        }
        throw new IllegalArgumentException(testClass.getName().concat("#suite() did not return a TestSuite"));
    }
}
