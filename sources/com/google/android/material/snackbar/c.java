package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.m0;
import c.o0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f18492e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f18493f = 1500;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f18494g = 2750;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static c f18495h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Object f18496a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Handler f18497b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private C0204c f18498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private C0204c f18499d;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@m0 Message message) {
            if (message.what != 0) {
                return false;
            }
            c.this.d((C0204c) message.obj);
            return true;
        }
    }

    interface b {
        void a(int i7);

        void b();
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.c$c, reason: collision with other inner class name */
    private static class C0204c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        final WeakReference<b> f18501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f18503c;

        C0204c(int i7, b bVar) {
            this.f18501a = new WeakReference<>(bVar);
            this.f18502b = i7;
        }

        boolean a(@o0 b bVar) {
            return bVar != null && this.f18501a.get() == bVar;
        }
    }

    private c() {
    }

    private boolean a(@m0 C0204c c0204c, int i7) {
        b bVar = c0204c.f18501a.get();
        if (bVar == null) {
            return false;
        }
        this.f18497b.removeCallbacksAndMessages(c0204c);
        bVar.a(i7);
        return true;
    }

    static c c() {
        if (f18495h == null) {
            f18495h = new c();
        }
        return f18495h;
    }

    private boolean g(b bVar) {
        C0204c c0204c = this.f18498c;
        return c0204c != null && c0204c.a(bVar);
    }

    private boolean h(b bVar) {
        C0204c c0204c = this.f18499d;
        return c0204c != null && c0204c.a(bVar);
    }

    private void m(@m0 C0204c c0204c) {
        int i7 = c0204c.f18502b;
        if (i7 == -2) {
            return;
        }
        if (i7 <= 0) {
            i7 = i7 == -1 ? 1500 : f18494g;
        }
        this.f18497b.removeCallbacksAndMessages(c0204c);
        Handler handler = this.f18497b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, c0204c), i7);
    }

    private void o() {
        C0204c c0204c = this.f18499d;
        if (c0204c != null) {
            this.f18498c = c0204c;
            this.f18499d = null;
            b bVar = c0204c.f18501a.get();
            if (bVar != null) {
                bVar.b();
            } else {
                this.f18498c = null;
            }
        }
    }

    public void b(b bVar, int i7) {
        synchronized (this.f18496a) {
            if (g(bVar)) {
                a(this.f18498c, i7);
            } else if (h(bVar)) {
                a(this.f18499d, i7);
            }
        }
    }

    void d(@m0 C0204c c0204c) {
        synchronized (this.f18496a) {
            if (this.f18498c == c0204c || this.f18499d == c0204c) {
                a(c0204c, 2);
            }
        }
    }

    public boolean e(b bVar) {
        boolean zG;
        synchronized (this.f18496a) {
            zG = g(bVar);
        }
        return zG;
    }

    public boolean f(b bVar) {
        boolean z7;
        synchronized (this.f18496a) {
            z7 = g(bVar) || h(bVar);
        }
        return z7;
    }

    public void i(b bVar) {
        synchronized (this.f18496a) {
            if (g(bVar)) {
                this.f18498c = null;
                if (this.f18499d != null) {
                    o();
                }
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f18496a) {
            if (g(bVar)) {
                m(this.f18498c);
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f18496a) {
            if (g(bVar)) {
                C0204c c0204c = this.f18498c;
                if (!c0204c.f18503c) {
                    c0204c.f18503c = true;
                    this.f18497b.removeCallbacksAndMessages(c0204c);
                }
            }
        }
    }

    public void l(b bVar) {
        synchronized (this.f18496a) {
            if (g(bVar)) {
                C0204c c0204c = this.f18498c;
                if (c0204c.f18503c) {
                    c0204c.f18503c = false;
                    m(c0204c);
                }
            }
        }
    }

    public void n(int i7, b bVar) {
        synchronized (this.f18496a) {
            if (g(bVar)) {
                C0204c c0204c = this.f18498c;
                c0204c.f18502b = i7;
                this.f18497b.removeCallbacksAndMessages(c0204c);
                m(this.f18498c);
                return;
            }
            if (h(bVar)) {
                this.f18499d.f18502b = i7;
            } else {
                this.f18499d = new C0204c(i7, bVar);
            }
            C0204c c0204c2 = this.f18498c;
            if (c0204c2 == null || !a(c0204c2, 4)) {
                this.f18498c = null;
                o();
            }
        }
    }
}
