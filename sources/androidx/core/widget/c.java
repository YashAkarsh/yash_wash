package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import c.m0;
import c.o0;
import c.t0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7025a = "CheckedTextViewCompat";

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f7026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static boolean f7027b;

        private a() {
        }

        @o0
        static Drawable a(@m0 CheckedTextView checkedTextView) {
            if (!f7027b) {
                try {
                    Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    f7026a = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e8) {
                    Log.i(c.f7025a, "Failed to retrieve mCheckMarkDrawable field", e8);
                }
                f7027b = true;
            }
            Field field = f7026a;
            if (field != null) {
                try {
                    return (Drawable) field.get(checkedTextView);
                } catch (IllegalAccessException e9) {
                    Log.i(c.f7025a, "Failed to get check mark drawable via reflection", e9);
                    f7026a = null;
                }
            }
            return null;
        }
    }

    @t0(16)
    private static class b {
        private b() {
        }

        @o0
        static Drawable a(@m0 CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.c$c, reason: collision with other inner class name */
    @t0(21)
    private static class C0083c {
        private C0083c() {
        }

        @o0
        static ColorStateList a(@m0 CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintList();
        }

        @o0
        static PorterDuff.Mode b(@m0 CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintMode();
        }

        static void c(@m0 CheckedTextView checkedTextView, @o0 ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void d(@m0 CheckedTextView checkedTextView, @o0 PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    private c() {
    }

    @o0
    public static Drawable a(@m0 CheckedTextView checkedTextView) {
        return b.a(checkedTextView);
    }

    @o0
    public static ColorStateList b(@m0 CheckedTextView checkedTextView) {
        return C0083c.a(checkedTextView);
    }

    @o0
    public static PorterDuff.Mode c(@m0 CheckedTextView checkedTextView) {
        return C0083c.b(checkedTextView);
    }

    public static void d(@m0 CheckedTextView checkedTextView, @o0 ColorStateList colorStateList) {
        C0083c.c(checkedTextView, colorStateList);
    }

    public static void e(@m0 CheckedTextView checkedTextView, @o0 PorterDuff.Mode mode) {
        C0083c.d(checkedTextView, mode);
    }
}
