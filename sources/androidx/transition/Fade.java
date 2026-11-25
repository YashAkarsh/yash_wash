package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {
    private static final String D0 = "android:fade:transitionAlpha";
    private static final String E0 = "Fade";
    public static final int F0 = 1;
    public static final int G0 = 2;

    class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f10602a;

        a(View view) {
            this.f10602a = view;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            q0.h(this.f10602a, 1.0f);
            q0.a(this.f10602a);
            transition.j0(this);
        }
    }

    private static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f10604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f10605b = false;

        b(View view) {
            this.f10604a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            q0.h(this.f10604a, 1.0f);
            if (this.f10605b) {
                this.f10604a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (n2.L0(this.f10604a) && this.f10604a.getLayerType() == 0) {
                this.f10605b = true;
                this.f10604a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i7) {
        L0(i7);
    }

    private Animator M0(View view, float f8, float f9) {
        if (f8 == f9) {
            return null;
        }
        q0.h(view, f8);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, q0.f10770c, f9);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }

    private static float N0(d0 d0Var, float f8) {
        Float f9;
        return (d0Var == null || (f9 = (Float) d0Var.f10674a.get(D0)) == null) ? f8 : f9.floatValue();
    }

    @Override // androidx.transition.Visibility
    public Animator H0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        float fN0 = N0(d0Var, 0.0f);
        return M0(view, fN0 != 1.0f ? fN0 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator J0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        q0.e(view);
        return M0(view, N0(d0Var, 1.0f), 0.0f);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        super.n(d0Var);
        d0Var.f10674a.put(D0, Float.valueOf(q0.c(d0Var.f10675b)));
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10787f);
        L0(androidx.core.content.res.q.k(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, E0()));
        typedArrayObtainStyledAttributes.recycle();
    }
}
