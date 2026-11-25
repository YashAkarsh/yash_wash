package androidx.lifecycle;

import android.annotation.SuppressLint;
import c.g1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class r extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.arch.core.internal.a<p, a> f8344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m.c f8345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<q> f8346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<m.c> f8350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f8351i;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        m.c f8352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        o f8353b;

        a(p pVar, m.c cVar) {
            this.f8353b = Lifecycling.g(pVar);
            this.f8352a = cVar;
        }

        void a(q qVar, m.b bVar) {
            m.c cVarC = bVar.c();
            this.f8352a = r.m(this.f8352a, cVarC);
            this.f8353b.g(qVar, bVar);
            this.f8352a = cVarC;
        }
    }

    public r(@c.m0 q qVar) {
        this(qVar, true);
    }

    private void d(q qVar) {
        Iterator<Map.Entry<p, a>> itDescendingIterator = this.f8344b.descendingIterator();
        while (itDescendingIterator.hasNext() && !this.f8349g) {
            Map.Entry<p, a> next = itDescendingIterator.next();
            a value = next.getValue();
            while (value.f8352a.compareTo(this.f8345c) > 0 && !this.f8349g && this.f8344b.contains(next.getKey())) {
                m.b bVarA = m.b.a(value.f8352a);
                if (bVarA == null) {
                    throw new IllegalStateException("no event down from " + value.f8352a);
                }
                p(bVarA.c());
                value.a(qVar, bVarA);
                o();
            }
        }
    }

    private m.c e(p pVar) {
        Map.Entry<p, a> entryK = this.f8344b.k(pVar);
        m.c cVar = null;
        m.c cVar2 = entryK != null ? entryK.getValue().f8352a : null;
        if (!this.f8350h.isEmpty()) {
            ArrayList<m.c> arrayList = this.f8350h;
            cVar = arrayList.get(arrayList.size() - 1);
        }
        return m(m(this.f8345c, cVar2), cVar);
    }

    @c.m0
    @g1
    public static r f(@c.m0 q qVar) {
        return new r(qVar, false);
    }

    @SuppressLint({"RestrictedApi"})
    private void g(String str) {
        if (!this.f8351i || androidx.arch.core.executor.a.f().c()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    private void h(q qVar) {
        androidx.arch.core.internal.b<p, a>.d dVarD = this.f8344b.d();
        while (dVarD.hasNext() && !this.f8349g) {
            Map.Entry next = dVarD.next();
            a aVar = (a) next.getValue();
            while (aVar.f8352a.compareTo(this.f8345c) < 0 && !this.f8349g && this.f8344b.contains((p) next.getKey())) {
                p(aVar.f8352a);
                m.b bVarD = m.b.d(aVar.f8352a);
                if (bVarD == null) {
                    throw new IllegalStateException("no event up from " + aVar.f8352a);
                }
                aVar.a(qVar, bVarD);
                o();
            }
        }
    }

    private boolean k() {
        if (this.f8344b.size() == 0) {
            return true;
        }
        m.c cVar = this.f8344b.a().getValue().f8352a;
        m.c cVar2 = this.f8344b.f().getValue().f8352a;
        return cVar == cVar2 && this.f8345c == cVar2;
    }

    static m.c m(@c.m0 m.c cVar, @c.o0 m.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void n(m.c cVar) {
        m.c cVar2 = this.f8345c;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 == m.c.INITIALIZED && cVar == m.c.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f8345c);
        }
        this.f8345c = cVar;
        if (this.f8348f || this.f8347e != 0) {
            this.f8349g = true;
            return;
        }
        this.f8348f = true;
        r();
        this.f8348f = false;
        if (this.f8345c == m.c.DESTROYED) {
            this.f8344b = new androidx.arch.core.internal.a<>();
        }
    }

    private void o() {
        ArrayList<m.c> arrayList = this.f8350h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void p(m.c cVar) {
        this.f8350h.add(cVar);
    }

    private void r() {
        q qVar = this.f8346d.get();
        if (qVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!k()) {
            this.f8349g = false;
            if (this.f8345c.compareTo(this.f8344b.a().getValue().f8352a) < 0) {
                d(qVar);
            }
            Map.Entry<p, a> entryF = this.f8344b.f();
            if (!this.f8349g && entryF != null && this.f8345c.compareTo(entryF.getValue().f8352a) > 0) {
                h(qVar);
            }
        }
        this.f8349g = false;
    }

    @Override // androidx.lifecycle.m
    public void a(@c.m0 p pVar) {
        q qVar;
        g("addObserver");
        m.c cVar = this.f8345c;
        m.c cVar2 = m.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = m.c.INITIALIZED;
        }
        a aVar = new a(pVar, cVar2);
        if (this.f8344b.h(pVar, aVar) == null && (qVar = this.f8346d.get()) != null) {
            boolean z7 = this.f8347e != 0 || this.f8348f;
            m.c cVarE = e(pVar);
            this.f8347e++;
            while (aVar.f8352a.compareTo(cVarE) < 0 && this.f8344b.contains(pVar)) {
                p(aVar.f8352a);
                m.b bVarD = m.b.d(aVar.f8352a);
                if (bVarD == null) {
                    throw new IllegalStateException("no event up from " + aVar.f8352a);
                }
                aVar.a(qVar, bVarD);
                o();
                cVarE = e(pVar);
            }
            if (!z7) {
                r();
            }
            this.f8347e--;
        }
    }

    @Override // androidx.lifecycle.m
    @c.m0
    public m.c b() {
        return this.f8345c;
    }

    @Override // androidx.lifecycle.m
    public void c(@c.m0 p pVar) {
        g("removeObserver");
        this.f8344b.j(pVar);
    }

    public int i() {
        g("getObserverCount");
        return this.f8344b.size();
    }

    public void j(@c.m0 m.b bVar) {
        g("handleLifecycleEvent");
        n(bVar.c());
    }

    @c.j0
    @Deprecated
    public void l(@c.m0 m.c cVar) {
        g("markState");
        q(cVar);
    }

    @c.j0
    public void q(@c.m0 m.c cVar) {
        g("setCurrentState");
        n(cVar);
    }

    private r(@c.m0 q qVar, boolean z7) {
        this.f8344b = new androidx.arch.core.internal.a<>();
        this.f8347e = 0;
        this.f8348f = false;
        this.f8349g = false;
        this.f8350h = new ArrayList<>();
        this.f8346d = new WeakReference<>(qVar);
        this.f8345c = m.c.INITIALIZED;
        this.f8351i = z7;
    }
}
