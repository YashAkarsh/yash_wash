package com.haier.library.okhttp;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Executor f27874g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), n.d.p("OkHttp ConnectionPool", true));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f27875h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f27877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f27878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Deque<com.haier.library.okhttp.b.d.c> f27879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final com.haier.library.okhttp.b.d.d f27880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f27881f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long jC = w.this.c(System.nanoTime());
                if (jC == -1) {
                    return;
                }
                if (jC > 0) {
                    long j7 = jC / 1000000;
                    long j8 = jC - (1000000 * j7);
                    synchronized (w.this) {
                        try {
                            w.this.wait(j7, (int) j8);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public w() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private int b(com.haier.library.okhttp.b.d.c cVar, long j7) {
        List<Reference<com.haier.library.okhttp.b.d.g>> list = cVar.f27024n;
        int i7 = 0;
        while (i7 < list.size()) {
            Reference<com.haier.library.okhttp.b.d.g> reference = list.get(i7);
            if (reference.get() != null) {
                i7++;
            } else {
                com.haier.library.okhttp.b.i.f.r().i("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((com.haier.library.okhttp.b.d.g.a) reference).f27056a);
                list.remove(i7);
                cVar.f27021k = true;
                if (list.isEmpty()) {
                    cVar.f27025o = j7 - this.f27877b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public synchronized int a() {
        int i7;
        Iterator<com.haier.library.okhttp.b.d.c> it = this.f27879d.iterator();
        i7 = 0;
        while (it.hasNext()) {
            if (it.next().f27024n.isEmpty()) {
                i7++;
            }
        }
        return i7;
    }

    long c(long j7) {
        synchronized (this) {
            com.haier.library.okhttp.b.d.c cVar = null;
            long j8 = Long.MIN_VALUE;
            int i7 = 0;
            int i8 = 0;
            for (com.haier.library.okhttp.b.d.c cVar2 : this.f27879d) {
                if (b(cVar2, j7) > 0) {
                    i8++;
                } else {
                    i7++;
                    long j9 = j7 - cVar2.f27025o;
                    if (j9 > j8) {
                        cVar = cVar2;
                        j8 = j9;
                    }
                }
            }
            long j10 = this.f27877b;
            if (j8 < j10 && i7 <= this.f27876a) {
                if (i7 > 0) {
                    return j10 - j8;
                }
                if (i8 > 0) {
                    return j10;
                }
                this.f27881f = false;
                return -1L;
            }
            this.f27879d.remove(cVar);
            n.d.v(cVar.b());
            return 0L;
        }
    }

    @Nullable
    com.haier.library.okhttp.b.d.c d(c cVar, com.haier.library.okhttp.b.d.g gVar, h hVar) {
        if (!f27875h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.haier.library.okhttp.b.d.c cVar2 : this.f27879d) {
            if (cVar2.m(cVar, hVar)) {
                gVar.g(cVar2, true);
                return cVar2;
            }
        }
        return null;
    }

    @Nullable
    Socket e(c cVar, com.haier.library.okhttp.b.d.g gVar) {
        if (!f27875h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.haier.library.okhttp.b.d.c cVar2 : this.f27879d) {
            if (cVar2.m(cVar, null) && cVar2.q() && cVar2 != gVar.l()) {
                return gVar.e(cVar2);
            }
        }
        return null;
    }

    void f(com.haier.library.okhttp.b.d.c cVar) {
        if (!f27875h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f27881f) {
            this.f27881f = true;
            f27874g.execute(this.f27878c);
        }
        this.f27879d.add(cVar);
    }

    public synchronized int g() {
        return this.f27879d.size();
    }

    boolean h(com.haier.library.okhttp.b.d.c cVar) {
        if (!f27875h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (cVar.f27021k || this.f27876a == 0) {
            this.f27879d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<com.haier.library.okhttp.b.d.c> it = this.f27879d.iterator();
            while (it.hasNext()) {
                com.haier.library.okhttp.b.d.c next = it.next();
                if (next.f27024n.isEmpty()) {
                    next.f27021k = true;
                    arrayList.add(next);
                    it.remove();
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            n.d.v(((com.haier.library.okhttp.b.d.c) it2.next()).b());
        }
    }

    public w(int i7, long j7, TimeUnit timeUnit) {
        this.f27878c = new a();
        this.f27879d = new ArrayDeque();
        this.f27880e = new com.haier.library.okhttp.b.d.d();
        this.f27876a = i7;
        this.f27877b = timeUnit.toNanos(j7);
        if (j7 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j7);
    }
}
