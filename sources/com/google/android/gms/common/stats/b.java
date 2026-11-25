package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import c.m0;
import com.google.android.gms.common.internal.f2;
import com.google.android.gms.common.internal.u;
import g1.d0;
import g1.v;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15977b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static volatile b f15978c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d0
    @m0
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> f15979a = new ConcurrentHashMap<>();

    private b() {
    }

    @c1.a
    @m0
    public static b b() {
        if (f15978c == null) {
            synchronized (f15977b) {
                if (f15978c == null) {
                    f15978c = new b();
                }
            }
        }
        b bVar = f15978c;
        u.k(bVar);
        return bVar;
    }

    private static void f(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean g(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i7, boolean z7, @Nullable Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((com.google.android.gms.common.wrappers.d.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!h(serviceConnection)) {
            return i(context, intent, serviceConnection, i7, executor);
        }
        ServiceConnection serviceConnectionPutIfAbsent = this.f15979a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnectionPutIfAbsent != null && serviceConnection != serviceConnectionPutIfAbsent) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zI = i(context, intent, serviceConnection, i7, executor);
            if (zI) {
                return zI;
            }
            this.f15979a.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            this.f15979a.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }

    private static boolean h(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof f2);
    }

    private static final boolean i(Context context, Intent intent, ServiceConnection serviceConnection, int i7, @Nullable Executor executor) {
        return (!v.p() || executor == null) ? context.bindService(intent, serviceConnection, i7) : context.bindService(intent, i7, executor, serviceConnection);
    }

    @c1.a
    public boolean a(@m0 Context context, @m0 Intent intent, @m0 ServiceConnection serviceConnection, int i7) {
        return g(context, context.getClass().getName(), intent, serviceConnection, i7, true, null);
    }

    @c1.a
    public void c(@m0 Context context, @m0 ServiceConnection serviceConnection) {
        if (!h(serviceConnection) || !this.f15979a.containsKey(serviceConnection)) {
            f(context, serviceConnection);
            return;
        }
        try {
            f(context, this.f15979a.get(serviceConnection));
        } finally {
            this.f15979a.remove(serviceConnection);
        }
    }

    @c1.a
    public void d(@m0 Context context, @m0 ServiceConnection serviceConnection) {
        try {
            c(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean e(@m0 Context context, @m0 String str, @m0 Intent intent, @m0 ServiceConnection serviceConnection, int i7, @Nullable Executor executor) {
        return g(context, str, intent, serviceConnection, i7, true, executor);
    }
}
