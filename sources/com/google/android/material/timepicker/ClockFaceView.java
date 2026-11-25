package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import c.a1;
import c.m0;
import c.o0;
import c.v;
import com.google.android.material.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.d {
    private static final float D0 = 0.001f;
    private static final int E0 = 12;
    private static final String F0 = "";
    private String[] A0;
    private float B0;
    private final ColorStateList C0;
    private final ClockHandView M;
    private final Rect N;
    private final RectF O;
    private final SparseArray<TextView> P;
    private final androidx.core.view.a Q;
    private final int[] R;
    private final float[] S;
    private final int T;
    private final int U;
    private final int V;
    private final int W;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.I(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.M.g()) - ClockFaceView.this.T);
            return true;
        }
    }

    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
            if (iIntValue > 0) {
                l0Var.Q1((View) ClockFaceView.this.P.get(iIntValue - 1));
            }
            l0Var.Z0(l0.c.h(0, 1, iIntValue, 1, false, view.isSelected()));
        }
    }

    public ClockFaceView(@m0 Context context) {
        this(context, null);
    }

    private void P() {
        RectF rectFD = this.M.d();
        for (int i7 = 0; i7 < this.P.size(); i7++) {
            TextView textView = this.P.get(i7);
            if (textView != null) {
                textView.getDrawingRect(this.N);
                this.N.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.N);
                this.O.set(this.N);
                textView.getPaint().setShader(Q(rectFD, this.O));
                textView.invalidate();
            }
        }
    }

    private RadialGradient Q(RectF rectF, RectF rectF2) {
        if (RectF.intersects(rectF, rectF2)) {
            return new RadialGradient(rectF.centerX() - this.O.left, rectF.centerY() - this.O.top, rectF.width() * 0.5f, this.R, this.S, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static float R(float f8, float f9, float f10) {
        return Math.max(Math.max(f8, f9), f10);
    }

    private void S(@a1 int i7) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.P.size();
        for (int i8 = 0; i8 < Math.max(this.A0.length, size); i8++) {
            TextView textView = this.P.get(i8);
            if (i8 >= this.A0.length) {
                removeView(textView);
                this.P.remove(i8);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.P.put(i8, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.A0[i8]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i8));
                n2.B1(textView, this.Q);
                textView.setTextColor(this.C0);
                if (i7 != 0) {
                    textView.setContentDescription(getResources().getString(i7, this.A0[i8]));
                }
            }
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void I(int i7) {
        if (i7 != H()) {
            super.I(i7);
            this.M.k(H());
        }
    }

    public void c(String[] strArr, @a1 int i7) {
        this.A0 = strArr;
        S(i7);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void d(float f8, boolean z7) {
        if (Math.abs(this.B0 - f8) > D0) {
            this.B0 = f8;
            P();
        }
    }

    public void g(@v(from = 0.0d, to = 360.0d) float f8) {
        this.M.l(f8);
        P();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        l0.X1(accessibilityNodeInfo).Y0(l0.b.f(1, this.A0.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        P();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iR = (int) (this.W / R(this.U / displayMetrics.heightPixels, this.V / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iR, 1073741824);
        setMeasuredDimension(iR, iR);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public ClockFaceView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.N = new Rect();
        this.O = new RectF();
        this.P = new SparseArray<>();
        this.S = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i7, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = com.google.android.material.resources.c.a(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.C0 = colorStateListA;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.M = clockHandView;
        this.T = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.R = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = e.a.a(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = com.google.android.material.resources.c.a(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.Q = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        c(strArr, 0);
        this.U = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.V = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.W = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
