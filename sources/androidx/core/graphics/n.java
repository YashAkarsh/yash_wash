package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    @a7.d
    public static final Bitmap a(@a7.d Bitmap bitmap, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(bitmap, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        block.z(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean b(@a7.d Bitmap bitmap, @a7.d Point p7) {
        int i7;
        kotlin.jvm.internal.l0.p(bitmap, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        int width = bitmap.getWidth();
        int i8 = p7.x;
        return (i8 >= 0 && i8 < width) && (i7 = p7.y) >= 0 && i7 < bitmap.getHeight();
    }

    public static final boolean c(@a7.d Bitmap bitmap, @a7.d PointF p7) {
        kotlin.jvm.internal.l0.p(bitmap, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        float f8 = p7.x;
        if (f8 >= 0.0f && f8 < bitmap.getWidth()) {
            float f9 = p7.y;
            if (f9 >= 0.0f && f9 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final Bitmap d(int i7, int i8, @a7.d Bitmap.Config config) {
        kotlin.jvm.internal.l0.p(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, config);
        kotlin.jvm.internal.l0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    @a7.d
    @c.t0(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap e(int i7, int i8, @a7.d Bitmap.Config config, boolean z7, @a7.d ColorSpace colorSpace) {
        kotlin.jvm.internal.l0.p(config, "config");
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, config, z7, colorSpace);
        kotlin.jvm.internal.l0.o(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap f(int i7, int i8, Bitmap.Config config, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        kotlin.jvm.internal.l0.p(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, config);
        kotlin.jvm.internal.l0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap g(int i7, int i8, Bitmap.Config config, boolean z7, ColorSpace colorSpace, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i9 & 8) != 0) {
            z7 = true;
        }
        if ((i9 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            kotlin.jvm.internal.l0.o(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        kotlin.jvm.internal.l0.p(config, "config");
        kotlin.jvm.internal.l0.p(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, config, z7, colorSpace);
        kotlin.jvm.internal.l0.o(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static final int h(@a7.d Bitmap bitmap, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bitmap, "<this>");
        return bitmap.getPixel(i7, i8);
    }

    @a7.d
    public static final Bitmap i(@a7.d Bitmap bitmap, int i7, int i8, boolean z7) {
        kotlin.jvm.internal.l0.p(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i7, i8, z7);
        kotlin.jvm.internal.l0.o(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap j(Bitmap bitmap, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            z7 = true;
        }
        kotlin.jvm.internal.l0.p(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i7, i8, z7);
        kotlin.jvm.internal.l0.o(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void k(@a7.d Bitmap bitmap, int i7, int i8, @c.l int i9) {
        kotlin.jvm.internal.l0.p(bitmap, "<this>");
        bitmap.setPixel(i7, i8, i9);
    }
}
