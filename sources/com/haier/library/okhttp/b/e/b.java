package com.haier.library.okhttp.b.e;

import com.haier.library.a.b0;
import com.haier.library.a.t;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.n;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27058a;

    static final class a extends com.haier.library.a.l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f27059b;

        a(b0 b0Var) {
            super(b0Var);
        }

        @Override // com.haier.library.a.l, com.haier.library.a.b0
        public void I1(com.haier.library.a.g gVar, long j7) throws IOException {
            super.I1(gVar, j7);
            this.f27059b += j7;
        }
    }

    public b(boolean z7) {
        this.f27058a = z7;
    }

    @Override // com.haier.library.okhttp.i0
    public com.haier.library.okhttp.a a(i0.a aVar) throws IOException {
        g gVar = (g) aVar;
        c cVarH = gVar.h();
        com.haier.library.okhttp.b.d.g gVarG = gVar.g();
        com.haier.library.okhttp.b.d.c cVar = (com.haier.library.okhttp.b.d.c) gVar.b();
        com.haier.library.okhttp.f fVarA = gVar.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gVar.i().q(gVar.c());
        cVarH.a(fVarA);
        gVar.i().e(gVar.c(), fVarA);
        com.haier.library.okhttp.a.C0352a c0352aA = null;
        if (f.c(fVarA.d()) && fVarA.g() != null) {
            if ("100-continue".equalsIgnoreCase(fVarA.c(com.google.common.net.c.f22166r))) {
                cVarH.a();
                gVar.i().s(gVar.c());
                c0352aA = cVarH.a(true);
            }
            if (c0352aA == null) {
                gVar.i().r(gVar.c());
                a aVar2 = new a(cVarH.c(fVarA, fVarA.g().h()));
                com.haier.library.a.h hVarA = t.a(aVar2);
                fVarA.g().f(hVarA);
                hVarA.close();
                gVar.i().c(gVar.c(), aVar2.f27059b);
            } else if (!cVar.q()) {
                gVarG.n();
            }
        }
        cVarH.b();
        if (c0352aA == null) {
            gVar.i().s(gVar.c());
            c0352aA = cVarH.a(false);
        }
        com.haier.library.okhttp.a aVarK = c0352aA.f(fVarA).g(gVarG.l().c()).b(jCurrentTimeMillis).m(System.currentTimeMillis()).k();
        int iU = aVarK.u();
        if (iU == 100) {
            aVarK = cVarH.a(false).f(fVarA).g(gVarG.l().c()).b(jCurrentTimeMillis).m(System.currentTimeMillis()).k();
            iU = aVarK.u();
        }
        gVar.i().d(gVar.c(), aVarK);
        com.haier.library.okhttp.a aVarK2 = (this.f27058a && iU == 101) ? aVarK.l0().d(n.d.f27688c).k() : aVarK.l0().d(cVarH.b(aVarK)).k();
        if ("close".equalsIgnoreCase(aVarK2.v0().c(com.google.common.net.c.f22160o)) || "close".equalsIgnoreCase(aVarK2.E(com.google.common.net.c.f22160o))) {
            gVarG.n();
        }
        if ((iU != 204 && iU != 205) || aVarK2.b().u() <= 0) {
            return aVarK2;
        }
        throw new ProtocolException("HTTP " + iU + " had non-zero Content-Length: " + aVarK2.b().u());
    }
}
