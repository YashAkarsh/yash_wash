package com.airbnb.lottie.parser;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class d0 implements k0<com.airbnb.lottie.value.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f12187a = new d0();

    private d0() {
    }

    @Override // com.airbnb.lottie.parser.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.value.k a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        boolean z7 = cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY;
        if (z7) {
            cVar.e();
        }
        float fG = (float) cVar.G();
        float fG2 = (float) cVar.G();
        while (cVar.E()) {
            cVar.r0();
        }
        if (z7) {
            cVar.r();
        }
        return new com.airbnb.lottie.value.k((fG / 100.0f) * f8, (fG2 / 100.0f) * f8);
    }
}
