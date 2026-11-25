package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class x extends b0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9744g = 100;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private w f9745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private w f9746f;

    class a extends q {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.z
        protected void p(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            x xVar = x.this;
            int[] iArrC = xVar.c(xVar.f9328a.getLayoutManager(), view);
            int i7 = iArrC[0];
            int i8 = iArrC[1];
            int iX = x(Math.max(Math.abs(i7), Math.abs(i8)));
            if (iX > 0) {
                aVar.l(i7, i8, iX, this.f9693j);
            }
        }

        @Override // androidx.recyclerview.widget.q
        protected float w(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.q
        protected int y(int i7) {
            return Math.min(100, super.y(i7));
        }
    }

    private int m(@m0 RecyclerView.o oVar, @m0 View view, w wVar) {
        return (wVar.g(view) + (wVar.e(view) / 2)) - (wVar.n() + (wVar.o() / 2));
    }

    @o0
    private View n(RecyclerView.o oVar, w wVar) {
        int iQ = oVar.Q();
        View view = null;
        if (iQ == 0) {
            return null;
        }
        int iN = wVar.n() + (wVar.o() / 2);
        int i7 = Integer.MAX_VALUE;
        for (int i8 = 0; i8 < iQ; i8++) {
            View viewP = oVar.P(i8);
            int iAbs = Math.abs((wVar.g(viewP) + (wVar.e(viewP) / 2)) - iN);
            if (iAbs < i7) {
                view = viewP;
                i7 = iAbs;
            }
        }
        return view;
    }

    @m0
    private w o(@m0 RecyclerView.o oVar) {
        w wVar = this.f9746f;
        if (wVar == null || wVar.f9741a != oVar) {
            this.f9746f = w.a(oVar);
        }
        return this.f9746f;
    }

    @o0
    private w p(RecyclerView.o oVar) {
        if (oVar.o()) {
            return q(oVar);
        }
        if (oVar.n()) {
            return o(oVar);
        }
        return null;
    }

    @m0
    private w q(@m0 RecyclerView.o oVar) {
        w wVar = this.f9745e;
        if (wVar == null || wVar.f9741a != oVar) {
            this.f9745e = w.c(oVar);
        }
        return this.f9745e;
    }

    private boolean r(RecyclerView.o oVar, int i7, int i8) {
        if (oVar.n()) {
            return i7 > 0;
        }
        return i8 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean s(RecyclerView.o oVar) {
        PointF pointFA;
        int iG0 = oVar.g0();
        if (!(oVar instanceof RecyclerView.z.b) || (pointFA = ((RecyclerView.z.b) oVar).a(iG0 - 1)) == null) {
            return false;
        }
        return pointFA.x < 0.0f || pointFA.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.b0
    @o0
    public int[] c(@m0 RecyclerView.o oVar, @m0 View view) {
        int[] iArr = new int[2];
        if (oVar.n()) {
            iArr[0] = m(oVar, view, o(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.o()) {
            iArr[1] = m(oVar, view, q(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.b0
    protected q f(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new a(this.f9328a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.b0
    @o0
    public View h(RecyclerView.o oVar) {
        if (oVar.o()) {
            return n(oVar, q(oVar));
        }
        if (oVar.n()) {
            return n(oVar, o(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.b0
    public int i(RecyclerView.o oVar, int i7, int i8) {
        w wVarP;
        int iG0 = oVar.g0();
        if (iG0 == 0 || (wVarP = p(oVar)) == null) {
            return -1;
        }
        int iQ = oVar.Q();
        View view = null;
        int i9 = Integer.MAX_VALUE;
        int i10 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i11 = 0; i11 < iQ; i11++) {
            View viewP = oVar.P(i11);
            if (viewP != null) {
                int iM = m(oVar, viewP, wVarP);
                if (iM <= 0 && iM > i10) {
                    view2 = viewP;
                    i10 = iM;
                }
                if (iM >= 0 && iM < i9) {
                    view = viewP;
                    i9 = iM;
                }
            }
        }
        boolean zR = r(oVar, i7, i8);
        if (zR && view != null) {
            return oVar.s0(view);
        }
        if (!zR && view2 != null) {
            return oVar.s0(view2);
        }
        if (zR) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iS0 = oVar.s0(view) + (s(oVar) == zR ? -1 : 1);
        if (iS0 < 0 || iS0 >= iG0) {
            return -1;
        }
        return iS0;
    }
}
