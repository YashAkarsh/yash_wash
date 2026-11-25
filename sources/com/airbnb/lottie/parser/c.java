package com.airbnb.lottie.parser;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12184a = com.airbnb.lottie.parser.moshi.c.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12185b = com.airbnb.lottie.parser.moshi.c.a.a("k");

    private c() {
    }

    private static boolean a(com.airbnb.lottie.model.animatable.e eVar) {
        return eVar == null || (eVar.c() && eVar.b().get(0).f12349b.equals(0.0f, 0.0f));
    }

    private static boolean b(com.airbnb.lottie.model.animatable.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof com.airbnb.lottie.model.animatable.i) && mVar.c() && mVar.b().get(0).f12349b.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(com.airbnb.lottie.model.animatable.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((com.airbnb.lottie.value.a) bVar.b().get(0)).f12349b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean d(com.airbnb.lottie.model.animatable.g gVar) {
        return gVar == null || (gVar.c() && ((com.airbnb.lottie.value.k) ((com.airbnb.lottie.value.a) gVar.b().get(0)).f12349b).a(1.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean e(com.airbnb.lottie.model.animatable.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((com.airbnb.lottie.value.a) bVar.b().get(0)).f12349b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean f(com.airbnb.lottie.model.animatable.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((com.airbnb.lottie.value.a) bVar.b().get(0)).f12349b).floatValue() == 0.0f);
    }

    public static com.airbnb.lottie.model.animatable.l g(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        boolean z7;
        boolean z8 = false;
        boolean z9 = cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_OBJECT;
        if (z9) {
            cVar.q();
        }
        com.airbnb.lottie.model.animatable.b bVar = null;
        com.airbnb.lottie.model.animatable.e eVarA = null;
        com.airbnb.lottie.model.animatable.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.model.animatable.g gVarJ = null;
        com.airbnb.lottie.model.animatable.b bVarF = null;
        com.airbnb.lottie.model.animatable.b bVarF2 = null;
        com.airbnb.lottie.model.animatable.d dVarH = null;
        com.airbnb.lottie.model.animatable.b bVarF3 = null;
        com.airbnb.lottie.model.animatable.b bVarF4 = null;
        while (cVar.E()) {
            switch (cVar.o0(f12184a)) {
                case 0:
                    boolean z10 = z8;
                    cVar.q();
                    while (cVar.E()) {
                        if (cVar.o0(f12185b) != 0) {
                            cVar.p0();
                            cVar.r0();
                        } else {
                            eVarA = a.a(cVar, fVar);
                        }
                    }
                    cVar.u();
                    z8 = z10;
                    continue;
                case 1:
                    mVarB = a.b(cVar, fVar);
                    continue;
                case 2:
                    gVarJ = d.j(cVar, fVar);
                    continue;
                case 3:
                    fVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVarH = d.h(cVar, fVar);
                    continue;
                case 6:
                    bVarF3 = d.f(cVar, fVar, z8);
                    continue;
                case 7:
                    bVarF4 = d.f(cVar, fVar, z8);
                    continue;
                case 8:
                    bVarF = d.f(cVar, fVar, z8);
                    continue;
                case 9:
                    bVarF2 = d.f(cVar, fVar, z8);
                    continue;
                default:
                    cVar.p0();
                    cVar.r0();
                    continue;
            }
            com.airbnb.lottie.model.animatable.b bVarF5 = d.f(cVar, fVar, z8);
            if (bVarF5.b().isEmpty()) {
                bVarF5.b().add(new com.airbnb.lottie.value.a(fVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(fVar.f())));
            } else {
                if (((com.airbnb.lottie.value.a) bVarF5.b().get(0)).f12349b == 0) {
                    z7 = false;
                    bVarF5.b().set(0, new com.airbnb.lottie.value.a(fVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(fVar.f())));
                }
                z8 = z7;
                bVar = bVarF5;
            }
            z7 = false;
            z8 = z7;
            bVar = bVarF5;
        }
        if (z9) {
            cVar.u();
        }
        com.airbnb.lottie.model.animatable.e eVar = a(eVarA) ? null : eVarA;
        com.airbnb.lottie.model.animatable.m<PointF, PointF> mVar = b(mVarB) ? null : mVarB;
        com.airbnb.lottie.model.animatable.b bVar2 = c(bVar) ? null : bVar;
        if (d(gVarJ)) {
            gVarJ = null;
        }
        return new com.airbnb.lottie.model.animatable.l(eVar, mVar, gVarJ, bVar2, dVarH, bVarF3, bVarF4, f(bVarF) ? null : bVarF, e(bVarF2) ? null : bVarF2);
    }
}
