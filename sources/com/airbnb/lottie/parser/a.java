package com.airbnb.lottie.parser;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12179a = com.airbnb.lottie.parser.moshi.c.a.a("k", "x", "y");

    private a() {
    }

    public static com.airbnb.lottie.model.animatable.e a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY) {
            cVar.e();
            while (cVar.E()) {
                arrayList.add(x.a(cVar, fVar));
            }
            cVar.r();
            r.b(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.value.a(p.e(cVar, com.airbnb.lottie.utils.j.e())));
        }
        return new com.airbnb.lottie.model.animatable.e(arrayList);
    }

    static com.airbnb.lottie.model.animatable.m<PointF, PointF> b(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        cVar.q();
        com.airbnb.lottie.model.animatable.e eVarA = null;
        com.airbnb.lottie.model.animatable.b bVarE = null;
        boolean z7 = false;
        com.airbnb.lottie.model.animatable.b bVarE2 = null;
        while (cVar.h0() != com.airbnb.lottie.parser.moshi.c.b.END_OBJECT) {
            int iO0 = cVar.o0(f12179a);
            if (iO0 == 0) {
                eVarA = a(cVar, fVar);
            } else if (iO0 != 1) {
                if (iO0 != 2) {
                    cVar.p0();
                    cVar.r0();
                } else if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.STRING) {
                    cVar.r0();
                    z7 = true;
                } else {
                    bVarE = d.e(cVar, fVar);
                }
            } else if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.STRING) {
                cVar.r0();
                z7 = true;
            } else {
                bVarE2 = d.e(cVar, fVar);
            }
        }
        cVar.u();
        if (z7) {
            fVar.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new com.airbnb.lottie.model.animatable.i(bVarE2, bVarE);
    }
}
