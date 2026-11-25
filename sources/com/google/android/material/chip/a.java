package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.d;
import androidx.core.graphics.drawable.r;
import androidx.core.graphics.v1;
import androidx.core.view.n2;
import c.a1;
import c.b1;
import c.f;
import c.i1;
import c.l;
import c.m0;
import c.o0;
import c.p;
import c.q;
import c.r0;
import c.u;
import com.google.android.material.animation.h;
import com.google.android.material.internal.k;
import com.google.android.material.internal.n;
import com.google.android.material.internal.v;
import com.google.android.material.resources.c;
import com.google.android.material.ripple.b;
import com.google.android.material.shape.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a extends j implements r, Drawable.Callback, k.b {

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private static final boolean f17353n1 = false;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private static final String f17355p1 = "http://schemas.android.com/apk/res-auto";

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private static final int f17356q1 = 24;

    @o0
    private h A0;

    @o0
    private h B0;
    private float C0;

    @o0
    private ColorStateList D;
    private float D0;

    @o0
    private ColorStateList E;
    private float E0;
    private float F;
    private float F0;
    private float G;
    private float G0;

    @o0
    private ColorStateList H;
    private float H0;
    private float I;
    private float I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @o0
    private ColorStateList f17358J;
    private float J0;

    @o0
    private CharSequence K;

    @m0
    private final Context K0;
    private boolean L;
    private final Paint L0;

    @o0
    private Drawable M;

    @o0
    private final Paint M0;

    @o0
    private ColorStateList N;
    private final Paint.FontMetrics N0;
    private float O;
    private final RectF O0;
    private boolean P;
    private final PointF P0;
    private boolean Q;
    private final Path Q0;

    @o0
    private Drawable R;

    @m0
    private final k R0;

    @o0
    private Drawable S;

    @l
    private int S0;

    @o0
    private ColorStateList T;

    @l
    private int T0;
    private float U;

    @l
    private int U0;

    @o0
    private CharSequence V;

    @l
    private int V0;
    private boolean W;

    @l
    private int W0;
    private boolean X;

    @l
    private int X0;

    @o0
    private Drawable Y;
    private boolean Y0;

    @o0
    private ColorStateList Z;

    @l
    private int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private int f17359a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    @o0
    private ColorFilter f17360b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    @o0
    private PorterDuffColorFilter f17361c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    @o0
    private ColorStateList f17362d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    @o0
    private PorterDuff.Mode f17363e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private int[] f17364f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private boolean f17365g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    @o0
    private ColorStateList f17366h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    @m0
    private WeakReference<InterfaceC0193a> f17367i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private TextUtils.TruncateAt f17368j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private boolean f17369k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private int f17370l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private boolean f17371m1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    private static final int[] f17354o1 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private static final ShapeDrawable f17357r1 = new ShapeDrawable(new OvalShape());

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0193a {
        void a();
    }

    private a(@m0 Context context, AttributeSet attributeSet, @f int i7, @b1 int i8) {
        super(context, attributeSet, i7, i8);
        this.G = -1.0f;
        this.L0 = new Paint(1);
        this.N0 = new Paint.FontMetrics();
        this.O0 = new RectF();
        this.P0 = new PointF();
        this.Q0 = new Path();
        this.f17359a1 = 255;
        this.f17363e1 = PorterDuff.Mode.SRC_IN;
        this.f17367i1 = new WeakReference<>(null);
        Y(context);
        this.K0 = context;
        k kVar = new k(this);
        this.R0 = kVar;
        this.K = "";
        kVar.e().density = context.getResources().getDisplayMetrics().density;
        this.M0 = null;
        int[] iArr = f17354o1;
        setState(iArr);
        e3(iArr);
        this.f17369k1 = true;
        if (b.f18164a) {
            f17357r1.setTint(-1);
        }
    }

    private float F1() {
        Drawable drawable = this.Y0 ? this.Y : this.M;
        float fCeil = this.O;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(v.e(this.K0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    private float G1() {
        Drawable drawable = this.Y0 ? this.Y : this.M;
        float f8 = this.O;
        return (f8 > 0.0f || drawable == null) ? f8 : drawable.getIntrinsicWidth();
    }

    private boolean I3() {
        return this.X && this.Y != null && this.Y0;
    }

    private boolean J3() {
        return this.L && this.M != null;
    }

    private boolean K3() {
        return this.Q && this.R != null;
    }

    private void L3(@o0 Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void M3() {
        this.f17366h1 = this.f17365g1 ? b.d(this.f17358J) : null;
    }

    @TargetApi(21)
    private void N3() {
        this.S = new RippleDrawable(b.d(M1()), this.R, f17357r1);
    }

    private void O0(@o0 Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        d.m(drawable, d.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.R) {
            if (drawable.isStateful()) {
                drawable.setState(C1());
            }
            d.o(drawable, this.T);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.M;
        if (drawable == drawable2 && this.P) {
            d.o(drawable2, this.N);
        }
    }

    private void P0(@m0 Rect rect, @m0 RectF rectF) {
        rectF.setEmpty();
        if (J3() || I3()) {
            float f8 = this.C0 + this.D0;
            float fG1 = G1();
            if (d.f(this) == 0) {
                float f9 = rect.left + f8;
                rectF.left = f9;
                rectF.right = f9 + fG1;
            } else {
                float f10 = rect.right - f8;
                rectF.right = f10;
                rectF.left = f10 - fG1;
            }
            float fF1 = F1();
            float fExactCenterY = rect.exactCenterY() - (fF1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fF1;
        }
    }

    private void R0(@m0 Rect rect, @m0 RectF rectF) {
        rectF.set(rect);
        if (K3()) {
            float f8 = this.J0 + this.I0 + this.U + this.H0 + this.G0;
            if (d.f(this) == 0) {
                rectF.right = rect.right - f8;
            } else {
                rectF.left = rect.left + f8;
            }
        }
    }

    private void S0(@m0 Rect rect, @m0 RectF rectF) {
        rectF.setEmpty();
        if (K3()) {
            float f8 = this.J0 + this.I0;
            if (d.f(this) == 0) {
                float f9 = rect.right - f8;
                rectF.right = f9;
                rectF.left = f9 - this.U;
            } else {
                float f10 = rect.left + f8;
                rectF.left = f10;
                rectF.right = f10 + this.U;
            }
            float fExactCenterY = rect.exactCenterY();
            float f11 = this.U;
            float f12 = fExactCenterY - (f11 / 2.0f);
            rectF.top = f12;
            rectF.bottom = f12 + f11;
        }
    }

    @o0
    private ColorFilter S1() {
        ColorFilter colorFilter = this.f17360b1;
        return colorFilter != null ? colorFilter : this.f17361c1;
    }

    private void S2(@o0 ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            onStateChange(getState());
        }
    }

    private void T0(@m0 Rect rect, @m0 RectF rectF) {
        rectF.setEmpty();
        if (K3()) {
            float f8 = this.J0 + this.I0 + this.U + this.H0 + this.G0;
            if (d.f(this) == 0) {
                float f9 = rect.right;
                rectF.right = f9;
                rectF.left = f9 - f8;
            } else {
                int i7 = rect.left;
                rectF.left = i7;
                rectF.right = i7 + f8;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean U1(@o0 int[] iArr, @f int i7) {
        if (iArr == null) {
            return false;
        }
        for (int i8 : iArr) {
            if (i8 == i7) {
                return true;
            }
        }
        return false;
    }

    private void V0(@m0 Rect rect, @m0 RectF rectF) {
        rectF.setEmpty();
        if (this.K != null) {
            float fQ0 = this.C0 + Q0() + this.F0;
            float fU0 = this.J0 + U0() + this.G0;
            if (d.f(this) == 0) {
                rectF.left = rect.left + fQ0;
                rectF.right = rect.right - fU0;
            } else {
                rectF.left = rect.left + fU0;
                rectF.right = rect.right - fQ0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private float W0() {
        this.R0.e().getFontMetrics(this.N0);
        Paint.FontMetrics fontMetrics = this.N0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean Y0() {
        return this.X && this.Y != null && this.W;
    }

    @m0
    public static a Z0(@m0 Context context, @o0 AttributeSet attributeSet, @f int i7, @b1 int i8) {
        a aVar = new a(context, attributeSet, i7, i8);
        aVar.h2(attributeSet, i7, i8);
        return aVar;
    }

    @m0
    public static a a1(@m0 Context context, @i1 int i7) {
        AttributeSet attributeSetA = m1.a.a(context, i7, "chip");
        int styleAttribute = attributeSetA.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return Z0(context, attributeSetA, com.google.android.material.R.attr.chipStandaloneStyle, styleAttribute);
    }

    private void b1(@m0 Canvas canvas, @m0 Rect rect) {
        if (I3()) {
            P0(rect, this.O0);
            RectF rectF = this.O0;
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas.translate(f8, f9);
            this.Y.setBounds(0, 0, (int) this.O0.width(), (int) this.O0.height());
            this.Y.draw(canvas);
            canvas.translate(-f8, -f9);
        }
    }

    private void c1(@m0 Canvas canvas, @m0 Rect rect) {
        if (this.f17371m1) {
            return;
        }
        this.L0.setColor(this.T0);
        this.L0.setStyle(Paint.Style.FILL);
        this.L0.setColorFilter(S1());
        this.O0.set(rect);
        canvas.drawRoundRect(this.O0, n1(), n1(), this.L0);
    }

    private void d1(@m0 Canvas canvas, @m0 Rect rect) {
        if (J3()) {
            P0(rect, this.O0);
            RectF rectF = this.O0;
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas.translate(f8, f9);
            this.M.setBounds(0, 0, (int) this.O0.width(), (int) this.O0.height());
            this.M.draw(canvas);
            canvas.translate(-f8, -f9);
        }
    }

    private void e1(@m0 Canvas canvas, @m0 Rect rect) {
        if (this.I <= 0.0f || this.f17371m1) {
            return;
        }
        this.L0.setColor(this.V0);
        this.L0.setStyle(Paint.Style.STROKE);
        if (!this.f17371m1) {
            this.L0.setColorFilter(S1());
        }
        RectF rectF = this.O0;
        float f8 = rect.left;
        float f9 = this.I;
        rectF.set(f8 + (f9 / 2.0f), rect.top + (f9 / 2.0f), rect.right - (f9 / 2.0f), rect.bottom - (f9 / 2.0f));
        float f10 = this.G - (this.I / 2.0f);
        canvas.drawRoundRect(this.O0, f10, f10, this.L0);
    }

    private static boolean e2(@o0 ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void f1(@m0 Canvas canvas, @m0 Rect rect) {
        if (this.f17371m1) {
            return;
        }
        this.L0.setColor(this.S0);
        this.L0.setStyle(Paint.Style.FILL);
        this.O0.set(rect);
        canvas.drawRoundRect(this.O0, n1(), n1(), this.L0);
    }

    private static boolean f2(@o0 Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void g1(@m0 Canvas canvas, @m0 Rect rect) {
        if (K3()) {
            S0(rect, this.O0);
            RectF rectF = this.O0;
            float f8 = rectF.left;
            float f9 = rectF.top;
            canvas.translate(f8, f9);
            this.R.setBounds(0, 0, (int) this.O0.width(), (int) this.O0.height());
            if (b.f18164a) {
                this.S.setBounds(this.R.getBounds());
                this.S.jumpToCurrentState();
                this.S.draw(canvas);
            } else {
                this.R.draw(canvas);
            }
            canvas.translate(-f8, -f9);
        }
    }

    private static boolean g2(@o0 com.google.android.material.resources.d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f18138a) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void h1(@m0 Canvas canvas, @m0 Rect rect) {
        this.L0.setColor(this.W0);
        this.L0.setStyle(Paint.Style.FILL);
        this.O0.set(rect);
        if (!this.f17371m1) {
            canvas.drawRoundRect(this.O0, n1(), n1(), this.L0);
        } else {
            h(new RectF(rect), this.Q0);
            super.q(canvas, this.L0, this.Q0, v());
        }
    }

    private void h2(@o0 AttributeSet attributeSet, @f int i7, @b1 int i8) {
        TypedArray typedArrayJ = n.j(this.K0, attributeSet, com.google.android.material.R.styleable.Chip, i7, i8, new int[0]);
        this.f17371m1 = typedArrayJ.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        S2(c.a(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        u2(c.a(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        K2(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, 0.0f));
        if (typedArrayJ.hasValue(com.google.android.material.R.styleable.Chip_chipCornerRadius)) {
            w2(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_chipCornerRadius, 0.0f));
        }
        O2(c.a(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        Q2(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, 0.0f));
        s3(c.a(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_rippleColor));
        x3(typedArrayJ.getText(com.google.android.material.R.styleable.Chip_android_text));
        com.google.android.material.resources.d dVarF = c.f(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_android_textAppearance);
        dVarF.f18151n = typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_android_textSize, dVarF.f18151n);
        y3(dVarF);
        int i9 = typedArrayJ.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (i9 == 1) {
            k3(TextUtils.TruncateAt.START);
        } else if (i9 == 2) {
            k3(TextUtils.TruncateAt.MIDDLE);
        } else if (i9 == 3) {
            k3(TextUtils.TruncateAt.END);
        }
        J2(typedArrayJ.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(f17355p1, "chipIconEnabled") != null && attributeSet.getAttributeValue(f17355p1, "chipIconVisible") == null) {
            J2(typedArrayJ.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        }
        A2(c.d(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_chipIcon));
        if (typedArrayJ.hasValue(com.google.android.material.R.styleable.Chip_chipIconTint)) {
            G2(c.a(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_chipIconTint));
        }
        E2(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, -1.0f));
        i3(typedArrayJ.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(f17355p1, "closeIconEnabled") != null && attributeSet.getAttributeValue(f17355p1, "closeIconVisible") == null) {
            i3(typedArrayJ.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        }
        T2(c.d(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_closeIcon));
        f3(c.a(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_closeIconTint));
        a3(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, 0.0f));
        k2(typedArrayJ.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        t2(typedArrayJ.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(f17355p1, "checkedIconEnabled") != null && attributeSet.getAttributeValue(f17355p1, "checkedIconVisible") == null) {
            t2(typedArrayJ.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        }
        m2(c.d(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_checkedIcon));
        if (typedArrayJ.hasValue(com.google.android.material.R.styleable.Chip_checkedIconTint)) {
            q2(c.a(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_checkedIconTint));
        }
        v3(h.c(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_showMotionSpec));
        l3(h.c(this.K0, typedArrayJ, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        M2(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, 0.0f));
        p3(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, 0.0f));
        n3(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, 0.0f));
        E3(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, 0.0f));
        A3(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, 0.0f));
        c3(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, 0.0f));
        X2(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, 0.0f));
        y2(typedArrayJ.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, 0.0f));
        r3(typedArrayJ.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayJ.recycle();
    }

    private void i1(@m0 Canvas canvas, @m0 Rect rect) {
        Paint paint = this.M0;
        if (paint != null) {
            paint.setColor(v1.B(n2.f6743t, 127));
            canvas.drawRect(rect, this.M0);
            if (J3() || I3()) {
                P0(rect, this.O0);
                canvas.drawRect(this.O0, this.M0);
            }
            if (this.K != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.M0);
            }
            if (K3()) {
                S0(rect, this.O0);
                canvas.drawRect(this.O0, this.M0);
            }
            this.M0.setColor(v1.B(k.a.f34390c, 127));
            R0(rect, this.O0);
            canvas.drawRect(this.O0, this.M0);
            this.M0.setColor(v1.B(-16711936, 127));
            T0(rect, this.O0);
            canvas.drawRect(this.O0, this.M0);
        }
    }

    private void j1(@m0 Canvas canvas, @m0 Rect rect) {
        if (this.K != null) {
            Paint.Align alignX0 = X0(rect, this.P0);
            V0(rect, this.O0);
            if (this.R0.d() != null) {
                this.R0.e().drawableState = getState();
                this.R0.k(this.K0);
            }
            this.R0.e().setTextAlign(alignX0);
            int iSave = 0;
            boolean z7 = Math.round(this.R0.f(O1().toString())) > Math.round(this.O0.width());
            if (z7) {
                iSave = canvas.save();
                canvas.clipRect(this.O0);
            }
            CharSequence charSequenceEllipsize = this.K;
            if (z7 && this.f17368j1 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.R0.e(), this.O0.width(), this.f17368j1);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.P0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.R0.e());
            if (z7) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean j2(@m0 int[] iArr, @m0 int[] iArr2) {
        boolean z7;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.D;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.S0) : 0);
        boolean state = true;
        if (this.S0 != iL) {
            this.S0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.E;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.T0) : 0);
        if (this.T0 != iL2) {
            this.T0 = iL2;
            zOnStateChange = true;
        }
        int iG = k1.a.g(iL, iL2);
        if ((this.U0 != iG) | (y() == null)) {
            this.U0 = iG;
            n0(ColorStateList.valueOf(iG));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.H;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.V0) : 0;
        if (this.V0 != colorForState) {
            this.V0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f17366h1 == null || !b.e(iArr)) ? 0 : this.f17366h1.getColorForState(iArr, this.W0);
        if (this.W0 != colorForState2) {
            this.W0 = colorForState2;
            if (this.f17365g1) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.R0.d() == null || this.R0.d().f18138a == null) ? 0 : this.R0.d().f18138a.getColorForState(iArr, this.X0);
        if (this.X0 != colorForState3) {
            this.X0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z8 = U1(getState(), R.attr.state_checked) && this.W;
        if (this.Y0 == z8 || this.Y == null) {
            z7 = false;
        } else {
            float fQ0 = Q0();
            this.Y0 = z8;
            if (fQ0 != Q0()) {
                zOnStateChange = true;
                z7 = true;
            } else {
                z7 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f17362d1;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.Z0) : 0;
        if (this.Z0 != colorForState4) {
            this.Z0 = colorForState4;
            this.f17361c1 = m1.a.c(this, this.f17362d1, this.f17363e1);
        } else {
            state = zOnStateChange;
        }
        if (f2(this.M)) {
            state |= this.M.setState(iArr);
        }
        if (f2(this.Y)) {
            state |= this.Y.setState(iArr);
        }
        if (f2(this.R)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.R.setState(iArr3);
        }
        if (b.f18164a && f2(this.S)) {
            state |= this.S.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z7) {
            i2();
        }
        return state;
    }

    public float A1() {
        return this.U;
    }

    public void A2(@o0 Drawable drawable) {
        Drawable drawableP1 = p1();
        if (drawableP1 != drawable) {
            float fQ0 = Q0();
            this.M = drawable != null ? d.r(drawable).mutate() : null;
            float fQ1 = Q0();
            L3(drawableP1);
            if (J3()) {
                O0(this.M);
            }
            invalidateSelf();
            if (fQ0 != fQ1) {
                i2();
            }
        }
    }

    public void A3(float f8) {
        if (this.G0 != f8) {
            this.G0 = f8;
            invalidateSelf();
            i2();
        }
    }

    public float B1() {
        return this.H0;
    }

    @Deprecated
    public void B2(boolean z7) {
        J2(z7);
    }

    public void B3(@p int i7) {
        A3(this.K0.getResources().getDimension(i7));
    }

    @m0
    public int[] C1() {
        return this.f17364f1;
    }

    @Deprecated
    public void C2(@c.h int i7) {
        I2(i7);
    }

    public void C3(@a1 int i7) {
        x3(this.K0.getResources().getString(i7));
    }

    @o0
    public ColorStateList D1() {
        return this.T;
    }

    public void D2(@u int i7) {
        A2(e.a.b(this.K0, i7));
    }

    public void D3(@q float f8) {
        com.google.android.material.resources.d dVarP1 = P1();
        if (dVarP1 != null) {
            dVarP1.f18151n = f8;
            this.R0.e().setTextSize(f8);
            a();
        }
    }

    public void E1(@m0 RectF rectF) {
        T0(getBounds(), rectF);
    }

    public void E2(float f8) {
        if (this.O != f8) {
            float fQ0 = Q0();
            this.O = f8;
            float fQ1 = Q0();
            invalidateSelf();
            if (fQ0 != fQ1) {
                i2();
            }
        }
    }

    public void E3(float f8) {
        if (this.F0 != f8) {
            this.F0 = f8;
            invalidateSelf();
            i2();
        }
    }

    public void F2(@p int i7) {
        E2(this.K0.getResources().getDimension(i7));
    }

    public void F3(@p int i7) {
        E3(this.K0.getResources().getDimension(i7));
    }

    public void G2(@o0 ColorStateList colorStateList) {
        this.P = true;
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (J3()) {
                d.o(this.M, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void G3(boolean z7) {
        if (this.f17365g1 != z7) {
            this.f17365g1 = z7;
            M3();
            onStateChange(getState());
        }
    }

    public TextUtils.TruncateAt H1() {
        return this.f17368j1;
    }

    public void H2(@c.n int i7) {
        G2(e.a.a(this.K0, i7));
    }

    boolean H3() {
        return this.f17369k1;
    }

    @o0
    public h I1() {
        return this.B0;
    }

    public void I2(@c.h int i7) {
        J2(this.K0.getResources().getBoolean(i7));
    }

    public float J1() {
        return this.E0;
    }

    public void J2(boolean z7) {
        if (this.L != z7) {
            boolean zJ3 = J3();
            this.L = z7;
            boolean zJ4 = J3();
            if (zJ3 != zJ4) {
                if (zJ4) {
                    O0(this.M);
                } else {
                    L3(this.M);
                }
                invalidateSelf();
                i2();
            }
        }
    }

    public float K1() {
        return this.D0;
    }

    public void K2(float f8) {
        if (this.F != f8) {
            this.F = f8;
            invalidateSelf();
            i2();
        }
    }

    @r0
    public int L1() {
        return this.f17370l1;
    }

    public void L2(@p int i7) {
        K2(this.K0.getResources().getDimension(i7));
    }

    @o0
    public ColorStateList M1() {
        return this.f17358J;
    }

    public void M2(float f8) {
        if (this.C0 != f8) {
            this.C0 = f8;
            invalidateSelf();
            i2();
        }
    }

    @o0
    public h N1() {
        return this.A0;
    }

    public void N2(@p int i7) {
        M2(this.K0.getResources().getDimension(i7));
    }

    @o0
    public CharSequence O1() {
        return this.K;
    }

    public void O2(@o0 ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (this.f17371m1) {
                E0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @o0
    public com.google.android.material.resources.d P1() {
        return this.R0.d();
    }

    public void P2(@c.n int i7) {
        O2(e.a.a(this.K0, i7));
    }

    float Q0() {
        if (J3() || I3()) {
            return this.D0 + G1() + this.E0;
        }
        return 0.0f;
    }

    public float Q1() {
        return this.G0;
    }

    public void Q2(float f8) {
        if (this.I != f8) {
            this.I = f8;
            this.L0.setStrokeWidth(f8);
            if (this.f17371m1) {
                super.H0(f8);
            }
            invalidateSelf();
        }
    }

    public float R1() {
        return this.F0;
    }

    public void R2(@p int i7) {
        Q2(this.K0.getResources().getDimension(i7));
    }

    public boolean T1() {
        return this.f17365g1;
    }

    public void T2(@o0 Drawable drawable) {
        Drawable drawableX1 = x1();
        if (drawableX1 != drawable) {
            float fU0 = U0();
            this.R = drawable != null ? d.r(drawable).mutate() : null;
            if (b.f18164a) {
                N3();
            }
            float fU1 = U0();
            L3(drawableX1);
            if (K3()) {
                O0(this.R);
            }
            invalidateSelf();
            if (fU0 != fU1) {
                i2();
            }
        }
    }

    float U0() {
        if (K3()) {
            return this.H0 + this.U + this.I0;
        }
        return 0.0f;
    }

    public void U2(@o0 CharSequence charSequence) {
        if (this.V != charSequence) {
            this.V = androidx.core.text.a.c().m(charSequence);
            invalidateSelf();
        }
    }

    public boolean V1() {
        return this.W;
    }

    @Deprecated
    public void V2(boolean z7) {
        i3(z7);
    }

    @Deprecated
    public boolean W1() {
        return X1();
    }

    @Deprecated
    public void W2(@c.h int i7) {
        h3(i7);
    }

    @m0
    Paint.Align X0(@m0 Rect rect, @m0 PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.K != null) {
            float fQ0 = this.C0 + Q0() + this.F0;
            if (d.f(this) == 0) {
                pointF.x = rect.left + fQ0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fQ0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - W0();
        }
        return align;
    }

    public boolean X1() {
        return this.X;
    }

    public void X2(float f8) {
        if (this.I0 != f8) {
            this.I0 = f8;
            invalidateSelf();
            if (K3()) {
                i2();
            }
        }
    }

    @Deprecated
    public boolean Y1() {
        return Z1();
    }

    public void Y2(@p int i7) {
        X2(this.K0.getResources().getDimension(i7));
    }

    public boolean Z1() {
        return this.L;
    }

    public void Z2(@u int i7) {
        T2(e.a.b(this.K0, i7));
    }

    @Override // com.google.android.material.internal.k.b
    public void a() {
        i2();
        invalidateSelf();
    }

    @Deprecated
    public boolean a2() {
        return c2();
    }

    public void a3(float f8) {
        if (this.U != f8) {
            this.U = f8;
            invalidateSelf();
            if (K3()) {
                i2();
            }
        }
    }

    public boolean b2() {
        return f2(this.R);
    }

    public void b3(@p int i7) {
        a3(this.K0.getResources().getDimension(i7));
    }

    public boolean c2() {
        return this.Q;
    }

    public void c3(float f8) {
        if (this.H0 != f8) {
            this.H0 = f8;
            invalidateSelf();
            if (K3()) {
                i2();
            }
        }
    }

    boolean d2() {
        return this.f17371m1;
    }

    public void d3(@p int i7) {
        c3(this.K0.getResources().getDimension(i7));
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i7 = this.f17359a1;
        int iA = i7 < 255 ? j1.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i7) : 0;
        f1(canvas, bounds);
        c1(canvas, bounds);
        if (this.f17371m1) {
            super.draw(canvas);
        }
        e1(canvas, bounds);
        h1(canvas, bounds);
        d1(canvas, bounds);
        b1(canvas, bounds);
        if (this.f17369k1) {
            j1(canvas, bounds);
        }
        g1(canvas, bounds);
        i1(canvas, bounds);
        if (this.f17359a1 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public boolean e3(@m0 int[] iArr) {
        if (Arrays.equals(this.f17364f1, iArr)) {
            return false;
        }
        this.f17364f1 = iArr;
        if (K3()) {
            return j2(getState(), iArr);
        }
        return false;
    }

    public void f3(@o0 ColorStateList colorStateList) {
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (K3()) {
                d.o(this.R, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void g3(@c.n int i7) {
        f3(e.a.a(this.K0, i7));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17359a1;
    }

    @Override // android.graphics.drawable.Drawable
    @o0
    public ColorFilter getColorFilter() {
        return this.f17360b1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.C0 + Q0() + this.F0 + this.R0.f(O1().toString()) + this.G0 + U0() + this.J0), this.f17370l1);
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@m0 Outline outline) {
        if (this.f17371m1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.G);
        } else {
            outline.setRoundRect(bounds, this.G);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public void h3(@c.h int i7) {
        i3(this.K0.getResources().getBoolean(i7));
    }

    protected void i2() {
        InterfaceC0193a interfaceC0193a = this.f17367i1.get();
        if (interfaceC0193a != null) {
            interfaceC0193a.a();
        }
    }

    public void i3(boolean z7) {
        if (this.Q != z7) {
            boolean zK3 = K3();
            this.Q = z7;
            boolean zK4 = K3();
            if (zK3 != zK4) {
                if (zK4) {
                    O0(this.R);
                } else {
                    L3(this.R);
                }
                invalidateSelf();
                i2();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@m0 Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return e2(this.D) || e2(this.E) || e2(this.H) || (this.f17365g1 && e2(this.f17366h1)) || g2(this.R0.d()) || Y0() || f2(this.M) || f2(this.Y) || e2(this.f17362d1);
    }

    public void j3(@o0 InterfaceC0193a interfaceC0193a) {
        this.f17367i1 = new WeakReference<>(interfaceC0193a);
    }

    @o0
    public Drawable k1() {
        return this.Y;
    }

    public void k2(boolean z7) {
        if (this.W != z7) {
            this.W = z7;
            float fQ0 = Q0();
            if (!z7 && this.Y0) {
                this.Y0 = false;
            }
            float fQ1 = Q0();
            invalidateSelf();
            if (fQ0 != fQ1) {
                i2();
            }
        }
    }

    public void k3(@o0 TextUtils.TruncateAt truncateAt) {
        this.f17368j1 = truncateAt;
    }

    @o0
    public ColorStateList l1() {
        return this.Z;
    }

    public void l2(@c.h int i7) {
        k2(this.K0.getResources().getBoolean(i7));
    }

    public void l3(@o0 h hVar) {
        this.B0 = hVar;
    }

    @o0
    public ColorStateList m1() {
        return this.E;
    }

    public void m2(@o0 Drawable drawable) {
        if (this.Y != drawable) {
            float fQ0 = Q0();
            this.Y = drawable;
            float fQ1 = Q0();
            L3(this.Y);
            O0(this.Y);
            invalidateSelf();
            if (fQ0 != fQ1) {
                i2();
            }
        }
    }

    public void m3(@c.b int i7) {
        l3(h.d(this.K0, i7));
    }

    public float n1() {
        return this.f17371m1 ? R() : this.G;
    }

    @Deprecated
    public void n2(boolean z7) {
        t2(z7);
    }

    public void n3(float f8) {
        if (this.E0 != f8) {
            float fQ0 = Q0();
            this.E0 = f8;
            float fQ1 = Q0();
            invalidateSelf();
            if (fQ0 != fQ1) {
                i2();
            }
        }
    }

    public float o1() {
        return this.J0;
    }

    @Deprecated
    public void o2(@c.h int i7) {
        t2(this.K0.getResources().getBoolean(i7));
    }

    public void o3(@p int i7) {
        n3(this.K0.getResources().getDimension(i7));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i7) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i7);
        if (J3()) {
            zOnLayoutDirectionChanged |= d.m(this.M, i7);
        }
        if (I3()) {
            zOnLayoutDirectionChanged |= d.m(this.Y, i7);
        }
        if (K3()) {
            zOnLayoutDirectionChanged |= d.m(this.R, i7);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i7) {
        boolean zOnLevelChange = super.onLevelChange(i7);
        if (J3()) {
            zOnLevelChange |= this.M.setLevel(i7);
        }
        if (I3()) {
            zOnLevelChange |= this.Y.setLevel(i7);
        }
        if (K3()) {
            zOnLevelChange |= this.R.setLevel(i7);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable, com.google.android.material.internal.k.b
    public boolean onStateChange(@m0 int[] iArr) {
        if (this.f17371m1) {
            super.onStateChange(iArr);
        }
        return j2(iArr, C1());
    }

    @o0
    public Drawable p1() {
        Drawable drawable = this.M;
        if (drawable != null) {
            return d.q(drawable);
        }
        return null;
    }

    public void p2(@u int i7) {
        m2(e.a.b(this.K0, i7));
    }

    public void p3(float f8) {
        if (this.D0 != f8) {
            float fQ0 = Q0();
            this.D0 = f8;
            float fQ1 = Q0();
            invalidateSelf();
            if (fQ0 != fQ1) {
                i2();
            }
        }
    }

    public float q1() {
        return this.O;
    }

    public void q2(@o0 ColorStateList colorStateList) {
        if (this.Z != colorStateList) {
            this.Z = colorStateList;
            if (Y0()) {
                d.o(this.Y, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void q3(@p int i7) {
        p3(this.K0.getResources().getDimension(i7));
    }

    @o0
    public ColorStateList r1() {
        return this.N;
    }

    public void r2(@c.n int i7) {
        q2(e.a.a(this.K0, i7));
    }

    public void r3(@r0 int i7) {
        this.f17370l1 = i7;
    }

    public float s1() {
        return this.F;
    }

    public void s2(@c.h int i7) {
        t2(this.K0.getResources().getBoolean(i7));
    }

    public void s3(@o0 ColorStateList colorStateList) {
        if (this.f17358J != colorStateList) {
            this.f17358J = colorStateList;
            M3();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable, long j7) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j7);
        }
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        if (this.f17359a1 != i7) {
            this.f17359a1 = i7;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
    public void setColorFilter(@o0 ColorFilter colorFilter) {
        if (this.f17360b1 != colorFilter) {
            this.f17360b1 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(@o0 ColorStateList colorStateList) {
        if (this.f17362d1 != colorStateList) {
            this.f17362d1 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(@m0 PorterDuff.Mode mode) {
        if (this.f17363e1 != mode) {
            this.f17363e1 = mode;
            this.f17361c1 = m1.a.c(this, this.f17362d1, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean visible = super.setVisible(z7, z8);
        if (J3()) {
            visible |= this.M.setVisible(z7, z8);
        }
        if (I3()) {
            visible |= this.Y.setVisible(z7, z8);
        }
        if (K3()) {
            visible |= this.R.setVisible(z7, z8);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public float t1() {
        return this.C0;
    }

    public void t2(boolean z7) {
        if (this.X != z7) {
            boolean zI3 = I3();
            this.X = z7;
            boolean zI4 = I3();
            if (zI3 != zI4) {
                if (zI4) {
                    O0(this.Y);
                } else {
                    L3(this.Y);
                }
                invalidateSelf();
                i2();
            }
        }
    }

    public void t3(@c.n int i7) {
        s3(e.a.a(this.K0, i7));
    }

    @o0
    public ColorStateList u1() {
        return this.H;
    }

    public void u2(@o0 ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            onStateChange(getState());
        }
    }

    void u3(boolean z7) {
        this.f17369k1 = z7;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v1() {
        return this.I;
    }

    public void v2(@c.n int i7) {
        u2(e.a.a(this.K0, i7));
    }

    public void v3(@o0 h hVar) {
        this.A0 = hVar;
    }

    public void w1(@m0 RectF rectF) {
        R0(getBounds(), rectF);
    }

    @Deprecated
    public void w2(float f8) {
        if (this.G != f8) {
            this.G = f8;
            setShapeAppearanceModel(getShapeAppearanceModel().w(f8));
        }
    }

    public void w3(@c.b int i7) {
        v3(h.d(this.K0, i7));
    }

    @o0
    public Drawable x1() {
        Drawable drawable = this.R;
        if (drawable != null) {
            return d.q(drawable);
        }
        return null;
    }

    @Deprecated
    public void x2(@p int i7) {
        w2(this.K0.getResources().getDimension(i7));
    }

    public void x3(@o0 CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.K, charSequence)) {
            return;
        }
        this.K = charSequence;
        this.R0.j(true);
        invalidateSelf();
        i2();
    }

    @o0
    public CharSequence y1() {
        return this.V;
    }

    public void y2(float f8) {
        if (this.J0 != f8) {
            this.J0 = f8;
            invalidateSelf();
            i2();
        }
    }

    public void y3(@o0 com.google.android.material.resources.d dVar) {
        this.R0.i(dVar, this.K0);
    }

    public float z1() {
        return this.I0;
    }

    public void z2(@p int i7) {
        y2(this.K0.getResources().getDimension(i7));
    }

    public void z3(@b1 int i7) {
        y3(new com.google.android.material.resources.d(this.K0, i7));
    }
}
