package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14604a = "TransformationUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14605b = 6;

    private s() {
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i7, int i8) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i7 && bitmap2.getHeight() == i8) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap2.getWidth() * i8 > bitmap2.getHeight() * i7) {
            width = i8 / bitmap2.getHeight();
            width2 = (i7 - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i7 / bitmap2.getWidth();
            height = (i8 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i7, i8, e(bitmap2));
        }
        j(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap b(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7, int i8) {
        if (bitmap.getWidth() == i7 && bitmap.getHeight() == i8) {
            if (Log.isLoggable(f14604a, 2)) {
                Log.v(f14604a, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i7 / bitmap.getWidth(), i8 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * fMin);
        int height = (int) (bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable(f14604a, 2)) {
                Log.v(f14604a, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config configE = e(bitmap);
        Bitmap bitmapD = cVar.d(width, height, configE);
        if (bitmapD == null) {
            bitmapD = Bitmap.createBitmap(width, height, configE);
        }
        j(bitmap, bitmapD);
        if (Log.isLoggable(f14604a, 2)) {
            Log.v(f14604a, "request: " + i7 + "x" + i8);
            Log.v(f14604a, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(f14604a, "toReuse: " + bitmapD.getWidth() + "x" + bitmapD.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v(f14604a, sb.toString());
        }
        Canvas canvas = new Canvas(bitmapD);
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapD;
    }

    public static int c(int i7) {
        switch (i7) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @TargetApi(5)
    @Deprecated
    public static int d(String str) {
        try {
            return c(new ExifInterface(str).getAttributeInt("Orientation", 0));
        } catch (Exception e8) {
            if (Log.isLoggable(f14604a, 6)) {
                Log.e(f14604a, "Unable to get orientation for image with path=" + str, e8);
            }
            return 0;
        }
    }

    private static Bitmap.Config e(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    static void f(int i7, Matrix matrix) {
        switch (i7) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    @Deprecated
    public static Bitmap g(String str, Bitmap bitmap) {
        return h(bitmap, d(str));
    }

    public static Bitmap h(Bitmap bitmap, int i7) {
        if (i7 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i7);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e8) {
            if (!Log.isLoggable(f14604a, 6)) {
                return bitmap;
            }
            Log.e(f14604a, "Exception when trying to orient image", e8);
            return bitmap;
        }
    }

    public static Bitmap i(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i7) {
        Matrix matrix = new Matrix();
        f(i7, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        Bitmap.Config configE = e(bitmap);
        Bitmap bitmapD = cVar.d(iRound, iRound2, configE);
        if (bitmapD == null) {
            bitmapD = Bitmap.createBitmap(iRound, iRound2, configE);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(bitmapD).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapD;
    }

    @TargetApi(12)
    public static void j(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
