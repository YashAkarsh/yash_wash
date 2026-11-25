package com.haier.library.okhttp.b.m;

import com.haier.library.a.g;
import com.haier.library.a.i;
import com.haier.library.a.j;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f27466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final i f27467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a f27468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f27469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f27470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f27471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f27472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f27473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g f27474i = new g();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g f27475j = new g();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final byte[] f27476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final g.c f27477l;

    public interface a {
        void a(j jVar);

        void b(int i7, String str);

        void b(String str) throws IOException;

        void d(j jVar) throws IOException;

        void e(j jVar);
    }

    c(boolean z7, i iVar, a aVar) {
        if (iVar == null) {
            throw new NullPointerException("source == null");
        }
        if (aVar == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.f27466a = z7;
        this.f27467b = iVar;
        this.f27468c = aVar;
        this.f27476k = z7 ? null : new byte[4];
        this.f27477l = z7 ? null : new g.c();
    }

    private void b() throws IOException {
        if (this.f27469d) {
            throw new IOException("closed");
        }
        long jH = this.f27467b.a().h();
        this.f27467b.a().f();
        try {
            int iJ = this.f27467b.j() & 255;
            this.f27467b.a().b(jH, TimeUnit.NANOSECONDS);
            this.f27470e = iJ & 15;
            boolean z7 = (iJ & 128) != 0;
            this.f27472g = z7;
            boolean z8 = (iJ & 8) != 0;
            this.f27473h = z8;
            if (z8 && !z7) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z9 = (iJ & 64) != 0;
            boolean z10 = (iJ & 32) != 0;
            boolean z11 = (iJ & 16) != 0;
            if (z9 || z10 || z11) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int iJ2 = this.f27467b.j() & 255;
            boolean z12 = (iJ2 & 128) != 0;
            if (z12 == this.f27466a) {
                throw new ProtocolException(this.f27466a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j7 = iJ2 & 127;
            this.f27471f = j7;
            if (j7 == 126) {
                this.f27471f = ((long) this.f27467b.k()) & okhttp3.internal.ws.g.f38386s;
            } else if (j7 == 127) {
                long jM = this.f27467b.m();
                this.f27471f = jM;
                if (jM < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f27471f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f27473h && this.f27471f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z12) {
                this.f27467b.k1(this.f27476k);
            }
        } catch (Throwable th) {
            this.f27467b.a().b(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void c() throws IOException {
        short sK;
        String strT;
        long j7 = this.f27471f;
        if (j7 > 0) {
            this.f27467b.y0(this.f27474i, j7);
            if (!this.f27466a) {
                this.f27474i.a1(this.f27477l);
                this.f27477l.c(0L);
                b.c(this.f27477l, this.f27476k);
                this.f27477l.close();
            }
        }
        switch (this.f27470e) {
            case 8:
                long jY0 = this.f27474i.Y0();
                if (jY0 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jY0 != 0) {
                    sK = this.f27474i.k();
                    strT = this.f27474i.T();
                    String strA = b.a(sK);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    sK = 1005;
                    strT = "";
                }
                this.f27468c.b(sK, strT);
                this.f27469d = true;
                return;
            case 9:
                this.f27468c.a(this.f27474i.s());
                return;
            case 10:
                this.f27468c.e(this.f27474i.s());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f27470e));
        }
    }

    private void d() throws IOException {
        int i7 = this.f27470e;
        if (i7 != 1 && i7 != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i7));
        }
        f();
        if (i7 == 1) {
            this.f27468c.b(this.f27475j.T());
        } else {
            this.f27468c.d(this.f27475j.s());
        }
    }

    private void e() throws IOException {
        while (!this.f27469d) {
            b();
            if (!this.f27473h) {
                return;
            } else {
                c();
            }
        }
    }

    private void f() throws IOException {
        while (!this.f27469d) {
            long j7 = this.f27471f;
            if (j7 > 0) {
                this.f27467b.y0(this.f27475j, j7);
                if (!this.f27466a) {
                    this.f27475j.a1(this.f27477l);
                    this.f27477l.c(this.f27475j.Y0() - this.f27471f);
                    b.c(this.f27477l, this.f27476k);
                    this.f27477l.close();
                }
            }
            if (this.f27472g) {
                return;
            }
            e();
            if (this.f27470e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f27470e));
            }
        }
        throw new IOException("closed");
    }

    void a() throws IOException {
        b();
        if (this.f27473h) {
            c();
        } else {
            d();
        }
    }
}
