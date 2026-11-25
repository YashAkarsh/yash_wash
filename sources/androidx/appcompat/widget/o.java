package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
class o extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f1921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f1922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f1923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f1924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1926i;

    o(SeekBar seekBar) {
        super(seekBar);
        this.f1923f = null;
        this.f1924g = null;
        this.f1925h = false;
        this.f1926i = false;
        this.f1921d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1922e;
        if (drawable != null) {
            if (this.f1925h || this.f1926i) {
                Drawable drawableR = androidx.core.graphics.drawable.d.r(drawable.mutate());
                this.f1922e = drawableR;
                if (this.f1925h) {
                    androidx.core.graphics.drawable.d.o(drawableR, this.f1923f);
                }
                if (this.f1926i) {
                    androidx.core.graphics.drawable.d.p(this.f1922e, this.f1924g);
                }
                if (this.f1922e.isStateful()) {
                    this.f1922e.setState(this.f1921d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.l
    void c(AttributeSet attributeSet, int i7) {
        super.c(attributeSet, i7);
        h1 h1VarG = h1.G(this.f1921d.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i7, 0);
        SeekBar seekBar = this.f1921d;
        n2.z1(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, h1VarG.B(), i7, 0);
        Drawable drawableI = h1VarG.i(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableI != null) {
            this.f1921d.setThumb(drawableI);
        }
        m(h1VarG.h(R.styleable.AppCompatSeekBar_tickMark));
        if (h1VarG.C(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1924g = k0.e(h1VarG.o(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1924g);
            this.f1926i = true;
        }
        if (h1VarG.C(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1923f = h1VarG.d(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f1925h = true;
        }
        h1VarG.I();
        f();
    }

    void g(Canvas canvas) {
        if (this.f1922e != null) {
            int max = this.f1921d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1922e.getIntrinsicWidth();
                int intrinsicHeight = this.f1922e.getIntrinsicHeight();
                int i7 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i8 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1922e.setBounds(-i7, -i8, i7, i8);
                float width = ((this.f1921d.getWidth() - this.f1921d.getPaddingLeft()) - this.f1921d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1921d.getPaddingLeft(), this.f1921d.getHeight() / 2);
                for (int i9 = 0; i9 <= max; i9++) {
                    this.f1922e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f1922e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1921d.getDrawableState())) {
            this.f1921d.invalidateDrawable(drawable);
        }
    }

    @c.o0
    Drawable i() {
        return this.f1922e;
    }

    @c.o0
    ColorStateList j() {
        return this.f1923f;
    }

    @c.o0
    PorterDuff.Mode k() {
        return this.f1924g;
    }

    void l() {
        Drawable drawable = this.f1922e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void m(@c.o0 Drawable drawable) {
        Drawable drawable2 = this.f1922e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1922e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1921d);
            androidx.core.graphics.drawable.d.m(drawable, n2.Z(this.f1921d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1921d.getDrawableState());
            }
            f();
        }
        this.f1921d.invalidate();
    }

    void n(@c.o0 ColorStateList colorStateList) {
        this.f1923f = colorStateList;
        this.f1925h = true;
        f();
    }

    void o(@c.o0 PorterDuff.Mode mode) {
        this.f1924g = mode;
        this.f1926i = true;
        f();
    }
}
