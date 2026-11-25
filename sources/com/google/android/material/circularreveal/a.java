package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.a$a, reason: collision with other inner class name */
    static class C0194a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f17376a;

        C0194a(c cVar) {
            this.f17376a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f17376a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f17376a.a();
        }
    }

    private a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m0
    public static Animator a(@m0 c cVar, float f8, float f9, float f10) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(cVar, (Property<c, V>) c.C0196c.f17394a, (TypeEvaluator) c.b.f17392b, (Object[]) new c.e[]{new c.e(f8, f9, f10)});
        c.e revealInfo = cVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f8, (int) f9, revealInfo.f17399c, f10);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m0
    public static Animator b(c cVar, float f8, float f9, float f10, float f11) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(cVar, (Property<c, V>) c.C0196c.f17394a, (TypeEvaluator) c.b.f17392b, (Object[]) new c.e[]{new c.e(f8, f9, f10), new c.e(f8, f9, f11)});
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f8, (int) f9, f10, f11);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    @m0
    public static Animator.AnimatorListener c(@m0 c cVar) {
        return new C0194a(cVar);
    }
}
