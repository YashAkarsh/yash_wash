package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.r;
import c.l;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.shape.j;
import com.google.android.material.shape.o;
import com.google.android.material.shape.s;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class a extends Drawable implements s, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f18161a;

    @Override // android.graphics.drawable.Drawable
    @m0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f18161a = new b(this.f18161a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f18161a;
        if (bVar.f18163b) {
            bVar.f18162a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @o0
    public Drawable.ConstantState getConstantState() {
        return this.f18161a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f18161a.f18162a.getOpacity();
    }

    @Override // com.google.android.material.shape.s
    @m0
    public o getShapeAppearanceModel() {
        return this.f18161a.f18162a.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@m0 Rect rect) {
        super.onBoundsChange(rect);
        this.f18161a.f18162a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@m0 int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f18161a.f18162a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zE = com.google.android.material.ripple.b.e(iArr);
        b bVar = this.f18161a;
        if (bVar.f18163b == zE) {
            return zOnStateChange;
        }
        bVar.f18163b = zE;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f18161a.f18162a.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@o0 ColorFilter colorFilter) {
        this.f18161a.f18162a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.s
    public void setShapeAppearanceModel(@m0 o oVar) {
        this.f18161a.f18162a.setShapeAppearanceModel(oVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(@l int i7) {
        this.f18161a.f18162a.setTint(i7);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(@o0 ColorStateList colorStateList) {
        this.f18161a.f18162a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(@o0 PorterDuff.Mode mode) {
        this.f18161a.f18162a.setTintMode(mode);
    }

    public a(o oVar) {
        this(new b(new j(oVar)));
    }

    static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        j f18162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f18163b;

        public b(j jVar) {
            this.f18162a = jVar;
            this.f18163b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(@m0 b bVar) {
            this.f18162a = (j) bVar.f18162a.getConstantState().newDrawable();
            this.f18163b = bVar.f18163b;
        }
    }

    private a(b bVar) {
        this.f18161a = bVar;
    }
}
