package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.core.view.z1;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    Drawable f17748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Rect f17749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Rect f17750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17752e;

    class a implements z1 {
        a() {
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, @m0 w5 w5Var) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f17749b == null) {
                scrimInsetsFrameLayout.f17749b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f17749b.set(w5Var.p(), w5Var.r(), w5Var.q(), w5Var.o());
            ScrimInsetsFrameLayout.this.a(w5Var);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!w5Var.w() || ScrimInsetsFrameLayout.this.f17748a == null);
            n2.n1(ScrimInsetsFrameLayout.this);
            return w5Var.c();
        }
    }

    public ScrimInsetsFrameLayout(@m0 Context context) {
        this(context, null);
    }

    protected void a(w5 w5Var) {
    }

    @Override // android.view.View
    public void draw(@m0 Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f17749b == null || this.f17748a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f17751d) {
            this.f17750c.set(0, 0, width, this.f17749b.top);
            this.f17748a.setBounds(this.f17750c);
            this.f17748a.draw(canvas);
        }
        if (this.f17752e) {
            this.f17750c.set(0, height - this.f17749b.bottom, width, height);
            this.f17748a.setBounds(this.f17750c);
            this.f17748a.draw(canvas);
        }
        Rect rect = this.f17750c;
        Rect rect2 = this.f17749b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f17748a.setBounds(this.f17750c);
        this.f17748a.draw(canvas);
        Rect rect3 = this.f17750c;
        Rect rect4 = this.f17749b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f17748a.setBounds(this.f17750c);
        this.f17748a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f17748a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f17748a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z7) {
        this.f17752e = z7;
    }

    public void setDrawTopInsetForeground(boolean z7) {
        this.f17751d = z7;
    }

    public void setScrimInsetForeground(@o0 Drawable drawable) {
        this.f17748a = drawable;
    }

    public ScrimInsetsFrameLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f17750c = new Rect();
        this.f17751d = true;
        this.f17752e = true;
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i7, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f17748a = typedArrayJ.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayJ.recycle();
        setWillNotDraw(true);
        n2.a2(this, new a());
    }
}
