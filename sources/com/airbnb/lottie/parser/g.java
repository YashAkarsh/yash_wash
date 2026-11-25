package com.airbnb.lottie.parser;

import c.o0;
import com.facebook.appevents.UserDataStore;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.airbnb.lottie.parser.moshi.c.a f12193a = com.airbnb.lottie.parser.moshi.c.a.a(m0.a.f37450j, "d");

    private g() {
    }

    @o0
    static com.airbnb.lottie.model.content.b a(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        com.airbnb.lottie.model.content.b bVarA;
        String strQ;
        cVar.q();
        byte b8 = 2;
        int iH = 2;
        while (true) {
            bVarA = null;
            if (!cVar.E()) {
                strQ = null;
                break;
            }
            int iO0 = cVar.o0(f12193a);
            if (iO0 == 0) {
                strQ = cVar.Q();
                break;
            }
            if (iO0 != 1) {
                cVar.p0();
                cVar.r0();
            } else {
                iH = cVar.H();
            }
        }
        if (strQ == null) {
            return null;
        }
        switch (strQ.hashCode()) {
            case 3239:
                b8 = !strQ.equals("el") ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b8 = !strQ.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strQ.equals("gf")) {
                    b8 = -1;
                }
                break;
            case 3307:
                b8 = !strQ.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b8 = !strQ.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b8 = !strQ.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b8 = !strQ.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3646:
                b8 = !strQ.equals("rp") ? (byte) -1 : (byte) 7;
                break;
            case 3669:
                b8 = !strQ.equals("sh") ? (byte) -1 : (byte) 8;
                break;
            case 3679:
                b8 = !strQ.equals("sr") ? (byte) -1 : (byte) 9;
                break;
            case 3681:
                b8 = !strQ.equals(UserDataStore.STATE) ? (byte) -1 : (byte) 10;
                break;
            case 3705:
                b8 = !strQ.equals("tm") ? (byte) -1 : com.google.common.base.c.f19313m;
                break;
            case 3710:
                b8 = !strQ.equals("tr") ? (byte) -1 : com.google.common.base.c.f19314n;
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
                bVarA = e.a(cVar, fVar, iH);
                break;
            case 1:
                bVarA = f0.a(cVar, fVar);
                break;
            case 2:
                bVarA = m.a(cVar, fVar);
                break;
            case 3:
                bVarA = g0.a(cVar, fVar);
                break;
            case 4:
                bVarA = n.a(cVar, fVar);
                break;
            case 5:
                bVarA = w.a(cVar);
                fVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                bVarA = b0.a(cVar, fVar);
                break;
            case 7:
                bVarA = c0.a(cVar, fVar);
                break;
            case 8:
                bVarA = h0.a(cVar, fVar);
                break;
            case 9:
                bVarA = a0.a(cVar, fVar);
                break;
            case 10:
                bVarA = i0.a(cVar, fVar);
                break;
            case 11:
                bVarA = j0.a(cVar, fVar);
                break;
            case 12:
                bVarA = c.g(cVar, fVar);
                break;
            default:
                com.airbnb.lottie.utils.f.e("Unknown shape type " + strQ);
                break;
        }
        while (cVar.E()) {
            cVar.r0();
        }
        cVar.u();
        return bVarA;
    }
}
