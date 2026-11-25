package com.haier.library.okhttp.b.g;

import com.haier.library.a.b0;
import com.haier.library.a.c0;
import com.haier.library.a.d0;
import com.haier.library.a.t;
import com.haier.library.okhttp.g0;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.l0;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements com.haier.library.okhttp.b.e.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f27205h = "host";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i0.a f27214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.haier.library.okhttp.b.d.g f27215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f27216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f27217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.haier.library.okhttp.d f27218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f27204g = "connection";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f27206i = "keep-alive";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f27207j = "proxy-connection";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f27209l = "te";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f27208k = "transfer-encoding";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f27210m = "encoding";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f27211n = "upgrade";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final List<String> f27212o = com.haier.library.okhttp.n.d.n(f27204g, "host", f27206i, f27207j, f27209l, f27208k, f27210m, f27211n, ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final List<String> f27213p = com.haier.library.okhttp.n.d.n(f27204g, "host", f27206i, f27207j, f27209l, f27208k, f27210m, f27211n);

    class a extends com.haier.library.a.m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f27219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f27220c;

        a(c0 c0Var) {
            super(c0Var);
            this.f27219b = false;
            this.f27220c = 0L;
        }

        private void c(IOException iOException) {
            if (this.f27219b) {
                return;
            }
            this.f27219b = true;
            f fVar = f.this;
            fVar.f27215c.i(false, fVar, this.f27220c, iOException);
        }

        @Override // com.haier.library.a.m, com.haier.library.a.c0
        public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
            try {
                long jP0 = b().P0(gVar, j7);
                if (jP0 > 0) {
                    this.f27220c += jP0;
                }
                return jP0;
            } catch (IOException e8) {
                c(e8);
                throw e8;
            }
        }

        @Override // com.haier.library.a.m, com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            c(null);
        }
    }

    public f(l0 l0Var, i0.a aVar, com.haier.library.okhttp.b.d.g gVar, g gVar2) {
        this.f27214b = aVar;
        this.f27215c = gVar;
        this.f27216d = gVar2;
        List<com.haier.library.okhttp.d> listF = l0Var.F();
        com.haier.library.okhttp.d dVar = com.haier.library.okhttp.d.H2_PRIOR_KNOWLEDGE;
        this.f27218f = listF.contains(dVar) ? dVar : com.haier.library.okhttp.d.HTTP_2;
    }

    public static com.haier.library.okhttp.a.C0352a d(g0 g0Var, com.haier.library.okhttp.d dVar) throws IOException {
        g0.a aVar = new g0.a();
        int iA = g0Var.a();
        com.haier.library.okhttp.b.e.k kVarB = null;
        for (int i7 = 0; i7 < iA; i7++) {
            String strD = g0Var.d(i7);
            String strH = g0Var.h(i7);
            if (strD.equals(":status")) {
                kVarB = com.haier.library.okhttp.b.e.k.b("HTTP/1.1 " + strH);
            } else if (!f27213p.contains(strD)) {
                com.haier.library.okhttp.n.b.f27684a.k(aVar, strD, strH);
            }
        }
        if (kVarB != null) {
            return new com.haier.library.okhttp.a.C0352a().e(dVar).a(kVarB.f27092b).i(kVarB.f27093c).h(aVar.e());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<c> e(com.haier.library.okhttp.f fVar) {
        g0 g0VarF = fVar.f();
        ArrayList arrayList = new ArrayList(g0VarF.a() + 4);
        arrayList.add(new c(c.f27148k, fVar.d()));
        arrayList.add(new c(c.f27149l, com.haier.library.okhttp.b.e.i.b(fVar.a())));
        String strC = fVar.c(com.google.common.net.c.f22174v);
        if (strC != null) {
            arrayList.add(new c(c.f27151n, strC));
        }
        arrayList.add(new c(c.f27150m, fVar.a().t()));
        int iA = g0VarF.a();
        for (int i7 = 0; i7 < iA; i7++) {
            com.haier.library.a.j jVarI = com.haier.library.a.j.i(g0VarF.d(i7).toLowerCase(Locale.US));
            if (!f27212o.contains(jVarI.o())) {
                arrayList.add(new c(jVarI, g0VarF.h(i7)));
            }
        }
        return arrayList;
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void a(com.haier.library.okhttp.f fVar) throws IOException {
        if (this.f27217e != null) {
            return;
        }
        i iVarF = this.f27216d.f(e(fVar), fVar.g() != null);
        this.f27217e = iVarF;
        d0 d0VarR = iVarF.r();
        long jK = this.f27214b.K();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        d0VarR.b(jK, timeUnit);
        this.f27217e.s().b(this.f27214b.f(), timeUnit);
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void b() throws IOException {
        this.f27217e.u().close();
    }

    @Override // com.haier.library.okhttp.b.e.c
    public b0 c(com.haier.library.okhttp.f fVar, long j7) {
        return this.f27217e.u();
    }

    @Override // com.haier.library.okhttp.b.e.c
    public com.haier.library.okhttp.b b(com.haier.library.okhttp.a aVar) throws IOException {
        com.haier.library.okhttp.b.d.g gVar = this.f27215c;
        gVar.f27047f.t(gVar.f27046e);
        return new com.haier.library.okhttp.b.e.h(aVar.E("Content-Type"), com.haier.library.okhttp.b.e.e.d(aVar), t.b(new a(this.f27217e.t())));
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void c() {
        i iVar = this.f27217e;
        if (iVar != null) {
            iVar.j(b.CANCEL);
        }
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void a() throws IOException {
        this.f27216d.J0();
    }

    @Override // com.haier.library.okhttp.b.e.c
    public com.haier.library.okhttp.a.C0352a a(boolean z7) throws IOException {
        com.haier.library.okhttp.a.C0352a c0352aD = d(this.f27217e.p(), this.f27218f);
        if (z7 && com.haier.library.okhttp.n.b.f27684a.a(c0352aD) == 100) {
            return null;
        }
        return c0352aD;
    }
}
