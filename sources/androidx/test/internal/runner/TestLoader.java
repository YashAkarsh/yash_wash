package androidx.test.internal.runner;

import android.util.Log;
import androidx.test.internal.runner.junit3.AndroidJUnit3Builder;
import c.g1;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.runner.c;
import org.junit.runner.l;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes.dex */
class TestLoader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10056d = "TestLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f10057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f10058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, l> f10059c = new LinkedHashMap();

    private static class ScanningRunnerBuilder extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f10060b;

        ScanningRunnerBuilder(h runnerBuilder) {
            this.f10060b = runnerBuilder;
        }

        @Override // org.junit.runners.model.h
        public l c(Class<?> testClass) throws Throwable {
            if (!Modifier.isAbstract(testClass.getModifiers())) {
                return this.f10060b.c(testClass);
            }
            TestLoader.d(String.format("Skipping abstract class %s: not a test", testClass.getName()));
            return null;
        }
    }

    @g1
    static class UnloadableClassRunner extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f10061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final org.junit.runner.notification.a f10062b;

        UnloadableClassRunner(c description, org.junit.runner.notification.a failure) {
            this.f10061a = description;
            this.f10062b = failure;
        }

        @Override // org.junit.runner.l
        public void a(org.junit.runner.notification.c notifier) {
            notifier.l(this.f10061a);
            notifier.f(this.f10062b);
            notifier.h(this.f10061a);
        }

        @Override // org.junit.runner.l, org.junit.runner.b
        public c b() {
            return this.f10061a;
        }
    }

    private TestLoader(ClassLoader classLoader, h runnerBuilder) {
        this.f10057a = classLoader;
        this.f10058b = runnerBuilder;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006a  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    private void b(String className, boolean isScanningPath) {
        if (this.f10059c.containsKey(className)) {
            return;
        }
        l unloadableClassRunner = null;
        try {
            Class<?> cls = Class.forName(className, false, this.f10057a);
            l lVarG = this.f10058b.g(cls);
            if (lVarG != null) {
                if (lVarG == AndroidJUnit3Builder.f10113e) {
                    d(String.format("Skipping class %s: not a valid test", cls.getName()));
                }
                if (unloadableClassRunner != null) {
                    this.f10059c.put(className, unloadableClassRunner);
                }
            }
            d(String.format("Skipping class %s: not a test", cls.getName()));
            unloadableClassRunner = lVarG;
        } catch (ClassNotFoundException | LinkageError e8) {
            Log.e(f10056d, String.format("Could not find class: %s", className));
            c cVarE = c.e(className, new Annotation[0]);
            org.junit.runner.notification.a aVar = new org.junit.runner.notification.a(cVarE, e8);
            if (!isScanningPath) {
                unloadableClassRunner = new UnloadableClassRunner(cVarE, aVar);
            }
        }
        if (unloadableClassRunner != null) {
            this.f10059c.put(className, unloadableClassRunner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String msg) {
        if (Log.isLoggable(f10056d, 3)) {
            Log.d(f10056d, msg);
        }
    }

    static TestLoader e(ClassLoader classLoader, h runnerBuilder, boolean scanningPath) {
        if (scanningPath) {
            runnerBuilder = new ScanningRunnerBuilder(runnerBuilder);
        }
        if (classLoader == null) {
            classLoader = TestLoader.class.getClassLoader();
        }
        return new TestLoader(classLoader, runnerBuilder);
    }

    List<l> c(Collection<String> classNames, boolean isScanningPath) {
        Iterator<String> it = classNames.iterator();
        while (it.hasNext()) {
            b(it.next(), isScanningPath);
        }
        return new ArrayList(this.f10059c.values());
    }
}
