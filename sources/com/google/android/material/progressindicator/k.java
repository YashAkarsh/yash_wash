package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import c.g1;
import c.m0;
import c.o0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class k extends h<ObjectAnimator> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f18102j = 667;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f18103k = 333;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Property<k, Float> f18104l = new b(Float.class, "animationFraction");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f18105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private androidx.interpolator.view.animation.b f18106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f18107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f18110i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.f18108g = (kVar.f18108g + 1) % k.this.f18107f.f18033c.length;
            k.this.f18109h = true;
        }
    }

    static class b extends Property<k, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(k kVar) {
            return Float.valueOf(kVar.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, Float f8) {
            kVar.r(f8.floatValue());
        }
    }

    public k(@m0 LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f18108g = 1;
        this.f18107f = linearProgressIndicatorSpec;
        this.f18106e = new androidx.interpolator.view.animation.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f18110i;
    }

    private void o() {
        if (this.f18105d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f18104l, 0.0f, 1.0f);
            this.f18105d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f18105d.setInterpolator(null);
            this.f18105d.setRepeatCount(-1);
            this.f18105d.addListener(new a());
        }
    }

    private void p() {
        if (!this.f18109h || this.f18095b[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.f18096c;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = k1.a.a(this.f18107f.f18033c[this.f18108g], this.f18094a.getAlpha());
        this.f18109h = false;
    }

    private void s(int i7) {
        this.f18095b[0] = 0.0f;
        float fB = b(i7, 0, f18102j);
        float[] fArr = this.f18095b;
        float interpolation = this.f18106e.getInterpolation(fB);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.f18095b;
        float interpolation2 = this.f18106e.getInterpolation(fB + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.f18095b[5] = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f18105d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@o0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        o();
        q();
        this.f18105d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
    }

    @g1
    void q() {
        this.f18109h = true;
        this.f18108g = 1;
        Arrays.fill(this.f18096c, k1.a.a(this.f18107f.f18033c[0], this.f18094a.getAlpha()));
    }

    @g1
    void r(float f8) {
        this.f18110i = f8;
        s((int) (f8 * 333.0f));
        p();
        this.f18094a.invalidateSelf();
    }
}
