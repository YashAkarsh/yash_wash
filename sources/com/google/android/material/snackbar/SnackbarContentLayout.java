package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f18488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f18489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18491d;

    public SnackbarContentLayout(@m0 Context context) {
        this(context, null);
    }

    private static void d(@m0 View view, int i7, int i8) {
        if (n2.Y0(view)) {
            n2.d2(view, n2.k0(view), i7, n2.j0(view), i8);
        } else {
            view.setPadding(view.getPaddingLeft(), i7, view.getPaddingRight(), i8);
        }
    }

    private boolean e(int i7, int i8, int i9) {
        boolean z7;
        if (i7 != getOrientation()) {
            setOrientation(i7);
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f18488a.getPaddingTop() == i8 && this.f18488a.getPaddingBottom() == i9) {
            return z7;
        }
        d(this.f18488a, i8, i9);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i7, int i8) {
        this.f18488a.setAlpha(0.0f);
        long j7 = i8;
        long j8 = i7;
        this.f18488a.animate().alpha(1.0f).setDuration(j7).setStartDelay(j8).start();
        if (this.f18489b.getVisibility() == 0) {
            this.f18489b.setAlpha(0.0f);
            this.f18489b.animate().alpha(1.0f).setDuration(j7).setStartDelay(j8).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i7, int i8) {
        this.f18488a.setAlpha(1.0f);
        long j7 = i8;
        long j8 = i7;
        this.f18488a.animate().alpha(0.0f).setDuration(j7).setStartDelay(j8).start();
        if (this.f18489b.getVisibility() == 0) {
            this.f18489b.setAlpha(1.0f);
            this.f18489b.animate().alpha(0.0f).setDuration(j7).setStartDelay(j8).start();
        }
    }

    void c(float f8) {
        if (f8 != 1.0f) {
            this.f18489b.setTextColor(k1.a.h(k1.a.d(this, R.attr.colorSurface), this.f18489b.getCurrentTextColor(), f8));
        }
    }

    public Button getActionView() {
        return this.f18489b;
    }

    public TextView getMessageView() {
        return this.f18488a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f18488a = (TextView) findViewById(R.id.snackbar_text);
        this.f18489b = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (this.f18490c > 0) {
            int measuredWidth = getMeasuredWidth();
            int i9 = this.f18490c;
            if (measuredWidth > i9) {
                i7 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                super.onMeasure(i7, i8);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        boolean z7 = false;
        boolean z8 = this.f18488a.getLayout().getLineCount() > 1;
        if (!z8 || this.f18491d <= 0 || this.f18489b.getMeasuredWidth() <= this.f18491d) {
            if (!z8) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (e(0, dimensionPixelSize, dimensionPixelSize)) {
                z7 = true;
            }
        } else if (e(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            z7 = true;
        }
        if (z7) {
            super.onMeasure(i7, i8);
        }
    }

    public void setMaxInlineActionWidth(int i7) {
        this.f18491d = i7;
    }

    public SnackbarContentLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.f18490c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.f18491d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
    }
}
