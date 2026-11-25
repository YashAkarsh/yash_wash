package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
class t extends Drawable implements Drawable.Callback, s, r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final PorterDuff.Mode f5830g = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PorterDuff.Mode f5832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    v f5834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Drawable f5836f;

    t(@m0 v vVar, @o0 Resources resources) {
        this.f5834d = vVar;
        e(resources);
    }

    @m0
    private v d() {
        return new v(this.f5834d);
    }

    private void e(@o0 Resources resources) {
        Drawable.ConstantState constantState;
        v vVar = this.f5834d;
        if (vVar == null || (constantState = vVar.f5840b) == null) {
            return;
        }
        a(constantState.newDrawable(resources));
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        v vVar = this.f5834d;
        ColorStateList colorStateList = vVar.f5841c;
        PorterDuff.Mode mode = vVar.f5842d;
        if (colorStateList == null || mode == null) {
            this.f5833c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f5833c || colorForState != this.f5831a || mode != this.f5832b) {
                setColorFilter(colorForState, mode);
                this.f5831a = colorForState;
                this.f5832b = mode;
                this.f5833c = true;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.s
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f5836f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f5836f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            v vVar = this.f5834d;
            if (vVar != null) {
                vVar.f5840b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // androidx.core.graphics.drawable.s
    public final Drawable b() {
        return this.f5836f;
    }

    protected boolean c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        this.f5836f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        v vVar = this.f5834d;
        return changingConfigurations | (vVar != null ? vVar.getChangingConfigurations() : 0) | this.f5836f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @o0
    public Drawable.ConstantState getConstantState() {
        v vVar = this.f5834d;
        if (vVar == null || !vVar.a()) {
            return null;
        }
        this.f5834d.f5839a = getChangingConfigurations();
        return this.f5834d;
    }

    @Override // android.graphics.drawable.Drawable
    @m0
    public Drawable getCurrent() {
        return this.f5836f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5836f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5836f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    @t0(23)
    public int getLayoutDirection() {
        return d.f(this.f5836f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f5836f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f5836f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5836f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@m0 Rect rect) {
        return this.f5836f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    @m0
    public int[] getState() {
        return this.f5836f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f5836f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@m0 Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @t0(19)
    public boolean isAutoMirrored() {
        return d.h(this.f5836f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        v vVar;
        ColorStateList colorStateList = (!c() || (vVar = this.f5834d) == null) ? null : vVar.f5841c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f5836f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f5836f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    @m0
    public Drawable mutate() {
        if (!this.f5835e && super.mutate() == this) {
            this.f5834d = d();
            Drawable drawable = this.f5836f;
            if (drawable != null) {
                drawable.mutate();
            }
            v vVar = this.f5834d;
            if (vVar != null) {
                Drawable drawable2 = this.f5836f;
                vVar.f5840b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f5835e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5836f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @t0(23)
    public boolean onLayoutDirectionChanged(int i7) {
        return d.m(this.f5836f, i7);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i7) {
        return this.f5836f.setLevel(i7);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable, long j7) {
        scheduleSelf(runnable, j7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f5836f.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    @t0(19)
    public void setAutoMirrored(boolean z7) {
        d.j(this.f5836f, z7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i7) {
        this.f5836f.setChangingConfigurations(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5836f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z7) {
        this.f5836f.setDither(z7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z7) {
        this.f5836f.setFilterBitmap(z7);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@m0 int[] iArr) {
        return f(iArr) || this.f5836f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(int i7) {
        setTintList(ColorStateList.valueOf(i7));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(ColorStateList colorStateList) {
        this.f5834d.f5841c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(@m0 PorterDuff.Mode mode) {
        this.f5834d.f5842d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        return super.setVisible(z7, z8) || this.f5836f.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable) {
        unscheduleSelf(runnable);
    }

    t(@o0 Drawable drawable) {
        this.f5834d = d();
        a(drawable);
    }
}
