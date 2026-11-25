package org.junit.rules;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f39931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f39932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long f39933c;

    static class b {
        b() {
        }

        public long a() {
            return System.nanoTime();
        }
    }

    private class c extends m {
        private c() {
        }

        @Override // org.junit.rules.m
        protected void g(Throwable th, org.junit.runner.c cVar) {
            i.this.k();
            i iVar = i.this;
            iVar.e(iVar.g(), th, cVar);
        }

        @Override // org.junit.rules.m
        protected void i(org.junit.runner.c cVar) {
            i iVar = i.this;
            iVar.f(iVar.g(), cVar);
        }

        @Override // org.junit.rules.m
        protected void k(org.junit.e eVar, org.junit.runner.c cVar) {
            i.this.k();
            i iVar = i.this;
            iVar.i(iVar.g(), eVar, cVar);
        }

        @Override // org.junit.rules.m
        protected void n(org.junit.runner.c cVar) {
            i.this.j();
        }

        @Override // org.junit.rules.m
        protected void p(org.junit.runner.c cVar) {
            i.this.k();
            i iVar = i.this;
            iVar.l(iVar.g(), cVar);
        }
    }

    public i() {
        this(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g() {
        if (this.f39932b == 0) {
            throw new IllegalStateException("Test has not started");
        }
        long jA = this.f39933c;
        if (jA == 0) {
            jA = this.f39931a.a();
        }
        return jA - this.f39932b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f39932b = this.f39931a.a();
        this.f39933c = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f39933c = this.f39931a.a();
    }

    @Override // org.junit.rules.l
    public final org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        return new c().a(jVar, cVar);
    }

    protected void e(long j7, Throwable th, org.junit.runner.c cVar) {
    }

    protected void f(long j7, org.junit.runner.c cVar) {
    }

    public long h(TimeUnit timeUnit) {
        return timeUnit.convert(g(), TimeUnit.NANOSECONDS);
    }

    protected void i(long j7, org.junit.e eVar, org.junit.runner.c cVar) {
    }

    protected void l(long j7, org.junit.runner.c cVar) {
    }

    i(b bVar) {
        this.f39931a = bVar;
    }
}
