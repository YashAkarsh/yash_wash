package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.r0;
import c.x0;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class s implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19178c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @r0
    private int f19180b = -1;

    static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19182b;

        a(View view, float f8) {
            this.f19181a = view;
            this.f19182b = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19181a.setTranslationX(this.f19182b);
        }
    }

    static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19184b;

        b(View view, float f8) {
            this.f19183a = view;
            this.f19184b = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19183a.setTranslationY(this.f19184b);
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public s(int i7) {
        this.f19179a = i7;
    }

    private static Animator c(View view, View view2, int i7, @r0 int i8) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i7 == 3) {
            return e(view2, i8 + translationX, translationX, translationX);
        }
        if (i7 == 5) {
            return e(view2, translationX - i8, translationX, translationX);
        }
        if (i7 == 48) {
            return f(view2, translationY - i8, translationY, translationY);
        }
        if (i7 == 80) {
            return f(view2, i8 + translationY, translationY, translationY);
        }
        if (i7 == 8388611) {
            return e(view2, j(view) ? i8 + translationX : translationX - i8, translationX, translationX);
        }
        if (i7 == 8388613) {
            return e(view2, j(view) ? translationX - i8 : i8 + translationX, translationX, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i7);
    }

    private static Animator d(View view, View view2, int i7, @r0 int i8) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i7 == 3) {
            return e(view2, translationX, translationX - i8, translationX);
        }
        if (i7 == 5) {
            return e(view2, translationX, i8 + translationX, translationX);
        }
        if (i7 == 48) {
            return f(view2, translationY, i8 + translationY, translationY);
        }
        if (i7 == 80) {
            return f(view2, translationY, translationY - i8, translationY);
        }
        if (i7 == 8388611) {
            return e(view2, translationX, j(view) ? translationX - i8 : i8 + translationX, translationX);
        }
        if (i7 == 8388613) {
            return e(view2, translationX, j(view) ? i8 + translationX : translationX - i8, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i7);
    }

    private static Animator e(View view, float f8, float f9, float f10) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f8, f9));
        objectAnimatorOfPropertyValuesHolder.addListener(new a(view, f10));
        return objectAnimatorOfPropertyValuesHolder;
    }

    private static Animator f(View view, float f8, float f9, float f10) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f8, f9));
        objectAnimatorOfPropertyValuesHolder.addListener(new b(view, f10));
        return objectAnimatorOfPropertyValuesHolder;
    }

    private int h(Context context) {
        int i7 = this.f19180b;
        return i7 != -1 ? i7 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean j(View view) {
        return n2.Z(view) == 1;
    }

    @Override // com.google.android.material.transition.v
    @o0
    public Animator a(@m0 ViewGroup viewGroup, @m0 View view) {
        return c(viewGroup, view, this.f19179a, h(view.getContext()));
    }

    @Override // com.google.android.material.transition.v
    @o0
    public Animator b(@m0 ViewGroup viewGroup, @m0 View view) {
        return d(viewGroup, view, this.f19179a, h(view.getContext()));
    }

    @r0
    public int g() {
        return this.f19180b;
    }

    public int i() {
        return this.f19179a;
    }

    public void k(@r0 int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.f19180b = i7;
    }

    public void l(int i7) {
        this.f19179a = i7;
    }
}
