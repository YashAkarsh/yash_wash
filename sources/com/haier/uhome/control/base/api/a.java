package com.haier.uhome.control.base.api;

import android.text.TextUtils;
import com.haier.uhome.control.base.json.DeviceTokenInfo;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.haier.uhome.usdk.base.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f28733a = -25014;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f28734b = 15000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Integer f28735c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Integer f28736d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f28737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Integer, i> f28738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicReference<DeviceStatus> f28739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f28740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<com.haier.uhome.control.base.api.b> f28741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, d> f28742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AtomicBoolean f28743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicBoolean f28744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AtomicBoolean f28745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f28746n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AtomicBoolean f28747o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AtomicBoolean f28748p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.a f28749q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<C0367a> f28750r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b f28751s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f28752t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicBoolean f28753u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final com.haier.uhome.usdk.base.utils.d<com.haier.uhome.usdk.base.api.o> f28754v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final com.haier.uhome.usdk.base.utils.d<com.haier.uhome.usdk.base.api.o> f28755w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f28756x;

    /* JADX INFO: renamed from: com.haier.uhome.control.base.api.a$a, reason: collision with other inner class name */
    public class C0367a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.haier.library.common.b.e f28767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private uSDKError f28768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f28769d;

        public C0367a(int i7) {
            a(ErrorConst.RET_USDK_OK);
            if (a.this.F() != com.haier.uhome.usdk.base.a.ar) {
                c();
                if (com.haier.library.common.b.h.a().c(com.haier.uhome.usdk.base.service.e.a().b())) {
                    return;
                }
                a(ErrorConst.ERR_USDK_NETWORK_IS_NONE);
            }
        }

        private void b() {
            com.haier.library.common.b.h.a().d(com.haier.uhome.usdk.base.service.e.a().b(), this.f28767b);
        }

        private void c() {
            this.f28769d = com.haier.library.common.util.w.g(com.haier.uhome.usdk.base.service.e.a().b());
            this.f28767b = new com.haier.library.common.b.e() { // from class: com.haier.uhome.control.base.api.l0
                @Override // com.haier.library.common.b.e
                public /* synthetic */ void a(com.haier.library.common.b.r rVar) {
                    com.haier.library.common.b.b.a(this, rVar);
                }

                @Override // com.haier.library.common.b.e
                public final void a(com.haier.library.common.b.a aVar) {
                    this.f28825a.a(aVar);
                }
            };
            com.haier.library.common.b.h.a().b(com.haier.uhome.usdk.base.service.e.a().b(), this.f28767b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(DeviceStatus deviceStatus, int i7) {
            if (deviceStatus == DeviceStatus.STATUS_CONNECTED || deviceStatus == DeviceStatus.STATUS_READY) {
                return;
            }
            if (i7 == a.f28733a) {
                a(ErrorConst.ERR_USDK_PHONE_IS_OFFLINE);
            } else {
                a(ErrorConst.ERR_USDK_DEVICE_IS_OFFLINE);
            }
        }

        public uSDKError a() {
            if (a.this.F() != com.haier.uhome.usdk.base.a.ar) {
                b();
                a.this.a(this);
            }
            e3.a.d("ChannelHealth<%s> free with %s", a.this.X(), this.f28768c.toString(), new Object[0]);
            return this.f28768c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.haier.library.common.b.a aVar) {
            e3.a.d("mLastNetworkId = %s, connectStatus = %s", this.f28769d, aVar.toString(), new Object[0]);
            if (!aVar.h()) {
                a(ErrorConst.ERR_USDK_NETWORK_IS_NONE);
            } else {
                if (this.f28769d.equals(aVar.k())) {
                    return;
                }
                a(ErrorConst.ERR_USDK_NETWORK_IS_SWITCHED);
            }
        }

        private void a(ErrorConst errorConst) {
            if (this.f28768c == null) {
                this.f28768c = errorConst.toError();
            }
            if (a(this.f28768c) > a(errorConst.toError())) {
                return;
            }
            this.f28768c.setCode(errorConst.getErrorId());
            this.f28768c.setDescription(errorConst.getErrorInfo());
        }

        private int a(uSDKError usdkerror) {
            if (usdkerror == null) {
                return 0;
            }
            if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                return 1;
            }
            if (usdkerror.a(ErrorConst.ERR_USDK_DEVICE_IS_OFFLINE)) {
                return 2;
            }
            if (usdkerror.a(ErrorConst.ERR_USDK_PHONE_IS_OFFLINE)) {
                return 3;
            }
            if (usdkerror.a(ErrorConst.ERR_USDK_NETWORK_IS_NONE)) {
                return 4;
            }
            return usdkerror.a(ErrorConst.ERR_USDK_NETWORK_IS_SWITCHED) ? 5 : 0;
        }
    }

    protected a(String str, String str2, String str3) {
        super(str, str3);
        this.f28753u = new AtomicBoolean();
        this.f28754v = new com.haier.uhome.usdk.base.utils.d<>();
        this.f28755w = new com.haier.uhome.usdk.base.utils.d<>();
        this.f28756x = new AtomicBoolean(false);
        this.f28738f = new ConcurrentHashMap();
        a(str2);
        J();
    }

    private void J() {
        this.f28750r = new ArrayList();
        this.f28739g = new AtomicReference<>();
        a(F(), DeviceStatus.STATUS_UNCONNECT, 0);
        this.f28741i = new ArrayList();
        this.f28742j = new ConcurrentHashMap();
        this.f28744l = new AtomicBoolean(false);
        this.f28743k = new AtomicBoolean(false);
        this.f28745m = new AtomicBoolean(false);
        this.f28748p = new AtomicBoolean(false);
        this.f28746n = System.currentTimeMillis();
        this.f28747o = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void K() {
        b bVar = this.f28751s;
        if (bVar != null) {
            bVar.a((com.haier.uhome.usdk.base.api.o) null);
            bVar.i();
        }
        long jB = B();
        e3.a.e("Create new timer interval: %d, tryGetAllProperty with device<%s>", Long.valueOf(jB), X());
        b bVar2 = new b(jB);
        bVar2.a(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.base.api.b0
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f28780a.a(errorConst);
            }
        });
        bVar2.a();
        this.f28751s = bVar2;
    }

    private String L() {
        String strF = F();
        if ("local".equals(strF)) {
            return "lst";
        }
        if (com.haier.uhome.usdk.base.a.ao.equals(strF)) {
            return "rst";
        }
        if (com.haier.uhome.usdk.base.a.aq.equals(strF)) {
            return "blest";
        }
        return null;
    }

    private boolean M() {
        return this.f28753u.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        synchronized (this.f28753u) {
            s().b(this);
            this.f28753u.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(com.haier.uhome.usdk.base.api.o oVar, ErrorConst errorConst) {
        if (oVar != null) {
            oVar.onCallback(errorConst);
        }
    }

    public boolean A() {
        return this.f28748p.get();
    }

    protected long B() {
        return f28734b;
    }

    public com.haier.uhome.usdk.base.utils.d<com.haier.uhome.usdk.base.api.o> C() {
        return this.f28754v;
    }

    public com.haier.uhome.usdk.base.utils.d<com.haier.uhome.usdk.base.api.o> D() {
        return this.f28755w;
    }

    protected boolean E() {
        return true;
    }

    protected String F() {
        return s().f();
    }

    public abstract void a(com.haier.uhome.usdk.base.api.o oVar);

    public abstract void a(String str, int i7, Trace trace, ICallback<String> iCallback);

    public abstract void a(String str, String str2, int i7, Trace trace, ICallback<Void> iCallback);

    public abstract void a(String str, List<c> list, int i7, Trace trace, String str2, ICallback<Void> iCallback);

    public abstract void a(boolean z7, com.haier.uhome.usdk.base.api.o oVar);

    public abstract void b(com.haier.uhome.usdk.base.api.o oVar);

    public void d(boolean z7) {
        this.f28747o.set(z7);
    }

    public abstract String e();

    public abstract void f();

    public AtomicBoolean f_() {
        return this.f28756x;
    }

    protected void g_() {
        a aVarB;
        if (com.haier.uhome.control.base.c.d(W())) {
            String strU = U();
            String strX = X();
            if (!TextUtils.isEmpty(strU) && (aVarB = s().b(strU)) != null) {
                aVarB.b(strX);
            }
            if (com.haier.uhome.control.base.c.c(strX)) {
                return;
            }
            for (String str : s().a()) {
                if (com.haier.uhome.control.base.c.a(strX, str)) {
                    b(str);
                }
            }
        }
    }

    public void h() {
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.control.base.api.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f28836a.K();
            }
        });
    }

    public long h_() {
        return this.f28752t;
    }

    public abstract com.haier.uhome.control.base.c.a s();

    public void t() {
        e3.a.e("device <%s> disconnect...,so clear all", X());
        a(F(), DeviceStatus.STATUS_UNCONNECT, 0);
        this.f28741i.clear();
        this.f28742j.clear();
    }

    @Override // com.haier.uhome.usdk.base.api.b
    public String toString() {
        return "AbsControlDevice{" + X() + com.alipay.sdk.util.j.f13808d;
    }

    public boolean u() {
        return this.f28743k.get();
    }

    public boolean v() {
        return this.f28744l.get();
    }

    public boolean w() {
        return this.f28745m.get();
    }

    public long x() {
        return this.f28746n;
    }

    public void y() {
        e3.a.o("checkOnline updateLastOnLineTime <%s>", X());
        this.f28746n = System.currentTimeMillis();
    }

    public boolean z() {
        return this.f28747o.get();
    }

    /* JADX INFO: renamed from: com.haier.uhome.control.base.api.a$2, reason: invalid class name */
    class AnonymousClass2 implements ICallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.uhome.usdk.base.api.o f28759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f28760b;

        AnonymousClass2(com.haier.uhome.usdk.base.api.o oVar, String str) {
            this.f28759a = oVar;
            this.f28760b = str;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r7) {
            com.haier.uhome.usdk.base.api.o oVar = this.f28759a;
            if (oVar != null) {
                oVar.onCallback(ErrorConst.RET_USDK_OK);
            }
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            a aVar = a.this;
            String str = this.f28760b;
            final com.haier.uhome.usdk.base.api.o oVar = this.f28759a;
            aVar.b(str, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.base.api.h0
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    a.AnonymousClass2.a(oVar, errorConst);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(final com.haier.uhome.usdk.base.api.o oVar, ErrorConst errorConst) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.i0
                @Override // java.lang.Runnable
                public final void run() {
                    a.AnonymousClass2.a(oVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar) {
            if (oVar != null) {
                oVar.onCallback(ErrorConst.ERR_USDK_DEVICE_AUTHORIZE_ERROR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(k kVar, ErrorConst errorConst) {
        if (kVar != null) {
            kVar.onGetDeviceAuthState(errorConst, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL);
        } else {
            e3.a.u("", "", "getDeviceBindInfo callback is null,so give up callback", new Object[0]);
        }
    }

    public void b(String str, final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.control.base.c.a aVarS = s();
        if (aVarS != null) {
            aVarS.a(str, X(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.base.api.z
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f28843a.a(oVar, errorConst);
                }
            });
        }
    }

    public void d(com.haier.uhome.usdk.base.api.o oVar) {
        c("disconnect", oVar);
    }

    public int g() {
        return this.f28740h;
    }

    public void i() {
        b bVar = this.f28751s;
        if (bVar == null) {
            return;
        }
        synchronized (this.f28753u) {
            bVar.f();
            this.f28753u.set(false);
        }
        if (bVar.c() && bVar.d() && E()) {
            s().e(this);
        }
    }

    public void j() {
        b bVar = this.f28751s;
        if (bVar != null) {
            bVar.g();
        }
    }

    public boolean k() {
        return this.f28751s != null && M();
    }

    public List<String> l() {
        return this.f28737e;
    }

    protected List<Integer> m() {
        int iB = com.haier.uhome.control.base.c.b(X());
        if (iB <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(iB));
        return arrayList;
    }

    public DeviceStatus n() {
        return this.f28739g.get();
    }

    public i o() {
        return this.f28738f.get(f28735c);
    }

    public com.haier.uhome.usdk.base.api.a p() {
        return this.f28749q;
    }

    public Map<String, d> q() {
        return this.f28742j;
    }

    public List<com.haier.uhome.control.base.api.b> r() {
        return this.f28741i;
    }

    /* JADX INFO: renamed from: com.haier.uhome.control.base.api.a$4, reason: invalid class name */
    class AnonymousClass4 implements ICallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f28764a;

        AnonymousClass4(k kVar) {
            this.f28764a = kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(k kVar) {
            if (kVar != null) {
                kVar.onGetDeviceAuthState(ErrorConst.RET_USDK_OK, true);
            }
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (str == null || !str.equals("True")) {
                com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
                final k kVar = this.f28764a;
                aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.api.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.AnonymousClass4.a(kVar);
                    }
                });
            } else {
                com.haier.library.common.thread.a aVarB2 = com.haier.library.common.thread.a.b();
                final k kVar2 = this.f28764a;
                aVarB2.c(new Runnable() { // from class: com.haier.uhome.control.base.api.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.AnonymousClass4.b(kVar2);
                    }
                });
            }
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            this.f28764a.onGetDeviceAuthState(ErrorConst.RET_USDK_OK, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(k kVar) {
            if (kVar != null) {
                kVar.onGetDeviceAuthState(ErrorConst.RET_USDK_OK, false);
            }
        }
    }

    class b extends com.haier.uhome.usdk.base.utils.e.a<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f28770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.haier.uhome.usdk.base.api.o f28771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AtomicBoolean f28772c;

        b(long j7) {
            super(com.haier.uhome.usdk.base.utils.e.k(), j7);
            this.f28772c = new AtomicBoolean();
            this.f28770a = a.this;
        }

        @Override // com.haier.uhome.usdk.base.utils.e
        public void a() {
            if (this.f28770a == null) {
                return;
            }
            this.f28772c.set(false);
            super.a();
        }

        boolean b() {
            return !this.f28770a.A() || this.f28770a.n() == DeviceStatus.STATUS_UNCONNECT || this.f28770a.n() == DeviceStatus.STATUS_OFFLINE || this.f28770a.n() == DeviceStatus.STATUS_CONNECTING;
        }

        boolean c() {
            if (this.f28770a.n() != DeviceStatus.STATUS_READY) {
                return false;
            }
            e3.a.e("DeviceOperResp getAllProperty exit,device already STATUS_READY", new Object[0]);
            return true;
        }

        public boolean d() {
            return this.f28772c.get();
        }

        @Override // com.haier.uhome.usdk.base.utils.e.a
        public void e() {
            this.f28772c.set(true);
            super.e();
        }

        void f() {
            if (h() && c()) {
                e();
            }
        }

        void g() {
            if (h() && b()) {
                e();
                i();
            }
        }

        @Override // com.haier.uhome.usdk.base.utils.e
        public void a(long j7) {
            if (b()) {
                e();
            } else if (!c()) {
                a.this.N();
                l();
            } else {
                e();
            }
        }

        @Override // com.haier.uhome.usdk.base.utils.e
        /* JADX INFO: renamed from: a */
        public void d(com.haier.uhome.usdk.base.api.c<Void> cVar) {
            Object[] objArr = new Object[1];
            a aVar = this.f28770a;
            objArr[0] = aVar == null ? "" : aVar.X();
            e3.a.e("RetryGetAllProperty with device<%s> finish", objArr);
            com.haier.uhome.usdk.base.api.o oVar = this.f28771b;
            if (oVar != null) {
                oVar.onCallback(cVar == null ? null : cVar.a());
            }
        }

        void a(com.haier.uhome.usdk.base.api.o oVar) {
            this.f28771b = oVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(DeviceStatus deviceStatus, int i7) {
        Iterator<i> it = this.f28738f.values().iterator();
        while (it.hasNext()) {
            it.next().a(F(), X(), deviceStatus, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.usdk.base.api.o oVar, ErrorConst errorConst) {
        if (oVar != null) {
            oVar.onCallback(errorConst);
        }
    }

    public Object a() {
        Object obj = this.f28748p;
        if (obj == null) {
            obj = this;
        }
        return s().a(obj, X());
    }

    public void e(boolean z7) {
        e3.a.e("device<%s> setConnectedStatus to %s", X(), Boolean.valueOf(z7));
        this.f28748p.set(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(k kVar, ErrorConst errorConst) {
        if (kVar != null) {
            kVar.onGetDeviceAuthState(errorConst, true);
        }
    }

    public void c(boolean z7) {
        this.f28745m.set(z7);
    }

    private void b(String str) {
        if (this.f28737e == null) {
            this.f28737e = new CopyOnWriteArrayList();
        }
        this.f28737e.add(str);
    }

    @Override // com.haier.uhome.usdk.base.api.b
    public void a(final String str) {
        com.haier.uhome.usdk.base.service.d.p().c(str, new ICallback<com.haier.uhome.usdk.base.api.a>() { // from class: com.haier.uhome.control.base.api.a.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.base.api.a aVar) {
                a.this.f28749q = aVar;
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.h("getProtocolType uplusId <%s> failed!!", str);
                a.this.f28749q = com.haier.uhome.usdk.base.api.a.APP_PROT_SIXID;
            }
        });
        super.a(str);
    }

    public void c(com.haier.uhome.usdk.base.api.o oVar) {
        c(u() ? "connectNeedProperties" : "connect", oVar);
    }

    private void c(String str, com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.trace.api.a.a(str, X(), oVar);
    }

    public void a(long j7) {
        this.f28752t = j7;
    }

    public void a(int i7) {
        this.f28740h = i7;
    }

    public synchronized C0367a b(int i7) {
        C0367a c0367a;
        c0367a = new C0367a(i7);
        this.f28750r.add(c0367a);
        return c0367a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ErrorConst errorConst) {
        e3.a.e("Release timer!", new Object[0]);
        this.f28751s = null;
    }

    private void b(DeviceStatus deviceStatus, int i7) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            return;
        }
        String strL = L();
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(strL, com.haier.uhome.control.base.d.b.a(deviceStatus), X(), null, VersionManager.getInstance().getSDKVersion());
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        if (DeviceStatus.STATUS_OFFLINE == deviceStatus) {
            dITraceNode.add("code", String.valueOf(i7));
        }
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }

    public void a(String str, m mVar) {
        com.haier.uhome.control.base.c.a aVarS = s();
        if (aVarS != null) {
            aVarS.a(str, X(), mVar);
        } else {
            mVar.onDeviceNetQualityGet(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND, null, 0);
        }
    }

    public void a(String str, ICallback<s> iCallback) {
        com.haier.uhome.control.base.c.a aVarS = s();
        if (aVarS != null) {
            aVarS.a(str, X(), iCallback);
        } else {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
        }
    }

    public void a(final String str, final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.control.base.c.a aVarS = s();
        if (aVarS != null) {
            aVarS.a(str, X(), new n() { // from class: com.haier.uhome.control.base.api.g0
                @Override // com.haier.uhome.control.base.api.n
                public final void onDeviceTokenGet(ErrorConst errorConst, String str2) {
                    this.f28818a.a(oVar, str, errorConst, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.haier.uhome.usdk.base.api.o oVar, String str, final ErrorConst errorConst, String str2) {
        if (errorConst.equals(ErrorConst.RET_USDK_OK)) {
            a("authDeviceToken", str2, 15, Trace.createDITrace(), new AnonymousClass2(oVar, str));
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.a0
                @Override // java.lang.Runnable
                public final void run() {
                    a.c(oVar, errorConst);
                }
            });
        }
    }

    void b(i iVar) {
        if (iVar != null) {
            this.f28738f.put(f28736d, iVar);
        } else {
            this.f28738f.remove(f28736d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.haier.uhome.usdk.base.api.o oVar, final ErrorConst errorConst) {
        if (errorConst.equals(ErrorConst.RET_USDK_OK)) {
            a("authDeviceToken", "", 15, Trace.createDITrace(), new ICallback<Void>() { // from class: com.haier.uhome.control.base.api.a.3
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    com.haier.uhome.usdk.base.api.o oVar2 = oVar;
                    if (oVar2 != null) {
                        oVar2.onCallback(ErrorConst.RET_USDK_OK);
                    }
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.api.o oVar2 = oVar;
                    if (oVar2 != null) {
                        oVar2.onCallback(ErrorConst.RET_USDK_OK);
                    }
                }
            });
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.t
                @Override // java.lang.Runnable
                public final void run() {
                    a.b(oVar, errorConst);
                }
            });
        }
    }

    public void b(boolean z7) {
        this.f28744l.set(z7);
    }

    public void a(String str, final k kVar) {
        com.haier.uhome.control.base.c.a aVarS = s();
        if (aVarS != null) {
            aVarS.a(str, new j() { // from class: com.haier.uhome.control.base.api.f0
                @Override // com.haier.uhome.control.base.api.j
                public final void onDeviceTokenInfoList(ErrorConst errorConst, DeviceTokenInfo[] deviceTokenInfoArr) {
                    this.f28799a.a(kVar, errorConst, deviceTokenInfoArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final k kVar, final ErrorConst errorConst, DeviceTokenInfo[] deviceTokenInfoArr) {
        int i7;
        if (errorConst.equals(ErrorConst.RET_USDK_OK)) {
            String strX = X();
            if (deviceTokenInfoArr != null) {
                i7 = 0;
                for (DeviceTokenInfo deviceTokenInfo : deviceTokenInfoArr) {
                    if (deviceTokenInfo.getDeviceId().equals(strX)) {
                        i7++;
                    }
                }
            } else {
                i7 = 0;
            }
            e3.a.o("isvalid~~~~~~" + i7, new Object[0]);
            if (i7 == 0) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c(kVar, errorConst);
                    }
                });
                return;
            }
            if (i7 > 0 && n() != DeviceStatus.STATUS_CONNECTED && n() != DeviceStatus.STATUS_READY) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.b(kVar, errorConst);
                    }
                });
                return;
            } else {
                if (i7 > 0) {
                    if (n() == DeviceStatus.STATUS_CONNECTED || n() == DeviceStatus.STATUS_READY) {
                        a("authDeviceState", 15, Trace.createDITrace(), new AnonymousClass4(kVar));
                        return;
                    }
                    return;
                }
                return;
            }
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.e0
            @Override // java.lang.Runnable
            public final void run() {
                a.a(kVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(k kVar, ErrorConst errorConst) {
        if (kVar != null) {
            kVar.onGetDeviceAuthState(errorConst, false);
        }
    }

    public void a(String str, final DeviceStatus deviceStatus, final int i7) {
        if (deviceStatus == DeviceStatus.STATUS_CONNECTED && this.f28739g.get() == DeviceStatus.STATUS_READY) {
            e3.a.d("Ignore changed device status, origin status is %s, current status is %s", this.f28739g.get().getValue(), deviceStatus.getValue(), new Object[0]);
            return;
        }
        synchronized (this.f28739g) {
            if (deviceStatus == this.f28739g.get()) {
                return;
            }
            this.f28739g.set(deviceStatus);
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28839a.c(deviceStatus, i7);
                }
            });
            if (deviceStatus == DeviceStatus.STATUS_OFFLINE) {
                this.f28740h = i7;
                this.f28742j.clear();
            } else {
                this.f28740h = 0;
            }
            a(deviceStatus, i7);
            b(deviceStatus, this.f28740h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0367a c0367a) {
        this.f28750r.remove(c0367a);
    }

    private synchronized void a(DeviceStatus deviceStatus, int i7) {
        Iterator<C0367a> it = this.f28750r.iterator();
        while (it.hasNext()) {
            it.next().a(deviceStatus, i7);
        }
    }

    public void a(i iVar) {
        this.f28738f.put(f28735c, iVar);
    }

    public void a(Map<String, d> map) {
        this.f28742j = map;
    }

    public void a(List<com.haier.uhome.control.base.api.b> list) {
        this.f28741i = list;
    }

    public void a(String str, boolean z7, TraceNode traceNode, final l lVar) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.v
            @Override // java.lang.Runnable
            public final void run() {
                a.a(lVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(l lVar) {
        if (lVar != null) {
            lVar.onDeviceBindInfoGet(ErrorConst.ERR_USDK_NOT_SUPPORT, null);
        } else {
            e3.a.u("", "", "getDeviceBindInfo callback is null,so give up callback", new Object[0]);
        }
    }

    public void a(String str, int i7, String str2, final com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.w
            @Override // java.lang.Runnable
            public final void run() {
                a.e(oVar);
            }
        });
    }

    public void a(int i7, Trace trace, final ICallback<r> iCallback) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.api.y
            @Override // java.lang.Runnable
            public final void run() {
                a.a(iCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback) {
        if (iCallback != null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL.toError());
        } else {
            e3.a.u("", "", "getDeviceBindInfo callback is null,so give up callback", new Object[0]);
        }
    }

    public void a(boolean z7) {
        this.f28743k.set(z7);
    }
}
