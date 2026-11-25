package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.v1;
import c.a1;
import c.b1;
import c.f;
import c.m0;
import c.o0;
import c.r0;
import c.v;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.internal.n;
import com.google.android.material.resources.c;
import com.google.android.material.resources.d;
import com.google.android.material.shape.g;
import com.google.android.material.shape.i;
import com.google.android.material.shape.j;
import com.google.android.material.shape.l;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class a extends j implements k.b {

    @b1
    private static final int U = R.style.Widget_MaterialComponents_Tooltip;

    @f
    private static final int V = R.attr.tooltipStyle;

    @o0
    private CharSequence D;

    @m0
    private final Context E;

    @o0
    private final Paint.FontMetrics F;

    @m0
    private final k G;

    @m0
    private final View.OnLayoutChangeListener H;

    @m0
    private final Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f18866J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private float P;
    private float Q;
    private final float R;
    private float S;
    private float T;

    /* JADX INFO: renamed from: com.google.android.material.tooltip.a$a, reason: collision with other inner class name */
    class ViewOnLayoutChangeListenerC0211a implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC0211a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            a.this.q1(view);
        }
    }

    private a(@m0 Context context, AttributeSet attributeSet, @f int i7, @b1 int i8) {
        super(context, attributeSet, i7, i8);
        this.F = new Paint.FontMetrics();
        k kVar = new k(this);
        this.G = kVar;
        this.H = new ViewOnLayoutChangeListenerC0211a();
        this.I = new Rect();
        this.P = 1.0f;
        this.Q = 1.0f;
        this.R = 0.5f;
        this.S = 0.5f;
        this.T = 1.0f;
        this.E = context;
        kVar.e().density = context.getResources().getDisplayMetrics().density;
        kVar.e().setTextAlign(Paint.Align.CENTER);
    }

    private float P0() {
        int i7;
        if (((this.I.right - getBounds().right) - this.O) - this.M < 0) {
            i7 = ((this.I.right - getBounds().right) - this.O) - this.M;
        } else {
            if (((this.I.left - getBounds().left) - this.O) + this.M <= 0) {
                return 0.0f;
            }
            i7 = ((this.I.left - getBounds().left) - this.O) + this.M;
        }
        return i7;
    }

    private float Q0() {
        this.G.e().getFontMetrics(this.F);
        Paint.FontMetrics fontMetrics = this.F;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float R0(@m0 Rect rect) {
        return rect.centerY() - Q0();
    }

    @m0
    public static a S0(@m0 Context context) {
        return U0(context, null, V, U);
    }

    @m0
    public static a T0(@m0 Context context, @o0 AttributeSet attributeSet) {
        return U0(context, attributeSet, V, U);
    }

    @m0
    public static a U0(@m0 Context context, @o0 AttributeSet attributeSet, @f int i7, @b1 int i8) {
        a aVar = new a(context, attributeSet, i7, i8);
        aVar.f1(attributeSet, i7, i8);
        return aVar;
    }

    private g V0() {
        float f8 = -P0();
        float fWidth = ((float) (((double) getBounds().width()) - (((double) this.N) * Math.sqrt(2.0d)))) / 2.0f;
        return new l(new i(this.N), Math.min(Math.max(f8, -fWidth), fWidth));
    }

    private void X0(@m0 Canvas canvas) {
        if (this.D == null) {
            return;
        }
        Rect bounds = getBounds();
        int iR0 = (int) R0(bounds);
        if (this.G.d() != null) {
            this.G.e().drawableState = getState();
            this.G.k(this.E);
            this.G.e().setAlpha((int) (this.T * 255.0f));
        }
        CharSequence charSequence = this.D;
        canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), iR0, this.G.e());
    }

    private float e1() {
        CharSequence charSequence = this.D;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.G.f(charSequence.toString());
    }

    private void f1(@o0 AttributeSet attributeSet, @f int i7, @b1 int i8) {
        TypedArray typedArrayJ = n.j(this.E, attributeSet, R.styleable.Tooltip, i7, i8, new int[0]);
        this.N = this.E.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(V0()).m());
        l1(typedArrayJ.getText(R.styleable.Tooltip_android_text));
        m1(c.f(this.E, typedArrayJ, R.styleable.Tooltip_android_textAppearance));
        n0(ColorStateList.valueOf(typedArrayJ.getColor(R.styleable.Tooltip_backgroundTint, k1.a.g(v1.B(k1.a.c(this.E, android.R.attr.colorBackground, a.class.getCanonicalName()), 229), v1.B(k1.a.c(this.E, R.attr.colorOnBackground, a.class.getCanonicalName()), 153)))));
        E0(ColorStateList.valueOf(k1.a.c(this.E, R.attr.colorSurface, a.class.getCanonicalName())));
        this.f18866J = typedArrayJ.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.K = typedArrayJ.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.L = typedArrayJ.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.M = typedArrayJ.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        typedArrayJ.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(@m0 View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.O = iArr[0];
        view.getWindowVisibleDisplayFrame(this.I);
    }

    public void W0(@o0 View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.H);
    }

    public int Y0() {
        return this.M;
    }

    public int Z0() {
        return this.L;
    }

    @Override // com.google.android.material.internal.k.b
    public void a() {
        invalidateSelf();
    }

    public int a1() {
        return this.K;
    }

    @o0
    public CharSequence b1() {
        return this.D;
    }

    @o0
    public d c1() {
        return this.G.d();
    }

    public int d1() {
        return this.f18866J;
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        canvas.save();
        float fP0 = P0();
        float f8 = (float) (-((((double) this.N) * Math.sqrt(2.0d)) - ((double) this.N)));
        canvas.scale(this.P, this.Q, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.S));
        canvas.translate(fP0, f8);
        super.draw(canvas);
        X0(canvas);
        canvas.restore();
    }

    public void g1(@r0 int i7) {
        this.M = i7;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.G.e().getTextSize(), this.L);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.f18866J * 2) + e1(), this.K);
    }

    public void h1(@r0 int i7) {
        this.L = i7;
        invalidateSelf();
    }

    public void i1(@r0 int i7) {
        this.K = i7;
        invalidateSelf();
    }

    public void j1(@o0 View view) {
        if (view == null) {
            return;
        }
        q1(view);
        view.addOnLayoutChangeListener(this.H);
    }

    public void k1(@v(from = 0.0d, to = 1.0d) float f8) {
        this.S = 1.2f;
        this.P = f8;
        this.Q = f8;
        this.T = com.google.android.material.animation.a.b(0.0f, 1.0f, 0.19f, 1.0f, f8);
        invalidateSelf();
    }

    public void l1(@o0 CharSequence charSequence) {
        if (TextUtils.equals(this.D, charSequence)) {
            return;
        }
        this.D = charSequence;
        this.G.j(true);
        invalidateSelf();
    }

    public void m1(@o0 d dVar) {
        this.G.i(dVar, this.E);
    }

    public void n1(@b1 int i7) {
        m1(new d(this.E, i7));
    }

    public void o1(@r0 int i7) {
        this.f18866J = i7;
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(V0()).m());
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable, com.google.android.material.internal.k.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p1(@a1 int i7) {
        l1(this.E.getResources().getString(i7));
    }
}
