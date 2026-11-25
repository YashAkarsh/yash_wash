package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.d0;
import c.m0;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class s<T, VH extends RecyclerView.d0> extends RecyclerView.g<VH> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final d<T> f9703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.b<T> f9704d;

    class a implements d.b<T> {
        a() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public void a(@m0 List<T> list, @m0 List<T> list2) {
            s.this.H(list, list2);
        }
    }

    protected s(@m0 i.d<T> dVar) {
        a aVar = new a();
        this.f9704d = aVar;
        d<T> dVar2 = new d<>(new b(this), new c.a(dVar).a());
        this.f9703c = dVar2;
        dVar2.a(aVar);
    }

    @m0
    public List<T> F() {
        return this.f9703c.b();
    }

    protected T G(int i7) {
        return this.f9703c.b().get(i7);
    }

    public void H(@m0 List<T> list, @m0 List<T> list2) {
    }

    public void I(@o0 List<T> list) {
        this.f9703c.f(list);
    }

    public void J(@o0 List<T> list, @o0 Runnable runnable) {
        this.f9703c.g(list, runnable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f9703c.b().size();
    }

    protected s(@m0 c<T> cVar) {
        a aVar = new a();
        this.f9704d = aVar;
        d<T> dVar = new d<>(new b(this), cVar);
        this.f9703c = dVar;
        dVar.a(aVar);
    }
}
