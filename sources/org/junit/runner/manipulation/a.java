package org.junit.runner.manipulation;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39987a = new C0540a();

    /* JADX INFO: renamed from: org.junit.runner.manipulation.a$a, reason: collision with other inner class name */
    static class C0540a extends a {
        C0540a() {
        }

        @Override // org.junit.runner.manipulation.a
        public void a(Object obj) throws org.junit.runner.manipulation.c {
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return "all tests";
        }

        @Override // org.junit.runner.manipulation.a
        public a c(a aVar) {
            return aVar;
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(org.junit.runner.c cVar) {
            return true;
        }
    }

    static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.c f39988b;

        b(org.junit.runner.c cVar) {
            this.f39988b = cVar;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return String.format("Method %s", this.f39988b.o());
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(org.junit.runner.c cVar) {
            if (cVar.u()) {
                return this.f39988b.equals(cVar);
            }
            Iterator<org.junit.runner.c> it = cVar.m().iterator();
            while (it.hasNext()) {
                if (e(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f39989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f39990c;

        c(a aVar, a aVar2) {
            this.f39989b = aVar;
            this.f39990c = aVar2;
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return this.f39989b.b() + " and " + this.f39990c.b();
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(org.junit.runner.c cVar) {
            return this.f39989b.e(cVar) && this.f39990c.e(cVar);
        }
    }

    public static a d(org.junit.runner.c cVar) {
        return new b(cVar);
    }

    public void a(Object obj) throws org.junit.runner.manipulation.c {
        if (obj instanceof org.junit.runner.manipulation.b) {
            ((org.junit.runner.manipulation.b) obj).d(this);
        }
    }

    public abstract String b();

    public a c(a aVar) {
        return (aVar == this || aVar == f39987a) ? this : new c(this, aVar);
    }

    public abstract boolean e(org.junit.runner.c cVar);
}
