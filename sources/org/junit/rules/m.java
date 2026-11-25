package org.junit.rules;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m implements l {

    class a extends org.junit.runners.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.c f39938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.j f39939b;

        a(org.junit.runner.c cVar, org.junit.runners.model.j jVar) throws Exception {
            this.f39938a = cVar;
            this.f39939b = jVar;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Exception {
            ArrayList arrayList = new ArrayList();
            m.this.o(this.f39938a, arrayList);
            try {
                try {
                    this.f39939b.a();
                    m.this.q(this.f39938a, arrayList);
                } catch (Throwable th) {
                    m.this.j(this.f39938a, arrayList);
                    throw th;
                }
            } catch (org.junit.internal.b e8) {
                arrayList.add(e8);
                m.this.m(e8, this.f39938a, arrayList);
            } catch (Throwable th2) {
                arrayList.add(th2);
                m.this.h(th2, this.f39938a, arrayList);
            }
            m.this.j(this.f39938a, arrayList);
            org.junit.runners.model.f.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Throwable th, org.junit.runner.c cVar, List<Throwable> list) {
        try {
            g(th, cVar);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(org.junit.runner.c cVar, List<Throwable> list) {
        try {
            i(cVar);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(org.junit.internal.b bVar, org.junit.runner.c cVar, List<Throwable> list) {
        try {
            if (bVar instanceof org.junit.e) {
                k((org.junit.e) bVar, cVar);
            } else {
                l(bVar, cVar);
            }
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(org.junit.runner.c cVar, List<Throwable> list) {
        try {
            n(cVar);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(org.junit.runner.c cVar, List<Throwable> list) {
        try {
            p(cVar);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        return new a(cVar, jVar);
    }

    protected void g(Throwable th, org.junit.runner.c cVar) {
    }

    protected void i(org.junit.runner.c cVar) {
    }

    protected void k(org.junit.e eVar, org.junit.runner.c cVar) {
        l(eVar, cVar);
    }

    @Deprecated
    protected void l(org.junit.internal.b bVar, org.junit.runner.c cVar) {
    }

    protected void n(org.junit.runner.c cVar) {
    }

    protected void p(org.junit.runner.c cVar) {
    }
}
