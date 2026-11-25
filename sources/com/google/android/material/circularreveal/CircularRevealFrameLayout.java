package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import c.l;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final b f17372a;

    public CircularRevealFrameLayout(@m0 Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.f17372a.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void b() {
        this.f17372a.b();
    }

    @Override // com.google.android.material.circularreveal.b.a
    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean d() {
        return super.isOpaque();
    }

    @Override // android.view.View, com.google.android.material.circularreveal.c
    @SuppressLint({"MissingSuperCall"})
    public void draw(@m0 Canvas canvas) {
        b bVar = this.f17372a;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f17372a.g();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.f17372a.h();
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public c.e getRevealInfo() {
        return this.f17372a.j();
    }

    @Override // android.view.View, com.google.android.material.circularreveal.c
    public boolean isOpaque() {
        b bVar = this.f17372a;
        return bVar != null ? bVar.l() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@o0 Drawable drawable) {
        this.f17372a.m(drawable);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@l int i7) {
        this.f17372a.n(i7);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@o0 c.e eVar) {
        this.f17372a.o(eVar);
    }

    public CircularRevealFrameLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17372a = new b(this);
    }
}
