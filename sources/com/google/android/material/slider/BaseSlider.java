package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import c.e0;
import c.g1;
import c.l;
import c.m0;
import c.o0;
import c.p;
import c.q;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.internal.u;
import com.google.android.material.internal.v;
import com.google.android.material.shape.j;
import com.google.android.material.shape.o;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a<S>, T extends com.google.android.material.slider.b<S>> extends View {
    private static final String C0 = "BaseSlider";
    private static final String D0 = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String E0 = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String F0 = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String G0 = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final String H0 = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String I0 = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    private static final int J0 = 200;
    private static final int K0 = 63;
    private static final double L0 = 1.0E-4d;
    static final int M0 = R.style.Widget_MaterialComponents_Slider;
    static final int N0 = 1;
    static final int O0 = 0;
    private static final long P0 = 83;
    private static final long Q0 = 117;
    private int A;
    private float A0;
    private float B;
    private int B0;
    private MotionEvent C;
    private com.google.android.material.slider.d D;
    private boolean E;
    private float F;
    private float G;
    private ArrayList<Float> H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f18366J;
    private float K;
    private float[] L;
    private boolean M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;

    @m0
    private ColorStateList R;

    @m0
    private ColorStateList S;

    @m0
    private ColorStateList T;

    @m0
    private ColorStateList U;

    @m0
    private ColorStateList V;

    @m0
    private final j W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Paint f18367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Paint f18368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final Paint f18369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final Paint f18370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    private final Paint f18371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    private final Paint f18372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m0
    private final e f18373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AccessibilityManager f18374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaseSlider<S, L, T>.d f18375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @m0
    private final f f18376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @m0
    private final List<com.google.android.material.tooltip.a> f18377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @m0
    private final List<L> f18378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @m0
    private final List<T> f18379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f18380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ValueAnimator f18381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueAnimator f18382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f18383q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f18384r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f18385s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f18386t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f18387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f18388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f18389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f18390x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f18391y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f18392z;

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f18393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f18394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList<Float> f18395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f18396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f18397e;

        static class a implements Parcelable.Creator<SliderState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(@m0 Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @m0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i7) {
                return new SliderState[i7];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeFloat(this.f18393a);
            parcel.writeFloat(this.f18394b);
            parcel.writeList(this.f18395c);
            parcel.writeFloat(this.f18396d);
            parcel.writeBooleanArray(new boolean[]{this.f18397e});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(@m0 Parcel parcel) {
            super(parcel);
            this.f18393a = parcel.readFloat();
            this.f18394b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f18395c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f18396d = parcel.readFloat();
            this.f18397e = parcel.createBooleanArray()[0];
        }
    }

    class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AttributeSet f18398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18399b;

        a(AttributeSet attributeSet, int i7) {
            this.f18398a = attributeSet;
            this.f18399b = i7;
        }

        @Override // com.google.android.material.slider.BaseSlider.f
        public com.google.android.material.tooltip.a a() {
            TypedArray typedArrayJ = n.j(BaseSlider.this.getContext(), this.f18398a, R.styleable.Slider, this.f18399b, BaseSlider.M0, new int[0]);
            com.google.android.material.tooltip.a aVarA0 = BaseSlider.a0(BaseSlider.this.getContext(), typedArrayJ);
            typedArrayJ.recycle();
            return aVarA0;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.f18377k.iterator();
            while (it.hasNext()) {
                ((com.google.android.material.tooltip.a) it.next()).k1(fFloatValue);
            }
            n2.n1(BaseSlider.this);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator it = BaseSlider.this.f18377k.iterator();
            while (it.hasNext()) {
                v.g(BaseSlider.this).b((com.google.android.material.tooltip.a) it.next());
            }
        }
    }

    private static class e extends androidx.customview.widget.a {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final BaseSlider<?, ?, ?> f18405t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        Rect f18406u;

        e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f18406u = new Rect();
            this.f18405t = baseSlider;
        }

        @m0
        private String a0(int i7) {
            if (i7 == this.f18405t.getValues().size() - 1) {
                return this.f18405t.getContext().getString(R.string.material_slider_range_end);
            }
            return i7 == 0 ? this.f18405t.getContext().getString(R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.a
        protected int C(float f8, float f9) {
            for (int i7 = 0; i7 < this.f18405t.getValues().size(); i7++) {
                this.f18405t.o0(i7, this.f18406u);
                if (this.f18406u.contains((int) f8, (int) f9)) {
                    return i7;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.a
        protected void D(List<Integer> list) {
            for (int i7 = 0; i7 < this.f18405t.getValues().size(); i7++) {
                list.add(Integer.valueOf(i7));
            }
        }

        @Override // androidx.customview.widget.a
        protected boolean N(int i7, int i8, Bundle bundle) {
            if (!this.f18405t.isEnabled()) {
                return false;
            }
            if (i8 != 4096 && i8 != 8192) {
                if (i8 == 16908349 && bundle != null && bundle.containsKey(l0.W)) {
                    if (this.f18405t.m0(i7, bundle.getFloat(l0.W))) {
                        this.f18405t.p0();
                        this.f18405t.postInvalidate();
                        G(i7);
                        return true;
                    }
                }
                return false;
            }
            float fM = this.f18405t.m(20);
            if (i8 == 8192) {
                fM = -fM;
            }
            if (this.f18405t.N()) {
                fM = -fM;
            }
            if (!this.f18405t.m0(i7, m.a.d(this.f18405t.getValues().get(i7).floatValue() + fM, this.f18405t.getValueFrom(), this.f18405t.getValueTo()))) {
                return false;
            }
            this.f18405t.p0();
            this.f18405t.postInvalidate();
            G(i7);
            return true;
        }

        @Override // androidx.customview.widget.a
        protected void R(int i7, l0 l0Var) {
            l0Var.b(l0.a.M);
            List<Float> values = this.f18405t.getValues();
            float fFloatValue = values.get(i7).floatValue();
            float valueFrom = this.f18405t.getValueFrom();
            float valueTo = this.f18405t.getValueTo();
            if (this.f18405t.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    l0Var.a(8192);
                }
                if (fFloatValue < valueTo) {
                    l0Var.a(4096);
                }
            }
            l0Var.C1(l0.d.e(1, valueFrom, valueTo, fFloatValue));
            l0Var.W0(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f18405t.getContentDescription() != null) {
                sb.append(this.f18405t.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(a0(i7));
                sb.append(this.f18405t.D(fFloatValue));
            }
            l0Var.a1(sb.toString());
            this.f18405t.o0(i7, this.f18406u);
            l0Var.R0(this.f18406u);
        }
    }

    private interface f {
        com.google.android.material.tooltip.a a();
    }

    public BaseSlider(@m0 Context context) {
        this(context, null);
    }

    private void A() {
        if (this.f18380n) {
            this.f18380n = false;
            ValueAnimator valueAnimatorQ = q(false);
            this.f18382p = valueAnimatorQ;
            this.f18381o = null;
            valueAnimatorQ.addListener(new c());
            this.f18382p.start();
        }
    }

    private void B(int i7) {
        if (i7 == 1) {
            U(Integer.MAX_VALUE);
            return;
        }
        if (i7 == 2) {
            U(Integer.MIN_VALUE);
        } else if (i7 == 17) {
            V(Integer.MAX_VALUE);
        } else {
            if (i7 != 66) {
                return;
            }
            V(Integer.MIN_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String D(float f8) {
        if (K()) {
            return this.D.a(f8);
        }
        return String.format(((float) ((int) f8)) == f8 ? "%.0f" : "%.2f", Float.valueOf(f8));
    }

    private float[] E() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.H.size() == 1) {
            fFloatValue2 = this.F;
        }
        float fW = W(fFloatValue2);
        float fW2 = W(fFloatValue);
        return N() ? new float[]{fW2, fW} : new float[]{fW, fW2};
    }

    private static float F(ValueAnimator valueAnimator, float f8) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f8;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    private float G(int i7, float f8) {
        float minSeparation = this.K == 0.0f ? getMinSeparation() : 0.0f;
        if (this.B0 == 0) {
            minSeparation = t(minSeparation);
        }
        if (N()) {
            minSeparation = -minSeparation;
        }
        int i8 = i7 + 1;
        int i9 = i7 - 1;
        return m.a.d(f8, i9 < 0 ? this.F : this.H.get(i9).floatValue() + minSeparation, i8 >= this.H.size() ? this.G : this.H.get(i8).floatValue() - minSeparation);
    }

    @l
    private int H(@m0 ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float I() {
        double dL0 = l0(this.A0);
        if (N()) {
            dL0 = 1.0d - dL0;
        }
        float f8 = this.G;
        float f9 = this.F;
        return (float) ((dL0 * ((double) (f8 - f9))) + ((double) f9));
    }

    private float J() {
        float f8 = this.A0;
        if (N()) {
            f8 = 1.0f - f8;
        }
        float f9 = this.G;
        float f10 = this.F;
        return (f8 * (f9 - f10)) + f10;
    }

    private void L() {
        this.f18367a.setStrokeWidth(this.f18388v);
        this.f18368b.setStrokeWidth(this.f18388v);
        this.f18371e.setStrokeWidth(this.f18388v / 2.0f);
        this.f18372f.setStrokeWidth(this.f18388v / 2.0f);
    }

    private boolean M() {
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void P(@m0 Resources resources) {
        this.f18386t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f18384r = dimensionPixelOffset;
        this.f18389w = dimensionPixelOffset;
        this.f18385s = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f18390x = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.A = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void Q() {
        if (this.K <= 0.0f) {
            return;
        }
        r0();
        int iMin = Math.min((int) (((this.G - this.F) / this.K) + 1.0f), (this.N / (this.f18388v * 2)) + 1);
        float[] fArr = this.L;
        if (fArr == null || fArr.length != iMin * 2) {
            this.L = new float[iMin * 2];
        }
        float f8 = this.N / (iMin - 1);
        for (int i7 = 0; i7 < iMin * 2; i7 += 2) {
            float[] fArr2 = this.L;
            fArr2[i7] = this.f18389w + ((i7 / 2) * f8);
            fArr2[i7 + 1] = n();
        }
    }

    private void R(@m0 Canvas canvas, int i7, int i8) {
        if (j0()) {
            int iW = (int) (this.f18389w + (W(this.H.get(this.f18366J).floatValue()) * i7));
            if (Build.VERSION.SDK_INT < 28) {
                int i9 = this.f18392z;
                canvas.clipRect(iW - i9, i8 - i9, iW + i9, i9 + i8, Region.Op.UNION);
            }
            canvas.drawCircle(iW, i8, this.f18392z, this.f18370d);
        }
    }

    private void S(@m0 Canvas canvas) {
        if (!this.M || this.K <= 0.0f) {
            return;
        }
        float[] fArrE = E();
        int iC0 = c0(this.L, fArrE[0]);
        int iC1 = c0(this.L, fArrE[1]);
        int i7 = iC0 * 2;
        canvas.drawPoints(this.L, 0, i7, this.f18371e);
        int i8 = iC1 * 2;
        canvas.drawPoints(this.L, i7, i8 - i7, this.f18372f);
        float[] fArr = this.L;
        canvas.drawPoints(fArr, i8, fArr.length - i8, this.f18371e);
    }

    private void T() {
        this.f18389w = this.f18384r + Math.max(this.f18391y - this.f18385s, 0);
        if (n2.U0(this)) {
            q0(getWidth());
        }
    }

    private boolean U(int i7) {
        int i8 = this.f18366J;
        int iF = (int) m.a.f(((long) i8) + ((long) i7), 0L, this.H.size() - 1);
        this.f18366J = iF;
        if (iF == i8) {
            return false;
        }
        if (this.I != -1) {
            this.I = iF;
        }
        p0();
        postInvalidate();
        return true;
    }

    private boolean V(int i7) {
        if (N()) {
            i7 = i7 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i7;
        }
        return U(i7);
    }

    private float W(float f8) {
        float f9 = this.F;
        float f10 = (f8 - f9) / (this.G - f9);
        return N() ? 1.0f - f10 : f10;
    }

    private Boolean X(int i7, @m0 KeyEvent keyEvent) {
        if (i7 == 61) {
            if (keyEvent.hasNoModifiers()) {
                return Boolean.valueOf(U(1));
            }
            return keyEvent.isShiftPressed() ? Boolean.valueOf(U(-1)) : Boolean.FALSE;
        }
        if (i7 != 66) {
            if (i7 != 81) {
                if (i7 == 69) {
                    U(-1);
                    return Boolean.TRUE;
                }
                if (i7 != 70) {
                    switch (i7) {
                        case 21:
                            V(-1);
                            return Boolean.TRUE;
                        case 22:
                            V(1);
                            return Boolean.TRUE;
                        case 23:
                            break;
                        default:
                            return null;
                    }
                }
            }
            U(1);
            return Boolean.TRUE;
        }
        this.I = this.f18366J;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void Y() {
        Iterator<T> it = this.f18379m.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void Z() {
        Iterator<T> it = this.f18379m.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @m0
    public static com.google.android.material.tooltip.a a0(@m0 Context context, @m0 TypedArray typedArray) {
        return com.google.android.material.tooltip.a.U0(context, null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int c0(float[] fArr, float f8) {
        return Math.round(f8 * ((fArr.length / 2) - 1));
    }

    private void d0(Context context, AttributeSet attributeSet, int i7) {
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.Slider, i7, M0, new int[0]);
        this.F = typedArrayJ.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.G = typedArrayJ.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.F));
        this.K = typedArrayJ.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        boolean zHasValue = typedArrayJ.hasValue(R.styleable.Slider_trackColor);
        int i8 = zHasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
        int i9 = zHasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
        ColorStateList colorStateListA = com.google.android.material.resources.c.a(context, typedArrayJ, i8);
        if (colorStateListA == null) {
            colorStateListA = e.a.a(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateListA);
        ColorStateList colorStateListA2 = com.google.android.material.resources.c.a(context, typedArrayJ, i9);
        if (colorStateListA2 == null) {
            colorStateListA2 = e.a.a(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateListA2);
        this.W.n0(com.google.android.material.resources.c.a(context, typedArrayJ, R.styleable.Slider_thumbColor));
        if (typedArrayJ.hasValue(R.styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(com.google.android.material.resources.c.a(context, typedArrayJ, R.styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(typedArrayJ.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA3 = com.google.android.material.resources.c.a(context, typedArrayJ, R.styleable.Slider_haloColor);
        if (colorStateListA3 == null) {
            colorStateListA3 = e.a.a(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateListA3);
        this.M = typedArrayJ.getBoolean(R.styleable.Slider_tickVisible, true);
        boolean zHasValue2 = typedArrayJ.hasValue(R.styleable.Slider_tickColor);
        int i10 = zHasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
        int i11 = zHasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
        ColorStateList colorStateListA4 = com.google.android.material.resources.c.a(context, typedArrayJ, i10);
        if (colorStateListA4 == null) {
            colorStateListA4 = e.a.a(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateListA4);
        ColorStateList colorStateListA5 = com.google.android.material.resources.c.a(context, typedArrayJ, i11);
        if (colorStateListA5 == null) {
            colorStateListA5 = e.a.a(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateListA5);
        setThumbRadius(typedArrayJ.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayJ.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayJ.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayJ.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.f18387u = typedArrayJ.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!typedArrayJ.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayJ.recycle();
    }

    private void g0(int i7) {
        BaseSlider<S, L, T>.d dVar = this.f18375i;
        if (dVar == null) {
            this.f18375i = new d(this, null);
        } else {
            removeCallbacks(dVar);
        }
        this.f18375i.a(i7);
        postDelayed(this.f18375i, 200L);
    }

    private void h0(com.google.android.material.tooltip.a aVar, float f8) {
        aVar.l1(D(f8));
        int iW = (this.f18389w + ((int) (W(f8) * this.N))) - (aVar.getIntrinsicWidth() / 2);
        int iN = n() - (this.A + this.f18391y);
        aVar.setBounds(iW, iN - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + iW, iN);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.c.c(v.f(this), this, rect);
        aVar.setBounds(rect);
        v.g(this).a(aVar);
    }

    private void i0(@m0 ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.H.size() == arrayList.size() && this.H.equals(arrayList)) {
            return;
        }
        this.H = arrayList;
        this.Q = true;
        this.f18366J = 0;
        p0();
        r();
        v();
        postInvalidate();
    }

    private void j(com.google.android.material.tooltip.a aVar) {
        aVar.j1(v.f(this));
    }

    private boolean j0() {
        return this.O || !(getBackground() instanceof RippleDrawable);
    }

    private Float k(int i7) {
        float fM = this.P ? m(20) : l();
        if (i7 == 21) {
            if (!N()) {
                fM = -fM;
            }
            return Float.valueOf(fM);
        }
        if (i7 == 22) {
            if (N()) {
                fM = -fM;
            }
            return Float.valueOf(fM);
        }
        if (i7 == 69) {
            return Float.valueOf(-fM);
        }
        if (i7 == 70 || i7 == 81) {
            return Float.valueOf(fM);
        }
        return null;
    }

    private boolean k0(float f8) {
        return m0(this.I, f8);
    }

    private float l() {
        float f8 = this.K;
        if (f8 == 0.0f) {
            return 1.0f;
        }
        return f8;
    }

    private double l0(float f8) {
        float f9 = this.K;
        if (f9 <= 0.0f) {
            return f8;
        }
        int i7 = (int) ((this.G - this.F) / f9);
        return ((double) Math.round(f8 * i7)) / ((double) i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m(int i7) {
        float fL = l();
        float f8 = (this.G - this.F) / fL;
        float f9 = i7;
        return f8 <= f9 ? fL : Math.round(f8 / f9) * fL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0(int i7, float f8) {
        if (Math.abs(f8 - this.H.get(i7).floatValue()) < L0) {
            return false;
        }
        this.H.set(i7, Float.valueOf(G(i7, f8)));
        this.f18366J = i7;
        u(i7);
        return true;
    }

    private int n() {
        return this.f18390x + (this.f18387u == 1 ? this.f18377k.get(0).getIntrinsicHeight() : 0);
    }

    private boolean n0() {
        return k0(I());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        if (j0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iW = (int) ((W(this.H.get(this.f18366J).floatValue()) * this.N) + this.f18389w);
            int iN = n();
            int i7 = this.f18392z;
            androidx.core.graphics.drawable.d.l(background, iW - i7, iN - i7, iW + i7, iN + i7);
        }
    }

    private ValueAnimator q(boolean z7) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(F(z7 ? this.f18382p : this.f18381o, z7 ? 0.0f : 1.0f), z7 ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z7 ? P0 : Q0);
        valueAnimatorOfFloat.setInterpolator(z7 ? com.google.android.material.animation.a.f16850e : com.google.android.material.animation.a.f16848c);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    private void q0(int i7) {
        this.N = Math.max(i7 - (this.f18389w * 2), 0);
        Q();
    }

    private void r() {
        if (this.f18377k.size() > this.H.size()) {
            List<com.google.android.material.tooltip.a> listSubList = this.f18377k.subList(this.H.size(), this.f18377k.size());
            for (com.google.android.material.tooltip.a aVar : listSubList) {
                if (n2.O0(this)) {
                    s(aVar);
                }
            }
            listSubList.clear();
        }
        while (this.f18377k.size() < this.H.size()) {
            com.google.android.material.tooltip.a aVarA = this.f18376j.a();
            this.f18377k.add(aVarA);
            if (n2.O0(this)) {
                j(aVarA);
            }
        }
        int i7 = this.f18377k.size() == 1 ? 0 : 1;
        Iterator<com.google.android.material.tooltip.a> it = this.f18377k.iterator();
        while (it.hasNext()) {
            it.next().H0(i7);
        }
    }

    private void r0() {
        if (this.Q) {
            t0();
            u0();
            s0();
            v0();
            y0();
            this.Q = false;
        }
    }

    private void s(com.google.android.material.tooltip.a aVar) {
        u uVarG = v.g(this);
        if (uVarG != null) {
            uVarG.b(aVar);
            aVar.W0(v.f(this));
        }
    }

    private void s0() {
        if (this.K > 0.0f && !w0(this.G)) {
            throw new IllegalStateException(String.format(H0, Float.toString(this.K), Float.toString(this.F), Float.toString(this.G)));
        }
    }

    private float t(float f8) {
        if (f8 == 0.0f) {
            return 0.0f;
        }
        float f9 = (f8 - this.f18389w) / this.N;
        float f10 = this.F;
        return (f9 * (f10 - this.G)) + f10;
    }

    private void t0() {
        if (this.F >= this.G) {
            throw new IllegalStateException(String.format(F0, Float.toString(this.F), Float.toString(this.G)));
        }
    }

    private void u(int i7) {
        Iterator<L> it = this.f18378l.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.H.get(i7).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f18374h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        g0(i7);
    }

    private void u0() {
        if (this.G <= this.F) {
            throw new IllegalStateException(String.format(G0, Float.toString(this.G), Float.toString(this.F)));
        }
    }

    private void v() {
        for (L l7 : this.f18378l) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                l7.a(this, it.next().floatValue(), false);
            }
        }
    }

    private void v0() {
        for (Float f8 : this.H) {
            if (f8.floatValue() < this.F || f8.floatValue() > this.G) {
                throw new IllegalStateException(String.format(D0, Float.toString(f8.floatValue()), Float.toString(this.F), Float.toString(this.G)));
            }
            if (this.K > 0.0f && !w0(f8.floatValue())) {
                throw new IllegalStateException(String.format(E0, Float.toString(f8.floatValue()), Float.toString(this.F), Float.toString(this.K), Float.toString(this.K)));
            }
        }
    }

    private void w(@m0 Canvas canvas, int i7, int i8) {
        float[] fArrE = E();
        int i9 = this.f18389w;
        float f8 = i7;
        float f9 = i8;
        canvas.drawLine(i9 + (fArrE[0] * f8), f9, i9 + (fArrE[1] * f8), f9, this.f18368b);
    }

    private boolean w0(float f8) {
        double dDoubleValue = new BigDecimal(Float.toString(f8)).subtract(new BigDecimal(Float.toString(this.F))).divide(new BigDecimal(Float.toString(this.K)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < L0;
    }

    private void x(@m0 Canvas canvas, int i7, int i8) {
        float[] fArrE = E();
        int i9 = this.f18389w;
        float f8 = i7;
        float f9 = i9 + (fArrE[1] * f8);
        if (f9 < i9 + i7) {
            float f10 = i8;
            canvas.drawLine(f9, f10, i9 + i7, f10, this.f18367a);
        }
        int i10 = this.f18389w;
        float f11 = i10 + (fArrE[0] * f8);
        if (f11 > i10) {
            float f12 = i8;
            canvas.drawLine(i10, f12, f11, f12, this.f18367a);
        }
    }

    private float x0(float f8) {
        return (W(f8) * this.N) + this.f18389w;
    }

    private void y(@m0 Canvas canvas, int i7, int i8) {
        if (!isEnabled()) {
            Iterator<Float> it = this.H.iterator();
            while (it.hasNext()) {
                canvas.drawCircle(this.f18389w + (W(it.next().floatValue()) * i7), i8, this.f18391y, this.f18369c);
            }
        }
        for (Float f8 : this.H) {
            canvas.save();
            int iW = this.f18389w + ((int) (W(f8.floatValue()) * i7));
            int i9 = this.f18391y;
            canvas.translate(iW - i9, i8 - i9);
            this.W.draw(canvas);
            canvas.restore();
        }
    }

    private void y0() {
        float f8 = this.K;
        if (f8 == 0.0f) {
            return;
        }
        if (((int) f8) != f8) {
            Log.w(C0, String.format(I0, "stepSize", Float.valueOf(f8)));
        }
        float f9 = this.F;
        if (((int) f9) != f9) {
            Log.w(C0, String.format(I0, "valueFrom", Float.valueOf(f9)));
        }
        float f10 = this.G;
        if (((int) f10) != f10) {
            Log.w(C0, String.format(I0, "valueTo", Float.valueOf(f10)));
        }
    }

    private void z() {
        if (this.f18387u == 2) {
            return;
        }
        if (!this.f18380n) {
            this.f18380n = true;
            ValueAnimator valueAnimatorQ = q(true);
            this.f18381o = valueAnimatorQ;
            this.f18382p = null;
            valueAnimatorQ.start();
        }
        Iterator<com.google.android.material.tooltip.a> it = this.f18377k.iterator();
        for (int i7 = 0; i7 < this.H.size() && it.hasNext(); i7++) {
            if (i7 != this.f18366J) {
                h0(it.next(), this.H.get(i7).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f18377k.size()), Integer.valueOf(this.H.size())));
        }
        h0(it.next(), this.H.get(this.f18366J).floatValue());
    }

    @g1
    void C(boolean z7) {
        this.O = z7;
    }

    public boolean K() {
        return this.D != null;
    }

    final boolean N() {
        return n2.Z(this) == 1;
    }

    public boolean O() {
        return this.M;
    }

    protected boolean b0() {
        if (this.I != -1) {
            return true;
        }
        float fJ = J();
        float fX0 = x0(fJ);
        this.I = 0;
        float fAbs = Math.abs(this.H.get(0).floatValue() - fJ);
        for (int i7 = 1; i7 < this.H.size(); i7++) {
            float fAbs2 = Math.abs(this.H.get(i7).floatValue() - fJ);
            float fX1 = x0(this.H.get(i7).floatValue());
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z7 = !N() ? fX1 - fX0 >= 0.0f : fX1 - fX0 <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.I = i7;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fX1 - fX0) < this.f18383q) {
                        this.I = -1;
                        return false;
                    }
                    if (z7) {
                        this.I = i7;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.I != -1;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@m0 MotionEvent motionEvent) {
        return this.f18373g.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@m0 KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f18367a.setColor(H(this.V));
        this.f18368b.setColor(H(this.U));
        this.f18371e.setColor(H(this.T));
        this.f18372f.setColor(H(this.S));
        for (com.google.android.material.tooltip.a aVar : this.f18377k) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.W.isStateful()) {
            this.W.setState(getDrawableState());
        }
        this.f18370d.setColor(H(this.R));
        this.f18370d.setAlpha(63);
    }

    public void e0(@m0 L l7) {
        this.f18378l.remove(l7);
    }

    public void f0(@m0 T t7) {
        this.f18379m.remove(t7);
    }

    @Override // android.view.View
    @m0
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @g1
    final int getAccessibilityFocusedVirtualViewId() {
        return this.f18373g.x();
    }

    public int getActiveThumbIndex() {
        return this.I;
    }

    public int getFocusedThumbIndex() {
        return this.f18366J;
    }

    @q
    public int getHaloRadius() {
        return this.f18392z;
    }

    @m0
    public ColorStateList getHaloTintList() {
        return this.R;
    }

    public int getLabelBehavior() {
        return this.f18387u;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.K;
    }

    public float getThumbElevation() {
        return this.W.x();
    }

    @q
    public int getThumbRadius() {
        return this.f18391y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.W.M();
    }

    public float getThumbStrokeWidth() {
        return this.W.P();
    }

    @m0
    public ColorStateList getThumbTintList() {
        return this.W.y();
    }

    @m0
    public ColorStateList getTickActiveTintList() {
        return this.S;
    }

    @m0
    public ColorStateList getTickInactiveTintList() {
        return this.T;
    }

    @m0
    public ColorStateList getTickTintList() {
        if (this.T.equals(this.S)) {
            return this.S;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @m0
    public ColorStateList getTrackActiveTintList() {
        return this.U;
    }

    @q
    public int getTrackHeight() {
        return this.f18388v;
    }

    @m0
    public ColorStateList getTrackInactiveTintList() {
        return this.V;
    }

    @q
    public int getTrackSidePadding() {
        return this.f18389w;
    }

    @m0
    public ColorStateList getTrackTintList() {
        if (this.V.equals(this.U)) {
            return this.U;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @q
    public int getTrackWidth() {
        return this.N;
    }

    public float getValueFrom() {
        return this.F;
    }

    public float getValueTo() {
        return this.G;
    }

    @m0
    List<Float> getValues() {
        return new ArrayList(this.H);
    }

    public void h(@o0 L l7) {
        this.f18378l.add(l7);
    }

    public void i(@m0 T t7) {
        this.f18379m.add(t7);
    }

    public void o() {
        this.f18378l.clear();
    }

    void o0(int i7, Rect rect) {
        int iW = this.f18389w + ((int) (W(getValues().get(i7).floatValue()) * this.N));
        int iN = n();
        int i8 = this.f18391y;
        rect.set(iW - i8, iN - i8, iW + i8, iN + i8);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<com.google.android.material.tooltip.a> it = this.f18377k.iterator();
        while (it.hasNext()) {
            j(it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.d dVar = this.f18375i;
        if (dVar != null) {
            removeCallbacks(dVar);
        }
        this.f18380n = false;
        Iterator<com.google.android.material.tooltip.a> it = this.f18377k.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@m0 Canvas canvas) {
        if (this.Q) {
            r0();
            Q();
        }
        super.onDraw(canvas);
        int iN = n();
        x(canvas, this.N, iN);
        if (((Float) Collections.max(getValues())).floatValue() > this.F) {
            w(canvas, this.N, iN);
        }
        S(canvas);
        if ((this.E || isFocused()) && isEnabled()) {
            R(canvas, this.N, iN);
            if (this.I != -1) {
                z();
            }
        }
        y(canvas, this.N, iN);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z7, int i7, @o0 Rect rect) {
        super.onFocusChanged(z7, i7, rect);
        if (z7) {
            B(i7);
            this.f18373g.X(this.f18366J);
        } else {
            this.I = -1;
            A();
            this.f18373g.o(this.f18366J);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, @m0 KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i7, keyEvent);
        }
        if (this.H.size() == 1) {
            this.I = 0;
        }
        if (this.I == -1) {
            Boolean boolX = X(i7, keyEvent);
            return boolX != null ? boolX.booleanValue() : super.onKeyDown(i7, keyEvent);
        }
        this.P |= keyEvent.isLongPress();
        Float fK = k(i7);
        if (fK != null) {
            if (k0(this.H.get(this.I).floatValue() + fK.floatValue())) {
                p0();
                postInvalidate();
            }
            return true;
        }
        if (i7 != 23) {
            if (i7 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return U(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return U(-1);
                }
                return false;
            }
            if (i7 != 66) {
                return super.onKeyDown(i7, keyEvent);
            }
        }
        this.I = -1;
        A();
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i7, @m0 KeyEvent keyEvent) {
        this.P = false;
        return super.onKeyUp(i7, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(this.f18386t + (this.f18387u == 1 ? this.f18377k.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.F = sliderState.f18393a;
        this.G = sliderState.f18394b;
        i0(sliderState.f18395c);
        this.K = sliderState.f18396d;
        if (sliderState.f18397e) {
            requestFocus();
        }
        v();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f18393a = this.F;
        sliderState.f18394b = this.G;
        sliderState.f18395c = new ArrayList<>(this.H);
        sliderState.f18396d = this.K;
        sliderState.f18397e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        q0(i7);
        p0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@m0 MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x7 = motionEvent.getX();
        float f8 = (x7 - this.f18389w) / this.N;
        this.A0 = f8;
        float fMax = Math.max(0.0f, f8);
        this.A0 = fMax;
        this.A0 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = x7;
            if (!M()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (b0()) {
                    requestFocus();
                    this.E = true;
                    n0();
                    p0();
                    invalidate();
                    Y();
                }
            }
        } else if (actionMasked == 1) {
            this.E = false;
            MotionEvent motionEvent2 = this.C;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.C.getX() - motionEvent.getX()) <= this.f18383q && Math.abs(this.C.getY() - motionEvent.getY()) <= this.f18383q && b0()) {
                Y();
            }
            if (this.I != -1) {
                n0();
                this.I = -1;
                Z();
            }
            A();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.E) {
                if (M() && Math.abs(x7 - this.B) < this.f18383q) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                Y();
            }
            if (b0()) {
                this.E = true;
                n0();
                p0();
                invalidate();
            }
        }
        setPressed(this.E);
        this.C = MotionEvent.obtain(motionEvent);
        return true;
    }

    public void p() {
        this.f18379m.clear();
    }

    protected void setActiveThumbIndex(int i7) {
        this.I = i7;
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        setLayerType(z7 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i7) {
        if (i7 < 0 || i7 >= this.H.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f18366J = i7;
        this.f18373g.X(i7);
        postInvalidate();
    }

    public void setHaloRadius(@e0(from = 0) @q int i7) {
        if (i7 == this.f18392z) {
            return;
        }
        this.f18392z = i7;
        Drawable background = getBackground();
        if (j0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            m1.a.b((RippleDrawable) background, this.f18392z);
        }
    }

    public void setHaloRadiusResource(@p int i7) {
        setHaloRadius(getResources().getDimensionPixelSize(i7));
    }

    public void setHaloTintList(@m0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.R)) {
            return;
        }
        this.R = colorStateList;
        Drawable background = getBackground();
        if (!j0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f18370d.setColor(H(colorStateList));
        this.f18370d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i7) {
        if (this.f18387u != i7) {
            this.f18387u = i7;
            requestLayout();
        }
    }

    public void setLabelFormatter(@o0 com.google.android.material.slider.d dVar) {
        this.D = dVar;
    }

    protected void setSeparationUnit(int i7) {
        this.B0 = i7;
    }

    public void setStepSize(float f8) {
        if (f8 < 0.0f) {
            throw new IllegalArgumentException(String.format(H0, Float.toString(f8), Float.toString(this.F), Float.toString(this.G)));
        }
        if (this.K != f8) {
            this.K = f8;
            this.Q = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f8) {
        this.W.m0(f8);
    }

    public void setThumbElevationResource(@p int i7) {
        setThumbElevation(getResources().getDimension(i7));
    }

    public void setThumbRadius(@e0(from = 0) @q int i7) {
        if (i7 == this.f18391y) {
            return;
        }
        this.f18391y = i7;
        T();
        this.W.setShapeAppearanceModel(o.a().q(0, this.f18391y).m());
        j jVar = this.W;
        int i8 = this.f18391y;
        jVar.setBounds(0, 0, i8 * 2, i8 * 2);
        postInvalidate();
    }

    public void setThumbRadiusResource(@p int i7) {
        setThumbRadius(getResources().getDimensionPixelSize(i7));
    }

    public void setThumbStrokeColor(@o0 ColorStateList colorStateList) {
        this.W.E0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@c.n int i7) {
        if (i7 != 0) {
            setThumbStrokeColor(e.a.a(getContext(), i7));
        }
    }

    public void setThumbStrokeWidth(float f8) {
        this.W.H0(f8);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@p int i7) {
        if (i7 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i7));
        }
    }

    public void setThumbTintList(@m0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.W.y())) {
            return;
        }
        this.W.n0(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(@m0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.S)) {
            return;
        }
        this.S = colorStateList;
        this.f18372f.setColor(H(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(@m0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.T)) {
            return;
        }
        this.T = colorStateList;
        this.f18371e.setColor(H(colorStateList));
        invalidate();
    }

    public void setTickTintList(@m0 ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z7) {
        if (this.M != z7) {
            this.M = z7;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@m0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.U)) {
            return;
        }
        this.U = colorStateList;
        this.f18368b.setColor(H(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@e0(from = 0) @q int i7) {
        if (this.f18388v != i7) {
            this.f18388v = i7;
            L();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(@m0 ColorStateList colorStateList) {
        if (colorStateList.equals(this.V)) {
            return;
        }
        this.V = colorStateList;
        this.f18367a.setColor(H(colorStateList));
        invalidate();
    }

    public void setTrackTintList(@m0 ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f8) {
        this.F = f8;
        this.Q = true;
        postInvalidate();
    }

    public void setValueTo(float f8) {
        this.G = f8;
        this.Q = true;
        postInvalidate();
    }

    void setValues(@m0 Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        i0(arrayList);
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18403a;

        private d() {
            this.f18403a = -1;
        }

        void a(int i7) {
            this.f18403a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f18373g.Y(this.f18403a, 4);
        }

        /* synthetic */ d(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    public BaseSlider(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(q1.a.c(context, attributeSet, i7, M0), attributeSet, i7);
        this.f18377k = new ArrayList();
        this.f18378l = new ArrayList();
        this.f18379m = new ArrayList();
        this.f18380n = false;
        this.E = false;
        this.H = new ArrayList<>();
        this.I = -1;
        this.f18366J = -1;
        this.K = 0.0f;
        this.M = true;
        this.P = false;
        j jVar = new j();
        this.W = jVar;
        this.B0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f18367a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f18368b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f18369c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f18370d = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f18371e = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f18372f = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        P(context2.getResources());
        this.f18376j = new a(attributeSet, i7);
        d0(context2, attributeSet, i7);
        setFocusable(true);
        setClickable(true);
        jVar.w0(2);
        this.f18383q = ViewConfiguration.get(context2).getScaledTouchSlop();
        e eVar = new e(this);
        this.f18373g = eVar;
        n2.B1(this, eVar);
        this.f18374h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    void setValues(@m0 List<Float> list) {
        i0(new ArrayList<>(list));
    }
}
