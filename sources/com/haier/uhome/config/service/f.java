package com.haier.uhome.config.service;

import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.ConfigDeviceByBleReq;
import com.haier.uhome.config.json.req.StopConfigDeviceByBleReq;
import com.haier.uhome.config.json.req.WithWifi;
import com.haier.uhome.config.json.req.WithoutWifi;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class f implements com.haier.uhome.config.service.a.a<com.haier.uhome.config.entity.a, d, com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d>>, com.haier.uhome.usdk.base.c.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28581j = -933;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f28582k = -940;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f28583l = -10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f28584m = -932;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f28585n = -934;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f28586o = -935;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f28588q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f28589r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.haier.uhome.config.entity.d f28590s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.haier.uhome.config.entity.a f28591t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d> f28593v;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private uSDKError f28587p = ErrorConst.ERR_USDK_SEND_CONFIG_REQ_TIMEOUT.toError();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicBoolean f28592u = new AtomicBoolean();

    static {
        ConfigProtocol.registerBle();
    }

    private boolean c() {
        com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d> eVar = this.f28593v;
        return eVar != null && eVar.c();
    }

    private void d() {
        a(this.f28591t.o());
    }

    private void e() {
        StopConfigDeviceByBleReq stopConfigDeviceByBleReq = new StopConfigDeviceByBleReq();
        stopConfigDeviceByBleReq.setWifiMAC(this.f28591t.o());
        stopConfigDeviceByBleReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
        com.haier.uhome.usdk.base.d.f.a().a(stopConfigDeviceByBleReq, 5, null);
    }

    @Override // com.haier.uhome.usdk.base.c.c
    public void notifyBtStateChanged(int i7) {
        e3.a.e("BLE config: bluetooth state changed status = %d, desc = %s", Integer.valueOf(i7), com.haier.uhome.usdk.base.c.i.a(i7));
        if (i7 == 1) {
            if (!this.f28588q && !this.f28589r) {
                a(ErrorConst.ERR_USDK_BLE_IS_POWER_OFF.toError());
                return;
            }
            com.haier.uhome.config.entity.d dVar = this.f28590s;
            if (dVar == null || dVar.c() >= 1004) {
                return;
            }
            a(ErrorConst.ERR_USDK_BLE_IS_POWER_OFF.toError());
        }
    }

    private boolean b(int i7) {
        return i7 == 2001 || i7 == 2002 || i7 == 2003;
    }

    private void c(com.haier.uhome.config.entity.d dVar) {
        e3.a.e("Ble config: module config state %s", dVar);
        com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d> eVar = this.f28593v;
        if (eVar != null) {
            eVar.a_(dVar.c());
        }
        int iC = dVar.c();
        if (this.f28588q) {
            if (iC == 1004) {
                d dVar2 = new d();
                dVar2.b(dVar.b());
                a(dVar2);
                return;
            }
        } else if (iC == 1000) {
            d dVar3 = new d();
            dVar3.b(dVar.b());
            a(dVar3);
            return;
        }
        int iD = dVar.d();
        if (iD == 5 && iC != 5000) {
            a(com.haier.uhome.usdk.base.utils.c.a(iC));
            return;
        }
        if (iD == 2 && b(iC)) {
            a(com.haier.uhome.usdk.base.utils.c.a(iC));
        } else if (iC == 4000 || iC == 5000) {
            this.f28587p = null;
        } else {
            this.f28587p = com.haier.uhome.usdk.base.utils.c.a(iC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.haier.uhome.config.entity.a aVar = this.f28591t;
        ConfigDeviceByBleReq configDeviceByBleReq = new ConfigDeviceByBleReq();
        configDeviceByBleReq.setProtoVer(String.valueOf(aVar.j()));
        configDeviceByBleReq.setBleDevId(aVar.a());
        configDeviceByBleReq.setWifiMAC(aVar.o());
        configDeviceByBleReq.setToken(aVar.f());
        configDeviceByBleReq.setBindCode(aVar.m());
        configDeviceByBleReq.setTimestamp(aVar.n());
        configDeviceByBleReq.setTraceId(aVar.i());
        configDeviceByBleReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
        if (aVar.p()) {
            WithWifi withWifi = new WithWifi();
            withWifi.setBssid(aVar.d());
            withWifi.setSsid(aVar.c());
            withWifi.setPassword(aVar.e());
            withWifi.setTimeout(5);
            configDeviceByBleReq.setWithWifi(withWifi);
        } else {
            WithoutWifi withoutWifi = new WithoutWifi();
            withoutWifi.setRandomNum(aVar.h());
            withoutWifi.setSessionKey(aVar.g());
            configDeviceByBleReq.setWithoutWifi(withoutWifi);
        }
        this.f28588q = !aVar.p();
        com.haier.uhome.usdk.base.d.f.a().a(configDeviceByBleReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.z
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f28710a.a(basicResp);
            }
        });
    }

    @Override // com.haier.uhome.config.service.a.a
    public synchronized void a(com.haier.uhome.config.entity.a aVar, com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d> eVar) {
        this.f28591t = aVar;
        this.f28593v = eVar;
        this.f28592u.set(true);
        com.haier.uhome.usdk.base.d.c.a().a(this);
        com.haier.uhome.usdk.base.c.b.a().a(this);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BasicResp basicResp) {
        this.f28589r = basicResp.getErrNo() == 0;
        a(com.haier.uhome.config.a.d.BEGIN_CONNECT);
        e3.a.e("Ble config: send config request result = %s", basicResp);
    }

    private void a(com.haier.uhome.config.a.d dVar) {
        if (c()) {
            e3.a.e("Ble config: notify progress but already timeout!", new Object[0]);
            return;
        }
        com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d> eVar = this.f28593v;
        if (eVar != null) {
            eVar.a(dVar);
        }
    }

    private void a(uSDKError usdkerror) {
        com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d> eVar = this.f28593v;
        if (eVar != null) {
            eVar.onFailure(usdkerror);
        }
        d();
    }

    private void a(d dVar) {
        com.haier.uhome.config.a.e<com.haier.uhome.config.a.d, d> eVar = this.f28593v;
        if (eVar != null) {
            eVar.onSuccess(dVar);
        }
        String strB = this.f28591t.b();
        if (com.haier.library.common.util.c.l(strB)) {
            b(strB);
        }
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.config.entity.c cVar) {
        com.haier.uhome.config.a.d dVarC = cVar.c();
        if (dVarC == com.haier.uhome.config.a.d.BEGIN_BIND) {
            this.f28587p = null;
        }
        a(dVarC);
    }

    private void b(com.haier.uhome.config.entity.d dVar) {
        e3.a.e("Ble config: ucom config state %s", dVar);
        int iC = dVar.c();
        if (iC != f28581j && iC != f28582k && iC != -10) {
            if (iC == f28584m && !this.f28593v.c()) {
                com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.config.service.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f28531a.b();
                    }
                }, 2L);
                return;
            } else {
                if (iC == f28585n || iC == f28586o) {
                    this.f28587p = com.haier.uhome.usdk.base.utils.c.a(iC);
                    return;
                }
                return;
            }
        }
        a(com.haier.uhome.usdk.base.utils.c.a(iC));
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.config.entity.d dVar) {
        if (!dVar.equals(this.f28590s)) {
            this.f28590s = dVar;
        }
        int iE = dVar.e();
        if (iE == 1) {
            b(dVar);
        } else if (iE == 2) {
            c(dVar);
        }
    }

    private void b(String str) {
        com.haier.uhome.search.b.f.a().a(str, 7);
    }

    @Override // com.haier.uhome.config.service.a.a
    public synchronized void a(String str) {
        if (!this.f28592u.get()) {
            e3.a.v("Ble config: already stopped config mac = %s", str);
            return;
        }
        e3.a.e("Ble config: stop config mac = %s", str);
        this.f28592u.set(false);
        e();
        com.haier.uhome.usdk.base.d.c.a().b(this);
        com.haier.uhome.usdk.base.c.b.a().b(this);
    }

    @Override // com.haier.uhome.config.service.a.a
    public uSDKError a() {
        return this.f28587p;
    }
}
