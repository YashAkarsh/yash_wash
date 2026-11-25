package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.l;
import c.m0;
import c.o0;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements c {

    @m0
    private final b F;

    public CircularRevealCoordinatorLayout(@m0 Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.F.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void b() {
        this.F.b();
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
    public void draw(Canvas canvas) {
        b bVar = this.F;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.F.g();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.F.h();
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public c.e getRevealInfo() {
        return this.F.j();
    }

    @Override // android.view.View, com.google.android.material.circularreveal.c
    public boolean isOpaque() {
        b bVar = this.F;
        return bVar != null ? bVar.l() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@o0 Drawable drawable) {
        this.F.m(drawable);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@l int i7) {
        this.F.n(i7);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@o0 c.e eVar) {
        this.F.o(eVar);
    }

    public CircularRevealCoordinatorLayout(@m0 Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new b(this);
    }
}
