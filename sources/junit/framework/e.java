package junit.framework;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements i, org.junit.runner.manipulation.b, org.junit.runner.manipulation.d, org.junit.runner.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f34354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.junit.runner.l f34355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f34356c;

    public e(Class<?> cls) {
        this(cls, f.e());
    }

    private boolean h(org.junit.runner.c cVar) {
        return cVar.k(org.junit.k.class) != null;
    }

    private org.junit.runner.c i(org.junit.runner.c cVar) {
        if (h(cVar)) {
            return org.junit.runner.c.f39958h;
        }
        org.junit.runner.c cVarB = cVar.b();
        Iterator<org.junit.runner.c> it = cVar.m().iterator();
        while (it.hasNext()) {
            org.junit.runner.c cVarI = i(it.next());
            if (!cVarI.r()) {
                cVarB.a(cVarI);
            }
        }
        return cVarB;
    }

    @Override // junit.framework.i
    public int a() {
        return this.f34355b.c();
    }

    @Override // org.junit.runner.b
    public org.junit.runner.c b() {
        return i(this.f34355b.b());
    }

    @Override // junit.framework.i
    public void c(m mVar) {
        this.f34355b.a(this.f34356c.g(mVar, this));
    }

    @Override // org.junit.runner.manipulation.b
    public void d(org.junit.runner.manipulation.a aVar) throws org.junit.runner.manipulation.c {
        aVar.a(this.f34355b);
    }

    @Override // org.junit.runner.manipulation.d
    public void e(org.junit.runner.manipulation.e eVar) {
        eVar.a(this.f34355b);
    }

    public Class<?> f() {
        return this.f34354a;
    }

    public List<i> g() {
        return this.f34356c.b(b());
    }

    public String toString() {
        return this.f34354a.getName();
    }

    public e(Class<?> cls, f fVar) {
        this.f34356c = fVar;
        this.f34354a = cls;
        this.f34355b = org.junit.runner.i.b(cls).h();
    }
}
