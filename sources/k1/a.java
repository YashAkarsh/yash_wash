package k1;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.v1;
import c.e0;
import c.f;
import c.l;
import c.m0;
import c.v;
import com.google.android.material.resources.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f34408a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f34409b = 0.54f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f34410c = 0.38f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f34411d = 0.32f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f34412e = 0.12f;

    private a() {
    }

    @l
    public static int a(@l int i7, @e0(from = 0, to = 255) int i8) {
        return v1.B(i7, (Color.alpha(i7) * i8) / 255);
    }

    @l
    public static int b(@m0 Context context, @f int i7, @l int i8) {
        TypedValue typedValueA = b.a(context, i7);
        return typedValueA != null ? typedValueA.data : i8;
    }

    @l
    public static int c(Context context, @f int i7, String str) {
        return b.g(context, i7, str);
    }

    @l
    public static int d(@m0 View view, @f int i7) {
        return b.h(view, i7);
    }

    @l
    public static int e(@m0 View view, @f int i7, @l int i8) {
        return b(view.getContext(), i7, i8);
    }

    public static boolean f(@l int i7) {
        return i7 != 0 && v1.m(i7) > 0.5d;
    }

    @l
    public static int g(@l int i7, @l int i8) {
        return v1.t(i8, i7);
    }

    @l
    public static int h(@l int i7, @l int i8, @v(from = 0.0d, to = 1.0d) float f8) {
        return g(i7, v1.B(i8, Math.round(Color.alpha(i8) * f8)));
    }

    @l
    public static int i(@m0 View view, @f int i7, @f int i8) {
        return j(view, i7, i8, 1.0f);
    }

    @l
    public static int j(@m0 View view, @f int i7, @f int i8, @v(from = 0.0d, to = 1.0d) float f8) {
        return h(d(view, i7), d(view, i8), f8);
    }
}
