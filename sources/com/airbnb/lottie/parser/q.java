package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import c.o0;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f12294a = 100.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static androidx.collection.j<WeakReference<Interpolator>> f12296c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Interpolator f12295b = new LinearInterpolator();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static com.airbnb.lottie.parser.moshi.c.a f12297d = com.airbnb.lottie.parser.moshi.c.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    q() {
    }

    @o0
    private static WeakReference<Interpolator> a(int i7) {
        WeakReference<Interpolator> weakReferenceM;
        synchronized (q.class) {
            weakReferenceM = e().m(i7);
        }
        return weakReferenceM;
    }

    static <T> com.airbnb.lottie.value.a<T> b(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, float f8, k0<T> k0Var, boolean z7) throws IOException {
        return z7 ? c(fVar, cVar, f8, k0Var) : d(cVar, f8, k0Var);
    }

    private static <T> com.airbnb.lottie.value.a<T> c(com.airbnb.lottie.f fVar, com.airbnb.lottie.parser.moshi.c cVar, float f8, k0<T> k0Var) throws IOException {
        Interpolator interpolator;
        T t7;
        Interpolator interpolatorB;
        cVar.q();
        PointF pointFE = null;
        PointF pointFE2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        float fG = 0.0f;
        while (true) {
            boolean z7 = false;
            while (true) {
                if (!cVar.E()) {
                    cVar.u();
                    if (z7) {
                        interpolator = f12295b;
                        t7 = tA2;
                    } else {
                        if (pointFE == null || pointFE2 == null) {
                            interpolator = f12295b;
                        } else {
                            float f9 = -f8;
                            pointFE.x = com.airbnb.lottie.utils.i.b(pointFE.x, f9, f8);
                            pointFE.y = com.airbnb.lottie.utils.i.b(pointFE.y, -100.0f, f12294a);
                            pointFE2.x = com.airbnb.lottie.utils.i.b(pointFE2.x, f9, f8);
                            float fB = com.airbnb.lottie.utils.i.b(pointFE2.y, -100.0f, f12294a);
                            pointFE2.y = fB;
                            int i7 = com.airbnb.lottie.utils.j.i(pointFE.x, pointFE.y, pointFE2.x, fB);
                            WeakReference<Interpolator> weakReferenceA = a(i7);
                            Interpolator interpolator2 = weakReferenceA != null ? weakReferenceA.get() : null;
                            if (weakReferenceA == null || interpolator2 == null) {
                                pointFE.x /= f8;
                                pointFE.y /= f8;
                                float f10 = pointFE2.x / f8;
                                pointFE2.x = f10;
                                float f11 = pointFE2.y / f8;
                                pointFE2.y = f11;
                                try {
                                    interpolatorB = androidx.core.view.animation.b.b(pointFE.x, pointFE.y, f10, f11);
                                } catch (IllegalArgumentException e8) {
                                    interpolatorB = e8.getMessage().equals("The Path cannot loop back on itself.") ? androidx.core.view.animation.b.b(Math.min(pointFE.x, 1.0f), pointFE.y, Math.max(pointFE2.x, 0.0f), pointFE2.y) : new LinearInterpolator();
                                }
                                interpolator2 = interpolatorB;
                                try {
                                    f(i7, new WeakReference(interpolator2));
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                }
                            }
                            interpolator = interpolator2;
                        }
                        t7 = tA;
                    }
                    com.airbnb.lottie.value.a<T> aVar = new com.airbnb.lottie.value.a<>(fVar, tA2, t7, interpolator, fG, null);
                    aVar.f12360m = pointFE4;
                    aVar.f12361n = pointFE3;
                    return aVar;
                }
                switch (cVar.o0(f12297d)) {
                    case 0:
                        fG = (float) cVar.G();
                        break;
                    case 1:
                        tA2 = k0Var.a(cVar, f8);
                        break;
                    case 2:
                        tA = k0Var.a(cVar, f8);
                        break;
                    case 3:
                        pointFE = p.e(cVar, f8);
                        break;
                    case 4:
                        pointFE2 = p.e(cVar, f8);
                        break;
                    case 5:
                        if (cVar.H() == 1) {
                            z7 = true;
                        }
                        break;
                    case 6:
                        pointFE4 = p.e(cVar, f8);
                        break;
                    case 7:
                        pointFE3 = p.e(cVar, f8);
                        break;
                    default:
                        cVar.r0();
                        break;
                }
            }
        }
    }

    private static <T> com.airbnb.lottie.value.a<T> d(com.airbnb.lottie.parser.moshi.c cVar, float f8, k0<T> k0Var) throws IOException {
        return new com.airbnb.lottie.value.a<>(k0Var.a(cVar, f8));
    }

    private static androidx.collection.j<WeakReference<Interpolator>> e() {
        if (f12296c == null) {
            f12296c = new androidx.collection.j<>();
        }
        return f12296c;
    }

    private static void f(int i7, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f12296c.s(i7, weakReference);
        }
    }
}
