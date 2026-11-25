package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class e extends e1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f10684d = 3.0f;

    private static float h(float f8, float f9, float f10, float f11) {
        float f12 = f10 - f8;
        float f13 = f11 - f9;
        return (float) Math.sqrt((f12 * f12) + (f13 * f13));
    }

    @Override // androidx.transition.a0
    public long c(ViewGroup viewGroup, Transition transition, d0 d0Var, d0 d0Var2) {
        int i7;
        int iRound;
        int iCenterX;
        if (d0Var == null && d0Var2 == null) {
            return 0L;
        }
        if (d0Var2 == null || e(d0Var) == 0) {
            i7 = -1;
        } else {
            d0Var = d0Var2;
            i7 = 1;
        }
        int iF = f(d0Var);
        int iG = g(d0Var);
        Rect rectH = transition.H();
        if (rectH != null) {
            iCenterX = rectH.centerX();
            iRound = rectH.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int iRound2 = Math.round(iArr[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(iArr[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fH = h(iF, iG, iCenterX, iRound) / h(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long jG = transition.G();
        if (jG < 0) {
            jG = 300;
        }
        return Math.round(((jG * ((long) i7)) / this.f10684d) * fH);
    }

    public void i(float f8) {
        if (f8 == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.f10684d = f8;
    }
}
