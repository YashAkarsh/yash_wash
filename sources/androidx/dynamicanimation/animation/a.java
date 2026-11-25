package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import c.t0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f7367g = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ThreadLocal<a> f7368h = new ThreadLocal<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f7372d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.collection.i<b, Long> f7369a = new androidx.collection.i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f7370b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0088a f7371c = new C0088a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f7373e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7374f = false;

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    class C0088a {
        C0088a() {
        }

        void a() {
            a.this.f7373e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f7373e);
            if (a.this.f7370b.size() > 0) {
                a.this.f().a();
            }
        }
    }

    interface b {
        boolean a(long j7);
    }

    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0088a f7376a;

        c(C0088a c0088a) {
            this.f7376a = c0088a;
        }

        abstract void a();
    }

    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f7377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f7378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f7379d;

        /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$d$a, reason: collision with other inner class name */
        class RunnableC0089a implements Runnable {
            RunnableC0089a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f7379d = SystemClock.uptimeMillis();
                d.this.f7376a.a();
            }
        }

        d(C0088a c0088a) {
            super(c0088a);
            this.f7379d = -1L;
            this.f7377b = new RunnableC0089a();
            this.f7378c = new Handler(Looper.myLooper());
        }

        @Override // androidx.dynamicanimation.animation.a.c
        void a() {
            this.f7378c.postDelayed(this.f7377b, Math.max(a.f7367g - (SystemClock.uptimeMillis() - this.f7379d), 0L));
        }
    }

    @t0(16)
    private static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Choreographer f7381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f7382c;

        /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$e$a, reason: collision with other inner class name */
        class ChoreographerFrameCallbackC0090a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0090a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j7) {
                e.this.f7376a.a();
            }
        }

        e(C0088a c0088a) {
            super(c0088a);
            this.f7381b = Choreographer.getInstance();
            this.f7382c = new ChoreographerFrameCallbackC0090a();
        }

        @Override // androidx.dynamicanimation.animation.a.c
        void a() {
            this.f7381b.postFrameCallback(this.f7382c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f7374f) {
            for (int size = this.f7370b.size() - 1; size >= 0; size--) {
                if (this.f7370b.get(size) == null) {
                    this.f7370b.remove(size);
                }
            }
            this.f7374f = false;
        }
    }

    public static long d() {
        ThreadLocal<a> threadLocal = f7368h;
        if (threadLocal.get() == null) {
            return 0L;
        }
        return threadLocal.get().f7373e;
    }

    public static a e() {
        ThreadLocal<a> threadLocal = f7368h;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    private boolean g(b bVar, long j7) {
        Long l7 = this.f7369a.get(bVar);
        if (l7 == null) {
            return true;
        }
        if (l7.longValue() >= j7) {
            return false;
        }
        this.f7369a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j7) {
        if (this.f7370b.size() == 0) {
            f().a();
        }
        if (!this.f7370b.contains(bVar)) {
            this.f7370b.add(bVar);
        }
        if (j7 > 0) {
            this.f7369a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j7));
        }
    }

    void c(long j7) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i7 = 0; i7 < this.f7370b.size(); i7++) {
            b bVar = this.f7370b.get(i7);
            if (bVar != null && g(bVar, jUptimeMillis)) {
                bVar.a(j7);
            }
        }
        b();
    }

    c f() {
        if (this.f7372d == null) {
            this.f7372d = new e(this.f7371c);
        }
        return this.f7372d;
    }

    public void h(b bVar) {
        this.f7369a.remove(bVar);
        int iIndexOf = this.f7370b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f7370b.set(iIndexOf, null);
            this.f7374f = true;
        }
    }

    public void i(c cVar) {
        this.f7372d = cVar;
    }
}
