package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.r;

/* JADX INFO: loaded from: classes.dex */
abstract class h extends Drawable implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Drawable f10924a;

    h() {
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getState() : super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.i(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i7) {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.setLevel(i7) : super.onLevelChange(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setChangingConfigurations(i7);
        } else {
            super.setChangingConfigurations(i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i7, PorterDuff.Mode mode) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setColorFilter(i7, mode);
        } else {
            super.setColorFilter(i7, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setFilterBitmap(z7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f8, float f9) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.k(drawable, f8, f9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i7, int i8, int i9, int i10) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.l(drawable, i7, i8, i9, i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
