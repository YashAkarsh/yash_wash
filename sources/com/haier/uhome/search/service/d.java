package com.haier.uhome.search.service;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.haier.uhome.mesh.api.MeshScannerManager;
import com.haier.uhome.mesh.api.callback.MeshScannerCallback;
import com.haier.uhome.search.service.entity.MeshDeviceUUIDInfo;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.uhome.search.service.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f29832f = 30000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MeshScannerManager f29833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.haier.uhome.search.a.f f29834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.haier.library.common.util.j<String, com.haier.uhome.search.a.c> f29835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.haier.uhome.search.a.d f29836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.haier.library.common.util.j<String, com.haier.uhome.search.service.entity.g> f29837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicBoolean f29838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AtomicBoolean f29839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AtomicBoolean f29840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AtomicBoolean f29841o;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static d f29848a = new d();

        private a() {
        }
    }

    public static d c() {
        return a.f29848a;
    }

    public ArrayList<com.haier.uhome.search.service.entity.g> d() {
        return new ArrayList<>(this.f29837k.values());
    }

    private d() {
        this.f29838l = new AtomicBoolean(false);
        this.f29840n = new AtomicBoolean(false);
        this.f29839m = new AtomicBoolean(false);
        this.f29841o = new AtomicBoolean(false);
        this.f29833g = MeshScannerManager.getInstance();
        this.f29835i = new com.haier.library.common.util.j<String, com.haier.uhome.search.a.c>() { // from class: com.haier.uhome.search.service.d.1
            @Override // com.haier.library.common.util.j
            public void a(String str, com.haier.uhome.search.a.c cVar) {
                d.this.c(cVar);
            }
        };
        this.f29837k = new com.haier.library.common.util.j<String, com.haier.uhome.search.service.entity.g>() { // from class: com.haier.uhome.search.service.d.2
            @Override // com.haier.library.common.util.j
            public void a(String str, com.haier.uhome.search.service.entity.g gVar) {
                d.this.b(gVar);
            }
        };
        this.f29833g.registerCallback(new MeshScannerCallback() { // from class: com.haier.uhome.search.service.d.3
            @Override // com.haier.uhome.mesh.api.callback.MeshScannerCallback
            public void onProxyDeviceFound(String str, String str2, int i7) {
                super.onProxyDeviceFound(str, str2, i7);
                e3.a.d("Mesh search: found device: %s, name: %s, rssi:%s", str, str2, Integer.valueOf(i7));
                com.haier.uhome.search.service.entity.g gVar = new com.haier.uhome.search.service.entity.g();
                gVar.a(str);
                gVar.a(i7);
                d.this.f29837k.a(str, gVar, d.f29832f);
                d.this.a(gVar);
            }

            @Override // com.haier.uhome.mesh.api.callback.MeshScannerCallback
            public void onUnProvDeviceFound(final String str, final String str2, byte[] bArr) {
                super.onUnProvDeviceFound(str, str2, bArr);
                e3.a.d("Mesh scan: found device: %s, uuid: %s", str, com.haier.library.common.util.c.a(bArr), new Object[0]);
                d.this.a(bArr, new ICallback<MeshDeviceUUIDInfo>() { // from class: com.haier.uhome.search.service.d.3.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(MeshDeviceUUIDInfo meshDeviceUUIDInfo) {
                        d.this.a(str2, str, meshDeviceUUIDInfo);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        e3.a.e("parserDeviceInfo error %s", usdkerror);
                    }
                });
            }
        });
        com.haier.uhome.usdk.base.c.b.a().a(new com.haier.uhome.usdk.base.c.c() { // from class: com.haier.uhome.search.service.t
            @Override // com.haier.uhome.usdk.base.c.c
            public final void notifyBtStateChanged(int i7) {
                this.f30031j.a(i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.haier.uhome.search.service.entity.g gVar) {
        com.haier.uhome.search.a.d dVar = this.f29836j;
        e3.a.d("notifyProxyDel %s, listener<%s>", gVar + "", dVar + "", new Object[0]);
        if (dVar == null) {
            return;
        }
        dVar.b(gVar);
    }

    private void d(final ICallback<Void> iCallback) {
        if (this.f29838l.get()) {
            a((ICallback) iCallback, ErrorConst.ERR_INTERNAL.toError());
        } else if (this.f29839m.get()) {
            this.f29833g.stopScanProv(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.search.service.r
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30027a.b(iCallback, errorConst);
                }
            });
        } else {
            a(iCallback, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void g(ICallback<Void> iCallback) {
        if (this.f29840n.get()) {
            a((ICallback) iCallback, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (!this.f29841o.get()) {
            a(iCallback, (Object) null);
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ErrorConst[] errorConstArr = {ErrorConst.ERR_USDK_TIMEOUT};
        e3.a.e("do stopControlSearch start", new Object[0]);
        this.f29833g.stopScanProxy(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.search.service.v
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                d.a(errorConstArr, countDownLatch, errorConst);
            }
        });
        try {
            e3.a.e("doStopControlSearch await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(5L, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("get excp %s !", e8);
            Thread.currentThread().interrupt();
        }
        e3.a.e("do stopControlSearch ret " + errorConstArr[0], new Object[0]);
        if (errorConstArr[0] == ErrorConst.RET_USDK_OK) {
            this.f29841o.set(false);
        }
        a(iCallback, errorConstArr[0]);
    }

    @Override // com.haier.uhome.search.service.a
    void c(com.haier.uhome.search.service.entity.b bVar) {
        super.c(bVar);
        com.haier.uhome.search.a.c cVar = this.f29835i.get(bVar.a());
        if (cVar != null) {
            boolean z7 = cVar.j(bVar.I()) || (cVar.a(bVar.i()) || (cVar.c(bVar.l()) || (cVar.d(bVar.f()) || (cVar.e(bVar.m()) || cVar.i(bVar.z())))));
            cVar.a(System.currentTimeMillis());
            this.f29835i.a(bVar.a(), cVar, 15500L);
            if (z7) {
                b(cVar);
                return;
            }
            return;
        }
        com.haier.uhome.search.a.c cVar2 = new com.haier.uhome.search.a.c();
        cVar2.c(bVar.c());
        cVar2.i(bVar.z());
        cVar2.e(bVar.m());
        cVar2.b(bVar.b());
        cVar2.a(bVar.a());
        cVar2.d(bVar.f());
        cVar2.c(bVar.l());
        cVar2.a(bVar.i());
        cVar2.i(bVar.t());
        cVar2.r(bVar.J());
        cVar2.j(bVar.I());
        this.f29835i.a(bVar.a(), cVar2, 15000L);
        a(cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized void h(ICallback<Void> iCallback) {
        if (!this.f29840n.get()) {
            a((ICallback) iCallback, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (this.f29841o.get()) {
            a(iCallback, (Object) null);
            return;
        }
        e3.a.e("do startControlSearch start ", new Object[0]);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ErrorConst[] errorConstArr = {ErrorConst.ERR_USDK_TIMEOUT};
        this.f29833g.scanProxy(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.search.service.u
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                d.b(errorConstArr, countDownLatch, errorConst);
            }
        });
        try {
            e3.a.e("doStartControlSearch await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(5L, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("get excp %s !", e8);
            Thread.currentThread().interrupt();
        }
        e3.a.e("do startControlSearch ret " + errorConstArr[0], new Object[0]);
        if (errorConstArr[0] == ErrorConst.RET_USDK_OK) {
            this.f29841o.set(true);
        }
        a(iCallback, errorConstArr[0]);
    }

    private void b(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.a.f fVar = this.f29834h;
        e3.a.d("notifyScannerUpdate %s, listener<%s>", cVar + "", fVar + "", new Object[0]);
        if (fVar == null) {
            return;
        }
        fVar.onDeviceUpdate(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i7) {
        if (i7 != 1 && i7 != 3) {
            b((com.haier.uhome.search.a.j<Void>) null);
            h(null);
        } else {
            d((ICallback<Void>) null);
            g(null);
        }
    }

    private void b(final com.haier.uhome.search.a.j<Void> jVar) {
        if (!this.f29838l.get()) {
            a((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        if (this.f29839m.get()) {
            a(jVar, (Object) null);
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("Mesh search: scanProv fail, ble is disable!", new Object[0]);
            com.haier.uhome.search.service.a.a(jVar, 16);
        }
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (!com.haier.library.common.util.f.D(contextB)) {
            e3.a.v("Mesh search: scanProv warning, location service disabled!", new Object[0]);
            com.haier.uhome.search.service.a.b(jVar, 16);
        }
        if (!com.haier.library.common.util.f.j(contextB, "android.permission.ACCESS_FINE_LOCATION")) {
            e3.a.v("Mesh search: scanProv warning, location permission is denied!", new Object[0]);
            com.haier.uhome.search.service.a.b(jVar, 16);
        }
        this.f29833g.scanProv(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.search.service.w
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30036a.a(jVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.uhome.search.service.entity.g gVar) {
        com.haier.uhome.search.a.d dVar = this.f29836j;
        e3.a.d("notifyProxyAdd %s, listener<%s>", gVar + "", dVar + "", new Object[0]);
        if (dVar == null) {
            return;
        }
        dVar.a(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, MeshDeviceUUIDInfo meshDeviceUUIDInfo) {
        if (meshDeviceUUIDInfo == null) {
            e3.a.v("fatal uuid", new Object[0]);
            return;
        }
        com.haier.uhome.search.service.entity.b bVar = new com.haier.uhome.search.service.entity.b();
        bVar.c(str);
        bVar.g(meshDeviceUUIDInfo.getTypeId());
        bVar.m(meshDeviceUUIDInfo.getDevUuid());
        bVar.b(str2);
        bVar.a(com.haier.uhome.usdk.base.utils.f.d(str2));
        bVar.d(meshDeviceUUIDInfo.getLongProductCode());
        bVar.j(5);
        bVar.f(32);
        bVar.n(32);
        bVar.u(com.haier.uhome.search.c.a.l(str));
        if (meshDeviceUUIDInfo.getSilence() == 0) {
            bVar.e(1);
        } else {
            bVar.e(2);
        }
        com.haier.uhome.usdk.base.utils.f.a aVarA = com.haier.uhome.usdk.base.utils.f.a(meshDeviceUUIDInfo.getTypeId());
        if (aVarA != null) {
            bVar.a(aVarA.a().b());
            bVar.b(aVarA.b());
        }
        c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ICallback iCallback, ErrorConst errorConst) {
        e3.a.e("stopConfigScan ret " + errorConst, new Object[0]);
        if (errorConst == ErrorConst.RET_USDK_OK) {
            this.f29839m.set(false);
        }
        a((ICallback<Void>) iCallback, errorConst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ErrorConst[] errorConstArr, CountDownLatch countDownLatch, ErrorConst errorConst) {
        errorConstArr[0] = errorConst;
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.a.f fVar = this.f29834h;
        e3.a.d("notifyScannerDel %s, listener<%s>", cVar + "", fVar + "", new Object[0]);
        if (fVar == null) {
            return;
        }
        fVar.onDeviceDel(cVar, 0);
    }

    public void b(final ICallback<Void> iCallback) {
        if (!this.f29840n.compareAndSet(false, true)) {
            a(iCallback, (Object) null);
        } else {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.search.service.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30029a.h(iCallback);
                }
            });
        }
    }

    public void c(final ICallback<Void> iCallback) {
        if (!this.f29840n.compareAndSet(true, false)) {
            a(iCallback, (Object) null);
        } else {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.search.service.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30038a.g(iCallback);
                }
            });
        }
    }

    private void a(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.a.f fVar = this.f29834h;
        e3.a.d("notifyScannerAdd %s, listener<%s>", cVar + "", fVar + "", new Object[0]);
        if (fVar == null) {
            return;
        }
        fVar.onDeviceAdd(cVar);
    }

    public void a(com.haier.uhome.search.a.f fVar) {
        this.f29834h = fVar;
    }

    public void a(com.haier.uhome.search.a.d dVar) {
        this.f29836j = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.search.a.j jVar, ErrorConst errorConst) {
        e3.a.e("startConfigScan ret " + errorConst, new Object[0]);
        if (errorConst == ErrorConst.RET_USDK_OK) {
            this.f29839m.set(true);
        }
        a((ICallback<Void>) jVar, errorConst);
    }

    public void a(com.haier.uhome.search.a.j<Void> jVar) {
        if (!this.f29838l.compareAndSet(false, true)) {
            a(jVar, (Object) null);
        } else {
            b(jVar);
        }
    }

    public void a(ICallback<Void> iCallback) {
        if (!this.f29838l.compareAndSet(true, false)) {
            a(iCallback, (Object) null);
        } else {
            d(iCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, ICallback<MeshDeviceUUIDInfo> iCallback) {
        if (iCallback == null) {
            return;
        }
        String strA = this.f29792e.a(bArr);
        e3.a.e("Mesh search: parser uuid is %s", strA);
        if (TextUtils.isEmpty(strA)) {
            e3.a.v("Mesh search: parse uuid error json is empty!", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        MeshDeviceUUIDInfo meshDeviceUUIDInfo = (MeshDeviceUUIDInfo) com.haier.library.json.a.z(strA, MeshDeviceUUIDInfo.class);
        if (meshDeviceUUIDInfo == null) {
            e3.a.v("Mesh search: parse MeshDeviceUUIDInfo is null!", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
            return;
        }
        meshDeviceUUIDInfo.decodeProperties();
        e3.a.e("Mesh search: parse mesh device UUID info = %s", meshDeviceUUIDInfo);
        com.haier.library.sumhttp.response.i iVarB = b(meshDeviceUUIDInfo.getProductCode());
        if (iVarB == null) {
            iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
            e3.a.v("Mesh parse ProductInfo is null!", new Object[0]);
        } else {
            meshDeviceUUIDInfo.setDevUuid(Base64.encodeToString(bArr, 2));
            meshDeviceUUIDInfo.setLongProductCode(iVarB.c());
            meshDeviceUUIDInfo.setTypeId(iVarB.d());
            iCallback.onSuccess(meshDeviceUUIDInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ErrorConst[] errorConstArr, CountDownLatch countDownLatch, ErrorConst errorConst) {
        errorConstArr[0] = errorConst;
        countDownLatch.countDown();
    }

    private void a(ICallback<Void> iCallback, ErrorConst errorConst) {
        if (errorConst == ErrorConst.RET_USDK_OK) {
            a(iCallback, (Object) null);
        } else {
            a((ICallback) iCallback, errorConst.toError());
        }
    }

    private <T> void a(ICallback<T> iCallback, T t7) {
        if (iCallback == null) {
            return;
        }
        iCallback.onSuccess(t7);
    }

    private void a(ICallback iCallback, uSDKError usdkerror) {
        if (iCallback == null) {
            return;
        }
        iCallback.onFailure(usdkerror);
    }
}
