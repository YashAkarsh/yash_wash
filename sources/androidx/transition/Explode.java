package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {
    private static final TimeInterpolator E0 = new DecelerateInterpolator();
    private static final TimeInterpolator F0 = new AccelerateInterpolator();
    private static final String G0 = "android:explode:screenBounds";
    private int[] D0;

    public Explode() {
        this.D0 = new int[2];
        y0(new e());
    }

    private void D0(d0 d0Var) {
        View view = d0Var.f10675b;
        view.getLocationOnScreen(this.D0);
        int[] iArr = this.D0;
        int i7 = iArr[0];
        int i8 = iArr[1];
        d0Var.f10674a.put(G0, new Rect(i7, i8, view.getWidth() + i7, view.getHeight() + i8));
    }

    private static float M0(float f8, float f9) {
        return (float) Math.sqrt((f8 * f8) + (f9 * f9));
    }

    private static float N0(View view, int i7, int i8) {
        return M0(Math.max(i7, view.getWidth() - i7), Math.max(i8, view.getHeight() - i8));
    }

    private void O0(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.D0);
        int[] iArr2 = this.D0;
        int i7 = iArr2[0];
        int i8 = iArr2[1];
        Rect rectH = H();
        if (rectH == null) {
            width = (view.getWidth() / 2) + i7 + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i8 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectH.centerX();
            iCenterY = rectH.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fM0 = M0(fCenterX, fCenterY);
        float fN0 = N0(view, width - i7, iCenterY - i8);
        iArr[0] = Math.round((fCenterX / fM0) * fN0);
        iArr[1] = Math.round(fN0 * (fCenterY / fM0));
    }

    @Override // androidx.transition.Visibility
    public Animator H0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        if (d0Var2 == null) {
            return null;
        }
        Rect rect = (Rect) d0Var2.f10674a.get(G0);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        O0(viewGroup, rect, this.D0);
        int[] iArr = this.D0;
        return f0.a(view, d0Var2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, E0, this);
    }

    @Override // androidx.transition.Visibility
    public Animator J0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        float f8;
        float f9;
        if (d0Var == null) {
            return null;
        }
        Rect rect = (Rect) d0Var.f10674a.get(G0);
        int i7 = rect.left;
        int i8 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) d0Var.f10675b.getTag(R.id.transition_position);
        if (iArr != null) {
            int i9 = iArr[0];
            f8 = (i9 - rect.left) + translationX;
            int i10 = iArr[1];
            f9 = (i10 - rect.top) + translationY;
            rect.offsetTo(i9, i10);
        } else {
            f8 = translationX;
            f9 = translationY;
        }
        O0(viewGroup, rect, this.D0);
        int[] iArr2 = this.D0;
        return f0.a(view, d0Var, i7, i8, translationX, translationY, f8 + iArr2[0], f9 + iArr2[1], F0, this);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void k(@c.m0 d0 d0Var) {
        super.k(d0Var);
        D0(d0Var);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        super.n(d0Var);
        D0(d0Var);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D0 = new int[2];
        y0(new e());
    }
}
