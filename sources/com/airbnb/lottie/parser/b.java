package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12181a = com.airbnb.lottie.parser.moshi.c.a.a("a");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12182b = com.airbnb.lottie.parser.moshi.c.a.a("fc", "sc", "sw", "t");

    private b() {
    }

    public static com.airbnb.lottie.model.animatable.k a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        cVar.q();
        com.airbnb.lottie.model.animatable.k kVarB = null;
        while (cVar.E()) {
            if (cVar.o0(f12181a) != 0) {
                cVar.p0();
                cVar.r0();
            } else {
                kVarB = b(cVar, fVar);
            }
        }
        cVar.u();
        return kVarB == null ? new com.airbnb.lottie.model.animatable.k(null, null, null, null) : kVarB;
    }

    private static com.airbnb.lottie.model.animatable.k b(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        cVar.q();
        com.airbnb.lottie.model.animatable.a aVarC = null;
        com.airbnb.lottie.model.animatable.a aVarC2 = null;
        com.airbnb.lottie.model.animatable.b bVarE = null;
        com.airbnb.lottie.model.animatable.b bVarE2 = null;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12182b);
            if (iO0 == 0) {
                aVarC = d.c(cVar, fVar);
            } else if (iO0 == 1) {
                aVarC2 = d.c(cVar, fVar);
            } else if (iO0 == 2) {
                bVarE = d.e(cVar, fVar);
            } else if (iO0 != 3) {
                cVar.p0();
                cVar.r0();
            } else {
                bVarE2 = d.e(cVar, fVar);
            }
        }
        cVar.u();
        return new com.airbnb.lottie.model.animatable.k(aVarC, aVarC2, bVarE, bVarE2);
    }
}
