package org.chromium.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public class ApplicationStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38599a = "androidx.appcompat.internal.app.ToolbarActionBar$ToolbarCallbackWrapper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f38600b = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f38601c = "com.android.tools.profiler.support.event.WindowProfilerCallback";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static Activity f38604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static f f38605g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ boolean f38609k = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Activity, d> f38602d = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("sActivityInfo")
    @SuppressLint({"SupportAnnotationUsage"})
    private static int f38603e = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a0<e> f38606h = new a0<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a0<f> f38607i = new a0<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a0<h> f38608j = new a0<>();

    class a implements h {
        a() {
        }

        @Override // org.chromium.base.ApplicationStatus.h
        public void a(Activity activity, boolean z7) {
            int iL;
            if (!z7 || activity == ApplicationStatus.f38604f || (iL = ApplicationStatus.l(activity)) == 6 || iL == 5) {
                return;
            }
            Activity unused = ApplicationStatus.f38604f = activity;
        }
    }

    class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f38610a = false;

        b() {
        }

        private void a(Activity activity) {
            if (l.f38814b) {
                activity.getWindow().getCallback().getClass();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ApplicationStatus.q(activity, 1);
            activity.getWindow().setCallback((Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new g(activity, activity.getWindow().getCallback())));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            ApplicationStatus.q(activity, 6);
            a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ApplicationStatus.q(activity, 4);
            a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            ApplicationStatus.q(activity, 3);
            a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ApplicationStatus.q(activity, 2);
            a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ApplicationStatus.q(activity, 5);
            a(activity);
        }
    }

    class c implements Runnable {

        class a implements f {
            a() {
            }

            @Override // org.chromium.base.ApplicationStatus.f
            public void a(int i7) {
                ApplicationStatus.nativeOnApplicationStateChange(i7);
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApplicationStatus.f38605g != null) {
                return;
            }
            f unused = ApplicationStatus.f38605g = new a();
            ApplicationStatus.s(ApplicationStatus.f38605g);
        }
    }

    public interface e {
        void a(Activity activity, int i7);
    }

    public interface f {
        void a(int i7);
    }

    private static class g implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Window.Callback f38614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Activity f38615b;

        public g(Activity activity, Window.Callback callback) {
            this.f38614a = callback;
            this.f38615b = activity;
        }

        public void a(boolean z7) {
            this.f38614a.onWindowFocusChanged(z7);
            Iterator it = ApplicationStatus.f38608j.iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(this.f38615b, z7);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals("onWindowFocusChanged") && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof Boolean) {
                    a(((Boolean) obj2).booleanValue());
                    return null;
                }
            }
            try {
                return method.invoke(this.f38614a, objArr);
            } catch (InvocationTargetException e8) {
                if (e8.getCause() instanceof AbstractMethodError) {
                    throw e8.getCause();
                }
                throw e8;
            }
        }
    }

    public interface h {
        void a(Activity activity, boolean z7);
    }

    private ApplicationStatus() {
    }

    @c.d
    @CalledByNative
    public static int getStateForApplication() {
        int i7;
        synchronized (f38602d) {
            i7 = f38603e;
        }
        return i7;
    }

    @c.j0
    public static void h() {
        Map<Activity, d> map = f38602d;
        synchronized (map) {
            f38607i.clear();
            f38606h.clear();
            map.clear();
            f38608j.clear();
            f38603e = 0;
            f38604f = null;
            f38605g = null;
        }
    }

    @GuardedBy("sActivityInfo")
    private static int i() {
        Iterator<d> it = f38602d.values().iterator();
        boolean z7 = false;
        boolean z8 = false;
        while (it.hasNext()) {
            int iB = it.next().b();
            if (iB != 4 && iB != 5 && iB != 6) {
                return 1;
            }
            if (iB == 4) {
                z7 = true;
            } else if (iB == 5) {
                z8 = true;
            }
        }
        if (z7) {
            return 2;
        }
        return z8 ? 3 : 4;
    }

    @c.j0
    public static Activity j() {
        return f38604f;
    }

    @c.d
    public static List<Activity> k() {
        ArrayList arrayList;
        Map<Activity, d> map = f38602d;
        synchronized (map) {
            arrayList = new ArrayList(map.keySet());
        }
        return arrayList;
    }

    @c.d
    public static int l(@c.o0 Activity activity) {
        d dVar;
        if (activity == null || (dVar = f38602d.get(activity)) == null) {
            return 6;
        }
        return dVar.b();
    }

    @c.d
    public static boolean m() {
        int stateForApplication = getStateForApplication();
        return stateForApplication == 1 || stateForApplication == 2;
    }

    @c.j0
    public static void n(Application application) {
        synchronized (f38602d) {
            f38603e = 4;
        }
        v(new a());
        application.registerActivityLifecycleCallbacks(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i7);

    @c.d
    public static boolean o() {
        return f38602d.isEmpty();
    }

    public static boolean p() {
        boolean z7;
        synchronized (f38602d) {
            z7 = f38603e != 0;
        }
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x002f A[Catch: all -> 0x008a, TryCatch #0 {, blocks: (B:15:0x001b, B:16:0x0023, B:18:0x002f, B:20:0x0036, B:21:0x0038, B:22:0x003e), top: B:43:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0036 A[Catch: all -> 0x008a, TryCatch #0 {, blocks: (B:15:0x001b, B:16:0x0023, B:18:0x002f, B:20:0x0036, B:21:0x0038, B:22:0x003e), top: B:43:0x001b }] */
    public static void q(Activity activity, int i7) {
        d dVar;
        if (activity == null) {
            throw new IllegalArgumentException("null activity is not supported");
        }
        if (f38604f == null || i7 == 1 || i7 == 3 || i7 == 2) {
            f38604f = activity;
        }
        int stateForApplication = getStateForApplication();
        Map<Activity, d> map = f38602d;
        synchronized (map) {
            a aVar = null;
            if (i7 == 1) {
                map.put(activity, new d(aVar));
                dVar = map.get(activity);
                dVar.c(i7);
                if (i7 == 6) {
                    map.remove(activity);
                    if (activity == f38604f) {
                        f38604f = null;
                    }
                }
                f38603e = i();
            } else {
                dVar = map.get(activity);
                dVar.c(i7);
                if (i7 == 6) {
                    map.remove(activity);
                    if (activity == f38604f) {
                        f38604f = null;
                    }
                }
                f38603e = i();
            }
            throw th;
        }
        Iterator<e> it = dVar.a().iterator();
        while (it.hasNext()) {
            it.next().a(activity, i7);
        }
        Iterator<e> it2 = f38606h.iterator();
        while (it2.hasNext()) {
            it2.next().a(activity, i7);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<f> it3 = f38607i.iterator();
            while (it3.hasNext()) {
                it3.next().a(stateForApplication2);
            }
        }
    }

    @c.j0
    @s0
    public static void r(Activity activity, int i7) {
        q(activity, i7);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.k(new c());
    }

    @c.j0
    public static void s(f fVar) {
        f38607i.g(fVar);
    }

    @SuppressLint({"NewApi"})
    @c.j0
    public static void t(e eVar, Activity activity) {
        f38602d.get(activity).a().g(eVar);
    }

    @c.j0
    public static void u(e eVar) {
        f38606h.g(eVar);
    }

    @c.j0
    public static void v(h hVar) {
        f38608j.g(hVar);
    }

    @c.j0
    public static void w(e eVar) {
        f38606h.o(eVar);
        Map<Activity, d> map = f38602d;
        synchronized (map) {
            Iterator<d> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().a().o(eVar);
            }
        }
    }

    @c.j0
    public static void x(f fVar) {
        f38607i.o(fVar);
    }

    @c.j0
    public static void y(h hVar) {
        f38608j.o(hVar);
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a0<e> f38613b;

        private d() {
            this.f38612a = 6;
            this.f38613b = new a0<>();
        }

        public a0<e> a() {
            return this.f38613b;
        }

        public int b() {
            return this.f38612a;
        }

        public void c(int i7) {
            this.f38612a = i7;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }
}
