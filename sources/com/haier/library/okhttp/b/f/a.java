package com.haier.library.okhttp.b.f;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.util.j;
import com.haier.library.a.b0;
import com.haier.library.a.c0;
import com.haier.library.a.d0;
import com.haier.library.a.h;
import com.haier.library.a.i;
import com.haier.library.a.n;
import com.haier.library.a.t;
import com.haier.library.okhttp.b.e.k;
import com.haier.library.okhttp.g0;
import com.haier.library.okhttp.h0;
import com.haier.library.okhttp.l0;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.haier.library.okhttp.b.e.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f27094h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f27095i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f27096j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f27097k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f27098l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f27099m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f27100n = 6;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f27101o = 262144;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final l0 f27102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.haier.library.okhttp.b.d.g f27103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final i f27104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h f27105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f27106f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f27107g = PlaybackStateCompat.E;

    private abstract class b implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final n f27108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f27109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected long f27110c;

        private b() {
            this.f27108a = new n(a.this.f27104d.a());
            this.f27110c = 0L;
        }

        @Override // com.haier.library.a.c0
        public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
            try {
                long jP0 = a.this.f27104d.P0(gVar, j7);
                if (jP0 > 0) {
                    this.f27110c += jP0;
                }
                return jP0;
            } catch (IOException e8) {
                b(false, e8);
                throw e8;
            }
        }

        @Override // com.haier.library.a.c0
        public d0 a() {
            return this.f27108a;
        }

        protected final void b(boolean z7, IOException iOException) throws IOException {
            a aVar = a.this;
            int i7 = aVar.f27106f;
            if (i7 == 6) {
                return;
            }
            if (i7 != 5) {
                throw new IllegalStateException("state: " + a.this.f27106f);
            }
            aVar.f(this.f27108a);
            a aVar2 = a.this;
            aVar2.f27106f = 6;
            com.haier.library.okhttp.b.d.g gVar = aVar2.f27103c;
            if (gVar != null) {
                gVar.i(!z7, aVar2, this.f27110c, iOException);
            }
        }
    }

    private final class c implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f27112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f27113b;

        c() {
            this.f27112a = new n(a.this.f27105e.a());
        }

        @Override // com.haier.library.a.b0
        public void I1(com.haier.library.a.g gVar, long j7) throws IOException {
            if (this.f27113b) {
                throw new IllegalStateException("closed");
            }
            if (j7 == 0) {
                return;
            }
            a.this.f27105e.P1(j7);
            a.this.f27105e.b("\r\n");
            a.this.f27105e.I1(gVar, j7);
            a.this.f27105e.b("\r\n");
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return this.f27112a;
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f27113b) {
                return;
            }
            this.f27113b = true;
            a.this.f27105e.b("0\r\n\r\n");
            a.this.f(this.f27112a);
            a.this.f27106f = 3;
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f27113b) {
                return;
            }
            a.this.f27105e.flush();
        }
    }

    private class d extends b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final long f27115i = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final h0 f27116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f27117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f27118g;

        d(h0 h0Var) {
            super();
            this.f27117f = -1L;
            this.f27118g = true;
            this.f27116e = h0Var;
        }

        private void e() throws IOException {
            if (this.f27117f != -1) {
                a.this.f27104d.v();
            }
            try {
                this.f27117f = a.this.f27104d.t();
                String strTrim = a.this.f27104d.v().trim();
                if (this.f27117f < 0 || !(strTrim.isEmpty() || strTrim.startsWith(j.f13806b))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f27117f + strTrim + "\"");
                }
                if (this.f27117f == 0) {
                    this.f27118g = false;
                    com.haier.library.okhttp.b.e.e.j(a.this.f27102b.q(), this.f27116e, a.this.j());
                    b(true, null);
                }
            } catch (NumberFormatException e8) {
                throw new ProtocolException(e8.getMessage());
            }
        }

        @Override // com.haier.library.okhttp.b.f.a.b, com.haier.library.a.c0
        public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
            if (j7 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j7);
            }
            if (this.f27109b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f27118g) {
                return -1L;
            }
            long j8 = this.f27117f;
            if (j8 == 0 || j8 == -1) {
                e();
                if (!this.f27118g) {
                    return -1L;
                }
            }
            long jP0 = super.P0(gVar, Math.min(j7, this.f27117f));
            if (jP0 != -1) {
                this.f27117f -= jP0;
                return jP0;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b(false, protocolException);
            throw protocolException;
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f27109b) {
                return;
            }
            if (this.f27118g && !com.haier.library.okhttp.n.d.w(this, 100, TimeUnit.MILLISECONDS)) {
                b(false, null);
            }
            this.f27109b = true;
        }
    }

    private final class e implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f27120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f27121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f27122c;

        e(long j7) {
            this.f27120a = new n(a.this.f27105e.a());
            this.f27122c = j7;
        }

        @Override // com.haier.library.a.b0
        public void I1(com.haier.library.a.g gVar, long j7) throws IOException {
            if (this.f27121b) {
                throw new IllegalStateException("closed");
            }
            com.haier.library.okhttp.n.d.r(gVar.Y0(), 0L, j7);
            if (j7 <= this.f27122c) {
                a.this.f27105e.I1(gVar, j7);
                this.f27122c -= j7;
                return;
            }
            throw new ProtocolException("expected " + this.f27122c + " bytes but received " + j7);
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return this.f27120a;
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f27121b) {
                return;
            }
            this.f27121b = true;
            if (this.f27122c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.f(this.f27120a);
            a.this.f27106f = 3;
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public void flush() throws IOException {
            if (this.f27121b) {
                return;
            }
            a.this.f27105e.flush();
        }
    }

    private class f extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f27124e;

        f(long j7) throws IOException {
            super();
            this.f27124e = j7;
            if (j7 == 0) {
                b(true, null);
            }
        }

        @Override // com.haier.library.okhttp.b.f.a.b, com.haier.library.a.c0
        public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
            if (j7 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j7);
            }
            if (this.f27109b) {
                throw new IllegalStateException("closed");
            }
            long j8 = this.f27124e;
            if (j8 == 0) {
                return -1L;
            }
            long jP0 = super.P0(gVar, Math.min(j8, j7));
            if (jP0 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b(false, protocolException);
                throw protocolException;
            }
            long j9 = this.f27124e - jP0;
            this.f27124e = j9;
            if (j9 == 0) {
                b(true, null);
            }
            return jP0;
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f27109b) {
                return;
            }
            if (this.f27124e != 0 && !com.haier.library.okhttp.n.d.w(this, 100, TimeUnit.MILLISECONDS)) {
                b(false, null);
            }
            this.f27109b = true;
        }
    }

    private class g extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f27126e;

        g() {
            super();
        }

        @Override // com.haier.library.okhttp.b.f.a.b, com.haier.library.a.c0
        public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
            if (j7 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j7);
            }
            if (this.f27109b) {
                throw new IllegalStateException("closed");
            }
            if (this.f27126e) {
                return -1L;
            }
            long jP0 = super.P0(gVar, j7);
            if (jP0 != -1) {
                return jP0;
            }
            this.f27126e = true;
            b(true, null);
            return -1L;
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f27109b) {
                return;
            }
            if (!this.f27126e) {
                b(false, null);
            }
            this.f27109b = true;
        }
    }

    public a(l0 l0Var, com.haier.library.okhttp.b.d.g gVar, i iVar, h hVar) {
        this.f27102b = l0Var;
        this.f27103c = gVar;
        this.f27104d = iVar;
        this.f27105e = hVar;
    }

    private String m() throws IOException {
        String strJ = this.f27104d.j(this.f27107g);
        this.f27107g -= (long) strJ.length();
        return strJ;
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void a(com.haier.library.okhttp.f fVar) throws IOException {
        g(fVar.f(), com.haier.library.okhttp.b.e.i.a(fVar, this.f27103c.l().a().b().type()));
    }

    @Override // com.haier.library.okhttp.b.e.c
    public com.haier.library.okhttp.b b(com.haier.library.okhttp.a aVar) throws IOException {
        com.haier.library.okhttp.b.d.g gVar = this.f27103c;
        gVar.f27047f.t(gVar.f27046e);
        String strE = aVar.E("Content-Type");
        if (!com.haier.library.okhttp.b.e.e.u(aVar)) {
            return new com.haier.library.okhttp.b.e.h(strE, 0L, t.b(h(0L)));
        }
        if ("chunked".equalsIgnoreCase(aVar.E(com.google.common.net.c.f22183z0))) {
            return new com.haier.library.okhttp.b.e.h(strE, -1L, t.b(e(aVar.v0().a())));
        }
        long jD = com.haier.library.okhttp.b.e.e.d(aVar);
        return jD != -1 ? new com.haier.library.okhttp.b.e.h(strE, jD, t.b(h(jD))) : new com.haier.library.okhttp.b.e.h(strE, -1L, t.b(l()));
    }

    @Override // com.haier.library.okhttp.b.e.c
    public b0 c(com.haier.library.okhttp.f fVar, long j7) {
        if ("chunked".equalsIgnoreCase(fVar.c(com.google.common.net.c.f22183z0))) {
            return k();
        }
        if (j7 != -1) {
            return d(j7);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public b0 d(long j7) {
        if (this.f27106f == 1) {
            this.f27106f = 2;
            return new e(j7);
        }
        throw new IllegalStateException("state: " + this.f27106f);
    }

    public c0 e(h0 h0Var) throws IOException {
        if (this.f27106f == 4) {
            this.f27106f = 5;
            return new d(h0Var);
        }
        throw new IllegalStateException("state: " + this.f27106f);
    }

    void f(n nVar) {
        d0 d0VarL = nVar.l();
        nVar.k(d0.f26246d);
        d0VarL.i();
        d0VarL.f();
    }

    public void g(g0 g0Var, String str) throws IOException {
        if (this.f27106f != 0) {
            throw new IllegalStateException("state: " + this.f27106f);
        }
        this.f27105e.b(str).b("\r\n");
        int iA = g0Var.a();
        for (int i7 = 0; i7 < iA; i7++) {
            this.f27105e.b(g0Var.d(i7)).b(": ").b(g0Var.h(i7)).b("\r\n");
        }
        this.f27105e.b("\r\n");
        this.f27106f = 1;
    }

    public c0 h(long j7) throws IOException {
        if (this.f27106f == 4) {
            this.f27106f = 5;
            return new f(j7);
        }
        throw new IllegalStateException("state: " + this.f27106f);
    }

    public boolean i() {
        return this.f27106f == 6;
    }

    public g0 j() throws IOException {
        g0.a aVar = new g0.a();
        while (true) {
            String strM = m();
            if (strM.length() == 0) {
                return aVar.e();
            }
            com.haier.library.okhttp.n.b.f27684a.j(aVar, strM);
        }
    }

    public b0 k() {
        if (this.f27106f == 1) {
            this.f27106f = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f27106f);
    }

    public c0 l() throws IOException {
        if (this.f27106f != 4) {
            throw new IllegalStateException("state: " + this.f27106f);
        }
        com.haier.library.okhttp.b.d.g gVar = this.f27103c;
        if (gVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f27106f = 5;
        gVar.n();
        return new g();
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void a() throws IOException {
        this.f27105e.flush();
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void c() {
        com.haier.library.okhttp.b.d.c cVarL = this.f27103c.l();
        if (cVarL != null) {
            cVarL.p();
        }
    }

    @Override // com.haier.library.okhttp.b.e.c
    public com.haier.library.okhttp.a.C0352a a(boolean z7) throws IOException {
        int i7 = this.f27106f;
        if (i7 != 1 && i7 != 3) {
            throw new IllegalStateException("state: " + this.f27106f);
        }
        try {
            k kVarB = k.b(m());
            com.haier.library.okhttp.a.C0352a c0352aH = new com.haier.library.okhttp.a.C0352a().e(kVarB.f27091a).a(kVarB.f27092b).i(kVarB.f27093c).h(j());
            if (z7 && kVarB.f27092b == 100) {
                return null;
            }
            if (kVarB.f27092b == 100) {
                this.f27106f = 3;
                return c0352aH;
            }
            this.f27106f = 4;
            return c0352aH;
        } catch (EOFException e8) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f27103c);
            iOException.initCause(e8);
            throw iOException;
        }
    }

    @Override // com.haier.library.okhttp.b.e.c
    public void b() throws IOException {
        this.f27105e.flush();
    }
}
