package com.airbnb.lottie.parser;

import android.graphics.Rect;
import com.haier.uhome.trace.api.TraceProtocolConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static com.airbnb.lottie.parser.moshi.c.a f12306a = com.airbnb.lottie.parser.moshi.c.a.a("w", "h", TraceProtocolConst.PRO_IP, "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

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
            switch (cVar.o0(f12306a)) {
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
                    b(cVar, fVar2, arrayList, fVar);
                default:
                    cVar.r0();
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
            }
        }
        fVar2.u(new Rect(0, 0, (int) (iH * fE), (int) (iH2 * fE)), fG, fG2, fG3, arrayList, fVar, map, map2, jVar, map3, arrayList2);
        return fVar2;
    }

    private static void b(com.airbnb.lottie.parser.moshi.c cVar, com.airbnb.lottie.f fVar, List<com.airbnb.lottie.model.layer.d> list, androidx.collection.f<com.airbnb.lottie.model.layer.d> fVar2) throws IOException {
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
}
