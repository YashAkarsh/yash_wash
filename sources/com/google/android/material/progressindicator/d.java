package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import c.g1;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
final class d extends h<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f18041l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f18042m = 5400;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f18043n = 667;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f18044o = 667;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f18045p = 333;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f18046q = 333;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f18050u = -20;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f18051v = 250;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f18052w = 1520;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f18055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObjectAnimator f18056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.interpolator.view.animation.b f18057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f18058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f18060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b.a f18062k;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f18047r = {0, 1350, 2700, 4050};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[] f18048s = {667, 2017, 3367, 4717};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int[] f18049t = {1000, 2350, 3700, 5050};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Property<d, Float> f18053x = new c(Float.class, "animationFraction");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Property<d, Float> f18054y = new C0201d(Float.class, "completeEndFraction");

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f18059h = (dVar.f18059h + 4) % d.this.f18058g.f18033c.length;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            dVar.f18062k.b(dVar.f18094a);
        }
    }

    static class c extends Property<d, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f8) {
            dVar.t(f8.floatValue());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.d$d, reason: collision with other inner class name */
    static class C0201d extends Property<d, Float> {
        C0201d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f8) {
            dVar.u(f8.floatValue());
        }
    }

    public d(@m0 CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f18059h = 0;
        this.f18062k = null;
        this.f18058g = circularProgressIndicatorSpec;
        this.f18057f = new androidx.interpolator.view.animation.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f18060i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f18061j;
    }

    private void q() {
        if (this.f18055d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f18053x, 0.0f, 1.0f);
            this.f18055d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f18055d.setInterpolator(null);
            this.f18055d.setRepeatCount(-1);
            this.f18055d.addListener(new a());
        }
        if (this.f18056e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f18054y, 0.0f, 1.0f);
            this.f18056e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f18056e.setInterpolator(this.f18057f);
            this.f18056e.addListener(new b());
        }
    }

    private void r(int i7) {
        for (int i8 = 0; i8 < 4; i8++) {
            float fB = b(i7, f18049t[i8], 333);
            if (fB >= 0.0f && fB <= 1.0f) {
                int i9 = i8 + this.f18059h;
                int[] iArr = this.f18058g.f18033c;
                int length = i9 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                this.f18096c[0] = com.google.android.material.animation.c.b().evaluate(this.f18057f.getInterpolation(fB), Integer.valueOf(k1.a.a(iArr[length], this.f18094a.getAlpha())), Integer.valueOf(k1.a.a(this.f18058g.f18033c[length2], this.f18094a.getAlpha()))).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f8) {
        this.f18061j = f8;
    }

    private void v(int i7) {
        float[] fArr = this.f18095b;
        float f8 = this.f18060i;
        fArr[0] = (f8 * 1520.0f) - 20.0f;
        fArr[1] = f8 * 1520.0f;
        for (int i8 = 0; i8 < 4; i8++) {
            float fB = b(i7, f18047r[i8], 667);
            float[] fArr2 = this.f18095b;
            fArr2[1] = fArr2[1] + (this.f18057f.getInterpolation(fB) * 250.0f);
            float fB2 = b(i7, f18048s[i8], 667);
            float[] fArr3 = this.f18095b;
            fArr3[0] = fArr3[0] + (this.f18057f.getInterpolation(fB2) * 250.0f);
        }
        float[] fArr4 = this.f18095b;
        float f9 = fArr4[0];
        float f10 = fArr4[1];
        float f11 = f9 + ((f10 - f9) * this.f18061j);
        fArr4[0] = f11;
        fArr4[0] = f11 / 360.0f;
        fArr4[1] = f10 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    void a() {
        ObjectAnimator objectAnimator = this.f18055d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        this.f18062k = aVar;
    }

    @Override // com.google.android.material.progressindicator.h
    void f() {
        if (this.f18056e.isRunning()) {
            return;
        }
        if (this.f18094a.isVisible()) {
            this.f18056e.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    void g() {
        q();
        s();
        this.f18055d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.f18062k = null;
    }

    @g1
    void s() {
        this.f18059h = 0;
        this.f18096c[0] = k1.a.a(this.f18058g.f18033c[0], this.f18094a.getAlpha());
        this.f18061j = 0.0f;
    }

    @g1
    void t(float f8) {
        this.f18060i = f8;
        int i7 = (int) (f8 * 5400.0f);
        v(i7);
        r(i7);
        this.f18094a.invalidateSelf();
    }
}
