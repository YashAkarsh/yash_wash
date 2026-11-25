package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.g0;
import androidx.core.util.h0;
import c.m0;
import c.o0;
import c.x0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<D> extends c<D> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final String f8387p = "AsyncTaskLoader";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final boolean f8388q = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Executor f8389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile a<D>.RunnableC0105a f8390k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    volatile a<D>.RunnableC0105a f8391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    long f8392m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    long f8393n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Handler f8394o;

    /* JADX INFO: renamed from: androidx.loader.content.a$a, reason: collision with other inner class name */
    final class RunnableC0105a extends d<Void, Void, D> implements Runnable {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final CountDownLatch f8395q = new CountDownLatch(1);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f8396r;

        RunnableC0105a() {
        }

        @Override // androidx.loader.content.d
        protected void m(D d8) {
            try {
                a.this.E(this, d8);
            } finally {
                this.f8395q.countDown();
            }
        }

        @Override // androidx.loader.content.d
        protected void n(D d8) {
            try {
                a.this.F(this, d8);
            } finally {
                this.f8395q.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8396r = false;
            a.this.G();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.content.d
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public D b(Void... voidArr) {
            try {
                return (D) a.this.K();
            } catch (g0 e8) {
                if (k()) {
                    return null;
                }
                throw e8;
            }
        }

        public void v() {
            try {
                this.f8395q.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public a(@m0 Context context) {
        this(context, d.f8422l);
    }

    public void D() {
    }

    void E(a<D>.RunnableC0105a runnableC0105a, D d8) {
        J(d8);
        if (this.f8391l == runnableC0105a) {
            x();
            this.f8393n = SystemClock.uptimeMillis();
            this.f8391l = null;
            e();
            G();
        }
    }

    void F(a<D>.RunnableC0105a runnableC0105a, D d8) {
        if (this.f8390k != runnableC0105a) {
            E(runnableC0105a, d8);
            return;
        }
        if (k()) {
            J(d8);
            return;
        }
        c();
        this.f8393n = SystemClock.uptimeMillis();
        this.f8390k = null;
        f(d8);
    }

    void G() {
        if (this.f8391l != null || this.f8390k == null) {
            return;
        }
        if (this.f8390k.f8396r) {
            this.f8390k.f8396r = false;
            this.f8394o.removeCallbacks(this.f8390k);
        }
        if (this.f8392m <= 0 || SystemClock.uptimeMillis() >= this.f8393n + this.f8392m) {
            this.f8390k.e(this.f8389j, null);
        } else {
            this.f8390k.f8396r = true;
            this.f8394o.postAtTime(this.f8390k, this.f8393n + this.f8392m);
        }
    }

    public boolean H() {
        return this.f8391l != null;
    }

    @o0
    public abstract D I();

    public void J(@o0 D d8) {
    }

    @o0
    protected D K() {
        return I();
    }

    public void L(long j7) {
        this.f8392m = j7;
        if (j7 != 0) {
            this.f8394o = new Handler();
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void M() {
        a<D>.RunnableC0105a runnableC0105a = this.f8390k;
        if (runnableC0105a != null) {
            runnableC0105a.v();
        }
    }

    @Override // androidx.loader.content.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f8390k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f8390k);
            printWriter.print(" waiting=");
            printWriter.println(this.f8390k.f8396r);
        }
        if (this.f8391l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f8391l);
            printWriter.print(" waiting=");
            printWriter.println(this.f8391l.f8396r);
        }
        if (this.f8392m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            h0.c(this.f8392m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            h0.b(this.f8393n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // androidx.loader.content.c
    protected boolean o() {
        if (this.f8390k == null) {
            return false;
        }
        if (!this.f8410e) {
            this.f8413h = true;
        }
        if (this.f8391l != null) {
            if (this.f8390k.f8396r) {
                this.f8390k.f8396r = false;
                this.f8394o.removeCallbacks(this.f8390k);
            }
            this.f8390k = null;
            return false;
        }
        if (this.f8390k.f8396r) {
            this.f8390k.f8396r = false;
            this.f8394o.removeCallbacks(this.f8390k);
            this.f8390k = null;
            return false;
        }
        boolean zA = this.f8390k.a(false);
        if (zA) {
            this.f8391l = this.f8390k;
            D();
        }
        this.f8390k = null;
        return zA;
    }

    @Override // androidx.loader.content.c
    protected void q() {
        super.q();
        b();
        this.f8390k = new RunnableC0105a();
        G();
    }

    private a(@m0 Context context, @m0 Executor executor) {
        super(context);
        this.f8393n = -10000L;
        this.f8389j = executor;
    }
}
