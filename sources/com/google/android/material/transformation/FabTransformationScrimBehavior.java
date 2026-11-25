package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.m0;
import com.google.android.material.animation.b;
import com.google.android.material.animation.i;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f18897h = 75;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f18898i = 150;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f18899j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f18900k = 150;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f18901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f18902g;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f18904b;

        a(boolean z7, View view) {
            this.f18903a = z7;
            this.f18904b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f18903a) {
                return;
            }
            this.f18904b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f18903a) {
                this.f18904b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f18901f = new i(75L, 150L);
        this.f18902g = new i(0L, 150L);
    }

    private void N(@m0 View view, boolean z7, boolean z8, @m0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        i iVar = z7 ? this.f18901f : this.f18902g;
        if (z7) {
            if (!z8) {
                view.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        iVar.a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean E(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, @m0 MotionEvent motionEvent) {
        return super.E(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @m0
    protected AnimatorSet M(@m0 View view, @m0 View view2, boolean z7, boolean z8) {
        ArrayList arrayList = new ArrayList();
        N(view2, z7, z8, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z7, view2));
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean f(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18901f = new i(75L, 150L);
        this.f18902g = new i(0L, 150L);
    }
}
