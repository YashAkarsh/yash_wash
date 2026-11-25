package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.i;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private AnimatorSet f18876e;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f18876e = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    @i
    protected boolean K(View view, View view2, boolean z7, boolean z8) {
        AnimatorSet animatorSet = this.f18876e;
        boolean z9 = animatorSet != null;
        if (z9) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetM = M(view, view2, z7, z9);
        this.f18876e = animatorSetM;
        animatorSetM.addListener(new a());
        this.f18876e.start();
        if (!z8) {
            this.f18876e.end();
        }
        return true;
    }

    @m0
    protected abstract AnimatorSet M(View view, View view2, boolean z7, boolean z8);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
