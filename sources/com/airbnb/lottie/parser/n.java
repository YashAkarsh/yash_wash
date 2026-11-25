package com.airbnb.lottie.parser;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12288a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12289b = com.airbnb.lottie.parser.moshi.c.a.a("p", "k");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12290c = com.airbnb.lottie.parser.moshi.c.a.a("n", "v");

    private n() {
    }

    static com.airbnb.lottie.model.content.e a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fG = 0.0f;
        String strQ = null;
        com.airbnb.lottie.model.content.f fVar2 = null;
        com.airbnb.lottie.model.animatable.c cVarG = null;
        com.airbnb.lottie.model.animatable.d dVarH = null;
        com.airbnb.lottie.model.animatable.f fVarI = null;
        com.airbnb.lottie.model.animatable.f fVarI2 = null;
        com.airbnb.lottie.model.animatable.b bVarE = null;
        com.airbnb.lottie.model.content.p.b bVar = null;
        com.airbnb.lottie.model.content.p.c cVar2 = null;
        com.airbnb.lottie.model.animatable.b bVar2 = null;
        boolean zF = false;
        while (cVar.E()) {
            switch (cVar.o0(f12288a)) {
                case 0:
                    strQ = cVar.Q();
                    continue;
                case 1:
                    cVar.q();
                    int iH = -1;
                    while (cVar.E()) {
                        int iO0 = cVar.o0(f12289b);
                        if (iO0 == 0) {
                            iH = cVar.H();
                        } else if (iO0 != 1) {
                            cVar.p0();
                            cVar.r0();
                        } else {
                            cVarG = d.g(cVar, fVar, iH);
                        }
                        cVarG = cVarG;
                    }
                    cVar.u();
                    break;
                case 2:
                    dVarH = d.h(cVar, fVar);
                    continue;
                case 3:
                    fVar2 = cVar.H() == 1 ? com.airbnb.lottie.model.content.f.LINEAR : com.airbnb.lottie.model.content.f.RADIAL;
                    break;
                case 4:
                    fVarI = d.i(cVar, fVar);
                    continue;
                case 5:
                    fVarI2 = d.i(cVar, fVar);
                    continue;
                case 6:
                    bVarE = d.e(cVar, fVar);
                    continue;
                case 7:
                    bVar = com.airbnb.lottie.model.content.p.b.values()[cVar.H() - 1];
                    break;
                case 8:
                    cVar2 = com.airbnb.lottie.model.content.p.c.values()[cVar.H() - 1];
                    break;
                case 9:
                    fG = (float) cVar.G();
                    break;
                case 10:
                    zF = cVar.F();
                    continue;
                case 11:
                    cVar.e();
                    while (cVar.E()) {
                        cVar.q();
                        String strQ2 = null;
                        com.airbnb.lottie.model.animatable.b bVarE2 = null;
                        while (cVar.E()) {
                            int iO1 = cVar.o0(f12290c);
                            if (iO1 != 0) {
                                com.airbnb.lottie.model.animatable.b bVar3 = bVar2;
                                if (iO1 != 1) {
                                    cVar.p0();
                                    cVar.r0();
                                } else {
                                    bVarE2 = d.e(cVar, fVar);
                                }
                                bVar2 = bVar3;
                            } else {
                                strQ2 = cVar.Q();
                            }
                        }
                        com.airbnb.lottie.model.animatable.b bVar4 = bVar2;
                        cVar.u();
                        if (strQ2.equals("o")) {
                            bVar2 = bVarE2;
                        } else {
                            if (strQ2.equals("d") || strQ2.equals("g")) {
                                fVar.w(true);
                                arrayList.add(bVarE2);
                            }
                            bVar2 = bVar4;
                        }
                    }
                    com.airbnb.lottie.model.animatable.b bVar5 = bVar2;
                    cVar.r();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar5;
                    continue;
                default:
                    cVar.p0();
                    cVar.r0();
                    continue;
            }
            strQ = strQ;
        }
        return new com.airbnb.lottie.model.content.e(strQ, fVar2, cVarG, dVarH, fVarI, fVarI2, bVarE, bVar, cVar2, fG, arrayList, bVar2, zF);
    }
}
