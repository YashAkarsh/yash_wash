package com.haier.uhome.usdk.base.service;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.haier.uhome.usdk.base.api.p;
import com.haier.uhome.usdk.base.api.r;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f31341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f31342b;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.base.service.a$a, reason: collision with other inner class name */
    private static class C0381a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f31343a = new a();

        private C0381a() {
        }
    }

    public static a a() {
        return C0381a.f31343a;
    }

    private void c() {
        e3.a.e("gotoBackground", new Object[0]);
        for (p pVar : r.a().g()) {
            if (pVar != null) {
                pVar.a(false);
            }
        }
    }

    private void d() {
        e3.a.e("gotoForeground", new Object[0]);
        for (p pVar : r.a().g()) {
            if (pVar != null) {
                pVar.a(true);
            }
        }
    }

    public boolean b() {
        return this.f31341a.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f31342b.incrementAndGet();
        if (!this.f31341a.get() && this.f31342b.get() == 1) {
            this.f31341a.set(true);
            d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f31342b.decrementAndGet();
        if (this.f31341a.get() && this.f31342b.get() == 0) {
            this.f31341a.set(false);
            c();
        }
    }

    private a() {
        this.f31341a = new AtomicBoolean(true);
        this.f31342b = new AtomicInteger(0);
    }
}
