package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY})
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5134a = "ActivityRecreator";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Class<?> f5135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Field f5136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Field f5137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Method f5138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final Method f5139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final Method f5140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Handler f5141h = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f5142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f5143b;

        a(d dVar, Object obj) {
            this.f5142a = dVar;
            this.f5143b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5142a.f5148a = this.f5143b;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Application f5144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f5145b;

        b(Application application, d dVar) {
            this.f5144a = application;
            this.f5145b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5144a.unregisterActivityLifecycleCallbacks(this.f5145b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f5147b;

        c(Object obj, Object obj2) {
            this.f5146a = obj;
            this.f5147b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = l.f5138e;
                if (method != null) {
                    method.invoke(this.f5146a, this.f5147b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    l.f5139f.invoke(this.f5146a, this.f5147b, Boolean.FALSE);
                }
            } catch (RuntimeException e8) {
                if (e8.getClass() == RuntimeException.class && e8.getMessage() != null && e8.getMessage().startsWith("Unable to stop")) {
                    throw e8;
                }
            } catch (Throwable th) {
                Log.e(l.f5134a, "Exception while invoking performStopActivity", th);
            }
        }
    }

    private static final class d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f5148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Activity f5149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f5150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f5151d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f5152e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5153f = false;

        d(@c.m0 Activity activity) {
            this.f5149b = activity;
            this.f5150c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f5149b == activity) {
                this.f5149b = null;
                this.f5152e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f5152e || this.f5153f || this.f5151d || !l.h(this.f5148a, this.f5150c, activity)) {
                return;
            }
            this.f5153f = true;
            this.f5148a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f5149b == activity) {
                this.f5151d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        f5135b = clsA;
        f5136c = b();
        f5137d = f();
        f5138e = d(clsA);
        f5139f = c(clsA);
        f5140g = e(clsA);
    }

    private l() {
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i7 = Build.VERSION.SDK_INT;
        return i7 == 26 || i7 == 27;
    }

    protected static boolean h(Object obj, int i7, Activity activity) {
        try {
            Object obj2 = f5137d.get(activity);
            if (obj2 == obj && activity.hashCode() == i7) {
                f5141h.postAtFrontOfQueue(new c(f5136c.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e(f5134a, "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(@c.m0 Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f5140g == null) {
            return false;
        }
        if (f5139f == null && f5138e == null) {
            return false;
        }
        try {
            Object obj2 = f5137d.get(activity);
            if (obj2 == null || (obj = f5136c.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            f5141h.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f5140g;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f5141h.post(new b(application, dVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
