package com.airbnb.lottie.parser;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12180a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    private a0() {
    }

    static com.airbnb.lottie.model.content.i a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        String strQ = null;
        com.airbnb.lottie.model.content.i.a aVarA = null;
        com.airbnb.lottie.model.animatable.b bVarF = null;
        com.airbnb.lottie.model.animatable.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.model.animatable.b bVarF2 = null;
        com.airbnb.lottie.model.animatable.b bVarE = null;
        com.airbnb.lottie.model.animatable.b bVarE2 = null;
        com.airbnb.lottie.model.animatable.b bVarF3 = null;
        com.airbnb.lottie.model.animatable.b bVarF4 = null;
        boolean zF = false;
        while (cVar.E()) {
            switch (cVar.o0(f12180a)) {
                case 0:
                    strQ = cVar.Q();
                    break;
                case 1:
                    aVarA = com.airbnb.lottie.model.content.i.a.a(cVar.H());
                    break;
                case 2:
                    bVarF = d.f(cVar, fVar, false);
                    break;
                case 3:
                    mVarB = a.b(cVar, fVar);
                    break;
                case 4:
                    bVarF2 = d.f(cVar, fVar, false);
                    break;
                case 5:
                    bVarE2 = d.e(cVar, fVar);
                    break;
                case 6:
                    bVarF4 = d.f(cVar, fVar, false);
                    break;
                case 7:
                    bVarE = d.e(cVar, fVar);
                    break;
                case 8:
                    bVarF3 = d.f(cVar, fVar, false);
                    break;
                case 9:
                    zF = cVar.F();
                    break;
                default:
                    cVar.p0();
                    cVar.r0();
                    break;
            }
        }
        return new com.airbnb.lottie.model.content.i(strQ, aVarA, bVarF, mVarB, bVarF2, bVarE, bVarE2, bVarF3, bVarF4, zF);
    }
}
