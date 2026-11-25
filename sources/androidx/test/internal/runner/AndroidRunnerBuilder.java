package androidx.test.internal.runner;

import androidx.test.internal.runner.junit3.AndroidJUnit3Builder;
import androidx.test.internal.runner.junit3.AndroidSuiteBuilder;
import androidx.test.internal.runner.junit4.AndroidAnnotatedBuilder;
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.builders.b;
import org.junit.internal.builders.c;
import org.junit.internal.builders.e;
import org.junit.internal.builders.f;
import org.junit.runner.l;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes.dex */
class AndroidRunnerBuilder extends org.junit.internal.builders.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AndroidJUnit3Builder f9927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AndroidJUnit4Builder f9928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AndroidSuiteBuilder f9929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AndroidAnnotatedBuilder f9930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f9931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<h> f9932h;

    public AndroidRunnerBuilder(AndroidRunnerParams runnerParams) {
        this(null, runnerParams, false, Collections.emptyList());
    }

    private List<h> m(List<Class<? extends h>> customRunnerBuilderClasses) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends h> cls : customRunnerBuilderClasses) {
            try {
                arrayList.add(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (IllegalAccessException e8) {
                String strValueOf = String.valueOf(cls);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 113);
                sb.append("Could not create instance of ");
                sb.append(strValueOf);
                sb.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb.toString(), e8);
            } catch (InstantiationException e9) {
                String strValueOf2 = String.valueOf(cls);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 113);
                sb2.append("Could not create instance of ");
                sb2.append(strValueOf2);
                sb2.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb2.toString(), e9);
            } catch (NoSuchMethodException e10) {
                String strValueOf3 = String.valueOf(cls);
                StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 113);
                sb3.append("Could not create instance of ");
                sb3.append(strValueOf3);
                sb3.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb3.toString(), e10);
            } catch (InvocationTargetException e11) {
                String strValueOf4 = String.valueOf(cls);
                StringBuilder sb4 = new StringBuilder(strValueOf4.length() + 74);
                sb4.append("Could not create instance of ");
                sb4.append(strValueOf4);
                sb4.append(", the constructor must not throw an exception");
                throw new IllegalStateException(sb4.toString(), e11);
            }
        }
        return arrayList;
    }

    @Override // org.junit.internal.builders.a, org.junit.runners.model.h
    public l c(Class<?> testClass) throws Throwable {
        Iterator<h> it = this.f9932h.iterator();
        while (it.hasNext()) {
            l lVarG = it.next().g(testClass);
            if (lVarG != null) {
                return lVarG;
            }
        }
        return super.c(testClass);
    }

    @Override // org.junit.internal.builders.a
    protected b h() {
        return this.f9930f;
    }

    @Override // org.junit.internal.builders.a
    protected c i() {
        return this.f9931g;
    }

    @Override // org.junit.internal.builders.a
    protected e j() {
        return this.f9927c;
    }

    @Override // org.junit.internal.builders.a
    protected f k() {
        return this.f9928d;
    }

    @Override // org.junit.internal.builders.a
    protected h l() {
        return this.f9929e;
    }

    AndroidRunnerBuilder(AndroidRunnerParams runnerParams, boolean scanningPath, List<Class<? extends h>> customRunnerBuilderClasses) {
        this(null, runnerParams, scanningPath, customRunnerBuilderClasses);
    }

    AndroidRunnerBuilder(h suiteBuilder, AndroidRunnerParams runnerParams, boolean scanningPath, List<Class<? extends h>> customRunnerBuilderClasses) {
        super(true);
        this.f9927c = new AndroidJUnit3Builder(runnerParams, scanningPath);
        this.f9928d = new AndroidJUnit4Builder(runnerParams, scanningPath);
        this.f9929e = new AndroidSuiteBuilder(runnerParams);
        this.f9930f = new AndroidAnnotatedBuilder(suiteBuilder == null ? this : suiteBuilder, runnerParams);
        this.f9931g = new c();
        this.f9932h = m(customRunnerBuilderClasses);
    }
}
