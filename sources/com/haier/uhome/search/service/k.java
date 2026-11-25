package com.haier.uhome.search.service;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class k extends com.haier.uhome.search.service.a implements com.haier.uhome.search.a.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.library.common.util.j<String, com.haier.uhome.search.a.c> f30008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.uhome.search.a.f f30009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WifiManager f30010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile l f30011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile ScheduledFuture<?> f30012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f30013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicInteger f30014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f30015m;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static k f30017a = new k();

        private a() {
        }
    }

    private void b(com.haier.uhome.search.a.c cVar) {
        e3.a.e("SoftAp search: sendConfigDeviceUpdate %s", cVar);
        com.haier.uhome.search.a.f fVar = this.f30009g;
        if (fVar == null || cVar == null) {
            return;
        }
        fVar.onDeviceUpdate(cVar.clone());
    }

    public static k c() {
        return a.f30017a;
    }

    private WifiManager d() {
        WifiManager wifiManager = this.f30010h;
        if (wifiManager != null) {
            return wifiManager;
        }
        try {
            this.f30010h = (WifiManager) com.haier.uhome.usdk.base.service.e.a().b().getSystemService("wifi");
        } catch (Exception e8) {
            e3.a.g("Obtain system service WifiManager error!", e8);
        }
        return this.f30010h;
    }

    private synchronized void f() {
        if (this.f30012j == null) {
            this.f30012j = e();
        } else {
            if (this.f30012j.isCancelled()) {
                this.f30012j = e();
            }
        }
    }

    private synchronized void g() {
        if (this.f30012j != null && !this.f30012j.isCancelled()) {
            this.f30012j.cancel(true);
            this.f30012j = null;
            e3.a.e("SoftAp search: stop scan result: true", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        WifiManager wifiManager = this.f30010h;
        if (wifiManager != null) {
            e3.a.e("SoftAp search: start scan result: %s", Boolean.valueOf(wifiManager.startScan()));
        }
    }

    private k() {
        this.f30013k = new AtomicBoolean(false);
        d();
        this.f30014l = new AtomicInteger(0);
        this.f30008f = new com.haier.library.common.util.j<String, com.haier.uhome.search.a.c>() { // from class: com.haier.uhome.search.service.k.1
            @Override // com.haier.library.common.util.j
            public void a(String str, com.haier.uhome.search.a.c cVar) {
            }

            @Override // com.haier.library.common.util.j
            public void b(String str, com.haier.uhome.search.a.c cVar) {
                if (cVar != null) {
                    k.this.e(cVar.a(), 10);
                }
            }
        };
    }

    private ScheduledFuture e() {
        return com.haier.library.common.thread.m.scheduleWithFixedDelayToFuture(new Runnable() { // from class: com.haier.uhome.search.service.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30004a.h();
            }
        }, 0L, 30L, TimeUnit.SECONDS);
    }

    void a(com.haier.uhome.search.a.f fVar) {
        this.f30009g = fVar;
    }

    @Override // com.haier.uhome.search.service.a
    void c(com.haier.uhome.search.service.entity.b bVar) {
        super.c(bVar);
        com.haier.uhome.search.a.c cVar = this.f30008f.get(bVar.a());
        if (cVar != null) {
            cVar.a(bVar.a());
            cVar.a(System.currentTimeMillis());
            cVar.t(bVar.p());
            cVar.i(bVar.t());
            boolean z7 = cVar.j(bVar.I()) || (cVar.a(bVar.i()) || (cVar.c(bVar.c()) || cVar.c(bVar.l())));
            this.f30008f.a(bVar.a(), cVar, 15000L, 500L);
            if (z7) {
                b(cVar);
                return;
            }
            return;
        }
        com.haier.uhome.search.a.c cVar2 = new com.haier.uhome.search.a.c();
        cVar2.c(bVar.c());
        cVar2.a(bVar.a());
        cVar2.c(bVar.l());
        cVar2.a(bVar.i());
        cVar2.i(bVar.t());
        cVar2.t(bVar.p());
        cVar2.j(bVar.I());
        cVar2.m(bVar.B());
        cVar2.s(bVar.C());
        cVar2.n(bVar.E());
        cVar2.p(bVar.F());
        cVar2.o(bVar.G());
        cVar2.l(bVar.H());
        cVar2.r(bVar.J());
        this.f30008f.a(bVar.a(), cVar2, 15000L, 500L);
        a(cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, int i7) {
        if (str == null) {
            e3.a.v("SoftAp search: handleConfigDeviceDel with null deviceId", new Object[0]);
            return;
        }
        e3.a.e("SoftAp search: handleConfigDeviceDel %s", str);
        com.haier.uhome.search.a.c cVar = this.f30008f.get(str);
        if (cVar != null) {
            this.f30008f.remove(str);
            com.haier.uhome.search.a.f fVar = this.f30009g;
            if (fVar != null) {
                fVar.onDeviceDel(cVar.clone(), i7);
            }
        }
    }

    public void a(com.haier.uhome.search.a.j<Void> jVar) {
        this.f30014l.getAndIncrement();
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            com.haier.uhome.usdk.base.utils.b.b((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (!com.haier.library.common.util.w.m(contextB)) {
            e3.a.v("SoftAp search: wifi disable!", new Object[0]);
            com.haier.uhome.search.service.a.a(jVar, 32);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (!com.haier.library.common.util.f.D(contextB)) {
            e3.a.v("SoftAp search: location service disabled!", new Object[0]);
            com.haier.uhome.search.service.a.b(jVar, 32);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (!com.haier.library.common.util.f.j(contextB, "android.permission.ACCESS_COARSE_LOCATION") || !com.haier.library.common.util.f.j(contextB, "android.permission.ACCESS_FINE_LOCATION")) {
            e3.a.v("SoftAp search: location permission denied!", new Object[0]);
            com.haier.uhome.search.service.a.b(jVar, 32);
        }
        if (d() == null) {
            com.haier.uhome.usdk.base.utils.b.b((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (this.f30013k.get()) {
            com.haier.uhome.usdk.base.utils.b.b(jVar, (Object) null);
        } else if (this.f30011i == null) {
            synchronized (this) {
                if (this.f30011i == null) {
                    this.f30011i = a(contextB, jVar, this.f30010h);
                }
            }
        }
    }

    private l a(Context context, com.haier.uhome.search.a.j<Void> jVar, WifiManager wifiManager) {
        l lVar = new l(wifiManager);
        com.haier.uhome.usdk.base.d.c.a().a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        context.registerReceiver(lVar, intentFilter);
        this.f30013k.set(true);
        com.haier.uhome.usdk.base.utils.b.b(jVar, (Object) null);
        return lVar;
    }

    @Override // com.haier.uhome.search.service.a
    protected void c(String str, int i7) {
        if (str == null) {
            e3.a.h("LANSearchService handleConfigDeviceDel with null deviceId", new Object[0]);
        } else if (i7 == 7) {
            e(str, i7);
        }
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.search.service.entity.h hVar) {
        List<ScanResult> listB = hVar.b();
        e3.a.e("SoftAp search: try split scan result<%d> once", Integer.valueOf(listB.size()));
        for (ScanResult scanResult : listB) {
            if (scanResult.SSID.startsWith(com.haier.uhome.usdk.base.a.T) || scanResult.SSID.startsWith(com.haier.uhome.usdk.base.a.U) || scanResult.SSID.startsWith(com.haier.uhome.usdk.base.a.V)) {
                e3.a.d("SoftAp search: softApSplitData: scanResult ssid = %s, bssid = %s", scanResult.SSID, scanResult.BSSID, new Object[0]);
                a(scanResult.SSID, scanResult.BSSID);
            }
        }
    }

    public void a(ICallback<Void> iCallback) {
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (this.f30014l.decrementAndGet() > 0) {
            e3.a.e("SoftAp search: stopSoftApSearch but referenceCount = %d so return", Integer.valueOf(this.f30014l.get()));
            return;
        }
        if (!this.f30013k.get()) {
            com.haier.uhome.usdk.base.utils.b.b(iCallback, (Object) null);
            return;
        }
        if (this.f30011i == null) {
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        synchronized (this) {
            contextB.unregisterReceiver(this.f30011i);
            this.f30013k.set(false);
            com.haier.uhome.usdk.base.utils.b.b(iCallback, (Object) null);
            com.haier.uhome.usdk.base.d.c.a().b(this);
            this.f30011i = null;
            g();
            this.f30008f.clear();
        }
    }

    private void a(String str, String str2) {
        String strC = com.haier.library.common.util.w.c(str2);
        com.haier.uhome.search.service.entity.b bVar = new com.haier.uhome.search.service.entity.b();
        if (!com.haier.uhome.search.c.a.a(str, bVar)) {
            e3.a.v("SoftAp search: ssid: %s not match any patterns", str);
            return;
        }
        String strA = com.haier.uhome.search.c.a.a(str);
        if (com.haier.library.common.util.c.l(strA) && !strC.endsWith(strA)) {
            com.haier.uhome.search.a.c cVarD = b.c().d(strA);
            strC = (cVarD == null || com.haier.library.common.util.c.c(strC, cVarD.a())) ? com.haier.uhome.search.c.a.a(strC, strA) : cVarD.a();
        }
        bVar.a(strC);
        bVar.i(str);
        bVar.f(strC);
        bVar.j(2);
        bVar.e(1);
        bVar.u(com.haier.uhome.search.c.a.l(str));
        c(bVar);
    }

    private void a(com.haier.uhome.search.a.c cVar) {
        e3.a.e("SoftAp search: sendConfigDeviceAdd %s", cVar);
        com.haier.uhome.search.a.f fVar = this.f30009g;
        if (fVar == null || cVar == null) {
            return;
        }
        fVar.onDeviceAdd(cVar.clone());
    }

    @Override // com.haier.uhome.search.a.b
    public boolean a(String str) {
        return this.f30008f.containsKey(str);
    }

    synchronized void a(boolean z7) {
        if (this.f30015m && !z7) {
            g();
        }
        if (!this.f30015m && z7) {
            f();
        }
        this.f30015m = z7;
    }
}
