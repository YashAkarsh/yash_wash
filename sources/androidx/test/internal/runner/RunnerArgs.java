package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.app.UiAutomation;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.screenshot.ScreenCaptureProcessor;
import c.g1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.notification.b;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes.dex */
public class RunnerArgs {
    private static final String F = "RunnerArgs";
    static final String G = "class";
    static final String H = "classpathToScan";
    static final String I = "notClass";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final String f9978J = "size";
    static final String K = "log";
    static final String L = "annotation";
    static final String M = "notAnnotation";
    static final String N = "numShards";
    static final String O = "shardIndex";
    static final String P = "delay_msec";
    static final String Q = "coverage";
    static final String R = "coverageFile";
    static final String S = "suiteAssignment";
    static final String T = "debug";
    static final String U = "listener";
    static final String V = "filter";
    static final String W = "runnerBuilder";
    static final String X = "package";
    static final String Y = "notPackage";
    static final String Z = "timeout_msec";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    static final String f9979a0 = "testFile";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    static final String f9980b0 = "notTestFile";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    static final String f9981c0 = "disableAnalytics";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    static final String f9982d0 = "appListener";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    static final String f9983e0 = "classLoader";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    static final String f9984f0 = "remoteMethod";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    static final String f9985g0 = "targetProcess";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    static final String f9986h0 = "screenCaptureProcessors";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    static final String f9987i0 = "orchestratorService";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    static final String f9988j0 = "listTestsForOrchestrator";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    static final String f9989k0 = "shellExecBinderKey";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    static final String f9990l0 = "newRunListenerMode";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    static final String f9991m0 = "tests_regex";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final String f9992n0 = ",";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private static final String f9993o0 = ":";

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private static final char f9994p0 = '#';
    public final String A;
    public final boolean B;
    public final String C;
    public final boolean D;
    public final String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f10001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f10002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f10003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f10004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f10005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f10006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<b> f10007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<org.junit.runner.manipulation.a> f10008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Class<? extends h>> f10009o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<TestArg> f10010p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<TestArg> f10011q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f10012r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f10013s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f10014t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<ApplicationLifecycleCallback> f10015u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ClassLoader f10016v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Set<String> f10017w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TestArg f10018x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f10019y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<ScreenCaptureProcessor> f10020z;

    public static class Builder {
        public String C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10021a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f10022b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f10023c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f10024d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f10025e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f10026f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<String> f10027g = new ArrayList();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<String> f10028h = new ArrayList();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f10029i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final List<String> f10030j = new ArrayList();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final List<String> f10031k = new ArrayList();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f10032l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List<b> f10033m = new ArrayList();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private List<org.junit.runner.manipulation.a> f10034n = new ArrayList();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private List<Class<? extends h>> f10035o = new ArrayList();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private List<TestArg> f10036p = new ArrayList();

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private List<TestArg> f10037q = new ArrayList();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f10038r = 0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f10039s = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f10040t = false;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private List<ApplicationLifecycleCallback> f10041u = new ArrayList();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private ClassLoader f10042v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private Set<String> f10043w = new HashSet();

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private TestArg f10044x = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private String f10045y = null;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f10046z = false;
        private String A = null;
        private List<ScreenCaptureProcessor> B = new ArrayList();
        private boolean D = false;
        private String E = null;

        @g1
        static boolean H(String line) {
            for (int i7 = 0; i7 < line.length(); i7++) {
                char cCharAt = line.charAt(i7);
                if (cCharAt == '#' || Character.isUpperCase(cCharAt)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T> void I(List<Class<? extends T>> classes, String className, Class<T> type) {
            if (className == null || className.length() == 0) {
                return;
            }
            try {
                Class<?> cls = Class.forName(className);
                if (type.isAssignableFrom(cls)) {
                    classes.add(cls);
                    return;
                }
                String name = type.getName();
                StringBuilder sb = new StringBuilder(className.length() + 17 + name.length());
                sb.append(className);
                sb.append(" does not extend ");
                sb.append(name);
                throw new IllegalArgumentException(sb.toString());
            } catch (ClassCastException unused) {
                String name2 = type.getName();
                StringBuilder sb2 = new StringBuilder(className.length() + 17 + name2.length());
                sb2.append(className);
                sb2.append(" does not extend ");
                sb2.append(name2);
                throw new IllegalArgumentException(sb2.toString());
            } catch (ClassNotFoundException unused2) {
                throw new IllegalArgumentException(className.length() != 0 ? "Could not find extra class ".concat(className) : new String("Could not find extra class "));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T> void J(List<T> objects, String className, Class<T> type, Bundle bundle) throws NoSuchMethodException {
            Constructor<?> constructor;
            Object[] objArr;
            if (className == null || className.length() == 0) {
                return;
            }
            try {
                try {
                    Class<?> cls = Class.forName(className);
                    try {
                        constructor = cls.getConstructor(new Class[0]);
                        objArr = new Object[0];
                    } catch (NoSuchMethodException e8) {
                        if (bundle == null) {
                            throw e8;
                        }
                        try {
                            Object[] objArr2 = {bundle};
                            constructor = cls.getConstructor(Bundle.class);
                            objArr = objArr2;
                        } catch (NoSuchMethodException e9) {
                            e9.initCause(e8);
                            throw e9;
                        }
                    }
                    constructor.setAccessible(true);
                    objects.add(constructor.newInstance(objArr));
                } catch (NoSuchMethodException unused) {
                    throw new IllegalArgumentException(className.length() != 0 ? "Must have no argument constructor for class ".concat(className) : new String("Must have no argument constructor for class "));
                }
            } catch (ClassCastException unused2) {
                String name = type.getName();
                StringBuilder sb = new StringBuilder(className.length() + 17 + name.length());
                sb.append(className);
                sb.append(" does not extend ");
                sb.append(name);
                throw new IllegalArgumentException(sb.toString());
            } catch (ClassNotFoundException unused3) {
                throw new IllegalArgumentException(className.length() != 0 ? "Could not find extra class ".concat(className) : new String("Could not find extra class "));
            } catch (IllegalAccessException e10) {
                throw new IllegalArgumentException(className.length() != 0 ? "Failed to create listener: ".concat(className) : new String("Failed to create listener: "), e10);
            } catch (InstantiationException e11) {
                throw new IllegalArgumentException(className.length() != 0 ? "Failed to create: ".concat(className) : new String("Failed to create: "), e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalArgumentException(className.length() != 0 ? "Failed to create: ".concat(className) : new String("Failed to create: "), e12);
            }
        }

        private BufferedReader K(Instrumentation instr, String filePath) throws IOException {
            Reader fileReader;
            if (Build.VERSION.SDK_INT >= 26 && instr.getContext().getPackageManager().isInstantApp()) {
                UiAutomation uiAutomation = instr.getUiAutomation();
                String strValueOf = String.valueOf(filePath);
                fileReader = new InputStreamReader(new ParcelFileDescriptor.AutoCloseInputStream(uiAutomation.executeShellCommand(strValueOf.length() != 0 ? "cat ".concat(strValueOf) : new String("cat "))));
            } else {
                fileReader = new FileReader(new File(filePath));
            }
            return new BufferedReader(fileReader);
        }

        private <T> List<Class<? extends T>> L(String classString, Class<T> type) {
            ArrayList arrayList = new ArrayList();
            if (classString != null) {
                for (String str : classString.split(RunnerArgs.f9992n0)) {
                    I(arrayList, str, type);
                }
            }
            return arrayList;
        }

        private static boolean M(String booleanValue) {
            return booleanValue != null && Boolean.parseBoolean(booleanValue);
        }

        private static Set<String> N(String classpath) {
            return (classpath == null || classpath.isEmpty()) ? new HashSet() : new HashSet(Arrays.asList(classpath.split(RunnerArgs.f9993o0, -1)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.test.internal.runner.RunnerArgs$1] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
        /* JADX WARN: Type inference failed for: r1v3 */
        private TestFileArgs O(Instrumentation instrumentation, String str) {
            ?? K = 0;
            K = 0;
            TestFileArgs testFileArgs = new TestFileArgs();
            try {
                if (str == null) {
                    return testFileArgs;
                }
                try {
                    K = K(instrumentation, str);
                    while (true) {
                        String line = K.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        } else if (H(line)) {
                            testFileArgs.f10049a.add(S(line));
                        } else {
                            testFileArgs.f10050b.addAll(U(line));
                        }
                    }
                    K.close();
                    return testFileArgs;
                } catch (FileNotFoundException e8) {
                    throw new IllegalArgumentException(str.length() != 0 ? "testfile not found: ".concat(str) : new String("testfile not found: "), e8);
                } catch (IOException e9) {
                    throw new IllegalArgumentException(str.length() != 0 ? "Could not read test file ".concat(str) : new String("Could not read test file "), e9);
                }
            } catch (Throwable th) {
                if (K != 0) {
                    try {
                        K.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }

        private <T> T P(String classString, Class<T> type) throws NoSuchMethodException {
            List<T> listQ = Q(classString, type, null);
            if (listQ.isEmpty()) {
                return null;
            }
            if (listQ.size() <= 1) {
                return listQ.get(0);
            }
            throw new IllegalArgumentException(String.format("Expected 1 class loader, %d given", Integer.valueOf(listQ.size())));
        }

        private <T> List<T> Q(String classString, Class<T> type, Bundle bundle) throws NoSuchMethodException {
            ArrayList arrayList = new ArrayList();
            if (classString != null) {
                for (String str : classString.split(RunnerArgs.f9992n0)) {
                    J(arrayList, str, type, bundle);
                }
            }
            return arrayList;
        }

        private static List<String> R(String value) {
            return value == null ? Collections.emptyList() : Arrays.asList(value.split(RunnerArgs.f9992n0));
        }

        private static TestArg S(String testClassName) {
            if (TextUtils.isEmpty(testClassName)) {
                return null;
            }
            int iIndexOf = testClassName.indexOf(35);
            if (iIndexOf <= 0) {
                return new TestArg(testClassName);
            }
            return new TestArg(testClassName.substring(0, iIndexOf), testClassName.substring(iIndexOf + 1));
        }

        private List<TestArg> T(String classesArg) {
            ArrayList arrayList = new ArrayList();
            if (classesArg != null) {
                for (String str : classesArg.split(RunnerArgs.f9992n0)) {
                    arrayList.add(S(str));
                }
            }
            return arrayList;
        }

        private static List<String> U(String packagesArg) {
            ArrayList arrayList = new ArrayList();
            if (packagesArg != null) {
                for (String str : packagesArg.split(RunnerArgs.f9992n0)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }

        private static int V(Object value, String name) {
            if (value == null) {
                return -1;
            }
            int i7 = Integer.parseInt(value.toString());
            if (i7 >= 0) {
                return i7;
            }
            throw new NumberFormatException(String.valueOf(name).concat(" can not be negative"));
        }

        private static long W(Object value, String name) {
            if (value == null) {
                return -1L;
            }
            long j7 = Long.parseLong(value.toString());
            if (j7 >= 0) {
                return j7;
            }
            throw new NumberFormatException(String.valueOf(name).concat(" can not be negative"));
        }

        public RunnerArgs E() {
            return new RunnerArgs(this);
        }

        public Builder F(Instrumentation instr, Bundle bundle) {
            this.f10021a = M(bundle.getString(RunnerArgs.T));
            this.f10025e = V(bundle.get(RunnerArgs.P), RunnerArgs.P);
            this.f10036p.addAll(T(bundle.getString("class")));
            this.f10037q.addAll(T(bundle.getString(RunnerArgs.I)));
            this.f10027g.addAll(U(bundle.getString(RunnerArgs.X)));
            this.f10028h.addAll(U(bundle.getString(RunnerArgs.Y)));
            TestFileArgs testFileArgsO = O(instr, bundle.getString(RunnerArgs.f9979a0));
            this.f10036p.addAll(testFileArgsO.f10049a);
            this.f10027g.addAll(testFileArgsO.f10050b);
            TestFileArgs testFileArgsO2 = O(instr, bundle.getString(RunnerArgs.f9980b0));
            this.f10037q.addAll(testFileArgsO2.f10049a);
            this.f10028h.addAll(testFileArgsO2.f10050b);
            this.f10033m.addAll(Q(bundle.getString("listener"), b.class, null));
            this.f10034n.addAll(Q(bundle.getString(RunnerArgs.V), org.junit.runner.manipulation.a.class, bundle));
            this.f10035o.addAll(L(bundle.getString(RunnerArgs.W), h.class));
            this.f10029i = bundle.getString(RunnerArgs.f9978J);
            this.f10030j.addAll(R(bundle.getString(RunnerArgs.L)));
            this.f10031k.addAll(R(bundle.getString(RunnerArgs.M)));
            this.f10032l = W(bundle.getString(RunnerArgs.Z), RunnerArgs.Z);
            this.f10038r = V(bundle.get(RunnerArgs.N), RunnerArgs.N);
            this.f10039s = V(bundle.get(RunnerArgs.O), RunnerArgs.O);
            this.f10026f = M(bundle.getString(RunnerArgs.K));
            this.f10040t = M(bundle.getString(RunnerArgs.f9981c0));
            this.f10041u.addAll(Q(bundle.getString(RunnerArgs.f9982d0), ApplicationLifecycleCallback.class, null));
            this.f10023c = M(bundle.getString(RunnerArgs.Q));
            this.f10024d = bundle.getString(RunnerArgs.R);
            this.f10022b = M(bundle.getString(RunnerArgs.S));
            this.f10042v = (ClassLoader) P(bundle.getString(RunnerArgs.f9983e0), ClassLoader.class);
            this.f10043w = N(bundle.getString(RunnerArgs.H));
            if (bundle.containsKey(RunnerArgs.f9984f0)) {
                this.f10044x = S(bundle.getString(RunnerArgs.f9984f0));
            }
            this.f10045y = bundle.getString(RunnerArgs.f9987i0);
            this.f10046z = M(bundle.getString(RunnerArgs.f9988j0));
            this.A = bundle.getString(RunnerArgs.f9985g0);
            this.B.addAll(Q(bundle.getString(RunnerArgs.f9986h0), ScreenCaptureProcessor.class, null));
            this.C = bundle.getString(RunnerArgs.f9989k0);
            this.D = M(bundle.getString(RunnerArgs.f9990l0));
            this.E = bundle.getString(RunnerArgs.f9991m0);
            return this;
        }

        public Builder G(Instrumentation instr) {
            try {
                Bundle bundle = instr.getContext().getPackageManager().getInstrumentationInfo(instr.getComponentName(), 128).metaData;
                return bundle == null ? this : F(instr, bundle);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.wtf(RunnerArgs.F, String.format("Could not find component %s", instr.getComponentName()));
                return this;
            }
        }
    }

    private static final class TestFileArgs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<TestArg> f10049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f10050b;

        private TestFileArgs() {
            this.f10049a = new ArrayList();
            this.f10050b = new ArrayList();
        }
    }

    private RunnerArgs(Builder builder) {
        this.f9995a = builder.f10021a;
        this.f9996b = builder.f10022b;
        this.f9997c = builder.f10023c;
        this.f9998d = builder.f10024d;
        this.f9999e = builder.f10025e;
        this.f10000f = builder.f10026f;
        this.f10001g = builder.f10027g;
        this.f10002h = builder.f10028h;
        this.f10003i = builder.f10029i;
        this.f10004j = Collections.unmodifiableList(builder.f10030j);
        this.f10005k = Collections.unmodifiableList(builder.f10031k);
        this.f10006l = builder.f10032l;
        this.f10007m = Collections.unmodifiableList(builder.f10033m);
        this.f10008n = Collections.unmodifiableList(builder.f10034n);
        this.f10009o = Collections.unmodifiableList(builder.f10035o);
        this.f10010p = Collections.unmodifiableList(builder.f10036p);
        this.f10011q = Collections.unmodifiableList(builder.f10037q);
        this.f10012r = builder.f10038r;
        this.f10013s = builder.f10039s;
        this.f10014t = builder.f10040t;
        this.f10015u = Collections.unmodifiableList(builder.f10041u);
        this.f10016v = builder.f10042v;
        this.f10017w = builder.f10043w;
        this.f10018x = builder.f10044x;
        this.A = builder.f10045y;
        this.B = builder.f10046z;
        this.f10020z = Collections.unmodifiableList(builder.B);
        this.f10019y = builder.A;
        this.C = builder.C;
        this.D = builder.D;
        this.E = builder.E;
    }

    public static class TestArg {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10048b;

        TestArg(String className, String methodName) {
            this.f10047a = className;
            this.f10048b = methodName;
        }

        public String toString() {
            String str = this.f10048b;
            if (str == null) {
                return this.f10047a;
            }
            String str2 = this.f10047a;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
            sb.append(str2);
            sb.append(RunnerArgs.f9994p0);
            sb.append(str);
            return sb.toString();
        }

        TestArg(String className) {
            this(className, null);
        }
    }
}
