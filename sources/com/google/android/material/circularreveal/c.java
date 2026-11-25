package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import c.l;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public interface c extends com.google.android.material.circularreveal.b.a {

    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f17392b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f17393a = new e();

        @Override // android.animation.TypeEvaluator
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f8, @m0 e eVar, @m0 e eVar2) {
            this.f17393a.b(p1.a.f(eVar.f17397a, eVar2.f17397a, f8), p1.a.f(eVar.f17398b, eVar2.f17398b, f8), p1.a.f(eVar.f17399c, eVar2.f17399c, f8));
            return this.f17393a;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    public static class C0196c extends Property<c, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, e> f17394a = new C0196c("circularReveal");

        private C0196c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @o0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(@m0 c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@m0 c cVar, @o0 e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property<c, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<c, Integer> f17395a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(@m0 c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@m0 c cVar, @m0 Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final float f17396d = Float.MAX_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f17397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f17398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f17399c;

        public boolean a() {
            return this.f17399c == Float.MAX_VALUE;
        }

        public void b(float f8, float f9, float f10) {
            this.f17397a = f8;
            this.f17398b = f9;
            this.f17399c = f10;
        }

        public void c(@m0 e eVar) {
            b(eVar.f17397a, eVar.f17398b, eVar.f17399c);
        }

        private e() {
        }

        public e(float f8, float f9, float f10) {
            this.f17397a = f8;
            this.f17398b = f9;
            this.f17399c = f10;
        }

        public e(@m0 e eVar) {
            this(eVar.f17397a, eVar.f17398b, eVar.f17399c);
        }
    }

    void a();

    void b();

    void draw(Canvas canvas);

    @o0
    Drawable getCircularRevealOverlayDrawable();

    @l
    int getCircularRevealScrimColor();

    @o0
    e getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@o0 Drawable drawable);

    void setCircularRevealScrimColor(@l int i7);

    void setRevealInfo(@o0 e eVar);
}
