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
import com.haier.library.common.util.w;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class c extends BroadcastReceiver implements j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f26369h = 1000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f26370i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26371a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConnectivityManager f26373c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.library.common.b.a f26376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f26377g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<e> f26372b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f26374d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f26375e = new AtomicBoolean(false);

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            c.this.a(com.haier.library.common.b.a.c(c.this.f26371a, c.this.f26375e.get()));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        /* JADX INFO: renamed from: onLost, reason: merged with bridge method [inline-methods] */
        public void b(final Network network) {
            if (c.this.f26377g < 3) {
                c.i(c.this);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.haier.library.common.b.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26389a.b(network);
                    }
                }, 1000L);
            } else {
                c.this.a(com.haier.library.common.b.a.c(c.this.f26371a, c.this.f26375e.get()));
            }
        }
    }

    private void e(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(w.f26615a);
        context.registerReceiver(this, intentFilter);
    }

    private void g() {
        try {
            this.f26373c.unregisterNetworkCallback(this.f26374d);
        } catch (Exception e8) {
            e3.a.h("could not unregister network callback <%s>", e8.getMessage());
        }
    }

    static /* synthetic */ int i(c cVar) {
        int i7 = cVar.f26377g;
        cVar.f26377g = i7 + 1;
        return i7;
    }

    @Override // com.haier.library.common.b.e
    public /* synthetic */ void a(r rVar) {
        b.a(this, rVar);
    }

    @Override // com.haier.library.common.b.j
    public synchronized void b(Context context, e eVar) {
        this.f26371a = context;
        this.f26372b.add(eVar);
        if (this.f26372b.size() == 1) {
            e(context);
            this.f26373c = (ConnectivityManager) context.getSystemService("connectivity");
            this.f26373c.registerNetworkCallback(new NetworkRequest.Builder().build(), this.f26374d);
        }
    }

    @Override // com.haier.library.common.b.j
    public synchronized void c(Context context, e eVar) {
        try {
            if (context == null) {
                e3.a.h("stopObserving error context is null", new Object[0]);
                return;
            }
            this.f26372b.remove(eVar);
            if (this.f26372b.isEmpty()) {
                context.unregisterReceiver(this);
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        e3.a.e("NetworkMonitor onReceive <%s>", intent.getAction());
        int intExtra = intent.getIntExtra("wifi_state", 0);
        if (intExtra == 13) {
            this.f26375e.set(true);
            a(com.haier.library.common.b.a.c(context, this.f26375e.get()));
        } else if (intExtra == 11) {
            this.f26375e.set(false);
            a(com.haier.library.common.b.a.c(context, this.f26375e.get()));
        }
    }

    @Override // com.haier.library.common.b.e
    public void a(com.haier.library.common.b.a aVar) {
        this.f26376f = aVar;
        if (aVar == null) {
            e3.a.h("onNetworkStateChange connectStatus is null", new Object[0]);
            return;
        }
        e3.a.e("onNetworkStateChange <%s>", aVar.toString());
        List<e> list = this.f26372b;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(this.f26376f);
            }
        }
    }

    @Override // com.haier.library.common.b.j
    public com.haier.library.common.b.a a() {
        return this.f26376f;
    }
}
