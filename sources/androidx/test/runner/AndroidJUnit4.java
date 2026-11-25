package androidx.test.runner;

import android.util.Log;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.InvocationTargetException;
import org.junit.runner.l;
import org.junit.runner.manipulation.b;
import org.junit.runner.manipulation.d;
import org.junit.runner.notification.c;
import org.junit.runners.model.e;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class AndroidJUnit4 extends l implements b, d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10433b = "AndroidJUnit4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f10434a;

    public AndroidJUnit4(Class<?> klass, AndroidRunnerParams runnerParams) throws e {
        this.f10434a = new AndroidJUnit4ClassRunner(klass, runnerParams);
    }

    private static l f(Class<?> testClass) throws e {
        return g(testClass, System.getProperty("android.junit.runner", "org.robolectric.RobolectricTestRunner"));
    }

    private static l g(Class<?> testClass, String className) throws e {
        try {
            return (l) Class.forName(className).getConstructor(Class.class).newInstance(testClass);
        } catch (ClassNotFoundException e8) {
            Log.e(f10433b, String.valueOf(className).concat(" could not be loaded"), e8);
            throw new e(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", className));
        } catch (IllegalAccessException e9) {
            Log.e(f10433b, String.valueOf(className).concat(" could not be loaded"), e9);
            throw new e(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", className));
        } catch (InstantiationException e10) {
            Log.e(f10433b, String.valueOf(className).concat(" could not be loaded"), e10);
            throw new e(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", className));
        } catch (NoSuchMethodException e11) {
            Log.e(f10433b, String.valueOf(className).concat(" could not be loaded"), e11);
            throw new e(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", className));
        } catch (InvocationTargetException e12) {
            Log.e(f10433b, String.valueOf(className).concat(" could not be loaded"), e12);
            throw new e(String.format("Attempted to use AndroidJUnit4 with standard JUnit runner and delegate runner '%s'could not be loaded. Check your build configuration.", className));
        }
    }

    @Override // org.junit.runner.l
    public void a(c runNotifier) {
        this.f10434a.a(runNotifier);
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        return this.f10434a.b();
    }

    @Override // org.junit.runner.manipulation.b
    public void d(org.junit.runner.manipulation.a filter) throws org.junit.runner.manipulation.c {
        ((b) this.f10434a).d(filter);
    }

    @Override // org.junit.runner.manipulation.d
    public void e(org.junit.runner.manipulation.e sorter) {
        ((d) this.f10434a).e(sorter);
    }

    public AndroidJUnit4(Class<?> klass) throws e {
        this.f10434a = f(klass);
    }
}
