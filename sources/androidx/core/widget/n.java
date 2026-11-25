package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public class n {

    @t0(21)
    static class a {
        private a() {
        }

        @c.t
        static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @c.t
        static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        @c.t
        static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        @c.t
        static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    private n() {
    }

    @o0
    public static ColorStateList a(@m0 ImageView imageView) {
        return a.a(imageView);
    }

    @o0
    public static PorterDuff.Mode b(@m0 ImageView imageView) {
        return a.b(imageView);
    }

    public static void c(@m0 ImageView imageView, @o0 ColorStateList colorStateList) {
        a.c(imageView, colorStateList);
    }

    public static void d(@m0 ImageView imageView, @o0 PorterDuff.Mode mode) {
        a.d(imageView, mode);
    }
}
