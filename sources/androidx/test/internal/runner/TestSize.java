package androidx.test.internal.runner;

import androidx.test.filters.LargeTest;
import androidx.test.filters.MediumTest;
import androidx.test.filters.SmallTest;
import c.g1;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.runner.c;

/* JADX INFO: loaded from: classes.dex */
public final class TestSize {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TestSize f10100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TestSize f10101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TestSize f10102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TestSize f10103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Set<TestSize> f10104i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends Annotation> f10106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<? extends Annotation> f10107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f10108d;

    static {
        TestSize testSize = new TestSize("small", SmallTest.class, "android.test.suitebuilder.annotation.SmallTest", 200.0f);
        f10100e = testSize;
        TestSize testSize2 = new TestSize("medium", MediumTest.class, "android.test.suitebuilder.annotation.MediumTest", 1000.0f);
        f10101f = testSize2;
        TestSize testSize3 = new TestSize("large", LargeTest.class, "android.test.suitebuilder.annotation.LargeTest", Float.MAX_VALUE);
        f10102g = testSize3;
        f10103h = new TestSize("", null, null, 0.0f);
        f10104i = Collections.unmodifiableSet(new HashSet(Arrays.asList(testSize, testSize2, testSize3)));
    }

    @g1
    public TestSize(String sizeQualifierName, Class<? extends Annotation> runnerFilterAnnotationClass, String legacyPlatformAnnotationClassName, float testSizeRuntimeThreshold) {
        this.f10105a = sizeQualifierName;
        this.f10106b = j(legacyPlatformAnnotationClassName);
        this.f10107c = runnerFilterAnnotationClass;
        this.f10108d = testSizeRuntimeThreshold;
    }

    public static TestSize a(c description) {
        TestSize testSize = f10103h;
        for (TestSize testSize2 : f10104i) {
            if (testSize2.m(description)) {
                testSize = testSize2;
                break;
            }
        }
        if (!f10103h.equals(testSize)) {
            return testSize;
        }
        for (TestSize testSize3 : f10104i) {
            if (testSize3.l(description)) {
                return testSize3;
            }
        }
        return testSize;
    }

    public static TestSize b(final String testSize) {
        TestSize testSize2 = f10103h;
        for (TestSize testSize3 : f10104i) {
            if (testSize3.f().equals(testSize)) {
                testSize2 = testSize3;
            }
        }
        return testSize2;
    }

    private Class<? extends Annotation> c() {
        return this.f10106b;
    }

    private Class<? extends Annotation> e() {
        return this.f10107c;
    }

    public static TestSize g(float testRuntime) {
        TestSize testSize = f10100e;
        if (k(testRuntime, testSize.d())) {
            return testSize;
        }
        TestSize testSize2 = f10101f;
        return k(testRuntime, testSize2.d()) ? testSize2 : f10102g;
    }

    private static boolean h(Class<?> testClass, Class<? extends Annotation> annotationClass) {
        return annotationClass != null && testClass.isAnnotationPresent(annotationClass);
    }

    public static boolean i(Class<? extends Annotation> annotationClass) {
        for (TestSize testSize : f10104i) {
            if (testSize.e() == annotationClass || testSize.c() == annotationClass) {
                return true;
            }
        }
        return false;
    }

    private static Class<? extends Annotation> j(String legacyPlatformAnnotationClassName) {
        if (legacyPlatformAnnotationClassName == null) {
            return null;
        }
        try {
            return Class.forName(legacyPlatformAnnotationClassName);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static boolean k(float testRuntime, float runtimeThreshold) {
        return Float.compare(testRuntime, runtimeThreshold) < 0;
    }

    public float d() {
        return this.f10108d;
    }

    public boolean equals(Object o7) {
        if (this == o7) {
            return true;
        }
        if (o7 == null || TestSize.class != o7.getClass()) {
            return false;
        }
        return this.f10105a.equals(((TestSize) o7).f10105a);
    }

    public String f() {
        return this.f10105a;
    }

    public int hashCode() {
        return this.f10105a.hashCode();
    }

    public boolean l(c description) {
        Class<?> clsQ = description.q();
        if (clsQ == null) {
            return false;
        }
        return h(clsQ, this.f10107c) || h(clsQ, this.f10106b);
    }

    public boolean m(c description) {
        return (description.k(this.f10107c) == null && description.k(this.f10106b) == null) ? false : true;
    }
}
