package org.junit.runner;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.junit.runner.notification.c f39971a = new org.junit.runner.notification.c();

    static a b() {
        return new a();
    }

    public static void d(String... strArr) {
        System.exit(!new h().m(new org.junit.internal.i(), strArr).l() ? 1 : 0);
    }

    public static j k(a aVar, Class<?>... clsArr) {
        return new h().g(aVar, clsArr);
    }

    public static j l(Class<?>... clsArr) {
        return k(b(), clsArr);
    }

    public void a(org.junit.runner.notification.b bVar) {
        this.f39971a.d(bVar);
    }

    public String c() {
        return junit.runner.c.a();
    }

    public void e(org.junit.runner.notification.b bVar) {
        this.f39971a.n(bVar);
    }

    public j f(junit.framework.i iVar) {
        return i(new org.junit.internal.runners.e(iVar));
    }

    public j g(a aVar, Class<?>... clsArr) {
        return h(i.c(aVar, clsArr));
    }

    public j h(i iVar) {
        return i(iVar.h());
    }

    public j i(l lVar) {
        j jVar = new j();
        org.junit.runner.notification.b bVarF = jVar.f();
        this.f39971a.c(bVarF);
        try {
            this.f39971a.k(lVar.b());
            lVar.a(this.f39971a);
            this.f39971a.j(jVar);
            return jVar;
        } finally {
            e(bVarF);
        }
    }

    public j j(Class<?>... clsArr) {
        return g(b(), clsArr);
    }

    j m(org.junit.internal.g gVar, String... strArr) {
        gVar.a().println("JUnit version " + junit.runner.c.a());
        g gVarG = g.g(strArr);
        a(new org.junit.internal.j(gVar));
        return h(gVarG.c(b()));
    }
}
