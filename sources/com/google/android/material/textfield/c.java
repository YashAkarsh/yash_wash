package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import c.m0;
import c.o0;
import com.google.android.material.shape.o;

/* JADX INFO: loaded from: classes.dex */
class c extends com.google.android.material.shape.j {

    @m0
    private final Paint D;

    @m0
    private final RectF E;
    private int F;

    c() {
        this(null);
    }

    private void P0(@m0 Canvas canvas) {
        if (W0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.F);
    }

    private void Q0(@m0 Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!W0(callback)) {
            S0(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void S0(@m0 Canvas canvas) {
        this.F = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    private void V0() {
        this.D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.D.setColor(-1);
        this.D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean W0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    boolean O0() {
        return !this.E.isEmpty();
    }

    void R0() {
        T0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void T0(float f8, float f9, float f10, float f11) {
        RectF rectF = this.E;
        if (f8 == rectF.left && f9 == rectF.top && f10 == rectF.right && f11 == rectF.bottom) {
            return;
        }
        rectF.set(f8, f9, f10, f11);
        invalidateSelf();
    }

    void U0(@m0 RectF rectF) {
        T0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        Q0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.E, this.D);
        P0(canvas);
    }

    c(@o0 o oVar) {
        super(oVar == null ? new o() : oVar);
        this.D = new Paint(1);
        V0();
        this.E = new RectF();
    }
}
