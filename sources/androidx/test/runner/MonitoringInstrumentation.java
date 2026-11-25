package androidx.test.runner;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.UserHandle;
import android.util.Log;
import androidx.test.internal.platform.app.ActivityLifecycleTimeout;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.internal.runner.hidden.ExposedInstrumentationApi;
import androidx.test.internal.runner.intent.IntentMonitorImpl;
import androidx.test.internal.runner.intercepting.DefaultInterceptingActivityFactory;
import androidx.test.internal.runner.lifecycle.ActivityLifecycleMonitorImpl;
import androidx.test.internal.runner.lifecycle.ApplicationLifecycleMonitorImpl;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.ProcSummary;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.intent.IntentMonitorRegistry;
import androidx.test.runner.intent.IntentStubberRegistry;
import androidx.test.runner.intercepting.InterceptingActivityFactory;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.ApplicationStage;
import androidx.test.runner.lifecycle.Stage;
import c.o0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class MonitoringInstrumentation extends ExposedInstrumentationApi {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f10444q = "MonitoringInstr";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final long f10445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final long f10446s;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f10450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f10451e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f10455i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile InterceptingActivityFactory f10461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f10462p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ActivityLifecycleMonitorImpl f10447a = new ActivityLifecycleMonitorImpl();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ApplicationLifecycleMonitorImpl f10448b = new ApplicationLifecycleMonitorImpl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IntentMonitorImpl f10449c = new IntentMonitorImpl();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f10452f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicLong f10453g = new AtomicLong(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f10454h = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicBoolean f10456j = new AtomicBoolean(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile Boolean f10457k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ThreadLocal<Boolean> f10458l = new ThreadLocal<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MessageQueue.IdleHandler f10459m = new MessageQueue.IdleHandler() { // from class: androidx.test.runner.MonitoringInstrumentation.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            MonitoringInstrumentation.this.f10453g.set(System.currentTimeMillis());
            return true;
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f10460n = false;

    public class ActivityFinisher implements Runnable {
        public ActivityFinisher() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<Activity> arrayList = new ArrayList();
            Iterator it = EnumSet.range(Stage.CREATED, Stage.STOPPED).iterator();
            while (it.hasNext()) {
                arrayList.addAll(MonitoringInstrumentation.this.f10447a.d((Stage) it.next()));
            }
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                StringBuilder sb = new StringBuilder(60);
                sb.append("Activities that are still in CREATED to STOPPED: ");
                sb.append(size);
                Log.i(MonitoringInstrumentation.f10444q, sb.toString());
            }
            for (Activity activity : arrayList) {
                if (!activity.isFinishing()) {
                    try {
                        String strValueOf = String.valueOf(activity);
                        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 20);
                        sb2.append("Finishing activity: ");
                        sb2.append(strValueOf);
                        Log.i(MonitoringInstrumentation.f10444q, sb2.toString());
                        activity.finish();
                    } catch (RuntimeException e8) {
                        Log.e(MonitoringInstrumentation.f10444q, "Failed to finish activity.", e8);
                    }
                }
            }
        }
    }

    private static class StubResultCallable implements Callable<Instrumentation.ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f10470a;

        StubResultCallable(Intent intent) {
            this.f10470a = intent;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Instrumentation.ActivityResult call() {
            return IntentStubberRegistry.b().a(this.f10470a);
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(2L);
        f10445r = millis;
        f10446s = millis / 40;
    }

    private void A() {
        Boolean bool = Boolean.TRUE;
        if (bool.equals(this.f10458l.get())) {
            return;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = getTargetContext().getClassLoader();
        if (contextClassLoader != classLoader) {
            Log.i(f10444q, String.format("Setting context classloader to '%s', Original: '%s'", classLoader, contextClassLoader));
            Thread.currentThread().setContextClassLoader(classLoader);
        }
        this.f10458l.set(bool);
    }

    private Instrumentation.ActivityResult D(Intent intent) {
        if (!IntentStubberRegistry.c()) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return IntentStubberRegistry.b().a(intent);
        }
        FutureTask futureTask = new FutureTask(new StubResultCallable(intent));
        runOnMainSync(futureTask);
        try {
            return (Instrumentation.ActivityResult) futureTask.get();
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e8);
        } catch (ExecutionException e9) {
            throw new RuntimeException(String.format("Could not retrieve stub result for intent %s", intent), e9);
        }
    }

    private void E(final String className) {
        if (className == null) {
            throw new NullPointerException("JsBridge class name cannot be null!");
        }
        runOnMainSync(new Runnable() { // from class: androidx.test.runner.MonitoringInstrumentation.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Class.forName(className).getDeclaredMethod("installBridge", new Class[0]).invoke(null, new Object[0]);
                    MonitoringInstrumentation.this.f10456j.set(true);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    Log.i(MonitoringInstrumentation.f10444q, "No JSBridge.");
                } catch (IllegalAccessException e8) {
                    e = e8;
                    throw new RuntimeException("JSbridge is available at runtime, but calling it failed.", e);
                } catch (InvocationTargetException e9) {
                    e = e9;
                    throw new RuntimeException("JSbridge is available at runtime, but calling it failed.", e);
                }
            }
        });
    }

    private List<String> n() {
        if (Build.VERSION.SDK_INT < 26) {
            return Collections.emptyList();
        }
        try {
            String str = getContext().getPackageManager().getInstrumentationInfo(getComponentName(), 0).targetProcesses;
            if (str == null) {
                str = "";
            }
            String strTrim = str.trim();
            if (strTrim.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : strTrim.split(",", -1)) {
                String strTrim2 = str2.trim();
                if (strTrim2.length() > 0) {
                    arrayList.add(strTrim2);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e8) {
            String strValueOf = String.valueOf(getComponentName());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("Cannot locate ourselves: ");
            sb.append(strValueOf);
            Log.wtf(f10444q, sb.toString(), e8);
            String strValueOf2 = String.valueOf(getComponentName());
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 25);
            sb2.append("Cannot locate ourselves: ");
            sb2.append(strValueOf2);
            throw new IllegalStateException(sb2.toString(), e8);
        }
    }

    private boolean s(String wantName, ProcSummary ps) {
        int length = wantName.length();
        int length2 = ps.f10249e.length();
        if (length == length2) {
            return wantName.equals(ps.f10249e);
        }
        if (length < length2 || !wantName.startsWith(ps.f10249e) || !wantName.endsWith(ps.f10245a)) {
            return false;
        }
        String strValueOf = String.valueOf(ps);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 165 + wantName.length());
        sb.append("Use smaller processNames in AndroidManifest.xml. Long names are truncated. This process's cmdline is a prefix of the processName and suffix of comm - assuming: ");
        sb.append(strValueOf);
        sb.append(" is: ");
        sb.append(wantName);
        Log.w(f10444q, sb.toString());
        return true;
    }

    private boolean t() {
        Boolean boolValueOf = this.f10457k;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(u());
            this.f10457k = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    private boolean u() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        List<String> listN = n();
        if (listN.isEmpty()) {
            return true;
        }
        boolean zEquals = "*".equals(listN.get(0));
        if (listN.size() == 1 && !zEquals) {
            return true;
        }
        try {
            ProcSummary procSummaryC = ProcSummary.c("self");
            if (!zEquals) {
                return s(listN.get(0), procSummaryC);
            }
            String packageName = getTargetContext().getApplicationInfo().processName;
            if (packageName == null) {
                packageName = getTargetContext().getPackageName();
            }
            return s(packageName, procSummaryC);
        } catch (ProcSummary.SummaryException e8) {
            Log.w(f10444q, "Could not list apps for this user, running in sandbox? Assuming primary", e8);
            return false;
        }
    }

    private void x() {
        this.f10462p = Thread.currentThread().getUncaughtExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.test.runner.MonitoringInstrumentation.3
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread t7, Throwable e8) {
                MonitoringInstrumentation.this.onException(t7, e8);
                if (MonitoringInstrumentation.this.f10462p != null) {
                    Log.w(MonitoringInstrumentation.f10444q, String.format("Invoking uncaught exception handler %s (a %s)", MonitoringInstrumentation.this.f10462p, MonitoringInstrumentation.this.f10462p.getClass()));
                    MonitoringInstrumentation.this.f10462p.uncaughtException(t7, e8);
                } else {
                    String strValueOf = String.valueOf(t7.getName());
                    Log.w(MonitoringInstrumentation.f10444q, strValueOf.length() != 0 ? "Invoking uncaught exception handler for thread: ".concat(strValueOf) : new String("Invoking uncaught exception handler for thread: "));
                    t7.getThreadGroup().uncaughtException(t7, e8);
                }
                if ("robolectric".equals(Build.FINGERPRINT) || !Looper.getMainLooper().getThread().equals(t7)) {
                    return;
                }
                Log.e(MonitoringInstrumentation.f10444q, "The main thread has died and the handlers didn't care, exiting");
                System.exit(-10);
            }
        });
    }

    protected boolean B() {
        return Boolean.parseBoolean(InstrumentationRegistry.a().getString("waitForActivitiesToComplete", "true"));
    }

    protected void C() {
        System.getProperties().put("dexmaker.dexcache", getTargetContext().getDir("dxmaker_cache", 0).getAbsolutePath());
    }

    public void F() {
        this.f10461o = new DefaultInterceptingActivityFactory();
    }

    protected void G() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Cannot be called from main thread!");
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + f10445r;
        int i7 = this.f10454h.get();
        while (i7 > 0 && System.currentTimeMillis() < jCurrentTimeMillis) {
            try {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unstopped activity count: ");
                sb.append(i7);
                Log.i(f10444q, sb.toString());
                Thread.sleep(f10446s);
                i7 = this.f10454h.get();
            } catch (InterruptedException e8) {
                Log.i(f10444q, "Abandoning activity wait due to interruption.", e8);
            }
        }
        if (i7 > 0) {
            g("ThreadState-unstopped.txt");
            Log.w(f10444q, String.format("Still %s activities active after waiting %s ms.", Integer.valueOf(i7), Long.valueOf(f10445r)));
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        this.f10447a.f(Stage.PRE_ON_CREATE, activity);
        super.callActivityOnCreate(activity, bundle);
        this.f10447a.f(Stage.CREATED, activity);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnDestroy(Activity activity) {
        super.callActivityOnDestroy(activity);
        this.f10447a.f(Stage.DESTROYED, activity);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnPause(Activity activity) {
        super.callActivityOnPause(activity);
        this.f10447a.f(Stage.PAUSED, activity);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestart(Activity activity) {
        super.callActivityOnRestart(activity);
        this.f10447a.f(Stage.RESTARTED, activity);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnResume(Activity activity) {
        super.callActivityOnResume(activity);
        this.f10447a.f(Stage.RESUMED, activity);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStart(Activity activity) {
        this.f10454h.incrementAndGet();
        try {
            super.callActivityOnStart(activity);
            this.f10447a.f(Stage.STARTED, activity);
        } catch (RuntimeException e8) {
            this.f10454h.decrementAndGet();
            throw e8;
        }
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStop(Activity activity) {
        try {
            super.callActivityOnStop(activity);
            this.f10447a.f(Stage.STOPPED, activity);
        } finally {
            this.f10454h.decrementAndGet();
        }
    }

    @Override // android.app.Instrumentation
    public void callApplicationOnCreate(Application app) {
        this.f10448b.c(app, ApplicationStage.PRE_ON_CREATE);
        super.callApplicationOnCreate(app);
        this.f10448b.c(app, ApplicationStage.CREATED);
    }

    @Override // android.app.Instrumentation
    public void finish(int resultCode, Bundle results) {
        if (this.f10460n) {
            Log.w(f10444q, "finish called 2x!");
            return;
        }
        this.f10460n = true;
        if (B()) {
            this.f10451e.post(new ActivityFinisher());
            long jCurrentTimeMillis = System.currentTimeMillis();
            G();
            Log.i(f10444q, String.format("waitForActivitiesToComplete() took: %sms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        }
        ActivityLifecycleMonitorRegistry.b(null);
        y();
        super.finish(resultCode, results);
    }

    protected void g(String outputFileName) {
        Log.e("THREAD_STATE", o());
    }

    public void h(Context who, IBinder contextThread, IBinder token, Activity target, Intent[] intents, Bundle options) {
        Log.d(f10444q, "execStartActivities(context, ibinder, ibinder, activity, intent[], bundle)");
        for (Intent intent : intents) {
            j(who, contextThread, token, target, intent, -1, options);
        }
    }

    public Instrumentation.ActivityResult i(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode) {
        this.f10449c.c(intent);
        Instrumentation.ActivityResult activityResultD = D(intent);
        if (activityResultD == null) {
            return super.execStartActivity(who, contextThread, token, target, intent, requestCode);
        }
        Log.i(f10444q, String.format("Stubbing intent %s", intent));
        return activityResultD;
    }

    public Instrumentation.ActivityResult j(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode, Bundle options) {
        this.f10449c.c(intent);
        Instrumentation.ActivityResult activityResultD = D(intent);
        if (activityResultD == null) {
            return super.execStartActivity(who, contextThread, token, target, intent, requestCode, options);
        }
        Log.i(f10444q, String.format("Stubbing intent %s", intent));
        return activityResultD;
    }

    public Instrumentation.ActivityResult k(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode, Bundle options, UserHandle user) {
        return super.execStartActivity(who, contextThread, token, target, intent, requestCode, options, user);
    }

    public Instrumentation.ActivityResult l(Context who, IBinder contextThread, IBinder token, Fragment target, Intent intent, int requestCode, Bundle options) {
        Log.d(f10444q, "execStartActivity(context, IBinder, IBinder, Fragment, Intent, int, Bundle)");
        this.f10449c.c(intent);
        Instrumentation.ActivityResult activityResultD = D(intent);
        if (activityResultD == null) {
            return super.execStartActivity(who, contextThread, token, target, intent, requestCode, options);
        }
        Log.i(f10444q, String.format("Stubbing intent %s", intent));
        return activityResultD;
    }

    public Instrumentation.ActivityResult m(Context who, IBinder contextThread, IBinder token, String target, Intent intent, int requestCode, Bundle options) {
        this.f10449c.c(intent);
        Instrumentation.ActivityResult activityResultD = D(intent);
        if (activityResultD == null) {
            return super.execStartActivity(who, contextThread, token, target, intent, requestCode, options);
        }
        Log.i(f10444q, String.format("Stubbing intent %s", intent));
        return activityResultD;
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(Class<?> clazz, Context context, IBinder token, Application application, Intent intent, ActivityInfo info, CharSequence title, Activity parent, String id, Object lastNonConfigurationInstance) throws IllegalAccessException, InstantiationException {
        String name = clazz.getPackage().getName();
        String packageName = context.getPackageName();
        ComponentName component = intent.getComponent();
        if (!packageName.equals(component.getPackageName()) && name.equals(component.getPackageName())) {
            intent.setComponent(new ComponentName(packageName, component.getClassName()));
        }
        return super.newActivity(clazz, context, token, application, intent, info, title, parent, id, lastNonConfigurationInstance);
    }

    protected String o() {
        Set<Map.Entry<Thread, StackTraceElement[]>> setEntrySet = Thread.getAllStackTraces().entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : setEntrySet) {
            StringBuilder sb2 = new StringBuilder("  ");
            sb2.append(entry.getKey());
            sb2.append("\n");
            for (StackTraceElement stackTraceElement : entry.getValue()) {
                sb2.append("    ");
                sb2.append(stackTraceElement.toString());
                sb2.append("\n");
            }
            sb2.append("\n");
            sb.append(sb2.toString());
        }
        return sb.toString();
    }

    @Override // android.app.Instrumentation
    public void onCreate(Bundle arguments) {
        Log.i(f10444q, "Instrumentation started!");
        x();
        p();
        InstrumentationRegistry.c(this, arguments);
        androidx.test.InstrumentationRegistry.e(this, arguments);
        ActivityLifecycleMonitorRegistry.b(this.f10447a);
        ApplicationLifecycleMonitorRegistry.b(this.f10448b);
        IntentMonitorRegistry.b(this.f10449c);
        this.f10451e = new Handler(Looper.getMainLooper());
        this.f10450d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory(this) { // from class: androidx.test.runner.MonitoringInstrumentation.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName(MonitoringInstrumentation.class.getSimpleName());
                return threadNewThread;
            }
        });
        Looper.myQueue().addIdleHandler(this.f10459m);
        super.onCreate(arguments);
        C();
        A();
        F();
    }

    @Override // android.app.Instrumentation
    public void onDestroy() {
        Log.i(f10444q, "Instrumentation Finished!");
        Looper.myQueue().removeIdleHandler(this.f10459m);
        InstrumentationConnection.f().j();
        super.onDestroy();
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object obj, Throwable e8) {
        Log.e(f10444q, String.format("Exception encountered by: %s. Dumping thread state to outputs and pining for the fjords.", obj), e8);
        g("ThreadState-onException.txt");
        Log.e(f10444q, "Dying now...");
        return super.onException(obj, e8);
    }

    @Override // android.app.Instrumentation
    public void onStart() {
        super.onStart();
        String str = this.f10455i;
        if (str != null) {
            E(str);
        }
        waitForIdleSync();
        A();
        InstrumentationConnection.f().g(this, new ActivityFinisher());
    }

    protected void p() {
    }

    protected void q(Class<?> multidexClass) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        multidexClass.getDeclaredMethod("install", Context.class).invoke(null, getTargetContext());
    }

    public void r(InterceptingActivityFactory interceptingActivityFactory) {
        Checks.f(interceptingActivityFactory);
        this.f10461o = interceptingActivityFactory;
    }

    @Override // android.app.Instrumentation
    public void runOnMainSync(Runnable runnable) {
        FutureTask futureTask = new FutureTask(runnable, null);
        super.runOnMainSync(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException e8) {
            Log.e(f10444q, "An execution is interrupted", e8);
            throw new RuntimeException(e8);
        } catch (ExecutionException e9) {
            Log.e(f10444q, "An exception is thrown from the runnable posted to the main thread", e9);
            throw new RuntimeException(e9.getCause());
        }
    }

    @Override // android.app.Instrumentation
    public Activity startActivitySync(final Intent intent) {
        Checks.e();
        long j7 = this.f10453g.get();
        if (this.f10452f.compareAndSet(false, true)) {
            intent.addFlags(67108864);
        }
        Future futureSubmit = this.f10450d.submit(new Callable<Activity>() { // from class: androidx.test.runner.MonitoringInstrumentation.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Activity call() {
                return MonitoringInstrumentation.super.startActivitySync(intent);
            }
        });
        try {
            return (Activity) futureSubmit.get(ActivityLifecycleTimeout.a(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted", e8);
        } catch (ExecutionException e9) {
            throw new RuntimeException("Could not launch activity", e9.getCause());
        } catch (TimeoutException unused) {
            g("ThreadState-startActivityTimeout.txt");
            futureSubmit.cancel(true);
            throw new RuntimeException(String.format("Could not launch intent %s within %s milliseconds. Perhaps the main thread has not gone idle within a reasonable amount of time? There could be an animation or something constantly repainting the screen. Or the activity is doing network calls on creation? See the threaddump logs. For your reference the last time the event queue was idle before your activity launch request was %s and now the last time the queue went idle was: %s. If these numbers are the same your activity might be hogging the event queue.", intent, Long.valueOf(ActivityLifecycleTimeout.a()), Long.valueOf(j7), Long.valueOf(this.f10453g.get())));
        }
    }

    protected final boolean v() {
        return t();
    }

    @Deprecated
    protected boolean w(@o0 String argsProcessName) {
        return v();
    }

    protected void y() {
        Thread.currentThread().setUncaughtExceptionHandler(this.f10462p);
    }

    protected final void z(final String className) {
        if (className == null) {
            throw new NullPointerException("JsBridge class name cannot be null!");
        }
        if (this.f10456j.get()) {
            throw new IllegalStateException("JsBridge is already loaded!");
        }
        this.f10455i = className;
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (this.f10461o.a(cl, className, intent)) {
            return this.f10461o.b(cl, className, intent);
        }
        return super.newActivity(cl, className, intent);
    }
}
