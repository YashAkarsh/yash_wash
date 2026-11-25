package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class v {
    private v() {
    }

    static com.airbnb.lottie.model.content.g a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        cVar.q();
        com.airbnb.lottie.model.content.g.a aVar = null;
        com.airbnb.lottie.model.animatable.h hVarK = null;
        com.airbnb.lottie.model.animatable.d dVarH = null;
        boolean zF = false;
        while (cVar.E()) {
            String strK = cVar.K();
            strK.hashCode();
            switch (strK) {
                case "o":
                    dVarH = d.h(cVar, fVar);
                    break;
                case "pt":
                    hVarK = d.k(cVar, fVar);
                    break;
                case "inv":
                    zF = cVar.F();
                    break;
                case "mode":
                    String strQ = cVar.Q();
                    strQ.hashCode();
                    switch (strQ) {
                        case "a":
                            aVar = com.airbnb.lottie.model.content.g.a.MASK_MODE_ADD;
                            break;
                        case "i":
                            fVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            aVar = com.airbnb.lottie.model.content.g.a.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            aVar = com.airbnb.lottie.model.content.g.a.MASK_MODE_NONE;
                            break;
                        case "s":
                            aVar = com.airbnb.lottie.model.content.g.a.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.airbnb.lottie.utils.f.e("Unknown mask mode " + strK + ". Defaulting to Add.");
                            aVar = com.airbnb.lottie.model.content.g.a.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    cVar.r0();
                    break;
            }
        }
        cVar.u();
        return new com.airbnb.lottie.model.content.g(aVar, hVarK, dVarH, zF);
    }
}
