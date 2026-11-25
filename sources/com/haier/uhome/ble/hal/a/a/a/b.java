package com.haier.uhome.ble.hal.a.a.a;

import android.os.Bundle;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f28176e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28177f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28178g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28179h = 11;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28180i = 12;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28181j = 13;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f28182k = 21;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f28183l = 22;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f28184m = "[]";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f28185s = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f28186u = 3;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f28187w = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.haier.uhome.usdk.base.d.d f28188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.haier.uhome.usdk.base.d.d f28189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final com.haier.uhome.usdk.base.d.d f28190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final com.haier.uhome.usdk.base.d.d f28191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f28192r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f28193t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f28194v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f28195x;

    public b(ICallback<Bundle> iCallback) {
        super(iCallback);
        this.f28195x = 23;
        String str = a.f28164a;
        this.f28188n = new com.haier.uhome.usdk.base.d.d(str, this);
        this.f28189o = new com.haier.uhome.usdk.base.d.d(str, 11, this);
        this.f28190p = new com.haier.uhome.usdk.base.d.d(str, 12, this);
        this.f28191q = new com.haier.uhome.usdk.base.d.d(str, 13, this);
    }

    private void c(int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "processTimeout. reason: %d ", Integer.valueOf(i7));
        a();
        s();
    }

    private void m() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "processConnect.State = %s, Count =%d", j(), Integer.valueOf(this.f28192r));
        a();
        int i7 = i();
        if (i7 == 0) {
            if (this.f28192r >= 3) {
                c(ErrorConst.ERR_USDK_TIMEOUT);
                return;
            } else if (p()) {
                com.haier.uhome.usdk.base.d.c.a().a(this.f28189o, RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
                return;
            } else {
                s();
                return;
            }
        }
        if (i7 != 1) {
            if (i7 == 2) {
                o();
                return;
            } else if (i7 != 3) {
                if (i7 != 4) {
                    return;
                }
                y();
                return;
            }
        }
        n();
    }

    private void n() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "processRequestMTU.State = %s, Count =%d", j(), Integer.valueOf(this.f28193t));
        a();
        int i7 = i();
        if (i7 == 0) {
            v();
            return;
        }
        if (i7 != 1) {
            if (i7 == 2) {
                o();
                return;
            } else if (i7 != 3) {
                if (i7 != 4) {
                    return;
                }
                y();
                return;
            }
        }
        if (this.f28193t >= 3) {
            e();
            o();
        } else if (q()) {
            com.haier.uhome.usdk.base.d.c.a().a(this.f28190p, 5000L);
        } else {
            t();
        }
    }

    private void o() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "processDiscoverService. State = %s, Count =%d, mtu = %d", j(), Integer.valueOf(this.f28194v), Integer.valueOf(this.f28195x));
        a();
        int i7 = i();
        if (i7 == 0) {
            v();
            return;
        }
        if (i7 == 1) {
            w();
            return;
        }
        if (i7 != 2 && i7 != 3) {
            if (i7 != 4) {
                return;
            }
            y();
        } else if (this.f28194v >= 3) {
            c(ErrorConst.ERR_USDK_TIMEOUT);
        } else if (r()) {
            com.haier.uhome.usdk.base.d.c.a().a(this.f28191q, RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT);
        } else {
            u();
        }
    }

    private boolean p() {
        this.f28192r++;
        return d();
    }

    private boolean q() {
        this.f28193t++;
        return b(512);
    }

    private boolean r() {
        this.f28194v++;
        return f();
    }

    private void s() {
        h();
    }

    private void t() {
        a();
        this.f28188n.f31263b = 21;
        com.haier.uhome.usdk.base.d.c.a().c(this.f28188n);
    }

    private void u() {
        a();
        this.f28188n.f31263b = 22;
        com.haier.uhome.usdk.base.d.c.a().c(this.f28188n);
    }

    private void v() {
        a();
        this.f28188n.f31263b = 1;
        com.haier.uhome.usdk.base.d.c.a().a(this.f28188n, 100L);
    }

    private void w() {
        a();
        this.f28188n.f31263b = 2;
        com.haier.uhome.usdk.base.d.c.a().a(this.f28188n, 100L);
    }

    private void x() {
        a();
        this.f28188n.f31263b = 3;
        com.haier.uhome.usdk.base.d.c.a().a(this.f28188n, 100L);
    }

    private void y() {
        this.f28192r = 0;
        this.f28193t = 0;
        this.f28194v = 0;
        String strG = g();
        if (com.haier.library.common.util.c.c("[]", strG)) {
            a(ErrorConst.ERR_INTERNAL);
        } else {
            a(com.haier.uhome.ble.a.f28149w, strG);
            a(ErrorConst.RET_USDK_OK);
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a
    protected void a() {
        super.a();
        com.haier.uhome.usdk.base.d.c.a().d(this.f28188n);
        com.haier.uhome.usdk.base.d.c.a().d(this.f28189o);
        com.haier.uhome.usdk.base.d.c.a().d(this.f28190p);
        com.haier.uhome.usdk.base.d.c.a().d(this.f28191q);
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a
    public void b() {
        this.f28192r = 0;
        this.f28193t = 0;
        this.f28194v = 0;
        m();
    }

    public String toString() {
        return "BleConnectReq{}";
    }

    private void c(ErrorConst errorConst) {
        s();
        a(errorConst);
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a
    public void b(com.haier.uhome.usdk.base.d.d dVar) {
        super.b(dVar);
        if (this != dVar.f31264c) {
            return;
        }
        int i7 = dVar.f31263b;
        if (i7 == 1) {
            m();
            return;
        }
        if (i7 == 2) {
            n();
            return;
        }
        if (i7 == 3) {
            o();
            return;
        }
        if (i7 == 21) {
            w();
            return;
        }
        if (i7 != 22) {
            switch (i7) {
                case 11:
                    c(11);
                    break;
                case 12:
                    this.f28192r = 0;
                    c(12);
                    break;
                case 13:
                    this.f28193t = 0;
                    this.f28192r = 0;
                    c(13);
                    break;
            }
            return;
        }
        x();
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a, com.haier.uhome.ble.hal.a.a.f
    public void a(int i7, int i8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onConnectionStateChange. status = %d, newState = %d", Integer.valueOf(i7), Integer.valueOf(i8));
        com.haier.uhome.usdk.base.d.c.a().d(this.f28189o);
        if (2 == i8) {
            this.f28188n.f31263b = 2;
            com.haier.uhome.usdk.base.d.c.a().a(this.f28188n, 100L);
        } else {
            a();
            v();
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a, com.haier.uhome.ble.hal.a.a.f
    public void a(int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onServicesDiscovered. status = %d", Integer.valueOf(i7));
        com.haier.uhome.usdk.base.d.c.a().d(this.f28191q);
        if (i7 == 0) {
            y();
        } else {
            x();
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a, com.haier.uhome.ble.hal.a.a.f
    public void b(int i7, int i8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onMtuChanged. mtu = %d, status = %d", Integer.valueOf(i7), Integer.valueOf(i8));
        com.haier.uhome.usdk.base.d.c.a().d(this.f28190p);
        if (i8 == 0) {
            this.f28195x = i7;
            this.f28188n.f31263b = 3;
            com.haier.uhome.usdk.base.d.c.a().a(this.f28188n, 100L);
        } else {
            a();
            w();
        }
    }
}
