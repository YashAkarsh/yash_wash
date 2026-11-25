package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {
    private static final String W = "android:changeScroll:x";
    private static final String X = "android:changeScroll:y";
    private static final String[] Y = {W, X};

    public ChangeScroll() {
    }

    private void D0(d0 d0Var) {
        d0Var.f10674a.put(W, Integer.valueOf(d0Var.f10675b.getScrollX()));
        d0Var.f10674a.put(X, Integer.valueOf(d0Var.f10675b.getScrollY()));
    }

    @Override // androidx.transition.Transition
    @c.o0
    public String[] V() {
        return Y;
    }

    @Override // androidx.transition.Transition
    public void k(@c.m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    @c.o0
    public Animator r(@c.m0 ViewGroup viewGroup, @c.o0 d0 d0Var, @c.o0 d0 d0Var2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (d0Var == null || d0Var2 == null) {
            return null;
        }
        View view = d0Var2.f10675b;
        int iIntValue = ((Integer) d0Var.f10674a.get(W)).intValue();
        int iIntValue2 = ((Integer) d0Var2.f10674a.get(W)).intValue();
        int iIntValue3 = ((Integer) d0Var.f10674a.get(X)).intValue();
        int iIntValue4 = ((Integer) d0Var2.f10674a.get(X)).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return c0.c(objectAnimatorOfInt, objectAnimatorOfInt2);
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
