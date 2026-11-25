package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.d;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.resources.c;
import k1.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f18125g = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[][] f18126h = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private ColorStateList f18127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18128f;

    public MaterialRadioButton(@m0 Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f18127e == null) {
            int iD = a.d(this, R.attr.colorControlActivated);
            int iD2 = a.d(this, R.attr.colorOnSurface);
            int iD3 = a.d(this, R.attr.colorSurface);
            int[][] iArr = f18126h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = a.h(iD3, iD, 1.0f);
            iArr2[1] = a.h(iD3, iD2, 0.54f);
            iArr2[2] = a.h(iD3, iD2, 0.38f);
            iArr2[3] = a.h(iD3, iD2, 0.38f);
            this.f18127e = new ColorStateList(iArr, iArr2);
        }
        return this.f18127e;
    }

    public boolean a() {
        return this.f18128f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f18128f && d.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f18128f = z7;
        if (z7) {
            d.d(this, getMaterialThemeColorsTintList());
        } else {
            d.d(this, null);
        }
    }

    public MaterialRadioButton(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialRadioButton(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = f18125g;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        Context context2 = getContext();
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.MaterialRadioButton, i7, i8, new int[0]);
        if (typedArrayJ.hasValue(R.styleable.MaterialRadioButton_buttonTint)) {
            d.d(this, c.a(context2, typedArrayJ, R.styleable.MaterialRadioButton_buttonTint));
        }
        this.f18128f = typedArrayJ.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayJ.recycle();
    }
}
