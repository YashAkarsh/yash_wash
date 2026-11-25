package org.junit.runners;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.junit.k;
import org.junit.m;
import org.junit.rules.h;
import org.junit.rules.l;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes3.dex */
public class b extends f<org.junit.runners.model.d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<org.junit.runners.model.d, org.junit.runner.c> f40019f;

    class a extends org.junit.internal.runners.model.c {
        a() throws Exception {
        }

        @Override // org.junit.internal.runners.model.c
        protected Object b() throws Throwable {
            return b.this.H();
        }
    }

    public b(Class<?> cls) throws org.junit.runners.model.e {
        super(cls);
        this.f40019f = new ConcurrentHashMap<>();
    }

    private boolean J(m mVar) {
        return K(mVar) != null;
    }

    private Class<? extends Throwable> K(m mVar) {
        if (mVar == null || mVar.expected() == m.a.class) {
            return null;
        }
        return mVar.expected();
    }

    private List<org.junit.rules.f> L(Object obj) {
        return T(obj);
    }

    private long N(m mVar) {
        if (mVar == null) {
            return 0L;
        }
        return mVar.timeout();
    }

    private boolean O() {
        return t().j().getConstructors().length == 1;
    }

    private void Z(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f39885g.i(t(), list);
    }

    private j g0(org.junit.runners.model.d dVar, List<l> list, Object obj, j jVar) {
        for (org.junit.rules.f fVar : L(obj)) {
            if (!list.contains(fVar)) {
                jVar = fVar.a(jVar, dVar, obj);
            }
        }
        return jVar;
    }

    private j i0(org.junit.runners.model.d dVar, Object obj, j jVar) {
        List<l> listM = M(obj);
        return j0(dVar, listM, g0(dVar, listM, obj, jVar));
    }

    private j j0(org.junit.runners.model.d dVar, List<l> list, j jVar) {
        return list.isEmpty() ? jVar : new h(jVar, list, o(dVar));
    }

    protected List<org.junit.runners.model.d> G() {
        return t().i(m.class);
    }

    protected Object H() throws Exception {
        return t().l().newInstance(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.f
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public org.junit.runner.c o(org.junit.runners.model.d dVar) {
        org.junit.runner.c cVar = this.f40019f.get(dVar);
        if (cVar != null) {
            return cVar;
        }
        org.junit.runner.c cVarG = org.junit.runner.c.g(t().j(), V(dVar), dVar.getAnnotations());
        this.f40019f.putIfAbsent(dVar, cVarG);
        return cVarG;
    }

    protected List<l> M(Object obj) {
        List<l> listG = t().g(obj, org.junit.l.class, l.class);
        listG.addAll(t().c(obj, org.junit.l.class, l.class));
        return listG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.f
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public boolean u(org.junit.runners.model.d dVar) {
        return dVar.getAnnotation(k.class) != null;
    }

    protected j Q(org.junit.runners.model.d dVar) {
        try {
            Object objA = new a().a();
            return i0(dVar, objA, e0(dVar, objA, f0(dVar, objA, h0(dVar, objA, S(dVar, objA, R(dVar, objA))))));
        } catch (Throwable th) {
            return new org.junit.internal.runners.statements.b(th);
        }
    }

    protected j R(org.junit.runners.model.d dVar, Object obj) {
        return new org.junit.internal.runners.statements.d(dVar, obj);
    }

    protected j S(org.junit.runners.model.d dVar, Object obj, j jVar) {
        m mVar = (m) dVar.getAnnotation(m.class);
        return J(mVar) ? new org.junit.internal.runners.statements.a(jVar, K(mVar)) : jVar;
    }

    protected List<org.junit.rules.f> T(Object obj) {
        List<org.junit.rules.f> listG = t().g(obj, org.junit.l.class, org.junit.rules.f.class);
        listG.addAll(t().c(obj, org.junit.l.class, org.junit.rules.f.class));
        return listG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.f
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void v(org.junit.runners.model.d dVar, org.junit.runner.notification.c cVar) {
        org.junit.runner.c cVarO = o(dVar);
        if (u(dVar)) {
            cVar.i(cVarO);
        } else {
            x(Q(dVar), cVarO, cVar);
        }
    }

    protected String V(org.junit.runners.model.d dVar) {
        return dVar.c();
    }

    protected void W(List<Throwable> list) {
        b0(list);
        d0(list);
    }

    protected void X(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f39883e.i(t(), list);
    }

    @Deprecated
    protected void Y(List<Throwable> list) {
        C(org.junit.a.class, false, list);
        C(org.junit.f.class, false, list);
        c0(list);
        if (G().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    protected void a0(List<Throwable> list) {
        if (t().o()) {
            list.add(new Exception("The inner class " + t().k() + " is not static."));
        }
    }

    protected void b0(List<Throwable> list) {
        if (O()) {
            return;
        }
        list.add(new Exception("Test class should have exactly one public constructor"));
    }

    protected void c0(List<Throwable> list) {
        C(m.class, false, list);
    }

    protected void d0(List<Throwable> list) {
        if (t().o() || !O() || t().l().getParameterTypes().length == 0) {
            return;
        }
        list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
    }

    protected j e0(org.junit.runners.model.d dVar, Object obj, j jVar) {
        List<org.junit.runners.model.d> listI = t().i(org.junit.a.class);
        return listI.isEmpty() ? jVar : new org.junit.internal.runners.statements.e(jVar, listI, obj);
    }

    protected j f0(org.junit.runners.model.d dVar, Object obj, j jVar) {
        List<org.junit.runners.model.d> listI = t().i(org.junit.f.class);
        return listI.isEmpty() ? jVar : new org.junit.internal.runners.statements.f(jVar, listI, obj);
    }

    @Deprecated
    protected j h0(org.junit.runners.model.d dVar, Object obj, j jVar) {
        long jN = N((m) dVar.getAnnotation(m.class));
        return jN <= 0 ? jVar : org.junit.internal.runners.statements.c.c().f(jN, TimeUnit.MILLISECONDS).d(jVar);
    }

    @Override // org.junit.runners.f
    protected void l(List<Throwable> list) {
        super.l(list);
        a0(list);
        W(list);
        Y(list);
        X(list);
        Z(list);
    }

    @Override // org.junit.runners.f
    protected List<org.junit.runners.model.d> p() {
        return G();
    }
}
