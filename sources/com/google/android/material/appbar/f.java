package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import c.m0;
import c.t0;
import com.google.android.material.internal.n;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f16993a = {R.attr.stateListAnimator};

    f() {
    }

    static void a(@m0 View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(@m0 View view, float f8) {
        int integer = view.getResources().getInteger(com.google.android.material.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j7 = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, com.google.android.material.R.attr.state_liftable, -com.google.android.material.R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j7));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f8).setDuration(j7));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(@m0 View view, AttributeSet attributeSet, int i7, int i8) {
        Context context = view.getContext();
        TypedArray typedArrayJ = n.j(context, attributeSet, f16993a, i7, i8, new int[0]);
        try {
            if (typedArrayJ.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayJ.getResourceId(0, 0)));
            }
        } finally {
            typedArrayJ.recycle();
        }
    }
}
