package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public abstract class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f22941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f22942b;

    static abstract class a {

        /* JADX INFO: renamed from: com.google.common.util.concurrent.y1$a$a, reason: collision with other inner class name */
        static class C0301a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final com.google.common.base.n0 f22943a = com.google.common.base.n0.c();

            C0301a() {
            }

            @Override // com.google.common.util.concurrent.y1.a
            protected long b() {
                return this.f22943a.g(TimeUnit.MICROSECONDS);
            }

            @Override // com.google.common.util.concurrent.y1.a
            protected void c(long j7) {
                if (j7 > 0) {
                    p2.i(j7, TimeUnit.MICROSECONDS);
                }
            }
        }

        protected a() {
        }

        public static a a() {
            return new C0301a();
        }

        protected abstract long b();

        protected abstract void c(long j7);
    }

    y1(a aVar) {
        this.f22941a = (a) com.google.common.base.e0.E(aVar);
    }

    private boolean c(long j7, long j8) {
        return m(j7) - j8 <= j7;
    }

    private static void d(int i7) {
        com.google.common.base.e0.k(i7 > 0, "Requested permits (%s) must be positive", i7);
    }

    public static y1 e(double d8) {
        return h(d8, a.a());
    }

    public static y1 f(double d8, long j7, TimeUnit timeUnit) {
        com.google.common.base.e0.p(j7 >= 0, "warmupPeriod must not be negative: %s", j7);
        return g(d8, j7, timeUnit, 3.0d, a.a());
    }

    @s1.d
    static y1 g(double d8, long j7, TimeUnit timeUnit, double d9, a aVar) {
        f2.c cVar = new f2.c(aVar, j7, timeUnit, d9);
        cVar.q(d8);
        return cVar;
    }

    @s1.d
    static y1 h(double d8, a aVar) {
        f2.b bVar = new f2.b(aVar, 1.0d);
        bVar.q(d8);
        return bVar;
    }

    private Object l() {
        Object obj = this.f22942b;
        if (obj == null) {
            synchronized (this) {
                obj = this.f22942b;
                if (obj == null) {
                    obj = new Object();
                    this.f22942b = obj;
                }
            }
        }
        return obj;
    }

    @u1.a
    public double a() {
        return b(1);
    }

    @u1.a
    public double b(int i7) {
        long jN = n(i7);
        this.f22941a.c(jN);
        return (jN * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    abstract double i();

    abstract void j(double d8, long j7);

    public final double k() {
        double dI;
        synchronized (l()) {
            dI = i();
        }
        return dI;
    }

    abstract long m(long j7);

    final long n(int i7) {
        long jO;
        d(i7);
        synchronized (l()) {
            jO = o(i7, this.f22941a.b());
        }
        return jO;
    }

    final long o(int i7, long j7) {
        return Math.max(p(i7, j7) - j7, 0L);
    }

    abstract long p(int i7, long j7);

    public final void q(double d8) {
        com.google.common.base.e0.e(d8 > 0.0d && !Double.isNaN(d8), "rate must be positive");
        synchronized (l()) {
            j(d8, this.f22941a.b());
        }
    }

    public boolean r() {
        return t(1, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean s(int i7) {
        return t(i7, 0L, TimeUnit.MICROSECONDS);
    }

    public boolean t(int i7, long j7, TimeUnit timeUnit) {
        long jMax = Math.max(timeUnit.toMicros(j7), 0L);
        d(i7);
        synchronized (l()) {
            long jB = this.f22941a.b();
            if (!c(jB, jMax)) {
                return false;
            }
            this.f22941a.c(o(i7, jB));
            return true;
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(k()));
    }

    public boolean u(long j7, TimeUnit timeUnit) {
        return t(1, j7, timeUnit);
    }
}
