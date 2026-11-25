package com.haier.uhome.control.cloud.service;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.OperArgs;
import com.haier.uhome.control.base.json.req.CloudBindDeviceReq;
import com.haier.uhome.control.base.json.req.CloudGetDeviceBindResultReq;
import com.haier.uhome.control.base.json.req.CloudGetDeviceInfoReq;
import com.haier.uhome.control.base.json.req.CloudGetDeviceListReq;
import com.haier.uhome.control.base.json.req.DeviceOperReq;
import com.haier.uhome.control.base.json.req.GetCacheAlarmReq;
import com.haier.uhome.control.base.json.req.GetCachePropertyReq;
import com.haier.uhome.control.base.json.req.GetModuleInfoReq;
import com.haier.uhome.control.base.json.req.UpdateIvIndexReq;
import com.haier.uhome.control.base.json.resp.CloudBindDeviceResp;
import com.haier.uhome.control.base.json.resp.CloudGetDeviceBindResultResp;
import com.haier.uhome.control.base.json.resp.DeviceOperResp;
import com.haier.uhome.control.base.json.resp.GetCacheAlarmResp;
import com.haier.uhome.control.base.json.resp.GetCachePropertyResp;
import com.haier.uhome.control.base.json.resp.GetModuleInfoResp;
import com.haier.uhome.control.cloud.api.DeviceFOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.control.cloud.api.ModuleInfo;
import com.haier.uhome.control.cloud.json.ControlCloudProtocol;
import com.haier.uhome.control.cloud.json.req.BoardFOTAReq;
import com.haier.uhome.control.cloud.json.req.DeviceStartFotaReq;
import com.haier.uhome.control.cloud.json.req.FetchFotaStatusReq;
import com.haier.uhome.control.cloud.json.req.GatewayStartPairingReq;
import com.haier.uhome.control.cloud.json.req.OpenBindTimeWindowReq;
import com.haier.uhome.control.cloud.json.req.SaveDeviceVersionReq;
import com.haier.uhome.control.cloud.json.req.UpDeviceVersionInfoReq;
import com.haier.uhome.control.cloud.json.resp.FetchFotaStatusResp;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.control.base.c.a implements com.haier.uhome.control.base.c.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29152c = -25001;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f29153d = "256";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29154e = -130;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29155f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.uhome.control.cloud.service.b f29156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f29157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f29158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicBoolean f29159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.haier.uhome.control.cloud.api.b f29160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.haier.uhome.control.cloud.api.i f29161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f29162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ConcurrentHashMap<Long, com.haier.uhome.control.cloud.api.e> f29163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f29164o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.haier.library.common.b.e f29165p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.haier.uhome.control.cloud.a.p f29166q;

    enum a {
        NONE,
        CREATED,
        STARTED
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f29188a = new c();

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(BasicResp basicResp) {
    }

    public static c l() {
        return b.f29188a;
    }

    private void u() {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.control.cloud.service.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29151a.B();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        new com.haier.uhome.usdk.base.utils.e.a<Void>(com.haier.uhome.usdk.base.utils.e.k(), 5000L) { // from class: com.haier.uhome.control.cloud.service.c.4

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f29173b;

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<Void> cVar) {
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            public void a() {
                if (c.this.f29159j.compareAndSet(false, true)) {
                    super.a();
                }
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j7) {
                if (!this.f29173b) {
                    if (com.haier.uhome.control.cloud.api.b.CONNECT_FAILED == c.this.f29160k) {
                        c.this.f29159j.set(false);
                        Trace traceCreateDITrace = Trace.createDITrace();
                        if (traceCreateDITrace == null) {
                            return;
                        }
                        DITraceNode dITraceNode = new DITraceNode("common", "networkState", "", "-19001", VersionManager.getInstance().getSDKVersion());
                        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
                        traceCreateDITrace.addDITraceNode(dITraceNode);
                        return;
                    }
                    l();
                    e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "ping gw start...", new Object[0]);
                    c.this.a(new ICallback<Void>() { // from class: com.haier.uhome.control.cloud.service.c.4.1
                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(Void r7) {
                            e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "ping gw success", new Object[0]);
                            AnonymousClass4.this.f29173b = true;
                        }

                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        public void onFailure(uSDKError usdkerror) {
                            e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "ping gw failure", new Object[0]);
                            AnonymousClass4.this.f29173b = false;
                        }
                    });
                    return;
                }
                c.this.f29159j.set(false);
            }
        }.a();
    }

    private ErrorConst w() {
        com.haier.library.common.b.h.a().d(com.haier.uhome.usdk.base.service.e.a().b(), this.f29165p);
        if (this.f29162m != a.CREATED) {
            return ErrorConst.ERR_MODULE_STOPPED;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "tryDelete error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryDelete", new Object[0]);
        this.f29156g.b();
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryDelete ret <void>.", new Object[0]);
        this.f29162m = a.NONE;
        return ErrorConst.RET_USDK_OK;
    }

    private ErrorConst x() {
        if (this.f29162m != a.CREATED) {
            return ErrorConst.ERR_MODULE_UNSTARTED;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "tryStart error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryStart.", new Object[0]);
        int iC = this.f29156g.c();
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryStart ret %d.", Integer.valueOf(iC));
        ErrorConst errorConstById = ErrorConst.getErrorConstById(iC);
        if (errorConstById == ErrorConst.RET_USDK_OK) {
            this.f29162m = a.STARTED;
        }
        return errorConstById;
    }

    private ErrorConst y() {
        if (this.f29162m != a.STARTED) {
            return ErrorConst.ERR_MODULE_STOPPED;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "tryStop error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryStop", new Object[0]);
        int iD = this.f29156g.d();
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryStop ret %d.", Integer.valueOf(iD));
        ErrorConst errorConstById = ErrorConst.getErrorConstById(iD);
        if (errorConstById == ErrorConst.RET_USDK_OK) {
            this.f29162m = a.CREATED;
        }
        return errorConstById;
    }

    private void z() {
        com.haier.library.common.b.h.a().b(com.haier.uhome.usdk.base.service.e.a().b(), new com.haier.library.common.b.e() { // from class: com.haier.uhome.control.cloud.service.y
            @Override // com.haier.library.common.b.e
            public /* synthetic */ void a(com.haier.library.common.b.r rVar) {
                com.haier.library.common.b.b.a(this, rVar);
            }

            @Override // com.haier.library.common.b.e
            public final void a(com.haier.library.common.b.a aVar) {
                this.f29262a.a(aVar);
            }
        });
    }

    @Override // com.haier.uhome.control.base.c.a
    public String f() {
        return com.haier.uhome.usdk.base.a.ao;
    }

    @Override // com.haier.uhome.control.base.c.a
    public int g() {
        return 1;
    }

    @Override // com.haier.uhome.control.base.c.a
    protected int h() {
        return -25001;
    }

    @Override // com.haier.uhome.control.base.c.a
    public String i() {
        return TraceProtocolConst.PRO_OP_RST;
    }

    @Override // com.haier.uhome.control.base.c.a
    public String j() {
        return TraceProtocolConst.PRO_ACK_RST;
    }

    public void m() {
        CloudGetDeviceListReq cloudGetDeviceListReq = new CloudGetDeviceListReq();
        cloudGetDeviceListReq.setTimeout(15);
        cloudGetDeviceListReq.setQueryNum(1);
        cloudGetDeviceListReq.setNativeSender(this.f29156g);
        com.haier.uhome.usdk.base.d.a.a().a(cloudGetDeviceListReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.t
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(basicResp);
            }
        });
    }

    public com.haier.uhome.control.cloud.api.b n() {
        return this.f29160k;
    }

    public long o() {
        return this.f29156g.e();
    }

    private c() {
        this.f29163n = new ConcurrentHashMap<>();
        this.f29165p = new com.haier.library.common.b.e() { // from class: com.haier.uhome.control.cloud.service.q
            @Override // com.haier.library.common.b.e
            public /* synthetic */ void a(com.haier.library.common.b.r rVar) {
                com.haier.library.common.b.b.a(this, rVar);
            }

            @Override // com.haier.library.common.b.e
            public final void a(com.haier.library.common.b.a aVar) {
                this.f29242a.b(aVar);
            }
        };
        this.f29166q = new com.haier.uhome.control.cloud.a.p() { // from class: com.haier.uhome.control.cloud.service.c.3
            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, String str2, String str3, int i7, int i8, String str4) {
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void b(String str) {
                if (c.this.f29161l != null) {
                    c.this.f29161l.a(str);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7) {
                if (c.f29153d.equals(str) && i7 == -130) {
                    if (VersionManager.getInstance().isInt()) {
                        return;
                    }
                    c.this.v();
                } else {
                    c.this.a(com.haier.uhome.control.cloud.api.b.a(str));
                    if (c.this.f29161l != null) {
                        c.this.f29161l.a(c.this.f29160k, i7);
                    }
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void b(String str, int i7, int i8) {
                com.haier.uhome.control.cloud.api.c cVar = (com.haier.uhome.control.cloud.api.c) ((com.haier.uhome.control.base.c.a) c.this).f28862a.get(str);
                if (cVar == null) {
                    e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29015m, "notifyFOTAStatus with a null remote device", new Object[0]);
                } else {
                    cVar.a(new FOTAStatusInfo(i8, new uSDKError(i7)));
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str) {
                if (c.this.f29161l != null) {
                    c.this.f29161l.b(str);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, String str2, String str3) {
                if (c.this.f29161l != null) {
                    c.this.f29161l.a(str, str2, str3);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, String str2) {
                if (c.this.f29161l != null) {
                    c.this.f29161l.a(str, str2);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7, boolean z7, String str2) {
                if (c.this.f29161l != null) {
                    c.this.f29161l.a(str, i7, z7, str2);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7, String str2, int i8) {
                if (c.this.f29161l != null) {
                    c.this.f29161l.a(str, i7, str2, i8);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7, int i8) {
                if (c.this.f29161l != null) {
                    c.this.f29161l.a(str, i7, i8);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(String str, String str2, String str3, String str4, int i7) {
                Trace traceCreateDITrace = Trace.createDITrace();
                if (traceCreateDITrace != null) {
                    DITraceNode dITraceNode = new DITraceNode(str2, str3, "", i7 + "", VersionManager.getInstance().getSDKVersion());
                    dITraceNode.add(TraceProtocolConst.PRO_PIPE, String.valueOf(c.this.g()));
                    dITraceNode.add("sys", str4);
                    dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, com.haier.uhome.usdk.base.a.au);
                    traceCreateDITrace.addDITraceNode(str, dITraceNode);
                    return;
                }
                e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "createDITrace failed, ignore traceId = %s, bid = %s", str, str2);
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(long j7, String str, int i7) {
                e3.a.n(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "notifyResourceConnectState handle %d, transId %s, status %d", Long.valueOf(j7), str, Integer.valueOf(i7));
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(long j7, String str, String str2, int i7) {
                com.haier.uhome.control.cloud.api.e eVar = (com.haier.uhome.control.cloud.api.e) c.this.f29163n.get(Long.valueOf(j7));
                if (eVar == null) {
                    e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "get handle<%d> from mResMap fail!!", Long.valueOf(j7));
                    return;
                }
                com.haier.uhome.control.base.api.a aVar = (com.haier.uhome.control.base.api.a) ((com.haier.uhome.control.base.c.a) c.this).f28862a.get(eVar.a());
                if (aVar == null) {
                    e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "No this device<%s>!!!", eVar.a());
                    return;
                }
                com.haier.uhome.control.cloud.api.c cVar = (com.haier.uhome.control.cloud.api.c) aVar;
                if (i7 == 2) {
                    com.haier.uhome.control.cloud.api.h hVarJ = cVar.J();
                    if (hVarJ == null) {
                        e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "receiver is null", new Object[0]);
                        return;
                    } else {
                        hVarJ.a(str, str2);
                        return;
                    }
                }
                try {
                    byte[] bArrDecode = Base64.decode(str2, 0);
                    com.haier.uhome.control.cloud.api.h hVarJ2 = cVar.J();
                    if (hVarJ2 == null) {
                        e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "receiver is null", new Object[0]);
                    } else {
                        hVarJ2.a(str, bArrDecode);
                    }
                } catch (IllegalArgumentException e8) {
                    e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "Base64 decode fail when notifyResourceData!!! -> %s", e8);
                }
            }

            @Override // com.haier.uhome.control.cloud.a.p
            public void a(long j7, int i7) {
                e3.a.n(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "notifyResourceEvent handle %d, event %d", Long.valueOf(j7), Integer.valueOf(i7));
            }
        };
        this.f29156g = com.haier.uhome.control.cloud.service.b.a();
        this.f29157h = e.a();
        a(com.haier.uhome.control.cloud.api.b.UNCONNECTED);
        this.f29159j = new AtomicBoolean(false);
        ControlCloudProtocol.register();
        com.haier.uhome.control.cloud.a.h.a().a(this.f29166q);
        z();
        this.f29164o = com.haier.library.common.util.w.g(com.haier.uhome.usdk.base.service.e.a().b());
    }

    private void A() {
        ConcurrentHashMap<Long, com.haier.uhome.control.cloud.api.e> concurrentHashMap = this.f29163n;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        new com.haier.library.common.thread.m<Void, Void, Void>(-2) { // from class: com.haier.uhome.control.cloud.service.c.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                HashMap map = new HashMap(c.this.f29163n);
                c.this.f29163n.clear();
                for (com.haier.uhome.control.cloud.api.e eVar : map.values()) {
                    if (eVar != null) {
                        c.this.f29157h.a(eVar.g());
                        com.haier.library.json.e eVarT = com.haier.library.json.a.t(c.this.f29157h.a(com.haier.uhome.usdk.base.service.e.a().k(), eVar.c(), eVar.d(), eVar.b(), eVar.e()));
                        int iI0 = eVarT.I0("errNo");
                        long jN0 = eVarT.N0("handle");
                        if (iI0 == 0) {
                            eVar.a(jN0);
                            for (String str : eVar.f()) {
                                e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "reSubscribe handle:%d, res:%s, return:%d", Long.valueOf(eVar.g()), str, Integer.valueOf(c.this.f29157h.a(eVar.g(), str, eVar.h())));
                            }
                            c.this.f29163n.put(Long.valueOf(jN0), eVar);
                        }
                    }
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        com.haier.uhome.usdk.base.e.b bVar = new com.haier.uhome.usdk.base.e.b(null);
        if (this.f29162m == a.STARTED) {
            com.haier.uhome.trace.api.a.a("disconnectToCloud", bVar);
            ErrorConst errorConstY = y();
            if (errorConstY != ErrorConst.RET_USDK_OK) {
                e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService restartService tryStop error = " + errorConstY, new Object[0]);
            }
        }
        com.haier.uhome.trace.api.a.a("connectToCloud", bVar);
        ErrorConst errorConstX = x();
        if (errorConstX != ErrorConst.RET_USDK_OK) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService restartService tryStart error = " + errorConstX, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(com.haier.uhome.usdk.base.api.o oVar) {
        ErrorConst errorConstW = w();
        if (oVar == null) {
            e3.a.n(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "userDelete callback is null,so give up this callback.", new Object[0]);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(oVar, errorConstW);
        }
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean c(com.haier.uhome.control.base.api.a aVar) {
        if (com.haier.uhome.usdk.base.api.e.d(aVar.ai())) {
            return false;
        }
        return super.c(aVar);
    }

    public void d(final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.cloud.service.a0
            @Override // java.lang.Runnable
            public final void run() {
                c.f(oVar);
            }
        });
    }

    @Override // com.haier.uhome.control.base.c.a
    public void e(final com.haier.uhome.control.base.api.a aVar) {
        Trace traceCreateDITrace = Trace.createDITrace();
        int iF = this.f29156g.f();
        if (iF != 2) {
            a(traceCreateDITrace, aVar, iF);
            return;
        }
        DeviceStatus deviceStatusN = aVar.n();
        e3.a.d("Device %s status is %s when getAllCloudCacheAlarm", aVar.X(), deviceStatusN.name(), new Object[0]);
        if (deviceStatusN == DeviceStatus.STATUS_CONNECTED || deviceStatusN == DeviceStatus.STATUS_READY) {
            a(aVar.X(), traceCreateDITrace, new ICallback<Void>() { // from class: com.haier.uhome.control.cloud.service.c.2
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "getAllCloudCacheAlarm success", new Object[0]);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    c.super.e(aVar);
                }
            });
        } else {
            e3.a.e("Device %s status changed!", aVar.X());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long d(String str) {
        for (com.haier.uhome.control.cloud.api.e eVar : this.f29163n.values()) {
            if (eVar != null && eVar.b().equals(str)) {
                return eVar.g();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(com.haier.uhome.usdk.base.api.o oVar) {
        ErrorConst errorConstY = y();
        if (oVar == null) {
            e3.a.n(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "userStop callback is null,so give up this callback.", new Object[0]);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(oVar, errorConstY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(com.haier.uhome.usdk.base.api.o oVar) {
        ErrorConst errorConstX = x();
        if (oVar == null) {
            e3.a.n(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "userStart callback is null,so give up this callback.", new Object[0]);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(oVar, errorConstX);
        }
    }

    @Override // com.haier.uhome.control.base.c.a
    protected uSDKError f(com.haier.uhome.control.base.api.a aVar) {
        uSDKError usdkerrorF = super.f(aVar);
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        return !usdkerrorF.a(errorConst) ? usdkerrorF : errorConst.toError();
    }

    @Override // com.haier.uhome.control.base.c.a
    public void b(final com.haier.uhome.control.base.api.a aVar) {
        Trace traceCreateDITrace = Trace.createDITrace();
        int iF = this.f29156g.f();
        if (iF != 2) {
            a(traceCreateDITrace, aVar, iF);
            return;
        }
        DeviceStatus deviceStatusN = aVar.n();
        e3.a.d("Device %s status is %s when getAllCloudCacheProperty", aVar.X(), deviceStatusN.name(), new Object[0]);
        if (deviceStatusN != DeviceStatus.STATUS_CONNECTED) {
            e3.a.e("Device %s status changed!", aVar.X());
        } else {
            b(aVar.X(), Trace.createDITrace(), new ICallback<Void>() { // from class: com.haier.uhome.control.cloud.service.c.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "getAllCloudCacheProperty success", new Object[0]);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    e3.a.d("Device %s status is %s when getAllProperty", aVar.X(), aVar.n().name(), new Object[0]);
                    if (aVar.n() == DeviceStatus.STATUS_CONNECTED) {
                        c.super.b(aVar);
                    }
                }
            });
        }
    }

    public void c(final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.control.cloud.service.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29210a.g(oVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            GetModuleInfoResp getModuleInfoResp = (GetModuleInfoResp) basicResp;
            ModuleInfo moduleInfo = new ModuleInfo();
            moduleInfo.a(getModuleInfoResp.getAccessType());
            moduleInfo.b(getModuleInfoResp.getMachineId());
            moduleInfo.e(getModuleInfoResp.getHardwareType());
            moduleInfo.f(getModuleInfoResp.getHardwareVer());
            moduleInfo.c(getModuleInfoResp.getSoftwareType());
            moduleInfo.d(getModuleInfoResp.getSoftwareVer());
            com.haier.uhome.usdk.base.utils.b.a((ICallback<ModuleInfo>) iCallback, moduleInfo);
            return;
        }
        com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL);
    }

    public void c(final String str, final com.haier.uhome.usdk.base.api.o oVar) {
        final com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "try to connect a not find device<id=%s>!!", str);
            a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        if (!aVarB.A()) {
            e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "try disconnect un connect device id : %s, return ok", str);
            a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        if (this.f29162m == a.NONE) {
            aVarB.e(false);
            a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        final com.haier.uhome.usdk.base.utils.d<com.haier.uhome.usdk.base.api.o> dVarD = aVarB.D();
        if (dVarD.a()) {
            dVarD.a(oVar);
            e3.a.e("CloudDevice %s is disconnecting, update callback!", aVarB.X());
        } else {
            dVarD.a(oVar);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.control.cloud.service.c0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29189a.a(dVarD, oVar, aVarB, str);
                }
            });
        }
    }

    public void a(String str, Trace trace, final ICallback<Void> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "getNetworkQuality device not found in deviceMap ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
            return;
        }
        if (com.haier.uhome.trace.b.g.a().c() && (trace == null || TextUtils.isEmpty(trace.getTraceId()))) {
            e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "enable ditrace,but ditrace is null or traceId is null", new Object[0]);
        }
        final com.haier.uhome.control.base.d.a aVar = new com.haier.uhome.control.base.d.a(trace, "getCacheAlarm", aVarB);
        uSDKError usdkerrorF = f(aVarB);
        if (!usdkerrorF.a(ErrorConst.RET_USDK_OK)) {
            aVar.a(usdkerrorF);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorF);
            return;
        }
        GetCacheAlarmReq getCacheAlarmReq = new GetCacheAlarmReq();
        getCacheAlarmReq.setTimeout(15);
        getCacheAlarmReq.setTraceId(trace == null ? "" : trace.getTraceId());
        getCacheAlarmReq.setNativeSender(this.f29156g);
        getCacheAlarmReq.setModule(f());
        getCacheAlarmReq.setDevId(str);
        com.haier.uhome.usdk.base.d.a.a().a(getCacheAlarmReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.n
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.b(aVar, iCallback, basicResp);
            }
        });
    }

    @Override // com.haier.uhome.control.base.c.a
    protected boolean e() {
        a aVar = a.CREATED;
        a aVar2 = this.f29162m;
        return aVar == aVar2 || a.STARTED == aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (!usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
            return;
        }
        FOTAStatusInfo fOTAStatusInfoA = a((FetchFotaStatusResp) basicResp);
        if (fOTAStatusInfoA == null) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, ErrorConst.ERR_INTERNAL.toError());
        } else {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<FOTAStatusInfo>) iCallback, fOTAStatusInfoA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.control.base.d.a aVar, ICallback iCallback, BasicResp basicResp) {
        aVar.a(new uSDKError(basicResp.getErrNo()));
        GetCacheAlarmResp getCacheAlarmResp = (GetCacheAlarmResp) basicResp;
        if (getCacheAlarmResp.getErrNo() != 0) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, com.haier.uhome.usdk.base.utils.c.a(getCacheAlarmResp));
        } else {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.usdk.base.api.o oVar, BasicResp basicResp) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.getErrorConstById(basicResp.getErrNo()));
        }
    }

    public void b(String str, final com.haier.uhome.usdk.base.api.o oVar) {
        CloudGetDeviceInfoReq cloudGetDeviceInfoReq = new CloudGetDeviceInfoReq();
        cloudGetDeviceInfoReq.setTimeout(5);
        cloudGetDeviceInfoReq.setQueryNum(1);
        cloudGetDeviceInfoReq.setNativeSender(this.f29156g);
        cloudGetDeviceInfoReq.setDevId(str);
        cloudGetDeviceInfoReq.setTraceId("");
        com.haier.uhome.usdk.base.d.a.a().a(cloudGetDeviceInfoReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.j
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(oVar, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, String str2, com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.control.cloud.api.e eVar = null;
        for (com.haier.uhome.control.cloud.api.e eVar2 : this.f29163n.values()) {
            if (eVar2.a().equals(str) && eVar2.f().contains(str2)) {
                eVar = eVar2;
            }
        }
        if (eVar == null) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_INTERNAL);
            return;
        }
        this.f29157h.a(eVar.g(), str2);
        eVar.b(str2);
        if (eVar.f().isEmpty()) {
            this.f29157h.a(eVar.g());
            this.f29163n.remove(Long.valueOf(eVar.g()));
        }
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    public void b(String str, Trace trace, final ICallback<Void> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "getNetworkQuality device not found in deviceMap ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
            return;
        }
        if (com.haier.uhome.trace.b.g.a().c() && (trace == null || TextUtils.isEmpty(trace.getTraceId()))) {
            e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "enable ditrace,but ditrace is null or traceId is null", new Object[0]);
        }
        if (aVarB.n() == DeviceStatus.STATUS_READY) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.RET_USDK_OK.toError());
            return;
        }
        final com.haier.uhome.control.base.d.a aVar = new com.haier.uhome.control.base.d.a(trace, "getCacheProperty", aVarB);
        uSDKError usdkerrorF = f(aVarB);
        if (!usdkerrorF.a(ErrorConst.RET_USDK_OK)) {
            aVar.a(usdkerrorF);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorF);
            return;
        }
        GetCachePropertyReq getCachePropertyReq = new GetCachePropertyReq();
        getCachePropertyReq.setTimeout(15);
        getCachePropertyReq.setTraceId(trace == null ? "" : trace.getTraceId());
        getCachePropertyReq.setNativeSender(this.f29156g);
        getCachePropertyReq.setModule(f());
        getCachePropertyReq.setDevId(str);
        com.haier.uhome.usdk.base.d.a.a().a(getCachePropertyReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.z
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(aVar, iCallback, basicResp);
            }
        });
    }

    public void a(final String str, String str2, final long j7, int i7, int i8, final String str3, String str4, final ICallback<String> iCallback) {
        CloudBindDeviceReq cloudBindDeviceReq = new CloudBindDeviceReq();
        cloudBindDeviceReq.setDevId(str);
        cloudBindDeviceReq.setUplusId(str2);
        cloudBindDeviceReq.setBindCode(j7);
        cloudBindDeviceReq.setBindCodeFrom(i7);
        cloudBindDeviceReq.setDeviceName("");
        cloudBindDeviceReq.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        cloudBindDeviceReq.setTimeout(i8);
        cloudBindDeviceReq.setTraceId(str3);
        cloudBindDeviceReq.setMeshDevKey(str4);
        cloudBindDeviceReq.setNativeSender(this.f29156g);
        com.haier.uhome.usdk.base.d.a.a().a(cloudBindDeviceReq, i8 + 2, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.r
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f29243a.a(str3, str, j7, iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, long j7, ICallback iCallback, BasicResp basicResp) {
        CloudBindDeviceResp cloudBindDeviceResp = (CloudBindDeviceResp) basicResp;
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(cloudBindDeviceResp);
        String str3 = ControlCloudProtocol.parserMethodProtocol(cloudBindDeviceResp.getProtocol());
        a(str, Integer.toString(cloudBindDeviceResp.getErrNo()), str2, str3, j7);
        if (usdkerrorB.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<String>) iCallback, str3);
            return;
        }
        HashMap<String, String> map = new HashMap<>(1);
        map.put(TraceProtocolConst.PRO_PROTOCOL, str3);
        usdkerrorB.a(map);
        com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.library.common.b.a aVar) {
        com.haier.uhome.usdk.base.e.b bVar = new com.haier.uhome.usdk.base.e.b(null);
        if (!aVar.n() && aVar.h() && aVar.a() == 1 && this.f29162m != a.STARTED) {
            com.haier.uhome.trace.api.a.a("connectToCloud", bVar);
        }
        u();
    }

    private void a(String str, String str2, String str3, String str4, long j7) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, "bindDevice", str3, str2, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("bindcode", Long.valueOf(j7));
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, str4);
        dITraceNode.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceCreateDITrace.addDITraceNode(str, dITraceNode);
    }

    public void b(final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.control.cloud.service.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f29256a.h(oVar);
            }
        });
    }

    public void b(final String str, final String str2, final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.control.cloud.service.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f29258a.c(str, str2, oVar);
            }
        });
    }

    public void b(String str, final ICallback<FOTAStatusInfo> iCallback) {
        if (TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        FetchFotaStatusReq fetchFotaStatusReq = new FetchFotaStatusReq();
        fetchFotaStatusReq.setTimeout(15);
        fetchFotaStatusReq.setDevId(str);
        fetchFotaStatusReq.setNativeSender(this.f29156g);
        fetchFotaStatusReq.setTraceId(com.haier.uhome.trace.c.a.a());
        com.haier.uhome.usdk.base.d.a.a().a(fetchFotaStatusReq, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.o
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f29234a.e(iCallback, basicResp);
            }
        });
    }

    public void a(String str, String str2, String str3, int i7, String str4, int i8, String str5, final com.haier.uhome.usdk.base.api.o oVar) {
        SaveDeviceVersionReq saveDeviceVersionReq = new SaveDeviceVersionReq();
        try {
            saveDeviceVersionReq.setModule(f());
            saveDeviceVersionReq.setDevId(str);
            saveDeviceVersionReq.setUplusId(str2);
            saveDeviceVersionReq.setLongProductCode(str3);
            saveDeviceVersionReq.setChannel(i7);
            saveDeviceVersionReq.setCompanyId(str4);
            saveDeviceVersionReq.setTimeout(i8);
            saveDeviceVersionReq.setMachineID(str5);
            saveDeviceVersionReq.setNativeSender(this.f29156g);
            com.haier.uhome.usdk.base.d.a.a().a(saveDeviceVersionReq, i8, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.m
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    c.b(oVar, basicResp);
                }
            });
        } catch (Exception unused) {
            if (oVar != null) {
                oVar.onCallback(ErrorConst.ERR_USDK_INVALID_PARAM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar, BasicResp basicResp) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.getErrorConstById(basicResp.getErrNo()));
        }
    }

    public void a(final String str, final long j7, int i7, int i8, final String str2, long j8, long j9, final ICallback<com.haier.uhome.control.base.a> iCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        CloudGetDeviceBindResultReq cloudGetDeviceBindResultReq = new CloudGetDeviceBindResultReq();
        cloudGetDeviceBindResultReq.setModule(com.haier.uhome.usdk.base.a.ao);
        cloudGetDeviceBindResultReq.setDevId(str);
        cloudGetDeviceBindResultReq.setTimeout(i8);
        cloudGetDeviceBindResultReq.setBindCode(j7);
        cloudGetDeviceBindResultReq.setBindCodeFrom(i7);
        cloudGetDeviceBindResultReq.setTraceId(str2);
        cloudGetDeviceBindResultReq.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        cloudGetDeviceBindResultReq.setNativeSender(this.f29156g);
        cloudGetDeviceBindResultReq.setLastBts(j8);
        cloudGetDeviceBindResultReq.setBtsOffset(j9);
        com.haier.uhome.usdk.base.d.a.a().a(cloudGetDeviceBindResultReq, i8 + 2, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.p
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f29236a.a(str2, str, j7, jCurrentTimeMillis, iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, long j7, long j8, ICallback iCallback, BasicResp basicResp) {
        CloudGetDeviceBindResultResp cloudGetDeviceBindResultResp = (CloudGetDeviceBindResultResp) basicResp;
        String str3 = ControlCloudProtocol.parserMethodProtocol(cloudGetDeviceBindResultResp.getProtocol());
        if (cloudGetDeviceBindResultResp.getErrNo() != 0) {
            a(str, Integer.toString(cloudGetDeviceBindResultResp.getErrNo()), str2, str3, j7, j8);
            uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(cloudGetDeviceBindResultResp);
            HashMap<String, String> map = new HashMap<>(1);
            map.put(TraceProtocolConst.PRO_PROTOCOL, str3);
            usdkerrorB.a(map);
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorB);
            return;
        }
        a(str, Integer.toString(cloudGetDeviceBindResultResp.getErrNo()), cloudGetDeviceBindResultResp.getDevId(), str3, j7, j8);
        com.haier.uhome.control.base.a aVar = new com.haier.uhome.control.base.a();
        aVar.a(str3);
        aVar.a(cloudGetDeviceBindResultResp.getResult());
        aVar.b(cloudGetDeviceBindResultResp.getDevId());
        aVar.c(cloudGetDeviceBindResultResp.getUplusId());
        com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.control.base.a>) iCallback, aVar);
    }

    public void a(long j7, long j8, com.haier.uhome.usdk.base.api.l lVar) {
        UpdateIvIndexReq updateIvIndexReq = new UpdateIvIndexReq();
        updateIvIndexReq.setTimeout(15);
        updateIvIndexReq.setIvIndex(j7);
        updateIvIndexReq.setNetId(j8);
        updateIvIndexReq.setNativeSender(this.f29156g);
        com.haier.uhome.usdk.base.d.a.a().a(updateIvIndexReq, 15, lVar);
    }

    private void a(String str, String str2, String str3, String str4, long j7, long j8) {
        if (TextUtils.isEmpty(str)) {
            e3.a.v("diRespCloudDeviceBindResult:customTraceId is empty,so return", new Object[0]);
            return;
        }
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("diRespCloudDeviceBindResult:diTrace is empty,so return", new Object[0]);
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, "getBindResult", str3, str2, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("bindcode", Long.valueOf(j7));
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, str4);
        dITraceNode.add(TraceProtocolConst.PRO_DEVICE_ID, str3);
        dITraceNode.add(TraceProtocolConst.PRO_SPAN, (System.currentTimeMillis() - j8) + "");
        dITraceNode.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceCreateDITrace.addDITraceNode(str, dITraceNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.d.a aVar, ICallback iCallback, BasicResp basicResp) {
        aVar.a(new uSDKError(basicResp.getErrNo()));
        GetCachePropertyResp getCachePropertyResp = (GetCachePropertyResp) basicResp;
        if (getCachePropertyResp.getErrNo() != 0) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, com.haier.uhome.usdk.base.utils.c.a(getCachePropertyResp));
        } else {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        }
    }

    private void a(Trace trace, com.haier.uhome.control.base.api.a aVar, int i7) {
        if (trace == null) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode("common", "CloudOffline", aVar.X(), "00000", VersionManager.getInstance().getSDKVersion());
        HashMap map = new HashMap(4);
        map.put(TraceProtocolConst.PRO_CAE_CLOUD_DST, Integer.valueOf(i7));
        map.put(TraceProtocolConst.PRO_CLIENT_CLOUD_DST, n().a());
        map.put(TraceProtocolConst.PRO_DEVICE_RST, aVar.n().getValue());
        map.put(TraceProtocolConst.IS_FGD, Integer.valueOf(com.haier.uhome.usdk.base.service.a.a().b() ? 1 : 0));
        dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, g(aVar));
        dITraceNode.add(TraceProtocolConst.PRO_NETWORK_TYPE, k());
        trace.addDITraceNode(dITraceNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ICallback<Void> iCallback) {
        if (TextUtils.isEmpty(this.f29158i)) {
            return;
        }
        String strReplaceFirst = this.f29158i.replaceFirst("http(s)?://", "");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(strReplaceFirst);
        new com.haier.library.common.b.n.b().c(arrayList).f(5000L).a(1, 64).d(false).e().l(new com.haier.library.common.b.n.c() { // from class: com.haier.uhome.control.cloud.service.c.5
            @Override // com.haier.library.common.b.n.c
            public void a(double d8) {
            }

            @Override // com.haier.library.common.b.n.c
            public void a(List<com.haier.library.common.b.o> list) {
                if (list.get(0).i() == 1) {
                    iCallback.onSuccess(null);
                } else {
                    iCallback.onFailure(new uSDKError(-1));
                }
            }

            @Override // com.haier.library.common.b.n.c
            public void a(String str) {
                iCallback.onFailure(new uSDKError(-1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.uhome.control.cloud.api.b bVar) {
        this.f29160k = bVar;
    }

    public void a(com.haier.uhome.control.cloud.api.i iVar) {
        this.f29161l = iVar;
    }

    public ErrorConst a(int i7, String str, String str2, int i8) {
        if (e()) {
            e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService create already create", new Object[0]);
            return ErrorConst.RET_USDK_OK;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f29158i = str2.toLowerCase();
        }
        String strM = com.haier.library.common.util.f.m(com.haier.uhome.usdk.base.service.e.a().b());
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService create(%s,%s,%s,%d)", strM, str, str2, Integer.valueOf(i8));
        int iA = this.f29156g.a(strM, i7, str, str2, i8);
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService create(%s,%s,%s,%d) ret %d.", strM, str, str2, Integer.valueOf(i8), Integer.valueOf(iA));
        if (iA != 0) {
            return ErrorConst.getErrorConstById(iA);
        }
        this.f29162m = a.CREATED;
        com.haier.library.common.b.h.a().b(com.haier.uhome.usdk.base.service.e.a().b(), this.f29165p);
        return ErrorConst.RET_USDK_OK;
    }

    public void a(final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.control.cloud.service.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f29229a.i(oVar);
            }
        });
    }

    public void a(final String str, final String str2, final boolean z7, final com.haier.uhome.usdk.base.api.o oVar) {
        if (this.f29162m != a.STARTED) {
            a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        final com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "try to connect a not find device<id=%s>!!", str);
            a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        if (aVarB.A()) {
            e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "try connect connected device id : %s, return ok", str);
            a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        final com.haier.uhome.usdk.base.utils.d<com.haier.uhome.usdk.base.api.o> dVarC = aVarB.C();
        if (dVarC.a()) {
            dVarC.a(oVar);
            e3.a.e("CloudDevice %s is connecting, update callback!", aVarB.X());
        } else {
            dVarC.a(oVar);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.control.cloud.service.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29198a.a(dVarC, oVar, aVarB, z7, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.usdk.base.utils.d dVar, com.haier.uhome.usdk.base.api.o oVar, com.haier.uhome.control.base.api.a aVar, boolean z7, String str, String str2) {
        int iA;
        synchronized (dVar) {
            if (dVar.a()) {
                dVar.a(oVar);
                e3.a.e("CloudDevice %s is connecting concurrent, update callback!", aVar.X());
                return;
            }
            dVar.d();
            aVar.a(z7);
            synchronized (aVar.a()) {
                e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryConnectDevice(%s,%s).", str, str2);
                iA = this.f29156g.a(str, str2);
                e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryConnectDevice(%s,%s) ret %d.", str, str2, Integer.valueOf(iA));
                com.haier.uhome.usdk.base.api.o oVar2 = (com.haier.uhome.usdk.base.api.o) dVar.c();
                if (oVar2 != null) {
                    aVar.c(oVar2);
                }
                if (iA == ErrorConst.RET_USDK_OK.getErrorId()) {
                    aVar.e(true);
                }
            }
            ErrorConst errorConstById = ErrorConst.getErrorConstById(iA);
            Iterator it = dVar.b().iterator();
            while (it.hasNext()) {
                a((com.haier.uhome.usdk.base.api.o) it.next(), errorConstById);
            }
            synchronized (dVar) {
                dVar.e();
                dVar.f();
            }
        }
    }

    private void a(com.haier.uhome.usdk.base.api.o oVar, ErrorConst errorConst) {
        if (oVar == null) {
            e3.a.n(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "connectDevice callback is null,so give up this callback.", new Object[0]);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(oVar, errorConst);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.usdk.base.utils.d dVar, com.haier.uhome.usdk.base.api.o oVar, com.haier.uhome.control.base.api.a aVar, String str) {
        int iA;
        synchronized (dVar) {
            if (dVar.a()) {
                dVar.a(oVar);
                e3.a.e("CloudDevice %s is disconnecting concurrent, update callback!", aVar.X());
                return;
            }
            dVar.d();
            synchronized (aVar.a()) {
                e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryDisConnectDevice(%s)", str);
                iA = this.f29156g.a(str);
                e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "CloudControlService tryDisConnectDevice(%s) ret %d.", str, Integer.valueOf(iA));
                com.haier.uhome.usdk.base.api.o oVar2 = (com.haier.uhome.usdk.base.api.o) dVar.c();
                if (oVar2 != null) {
                    aVar.d(oVar2);
                }
                if (iA == ErrorConst.RET_USDK_OK.getErrorId()) {
                    aVar.e(false);
                }
                aVar.t();
            }
            ErrorConst errorConstById = ErrorConst.getErrorConstById(iA);
            Iterator it = dVar.b().iterator();
            while (it.hasNext()) {
                a((com.haier.uhome.usdk.base.api.o) it.next(), errorConstById);
            }
            synchronized (dVar) {
                dVar.e();
                dVar.f();
            }
        }
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, int i7, Trace trace, ICallback<String> iCallback) {
        a(this.f29156g, str, str2, list, str3, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, String str4, int i7, Trace trace, ICallback<Void> iCallback) {
        a(this.f29156g, str, str2, list, str3, str4, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, List<com.haier.uhome.control.base.api.c> list2, int i7, Trace trace, String str4, ICallback<Void> iCallback) {
        a(this.f29156g, str, str2, list, str3, list2, i7, trace, str4, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, int i7, String str3, String str4, com.haier.uhome.usdk.base.api.q qVar, boolean z7, TraceNode traceNode, String str5, final com.haier.uhome.control.base.api.l lVar) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.cloud.service.e0
            @Override // java.lang.Runnable
            public final void run() {
                c.a(lVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.l lVar) {
        if (lVar != null) {
            lVar.onDeviceBindInfoGet(ErrorConst.ERR_USDK_NOT_SUPPORT, null);
        } else {
            e3.a.u(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "getDeviceBindInfo callback is null,so give up callback", new Object[0]);
        }
    }

    @Override // com.haier.uhome.control.base.c.a, com.haier.uhome.control.base.c.c
    public void a(String str, int i7, Trace trace, ICallback<com.haier.uhome.control.base.api.r> iCallback) {
        a(this.f29156g, str, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, com.haier.uhome.usdk.base.api.o oVar) {
        a(this.f29156g, str, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.library.common.b.a aVar) {
        if (aVar.h()) {
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst a(String str, DeviceOperResp deviceOperResp, String str2, int i7) {
        long jD = d(deviceOperResp.getChannelId());
        if (jD == 0) {
            com.haier.library.json.e eVarT = com.haier.library.json.a.t(this.f29157h.a(com.haier.uhome.usdk.base.service.e.a().k(), deviceOperResp.getAddr(), deviceOperResp.getPort(), deviceOperResp.getChannelId(), deviceOperResp.getPassword()));
            int iI0 = eVarT.I0("errNo");
            long jN0 = eVarT.N0("handle");
            if (iI0 == 0) {
                com.haier.uhome.control.cloud.api.e eVar = this.f29163n.get(Long.valueOf(jN0));
                if (eVar == null) {
                    eVar = new com.haier.uhome.control.cloud.api.e();
                    eVar.d(deviceOperResp.getChannelId());
                    eVar.e(deviceOperResp.getAddr());
                    eVar.a(deviceOperResp.getPort());
                    eVar.f(deviceOperResp.getPassword());
                    eVar.a(jN0);
                    eVar.c(str);
                    eVar.a(new ArrayList<>());
                    eVar.b(i7);
                    this.f29163n.put(Long.valueOf(jN0), eVar);
                }
                eVar.a(str2);
                jD = jN0;
            } else {
                return ErrorConst.getErrorConstById((int) jN0);
            }
        }
        return ErrorConst.getErrorConstById(this.f29157h.a(jD, str2, i7));
    }

    private void a(final String str, final DeviceOperResp deviceOperResp, final String str2, final int i7, final com.haier.uhome.usdk.base.api.n<com.haier.uhome.control.cloud.api.e> nVar) {
        new com.haier.library.common.thread.m<Void, Void, ErrorConst>(-2) { // from class: com.haier.uhome.control.cloud.service.c.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ErrorConst doInBackground(Void... voidArr) {
                return c.this.a(str, deviceOperResp, str2, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(ErrorConst errorConst) {
                com.haier.uhome.usdk.base.api.n nVar2 = nVar;
                if (nVar2 == null) {
                    return;
                }
                if (errorConst != ErrorConst.RET_USDK_OK) {
                    c.this.a(errorConst, nVar2);
                    return;
                }
                com.haier.uhome.control.cloud.api.e eVar = (com.haier.uhome.control.cloud.api.e) c.this.f29163n.get(Long.valueOf(c.this.d(deviceOperResp.getChannelId())));
                if (eVar == null) {
                    c.this.a(ErrorConst.ERR_INTERNAL, nVar);
                } else {
                    nVar.a(eVar);
                }
            }
        }.execute(new Void[0]);
    }

    public void a(final String str, final String str2, final int i7, final com.haier.uhome.usdk.base.api.n<com.haier.uhome.control.cloud.api.e> nVar) {
        if (!e()) {
            a(ErrorConst.ERR_MODULE_UNSTARTED, nVar);
            return;
        }
        com.haier.uhome.control.base.api.a aVar = ((com.haier.uhome.control.base.c.a) this).f28862a.get(str);
        if (aVar == null) {
            e3.a.f(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "subscribeResource device not found in deviceMap ", new Object[0]);
            a(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND, nVar);
            return;
        }
        Trace traceCreateDITrace = Trace.createDITrace();
        final com.haier.uhome.control.base.d.a aVar2 = new com.haier.uhome.control.base.d.a(traceCreateDITrace, "getResInfo", aVar);
        DeviceOperReq deviceOperReqD = d();
        deviceOperReqD.setNativeSender(this.f29156g);
        deviceOperReqD.setDevId(str);
        deviceOperReqD.setOp("getResInfo");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new OperArgs(str2, str2));
        deviceOperReqD.setArgs(arrayList);
        deviceOperReqD.setTimeout(15);
        deviceOperReqD.setTraceId(traceCreateDITrace == null ? null : traceCreateDITrace.getTraceId());
        com.haier.uhome.usdk.base.d.a.a().a(deviceOperReqD, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.u
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f29249a.a(aVar2, nVar, str, str2, i7, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.control.base.d.a aVar, com.haier.uhome.usdk.base.api.n nVar, String str, String str2, int i7, BasicResp basicResp) {
        DeviceOperResp deviceOperResp = (DeviceOperResp) basicResp;
        aVar.a(new uSDKError(deviceOperResp.getErrNo()));
        if (deviceOperResp.getErrNo() != 0) {
            a(ErrorConst.getErrorConstById(deviceOperResp.getErrNo()), nVar);
        } else {
            a(str, deviceOperResp, str2, i7, (com.haier.uhome.usdk.base.api.n<com.haier.uhome.control.cloud.api.e>) nVar);
        }
    }

    public void a(String str, ICallback<FOTAInfo> iCallback) {
        com.haier.uhome.control.cloud.b.c.a(str, 30, iCallback);
    }

    private FOTAStatusInfo a(FetchFotaStatusResp fetchFotaStatusResp) {
        uSDKError usdkerrorB;
        if (fetchFotaStatusResp == null) {
            return null;
        }
        if (fetchFotaStatusResp.getErrNo() == 0) {
            usdkerrorB = new uSDKError(fetchFotaStatusResp.getUpgradeErrNo());
        } else {
            usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(fetchFotaStatusResp);
        }
        return new FOTAStatusInfo(fetchFotaStatusResp.getStatus(), usdkerrorB);
    }

    public void a(String str, int i7, final ICallback<ModuleInfo> iCallback) {
        if (i7 < 5 || i7 > 120) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (iCallback == null) {
            e3.a.e("getModuleInfo with null callback", new Object[0]);
            return;
        }
        GetModuleInfoReq getModuleInfoReq = new GetModuleInfoReq();
        getModuleInfoReq.setModule(com.haier.uhome.usdk.base.a.ao);
        getModuleInfoReq.setTimeout(i7);
        getModuleInfoReq.setDevId(str);
        getModuleInfoReq.setNativeSender(this.f29156g);
        com.haier.uhome.usdk.base.d.a.a().a(getModuleInfoReq, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.k
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.d(iCallback, basicResp);
            }
        });
    }

    public void a(String str, FOTAInfo fOTAInfo, final ICallback<Void> iCallback) {
        if (fOTAInfo == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_FOTA_INFO_IS_NULL.toError());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (!fOTAInfo.isNeedFOTA()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DONT_NEED_FOTA.toError());
            return;
        }
        BoardFOTAReq boardFOTAReq = new BoardFOTAReq();
        boardFOTAReq.setNativeSender(this.f29156g);
        boardFOTAReq.setDevId(str);
        boardFOTAReq.setTimeout(15);
        boardFOTAReq.setFotaTimeout(15);
        boardFOTAReq.setDigestAlg(fOTAInfo.b());
        boardFOTAReq.setDigest(fOTAInfo.c());
        boardFOTAReq.setUrl(fOTAInfo.a());
        boardFOTAReq.setKeyAlg(fOTAInfo.d());
        boardFOTAReq.setKey(fOTAInfo.e());
        boardFOTAReq.setSize(fOTAInfo.getSize());
        boardFOTAReq.setTraceId(com.haier.uhome.trace.c.a.a());
        com.haier.uhome.usdk.base.d.a.a().a(boardFOTAReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.h
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.c(iCallback, basicResp);
            }
        });
    }

    public void a(String str, DeviceFOTAInfo deviceFOTAInfo, final ICallback<Void> iCallback) {
        if (deviceFOTAInfo != null && !TextUtils.isEmpty(deviceFOTAInfo.b()) && !TextUtils.isEmpty(deviceFOTAInfo.a())) {
            DeviceStartFotaReq deviceStartFotaReq = new DeviceStartFotaReq();
            deviceStartFotaReq.setNativeSender(this.f29156g);
            deviceStartFotaReq.setDevId(str);
            deviceStartFotaReq.setTimeout(15);
            deviceStartFotaReq.setFirmwareID(deviceFOTAInfo.b());
            deviceStartFotaReq.setTraceId(deviceFOTAInfo.a());
            com.haier.uhome.usdk.base.d.a.a().a(deviceStartFotaReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.s
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    c.b(iCallback, basicResp);
                }
            });
            return;
        }
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
    }

    public void a(Trace trace, final ICallback<Void> iCallback) {
        String traceId;
        if (trace == null) {
            traceId = com.haier.uhome.trace.c.a.a();
        } else {
            traceId = trace.getTraceId();
        }
        if (n() != com.haier.uhome.control.cloud.api.b.CONNECTED) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_CLOUD_OFFLINE.toError());
            return;
        }
        OpenBindTimeWindowReq openBindTimeWindowReq = new OpenBindTimeWindowReq();
        openBindTimeWindowReq.setTimeout(15);
        openBindTimeWindowReq.setTraceId(traceId);
        openBindTimeWindowReq.setNativeSender(this.f29156g);
        com.haier.uhome.usdk.base.d.a.a().a(openBindTimeWindowReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.v
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "bind camera open user window error : %s", usdkerrorA);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    public void a(final String str, String str2, String str3, String str4, String str5, final ICallback<Void> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        if (n() != com.haier.uhome.control.cloud.api.b.CONNECTED) {
            iCallback.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
            return;
        }
        GatewayStartPairingReq gatewayStartPairingReq = new GatewayStartPairingReq();
        gatewayStartPairingReq.setNativeSender(this.f29156g);
        gatewayStartPairingReq.setDevId(str);
        gatewayStartPairingReq.setUpid(str2);
        gatewayStartPairingReq.setUpCodeT(str3);
        gatewayStartPairingReq.setExtendInfo(str4);
        gatewayStartPairingReq.setBindSn(str5);
        gatewayStartPairingReq.setTimeout(5);
        com.haier.uhome.usdk.base.d.a.a().a(gatewayStartPairingReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.g
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(str, iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29013k, "startPairing devId<%s> error : %s", str, usdkerrorA);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    public void a(int i7, String str, com.haier.uhome.control.cloud.api.f fVar, final com.haier.uhome.usdk.base.api.s sVar) {
        if (n() != com.haier.uhome.control.cloud.api.b.CONNECTED) {
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_CLOUD_OFFLINE.toError());
            return;
        }
        UpDeviceVersionInfoReq upDeviceVersionInfoReq = new UpDeviceVersionInfoReq();
        upDeviceVersionInfoReq.setTimeout(i7);
        upDeviceVersionInfoReq.setDevId(str);
        upDeviceVersionInfoReq.setSoft(fVar.a());
        upDeviceVersionInfoReq.setSoftVer(fVar.b());
        upDeviceVersionInfoReq.setHard(fVar.c());
        upDeviceVersionInfoReq.setHardVer(fVar.d());
        upDeviceVersionInfoReq.setDevVers(fVar.e());
        upDeviceVersionInfoReq.setNativeSender(this.f29156g);
        upDeviceVersionInfoReq.setType(fVar.f());
        upDeviceVersionInfoReq.setMac(fVar.g());
        com.haier.uhome.usdk.base.d.a.a().a(upDeviceVersionInfoReq, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.i
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                c.a(sVar, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.s sVar, BasicResp basicResp) {
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(basicResp);
        if (sVar != null) {
            sVar.onCallback(usdkerrorB);
        }
    }
}
