package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;
import androidx.test.filters.Suppress;
import androidx.test.internal.runner.filters.ParentFilter;
import androidx.test.internal.runner.filters.TestsRegExFilter;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.internal.util.Checks;
import c.g1;
import easypay.appinvoke.manager.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.junit.runner.c;
import org.junit.runner.i;
import org.junit.runner.l;
import org.junit.runners.g;
import org.junit.runners.model.e;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes.dex */
public class TestRequestBuilder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f10063q = "TestRequestBuilder";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String[] f10064r = {"junit", "org.junit", "org.hamcrest", "org.mockito", "androidx.test.internal.runner.junit3", "org.jacoco", "net.bytebuddy"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final String f10065s = "Must provide either classes to run, or paths to scan";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final String f10066t = "Ambiguous arguments: cannot provide both test package and test class(es) to run";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f10067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f10068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f10069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f10070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f10071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ClassAndMethodFilter f10072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TestsRegExFilter f10073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private org.junit.runner.manipulation.a f10074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Class<? extends h>> f10075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final DeviceBuild f10077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f10078l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Instrumentation f10079m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Bundle f10080n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ClassLoader f10081o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f10082p;

    private static class AnnotationExclusionFilter extends ParentFilter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<? extends Annotation> f10083b;

        AnnotationExclusionFilter(Class<? extends Annotation> annotation) {
            this.f10083b = annotation;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return String.format("not annotation %s", this.f10083b.getName());
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean f(c description) {
            Class<?> clsQ = description.q();
            return (clsQ == null || !clsQ.isAnnotationPresent(this.f10083b)) && description.k(this.f10083b) == null;
        }
    }

    private static class AnnotationInclusionFilter extends ParentFilter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<? extends Annotation> f10084b;

        AnnotationInclusionFilter(Class<? extends Annotation> annotation) {
            this.f10084b = annotation;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return String.format("annotation %s", this.f10084b.getName());
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean f(c description) {
            Class<?> clsQ = description.q();
            return description.k(this.f10084b) != null || (clsQ != null && clsQ.isAnnotationPresent(this.f10084b));
        }

        protected Class<? extends Annotation> g() {
            return this.f10084b;
        }
    }

    private static class BlankRunner extends l {
        private BlankRunner() {
        }

        @Override // org.junit.runner.l
        public void a(org.junit.runner.notification.c notifier) {
        }

        @Override // org.junit.runner.l, org.junit.runner.b
        public c b() {
            return c.e("no tests found", new Annotation[0]);
        }
    }

    private static class ClassAndMethodFilter extends ParentFilter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, MethodFilter> f10085b;

        private ClassAndMethodFilter() {
            this.f10085b = new HashMap();
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return "Class and method filter";
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        public boolean f(c description) {
            if (this.f10085b.isEmpty()) {
                return true;
            }
            MethodFilter methodFilter = this.f10085b.get(description.n());
            if (methodFilter != null) {
                return methodFilter.e(description);
            }
            return true;
        }

        public void g(String className, String methodName) {
            MethodFilter methodFilter = this.f10085b.get(className);
            if (methodFilter == null) {
                methodFilter = new MethodFilter(className);
                this.f10085b.put(className, methodFilter);
            }
            methodFilter.h(methodName);
        }

        public void h(String className, String methodName) {
            MethodFilter methodFilter = this.f10085b.get(className);
            if (methodFilter == null) {
                methodFilter = new MethodFilter(className);
                this.f10085b.put(className, methodFilter);
            }
            methodFilter.g(methodName);
        }
    }

    interface DeviceBuild {
        int a();

        String b();

        String c();
    }

    private static class DeviceBuildImpl implements DeviceBuild {
        private DeviceBuildImpl() {
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.DeviceBuild
        public int a() {
            return Build.VERSION.SDK_INT;
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.DeviceBuild
        public String b() {
            return Build.VERSION.CODENAME;
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.DeviceBuild
        public String c() {
            return Build.HARDWARE;
        }
    }

    private static class ExtendedSuite extends g {
        ExtendedSuite(List<l> runners) throws e {
            super((Class<?>) null, runners);
        }

        static g K(List<l> runners) {
            try {
                return new ExtendedSuite(runners);
            } catch (e unused) {
                String name = g.class.getName();
                StringBuilder sb = new StringBuilder(name.length() + Constants.OTP_FILLER_WEB_SUCCESS);
                sb.append("Internal Error: ");
                sb.append(name);
                sb.append("(Class<?>, List<Runner>) should never throw an InitializationError when passed a null Class");
                throw new RuntimeException(sb.toString());
            }
        }
    }

    private static class LenientFilterRequest extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i f10086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final org.junit.runner.manipulation.a f10087b;

        public LenientFilterRequest(i classRequest, org.junit.runner.manipulation.a filter) {
            this.f10086a = classRequest;
            this.f10087b = filter;
        }

        @Override // org.junit.runner.i
        public l h() {
            try {
                l lVarH = this.f10086a.h();
                this.f10087b.a(lVarH);
                return lVarH;
            } catch (org.junit.runner.manipulation.c unused) {
                return new BlankRunner();
            }
        }
    }

    private static class MethodFilter extends ParentFilter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set<String> f10089c = new HashSet();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Set<String> f10090d = new HashSet();

        public MethodFilter(String className) {
            this.f10088b = className;
        }

        private String i(String name) {
            return Pattern.compile(".+(\\[[0-9]+\\])$").matcher(name).matches() ? name.substring(0, name.lastIndexOf(91)) : name;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            String str = this.f10088b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24);
            sb.append("Method filter for ");
            sb.append(str);
            sb.append(" class");
            return sb.toString();
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        public boolean f(c description) {
            String strP = description.p();
            if (strP == null) {
                return false;
            }
            String strI = i(strP);
            if (this.f10090d.contains(strP) || this.f10090d.contains(strI)) {
                return false;
            }
            return this.f10089c.isEmpty() || this.f10089c.contains(strP) || this.f10089c.contains(strI) || strP.equals("initializationError");
        }

        public void g(String methodName) {
            this.f10090d.add(methodName);
        }

        public void h(String methodName) {
            this.f10089c.add(methodName);
        }
    }

    @g1
    class RequiresDeviceFilter extends AnnotationExclusionFilter {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final String f10091e = "goldfish";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final String f10092f = "ranchu";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final String f10093g = "gce_x86";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<String> f10094c;

        RequiresDeviceFilter() {
            super(RequiresDevice.class);
            this.f10094c = new HashSet(Arrays.asList(f10091e, f10092f, f10093g));
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.AnnotationExclusionFilter, org.junit.runner.manipulation.a
        public String b() {
            return String.format("skip tests annotated with RequiresDevice if necessary", new Object[0]);
        }

        @Override // androidx.test.internal.runner.TestRequestBuilder.AnnotationExclusionFilter, androidx.test.internal.runner.filters.ParentFilter
        protected boolean f(c description) {
            if (super.f(description)) {
                return true;
            }
            return !this.f10094c.contains(TestRequestBuilder.this.t());
        }
    }

    private class SdkSuppressFilter extends ParentFilter {
        private SdkSuppressFilter() {
        }

        private SdkSuppress g(c description) {
            SdkSuppress sdkSuppress = (SdkSuppress) description.k(SdkSuppress.class);
            if (sdkSuppress != null) {
                return sdkSuppress;
            }
            Class<?> clsQ = description.q();
            if (clsQ != null) {
                return (SdkSuppress) clsQ.getAnnotation(SdkSuppress.class);
            }
            return null;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return String.format("skip tests annotated with SdkSuppress if necessary", new Object[0]);
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean f(c description) {
            SdkSuppress sdkSuppressG = g(description);
            if (sdkSuppressG != null) {
                return (TestRequestBuilder.this.u() >= sdkSuppressG.minSdkVersion() && TestRequestBuilder.this.u() <= sdkSuppressG.maxSdkVersion()) || TestRequestBuilder.this.s().equals(sdkSuppressG.codeName());
            }
            return true;
        }
    }

    private static class ShardingFilter extends org.junit.runner.manipulation.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f10098c;

        ShardingFilter(int numShards, int shardIndex) {
            this.f10097b = numShards;
            this.f10098c = shardIndex;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return String.format("Shard %s of %s shards", Integer.valueOf(this.f10098c), Integer.valueOf(this.f10097b));
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(c description) {
            return !description.u() || Math.abs(description.hashCode()) % this.f10097b == this.f10098c;
        }
    }

    private static class SizeFilter extends ParentFilter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TestSize f10099b;

        SizeFilter(TestSize testSize) {
            this.f10099b = testSize;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return "";
        }

        @Override // androidx.test.internal.runner.filters.ParentFilter
        protected boolean f(c description) {
            if (this.f10099b.m(description)) {
                return true;
            }
            if (!this.f10099b.l(description)) {
                return false;
            }
            Iterator<Annotation> it = description.l().iterator();
            while (it.hasNext()) {
                if (TestSize.i(it.next().annotationType())) {
                    return false;
                }
            }
            return true;
        }
    }

    public TestRequestBuilder(Instrumentation instr, Bundle bundle) {
        this(new DeviceBuildImpl(), instr, bundle);
    }

    private void G(Set<String> classNames) {
        if (classNames.isEmpty() && this.f10067a.isEmpty()) {
            throw new IllegalArgumentException(f10065s);
        }
    }

    private Collection<String> r() {
        if (this.f10067a.isEmpty()) {
            throw new IllegalStateException("neither test class to execute or class paths were provided");
        }
        Log.i(f10063q, String.format("Scanning classpath to find tests in paths %s", this.f10067a));
        ClassPathScanner classPathScannerQ = q(this.f10067a);
        ClassPathScanner.ChainedClassNameFilter chainedClassNameFilter = new ClassPathScanner.ChainedClassNameFilter();
        chainedClassNameFilter.b(new ClassPathScanner.ExternalClassNameFilter());
        for (String str : f10064r) {
            if (!this.f10068b.contains(str)) {
                this.f10069c.add(str);
            }
        }
        if (!this.f10068b.isEmpty()) {
            chainedClassNameFilter.b(new ClassPathScanner.InclusivePackageNamesFilter(this.f10068b));
        }
        Iterator<String> it = this.f10069c.iterator();
        while (it.hasNext()) {
            chainedClassNameFilter.b(new ClassPathScanner.ExcludePackageNameFilter(it.next()));
        }
        chainedClassNameFilter.b(new ClassPathScanner.ExcludeClassNamesFilter(this.f10071e));
        try {
            return classPathScannerQ.b(chainedClassNameFilter);
        } catch (IOException e8) {
            Log.e(f10063q, "Failed to scan classes", e8);
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s() {
        return this.f10077k.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t() {
        return this.f10077k.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        return this.f10077k.a();
    }

    private h v(AndroidRunnerParams runnerParams, boolean scanningPath) {
        return this.f10076j ? new AndroidLogOnlyBuilder(runnerParams, scanningPath, this.f10075i) : new AndroidRunnerBuilder(runnerParams, scanningPath, this.f10075i);
    }

    private Class<? extends Annotation> x(String className) {
        try {
            return Class.forName(className);
        } catch (ClassCastException unused) {
            Log.e(f10063q, String.format("Class %s is not an annotation", className));
            return null;
        } catch (ClassNotFoundException unused2) {
            Log.e(f10063q, String.format("Could not find annotation class: %s", className));
            return null;
        }
    }

    private void y() {
        try {
            this.f10074h = this.f10074h.c(new AnnotationExclusionFilter(Class.forName("android.test.suitebuilder.annotation.Suppress")));
        } catch (ClassNotFoundException unused) {
        }
    }

    public TestRequestBuilder A(String testClassName, String testMethodName) {
        this.f10072f.h(testClassName, testMethodName);
        return this;
    }

    public TestRequestBuilder B(String testPackage) {
        this.f10069c.add(testPackage);
        return this;
    }

    public TestRequestBuilder C(ClassLoader loader) {
        this.f10081o = loader;
        return this;
    }

    public TestRequestBuilder D(long millis) {
        this.f10078l = millis;
        return this;
    }

    public TestRequestBuilder E(boolean b8) {
        this.f10076j = b8;
        return this;
    }

    public TestRequestBuilder F(String testsRegex) {
        this.f10073g.g(testsRegex);
        return this;
    }

    public TestRequestBuilder d(String notAnnotation) {
        Class<? extends Annotation> clsX = x(notAnnotation);
        if (clsX != null) {
            g(new AnnotationExclusionFilter(clsX));
        }
        return this;
    }

    public TestRequestBuilder e(String annotation) {
        Class<? extends Annotation> clsX = x(annotation);
        if (clsX != null) {
            g(new AnnotationInclusionFilter(clsX));
        }
        return this;
    }

    public TestRequestBuilder f(Class<? extends h> runnerBuilderClass) {
        this.f10075i.add(runnerBuilderClass);
        return this;
    }

    public TestRequestBuilder g(org.junit.runner.manipulation.a filter) {
        this.f10074h = this.f10074h.c(filter);
        return this;
    }

    public TestRequestBuilder h(RunnerArgs runnerArgs) {
        int i7;
        for (RunnerArgs.TestArg testArg : runnerArgs.f10010p) {
            String str = testArg.f10048b;
            if (str == null) {
                l(testArg.f10047a);
            } else {
                m(testArg.f10047a, str);
            }
        }
        for (RunnerArgs.TestArg testArg2 : runnerArgs.f10011q) {
            String str2 = testArg2.f10048b;
            if (str2 == null) {
                z(testArg2.f10047a);
            } else {
                A(testArg2.f10047a, str2);
            }
        }
        Iterator<String> it = runnerArgs.f10001g.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
        Iterator<String> it2 = runnerArgs.f10002h.iterator();
        while (it2.hasNext()) {
            B(it2.next());
        }
        String str3 = runnerArgs.f10003i;
        if (str3 != null) {
            o(TestSize.b(str3));
        }
        Iterator<String> it3 = runnerArgs.f10004j.iterator();
        while (it3.hasNext()) {
            e(it3.next());
        }
        Iterator<String> it4 = runnerArgs.f10005k.iterator();
        while (it4.hasNext()) {
            d(it4.next());
        }
        Iterator<org.junit.runner.manipulation.a> it5 = runnerArgs.f10008n.iterator();
        while (it5.hasNext()) {
            g(it5.next());
        }
        long j7 = runnerArgs.f10006l;
        if (j7 > 0) {
            D(j7);
        }
        int i8 = runnerArgs.f10012r;
        if (i8 > 0 && (i7 = runnerArgs.f10013s) >= 0 && i7 < i8) {
            k(i8, i7);
        }
        if (runnerArgs.f10000f) {
            E(true);
        }
        ClassLoader classLoader = runnerArgs.f10016v;
        if (classLoader != null) {
            C(classLoader);
        }
        Iterator<Class<? extends h>> it6 = runnerArgs.f10009o.iterator();
        while (it6.hasNext()) {
            f(it6.next());
        }
        String str4 = runnerArgs.E;
        if (str4 != null) {
            F(str4);
        }
        return this;
    }

    public TestRequestBuilder i(String path) {
        this.f10067a.add(path);
        return this;
    }

    public TestRequestBuilder j(Iterable<String> paths) {
        Iterator<String> it = paths.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
        return this;
    }

    public TestRequestBuilder k(int numShards, int shardIndex) {
        return g(new ShardingFilter(numShards, shardIndex));
    }

    public TestRequestBuilder l(String className) {
        this.f10070d.add(className);
        return this;
    }

    public TestRequestBuilder m(String testClassName, String testMethodName) {
        this.f10070d.add(testClassName);
        this.f10072f.g(testClassName, testMethodName);
        return this;
    }

    public TestRequestBuilder n(String testPackage) {
        this.f10068b.add(testPackage);
        return this;
    }

    public TestRequestBuilder o(TestSize forTestSize) {
        if (TestSize.f10103h.equals(forTestSize)) {
            Log.e(f10063q, String.format("Unrecognized test size '%s'", forTestSize.f()));
        } else {
            g(new SizeFilter(forTestSize));
        }
        return this;
    }

    public i p() {
        this.f10068b.removeAll(this.f10069c);
        this.f10070d.removeAll(this.f10071e);
        G(this.f10070d);
        boolean zIsEmpty = this.f10070d.isEmpty();
        return new LenientFilterRequest(i.j(ExtendedSuite.K(TestLoader.e(this.f10081o, v(new AndroidRunnerParams(this.f10079m, this.f10080n, this.f10078l, this.f10082p || zIsEmpty), zIsEmpty), zIsEmpty).c(zIsEmpty ? r() : this.f10070d, zIsEmpty))), this.f10074h);
    }

    ClassPathScanner q(List<String> classPath) {
        return new ClassPathScanner(classPath);
    }

    public TestRequestBuilder w(boolean ignoreSuiteMethods) {
        this.f10082p = ignoreSuiteMethods;
        return this;
    }

    public TestRequestBuilder z(String className) {
        this.f10071e.add(className);
        return this;
    }

    @g1
    TestRequestBuilder(DeviceBuild deviceBuildAccessor, Instrumentation instr, Bundle bundle) {
        this.f10067a = new ArrayList();
        this.f10068b = new HashSet();
        this.f10069c = new HashSet();
        this.f10070d = new HashSet();
        this.f10071e = new HashSet();
        this.f10072f = new ClassAndMethodFilter();
        TestsRegExFilter testsRegExFilter = new TestsRegExFilter();
        this.f10073g = testsRegExFilter;
        this.f10074h = new AnnotationExclusionFilter(Suppress.class).c(new SdkSuppressFilter()).c(new RequiresDeviceFilter()).c(this.f10072f).c(testsRegExFilter);
        this.f10075i = new ArrayList();
        this.f10076j = false;
        this.f10078l = 0L;
        this.f10082p = false;
        this.f10077k = (DeviceBuild) Checks.f(deviceBuildAccessor);
        this.f10079m = (Instrumentation) Checks.f(instr);
        this.f10080n = (Bundle) Checks.f(bundle);
        y();
    }
}
