package androidx.recyclerview.widget;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final RecyclerView.g f9326a;

    public b(@m0 RecyclerView.g gVar) {
        this.f9326a = gVar;
    }

    @Override // androidx.recyclerview.widget.t
    public void a(int i7, int i8) {
        this.f9326a.n(i7, i8);
    }

    @Override // androidx.recyclerview.widget.t
    public void b(int i7, int i8) {
        this.f9326a.q(i7, i8);
    }

    @Override // androidx.recyclerview.widget.t
    public void c(int i7, int i8) {
        this.f9326a.r(i7, i8);
    }

    @Override // androidx.recyclerview.widget.t
    public void d(int i7, int i8, Object obj) {
        this.f9326a.p(i7, i8, obj);
    }
}
