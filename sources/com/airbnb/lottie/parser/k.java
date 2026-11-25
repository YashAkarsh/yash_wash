package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12204a = com.airbnb.lottie.parser.moshi.c.a.a("fFamily", "fName", "fStyle", "ascent");

    private k() {
    }

    static com.airbnb.lottie.model.c a(com.airbnb.lottie.parser.moshi.c cVar) throws IOException {
        cVar.q();
        String strQ = null;
        String strQ2 = null;
        float fG = 0.0f;
        String strQ3 = null;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12204a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                strQ3 = cVar.Q();
            } else if (iO0 == 2) {
                strQ2 = cVar.Q();
            } else if (iO0 != 3) {
                cVar.p0();
                cVar.r0();
            } else {
                fG = (float) cVar.G();
            }
        }
        cVar.u();
        return new com.airbnb.lottie.model.c(strQ, strQ3, strQ2, fG);
    }
}
