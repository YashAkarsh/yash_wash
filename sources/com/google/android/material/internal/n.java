package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.h1;
import c.b1;
import c.c1;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17885b = "Theme.AppCompat";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f17887d = "Theme.MaterialComponents";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f17884a = {R.attr.colorPrimary};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f17886c = {R.attr.colorPrimaryVariant};

    private n() {
    }

    public static void a(@m0 Context context) {
        e(context, f17884a, f17885b);
    }

    private static void b(@m0 Context context, AttributeSet attributeSet, @c.f int i7, @b1 int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i7, i8);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z7) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(@m0 Context context) {
        e(context, f17886c, f17887d);
    }

    private static void d(@m0 Context context, AttributeSet attributeSet, @m0 @c1 int[] iArr, @c.f int i7, @b1 int i8, @o0 @c1 int... iArr2) {
        boolean zG;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i7, i8);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zG = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zG = g(context, attributeSet, iArr, i7, i8, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zG) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(@m0 Context context, @m0 int[] iArr, String str) {
        if (i(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static boolean f(@m0 Context context) {
        return i(context, f17884a);
    }

    private static boolean g(@m0 Context context, AttributeSet attributeSet, @m0 @c1 int[] iArr, @c.f int i7, @b1 int i8, @m0 @c1 int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i7, i8);
        for (int i9 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i9, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static boolean h(@m0 Context context) {
        return i(context, f17886c);
    }

    private static boolean i(@m0 Context context, @m0 int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i7 = 0; i7 < iArr.length; i7++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i7)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    @m0
    public static TypedArray j(@m0 Context context, AttributeSet attributeSet, @m0 @c1 int[] iArr, @c.f int i7, @b1 int i8, @c1 int... iArr2) {
        b(context, attributeSet, i7, i8);
        d(context, attributeSet, iArr, i7, i8, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i7, i8);
    }

    public static h1 k(@m0 Context context, AttributeSet attributeSet, @m0 @c1 int[] iArr, @c.f int i7, @b1 int i8, @c1 int... iArr2) {
        b(context, attributeSet, i7, i8);
        d(context, attributeSet, iArr, i7, i8, iArr2);
        return h1.G(context, attributeSet, iArr, i7, i8);
    }
}
