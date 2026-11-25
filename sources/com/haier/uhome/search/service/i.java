package com.haier.uhome.search.service;

import android.database.ContentObserver;
import android.location.LocationManager;
import android.os.Looper;
import android.provider.Settings;
import c.h1;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class i extends ContentObserver implements com.haier.library.common.b.t, com.haier.uhome.search.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f29965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f29966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, com.haier.uhome.search.a.c> f29967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, com.haier.uhome.search.a.c> f29968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ScheduledFuture f29969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f29970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.uhome.search.a.f f29971g;

    /* JADX INFO: renamed from: com.haier.uhome.search.service.i$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f29987a;

        static {
            int[] iArr = new int[com.haier.uhome.search.service.entity.a.values().length];
            f29987a = iArr;
            try {
                iArr[com.haier.uhome.search.service.entity.a.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29987a[com.haier.uhome.search.service.entity.a.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29987a[com.haier.uhome.search.service.entity.a.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static abstract class a<V> implements com.haier.uhome.search.a.j<V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30000e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        CountDownLatch f30001f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        com.haier.uhome.search.a.i f30002g;

        a(com.haier.uhome.search.a.i iVar, CountDownLatch countDownLatch, int i7) {
            this.f30000e = i7;
            this.f30001f = countDownLatch;
            this.f30002g = iVar;
        }

        @Override // com.haier.uhome.search.a.j
        public void a(int i7) {
            com.haier.uhome.search.a.i iVar = this.f30002g;
            if (iVar != null) {
                if (i7 == 16) {
                    iVar.bluetoothDisable();
                } else if (i7 == 32) {
                    iVar.wifiDisable();
                }
            }
        }

        @Override // com.haier.uhome.search.a.j
        public void b(int i7) {
            com.haier.uhome.search.a.i iVar = this.f30002g;
            if (iVar != null) {
                if (i7 == 16) {
                    iVar.blePermissionInvalid();
                } else if (i7 == 32) {
                    iVar.wifiPermissionInvalid();
                }
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static i f30003a = new i();

        private b() {
        }
    }

    private void i() {
        p();
        r();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        o();
        q();
        s();
    }

    private void k() {
        a((com.haier.uhome.search.a.i) null, (List<uSDKError>) null, (CountDownLatch) null);
    }

    private void l() {
        a((List<uSDKError>) null, (CountDownLatch) null);
    }

    private void m() {
        b(null, null, null);
    }

    private void n() {
        b((List<uSDKError>) null, (CountDownLatch) null);
    }

    private void o() {
        c(null, null, null);
    }

    private void p() {
        c((List<uSDKError>) null, (CountDownLatch) null);
    }

    private void q() {
        d(null, null, null);
    }

    private void r() {
        d((List<uSDKError>) null, (CountDownLatch) null);
    }

    private void s() {
        e(null, null, null);
    }

    private uSDKError t() {
        uSDKError usdkerrorD = c.c().d();
        Object[] objArr = new Object[1];
        objArr[0] = uSDKError.RET_USDK_OK.a(usdkerrorD) ? "success" : "failure";
        e3.a.e("LAN Search stop %s", objArr);
        return usdkerrorD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.haier.library.common.b.h.a().b(com.haier.uhome.usdk.base.service.e.a().b(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.haier.library.common.b.h.a().d(com.haier.uhome.usdk.base.service.e.a().b(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.haier.uhome.usdk.base.service.e.a().b().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("location_providers_allowed"), true, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.haier.uhome.usdk.base.service.e.a().b().getContentResolver().unregisterContentObserver(this);
    }

    @Override // com.haier.library.common.b.t, com.haier.library.common.b.e
    public /* synthetic */ void a(com.haier.library.common.b.a aVar) {
        com.haier.library.common.b.s.a(this, aVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z7) {
        final LocationManager locationManager = (LocationManager) com.haier.uhome.usdk.base.service.e.a().b().getSystemService("location");
        ScheduledFuture scheduledFuture = this.f29969e;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.f29969e = com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.search.service.f0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29942a.b(locationManager);
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        } else {
            e3.a.v("Search: location state abort!", new Object[0]);
        }
    }

    @Override // com.haier.uhome.search.a.f
    public void onDeviceAdd(com.haier.uhome.search.a.c cVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceAdd device = %s", cVar.toString());
        a(cVar, com.haier.uhome.search.service.entity.a.ADD);
    }

    @Override // com.haier.uhome.search.a.f
    public void onDeviceDel(com.haier.uhome.search.a.c cVar, int i7) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "notifyDeviceRemove device = %s, channel %d reason = %d", cVar, Integer.valueOf(cVar.v()), Integer.valueOf(i7));
        if (a(cVar)) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "notifyDeviceRemove other channel hold so no need notify client!", new Object[0]);
        } else {
            a(cVar, com.haier.uhome.search.service.entity.a.DELETE);
        }
    }

    @Override // com.haier.uhome.search.a.f
    public void onDeviceUpdate(com.haier.uhome.search.a.c cVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceUpdate device = %s", cVar.toString());
        a(cVar, com.haier.uhome.search.service.entity.a.UPDATE);
    }

    private i() {
        super(null);
        this.f29965a = new AtomicBoolean(false);
        this.f29966b = new AtomicBoolean(false);
        this.f29967c = new ConcurrentHashMap();
        this.f29968d = new ConcurrentHashMap();
        this.f29970f = new AtomicBoolean();
        com.haier.uhome.search.service.b.c().a(this);
        g.c().a(this);
        d.c().a(this);
        k.c().a(this);
        c.c().a(this);
    }

    private synchronized void d(com.haier.uhome.search.a.c cVar, com.haier.uhome.search.service.entity.a aVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "sendDeviceChange %s device = %s", aVar, cVar);
        int i7 = AnonymousClass4.f29987a[aVar.ordinal()];
        if (i7 == 1) {
            this.f29968d.put(cVar.a(), cVar);
            this.f29971g.onDeviceAdd(cVar);
        } else if (i7 == 2) {
            this.f29968d.put(cVar.a(), cVar);
            this.f29971g.onDeviceUpdate(cVar);
        } else if (i7 == 3) {
            this.f29968d.remove(cVar.a());
            this.f29971g.onDeviceDel(cVar, 0);
        }
    }

    @h1
    private void e(com.haier.uhome.search.a.i iVar, final List<uSDKError> list, CountDownLatch countDownLatch) {
        c.c().a((String) null, new a<Void>(iVar, countDownLatch, 32) { // from class: com.haier.uhome.search.service.i.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(this.f30001f, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.e("LAN Search start success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(this.f30001f, (List<uSDKError>) list, usdkerror);
                e3.a.v("LAN Search start error %s", usdkerror);
            }
        });
    }

    private void g() {
        if (this.f29968d.isEmpty()) {
            e3.a.v("scanner device list is empty!", new Object[0]);
            return;
        }
        synchronized (this) {
            this.f29968d.clear();
            a(this.f29967c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst h() {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "stop scan ScanDevice", new Object[0]);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f("SEARCH", com.haier.uhome.search.a.f29683d, "checkConditions error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        if (!this.f29966b.get()) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "SDK is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        this.f29965a.set(false);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        b(copyOnWriteArrayList, countDownLatch);
        a(copyOnWriteArrayList, countDownLatch);
        c(copyOnWriteArrayList, countDownLatch);
        d(copyOnWriteArrayList, countDownLatch);
        copyOnWriteArrayList.add(t());
        try {
            e3.a.e("tryStopScan await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(5L, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("tryStopScan get excp %s ", e8);
            Thread.currentThread().interrupt();
        }
        uSDKError error = copyOnWriteArrayList.get(1);
        if (a(copyOnWriteArrayList) || error == null) {
            error = ErrorConst.RET_USDK_OK.toError();
        }
        Iterator it = new ArrayList(this.f29967c.keySet()).iterator();
        while (it.hasNext()) {
            a(this.f29967c.get((String) it.next()), com.haier.uhome.search.service.entity.a.DELETE);
        }
        com.haier.uhome.usdk.base.d.c.a().b(this);
        return ErrorConst.getErrorConstById(error.getCode());
    }

    public void b() {
        this.f29966b.set(true);
    }

    public void c() {
        this.f29966b.set(false);
    }

    public boolean f() {
        return this.f29966b.get();
    }

    private void b(com.haier.uhome.search.a.c cVar, com.haier.uhome.search.service.entity.a aVar) {
        if (cVar.c() == 3) {
            d(cVar, aVar);
        } else if (com.haier.library.common.util.c.l(cVar.g())) {
            d(cVar, aVar);
        } else {
            c(cVar, aVar);
        }
    }

    private void c(com.haier.uhome.search.a.c cVar, com.haier.uhome.search.service.entity.a aVar) {
        com.haier.uhome.usdk.base.utils.f.a aVarA;
        com.haier.uhome.search.service.a.a<com.haier.library.sumhttp.response.i> aVarZ = cVar.z();
        if (aVarZ == null) {
            synchronized (this) {
                com.haier.uhome.search.service.a.a.a aVar2 = new com.haier.uhome.search.service.a.a.a(cVar, aVar);
                cVar.a(aVar2);
                aVar2.a();
            }
            return;
        }
        if (aVarZ.c()) {
            e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "actuator is processing!", new Object[0]);
            return;
        }
        com.haier.library.sumhttp.response.i iVarD = aVarZ.d();
        if (iVarD != null) {
            cVar.d(iVarD.c());
            if (cVar.e() == null && com.haier.library.common.util.c.l(iVarD.d()) && (aVarA = com.haier.uhome.usdk.base.utils.f.a(iVarD.d())) != null) {
                cVar.a(aVarA.a());
                cVar.b(aVarA.b());
            }
            d(cVar, aVar);
        }
    }

    public boolean e() {
        return this.f29965a.get();
    }

    public static i a() {
        return b.f30003a;
    }

    private boolean a(com.haier.uhome.search.a.c cVar) {
        if (cVar.v() == 1) {
            return k.c().a(cVar.a()) || c.c().a(cVar.a());
        }
        if (cVar.v() == 2) {
            return com.haier.uhome.search.service.b.c().a(cVar.a()) || c.c().a(cVar.a());
        }
        if (cVar.v() == 3) {
            return com.haier.uhome.search.service.b.c().a(cVar.a()) || k.c().a(cVar.a());
        }
        return false;
    }

    private void b(com.haier.uhome.search.a.c cVar, com.haier.uhome.search.a.c cVar2) {
        cVar.b(cVar2.b());
        cVar.c(cVar2.d());
        cVar.a(cVar2.e());
        cVar.b(cVar2.f());
        cVar.d(cVar2.j());
        if (com.haier.library.common.util.c.l(cVar2.g())) {
            cVar.d(cVar2.g());
        }
        cVar.a(cVar2.c());
        cVar.h(cVar2.r());
        cVar.u(cVar2.I());
        cVar.j(cVar2.x());
        cVar.m(cVar2.A());
        cVar.s(cVar2.G());
        cVar.n(cVar2.B());
        cVar.p(cVar2.D());
        cVar.o(cVar2.C());
        cVar.l(cVar2.y());
        cVar.r(cVar2.F());
        cVar.t(cVar2.H());
    }

    private void d(com.haier.uhome.search.a.i iVar, final List<uSDKError> list, CountDownLatch countDownLatch) {
        k.c().a((com.haier.uhome.search.a.j<Void>) new a<Void>(iVar, countDownLatch, 32) { // from class: com.haier.uhome.search.service.i.12
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(this.f30001f, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "startSoftApSearch success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(this.f30001f, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "startSoftApSearch ret = %s", usdkerror);
            }
        });
    }

    private void d(final List<uSDKError> list, final CountDownLatch countDownLatch) {
        k.c().a(new ICallback<Void>() { // from class: com.haier.uhome.search.service.i.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(countDownLatch, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doSoftApStopScan success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(countDownLatch, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doSoftApStopScan ret = %s", usdkerror);
            }
        });
    }

    public List<com.haier.uhome.search.a.c> d() {
        return new ArrayList(this.f29968d.values());
    }

    private synchronized void a(com.haier.uhome.search.a.c cVar, com.haier.uhome.search.service.entity.a aVar) {
        try {
            if (cVar == null) {
                e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "mystery disappearance maybe concurrent delete!", new Object[0]);
                return;
            }
            com.haier.uhome.search.service.entity.a aVar2 = com.haier.uhome.search.service.entity.a.ADD;
            if (aVar != aVar2 && aVar != com.haier.uhome.search.service.entity.a.UPDATE) {
                com.haier.uhome.search.a.c cVarRemove = this.f29967c.remove(cVar.a());
                if (cVarRemove == null) {
                    e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "not found %s", cVar.a());
                } else {
                    b(cVarRemove);
                    d(cVarRemove, aVar);
                }
            } else {
                com.haier.uhome.search.a.c cVar2 = this.f29967c.get(cVar.a());
                if (cVar2 == null) {
                    this.f29967c.put(cVar.a(), cVar);
                    if (cVar.c() == 3) {
                        d(cVar, aVar);
                    } else {
                        if (com.haier.library.common.util.c.l(cVar.g())) {
                            d(cVar, aVar);
                            return;
                        }
                        c(cVar, aVar2);
                    }
                } else {
                    if (cVar2.c() == 1 && cVar.c() == 3) {
                        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "%s config status change from configurable to configured, remove roll actuator", cVar.a());
                        b(cVar2);
                        a(cVar2, cVar);
                        d(cVar2, com.haier.uhome.search.service.entity.a.UPDATE);
                        return;
                    }
                    if (cVar2.c() == 1 && cVar.c() == 2) {
                        if (com.haier.library.common.util.c.j(cVar2.g())) {
                            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "%s config status change from configurable to trigger, send remove msg to app", cVar.a());
                            d(cVar2, com.haier.uhome.search.service.entity.a.DELETE);
                            a(cVar2, cVar);
                            b(cVar2, com.haier.uhome.search.service.entity.a.UPDATE);
                        } else {
                            a(cVar2, cVar);
                            d(cVar2, com.haier.uhome.search.service.entity.a.UPDATE);
                        }
                        return;
                    }
                    if (cVar2.c() == 2 && cVar.c() == 1) {
                        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "%s config status change from trigger to configurable!", cVar.a());
                        if (com.haier.library.common.util.c.j(cVar2.g())) {
                            a(cVar2, cVar);
                            com.haier.uhome.search.service.a.a<com.haier.library.sumhttp.response.i> aVarZ = cVar2.z();
                            if (aVarZ == null) {
                                c(cVar2, aVar);
                                return;
                            } else if (!aVarZ.c()) {
                                d(cVar2, aVar2);
                            }
                        } else {
                            a(cVar2, cVar);
                            d(cVar2, com.haier.uhome.search.service.entity.a.UPDATE);
                        }
                        return;
                    }
                    if (cVar2.c() == 3 && cVar.c() == 1) {
                        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "%s config status change from configured to configurable!", cVar.a());
                        if (com.haier.library.common.util.c.j(cVar2.g())) {
                            a(cVar2, cVar);
                            c(cVar2, aVar);
                        } else {
                            a(cVar2, cVar);
                            d(cVar2, com.haier.uhome.search.service.entity.a.UPDATE);
                        }
                        return;
                    }
                    a(cVar2, cVar);
                    b(cVar2, com.haier.uhome.search.service.entity.a.UPDATE);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c(com.haier.uhome.search.a.i iVar, final List<uSDKError> list, CountDownLatch countDownLatch) {
        g.c().a((com.haier.uhome.search.a.j<Void>) new a<Void>(iVar, countDownLatch, 32) { // from class: com.haier.uhome.search.service.i.10
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(this.f30001f, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "startConfigScan success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(this.f30001f, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "startConfigScan ret = %s", usdkerror);
            }
        });
    }

    private void c(final List<uSDKError> list, final CountDownLatch countDownLatch) {
        g.c().a(new ICallback<Void>() { // from class: com.haier.uhome.search.service.i.11
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(countDownLatch, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "stopConfigScan success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(countDownLatch, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "stopConfigScan ret = %s", usdkerror);
            }
        });
    }

    private void b(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.service.a.a<com.haier.library.sumhttp.response.i> aVarZ = cVar.z();
        if (aVarZ == null || !aVarZ.c()) {
            return;
        }
        synchronized (this) {
            aVarZ.b();
            cVar.a((com.haier.uhome.search.service.a.a<com.haier.library.sumhttp.response.i>) null);
        }
    }

    private void b(com.haier.uhome.search.a.i iVar, final List<uSDKError> list, CountDownLatch countDownLatch) {
        d.c().a((com.haier.uhome.search.a.j<Void>) new a<Void>(iVar, countDownLatch, 16) { // from class: com.haier.uhome.search.service.i.8
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(this.f30001f, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doMeshStartScan success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(this.f30001f, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doMeshStartScan ret = %s", usdkerror);
            }
        });
    }

    private void b(final List<uSDKError> list, final CountDownLatch countDownLatch) {
        d.c().a(new ICallback<Void>() { // from class: com.haier.uhome.search.service.i.9
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(countDownLatch, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doMeshStopScan success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(countDownLatch, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doMeshStopScan ret = %s", usdkerror);
            }
        });
    }

    private void a(com.haier.uhome.search.a.c cVar, com.haier.uhome.search.a.c cVar2) {
        if (cVar.v() == 1) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "raise config type to %d", Integer.valueOf(cVar.i()));
            if (cVar2.v() == 1) {
                b(cVar, cVar2);
                return;
            }
            return;
        }
        if (cVar2.v() == 1) {
            if (cVar.i() != cVar2.i()) {
                cVar.c(cVar2.i());
                cVar.i(1);
            }
            b(cVar, cVar2);
            return;
        }
        if (cVar.i() != cVar2.i()) {
            cVar.c(cVar2.i());
        }
        b(cVar, cVar2);
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.search.service.entity.f fVar) {
        d(fVar.b(), fVar.a());
    }

    private void a(Map<String, com.haier.uhome.search.a.c> map) {
        if (map.isEmpty()) {
            e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "scanner device list is empty!", new Object[0]);
            return;
        }
        Iterator<com.haier.uhome.search.a.c> it = map.values().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        map.clear();
    }

    public void a(final com.haier.uhome.search.a.i iVar, final com.haier.uhome.usdk.base.api.o oVar) {
        new com.haier.library.common.thread.m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.search.service.i.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ErrorConst doInBackground(Void... voidArr) {
                return i.this.a(iVar);
            }

            @Override // com.haier.library.common.thread.m
            protected void onPreExecute() {
                i.this.f29970f.set(com.haier.library.common.util.f.D(com.haier.uhome.usdk.base.service.e.a().b()));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(ErrorConst errorConst) {
                i.this.u();
                i.this.w();
                com.haier.uhome.usdk.base.api.o oVar2 = oVar;
                if (oVar2 != null) {
                    oVar2.onCallback(errorConst);
                } else {
                    e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "startScan callback is null,so give up callback", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst a(com.haier.uhome.search.a.i iVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f("SEARCH", com.haier.uhome.search.a.f29683d, "checkConditions error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        if (!this.f29966b.get()) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "SDK is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        synchronized (this) {
            if (this.f29965a.get()) {
                return ErrorConst.ERR_USDK_DEVICE_SCANNING;
            }
            this.f29965a.set(true);
            g();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            CountDownLatch countDownLatch = new CountDownLatch(5);
            a(iVar, copyOnWriteArrayList, countDownLatch);
            b(iVar, copyOnWriteArrayList, countDownLatch);
            c(iVar, copyOnWriteArrayList, countDownLatch);
            d(iVar, copyOnWriteArrayList, countDownLatch);
            e(iVar, copyOnWriteArrayList, countDownLatch);
            try {
                e3.a.e("tryStartScan await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(5L, TimeUnit.SECONDS)));
            } catch (InterruptedException e8) {
                e3.a.g("tryStartScan get excp %s ", e8);
                Thread.currentThread().interrupt();
            }
            uSDKError error = copyOnWriteArrayList.get(0);
            if (a(copyOnWriteArrayList) || error == null) {
                error = ErrorConst.RET_USDK_OK.toError();
            }
            com.haier.uhome.usdk.base.d.c.a().a(this);
            return ErrorConst.getErrorConstById(error.getCode());
        }
    }

    private boolean a(List<uSDKError> list) {
        Iterator<uSDKError> it = list.iterator();
        while (it.hasNext()) {
            if (uSDKError.RET_USDK_OK.a(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void a(final com.haier.uhome.usdk.base.api.o oVar) {
        new com.haier.library.common.thread.m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.search.service.i.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ErrorConst doInBackground(Void... voidArr) {
                return i.this.h();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(ErrorConst errorConst) {
                i.this.v();
                i.this.x();
                com.haier.uhome.usdk.base.api.o oVar2 = oVar;
                if (oVar2 != null) {
                    oVar2.onCallback(errorConst);
                } else {
                    e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "stopScan callback is null,so give up callback", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.library.common.b.e
    public void a(com.haier.library.common.b.r rVar) {
        e3.a.e("Search: wifi state change %s", rVar);
        if (this.f29965a.get()) {
            if (rVar == com.haier.library.common.b.r.STATE_DISABLED) {
                i();
            } else if (rVar == com.haier.library.common.b.r.STATE_ENABLED) {
                com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.search.service.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29948a.j();
                    }
                }, 200L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(LocationManager locationManager) {
        if (locationManager == null) {
            e3.a.v("startOrStopByLocationService but LocationManager is null", new Object[0]);
            return;
        }
        boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
        e3.a.e("Search: location state change %s", Boolean.valueOf(zIsProviderEnabled));
        if (this.f29965a.get()) {
            if (zIsProviderEnabled) {
                k();
                m();
                o();
                q();
                return;
            }
            l();
            n();
            p();
            r();
        }
    }

    private void a(com.haier.uhome.search.a.i iVar, final List<uSDKError> list, CountDownLatch countDownLatch) {
        com.haier.uhome.search.service.b.c().a((com.haier.uhome.search.a.j<Void>) new a<Void>(iVar, countDownLatch, 16) { // from class: com.haier.uhome.search.service.i.6
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(this.f30001f, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doBleStartScan success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(this.f30001f, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doBleStartScan ret = %s", usdkerror);
            }
        });
    }

    private void a(final List<uSDKError> list, final CountDownLatch countDownLatch) {
        com.haier.uhome.search.service.b.c().a(new ICallback<Void>() { // from class: com.haier.uhome.search.service.i.7
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                i.this.a(countDownLatch, (List<uSDKError>) list, uSDKError.RET_USDK_OK);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doBleStopScan success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                i.this.a(countDownLatch, (List<uSDKError>) list, usdkerror);
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "doBleStopScan ret = %s", usdkerror);
            }
        });
    }

    public void a(com.haier.uhome.search.a.f fVar) {
        this.f29971g = (com.haier.uhome.search.a.f) com.haier.uhome.usdk.base.utils.b.a(fVar, (Class<?>) com.haier.uhome.search.a.f.class);
    }

    public com.haier.uhome.search.a.c a(String str) {
        return this.f29968d.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CountDownLatch countDownLatch, List<uSDKError> list, uSDKError usdkerror) {
        if (list != null) {
            list.add(usdkerror);
        }
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void a(boolean z7) {
        k.c().a(z7);
    }
}
