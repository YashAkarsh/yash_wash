package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class i extends Visibility {
    @Override // android.transition.Visibility
    @m0
    public Animator onAppear(@m0 ViewGroup viewGroup, @m0 View view, @o0 TransitionValues transitionValues, @o0 TransitionValues transitionValues2) {
        return ValueAnimator.ofFloat(0.0f);
    }

    @Override // android.transition.Visibility
    @m0
    public Animator onDisappear(@m0 ViewGroup viewGroup, @m0 View view, @o0 TransitionValues transitionValues, @o0 TransitionValues transitionValues2) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
