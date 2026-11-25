package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import c.g1;

/* JADX INFO: loaded from: classes.dex */
public class z implements q {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g1
    static final long f8359i = 700;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final z f8360j = new z();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f8365e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8361a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8362b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8363c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8364d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final r f8366f = new r(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f8367g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    b0.a f8368h = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.f();
            z.this.g();
        }
    }

    class b implements b0.a {
        b() {
        }

        @Override // androidx.lifecycle.b0.a
        public void i() {
            z.this.b();
        }

        @Override // androidx.lifecycle.b0.a
        public void j() {
        }

        @Override // androidx.lifecycle.b0.a
        public void onStart() {
            z.this.c();
        }
    }

    class c extends g {

        class a extends g {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(@c.m0 Activity activity) {
                z.this.b();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(@c.m0 Activity activity) {
                z.this.c();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                b0.f(activity).h(z.this.f8368h);
            }
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            z.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @c.t0(29)
        public void onActivityPreCreated(@c.m0 Activity activity, @c.o0 Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            z.this.d();
        }
    }

    private z() {
    }

    @c.m0
    public static q h() {
        return f8360j;
    }

    static void i(Context context) {
        f8360j.e(context);
    }

    void a() {
        int i7 = this.f8362b - 1;
        this.f8362b = i7;
        if (i7 == 0) {
            this.f8365e.postDelayed(this.f8367g, f8359i);
        }
    }

    void b() {
        int i7 = this.f8362b + 1;
        this.f8362b = i7;
        if (i7 == 1) {
            if (!this.f8363c) {
                this.f8365e.removeCallbacks(this.f8367g);
            } else {
                this.f8366f.j(m.b.ON_RESUME);
                this.f8363c = false;
            }
        }
    }

    void c() {
        int i7 = this.f8361a + 1;
        this.f8361a = i7;
        if (i7 == 1 && this.f8364d) {
            this.f8366f.j(m.b.ON_START);
            this.f8364d = false;
        }
    }

    void d() {
        this.f8361a--;
        g();
    }

    void e(Context context) {
        this.f8365e = new Handler();
        this.f8366f.j(m.b.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    void f() {
        if (this.f8362b == 0) {
            this.f8363c = true;
            this.f8366f.j(m.b.ON_PAUSE);
        }
    }

    void g() {
        if (this.f8361a == 0 && this.f8363c) {
            this.f8366f.j(m.b.ON_STOP);
            this.f8364d = true;
        }
    }

    @Override // androidx.lifecycle.q
    @c.m0
    public m getLifecycle() {
        return this.f8366f;
    }
}
