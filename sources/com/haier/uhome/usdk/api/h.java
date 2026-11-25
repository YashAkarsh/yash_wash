package com.haier.uhome.usdk.api;

import com.haier.uhome.control.local.api.uSDKOTAStatus;
import com.haier.uhome.control.local.api.uSDKOTAStatusInfo;
import com.haier.uhome.usdk.api.interfaces.IuSDKOTACallback;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class h implements com.haier.uhome.control.local.api.e, com.haier.uhome.search.a.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKDevice f30566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.haier.uhome.control.local.api.h f30567b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.library.common.util.b0 f30569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f30570e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicReference<IuSDKOTACallback> f30568c = new AtomicReference<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f30571f = new AtomicBoolean();

    h(uSDKDevice usdkdevice, com.haier.uhome.control.local.api.h hVar) {
        this.f30566a = usdkdevice;
        this.f30567b = hVar;
    }

    private void e() {
        com.haier.uhome.control.local.a.e.a().b(this);
        com.haier.uhome.search.a.n.a().b(this);
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceAdd(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (!c()) {
            e3.a.e("ota found device stage: Has already timeout!", new Object[0]);
            return;
        }
        e3.a.e("ota found device stage: device add deviceId = " + fVar.b(), new Object[0]);
        uSDKDevice usdkdevice = this.f30566a;
        if (usdkdevice == null || !usdkdevice.getDeviceId().equals(fVar.b())) {
            return;
        }
        a(fVar);
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceDel(String str, com.haier.uhome.usdk.base.api.f fVar, int i7) {
    }

    @Override // com.haier.uhome.search.a.g
    public void onDeviceUpdate(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (!c()) {
            e3.a.e("ota found device stage: Has already timeout!", new Object[0]);
            return;
        }
        e3.a.e("ota found device stage: device update deviceId = " + fVar.b(), new Object[0]);
        uSDKDevice usdkdevice = this.f30566a;
        if (usdkdevice == null || !usdkdevice.getDeviceId().equals(fVar.b())) {
            return;
        }
        a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        e3.a.e("ota stage: timeout!", new Object[0]);
        this.f30571f.set(false);
        a(uSDKErrorConst.ERR_USDK_MODULE_OTA_TIMEOUT);
        e();
    }

    private boolean c() {
        com.haier.library.common.util.b0 b0Var = this.f30569d;
        return b0Var != null && b0Var.b();
    }

    private void d() {
        if (c()) {
            this.f30569d.f();
            e();
        }
    }

    @Override // com.haier.uhome.search.a.g
    public /* synthetic */ void a(com.haier.uhome.search.service.entity.d dVar) {
        com.haier.uhome.search.a.p.a(this, dVar);
    }

    @Override // com.haier.uhome.control.local.api.e
    public /* synthetic */ void a(String str, int i7, int i8, int i9) {
        com.haier.uhome.control.local.api.p.a(this, str, i7, i8, i9);
    }

    void a(IuSDKOTACallback iuSDKOTACallback) {
        this.f30568c.set(iuSDKOTACallback);
    }

    void a(com.haier.uhome.control.local.api.h hVar) {
        this.f30567b = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(uSDKOTAStatus usdkotastatus, float f8) {
        if (this.f30568c.get() != null) {
            this.f30568c.get().progressNotify(new uSDKOTAStatusInfo(usdkotastatus, f8));
        }
    }

    @Override // com.haier.uhome.control.local.api.e
    public void a(String str, int i7, float f8, int i8, String str2) {
        a(uSDKOTAStatus.sendUpgradePackage, f8);
    }

    void a() {
        if (!uSDKManager.getSingleInstance().a()) {
            a(uSDKErrorConst.ERR_USDK_UNSTARTED);
            return;
        }
        if (this.f30567b == null) {
            a(uSDKErrorConst.ERR_USDK_DEVICE_NOT_LOCAL);
            return;
        }
        if (!this.f30566a.isModuleNeedOTA()) {
            a(uSDKErrorConst.ERR_USDK_DONT_NEED_OTA);
            return;
        }
        if (this.f30571f.get()) {
            a(uSDKErrorConst.ERR_USDK_MODULE_IS_OTAING);
            return;
        }
        synchronized (this.f30571f) {
            this.f30571f.set(true);
            this.f30570e = this.f30566a.getModuleOTATargetVersion();
            com.haier.uhome.control.local.a.e.a().a(this);
            this.f30567b.a(this.f30566a.getModuleOTATargetFile(), this.f30566a.getIp(), this.f30566a.getPort(), this.f30567b.L(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.n1
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30652a.a(errorConst);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(uSDKErrorConst usdkerrorconst) {
        if (this.f30568c.get() != null) {
            this.f30568c.get().onCallback(usdkerrorconst);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorConst errorConst) {
        e3.a.e("ota transfer stage: result errorConst = %s", errorConst);
        if (errorConst.getErrorId() != ErrorConst.RET_USDK_OK.getErrorId()) {
            this.f30571f.set(false);
            com.haier.uhome.control.local.a.e.a().b(this);
            a(uSDKErrorConst.getErrorConst(errorConst));
        } else {
            synchronized (this.f30571f) {
                this.f30569d = com.haier.library.common.util.a0.a(1L, TimeUnit.MINUTES, new Runnable() { // from class: com.haier.uhome.usdk.api.p1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30691a.b();
                    }
                });
                a(uSDKOTAStatus.moduleRestart, 0.01f);
                com.haier.uhome.search.a.n.a().a(this);
            }
        }
    }

    private void a(com.haier.uhome.usdk.base.api.f fVar) {
        e3.a.e("ota found device stage: device = %s", fVar);
        synchronized (this.f30571f) {
            String strH = fVar.p().h();
            if (strH.equals(this.f30570e)) {
                a(uSDKOTAStatus.moduleRestart, 1.0f);
                a(uSDKErrorConst.RET_USDK_OK);
            } else {
                e3.a.d("ota found device stage: but the device soft version not equals target, crtVersion = %s, targetVersion = %s", strH, this.f30570e, new Object[0]);
                a(uSDKErrorConst.ERR_USDK_MODULE_OTA_SEARCH_FAIL);
            }
            this.f30571f.set(false);
            d();
        }
    }

    private void a(final uSDKOTAStatus usdkotastatus, final float f8) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.q1
            @Override // java.lang.Runnable
            public final void run() {
                this.f30698a.b(usdkotastatus, f8);
            }
        });
    }

    private void a(final uSDKErrorConst usdkerrorconst) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.o1
            @Override // java.lang.Runnable
            public final void run() {
                this.f30672a.b(usdkerrorconst);
            }
        });
    }
}
