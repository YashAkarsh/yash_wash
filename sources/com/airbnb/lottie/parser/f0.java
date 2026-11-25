package com.airbnb.lottie.parser;

import android.graphics.Path;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12192a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    private f0() {
    }

    static com.airbnb.lottie.model.content.m a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        String strQ = null;
        com.airbnb.lottie.model.animatable.a aVarC = null;
        com.airbnb.lottie.model.animatable.d dVarH = null;
        boolean zF = false;
        boolean zF2 = false;
        int iH = 1;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12192a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                aVarC = d.c(cVar, fVar);
            } else if (iO0 == 2) {
                dVarH = d.h(cVar, fVar);
            } else if (iO0 == 3) {
                zF = cVar.F();
            } else if (iO0 == 4) {
                iH = cVar.H();
            } else if (iO0 != 5) {
                cVar.p0();
                cVar.r0();
            } else {
                zF2 = cVar.F();
            }
        }
        return new com.airbnb.lottie.model.content.m(strQ, zF, iH == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarC, dVarH, zF2);
    }
}
