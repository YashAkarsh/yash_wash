package com.airbnb.lottie.parser;

import com.facebook.internal.AnalyticsEvents;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12201a = com.airbnb.lottie.parser.moshi.c.a.a("ch", "size", "w", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "fFamily", "data");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12202b = com.airbnb.lottie.parser.moshi.c.a.a("shapes");

    private j() {
    }

    static com.airbnb.lottie.model.d a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.q();
        double dG = 0.0d;
        String strQ = null;
        String strQ2 = null;
        char cCharAt = 0;
        double dG2 = 0.0d;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12201a);
            if (iO0 == 0) {
                cCharAt = cVar.Q().charAt(0);
            } else if (iO0 == 1) {
                dG2 = cVar.G();
            } else if (iO0 == 2) {
                dG = cVar.G();
            } else if (iO0 == 3) {
                strQ = cVar.Q();
            } else if (iO0 == 4) {
                strQ2 = cVar.Q();
            } else if (iO0 != 5) {
                cVar.p0();
                cVar.r0();
            } else {
                cVar.q();
                while (cVar.E()) {
                    if (cVar.o0(f12202b) != 0) {
                        cVar.p0();
                        cVar.r0();
                    } else {
                        cVar.e();
                        while (cVar.E()) {
                            arrayList.add((com.airbnb.lottie.model.content.n) g.a(cVar, fVar));
                        }
                        cVar.r();
                    }
                }
                cVar.u();
            }
        }
        cVar.u();
        return new com.airbnb.lottie.model.d(arrayList, cCharAt, dG2, dG, strQ, strQ2);
    }
}
