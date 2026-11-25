package com.google.common.util.concurrent;

import com.google.common.collect.cd;
import com.google.common.collect.ck;
import com.google.common.collect.d7;
import com.google.common.collect.e9;
import com.google.common.collect.h3;
import com.google.common.collect.h8;
import com.google.common.collect.hd;
import com.google.common.collect.ib;
import com.google.common.collect.td;
import com.google.common.collect.u8;
import com.google.common.collect.uc;
import com.google.common.collect.ue;
import com.google.common.collect.v7;
import com.google.common.collect.wb;
import com.google.common.collect.x6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class c2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f22563c = Logger.getLogger(c2.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final o1.a<e> f22564d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final o1.a<e> f22565e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f22566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d7<b2> f22567b;

    static class a implements o1.a<e> {
        a() {
        }

        @Override // com.google.common.util.concurrent.o1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            eVar.b();
        }

        public String toString() {
            return "healthy()";
        }
    }

    static class b implements o1.a<e> {
        b() {
        }

        @Override // com.google.common.util.concurrent.o1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(e eVar) {
            eVar.c();
        }

        public String toString() {
            return "stopped()";
        }
    }

    private static final class c extends Throwable {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    private static final class d extends Throwable {
        d(b2 b2Var) {
            super(b2Var.toString(), b2Var.e(), false, false);
        }
    }

    @s1.a
    public static abstract class e {
        public void a(b2 b2Var) {
        }

        public void b() {
        }

        public void c() {
        }
    }

    private static final class f extends i {
        private f() {
        }

        @Override // com.google.common.util.concurrent.i
        protected void n() {
            v();
        }

        @Override // com.google.common.util.concurrent.i
        protected void o() {
            w();
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    private static final class g extends b2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b2 f22568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WeakReference<h> f22569b;

        g(b2 b2Var, WeakReference<h> weakReference) {
            this.f22568a = b2Var;
            this.f22569b = weakReference;
        }

        @Override // com.google.common.util.concurrent.b2.b
        public void a(b2.c cVar, Throwable th) {
            h hVar = this.f22569b.get();
            if (hVar != null) {
                if ((!(this.f22568a instanceof f)) & (cVar != b2.c.f22550b)) {
                    c2.f22563c.log(Level.SEVERE, "Service " + this.f22568a + " has failed in the " + cVar + " state.", th);
                }
                hVar.n(this.f22568a, cVar, b2.c.f22554f);
            }
        }

        @Override // com.google.common.util.concurrent.b2.b
        public void b() {
            h hVar = this.f22569b.get();
            if (hVar != null) {
                hVar.n(this.f22568a, b2.c.f22550b, b2.c.f22551c);
            }
        }

        @Override // com.google.common.util.concurrent.b2.b
        public void c() {
            h hVar = this.f22569b.get();
            if (hVar != null) {
                hVar.n(this.f22568a, b2.c.f22549a, b2.c.f22550b);
                if (this.f22568a instanceof f) {
                    return;
                }
                c2.f22563c.log(Level.FINE, "Starting {0}.", this.f22568a);
            }
        }

        @Override // com.google.common.util.concurrent.b2.b
        public void d(b2.c cVar) {
            h hVar = this.f22569b.get();
            if (hVar != null) {
                hVar.n(this.f22568a, cVar, b2.c.f22552d);
            }
        }

        @Override // com.google.common.util.concurrent.b2.b
        public void e(b2.c cVar) {
            h hVar = this.f22569b.get();
            if (hVar != null) {
                if (!(this.f22568a instanceof f)) {
                    c2.f22563c.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f22568a, cVar});
                }
                hVar.n(this.f22568a, cVar, b2.c.f22553e);
            }
        }
    }

    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final u1 f22570a = new u1();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @v1.a("monitor")
        final ue<b2.c, b2> f22571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @v1.a("monitor")
        final hd<b2.c> f22572c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @v1.a("monitor")
        final Map<b2, com.google.common.base.n0> f22573d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @v1.a("monitor")
        boolean f22574e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @v1.a("monitor")
        boolean f22575f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f22576g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final u1.b f22577h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final u1.b f22578i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final o1<e> f22579j;

        class a implements com.google.common.base.s<Map.Entry<b2, Long>, Long> {
            a() {
            }

            @Override // com.google.common.base.s, java.util.function.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long apply(Map.Entry<b2, Long> entry) {
                return entry.getValue();
            }
        }

        class b implements o1.a<e> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b2 f22581a;

            b(b2 b2Var) {
                this.f22581a = b2Var;
            }

            @Override // com.google.common.util.concurrent.o1.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(e eVar) {
                eVar.a(this.f22581a);
            }

            public String toString() {
                return "failed({service=" + this.f22581a + "})";
            }
        }

        final class c extends u1.b {
            c() {
                super(h.this.f22570a);
            }

            @Override // com.google.common.util.concurrent.u1.b
            @v1.a("ServiceManagerState.this.monitor")
            public boolean a() {
                int iL0 = h.this.f22572c.l0(b2.c.f22551c);
                h hVar = h.this;
                return iL0 == hVar.f22576g || hVar.f22572c.contains(b2.c.f22552d) || h.this.f22572c.contains(b2.c.f22553e) || h.this.f22572c.contains(b2.c.f22554f);
            }
        }

        final class d extends u1.b {
            d() {
                super(h.this.f22570a);
            }

            @Override // com.google.common.util.concurrent.u1.b
            @v1.a("ServiceManagerState.this.monitor")
            public boolean a() {
                return h.this.f22572c.l0(b2.c.f22553e) + h.this.f22572c.l0(b2.c.f22554f) == h.this.f22576g;
            }
        }

        h(x6<b2> x6Var) {
            ue<b2.c, b2> ueVarA = uc.c(b2.c.class).g().a();
            this.f22571b = ueVarA;
            this.f22572c = ueVarA.keys();
            this.f22573d = wb.l0();
            this.f22577h = new c();
            this.f22578i = new d();
            this.f22579j = new o1<>();
            this.f22576g = x6Var.size();
            ueVarA.putAll(b2.c.f22549a, x6Var);
        }

        void a(e eVar, Executor executor) {
            this.f22579j.b(eVar, executor);
        }

        void b() {
            this.f22570a.q(this.f22577h);
            try {
                f();
            } finally {
                this.f22570a.D();
            }
        }

        void c(long j7, TimeUnit timeUnit) throws TimeoutException {
            this.f22570a.g();
            try {
                if (this.f22570a.O(this.f22577h, j7, timeUnit)) {
                    f();
                    this.f22570a.D();
                } else {
                    throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + cd.r(this.f22571b, com.google.common.base.h0.n(u8.D(b2.c.f22549a, b2.c.f22550b))));
                }
            } catch (Throwable th) {
                this.f22570a.D();
                throw th;
            }
        }

        void d() {
            this.f22570a.q(this.f22578i);
            this.f22570a.D();
        }

        void e(long j7, TimeUnit timeUnit) throws TimeoutException {
            this.f22570a.g();
            try {
                if (this.f22570a.O(this.f22578i, j7, timeUnit)) {
                    this.f22570a.D();
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + cd.r(this.f22571b, com.google.common.base.h0.q(com.google.common.base.h0.n(EnumSet.of(b2.c.f22553e, b2.c.f22554f)))));
            } catch (Throwable th) {
                this.f22570a.D();
                throw th;
            }
        }

        @v1.a("monitor")
        void f() {
            hd<b2.c> hdVar = this.f22572c;
            b2.c cVar = b2.c.f22551c;
            if (hdVar.l0(cVar) != this.f22576g) {
                IllegalStateException illegalStateException = new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + cd.r(this.f22571b, com.google.common.base.h0.q(com.google.common.base.h0.m(cVar))));
                Iterator<b2> it = this.f22571b.get(b2.c.f22554f).iterator();
                while (it.hasNext()) {
                    illegalStateException.addSuppressed(new d(it.next()));
                }
                throw illegalStateException;
            }
        }

        void g() {
            com.google.common.base.e0.h0(!this.f22570a.B(), "It is incorrect to execute listeners with the monitor held.");
            this.f22579j.c();
        }

        void h(b2 b2Var) {
            this.f22579j.d(new b(b2Var));
        }

        void i() {
            this.f22579j.d(c2.f22564d);
        }

        void j() {
            this.f22579j.d(c2.f22565e);
        }

        void k() {
            this.f22570a.g();
            try {
                if (!this.f22575f) {
                    this.f22574e = true;
                    this.f22570a.D();
                    return;
                }
                ArrayList arrayListQ = ib.q();
                ck<b2> it = l().values().iterator();
                while (it.hasNext()) {
                    b2 next = it.next();
                    if (next.c() != b2.c.f22549a) {
                        arrayListQ.add(next);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + arrayListQ);
            } catch (Throwable th) {
                this.f22570a.D();
                throw th;
            }
        }

        h8<b2.c, b2> l() {
            e9.a aVarB0 = e9.b0();
            this.f22570a.g();
            try {
                for (Map.Entry<b2.c, b2> entry : this.f22571b.y()) {
                    if (!(entry.getValue() instanceof f)) {
                        aVarB0.g(entry);
                    }
                }
                this.f22570a.D();
                return aVarB0.a();
            } catch (Throwable th) {
                this.f22570a.D();
                throw th;
            }
        }

        v7<b2, Long> m() {
            this.f22570a.g();
            try {
                ArrayList arrayListU = ib.u(this.f22573d.size());
                for (Map.Entry<b2, com.google.common.base.n0> entry : this.f22573d.entrySet()) {
                    b2 key = entry.getKey();
                    com.google.common.base.n0 value = entry.getValue();
                    if (!value.j() && !(key instanceof f)) {
                        arrayListU.add(wb.T(key, Long.valueOf(value.g(TimeUnit.MILLISECONDS))));
                    }
                }
                this.f22570a.D();
                Collections.sort(arrayListU, td.A().E(new a()));
                return v7.f(arrayListU);
            } catch (Throwable th) {
                this.f22570a.D();
                throw th;
            }
        }

        void n(b2 b2Var, b2.c cVar, b2.c cVar2) {
            com.google.common.base.e0.E(b2Var);
            com.google.common.base.e0.d(cVar != cVar2);
            this.f22570a.g();
            try {
                this.f22575f = true;
                if (this.f22574e) {
                    com.google.common.base.e0.B0(this.f22571b.remove(cVar, b2Var), "Service %s not at the expected location in the state map %s", b2Var, cVar);
                    com.google.common.base.e0.B0(this.f22571b.put(cVar2, b2Var), "Service %s in the state map unexpectedly at %s", b2Var, cVar2);
                    com.google.common.base.n0 n0VarC = this.f22573d.get(b2Var);
                    if (n0VarC == null) {
                        n0VarC = com.google.common.base.n0.c();
                        this.f22573d.put(b2Var, n0VarC);
                    }
                    b2.c cVar3 = b2.c.f22551c;
                    if (cVar2.compareTo(cVar3) >= 0 && n0VarC.j()) {
                        n0VarC.m();
                        if (!(b2Var instanceof f)) {
                            c2.f22563c.log(Level.FINE, "Started {0} in {1}.", new Object[]{b2Var, n0VarC});
                        }
                    }
                    b2.c cVar4 = b2.c.f22554f;
                    if (cVar2 == cVar4) {
                        h(b2Var);
                    }
                    if (this.f22572c.l0(cVar3) == this.f22576g) {
                        i();
                    } else if (this.f22572c.l0(b2.c.f22553e) + this.f22572c.l0(cVar4) == this.f22576g) {
                        j();
                    }
                }
            } finally {
                this.f22570a.D();
                g();
            }
        }

        void o(b2 b2Var) {
            this.f22570a.g();
            try {
                if (this.f22573d.get(b2Var) == null) {
                    this.f22573d.put(b2Var, com.google.common.base.n0.c());
                }
            } finally {
                this.f22570a.D();
            }
        }
    }

    public c2(Iterable<? extends b2> iterable) {
        d7<b2> d7VarP = d7.p(iterable);
        if (d7VarP.isEmpty()) {
            a aVar = null;
            f22563c.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new c(aVar));
            d7VarP = d7.z(new f(aVar));
        }
        h hVar = new h(d7VarP);
        this.f22566a = hVar;
        this.f22567b = d7VarP;
        WeakReference weakReference = new WeakReference(hVar);
        ck<b2> it = d7VarP.iterator();
        while (it.hasNext()) {
            b2 next = it.next();
            next.a(new g(next, weakReference), v1.c());
            com.google.common.base.e0.u(next.c() == b2.c.f22549a, "Can only manage NEW services, %s", next);
        }
        this.f22566a.k();
    }

    public void d(e eVar) {
        this.f22566a.a(eVar, v1.c());
    }

    public void e(e eVar, Executor executor) {
        this.f22566a.a(eVar, executor);
    }

    public void f() {
        this.f22566a.b();
    }

    public void g(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22566a.c(j7, timeUnit);
    }

    public void h() {
        this.f22566a.d();
    }

    public void i(long j7, TimeUnit timeUnit) throws TimeoutException {
        this.f22566a.e(j7, timeUnit);
    }

    public boolean j() {
        ck<b2> it = this.f22567b.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    public h8<b2.c, b2> k() {
        return this.f22566a.l();
    }

    @u1.a
    public c2 l() {
        ck<b2> it = this.f22567b.iterator();
        while (it.hasNext()) {
            b2 next = it.next();
            b2.c cVarC = next.c();
            com.google.common.base.e0.B0(cVarC == b2.c.f22549a, "Service %s is %s, cannot start it.", next, cVarC);
        }
        ck<b2> it2 = this.f22567b.iterator();
        while (it2.hasNext()) {
            b2 next2 = it2.next();
            try {
                this.f22566a.o(next2);
                next2.i();
            } catch (IllegalStateException e8) {
                f22563c.log(Level.WARNING, "Unable to start Service " + next2, (Throwable) e8);
            }
        }
        return this;
    }

    public v7<b2, Long> m() {
        return this.f22566a.m();
    }

    @u1.a
    public c2 n() {
        ck<b2> it = this.f22567b.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
        return this;
    }

    public String toString() {
        return com.google.common.base.x.b(c2.class).f("services", h3.d(this.f22567b, com.google.common.base.h0.q(com.google.common.base.h0.o(f.class)))).toString();
    }
}
