package com.realsil.sdk.mesh;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import android.text.TextUtils;
import h4.j;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class RtkMeshManager {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static RtkMeshManager f33245o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Context f33246p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f33247q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f33248r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f33249s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f33250t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f33251u = 4;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Object f33252v = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f33253w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f33254x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f33255y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q4.a f33256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f33257b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t4.c f33259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MeshReceiver f33260e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n4.d f33262g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f33258c = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f33261f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f33263h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f33264i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f33265j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f33266k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q4.b f33267l = new c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f33268m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t4.a f33269n = new d();

    public class MeshReceiver extends BroadcastReceiver {
        public MeshReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                k4.b.q(true, "ACTION_STATE_CHANGED: state: " + intExtra);
                if (intExtra == 12) {
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e8) {
                        e8.printStackTrace();
                    }
                    RtkMeshManager.this.L();
                    if (RtkMeshManager.this.f33262g != null) {
                        RtkMeshManager.this.f33262g.onBtOn();
                        return;
                    }
                    return;
                }
                if (intExtra == 13) {
                    RtkMeshManager.this.N();
                    return;
                }
                if (intExtra == 10) {
                    k4.b.s("May be close bluetooth, but not disconnect, something may be error!");
                    k4.b.s("isConnected = " + RtkMeshManager.this.f33261f);
                    if (RtkMeshManager.this.f33262g != null) {
                        RtkMeshManager.this.f33262g.onBtOff();
                    }
                    if (n4.b.F().K()) {
                        k4.b.t(true, "BT is STATE_OFF, isProvisioning fail");
                        n4.b.F().c0(com.google.common.base.c.f19321u, (byte) 0, null, (short) 0, (byte) 0, null);
                    } else if (n4.b.F().B()) {
                        k4.b.t(true, "BT is STATE_OFF, isAddAppkeying fail");
                        n4.b.F().Q(com.google.common.base.c.f19321u, 0, 0);
                    } else if (n4.b.F().C()) {
                        k4.b.t(true, "BT is STATE_OFF, isAddAppkeying fail");
                        n4.b.F().S(com.google.common.base.c.f19321u, 0, 0, 0);
                    }
                    RtkMeshManager.this.t();
                    RtkMeshManager.this.m();
                }
            }
        }

        public /* synthetic */ MeshReceiver(RtkMeshManager rtkMeshManager, a aVar) {
            this();
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f33272b;

        public a(String str, long j7) {
            this.f33271a = str;
            this.f33272b = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7 = 0;
            while (i7 < 3 && RtkMeshManager.this.f33257b != 2) {
                k4.b.e("reTryNum =" + i7);
                RtkMeshManager.this.f33256a.o(this.f33271a, RtkMeshManager.this.f33267l);
                Object obj = RtkMeshManager.f33252v;
                synchronized (obj) {
                    try {
                        obj.wait(this.f33272b);
                        if (RtkMeshManager.this.f33257b != 2) {
                            k4.b.e("reTryNum mConnState = " + RtkMeshManager.this.f33257b);
                            RtkMeshManager.this.n(this.f33271a);
                            RtkMeshManager.this.d(500L);
                        }
                    } catch (InterruptedException e8) {
                        e8.printStackTrace();
                    }
                }
                i7++;
            }
            if (i7 == 3 && RtkMeshManager.this.f33257b != 2 && RtkMeshManager.f33255y == 1) {
                k4.b.e("reTryNum == 3 meshProvsionComplete is fail");
                n4.b.F().c0((byte) 1, (byte) 0, null, (short) 0, (byte) 0, null);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33274a;

        public b(String str) {
            this.f33274a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7 = 0;
            while (i7 < 3 && RtkMeshManager.this.f33257b != 2) {
                k4.b.e("reTryNum =" + i7);
                RtkMeshManager.this.f33256a.o(this.f33274a, RtkMeshManager.this.f33267l);
                Object obj = RtkMeshManager.f33252v;
                synchronized (obj) {
                    try {
                        obj.wait(9500L);
                        if (RtkMeshManager.this.f33257b != 2) {
                            k4.b.e("reTryNum mConnState = " + RtkMeshManager.this.f33257b);
                            RtkMeshManager.this.n(this.f33274a);
                            RtkMeshManager.this.d(500L);
                        }
                    } catch (InterruptedException e8) {
                        e8.printStackTrace();
                    }
                }
                i7++;
            }
            if (i7 == 3 && RtkMeshManager.this.f33257b != 2 && RtkMeshManager.f33255y == 1) {
                k4.b.e("reTryNum == 3 meshProvsionComplete is fail");
                n4.b.F().c0((byte) 1, (byte) 0, null, (short) 0, (byte) 0, null);
            }
        }
    }

    public class c extends q4.b {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n4.b.F().X(RtkMeshManager.this.f33263h, RtkMeshManager.this.f33264i, RtkMeshManager.this.f33265j);
            }
        }

        public c() {
        }

        @Override // q4.b
        public void a(String str, boolean z7) {
            super.a(str, z7);
            k4.b.e("address: " + str + ", newState: " + z7 + ", connectType: " + RtkMeshManager.f33255y);
            if (!z7) {
                RtkMeshManager.this.f33261f = false;
                RtkMeshManager.this.c(4, true);
                Object obj = RtkMeshManager.f33252v;
                synchronized (obj) {
                    obj.notify();
                }
                RtkMeshManager.this.n(str);
                p4.b.d(RtkMeshManager.f33246p, str);
                k4.b.e("managerCallback = " + RtkMeshManager.this.f33262g);
                if (RtkMeshManager.this.f33262g != null) {
                    k4.b.e("onProxyDeviceDisconnected");
                    RtkMeshManager.this.f33262g.onProxyDeviceDisconnected(str);
                }
                RtkMeshManager.this.L();
                return;
            }
            RtkMeshManager.this.f33261f = true;
            RtkMeshManager.this.c(2, true);
            Object obj2 = RtkMeshManager.f33252v;
            synchronized (obj2) {
                obj2.notify();
            }
            int i7 = RtkMeshManager.f33255y;
            if (i7 == 1) {
                k4.b.e("CONNECT_TYPE_PROV onProvDeviceConnected connectedDeviceSize() = " + RtkMeshManager.this.p());
                if (RtkMeshManager.this.p() == 1) {
                    p4.b.e(RtkMeshManager.f33246p, null);
                } else if (RtkMeshManager.this.p() > 1) {
                    String strC = p4.b.c(RtkMeshManager.f33246p);
                    k4.b.e("preProxyAddr = " + strC);
                    p4.b.e(RtkMeshManager.f33246p, strC);
                }
                p4.b.f(RtkMeshManager.f33246p, str);
                if (RtkMeshManager.this.f33262g != null) {
                    RtkMeshManager.this.f33262g.onProxyDeviceConnected(str);
                }
                new Thread(new a()).start();
                return;
            }
            if (i7 == 0) {
                k4.b.e("CONNECT_TYPE_PROXY onProxyDeviceConnected connectedDeviceSize() = " + RtkMeshManager.this.p());
                p4.b.e(RtkMeshManager.f33246p, p4.b.c(RtkMeshManager.f33246p));
                p4.b.f(RtkMeshManager.f33246p, str);
                if (RtkMeshManager.this.f33262g != null) {
                    RtkMeshManager.this.f33262g.onProxyDeviceConnected(str);
                }
                if (RtkMeshManager.this.p() > 1) {
                    String strB = p4.b.b(RtkMeshManager.f33246p);
                    k4.b.e("CONNECT_TYPE_PROXY connectedDeviceSize() > 1 preProxyAddr = " + strB);
                    if (strB != null) {
                        RtkMeshManager.this.u(strB);
                        RtkMeshManager.this.n(strB);
                    }
                }
            }
        }
    }

    public class d extends t4.a {
        public d() {
        }

        @Override // t4.a
        public void onBroadcastDeviceFound(h4.b bVar) {
            super.onBroadcastDeviceFound(bVar);
            BluetoothDevice bluetoothDevice = bVar.f34047a;
            j jVar = bVar.f34054h;
            String strC = p4.b.c(RtkMeshManager.f33246p);
            if (strC == null || !strC.equals(bluetoothDevice.getAddress())) {
                return;
            }
            byte[] bArrI = jVar.i(new ParcelUuid(q4.a.f40121r));
            if (RtkMeshManager.this.f33262g != null) {
                RtkMeshManager.this.f33262g.onBroadcastDeviceFound(strC, bArrI);
            }
        }

        @Override // t4.a
        public void onScanStateChanged(boolean z7) {
            super.onScanStateChanged(z7);
        }
    }

    public RtkMeshManager(Context context) {
        f33246p = context.getApplicationContext();
        this.f33256a = new q4.a(f33246p);
        this.f33259d = new t4.c(f33246p, this.f33266k);
    }

    public static void B(Context context) {
        b4.d.e(context, new b4.c.b().b(true).e(false).a());
        if (f33245o == null) {
            f33245o = new RtkMeshManager(context);
        }
        n4.b.N(context);
    }

    public static void C(Context context, String str, boolean z7, int i7) {
        b4.d.e(context, new b4.c.b().b(true).e(z7).d(str).c(i7).a());
        if (f33245o == null) {
            f33245o = new RtkMeshManager(context);
        }
        n4.b.N(context);
    }

    public static RtkMeshManager z() {
        return f33245o;
    }

    public boolean D() {
        k4.b.p("isConnected: " + this.f33261f);
        if (p() >= 1) {
            this.f33261f = true;
        }
        return this.f33261f;
    }

    public boolean E(int i7, byte[] bArr, byte[] bArr2) {
        k4.b.p("isNodeIdentifyAdvAddress elementAddr = " + i7 + " hashValueForAdv = " + m4.a.a(bArr) + " randomValueForAdv  = " + m4.a.a(bArr2));
        byte[] bArrM = n4.b.F().M(n4.b.F().J());
        byte[] bArrL = n4.b.F().L(bArr2, bArrM, i7);
        k4.b.p(String.format("isNodeIdentifyAdvAddress: identityKey=%s, hashValue=%s", m4.a.a(bArrM), m4.a.a(bArrL)));
        if (Arrays.equals(bArrL, bArr)) {
            k4.b.p("isNodeIdentifyAdvAddress hashValue is equals hash");
            return true;
        }
        k4.b.p("isNodeIdentifyAdvAddress hashValue is not equals hash");
        return false;
    }

    public void F(String str, byte b8, byte[] bArr, int i7, long j7) {
        k4.b.e("meshInviteDeviceProvision oobAuthValue = " + m4.a.b(bArr));
        n4.b.F().D0(true);
        f33255y = 1;
        this.f33263h = b8;
        this.f33264i = bArr;
        this.f33265j = i7;
        g(str, j7);
    }

    public void G() {
        k4.b.p("registerMeshReceiver");
        this.f33260e = new MeshReceiver(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        f33246p.registerReceiver(this.f33260e, intentFilter);
    }

    public void H(int i7) {
        this.f33259d.d(i7, this.f33269n);
    }

    public void I(String str, boolean z7, int i7) {
        k4.b.e("setLogConfig");
        k4.b.f34437j = i7;
        k4.b.n(str, z7);
        n4.b.F().C0(z7, str);
    }

    public void J(n4.d dVar) {
        this.f33262g = dVar;
    }

    public void K(boolean z7) {
        this.f33268m = z7;
    }

    public void L() {
        if (this.f33268m) {
            if (this.f33261f) {
                N();
                return;
            }
            String strC = p4.b.c(f33246p);
            if (TextUtils.isEmpty(strC)) {
                H(2);
                return;
            }
            k4.b.f(true, "startAutoConnect bondedDeviceAddr: " + strC);
            o(strC);
        }
    }

    public void M() {
        k4.b.e("startAutoConnect isConnected = " + this.f33261f);
        if (this.f33261f) {
            N();
            return;
        }
        String strA = p4.b.a(f33246p);
        k4.b.e("startAutoConnect bondedDeviceAddr: " + strA);
        if (TextUtils.isEmpty(strA)) {
            H(2);
        } else {
            o(strA);
        }
    }

    public void N() {
        k4.b.p("stopAutoConnect()");
        this.f33259d.i();
    }

    public void O() {
        k4.b.q(true, "unregisterMeshReceiver");
        MeshReceiver meshReceiver = this.f33260e;
        if (meshReceiver != null) {
            f33246p.unregisterReceiver(meshReceiver);
        }
        this.f33260e = null;
    }

    public void c(int i7, boolean z7) {
        synchronized (this.f33258c) {
            if (i7 != this.f33257b) {
                k4.b.e(String.format("mConnState 0x%04X > 0x%04X", Integer.valueOf(this.f33257b), Integer.valueOf(i7)));
                this.f33257b = i7;
            }
        }
        if (!z7 || this.f33262g == null) {
            return;
        }
        k4.b.e("notifyConnStateChanged mConnState = " + this.f33257b);
        this.f33262g.onConnectionStateChanged(this.f33257b);
    }

    public final void d(long j7) {
        try {
            Thread.sleep(j7);
        } catch (InterruptedException e8) {
            k4.b.e("e.toString() = " + e8.toString());
        }
    }

    public final void f(String str) {
        N();
        k4.b.e("connect to " + str);
        c(1, true);
        k4.b.e("isConnected " + this.f33261f + " mConnState = " + this.f33257b);
        if (this.f33256a != null) {
            new Thread(new b(str)).start();
        } else {
            k4.b.e("GattLayer == null");
        }
    }

    public final void g(String str, long j7) {
        N();
        k4.b.e("connect to " + str);
        c(1, true);
        k4.b.e("isConnected " + this.f33261f + " mConnState = " + this.f33257b);
        if (this.f33256a != null) {
            new Thread(new a(str, j7)).start();
        } else {
            k4.b.e("GattLayer == null");
        }
    }

    public boolean k(String str) {
        boolean zEquals;
        k4.b.p("changeProxy deviceAddress: " + str);
        String strC = p4.b.c(f33246p);
        k4.b.p("changeProxy curProxyAddr: " + strC);
        if (strC != null) {
            zEquals = strC.equals(str);
        } else {
            zEquals = strC == null && str == null;
        }
        if (zEquals) {
            return false;
        }
        if (str == null) {
            return true;
        }
        f33255y = 0;
        f(str);
        return true;
    }

    public boolean l(String str, long j7) {
        boolean zEquals;
        k4.b.p("changeProxy deviceAddress: " + str);
        String strC = p4.b.c(f33246p);
        k4.b.p("changeProxy curProxyAddr: " + strC);
        if (strC != null) {
            zEquals = strC.equals(str);
        } else {
            zEquals = strC == null && str == null;
        }
        if (zEquals) {
            return false;
        }
        if (str == null) {
            return true;
        }
        f33255y = 0;
        g(str, j7);
        return true;
    }

    public void m() {
        k4.b.p("closeGatt()");
        q4.a aVar = this.f33256a;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void n(String str) {
        k4.b.p("closeGatt deviceAddress: " + str);
        q4.a aVar = this.f33256a;
        if (aVar != null) {
            aVar.m(str);
        }
    }

    public void o(String str) {
        f33255y = 0;
        f(str);
    }

    public int p() {
        k4.b.p("connectedDeviceSize: ");
        q4.a aVar = this.f33256a;
        if (aVar != null) {
            return aVar.p();
        }
        return 0;
    }

    public void r() {
        k4.b.p("disconnectAndCloseGatt()");
        t();
        m();
    }

    public void s(String str) {
        k4.b.p("disconnectAndCloseGatt deviceAddress = " + str);
        u(str);
        n(str);
    }

    public void t() {
        k4.b.p("disconnectGatt()");
        q4.a aVar = this.f33256a;
        if (aVar != null) {
            aVar.s();
        }
    }

    public void u(String str) {
        k4.b.p("disconnectGatt deviceAddress : " + str);
        q4.a aVar = this.f33256a;
        if (aVar != null) {
            aVar.t(str);
        }
    }

    public q4.a y() {
        return this.f33256a;
    }
}
