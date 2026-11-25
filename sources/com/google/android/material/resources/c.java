package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.h1;
import c.c1;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18132a = 1.3f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18133b = 2.0f;

    private c() {
    }

    @o0
    public static ColorStateList a(@m0 Context context, @m0 TypedArray typedArray, @c1 int i7) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (colorStateListA = e.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i7) : colorStateListA;
    }

    @o0
    public static ColorStateList b(@m0 Context context, @m0 h1 h1Var, @c1 int i7) {
        int iU;
        ColorStateList colorStateListA;
        return (!h1Var.C(i7) || (iU = h1Var.u(i7, 0)) == 0 || (colorStateListA = e.a.a(context, iU)) == null) ? h1Var.d(i7) : colorStateListA;
    }

    public static int c(@m0 Context context, @m0 TypedArray typedArray, @c1 int i7, int i8) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i7, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i7, i8);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i8);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @o0
    public static Drawable d(@m0 Context context, @m0 TypedArray typedArray, @c1 int i7) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0 || (drawableB = e.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i7) : drawableB;
    }

    @c1
    static int e(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8) {
        return typedArray.hasValue(i7) ? i7 : i8;
    }

    @o0
    public static d f(@m0 Context context, @m0 TypedArray typedArray, @c1 int i7) {
        int resourceId;
        if (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean g(@m0 Context context) {
        return context.getResources().getConfiguration().fontScale >= f18132a;
    }

    public static boolean h(@m0 Context context) {
        return context.getResources().getConfiguration().fontScale >= f18133b;
    }
}
