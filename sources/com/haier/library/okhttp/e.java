package com.haier.library.okhttp;

import androidx.core.app.l2;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class e implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final l0 f27523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.haier.library.okhttp.b.e.j f27524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.haier.library.a.a f27525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private d0 f27526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final f f27527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f27528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27529g;

    class a extends com.haier.library.a.a {
        a() {
        }

        @Override // com.haier.library.a.a
        protected void n() {
            e.this.c();
        }
    }

    final class b extends n.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f27531d = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r f27532b;

        b(r rVar) {
            super("OkHttp %s", e.this.j());
            this.f27532b = rVar;
        }

        @Override // com.haier.library.okhttp.n.c
        protected void k() {
            boolean z7;
            IOException e8;
            e.this.f27525c.u();
            try {
                try {
                    z7 = true;
                    try {
                        this.f27532b.b(e.this, e.this.k());
                    } catch (IOException e9) {
                        e8 = e9;
                        IOException iOExceptionC = e.this.c(e8);
                        if (z7) {
                            com.haier.library.okhttp.b.i.f.r().h(4, "Callback failure for " + e.this.i(), iOExceptionC);
                        } else {
                            e.this.f27526d.h(e.this, iOExceptionC);
                            this.f27532b.a(e.this, iOExceptionC);
                        }
                    }
                } finally {
                    e.this.f27523a.E().i(this);
                }
            } catch (IOException e10) {
                z7 = false;
                e8 = e10;
            }
        }

        String l() {
            return e.this.f27527e.a().F();
        }

        void m(ExecutorService executorService) {
            if (!f27531d && Thread.holdsLock(e.this.f27523a.E())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e8) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e8);
                    e.this.f27526d.h(e.this, interruptedIOException);
                    this.f27532b.a(e.this, interruptedIOException);
                    e.this.f27523a.E().i(this);
                }
            } catch (Throwable th) {
                e.this.f27523a.E().i(this);
                throw th;
            }
        }

        f n() {
            return e.this.f27527e;
        }

        e o() {
            return e.this;
        }
    }

    private e(l0 l0Var, f fVar, boolean z7) {
        this.f27523a = l0Var;
        this.f27527e = fVar;
        this.f27528f = z7;
        this.f27524b = new com.haier.library.okhttp.b.e.j(l0Var, z7);
        a aVar = new a();
        this.f27525c = aVar;
        aVar.b(l0Var.i(), TimeUnit.MILLISECONDS);
    }

    static e a(l0 l0Var, f fVar, boolean z7) {
        e eVar = new e(l0Var, fVar, z7);
        eVar.f27526d = l0Var.e().a(eVar);
        return eVar;
    }

    private void l() {
        this.f27524b.f(com.haier.library.okhttp.b.i.f.r().d("response.body().close()"));
    }

    @Override // com.haier.library.okhttp.q
    public boolean K() {
        return this.f27524b.k();
    }

    @Nullable
    IOException c(@Nullable IOException iOException) {
        if (!this.f27525c.r()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(com.alipay.sdk.data.a.f13674p);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Override // com.haier.library.okhttp.q
    public synchronized boolean d() {
        return this.f27529g;
    }

    @Override // com.haier.library.okhttp.q
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e g() {
        return a(this.f27523a, this.f27527e, this.f27528f);
    }

    @Override // com.haier.library.okhttp.q
    public com.haier.library.a.d0 f() {
        return this.f27525c;
    }

    com.haier.library.okhttp.b.d.g h() {
        return this.f27524b.l();
    }

    String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(K() ? "canceled " : "");
        sb.append(this.f27528f ? "web socket" : l2.f5208p0);
        sb.append(" to ");
        sb.append(j());
        return sb.toString();
    }

    String j() {
        return this.f27527e.a().R();
    }

    com.haier.library.okhttp.a k() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f27523a.H());
        arrayList.add(this.f27524b);
        arrayList.add(new com.haier.library.okhttp.b.e.a(this.f27523a.q()));
        arrayList.add(new com.haier.library.okhttp.b.b.a(this.f27523a.s()));
        arrayList.add(new com.haier.library.okhttp.b.d.a(this.f27523a));
        if (!this.f27528f) {
            arrayList.addAll(this.f27523a.I());
        }
        arrayList.add(new com.haier.library.okhttp.b.e.b(this.f27528f));
        com.haier.library.okhttp.a aVarA = new com.haier.library.okhttp.b.e.g(arrayList, null, null, null, 0, this.f27527e, this, this.f27526d, this.f27523a.k(), this.f27523a.l(), this.f27523a.m()).a(this.f27527e);
        if (!this.f27524b.k()) {
            return aVarA;
        }
        n.d.s(aVarA);
        throw new IOException("Canceled");
    }

    @Override // com.haier.library.okhttp.q
    public void p0(r rVar) {
        synchronized (this) {
            if (this.f27529g) {
                throw new IllegalStateException("Already Executed");
            }
            this.f27529g = true;
        }
        l();
        this.f27526d.b(this);
        this.f27523a.E().c(new b(rVar));
    }

    @Override // com.haier.library.okhttp.q
    public com.haier.library.okhttp.a b() throws IOException {
        synchronized (this) {
            if (this.f27529g) {
                throw new IllegalStateException("Already Executed");
            }
            this.f27529g = true;
        }
        l();
        this.f27525c.u();
        this.f27526d.b(this);
        try {
            try {
                this.f27523a.E().d(this);
                com.haier.library.okhttp.a aVarK = k();
                if (aVarK == null) {
                    throw new IOException("Canceled");
                }
                this.f27523a.E().j(this);
                return aVarK;
            } catch (IOException e8) {
                IOException iOExceptionC = c(e8);
                this.f27526d.h(this, iOExceptionC);
                throw iOExceptionC;
            }
        } catch (Throwable th) {
            this.f27523a.E().j(this);
            throw th;
        }
        this.f27523a.E().j(this);
        throw th;
    }

    @Override // com.haier.library.okhttp.q
    public f a() {
        return this.f27527e;
    }

    @Override // com.haier.library.okhttp.q
    public void c() {
        this.f27524b.e();
    }
}
