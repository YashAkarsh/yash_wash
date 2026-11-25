package com.haier.library.common.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.haier.library.common.util.w;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class i extends BroadcastReceiver implements j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f26395e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f26396f = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f26399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f26400d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f26398b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<e> f26397a = new CopyOnWriteArrayList();

    @Override // com.haier.library.common.b.e
    public void a(r rVar) {
        e3.a.e("onWifiStateChange state<%s>", rVar);
        List<e> list = this.f26397a;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(rVar);
            }
        }
    }

    @Override // com.haier.library.common.b.j
    public synchronized void b(Context context, e eVar) {
        try {
            if (context == null) {
                e3.a.h("registerNetworkReceiver error context is null", new Object[0]);
                return;
            }
            this.f26397a.add(eVar);
            if (this.f26397a.size() == 1) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction(w.f26615a);
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                context.registerReceiver(this, intentFilter);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.haier.library.common.b.j
    public synchronized void c(Context context, e eVar) {
        try {
            if (context == null) {
                e3.a.h("unRegisterNetworkReceiver error context is null", new Object[0]);
                return;
            }
            this.f26397a.remove(eVar);
            if (this.f26397a.isEmpty()) {
                context.unregisterReceiver(this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    /* JADX INFO: renamed from: onReceive, reason: merged with bridge method [inline-methods] */
    public void e(final Context context, final Intent intent) {
        int intExtra;
        String action = intent.getAction();
        e3.a.e("NetworkMonitor onReceive <%s>", action);
        if (w.f26615a.equals(action)) {
            int intExtra2 = intent.getIntExtra("wifi_state", 0);
            if (intExtra2 == 13) {
                this.f26398b.set(true);
                a(a.c(context, this.f26398b.get()));
                return;
            } else {
                if (intExtra2 == 11) {
                    this.f26398b.set(false);
                    return;
                }
                return;
            }
        }
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            if (!com.haier.library.common.util.c.c("android.net.wifi.WIFI_STATE_CHANGED", action) || (intExtra = intent.getIntExtra("wifi_state", 0)) == 0) {
                return;
            }
            a(r.a(intExtra));
            return;
        }
        if (this.f26398b.get() || h.a().c(context)) {
            a(a.c(context, this.f26398b.get()));
            return;
        }
        int i7 = this.f26400d;
        if (i7 >= 3) {
            a(a.c(context, this.f26398b.get()));
        } else {
            this.f26400d = i7 + 1;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.haier.library.common.b.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f26446a.e(context, intent);
                }
            }, 1000L);
        }
    }

    @Override // com.haier.library.common.b.e
    public void a(a aVar) {
        this.f26399c = aVar;
        if (aVar == null) {
            e3.a.h("onNetworkStateChange connectStatus is null", new Object[0]);
            return;
        }
        e3.a.e("onNetworkStateChange <%s>", aVar.toString());
        List<e> list = this.f26397a;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(this.f26399c);
            }
        }
    }

    @Override // com.haier.library.common.b.j
    public a a() {
        return this.f26399c;
    }
}
