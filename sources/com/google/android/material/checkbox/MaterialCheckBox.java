package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.d;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.resources.c;
import k1.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f17311g = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[][] f17312h = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private ColorStateList f17313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17314f;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f17313e == null) {
            int[][] iArr = f17312h;
            int[] iArr2 = new int[iArr.length];
            int iD = a.d(this, R.attr.colorControlActivated);
            int iD2 = a.d(this, R.attr.colorSurface);
            int iD3 = a.d(this, R.attr.colorOnSurface);
            iArr2[0] = a.h(iD2, iD, 1.0f);
            iArr2[1] = a.h(iD2, iD3, 0.54f);
            iArr2[2] = a.h(iD2, iD3, 0.38f);
            iArr2[3] = a.h(iD2, iD3, 0.38f);
            this.f17313e = new ColorStateList(iArr, iArr2);
        }
        return this.f17313e;
    }

    public boolean c() {
        return this.f17314f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f17314f && d.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f17314f = z7;
        if (z7) {
            d.d(this, getMaterialThemeColorsTintList());
        } else {
            d.d(this, null);
        }
    }

    public MaterialCheckBox(Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = f17311g;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        Context context2 = getContext();
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.MaterialCheckBox, i7, i8, new int[0]);
        if (typedArrayJ.hasValue(R.styleable.MaterialCheckBox_buttonTint)) {
            d.d(this, c.a(context2, typedArrayJ, R.styleable.MaterialCheckBox_buttonTint));
        }
        this.f17314f = typedArrayJ.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        typedArrayJ.recycle();
    }
}
