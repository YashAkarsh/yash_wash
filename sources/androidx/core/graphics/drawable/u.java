package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import c.m0;
import c.t0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class u extends t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f5837h = "WrappedDrawableApi21";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Method f5838i;

    u(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (f5838i == null) {
            try {
                f5838i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e8) {
                Log.w(f5837h, "Failed to retrieve Drawable#isProjected() method", e8);
            }
        }
    }

    @Override // androidx.core.graphics.drawable.t
    protected boolean c() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    @m0
    public Rect getDirtyBounds() {
        return this.f5836f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@m0 Outline outline) {
        this.f5836f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f5836f;
        if (drawable != null && (method = f5838i) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e8) {
                Log.w(f5837h, "Error calling Drawable#isProjected() method", e8);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f8, float f9) {
        this.f5836f.setHotspot(f8, f9);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i7, int i8, int i9, int i10) {
        this.f5836f.setHotspotBounds(i7, i8, i9, i10);
    }

    @Override // androidx.core.graphics.drawable.t, android.graphics.drawable.Drawable
    public boolean setState(@m0 int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.t, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(int i7) {
        if (c()) {
            super.setTint(i7);
        } else {
            this.f5836f.setTint(i7);
        }
    }

    @Override // androidx.core.graphics.drawable.t, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f5836f.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.t, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(@m0 PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f5836f.setTintMode(mode);
        }
    }

    u(v vVar, Resources resources) {
        super(vVar, resources);
        g();
    }
}
