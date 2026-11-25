package com.google.android.material.transition.platform;

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
import c.t0;
import c.x0;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class t implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19147c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @r0
    private int f19149b = -1;

    static class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19151b;

        a(View view, float f8) {
            this.f19150a = view;
            this.f19151b = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19150a.setTranslationX(this.f19151b);
        }
    }

    static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f19153b;

        b(View view, float f8) {
            this.f19152a = view;
            this.f19153b = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19152a.setTranslationY(this.f19153b);
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public t(int i7) {
        this.f19148a = i7;
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
        int i7 = this.f19149b;
        return i7 != -1 ? i7 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean j(View view) {
        return n2.Z(view) == 1;
    }

    @Override // com.google.android.material.transition.platform.w
    @o0
    public Animator a(@m0 ViewGroup viewGroup, @m0 View view) {
        return c(viewGroup, view, this.f19148a, h(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.w
    @o0
    public Animator b(@m0 ViewGroup viewGroup, @m0 View view) {
        return d(viewGroup, view, this.f19148a, h(view.getContext()));
    }

    @r0
    public int g() {
        return this.f19149b;
    }

    public int i() {
        return this.f19148a;
    }

    public void k(@r0 int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.f19149b = i7;
    }

    public void l(int i7) {
        this.f19148a = i7;
    }
}
