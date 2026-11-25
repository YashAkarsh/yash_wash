package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0<T2> extends c0.b<T2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RecyclerView.g f9376a;

    public d0(RecyclerView.g gVar) {
        this.f9376a = gVar;
    }

    @Override // androidx.recyclerview.widget.t
    public void a(int i7, int i8) {
        this.f9376a.n(i7, i8);
    }

    @Override // androidx.recyclerview.widget.t
    public void b(int i7, int i8) {
        this.f9376a.q(i7, i8);
    }

    @Override // androidx.recyclerview.widget.t
    public void c(int i7, int i8) {
        this.f9376a.r(i7, i8);
    }

    @Override // androidx.recyclerview.widget.c0.b, androidx.recyclerview.widget.t
    public void d(int i7, int i8, Object obj) {
        this.f9376a.p(i7, i8, obj);
    }

    @Override // androidx.recyclerview.widget.c0.b
    public void h(int i7, int i8) {
        this.f9376a.o(i7, i8);
    }
}
