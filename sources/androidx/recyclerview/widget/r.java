package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class r extends b0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f9700g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private w f9701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private w f9702f;

    private float m(RecyclerView.o oVar, w wVar) {
        int iQ = oVar.Q();
        if (iQ == 0) {
            return 1.0f;
        }
        View view = null;
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i9 = 0; i9 < iQ; i9++) {
            View viewP = oVar.P(i9);
            int iS0 = oVar.s0(viewP);
            if (iS0 != -1) {
                if (iS0 < i8) {
                    view = viewP;
                    i8 = iS0;
                }
                if (iS0 > i7) {
                    view2 = viewP;
                    i7 = iS0;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(wVar.d(view), wVar.d(view2)) - Math.min(wVar.g(view), wVar.g(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i7 - i8) + 1);
    }

    private int n(@m0 RecyclerView.o oVar, @m0 View view, w wVar) {
        return (wVar.g(view) + (wVar.e(view) / 2)) - (wVar.n() + (wVar.o() / 2));
    }

    private int o(RecyclerView.o oVar, w wVar, int i7, int i8) {
        int[] iArrD = d(i7, i8);
        float fM = m(oVar, wVar);
        if (fM <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArrD[0]) > Math.abs(iArrD[1]) ? iArrD[0] : iArrD[1]) / fM);
    }

    @o0
    private View p(RecyclerView.o oVar, w wVar) {
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
    private w q(@m0 RecyclerView.o oVar) {
        w wVar = this.f9702f;
        if (wVar == null || wVar.f9741a != oVar) {
            this.f9702f = w.a(oVar);
        }
        return this.f9702f;
    }

    @m0
    private w r(@m0 RecyclerView.o oVar) {
        w wVar = this.f9701e;
        if (wVar == null || wVar.f9741a != oVar) {
            this.f9701e = w.c(oVar);
        }
        return this.f9701e;
    }

    @Override // androidx.recyclerview.widget.b0
    public int[] c(@m0 RecyclerView.o oVar, @m0 View view) {
        int[] iArr = new int[2];
        if (oVar.n()) {
            iArr[0] = n(oVar, view, q(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.o()) {
            iArr[1] = n(oVar, view, r(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.b0
    public View h(RecyclerView.o oVar) {
        if (oVar.o()) {
            return p(oVar, r(oVar));
        }
        if (oVar.n()) {
            return p(oVar, q(oVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.b0
    public int i(RecyclerView.o oVar, int i7, int i8) {
        int iG0;
        View viewH;
        int iS0;
        int i9;
        PointF pointFA;
        int iO;
        int iO2;
        if (!(oVar instanceof RecyclerView.z.b) || (iG0 = oVar.g0()) == 0 || (viewH = h(oVar)) == null || (iS0 = oVar.s0(viewH)) == -1 || (pointFA = ((RecyclerView.z.b) oVar).a((i9 = iG0 - 1))) == null) {
            return -1;
        }
        if (oVar.n()) {
            iO = o(oVar, q(oVar), i7, 0);
            if (pointFA.x < 0.0f) {
                iO = -iO;
            }
        } else {
            iO = 0;
        }
        if (oVar.o()) {
            iO2 = o(oVar, r(oVar), 0, i8);
            if (pointFA.y < 0.0f) {
                iO2 = -iO2;
            }
        } else {
            iO2 = 0;
        }
        if (oVar.o()) {
            iO = iO2;
        }
        if (iO == 0) {
            return -1;
        }
        int i10 = iS0 + iO;
        int i11 = i10 >= 0 ? i10 : 0;
        return i11 >= iG0 ? i9 : i11;
    }
}
