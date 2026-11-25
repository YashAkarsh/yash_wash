package com.haier.uhome.search.service;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.haier.uhome.search.service.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f29944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.haier.uhome.search.a.c> f29945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.haier.uhome.search.a.f f29946h;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f29947a = new g();

        private a() {
        }
    }

    public static g c() {
        return a.f29947a;
    }

    private void e() {
        Iterator<Map.Entry<String, com.haier.uhome.search.a.c>> it = this.f29945g.entrySet().iterator();
        while (it.hasNext()) {
            a(it.next().getValue());
        }
    }

    private void f() {
        Iterator<Map.Entry<String, com.haier.uhome.search.a.c>> it = this.f29945g.entrySet().iterator();
        while (it.hasNext()) {
            a(it.next().getValue(), 0);
        }
    }

    void a(com.haier.uhome.search.a.j<Void> jVar) {
        if (!com.haier.library.common.util.w.m(com.haier.uhome.usdk.base.service.e.a().b())) {
            e3.a.v("NewDirect search: wifi disable!", new Object[0]);
            com.haier.uhome.search.service.a.a(jVar, 32);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
        } else {
            e3.a.e("startConfigScan", new Object[0]);
            this.f29944f.set(true);
            com.haier.uhome.usdk.base.utils.b.a(jVar, (Object) null);
            e();
        }
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(String str, String str2, String str3, String str4, int i7, String str5, String str6, int i8, String str7, int i9) {
        if (str2 == null) {
            e3.a.h("handleDirectLinkConfigUpdate with null devId", new Object[0]);
            return;
        }
        com.haier.uhome.search.service.entity.b bVar = new com.haier.uhome.search.service.entity.b();
        bVar.a(str2);
        bVar.c(str5);
        bVar.g(str3);
        bVar.k(str4);
        bVar.k(i7);
        bVar.d(str6);
        bVar.l(i8);
        bVar.l(str7);
        bVar.m(i9);
        bVar.f(16);
        bVar.e(1);
        bVar.j(4);
        bVar.n(16);
        com.haier.uhome.usdk.base.utils.f.a aVarA = com.haier.uhome.usdk.base.utils.f.a(str3);
        if (aVarA != null) {
            bVar.a(aVarA.a().b());
            bVar.b(aVarA.b());
        }
        c(bVar);
    }

    @Override // com.haier.uhome.search.service.a
    protected void d(String str, int i7) {
        if (str == null) {
            e3.a.h("handleDirectLinkConfigDelete with null devId", new Object[0]);
            return;
        }
        com.haier.uhome.search.a.c cVar = this.f29945g.get(str);
        if (cVar != null) {
            this.f29945g.remove(str);
            a(cVar, i7);
        }
    }

    private g() {
        this.f29944f = new AtomicBoolean(false);
        this.f29945g = new ConcurrentHashMap<>();
    }

    @Override // com.haier.uhome.search.service.a
    void c(com.haier.uhome.search.service.entity.b bVar) {
        super.c(bVar);
        com.haier.uhome.search.a.c cVar = this.f29945g.get(bVar.a());
        boolean z7 = true;
        if (cVar != null) {
            cVar.e(bVar.m());
            cVar.e(bVar.w());
            cVar.f(bVar.y());
            boolean z8 = cVar.d(bVar.f()) || (cVar.c(bVar.c()) || (cVar.g(bVar.v()) || cVar.g(bVar.u())));
            if (!cVar.f(bVar.x()) && !z8) {
                z7 = false;
            }
            this.f29945g.put(cVar.a(), cVar);
            cVar.a(System.currentTimeMillis());
            if (z7) {
                b(cVar);
                return;
            }
            return;
        }
        com.haier.uhome.search.a.c cVar2 = new com.haier.uhome.search.a.c();
        cVar2.a(bVar.a());
        cVar2.c(bVar.l());
        cVar2.e(bVar.m());
        cVar2.g(bVar.u());
        cVar2.g(bVar.v());
        cVar2.c(bVar.c());
        cVar2.d(bVar.f());
        cVar2.e(bVar.w());
        cVar2.f(bVar.x());
        cVar2.f(bVar.y());
        cVar2.a(true);
        cVar2.a(bVar.i());
        cVar2.a(System.currentTimeMillis());
        cVar2.i(bVar.t());
        this.f29945g.put(cVar2.a(), cVar2);
        a(cVar2);
    }

    public void d() {
        for (String str : new ArrayList(this.f29945g.keySet())) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "stopNativeService remove devId: " + str, new Object[0]);
            com.haier.uhome.search.b.f.a().b(str, ErrorConst.ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE.getErrorId());
        }
    }

    void a(ICallback<Void> iCallback) {
        e3.a.e("stopConfigScan", new Object[0]);
        f();
        this.f29944f.set(false);
        com.haier.uhome.usdk.base.utils.b.a(iCallback, (Object) null);
    }

    void a(com.haier.uhome.search.a.f fVar) {
        this.f29946h = fVar;
    }

    private void a(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.a.f fVar;
        if (!this.f29944f.get() || (fVar = this.f29946h) == null || cVar == null) {
            return;
        }
        fVar.onDeviceAdd(cVar);
    }

    private void a(com.haier.uhome.search.a.c cVar, int i7) {
        com.haier.uhome.search.a.f fVar;
        if (!this.f29944f.get() || (fVar = this.f29946h) == null || cVar == null) {
            return;
        }
        fVar.onDeviceDel(cVar, i7);
    }

    private void b(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.a.f fVar;
        if (!this.f29944f.get() || (fVar = this.f29946h) == null || cVar == null) {
            return;
        }
        fVar.onDeviceUpdate(cVar);
    }
}
