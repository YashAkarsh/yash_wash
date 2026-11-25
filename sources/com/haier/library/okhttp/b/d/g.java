package com.haier.library.okhttp.b.d;

import com.haier.library.okhttp.d0;
import com.haier.library.okhttp.h;
import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.l0;
import com.haier.library.okhttp.n;
import com.haier.library.okhttp.q;
import com.haier.library.okhttp.w;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final /* synthetic */ boolean f27041o = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.haier.library.okhttp.c f27042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f.a f27043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f27044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w f27045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f27046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d0 f27047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f27048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f27049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f27051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f27052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f27053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f27054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.haier.library.okhttp.b.e.c f27055n;

    public static final class a extends WeakReference<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f27056a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f27056a = obj;
        }
    }

    public g(w wVar, com.haier.library.okhttp.c cVar, q qVar, d0 d0Var, Object obj) {
        this.f27045d = wVar;
        this.f27042a = cVar;
        this.f27046e = qVar;
        this.f27047f = d0Var;
        this.f27049h = new f(cVar, r(), qVar, d0Var);
        this.f27048g = obj;
    }

    private c a(int i7, int i8, int i9, int i10, boolean z7) throws Throwable {
        c cVar;
        Socket socketQ;
        c cVar2;
        Socket socketG;
        h hVarB;
        boolean z8;
        boolean z9;
        f.a aVar;
        synchronized (this.f27045d) {
            if (this.f27053l) {
                throw new IllegalStateException("released");
            }
            if (this.f27055n != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f27054m) {
                throw new IOException("Canceled");
            }
            cVar = this.f27051j;
            socketQ = q();
            cVar2 = this.f27051j;
            socketG = null;
            if (cVar2 != null) {
                cVar = null;
            } else {
                cVar2 = null;
            }
            if (!this.f27052k) {
                cVar = null;
            }
            if (cVar2 == null) {
                n.b.f27684a.b(this.f27045d, this.f27042a, this, null);
                c cVar3 = this.f27051j;
                if (cVar3 != null) {
                    z8 = true;
                    cVar2 = cVar3;
                    hVarB = null;
                } else {
                    hVarB = this.f27044c;
                }
            } else {
                hVarB = null;
            }
            z8 = false;
        }
        n.d.v(socketQ);
        if (cVar != null) {
            this.f27047f.p(this.f27046e, cVar);
        }
        if (z8) {
            this.f27047f.f(this.f27046e, cVar2);
        }
        if (cVar2 != null) {
            this.f27044c = this.f27051j.a();
            return cVar2;
        }
        if (hVarB != null || ((aVar = this.f27043b) != null && aVar.a())) {
            z9 = false;
        } else {
            this.f27043b = this.f27049h.f();
            z9 = true;
        }
        synchronized (this.f27045d) {
            if (this.f27054m) {
                throw new IOException("Canceled");
            }
            if (z9) {
                List<h> listC = this.f27043b.c();
                int size = listC.size();
                for (int i11 = 0; i11 < size; i11++) {
                    h hVar = listC.get(i11);
                    n.b.f27684a.b(this.f27045d, this.f27042a, this, hVar);
                    c cVar4 = this.f27051j;
                    if (cVar4 != null) {
                        this.f27044c = hVar;
                        z8 = true;
                        cVar2 = cVar4;
                        break;
                    }
                }
            }
            if (!z8) {
                if (hVarB == null) {
                    hVarB = this.f27043b.b();
                }
                this.f27044c = hVarB;
                this.f27050i = 0;
                cVar2 = new c(this.f27045d, hVarB);
                g(cVar2, false);
            }
        }
        if (z8) {
            this.f27047f.f(this.f27046e, cVar2);
            return cVar2;
        }
        cVar2.h(i7, i8, i9, i10, z7, this.f27046e, this.f27047f);
        r().b(cVar2.a());
        synchronized (this.f27045d) {
            this.f27052k = true;
            n.b.f27684a.p(this.f27045d, cVar2);
            if (cVar2.q()) {
                socketG = n.b.f27684a.g(this.f27045d, this.f27042a, this);
                cVar2 = this.f27051j;
            }
        }
        n.d.v(socketG);
        this.f27047f.f(this.f27046e, cVar2);
        return cVar2;
    }

    private c b(int i7, int i8, int i9, int i10, boolean z7, boolean z8) throws Throwable {
        while (true) {
            c cVarA = a(i7, i8, i9, i10, z7);
            synchronized (this.f27045d) {
                if (cVarA.f27022l == 0) {
                    return cVarA;
                }
                if (cVarA.o(z8)) {
                    return cVarA;
                }
                n();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    private Socket f(boolean z7, boolean z8, boolean z9) {
        Socket socketB;
        if (!f27041o && !Thread.holdsLock(this.f27045d)) {
            throw new AssertionError();
        }
        if (z9) {
            this.f27055n = null;
        }
        if (z8) {
            this.f27053l = true;
        }
        c cVar = this.f27051j;
        if (cVar == null) {
            return null;
        }
        if (z7) {
            cVar.f27021k = true;
        }
        if (this.f27055n != null) {
            return null;
        }
        if (!this.f27053l && !cVar.f27021k) {
            return null;
        }
        k(cVar);
        if (this.f27051j.f27024n.isEmpty()) {
            this.f27051j.f27025o = System.nanoTime();
            if (n.b.f27684a.n(this.f27045d, this.f27051j)) {
                socketB = this.f27051j.b();
            } else {
                socketB = null;
            }
        } else {
            socketB = null;
        }
        this.f27051j = null;
        return socketB;
    }

    private void k(c cVar) {
        int size = cVar.f27024n.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (cVar.f27024n.get(i7).get() == this) {
                cVar.f27024n.remove(i7);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket q() {
        if (!f27041o && !Thread.holdsLock(this.f27045d)) {
            throw new AssertionError();
        }
        c cVar = this.f27051j;
        if (cVar == null || !cVar.f27021k) {
            return null;
        }
        return f(false, false, true);
    }

    private d r() {
        return n.b.f27684a.c(this.f27045d);
    }

    public com.haier.library.okhttp.b.e.c c() {
        com.haier.library.okhttp.b.e.c cVar;
        synchronized (this.f27045d) {
            cVar = this.f27055n;
        }
        return cVar;
    }

    public com.haier.library.okhttp.b.e.c d(l0 l0Var, i0.a aVar, boolean z7) {
        try {
            com.haier.library.okhttp.b.e.c cVarE = b(aVar.d(), aVar.K(), aVar.f(), l0Var.n(), l0Var.D(), z7).e(l0Var, aVar, this);
            synchronized (this.f27045d) {
                this.f27055n = cVarE;
            }
            return cVarE;
        } catch (IOException e8) {
            throw new e(e8);
        }
    }

    public Socket e(c cVar) {
        if (!f27041o && !Thread.holdsLock(this.f27045d)) {
            throw new AssertionError();
        }
        if (this.f27055n != null || this.f27051j.f27024n.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<g> reference = this.f27051j.f27024n.get(0);
        Socket socketF = f(true, false, false);
        this.f27051j = cVar;
        cVar.f27024n.add(reference);
        return socketF;
    }

    public void g(c cVar, boolean z7) {
        if (!f27041o && !Thread.holdsLock(this.f27045d)) {
            throw new AssertionError();
        }
        if (this.f27051j != null) {
            throw new IllegalStateException();
        }
        this.f27051j = cVar;
        this.f27052k = z7;
        cVar.f27024n.add(new a(this, this.f27048g));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0046  */
    public void h(IOException iOException) {
        c cVar;
        boolean z7;
        Socket socketF;
        synchronized (this.f27045d) {
            cVar = null;
            if (iOException instanceof com.haier.library.okhttp.b.g.n) {
                com.haier.library.okhttp.b.g.b bVar = ((com.haier.library.okhttp.b.g.n) iOException).f27349a;
                if (bVar == com.haier.library.okhttp.b.g.b.REFUSED_STREAM) {
                    int i7 = this.f27050i + 1;
                    this.f27050i = i7;
                    if (i7 > 1) {
                        this.f27044c = null;
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else if (bVar != com.haier.library.okhttp.b.g.b.CANCEL) {
                    this.f27044c = null;
                    z7 = true;
                } else {
                    z7 = false;
                }
            } else {
                c cVar2 = this.f27051j;
                if (cVar2 == null || (cVar2.q() && !(iOException instanceof com.haier.library.okhttp.b.g.a))) {
                    z7 = false;
                } else {
                    if (this.f27051j.f27022l == 0) {
                        h hVar = this.f27044c;
                        if (hVar != null && iOException != null) {
                            this.f27049h.b(hVar, iOException);
                        }
                        this.f27044c = null;
                    }
                    z7 = true;
                }
            }
            c cVar3 = this.f27051j;
            socketF = f(z7, false, true);
            if (this.f27051j == null && this.f27052k) {
                cVar = cVar3;
            }
        }
        n.d.v(socketF);
        if (cVar != null) {
            this.f27047f.p(this.f27046e, cVar);
        }
    }

    public void i(boolean z7, com.haier.library.okhttp.b.e.c cVar, long j7, IOException iOException) {
        c cVar2;
        Socket socketF;
        boolean z8;
        this.f27047f.o(this.f27046e, j7);
        synchronized (this.f27045d) {
            if (cVar != null) {
                if (cVar == this.f27055n) {
                    if (!z7) {
                        this.f27051j.f27022l++;
                    }
                    cVar2 = this.f27051j;
                    socketF = f(z7, false, true);
                    if (this.f27051j != null) {
                        cVar2 = null;
                    }
                    z8 = this.f27053l;
                }
            }
            throw new IllegalStateException("expected " + this.f27055n + " but was " + cVar);
        }
        n.d.v(socketF);
        if (cVar2 != null) {
            this.f27047f.p(this.f27046e, cVar2);
        }
        if (iOException != null) {
            this.f27047f.h(this.f27046e, n.b.f27684a.f(this.f27046e, iOException));
        } else if (z8) {
            n.b.f27684a.f(this.f27046e, null);
            this.f27047f.u(this.f27046e);
        }
    }

    public h j() {
        return this.f27044c;
    }

    public synchronized c l() {
        return this.f27051j;
    }

    public void m() {
        c cVar;
        Socket socketF;
        synchronized (this.f27045d) {
            cVar = this.f27051j;
            socketF = f(false, true, false);
            if (this.f27051j != null) {
                cVar = null;
            }
        }
        n.d.v(socketF);
        if (cVar != null) {
            n.b.f27684a.f(this.f27046e, null);
            this.f27047f.p(this.f27046e, cVar);
            this.f27047f.u(this.f27046e);
        }
    }

    public void n() {
        c cVar;
        Socket socketF;
        synchronized (this.f27045d) {
            cVar = this.f27051j;
            socketF = f(true, false, false);
            if (this.f27051j != null) {
                cVar = null;
            }
        }
        n.d.v(socketF);
        if (cVar != null) {
            this.f27047f.p(this.f27046e, cVar);
        }
    }

    public void o() {
        com.haier.library.okhttp.b.e.c cVar;
        c cVar2;
        synchronized (this.f27045d) {
            this.f27054m = true;
            cVar = this.f27055n;
            cVar2 = this.f27051j;
        }
        if (cVar != null) {
            cVar.c();
        } else if (cVar2 != null) {
            cVar2.p();
        }
    }

    public boolean p() {
        f.a aVar;
        return this.f27044c != null || ((aVar = this.f27043b) != null && aVar.a()) || this.f27049h.e();
    }

    public String toString() {
        c cVarL = l();
        return cVarL != null ? cVarL.toString() : this.f27042a.toString();
    }
}
