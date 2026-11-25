package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class r implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f19169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f19170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f19171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19174f;

    static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f19177c;

        a(View view, float f8, float f9) {
            this.f19175a = view;
            this.f19176b = f8;
            this.f19177c = f9;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19175a.setScaleX(this.f19176b);
            this.f19175a.setScaleY(this.f19177c);
        }
    }

    public r() {
        this(true);
    }

    private static Animator c(View view, float f8, float f9) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f8, scaleX * f9), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f8 * scaleY, f9 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.v
    @o0
    public Animator a(@m0 ViewGroup viewGroup, @m0 View view) {
        return this.f19173e ? c(view, this.f19171c, this.f19172d) : c(view, this.f19170b, this.f19169a);
    }

    @Override // com.google.android.material.transition.v
    @o0
    public Animator b(@m0 ViewGroup viewGroup, @m0 View view) {
        if (this.f19174f) {
            return this.f19173e ? c(view, this.f19169a, this.f19170b) : c(view, this.f19172d, this.f19171c);
        }
        return null;
    }

    public float d() {
        return this.f19172d;
    }

    public float e() {
        return this.f19171c;
    }

    public float f() {
        return this.f19170b;
    }

    public float g() {
        return this.f19169a;
    }

    public boolean h() {
        return this.f19173e;
    }

    public boolean i() {
        return this.f19174f;
    }

    public void j(boolean z7) {
        this.f19173e = z7;
    }

    public void k(float f8) {
        this.f19172d = f8;
    }

    public void l(float f8) {
        this.f19171c = f8;
    }

    public void m(float f8) {
        this.f19170b = f8;
    }

    public void n(float f8) {
        this.f19169a = f8;
    }

    public void o(boolean z7) {
        this.f19174f = z7;
    }

    public r(boolean z7) {
        this.f19169a = 1.0f;
        this.f19170b = 1.1f;
        this.f19171c = 0.8f;
        this.f19172d = 1.0f;
        this.f19174f = true;
        this.f19173e = z7;
    }
}
