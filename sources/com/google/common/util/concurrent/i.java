package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public abstract class i implements b2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final o1.a<b2.b> f22735h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final o1.a<b2.b> f22736i = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final o1.a<b2.b> f22737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final o1.a<b2.b> f22738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final o1.a<b2.b> f22739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final o1.a<b2.b> f22740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final o1.a<b2.b> f22741n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final o1.a<b2.b> f22742o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u1 f22743a = new u1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u1.b f22744b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u1.b f22745c = new C0298i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u1.b f22746d = new g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u1.b f22747e = new j();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final o1<b2.b> f22748f = new o1<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile k f22749g = new k(b2.c.f22549a);

    static class a implements o1.a<b2.b> {
        a() {
        }

        @Override // com.google.common.util.concurrent.o1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b2.b bVar) {
            bVar.c();
        }

        public String toString() {
            return "starting()";
        }
    }

    static class b implements o1.a<b2.b> {
        b() {
        }

        @Override // com.google.common.util.concurrent.o1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b2.b bVar) {
            bVar.b();
        }

        public String toString() {
            return "running()";
        }
    }

    static class c implements o1.a<b2.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b2.c f22750a;

        c(b2.c cVar) {
            this.f22750a = cVar;
        }

        @Override // com.google.common.util.concurrent.o1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b2.b bVar) {
            bVar.e(this.f22750a);
        }

        public String toString() {
            return "terminated({from = " + this.f22750a + "})";
        }
    }

    static class d implements o1.a<b2.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b2.c f22751a;

        d(b2.c cVar) {
            this.f22751a = cVar;
        }

        @Override // com.google.common.util.concurrent.o1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b2.b bVar) {
            bVar.d(this.f22751a);
        }

        public String toString() {
            return "stopping({from = " + this.f22751a + "})";
        }
    }

    class e implements o1.a<b2.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b2.c f22752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable f22753b;

        e(b2.c cVar, Throwable th) {
            this.f22752a = cVar;
            this.f22753b = th;
        }

        @Override // com.google.common.util.concurrent.o1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b2.b bVar) {
            bVar.a(this.f22752a, this.f22753b);
        }

        public String toString() {
            return "failed({from = " + this.f22752a + ", cause = " + this.f22753b + "})";
        }
    }

    static /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f22755a;

        static {
            int[] iArr = new int[b2.c.values().length];
            f22755a = iArr;
            try {
                iArr[b2.c.f22549a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22755a[b2.c.f22550b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22755a[b2.c.f22551c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22755a[b2.c.f22552d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22755a[b2.c.f22553e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22755a[b2.c.f22554f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private final class g extends u1.b {
        g() {
            super(i.this.f22743a);
        }

        @Override // com.google.common.util.concurrent.u1.b
        public boolean a() {
            return i.this.c().compareTo(b2.c.f22551c) >= 0;
        }
    }

    private final class h extends u1.b {
        h() {
            super(i.this.f22743a);
        }

        @Override // com.google.common.util.concurrent.u1.b
        public boolean a() {
            return i.this.c() == b2.c.f22549a;
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.i$i, reason: collision with other inner class name */
    private final class C0298i extends u1.b {
        C0298i() {
            super(i.this.f22743a);
        }

        @Override // com.google.common.util.concurrent.u1.b
        public boolean a() {
            return i.this.c().compareTo(b2.c.f22551c) <= 0;
        }
    }

    private final class j extends u1.b {
        j() {
            super(i.this.f22743a);
        }

        @Override // com.google.common.util.concurrent.u1.b
        public boolean a() {
            return i.this.c().a();
        }
    }

    private static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b2.c f22760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f22761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Throwable f22762c;

        k(b2.c cVar) {
            this(cVar, false, null);
        }

        b2.c a() {
            return (this.f22761b && this.f22760a == b2.c.f22550b) ? b2.c.f22552d : this.f22760a;
        }

        Throwable b() {
            b2.c cVar = this.f22760a;
            com.google.common.base.e0.x0(cVar == b2.c.f22554f, "failureCause() is only valid if the service has failed, service is %s", cVar);
            return this.f22762c;
        }

        k(b2.c cVar, boolean z7, Throwable th) {
            com.google.common.base.e0.u(!z7 || cVar == b2.c.f22550b, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", cVar);
            com.google.common.base.e0.y(!((cVar == b2.c.f22554f) ^ (th != null)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", cVar, th);
            this.f22760a = cVar;
            this.f22761b = z7;
            this.f22762c = th;
        }
    }

    static {
        b2.c cVar = b2.c.f22550b;
        f22737j = x(cVar);
        b2.c cVar2 = b2.c.f22551c;
        f22738k = x(cVar2);
        f22739l = y(b2.c.f22549a);
        f22740m = y(cVar);
        f22741n = y(cVar2);
        f22742o = y(b2.c.f22552d);
    }

    protected i() {
    }

    @v1.a("monitor")
    private void k(b2.c cVar) {
        b2.c cVarC = c();
        if (cVarC != cVar) {
            if (cVarC == b2.c.f22554f) {
                throw new IllegalStateException("Expected the service " + this + " to be " + cVar + ", but the service has FAILED", e());
            }
            throw new IllegalStateException("Expected the service " + this + " to be " + cVar + ", but was " + cVarC);
        }
    }

    private void l() {
        if (this.f22743a.B()) {
            return;
        }
        this.f22748f.c();
    }

    private void p(b2.c cVar, Throwable th) {
        this.f22748f.d(new e(cVar, th));
    }

    private void q() {
        this.f22748f.d(f22736i);
    }

    private void r() {
        this.f22748f.d(f22735h);
    }

    private void s(b2.c cVar) {
        if (cVar == b2.c.f22550b) {
            this.f22748f.d(f22737j);
        } else {
            if (cVar != b2.c.f22551c) {
                throw new AssertionError();
            }
            this.f22748f.d(f22738k);
        }
    }

    private void t(b2.c cVar) {
        switch (f.f22755a[cVar.ordinal()]) {
            case 1:
                this.f22748f.d(f22739l);
                return;
            case 2:
                this.f22748f.d(f22740m);
                return;
            case 3:
                this.f22748f.d(f22741n);
                return;
            case 4:
                this.f22748f.d(f22742o);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    private static o1.a<b2.b> x(b2.c cVar) {
        return new d(cVar);
    }

    private static o1.a<b2.b> y(b2.c cVar) {
        return new c(cVar);
    }

    @Override // com.google.common.util.concurrent.b2
    public final void a(b2.b bVar, Executor executor) {
        this.f22748f.b(bVar, executor);
    }

    @Override // com.google.common.util.concurrent.b2
    public final void b(long j7, TimeUnit timeUnit) throws TimeoutException {
        if (this.f22743a.r(this.f22746d, j7, timeUnit)) {
            try {
                k(b2.c.f22551c);
            } finally {
                this.f22743a.D();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
        }
    }

    @Override // com.google.common.util.concurrent.b2
    public final b2.c c() {
        return this.f22749g.a();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void d() {
        this.f22743a.q(this.f22746d);
        try {
            k(b2.c.f22551c);
        } finally {
            this.f22743a.D();
        }
    }

    @Override // com.google.common.util.concurrent.b2
    public final Throwable e() {
        return this.f22749g.b();
    }

    @Override // com.google.common.util.concurrent.b2
    public final void f(long j7, TimeUnit timeUnit) throws TimeoutException {
        if (this.f22743a.r(this.f22747e, j7, timeUnit)) {
            try {
                k(b2.c.f22553e);
            } finally {
                this.f22743a.D();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + c());
        }
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 g() {
        if (this.f22743a.i(this.f22745c)) {
            try {
                b2.c cVarC = c();
                switch (f.f22755a[cVarC.ordinal()]) {
                    case 1:
                        this.f22749g = new k(b2.c.f22553e);
                        t(b2.c.f22549a);
                        break;
                    case 2:
                        b2.c cVar = b2.c.f22550b;
                        this.f22749g = new k(cVar, true, null);
                        s(cVar);
                        m();
                        break;
                    case 3:
                        this.f22749g = new k(b2.c.f22552d);
                        s(b2.c.f22551c);
                        o();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + cVarC);
                }
            } catch (Throwable th) {
                try {
                    u(th);
                } finally {
                    this.f22743a.D();
                    l();
                }
            }
        }
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final void h() {
        this.f22743a.q(this.f22747e);
        try {
            k(b2.c.f22553e);
        } finally {
            this.f22743a.D();
        }
    }

    @Override // com.google.common.util.concurrent.b2
    @u1.a
    public final b2 i() {
        if (!this.f22743a.i(this.f22744b)) {
            throw new IllegalStateException("Service " + this + " has already been started");
        }
        try {
            this.f22749g = new k(b2.c.f22550b);
            r();
            n();
        } catch (Throwable th) {
            try {
                u(th);
            } finally {
                this.f22743a.D();
                l();
            }
        }
        return this;
    }

    @Override // com.google.common.util.concurrent.b2
    public final boolean isRunning() {
        return c() == b2.c.f22551c;
    }

    @u1.g
    protected void m() {
    }

    @u1.g
    protected abstract void n();

    @u1.g
    protected abstract void o();

    public String toString() {
        return getClass().getSimpleName() + " [" + c() + "]";
    }

    protected final void u(Throwable th) {
        com.google.common.base.e0.E(th);
        this.f22743a.g();
        try {
            b2.c cVarC = c();
            int i7 = f.f22755a[cVarC.ordinal()];
            if (i7 != 1) {
                if (i7 == 2 || i7 == 3 || i7 == 4) {
                    this.f22749g = new k(b2.c.f22554f, false, th);
                    p(cVarC, th);
                } else if (i7 != 5) {
                }
                this.f22743a.D();
                l();
                return;
            }
            throw new IllegalStateException("Failed while in state:" + cVarC, th);
        } catch (Throwable th2) {
            this.f22743a.D();
            l();
            throw th2;
        }
    }

    protected final void v() {
        this.f22743a.g();
        try {
            if (this.f22749g.f22760a != b2.c.f22550b) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f22749g.f22760a);
                u(illegalStateException);
                throw illegalStateException;
            }
            if (this.f22749g.f22761b) {
                this.f22749g = new k(b2.c.f22552d);
                o();
            } else {
                this.f22749g = new k(b2.c.f22551c);
                q();
            }
            this.f22743a.D();
            l();
        } catch (Throwable th) {
            this.f22743a.D();
            l();
            throw th;
        }
    }

    protected final void w() {
        this.f22743a.g();
        try {
            b2.c cVarC = c();
            switch (f.f22755a[cVarC.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is " + cVarC);
                case 2:
                case 3:
                case 4:
                    this.f22749g = new k(b2.c.f22553e);
                    t(cVarC);
                    break;
            }
            this.f22743a.D();
            l();
        } catch (Throwable th) {
            this.f22743a.D();
            l();
            throw th;
        }
    }
}
