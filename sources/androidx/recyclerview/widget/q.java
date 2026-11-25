package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class q extends RecyclerView.z {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final boolean f9685q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final float f9686r = 25.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f9687s = 10000;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f9688t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f9689u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f9690v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final float f9691w = 1.2f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected PointF f9694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DisplayMetrics f9695l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f9697n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f9692i = new LinearInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f9693j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9696m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected int f9698o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f9699p = 0;

    public q(Context context) {
        this.f9695l = context.getResources().getDisplayMetrics();
    }

    private float B() {
        if (!this.f9696m) {
            this.f9697n = w(this.f9695l);
            this.f9696m = true;
        }
        return this.f9697n;
    }

    private int z(int i7, int i8) {
        int i9 = i7 - i8;
        if (i7 * i9 <= 0) {
            return 0;
        }
        return i9;
    }

    protected int A() {
        PointF pointF = this.f9694k;
        if (pointF != null) {
            float f8 = pointF.x;
            if (f8 != 0.0f) {
                return f8 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected int C() {
        PointF pointF = this.f9694k;
        if (pointF != null) {
            float f8 = pointF.y;
            if (f8 != 0.0f) {
                return f8 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void D(RecyclerView.z.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.f(f());
            s();
            return;
        }
        j(pointFA);
        this.f9694k = pointFA;
        this.f9698o = (int) (pointFA.x * 10000.0f);
        this.f9699p = (int) (pointFA.y * 10000.0f);
        aVar.l((int) (this.f9698o * f9691w), (int) (this.f9699p * f9691w), (int) (y(10000) * f9691w), this.f9692i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void m(int i7, int i8, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        if (c() == 0) {
            s();
            return;
        }
        this.f9698o = z(this.f9698o, i7);
        int iZ = z(this.f9699p, i8);
        this.f9699p = iZ;
        if (this.f9698o == 0 && iZ == 0) {
            D(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void n() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void o() {
        this.f9699p = 0;
        this.f9698o = 0;
        this.f9694k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z
    protected void p(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        int iU = u(view, A());
        int iV = v(view, C());
        int iX = x((int) Math.sqrt((iU * iU) + (iV * iV)));
        if (iX > 0) {
            aVar.l(-iU, -iV, iX, this.f9693j);
        }
    }

    public int t(int i7, int i8, int i9, int i10, int i11) {
        if (i11 == -1) {
            return i9 - i7;
        }
        if (i11 != 0) {
            if (i11 == 1) {
                return i10 - i8;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i12 = i9 - i7;
        if (i12 > 0) {
            return i12;
        }
        int i13 = i10 - i8;
        if (i13 < 0) {
            return i13;
        }
        return 0;
    }

    public int u(View view, int i7) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.n()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return t(oVarE.Y(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, oVarE.b0(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, oVarE.o0(), oVarE.z0() - oVarE.p0(), i7);
    }

    public int v(View view, int i7) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.o()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return t(oVarE.c0(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, oVarE.W(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, oVarE.r0(), oVarE.e0() - oVarE.m0(), i7);
    }

    protected float w(DisplayMetrics displayMetrics) {
        return f9686r / displayMetrics.densityDpi;
    }

    protected int x(int i7) {
        return (int) Math.ceil(((double) y(i7)) / 0.3356d);
    }

    protected int y(int i7) {
        return (int) Math.ceil(Math.abs(i7) * B());
    }
}
