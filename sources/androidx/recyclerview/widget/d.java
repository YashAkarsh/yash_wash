package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import c.m0;
import c.o0;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class d<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Executor f9359h = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f9360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final androidx.recyclerview.widget.c<T> f9361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Executor f9362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b<T>> f9363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private List<T> f9364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    private List<T> f9365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f9366g;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f9367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f9368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f9370d;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.d$a$a, reason: collision with other inner class name */
        class C0122a extends i.b {
            C0122a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.i.b
            public boolean a(int i7, int i8) {
                Object obj = a.this.f9367a.get(i7);
                Object obj2 = a.this.f9368b.get(i8);
                if (obj != null && obj2 != null) {
                    return d.this.f9361b.b().a(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.i.b
            public boolean b(int i7, int i8) {
                Object obj = a.this.f9367a.get(i7);
                Object obj2 = a.this.f9368b.get(i8);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return d.this.f9361b.b().b(obj, obj2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.i.b
            @o0
            public Object c(int i7, int i8) {
                Object obj = a.this.f9367a.get(i7);
                Object obj2 = a.this.f9368b.get(i8);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                return d.this.f9361b.b().c(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.i.b
            public int d() {
                return a.this.f9368b.size();
            }

            @Override // androidx.recyclerview.widget.i.b
            public int e() {
                return a.this.f9367a.size();
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i.c f9373a;

            b(i.c cVar) {
                this.f9373a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f9366g == aVar.f9369c) {
                    dVar.c(aVar.f9368b, this.f9373a, aVar.f9370d);
                }
            }
        }

        a(List list, List list2, int i7, Runnable runnable) {
            this.f9367a = list;
            this.f9368b = list2;
            this.f9369c = i7;
            this.f9370d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f9362c.execute(new b(i.a(new C0122a())));
        }
    }

    public interface b<T> {
        void a(@m0 List<T> list, @m0 List<T> list2);
    }

    private static class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Handler f9375a = new Handler(Looper.getMainLooper());

        c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@m0 Runnable runnable) {
            this.f9375a.post(runnable);
        }
    }

    public d(@m0 RecyclerView.g gVar, @m0 i.d<T> dVar) {
        this(new androidx.recyclerview.widget.b(gVar), new androidx.recyclerview.widget.c.a(dVar).a());
    }

    private void d(@m0 List<T> list, @o0 Runnable runnable) {
        Iterator<b<T>> it = this.f9363d.iterator();
        while (it.hasNext()) {
            it.next().a(list, this.f9365f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(@m0 b<T> bVar) {
        this.f9363d.add(bVar);
    }

    @m0
    public List<T> b() {
        return this.f9365f;
    }

    void c(@m0 List<T> list, @m0 i.c cVar, @o0 Runnable runnable) {
        List<T> list2 = this.f9365f;
        this.f9364e = list;
        this.f9365f = Collections.unmodifiableList(list);
        cVar.f(this.f9360a);
        d(list2, runnable);
    }

    public void e(@m0 b<T> bVar) {
        this.f9363d.remove(bVar);
    }

    public void f(@o0 List<T> list) {
        g(list, null);
    }

    public void g(@o0 List<T> list, @o0 Runnable runnable) {
        int i7 = this.f9366g + 1;
        this.f9366g = i7;
        List<T> list2 = this.f9364e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.f9365f;
        if (list == null) {
            int size = list2.size();
            this.f9364e = null;
            this.f9365f = Collections.emptyList();
            this.f9360a.c(0, size);
            d(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.f9361b.a().execute(new a(list2, list, i7, runnable));
            return;
        }
        this.f9364e = list;
        this.f9365f = Collections.unmodifiableList(list);
        this.f9360a.b(0, list.size());
        d(list3, runnable);
    }

    public d(@m0 t tVar, @m0 androidx.recyclerview.widget.c<T> cVar) {
        this.f9363d = new CopyOnWriteArrayList();
        this.f9365f = Collections.emptyList();
        this.f9360a = tVar;
        this.f9361b = cVar;
        if (cVar.c() != null) {
            this.f9362c = cVar.c();
        } else {
            this.f9362c = f9359h;
        }
    }
}
