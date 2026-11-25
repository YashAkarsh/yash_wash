package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class u<T> implements e0<T> {

    class a implements e0.b<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f9706f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f9707g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f9708h = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f9709a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f9710b = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f9711c = new RunnableC0124a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e0.b f9712d;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.u$a$a, reason: collision with other inner class name */
        class RunnableC0124a implements Runnable {
            RunnableC0124a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVarA = a.this.f9709a.a();
                while (dVarA != null) {
                    int i7 = dVarA.f9730b;
                    if (i7 == 1) {
                        a.this.f9712d.c(dVarA.f9731c, dVarA.f9732d);
                    } else if (i7 == 2) {
                        a.this.f9712d.a(dVarA.f9731c, (f0.a) dVarA.f9736h);
                    } else if (i7 != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + dVarA.f9730b);
                    } else {
                        a.this.f9712d.b(dVarA.f9731c, dVarA.f9732d);
                    }
                    dVarA = a.this.f9709a.a();
                }
            }
        }

        a(e0.b bVar) {
            this.f9712d = bVar;
        }

        private void d(d dVar) {
            this.f9709a.c(dVar);
            this.f9710b.post(this.f9711c);
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void a(int i7, f0.a<T> aVar) {
            d(d.c(2, i7, aVar));
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void b(int i7, int i8) {
            d(d.a(3, i7, i8));
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void c(int i7, int i8) {
            d(d.a(1, i7, i8));
        }
    }

    class b implements e0.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f9715g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f9716h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f9717i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f9718j = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f9719a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f9720b = AsyncTask.THREAD_POOL_EXECUTOR;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AtomicBoolean f9721c = new AtomicBoolean(false);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f9722d = new a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e0.a f9723e;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    d dVarA = b.this.f9719a.a();
                    if (dVarA == null) {
                        b.this.f9721c.set(false);
                        return;
                    }
                    int i7 = dVarA.f9730b;
                    if (i7 == 1) {
                        b.this.f9719a.b(1);
                        b.this.f9723e.d(dVarA.f9731c);
                    } else if (i7 == 2) {
                        b.this.f9719a.b(2);
                        b.this.f9719a.b(3);
                        b.this.f9723e.a(dVarA.f9731c, dVarA.f9732d, dVarA.f9733e, dVarA.f9734f, dVarA.f9735g);
                    } else if (i7 == 3) {
                        b.this.f9723e.c(dVarA.f9731c, dVarA.f9732d);
                    } else if (i7 != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + dVarA.f9730b);
                    } else {
                        b.this.f9723e.b((f0.a) dVarA.f9736h);
                    }
                }
            }
        }

        b(e0.a aVar) {
            this.f9723e = aVar;
        }

        private void e() {
            if (this.f9721c.compareAndSet(false, true)) {
                this.f9720b.execute(this.f9722d);
            }
        }

        private void f(d dVar) {
            this.f9719a.c(dVar);
            e();
        }

        private void g(d dVar) {
            this.f9719a.d(dVar);
            e();
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void a(int i7, int i8, int i9, int i10, int i11) {
            g(d.b(2, i7, i8, i9, i10, i11, null));
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void b(f0.a<T> aVar) {
            f(d.c(4, 0, aVar));
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void c(int i7, int i8) {
            f(d.a(3, i7, i8));
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void d(int i7) {
            g(d.c(1, i7, null));
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f9726a;

        c() {
        }

        synchronized d a() {
            d dVar = this.f9726a;
            if (dVar == null) {
                return null;
            }
            this.f9726a = dVar.f9729a;
            return dVar;
        }

        synchronized void b(int i7) {
            d dVar;
            while (true) {
                dVar = this.f9726a;
                if (dVar == null || dVar.f9730b != i7) {
                    break;
                }
                this.f9726a = dVar.f9729a;
                dVar.d();
            }
            if (dVar != null) {
                d dVar2 = dVar.f9729a;
                while (dVar2 != null) {
                    d dVar3 = dVar2.f9729a;
                    if (dVar2.f9730b == i7) {
                        dVar.f9729a = dVar3;
                        dVar2.d();
                    } else {
                        dVar = dVar2;
                    }
                    dVar2 = dVar3;
                }
            }
        }

        synchronized void c(d dVar) {
            d dVar2 = this.f9726a;
            if (dVar2 == null) {
                this.f9726a = dVar;
                return;
            }
            while (true) {
                d dVar3 = dVar2.f9729a;
                if (dVar3 == null) {
                    dVar2.f9729a = dVar;
                    return;
                }
                dVar2 = dVar3;
            }
        }

        synchronized void d(d dVar) {
            dVar.f9729a = this.f9726a;
            this.f9726a = dVar;
        }
    }

    static class d {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static d f9727i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Object f9728j = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d f9729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9734f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f9735g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f9736h;

        d() {
        }

        static d a(int i7, int i8, int i9) {
            return b(i7, i8, i9, 0, 0, 0, null);
        }

        static d b(int i7, int i8, int i9, int i10, int i11, int i12, Object obj) {
            d dVar;
            synchronized (f9728j) {
                dVar = f9727i;
                if (dVar == null) {
                    dVar = new d();
                } else {
                    f9727i = dVar.f9729a;
                    dVar.f9729a = null;
                }
                dVar.f9730b = i7;
                dVar.f9731c = i8;
                dVar.f9732d = i9;
                dVar.f9733e = i10;
                dVar.f9734f = i11;
                dVar.f9735g = i12;
                dVar.f9736h = obj;
            }
            return dVar;
        }

        static d c(int i7, int i8, Object obj) {
            return b(i7, i8, 0, 0, 0, 0, obj);
        }

        void d() {
            this.f9729a = null;
            this.f9735g = 0;
            this.f9734f = 0;
            this.f9733e = 0;
            this.f9732d = 0;
            this.f9731c = 0;
            this.f9730b = 0;
            this.f9736h = null;
            synchronized (f9728j) {
                d dVar = f9727i;
                if (dVar != null) {
                    this.f9729a = dVar;
                }
                f9727i = this;
            }
        }
    }

    u() {
    }

    @Override // androidx.recyclerview.widget.e0
    public e0.a<T> a(e0.a<T> aVar) {
        return new b(aVar);
    }

    @Override // androidx.recyclerview.widget.e0
    public e0.b<T> b(e0.b<T> bVar) {
        return new a(bVar);
    }
}
