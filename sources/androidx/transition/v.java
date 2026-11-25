package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
public class v extends e1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f10780d = 3.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10781e = 80;

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    private int h(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        int i15 = this.f10781e;
        if (i15 == 8388611) {
            if (n2.Z(view) == 1) {
                i15 = 5;
            } else {
                i15 = 3;
            }
        } else if (i15 == 8388613) {
            if (n2.Z(view) == 1) {
                i15 = 3;
            } else {
                i15 = 5;
            }
        }
        if (i15 == 3) {
            return (i13 - i7) + Math.abs(i10 - i8);
        }
        if (i15 == 5) {
            return (i7 - i11) + Math.abs(i10 - i8);
        }
        if (i15 == 48) {
            return (i14 - i8) + Math.abs(i9 - i7);
        }
        if (i15 != 80) {
            return 0;
        }
        return (i8 - i12) + Math.abs(i9 - i7);
    }

    private int i(ViewGroup viewGroup) {
        int i7 = this.f10781e;
        return (i7 == 3 || i7 == 5 || i7 == 8388611 || i7 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // androidx.transition.a0
    public long c(ViewGroup viewGroup, Transition transition, d0 d0Var, d0 d0Var2) {
        int i7;
        int iCenterX;
        int iCenterY;
        d0 d0Var3 = d0Var;
        if (d0Var3 == null && d0Var2 == null) {
            return 0L;
        }
        Rect rectH = transition.H();
        if (d0Var2 == null || e(d0Var3) == 0) {
            i7 = -1;
        } else {
            d0Var3 = d0Var2;
            i7 = 1;
        }
        int iF = f(d0Var3);
        int iG = g(d0Var3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (rectH != null) {
            iCenterX = rectH.centerX();
            iCenterY = rectH.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fH = h(viewGroup, iF, iG, iCenterX, iCenterY, iRound, iRound2, width, height) / i(viewGroup);
        long jG = transition.G();
        if (jG < 0) {
            jG = 300;
        }
        return Math.round(((jG * ((long) i7)) / this.f10780d) * fH);
    }

    public void j(float f8) {
        if (f8 == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.f10780d = f8;
    }

    public void k(int i7) {
        this.f10781e = i7;
    }
}
