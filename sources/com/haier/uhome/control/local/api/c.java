package com.haier.uhome.control.local.api;

import android.text.TextUtils;
import com.haier.library.common.util.u;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a implements com.haier.uhome.control.base.api.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.haier.uhome.control.local.e.e f29306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f29307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.haier.uhome.control.base.api.p f29308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.haier.uhome.control.base.api.g f29309d;

    protected c(String str, String str2, String str3, String str4, int i7, com.haier.uhome.control.base.api.p pVar, com.haier.uhome.control.local.e.e eVar) {
        super(str, str2, str3, str4);
        this.f29308c = pVar;
        this.f29306a = eVar;
        this.f29307b = i7;
        R();
        this.f29306a.a(str, this);
        if (ah()) {
            this.f29309d = new com.haier.uhome.control.base.api.g(s(), this.f29308c, this) { // from class: com.haier.uhome.control.local.api.c.1
                @Override // com.haier.uhome.control.base.api.g
                protected void a(DeviceStatus deviceStatus) {
                    c cVar = c.this;
                    cVar.a(cVar.F(), deviceStatus, 0);
                }
            };
        }
        com.haier.uhome.control.local.e.g.a().a(W(), new com.haier.uhome.control.local.e.g.a() { // from class: com.haier.uhome.control.local.api.n
            @Override // com.haier.uhome.control.local.e.g.a
            public final void onUplusIdReady() {
                this.f29329a.T();
            }
        });
        e_();
        g(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        g(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ErrorConst errorConst) {
    }

    @Override // com.haier.uhome.control.base.api.o
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public c c() {
        com.haier.uhome.control.local.e.a aVarS;
        com.haier.uhome.control.base.api.a aVarB;
        String strV = V();
        if (TextUtils.isEmpty(strV) || (aVarS = s()) == null || (aVarB = aVarS.b(strV)) == null) {
            return null;
        }
        return (c) aVarB;
    }

    abstract DeviceStatus N();

    protected abstract String O();

    @Override // com.haier.uhome.control.base.api.o
    public com.haier.uhome.control.base.api.g b() {
        c cVarC = c();
        if (cVarC != null) {
            return cVarC.f29309d;
        }
        return null;
    }

    @Override // com.haier.uhome.control.base.api.o
    public int d() {
        return this.f29307b;
    }

    @Override // com.haier.uhome.control.base.api.o
    public void e_() {
        if (ah()) {
            this.f29309d.a();
            return;
        }
        com.haier.uhome.control.base.api.g gVarB = b();
        if (gVarB != null) {
            gVarB.a();
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public void f() {
        a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.local.api.m
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f29328a.b(errorConst);
            }
        }));
    }

    void g(boolean z7) {
        DeviceStatus deviceStatusC = ah() ? this.f29309d.c() : N();
        boolean z8 = false;
        e3.a.e("catchCover device<%s> status:%s type:%s force:%s", X(), deviceStatusC, e(), Boolean.valueOf(z7));
        if (deviceStatusC == null) {
            deviceStatusC = DeviceStatus.STATUS_OFFLINE;
        }
        DeviceStatus deviceStatusN = n();
        a(F(), deviceStatusC, 0);
        if (!z7 ? !(deviceStatusC != DeviceStatus.STATUS_CONNECTED || deviceStatusN == deviceStatusC) : deviceStatusC == DeviceStatus.STATUS_CONNECTED) {
            z8 = true;
        }
        if (z8) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.control.local.api.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29327a.S();
                }
            }, com.haier.uhome.usdk.base.utils.f.a() % 1000, TimeUnit.MILLISECONDS);
            s().e(this);
        }
    }

    private void R() {
        com.haier.uhome.control.base.api.p pVar = this.f29308c;
        if (pVar == null) {
            return;
        }
        pVar.a(new ICallback<Void>() { // from class: com.haier.uhome.control.local.api.c.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
            }
        }, 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        s().c(X());
    }

    protected void P() {
        com.haier.uhome.control.base.api.p pVar = this.f29308c;
        if (pVar == null) {
            return;
        }
        List<String> listA = pVar.a(X());
        if (u.h(listA)) {
            return;
        }
        Iterator<String> it = listA.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ErrorConst errorConst) {
        if (errorConst != ErrorConst.RET_USDK_OK) {
            e3.a.o("destroy device<id=%s> first call disConnect, but disConnect fail<err id=%d>!!", X(), Integer.valueOf(errorConst.getErrorId()));
        }
        this.f29306a.a(X());
        com.haier.uhome.control.base.api.g gVarB = b();
        if (gVarB != null) {
            gVarB.a();
        }
        com.haier.uhome.control.base.api.g gVar = this.f29309d;
        if (gVar != null) {
            gVar.d();
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, DeviceStatus deviceStatus, int i7) {
        com.haier.uhome.control.base.api.g gVarB;
        if (!com.haier.uhome.control.local.e.g.a().b(W()) && deviceStatus != DeviceStatus.STATUS_UNCONNECT) {
            e3.a.e("setDeviceStatus<%s> to %s but typeId is not ready so return<%s>", deviceStatus, X(), W());
            return;
        }
        super.a(str, deviceStatus, i7);
        if ((deviceStatus == DeviceStatus.STATUS_UNCONNECT || deviceStatus == DeviceStatus.STATUS_OFFLINE) && (gVarB = b()) != null) {
            gVarB.a();
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(boolean z7, final com.haier.uhome.usdk.base.api.o oVar) {
        this.f29306a.a(O(), W(), this.f29307b, z7, aj(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.local.api.k
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f29325a.a(oVar, errorConst);
            }
        });
    }

    protected void b(String str) {
        com.haier.uhome.control.base.api.a aVarB;
        if (ah() && A() && str != null && (aVarB = s().b(str)) != null) {
            e3.a.d("refreshInGroupDevConnectStatus groupId<%s> devId<%s>", X(), str, new Object[0]);
            aVarB.a(u(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.local.api.o
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    c.a(errorConst);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar, ErrorConst errorConst) {
        g(true);
        com.haier.uhome.usdk.base.utils.b.a(oVar, errorConst);
        if (ah()) {
            P();
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public void b(com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.e("MeshBaseDevice is not support", new Object[0]);
    }
}
