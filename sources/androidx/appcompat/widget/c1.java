package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.v1;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY})
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1793a = "ThemeUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1794b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f1795c = {-16842910};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f1796d = {R.attr.state_focused};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f1797e = {R.attr.state_activated};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f1798f = {R.attr.state_pressed};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f1799g = {R.attr.state_checked};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[] f1800h = {R.attr.state_selected};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[] f1801i = {-16842919, -16842908};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int[] f1802j = new int[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f1803k = new int[1];

    private c1() {
    }

    public static void a(@c.m0 View view, @c.m0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e(f1793a, "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @c.m0
    public static ColorStateList b(int i7, int i8) {
        return new ColorStateList(new int[][]{f1795c, f1802j}, new int[]{i8, i7});
    }

    public static int c(@c.m0 Context context, int i7) {
        ColorStateList colorStateListF = f(context, i7);
        if (colorStateListF != null && colorStateListF.isStateful()) {
            return colorStateListF.getColorForState(f1795c, colorStateListF.getDefaultColor());
        }
        TypedValue typedValueG = g();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueG, true);
        return e(context, i7, typedValueG.getFloat());
    }

    public static int d(@c.m0 Context context, int i7) {
        int[] iArr = f1803k;
        iArr[0] = i7;
        h1 h1VarF = h1.F(context, null, iArr);
        try {
            return h1VarF.c(0, 0);
        } finally {
            h1VarF.I();
        }
    }

    static int e(@c.m0 Context context, int i7, float f8) {
        int iD = d(context, i7);
        return v1.B(iD, Math.round(Color.alpha(iD) * f8));
    }

    @c.o0
    public static ColorStateList f(@c.m0 Context context, int i7) {
        int[] iArr = f1803k;
        iArr[0] = i7;
        h1 h1VarF = h1.F(context, null, iArr);
        try {
            return h1VarF.d(0);
        } finally {
            h1VarF.I();
        }
    }

    private static TypedValue g() {
        ThreadLocal<TypedValue> threadLocal = f1794b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
