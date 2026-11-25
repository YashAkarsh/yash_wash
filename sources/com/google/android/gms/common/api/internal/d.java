package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class d implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f15176e = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f15177a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f15178b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("sInstance")
    private final ArrayList<a> f15179c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("sInstance")
    private boolean f15180d = false;

    @c1.a
    public interface a {
        @c1.a
        void a(boolean z7);
    }

    @c1.a
    private d() {
    }

    @c1.a
    @c.m0
    public static d b() {
        return f15176e;
    }

    @c1.a
    public static void c(@c.m0 Application application) {
        d dVar = f15176e;
        synchronized (dVar) {
            if (!dVar.f15180d) {
                application.registerActivityLifecycleCallbacks(dVar);
                application.registerComponentCallbacks(dVar);
                dVar.f15180d = true;
            }
        }
    }

    private final void f(boolean z7) {
        synchronized (f15176e) {
            Iterator<a> it = this.f15179c.iterator();
            while (it.hasNext()) {
                it.next().a(z7);
            }
        }
    }

    @c1.a
    public void a(@c.m0 a aVar) {
        synchronized (f15176e) {
            this.f15179c.add(aVar);
        }
    }

    @c1.a
    public boolean d() {
        return this.f15177a.get();
    }

    @c1.a
    @TargetApi(16)
    public boolean e(boolean z7) {
        if (!this.f15178b.get()) {
            if (!g1.v.e()) {
                return z7;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f15178b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f15177a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@c.m0 Activity activity, @c.o0 Bundle bundle) {
        boolean zCompareAndSet = this.f15177a.compareAndSet(true, false);
        this.f15178b.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@c.m0 Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@c.m0 Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@c.m0 Activity activity) {
        boolean zCompareAndSet = this.f15177a.compareAndSet(true, false);
        this.f15178b.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@c.m0 Activity activity, @c.m0 Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@c.m0 Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@c.m0 Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@c.m0 Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i7) {
        if (i7 == 20 && this.f15177a.compareAndSet(false, true)) {
            this.f15178b.set(true);
            f(true);
        }
    }
}
