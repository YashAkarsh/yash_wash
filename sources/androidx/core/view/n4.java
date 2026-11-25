package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class n4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f6763e = 2113929216;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f6764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f6765b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Runnable f6766c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6767d = -1;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o4 f6768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6769b;

        a(o4 o4Var, View view) {
            this.f6768a = o4Var;
            this.f6769b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6768a.a(this.f6769b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6768a.b(this.f6769b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f6768a.c(this.f6769b);
        }
    }

    @c.t0(16)
    static class b {
        private b() {
        }

        @c.t
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        @c.t
        static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }

        @c.t
        static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withStartAction(runnable);
        }
    }

    @c.t0(18)
    static class c {
        private c() {
        }

        @c.t
        static Interpolator a(ViewPropertyAnimator viewPropertyAnimator) {
            return (Interpolator) viewPropertyAnimator.getInterpolator();
        }
    }

    @c.t0(19)
    static class d {
        private d() {
        }

        @c.t
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    @c.t0(21)
    static class e {
        private e() {
        }

        @c.t
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, float f8) {
            return viewPropertyAnimator.translationZ(f8);
        }

        @c.t
        static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator, float f8) {
            return viewPropertyAnimator.translationZBy(f8);
        }

        @c.t
        static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, float f8) {
            return viewPropertyAnimator.z(f8);
        }

        @c.t
        static ViewPropertyAnimator d(ViewPropertyAnimator viewPropertyAnimator, float f8) {
            return viewPropertyAnimator.zBy(f8);
        }
    }

    static class f implements o4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        n4 f6771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f6772b;

        f(n4 n4Var) {
            this.f6771a = n4Var;
        }

        @Override // androidx.core.view.o4
        public void a(@c.m0 View view) {
            Object tag = view.getTag(n4.f6763e);
            o4 o4Var = tag instanceof o4 ? (o4) tag : null;
            if (o4Var != null) {
                o4Var.a(view);
            }
        }

        @Override // androidx.core.view.o4
        @SuppressLint({"WrongConstant"})
        public void b(@c.m0 View view) {
            int i7 = this.f6771a.f6767d;
            if (i7 > -1) {
                view.setLayerType(i7, null);
                this.f6771a.f6767d = -1;
            }
            n4 n4Var = this.f6771a;
            Runnable runnable = n4Var.f6766c;
            if (runnable != null) {
                n4Var.f6766c = null;
                runnable.run();
            }
            Object tag = view.getTag(n4.f6763e);
            o4 o4Var = tag instanceof o4 ? (o4) tag : null;
            if (o4Var != null) {
                o4Var.b(view);
            }
            this.f6772b = true;
        }

        @Override // androidx.core.view.o4
        public void c(@c.m0 View view) {
            this.f6772b = false;
            if (this.f6771a.f6767d > -1) {
                view.setLayerType(2, null);
            }
            n4 n4Var = this.f6771a;
            Runnable runnable = n4Var.f6765b;
            if (runnable != null) {
                n4Var.f6765b = null;
                runnable.run();
            }
            Object tag = view.getTag(n4.f6763e);
            o4 o4Var = tag instanceof o4 ? (o4) tag : null;
            if (o4Var != null) {
                o4Var.c(view);
            }
        }
    }

    n4(View view) {
        this.f6764a = new WeakReference<>(view);
    }

    private void v(View view, o4 o4Var) {
        if (o4Var != null) {
            view.animate().setListener(new a(o4Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    @c.m0
    public n4 A(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().translationXBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 B(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().translationY(f8);
        }
        return this;
    }

    @c.m0
    public n4 C(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().translationYBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 D(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            e.a(view.animate(), f8);
        }
        return this;
    }

    @c.m0
    public n4 E(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            e.b(view.animate(), f8);
        }
        return this;
    }

    @c.m0
    public n4 F(@c.m0 Runnable runnable) {
        View view = this.f6764a.get();
        if (view != null) {
            b.a(view.animate(), runnable);
        }
        return this;
    }

    @c.m0
    @SuppressLint({"WrongConstant"})
    public n4 G() {
        View view = this.f6764a.get();
        if (view != null) {
            b.b(view.animate());
        }
        return this;
    }

    @c.m0
    public n4 H(@c.m0 Runnable runnable) {
        View view = this.f6764a.get();
        if (view != null) {
            b.c(view.animate(), runnable);
        }
        return this;
    }

    @c.m0
    public n4 I(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().x(f8);
        }
        return this;
    }

    @c.m0
    public n4 J(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().xBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 K(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().y(f8);
        }
        return this;
    }

    @c.m0
    public n4 L(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().yBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 M(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            e.c(view.animate(), f8);
        }
        return this;
    }

    @c.m0
    public n4 N(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            e.d(view.animate(), f8);
        }
        return this;
    }

    @c.m0
    public n4 b(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().alpha(f8);
        }
        return this;
    }

    @c.m0
    public n4 c(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().alphaBy(f8);
        }
        return this;
    }

    public void d() {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long e() {
        View view = this.f6764a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    @c.o0
    public Interpolator f() {
        View view = this.f6764a.get();
        if (view != null) {
            return c.a(view.animate());
        }
        return null;
    }

    public long g() {
        View view = this.f6764a.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    @c.m0
    public n4 i(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().rotation(f8);
        }
        return this;
    }

    @c.m0
    public n4 j(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().rotationBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 k(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().rotationX(f8);
        }
        return this;
    }

    @c.m0
    public n4 l(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().rotationXBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 m(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().rotationY(f8);
        }
        return this;
    }

    @c.m0
    public n4 n(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().rotationYBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 o(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().scaleX(f8);
        }
        return this;
    }

    @c.m0
    public n4 p(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().scaleXBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 q(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().scaleY(f8);
        }
        return this;
    }

    @c.m0
    public n4 r(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().scaleYBy(f8);
        }
        return this;
    }

    @c.m0
    public n4 s(long j7) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().setDuration(j7);
        }
        return this;
    }

    @c.m0
    public n4 t(@c.o0 Interpolator interpolator) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @c.m0
    public n4 u(@c.o0 o4 o4Var) {
        View view = this.f6764a.get();
        if (view != null) {
            v(view, o4Var);
        }
        return this;
    }

    @c.m0
    public n4 w(long j7) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().setStartDelay(j7);
        }
        return this;
    }

    @c.m0
    public n4 x(@c.o0 final q4 q4Var) {
        final View view = this.f6764a.get();
        if (view != null) {
            d.a(view.animate(), q4Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.m4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    q4Var.a(view);
                }
            } : null);
        }
        return this;
    }

    public void y() {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @c.m0
    public n4 z(float f8) {
        View view = this.f6764a.get();
        if (view != null) {
            view.animate().translationX(f8);
        }
        return this;
    }
}
