package androidx.lifecycle;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f8219k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final Object f8220l = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f8221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.arch.core.internal.b<x<? super T>, LiveData<T>.c> f8222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f8223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Object f8225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile Object f8226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f8230j;

    class LifecycleBoundObserver extends LiveData<T>.c implements o {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.m0
        final q f8231e;

        LifecycleBoundObserver(q qVar, x<? super T> xVar) {
            super(xVar);
            this.f8231e = qVar;
        }

        @Override // androidx.lifecycle.o
        public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
            m.c cVarB = this.f8231e.getLifecycle().b();
            if (cVarB == m.c.DESTROYED) {
                LiveData.this.o(this.f8235a);
                return;
            }
            m.c cVar = null;
            while (cVar != cVarB) {
                h(k());
                cVar = cVarB;
                cVarB = this.f8231e.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.c
        void i() {
            this.f8231e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean j(q qVar) {
            return this.f8231e == qVar;
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean k() {
            return this.f8231e.getLifecycle().b().a(m.c.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f8221a) {
                obj = LiveData.this.f8226f;
                LiveData.this.f8226f = LiveData.f8220l;
            }
            LiveData.this.q(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(x<? super T> xVar) {
            super(xVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean k() {
            return true;
        }
    }

    private abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final x<? super T> f8235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f8236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f8237c = -1;

        c(x<? super T> xVar) {
            this.f8235a = xVar;
        }

        void h(boolean z7) {
            if (z7 == this.f8236b) {
                return;
            }
            this.f8236b = z7;
            LiveData.this.c(z7 ? 1 : -1);
            if (this.f8236b) {
                LiveData.this.e(this);
            }
        }

        void i() {
        }

        boolean j(q qVar) {
            return false;
        }

        abstract boolean k();
    }

    public LiveData(T t7) {
        this.f8221a = new Object();
        this.f8222b = new androidx.arch.core.internal.b<>();
        this.f8223c = 0;
        this.f8226f = f8220l;
        this.f8230j = new a();
        this.f8225e = t7;
        this.f8227g = 0;
    }

    static void b(String str) {
        if (androidx.arch.core.executor.a.f().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(LiveData<T>.c cVar) {
        if (cVar.f8236b) {
            if (!cVar.k()) {
                cVar.h(false);
                return;
            }
            int i7 = cVar.f8237c;
            int i8 = this.f8227g;
            if (i7 >= i8) {
                return;
            }
            cVar.f8237c = i8;
            cVar.f8235a.a((Object) this.f8225e);
        }
    }

    @c.j0
    void c(int i7) {
        int i8 = this.f8223c;
        this.f8223c = i7 + i8;
        if (this.f8224d) {
            return;
        }
        this.f8224d = true;
        while (true) {
            try {
                int i9 = this.f8223c;
                if (i8 == i9) {
                    this.f8224d = false;
                    return;
                }
                boolean z7 = i8 == 0 && i9 > 0;
                boolean z8 = i8 > 0 && i9 == 0;
                if (z7) {
                    l();
                } else if (z8) {
                    m();
                }
                i8 = i9;
            } catch (Throwable th) {
                this.f8224d = false;
                throw th;
            }
        }
    }

    void e(@c.o0 LiveData<T>.c cVar) {
        if (this.f8228h) {
            this.f8229i = true;
            return;
        }
        this.f8228h = true;
        do {
            this.f8229i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                androidx.arch.core.internal.b<x<? super T>, LiveData<T>.c>.d dVarD = this.f8222b.d();
                while (dVarD.hasNext()) {
                    d((c) dVarD.next().getValue());
                    if (this.f8229i) {
                        break;
                    }
                }
            }
        } while (this.f8229i);
        this.f8228h = false;
    }

    @c.o0
    public T f() {
        T t7 = (T) this.f8225e;
        if (t7 != f8220l) {
            return t7;
        }
        return null;
    }

    int g() {
        return this.f8227g;
    }

    public boolean h() {
        return this.f8223c > 0;
    }

    public boolean i() {
        return this.f8222b.size() > 0;
    }

    @c.j0
    public void j(@c.m0 q qVar, @c.m0 x<? super T> xVar) {
        b("observe");
        if (qVar.getLifecycle().b() == m.c.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(qVar, xVar);
        LiveData<T>.c cVarH = this.f8222b.h(xVar, lifecycleBoundObserver);
        if (cVarH != null && !cVarH.j(qVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarH != null) {
            return;
        }
        qVar.getLifecycle().a(lifecycleBoundObserver);
    }

    @c.j0
    public void k(@c.m0 x<? super T> xVar) {
        b("observeForever");
        b bVar = new b(xVar);
        LiveData<T>.c cVarH = this.f8222b.h(xVar, bVar);
        if (cVarH instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVarH != null) {
            return;
        }
        bVar.h(true);
    }

    protected void l() {
    }

    protected void m() {
    }

    protected void n(T t7) {
        boolean z7;
        synchronized (this.f8221a) {
            z7 = this.f8226f == f8220l;
            this.f8226f = t7;
        }
        if (z7) {
            androidx.arch.core.executor.a.f().d(this.f8230j);
        }
    }

    @c.j0
    public void o(@c.m0 x<? super T> xVar) {
        b("removeObserver");
        LiveData<T>.c cVarJ = this.f8222b.j(xVar);
        if (cVarJ == null) {
            return;
        }
        cVarJ.i();
        cVarJ.h(false);
    }

    @c.j0
    public void p(@c.m0 q qVar) {
        b("removeObservers");
        for (Map.Entry<x<? super T>, LiveData<T>.c> entry : this.f8222b) {
            if (entry.getValue().j(qVar)) {
                o(entry.getKey());
            }
        }
    }

    @c.j0
    protected void q(T t7) {
        b("setValue");
        this.f8227g++;
        this.f8225e = t7;
        e(null);
    }

    public LiveData() {
        this.f8221a = new Object();
        this.f8222b = new androidx.arch.core.internal.b<>();
        this.f8223c = 0;
        Object obj = f8220l;
        this.f8226f = obj;
        this.f8230j = new a();
        this.f8225e = obj;
        this.f8227g = -1;
    }
}
