package com.google.common.util.concurrent;

import com.google.common.collect.ck;
import com.google.common.collect.x6;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
abstract class k<InputT, OutputT> extends d.j<OutputT> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Logger f22790j = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k<InputT, OutputT>.a f22791i;

    abstract class a extends l implements Runnable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private x6<? extends l1<? extends InputT>> f22792e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f22793f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f22794g;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.k$a$a, reason: collision with other inner class name */
        class RunnableC0299a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f22796a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l1 f22797b;

            RunnableC0299a(int i7, l1 l1Var) {
                this.f22796a = i7;
                this.f22797b = l1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.p(this.f22796a, this.f22797b);
                } finally {
                    a.this.m();
                }
            }
        }

        a(x6<? extends l1<? extends InputT>> x6Var, boolean z7, boolean z8) {
            super(x6Var.size());
            this.f22792e = (x6) com.google.common.base.e0.E(x6Var);
            this.f22793f = z7;
            this.f22794g = z8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m() {
            int iF = f();
            com.google.common.base.e0.h0(iF >= 0, "Less than 0 remaining futures");
            if (iF == 0) {
                s();
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0029 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:13:0x002b  */
        /* JADX WARN: Code duplicated, block: B:14:0x002e  */
        /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
        private void o(Throwable th) {
            boolean zB;
            boolean zK;
            boolean z7;
            String str;
            com.google.common.base.e0.E(th);
            if (this.f22793f) {
                zB = k.this.B(th);
                if (zB) {
                    t();
                } else {
                    zK = k.K(g(), th);
                }
                z7 = th instanceof Error;
                if (((!zB) & this.f22793f & zK) || z7) {
                    if (z7) {
                        str = "Input Future failed with Error";
                    } else {
                        str = "Got more than one input Future failure. Logging failures after the first";
                    }
                    k.f22790j.log(Level.SEVERE, str, th);
                }
            }
            zB = false;
            zK = true;
            z7 = th instanceof Error;
            if (((!zB) & this.f22793f & zK) || z7) {
                if (z7) {
                    str = "Input Future failed with Error";
                } else {
                    str = "Got more than one input Future failure. Logging failures after the first";
                }
                k.f22790j.log(Level.SEVERE, str, th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void p(int i7, Future<? extends InputT> future) {
            com.google.common.base.e0.h0(this.f22793f || !k.this.isDone() || k.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                com.google.common.base.e0.h0(future.isDone(), "Tried to set value from future which is not done");
                if (this.f22793f) {
                    if (future.isCancelled()) {
                        k.this.f22791i = null;
                        k.this.cancel(false);
                    } else {
                        Object objH = e1.h(future);
                        if (this.f22794g) {
                            l(this.f22793f, i7, objH);
                        }
                    }
                } else if (this.f22794g && !future.isCancelled()) {
                    l(this.f22793f, i7, e1.h(future));
                }
            } catch (ExecutionException e8) {
                o(e8.getCause());
            } catch (Throwable th) {
                o(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            if (this.f22792e.isEmpty()) {
                n();
                return;
            }
            if (!this.f22793f) {
                ck<? extends l1<? extends InputT>> it = this.f22792e.iterator();
                while (it.hasNext()) {
                    it.next().I(this, v1.c());
                }
                return;
            }
            ck<? extends l1<? extends InputT>> it2 = this.f22792e.iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                l1<? extends InputT> next = it2.next();
                next.I(new RunnableC0299a(i7, next), v1.c());
                i7++;
            }
        }

        private void s() {
            if (this.f22794g & (!this.f22793f)) {
                ck<? extends l1<? extends InputT>> it = this.f22792e.iterator();
                int i7 = 0;
                while (it.hasNext()) {
                    p(i7, it.next());
                    i7++;
                }
            }
            n();
        }

        @Override // com.google.common.util.concurrent.l
        final void e(Set<Throwable> set) {
            if (k.this.isCancelled()) {
                return;
            }
            k.K(set, k.this.a());
        }

        abstract void l(boolean z7, int i7, InputT inputt);

        abstract void n();

        void r() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m();
        }

        @u1.n
        @u1.g
        void t() {
            this.f22792e = null;
        }
    }

    k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean K(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    final void L(k<InputT, OutputT>.a aVar) {
        this.f22791i = aVar;
        aVar.q();
    }

    @Override // com.google.common.util.concurrent.d
    protected final void m() {
        super.m();
        k<InputT, OutputT>.a aVar = this.f22791i;
        if (aVar != null) {
            this.f22791i = null;
            x6 x6Var = ((a) aVar).f22792e;
            boolean zE = E();
            if (zE) {
                aVar.r();
            }
            if (isCancelled() && (x6Var != null)) {
                ck it = x6Var.iterator();
                while (it.hasNext()) {
                    ((l1) it.next()).cancel(zE);
                }
            }
        }
    }

    @Override // com.google.common.util.concurrent.d
    protected String x() {
        x6 x6Var;
        k<InputT, OutputT>.a aVar = this.f22791i;
        if (aVar == null || (x6Var = ((a) aVar).f22792e) == null) {
            return null;
        }
        return "futures=[" + x6Var + "]";
    }
}
