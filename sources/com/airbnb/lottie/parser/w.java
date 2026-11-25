package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12307a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "mm", "hd");

    private w() {
    }

    static com.airbnb.lottie.model.content.h a(com.airbnb.lottie.parser.moshi.c cVar) throws IOException {
        String strQ = null;
        boolean zF = false;
        com.airbnb.lottie.model.content.h.a aVarA = null;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12307a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                aVarA = com.airbnb.lottie.model.content.h.a.a(cVar.H());
            } else if (iO0 != 2) {
                cVar.p0();
                cVar.r0();
            } else {
                zF = cVar.F();
            }
        }
        return new com.airbnb.lottie.model.content.h(strQ, aVarA, zF);
    }
}
