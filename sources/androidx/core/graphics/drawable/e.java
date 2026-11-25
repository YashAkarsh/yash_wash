package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.r0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    @a7.d
    public static final Bitmap a(@a7.d Drawable drawable, @r0 int i7, @r0 int i8, @a7.e Bitmap.Config config) {
        l0.p(drawable, "<this>");
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                if (i7 == bitmapDrawable.getBitmap().getWidth() && i8 == bitmapDrawable.getBitmap().getHeight()) {
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    l0.o(bitmap, "bitmap");
                    return bitmap;
                }
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i7, i8, true);
                l0.o(bitmapCreateScaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
                return bitmapCreateScaledBitmap;
            }
        }
        Rect bounds = drawable.getBounds();
        l0.o(bounds, "bounds");
        int i9 = bounds.left;
        int i10 = bounds.top;
        int i11 = bounds.right;
        int i12 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = Bitmap.createBitmap(i7, i8, config);
        drawable.setBounds(0, 0, i7, i8);
        drawable.draw(new Canvas(bitmap2));
        drawable.setBounds(i9, i10, i11, i12);
        l0.o(bitmap2, "bitmap");
        return bitmap2;
    }

    public static /* synthetic */ Bitmap b(Drawable drawable, int i7, int i8, Bitmap.Config config, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = drawable.getIntrinsicWidth();
        }
        if ((i9 & 2) != 0) {
            i8 = drawable.getIntrinsicHeight();
        }
        if ((i9 & 4) != 0) {
            config = null;
        }
        return a(drawable, i7, i8, config);
    }

    @a7.e
    public static final Bitmap c(@a7.d Drawable drawable, @r0 int i7, @r0 int i8, @a7.e Bitmap.Config config) {
        l0.p(drawable, "<this>");
        if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null) {
            return null;
        }
        return a(drawable, i7, i8, config);
    }

    public static /* synthetic */ Bitmap d(Drawable drawable, int i7, int i8, Bitmap.Config config, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = drawable.getIntrinsicWidth();
        }
        if ((i9 & 2) != 0) {
            i8 = drawable.getIntrinsicHeight();
        }
        if ((i9 & 4) != 0) {
            config = null;
        }
        return c(drawable, i7, i8, config);
    }

    public static final void e(@a7.d Drawable drawable, @r0 int i7, @r0 int i8, @r0 int i9, @r0 int i10) {
        l0.p(drawable, "<this>");
        drawable.setBounds(i7, i8, i9, i10);
    }

    public static /* synthetic */ void f(Drawable drawable, int i7, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i7 = drawable.getBounds().left;
        }
        if ((i11 & 2) != 0) {
            i8 = drawable.getBounds().top;
        }
        if ((i11 & 4) != 0) {
            i9 = drawable.getBounds().right;
        }
        if ((i11 & 8) != 0) {
            i10 = drawable.getBounds().bottom;
        }
        e(drawable, i7, i8, i9, i10);
    }
}
