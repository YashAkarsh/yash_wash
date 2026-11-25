package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.airbnb.lottie.parser.moshi.c.a f12197a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "ind", "ks", "hd");

    private h0() {
    }

    static com.airbnb.lottie.model.content.o a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        String strQ = null;
        int iH = 0;
        boolean zF = false;
        com.airbnb.lottie.model.animatable.h hVarK = null;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12197a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                iH = cVar.H();
            } else if (iO0 == 2) {
                hVarK = d.k(cVar, fVar);
            } else if (iO0 != 3) {
                cVar.r0();
            } else {
                zF = cVar.F();
            }
        }
        return new com.airbnb.lottie.model.content.o(strQ, iH, hVarK, zF);
    }
}
