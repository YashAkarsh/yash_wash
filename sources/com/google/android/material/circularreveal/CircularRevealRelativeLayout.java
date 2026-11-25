package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import c.l;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealRelativeLayout extends RelativeLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final b f17375a;

    public CircularRevealRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.f17375a.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void b() {
        this.f17375a.b();
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
    public void draw(@m0 Canvas canvas) {
        b bVar = this.f17375a;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f17375a.g();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.f17375a.h();
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public c.e getRevealInfo() {
        return this.f17375a.j();
    }

    @Override // android.view.View, com.google.android.material.circularreveal.c
    public boolean isOpaque() {
        b bVar = this.f17375a;
        return bVar != null ? bVar.l() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@o0 Drawable drawable) {
        this.f17375a.m(drawable);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@l int i7) {
        this.f17375a.n(i7);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@o0 c.e eVar) {
        this.f17375a.o(eVar);
    }

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17375a = new b(this);
    }
}
