package androidx.arch.core.executor;

import c.m0;
import c.o0;
import c.x0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class a extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f2028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private static final Executor f2029d = new ExecutorC0026a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    private static final Executor f2030e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private d f2031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private d f2032b;

    /* JADX INFO: renamed from: androidx.arch.core.executor.a$a, reason: collision with other inner class name */
    static class ExecutorC0026a implements Executor {
        ExecutorC0026a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.f().d(runnable);
        }
    }

    static class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.f().a(runnable);
        }
    }

    private a() {
        c cVar = new c();
        this.f2032b = cVar;
        this.f2031a = cVar;
    }

    @m0
    public static Executor e() {
        return f2030e;
    }

    @m0
    public static a f() {
        if (f2028c != null) {
            return f2028c;
        }
        synchronized (a.class) {
            if (f2028c == null) {
                f2028c = new a();
            }
        }
        return f2028c;
    }

    @m0
    public static Executor g() {
        return f2029d;
    }

    @Override // androidx.arch.core.executor.d
    public void a(Runnable runnable) {
        this.f2031a.a(runnable);
    }

    @Override // androidx.arch.core.executor.d
    public boolean c() {
        return this.f2031a.c();
    }

    @Override // androidx.arch.core.executor.d
    public void d(Runnable runnable) {
        this.f2031a.d(runnable);
    }

    public void h(@o0 d dVar) {
        if (dVar == null) {
            dVar = this.f2032b;
        }
        this.f2031a = dVar;
    }
}
