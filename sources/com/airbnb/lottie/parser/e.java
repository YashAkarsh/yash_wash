package com.airbnb.lottie.parser;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12188a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "p", "s", "hd", "d");

    private e() {
    }

    static com.airbnb.lottie.model.content.a a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, int i7) throws IOException {
        boolean z7 = i7 == 3;
        boolean zF = false;
        String strQ = null;
        com.airbnb.lottie.model.animatable.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.model.animatable.f fVarI = null;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12188a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                mVarB = a.b(cVar, fVar);
            } else if (iO0 == 2) {
                fVarI = d.i(cVar, fVar);
            } else if (iO0 == 3) {
                zF = cVar.F();
            } else if (iO0 != 4) {
                cVar.p0();
                cVar.r0();
            } else {
                z7 = cVar.H() == 3;
            }
        }
        return new com.airbnb.lottie.model.content.a(strQ, mVarB, fVarI, z7, zF);
    }
}
