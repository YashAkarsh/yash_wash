package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.util.w;
import androidx.core.view.n2;
import c.b1;
import c.m0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Rect f17449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f17450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f17451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f17452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f17453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.shape.o f17454f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i7, com.google.android.material.shape.o oVar, @m0 Rect rect) {
        w.i(rect.left);
        w.i(rect.top);
        w.i(rect.right);
        w.i(rect.bottom);
        this.f17449a = rect;
        this.f17450b = colorStateList2;
        this.f17451c = colorStateList;
        this.f17452d = colorStateList3;
        this.f17453e = i7;
        this.f17454f = oVar;
    }

    @m0
    static a a(@m0 Context context, @b1 int i7) {
        w.b(i7 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i7, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = com.google.android.material.resources.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = com.google.android.material.resources.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = com.google.android.material.resources.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.shape.o oVarM = com.google.android.material.shape.o.b(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, oVarM, rect);
    }

    int b() {
        return this.f17449a.bottom;
    }

    int c() {
        return this.f17449a.left;
    }

    int d() {
        return this.f17449a.right;
    }

    int e() {
        return this.f17449a.top;
    }

    void f(@m0 TextView textView) {
        com.google.android.material.shape.j jVar = new com.google.android.material.shape.j();
        com.google.android.material.shape.j jVar2 = new com.google.android.material.shape.j();
        jVar.setShapeAppearanceModel(this.f17454f);
        jVar2.setShapeAppearanceModel(this.f17454f);
        jVar.n0(this.f17451c);
        jVar.D0(this.f17453e, this.f17452d);
        textView.setTextColor(this.f17450b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f17450b.withAlpha(30), jVar, jVar2);
        Rect rect = this.f17449a;
        n2.I1(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
