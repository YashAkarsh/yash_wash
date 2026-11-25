package com.alibaba.android.arouter.launcher;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.d;
import com.alibaba.android.arouter.core.e;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.utils.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ILogger f12465a = new com.alibaba.android.arouter.utils.c("ARouter::");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f12466b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f12467c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f12468d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile b f12469e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f12470f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f12471g = com.alibaba.android.arouter.thread.b.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Handler f12472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Context f12473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static InterceptorService f12474j;

    class a implements InterceptorCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NavigationCallback f12477c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Postcard f12478d;

        a(Context context, int i7, NavigationCallback navigationCallback, Postcard postcard) {
            this.f12475a = context;
            this.f12476b = i7;
            this.f12477c = navigationCallback;
            this.f12478d = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            b.this.a(this.f12475a, postcard, this.f12476b, this.f12477c);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th) {
            NavigationCallback navigationCallback = this.f12477c;
            if (navigationCallback != null) {
                navigationCallback.onInterrupt(this.f12478d);
            }
            b.f12465a.info("ARouter::", "Navigation failed, termination by interceptor : " + th.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.alibaba.android.arouter.launcher.b$b, reason: collision with other inner class name */
    class RunnableC0146b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f12481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f12482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Postcard f12483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ NavigationCallback f12484e;

        RunnableC0146b(int i7, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
            this.f12480a = i7;
            this.f12481b = context;
            this.f12482c = intent;
            this.f12483d = postcard;
            this.f12484e = navigationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.z(this.f12480a, this.f12481b, this.f12482c, this.f12483d, this.f12484e);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12486a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f12486a = iArr;
            try {
                iArr[RouteType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12486a[RouteType.PROVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12486a[RouteType.BOARDCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12486a[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12486a[RouteType.FRAGMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12486a[RouteType.METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12486a[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(Context context, Postcard postcard, int i7, NavigationCallback navigationCallback) {
        if (context == null) {
            context = f12473i;
        }
        int i8 = c.f12486a[postcard.getType().ordinal()];
        if (i8 == 1) {
            Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (-1 != flags) {
                intent.setFlags(flags);
            } else if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            String action = postcard.getAction();
            if (!f.d(action)) {
                intent.setAction(action);
            }
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                f12472h.post(new RunnableC0146b(i7, context, intent, postcard, navigationCallback));
            } else {
                z(i7, context, intent, postcard, navigationCallback);
            }
            return null;
        }
        if (i8 == 2) {
            return postcard.getProvider();
        }
        if (i8 == 3 || i8 == 4 || i8 == 5) {
            try {
                Object objNewInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance instanceof Fragment) {
                    ((Fragment) objNewInstance).setArguments(postcard.getExtras());
                } else if (objNewInstance instanceof androidx.fragment.app.Fragment) {
                    ((androidx.fragment.app.Fragment) objNewInstance).setArguments(postcard.getExtras());
                }
                return objNewInstance;
            } catch (Exception e8) {
                f12465a.error("ARouter::", "Fetch fragment instance error, " + f.a(e8.getStackTrace()));
            }
        }
        return null;
    }

    static void d() {
        f12474j = (InterceptorService) com.alibaba.android.arouter.launcher.a.i().c("/arouter/service/interceptor").navigation();
    }

    @Deprecated
    static void e() {
        Log.i("ARouter::", "ARouter start attachBaseContext");
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            declaredField.set(objInvoke, new com.alibaba.android.arouter.core.c());
            Log.i("ARouter::", "ARouter hook instrumentation success!");
        } catch (Exception e8) {
            Log.e("ARouter::", "ARouter hook instrumentation failed! [" + e8.getMessage() + "]");
        }
    }

    @Deprecated
    static boolean i() {
        return f12468d;
    }

    static boolean j() {
        return f12467c;
    }

    static synchronized void k() {
        if (j()) {
            f12470f = false;
            e.k();
            f12465a.info("ARouter::", "ARouter destroy success!");
        } else {
            f12465a.error("ARouter::", "Destroy can be used in debug mode only!");
        }
    }

    @Deprecated
    static synchronized void l() {
        f12468d = true;
    }

    private String m(String str) {
        if (f.d(str) || !str.startsWith("/")) {
            throw new d0.a("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String strSubstring = str.substring(1, str.indexOf("/", 1));
            if (f.d(strSubstring)) {
                throw new d0.a("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
            }
            return strSubstring;
        } catch (Exception e8) {
            f12465a.warning("ARouter::", "Failed to extract default group! " + e8.getMessage());
            return null;
        }
    }

    protected static b n() {
        if (!f12470f) {
            throw new d0.b("ARouterCore::Init::Invoke init(context) first!");
        }
        if (f12469e == null) {
            synchronized (b.class) {
                if (f12469e == null) {
                    f12469e = new b();
                }
            }
        }
        return f12469e;
    }

    protected static synchronized boolean o(Application application) {
        f12473i = application;
        e.c(application, f12471g);
        f12465a.info("ARouter::", "ARouter init success!");
        f12470f = true;
        f12472h = new Handler(Looper.getMainLooper());
        return true;
    }

    static void p(Object obj) {
        AutowiredService autowiredService = (AutowiredService) com.alibaba.android.arouter.launcher.a.i().c("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    static boolean q() {
        return f12466b;
    }

    static synchronized void r() {
        f12466b = true;
        f12465a.info("ARouter::", "ARouter monitorMode on");
    }

    static synchronized void u() {
        f12467c = true;
        f12465a.info("ARouter::", "ARouter openDebug");
    }

    static synchronized void v() {
        f12465a.showLog(true);
        f12465a.info("ARouter::", "ARouter openLog");
    }

    static synchronized void w() {
        f12465a.showStackTrace(true);
        f12465a.info("ARouter::", "ARouter printStackTrace");
    }

    static synchronized void x(ThreadPoolExecutor threadPoolExecutor) {
        f12471g = threadPoolExecutor;
    }

    static void y(ILogger iLogger) {
        if (iLogger != null) {
            f12465a = iLogger;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i7, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i7 >= 0) {
            androidx.core.app.b.N((Activity) context, intent, i7, postcard.getOptionsBundle());
        } else {
            d.t(context, intent, postcard.getOptionsBundle());
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }

    protected Postcard f(Uri uri) {
        if (uri == null || f.d(uri.toString())) {
            throw new d0.a("ARouter::Parameter invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) com.alibaba.android.arouter.launcher.a.i().o(PathReplaceService.class);
        if (pathReplaceService != null) {
            uri = pathReplaceService.forUri(uri);
        }
        return new Postcard(uri.getPath(), m(uri.getPath()), uri, null);
    }

    protected Postcard g(String str) {
        if (f.d(str)) {
            throw new d0.a("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) com.alibaba.android.arouter.launcher.a.i().o(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return h(str, m(str));
    }

    protected Postcard h(String str, String str2) {
        if (f.d(str) || f.d(str2)) {
            throw new d0.a("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) com.alibaba.android.arouter.launcher.a.i().o(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    protected Object s(Context context, Postcard postcard, int i7, NavigationCallback navigationCallback) {
        try {
            e.b(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return a(context, postcard, i7, navigationCallback);
            }
            f12474j.doInterceptions(postcard, new a(context, i7, navigationCallback, postcard));
            return null;
        } catch (d0.c e8) {
            f12465a.warning("ARouter::", e8.getMessage());
            if (j()) {
                Toast.makeText(f12473i, "There's no route matched!\n Path = [" + postcard.getPath() + "]\n Group = [" + postcard.getGroup() + "]", 1).show();
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) com.alibaba.android.arouter.launcher.a.i().o(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    protected <T> T t(Class<? extends T> cls) {
        try {
            Postcard postcardA = e.a(cls.getName());
            if (postcardA == null) {
                postcardA = e.a(cls.getSimpleName());
            }
            if (postcardA == null) {
                return null;
            }
            e.b(postcardA);
            return (T) postcardA.getProvider();
        } catch (d0.c e8) {
            f12465a.warning("ARouter::", e8.getMessage());
            return null;
        }
    }
}
