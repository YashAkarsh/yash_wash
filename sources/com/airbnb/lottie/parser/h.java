package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class h implements k0<com.airbnb.lottie.model.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12195a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12196b = com.airbnb.lottie.parser.moshi.c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    @Override // com.airbnb.lottie.parser.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.model.b a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        com.airbnb.lottie.model.b.a aVar = com.airbnb.lottie.model.b.a.CENTER;
        cVar.q();
        com.airbnb.lottie.model.b.a aVar2 = aVar;
        String strQ = null;
        String strQ2 = null;
        float fG = 0.0f;
        float fG2 = 0.0f;
        float fG3 = 0.0f;
        float fG4 = 0.0f;
        int iH = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zF = true;
        while (cVar.E()) {
            switch (cVar.o0(f12196b)) {
                case 0:
                    strQ = cVar.Q();
                    break;
                case 1:
                    strQ2 = cVar.Q();
                    break;
                case 2:
                    fG = (float) cVar.G();
                    break;
                case 3:
                    int iH2 = cVar.H();
                    aVar2 = com.airbnb.lottie.model.b.a.CENTER;
                    if (iH2 <= aVar2.ordinal() && iH2 >= 0) {
                        aVar2 = com.airbnb.lottie.model.b.a.values()[iH2];
                    }
                    break;
                case 4:
                    iH = cVar.H();
                    break;
                case 5:
                    fG2 = (float) cVar.G();
                    break;
                case 6:
                    fG3 = (float) cVar.G();
                    break;
                case 7:
                    iD = p.d(cVar);
                    break;
                case 8:
                    iD2 = p.d(cVar);
                    break;
                case 9:
                    fG4 = (float) cVar.G();
                    break;
                case 10:
                    zF = cVar.F();
                    break;
                default:
                    cVar.p0();
                    cVar.r0();
                    break;
            }
        }
        cVar.u();
        return new com.airbnb.lottie.model.b(strQ, strQ2, fG, aVar2, iH, fG2, fG3, iD, iD2, fG4, zF);
    }
}
