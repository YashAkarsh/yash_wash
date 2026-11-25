package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class s implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f19138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f19139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f19140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19143f;

    static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f19146c;

        a(View view, float f8, float f9) {
            this.f19144a = view;
            this.f19145b = f8;
            this.f19146c = f9;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19144a.setScaleX(this.f19145b);
            this.f19144a.setScaleY(this.f19146c);
        }
    }

    public s() {
        this(true);
    }

    private static Animator c(View view, float f8, float f9) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f8, scaleX * f9), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f8 * scaleY, f9 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.platform.w
    @o0
    public Animator a(@m0 ViewGroup viewGroup, @m0 View view) {
        return this.f19142e ? c(view, this.f19140c, this.f19141d) : c(view, this.f19139b, this.f19138a);
    }

    @Override // com.google.android.material.transition.platform.w
    @o0
    public Animator b(@m0 ViewGroup viewGroup, @m0 View view) {
        if (this.f19143f) {
            return this.f19142e ? c(view, this.f19138a, this.f19139b) : c(view, this.f19141d, this.f19140c);
        }
        return null;
    }

    public float d() {
        return this.f19141d;
    }

    public float e() {
        return this.f19140c;
    }

    public float f() {
        return this.f19139b;
    }

    public float g() {
        return this.f19138a;
    }

    public boolean h() {
        return this.f19142e;
    }

    public boolean i() {
        return this.f19143f;
    }

    public void j(boolean z7) {
        this.f19142e = z7;
    }

    public void k(float f8) {
        this.f19141d = f8;
    }

    public void l(float f8) {
        this.f19140c = f8;
    }

    public void m(float f8) {
        this.f19139b = f8;
    }

    public void n(float f8) {
        this.f19138a = f8;
    }

    public void o(boolean z7) {
        this.f19143f = z7;
    }

    public s(boolean z7) {
        this.f19138a = 1.0f;
        this.f19139b = 1.1f;
        this.f19140c = 0.8f;
        this.f19141d = 1.0f;
        this.f19143f = true;
        this.f19142e = z7;
    }
}
