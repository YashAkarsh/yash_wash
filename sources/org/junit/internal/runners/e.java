package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import junit.framework.m;
import junit.framework.n;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class e extends l implements org.junit.runner.manipulation.b, org.junit.runner.manipulation.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile junit.framework.i f39858a;

    private static final class b implements junit.framework.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.junit.runner.notification.c f39859a;

        private org.junit.runner.c e(junit.framework.i iVar) {
            return iVar instanceof org.junit.runner.b ? ((org.junit.runner.b) iVar).b() : org.junit.runner.c.f(f(iVar), g(iVar));
        }

        private Class<? extends junit.framework.i> f(junit.framework.i iVar) {
            return iVar.getClass();
        }

        private String g(junit.framework.i iVar) {
            return iVar instanceof junit.framework.j ? ((junit.framework.j) iVar).P() : iVar.toString();
        }

        @Override // junit.framework.l
        public void a(junit.framework.i iVar, Throwable th) {
            this.f39859a.f(new org.junit.runner.notification.a(e(iVar), th));
        }

        @Override // junit.framework.l
        public void b(junit.framework.i iVar, junit.framework.b bVar) {
            a(iVar, bVar);
        }

        @Override // junit.framework.l
        public void c(junit.framework.i iVar) {
            this.f39859a.h(e(iVar));
        }

        @Override // junit.framework.l
        public void d(junit.framework.i iVar) {
            this.f39859a.l(e(iVar));
        }

        private b(org.junit.runner.notification.c cVar) {
            this.f39859a = cVar;
        }
    }

    public e(Class<?> cls) {
        this(new n(cls.asSubclass(junit.framework.j.class)));
    }

    private static String g(n nVar) {
        int iA = nVar.a();
        return String.format("TestSuite with %s tests%s", Integer.valueOf(iA), iA == 0 ? "" : String.format(" [example: %s]", nVar.p(0)));
    }

    private static Annotation[] h(junit.framework.j jVar) {
        try {
            return jVar.getClass().getMethod(jVar.P(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private junit.framework.i i() {
        return this.f39858a;
    }

    private static org.junit.runner.c j(junit.framework.i iVar) {
        if (iVar instanceof junit.framework.j) {
            junit.framework.j jVar = (junit.framework.j) iVar;
            return org.junit.runner.c.g(jVar.getClass(), jVar.P(), h(jVar));
        }
        if (!(iVar instanceof n)) {
            if (iVar instanceof org.junit.runner.b) {
                return ((org.junit.runner.b) iVar).b();
            }
            return iVar instanceof junit.extensions.c ? j(((junit.extensions.c) iVar).P()) : org.junit.runner.c.c(iVar.getClass());
        }
        n nVar = (n) iVar;
        org.junit.runner.c cVarE = org.junit.runner.c.e(nVar.j() == null ? g(nVar) : nVar.j(), new Annotation[0]);
        int iR = nVar.r();
        for (int i7 = 0; i7 < iR; i7++) {
            cVarE.a(j(nVar.p(i7)));
        }
        return cVarE;
    }

    private void k(junit.framework.i iVar) {
        this.f39858a = iVar;
    }

    @Override // org.junit.runner.l
    public void a(org.junit.runner.notification.c cVar) {
        m mVar = new m();
        mVar.c(f(cVar));
        i().c(mVar);
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        return j(i());
    }

    @Override // org.junit.runner.manipulation.b
    public void d(org.junit.runner.manipulation.a aVar) throws org.junit.runner.manipulation.c {
        if (i() instanceof org.junit.runner.manipulation.b) {
            ((org.junit.runner.manipulation.b) i()).d(aVar);
            return;
        }
        if (i() instanceof n) {
            n nVar = (n) i();
            n nVar2 = new n(nVar.j());
            int iR = nVar.r();
            for (int i7 = 0; i7 < iR; i7++) {
                junit.framework.i iVarP = nVar.p(i7);
                if (aVar.e(j(iVarP))) {
                    nVar2.b(iVarP);
                }
            }
            k(nVar2);
            if (nVar2.r() == 0) {
                throw new org.junit.runner.manipulation.c();
            }
        }
    }

    @Override // org.junit.runner.manipulation.d
    public void e(org.junit.runner.manipulation.e eVar) {
        if (i() instanceof org.junit.runner.manipulation.d) {
            ((org.junit.runner.manipulation.d) i()).e(eVar);
        }
    }

    public junit.framework.l f(org.junit.runner.notification.c cVar) {
        return new b(cVar);
    }

    public e(junit.framework.i iVar) {
        k(iVar);
    }
}
