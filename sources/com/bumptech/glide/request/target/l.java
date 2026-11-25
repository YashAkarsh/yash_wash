package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class l extends com.bumptech.glide.load.resource.drawable.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.resource.drawable.b f14886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f14887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14888e;

    static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f14889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14890b;

        a(a aVar) {
            this(aVar.f14889a, aVar.f14890b);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        a(Drawable.ConstantState constantState, int i7) {
            this.f14889a = constantState;
            this.f14890b = i7;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new l(this, null, resources);
        }
    }

    public l(com.bumptech.glide.load.resource.drawable.b bVar, int i7) {
        this(new a(bVar.getConstantState(), i7), bVar, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f14886c.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f14886c.draw(canvas);
    }

    @Override // com.bumptech.glide.load.resource.drawable.b
    public boolean e() {
        return this.f14886c.e();
    }

    @Override // com.bumptech.glide.load.resource.drawable.b
    public void f(int i7) {
        this.f14886c.f(i7);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(19)
    public int getAlpha() {
        return this.f14886c.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(11)
    public Drawable.Callback getCallback() {
        return this.f14886c.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f14886c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f14887d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f14886c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14887d.f14890b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14887d.f14890b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f14886c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f14886c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f14886c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f14886c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f14886c.invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f14886c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f14888e && super.mutate() == this) {
            this.f14886c = (com.bumptech.glide.load.resource.drawable.b) this.f14886c.mutate();
            this.f14887d = new a(this.f14887d);
            this.f14888e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j7) {
        super.scheduleSelf(runnable, j7);
        this.f14886c.scheduleSelf(runnable, j7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f14886c.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i7, int i8, int i9, int i10) {
        super.setBounds(i7, i8, i9, i10);
        this.f14886c.setBounds(i7, i8, i9, i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i7) {
        this.f14886c.setChangingConfigurations(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i7, PorterDuff.Mode mode) {
        this.f14886c.setColorFilter(i7, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z7) {
        this.f14886c.setDither(z7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z7) {
        this.f14886c.setFilterBitmap(z7);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        return this.f14886c.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f14886c.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f14886c.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f14886c.unscheduleSelf(runnable);
    }

    l(a aVar, com.bumptech.glide.load.resource.drawable.b bVar, Resources resources) {
        this.f14887d = aVar;
        if (bVar != null) {
            this.f14886c = bVar;
        } else if (resources != null) {
            this.f14886c = (com.bumptech.glide.load.resource.drawable.b) aVar.f14889a.newDrawable(resources);
        } else {
            this.f14886c = (com.bumptech.glide.load.resource.drawable.b) aVar.f14889a.newDrawable();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14886c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f14886c.setBounds(rect);
    }
}
