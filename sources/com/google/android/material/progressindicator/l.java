package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import c.g1;
import c.m0;
import com.google.android.material.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class l extends h<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f18112l = 1800;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f18113m = {533, 567, 850, 750};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f18114n = {1267, 1000, 333, 0};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Property<l, Float> f18115o = new b(Float.class, "animationFraction");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f18116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Interpolator[] f18117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f18118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f18121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b.a f18123k;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (l.this.f18122j) {
                l.this.f18116d.setRepeatCount(-1);
                l lVar = l.this;
                lVar.f18123k.b(lVar.f18094a);
                l.this.f18122j = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f18119g = (lVar.f18119g + 1) % l.this.f18118f.f18033c.length;
            l.this.f18120h = true;
        }
    }

    static class b extends Property<l, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.q());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f8) {
            lVar.u(f8.floatValue());
        }
    }

    public l(@m0 Context context, @m0 LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f18119g = 0;
        this.f18123k = null;
        this.f18118f = linearProgressIndicatorSpec;
        this.f18117e = new Interpolator[]{androidx.vectordrawable.graphics.drawable.d.b(context, R.animator.linear_indeterminate_line1_head_interpolator), androidx.vectordrawable.graphics.drawable.d.b(context, R.animator.linear_indeterminate_line1_tail_interpolator), androidx.vectordrawable.graphics.drawable.d.b(context, R.animator.linear_indeterminate_line2_head_interpolator), androidx.vectordrawable.graphics.drawable.d.b(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q() {
        return this.f18121i;
    }

    private void r() {
        if (this.f18116d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f18115o, 0.0f, 1.0f);
            this.f18116d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f18116d.setInterpolator(null);
            this.f18116d.setRepeatCount(-1);
            this.f18116d.addListener(new a());
        }
    }

    private void s() {
        if (this.f18120h) {
            Arrays.fill(this.f18096c, k1.a.a(this.f18118f.f18033c[this.f18119g], this.f18094a.getAlpha()));
            this.f18120h = false;
        }
    }

    private void v(int i7) {
        for (int i8 = 0; i8 < 4; i8++) {
            this.f18095b[i8] = Math.max(0.0f, Math.min(1.0f, this.f18117e[i8].getInterpolation(b(i7, f18114n[i8], f18113m[i8]))));
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f18116d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        t();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        this.f18123k = aVar;
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
        if (!this.f18094a.isVisible()) {
            a();
        } else {
            this.f18122j = true;
            this.f18116d.setRepeatCount(0);
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        r();
        t();
        this.f18116d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.f18123k = null;
    }

    @g1
    void t() {
        this.f18119g = 0;
        int iA = k1.a.a(this.f18118f.f18033c[0], this.f18094a.getAlpha());
        int[] iArr = this.f18096c;
        iArr[0] = iA;
        iArr[1] = iA;
    }

    @g1
    void u(float f8) {
        this.f18121i = f8;
        v((int) (f8 * 1800.0f));
        s();
        this.f18094a.invalidateSelf();
    }
}
