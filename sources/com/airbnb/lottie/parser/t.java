package com.airbnb.lottie.parser;

import android.graphics.Rect;
import com.haier.uhome.trace.api.TraceProtocolConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12302a = com.airbnb.lottie.parser.moshi.c.a.a("w", "h", TraceProtocolConst.PRO_IP, "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static com.airbnb.lottie.parser.moshi.c.a f12303b = com.airbnb.lottie.parser.moshi.c.a.a("id", "layers", "w", "h", "p", "u");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12304c = com.airbnb.lottie.parser.moshi.c.a.a("list");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12305d = com.airbnb.lottie.parser.moshi.c.a.a("cm", "tm", "dr");

    public static com.airbnb.lottie.f a(com.airbnb.lottie.parser.moshi.c cVar) throws IOException {
        float fE = com.airbnb.lottie.utils.j.e();
        androidx.collection.f<com.airbnb.lottie.model.layer.d> fVar = new androidx.collection.f<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        androidx.collection.j<com.airbnb.lottie.model.d> jVar = new androidx.collection.j<>();
        com.airbnb.lottie.f fVar2 = new com.airbnb.lottie.f();
        cVar.q();
        float fG = 0.0f;
        float fG2 = 0.0f;
        float fG3 = 0.0f;
        int iH = 0;
        int iH2 = 0;
        while (cVar.E()) {
            switch (cVar.o0(f12302a)) {
                case 0:
                    iH = cVar.H();
                    break;
                case 1:
                    iH2 = cVar.H();
                    break;
                case 2:
                    fG = (float) cVar.G();
                    break;
                case 3:
                    fG2 = ((float) cVar.G()) - 0.01f;
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 4:
                    fG3 = (float) cVar.G();
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 5:
                    String[] strArrSplit = cVar.Q().split("\\.");
                    if (!com.airbnb.lottie.utils.j.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        fVar2.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 6:
                    e(cVar, fVar2, arrayList, fVar);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 7:
                    b(cVar, fVar2, map, map2);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 8:
                    d(cVar, map3);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 9:
                    c(cVar, fVar2, jVar);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 10:
                    f(cVar, fVar2, arrayList2);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                default:
                    cVar.p0();
                    cVar.r0();
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
            }
        }
        fVar2.u(new Rect(0, 0, (int) (iH * fE), (int) (iH2 * fE)), fG, fG2, fG3, arrayList, fVar, map, map2, jVar, map3, arrayList2);
        return fVar2;
    }

    private static void b(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, Map<String, List<com.airbnb.lottie.model.layer.d>> map, Map<String, com.airbnb.lottie.i> map2) throws IOException {
        cVar.e();
        while (cVar.E()) {
            ArrayList arrayList = new ArrayList();
            androidx.collection.f fVar2 = new androidx.collection.f();
            cVar.q();
            int iH = 0;
            int iH2 = 0;
            String strQ = null;
            String strQ2 = null;
            String strQ3 = null;
            while (cVar.E()) {
                int iO0 = cVar.o0(f12303b);
                if (iO0 == 0) {
                    strQ = cVar.Q();
                } else if (iO0 == 1) {
                    cVar.e();
                    while (cVar.E()) {
                        com.airbnb.lottie.model.layer.d dVarB = s.b(cVar, fVar);
                        fVar2.s(dVarB.b(), dVarB);
                        arrayList.add(dVarB);
                    }
                    cVar.r();
                } else if (iO0 == 2) {
                    iH = cVar.H();
                } else if (iO0 == 3) {
                    iH2 = cVar.H();
                } else if (iO0 == 4) {
                    strQ2 = cVar.Q();
                } else if (iO0 != 5) {
                    cVar.p0();
                    cVar.r0();
                } else {
                    strQ3 = cVar.Q();
                }
            }
            cVar.u();
            if (strQ2 != null) {
                com.airbnb.lottie.i iVar = new com.airbnb.lottie.i(iH, iH2, strQ, strQ2, strQ3);
                map2.put(iVar.e(), iVar);
            } else {
                map.put(strQ, arrayList);
            }
        }
        cVar.r();
    }

    private static void c(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, androidx.collection.j<com.airbnb.lottie.model.d> jVar) throws IOException {
        cVar.e();
        while (cVar.E()) {
            com.airbnb.lottie.model.d dVarA = j.a(cVar, fVar);
            jVar.s(dVarA.hashCode(), dVarA);
        }
        cVar.r();
    }

    private static void d(com.airbnb.lottie.parser.moshi.c cVar, Map<String, com.airbnb.lottie.model.c> map) throws IOException {
        cVar.q();
        while (cVar.E()) {
            if (cVar.o0(f12304c) != 0) {
                cVar.p0();
                cVar.r0();
            } else {
                cVar.e();
                while (cVar.E()) {
                    com.airbnb.lottie.model.c cVarA = k.a(cVar);
                    map.put(cVarA.c(), cVarA);
                }
                cVar.r();
            }
        }
        cVar.u();
    }

    private static void e(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, List<com.airbnb.lottie.model.layer.d> list, androidx.collection.f<com.airbnb.lottie.model.layer.d> fVar2) throws IOException {
        cVar.e();
        int i7 = 0;
        while (cVar.E()) {
            com.airbnb.lottie.model.layer.d dVarB = s.b(cVar, fVar);
            if (dVarB.d() == com.airbnb.lottie.model.layer.d.a.IMAGE) {
                i7++;
            }
            list.add(dVarB);
            fVar2.s(dVarB.b(), dVarB);
            if (i7 > 4) {
                com.airbnb.lottie.utils.f.e("You have " + i7 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.r();
    }

    private static void f(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, List<com.airbnb.lottie.model.h> list) throws IOException {
        cVar.e();
        while (cVar.E()) {
            cVar.q();
            float fG = 0.0f;
            String strQ = null;
            float fG2 = 0.0f;
            while (cVar.E()) {
                int iO0 = cVar.o0(f12305d);
                if (iO0 == 0) {
                    strQ = cVar.Q();
                } else if (iO0 == 1) {
                    fG = (float) cVar.G();
                } else if (iO0 != 2) {
                    cVar.p0();
                    cVar.r0();
                } else {
                    fG2 = (float) cVar.G();
                }
            }
            cVar.u();
            list.add(new com.airbnb.lottie.model.h(strQ, fG, fG2));
        }
        cVar.r();
    }
}
