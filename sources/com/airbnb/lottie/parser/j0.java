package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12203a = com.airbnb.lottie.parser.moshi.c.a.a("s", "e", "o", "nm", "m", "hd");

    private j0() {
    }

    static com.airbnb.lottie.model.content.q a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        String strQ = null;
        com.airbnb.lottie.model.content.q.a aVarA = null;
        com.airbnb.lottie.model.animatable.b bVarF = null;
        com.airbnb.lottie.model.animatable.b bVarF2 = null;
        com.airbnb.lottie.model.animatable.b bVarF3 = null;
        boolean zF = false;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12203a);
            if (iO0 == 0) {
                bVarF = d.f(cVar, fVar, false);
            } else if (iO0 == 1) {
                bVarF2 = d.f(cVar, fVar, false);
            } else if (iO0 == 2) {
                bVarF3 = d.f(cVar, fVar, false);
            } else if (iO0 == 3) {
                strQ = cVar.Q();
            } else if (iO0 == 4) {
                aVarA = com.airbnb.lottie.model.content.q.a.a(cVar.H());
            } else if (iO0 != 5) {
                cVar.r0();
            } else {
                zF = cVar.F();
            }
        }
        return new com.airbnb.lottie.model.content.q(strQ, aVarA, bVarF, bVarF2, bVarF3, zF);
    }
}
