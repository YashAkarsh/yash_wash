package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends RecyclerView.q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final float f9327d = 100.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f9328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f9329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView.s f9330c = new a();

    class a extends RecyclerView.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9331a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i7) {
            super.a(recyclerView, i7);
            if (i7 == 0 && this.f9331a) {
                this.f9331a = false;
                b0.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i7, int i8) {
            if (i7 == 0 && i8 == 0) {
                return;
            }
            this.f9331a = true;
        }
    }

    class b extends q {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.z
        protected void p(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            b0 b0Var = b0.this;
            RecyclerView recyclerView = b0Var.f9328a;
            if (recyclerView == null) {
                return;
            }
            int[] iArrC = b0Var.c(recyclerView.getLayoutManager(), view);
            int i7 = iArrC[0];
            int i8 = iArrC[1];
            int iX = x(Math.max(Math.abs(i7), Math.abs(i8)));
            if (iX > 0) {
                aVar.l(i7, i8, iX, this.f9693j);
            }
        }

        @Override // androidx.recyclerview.widget.q
        protected float w(DisplayMetrics displayMetrics) {
            return b0.f9327d / displayMetrics.densityDpi;
        }
    }

    private void g() {
        this.f9328a.t1(this.f9330c);
        this.f9328a.setOnFlingListener(null);
    }

    private void j() throws IllegalStateException {
        if (this.f9328a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f9328a.r(this.f9330c);
        this.f9328a.setOnFlingListener(this);
    }

    private boolean k(@m0 RecyclerView.o oVar, int i7, int i8) {
        RecyclerView.z zVarE;
        int i9;
        if (!(oVar instanceof RecyclerView.z.b) || (zVarE = e(oVar)) == null || (i9 = i(oVar, i7, i8)) == -1) {
            return false;
        }
        zVarE.q(i9);
        oVar.g2(zVarE);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean a(int i7, int i8) {
        RecyclerView.o layoutManager = this.f9328a.getLayoutManager();
        if (layoutManager == null || this.f9328a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f9328a.getMinFlingVelocity();
        return (Math.abs(i8) > minFlingVelocity || Math.abs(i7) > minFlingVelocity) && k(layoutManager, i7, i8);
    }

    public void b(@o0 RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f9328a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.f9328a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f9329b = new Scroller(this.f9328a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    @o0
    public abstract int[] c(@m0 RecyclerView.o oVar, @m0 View view);

    public int[] d(int i7, int i8) {
        this.f9329b.fling(0, 0, i7, i8, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f9329b.getFinalX(), this.f9329b.getFinalY()};
    }

    @o0
    protected RecyclerView.z e(RecyclerView.o oVar) {
        return f(oVar);
    }

    @o0
    @Deprecated
    protected q f(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new b(this.f9328a.getContext());
        }
        return null;
    }

    @o0
    public abstract View h(RecyclerView.o oVar);

    public abstract int i(RecyclerView.o oVar, int i7, int i8);

    void l() {
        RecyclerView.o layoutManager;
        View viewH;
        RecyclerView recyclerView = this.f9328a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewH = h(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewH);
        int i7 = iArrC[0];
        if (i7 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f9328a.G1(i7, iArrC[1]);
    }
}
