package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.core.graphics.a$a, reason: collision with other inner class name */
    @c.t0(17)
    static class C0062a {
        private C0062a() {
        }

        @c.t
        static boolean a(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        @c.t
        static void b(Bitmap bitmap, boolean z7) {
            bitmap.setHasMipMap(z7);
        }
    }

    @c.t0(19)
    static class b {
        private b() {
        }

        @c.t
        static int a(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    @c.t0(27)
    static class c {
        private c() {
        }

        @c.t
        static Bitmap a(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config configA = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                configA = e.a(bitmap);
            }
            return bitmap.copy(configA, true);
        }

        @c.t
        static Bitmap b(int i7, int i8, Bitmap bitmap, boolean z7) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z7 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = e.a(bitmap);
                }
            }
            return Bitmap.createBitmap(i7, i8, config, bitmap.hasAlpha(), colorSpace);
        }

        @c.t
        static boolean c(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }
    }

    @c.t0(29)
    static class d {
        private d() {
        }

        @c.t
        static void a(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    @c.t0(31)
    static class e {
        private e() {
        }

        @c.t
        static Bitmap.Config a(Bitmap bitmap) {
            return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
        }
    }

    private a() {
    }

    @c.m0
    public static Bitmap a(@c.m0 Bitmap bitmap, int i7, int i8, @c.o0 Rect rect, boolean z7) {
        Paint paint;
        Bitmap bitmap2;
        int i9;
        Rect rect2;
        Bitmap bitmapCreateBitmap;
        if (i7 <= 0 || i8 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
        int i10 = Build.VERSION.SDK_INT;
        Bitmap bitmapA = i10 >= 27 ? c.a(bitmap) : bitmap;
        int iWidth = rect != null ? rect.width() : bitmap.getWidth();
        int iHeight = rect != null ? rect.height() : bitmap.getHeight();
        float f8 = i7 / iWidth;
        float f9 = i8 / iHeight;
        int i11 = rect != null ? rect.left : 0;
        int i12 = rect != null ? rect.top : 0;
        if (i11 == 0 && i12 == 0 && i7 == bitmap.getWidth() && i8 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == bitmapA) ? bitmap.copy(bitmap.getConfig(), true) : bitmapA;
        }
        Paint paint2 = new Paint(1);
        paint2.setFilterBitmap(true);
        if (i10 >= 29) {
            d.a(paint2);
        } else {
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        if (iWidth == i7 && iHeight == i8) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i7, i8, bitmapA.getConfig());
            new Canvas(bitmapCreateBitmap2).drawBitmap(bitmapA, -i11, -i12, paint2);
            return bitmapCreateBitmap2;
        }
        double dLog = Math.log(2.0d);
        int iCeil = (int) (f8 > 1.0f ? Math.ceil(Math.log(f8) / dLog) : Math.floor(Math.log(f8) / dLog));
        int iCeil2 = (int) (f9 > 1.0f ? Math.ceil(Math.log(f9) / dLog) : Math.floor(Math.log(f9) / dLog));
        if (!z7 || i10 < 27 || c.c(bitmap)) {
            paint = paint2;
            bitmap2 = null;
            i9 = 0;
        } else {
            Bitmap bitmapB = c.b(iCeil > 0 ? e(iWidth, i7, 1, iCeil) : iWidth, iCeil2 > 0 ? e(iHeight, i8, 1, iCeil2) : iHeight, bitmap, true);
            paint = paint2;
            new Canvas(bitmapB).drawBitmap(bitmapA, -i11, -i12, paint);
            i9 = 1;
            i12 = 0;
            i11 = 0;
            bitmap2 = bitmapA;
            bitmapA = bitmapB;
        }
        Rect rect3 = new Rect(i11, i12, iWidth, iHeight);
        Rect rect4 = new Rect();
        int i13 = iCeil;
        int i14 = iCeil2;
        while (true) {
            if (i13 == 0 && i14 == 0) {
                break;
            }
            if (i13 < 0) {
                i13++;
            } else if (i13 > 0) {
                i13--;
            }
            if (i14 < 0) {
                i14++;
            } else if (i14 > 0) {
                i14--;
            }
            int i15 = i14;
            Paint paint3 = paint;
            Rect rect5 = rect3;
            rect4.set(0, 0, e(iWidth, i7, i13, iCeil), e(iHeight, i8, i15, iCeil2));
            boolean z8 = i13 == 0 && i15 == 0;
            boolean z9 = bitmap2 != null && bitmap2.getWidth() == i7 && bitmap2.getHeight() == i8;
            if (bitmap2 == null || bitmap2 == bitmap) {
                rect2 = rect4;
            } else {
                if (z7) {
                    rect2 = rect4;
                    if (Build.VERSION.SDK_INT < 27 || c.c(bitmap2)) {
                    }
                    Rect rect6 = rect2;
                    new Canvas(bitmapCreateBitmap).drawBitmap(bitmapA, rect5, rect6, paint3);
                    rect5.set(rect6);
                    i14 = i15;
                    Bitmap bitmap3 = bitmapA;
                    bitmapA = bitmapCreateBitmap;
                    rect4 = rect6;
                    rect3 = rect5;
                    paint = paint3;
                    bitmap2 = bitmap3;
                } else {
                    rect2 = rect4;
                }
                if (!z8 || (z9 && i9 == 0)) {
                    bitmapCreateBitmap = bitmap2;
                }
                Rect rect7 = rect2;
                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapA, rect5, rect7, paint3);
                rect5.set(rect7);
                i14 = i15;
                Bitmap bitmap4 = bitmapA;
                bitmapA = bitmapCreateBitmap;
                rect4 = rect7;
                rect3 = rect5;
                paint = paint3;
                bitmap2 = bitmap4;
            }
            if (bitmap2 != bitmap && bitmap2 != null) {
                bitmap2.recycle();
            }
            int iE = e(iWidth, i7, i13 > 0 ? i9 : i13, iCeil);
            int iE2 = e(iHeight, i8, i15 > 0 ? i9 : i15, iCeil2);
            if (Build.VERSION.SDK_INT >= 27) {
                bitmapCreateBitmap = c.b(iE, iE2, bitmap, z7 && !z8);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iE, iE2, bitmapA.getConfig());
            }
            Rect rect8 = rect2;
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapA, rect5, rect8, paint3);
            rect5.set(rect8);
            i14 = i15;
            Bitmap bitmap5 = bitmapA;
            bitmapA = bitmapCreateBitmap;
            rect4 = rect8;
            rect3 = rect5;
            paint = paint3;
            bitmap2 = bitmap5;
        }
        if (bitmap2 != bitmap && bitmap2 != null) {
            bitmap2.recycle();
        }
        return bitmapA;
    }

    public static int b(@c.m0 Bitmap bitmap) {
        return b.a(bitmap);
    }

    public static boolean c(@c.m0 Bitmap bitmap) {
        return C0062a.a(bitmap);
    }

    public static void d(@c.m0 Bitmap bitmap, boolean z7) {
        C0062a.b(bitmap, z7);
    }

    @c.g1
    public static int e(int i7, int i8, int i9, int i10) {
        if (i9 == 0) {
            return i8;
        }
        return i9 > 0 ? i7 * (1 << (i10 - i9)) : i8 << ((-i9) - 1);
    }
}
