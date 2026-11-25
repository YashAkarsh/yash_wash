package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.internal.v;
import n1.a;

/* JADX INFO: loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int J0 = R.style.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] K0 = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    @m0
    private final a F0;

    @o0
    private ColorStateList G0;

    @o0
    private ColorStateList H0;
    private boolean I0;

    public SwitchMaterial(@m0 Context context) {
        this(context, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.G0 == null) {
            int iD = k1.a.d(this, R.attr.colorSurface);
            int iD2 = k1.a.d(this, R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.F0.l()) {
                dimension += v.i(this);
            }
            int iE = this.F0.e(iD, dimension);
            int[][] iArr = K0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = k1.a.h(iD, iD2, 1.0f);
            iArr2[1] = iE;
            iArr2[2] = k1.a.h(iD, iD2, 0.38f);
            iArr2[3] = iE;
            this.G0 = new ColorStateList(iArr, iArr2);
        }
        return this.G0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.H0 == null) {
            int[][] iArr = K0;
            int[] iArr2 = new int[iArr.length];
            int iD = k1.a.d(this, R.attr.colorSurface);
            int iD2 = k1.a.d(this, R.attr.colorControlActivated);
            int iD3 = k1.a.d(this, R.attr.colorOnSurface);
            iArr2[0] = k1.a.h(iD, iD2, 0.54f);
            iArr2[1] = k1.a.h(iD, iD3, 0.32f);
            iArr2[2] = k1.a.h(iD, iD2, 0.12f);
            iArr2[3] = k1.a.h(iD, iD3, 0.12f);
            this.H0 = new ColorStateList(iArr, iArr2);
        }
        return this.H0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.I0 && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.I0 && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public boolean q() {
        return this.I0;
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.I0 = z7;
        if (z7) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchMaterial(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = J0;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        Context context2 = getContext();
        this.F0 = new a(context2);
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.SwitchMaterial, i7, i8, new int[0]);
        this.I0 = typedArrayJ.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayJ.recycle();
    }
}
