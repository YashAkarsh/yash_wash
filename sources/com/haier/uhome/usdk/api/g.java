package com.haier.uhome.usdk.api;

import android.util.Base64;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import com.haier.uhome.mesh.bridge.IdentityCallback;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.haier.uhome.mesh.bridge.RtkScannerWrapper;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class g extends com.haier.library.common.util.m implements com.haier.uhome.control.local.api.e, com.haier.uhome.search.a.m, com.haier.uhome.usdk.api.interfaces.a, com.haier.uhome.usdk.base.c.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f30531f = 480;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f30532g = 60;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f30533h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f30534i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f30535j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30536k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f30537l = 123;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f30538m = 121;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f30539n = 124;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f30540o = 10;
    private volatile boolean C;
    private com.haier.library.common.util.b0 D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.haier.uhome.control.local.api.a f30541p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ICallback<Void> f30542q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ICallback<FOTAInfo> f30543r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile com.haier.uhome.control.local.b.b f30544s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.haier.uhome.control.local.b.c f30545t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f30547v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f30548w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MeshNetKey f30549x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f30550y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f30551z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicBoolean f30546u = new AtomicBoolean();
    private int A = -1;
    private final AtomicBoolean B = new AtomicBoolean();
    private final Set<FOTAStatusInfo> E = new HashSet();

    g(com.haier.uhome.control.local.api.a aVar) {
        this.f30541p = aVar;
        g();
        this.f30551z = uSDKDeviceManager.getSingleInstance().b();
    }

    private ErrorConst A() {
        if (!uSDKManager.getSingleInstance().a()) {
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("bluetooth not Enabled or not support ble", new Object[0]);
            return ErrorConst.ERR_USDK_BLE_NOT_OPEN;
        }
        com.haier.uhome.control.local.api.a aVar = this.f30541p;
        if (aVar == null) {
            return ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL;
        }
        return (aVar.getClass() == com.haier.uhome.control.local.api.d.class && this.f30549x == null) ? ErrorConst.ERR_INTERNAL : ErrorConst.RET_USDK_OK;
    }

    private void q() {
        if (this.f30541p.getClass() == com.haier.uhome.control.local.api.d.class) {
            com.haier.library.common.util.a0.a(10L, TimeUnit.SECONDS, new Runnable() { // from class: com.haier.uhome.usdk.api.g1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30558a.s();
                }
            });
        } else {
            com.haier.uhome.search.a.n.a().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f30547v != 1) {
            e3.a.v("Ota stage: current otaStage: %d are not defined", new Object[0]);
            return;
        }
        this.B.set(true);
        this.f30551z.b();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f30547v == 2 && this.A == 3) {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        ICallback<Void> iCallback = this.f30542q;
        if (iCallback != null) {
            iCallback.onSuccess(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.f30541p.a(new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.api.i1
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                g.b(usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f30550y = 0;
        this.f30546u.set(false);
        d();
        this.B.set(false);
        this.f30551z.a(false);
        if (this.f30547v == 2) {
            w();
        }
        com.haier.uhome.control.local.a.e.a().b(this);
        com.haier.uhome.search.a.n.a().b(this);
        com.haier.uhome.usdk.base.c.b.a().b(this);
        RtkScannerWrapper.getInstance().removeIdentityCallback();
        this.f30547v = -1;
        this.A = -1;
        this.C = false;
    }

    private void w() {
        y();
        com.haier.uhome.ble.hal.a.b.a.a().a(false);
    }

    private void x() {
        z();
        com.haier.uhome.ble.hal.a.b.a.a().a(true);
    }

    private void y() {
        this.f30551z.c();
    }

    private void z() {
        this.f30551z.b();
    }

    @Override // com.haier.uhome.search.a.g
    public /* synthetic */ void a(com.haier.uhome.search.service.entity.d dVar) {
        com.haier.uhome.search.a.p.a(this, dVar);
    }

    @Override // com.haier.uhome.usdk.base.c.c
    public void notifyBtStateChanged(int i7) {
        e3.a.e("Ota stage: ble state = %d changed!", Integer.valueOf(i7));
        if (i7 == 1) {
            a(this.f30541p.X(), this.f30545t.d(), f30539n);
            v();
            u();
        }
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceAdd(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (c()) {
            e3.a.v("Ota stage: find ble device: %s add but already timeout!", fVar.b());
        } else if (com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(str) && fVar.b().equals(this.f30541p.X())) {
            o();
        }
    }

    @Override // com.haier.uhome.search.a.m, com.haier.uhome.search.a.g
    public /* synthetic */ void onDeviceDel(String str, com.haier.uhome.usdk.base.api.f fVar, int i7) {
        com.haier.uhome.search.a.q.a(this, str, fVar, i7);
    }

    @Override // com.haier.uhome.search.a.m, com.haier.uhome.search.a.g
    public /* synthetic */ void onDeviceUpdate(String str, com.haier.uhome.usdk.base.api.f fVar) {
        com.haier.uhome.search.a.q.b(this, str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(uSDKError usdkerror) {
        if (c()) {
            e3.a.v("Ota stage: start ota resp already timeout!", new Object[0]);
            return;
        }
        if (this.f30550y > 1) {
            e3.a.e("Ota stage: start ota resp fragment no care!", new Object[0]);
            return;
        }
        if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.control.local.a.e.a().a(this);
        } else if (!usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            a(usdkerror);
        } else {
            p();
            e3.a.v("Ota stage: start ota resp error %s", usdkerror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(uSDKError usdkerror) {
        e3.a.e("Ble ota: set cfg node identify result: %s", usdkerror);
        y();
        i();
        this.C = true;
    }

    private void g() {
        com.haier.uhome.control.local.api.a aVar = this.f30541p;
        if (aVar == null) {
            e3.a.v("Ble ota: local ble device null!", new Object[0]);
            return;
        }
        if (aVar.getClass() == com.haier.uhome.control.local.api.g.class) {
            e3.a.v("Ble ota: local ble device no need appKey!", new Object[0]);
            return;
        }
        com.haier.uhome.control.base.a.c cVarI = uSDKDeviceManager.getSingleInstance().i();
        if (cVarI == null) {
            uSDKDeviceManager.getSingleInstance().a(new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.g.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    com.haier.uhome.control.base.a.c cVarI2 = uSDKDeviceManager.getSingleInstance().i();
                    g.this.f30548w = Base64.encodeToString(cVarI2.c().getData(), 2);
                    g.this.f30549x = cVarI2.b();
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    e3.a.v("Ble ota: mesh device net info obtain error %s !", usdkerror);
                }
            }, 5);
        } else {
            this.f30548w = Base64.encodeToString(cVarI.c().getData(), 2);
            this.f30549x = cVarI.b();
        }
    }

    private void h() {
        if (this.f30541p.getClass() == com.haier.uhome.control.local.api.d.class) {
            com.haier.uhome.control.local.api.d dVar = (com.haier.uhome.control.local.api.d) this.f30541p;
            this.f30551z.a(true);
            if (dVar != com.haier.uhome.control.local.d.f.a().d()) {
                this.f30551z.a(true);
                this.B.set(false);
                a(dVar);
            } else {
                j();
            }
        } else {
            j();
        }
        com.haier.uhome.usdk.base.c.b.a().a(this);
    }

    private void i() {
        RtkScannerWrapper.getInstance().registerIdentityCallback(new IdentityCallback() { // from class: com.haier.uhome.usdk.api.k1
            @Override // com.haier.uhome.mesh.bridge.IdentityCallback
            public final void onIdentityDeviceFound(String str, byte[] bArr, byte[] bArr2) {
                this.f30607a.a(str, bArr, bArr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f30541p.a(30, new ICallback<FOTAInfo>() { // from class: com.haier.uhome.usdk.api.g.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(FOTAInfo fOTAInfo) {
                if (g.this.c()) {
                    e3.a.v("Ble ota: check ota info success but already timeout!", new Object[0]);
                    return;
                }
                g.this.f30544s = new com.haier.uhome.control.local.b.b(fOTAInfo);
                if (fOTAInfo.isNeedFOTA()) {
                    g.this.a(fOTAInfo.a());
                } else {
                    g.this.f30543r.onSuccess(fOTAInfo);
                    g.this.v();
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                if (g.this.c()) {
                    e3.a.v("Ble ota: check ota info failure but already timeout!", new Object[0]);
                } else if (usdkerror.getFailureReason().equals(String.valueOf(-40004))) {
                    g.this.j();
                } else {
                    g.this.f30543r.onFailure(usdkerror);
                    g.this.v();
                }
            }
        });
    }

    private void k() {
        DeviceStatus deviceStatusN = this.f30541p.n();
        if (deviceStatusN == DeviceStatus.STATUS_CONNECTED || deviceStatusN == DeviceStatus.STATUS_READY) {
            if (this.f30541p.getClass() == com.haier.uhome.control.local.api.d.class) {
                l();
            } else {
                n();
            }
        } else if (this.f30541p.getClass() == com.haier.uhome.control.local.api.d.class) {
            m();
        } else {
            o();
        }
        com.haier.uhome.usdk.base.c.b.a().a(this);
    }

    private void l() {
        this.f30551z.a(true);
        RtkCoreMeshWrapper.getInstance().closeConnect();
        m();
    }

    private void m() {
        b(this.f30548w);
    }

    private void n() {
        this.f30541p.a(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.j1
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30592a.b(errorConst);
            }
        });
    }

    private void o() {
        b("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.haier.uhome.control.local.b.a aVar = new com.haier.uhome.control.local.b.a();
        if (this.f30545t.c() == 1) {
            aVar.a(this.f30545t.d());
        } else {
            aVar.a(0);
        }
        aVar.e(this.f30545t.i());
        aVar.c(this.f30544s.a().getAbsolutePath());
        aVar.f(this.f30544s.m());
        aVar.g(this.f30544s.l());
        aVar.b(this.f30544s.m().length());
        aVar.c(this.f30545t.c());
        aVar.d(((com.haier.uhome.control.local.api.d) this.f30541p).d());
        this.f30541p.a(aVar, new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.api.h1
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                this.f30573a.c(usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void b(ICallback<Void> iCallback) {
        ErrorConst errorConstA = A();
        if (errorConstA != ErrorConst.RET_USDK_OK) {
            a(iCallback, errorConstA);
            return;
        }
        if (this.f30544s == null) {
            a(iCallback, ErrorConst.ERR_USDK_FOTA_INFO_IS_NULL);
            return;
        }
        if (!this.f30544s.b()) {
            a(iCallback, ErrorConst.ERR_USDK_DONT_NEED_FOTA);
            return;
        }
        if (this.f30546u.get()) {
            a(iCallback, ErrorConst.ERR_USDK_MODULE_IS_OTAING);
            return;
        }
        if (this.f30546u.compareAndSet(false, true)) {
            this.f30547v = 2;
            this.f30542q = iCallback;
            a(480L, TimeUnit.SECONDS);
            f();
            x();
            k();
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void f() {
        this.E.clear();
    }

    private void c(String str, int i7, int i8, int i9) {
        if (this.f30541p.X().equals(str)) {
            this.f30541p.a(String.valueOf(i7), i8, i9);
        } else {
            e3.a.v("Ota stage: device id are not the same, deviceId = %s", str);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void a(com.haier.uhome.control.local.api.a aVar) {
        this.f30541p = aVar;
        g();
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void a(ICallback<FOTAInfo> iCallback) {
        ErrorConst errorConstA = A();
        if (errorConstA != ErrorConst.RET_USDK_OK) {
            iCallback.onFailure(errorConstA.toError());
            return;
        }
        if (b()) {
            e3.a.e("Ble ota: device is checking!", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_IS_BUSY.toError());
        } else if (this.f30546u.compareAndSet(false, true)) {
            if (this.f30544s != null) {
                this.f30544s = null;
            }
            this.f30547v = 1;
            this.f30543r = iCallback;
            f();
            a(60L, TimeUnit.SECONDS);
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ErrorConst errorConst) {
        if (c()) {
            e3.a.v("Ble ota: disconnect ble device already timeout!", new Object[0]);
            return;
        }
        if (errorConst == ErrorConst.RET_USDK_OK) {
            o();
        } else if (errorConst == ErrorConst.ERR_USDK_TIMEOUT) {
            n();
        } else {
            a(errorConst);
            e3.a.v("Ble ota: disconnect ble device error: %s", errorConst);
        }
    }

    private void b(final String str) {
        this.f30550y++;
        this.f30541p.b(str, new ICallback<com.haier.uhome.control.local.b.c>() { // from class: com.haier.uhome.usdk.api.g.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.control.local.b.c cVar) {
                boolean z7 = true;
                e3.a.e("Ota stage: Get ota info: %s", cVar);
                if (g.this.c()) {
                    e3.a.v("Ota stage: get ota info success but already timeout!", new Object[0]);
                    return;
                }
                if (cVar.b() == 0) {
                    g.this.a(ErrorConst.ERR_USDK_DEVICE_NOT_IN_OTA_MODE);
                    return;
                }
                if (g.this.f30550y <= 1) {
                    g.this.t();
                }
                if (cVar.c() != 1 && g.this.f30550y <= 1) {
                    z7 = false;
                }
                if (z7 && g.this.f30544s.e().equals(cVar.h())) {
                    g gVar = g.this;
                    gVar.a(gVar.f30541p.X(), cVar.d(), 0);
                    g.this.v();
                    g.this.u();
                    return;
                }
                if (g.this.f30544s.d().compareTo(cVar.h()) < 0) {
                    g.this.a(ErrorConst.ERR_USDK_DONT_NEED_FOTA);
                    return;
                }
                g.this.f30545t = cVar;
                g.this.f30545t.f(str);
                g.this.p();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("Ota stage: get ota info error %s", usdkerror);
                if (g.this.c()) {
                    e3.a.v("Ota stage: get ota info fail but already timeout!", new Object[0]);
                    return;
                }
                if (g.this.f30550y <= 1) {
                    if (usdkerror.getCode() == -1) {
                        usdkerror = ErrorConst.ERR_USDK_DEVICE_OTA_INTERRUPTED.toError();
                    }
                    g.this.a(usdkerror);
                } else {
                    g gVar = g.this;
                    gVar.b(gVar.f30545t.a(), g.this.f30545t.d(), 0, g.f30537l);
                    g.this.v();
                    g.this.u();
                }
            }
        });
    }

    private void a(com.haier.uhome.control.local.api.d dVar) {
        RtkCoreMeshWrapper.getInstance().setCfgNodeIdentity(dVar.d(), this.f30549x.getIndex(), new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.api.l1
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                this.f30623a.d(usdkerror);
            }
        });
        this.D = com.haier.library.common.util.a0.a(30L, TimeUnit.SECONDS, new Runnable() { // from class: com.haier.uhome.usdk.api.m1
            @Override // java.lang.Runnable
            public final void run() {
                this.f30640a.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i7, int i8, int i9) {
        uSDKError usdkerror = new uSDKError();
        usdkerror.setCode(i9);
        c(str, i7, i8, i9);
        this.f30541p.a(new FOTAStatusInfo(i8, usdkerror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, byte[] bArr, byte[] bArr2) {
        if (this.B.get()) {
            e3.a.v("Ble ota: identify already validated!", new Object[0]);
            return;
        }
        if (a((com.haier.uhome.control.local.api.d) this.f30541p, bArr, bArr2)) {
            com.haier.library.common.util.b0 b0Var = this.D;
            if (b0Var != null && b0Var.b()) {
                this.D.f();
            }
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(uSDKError usdkerror) {
        e3.a.e("Ota stage: end ota result: %s", usdkerror);
    }

    private boolean a(com.haier.uhome.control.local.api.d dVar, byte[] bArr, byte[] bArr2) {
        boolean zIsNodeIdentifyAdvAddress = RtkCoreMeshWrapper.getInstance().isNodeIdentifyAdvAddress(dVar.d(), bArr, bArr2);
        e3.a.e("Ota stage: validate node identity result %s", Boolean.valueOf(zIsNodeIdentifyAdvAddress));
        return zIsNodeIdentifyAdvAddress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        File fileA = com.haier.uhome.control.cloud.b.c.a(str);
        if (fileA != null && com.haier.library.common.util.c.c(a(fileA), this.f30544s.k())) {
            e3.a.e("Ble ota: find ota file: %s from cache dir!", fileA.getName());
            this.f30544s.a(fileA);
            this.f30543r.onSuccess(this.f30544s.n());
            v();
            return;
        }
        com.haier.uhome.control.cloud.b.c.a(str, new ICallback<File>() { // from class: com.haier.uhome.usdk.api.g.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(File file) {
                if (g.this.c()) {
                    e3.a.v("Ble ota: download ota file success but already timeout!", new Object[0]);
                    return;
                }
                if (com.haier.library.common.util.c.c(g.this.a(file), g.this.f30544s.k())) {
                    g.this.f30544s.a(file);
                    g.this.f30543r.onSuccess(g.this.f30544s.n());
                } else {
                    g.this.f30543r.onFailure(ErrorConst.ERR_USDK_DEVICE_OTA_PKG_VALIDATE_FAIL.toError());
                }
                g.this.v();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                if (g.this.c()) {
                    e3.a.v("Ble ota: download ota file failure but already timeout!", new Object[0]);
                } else {
                    g.this.f30543r.onFailure(usdkerror);
                    g.this.v();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(File file) {
        return com.haier.library.common.util.a.m(file, this.f30544s.m(), this.f30544s.l(), this.f30544s.c(), this.f30544s.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i7, int i8) {
        b(str, i7, i8, ErrorConst.RET_USDK_OK.getErrorId());
    }

    @Override // com.haier.uhome.control.local.api.e
    public void a(String str, int i7, float f8, int i8, String str2) {
        if (c()) {
            e3.a.v("Ota stage: notify status: %d but already timeout!", Integer.valueOf(i8));
            return;
        }
        if (this.f30545t.d() != i7) {
            this.f30545t.c(i7);
            e3.a.v("Ota stage: Obtain ota info session are not same! origin: %d, current: %d", Integer.valueOf(this.f30545t.d()), Integer.valueOf(i7));
        }
        if (i8 == 1) {
            q();
            this.A = 3;
        } else {
            if (i8 == 0) {
                e3.a.e("Ota stage: sending progress %.2f", Float.valueOf(f8));
                return;
            }
            b(str, i7, 0, f30537l);
            v();
            u();
        }
    }

    @Override // com.haier.uhome.control.local.api.e
    public void a(String str, int i7, int i8, int i9) {
        b(str, i9, i7, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKError usdkerror) {
        this.f30542q.onFailure(usdkerror);
        v();
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorConst errorConst) {
        a(errorConst.toError());
    }

    private void a(ICallback<Void> iCallback, ErrorConst errorConst) {
        if (iCallback != null) {
            iCallback.onFailure(errorConst.toError());
        }
    }

    @Override // com.haier.library.common.util.m
    public void a() {
        e3.a.e("Ble ota: timeout!", new Object[0]);
        int i7 = this.f30547v;
        if (i7 == 1) {
            if (this.C) {
                z();
            }
            this.f30543r.onFailure(ErrorConst.ERR_USDK_DEVICE_SEND_OTA_FILE_TIMEOUT.toError());
        } else if (i7 == 2) {
            b(this.f30541p.X(), this.f30545t.d(), 0, 121);
            u();
        }
        v();
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public boolean a(FOTAStatusInfo fOTAStatusInfo) {
        return this.E.add(fOTAStatusInfo);
    }
}
