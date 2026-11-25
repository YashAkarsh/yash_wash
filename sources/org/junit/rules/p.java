package org.junit.rules;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p implements l {

    class a extends org.junit.runners.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.j f39952a;

        a(org.junit.runners.model.j jVar) throws Throwable {
            this.f39952a = jVar;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            this.f39952a.a();
            p.this.b();
        }
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        return new a(jVar);
    }

    protected void b() throws Throwable {
    }
}
