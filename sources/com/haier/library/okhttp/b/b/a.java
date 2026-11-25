package com.haier.library.okhttp.b.b;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.library.a.b0;
import com.haier.library.a.c0;
import com.haier.library.a.d0;
import com.haier.library.a.g;
import com.haier.library.a.h;
import com.haier.library.a.i;
import com.haier.library.a.t;
import com.haier.library.okhttp.g0;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.n;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final f f26933a;

    /* JADX INFO: renamed from: com.haier.library.okhttp.b.b.a$a, reason: collision with other inner class name */
    class C0355a implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f26934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f26935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f26936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f26937d;

        C0355a(i iVar, b bVar, h hVar) {
            this.f26935b = iVar;
            this.f26936c = bVar;
            this.f26937d = hVar;
        }

        @Override // com.haier.library.a.c0
        public long P0(g gVar, long j7) throws IOException {
            try {
                long jP0 = this.f26935b.P0(gVar, j7);
                if (jP0 != -1) {
                    gVar.h0(this.f26937d.c(), gVar.Y0() - jP0, jP0);
                    this.f26937d.P();
                    return jP0;
                }
                if (!this.f26934a) {
                    this.f26934a = true;
                    this.f26937d.close();
                }
                return -1L;
            } catch (IOException e8) {
                if (!this.f26934a) {
                    this.f26934a = true;
                    this.f26936c.a();
                }
                throw e8;
            }
        }

        @Override // com.haier.library.a.c0
        public d0 a() {
            return this.f26935b.a();
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f26934a && !n.d.w(this, 100, TimeUnit.MILLISECONDS)) {
                this.f26934a = true;
                this.f26936c.a();
            }
            this.f26935b.close();
        }
    }

    public a(f fVar) {
        this.f26933a = fVar;
    }

    private static com.haier.library.okhttp.a b(com.haier.library.okhttp.a aVar) {
        return (aVar == null || aVar.b() == null) ? aVar : aVar.l0().d(null).k();
    }

    private com.haier.library.okhttp.a c(b bVar, com.haier.library.okhttp.a aVar) throws IOException {
        b0 b0VarB;
        if (bVar == null || (b0VarB = bVar.b()) == null) {
            return aVar;
        }
        return aVar.l0().d(new com.haier.library.okhttp.b.e.h(aVar.E("Content-Type"), aVar.b().u(), t.b(new C0355a(aVar.b().K(), bVar, t.a(b0VarB))))).k();
    }

    private static g0 d(g0 g0Var, g0 g0Var2) {
        g0.a aVar = new g0.a();
        int iA = g0Var.a();
        for (int i7 = 0; i7 < iA; i7++) {
            String strD = g0Var.d(i7);
            String strH = g0Var.h(i7);
            if ((!com.google.common.net.c.f22144g.equalsIgnoreCase(strD) || !strH.startsWith("1")) && (f(strD) || !e(strD) || g0Var2.e(strD) == null)) {
                n.b.f27684a.k(aVar, strD, strH);
            }
        }
        int iA2 = g0Var2.a();
        for (int i8 = 0; i8 < iA2; i8++) {
            String strD2 = g0Var2.d(i8);
            if (!f(strD2) && e(strD2)) {
                n.b.f27684a.k(aVar, strD2, g0Var2.h(i8));
            }
        }
        return aVar.e();
    }

    static boolean e(String str) {
        return (com.google.common.net.c.f22160o.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || com.google.common.net.c.f22161o0.equalsIgnoreCase(str) || com.google.common.net.c.F.equalsIgnoreCase(str) || com.google.common.net.c.K.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || com.google.common.net.c.f22183z0.equalsIgnoreCase(str) || com.google.common.net.c.L.equalsIgnoreCase(str)) ? false : true;
    }

    static boolean f(String str) {
        return com.google.common.net.c.f22134b.equalsIgnoreCase(str) || com.google.common.net.c.X.equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    @Override // com.haier.library.okhttp.i0
    public com.haier.library.okhttp.a a(i0.a aVar) throws IOException {
        f fVar = this.f26933a;
        com.haier.library.okhttp.a aVarA = fVar != null ? fVar.a(aVar.a()) : null;
        c cVarA = new c.a(System.currentTimeMillis(), aVar.a(), aVarA).a();
        com.haier.library.okhttp.f fVar2 = cVarA.f26939a;
        com.haier.library.okhttp.a aVar2 = cVarA.f26940b;
        f fVar3 = this.f26933a;
        if (fVar3 != null) {
            fVar3.e(cVarA);
        }
        if (aVarA != null && aVar2 == null) {
            n.d.s(aVarA.b());
        }
        if (fVar2 == null && aVar2 == null) {
            return new com.haier.library.okhttp.a.C0352a().f(aVar.a()).e(com.haier.library.okhttp.d.HTTP_1_1).a(w.g.f3135l).i("Unsatisfiable Request (only-if-cached)").d(n.d.f27688c).b(-1L).m(System.currentTimeMillis()).k();
        }
        if (fVar2 == null) {
            return aVar2.l0().n(b(aVar2)).k();
        }
        try {
            com.haier.library.okhttp.a aVarA2 = aVar.a(fVar2);
            if (aVarA2 == null && aVarA != null) {
                n.d.s(aVarA.b());
            }
            if (aVar2 != null) {
                if (aVarA2.u() == 304) {
                    com.haier.library.okhttp.a aVarK = aVar2.l0().h(d(aVar2.G(), aVarA2.G())).b(aVarA2.x0()).m(aVarA2.s0()).n(b(aVar2)).c(b(aVarA2)).k();
                    aVarA2.b().close();
                    this.f26933a.a();
                    this.f26933a.c(aVar2, aVarK);
                    return aVarK;
                }
                n.d.s(aVar2.b());
            }
            com.haier.library.okhttp.a aVarK2 = aVarA2.l0().n(b(aVar2)).c(b(aVarA2)).k();
            if (this.f26933a != null) {
                if (com.haier.library.okhttp.b.e.e.u(aVarK2) && c.a(aVarK2, fVar2)) {
                    return c(this.f26933a.b(aVarK2), aVarK2);
                }
                if (com.haier.library.okhttp.b.e.f.a(fVar2.d())) {
                    try {
                        this.f26933a.d(fVar2);
                    } catch (IOException unused) {
                    }
                }
            }
            return aVarK2;
        } catch (Throwable th) {
            if (aVarA != null) {
                n.d.s(aVarA.b());
            }
            throw th;
        }
    }
}
