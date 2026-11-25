package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import c.g1;
import c.m0;
import c.o0;
import c.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class f extends Drawable implements androidx.vectordrawable.graphics.drawable.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final boolean f18073o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f18074p = 500;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Property<f, Float> f18075q = new c(Float.class, "growFraction");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f18076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.google.android.material.progressindicator.b f18077b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ValueAnimator f18079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ValueAnimator f18080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f18082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f18083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<androidx.vectordrawable.graphics.drawable.b.a> f18084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private androidx.vectordrawable.graphics.drawable.b.a f18085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18087l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f18089n;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final Paint f18088m = new Paint();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.google.android.material.progressindicator.a f18078c = new com.google.android.material.progressindicator.a();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.h();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.super.setVisible(false, false);
            f.this.g();
        }
    }

    static class c extends Property<f, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.j());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(f fVar, Float f8) {
            fVar.p(f8.floatValue());
        }
    }

    f(@m0 Context context, @m0 com.google.android.material.progressindicator.b bVar) {
        this.f18076a = context;
        this.f18077b = bVar;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        androidx.vectordrawable.graphics.drawable.b.a aVar = this.f18085j;
        if (aVar != null) {
            aVar.b(this);
        }
        List<androidx.vectordrawable.graphics.drawable.b.a> list = this.f18084i;
        if (list == null || this.f18086k) {
            return;
        }
        Iterator<androidx.vectordrawable.graphics.drawable.b.a> it = list.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        androidx.vectordrawable.graphics.drawable.b.a aVar = this.f18085j;
        if (aVar != null) {
            aVar.c(this);
        }
        List<androidx.vectordrawable.graphics.drawable.b.a> list = this.f18084i;
        if (list == null || this.f18086k) {
            return;
        }
        Iterator<androidx.vectordrawable.graphics.drawable.b.a> it = list.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    private void i(@m0 ValueAnimator... valueAnimatorArr) {
        boolean z7 = this.f18086k;
        this.f18086k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f18086k = z7;
    }

    private void o() {
        if (this.f18079d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f18075q, 0.0f, 1.0f);
            this.f18079d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f18079d.setInterpolator(com.google.android.material.animation.a.f16847b);
            u(this.f18079d);
        }
        if (this.f18080e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f18075q, 1.0f, 0.0f);
            this.f18080e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f18080e.setInterpolator(com.google.android.material.animation.a.f16847b);
            q(this.f18080e);
        }
    }

    private void q(@m0 ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f18080e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f18080e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void u(@m0 ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f18079d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f18079d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    public void b(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        if (this.f18084i == null) {
            this.f18084i = new ArrayList();
        }
        if (this.f18084i.contains(aVar)) {
            return;
        }
        this.f18084i.add(aVar);
    }

    public void c() {
        this.f18084i.clear();
        this.f18084i = null;
    }

    public boolean d(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        List<androidx.vectordrawable.graphics.drawable.b.a> list = this.f18084i;
        if (list == null || !list.contains(aVar)) {
            return false;
        }
        this.f18084i.remove(aVar);
        if (!this.f18084i.isEmpty()) {
            return true;
        }
        this.f18084i = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f18089n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return n() || m();
    }

    float j() {
        if (this.f18077b.b() || this.f18077b.a()) {
            return (this.f18082g || this.f18081f) ? this.f18083h : this.f18087l;
        }
        return 1.0f;
    }

    @m0
    ValueAnimator k() {
        return this.f18080e;
    }

    public boolean l() {
        return v(false, false, false);
    }

    public boolean m() {
        ValueAnimator valueAnimator = this.f18080e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f18082g;
    }

    public boolean n() {
        ValueAnimator valueAnimator = this.f18079d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f18081f;
    }

    void p(@v(from = 0.0d, to = 1.0d) float f8) {
        if (this.f18087l != f8) {
            this.f18087l = f8;
            invalidateSelf();
        }
    }

    void r(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        this.f18085j = aVar;
    }

    @g1
    void s(boolean z7, @v(from = 0.0d, to = 1.0d) float f8) {
        this.f18082g = z7;
        this.f18083h = f8;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f18089n = i7;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@o0 ColorFilter colorFilter) {
        this.f18088m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        return v(z7, z8, true);
    }

    public void start() {
        w(true, true, false);
    }

    public void stop() {
        w(false, true, false);
    }

    @g1
    void t(boolean z7, @v(from = 0.0d, to = 1.0d) float f8) {
        this.f18081f = z7;
        this.f18083h = f8;
    }

    public boolean v(boolean z7, boolean z8, boolean z9) {
        return w(z7, z8, z9 && this.f18078c.a(this.f18076a.getContentResolver()) > 0.0f);
    }

    boolean w(boolean z7, boolean z8, boolean z9) {
        o();
        if (!isVisible() && !z7) {
            return false;
        }
        ValueAnimator valueAnimator = z7 ? this.f18079d : this.f18080e;
        if (!z9) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                i(valueAnimator);
            }
            return super.setVisible(z7, false);
        }
        if (z9 && valueAnimator.isRunning()) {
            return false;
        }
        boolean z10 = !z7 || super.setVisible(z7, false);
        if (!(z7 ? this.f18077b.b() : this.f18077b.a())) {
            i(valueAnimator);
            return z10;
        }
        if (z8 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z10;
    }
}
