package com.alibaba.android.arouter.launcher;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12460a = "NTeRQWvye18AkPd6G";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12461b = "wmHzgD4lOj5o4241";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f12462c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f12463d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ILogger f12464e;

    private a() {
    }

    @Deprecated
    public static void a() {
        b.e();
    }

    public static boolean e() {
        return b.i();
    }

    public static boolean f() {
        return b.j();
    }

    @Deprecated
    public static synchronized void h() {
        b.l();
    }

    public static a i() {
        if (!f12463d) {
            throw new d0.b("ARouter::Init::Invoke init(context) first!");
        }
        if (f12462c == null) {
            synchronized (a.class) {
                if (f12462c == null) {
                    f12462c = new a();
                }
            }
        }
        return f12462c;
    }

    public static void j(Application application) {
        if (f12463d) {
            return;
        }
        ILogger iLogger = b.f12465a;
        f12464e = iLogger;
        iLogger.info("ARouter::", "ARouter init start.");
        f12463d = b.o(application);
        if (f12463d) {
            b.d();
        }
        b.f12465a.info("ARouter::", "ARouter init over.");
    }

    public static boolean l() {
        return b.q();
    }

    public static synchronized void m() {
        b.r();
    }

    public static synchronized void p() {
        b.u();
    }

    public static synchronized void q() {
        b.v();
    }

    public static synchronized void r() {
        b.w();
    }

    public static synchronized void s(ThreadPoolExecutor threadPoolExecutor) {
        b.x(threadPoolExecutor);
    }

    public static void t(ILogger iLogger) {
        b.y(iLogger);
    }

    public Postcard b(Uri uri) {
        return b.n().f(uri);
    }

    public Postcard c(String str) {
        return b.n().g(str);
    }

    @Deprecated
    public Postcard d(String str, String str2) {
        return b.n().h(str, str2);
    }

    public synchronized void g() {
        b.k();
        f12463d = false;
    }

    public void k(Object obj) {
        b.p(obj);
    }

    public Object n(Context context, Postcard postcard, int i7, NavigationCallback navigationCallback) {
        return b.n().s(context, postcard, i7, navigationCallback);
    }

    public <T> T o(Class<? extends T> cls) {
        return (T) b.n().t(cls);
    }
}
