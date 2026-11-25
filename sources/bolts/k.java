package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class k implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f11373a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<j> f11374b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f11375c = h.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ScheduledFuture<?> f11376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11378f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (k.this.f11373a) {
                k.this.f11376d = null;
            }
            k.this.e();
        }
    }

    private void F() {
        if (this.f11378f) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void g(long j7, TimeUnit timeUnit) {
        if (j7 < -1) {
            throw new IllegalArgumentException("Delay must be >= -1");
        }
        if (j7 == 0) {
            e();
            return;
        }
        synchronized (this.f11373a) {
            if (this.f11377e) {
                return;
            }
            q();
            if (j7 != -1) {
                this.f11376d = this.f11375c.schedule(new a(), j7, timeUnit);
            }
        }
    }

    private void q() {
        ScheduledFuture<?> scheduledFuture = this.f11376d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f11376d = null;
        }
    }

    private void v(List<j> list) {
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    j C(Runnable runnable) {
        j jVar;
        synchronized (this.f11373a) {
            F();
            jVar = new j(this, runnable);
            if (this.f11377e) {
                jVar.b();
            } else {
                this.f11374b.add(jVar);
            }
        }
        return jVar;
    }

    void E() throws CancellationException {
        synchronized (this.f11373a) {
            F();
            if (this.f11377e) {
                throw new CancellationException();
            }
        }
    }

    void G(j jVar) {
        synchronized (this.f11373a) {
            F();
            this.f11374b.remove(jVar);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f11373a) {
            if (this.f11378f) {
                return;
            }
            q();
            Iterator<j> it = this.f11374b.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.f11374b.clear();
            this.f11378f = true;
        }
    }

    public void e() {
        synchronized (this.f11373a) {
            F();
            if (this.f11377e) {
                return;
            }
            q();
            this.f11377e = true;
            v(new ArrayList(this.f11374b));
        }
    }

    public void f(long j7) {
        g(j7, TimeUnit.MILLISECONDS);
    }

    public i r() {
        i iVar;
        synchronized (this.f11373a) {
            F();
            iVar = new i(this);
        }
        return iVar;
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(u()));
    }

    public boolean u() {
        boolean z7;
        synchronized (this.f11373a) {
            F();
            z7 = this.f11377e;
        }
        return z7;
    }
}
