package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9738d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9739e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9740f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.o f9741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Rect f9743c;

    static class a extends w {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.w
        public int d(View view) {
            return this.f9741a.b0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f9741a.a0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f9741a.Z(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int g(View view) {
            return this.f9741a.Y(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int h() {
            return this.f9741a.z0();
        }

        @Override // androidx.recyclerview.widget.w
        public int i() {
            return this.f9741a.z0() - this.f9741a.p0();
        }

        @Override // androidx.recyclerview.widget.w
        public int j() {
            return this.f9741a.p0();
        }

        @Override // androidx.recyclerview.widget.w
        public int l() {
            return this.f9741a.A0();
        }

        @Override // androidx.recyclerview.widget.w
        public int m() {
            return this.f9741a.f0();
        }

        @Override // androidx.recyclerview.widget.w
        public int n() {
            return this.f9741a.o0();
        }

        @Override // androidx.recyclerview.widget.w
        public int o() {
            return (this.f9741a.z0() - this.f9741a.o0()) - this.f9741a.p0();
        }

        @Override // androidx.recyclerview.widget.w
        public int q(View view) {
            this.f9741a.y0(view, true, this.f9743c);
            return this.f9743c.right;
        }

        @Override // androidx.recyclerview.widget.w
        public int r(View view) {
            this.f9741a.y0(view, true, this.f9743c);
            return this.f9743c.left;
        }

        @Override // androidx.recyclerview.widget.w
        public void s(View view, int i7) {
            view.offsetLeftAndRight(i7);
        }

        @Override // androidx.recyclerview.widget.w
        public void t(int i7) {
            this.f9741a.T0(i7);
        }
    }

    static class b extends w {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.w
        public int d(View view) {
            return this.f9741a.W(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f9741a.Z(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f9741a.a0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int g(View view) {
            return this.f9741a.c0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.w
        public int h() {
            return this.f9741a.e0();
        }

        @Override // androidx.recyclerview.widget.w
        public int i() {
            return this.f9741a.e0() - this.f9741a.m0();
        }

        @Override // androidx.recyclerview.widget.w
        public int j() {
            return this.f9741a.m0();
        }

        @Override // androidx.recyclerview.widget.w
        public int l() {
            return this.f9741a.f0();
        }

        @Override // androidx.recyclerview.widget.w
        public int m() {
            return this.f9741a.A0();
        }

        @Override // androidx.recyclerview.widget.w
        public int n() {
            return this.f9741a.r0();
        }

        @Override // androidx.recyclerview.widget.w
        public int o() {
            return (this.f9741a.e0() - this.f9741a.r0()) - this.f9741a.m0();
        }

        @Override // androidx.recyclerview.widget.w
        public int q(View view) {
            this.f9741a.y0(view, true, this.f9743c);
            return this.f9743c.bottom;
        }

        @Override // androidx.recyclerview.widget.w
        public int r(View view) {
            this.f9741a.y0(view, true, this.f9743c);
            return this.f9743c.top;
        }

        @Override // androidx.recyclerview.widget.w
        public void s(View view, int i7) {
            view.offsetTopAndBottom(i7);
        }

        @Override // androidx.recyclerview.widget.w
        public void t(int i7) {
            this.f9741a.U0(i7);
        }
    }

    /* synthetic */ w(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static w a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static w b(RecyclerView.o oVar, int i7) {
        if (i7 == 0) {
            return a(oVar);
        }
        if (i7 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static w c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public RecyclerView.o k() {
        return this.f9741a;
    }

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public int p() {
        if (Integer.MIN_VALUE == this.f9742b) {
            return 0;
        }
        return o() - this.f9742b;
    }

    public abstract int q(View view);

    public abstract int r(View view);

    public abstract void s(View view, int i7);

    public abstract void t(int i7);

    public void u() {
        this.f9742b = o();
    }

    private w(RecyclerView.o oVar) {
        this.f9742b = Integer.MIN_VALUE;
        this.f9743c = new Rect();
        this.f9741a = oVar;
    }
}
