package com.haier.library.okhttp.b.e;

import com.haier.library.a.p;
import com.haier.library.a.t;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.j0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.y;
import com.haier.library.okhttp.z;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f27057a;

    public a(z zVar) {
        this.f27057a = zVar;
    }

    private String b(List<y> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (i7 > 0) {
                sb.append("; ");
            }
            y yVar = list.get(i7);
            sb.append(yVar.f());
            sb.append('=');
            sb.append(yVar.k());
        }
        return sb.toString();
    }

    @Override // com.haier.library.okhttp.i0
    public com.haier.library.okhttp.a a(i0.a aVar) throws IOException {
        com.haier.library.okhttp.f fVarA = aVar.a();
        com.haier.library.okhttp.f.a aVarI = fVarA.i();
        com.haier.library.okhttp.g gVarG = fVarA.g();
        if (gVarG != null) {
            j0 j0VarG = gVarG.g();
            if (j0VarG != null) {
                aVarI.j("Content-Type", j0VarG.toString());
            }
            long jH = gVarG.h();
            if (jH != -1) {
                aVarI.j(com.google.common.net.c.f22134b, Long.toString(jH));
                aVarI.n(com.google.common.net.c.f22183z0);
            } else {
                aVarI.j(com.google.common.net.c.f22183z0, "chunked");
                aVarI.n(com.google.common.net.c.f22134b);
            }
        }
        boolean z7 = false;
        if (fVarA.c(com.google.common.net.c.f22174v) == null) {
            aVarI.j(com.google.common.net.c.f22174v, n.d.h(fVarA.a(), false));
        }
        if (fVarA.c(com.google.common.net.c.f22160o) == null) {
            aVarI.j(com.google.common.net.c.f22160o, "Keep-Alive");
        }
        if (fVarA.c(com.google.common.net.c.f22150j) == null && fVarA.c(com.google.common.net.c.G) == null) {
            aVarI.j(com.google.common.net.c.f22150j, "gzip");
            z7 = true;
        }
        List<y> listB = this.f27057a.b(fVarA.a());
        if (!listB.isEmpty()) {
            aVarI.j(com.google.common.net.c.f22162p, b(listB));
        }
        if (fVarA.c(com.google.common.net.c.M) == null) {
            aVarI.j(com.google.common.net.c.M, com.haier.library.okhttp.j.a());
        }
        com.haier.library.okhttp.a aVarA = aVar.a(aVarI.s());
        e.j(this.f27057a, fVarA.a(), aVarA.G());
        com.haier.library.okhttp.a.C0352a c0352aF = aVarA.l0().f(fVarA);
        if (z7 && "gzip".equalsIgnoreCase(aVarA.E(com.google.common.net.c.X)) && e.u(aVarA)) {
            p pVar = new p(aVarA.b().K());
            c0352aF.h(aVarA.G().m().i(com.google.common.net.c.X).i(com.google.common.net.c.f22134b).e());
            c0352aF.d(new h(aVarA.E("Content-Type"), -1L, t.b(pVar)));
        }
        return c0352aF.k();
    }
}
