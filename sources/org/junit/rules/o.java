package org.junit.rules;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class o implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f39944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeUnit f39945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f39946c;

    class a extends org.junit.runners.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Exception f39947a;

        a(Exception exc) {
            this.f39947a = exc;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            throw new RuntimeException("Invalid parameters for Timeout", this.f39947a);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f39949a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f39950b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TimeUnit f39951c = TimeUnit.SECONDS;

        protected b() {
        }

        public o a() {
            return new o(this);
        }

        protected boolean b() {
            return this.f39949a;
        }

        protected TimeUnit c() {
            return this.f39951c;
        }

        protected long d() {
            return this.f39950b;
        }

        public b e(boolean z7) {
            this.f39949a = z7;
            return this;
        }

        public b f(long j7, TimeUnit timeUnit) {
            this.f39950b = j7;
            this.f39951c = timeUnit;
            return this;
        }
    }

    @Deprecated
    public o(int i7) {
        this(i7, TimeUnit.MILLISECONDS);
    }

    public static b b() {
        return new b();
    }

    public static o f(long j7) {
        return new o(j7, TimeUnit.MILLISECONDS);
    }

    public static o g(long j7) {
        return new o(j7, TimeUnit.SECONDS);
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.j a(org.junit.runners.model.j jVar, org.junit.runner.c cVar) {
        try {
            return c(jVar);
        } catch (Exception e8) {
            return new a(e8);
        }
    }

    protected org.junit.runners.model.j c(org.junit.runners.model.j jVar) throws Exception {
        return org.junit.internal.runners.statements.c.c().f(this.f39944a, this.f39945b).e(this.f39946c).d(jVar);
    }

    protected final boolean d() {
        return this.f39946c;
    }

    protected final long e(TimeUnit timeUnit) {
        return timeUnit.convert(this.f39944a, this.f39945b);
    }

    public o(long j7, TimeUnit timeUnit) {
        this.f39944a = j7;
        this.f39945b = timeUnit;
        this.f39946c = false;
    }

    protected o(b bVar) {
        this.f39944a = bVar.d();
        this.f39945b = bVar.c();
        this.f39946c = bVar.b();
    }
}
