package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.c2;
import androidx.fragment.R;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
class d {

    class a implements androidx.core.os.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f7981a;

        a(Fragment fragment) {
            this.f7981a = fragment;
        }

        @Override // androidx.core.os.e.b
        public void onCancel() {
            if (this.f7981a.getAnimatingAway() != null) {
                View animatingAway = this.f7981a.getAnimatingAway();
                this.f7981a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.f7981a.setAnimator(null);
        }
    }

    class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f7983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w.g f7984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f7985d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f7983b.getAnimatingAway() != null) {
                    b.this.f7983b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.f7984c.a(bVar.f7983b, bVar.f7985d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, w.g gVar, androidx.core.os.e eVar) {
            this.f7982a = viewGroup;
            this.f7983b = fragment;
            this.f7984c = gVar;
            this.f7985d = eVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f7982a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f7987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f7988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f7989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ w.g f7990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ androidx.core.os.e f7991e;

        c(ViewGroup viewGroup, View view, Fragment fragment, w.g gVar, androidx.core.os.e eVar) {
            this.f7987a = viewGroup;
            this.f7988b = view;
            this.f7989c = fragment;
            this.f7990d = gVar;
            this.f7991e = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f7987a.endViewTransition(this.f7988b);
            Animator animator2 = this.f7989c.getAnimator();
            this.f7989c.setAnimator(null);
            if (animator2 == null || this.f7987a.indexOfChild(this.f7988b) >= 0) {
                return;
            }
            this.f7990d.a(this.f7989c, this.f7991e);
        }
    }

    private d() {
    }

    static void a(@m0 Fragment fragment, @m0 C0098d c0098d, @m0 w.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        androidx.core.os.e eVar = new androidx.core.os.e();
        eVar.d(new a(fragment));
        gVar.b(fragment, eVar);
        if (c0098d.f7992a != null) {
            e eVar2 = new e(c0098d.f7992a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar2.setAnimationListener(new b(viewGroup, fragment, gVar, eVar));
            fragment.mView.startAnimation(eVar2);
            return;
        }
        Animator animator = c0098d.f7993b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, eVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z7, boolean z8) {
        if (z8) {
            return z7 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim();
        }
        return z7 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    static C0098d c(@m0 Context context, @m0 Fragment fragment, boolean z7, boolean z8) {
        int nextTransition = fragment.getNextTransition();
        int iB = b(fragment, z7, z8);
        boolean z9 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z7, iB);
        if (animationOnCreateAnimation != null) {
            return new C0098d(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z7, iB);
        if (animatorOnCreateAnimator != null) {
            return new C0098d(animatorOnCreateAnimator);
        }
        if (iB == 0 && nextTransition != 0) {
            iB = d(nextTransition, z7);
        }
        if (iB != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iB));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iB);
                    if (animationLoadAnimation != null) {
                        return new C0098d(animationLoadAnimation);
                    }
                    z9 = true;
                } catch (Resources.NotFoundException e8) {
                    throw e8;
                } catch (RuntimeException unused) {
                }
            }
            if (!z9) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iB);
                    if (animatorLoadAnimator != null) {
                        return new C0098d(animatorLoadAnimator);
                    }
                } catch (RuntimeException e9) {
                    if (zEquals) {
                        throw e9;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iB);
                    if (animationLoadAnimation2 != null) {
                        return new C0098d(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    @c.a
    private static int d(int i7, boolean z7) {
        if (i7 == 4097) {
            return z7 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
        }
        if (i7 == 4099) {
            return z7 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
        }
        if (i7 != 8194) {
            return -1;
        }
        return z7 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    static class C0098d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f7992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f7993b;

        C0098d(Animation animation) {
            this.f7992a = animation;
            this.f7993b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        C0098d(Animator animator) {
            this.f7992a = null;
            this.f7993b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class e extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f7994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f7995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f7996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f7997d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f7998e;

        e(@m0 Animation animation, @m0 ViewGroup viewGroup, @m0 View view) {
            super(false);
            this.f7998e = true;
            this.f7994a = viewGroup;
            this.f7995b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j7, @m0 Transformation transformation) {
            this.f7998e = true;
            if (this.f7996c) {
                return !this.f7997d;
            }
            if (!super.getTransformation(j7, transformation)) {
                this.f7996c = true;
                c2.a(this.f7994a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7996c || !this.f7998e) {
                this.f7994a.endViewTransition(this.f7995b);
                this.f7997d = true;
            } else {
                this.f7998e = false;
                this.f7994a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j7, @m0 Transformation transformation, float f8) {
            this.f7998e = true;
            if (this.f7996c) {
                return !this.f7997d;
            }
            if (!super.getTransformation(j7, transformation, f8)) {
                this.f7996c = true;
                c2.a(this.f7994a, this);
            }
            return true;
        }
    }
}
