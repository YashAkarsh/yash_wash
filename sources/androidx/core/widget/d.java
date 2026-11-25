package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import c.m0;
import c.o0;
import c.t0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7028a = "CompoundButtonCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f7029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7030c;

    @t0(21)
    static class a {
        private a() {
        }

        @c.t
        static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        @c.t
        static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        @c.t
        static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @c.t
        static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    @t0(23)
    static class b {
        private b() {
        }

        @c.t
        static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    private d() {
    }

    @o0
    public static Drawable a(@m0 CompoundButton compoundButton) {
        return b.a(compoundButton);
    }

    @o0
    public static ColorStateList b(@m0 CompoundButton compoundButton) {
        return a.a(compoundButton);
    }

    @o0
    public static PorterDuff.Mode c(@m0 CompoundButton compoundButton) {
        return a.b(compoundButton);
    }

    public static void d(@m0 CompoundButton compoundButton, @o0 ColorStateList colorStateList) {
        a.c(compoundButton, colorStateList);
    }

    public static void e(@m0 CompoundButton compoundButton, @o0 PorterDuff.Mode mode) {
        a.d(compoundButton, mode);
    }
}
