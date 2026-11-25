package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12186a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "c", "o", "tr", "hd");

    private c0() {
    }

    static com.airbnb.lottie.model.content.k a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        String strQ = null;
        com.airbnb.lottie.model.animatable.b bVarF = null;
        com.airbnb.lottie.model.animatable.b bVarF2 = null;
        com.airbnb.lottie.model.animatable.l lVarG = null;
        boolean zF = false;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12186a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                bVarF = d.f(cVar, fVar, false);
            } else if (iO0 == 2) {
                bVarF2 = d.f(cVar, fVar, false);
            } else if (iO0 == 3) {
                lVarG = c.g(cVar, fVar);
            } else if (iO0 != 4) {
                cVar.r0();
            } else {
                zF = cVar.F();
            }
        }
        return new com.airbnb.lottie.model.content.k(strQ, bVarF, bVarF2, lVarG, zF);
    }
}
