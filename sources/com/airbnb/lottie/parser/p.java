package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12292a = com.airbnb.lottie.parser.moshi.c.a.a("x", "y");

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12293a;

        static {
            int[] iArr = new int[com.airbnb.lottie.parser.moshi.c.b.values().length];
            f12293a = iArr;
            try {
                iArr[com.airbnb.lottie.parser.moshi.c.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12293a[com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12293a[com.airbnb.lottie.parser.moshi.c.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private p() {
    }

    private static PointF a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        cVar.e();
        float fG = (float) cVar.G();
        float fG2 = (float) cVar.G();
        while (cVar.h0() != com.airbnb.lottie.parser.moshi.c.b.END_ARRAY) {
            cVar.r0();
        }
        cVar.r();
        return new PointF(fG * f8, fG2 * f8);
    }

    private static PointF b(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        float fG = (float) cVar.G();
        float fG2 = (float) cVar.G();
        while (cVar.E()) {
            cVar.r0();
        }
        return new PointF(fG * f8, fG2 * f8);
    }

    private static PointF c(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        cVar.q();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12292a);
            if (iO0 == 0) {
                fG = g(cVar);
            } else if (iO0 != 1) {
                cVar.p0();
                cVar.r0();
            } else {
                fG2 = g(cVar);
            }
        }
        cVar.u();
        return new PointF(fG * f8, fG2 * f8);
    }

    @c.l
    static int d(com.airbnb.lottie.parser.moshi.c cVar) throws IOException {
        cVar.e();
        int iG = (int) (cVar.G() * 255.0d);
        int iG2 = (int) (cVar.G() * 255.0d);
        int iG3 = (int) (cVar.G() * 255.0d);
        while (cVar.E()) {
            cVar.r0();
        }
        cVar.r();
        return Color.argb(255, iG, iG2, iG3);
    }

    static PointF e(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        int i7 = a.f12293a[cVar.h0().ordinal()];
        if (i7 == 1) {
            return b(cVar, f8);
        }
        if (i7 == 2) {
            return a(cVar, f8);
        }
        if (i7 == 3) {
            return c(cVar, f8);
        }
        throw new IllegalArgumentException("Unknown point starts with " + cVar.h0());
    }

    static List<PointF> f(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.e();
        while (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY) {
            cVar.e();
            arrayList.add(e(cVar, f8));
            cVar.r();
        }
        cVar.r();
        return arrayList;
    }

    static float g(com.airbnb.lottie.parser.moshi.c cVar) throws IOException {
        com.airbnb.lottie.parser.moshi.c.b bVarH0 = cVar.h0();
        int i7 = a.f12293a[bVarH0.ordinal()];
        if (i7 == 1) {
            return (float) cVar.G();
        }
        if (i7 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + bVarH0);
        }
        cVar.e();
        float fG = (float) cVar.G();
        while (cVar.E()) {
            cVar.r0();
        }
        cVar.r();
        return fG;
    }
}
