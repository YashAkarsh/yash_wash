package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import c.o0;
import com.airbnb.lottie.animation.content.t;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12339a = 1000000000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PathMeasure f12340b = new PathMeasure();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Path f12341c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Path f12342d = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float[] f12343e = new float[4];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f12344f = (float) (Math.sqrt(2.0d) / 2.0d);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static float f12345g = -1.0f;

    private j() {
    }

    public static void a(Path path, float f8, float f9, float f10) {
        com.airbnb.lottie.e.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f12340b;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f8 == 1.0f && f9 == 0.0f) {
            com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f9 - f8) - 1.0f) < 0.01d) {
            com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
            return;
        }
        float f11 = f8 * length;
        float f12 = f9 * length;
        float f13 = f10 * length;
        float fMin = Math.min(f11, f12) + f13;
        float fMax = Math.max(f11, f12) + f13;
        if (fMin >= length && fMax >= length) {
            fMin = i.f(fMin, length);
            fMax = i.f(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = i.f(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = i.f(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        Path path2 = f12341c;
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            Path path3 = f12342d;
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            Path path4 = f12342d;
            path4.reset();
            pathMeasure.getSegment(fMin + length, length, path4, true);
            path2.addPath(path4);
        }
        path.set(path2);
        com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
    }

    public static void b(Path path, @o0 t tVar) {
        if (tVar == null || tVar.k()) {
            return;
        }
        a(path, ((com.airbnb.lottie.animation.keyframe.c) tVar.i()).o() / 100.0f, ((com.airbnb.lottie.animation.keyframe.c) tVar.e()).o() / 100.0f, ((com.airbnb.lottie.animation.keyframe.c) tVar.h()).o() / 360.0f);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e8) {
                throw e8;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f8 = pointF3.x + pointF.x;
            float f9 = pointF.y + pointF3.y;
            float f10 = pointF2.x;
            float f11 = f10 + pointF4.x;
            float f12 = pointF2.y;
            path.cubicTo(f8, f9, f11, f12 + pointF4.y, f10, f12);
        }
        return path;
    }

    public static float e() {
        if (f12345g == -1.0f) {
            f12345g = Resources.getSystem().getDisplayMetrics().density;
        }
        return f12345g;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = f12343e;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f8 = f12344f;
        fArr[2] = f8;
        fArr[3] = f8;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = f12343e;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static int i(float f8, float f9, float f10, float f11) {
        int i7 = f8 != 0.0f ? (int) (527 * f8) : 17;
        if (f9 != 0.0f) {
            i7 = (int) (i7 * 31 * f9);
        }
        if (f10 != 0.0f) {
            i7 = (int) (i7 * 31 * f10);
        }
        return f11 != 0.0f ? (int) (i7 * 31 * f11) : i7;
    }

    public static boolean j(int i7, int i8, int i9, int i10, int i11, int i12) {
        if (i7 < i10) {
            return false;
        }
        if (i7 > i10) {
            return true;
        }
        if (i8 < i11) {
            return false;
        }
        return i8 > i11 || i9 >= i12;
    }

    public static boolean k(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static Bitmap l(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        com.airbnb.lottie.animation.a aVar = new com.airbnb.lottie.animation.a();
        aVar.setAntiAlias(true);
        aVar.setColor(-16776961);
        canvas.drawPath(path, aVar);
        return bitmapCreateBitmap;
    }

    public static Bitmap m(Bitmap bitmap, int i7, int i8) {
        if (bitmap.getWidth() == i7 && bitmap.getHeight() == i8) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i7, i8, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint) {
        o(canvas, rectF, paint, 31);
    }

    public static void o(Canvas canvas, RectF rectF, Paint paint, int i7) {
        com.airbnb.lottie.e.a("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        com.airbnb.lottie.e.b("Utils#saveLayer");
    }
}
