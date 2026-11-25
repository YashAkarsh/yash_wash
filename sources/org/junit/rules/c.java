package org.junit.rules;

/* JADX INFO: loaded from: classes3.dex */
public class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f39921a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f39922b = "Expected test to throw %s";

    private class a extends org.junit.runners.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.junit.runners.model.j f39923a;

        public a(org.junit.runners.model.j jVar) {
            this.f39923a = jVar;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            try {
                this.f39923a.a();
                if (c.this.n()) {
                    c.this.j();
                }
            } catch (Throwable th) {
                c.this.m(th);
            }
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws AssertionError {
        org.junit.c.d0(o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Throwable th) throws Throwable {
        if (!n()) {
            throw th;
        }
        org.junit.c.W(th, this.f39921a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return this.f39921a.f();
    }

    private String o() {
        return String.format(this.f39922b, org.hamcrest.n.o(this.f39921a.c()));
    }

    public static c p() {
        return new c();
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        return new a(jVar);
    }

    public void e(Class<? extends Throwable> cls) {
        f(org.hamcrest.d.C(cls));
    }

    public void f(org.hamcrest.k<?> kVar) {
        this.f39921a.a(kVar);
    }

    public void g(org.hamcrest.k<? extends Throwable> kVar) {
        f(org.junit.internal.matchers.b.h(kVar));
    }

    public void h(String str) {
        i(org.hamcrest.d.s(str));
    }

    public void i(org.hamcrest.k<String> kVar) {
        f(org.junit.internal.matchers.c.h(kVar));
    }

    @Deprecated
    public c k() {
        return this;
    }

    @Deprecated
    public c l() {
        return this;
    }

    public c q(String str) {
        this.f39922b = str;
        return this;
    }
}
