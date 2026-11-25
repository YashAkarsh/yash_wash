package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class e implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final float f18922b = 0.35f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f18923a = f18922b;

    static class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f18924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f18925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f18926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f18927d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f18928e;

        a(View view, float f8, float f9, float f10, float f11) {
            this.f18924a = view;
            this.f18925b = f8;
            this.f18926c = f9;
            this.f18927d = f10;
            this.f18928e = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18924a.setAlpha(u.o(this.f18925b, this.f18926c, this.f18927d, this.f18928e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f18929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f18930b;

        b(View view, float f8) {
            this.f18929a = view;
            this.f18930b = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f18929a.setAlpha(this.f18930b);
        }
    }

    private static Animator c(View view, float f8, float f9, @c.v(from = 0.0d, to = 1.0d) float f10, @c.v(from = 0.0d, to = 1.0d) float f11, float f12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(view, f8, f9, f10, f11));
        valueAnimatorOfFloat.addListener(new b(view, f12));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.v
    @o0
    public Animator a(@m0 ViewGroup viewGroup, @m0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, this.f18923a, 1.0f, alpha);
    }

    @Override // com.google.android.material.transition.v
    @o0
    public Animator b(@m0 ViewGroup viewGroup, @m0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, this.f18923a, alpha);
    }

    public float d() {
        return this.f18923a;
    }

    public void e(@c.v(from = 0.0d, to = 1.0d) float f8) {
        this.f18923a = f8;
    }
}
