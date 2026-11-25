package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.rules.h;
import org.junit.runner.l;
import org.junit.runners.model.i;
import org.junit.runners.model.j;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f<T> extends l implements org.junit.runner.manipulation.b, org.junit.runner.manipulation.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<org.junit.validator.e> f40029e = Arrays.asList(new org.junit.validator.c(), new org.junit.validator.d());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f40031b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f40030a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Collection<T> f40032c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile i f40033d = new a();

    class a implements i {
        a() {
        }

        @Override // org.junit.runners.model.i
        public void a(Runnable runnable) {
            runnable.run();
        }

        @Override // org.junit.runners.model.i
        public void b() {
        }
    }

    class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.notification.c f40035a;

        b(org.junit.runner.notification.c cVar) {
            this.f40035a = cVar;
        }

        @Override // org.junit.runners.model.j
        public void a() {
            f.this.w(this.f40035a);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f40037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.notification.c f40038b;

        c(Object obj, org.junit.runner.notification.c cVar) {
            this.f40037a = obj;
            this.f40038b = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            f.this.v(this.f40037a, this.f40038b);
        }
    }

    class d implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.manipulation.e f40040a;

        d(org.junit.runner.manipulation.e eVar) {
            this.f40040a = eVar;
        }

        @Override // java.util.Comparator
        public int compare(T t7, T t8) {
            return this.f40040a.compare(f.this.o(t7), f.this.o(t8));
        }
    }

    protected f(Class<?> cls) throws org.junit.runners.model.e {
        this.f40031b = n(cls);
        A();
    }

    private void A() throws org.junit.runners.model.e {
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (!arrayList.isEmpty()) {
            throw new org.junit.runners.model.e(arrayList);
        }
    }

    private void B(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f39882d.i(t(), list);
        org.junit.internal.runners.rules.a.f39884f.i(t(), list);
    }

    private j F(j jVar) {
        List<org.junit.rules.l> listK = k();
        return listK.isEmpty() ? jVar : new h(jVar, listK, b());
    }

    private void g(List<Throwable> list) {
        if (t().j() != null) {
            Iterator<org.junit.validator.e> it = f40029e.iterator();
            while (it.hasNext()) {
                list.addAll(it.next().a(t()));
            }
        }
    }

    private boolean h() {
        Iterator<T> it = q().iterator();
        while (it.hasNext()) {
            if (!u(it.next())) {
                return false;
            }
        }
        return true;
    }

    private Comparator<? super T> m(org.junit.runner.manipulation.e eVar) {
        return new d(eVar);
    }

    private Collection<T> q() {
        if (this.f40032c == null) {
            synchronized (this.f40030a) {
                if (this.f40032c == null) {
                    this.f40032c = Collections.unmodifiableCollection(p());
                }
            }
        }
        return this.f40032c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(org.junit.runner.notification.c cVar) {
        i iVar = this.f40033d;
        try {
            Iterator<T> it = q().iterator();
            while (it.hasNext()) {
                iVar.a(new c(it.next(), cVar));
            }
            iVar.b();
        } catch (Throwable th) {
            iVar.b();
            throw th;
        }
    }

    private boolean z(org.junit.runner.manipulation.a aVar, T t7) {
        return aVar.e(o(t7));
    }

    protected void C(Class<? extends Annotation> cls, boolean z7, List<Throwable> list) {
        Iterator<org.junit.runners.model.d> it = t().i(cls).iterator();
        while (it.hasNext()) {
            it.next().r(z7, list);
        }
    }

    protected j D(j jVar) {
        List<org.junit.runners.model.d> listI = this.f40031b.i(org.junit.b.class);
        return listI.isEmpty() ? jVar : new org.junit.internal.runners.statements.e(jVar, listI, null);
    }

    protected j E(j jVar) {
        List<org.junit.runners.model.d> listI = this.f40031b.i(org.junit.g.class);
        return listI.isEmpty() ? jVar : new org.junit.internal.runners.statements.f(jVar, listI, null);
    }

    @Override // org.junit.runner.l
    public void a(org.junit.runner.notification.c cVar) {
        org.junit.internal.runners.model.a aVar = new org.junit.internal.runners.model.a(cVar, b());
        try {
            j(cVar).a();
        } catch (org.junit.internal.b e8) {
            aVar.a(e8);
        } catch (org.junit.runner.notification.d e9) {
            throw e9;
        } catch (Throwable th) {
            aVar.b(th);
        }
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        org.junit.runner.c cVarE = org.junit.runner.c.e(r(), s());
        Iterator<T> it = q().iterator();
        while (it.hasNext()) {
            cVarE.a(o(it.next()));
        }
        return cVarE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.manipulation.b
    public void d(org.junit.runner.manipulation.a aVar) throws org.junit.runner.manipulation.c {
        synchronized (this.f40030a) {
            ArrayList arrayList = new ArrayList(q());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (z(aVar, next)) {
                    try {
                        aVar.a(next);
                    } catch (org.junit.runner.manipulation.c unused) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.f40032c = Collections.unmodifiableCollection(arrayList);
            if (this.f40032c.isEmpty()) {
                throw new org.junit.runner.manipulation.c();
            }
        }
    }

    @Override // org.junit.runner.manipulation.d
    public void e(org.junit.runner.manipulation.e eVar) {
        synchronized (this.f40030a) {
            Iterator<T> it = q().iterator();
            while (it.hasNext()) {
                eVar.a(it.next());
            }
            ArrayList arrayList = new ArrayList(q());
            Collections.sort(arrayList, m(eVar));
            this.f40032c = Collections.unmodifiableCollection(arrayList);
        }
    }

    protected j i(org.junit.runner.notification.c cVar) {
        return new b(cVar);
    }

    protected j j(org.junit.runner.notification.c cVar) {
        j jVarI = i(cVar);
        return !h() ? F(D(E(jVarI))) : jVarI;
    }

    protected List<org.junit.rules.l> k() {
        List<org.junit.rules.l> listG = this.f40031b.g(null, org.junit.h.class, org.junit.rules.l.class);
        listG.addAll(this.f40031b.c(null, org.junit.h.class, org.junit.rules.l.class));
        return listG;
    }

    protected void l(List<Throwable> list) {
        C(org.junit.g.class, true, list);
        C(org.junit.b.class, true, list);
        B(list);
        g(list);
    }

    protected k n(Class<?> cls) {
        return new k(cls);
    }

    protected abstract org.junit.runner.c o(T t7);

    protected abstract List<T> p();

    protected String r() {
        return this.f40031b.k();
    }

    protected Annotation[] s() {
        return this.f40031b.getAnnotations();
    }

    public final k t() {
        return this.f40031b;
    }

    protected boolean u(T t7) {
        return false;
    }

    protected abstract void v(T t7, org.junit.runner.notification.c cVar);

    protected final void x(j jVar, org.junit.runner.c cVar, org.junit.runner.notification.c cVar2) {
        org.junit.internal.runners.model.a aVar = new org.junit.internal.runners.model.a(cVar2, cVar);
        aVar.f();
        try {
            try {
                jVar.a();
            } catch (Throwable th) {
                aVar.d();
                throw th;
            }
        } catch (org.junit.internal.b e8) {
            aVar.a(e8);
        } catch (Throwable th2) {
            aVar.b(th2);
        }
        aVar.d();
    }

    public void y(i iVar) {
        this.f40033d = iVar;
    }
}
