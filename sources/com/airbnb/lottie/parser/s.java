package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.facebook.appevents.UserDataStore;
import com.haier.uhome.trace.api.TraceProtocolConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12299a = com.airbnb.lottie.parser.moshi.c.a.a("nm", "ind", "refId", m0.a.f37450j, "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", UserDataStore.STATE, "w", "h", TraceProtocolConst.PRO_IP, "op", "tm", "cl", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12300b = com.airbnb.lottie.parser.moshi.c.a.a("d", "a");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12301c = com.airbnb.lottie.parser.moshi.c.a.a("nm");

    private s() {
    }

    public static com.airbnb.lottie.model.layer.d a(com.airbnb.lottie.f fVar) {
        Rect rectB = fVar.b();
        return new com.airbnb.lottie.model.layer.d(Collections.emptyList(), fVar, "__container", -1L, com.airbnb.lottie.model.layer.d.a.PRE_COMP, -1L, null, Collections.emptyList(), new com.airbnb.lottie.model.animatable.l(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), com.airbnb.lottie.model.layer.d.b.NONE, null, false);
    }

    public static com.airbnb.lottie.model.layer.d b(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar) throws IOException {
        ArrayList arrayList;
        float f8;
        com.airbnb.lottie.model.layer.d.b bVar = com.airbnb.lottie.model.layer.d.b.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cVar.q();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        com.airbnb.lottie.model.layer.d.b bVar2 = bVar;
        String strQ = null;
        com.airbnb.lottie.model.animatable.l lVarG = null;
        com.airbnb.lottie.model.animatable.j jVarD = null;
        com.airbnb.lottie.model.animatable.k kVarA = null;
        com.airbnb.lottie.model.animatable.b bVarF = null;
        long jH = 0;
        int iH = 0;
        int iH2 = 0;
        int color = 0;
        int iH3 = 0;
        int iH4 = 0;
        boolean zF = false;
        float fG = 1.0f;
        long jH2 = -1;
        float fG2 = 0.0f;
        float fG3 = 0.0f;
        String strQ2 = "UNSET";
        String strQ3 = null;
        com.airbnb.lottie.model.layer.d.a aVar = null;
        float fG4 = 0.0f;
        while (cVar.E()) {
            switch (cVar.o0(f12299a)) {
                case 0:
                    strQ2 = cVar.Q();
                    break;
                case 1:
                    jH = cVar.H();
                    break;
                case 2:
                    strQ = cVar.Q();
                    break;
                case 3:
                    int iH5 = cVar.H();
                    aVar = com.airbnb.lottie.model.layer.d.a.UNKNOWN;
                    if (iH5 < aVar.ordinal()) {
                        aVar = com.airbnb.lottie.model.layer.d.a.values()[iH5];
                    }
                    break;
                case 4:
                    jH2 = cVar.H();
                    break;
                case 5:
                    iH = (int) (cVar.H() * com.airbnb.lottie.utils.j.e());
                    break;
                case 6:
                    iH2 = (int) (cVar.H() * com.airbnb.lottie.utils.j.e());
                    break;
                case 7:
                    color = Color.parseColor(cVar.Q());
                    break;
                case 8:
                    lVarG = c.g(cVar, fVar);
                    break;
                case 9:
                    bVar2 = com.airbnb.lottie.model.layer.d.b.values()[cVar.H()];
                    fVar.t(1);
                    break;
                case 10:
                    cVar.e();
                    while (cVar.E()) {
                        arrayList2.add(v.a(cVar, fVar));
                    }
                    fVar.t(arrayList2.size());
                    cVar.r();
                    break;
                case 11:
                    cVar.e();
                    while (cVar.E()) {
                        com.airbnb.lottie.model.content.b bVarA = g.a(cVar, fVar);
                        if (bVarA != null) {
                            arrayList3.add(bVarA);
                        }
                    }
                    cVar.r();
                    break;
                case 12:
                    cVar.q();
                    while (cVar.E()) {
                        int iO0 = cVar.o0(f12300b);
                        if (iO0 == 0) {
                            jVarD = d.d(cVar, fVar);
                        } else if (iO0 != 1) {
                            cVar.p0();
                            cVar.r0();
                        } else {
                            cVar.e();
                            if (cVar.E()) {
                                kVarA = b.a(cVar, fVar);
                            }
                            while (cVar.E()) {
                                cVar.r0();
                            }
                            cVar.r();
                        }
                    }
                    cVar.u();
                    break;
                case 13:
                    cVar.e();
                    ArrayList arrayList4 = new ArrayList();
                    while (cVar.E()) {
                        cVar.q();
                        while (cVar.E()) {
                            if (cVar.o0(f12301c) != 0) {
                                cVar.p0();
                                cVar.r0();
                            } else {
                                arrayList4.add(cVar.Q());
                            }
                        }
                        cVar.u();
                    }
                    cVar.r();
                    fVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    fG = (float) cVar.G();
                    break;
                case 15:
                    fG3 = (float) cVar.G();
                    break;
                case 16:
                    iH3 = (int) (cVar.H() * com.airbnb.lottie.utils.j.e());
                    break;
                case 17:
                    iH4 = (int) (cVar.H() * com.airbnb.lottie.utils.j.e());
                    break;
                case 18:
                    fG2 = (float) cVar.G();
                    break;
                case 19:
                    fG4 = (float) cVar.G();
                    break;
                case 20:
                    bVarF = d.f(cVar, fVar, false);
                    break;
                case 21:
                    strQ3 = cVar.Q();
                    break;
                case 22:
                    zF = cVar.F();
                    break;
                default:
                    cVar.p0();
                    cVar.r0();
                    break;
            }
        }
        cVar.u();
        float f9 = fG2 / fG;
        float f10 = fG4 / fG;
        ArrayList arrayList5 = new ArrayList();
        if (f9 > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new com.airbnb.lottie.value.a(fVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f9)));
            f8 = 0.0f;
        } else {
            arrayList = arrayList5;
            f8 = 0.0f;
        }
        if (f10 <= f8) {
            f10 = fVar.f();
        }
        arrayList.add(new com.airbnb.lottie.value.a(fVar, fValueOf, fValueOf, null, f9, Float.valueOf(f10)));
        arrayList.add(new com.airbnb.lottie.value.a(fVar, fValueOf2, fValueOf2, null, f10, Float.valueOf(Float.MAX_VALUE)));
        if (strQ2.endsWith(".ai") || "ai".equals(strQ3)) {
            fVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new com.airbnb.lottie.model.layer.d(arrayList3, fVar, strQ2, jH, aVar, jH2, strQ, arrayList2, lVarG, iH, iH2, color, fG, fG3, iH3, iH4, jVarD, kVarA, arrayList, bVar2, bVarF, zF);
    }
}
