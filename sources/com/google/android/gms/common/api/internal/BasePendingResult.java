package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@KeepName
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.t> extends com.google.android.gms.common.api.n<R> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final ThreadLocal<Boolean> f15119p = new v3();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f15120q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f15121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    protected final a<R> f15122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.m0
    protected final WeakReference<com.google.android.gms.common.api.k> f15123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CountDownLatch f15124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<com.google.android.gms.common.api.n.a> f15125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.common.api.u<? super R> f15126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<h3> f15127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.o0
    private R f15128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Status f15129i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f15130j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f15132l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.o0
    private com.google.android.gms.common.internal.n f15133m;

    @KeepName
    private x3 mResultGuardian;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile g3<R> f15134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f15135o;

    @Deprecated
    BasePendingResult() {
        this.f15121a = new Object();
        this.f15124d = new CountDownLatch(1);
        this.f15125e = new ArrayList<>();
        this.f15127g = new AtomicReference<>();
        this.f15135o = false;
        this.f15122b = new a<>(Looper.getMainLooper());
        this.f15123c = new WeakReference<>(null);
    }

    private final R p() {
        R r7;
        synchronized (this.f15121a) {
            com.google.android.gms.common.internal.u.r(!this.f15130j, "Result has already been consumed.");
            com.google.android.gms.common.internal.u.r(m(), "Result is not ready.");
            r7 = this.f15128h;
            this.f15128h = null;
            this.f15126f = null;
            this.f15130j = true;
        }
        h3 andSet = this.f15127g.getAndSet(null);
        if (andSet != null) {
            andSet.f15241a.f15275a.remove(this);
        }
        return (R) com.google.android.gms.common.internal.u.k(r7);
    }

    private final void q(R r7) {
        this.f15128h = r7;
        this.f15129i = r7.G();
        w3 w3Var = null;
        this.f15133m = null;
        this.f15124d.countDown();
        if (this.f15131k) {
            this.f15126f = null;
        } else {
            com.google.android.gms.common.api.u<? super R> uVar = this.f15126f;
            if (uVar != null) {
                this.f15122b.removeMessages(2);
                this.f15122b.a(uVar, p());
            } else if (this.f15128h instanceof com.google.android.gms.common.api.p) {
                this.mResultGuardian = new x3(this, w3Var);
            }
        }
        ArrayList<com.google.android.gms.common.api.n.a> arrayList = this.f15125e;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.get(i7).a(this.f15129i);
        }
        this.f15125e.clear();
    }

    public static void t(@c.o0 com.google.android.gms.common.api.t tVar) {
        if (tVar instanceof com.google.android.gms.common.api.p) {
            try {
                ((com.google.android.gms.common.api.p) tVar).i();
            } catch (RuntimeException e8) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(tVar)), e8);
            }
        }
    }

    @Override // com.google.android.gms.common.api.n
    public final void c(@c.m0 com.google.android.gms.common.api.n.a aVar) {
        com.google.android.gms.common.internal.u.b(aVar != null, "Callback cannot be null.");
        synchronized (this.f15121a) {
            if (m()) {
                aVar.a(this.f15129i);
            } else {
                this.f15125e.add(aVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.n
    @c.m0
    public final R d() {
        com.google.android.gms.common.internal.u.j("await must not be called on the UI thread");
        com.google.android.gms.common.internal.u.r(!this.f15130j, "Result has already been consumed");
        com.google.android.gms.common.internal.u.r(this.f15134n == null, "Cannot await if then() has been called.");
        try {
            this.f15124d.await();
        } catch (InterruptedException unused) {
            l(Status.f15064g);
        }
        com.google.android.gms.common.internal.u.r(m(), "Result is not ready.");
        return (R) p();
    }

    @Override // com.google.android.gms.common.api.n
    @c.m0
    public final R e(long j7, @c.m0 TimeUnit timeUnit) {
        if (j7 > 0) {
            com.google.android.gms.common.internal.u.j("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.u.r(!this.f15130j, "Result has already been consumed.");
        com.google.android.gms.common.internal.u.r(this.f15134n == null, "Cannot await if then() has been called.");
        try {
            if (!this.f15124d.await(j7, timeUnit)) {
                l(Status.f15066i);
            }
        } catch (InterruptedException unused) {
            l(Status.f15064g);
        }
        com.google.android.gms.common.internal.u.r(m(), "Result is not ready.");
        return (R) p();
    }

    @Override // com.google.android.gms.common.api.n
    @c1.a
    public void f() {
        synchronized (this.f15121a) {
            if (!this.f15131k && !this.f15130j) {
                com.google.android.gms.common.internal.n nVar = this.f15133m;
                if (nVar != null) {
                    try {
                        nVar.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                t(this.f15128h);
                this.f15131k = true;
                q(k(Status.f15067j));
            }
        }
    }

    @Override // com.google.android.gms.common.api.n
    public final boolean g() {
        boolean z7;
        synchronized (this.f15121a) {
            z7 = this.f15131k;
        }
        return z7;
    }

    @Override // com.google.android.gms.common.api.n
    @c1.a
    public final void h(@c.o0 com.google.android.gms.common.api.u<? super R> uVar) {
        synchronized (this.f15121a) {
            try {
                if (uVar == null) {
                    this.f15126f = null;
                    return;
                }
                boolean z7 = true;
                com.google.android.gms.common.internal.u.r(!this.f15130j, "Result has already been consumed.");
                if (this.f15134n != null) {
                    z7 = false;
                }
                com.google.android.gms.common.internal.u.r(z7, "Cannot set callbacks if then() has been called.");
                if (g()) {
                    return;
                }
                if (m()) {
                    this.f15122b.a(uVar, p());
                } else {
                    this.f15126f = uVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.n
    @c1.a
    public final void i(@c.m0 com.google.android.gms.common.api.u<? super R> uVar, long j7, @c.m0 TimeUnit timeUnit) {
        synchronized (this.f15121a) {
            try {
                if (uVar == null) {
                    this.f15126f = null;
                    return;
                }
                boolean z7 = true;
                com.google.android.gms.common.internal.u.r(!this.f15130j, "Result has already been consumed.");
                if (this.f15134n != null) {
                    z7 = false;
                }
                com.google.android.gms.common.internal.u.r(z7, "Cannot set callbacks if then() has been called.");
                if (g()) {
                    return;
                }
                if (m()) {
                    this.f15122b.a(uVar, p());
                } else {
                    this.f15126f = uVar;
                    a<R> aVar = this.f15122b;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.n
    @c.m0
    public final <S extends com.google.android.gms.common.api.t> com.google.android.gms.common.api.x<S> j(@c.m0 com.google.android.gms.common.api.w<? super R, ? extends S> wVar) {
        com.google.android.gms.common.api.x<S> xVarC;
        com.google.android.gms.common.internal.u.r(!this.f15130j, "Result has already been consumed.");
        synchronized (this.f15121a) {
            com.google.android.gms.common.internal.u.r(this.f15134n == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.u.r(this.f15126f == null, "Cannot call then() if callbacks are set.");
            com.google.android.gms.common.internal.u.r(!this.f15131k, "Cannot call then() if result was canceled.");
            this.f15135o = true;
            this.f15134n = new g3<>(this.f15123c);
            xVarC = this.f15134n.c(wVar);
            if (m()) {
                this.f15122b.a(this.f15134n, p());
            } else {
                this.f15126f = this.f15134n;
            }
        }
        return xVarC;
    }

    @c1.a
    @c.m0
    protected abstract R k(@c.m0 Status status);

    @c1.a
    @Deprecated
    public final void l(@c.m0 Status status) {
        synchronized (this.f15121a) {
            if (!m()) {
                o(k(status));
                this.f15132l = true;
            }
        }
    }

    @c1.a
    public final boolean m() {
        return this.f15124d.getCount() == 0;
    }

    @c1.a
    protected final void n(@c.m0 com.google.android.gms.common.internal.n nVar) {
        synchronized (this.f15121a) {
            this.f15133m = nVar;
        }
    }

    @c1.a
    public final void o(@c.m0 R r7) {
        synchronized (this.f15121a) {
            if (this.f15132l || this.f15131k) {
                t(r7);
                return;
            }
            m();
            com.google.android.gms.common.internal.u.r(!m(), "Results have already been set");
            com.google.android.gms.common.internal.u.r(!this.f15130j, "Result has already been consumed");
            q(r7);
        }
    }

    public final void s() {
        boolean z7 = true;
        if (!this.f15135o && !f15119p.get().booleanValue()) {
            z7 = false;
        }
        this.f15135o = z7;
    }

    public final boolean u() {
        boolean zG;
        synchronized (this.f15121a) {
            if (this.f15123c.get() == null || !this.f15135o) {
                f();
            }
            zG = g();
        }
        return zG;
    }

    public final void v(@c.o0 h3 h3Var) {
        this.f15127g.set(h3Var);
    }

    @g1.d0
    public static class a<R extends com.google.android.gms.common.api.t> extends com.google.android.gms.internal.base.p {
        public a() {
            super(Looper.getMainLooper());
        }

        public final void a(@c.m0 com.google.android.gms.common.api.u<? super R> uVar, @c.m0 R r7) {
            int i7 = BasePendingResult.f15120q;
            sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.api.u) com.google.android.gms.common.internal.u.k(uVar), r7)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(@c.m0 Message message) {
            int i7 = message.what;
            if (i7 == 1) {
                Pair pair = (Pair) message.obj;
                com.google.android.gms.common.api.u uVar = (com.google.android.gms.common.api.u) pair.first;
                com.google.android.gms.common.api.t tVar = (com.google.android.gms.common.api.t) pair.second;
                try {
                    uVar.a(tVar);
                    return;
                } catch (RuntimeException e8) {
                    BasePendingResult.t(tVar);
                    throw e8;
                }
            }
            if (i7 == 2) {
                ((BasePendingResult) message.obj).l(Status.f15066i);
                return;
            }
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i7);
            Log.wtf("BasePendingResult", sb.toString(), new Exception());
        }

        public a(@c.m0 Looper looper) {
            super(looper);
        }
    }

    @c1.a
    @Deprecated
    protected BasePendingResult(@c.m0 Looper looper) {
        this.f15121a = new Object();
        this.f15124d = new CountDownLatch(1);
        this.f15125e = new ArrayList<>();
        this.f15127g = new AtomicReference<>();
        this.f15135o = false;
        this.f15122b = new a<>(looper);
        this.f15123c = new WeakReference<>(null);
    }

    @c1.a
    protected BasePendingResult(@c.o0 com.google.android.gms.common.api.k kVar) {
        this.f15121a = new Object();
        this.f15124d = new CountDownLatch(1);
        this.f15125e = new ArrayList<>();
        this.f15127g = new AtomicReference<>();
        this.f15135o = false;
        this.f15122b = new a<>(kVar != null ? kVar.r() : Looper.getMainLooper());
        this.f15123c = new WeakReference<>(kVar);
    }

    @g1.d0
    @c1.a
    protected BasePendingResult(@c.m0 a<R> aVar) {
        this.f15121a = new Object();
        this.f15124d = new CountDownLatch(1);
        this.f15125e = new ArrayList<>();
        this.f15127g = new AtomicReference<>();
        this.f15135o = false;
        this.f15122b = (a) com.google.android.gms.common.internal.u.l(aVar, "CallbackHandler must not be null");
        this.f15123c = new WeakReference<>(null);
    }
}
