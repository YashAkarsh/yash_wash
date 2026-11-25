package com.haier.library.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f26232h = 65536;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f26233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f26234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    static a f26235k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f26236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private a f26237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f26238g;

    /* JADX INFO: renamed from: com.haier.library.a.a$a, reason: collision with other inner class name */
    class C0347a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f26239a;

        C0347a(b0 b0Var) {
            this.f26239a = b0Var;
        }

        @Override // com.haier.library.a.b0
        public void I1(g gVar, long j7) throws IOException {
            com.haier.library.a.c.d(gVar.f26255b, 0L, j7);
            while (true) {
                long j8 = 0;
                if (j7 <= 0) {
                    return;
                }
                y yVar = gVar.f26254a;
                while (j8 < PlaybackStateCompat.C) {
                    j8 += (long) (yVar.f26333c - yVar.f26332b);
                    if (j8 >= j7) {
                        j8 = j7;
                        break;
                    }
                    yVar = yVar.f26336f;
                }
                a.this.u();
                try {
                    try {
                        this.f26239a.I1(gVar, j8);
                        j7 -= j8;
                        a.this.p(true);
                    } catch (IOException e8) {
                        throw a.this.t(e8);
                    }
                } catch (Throwable th) {
                    a.this.p(false);
                    throw th;
                }
            }
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return a.this;
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.u();
            try {
                try {
                    this.f26239a.close();
                    a.this.p(true);
                } catch (IOException e8) {
                    throw a.this.t(e8);
                }
            } catch (Throwable th) {
                a.this.p(false);
                throw th;
            }
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public void flush() throws IOException {
            a.this.u();
            try {
                try {
                    this.f26239a.flush();
                    a.this.p(true);
                } catch (IOException e8) {
                    throw a.this.t(e8);
                }
            } catch (Throwable th) {
                a.this.p(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f26239a + ")";
        }
    }

    class b implements c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c0 f26241a;

        b(c0 c0Var) {
            this.f26241a = c0Var;
        }

        @Override // com.haier.library.a.c0
        public long P0(g gVar, long j7) throws IOException {
            a.this.u();
            try {
                try {
                    long jP0 = this.f26241a.P0(gVar, j7);
                    a.this.p(true);
                    return jP0;
                } catch (IOException e8) {
                    throw a.this.t(e8);
                }
            } catch (Throwable th) {
                a.this.p(false);
                throw th;
            }
        }

        @Override // com.haier.library.a.c0
        public d0 a() {
            return a.this;
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f26241a.close();
                    a.this.p(true);
                } catch (IOException e8) {
                    throw a.this.t(e8);
                }
            } catch (Throwable th) {
                a.this.p(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f26241a + ")";
        }
    }

    private static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.n();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<com.haier.library.a.a> r0 = com.haier.library.a.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                com.haier.library.a.a r1 = com.haier.library.a.a.v()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                com.haier.library.a.a r2 = com.haier.library.a.a.f26235k     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                com.haier.library.a.a.f26235k = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.n()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.haier.library.a.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f26233i = millis;
        f26234j = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    private static synchronized void o(a aVar, long j7, boolean z7) {
        if (f26235k == null) {
            f26235k = new a();
            new c().start();
        }
        long jNanoTime = System.nanoTime();
        if (j7 != 0 && z7) {
            aVar.f26238g = Math.min(j7, aVar.g() - jNanoTime) + jNanoTime;
        } else if (j7 != 0) {
            aVar.f26238g = j7 + jNanoTime;
        } else {
            if (!z7) {
                throw new AssertionError();
            }
            aVar.f26238g = aVar.g();
        }
        long jS = aVar.s(jNanoTime);
        a aVar2 = f26235k;
        while (true) {
            a aVar3 = aVar2.f26237f;
            if (aVar3 == null || jS < aVar3.s(jNanoTime)) {
                break;
                break;
            }
            aVar2 = aVar2.f26237f;
        }
        aVar.f26237f = aVar2.f26237f;
        aVar2.f26237f = aVar;
        if (aVar2 == f26235k) {
            a.class.notify();
        }
    }

    private static synchronized boolean q(a aVar) {
        a aVar2 = f26235k;
        while (aVar2 != null) {
            a aVar3 = aVar2.f26237f;
            if (aVar3 == aVar) {
                aVar2.f26237f = aVar.f26237f;
                aVar.f26237f = null;
                return false;
            }
            aVar2 = aVar3;
        }
        return true;
    }

    private long s(long j7) {
        return this.f26238g - j7;
    }

    @Nullable
    static a v() throws InterruptedException {
        a aVar = f26235k.f26237f;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(f26233i);
            if (f26235k.f26237f != null || System.nanoTime() - jNanoTime < f26234j) {
                return null;
            }
            return f26235k;
        }
        long jS = aVar.s(System.nanoTime());
        if (jS > 0) {
            long j7 = jS / 1000000;
            a.class.wait(j7, (int) (jS - (1000000 * j7)));
            return null;
        }
        f26235k.f26237f = aVar.f26237f;
        aVar.f26237f = null;
        return aVar;
    }

    public final b0 k(b0 b0Var) {
        return new C0347a(b0Var);
    }

    public final c0 l(c0 c0Var) {
        return new b(c0Var);
    }

    protected IOException m(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(com.alipay.sdk.data.a.f13674p);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    protected void n() {
    }

    final void p(boolean z7) throws IOException {
        if (r() && z7) {
            throw m(null);
        }
    }

    public final boolean r() {
        if (!this.f26236e) {
            return false;
        }
        this.f26236e = false;
        return q(this);
    }

    final IOException t(IOException iOException) throws IOException {
        return !r() ? iOException : m(iOException);
    }

    public final void u() {
        if (this.f26236e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            this.f26236e = true;
            o(this, jH, zE);
        }
    }
}
