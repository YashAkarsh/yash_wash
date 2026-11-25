package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class f0 {

    private static class a extends AnimatorListenerAdapter implements Transition.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f10693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f10694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f10695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f10696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f10697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f10698f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f10699g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f10700h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final float f10701i;

        a(View view, View view2, int i7, int i8, float f8, float f9) {
            this.f10694b = view;
            this.f10693a = view2;
            this.f10695c = i7 - Math.round(view.getTranslationX());
            this.f10696d = i8 - Math.round(view.getTranslationY());
            this.f10700h = f8;
            this.f10701i = f9;
            int[] iArr = (int[]) view2.getTag(R.id.transition_position);
            this.f10697e = iArr;
            if (iArr != null) {
                view2.setTag(R.id.transition_position, null);
            }
        }

        @Override // androidx.transition.Transition.h
        public void a(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void b(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            this.f10694b.setTranslationX(this.f10700h);
            this.f10694b.setTranslationY(this.f10701i);
            transition.j0(this);
        }

        @Override // androidx.transition.Transition.h
        public void d(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void e(@c.m0 Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f10697e == null) {
                this.f10697e = new int[2];
            }
            this.f10697e[0] = Math.round(this.f10695c + this.f10694b.getTranslationX());
            this.f10697e[1] = Math.round(this.f10696d + this.f10694b.getTranslationY());
            this.f10693a.setTag(R.id.transition_position, this.f10697e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f10698f = this.f10694b.getTranslationX();
            this.f10699g = this.f10694b.getTranslationY();
            this.f10694b.setTranslationX(this.f10700h);
            this.f10694b.setTranslationY(this.f10701i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f10694b.setTranslationX(this.f10698f);
            this.f10694b.setTranslationY(this.f10699g);
        }
    }

    private f0() {
    }

    @c.o0
    static Animator a(@c.m0 View view, @c.m0 d0 d0Var, int i7, int i8, float f8, float f9, float f10, float f11, @c.o0 TimeInterpolator timeInterpolator, @c.m0 Transition transition) {
        float f12;
        float f13;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) d0Var.f10675b.getTag(R.id.transition_position);
        if (iArr != null) {
            f12 = (iArr[0] - i7) + translationX;
            f13 = (iArr[1] - i8) + translationY;
        } else {
            f12 = f8;
            f13 = f9;
        }
        int iRound = i7 + Math.round(f12 - translationX);
        int iRound2 = i8 + Math.round(f13 - translationY);
        view.setTranslationX(f12);
        view.setTranslationY(f13);
        if (f12 == f10 && f13 == f11) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f12, f10), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f13, f11));
        a aVar = new a(view, d0Var.f10675b, iRound, iRound2, translationX, translationY);
        transition.a(aVar);
        objectAnimatorOfPropertyValuesHolder.addListener(aVar);
        androidx.transition.a.a(objectAnimatorOfPropertyValuesHolder, aVar);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
