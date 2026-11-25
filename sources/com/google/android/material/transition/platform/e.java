package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class e implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final float f19015b = 0.35f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f19016a = f19015b;

    static class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f19019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f19020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f19021e;

        a(View view, float f8, float f9, float f10, float f11) {
            this.f19017a = view;
            this.f19018b = f8;
            this.f19019c = f9;
            this.f19020d = f10;
            this.f19021e = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f19017a.setAlpha(v.o(this.f19018b, this.f19019c, this.f19020d, this.f19021e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19023b;

        b(View view, float f8) {
            this.f19022a = view;
            this.f19023b = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19022a.setAlpha(this.f19023b);
        }
    }

    private static Animator c(View view, float f8, float f9, @c.v(from = 0.0d, to = 1.0d) float f10, @c.v(from = 0.0d, to = 1.0d) float f11, float f12) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(view, f8, f9, f10, f11));
        valueAnimatorOfFloat.addListener(new b(view, f12));
        return valueAnimatorOfFloat;
    }

    @Override // com.google.android.material.transition.platform.w
    @o0
    public Animator a(@m0 ViewGroup viewGroup, @m0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, this.f19016a, 1.0f, alpha);
    }

    @Override // com.google.android.material.transition.platform.w
    @o0
    public Animator b(@m0 ViewGroup viewGroup, @m0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, this.f19016a, alpha);
    }

    public float d() {
        return this.f19016a;
    }

    public void e(@c.v(from = 0.0d, to = 1.0d) float f8) {
        this.f19016a = f8;
    }
}
