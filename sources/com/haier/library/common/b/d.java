package com.haier.library.common.b;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.haier.library.common.util.w;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(23)
public class d extends BroadcastReceiver implements j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f26379h = 1000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f26380i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26381a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConnectivityManager f26383c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.library.common.b.a f26386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f26387g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<e> f26382b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f26384d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f26385e = new AtomicBoolean(false);

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            d.this.a(com.haier.library.common.b.a.c(d.this.f26381a, d.this.f26385e.get()));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        /* JADX INFO: renamed from: onLost, reason: merged with bridge method [inline-methods] */
        public void b(final Network network) {
            if (d.this.f26387g < 3) {
                d.k(d.this);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.haier.library.common.b.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26391a.b(network);
                    }
                }, 1000L);
            } else {
                d.this.a(com.haier.library.common.b.a.c(d.this.f26381a, d.this.f26385e.get()));
            }
        }
    }

    private void e(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        intentFilter.addAction(w.f26615a);
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        context.registerReceiver(this, intentFilter);
    }

    private void g() {
        try {
            this.f26383c.unregisterNetworkCallback(this.f26384d);
        } catch (Exception e8) {
            e3.a.h("could not unregister network callback <%s>", e8.getMessage());
        }
    }

    private boolean h(Context context) {
        String packageName = context.getPackageName();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager.isDeviceIdleMode() && !powerManager.isIgnoringBatteryOptimizations(packageName);
    }

    private void j() {
        try {
            this.f26381a.unregisterReceiver(this);
        } catch (Exception e8) {
            e3.a.h("could not unregister  idle Receiver <%s>", e8.getMessage());
        }
    }

    static /* synthetic */ int k(d dVar) {
        int i7 = dVar.f26387g;
        dVar.f26387g = i7 + 1;
        return i7;
    }

    @Override // com.haier.library.common.b.e
    public void a(com.haier.library.common.b.a aVar) {
        this.f26386f = aVar;
        if (aVar == null) {
            e3.a.h("onNetworkStateChange connectStatus is null", new Object[0]);
            return;
        }
        e3.a.e("onNetworkStateChange connectStatus<%s>", aVar.toString());
        List<e> list = this.f26382b;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(this.f26386f);
            }
        }
    }

    @Override // com.haier.library.common.b.j
    public synchronized void b(Context context, e eVar) {
        this.f26381a = context;
        this.f26382b.add(eVar);
        this.f26383c = (ConnectivityManager) context.getSystemService("connectivity");
        if (this.f26382b.size() == 1) {
            e(context);
            try {
                this.f26383c.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(13).build(), this.f26384d);
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
    }

    @Override // com.haier.library.common.b.j
    public synchronized void c(Context context, e eVar) {
        try {
            if (context == null) {
                e3.a.h("stopObserving error context is null", new Object[0]);
                return;
            }
            this.f26382b.remove(eVar);
            if (this.f26382b.isEmpty()) {
                j();
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra;
        String action = intent.getAction();
        e3.a.e("NetworkMonitor onReceive <%s>", action);
        if (w.f26615a.equals(action)) {
            int intExtra2 = intent.getIntExtra("wifi_state", 0);
            if (intExtra2 == 13) {
                this.f26385e.set(true);
                a(com.haier.library.common.b.a.c(context, this.f26385e.get()));
                return;
            } else {
                if (intExtra2 == 11) {
                    this.f26385e.set(false);
                    a(com.haier.library.common.b.a.c(context, this.f26385e.get()));
                    return;
                }
                return;
            }
        }
        if ("android.os.action.DEVICE_IDLE_MODE_CHANGED".equals(action) && h(context)) {
            e3.a.e("device in idle mode", new Object[0]);
            a(com.haier.library.common.b.a.c(context, this.f26385e.get()));
        } else {
            if (!com.haier.library.common.util.c.c("android.net.wifi.WIFI_STATE_CHANGED", action) || (intExtra = intent.getIntExtra("wifi_state", 0)) == 0) {
                return;
            }
            a(r.a(intExtra));
        }
    }

    @Override // com.haier.library.common.b.e
    public void a(r rVar) {
        e3.a.e("onWifiStateChange state<%s>", rVar);
        List<e> list = this.f26382b;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(rVar);
            }
        }
    }

    @Override // com.haier.library.common.b.j
    public com.haier.library.common.b.a a() {
        return this.f26386f;
    }
}
