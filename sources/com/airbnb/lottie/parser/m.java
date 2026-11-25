package com.airbnb.lottie.parser;

import android.graphics.Path;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12206a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12207b = com.airbnb.lottie.parser.moshi.c.a.a("p", "k");

    private m() {
    }

    static com.airbnb.lottie.model.content.d a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        Path.FillType fillType = Path.FillType.WINDING;
        String strQ = null;
        com.airbnb.lottie.model.content.f fVar2 = null;
        com.airbnb.lottie.model.animatable.c cVarG = null;
        com.airbnb.lottie.model.animatable.d dVarH = null;
        com.airbnb.lottie.model.animatable.f fVarI = null;
        com.airbnb.lottie.model.animatable.f fVarI2 = null;
        boolean zF = false;
        while (cVar.E()) {
            switch (cVar.o0(f12206a)) {
                case 0:
                    strQ = cVar.Q();
                    break;
                case 1:
                    cVar.q();
                    int iH = -1;
                    while (cVar.E()) {
                        int iO0 = cVar.o0(f12207b);
                        if (iO0 == 0) {
                            iH = cVar.H();
                        } else if (iO0 != 1) {
                            cVar.p0();
                            cVar.r0();
                        } else {
                            cVarG = d.g(cVar, fVar, iH);
                        }
                    }
                    cVar.u();
                    break;
                case 2:
                    dVarH = d.h(cVar, fVar);
                    break;
                case 3:
                    fVar2 = cVar.H() == 1 ? com.airbnb.lottie.model.content.f.LINEAR : com.airbnb.lottie.model.content.f.RADIAL;
                    break;
                case 4:
                    fVarI = d.i(cVar, fVar);
                    break;
                case 5:
                    fVarI2 = d.i(cVar, fVar);
                    break;
                case 6:
                    fillType = cVar.H() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zF = cVar.F();
                    break;
                default:
                    cVar.p0();
                    cVar.r0();
                    break;
            }
        }
        return new com.airbnb.lottie.model.content.d(strQ, fVar2, fillType, cVarG, dVarH, fVarI, fVarI2, null, null, zF);
    }
}
