package n4;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import com.realsil.sdk.mesh.CoreMesh;
import com.realsil.sdk.mesh.RtkMeshManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Context f37534p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static b f37535q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f37536r = 240;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q4.a f37537a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f37539c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<o4.a> f37541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o4.b f37542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f37543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f37544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f37545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f37546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f37547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f37548l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q4.c f37549m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ScheduledExecutorService f37550n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f37551o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f37538b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f37540d = Executors.newSingleThreadExecutor();

    public class a extends q4.c {

        /* JADX INFO: renamed from: n4.b$a$a, reason: collision with other inner class name */
        public class RunnableC0497a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f37553a;

            public RunnableC0497a(byte[] bArr) {
                this.f37553a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                byte[] bArr = this.f37553a;
                bVar.s0((byte) 0, bArr, (short) bArr.length);
            }
        }

        /* JADX INFO: renamed from: n4.b$a$b, reason: collision with other inner class name */
        public class RunnableC0498b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f37555a;

            public RunnableC0498b(byte[] bArr) {
                this.f37555a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                byte[] bArr = this.f37555a;
                bVar.s0((byte) 1, bArr, (short) bArr.length);
            }
        }

        public a() {
        }

        @Override // q4.c
        public void a(int i7) {
            super.a(i7);
            int unused = b.f37536r = i7;
        }

        @Override // q4.c
        public void b(byte[] bArr) {
            k4.b.p("onProvIn");
            super.b(bArr);
            b.this.f37540d.execute(new RunnableC0497a(bArr));
        }

        @Override // q4.c
        public void c(boolean z7) {
            super.c(z7);
            b.this.f37539c = true;
            synchronized (b.this.f37538b) {
                b.this.f37538b.notifyAll();
            }
            k4.b.e("onProvOut status: " + z7);
        }

        @Override // q4.c
        public void d(byte[] bArr) {
            k4.b.p("onProxyIn");
            super.d(bArr);
            b.this.f37540d.execute(new RunnableC0498b(bArr));
        }

        @Override // q4.c
        public void e(boolean z7) {
            super.e(z7);
            b.this.f37539c = true;
            synchronized (b.this.f37538b) {
                b.this.f37538b.notifyAll();
            }
            k4.b.e("onProxyOut status: " + z7);
        }
    }

    /* JADX INFO: renamed from: n4.b$b, reason: collision with other inner class name */
    public class RunnableC0499b implements Runnable {
        public RunnableC0499b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k4.b.e("scheduledExecutorService isAddAppkeying = " + b.this.f37546j);
            if (b.this.f37546j) {
                b.F().Q(com.google.common.base.c.f19321u, 0, 0);
                k4.b.e("scheduledExecutorService mesh configuration add app key is fail");
            }
        }
    }

    public class c extends Thread {
        public c() {
        }

        public byte A(int i7, int i8, byte[] bArr, int i9, int i10) {
            return CoreMesh.sendModelData(i7, (short) i8, bArr, i9, i10);
        }

        public void B(short s7, short s8, byte b8) {
            k4.b.e("setCfgNodeIdentity dst = " + ((int) s7) + " net_key_index = " + ((int) s8) + " identity = " + ((int) b8));
            CoreMesh.setCfgNodeIdentity(s7, s8, b8);
        }

        public void C(byte[] bArr, int i7, int i8) {
            k4.b.p("start set Light Color");
            CoreMesh.light_cwrgb_set(null, (short) i7, (short) i8, bArr, false);
        }

        public void D(boolean z7, String str) {
            CoreMesh.setMeshJniLog(z7, str);
        }

        public void E(int i7) {
            CoreMesh.setTtlValue((short) i7);
        }

        public void a(List<r4.a> list) {
            CoreMesh.addDevKey(list);
        }

        public void b(short s7, short s8, short s9, byte[] bArr) {
            k4.b.e("appKeyAdd");
            b.this.f(true);
            CoreMesh.AppKeyAdd(s7, s8, s9, bArr);
            b.this.d();
        }

        public void c(short s7) {
            CoreMesh.CfgClientSetNetKeyIndex(s7);
        }

        public void d(short s7, byte b8) {
            CoreMesh.CompoDataGet(s7, b8);
        }

        public void e(byte b8) {
            CoreMesh.noticeMeshProtocalConnected(b8);
        }

        public void f(byte b8) {
            CoreMesh.noticeMeshProtocalDisConnected(b8);
        }

        public void g(int i7, int i8) {
            k4.b.p("start get Light Color");
            CoreMesh.light_cwrgb_get((short) i7, (short) i8);
        }

        public byte[] h(byte[] bArr, byte[] bArr2, int i7) {
            return CoreMesh.identityHashGen(bArr, bArr2, (short) i7);
        }

        public byte[] i(byte[] bArr) {
            return CoreMesh.identityKeyGen(bArr);
        }

        public void j(short s7, int i7, short s8, boolean z7, int i8) {
            CoreMesh.CfgModelSubAdd(s7, (short) (i8 + s7), z7, (short) (s8 + 49152), i7);
        }

        public void k(short s7, byte[] bArr, byte[] bArr2, long j7, long j8) {
            CoreMesh.meshChangeNetwork(s7, bArr, bArr2, j7, j8);
        }

        public void l(short s7, int i7, short s8, boolean z7, int i8) {
            CoreMesh.CfgModelSubDelete(s7, (short) (i8 + s7), z7, (short) (s8 + 49152), i7);
        }

        public void m(byte b8, byte[] bArr, int i7) {
            k4.b.e("meshInviteDevice oobAuthValue = " + m4.a.b(bArr));
            CoreMesh.ProvInvite(b8, bArr, i7);
        }

        public boolean n(short s7, int i7, short s8) {
            return CoreMesh.MeshModelSub(s7, i7, s8);
        }

        public void o(boolean z7, int i7, int i8, byte b8) {
            CoreMesh.generic_on_off_set((short) i7, (short) i8, z7, b8, false);
        }

        public int p(short s7, byte[] bArr, byte[] bArr2, List<r4.a> list, long j7, long j8) {
            k4.b.e("meshStackInit netKey = " + m4.a.b(bArr) + " src = " + ((int) s7) + " appKey = " + m4.a.b(bArr2) + " ivIndex = " + j7 + " seqNum = " + j8 + " isMeshStackInit = " + b.this.f37544h);
            b.this.f37543g = bArr;
            if (b.this.f37544h.booleanValue()) {
                return 3;
            }
            if ((s7 > Short.MAX_VALUE) || (s7 < 1)) {
                k4.b.e("meshStackInit src = " + ((int) s7));
                return 1;
            }
            if (j7 >= 0) {
                b.this.q(bArr);
                CoreMesh.MeshStackInit(s7, bArr, bArr2, list, j7, j8);
                b.this.f37544h = Boolean.TRUE;
                return 0;
            }
            k4.b.e("meshStackInit ivIndex = " + j7);
            return 2;
        }

        public void q() {
            CoreMesh.UnprovisioningCmd();
        }

        public boolean r(short s7, int i7) {
            return CoreMesh.MeshModelRegister(s7, i7);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            b.this.h0();
        }

        public void s(short s7, short s8, short s9, int i7) {
            k4.b.e("modelAppBind");
            b.this.o(true);
            CoreMesh.ModelAppBind(s7, s8, s9, i7);
        }

        public byte t(short s7, short s8, short s9, int i7) {
            return CoreMesh.ModelAppUnbind(s7, s8, s9, i7);
        }

        public boolean u(short s7, boolean z7, short[] sArr, short s8) {
            return CoreMesh.ProxyCfgAddRemoveAddr(s7, z7, sArr, s8);
        }

        public boolean v(int i7) {
            k4.b.p("proxyCfgSetFilterType typeId = " + i7);
            return CoreMesh.proxyCfgSetFilterType(0, i7);
        }

        public byte w(short s7) {
            k4.b.p("proxyFilterAddAddr nodeAddress = " + ((int) s7));
            return CoreMesh.proxyFilterAddAddr(0, s7);
        }

        public byte x(short s7) {
            k4.b.p("proxyFilterRemoveAddr nodeAddress = " + ((int) s7));
            return CoreMesh.proxyFilterRemoveAddr(0, s7);
        }

        public boolean y(byte b8, byte[] bArr, short s7) {
            return CoreMesh.ProxyReceive(b8, bArr, s7);
        }

        public void z(short s7) {
            CoreMesh.NodeReset(s7);
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    public b(Context context) {
        new Handler();
        this.f37543g = new byte[]{0};
        this.f37544h = Boolean.FALSE;
        this.f37545i = false;
        this.f37546j = false;
        this.f37547k = false;
        this.f37548l = new c(this, null);
        this.f37549m = new a();
        this.f37550n = null;
        f37534p = context;
        this.f37541e = new CopyOnWriteArrayList();
        q4.a aVarY = RtkMeshManager.z().y();
        this.f37537a = aVarY;
        aVarY.F(this.f37549m);
        this.f37548l.start();
    }

    public static String E() {
        return p4.b.c(f37534p);
    }

    public static b F() {
        return f37535q;
    }

    public static int H() {
        return f37536r;
    }

    public static void N(Context context) {
        if (f37535q == null) {
            f37535q = new b(context);
        }
    }

    public static void P(byte[] bArr) {
        k4.b.p("<< >> " + m4.a.b(bArr));
    }

    public static void x() {
        RtkMeshManager.z().t();
    }

    public String A() {
        if (f37534p == null) {
            return "";
        }
        String str = f37534p.getFilesDir().getAbsolutePath() + "/flash" + m4.a.a(this.f37551o) + ".bin";
        k4.b.p("filePath:" + str);
        return str;
    }

    public void A0(byte[] bArr, int i7, int i8) {
        this.f37548l.C(bArr, i7, i8);
    }

    public boolean B() {
        return this.f37546j;
    }

    public void B0(o4.b bVar) {
        this.f37542f = bVar;
    }

    public boolean C() {
        return this.f37547k;
    }

    public void C0(boolean z7, String str) {
        this.f37548l.D(z7, str);
    }

    public BluetoothDevice D(String str) {
        q4.a aVar = this.f37537a;
        if (aVar != null) {
            return aVar.y(str);
        }
        return null;
    }

    public void D0(boolean z7) {
        this.f37545i = z7;
    }

    public void E0(int i7) {
        this.f37548l.E(i7);
    }

    public void F0(o4.a aVar) {
        List<o4.a> list = this.f37541e;
        if (list != null) {
            list.remove(aVar);
        }
    }

    public void G(int i7, int i8) {
        this.f37548l.g(i7, i8);
    }

    public byte[] I() {
        return this.f37551o;
    }

    public byte[] J() {
        k4.b.e("getNetkey,currentNetKey = " + m4.a.a(this.f37543g));
        return this.f37543g;
    }

    public boolean K() {
        return this.f37545i;
    }

    public byte[] L(byte[] bArr, byte[] bArr2, int i7) {
        return this.f37548l.h(bArr, bArr2, (short) i7);
    }

    public byte[] M(byte[] bArr) {
        return this.f37548l.i(bArr);
    }

    public void O(long j7) {
        k4.b.e("ivUpdateFlagNotification ivUpdateIndex= " + j7);
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().ivUpdateFlagNotification(j7);
            }
        }
    }

    public void Q(byte b8, int i7, int i8) {
        k4.b.e("meshAddAppKeyComplete res = " + ((int) b8) + " netKeyIndex = " + i7 + " appKeyIndex = " + i8);
        this.f37546j = false;
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().meshAddAppKeyComplete(b8, i7, i8);
            }
        }
    }

    public void R(short s7, int i7, short s8, boolean z7, int i8) {
        this.f37548l.j(s7, i7, s8, z7, i8);
    }

    public void S(byte b8, int i7, int i8, int i9) {
        k4.b.e("meshBindModelToAppComplete res = " + ((int) b8) + " model = " + i7 + " appKeyIndex = " + i8 + " element = " + i9);
        this.f37547k = false;
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().meshBindModelToAppComplete(b8, i7, i8, i9);
            }
        }
    }

    public void T(int i7, int i8, int i9, int i10) {
        o4.b bVar = this.f37542f;
        if (bVar != null) {
            bVar.meshBindModelToGroupSuccess(i7 == 0);
        }
    }

    public void U(byte b8, int i7, int i8) {
        k4.b.e("meshCfgNodeIdentityStatComplete status = " + ((int) b8) + " identity = " + i7 + " netKeyIndex = " + i8);
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().meshCfgNodeIdentityStatComplete(b8, i7, i8);
            }
        }
    }

    public void V(short s7, byte[] bArr, byte[] bArr2, long j7, long j8) {
        this.f37548l.k(s7, bArr, bArr2, j7, j8);
    }

    public void W(short s7, int i7, short s8, boolean z7, int i8) {
        this.f37548l.l(s7, i7, s8, z7, i8);
    }

    public void X(byte b8, byte[] bArr, int i7) {
        this.f37548l.m(b8, bArr, i7);
    }

    public void Y(byte b8) {
        k4.b.p("meshLightOnOffState = " + ((int) b8));
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().meshLightOnOffState(b8);
            }
        }
    }

    public void Z(byte[] bArr) {
        k4.b.e("meshLightUpdateState = " + m4.a.b(bArr));
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().meshLightUpdateState(bArr);
            }
        }
    }

    public boolean a0(short s7, int i7, short s8) {
        return this.f37548l.n(s7, i7, s8);
    }

    public void b0() {
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().meshResetNodeResult(true);
            }
        }
    }

    public void c0(byte b8, byte b9, byte[] bArr, short s7, byte b10, String str) {
        k4.b.e("meshProvsionComplete failType = " + ((int) b8) + " failReason = " + ((int) b9) + " devKey = " + m4.a.b(bArr) + " addr = " + ((int) s7) + " elementNum = " + ((int) b10) + " bleAddr = " + str);
        this.f37545i = false;
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().meshProvsionComplete(b8, b9, bArr, s7, b10, str);
                if (RtkMeshManager.z().p() > 1) {
                    String strB = p4.b.b(f37534p);
                    k4.b.e("meshProvsionComplete connectedDeviceSize() > 1 preProxyAddr = " + strB);
                    if (strB != null) {
                        RtkMeshManager.z().u(strB);
                        RtkMeshManager.z().n(strB);
                    }
                }
            }
        }
    }

    public final void d() {
        if (this.f37550n == null) {
            this.f37550n = Executors.newSingleThreadScheduledExecutor();
        }
        this.f37550n.schedule(new RunnableC0499b(), 3L, TimeUnit.SECONDS);
    }

    public boolean d0(byte[] bArr, boolean z7) {
        k4.b.e("meshSend bIsProv = " + z7);
        return z7 ? g(bArr) : p(bArr);
    }

    public void e0(byte[] bArr, byte[] bArr2, int i7, int i8, int i9) {
        k4.b.e("meshSendVendorModelData cwrgb= " + m4.a.b(bArr));
        byte[] bArrI = i(bArr2, bArr);
        w0(i7, i8, bArrI, bArrI.length, i9);
    }

    public final void f(boolean z7) {
        this.f37546j = z7;
    }

    public void f0(boolean z7, int i7, int i8, byte b8) {
        this.f37548l.o(z7, i7, i8, b8);
    }

    public final boolean g(byte[] bArr) {
        k4.b.p("ProvOut:" + m4.a.a(bArr));
        synchronized (this.f37538b) {
            this.f37539c = false;
            try {
                boolean zA = this.f37537a.a(bArr);
                k4.b.e("ProvOut,sendResult = " + zA);
                if (!zA) {
                    int i7 = 0;
                    while (i7 < 3) {
                        i7++;
                        Thread.sleep(100L);
                        zA = this.f37537a.a(bArr);
                        if (zA) {
                            break;
                        }
                    }
                    if (!zA) {
                        k4.b.e("ProvOut false");
                        return false;
                    }
                }
                k4.b.e("ProvOut wait for mGattCallbackCalled = " + this.f37539c);
                if (!this.f37539c) {
                    k4.b.e("ProvOut wait for 2000ms");
                    this.f37538b.wait(com.haier.uhome.ble.hal.a.b.a.f28246a);
                    if (!this.f37539c) {
                        k4.b.e("ProvOut wait time reached");
                        return false;
                    }
                }
                return zA;
            } catch (InterruptedException e8) {
                k4.b.h(e8.toString());
                return false;
            }
        }
    }

    public int g0(short s7, byte[] bArr, byte[] bArr2, List<r4.a> list, long j7, long j8) {
        return this.f37548l.p(s7, bArr, bArr2, list, j7, j8);
    }

    public void h0() {
        CoreMesh.meshStartQueueAndCustomer();
    }

    public final byte[] i(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public void i0() {
        this.f37548l.q();
    }

    public void j(List<r4.a> list) {
        this.f37548l.a(list);
    }

    public boolean j0(short s7, int i7) {
        return this.f37548l.r(s7, i7);
    }

    public void k(short s7, short s8, short s9, byte[] bArr) {
        this.f37548l.b(s7, s8, s9, bArr);
    }

    public void k0(short s7, short s8, short s9, int i7) {
        this.f37548l.s(s7, s8, s9, i7);
    }

    public byte l0(short s7, short s8, short s9, int i7) {
        return this.f37548l.t(s7, s8, s9, i7);
    }

    public void m0(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, byte[] bArr) {
        k4.b.e("onVendorModelData modelId = " + i7 + " dst = " + i8 + " src = " + i9 + " elementIndex = " + i10 + " ttl = " + i11 + " rssi = " + i12 + " seq = " + i13 + " appKeyIndex = " + i14 + " netKeyIndex = " + i15 + " modelData = " + m4.a.b(bArr));
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().onVendorModelData(i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, bArr);
            }
        }
    }

    public void n0(int i7) {
        k4.b.e("onVendorModelDatatrans status = " + i7);
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().onVendorModelDatatrans(i7);
            }
        }
    }

    public final void o(boolean z7) {
        this.f37547k = z7;
    }

    public boolean o0(short s7, boolean z7, short[] sArr, short s8) {
        return this.f37548l.u(s7, z7, sArr, s8);
    }

    public final boolean p(byte[] bArr) {
        k4.b.e("ProxyOut:" + m4.a.a(bArr));
        synchronized (this.f37538b) {
            this.f37539c = false;
            try {
                boolean zB = this.f37537a.b(bArr);
                k4.b.e("ProxyOut,sendResult = " + zB);
                if (!zB) {
                    int i7 = 0;
                    while (i7 < 3) {
                        i7++;
                        Thread.sleep(100L);
                        zB = this.f37537a.b(bArr);
                        if (zB) {
                            break;
                        }
                    }
                    if (!zB) {
                        k4.b.e("ProxyOut false");
                        return false;
                    }
                }
                k4.b.e("ProxyOut wait for mGattCallbackCalled = " + this.f37539c);
                if (!this.f37539c) {
                    k4.b.e("ProxyOut wait for 2000ms");
                    this.f37538b.wait(com.haier.uhome.ble.hal.a.b.a.f28246a);
                    k4.b.e("ProxyOut wait for 2000ms mGattCallbackCalled = " + this.f37539c);
                    if (!this.f37539c) {
                        k4.b.e("ProxyOut wait time reached");
                        return false;
                    }
                }
                return zB;
            } catch (InterruptedException e8) {
                k4.b.h(e8.toString());
                return false;
            }
        }
    }

    public boolean p0(int i7) {
        return this.f37548l.v(i7);
    }

    public final void q(byte[] bArr) {
        k4.b.e("netKey = " + m4.a.b(bArr));
        this.f37551o = CoreMesh.MeshK3(bArr);
        k4.b.e("netId = " + m4.a.b(this.f37551o));
    }

    public byte q0(short s7) {
        return this.f37548l.w(s7);
    }

    public byte r0(short s7) {
        return this.f37548l.x(s7);
    }

    public boolean s0(byte b8, byte[] bArr, short s7) {
        return this.f37548l.y(b8, bArr, s7);
    }

    public void t(short s7) {
        this.f37548l.c(s7);
    }

    public void t0(int i7, int i8, short s7) {
        k4.b.e("receiveProxyConfigurationMessage src = " + i7 + " filterType = " + i8 + " listSize = " + ((int) s7));
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().receiveProxyConfigurationMessage(i7, i8, s7);
            }
        }
    }

    public void u(short s7, byte b8) {
        this.f37548l.d(s7, b8);
    }

    public void u0(o4.a aVar) {
        if (this.f37541e == null) {
            this.f37541e = new CopyOnWriteArrayList();
        }
        if (this.f37541e.contains(aVar)) {
            return;
        }
        this.f37541e.add(aVar);
    }

    public void v(byte b8) {
        this.f37548l.e(b8);
    }

    public void v0(short s7) {
        this.f37548l.z(s7);
    }

    public byte w0(int i7, int i8, byte[] bArr, int i9, int i10) {
        return this.f37548l.A(i7, i8, bArr, i9, i10);
    }

    public void x0(int i7) {
        k4.b.e("seqNumberNotification seqNumber = " + i7);
        List<o4.a> list = this.f37541e;
        if (list != null) {
            Iterator<o4.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().seqNumberNotification(i7);
            }
        }
    }

    public void y(byte b8) {
        this.f37548l.f(b8);
    }

    public void y0(short s7, short s8, byte b8) {
        this.f37548l.B(s7, s8, b8);
    }

    public void z0(boolean z7) {
        this.f37544h = Boolean.valueOf(z7);
    }
}
