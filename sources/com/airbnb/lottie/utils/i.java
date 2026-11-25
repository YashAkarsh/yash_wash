package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import c.v;
import com.airbnb.lottie.model.content.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PointF f12338a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f8, float f9, float f10) {
        return Math.max(f9, Math.min(f10, f8));
    }

    public static int c(int i7, int i8, int i9) {
        return Math.max(i8, Math.min(i9, i7));
    }

    public static boolean d(float f8, float f9, float f10) {
        return f8 >= f9 && f8 <= f10;
    }

    private static int e(int i7, int i8) {
        int i9 = i7 / i8;
        return (((i7 ^ i8) >= 0) || i7 % i8 == 0) ? i9 : i9 - 1;
    }

    static int f(float f8, float f9) {
        return g((int) f8, (int) f9);
    }

    private static int g(int i7, int i8) {
        return i7 - (i8 * e(i7, i8));
    }

    public static void h(l lVar, Path path) {
        path.reset();
        PointF pointFB = lVar.b();
        path.moveTo(pointFB.x, pointFB.y);
        f12338a.set(pointFB.x, pointFB.y);
        for (int i7 = 0; i7 < lVar.a().size(); i7++) {
            com.airbnb.lottie.model.a aVar = lVar.a().get(i7);
            PointF pointFA = aVar.a();
            PointF pointFB2 = aVar.b();
            PointF pointFC = aVar.c();
            if (pointFA.equals(f12338a) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            f12338a.set(pointFC.x, pointFC.y);
        }
        if (lVar.d()) {
            path.close();
        }
    }

    public static double i(double d8, double d9, @v(from = 0.0d, to = 1.0d) double d10) {
        return d8 + (d10 * (d9 - d8));
    }

    public static float j(float f8, float f9, @v(from = 0.0d, to = 1.0d) float f10) {
        return f8 + (f10 * (f9 - f8));
    }

    public static int k(int i7, int i8, @v(from = 0.0d, to = 1.0d) float f8) {
        return (int) (i7 + (f8 * (i8 - i7)));
    }

    public static void l(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2, com.airbnb.lottie.animation.content.k kVar) {
        if (eVar.c(kVar.getName(), i7)) {
            list.add(eVar2.a(kVar.getName()).j(kVar));
        }
    }
}
