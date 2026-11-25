package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f15747a = 4225;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15748b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private static e2 f15749c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    @g1.d0
    static HandlerThread f15750d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f15751e = false;

    @c1.a
    public static int c() {
        return f15747a;
    }

    @c1.a
    @c.m0
    public static j d(@c.m0 Context context) {
        synchronized (f15748b) {
            if (f15749c == null) {
                f15749c = new e2(context.getApplicationContext(), f15751e ? e().getLooper() : context.getMainLooper());
            }
        }
        return f15749c;
    }

    @c1.a
    @c.m0
    public static HandlerThread e() {
        synchronized (f15748b) {
            HandlerThread handlerThread = f15750d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f15750d = handlerThread2;
            handlerThread2.start();
            return f15750d;
        }
    }

    @c1.a
    public static void f() {
        synchronized (f15748b) {
            e2 e2Var = f15749c;
            if (e2Var != null && !f15751e) {
                e2Var.q(e().getLooper());
            }
            f15751e = true;
        }
    }

    @c1.a
    public boolean a(@c.m0 ComponentName componentName, @c.m0 ServiceConnection serviceConnection, @c.m0 String str) {
        return k(new a2(componentName, c()), serviceConnection, str, null);
    }

    @c1.a
    public boolean b(@c.m0 String str, @c.m0 ServiceConnection serviceConnection, @c.m0 String str2) {
        return k(new a2(str, c(), false), serviceConnection, str2, null);
    }

    @c1.a
    public void g(@c.m0 ComponentName componentName, @c.m0 ServiceConnection serviceConnection, @c.m0 String str) {
        i(new a2(componentName, c()), serviceConnection, str);
    }

    @c1.a
    public void h(@c.m0 String str, @c.m0 ServiceConnection serviceConnection, @c.m0 String str2) {
        i(new a2(str, c(), false), serviceConnection, str2);
    }

    protected abstract void i(a2 a2Var, ServiceConnection serviceConnection, String str);

    public final void j(@c.m0 String str, @c.m0 String str2, int i7, @c.m0 ServiceConnection serviceConnection, @c.m0 String str3, boolean z7) {
        i(new a2(str, str2, i7, z7), serviceConnection, str3);
    }

    protected abstract boolean k(a2 a2Var, ServiceConnection serviceConnection, String str, @c.o0 Executor executor);
}
