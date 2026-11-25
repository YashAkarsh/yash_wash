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
public final class d implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f19007a = 1.0f;

    static class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f19010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f19011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f19012e;

        a(View view, float f8, float f9, float f10, float f11) {
            this.f19008a = view;
            this.f19009b = f8;
            this.f19010c = f9;
            this.f19011d = f10;
            this.f19012e = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f19008a.setAlpha(v.o(this.f19009b, this.f19010c, this.f19011d, this.f19012e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19014b;

        b(View view, float f8) {
            this.f19013a = view;
            this.f19014b = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19013a.setAlpha(this.f19014b);
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
        return c(view, 0.0f, alpha, 0.0f, this.f19007a, alpha);
    }

    @Override // com.google.android.material.transition.platform.w
    @o0
    public Animator b(@m0 ViewGroup viewGroup, @m0 View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }

    public float d() {
        return this.f19007a;
    }

    public void e(float f8) {
        this.f19007a = f8;
    }
}
