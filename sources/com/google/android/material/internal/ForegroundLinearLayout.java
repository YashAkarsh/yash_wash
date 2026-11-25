package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.n0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class ForegroundLinearLayout extends LinearLayoutCompat {

    @o0
    private Drawable B;
    private final Rect C;
    private final Rect D;
    private int E;
    protected boolean F;
    boolean G;

    public ForegroundLinearLayout(@m0 Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(@m0 Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.B;
        if (drawable != null) {
            if (this.G) {
                this.G = false;
                Rect rect = this.C;
                Rect rect2 = this.D;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.F) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.E, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @t0(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f8, float f9) {
        super.drawableHotspotChanged(f8, f9);
        Drawable drawable = this.B;
        if (drawable != null) {
            drawable.setHotspot(f8, f9);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.B;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.B.setState(getDrawableState());
    }

    @Override // android.view.View
    @o0
    public Drawable getForeground() {
        return this.B;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.E;
    }

    @Override // android.view.ViewGroup, android.view.View
    @t0(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.B;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        this.G = z7 | this.G;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        this.G = true;
    }

    @Override // android.view.View
    public void setForeground(@o0 Drawable drawable) {
        Drawable drawable2 = this.B;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.B);
            }
            this.B = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.E == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i7) {
        if (this.E != i7) {
            if ((8388615 & i7) == 0) {
                i7 |= n0.f6717b;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            this.E = i7;
            if (i7 == 119 && this.B != null) {
                this.B.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.B;
    }

    public ForegroundLinearLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.C = new Rect();
        this.D = new Rect();
        this.E = 119;
        this.F = true;
        this.G = false;
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.ForegroundLinearLayout, i7, 0, new int[0]);
        this.E = typedArrayJ.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.E);
        Drawable drawable = typedArrayJ.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.F = typedArrayJ.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayJ.recycle();
    }
}
