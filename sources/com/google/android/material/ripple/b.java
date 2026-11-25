package com.google.android.material.ripple;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.v1;
import c.g1;
import c.l;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f18164a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f18165b = {R.attr.state_pressed};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f18166c = {R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f18167d = {R.attr.state_focused};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f18168e = {R.attr.state_hovered};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f18169f = {R.attr.state_selected, R.attr.state_pressed};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f18170g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f18171h = {R.attr.state_selected, R.attr.state_focused};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f18172i = {R.attr.state_selected, R.attr.state_hovered};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f18173j = {R.attr.state_selected};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f18174k = {R.attr.state_enabled, R.attr.state_pressed};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g1
    static final String f18175l = b.class.getSimpleName();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g1
    static final String f18176m = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";

    private b() {
    }

    @m0
    public static ColorStateList a(@o0 ColorStateList colorStateList) {
        if (f18164a) {
            return new ColorStateList(new int[][]{f18173j, StateSet.NOTHING}, new int[]{c(colorStateList, f18169f), c(colorStateList, f18165b)});
        }
        int[] iArr = f18169f;
        int[] iArr2 = f18170g;
        int[] iArr3 = f18171h;
        int[] iArr4 = f18172i;
        int[] iArr5 = f18165b;
        int[] iArr6 = f18166c;
        int[] iArr7 = f18167d;
        int[] iArr8 = f18168e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f18173j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    @l
    private static int b(@l int i7) {
        return v1.B(i7, Math.min(Color.alpha(i7) * 2, 255));
    }

    @l
    private static int c(@o0 ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f18164a ? b(colorForState) : colorForState;
    }

    @m0
    public static ColorStateList d(@o0 ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f18174k, 0)) != 0) {
            Log.w(f18175l, f18176m);
        }
        return colorStateList;
    }

    public static boolean e(@m0 int[] iArr) {
        boolean z7 = false;
        boolean z8 = false;
        for (int i7 : iArr) {
            if (i7 == 16842910) {
                z7 = true;
            } else if (i7 == 16842908 || i7 == 16842919 || i7 == 16843623) {
                z8 = true;
            }
        }
        return z7 && z8;
    }
}
