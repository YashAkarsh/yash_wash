package com.haier.uhome.search.service.a.a;

import com.haier.library.common.thread.m;
import com.haier.library.common.util.j;
import com.haier.library.common.util.s;
import com.haier.library.sumhttp.response.h;
import com.haier.library.sumhttp.response.i;
import com.haier.library.sumhttp.response.k;
import com.haier.uhome.search.a.c;
import com.haier.uhome.usdk.base.utils.f;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.haier.uhome.search.service.a.a<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29796a = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final j<String, i> f29797j = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.haier.uhome.search.service.entity.a f29798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f29799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile i f29800d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f29804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f29805i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f29802f = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f29803g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C0372a f29801e = new C0372a(this);

    /* JADX INFO: renamed from: com.haier.uhome.search.service.a.a.a$a, reason: collision with other inner class name */
    private static class C0372a implements m3.a<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f29806a = "D00003";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<a> f29807b;

        C0372a(a aVar) {
            this.f29807b = new WeakReference<>(aVar);
        }

        @Override // m3.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(h hVar) {
            a aVar = this.f29807b.get();
            if (aVar == null) {
                e3.a.v("Roll actuator: query product code from mac already release!", new Object[0]);
                return;
            }
            if (!aVar.f29802f.get()) {
                e3.a.v("Roll actuator(%s): query product code from mac latch stopped!", aVar.l());
                return;
            }
            aVar.f29805i = !com.haier.library.common.util.c.c(f29806a, hVar.a());
            if (hVar.c()) {
                e3.a.v("Roll actuator(%s): query product code from mac result data = %s", aVar.l(), hVar);
                aVar.b(hVar.g());
            } else {
                e3.a.u("Roll actuator(%s): query product code from mac failure code = %s", aVar.l(), hVar.a(), new Object[0]);
                aVar.i();
            }
        }

        @Override // m3.a
        public void onError(Exception exc) {
            a aVar = this.f29807b.get();
            if (aVar == null) {
                e3.a.v("Roll actuator: query product code from mac already release!", new Object[0]);
            } else if (aVar.f29802f.get()) {
                e3.a.d("Roll actuator(%s): query product code from mac error, e = %s!", aVar.l(), exc.getMessage(), new Object[0]);
                aVar.i();
            }
        }
    }

    private static class b implements m3.a<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<a> f29808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f29809b;

        b(String str, a aVar) {
            this.f29809b = str;
            this.f29808a = new WeakReference<>(aVar);
        }

        @Override // m3.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(k kVar) {
            a aVar = this.f29808a.get();
            if (aVar == null) {
                e3.a.v("Roll actuator: query product code from modelShortId already release!", new Object[0]);
                return;
            }
            if (!aVar.f29802f.get()) {
                e3.a.u("Roll actuator(%s): query product code from modelShortId = %s latch stopped!", aVar.l(), this.f29809b, new Object[0]);
                return;
            }
            e3.a.d("Roll actuator(%s): query product code from modelShortId = %s, result data = %s", aVar.l(), this.f29809b, kVar);
            aVar.f29804h = !kVar.c();
            i iVarF = kVar.f();
            if (!kVar.c() || iVarF == null || !com.haier.library.common.util.c.l(iVarF.c())) {
                aVar.h();
            } else {
                a.f29797j.put(aVar.f29799c.y(), iVarF);
                aVar.a(iVarF);
            }
        }

        @Override // m3.a
        public void onError(Exception exc) {
            a aVar = this.f29808a.get();
            if (aVar == null) {
                e3.a.v("Roll actuator: fetch product info is already release!", new Object[0]);
            } else if (aVar.f29802f.get()) {
                e3.a.d("Roll actuator(%s): fetch product info error, e = %s!", aVar.l(), exc.getMessage(), new Object[0]);
                aVar.h();
            }
        }
    }

    public a(c cVar, com.haier.uhome.search.service.entity.a aVar) {
        this.f29799c = cVar;
        this.f29798b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String strY = this.f29799c.y();
        boolean zJ = com.haier.library.common.util.c.j(strY);
        this.f29804h = zJ;
        if (zJ) {
            h();
        } else {
            if (this.f29805i) {
                return;
            }
            a(strY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a(this.f29801e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int iC = this.f29799c.c();
        if (1 == iC) {
            j();
        }
        if (this.f29804h && this.f29805i) {
            this.f29802f.set(false);
            e3.a.v("Roll actuator(%s): all query failure so return loop!", l());
            return;
        }
        e3.a.e("Roll actuator(%s): retry query again!", l());
        if (2 == iC) {
            m.execute(new Runnable() { // from class: com.haier.uhome.search.service.a.a.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29810a.g();
                }
            }, 5L);
        } else if (1 == iC) {
            m.execute(new Runnable() { // from class: com.haier.uhome.search.service.a.a.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29810a.g();
                }
            }, 5L);
        }
    }

    private void j() {
        if (this.f29803g.compareAndSet(false, true)) {
            a(com.haier.uhome.search.service.entity.a.ADD);
        }
    }

    private void k() {
        if (1 == this.f29799c.c()) {
            a(this.f29803g.get() ? com.haier.uhome.search.service.entity.a.UPDATE : com.haier.uhome.search.service.entity.a.ADD);
        } else {
            a(this.f29798b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(":");
        c cVar = this.f29799c;
        sb.append(cVar != null ? cVar.a() : "");
        return sb.toString();
    }

    @Override // com.haier.uhome.search.service.a.a
    public boolean c() {
        return this.f29802f.get();
    }

    @Override // com.haier.uhome.search.service.a.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public i d() {
        return this.f29800d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        i iVar = new i();
        iVar.h(str);
        this.f29802f.set(false);
        f29797j.put(this.f29799c.a(), iVar);
        this.f29800d = iVar;
        k();
    }

    @Override // com.haier.uhome.search.service.a.a
    public synchronized void a() {
        if (this.f29802f.get()) {
            e3.a.v("Roll actuator(%s): is already running!", l());
            return;
        }
        e3.a.e("Roll actuator(%s): actuator is created and start!", l());
        if (this.f29802f.compareAndSet(false, true)) {
            g();
        }
    }

    @Override // com.haier.uhome.search.service.a.a
    public synchronized void b() {
        this.f29802f.set(false);
        e3.a.e("Roll actuator(%s): actuator is stop!", l());
    }

    private void a(String str) {
        i iVar = f29797j.get(str);
        if (iVar == null) {
            a(str, new b(str, this));
        } else {
            e3.a.e("Roll actuator(%s): query product code from modelShortId catch cache, modelShortId = %s, productInfo = %s", Integer.valueOf(hashCode()), str, iVar);
            a(iVar);
        }
    }

    private void a(String str, m3.a<k> aVar) {
        e3.a.d("Roll actuator(%s): query product code from modelShortId, modelShortId = %s", l(), str, new Object[0]);
        com.haier.library.sumhttp.request.a.h().t(str, aVar);
    }

    private void a(m3.a<h> aVar) {
        String strA = this.f29799c.a();
        e3.a.d("Roll actuator(%s): query product code from mac, mac = %s", l(), strA, new Object[0]);
        i iVar = f29797j.get(strA);
        if (iVar == null) {
            com.haier.library.sumhttp.request.a.h().n(strA, aVar);
        } else {
            e3.a.d("Roll actuator(%s): query product code from mac catch cache, mac = %s, productInfo = %s", l(), strA, iVar);
            aVar.onSuccess(h.f(iVar.c()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.f29802f.set(false);
        this.f29800d = iVar;
        k();
    }

    private void a(com.haier.uhome.search.service.entity.a aVar) {
        f.a aVarA;
        if (this.f29800d != null) {
            this.f29799c.d(this.f29800d.c());
            if (this.f29799c.e() == null && com.haier.library.common.util.c.l(this.f29800d.d()) && (aVarA = f.a(this.f29800d.d())) != null) {
                this.f29799c.a(aVarA.a());
                this.f29799c.b(aVarA.b());
            }
        }
        com.haier.uhome.usdk.base.d.c.a().c(new com.haier.uhome.search.service.entity.f(aVar, this.f29799c));
    }
}
