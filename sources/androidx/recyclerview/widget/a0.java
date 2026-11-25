package androidx.recyclerview.widget;

import android.view.View;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a0 extends RecyclerView.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final boolean f9323m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f9324n = "SimpleItemAnimator";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f9325l = true;

    public abstract boolean D(RecyclerView.d0 d0Var);

    public abstract boolean E(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i7, int i8, int i9, int i10);

    public abstract boolean F(RecyclerView.d0 d0Var, int i7, int i8, int i9, int i10);

    public abstract boolean G(RecyclerView.d0 d0Var);

    public final void H(RecyclerView.d0 d0Var) {
        Q(d0Var);
        h(d0Var);
    }

    public final void I(RecyclerView.d0 d0Var) {
        R(d0Var);
    }

    public final void J(RecyclerView.d0 d0Var, boolean z7) {
        S(d0Var, z7);
        h(d0Var);
    }

    public final void K(RecyclerView.d0 d0Var, boolean z7) {
        T(d0Var, z7);
    }

    public final void L(RecyclerView.d0 d0Var) {
        U(d0Var);
        h(d0Var);
    }

    public final void M(RecyclerView.d0 d0Var) {
        V(d0Var);
    }

    public final void N(RecyclerView.d0 d0Var) {
        W(d0Var);
        h(d0Var);
    }

    public final void O(RecyclerView.d0 d0Var) {
        X(d0Var);
    }

    public boolean P() {
        return this.f9325l;
    }

    public void Q(RecyclerView.d0 d0Var) {
    }

    public void R(RecyclerView.d0 d0Var) {
    }

    public void S(RecyclerView.d0 d0Var, boolean z7) {
    }

    public void T(RecyclerView.d0 d0Var, boolean z7) {
    }

    public void U(RecyclerView.d0 d0Var) {
    }

    public void V(RecyclerView.d0 d0Var) {
    }

    public void W(RecyclerView.d0 d0Var) {
    }

    public void X(RecyclerView.d0 d0Var) {
    }

    public void Y(boolean z7) {
        this.f9325l = z7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(@m0 RecyclerView.d0 d0Var, @o0 RecyclerView.l.d dVar, @m0 RecyclerView.l.d dVar2) {
        int i7;
        int i8;
        return (dVar == null || ((i7 = dVar.f9194a) == (i8 = dVar2.f9194a) && dVar.f9195b == dVar2.f9195b)) ? D(d0Var) : F(d0Var, i7, dVar.f9195b, i8, dVar2.f9195b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(@m0 RecyclerView.d0 d0Var, @m0 RecyclerView.d0 d0Var2, @m0 RecyclerView.l.d dVar, @m0 RecyclerView.l.d dVar2) {
        int i7;
        int i8;
        int i9 = dVar.f9194a;
        int i10 = dVar.f9195b;
        if (d0Var2.K()) {
            int i11 = dVar.f9194a;
            i8 = dVar.f9195b;
            i7 = i11;
        } else {
            i7 = dVar2.f9194a;
            i8 = dVar2.f9195b;
        }
        return E(d0Var, d0Var2, i9, i10, i7, i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(@m0 RecyclerView.d0 d0Var, @m0 RecyclerView.l.d dVar, @o0 RecyclerView.l.d dVar2) {
        int i7 = dVar.f9194a;
        int i8 = dVar.f9195b;
        View view = d0Var.f9157a;
        int left = dVar2 == null ? view.getLeft() : dVar2.f9194a;
        int top = dVar2 == null ? view.getTop() : dVar2.f9195b;
        if (d0Var.w() || (i7 == left && i8 == top)) {
            return G(d0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return F(d0Var, i7, i8, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(@m0 RecyclerView.d0 d0Var, @m0 RecyclerView.l.d dVar, @m0 RecyclerView.l.d dVar2) {
        int i7 = dVar.f9194a;
        int i8 = dVar2.f9194a;
        if (i7 != i8 || dVar.f9195b != dVar2.f9195b) {
            return F(d0Var, i7, dVar.f9195b, i8, dVar2.f9195b);
        }
        L(d0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(@m0 RecyclerView.d0 d0Var) {
        return !this.f9325l || d0Var.u();
    }
}
