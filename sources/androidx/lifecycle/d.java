package androidx.lifecycle;

import c.g1;
import c.h1;
import c.x0;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public abstract class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Executor f8264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final LiveData<T> f8265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicBoolean f8266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicBoolean f8267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g1
    final Runnable f8268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g1
    final Runnable f8269f;

    class a extends LiveData<T> {
        a() {
        }

        @Override // androidx.lifecycle.LiveData
        protected void l() {
            d dVar = d.this;
            dVar.f8264a.execute(dVar.f8268e);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        @h1
        public void run() {
            do {
                boolean z7 = false;
                if (d.this.f8267d.compareAndSet(false, true)) {
                    Object objA = null;
                    boolean z8 = false;
                    while (d.this.f8266c.compareAndSet(true, false)) {
                        try {
                            objA = d.this.a();
                            z8 = true;
                        } catch (Throwable th) {
                            d.this.f8267d.set(false);
                            throw th;
                        }
                    }
                    if (z8) {
                        d.this.f8265b.n((T) objA);
                    }
                    d.this.f8267d.set(false);
                    z7 = z8;
                }
                if (!z7) {
                    return;
                }
            } while (d.this.f8266c.get());
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        @c.j0
        public void run() {
            boolean zH = d.this.f8265b.h();
            if (d.this.f8266c.compareAndSet(false, true) && zH) {
                d dVar = d.this;
                dVar.f8264a.execute(dVar.f8268e);
            }
        }
    }

    public d() {
        this(androidx.arch.core.executor.a.e());
    }

    @h1
    protected abstract T a();

    @c.m0
    public LiveData<T> b() {
        return this.f8265b;
    }

    public void c() {
        androidx.arch.core.executor.a.f().b(this.f8269f);
    }

    public d(@c.m0 Executor executor) {
        this.f8266c = new AtomicBoolean(true);
        this.f8267d = new AtomicBoolean(false);
        this.f8268e = new b();
        this.f8269f = new c();
        this.f8264a = executor;
        this.f8265b = new a();
    }
}
