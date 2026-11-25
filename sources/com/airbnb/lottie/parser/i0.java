package com.airbnb.lottie.parser;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12199a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12200b = com.airbnb.lottie.parser.moshi.c.a.a("n", "v");

    private i0() {
    }

    static com.airbnb.lottie.model.content.p a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fG = 0.0f;
        boolean zF = false;
        String strQ = null;
        com.airbnb.lottie.model.animatable.b bVar = null;
        com.airbnb.lottie.model.animatable.a aVarC = null;
        com.airbnb.lottie.model.animatable.d dVarH = null;
        com.airbnb.lottie.model.animatable.b bVarE = null;
        com.airbnb.lottie.model.content.p.b bVar2 = null;
        com.airbnb.lottie.model.content.p.c cVar2 = null;
        while (cVar.E()) {
            switch (cVar.o0(f12199a)) {
                case 0:
                    strQ = cVar.Q();
                    break;
                case 1:
                    aVarC = d.c(cVar, fVar);
                    break;
                case 2:
                    bVarE = d.e(cVar, fVar);
                    break;
                case 3:
                    dVarH = d.h(cVar, fVar);
                    break;
                case 4:
                    bVar2 = com.airbnb.lottie.model.content.p.b.values()[cVar.H() - 1];
                    break;
                case 5:
                    cVar2 = com.airbnb.lottie.model.content.p.c.values()[cVar.H() - 1];
                    break;
                case 6:
                    fG = (float) cVar.G();
                    break;
                case 7:
                    zF = cVar.F();
                    break;
                case 8:
                    cVar.e();
                    while (cVar.E()) {
                        cVar.q();
                        String strQ2 = null;
                        com.airbnb.lottie.model.animatable.b bVarE2 = null;
                        while (cVar.E()) {
                            int iO0 = cVar.o0(f12200b);
                            if (iO0 == 0) {
                                strQ2 = cVar.Q();
                            } else if (iO0 != 1) {
                                cVar.p0();
                                cVar.r0();
                            } else {
                                bVarE2 = d.e(cVar, fVar);
                            }
                        }
                        cVar.u();
                        strQ2.hashCode();
                        switch (strQ2) {
                            case "d":
                            case "g":
                                fVar.w(true);
                                arrayList.add(bVarE2);
                                break;
                            case "o":
                                bVar = bVarE2;
                                break;
                        }
                    }
                    cVar.r();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                default:
                    cVar.r0();
                    break;
            }
        }
        return new com.airbnb.lottie.model.content.p(strQ, bVar, arrayList, aVarC, dVarH, bVarE, bVar2, cVar2, fG, zF);
    }
}
