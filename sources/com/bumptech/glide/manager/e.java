package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.a f14720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f14723e = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z7 = e.this.f14721c;
            e eVar = e.this;
            eVar.f14721c = eVar.n(context);
            if (z7 != e.this.f14721c) {
                e.this.f14720b.a(e.this.f14721c);
            }
        }
    }

    public e(Context context, c.a aVar) {
        this.f14719a = context.getApplicationContext();
        this.f14720b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void o() {
        if (this.f14722d) {
            return;
        }
        this.f14721c = n(this.f14719a);
        this.f14719a.registerReceiver(this.f14723e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f14722d = true;
    }

    private void p() {
        if (this.f14722d) {
            this.f14719a.unregisterReceiver(this.f14723e);
            this.f14722d = false;
        }
    }

    @Override // com.bumptech.glide.manager.h
    public void g() {
        p();
    }

    @Override // com.bumptech.glide.manager.h
    public void k() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStart() {
        o();
    }
}
