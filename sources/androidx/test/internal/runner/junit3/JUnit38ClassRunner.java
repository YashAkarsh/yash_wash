package androidx.test.internal.runner.junit3;

import java.lang.annotation.Annotation;
import junit.framework.i;
import junit.framework.j;
import junit.framework.m;
import junit.framework.n;
import org.junit.runner.l;
import org.junit.runner.manipulation.b;
import org.junit.runner.manipulation.d;
import org.junit.runner.manipulation.e;
import org.junit.runner.notification.a;
import org.junit.runner.notification.c;

/* JADX INFO: loaded from: classes.dex */
public class JUnit38ClassRunner extends l implements b, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile i f10128a;

    private static final class OldTestClassAdaptingListener implements junit.framework.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f10129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f10130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private org.junit.runner.c f10131c;

        private org.junit.runner.c e(i test) {
            org.junit.runner.c cVar;
            i iVar = this.f10130b;
            if (iVar != null && iVar.equals(test) && (cVar = this.f10131c) != null) {
                return cVar;
            }
            this.f10130b = test;
            if (test instanceof org.junit.runner.b) {
                this.f10131c = ((org.junit.runner.b) test).b();
            } else if (test instanceof j) {
                this.f10131c = JUnit38ClassRunner.j(test);
            } else {
                this.f10131c = org.junit.runner.c.f(f(test), test.toString());
            }
            return this.f10131c;
        }

        private Class<? extends i> f(i test) {
            return test.getClass();
        }

        @Override // junit.framework.l
        public void a(i test, Throwable t7) {
            this.f10129a.f(new a(e(test), t7));
        }

        @Override // junit.framework.l
        public void b(i test, junit.framework.b t7) {
            a(test, t7);
        }

        @Override // junit.framework.l
        public void c(i test) {
            this.f10129a.h(e(test));
        }

        @Override // junit.framework.l
        public void d(i test) {
            this.f10129a.l(e(test));
        }

        private OldTestClassAdaptingListener(c notifier) {
            this.f10130b = null;
            this.f10131c = null;
            this.f10129a = notifier;
        }
    }

    public JUnit38ClassRunner(Class<?> klass) {
        this(new n(klass.asSubclass(j.class)));
    }

    private static String g(n ts) {
        int iA = ts.a();
        return String.format("TestSuite with %s tests%s", Integer.valueOf(iA), iA == 0 ? "" : String.format(" [example: %s]", ts.p(0)));
    }

    private static Annotation[] h(j test) {
        try {
            return test.getClass().getMethod(test.P(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private i i() {
        return this.f10128a;
    }

    static org.junit.runner.c j(i test) {
        if (test instanceof j) {
            j jVar = (j) test;
            return org.junit.runner.c.g(jVar.getClass(), jVar.P(), h(jVar));
        }
        if (!(test instanceof n)) {
            if (test instanceof org.junit.runner.b) {
                return ((org.junit.runner.b) test).b();
            }
            return test instanceof junit.extensions.c ? j(((junit.extensions.c) test).P()) : org.junit.runner.c.c(test.getClass());
        }
        n nVar = (n) test;
        org.junit.runner.c cVarE = org.junit.runner.c.e(nVar.j() == null ? g(nVar) : nVar.j(), new Annotation[0]);
        int iR = nVar.r();
        for (int i7 = 0; i7 < iR; i7++) {
            cVarE.a(j(nVar.p(i7)));
        }
        return cVarE;
    }

    private void k(i test) {
        this.f10128a = test;
    }

    @Override // org.junit.runner.l
    public void a(c notifier) {
        m mVar = new m();
        mVar.c(f(notifier));
        i().c(mVar);
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        return j(i());
    }

    @Override // org.junit.runner.manipulation.b
    public void d(org.junit.runner.manipulation.a filter) throws org.junit.runner.manipulation.c {
        if (i() instanceof b) {
            ((b) i()).d(filter);
            return;
        }
        if (i() instanceof n) {
            n nVar = (n) i();
            n nVar2 = new n(nVar.j());
            int iR = nVar.r();
            for (int i7 = 0; i7 < iR; i7++) {
                i iVarP = nVar.p(i7);
                if (filter.e(j(iVarP))) {
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
    public void e(e sorter) {
        if (i() instanceof d) {
            ((d) i()).e(sorter);
        }
    }

    public junit.framework.l f(final c notifier) {
        return new OldTestClassAdaptingListener(notifier);
    }

    public JUnit38ClassRunner(i test) {
        k(test);
    }
}
