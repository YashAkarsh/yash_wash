package com.airbnb.lottie.parser;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12194a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "hd", "it");

    private g0() {
    }

    static com.airbnb.lottie.model.content.n a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strQ = null;
        boolean zF = false;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12194a);
            if (iO0 == 0) {
                strQ = cVar.Q();
            } else if (iO0 == 1) {
                zF = cVar.F();
            } else if (iO0 != 2) {
                cVar.r0();
            } else {
                cVar.e();
                while (cVar.E()) {
                    com.airbnb.lottie.model.content.b bVarA = g.a(cVar, fVar);
                    if (bVarA != null) {
                        arrayList.add(bVarA);
                    }
                }
                cVar.r();
            }
        }
        return new com.airbnb.lottie.model.content.n(strQ, arrayList, zF);
    }
}
