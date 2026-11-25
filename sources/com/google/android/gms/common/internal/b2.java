package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class b2 implements ServiceConnection, f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<ServiceConnection, ServiceConnection> f15666a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15667b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    private IBinder f15669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a2 f15670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ComponentName f15671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ e2 f15672g;

    public b2(e2 e2Var, a2 a2Var) {
        this.f15672g = e2Var;
        this.f15670e = a2Var;
    }

    public final int a() {
        return this.f15667b;
    }

    public final ComponentName b() {
        return this.f15671f;
    }

    @c.o0
    public final IBinder c() {
        return this.f15669d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f15666a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, @c.o0 Executor executor) {
        this.f15667b = 3;
        e2 e2Var = this.f15672g;
        boolean zE = e2Var.f15715j.e(e2Var.f15712g, str, this.f15670e.c(e2Var.f15712g), this, this.f15670e.a(), executor);
        this.f15668c = zE;
        if (zE) {
            this.f15672g.f15713h.sendMessageDelayed(this.f15672g.f15713h.obtainMessage(1, this.f15670e), this.f15672g.f15717l);
        } else {
            this.f15667b = 2;
            try {
                e2 e2Var2 = this.f15672g;
                e2Var2.f15715j.c(e2Var2.f15712g, this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f15666a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f15672g.f15713h.removeMessages(1, this.f15670e);
        e2 e2Var = this.f15672g;
        e2Var.f15715j.c(e2Var.f15712g, this);
        this.f15668c = false;
        this.f15667b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f15666a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f15666a.isEmpty();
    }

    public final boolean j() {
        return this.f15668c;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f15672g.f15711f) {
            this.f15672g.f15713h.removeMessages(1, this.f15670e);
            this.f15669d = iBinder;
            this.f15671f = componentName;
            Iterator<ServiceConnection> it = this.f15666a.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f15667b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f15672g.f15711f) {
            this.f15672g.f15713h.removeMessages(1, this.f15670e);
            this.f15669d = null;
            this.f15671f = componentName;
            Iterator<ServiceConnection> it = this.f15666a.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f15667b = 2;
        }
    }
}
