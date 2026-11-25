package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.m0;
import c.o0;
import c.q;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final int f17043e = 225;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final int f17044f = 175;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f17045g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f17046h = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private ViewPropertyAnimator f17050d;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f17050d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f17047a = 0;
        this.f17048b = 2;
        this.f17049c = 0;
    }

    private void H(@m0 V v7, int i7, long j7, TimeInterpolator timeInterpolator) {
        this.f17050d = v7.animate().translationY(i7).setInterpolator(timeInterpolator).setDuration(j7).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean B(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, @m0 View view2, int i7, int i8) {
        return i7 == 2;
    }

    public void I(@m0 V v7, @q int i7) {
        this.f17049c = i7;
        if (this.f17048b == 1) {
            v7.setTranslationY(this.f17047a + i7);
        }
    }

    public void J(@m0 V v7) {
        if (this.f17048b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f17050d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v7.clearAnimation();
        }
        this.f17048b = 1;
        H(v7, this.f17047a + this.f17049c, 175L, com.google.android.material.animation.a.f16848c);
    }

    public void K(@m0 V v7) {
        if (this.f17048b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f17050d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v7.clearAnimation();
        }
        this.f17048b = 2;
        H(v7, 0, 225L, com.google.android.material.animation.a.f16849d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, int i7) {
        this.f17047a = v7.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v7.getLayoutParams()).bottomMargin;
        return super.m(coordinatorLayout, v7, i7);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void u(CoordinatorLayout coordinatorLayout, @m0 V v7, @m0 View view, int i7, int i8, int i9, int i10, int i11, @m0 int[] iArr) {
        if (i8 > 0) {
            J(v7);
        } else if (i8 < 0) {
            K(v7);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17047a = 0;
        this.f17048b = 2;
        this.f17049c = 0;
    }
}
