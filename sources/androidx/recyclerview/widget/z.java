package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class z {
    private z() {
    }

    static int a(RecyclerView.a0 a0Var, w wVar, View view, View view2, RecyclerView.o oVar, boolean z7) {
        if (oVar.Q() == 0 || a0Var.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z7) {
            return Math.abs(oVar.s0(view) - oVar.s0(view2)) + 1;
        }
        return Math.min(wVar.o(), wVar.d(view2) - wVar.g(view));
    }

    static int b(RecyclerView.a0 a0Var, w wVar, View view, View view2, RecyclerView.o oVar, boolean z7, boolean z8) {
        if (oVar.Q() == 0 || a0Var.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z8 ? Math.max(0, (a0Var.d() - Math.max(oVar.s0(view), oVar.s0(view2))) - 1) : Math.max(0, Math.min(oVar.s0(view), oVar.s0(view2)));
        if (z7) {
            return Math.round((iMax * (Math.abs(wVar.d(view2) - wVar.g(view)) / (Math.abs(oVar.s0(view) - oVar.s0(view2)) + 1))) + (wVar.n() - wVar.g(view)));
        }
        return iMax;
    }

    static int c(RecyclerView.a0 a0Var, w wVar, View view, View view2, RecyclerView.o oVar, boolean z7) {
        if (oVar.Q() == 0 || a0Var.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z7) {
            return a0Var.d();
        }
        return (int) (((wVar.d(view2) - wVar.g(view)) / (Math.abs(oVar.s0(view) - oVar.s0(view2)) + 1)) * a0Var.d());
    }
}
