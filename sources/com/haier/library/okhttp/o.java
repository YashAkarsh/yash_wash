package com.haier.library.okhttp;

import com.haier.uhome.account.api.Const;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Closeable, Flushable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f27727h = 201105;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f27728i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f27729j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f27730k = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.haier.library.okhttp.b.b.f f27731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.haier.library.okhttp.b.b.d f27732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f27733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f27734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f27736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f27737g;

    class a implements com.haier.library.okhttp.b.b.f {
        a() {
        }

        @Override // com.haier.library.okhttp.b.b.f
        public com.haier.library.okhttp.a a(f fVar) throws IOException {
            return o.this.c(fVar);
        }

        @Override // com.haier.library.okhttp.b.b.f
        public com.haier.library.okhttp.b.b.b b(com.haier.library.okhttp.a aVar) throws IOException {
            return o.this.e(aVar);
        }

        @Override // com.haier.library.okhttp.b.b.f
        public void c(com.haier.library.okhttp.a aVar, com.haier.library.okhttp.a aVar2) {
            o.this.r(aVar, aVar2);
        }

        @Override // com.haier.library.okhttp.b.b.f
        public void d(f fVar) throws IOException {
            o.this.E(fVar);
        }

        @Override // com.haier.library.okhttp.b.b.f
        public void e(com.haier.library.okhttp.b.b.c cVar) {
            o.this.s(cVar);
        }

        @Override // com.haier.library.okhttp.b.b.f
        public void a() {
            o.this.o0();
        }
    }

    class b implements Iterator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<com.haier.library.okhttp.b.b.d.f> f27739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        String f27740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f27741c;

        b() throws IOException {
            this.f27739a = o.this.f27732b.p0();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f27740b;
            this.f27740b = null;
            this.f27741c = true;
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f27740b != null) {
                return true;
            }
            this.f27741c = false;
            while (this.f27739a.hasNext()) {
                com.haier.library.okhttp.b.b.d.f next = this.f27739a.next();
                try {
                    this.f27740b = com.haier.library.a.t.b(next.b(0)).v();
                    next.close();
                    return true;
                } catch (IOException unused) {
                    next.close();
                } catch (Throwable th) {
                    next.close();
                    throw th;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f27741c) {
                throw new IllegalStateException("remove() before next()");
            }
            this.f27739a.remove();
        }
    }

    private final class c implements com.haier.library.okhttp.b.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.library.okhttp.b.b.d.C0356d f27743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.haier.library.a.b0 f27744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.haier.library.a.b0 f27745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27746d;

        class a extends com.haier.library.a.l {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ o f27748b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.haier.library.okhttp.b.b.d.C0356d f27749c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(com.haier.library.a.b0 b0Var, o oVar, com.haier.library.okhttp.b.b.d.C0356d c0356d) {
                super(b0Var);
                this.f27748b = oVar;
                this.f27749c = c0356d;
            }

            @Override // com.haier.library.a.l, com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (o.this) {
                    c cVar = c.this;
                    if (cVar.f27746d) {
                        return;
                    }
                    cVar.f27746d = true;
                    o.this.f27733c++;
                    super.close();
                    this.f27749c.d();
                }
            }
        }

        c(com.haier.library.okhttp.b.b.d.C0356d c0356d) {
            this.f27743a = c0356d;
            com.haier.library.a.b0 b0VarC = c0356d.c(1);
            this.f27744b = b0VarC;
            this.f27745c = new a(b0VarC, o.this, c0356d);
        }

        @Override // com.haier.library.okhttp.b.b.b
        public void a() {
            synchronized (o.this) {
                if (this.f27746d) {
                    return;
                }
                this.f27746d = true;
                o.this.f27734d++;
                n.d.s(this.f27744b);
                try {
                    this.f27743a.e();
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.haier.library.okhttp.b.b.b
        public com.haier.library.a.b0 b() {
            return this.f27745c;
        }
    }

    private static class d extends com.haier.library.okhttp.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.haier.library.okhttp.b.b.d.f f27751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.haier.library.a.i f27752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private final String f27753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private final String f27754e;

        class a extends com.haier.library.a.m {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.haier.library.okhttp.b.b.d.f f27755b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(com.haier.library.a.c0 c0Var, com.haier.library.okhttp.b.b.d.f fVar) {
                super(c0Var);
                this.f27755b = fVar;
            }

            @Override // com.haier.library.a.m, com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f27755b.close();
                super.close();
            }
        }

        d(com.haier.library.okhttp.b.b.d.f fVar, String str, String str2) {
            this.f27751b = fVar;
            this.f27753d = str;
            this.f27754e = str2;
            this.f27752c = com.haier.library.a.t.b(new a(fVar.b(1), fVar));
        }

        @Override // com.haier.library.okhttp.b
        public j0 C() {
            String str = this.f27753d;
            if (str != null) {
                return j0.d(str);
            }
            return null;
        }

        @Override // com.haier.library.okhttp.b
        public com.haier.library.a.i K() {
            return this.f27752c;
        }

        @Override // com.haier.library.okhttp.b
        public long u() {
            try {
                String str = this.f27754e;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
    }

    public o(File file, long j7) {
        this(file, j7, com.haier.library.okhttp.b.h.a.f27350a);
    }

    static int b(com.haier.library.a.i iVar) throws IOException {
        try {
            long jE1 = iVar.E1();
            String strV = iVar.v();
            if (jE1 >= 0 && jE1 <= 2147483647L && strV.isEmpty()) {
                return (int) jE1;
            }
            throw new IOException("expected an int but was \"" + jE1 + strV + "\"");
        } catch (NumberFormatException e8) {
            throw new IOException(e8.getMessage());
        }
    }

    public static String f(h0 h0Var) {
        return com.haier.library.a.j.i(h0Var.toString()).E().W();
    }

    private void u(@Nullable com.haier.library.okhttp.b.b.d.C0356d c0356d) {
        if (c0356d != null) {
            try {
                c0356d.e();
            } catch (IOException unused) {
            }
        }
    }

    public void C() throws IOException {
        this.f27732b.l0();
    }

    void E(f fVar) throws IOException {
        this.f27732b.F(f(fVar.a()));
    }

    public void F() throws IOException {
        this.f27732b.o0();
    }

    public Iterator<String> G() throws IOException {
        return new b();
    }

    public synchronized int H() {
        return this.f27734d;
    }

    public synchronized int K() {
        return this.f27733c;
    }

    public long Q() throws IOException {
        return this.f27732b.K();
    }

    @Nullable
    com.haier.library.okhttp.a c(f fVar) {
        try {
            com.haier.library.okhttp.b.b.d.f fVarC = this.f27732b.c(f(fVar.a()));
            if (fVarC == null) {
                return null;
            }
            try {
                e eVar = new e(fVarC.b(0));
                com.haier.library.okhttp.a aVarA = eVar.a(fVarC);
                if (eVar.f(fVar, aVarA)) {
                    return aVarA;
                }
                n.d.s(aVarA.b());
                return null;
            } catch (IOException unused) {
                n.d.s(fVarC);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27732b.close();
    }

    @Nullable
    com.haier.library.okhttp.b.b.b e(com.haier.library.okhttp.a aVar) {
        com.haier.library.okhttp.b.b.d.C0356d c0356dU;
        String strD = aVar.v0().d();
        if (com.haier.library.okhttp.b.e.f.a(aVar.v0().d())) {
            try {
                E(aVar.v0());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!strD.equals(Const.HTTP_REQUEST_TYPE_GET) || com.haier.library.okhttp.b.e.e.p(aVar)) {
            return null;
        }
        e eVar = new e(aVar);
        try {
            c0356dU = this.f27732b.u(f(aVar.v0().a()));
            if (c0356dU == null) {
                return null;
            }
            try {
                eVar.d(c0356dU);
                return new c(c0356dU);
            } catch (IOException unused2) {
                u(c0356dU);
                return null;
            }
        } catch (IOException unused3) {
            c0356dU = null;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f27732b.flush();
    }

    public long g0() {
        return this.f27732b.G();
    }

    public File h0() {
        return this.f27732b.E();
    }

    public synchronized int l() {
        return this.f27735e;
    }

    public boolean l0() {
        return this.f27732b.g();
    }

    synchronized void o0() {
        this.f27736f++;
    }

    public synchronized int p0() {
        return this.f27736f;
    }

    public void q() throws IOException {
        this.f27732b.q();
    }

    void r(com.haier.library.okhttp.a aVar, com.haier.library.okhttp.a aVar2) {
        com.haier.library.okhttp.b.b.d.C0356d c0356dQ;
        e eVar = new e(aVar2);
        try {
            c0356dQ = ((d) aVar.b()).f27751b.q();
            if (c0356dQ != null) {
                try {
                    eVar.d(c0356dQ);
                    c0356dQ.d();
                } catch (IOException unused) {
                    u(c0356dQ);
                }
            }
        } catch (IOException unused2) {
            c0356dQ = null;
        }
    }

    public synchronized int r0() {
        return this.f27737g;
    }

    synchronized void s(com.haier.library.okhttp.b.b.c cVar) {
        this.f27737g++;
        if (cVar.f26939a != null) {
            this.f27735e++;
        } else if (cVar.f26940b != null) {
            this.f27736f++;
        }
    }

    o(File file, long j7, com.haier.library.okhttp.b.h.a aVar) {
        this.f27731a = new a();
        this.f27732b = com.haier.library.okhttp.b.b.d.e(aVar, file, f27727h, 2, j7);
    }

    private static final class e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String f27757k = com.haier.library.okhttp.b.i.f.r().t() + "-Sent-Millis";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f27758l = com.haier.library.okhttp.b.i.f.r().t() + "-Received-Millis";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g0 f27760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f27761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.haier.library.okhttp.d f27762d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f27763e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f27764f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final g0 f27765g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private final f0 f27766h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f27767i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final long f27768j;

        e(com.haier.library.a.c0 c0Var) throws IOException {
            try {
                com.haier.library.a.i iVarB = com.haier.library.a.t.b(c0Var);
                this.f27759a = iVarB.v();
                this.f27761c = iVarB.v();
                g0.a aVar = new g0.a();
                int iB = o.b(iVarB);
                for (int i7 = 0; i7 < iB; i7++) {
                    aVar.b(iVarB.v());
                }
                this.f27760b = aVar.e();
                com.haier.library.okhttp.b.e.k kVarB = com.haier.library.okhttp.b.e.k.b(iVarB.v());
                this.f27762d = kVarB.f27091a;
                this.f27763e = kVarB.f27092b;
                this.f27764f = kVarB.f27093c;
                g0.a aVar2 = new g0.a();
                int iB2 = o.b(iVarB);
                for (int i8 = 0; i8 < iB2; i8++) {
                    aVar2.b(iVarB.v());
                }
                String str = f27757k;
                String strL = aVar2.l(str);
                String str2 = f27758l;
                String strL2 = aVar2.l(str2);
                aVar2.i(str);
                aVar2.i(str2);
                this.f27767i = strL != null ? Long.parseLong(strL) : 0L;
                this.f27768j = strL2 != null ? Long.parseLong(strL2) : 0L;
                this.f27765g = aVar2.e();
                if (e()) {
                    String strV = iVarB.v();
                    if (strV.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strV + "\"");
                    }
                    this.f27766h = f0.b(!iVarB.g() ? i.a(iVarB.v()) : i.SSL_3_0, u.a(iVarB.v()), b(iVarB), b(iVarB));
                } else {
                    this.f27766h = null;
                }
                c0Var.close();
            } catch (Throwable th) {
                c0Var.close();
                throw th;
            }
        }

        private List<Certificate> b(com.haier.library.a.i iVar) throws IOException {
            int iB = o.b(iVar);
            if (iB == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iB);
                for (int i7 = 0; i7 < iB; i7++) {
                    String strV = iVar.v();
                    com.haier.library.a.g gVar = new com.haier.library.a.g();
                    gVar.B(com.haier.library.a.j.B(strV));
                    arrayList.add(certificateFactory.generateCertificate(gVar.h()));
                }
                return arrayList;
            } catch (CertificateException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        private void c(com.haier.library.a.h hVar, List<Certificate> list) throws IOException {
            try {
                hVar.n(list.size()).y1(10);
                int size = list.size();
                for (int i7 = 0; i7 < size; i7++) {
                    hVar.b(com.haier.library.a.j.m(list.get(i7).getEncoded()).C()).y1(10);
                }
            } catch (CertificateEncodingException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        private boolean e() {
            return this.f27759a.startsWith("https://");
        }

        public com.haier.library.okhttp.a a(com.haier.library.okhttp.b.b.d.f fVar) {
            String strE = this.f27765g.e("Content-Type");
            String strE2 = this.f27765g.e(com.google.common.net.c.f22134b);
            return new com.haier.library.okhttp.a.C0352a().f(new f.a().h(this.f27759a).i(this.f27761c, null).d(this.f27760b).s()).e(this.f27762d).a(this.f27763e).i(this.f27764f).h(this.f27765g).d(new d(fVar, strE, strE2)).g(this.f27766h).b(this.f27767i).m(this.f27768j).k();
        }

        public void d(com.haier.library.okhttp.b.b.d.C0356d c0356d) throws IOException {
            com.haier.library.a.h hVarA = com.haier.library.a.t.a(c0356d.c(0));
            hVarA.b(this.f27759a).y1(10);
            hVarA.b(this.f27761c).y1(10);
            hVarA.n(this.f27760b.a()).y1(10);
            int iA = this.f27760b.a();
            for (int i7 = 0; i7 < iA; i7++) {
                hVarA.b(this.f27760b.d(i7)).b(": ").b(this.f27760b.h(i7)).y1(10);
            }
            hVarA.b(new com.haier.library.okhttp.b.e.k(this.f27762d, this.f27763e, this.f27764f).toString()).y1(10);
            hVarA.n(this.f27765g.a() + 2).y1(10);
            int iA2 = this.f27765g.a();
            for (int i8 = 0; i8 < iA2; i8++) {
                hVarA.b(this.f27765g.d(i8)).b(": ").b(this.f27765g.h(i8)).y1(10);
            }
            hVarA.b(f27757k).b(": ").n(this.f27767i).y1(10);
            hVarA.b(f27758l).b(": ").n(this.f27768j).y1(10);
            if (e()) {
                hVarA.y1(10);
                hVarA.b(this.f27766h.d().c()).y1(10);
                c(hVarA, this.f27766h.e());
                c(hVarA, this.f27766h.g());
                hVarA.b(this.f27766h.a().b()).y1(10);
            }
            hVarA.close();
        }

        public boolean f(f fVar, com.haier.library.okhttp.a aVar) {
            return this.f27759a.equals(fVar.a().toString()) && this.f27761c.equals(fVar.d()) && com.haier.library.okhttp.b.e.e.m(aVar, this.f27760b, fVar);
        }

        e(com.haier.library.okhttp.a aVar) {
            this.f27759a = aVar.v0().a().toString();
            this.f27760b = com.haier.library.okhttp.b.e.e.r(aVar);
            this.f27761c = aVar.v0().d();
            this.f27762d = aVar.r0();
            this.f27763e = aVar.u();
            this.f27764f = aVar.g0();
            this.f27765g = aVar.G();
            this.f27766h = aVar.C();
            this.f27767i = aVar.x0();
            this.f27768j = aVar.s0();
        }
    }
}
