package com.haier.uhome.usdk.api;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class e extends com.haier.library.common.util.m implements com.haier.uhome.control.local.api.e, com.haier.uhome.search.a.m, com.haier.uhome.usdk.api.interfaces.a, com.haier.uhome.usdk.base.c.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f30486f = 500;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f30487g = 60;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f30488h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f30489i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f30490j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f30491k = 123;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f30492l = 121;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f30493m = 124;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f30494n = -23102;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile com.haier.uhome.control.local.api.a f30495o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ICallback<Void> f30496p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ICallback<FOTAInfo> f30497q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile com.haier.uhome.control.local.b.b f30498r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.haier.uhome.control.local.b.c f30499s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f30501u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f30502v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f30506z;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicBoolean f30500t = new AtomicBoolean();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f30503w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Set<FOTAStatusInfo> f30504x = new HashSet();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicBoolean f30505y = new AtomicBoolean();

    private static abstract class a<E> implements ICallback<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<e> f30509a;

        a(e eVar) {
            this.f30509a = new WeakReference<>(eVar);
        }

        e a() {
            return this.f30509a.get();
        }

        abstract void a(e eVar, uSDKError usdkerror);

        abstract void a(e eVar, E e8);

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public final void onFailure(uSDKError usdkerror) {
            e eVarA = a();
            if (eVarA == null) {
                e3.a.v("Ble ota: %s failure but object has release!", getClass().getSimpleName());
            } else if (eVarA.c()) {
                e3.a.v("Ble ota: %s failure but already timeout!", getClass().getSimpleName());
            } else {
                a(eVarA, usdkerror);
            }
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public final void onSuccess(E e8) {
            e eVarA = a();
            if (eVarA == null) {
                e3.a.v("Ble ota: %s success handler object has release!", getClass().getSimpleName());
            } else if (eVarA.c()) {
                e3.a.v("Ble ota: %s success but already timeout!", getClass().getSimpleName());
            } else {
                a(eVarA, e8);
            }
        }
    }

    private static class b extends a<FOTAInfo> {
        b(e eVar) {
            super(eVar);
        }

        @Override // com.haier.uhome.usdk.api.e.a
        public void a(e eVar, FOTAInfo fOTAInfo) {
            eVar.f30498r = new com.haier.uhome.control.local.b.b(fOTAInfo);
            if (fOTAInfo.isNeedFOTA()) {
                eVar.a(fOTAInfo.a());
            } else {
                eVar.a(fOTAInfo);
            }
        }

        @Override // com.haier.uhome.usdk.api.e.a
        public void a(e eVar, uSDKError usdkerror) {
            if (usdkerror.getFailureReason().equals(String.valueOf(-40004))) {
                eVar.c(this);
            } else {
                eVar.b(usdkerror);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c extends a<com.haier.uhome.control.local.b.c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f30510b;

        c(e eVar) {
            super(eVar);
        }

        void c(e eVar, uSDKError usdkerror) {
            if (usdkerror.getCode() == -1 || usdkerror.getCode() == e.f30494n) {
                a(eVar);
            } else {
                eVar.a(usdkerror);
            }
        }

        void a(int i7) {
            this.f30510b = i7;
        }

        void b(e eVar, uSDKError usdkerror) {
            if (usdkerror.getCode() == -1 || usdkerror.getCode() == e.f30494n) {
                a(eVar);
            } else {
                eVar.b(usdkerror);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.haier.uhome.usdk.api.e.a
        public void a(e eVar, com.haier.uhome.control.local.b.c cVar) {
            e3.a.e("Ble ota: stage = %d ota info = %s", Integer.valueOf(this.f30510b), cVar);
            int i7 = this.f30510b;
            if (i7 == 1) {
                eVar.c(cVar);
            } else if (i7 == 2) {
                eVar.b(cVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(e eVar) {
            eVar.f30495o.a(this);
        }

        @Override // com.haier.uhome.usdk.api.e.a
        void a(e eVar, uSDKError usdkerror) {
            int i7 = this.f30510b;
            if (i7 == 1) {
                b(eVar, usdkerror);
            } else if (i7 == 2) {
                c(eVar, usdkerror);
            }
        }

        void a(final e eVar) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.f1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30523a.b(eVar);
                }
            }, 3L, TimeUnit.SECONDS);
        }
    }

    private static class d extends a<File> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f30511b;

        d(String str, e eVar) {
            super(eVar);
            this.f30511b = str;
        }

        @Override // com.haier.uhome.usdk.api.e.a
        public void a(e eVar, File file) {
            if (!com.haier.library.common.util.c.c(eVar.a(file), eVar.f30498r.k())) {
                eVar.b(ErrorConst.ERR_USDK_DEVICE_OTA_PKG_VALIDATE_FAIL.toError());
            } else {
                eVar.f30498r.a(file);
                eVar.a(eVar.f30498r.n());
            }
        }

        @Override // com.haier.uhome.usdk.api.e.a
        public void a(e eVar, uSDKError usdkerror) {
            eVar.a(this.f30511b, this);
        }
    }

    e(com.haier.uhome.control.local.api.a aVar) {
        this.f30495o = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(uSDKError usdkerror) {
        e3.a.e("Ble ota: end ota result: %s", usdkerror);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(uSDKError usdkerror) {
        if (c()) {
            e3.a.v("Ble ota: start ota resp already timeout!", new Object[0]);
            return;
        }
        if (this.f30502v > 1) {
            e3.a.e("Ble ota: start ota resp fragment no care!", new Object[0]);
            return;
        }
        this.f30506z = true;
        if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.control.local.a.e.a().a(this);
        } else if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            e3.a.v("Ble ota: start ota resp error %s", usdkerror);
        } else {
            c(usdkerror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.haier.uhome.control.local.b.a aVar = new com.haier.uhome.control.local.b.a();
        if (this.f30502v > 1) {
            aVar.a(this.f30499s.d());
            aVar.c(this.f30499s.c());
            a(aVar);
            return;
        }
        int iB = com.haier.uhome.usdk.base.utils.f.b();
        e3.a.e("Ble ota: sdk crate session is " + iB + " !", new Object[0]);
        aVar.a(iB);
        aVar.c(0);
        a(aVar, iB);
    }

    private synchronized void l() {
        this.f30505y.set(false);
        com.haier.uhome.search.a.n.a().a(this);
    }

    private synchronized void m() {
        this.f30505y.set(false);
        com.haier.uhome.search.a.n.a().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ICallback<Void> iCallback = this.f30496p;
        if (iCallback != null) {
            iCallback.onSuccess(null);
        }
    }

    private void o() {
        this.f30495o.a(new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.api.c1
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                e.d(usdkerror);
            }
        });
    }

    private void p() {
        this.f30502v = 0;
        this.f30500t.set(false);
        d();
        this.f30495o.f(false);
        this.f30501u = -1;
        this.f30503w = -1;
        this.f30505y.set(false);
        if (this.f30506z) {
            r();
        }
        com.haier.uhome.control.local.a.e.a().b(this);
        com.haier.uhome.search.a.n.a().b(this);
        com.haier.uhome.usdk.base.c.b.a().b(this);
    }

    private ErrorConst q() {
        if (!uSDKManager.getSingleInstance().a()) {
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("Ble ota: bluetooth not Enabled or not support ble", new Object[0]);
            return ErrorConst.ERR_USDK_BLE_NOT_OPEN;
        }
        if (this.f30495o != null) {
            return ErrorConst.RET_USDK_OK;
        }
        e3.a.v("Ble ota: local BLE device not exist!", new Object[0]);
        return ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL;
    }

    private void r() {
        this.f30495o.e(false);
        this.f30495o.a(this.f30495o.u(), (com.haier.uhome.usdk.base.api.o) null);
    }

    private void s() {
        if (this.f30504x.isEmpty()) {
            return;
        }
        f();
    }

    @Override // com.haier.uhome.search.a.g
    public /* synthetic */ void a(com.haier.uhome.search.service.entity.d dVar) {
        com.haier.uhome.search.a.p.a(this, dVar);
    }

    @Override // com.haier.uhome.usdk.base.c.c
    public void notifyBtStateChanged(int i7) {
        e3.a.e("Ble ota: ble state = %d changed!", Integer.valueOf(i7));
        if (i7 == 1) {
            a(0, f30493m);
        }
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceAdd(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (c()) {
            e3.a.v("Ble ota: find ble device: %s add but already timeout!", fVar.b());
        } else {
            a(str, fVar);
        }
    }

    @Override // com.haier.uhome.search.a.m, com.haier.uhome.search.a.g
    public /* synthetic */ void onDeviceDel(String str, com.haier.uhome.usdk.base.api.f fVar, int i7) {
        com.haier.uhome.search.a.q.a(this, str, fVar, i7);
    }

    @Override // com.haier.uhome.search.a.m, com.haier.uhome.search.a.g
    public void onDeviceUpdate(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (c()) {
            e3.a.v("Ble ota: find ble device: %s update but already timeout!", fVar.b());
        } else {
            a(str, fVar);
        }
    }

    private void g() {
        com.haier.uhome.usdk.base.c.b.a().a(this);
        this.f30495o.f(true);
        h();
    }

    private void h() {
        c cVar = new c(this);
        cVar.a(1);
        this.f30495o.a(cVar);
    }

    private void i() {
        this.f30495o.f(true);
        j();
        com.haier.uhome.usdk.base.c.b.a().a(this);
    }

    private void j() {
        this.f30502v++;
        c cVar = new c(this);
        cVar.a(2);
        this.f30495o.b(this.f30502v <= 1 ? 0 : 1, cVar);
        m();
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void f() {
        this.f30504x.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ICallback<FOTAInfo> iCallback) {
        this.f30495o.a(30, iCallback);
    }

    private void c(String str, int i7, int i8, int i9) {
        if (com.haier.library.common.util.c.c(this.f30495o.X(), str)) {
            this.f30495o.a(String.valueOf(i7), i8, i9);
        } else {
            e3.a.v("Ble ota: device id are not the same, deviceId = %s", str);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void b(ICallback<Void> iCallback) {
        ErrorConst errorConstQ = q();
        if (errorConstQ != ErrorConst.RET_USDK_OK) {
            a(iCallback, errorConstQ);
            return;
        }
        if (this.f30498r == null) {
            a(iCallback, ErrorConst.ERR_USDK_FOTA_INFO_IS_NULL);
            return;
        }
        if (!this.f30498r.b()) {
            a(iCallback, ErrorConst.ERR_USDK_DONT_NEED_FOTA);
            return;
        }
        if (this.f30500t.get()) {
            a(iCallback, ErrorConst.ERR_USDK_MODULE_IS_OTAING);
            return;
        }
        if (this.f30500t.compareAndSet(false, true)) {
            s();
            this.f30501u = 2;
            this.f30496p = iCallback;
            int iH = this.f30498r.h();
            int i7 = iH > 0 ? iH * 60 : f30486f;
            e3.a.e("Ble ota: OTA start timeout = %d s", Integer.valueOf(i7));
            a(i7);
            i();
        }
    }

    private void c(uSDKError usdkerror) {
        ICallback<Void> iCallback = this.f30496p;
        if (iCallback != null) {
            iCallback.onFailure(usdkerror);
        }
        f();
        p();
        o();
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void a(com.haier.uhome.control.local.api.a aVar) {
        this.f30495o = aVar;
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public void a(ICallback<FOTAInfo> iCallback) {
        ErrorConst errorConstQ = q();
        if (errorConstQ != ErrorConst.RET_USDK_OK) {
            iCallback.onFailure(errorConstQ.toError());
            return;
        }
        if (!com.haier.uhome.usdk.base.api.e.c(this.f30495o.ai())) {
            iCallback.onFailure(ErrorConst.ERR_USDK_BLE_OPERATION_NOT_SUPPORT.toError());
            return;
        }
        if (this.f30495o.n() != DeviceStatus.STATUS_CONNECTED && this.f30495o.n() != DeviceStatus.STATUS_READY) {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
            return;
        }
        if (b()) {
            e3.a.e("Ble ota: device is checking!", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_IS_BUSY.toError());
        } else if (this.f30500t.compareAndSet(false, true)) {
            s();
            if (this.f30498r != null) {
                this.f30498r = null;
            }
            this.f30501u = 1;
            this.f30497q = iCallback;
            a(60L, TimeUnit.SECONDS);
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.haier.uhome.control.local.b.c cVar) {
        e3.a.e("Ble ota: Get ota info: %s", cVar);
        if (cVar.b() == 0) {
            a(ErrorConst.ERR_USDK_DEVICE_NOT_IN_OTA_MODE);
            return;
        }
        if (this.f30503w == 0) {
            c(cVar);
        } else if (this.f30502v <= 1 && this.f30498r.d().compareTo(cVar.k()) < 0) {
            a(ErrorConst.ERR_USDK_DONT_NEED_FOTA);
        } else {
            this.f30499s = cVar;
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.d1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30481a.k();
                }
            }, 5L);
        }
    }

    private void b(String str, int i7, int i8, int i9) {
        uSDKError usdkerror = new uSDKError();
        usdkerror.setCode(i9);
        c(str, i7, i8, i9);
        this.f30495o.a(new FOTAStatusInfo(i8, usdkerror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(final com.haier.uhome.control.local.b.c cVar) {
        com.haier.uhome.control.cloud.api.f fVar = new com.haier.uhome.control.cloud.api.f();
        fVar.b(cVar.h());
        fVar.a(cVar.g());
        fVar.d(cVar.f());
        fVar.c(cVar.e());
        fVar.e(cVar.k());
        fVar.a(cVar.m());
        fVar.f(cVar.l());
        this.f30495o.a(fVar, new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.api.a1
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                this.f30432a.a(cVar, usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(uSDKError usdkerror) {
        this.f30497q.onFailure(usdkerror);
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKError usdkerror, final com.haier.uhome.control.local.b.c cVar) {
        if (c()) {
            e3.a.v("Ble ota: update version return but already timeout!", new Object[0]);
            return;
        }
        if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.b1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30458a.c(cVar);
                }
            }, 1L, TimeUnit.SECONDS);
            return;
        }
        uSDKError usdkerror2 = uSDKError.RET_USDK_OK;
        if (usdkerror2.a(usdkerror)) {
            if (this.f30501u == 1) {
                c(new b(this));
                return;
            } else {
                a(0, usdkerror2.getCode());
                return;
            }
        }
        if (this.f30501u == 1) {
            b(usdkerror);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        File fileA = com.haier.uhome.control.cloud.b.c.a(str);
        if (fileA != null && com.haier.library.common.util.c.c(a(fileA), this.f30498r.k())) {
            e3.a.e("Ble ota: find ota file: %s from cache dir!", fileA.getName());
            this.f30498r.a(fileA);
            a(this.f30498r.n());
            return;
        }
        a(str, new d(str, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, ICallback<File> iCallback) {
        com.haier.uhome.control.cloud.b.c.a(str, iCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(File file) {
        return com.haier.library.common.util.a.m(file, this.f30498r.m(), this.f30498r.l(), this.f30498r.c(), this.f30498r.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKError usdkerror) {
        if (this.f30502v > 1) {
            a(0, f30491k);
            return;
        }
        if (usdkerror.getCode() == -1) {
            usdkerror = ErrorConst.ERR_USDK_DEVICE_OTA_INTERRUPTED.toError();
        }
        c(usdkerror);
    }

    private void a(final com.haier.uhome.control.local.b.a aVar, int i7) {
        HashMap map = new HashMap(8);
        map.put(com.haier.globalwasher.presenter.o.f25218y, this.f30499s.a());
        map.put("sn", Integer.valueOf(i7));
        map.put("typeId", this.f30495o.W());
        map.put("fwType", this.f30498r.n().getModel());
        map.put("softVer", this.f30498r.n().getNewVersion());
        map.put("url", this.f30498r.n().a());
        map.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(this.f30498r.n().getTimeoutInterval()));
        map.put("createDate", com.haier.library.common.util.a0.f());
        this.f30495o.a(map, new m3.a<com.haier.library.sumhttp.response.c>() { // from class: com.haier.uhome.usdk.api.e.1
            @Override // m3.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.library.sumhttp.response.c cVar) {
                e3.a.v("Ble ota: start upgradeOta result data is " + cVar.toString() + " !", new Object[0]);
                if (!cVar.c()) {
                    e.this.a(cVar);
                } else {
                    e.this.n();
                    e.this.a(aVar);
                }
            }

            @Override // m3.a
            public void onError(Exception exc) {
                e.this.a((com.haier.library.sumhttp.response.c) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.uhome.control.local.b.a aVar) {
        aVar.e(this.f30499s.i());
        aVar.c(this.f30498r.a().getAbsolutePath());
        aVar.f(this.f30498r.m());
        aVar.g(this.f30498r.l());
        aVar.b(this.f30498r.m().length());
        this.f30495o.a(aVar, new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.api.e1
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                this.f30513a.e(usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.control.local.api.e
    public void a(String str, int i7, float f8, int i8, String str2) {
        if (c()) {
            e3.a.v("Ble ota: notify status: %d but already timeout!", Integer.valueOf(i8));
            return;
        }
        if (this.f30499s.d() != i7) {
            this.f30499s.c(i7);
            e3.a.v("Ble ota: Obtain ota info session are not same! origin: %d, current: %d", Integer.valueOf(this.f30499s.d()), Integer.valueOf(i7));
        }
        if (i8 == 1) {
            l();
        } else if (i8 == 0) {
            e3.a.e("Ble ota: sending progress %.2f", Float.valueOf(f8));
        } else {
            a(0, f30491k);
        }
    }

    @Override // com.haier.uhome.control.local.api.e
    public void a(String str, int i7, int i8, int i9) {
        this.f30503w = i7;
        if (i7 != 0) {
            b(str, i9, i7, i8);
        }
    }

    private void a(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(str) && com.haier.library.common.util.c.c(fVar.b(), this.f30495o.X()) && this.f30505y.compareAndSet(false, true)) {
            j();
        }
    }

    private void a(int i7, int i8) {
        b(this.f30495o.X(), this.f30499s.d(), i7, i8);
        o();
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FOTAInfo fOTAInfo) {
        this.f30497q.onSuccess(fOTAInfo);
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.library.sumhttp.response.c cVar) {
        uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
        if (cVar != null && !TextUtils.isEmpty(cVar.b())) {
            error.setDescription(cVar.b());
        } else {
            error.setDescription("");
        }
        c(error);
    }

    private void a(ErrorConst errorConst) {
        c(errorConst.toError());
    }

    private void a(ICallback<Void> iCallback, ErrorConst errorConst) {
        if (iCallback != null) {
            iCallback.onFailure(errorConst.toError());
        }
    }

    @Override // com.haier.library.common.util.m
    public void a() {
        e3.a.e("Ble ota: timeout!", new Object[0]);
        int i7 = this.f30501u;
        if (i7 == 1) {
            b(ErrorConst.ERR_USDK_DEVICE_SEND_OTA_FILE_TIMEOUT.toError());
        } else if (i7 == 2) {
            a(0, 121);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.a
    public boolean a(FOTAStatusInfo fOTAStatusInfo) {
        return this.f30504x.add(fOTAStatusInfo);
    }
}
