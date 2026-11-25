package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.n2;
import c.b1;
import c.g1;
import c.m0;
import c.o0;
import c.r0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.progressindicator.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.b> extends ProgressBar {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17992o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f17993p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f17994q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f17995r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f17996s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f17997t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f17998u = R.style.Widget_MaterialComponents_ProgressIndicator;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final float f17999v = 0.2f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final int f18000w = 255;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f18001x = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    S f18002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f18006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f18008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    com.google.android.material.progressindicator.a f18009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f18012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Runnable f18013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b.a f18014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b.a f18015n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.l();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.k();
            BaseProgressIndicator.this.f18008g = -1L;
        }
    }

    class c extends androidx.vectordrawable.graphics.drawable.b.a {
        c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b.a
        public void b(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.setProgressCompat(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.f18003b, BaseProgressIndicator.this.f18004c);
        }
    }

    class d extends androidx.vectordrawable.graphics.drawable.b.a {
        d() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b.a
        public void b(Drawable drawable) {
            super.b(drawable);
            if (BaseProgressIndicator.this.f18010i) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.f18011j);
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    protected BaseProgressIndicator(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7, @b1 int i8) {
        super(q1.a.c(context, attributeSet, i7, f17998u), attributeSet, i7);
        this.f18008g = -1L;
        this.f18010i = false;
        this.f18011j = 4;
        this.f18012k = new a();
        this.f18013l = new b();
        this.f18014m = new c();
        this.f18015n = new d();
        Context context2 = getContext();
        this.f18002a = (S) i(context2, attributeSet);
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.BaseProgressIndicator, i7, i8, new int[0]);
        this.f18006e = typedArrayJ.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f18007f = Math.min(typedArrayJ.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayJ.recycle();
        this.f18009h = new com.google.android.material.progressindicator.a();
        this.f18005d = true;
    }

    @o0
    private g<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().A();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ((com.google.android.material.progressindicator.f) getCurrentDrawable()).v(false, false, true);
        if (n()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f18007f > 0) {
            this.f18008g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean n() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void o() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().z().d(this.f18014m);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().b(this.f18015n);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().b(this.f18015n);
        }
    }

    private void q() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().d(this.f18015n);
            getIndeterminateDrawable().z().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().d(this.f18015n);
        }
    }

    @Override // android.widget.ProgressBar
    @o0
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f18002a.f18036f;
    }

    @m0
    public int[] getIndicatorColor() {
        return this.f18002a.f18033c;
    }

    public int getShowAnimationBehavior() {
        return this.f18002a.f18035e;
    }

    @c.l
    public int getTrackColor() {
        return this.f18002a.f18034d;
    }

    @r0
    public int getTrackCornerRadius() {
        return this.f18002a.f18032b;
    }

    @r0
    public int getTrackThickness() {
        return this.f18002a.f18031a;
    }

    protected void h(boolean z7) {
        if (this.f18005d) {
            ((com.google.android.material.progressindicator.f) getCurrentDrawable()).v(r(), false, z7);
        }
    }

    abstract S i(@m0 Context context, @m0 AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public void j() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f18012k);
            return;
        }
        removeCallbacks(this.f18013l);
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f18008g;
        int i7 = this.f18007f;
        if (jUptimeMillis >= ((long) i7)) {
            this.f18013l.run();
        } else {
            postDelayed(this.f18013l, ((long) i7) - jUptimeMillis);
        }
    }

    boolean m() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        if (r()) {
            l();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f18013l);
        removeCallbacks(this.f18012k);
        ((com.google.android.material.progressindicator.f) getCurrentDrawable()).l();
        q();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@m0 Canvas canvas) {
        int iSave = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        g<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        int iE = currentDrawingDelegate.e();
        int iD = currentDrawingDelegate.d();
        setMeasuredDimension(iE < 0 ? getMeasuredWidth() : iE + getPaddingLeft() + getPaddingRight(), iD < 0 ? getMeasuredHeight() : iD + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@m0 View view, int i7) {
        super.onVisibilityChanged(view, i7);
        h(i7 == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i7) {
        super.onWindowVisibilityChanged(i7);
        h(false);
    }

    public void p() {
        if (this.f18006e <= 0) {
            this.f18012k.run();
        } else {
            removeCallbacks(this.f18012k);
            postDelayed(this.f18012k, this.f18006e);
        }
    }

    boolean r() {
        return n2.O0(this) && getWindowVisibility() == 0 && m();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    public void setAnimatorDurationScaleProvider(@m0 com.google.android.material.progressindicator.a aVar) {
        this.f18009h = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f18078c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f18078c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i7) {
        this.f18002a.f18036f = i7;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z7) {
        if (z7 == isIndeterminate()) {
            return;
        }
        if (r() && z7) {
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
        com.google.android.material.progressindicator.f fVar = (com.google.android.material.progressindicator.f) getCurrentDrawable();
        if (fVar != null) {
            fVar.l();
        }
        super.setIndeterminate(z7);
        com.google.android.material.progressindicator.f fVar2 = (com.google.android.material.progressindicator.f) getCurrentDrawable();
        if (fVar2 != null) {
            fVar2.v(r(), false, false);
        }
        this.f18010i = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@o0 Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof i)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((com.google.android.material.progressindicator.f) drawable).l();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(@c.l int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{k1.a.b(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f18002a.f18033c = iArr;
        getIndeterminateDrawable().z().c();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i7) {
        if (isIndeterminate()) {
            return;
        }
        setProgressCompat(i7, false);
    }

    public void setProgressCompat(int i7, boolean z7) {
        if (!isIndeterminate()) {
            super.setProgress(i7);
            if (getProgressDrawable() == null || z7) {
                return;
            }
            getProgressDrawable().jumpToCurrentState();
            return;
        }
        if (getProgressDrawable() != null) {
            this.f18003b = i7;
            this.f18004c = z7;
            this.f18010i = true;
            if (!getIndeterminateDrawable().isVisible() || this.f18009h.a(getContext().getContentResolver()) == 0.0f) {
                this.f18014m.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().z().f();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@o0 Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof com.google.android.material.progressindicator.e)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            com.google.android.material.progressindicator.e eVar = (com.google.android.material.progressindicator.e) drawable;
            eVar.l();
            super.setProgressDrawable(eVar);
            eVar.F(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i7) {
        this.f18002a.f18035e = i7;
        invalidate();
    }

    public void setTrackColor(@c.l int i7) {
        S s7 = this.f18002a;
        if (s7.f18034d != i7) {
            s7.f18034d = i7;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@r0 int i7) {
        S s7 = this.f18002a;
        if (s7.f18032b != i7) {
            s7.f18032b = Math.min(i7, s7.f18031a / 2);
        }
    }

    public void setTrackThickness(@r0 int i7) {
        S s7 = this.f18002a;
        if (s7.f18031a != i7) {
            s7.f18031a = i7;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i7) {
        if (i7 != 0 && i7 != 4 && i7 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f18011j = i7;
    }

    @Override // android.widget.ProgressBar
    @o0
    public i<S> getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @o0
    public com.google.android.material.progressindicator.e<S> getProgressDrawable() {
        return (com.google.android.material.progressindicator.e) super.getProgressDrawable();
    }
}
