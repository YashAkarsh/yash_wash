package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.n2;
import c.l;
import c.m0;
import c.o0;
import c.t0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.internal.o;
import com.google.android.material.shape.j;
import com.google.android.material.shape.k;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int V = R.style.Widget_MaterialComponents_Toolbar;

    @o0
    private Integer S;
    private boolean T;
    private boolean U;

    public MaterialToolbar(@m0 Context context) {
        this(context, null);
    }

    private Pair<Integer, Integer> M(@o0 TextView textView, @o0 TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i7 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i7 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i7 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void N(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            j jVar = new j();
            jVar.n0(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            jVar.Y(context);
            jVar.m0(n2.R(this));
            n2.I1(this, jVar);
        }
    }

    private void Q(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i7 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i8 = measuredWidth2 + i7;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i7, 0), Math.max(i8 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i7 += iMax;
            i8 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i8 - i7, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i7, view.getTop(), i8, view.getBottom());
    }

    private void R() {
        if (this.T || this.U) {
            TextView textViewG = o.g(this);
            TextView textViewE = o.e(this);
            if (textViewG == null && textViewE == null) {
                return;
            }
            Pair<Integer, Integer> pairM = M(textViewG, textViewE);
            if (this.T && textViewG != null) {
                Q(textViewG, pairM);
            }
            if (!this.U || textViewE == null) {
                return;
            }
            Q(textViewE, pairM);
        }
    }

    @o0
    private Drawable S(@o0 Drawable drawable) {
        if (drawable == null || this.S == null) {
            return drawable;
        }
        Drawable drawableR = androidx.core.graphics.drawable.d.r(drawable);
        androidx.core.graphics.drawable.d.n(drawableR, this.S.intValue());
        return drawableR;
    }

    public boolean O() {
        return this.U;
    }

    public boolean P() {
        return this.T;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        R();
    }

    @Override // android.view.View
    @t0(21)
    public void setElevation(float f8) {
        super.setElevation(f8);
        k.d(this, f8);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@o0 Drawable drawable) {
        super.setNavigationIcon(S(drawable));
    }

    public void setNavigationIconTint(@l int i7) {
        this.S = Integer.valueOf(i7);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z7) {
        if (this.U != z7) {
            this.U = z7;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z7) {
        if (this.T != z7) {
            this.T = z7;
            requestLayout();
        }
    }

    public MaterialToolbar(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = V;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        Context context2 = getContext();
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.MaterialToolbar, i7, i8, new int[0]);
        if (typedArrayJ.hasValue(R.styleable.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayJ.getColor(R.styleable.MaterialToolbar_navigationIconTint, -1));
        }
        this.T = typedArrayJ.getBoolean(R.styleable.MaterialToolbar_titleCentered, false);
        this.U = typedArrayJ.getBoolean(R.styleable.MaterialToolbar_subtitleCentered, false);
        typedArrayJ.recycle();
        N(context2);
    }
}
