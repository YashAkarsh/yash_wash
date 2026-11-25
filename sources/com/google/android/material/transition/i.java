package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Visibility;
import androidx.transition.d0;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class i extends Visibility {
    @Override // androidx.transition.Visibility
    @m0
    public Animator H0(@m0 ViewGroup viewGroup, @m0 View view, @o0 d0 d0Var, @o0 d0 d0Var2) {
        return ValueAnimator.ofFloat(0.0f);
    }

    @Override // androidx.transition.Visibility
    @m0
    public Animator J0(@m0 ViewGroup viewGroup, @m0 View view, @o0 d0 d0Var, @o0 d0 d0Var2) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
