package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import c.m0;
import c.o0;
import c.p;
import c.r0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class b {
    @o0
    public static TypedValue a(@m0 Context context, @c.f int i7) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i7, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(@m0 Context context, @c.f int i7, boolean z7) {
        TypedValue typedValueA = a(context, i7);
        if (typedValueA == null || typedValueA.type != 18) {
            return z7;
        }
        return typedValueA.data != 0;
    }

    public static boolean c(@m0 Context context, @c.f int i7, @m0 String str) {
        return g(context, i7, str) != 0;
    }

    @r0
    public static int d(@m0 Context context, @c.f int i7, @p int i8) {
        TypedValue typedValueA = a(context, i7);
        return (int) ((typedValueA == null || typedValueA.type != 5) ? context.getResources().getDimension(i8) : typedValueA.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static int e(@m0 Context context, @c.f int i7, int i8) {
        TypedValue typedValueA = a(context, i7);
        return (typedValueA == null || typedValueA.type != 16) ? i8 : typedValueA.data;
    }

    @r0
    public static int f(@m0 Context context) {
        return d(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int g(@m0 Context context, @c.f int i7, @m0 String str) {
        TypedValue typedValueA = a(context, i7);
        if (typedValueA != null) {
            return typedValueA.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i7)));
    }

    public static int h(@m0 View view, @c.f int i7) {
        return g(view.getContext(), i7, view.getClass().getCanonicalName());
    }
}
