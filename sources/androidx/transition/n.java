package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10750a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f10751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10752c;

    private n() {
    }

    static void a(@c.m0 ImageView imageView, @c.o0 Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix != null) {
            c(imageView, matrix);
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
            imageView.invalidate();
        }
    }

    private static void b() {
        if (f10752c) {
            return;
        }
        try {
            Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
            f10751b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        f10752c = true;
    }

    @c.t0(21)
    @SuppressLint({"NewApi"})
    private static void c(@c.m0 ImageView imageView, @c.o0 Matrix matrix) {
        if (f10750a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f10750a = false;
            }
        }
    }
}
