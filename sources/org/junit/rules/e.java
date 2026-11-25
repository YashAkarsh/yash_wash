package org.junit.rules;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements l {

    class a extends org.junit.runners.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.j f39926a;

        a(org.junit.runners.model.j jVar) throws Throwable {
            this.f39926a = jVar;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            e.this.c();
            try {
                this.f39926a.a();
            } finally {
                e.this.b();
            }
        }
    }

    private org.junit.runners.model.j d(org.junit.runners.model.j jVar) {
        return new a(jVar);
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        return d(jVar);
    }

    protected void b() {
    }

    protected void c() throws Throwable {
    }
}
