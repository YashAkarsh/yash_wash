package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String X = "android:clipBounds:bounds";
    private static final String W = "android:clipBounds:clip";
    private static final String[] Y = {W};

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f10576a;

        a(View view) {
            this.f10576a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            n2.M1(this.f10576a, null);
        }
    }

    public ChangeClipBounds() {
    }

    private void D0(d0 d0Var) {
        View view = d0Var.f10675b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rectP = n2.P(view);
        d0Var.f10674a.put(W, rectP);
        if (rectP == null) {
            d0Var.f10674a.put(X, new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
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
    public Animator r(@c.m0 ViewGroup viewGroup, d0 d0Var, d0 d0Var2) {
        ObjectAnimator objectAnimatorOfObject = null;
        if (d0Var != null && d0Var2 != null && d0Var.f10674a.containsKey(W) && d0Var2.f10674a.containsKey(W)) {
            Rect rect = (Rect) d0Var.f10674a.get(W);
            Rect rect2 = (Rect) d0Var2.f10674a.get(W);
            boolean z7 = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) d0Var.f10674a.get(X);
            } else if (rect2 == null) {
                rect2 = (Rect) d0Var2.f10674a.get(X);
            }
            if (rect.equals(rect2)) {
                return null;
            }
            n2.M1(d0Var2.f10675b, rect);
            objectAnimatorOfObject = ObjectAnimator.ofObject(d0Var2.f10675b, (Property<View, V>) q0.f10771d, (TypeEvaluator) new t(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z7) {
                objectAnimatorOfObject.addListener(new a(d0Var2.f10675b));
            }
        }
        return objectAnimatorOfObject;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
