package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class e2 extends j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("connectionStatus")
    private final HashMap<a2, b2> f15711f = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f15712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile Handler f15713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d2 f15714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.google.android.gms.common.stats.b f15715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f15716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f15717l;

    e2(Context context, Looper looper) {
        d2 d2Var = new d2(this, null);
        this.f15714i = d2Var;
        this.f15712g = context.getApplicationContext();
        this.f15713h = new com.google.android.gms.internal.common.t(looper, d2Var);
        this.f15715j = com.google.android.gms.common.stats.b.b();
        this.f15716k = 5000L;
        this.f15717l = 300000L;
    }

    @Override // com.google.android.gms.common.internal.j
    protected final void i(a2 a2Var, ServiceConnection serviceConnection, String str) {
        u.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f15711f) {
            b2 b2Var = this.f15711f.get(a2Var);
            if (b2Var == null) {
                String string = a2Var.toString();
                StringBuilder sb = new StringBuilder(string.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            if (!b2Var.h(serviceConnection)) {
                String string2 = a2Var.toString();
                StringBuilder sb2 = new StringBuilder(string2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(string2);
                throw new IllegalStateException(sb2.toString());
            }
            b2Var.f(serviceConnection, str);
            if (b2Var.i()) {
                this.f15713h.sendMessageDelayed(this.f15713h.obtainMessage(0, a2Var), this.f15716k);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.j
    protected final boolean k(a2 a2Var, ServiceConnection serviceConnection, String str, @c.o0 Executor executor) {
        boolean zJ;
        u.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f15711f) {
            b2 b2Var = this.f15711f.get(a2Var);
            if (b2Var == null) {
                b2Var = new b2(this, a2Var);
                b2Var.d(serviceConnection, serviceConnection, str);
                b2Var.e(str, executor);
                this.f15711f.put(a2Var, b2Var);
            } else {
                this.f15713h.removeMessages(0, a2Var);
                if (b2Var.h(serviceConnection)) {
                    String string = a2Var.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                b2Var.d(serviceConnection, serviceConnection, str);
                int iA = b2Var.a();
                if (iA == 1) {
                    serviceConnection.onServiceConnected(b2Var.b(), b2Var.c());
                } else if (iA == 2) {
                    b2Var.e(str, executor);
                }
            }
            zJ = b2Var.j();
        }
        return zJ;
    }

    final void q(Looper looper) {
        synchronized (this.f15711f) {
            this.f15713h = new com.google.android.gms.internal.common.t(looper, this.f15714i);
        }
    }
}
