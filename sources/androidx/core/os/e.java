package androidx.core.os;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f6080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f6081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6082d;

    @c.t0(16)
    static class a {
        private a() {
        }

        @c.t
        static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        @c.t
        static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface b {
        void onCancel();
    }

    private void f() {
        while (this.f6082d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f6079a) {
                return;
            }
            this.f6079a = true;
            this.f6082d = true;
            b bVar = this.f6080b;
            Object obj = this.f6081c;
            if (bVar != null) {
                try {
                    bVar.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f6082d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                a.a(obj);
            }
            synchronized (this) {
                this.f6082d = false;
                notifyAll();
            }
        }
    }

    @c.o0
    public Object b() {
        Object obj;
        synchronized (this) {
            if (this.f6081c == null) {
                CancellationSignal cancellationSignalB = a.b();
                this.f6081c = cancellationSignalB;
                if (this.f6079a) {
                    a.a(cancellationSignalB);
                }
            }
            obj = this.f6081c;
        }
        return obj;
    }

    public boolean c() {
        boolean z7;
        synchronized (this) {
            z7 = this.f6079a;
        }
        return z7;
    }

    public void d(@c.o0 b bVar) {
        synchronized (this) {
            f();
            if (this.f6080b == bVar) {
                return;
            }
            this.f6080b = bVar;
            if (this.f6079a && bVar != null) {
                bVar.onCancel();
            }
        }
    }

    public void e() {
        if (c()) {
            throw new g0();
        }
    }
}
