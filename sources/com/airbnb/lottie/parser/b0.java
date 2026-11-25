package com.airbnb.lottie.parser;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12183a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "p", "s", "r", "hd");

    private b0() {
    }

    static com.airbnb.lottie.model.content.j a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        String strQ = null;
        com.airbnb.lottie.model.animatable.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.model.animatable.f fVarI = null;
        com.airbnb.lottie.model.animatable.b bVarE = null;
        boolean zF = false;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12183a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                mVarB = a.b(cVar, fVar);
            } else if (iO0 == 2) {
                fVarI = d.i(cVar, fVar);
            } else if (iO0 == 3) {
                bVarE = d.e(cVar, fVar);
            } else if (iO0 != 4) {
                cVar.r0();
            } else {
                zF = cVar.F();
            }
        }
        return new com.airbnb.lottie.model.content.j(strQ, mVarB, fVarI, bVarE, zF);
    }
}
