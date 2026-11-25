package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import c.l;
import c.m0;
import c.o0;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealCardView extends MaterialCardView implements c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @m0
    private final b f17400u;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c
    public void a() {
        this.f17400u.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public void b() {
        this.f17400u.b();
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
        b bVar = this.f17400u;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f17400u.g();
    }

    @Override // com.google.android.material.circularreveal.c
    public int getCircularRevealScrimColor() {
        return this.f17400u.h();
    }

    @Override // com.google.android.material.circularreveal.c
    @o0
    public c.e getRevealInfo() {
        return this.f17400u.j();
    }

    @Override // android.view.View, com.google.android.material.circularreveal.c
    public boolean isOpaque() {
        b bVar = this.f17400u;
        return bVar != null ? bVar.l() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@o0 Drawable drawable) {
        this.f17400u.m(drawable);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@l int i7) {
        this.f17400u.n(i7);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@o0 c.e eVar) {
        this.f17400u.o(eVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17400u = new b(this);
    }
}
