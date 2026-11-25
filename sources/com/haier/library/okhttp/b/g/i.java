package com.haier.library.okhttp.b.g;

import com.haier.library.a.b0;
import com.haier.library.a.c0;
import com.haier.library.a.d0;
import com.haier.library.okhttp.g0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f27297m = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f27298a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f27299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f27300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g f27301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<g0> f27302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.library.okhttp.b.g.c.a f27303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f27305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final a f27306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final c f27307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final c f27308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    com.haier.library.okhttp.b.g.b f27309l;

    final class a implements b0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f27310e = 16384;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ boolean f27311f = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.library.a.g f27312a = new com.haier.library.a.g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f27313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f27314c;

        a() {
        }

        private void b(boolean z7) throws IOException {
            i iVar;
            long jMin;
            i iVar2;
            synchronized (i.this) {
                i.this.f27308k.u();
                while (true) {
                    try {
                        iVar = i.this;
                        if (iVar.f27299b > 0 || this.f27314c || this.f27313b || iVar.f27309l != null) {
                            break;
                        } else {
                            iVar.y();
                        }
                    } catch (Throwable th) {
                        i.this.f27308k.w();
                        throw th;
                    }
                }
                iVar.f27308k.w();
                i.this.x();
                jMin = Math.min(i.this.f27299b, this.f27312a.Y0());
                iVar2 = i.this;
                iVar2.f27299b -= jMin;
            }
            iVar2.f27308k.u();
            try {
                i iVar3 = i.this;
                iVar3.f27301d.s(iVar3.f27300c, z7 && jMin == this.f27312a.Y0(), this.f27312a, jMin);
            } finally {
                i.this.f27308k.w();
            }
        }

        @Override // com.haier.library.a.b0
        public void I1(com.haier.library.a.g gVar, long j7) throws IOException {
            if (!f27311f && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f27312a.I1(gVar, j7);
            while (this.f27312a.Y0() >= 16384) {
                b(false);
            }
        }

        @Override // com.haier.library.a.b0
        public d0 a() {
            return i.this.f27308k;
        }

        @Override // com.haier.library.a.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f27311f && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.f27313b) {
                    return;
                }
                if (!i.this.f27306i.f27314c) {
                    if (this.f27312a.Y0() > 0) {
                        while (this.f27312a.Y0() > 0) {
                            b(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f27301d.s(iVar.f27300c, true, null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f27313b = true;
                }
                i.this.f27301d.J0();
                i.this.w();
            }
        }

        @Override // com.haier.library.a.b0, java.io.Flushable
        public void flush() throws IOException {
            if (!f27311f && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.x();
            }
            while (this.f27312a.Y0() > 0) {
                b(false);
                i.this.f27301d.J0();
            }
        }
    }

    class c extends com.haier.library.a.a {
        c() {
        }

        @Override // com.haier.library.a.a
        protected IOException m(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.data.a.f13674p);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.haier.library.a.a
        protected void n() {
            i.this.j(com.haier.library.okhttp.b.g.b.CANCEL);
        }

        public void w() throws IOException {
            if (r()) {
                throw m(null);
            }
        }
    }

    i(int i7, g gVar, boolean z7, boolean z8, @Nullable g0 g0Var) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f27302e = arrayDeque;
        this.f27307j = new c();
        this.f27308k = new c();
        this.f27309l = null;
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.f27300c = i7;
        this.f27301d = gVar;
        this.f27299b = gVar.f27239o.j();
        b bVar = new b(gVar.f27238n.j());
        this.f27305h = bVar;
        a aVar = new a();
        this.f27306i = aVar;
        bVar.f27321e = z8;
        aVar.f27314c = z7;
        if (g0Var != null) {
            arrayDeque.add(g0Var);
        }
        if (m() && g0Var != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!m() && g0Var == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean o(com.haier.library.okhttp.b.g.b bVar) {
        if (!f27297m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.f27309l != null) {
                return false;
            }
            if (this.f27305h.f27321e && this.f27306i.f27314c) {
                return false;
            }
            this.f27309l = bVar;
            notifyAll();
            this.f27301d.h0(this.f27300c);
            return true;
        }
    }

    public int a() {
        return this.f27300c;
    }

    void c(long j7) {
        this.f27299b += j7;
        if (j7 > 0) {
            notifyAll();
        }
    }

    void d(com.haier.library.a.i iVar, int i7) throws IOException {
        if (!f27297m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f27305h.b(iVar, i7);
    }

    public void e(com.haier.library.okhttp.b.g.b bVar) throws IOException {
        if (o(bVar)) {
            this.f27301d.o0(this.f27300c, bVar);
        }
    }

    public synchronized void f(com.haier.library.okhttp.b.g.c.a aVar) {
        this.f27303f = aVar;
        if (!this.f27302e.isEmpty() && aVar != null) {
            notifyAll();
        }
    }

    void g(List<com.haier.library.okhttp.b.g.c> list) {
        boolean zK;
        if (!f27297m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f27304g = true;
            this.f27302e.add(com.haier.library.okhttp.n.d.E(list));
            zK = k();
            notifyAll();
        }
        if (zK) {
            return;
        }
        this.f27301d.h0(this.f27300c);
    }

    public void h(List<com.haier.library.okhttp.b.g.c> list, boolean z7) throws IOException {
        boolean z8;
        boolean z9;
        boolean z10;
        if (!f27297m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            z8 = true;
            this.f27304g = true;
            if (z7) {
                z9 = false;
            } else {
                this.f27306i.f27314c = true;
                z9 = true;
            }
            z10 = z9;
        }
        if (!z9) {
            synchronized (this.f27301d) {
                if (this.f27301d.f27237m != 0) {
                    z8 = false;
                }
            }
            z9 = z8;
        }
        this.f27301d.u(this.f27300c, z10, list);
        if (z9) {
            this.f27301d.J0();
        }
    }

    public void j(com.haier.library.okhttp.b.g.b bVar) {
        if (o(bVar)) {
            this.f27301d.q(this.f27300c, bVar);
        }
    }

    public synchronized boolean k() {
        if (this.f27309l != null) {
            return false;
        }
        b bVar = this.f27305h;
        if (bVar.f27321e || bVar.f27320d) {
            a aVar = this.f27306i;
            if ((aVar.f27314c || aVar.f27313b) && this.f27304g) {
                return false;
            }
        }
        return true;
    }

    synchronized void l(com.haier.library.okhttp.b.g.b bVar) {
        if (this.f27309l == null) {
            this.f27309l = bVar;
            notifyAll();
        }
    }

    public boolean m() {
        return this.f27301d.f27225a == ((this.f27300c & 1) == 1);
    }

    public g n() {
        return this.f27301d;
    }

    public synchronized g0 p() throws IOException {
        this.f27307j.u();
        while (this.f27302e.isEmpty() && this.f27309l == null) {
            try {
                y();
            } catch (Throwable th) {
                this.f27307j.w();
                throw th;
            }
        }
        this.f27307j.w();
        if (this.f27302e.isEmpty()) {
            throw new n(this.f27309l);
        }
        return this.f27302e.removeFirst();
    }

    public synchronized com.haier.library.okhttp.b.g.b q() {
        return this.f27309l;
    }

    public d0 r() {
        return this.f27307j;
    }

    public d0 s() {
        return this.f27308k;
    }

    public c0 t() {
        return this.f27305h;
    }

    public b0 u() {
        synchronized (this) {
            if (!this.f27304g && !m()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f27306i;
    }

    void v() {
        boolean zK;
        if (!f27297m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f27305h.f27321e = true;
            zK = k();
            notifyAll();
        }
        if (zK) {
            return;
        }
        this.f27301d.h0(this.f27300c);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0028  */
    void w() throws IOException {
        boolean z7;
        boolean zK;
        if (!f27297m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            b bVar = this.f27305h;
            if (bVar.f27321e || !bVar.f27320d) {
                z7 = false;
            } else {
                a aVar = this.f27306i;
                if (aVar.f27314c || aVar.f27313b) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            zK = k();
        }
        if (z7) {
            e(com.haier.library.okhttp.b.g.b.CANCEL);
        } else {
            if (zK) {
                return;
            }
            this.f27301d.h0(this.f27300c);
        }
    }

    void x() throws IOException {
        a aVar = this.f27306i;
        if (aVar.f27313b) {
            throw new IOException("stream closed");
        }
        if (aVar.f27314c) {
            throw new IOException("stream finished");
        }
        if (this.f27309l != null) {
            throw new n(this.f27309l);
        }
    }

    void y() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    private final class b implements c0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final /* synthetic */ boolean f27316g = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.library.a.g f27317a = new com.haier.library.a.g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.haier.library.a.g f27318b = new com.haier.library.a.g();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f27319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27320d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f27321e;

        b(long j7) {
            this.f27319c = j7;
        }

        private void a(long j7) {
            if (!f27316g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            i.this.f27301d.a(j7);
        }

        /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:44:0x00c3 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:45:0x00c5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
        @Override // com.haier.library.a.c0
        public long P0(com.haier.library.a.g gVar, long j7) throws IOException {
            long jP0;
            g0 g0Var;
            com.haier.library.okhttp.b.g.c.a aVar;
            if (j7 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j7);
            }
            while (true) {
                synchronized (i.this) {
                    i.this.f27307j.u();
                    try {
                        i iVar = i.this;
                        com.haier.library.okhttp.b.g.b bVar = iVar.f27309l;
                        if (bVar == null) {
                            bVar = null;
                        }
                        if (this.f27320d) {
                            throw new IOException("stream closed");
                        }
                        if (!iVar.f27302e.isEmpty() && i.this.f27303f != null) {
                            g0Var = (g0) i.this.f27302e.removeFirst();
                            aVar = i.this.f27303f;
                        } else if (this.f27318b.Y0() > 0) {
                            com.haier.library.a.g gVar2 = this.f27318b;
                            jP0 = gVar2.P0(gVar, Math.min(j7, gVar2.Y0()));
                            i iVar2 = i.this;
                            long j8 = iVar2.f27298a + jP0;
                            iVar2.f27298a = j8;
                            if (bVar == null && j8 >= iVar2.f27301d.f27238n.j() / 2) {
                                i iVar3 = i.this;
                                iVar3.f27301d.g(iVar3.f27300c, iVar3.f27298a);
                                i.this.f27298a = 0L;
                            }
                            g0Var = null;
                            aVar = null;
                            i.this.f27307j.w();
                            if (g0Var != null || aVar == null) {
                                if (jP0 != -1) {
                                    a(jP0);
                                    return jP0;
                                }
                                if (bVar == null) {
                                    return -1L;
                                }
                                throw new n(bVar);
                            }
                            aVar.a(g0Var);
                        } else if (this.f27321e || bVar != null) {
                            g0Var = null;
                            aVar = null;
                        } else {
                            i.this.y();
                            i.this.f27307j.w();
                        }
                        jP0 = -1;
                        i.this.f27307j.w();
                        if (g0Var != null) {
                        }
                        if (jP0 != -1) {
                            a(jP0);
                            return jP0;
                        }
                        if (bVar == null) {
                            return -1L;
                        }
                        throw new n(bVar);
                    } catch (Throwable th) {
                        i.this.f27307j.w();
                        throw th;
                    }
                    throw th;
                }
            }
        }

        void b(com.haier.library.a.i iVar, long j7) throws IOException {
            boolean z7;
            boolean z8;
            boolean z9;
            if (!f27316g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j7 > 0) {
                synchronized (i.this) {
                    z7 = this.f27321e;
                    z8 = true;
                    z9 = this.f27318b.Y0() + j7 > this.f27319c;
                }
                if (z9) {
                    iVar.j0(j7);
                    i.this.j(com.haier.library.okhttp.b.g.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z7) {
                    iVar.j0(j7);
                    return;
                }
                long jP0 = iVar.P0(this.f27317a, j7);
                if (jP0 == -1) {
                    throw new EOFException();
                }
                j7 -= jP0;
                synchronized (i.this) {
                    if (this.f27318b.Y0() != 0) {
                        z8 = false;
                    }
                    this.f27318b.f0(this.f27317a);
                    if (z8) {
                        i.this.notifyAll();
                    }
                }
            }
        }

        @Override // com.haier.library.a.c0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long jY0;
            ArrayList arrayList;
            com.haier.library.okhttp.b.g.c.a aVar;
            synchronized (i.this) {
                this.f27320d = true;
                jY0 = this.f27318b.Y0();
                this.f27318b.h2();
                if (i.this.f27302e.isEmpty() || i.this.f27303f == null) {
                    arrayList = null;
                    aVar = null;
                } else {
                    arrayList = new ArrayList(i.this.f27302e);
                    i.this.f27302e.clear();
                    aVar = i.this.f27303f;
                }
                i.this.notifyAll();
            }
            if (jY0 > 0) {
                a(jY0);
            }
            i.this.w();
            if (aVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    aVar.a((g0) it.next());
                }
            }
        }

        @Override // com.haier.library.a.c0
        public d0 a() {
            return i.this.f27307j;
        }
    }
}
