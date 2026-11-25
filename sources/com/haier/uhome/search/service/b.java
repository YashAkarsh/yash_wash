package com.haier.uhome.search.service;

import android.content.Context;
import android.text.TextUtils;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.search.service.a implements com.haier.uhome.search.a.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f29812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f29813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.haier.library.common.util.j<String, com.haier.uhome.search.a.c> f29814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.haier.uhome.search.a.f f29815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f29816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.haier.library.common.util.j<String, com.haier.uhome.usdk.base.api.f> f29817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<com.haier.uhome.search.a.g> f29818l;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f29821a = new b();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i7) {
        if (i7 == 1 || i7 == 3) {
            i();
            e();
        } else if (i7 != 2) {
            e3.a.e("bt status changed~", new Object[0]);
        } else if (this.f29813g.get() || this.f29816j.get()) {
            com.haier.uhome.usdk.base.d.f.a().b().postDelayed(new Runnable() { // from class: com.haier.uhome.search.service.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30022a.h();
                }
            }, 1000L);
        }
    }

    public static b c() {
        return a.f29821a;
    }

    private String d(com.haier.uhome.search.service.entity.b bVar) {
        StringBuilder sb = new StringBuilder(bVar.c());
        sb.append('-');
        sb.append(bVar.B());
        sb.append(bVar.C());
        sb.append(bVar.E());
        sb.append(bVar.F());
        sb.append(bVar.G());
        if (com.haier.library.common.util.c.l(bVar.H())) {
            sb.append('-');
            sb.append(bVar.H());
        }
        return sb.toString();
    }

    private void i() {
        j();
    }

    private void j() {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.search.service.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f30019a.l();
            }
        });
    }

    private void k() {
        if (this.f29815i != null) {
            Iterator<Map.Entry<String, com.haier.uhome.search.a.c>> it = this.f29814h.entrySet().iterator();
            while (it.hasNext()) {
                this.f29815i.onDeviceAdd(it.next().getValue().clone());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        e3.a.d("SEARCH", "BLE", "stopNativeSearch Config=%s,Control=%s,running=%s", Boolean.valueOf(this.f29813g.get()), Boolean.valueOf(this.f29816j.get()), Boolean.valueOf(this.f29812f.get()));
        if (this.f29812f.get()) {
            int iB = this.f29792e.b(2);
            this.f29812f.set(iB != 0);
            e3.a.d("SEARCH", "BLE", "stopNativeSearch ret = %d", Integer.valueOf(iB));
        }
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (!this.f29816j.get()) {
            e3.a.e("control scan is not start!", new Object[0]);
            return;
        }
        if (f().equals(str)) {
            if (fVar == null || TextUtils.isEmpty(fVar.b())) {
                e3.a.h("deviceInfo is error,%s", fVar);
                return;
            }
            com.haier.uhome.usdk.base.api.f fVar2 = this.f29817k.get(fVar.b());
            if (fVar2 != null) {
                this.f29817k.a(fVar2.b(), fVar2, 15500L, 500L);
                fVar2.a(System.currentTimeMillis());
                d(str, fVar2);
            } else {
                fVar.a(System.currentTimeMillis());
                com.haier.uhome.usdk.base.api.g.a().b(fVar.b());
                this.f29817k.a(fVar.b(), fVar, 15500L, 500L);
                c(str, fVar);
            }
        }
    }

    private b() {
        com.haier.uhome.ble.hal.jni.a.a().b();
        this.f29814h = new com.haier.library.common.util.j<String, com.haier.uhome.search.a.c>() { // from class: com.haier.uhome.search.service.b.1
            @Override // com.haier.library.common.util.j
            public void a(String str, com.haier.uhome.search.a.c cVar) {
            }

            @Override // com.haier.library.common.util.j
            public void b(String str, com.haier.uhome.search.a.c cVar) {
                if (cVar != null) {
                    com.haier.uhome.search.b.f.a().a(cVar.a(), 10);
                }
            }
        };
        this.f29817k = new com.haier.library.common.util.j<String, com.haier.uhome.usdk.base.api.f>() { // from class: com.haier.uhome.search.service.b.2
            @Override // com.haier.library.common.util.j
            public void a(String str, com.haier.uhome.usdk.base.api.f fVar) {
            }

            @Override // com.haier.library.common.util.j
            public void b(String str, com.haier.uhome.usdk.base.api.f fVar) {
                if (fVar != null) {
                    com.haier.uhome.search.b.f.a().a(com.haier.uhome.usdk.base.a.aq, fVar.b(), 0);
                }
            }
        };
        this.f29812f = new AtomicBoolean(false);
        this.f29818l = new ArrayList();
        this.f29816j = new AtomicBoolean(false);
        this.f29813g = new AtomicBoolean(false);
        com.haier.uhome.usdk.base.c.b.a().a(new com.haier.uhome.usdk.base.c.c() { // from class: com.haier.uhome.search.service.p
            @Override // com.haier.uhome.usdk.base.c.c
            public final void notifyBtStateChanged(int i7) {
                this.f30023j.a(i7);
            }
        });
    }

    private void e() {
        Iterator<String> it = this.f29814h.keySet().iterator();
        while (it.hasNext()) {
            com.haier.uhome.search.b.f.a().a(it.next(), 8);
        }
        Iterator<String> it2 = this.f29817k.keySet().iterator();
        while (it2.hasNext()) {
            com.haier.uhome.search.b.f.a().a(com.haier.uhome.usdk.base.a.aq, it2.next(), 0);
        }
    }

    private String f() {
        return com.haier.uhome.usdk.base.a.aq;
    }

    private void g() {
        if (this.f29815i != null) {
            Iterator<Map.Entry<String, com.haier.uhome.usdk.base.api.f>> it = this.f29817k.entrySet().iterator();
            while (it.hasNext()) {
                c(f(), it.next().getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        b((com.haier.uhome.search.a.j<Void>) null);
    }

    public com.haier.uhome.usdk.base.api.f c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.haier.uhome.usdk.base.api.f fVar = this.f29817k.get(str);
        if (fVar != null) {
            return fVar;
        }
        for (com.haier.uhome.usdk.base.api.f fVar2 : this.f29817k.values()) {
            if (fVar2 instanceof com.haier.uhome.usdk.base.api.f) {
                com.haier.uhome.usdk.base.api.f fVar3 = fVar2;
                if (str.equals(fVar3.b())) {
                    return fVar3;
                }
            }
        }
        return null;
    }

    public ArrayList<com.haier.uhome.usdk.base.api.f> a(ArrayList<com.haier.uhome.usdk.base.api.h> arrayList) {
        ArrayList<com.haier.uhome.usdk.base.api.f> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.contains(com.haier.uhome.usdk.base.api.h.ALL_TYPE)) {
            for (com.haier.uhome.usdk.base.api.f fVar : this.f29817k.values()) {
                if (fVar instanceof com.haier.uhome.usdk.base.api.f) {
                    com.haier.uhome.usdk.base.api.f fVar2 = fVar;
                    if (fVar2.f() != null && arrayList.contains(fVar2.f())) {
                        arrayList2.add(fVar2);
                    }
                }
            }
            return arrayList2;
        }
        arrayList2.addAll(this.f29817k.values());
        return arrayList2;
    }

    @Override // com.haier.uhome.search.service.a
    protected void c(String str, int i7) {
        if (str == null) {
            e3.a.h("Ble search: handleConfigDeviceDel with null deviceId", new Object[0]);
            return;
        }
        com.haier.uhome.search.a.c cVar = this.f29814h.get(str);
        if (cVar != null) {
            this.f29814h.remove(str);
            com.haier.uhome.search.a.f fVar = this.f29815i;
            if (fVar != null) {
                fVar.onDeviceDel(cVar.clone(), i7);
            }
        }
    }

    public boolean d() {
        return this.f29816j.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(com.haier.uhome.search.a.j jVar) {
        e3.a.d("SEARCH", "BLE", "startNativeSearch Config=%s,Control=%s,running=%s", Boolean.valueOf(this.f29813g.get()), Boolean.valueOf(this.f29816j.get()), Boolean.valueOf(this.f29812f.get()));
        if (this.f29812f.get()) {
            return;
        }
        int iA = this.f29792e.a(2);
        this.f29812f.set(iA == 0);
        e3.a.d("SEARCH", "BLE", "startNativeSearch ret = %d", Integer.valueOf(iA));
        if (iA == 0) {
            com.haier.uhome.usdk.base.utils.b.b(jVar, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.b((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
        }
    }

    public void c(ICallback<Void> iCallback) {
        this.f29816j.set(false);
        if (this.f29812f.get() && !this.f29813g.get()) {
            i();
        }
        com.haier.uhome.usdk.base.utils.b.a(iCallback, (Object) null);
    }

    public void a(com.haier.uhome.search.a.f fVar) {
        this.f29815i = fVar;
    }

    public void a(com.haier.uhome.search.a.j<Void> jVar) {
        this.f29813g.set(true);
        if (!this.f29812f.get()) {
            b(jVar);
        } else {
            com.haier.uhome.usdk.base.utils.b.b(jVar, (Object) null);
        }
        k();
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(String str, String str2, int i7) {
        if (f().equals(str)) {
            if (str2 == null) {
                e3.a.h("handleControlDeviceDel with null deviceId", new Object[0]);
                return;
            }
            com.haier.uhome.usdk.base.api.f fVar = this.f29817k.get(str2);
            if (fVar != null) {
                this.f29817k.remove(str2);
                a(str, fVar, i7);
            } else if (i7 == 6) {
                String str3 = str2 + "-del_nonexistent";
                com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(str3);
                fVarA.a(str2);
                a(str, fVarA, i7);
                com.haier.uhome.usdk.base.api.g.a().c(str3);
            }
        }
    }

    private void c(final com.haier.uhome.search.a.j<Void> jVar) {
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.search.service.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f30020a.d(jVar);
            }
        });
    }

    private void c(String str, com.haier.uhome.usdk.base.api.f fVar) {
        ArrayList arrayList;
        synchronized (this.f29818l) {
            arrayList = new ArrayList(this.f29818l);
        }
        e3.a.d("SEARCH", "BLE", "sendControlDeviceAdd deviceInfo =  " + fVar, new Object[0]);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.haier.uhome.search.a.g) it.next()).onDeviceAdd(str, fVar);
        }
    }

    public void a(ICallback<Void> iCallback) {
        this.f29813g.set(false);
        if (this.f29812f.get() && !this.f29816j.get()) {
            i();
        }
        com.haier.uhome.usdk.base.utils.b.a(iCallback, (Object) null);
    }

    private void d(String str, com.haier.uhome.usdk.base.api.f fVar) {
        ArrayList arrayList;
        synchronized (this.f29818l) {
            arrayList = new ArrayList(this.f29818l);
        }
        e3.a.d("SEARCH", "BLE", "sendControlDeviceUpdate deviceInfo =  " + fVar, new Object[0]);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.haier.uhome.search.a.g) it.next()).onDeviceUpdate(str, fVar);
        }
    }

    private void a(String str, com.haier.uhome.usdk.base.api.f fVar, int i7) {
        ArrayList arrayList;
        synchronized (this.f29818l) {
            arrayList = new ArrayList(this.f29818l);
        }
        e3.a.d("SEARCH", "BLE", "sendControlDeviceDel deviceInfo =  " + fVar, new Object[0]);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.haier.uhome.search.a.g) it.next()).onDeviceDel(str, fVar, i7);
        }
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(com.haier.uhome.search.service.entity.b bVar) {
        if (!this.f29813g.get()) {
            e3.a.e("config scan is not start! ", new Object[0]);
            return;
        }
        if (bVar.a() == null) {
            e3.a.h("handleConfigDeviceUpdate with null deviceId", new Object[0]);
            return;
        }
        bVar.j(1);
        bVar.u(com.haier.uhome.search.c.a.l(bVar.c()));
        String strC = bVar.c();
        String strK = bVar.k();
        int iF = com.haier.uhome.usdk.base.utils.f.f(bVar.j());
        if (iF == 1) {
            bVar.i(strC);
        } else {
            String str = "";
            if (iF == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(strC);
                if (com.haier.library.common.util.c.l(bVar.C())) {
                    str = "-" + bVar.C();
                }
                sb.append(str);
                bVar.i(sb.toString());
            } else if (iF == 5) {
                bVar.i(d(bVar));
            } else {
                bVar.i("");
            }
        }
        bVar.f(com.haier.library.common.util.w.c(strK));
        if (bVar.g() == 0) {
            bVar.f(2);
            bVar.n(2);
        } else {
            bVar.f(com.haier.uhome.search.c.a.a(bVar.r()));
            bVar.f(a());
            int iD = bVar.D() > 0 ? bVar.D() : bVar.r();
            if (iD > 0) {
                bVar.n(com.haier.uhome.search.c.a.b(iD));
            } else {
                bVar.n(9);
            }
        }
        if (bVar.i() == 3) {
            if (bVar.g() == 0) {
                bVar.n(2);
            }
            c(bVar);
        } else {
            e3.a.e("Ble search: devId = %s, dto = %s", bVar.a(), bVar);
            c(bVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0167  */
    /* JADX WARN: Code duplicated, block: B:28:0x0169  */
    @Override // com.haier.uhome.search.service.a
    void c(com.haier.uhome.search.service.entity.b bVar) {
        boolean z7;
        super.c(bVar);
        com.haier.uhome.search.a.c cVar = this.f29814h.get(bVar.a());
        if (cVar == null) {
            com.haier.uhome.search.a.c cVar2 = new com.haier.uhome.search.a.c();
            cVar2.a(bVar.a());
            cVar2.u(bVar.K());
            cVar2.b(bVar.b());
            cVar2.c(bVar.c());
            if (com.haier.library.common.util.c.l(bVar.m())) {
                cVar2.e(bVar.m());
            } else {
                cVar2.a(com.haier.uhome.usdk.base.api.h.a(bVar.d()));
                cVar2.b(bVar.e());
            }
            cVar2.d(bVar.f());
            cVar2.c(bVar.l());
            cVar2.a(bVar.i());
            cVar2.h(bVar.j());
            cVar2.d(bVar.h());
            cVar2.i(bVar.t());
            cVar2.k(bVar.A());
            cVar2.t(bVar.p());
            cVar2.a(true);
            cVar2.a(System.currentTimeMillis());
            if (com.haier.uhome.usdk.base.api.e.a(bVar.o())) {
                cVar2.j(bVar.n());
                cVar2.h(bVar.o());
                a(cVar2);
            }
            cVar2.j(bVar.I());
            cVar2.m(bVar.B());
            cVar2.s(bVar.C());
            cVar2.n(bVar.E());
            cVar2.p(bVar.F());
            cVar2.o(bVar.G());
            cVar2.l(bVar.H());
            cVar2.r(bVar.J());
            this.f29814h.a(bVar.a(), cVar2, 15500L, 500L);
            if (this.f29815i == null) {
                e3.a.u("SEARCH", "BLE", "mConfigListener is null, so give up %s add", bVar.a());
                return;
            } else {
                e3.a.d("SEARCH", "BLE", "mConfigListener not null, callback %s add", bVar.a());
                this.f29815i.onDeviceAdd(cVar2.clone());
                return;
            }
        }
        cVar.k(bVar.A());
        cVar.i(bVar.t());
        boolean z8 = cVar.c(bVar.c()) || cVar.b(bVar.b());
        if (com.haier.library.common.util.c.l(bVar.m())) {
            if (cVar.e(bVar.m()) || z8) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            boolean z9 = cVar.a(com.haier.uhome.usdk.base.api.h.a(bVar.d())) || z8;
            if (cVar.b(bVar.e()) || z9) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        boolean z10 = cVar.j(bVar.I()) || (cVar.a(bVar.i()) || (cVar.c(bVar.l()) || (cVar.d(bVar.f()) || z7)));
        cVar.a(true);
        cVar.a(System.currentTimeMillis());
        cVar.d(bVar.h());
        cVar.h(bVar.j());
        cVar.u(bVar.K());
        if (com.haier.uhome.usdk.base.api.e.a(bVar.o())) {
            cVar.j(bVar.n());
            cVar.h(bVar.o());
        }
        this.f29814h.a(bVar.a(), cVar, 15500L, 500L);
        if (this.f29815i == null || !z10) {
            e3.a.u("SEARCH", "BLE", "mConfigListener is null, so give up %s update", bVar.a());
        } else {
            e3.a.d("SEARCH", "BLE", "mConfigListener not null, callback %s update", bVar.a());
            this.f29815i.onDeviceUpdate(cVar.clone());
        }
    }

    com.haier.uhome.search.a.c d(String str) {
        if (com.haier.library.common.util.c.j(str)) {
            return null;
        }
        for (com.haier.uhome.search.a.c cVar : this.f29814h.values()) {
            if (com.haier.library.common.util.c.l(cVar.a()) && cVar.a().endsWith(str)) {
                return cVar;
            }
        }
        return null;
    }

    public void a(com.haier.uhome.search.a.g gVar) {
        synchronized (this.f29818l) {
            if (this.f29818l.contains(gVar)) {
                e3.a.v("Search: add listener repeat!", new Object[0]);
            } else {
                this.f29818l.add(gVar);
            }
        }
    }

    private void a(com.haier.uhome.search.a.c cVar) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("rptBleAdvDI:diTrace is empty,so return", new Object[0]);
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, "reportBLEAdvModel", cVar.a(), "0", VersionManager.getInstance().getSDKVersion());
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        dITraceNode.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }

    @Override // com.haier.uhome.search.a.b
    public boolean a(String str) {
        return this.f29814h.containsKey(str);
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(com.haier.uhome.search.service.entity.c cVar) {
        if (!this.f29813g.get()) {
            e3.a.e("Ble search: config scan is not start! ", new Object[0]);
            return;
        }
        if (cVar == null) {
            e3.a.h("Ble search: handleDeviceAdvUnBound with null unbound", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(cVar.d())) {
            e3.a.h("Ble search: handleDeviceAdvUnBound with null devId", new Object[0]);
            return;
        }
        com.haier.library.sumhttp.response.i iVarB = b(cVar.h());
        if (iVarB == null) {
            e3.a.v("Ble search: findProductCache return null", new Object[0]);
            return;
        }
        com.haier.uhome.search.service.entity.b bVarA = com.haier.uhome.search.service.entity.b.a(cVar);
        bVarA.d(iVarB.c());
        bVarA.g(iVarB.d());
        bVarA.g(8);
        bVarA.e(1);
        bVarA.f(64);
        bVarA.n(64);
        bVarA.c(cVar.c());
        com.haier.uhome.usdk.base.utils.f.a aVarA = com.haier.uhome.usdk.base.utils.f.a(iVarB.d());
        if (aVarA != null) {
            bVarA.a(aVarA.a().b());
            bVarA.b(aVarA.b());
        }
        c(bVarA);
    }

    public void b(ICallback<Void> iCallback) {
        this.f29816j.set(true);
        if (!this.f29812f.get()) {
            h();
        }
        com.haier.uhome.usdk.base.utils.b.a(iCallback, (Object) null);
        g();
    }

    private void b(com.haier.uhome.search.a.j<Void> jVar) {
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.u("SEARCH", "BLE", "===> ble adapter is off!", new Object[0]);
            com.haier.uhome.search.service.a.a(jVar, 16);
        }
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (!com.haier.library.common.util.f.D(contextB)) {
            e3.a.u("SEARCH", "BLE", "===> location service disabled!", new Object[0]);
            com.haier.uhome.search.service.a.b(jVar, 16);
        }
        if (!com.haier.library.common.util.f.j(contextB, "android.permission.ACCESS_FINE_LOCATION")) {
            e3.a.u("SEARCH", "BLE", "===> location permission is denied!", new Object[0]);
            com.haier.uhome.search.service.a.b(jVar, 16);
        }
        c(jVar);
    }

    @Override // com.haier.uhome.search.service.a
    public void b(com.haier.uhome.search.service.entity.d dVar) {
        ArrayList arrayList;
        synchronized (this.f29818l) {
            arrayList = new ArrayList(this.f29818l);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.haier.uhome.search.a.g) it.next()).a(dVar);
        }
    }

    public void b(com.haier.uhome.search.a.g gVar) {
        synchronized (this.f29818l) {
            this.f29818l.remove(gVar);
        }
    }
}
