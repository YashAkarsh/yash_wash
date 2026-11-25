package com.haier.library.okhttp.b.m;

import android.support.v4.media.session.PlaybackStateCompat;
import com.haier.library.a.b0;
import com.haier.library.a.d0;
import com.haier.library.a.g;
import com.haier.library.a.h;
import com.haier.library.a.j;
import java.io.IOException;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f27478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Random f27479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h f27480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g f27481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f27482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final g f27483f = new g();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final a f27484g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f27485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f27486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g.c f27487j;

    final class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f27489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f27490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27491d;

        a() {
        }

        @Override // com.haier.library.a.b0
        public void I1(g gVar, long j7) throws IOException {
            if (this.f27491d) {
                throw new IOException("closed");
            }
            d.this.f27483f.I1(gVar, j7);
            boolean z7 = this.f27490c && this.f27489b != -1 && d.this.f27483f.Y0() > this.f27489b - PlaybackStateCompat.f450z;
            long jC2 = d.this.f27483f.c2();
            if (jC2 <= 0 || z7) {
                return;
            }
            d.this.b(this.f27488a, jC2, this.f27490c, false);
            this.f27490c = false;
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return d.this.f27480c.a();
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f27491d) {
                throw new IOException("closed");
            }
            d dVar = d.this;
            dVar.b(this.f27488a, dVar.f27483f.Y0(), this.f27490c, true);
            this.f27491d = true;
            d.this.f27485h = false;
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public void flush() throws IOException {
            if (this.f27491d) {
                throw new IOException("closed");
            }
            d dVar = d.this;
            dVar.b(this.f27488a, dVar.f27483f.Y0(), this.f27490c, false);
            this.f27490c = false;
        }
    }

    d(boolean z7, h hVar, Random random) {
        if (hVar == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.f27478a = z7;
        this.f27480c = hVar;
        this.f27481d = hVar.c();
        this.f27479b = random;
        this.f27486i = z7 ? new byte[4] : null;
        this.f27487j = z7 ? new g.c() : null;
    }

    private void e(int i7, j jVar) throws IOException {
        if (this.f27482e) {
            throw new IOException("closed");
        }
        int iZ = jVar.Z();
        if (iZ > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f27481d.y1(i7 | 128);
        if (this.f27478a) {
            this.f27481d.y1(iZ | 128);
            this.f27479b.nextBytes(this.f27486i);
            this.f27481d.K1(this.f27486i);
            if (iZ > 0) {
                long jY0 = this.f27481d.Y0();
                this.f27481d.B(jVar);
                this.f27481d.a1(this.f27487j);
                this.f27487j.c(jY0);
                b.c(this.f27487j, this.f27486i);
                this.f27487j.close();
            }
        } else {
            this.f27481d.y1(iZ);
            this.f27481d.B(jVar);
        }
        this.f27480c.flush();
    }

    b0 a(int i7, long j7) {
        if (this.f27485h) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.f27485h = true;
        a aVar = this.f27484g;
        aVar.f27488a = i7;
        aVar.f27489b = j7;
        aVar.f27490c = true;
        aVar.f27491d = false;
        return aVar;
    }

    void b(int i7, long j7, boolean z7, boolean z8) throws IOException {
        if (this.f27482e) {
            throw new IOException("closed");
        }
        if (!z7) {
            i7 = 0;
        }
        if (z8) {
            i7 |= 128;
        }
        this.f27481d.y1(i7);
        int i8 = this.f27478a ? 128 : 0;
        if (j7 <= 125) {
            this.f27481d.y1(((int) j7) | i8);
        } else if (j7 <= okhttp3.internal.ws.g.f38386s) {
            this.f27481d.y1(i8 | 126);
            this.f27481d.l1((int) j7);
        } else {
            this.f27481d.y1(i8 | 127);
            this.f27481d.d0(j7);
        }
        if (this.f27478a) {
            this.f27479b.nextBytes(this.f27486i);
            this.f27481d.K1(this.f27486i);
            if (j7 > 0) {
                long jY0 = this.f27481d.Y0();
                this.f27481d.I1(this.f27483f, j7);
                this.f27481d.a1(this.f27487j);
                this.f27487j.c(jY0);
                b.c(this.f27487j, this.f27486i);
                this.f27487j.close();
            }
        } else {
            this.f27481d.I1(this.f27483f, j7);
        }
        this.f27480c.f();
    }

    void c(int i7, j jVar) throws IOException {
        j jVarS = j.f26267f;
        if (i7 != 0 || jVar != null) {
            if (i7 != 0) {
                b.d(i7);
            }
            g gVar = new g();
            gVar.l1(i7);
            if (jVar != null) {
                gVar.B(jVar);
            }
            jVarS = gVar.s();
        }
        try {
            e(8, jVarS);
        } finally {
            this.f27482e = true;
        }
    }

    void d(j jVar) throws IOException {
        e(9, jVar);
    }

    void f(j jVar) throws IOException {
        e(10, jVar);
    }
}
