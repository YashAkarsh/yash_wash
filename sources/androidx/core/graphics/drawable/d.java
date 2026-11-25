package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import c.m0;
import c.o0;
import c.t0;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5810a = "DrawableCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f5811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f5812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f5813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f5814e;

    @t0(19)
    static class a {
        private a() {
        }

        @c.t
        static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        @c.t
        static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i7) {
            return drawableContainerState.getChild(i7);
        }

        @c.t
        static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        @c.t
        static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        @c.t
        static void e(Drawable drawable, boolean z7) {
            drawable.setAutoMirrored(z7);
        }
    }

    @t0(21)
    static class b {
        private b() {
        }

        @c.t
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @c.t
        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        @c.t
        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        @c.t
        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @c.t
        static void e(Drawable drawable, float f8, float f9) {
            drawable.setHotspot(f8, f9);
        }

        @c.t
        static void f(Drawable drawable, int i7, int i8, int i9, int i10) {
            drawable.setHotspotBounds(i7, i8, i9, i10);
        }

        @c.t
        static void g(Drawable drawable, int i7) {
            drawable.setTint(i7);
        }

        @c.t
        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @c.t
        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    @t0(23)
    static class c {
        private c() {
        }

        @c.t
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @c.t
        static boolean b(Drawable drawable, int i7) {
            return drawable.setLayoutDirection(i7);
        }
    }

    private d() {
    }

    public static void a(@m0 Drawable drawable, @m0 Resources.Theme theme) {
        b.a(drawable, theme);
    }

    public static boolean b(@m0 Drawable drawable) {
        return b.b(drawable);
    }

    public static void c(@m0 Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int d(@m0 Drawable drawable) {
        return a.a(drawable);
    }

    @o0
    public static ColorFilter e(@m0 Drawable drawable) {
        return b.c(drawable);
    }

    public static int f(@m0 Drawable drawable) {
        return c.a(drawable);
    }

    public static void g(@m0 Drawable drawable, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        b.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(@m0 Drawable drawable) {
        return a.d(drawable);
    }

    @Deprecated
    public static void i(@m0 Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(@m0 Drawable drawable, boolean z7) {
        a.e(drawable, z7);
    }

    public static void k(@m0 Drawable drawable, float f8, float f9) {
        b.e(drawable, f8, f9);
    }

    public static void l(@m0 Drawable drawable, int i7, int i8, int i9, int i10) {
        b.f(drawable, i7, i8, i9, i10);
    }

    public static boolean m(@m0 Drawable drawable, int i7) {
        return c.b(drawable, i7);
    }

    public static void n(@m0 Drawable drawable, @c.l int i7) {
        b.g(drawable, i7);
    }

    public static void o(@m0 Drawable drawable, @o0 ColorStateList colorStateList) {
        b.h(drawable, colorStateList);
    }

    public static void p(@m0 Drawable drawable, @m0 PorterDuff.Mode mode) {
        b.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(@m0 Drawable drawable) {
        return drawable instanceof s ? (T) ((s) drawable).b() : drawable;
    }

    @m0
    public static Drawable r(@m0 Drawable drawable) {
        return drawable;
    }
}
