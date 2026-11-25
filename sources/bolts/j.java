package bolts;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f11369a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f11370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f11371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11372d;

    j(k kVar, Runnable runnable) {
        this.f11370b = kVar;
        this.f11371c = runnable;
    }

    private void e() {
        if (this.f11372d) {
            throw new IllegalStateException("Object already closed");
        }
    }

    void b() {
        synchronized (this.f11369a) {
            e();
            this.f11371c.run();
            close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f11369a) {
            if (this.f11372d) {
                return;
            }
            this.f11372d = true;
            this.f11370b.G(this);
            this.f11370b = null;
            this.f11371c = null;
        }
    }
}
