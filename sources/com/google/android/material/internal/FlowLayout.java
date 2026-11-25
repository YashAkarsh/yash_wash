package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;
import androidx.core.view.s0;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17745d;

    public FlowLayout(@m0 Context context) {
        this(context, null);
    }

    private static int a(int i7, int i8, int i9) {
        if (i8 != Integer.MIN_VALUE) {
            return i8 != 1073741824 ? i9 : i7;
        }
        return Math.min(i9, i7);
    }

    private void d(@m0 Context context, @o0 AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.f17742a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.f17743b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int b(@m0 View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f17744c;
    }

    protected int getItemSpacing() {
        return this.f17743b;
    }

    protected int getLineSpacing() {
        return this.f17742a;
    }

    protected int getRowCount() {
        return this.f17745d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int iB;
        int iC;
        if (getChildCount() == 0) {
            this.f17745d = 0;
            return;
        }
        this.f17745d = 1;
        boolean z8 = n2.Z(this) == 1;
        int paddingRight = z8 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z8 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i11 = (i9 - i7) - paddingLeft;
        int measuredWidth = paddingRight;
        int i12 = paddingTop;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iC = s0.c(marginLayoutParams);
                    iB = s0.b(marginLayoutParams);
                } else {
                    iB = 0;
                    iC = 0;
                }
                int measuredWidth2 = measuredWidth + iC + childAt.getMeasuredWidth();
                if (!this.f17744c && measuredWidth2 > i11) {
                    i12 = this.f17742a + paddingTop;
                    this.f17745d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f17745d - 1));
                int i14 = measuredWidth + iC;
                int measuredWidth3 = childAt.getMeasuredWidth() + i14;
                int measuredHeight = childAt.getMeasuredHeight() + i12;
                if (z8) {
                    childAt.layout(i11 - measuredWidth3, i12, (i11 - measuredWidth) - iC, measuredHeight);
                } else {
                    childAt.layout(i14, i12, measuredWidth3, measuredHeight);
                }
                measuredWidth += iC + iB + childAt.getMeasuredWidth() + this.f17743b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i7, int i8) {
        int i9;
        int i10;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i7);
        int mode = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i8);
        int i11 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i11 - getPaddingRight();
        int i12 = paddingTop;
        int i13 = 0;
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i7, i8);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i9 = marginLayoutParams.leftMargin + 0;
                    i10 = marginLayoutParams.rightMargin + 0;
                } else {
                    i9 = 0;
                    i10 = 0;
                }
                int i15 = paddingLeft2;
                if (paddingLeft2 + i9 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i15;
                } else {
                    paddingLeft = getPaddingLeft();
                    i12 = this.f17742a + paddingTop;
                }
                int measuredWidth = paddingLeft + i9 + childAt.getMeasuredWidth();
                int measuredHeight = i12 + childAt.getMeasuredHeight();
                if (measuredWidth > i13) {
                    i13 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i9 + i10 + childAt.getMeasuredWidth() + this.f17743b;
                if (i14 == getChildCount() - 1) {
                    i13 += i10;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i13 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i7) {
        this.f17743b = i7;
    }

    protected void setLineSpacing(int i7) {
        this.f17742a = i7;
    }

    public void setSingleLine(boolean z7) {
        this.f17744c = z7;
    }

    public FlowLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f17744c = false;
        d(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f17744c = false;
        d(context, attributeSet);
    }
}
