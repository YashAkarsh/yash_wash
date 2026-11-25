package com.haier.uhome.usdk.api;

import android.text.TextUtils;
import com.haier.uhome.mesh.api.ConfigClientModel;
import com.haier.uhome.mesh.api.MeshNetworkManager;
import com.haier.uhome.mesh.api.callback.MeshConfigCallback;
import com.haier.uhome.mesh.api.callback.MeshNetworkCallback;
import com.haier.uhome.mesh.api.model.InitNodeParam;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.haier.uhome.mesh.service.MeshNativeService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.haier.uhome.control.base.api.p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f30311h = ErrorConst.ERR_USER_BEGIN.getErrorId() + 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f30312i = 30000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f30313j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f30314k = 15000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f30315l = 15000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ScheduledFuture f30320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f30321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f30322g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private uSDKDeviceManager f30323m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.haier.uhome.control.base.a.c f30324n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile int f30326p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AtomicBoolean f30329s = new AtomicBoolean();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicBoolean f30330t = new AtomicBoolean();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ICallback<Void> f30331u = new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.a.9
        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r7) {
            for (Integer num : a.this.f30317b.keySet()) {
                a aVar = a.this;
                aVar.a(aVar.f30317b.get(num), r7);
            }
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            if (usdkerror.getCode() != a.f30311h) {
                for (Integer num : a.this.f30317b.keySet()) {
                    a aVar = a.this;
                    aVar.a((ICallback) aVar.f30317b.get(num), usdkerror);
                }
            }
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile AbstractC0375a f30316a = new d();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f30325o = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<Integer, b> f30328r = new ConcurrentHashMap();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AtomicBoolean f30327q = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.haier.library.common.thread.d f30319d = new com.haier.library.common.thread.d(f30312i);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.haier.library.common.util.j<Integer, ICallback<Void>> f30317b = new com.haier.library.common.util.j<Integer, ICallback<Void>>() { // from class: com.haier.uhome.usdk.api.a.1
        @Override // com.haier.library.common.util.j
        public void a(Integer num, ICallback<Void> iCallback) {
            e3.a.e("startMeshNet callback fail sn = %d", num);
            a.this.a((ICallback) iCallback, ErrorConst.ERR_USDK_TIMEOUT.toError());
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.haier.library.common.util.j<String, String> f30318c = new com.haier.library.common.util.j<String, String>() { // from class: com.haier.uhome.usdk.api.a.3
        @Override // com.haier.library.common.util.j
        public void a(String str, String str2) {
            e3.a.e("remove proxy address %s form unfrendyProxyAddressMap", str);
        }
    };

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.a$a, reason: collision with other inner class name */
    abstract class AbstractC0375a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile boolean f30348a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile boolean f30349b = false;

        AbstractC0375a() {
        }

        abstract void a();

        abstract boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MeshDeviceNode f30351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f30352b;

        private b() {
        }
    }

    class d extends AbstractC0375a<com.haier.uhome.control.base.a.c> {
        d() {
            super();
        }

        @Override // com.haier.uhome.usdk.api.a.AbstractC0375a
        void a() {
            if (this.f30349b) {
                e3.a.o("getMeshInfo duplicate so return", new Object[0]);
                a aVar = a.this;
                aVar.a(aVar.f30331u, new uSDKError(a.f30311h, "isRunning"));
                return;
            }
            this.f30349b = true;
            e3.a.e("MeshNetInfoGetState start", new Object[0]);
            if (a.this.f30324n == null) {
                a.this.b(new ICallback<com.haier.uhome.control.base.a.c>() { // from class: com.haier.uhome.usdk.api.a.d.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.haier.uhome.control.base.a.c cVar) {
                        e3.a.e("getMeshNetInfo success:" + cVar, new Object[0]);
                        a.this.f30324n = cVar;
                        a aVar2 = a.this;
                        aVar2.f30316a = aVar2.new c();
                        a.this.f30316a.a();
                        d.this.f30348a = true;
                        d.this.f30349b = false;
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        e3.a.e("getMeshNetInfo fail:" + usdkerror, new Object[0]);
                        d.this.f30349b = false;
                        d.this.f30348a = false;
                        a aVar2 = a.this;
                        aVar2.a(aVar2.f30331u, usdkerror);
                    }
                });
                return;
            }
            a aVar2 = a.this;
            aVar2.f30316a = aVar2.new c();
            a.this.f30316a.a();
        }

        @Override // com.haier.uhome.usdk.api.a.AbstractC0375a
        boolean b() {
            return this.f30348a;
        }
    }

    class e extends AbstractC0375a<Void> {
        e() {
            super();
        }

        @Override // com.haier.uhome.usdk.api.a.AbstractC0375a
        void a() {
            if (this.f30349b) {
                e3.a.o("getMeshInfo duplicate so return", new Object[0]);
                a aVar = a.this;
                aVar.a(aVar.f30331u, new uSDKError(a.f30311h, "isRunning"));
                return;
            }
            this.f30349b = true;
            if (this.f30348a) {
                a aVar2 = a.this;
                aVar2.a((ICallback<Object>) aVar2.f30331u, (Object) null);
            } else {
                e3.a.e("startBleMeshSearch", new Object[0]);
                com.haier.uhome.search.a.n.a().a(new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.a.e.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(Void r7) {
                        e.this.f30349b = false;
                        e.this.f30348a = true;
                        a aVar3 = a.this;
                        aVar3.a((ICallback<Void>) aVar3.f30331u, r7);
                        e3.a.e("startBleMeshSearch success", new Object[0]);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        e.this.f30349b = false;
                        a aVar3 = a.this;
                        aVar3.a(aVar3.f30331u, usdkerror);
                        e3.a.e("startBleMeshSearch failure<%s>", usdkerror);
                    }
                });
            }
        }

        @Override // com.haier.uhome.usdk.api.a.AbstractC0375a
        boolean b() {
            return this.f30348a;
        }
    }

    class f implements MeshNetworkCallback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<String> f30360b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MeshNetworkCallback f30361c;

        f(MeshNetworkCallback meshNetworkCallback) {
            this.f30361c = meshNetworkCallback;
        }

        @Override // com.haier.uhome.mesh.api.callback.MeshNetworkCallback
        public void onIvIndexUpdate(long j7) {
            this.f30361c.onIvIndexUpdate(j7);
        }

        @Override // com.haier.uhome.mesh.api.callback.MeshNetworkCallback
        public void onProxyConnected(final String str) {
            e3.a.e("OrderRTKCallback Mesh device: proxy %s connected!", str);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30605a.b(str);
                }
            });
        }

        @Override // com.haier.uhome.mesh.api.callback.MeshNetworkCallback
        public void onProxyDisConnected(final String str) {
            e3.a.e("OrderRTKCallback Mesh device: proxy %s disConnect!", str);
            this.f30361c.onProxyDisConnected(str);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.l0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30621a.a(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            synchronized (this) {
                this.f30360b.remove(str);
                if (this.f30360b.size() == 1) {
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e8) {
                        e8.printStackTrace();
                    }
                    Iterator<String> it = this.f30360b.iterator();
                    if (it.hasNext()) {
                        this.f30361c.onProxyConnected(it.next());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            synchronized (this) {
                this.f30360b.add(str);
                if (this.f30360b.size() == 1) {
                    this.f30361c.onProxyConnected(str);
                }
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(uSDKError usdkerror) {
            e3.a.e("setProxyFilterType withe list:" + usdkerror, new Object[0]);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.f30327q.get()) {
                com.haier.library.common.thread.m.stopScheduled(this);
            } else if (a.this.f30326p != -1) {
                com.haier.library.common.thread.m.stopScheduled(this);
            } else {
                ConfigClientModel.getInstance().setProxyFilterType(0, new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.api.m0
                    @Override // com.haier.uhome.usdk.base.api.s
                    public final void onCallback(uSDKError usdkerror) {
                        a.g.a(usdkerror);
                    }
                });
            }
        }
    }

    a(uSDKDeviceManager usdkdevicemanager) {
        this.f30323m = usdkdevicemanager;
        com.haier.uhome.usdk.base.c.b.a().a(new com.haier.uhome.usdk.base.c.c() { // from class: com.haier.uhome.usdk.api.g0
            @Override // com.haier.uhome.usdk.base.c.c
            public final void notifyBtStateChanged(int i7) {
                this.f30557j.a(i7);
            }
        });
        this.f30326p = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f30319d.d(new Runnable() { // from class: com.haier.uhome.usdk.api.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30457a.h();
            }
        }, !this.f30330t.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.haier.uhome.search.service.entity.g next;
        if (this.f30326p != -1) {
            return;
        }
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30480a.g();
            }
        }, f30312i, TimeUnit.MILLISECONDS);
        if (this.f30330t.get()) {
            e3.a.e("refreshProxyConnect has set node to proxy!", new Object[0]);
            return;
        }
        if (this.f30327q.get()) {
            e3.a.e("in proxyConnected so return", new Object[0]);
            return;
        }
        if (this.f30329s.get()) {
            e3.a.e("in OTA so no proxy connect", new Object[0]);
            return;
        }
        if (com.haier.uhome.usdk.bind.g.j()) {
            e3.a.e("inBinding so no proxy connect", new Object[0]);
            return;
        }
        ArrayList<com.haier.uhome.search.service.entity.g> arrayListE = com.haier.uhome.search.a.n.a().e();
        if (arrayListE.size() == 0) {
            e3.a.o("refreshProxyConnect but no proxy find ", new Object[0]);
            return;
        }
        Iterator<com.haier.uhome.search.service.entity.g> it = arrayListE.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && !TextUtils.isEmpty(next.a())) {
                if (!this.f30318c.containsKey(next.a())) {
                    break;
                } else {
                    e3.a.e("refreshProxyConnect ignore temporary proxy<%s>", next.a());
                }
            }
        }
        if (next == null) {
            next = arrayListE.get(0);
        }
        e3.a.e("refreshProxyConnect to info " + next.a(), new Object[0]);
        MeshNetworkManager.getInstance().setProxyNode(next.a(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.e0
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30512a.a(errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int i7 = this.f30326p;
        if (i7 == -1) {
            return;
        }
        if (this.f30321f + 15000 < System.currentTimeMillis()) {
            RtkCoreMeshWrapper.getInstance().closeConnect();
            e3.a.e("retry setProxyDeviceToVirtualSearch timeout so disconnect current proxy<%d>", Integer.valueOf(i7));
            return;
        }
        com.haier.uhome.control.local.d.f fVarA = com.haier.uhome.control.local.d.f.a();
        com.haier.uhome.control.local.api.d dVarD = fVarA.d();
        if (dVarD != null && dVarD.d() == i7) {
            e3.a.e("setProxyDevice but same as already one", new Object[0]);
            return;
        }
        fVarA.b(i7);
        if (fVarA.d() != null) {
            return;
        }
        ScheduledFuture scheduledFuture = this.f30320e;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.f30320e.cancel(false);
        }
        this.f30320e = com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30572a.i();
            }
        }, 1000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.haier.uhome.search.a.n.a().a(new com.haier.uhome.search.a.d() { // from class: com.haier.uhome.usdk.api.a.4
            @Override // com.haier.uhome.search.a.d
            public void a(com.haier.uhome.search.service.entity.g gVar) {
                if (a.this.f30329s.get()) {
                    return;
                }
                a.this.g();
            }

            @Override // com.haier.uhome.search.a.d
            public void b(com.haier.uhome.search.service.entity.g gVar) {
            }
        });
        ConfigClientModel.getInstance().registerCallback(new MeshConfigCallback() { // from class: com.haier.uhome.usdk.api.a.5
            @Override // com.haier.uhome.mesh.api.callback.MeshConfigCallback
            public void onGetProxyUnicast(int i7) {
                super.onGetProxyUnicast(i7);
                a.this.f30326p = i7;
                a.this.f30321f = System.currentTimeMillis();
                a.this.i();
                e3.a.e("current proxy address %d", Integer.valueOf(a.this.f30326p));
            }
        });
        MeshNetworkManager.getInstance().setNetworkCallback(new f(new MeshNetworkCallback() { // from class: com.haier.uhome.usdk.api.a.6
            @Override // com.haier.uhome.mesh.api.callback.MeshNetworkCallback
            public void onIvIndexUpdate(long j7) {
                a.this.a(j7);
            }

            @Override // com.haier.uhome.mesh.api.callback.MeshNetworkCallback
            public void onProxyConnected(String str) {
                e3.a.e("Mesh device: proxy %s connected!", str);
                a.this.f30327q.set(true);
                a.this.b();
                com.haier.library.common.thread.m.scheduleWithFixedDelay(a.this.new g(), 0L, 5L, TimeUnit.SECONDS);
            }

            @Override // com.haier.uhome.mesh.api.callback.MeshNetworkCallback
            public void onProxyDisConnected(String str) {
                e3.a.e("Mesh device: proxy %s disconnected!", str);
                a.this.f30318c.a(str, str, 15000L);
                a.this.f30327q.set(false);
                a.this.f30326p = -1;
                a.this.f30330t.set(false);
                if (!a.this.f30329s.get()) {
                    a.this.c();
                }
                com.haier.uhome.control.local.d.f.a().b();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        if (!this.f30325o) {
            return false;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.e("meshNeed:is bluetooth not enable so", new Object[0]);
            return false;
        }
        if (this.f30323m.getCloudConnectionState() == uSDKCloudConnectionState.CLOUD_CONNECTION_STATE_CONNECTED) {
            return true;
        }
        e3.a.e("meshNeed:cloud connect state is not connected", new Object[0]);
        return false;
    }

    private synchronized int l() {
        int i7;
        if (this.f30322g >= Integer.MAX_VALUE) {
            this.f30322g = 0;
        }
        i7 = this.f30322g;
        this.f30322g = i7 + 1;
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        e3.a.e("reset setProxyFinish to false proxyAddress=%s", Integer.valueOf(this.f30326p));
        if (this.f30326p == -1) {
            this.f30330t.set(false);
        }
    }

    void b() {
        if (d()) {
            com.haier.uhome.search.a.n.a().b(new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.a.7
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    e3.a.e("stopBleMeshSearch when onProxyConnected success", new Object[0]);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    e3.a.v("stopBleMeshSearch when onProxyConnected fail %s", usdkerror);
                }
            });
        } else {
            e3.a.h("mesh not ready so stopBleMeshSearch return", new Object[0]);
        }
    }

    void c() {
        if (d()) {
            com.haier.uhome.search.a.n.a().a(new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.a.8
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    e3.a.e("startBleMeshSearch when onProxyDisConnected success", new Object[0]);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    e3.a.v("startBleMeshSearch when onProxyDisConnected fail %", usdkerror);
                }
            });
        } else {
            e3.a.h("mesh not ready so startBleMeshSearch return", new Object[0]);
        }
    }

    public boolean d() {
        return (this.f30316a instanceof e) && this.f30316a.b();
    }

    public com.haier.uhome.control.base.a.c e() {
        return this.f30324n;
    }

    private void b(ICallback<Void> iCallback, int i7) {
        this.f30325o = true;
        if (d()) {
            e3.a.e("startMeshNet callback success Direct", new Object[0]);
            MeshNetworkManager.getInstance().startMeshModule(null);
            a(iCallback, (Object) null);
        } else {
            if (iCallback != null) {
                int iL = l();
                e3.a.e("startMeshNet callback sn = %d", Integer.valueOf(iL));
                this.f30317b.a(Integer.valueOf(iL), iCallback, i7 * 1000);
            }
            this.f30316a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i7) {
        if (i7 == 2) {
            e3.a.e("resume mesh net when ble state = " + i7, new Object[0]);
            a((ICallback<Void>) null);
            return;
        }
        e3.a.e("change ble state = " + i7, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ErrorConst errorConst) {
        e3.a.e("refreshProxyConnect ret " + errorConst, new Object[0]);
        this.f30330t.set(true);
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30522a.m();
            }
        }, 29000L, TimeUnit.MILLISECONDS);
    }

    private boolean b(MeshDeviceNode meshDeviceNode) {
        b bVar;
        return (meshDeviceNode == null || (bVar = this.f30328r.get(Integer.valueOf(meshDeviceNode.getUnicast()))) == null || !bVar.f30352b) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j7) {
        if (this.f30324n == null) {
            e3.a.v("sendNewIvIndex error, but netInfo is null", new Object[0]);
        } else {
            com.haier.uhome.control.cloud.service.c.l().a(j7, this.f30324n.a(), new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.usdk.api.a0
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    this.f30430a.a(j7, basicResp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MeshDeviceNode meshDeviceNode, final ICallback<Void> iCallback) {
        if (meshDeviceNode == null) {
            a(iCallback, (Object) null);
        } else {
            MeshNetworkManager.getInstance().addKnownNodes(meshDeviceNode, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.c0
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30469a.a(iCallback, errorConst);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j7, BasicResp basicResp) {
        if (basicResp.getErrNo() != ErrorConst.RET_USDK_OK.getErrorId()) {
            e3.a.h("reqUpdateIvIndex <%d> to cloud ret <%s>", Long.valueOf(j7), Integer.valueOf(basicResp.getErrNo()));
        } else {
            e3.a.e("reqUpdateIvIndex <%d> to cloud OK", Long.valueOf(j7));
            this.f30324n.b(j7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ICallback<com.haier.uhome.control.base.a.c> iCallback) {
        new com.haier.uhome.usdk.base.utils.e<com.haier.uhome.control.base.a.c>(com.haier.uhome.usdk.base.utils.e.k(), 1000L) { // from class: com.haier.uhome.usdk.api.a.2
            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j7) {
                if (!a.this.k()) {
                    b(new com.haier.uhome.usdk.base.api.c(ErrorConst.ERR_INTERNAL.toError()));
                } else {
                    e3.a.e("getMeshNetInfo once", new Object[0]);
                    com.haier.uhome.control.cloud.api.a.a().a(new ICallback<com.haier.uhome.control.base.a.c>() { // from class: com.haier.uhome.usdk.api.a.2.1
                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(com.haier.uhome.control.base.a.c cVar) {
                            b(new com.haier.uhome.usdk.base.api.c(ErrorConst.RET_USDK_OK.toError(), cVar));
                        }

                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        public void onFailure(uSDKError usdkerror) {
                            b(new com.haier.uhome.usdk.base.api.c(usdkerror));
                        }
                    });
                }
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<com.haier.uhome.control.base.a.c> cVar) {
                if (!cVar.b().a(ErrorConst.RET_USDK_OK)) {
                    a.this.a(iCallback, cVar.b());
                } else {
                    a.this.a((ICallback<com.haier.uhome.control.base.a.c>) iCallback, cVar.c());
                }
            }
        }.a();
    }

    private boolean a(MeshDeviceNode meshDeviceNode) {
        return meshDeviceNode != null && this.f30328r.get(Integer.valueOf(meshDeviceNode.getUnicast())) == null;
    }

    void a(final MeshDeviceNode meshDeviceNode, final ICallback<Void> iCallback) {
        if (meshDeviceNode == null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else if (!a(meshDeviceNode) && b(meshDeviceNode)) {
            a(iCallback, (Object) null);
        } else {
            b(new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.a.10
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    final b bVar = new b();
                    bVar.f30351a = meshDeviceNode;
                    bVar.f30352b = false;
                    a.this.f30328r.put(Integer.valueOf(meshDeviceNode.getUnicast()), bVar);
                    a.this.b(meshDeviceNode, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.a.10.1
                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(Void r8) {
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            a.this.a((ICallback<Object>) iCallback, (Object) null);
                            bVar.f30352b = true;
                        }

                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        public void onFailure(uSDKError usdkerror) {
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            a.this.a(iCallback, usdkerror);
                            bVar.f30352b = false;
                        }
                    });
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    a.this.a(iCallback, usdkerror);
                }
            }, 15);
        }
    }

    public void a(ICallback<Void> iCallback) {
        b(iCallback, 15);
    }

    @Override // com.haier.uhome.control.base.api.p
    public void a(ICallback<Void> iCallback, int i7) {
        b(iCallback, i7);
    }

    class c extends AbstractC0375a<Void> {
        c() {
            super();
        }

        @Override // com.haier.uhome.usdk.api.a.AbstractC0375a
        void a() {
            if (this.f30348a) {
                e3.a.e("create Mesh net after mesh create success", new Object[0]);
                a aVar = a.this;
                aVar.a((ICallback<Object>) aVar.f30331u, (Object) null);
                return;
            }
            if (!a.this.k()) {
                e3.a.o("create Mesh but is no mesh net need so return", new Object[0]);
                a aVar2 = a.this;
                aVar2.a(aVar2.f30331u, ErrorConst.ERR_INTERNAL.toError());
                return;
            }
            if (a.this.f30324n == null) {
                e3.a.h("create Mesh net but netInfo null", new Object[0]);
                a aVar3 = a.this;
                aVar3.f30316a = aVar3.new d();
                a.this.f30316a.a();
                return;
            }
            if (this.f30349b) {
                e3.a.o("create Mesh net duplicate so return", new Object[0]);
                a aVar4 = a.this;
                aVar4.a(aVar4.f30331u, new uSDKError(a.f30311h));
                return;
            }
            this.f30349b = true;
            e3.a.e("init mesh stack begin", new Object[0]);
            a.this.j();
            List<MeshNetKey> listSingletonList = Collections.singletonList(a.this.f30324n.b());
            MeshNetworkManager.getInstance().initStack(new InitNodeParam.Builder().unicast(a.this.f30324n.e()).ivIndex(a.this.f30324n.d()).knownNode(com.haier.library.common.util.u.a(com.haier.library.common.util.u.d(new ArrayList(a.this.f30328r.values())), new com.haier.library.common.util.p() { // from class: com.haier.uhome.usdk.api.i0
                @Override // com.haier.library.common.util.p
                public final Object transform(Object obj) {
                    return ((a.b) obj).f30351a;
                }
            })).netKey(listSingletonList).appKey(Collections.singletonList(a.this.f30324n.c())).build(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.j0
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30591a.a(errorConst);
                }
            });
            a.this.g();
            this.f30349b = false;
        }

        @Override // com.haier.uhome.usdk.api.a.AbstractC0375a
        boolean b() {
            return this.f30348a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ErrorConst errorConst) {
            e3.a.e("initStack ret:%s", errorConst);
            if (errorConst == ErrorConst.RET_USDK_OK) {
                MeshNativeService.getInstance().initHal(a.this.f30324n.b().getIndex(), a.this.f30324n.c().getIndex(), a.this.f30324n.e());
                this.f30348a = true;
                a aVar = a.this;
                aVar.f30316a = aVar.new e();
                a.this.f30316a.a();
                return;
            }
            this.f30348a = false;
            a aVar2 = a.this;
            aVar2.a(aVar2.f30331u, errorConst.toError());
        }
    }

    @Override // com.haier.uhome.control.base.api.p
    public int a() {
        return this.f30326p;
    }

    @Override // com.haier.uhome.control.base.api.p
    public List<String> a(String str) {
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
        if (device == null) {
            return Collections.emptyList();
        }
        if (!device.isGroup()) {
            return Collections.emptyList();
        }
        List<uSDKDevice> groupMemberList = device.getGroupMemberList();
        if (groupMemberList != null && groupMemberList.size() != 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<uSDKDevice> it = groupMemberList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getDeviceId());
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ICallback iCallback, ErrorConst errorConst) {
        if (errorConst == ErrorConst.RET_USDK_OK) {
            a((ICallback<Object>) iCallback, (Object) null);
        } else {
            a(iCallback, errorConst.toError());
        }
    }

    void a(boolean z7) {
        this.f30329s.set(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ICallback iCallback, uSDKError usdkerror) {
        if (iCallback == null) {
            return;
        }
        iCallback.onFailure(usdkerror);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <R> void a(ICallback<R> iCallback, R r7) {
        if (iCallback == null) {
            return;
        }
        iCallback.onSuccess(r7);
    }
}
