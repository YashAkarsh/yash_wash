package com.haier.library.sumhttp.plugin;

import com.haier.library.okhttp.q;
import com.haier.library.okhttp.r;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f27938b = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.library.okhttp.api.e f27939a;

    class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f27940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f27941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.haier.library.sumhttp.plugin.a f27942c;

        a(b bVar, h hVar, com.haier.library.sumhttp.plugin.a aVar) {
            this.f27940a = bVar;
            this.f27941b = hVar;
            this.f27942c = aVar;
        }

        @Override // com.haier.library.okhttp.r
        public void a(q qVar, IOException iOException) {
            g.this.j(this.f27940a, h.f27944a, iOException.getMessage());
        }

        @Override // com.haier.library.okhttp.r
        public void b(q qVar, com.haier.library.okhttp.a aVar) {
            Object objA = this.f27941b.a(aVar);
            int iA = this.f27941b.a();
            if (iA == 200) {
                g.this.i(this.f27942c, objA);
            } else {
                g.this.j(this.f27940a, iA, this.f27941b.b());
            }
        }
    }

    public g(long j7) {
        this.f27939a = com.haier.library.okhttp.api.e.m(j7, TimeUnit.MILLISECONDS);
    }

    public static g d() {
        return new g(10000L);
    }

    public static g e(long j7) {
        return new g(j7);
    }

    public q c(com.haier.library.okhttp.f fVar) {
        return this.f27939a.j().a(fVar);
    }

    public <T> void f(com.haier.library.okhttp.f fVar, h<T> hVar) {
        try {
            e3.a.e(fVar.toString(), new Object[0]);
            com.haier.library.okhttp.a aVarB = this.f27939a.j().a(fVar).b();
            e3.a.e(aVarB.toString(), new Object[0]);
            hVar.a(aVarB);
        } catch (IOException e8) {
            e3.a.e("http response with:" + e8.getMessage(), new Object[0]);
            hVar.a(h.f27946c, e8.getMessage());
        }
    }

    public <T> void g(com.haier.library.okhttp.f fVar, h<T> hVar, com.haier.library.sumhttp.plugin.a<T> aVar, b bVar) {
        this.f27939a.j().a(fVar).p0(new a(bVar, hVar, aVar));
    }

    public <T> void h(q qVar, h<T> hVar) {
        try {
            com.haier.library.okhttp.a aVarB = qVar.b();
            e3.a.e(aVarB.toString(), new Object[0]);
            hVar.a(aVarB);
        } catch (IOException e8) {
            e3.a.e("http response with:" + e8.getMessage(), new Object[0]);
            hVar.a(h.f27946c, e8.getMessage());
        }
    }

    public <T> void i(final com.haier.library.sumhttp.plugin.a<T> aVar, final T t7) {
        if (aVar != null) {
            this.f27939a.k().post(new Runnable() { // from class: com.haier.library.sumhttp.plugin.e
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(t7);
                }
            });
        }
    }

    public void j(final b bVar, final int i7, final String str) {
        if (bVar != null) {
            this.f27939a.k().post(new Runnable() { // from class: com.haier.library.sumhttp.plugin.f
                @Override // java.lang.Runnable
                public final void run() {
                    bVar.a(i7, str);
                }
            });
        }
    }
}
