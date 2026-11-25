package org.junit.rules;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class n implements f {

    class a extends org.junit.runners.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.d f39941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.j f39942b;

        a(org.junit.runners.model.d dVar, org.junit.runners.model.j jVar) throws Throwable {
            this.f39941a = dVar;
            this.f39942b = jVar;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            n.this.d(this.f39941a);
            try {
                try {
                    this.f39942b.a();
                    n.this.e(this.f39941a);
                    n.this.c(this.f39941a);
                } catch (Throwable th) {
                    n.this.c(this.f39941a);
                    throw th;
                }
            } catch (org.junit.internal.b e8) {
                throw e8;
            } catch (Throwable th2) {
                n.this.b(th2, this.f39941a);
                throw th2;
            }
        }
    }

    @Override // org.junit.rules.f
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runners.model.d dVar, Object obj) {
        return new a(dVar, jVar);
    }

    public void b(Throwable th, org.junit.runners.model.d dVar) {
    }

    public void c(org.junit.runners.model.d dVar) {
    }

    public void d(org.junit.runners.model.d dVar) {
    }

    public void e(org.junit.runners.model.d dVar) {
    }
}
