package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class r0 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c
    private final q0 f15779a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f15786h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.google.android.gms.common.api.k.b> f15780b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g1.d0
    final ArrayList<com.google.android.gms.common.api.k.b> f15781c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<com.google.android.gms.common.api.k.c> f15782d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f15783e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f15784f = new AtomicInteger(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15785g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f15787i = new Object();

    public r0(Looper looper, q0 q0Var) {
        this.f15779a = q0Var;
        this.f15786h = new com.google.android.gms.internal.base.p(looper, this);
    }

    public final void a() {
        this.f15783e = false;
        this.f15784f.incrementAndGet();
    }

    public final void b() {
        this.f15783e = true;
    }

    @g1.d0
    public final void c(ConnectionResult connectionResult) {
        u.e(this.f15786h, "onConnectionFailure must only be called on the Handler thread");
        this.f15786h.removeMessages(1);
        synchronized (this.f15787i) {
            ArrayList<com.google.android.gms.common.api.k.c> arrayList = new ArrayList(this.f15782d);
            int i7 = this.f15784f.get();
            for (com.google.android.gms.common.api.k.c cVar : arrayList) {
                if (this.f15783e && this.f15784f.get() == i7) {
                    if (this.f15782d.contains(cVar)) {
                        cVar.u0(connectionResult);
                    }
                }
                return;
            }
        }
    }

    @g1.d0
    public final void d(@c.o0 Bundle bundle) {
        u.e(this.f15786h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f15787i) {
            u.q(!this.f15785g);
            this.f15786h.removeMessages(1);
            this.f15785g = true;
            u.q(this.f15781c.isEmpty());
            ArrayList<com.google.android.gms.common.api.k.b> arrayList = new ArrayList(this.f15780b);
            int i7 = this.f15784f.get();
            for (com.google.android.gms.common.api.k.b bVar : arrayList) {
                if (!this.f15783e || !this.f15779a.a() || this.f15784f.get() != i7) {
                    break;
                    break;
                    break;
                } else if (!this.f15781c.contains(bVar)) {
                    bVar.y0(bundle);
                }
            }
            this.f15781c.clear();
            this.f15785g = false;
        }
    }

    @g1.d0
    public final void e(int i7) {
        u.e(this.f15786h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f15786h.removeMessages(1);
        synchronized (this.f15787i) {
            this.f15785g = true;
            ArrayList<com.google.android.gms.common.api.k.b> arrayList = new ArrayList(this.f15780b);
            int i8 = this.f15784f.get();
            for (com.google.android.gms.common.api.k.b bVar : arrayList) {
                if (!this.f15783e || this.f15784f.get() != i8) {
                    break;
                    break;
                } else if (this.f15780b.contains(bVar)) {
                    bVar.i0(i7);
                }
            }
            this.f15781c.clear();
            this.f15785g = false;
        }
    }

    public final void f(com.google.android.gms.common.api.k.b bVar) {
        u.k(bVar);
        synchronized (this.f15787i) {
            if (this.f15780b.contains(bVar)) {
                String strValueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 62);
                sb.append("registerConnectionCallbacks(): listener ");
                sb.append(strValueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f15780b.add(bVar);
            }
        }
        if (this.f15779a.a()) {
            Handler handler = this.f15786h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void g(com.google.android.gms.common.api.k.c cVar) {
        u.k(cVar);
        synchronized (this.f15787i) {
            if (this.f15782d.contains(cVar)) {
                String strValueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 67);
                sb.append("registerConnectionFailedListener(): listener ");
                sb.append(strValueOf);
                sb.append(" is already registered");
                Log.w("GmsClientEvents", sb.toString());
            } else {
                this.f15782d.add(cVar);
            }
        }
    }

    public final void h(com.google.android.gms.common.api.k.b bVar) {
        u.k(bVar);
        synchronized (this.f15787i) {
            if (!this.f15780b.remove(bVar)) {
                String strValueOf = String.valueOf(bVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 52);
                sb.append("unregisterConnectionCallbacks(): listener ");
                sb.append(strValueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            } else if (this.f15785g) {
                this.f15781c.add(bVar);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i7 = message.what;
        if (i7 != 1) {
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i7);
            Log.wtf("GmsClientEvents", sb.toString(), new Exception());
            return false;
        }
        com.google.android.gms.common.api.k.b bVar = (com.google.android.gms.common.api.k.b) message.obj;
        synchronized (this.f15787i) {
            if (this.f15783e && this.f15779a.a() && this.f15780b.contains(bVar)) {
                bVar.y0(null);
            }
        }
        return true;
    }

    public final void i(com.google.android.gms.common.api.k.c cVar) {
        u.k(cVar);
        synchronized (this.f15787i) {
            if (!this.f15782d.remove(cVar)) {
                String strValueOf = String.valueOf(cVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 57);
                sb.append("unregisterConnectionFailedListener(): listener ");
                sb.append(strValueOf);
                sb.append(" not found");
                Log.w("GmsClientEvents", sb.toString());
            }
        }
    }

    public final boolean j(com.google.android.gms.common.api.k.b bVar) {
        boolean zContains;
        u.k(bVar);
        synchronized (this.f15787i) {
            zContains = this.f15780b.contains(bVar);
        }
        return zContains;
    }

    public final boolean k(com.google.android.gms.common.api.k.c cVar) {
        boolean zContains;
        u.k(cVar);
        synchronized (this.f15787i) {
            zContains = this.f15782d.contains(cVar);
        }
        return zContains;
    }
}
