package com.airbnb.lottie.parser;

import android.graphics.PointF;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class z implements k0<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f12309a = new z();

    private z() {
    }

    @Override // com.airbnb.lottie.parser.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        com.airbnb.lottie.parser.moshi.c.b bVarH0 = cVar.h0();
        if (bVarH0 == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY) {
            return p.e(cVar, f8);
        }
        if (bVarH0 == com.airbnb.lottie.parser.moshi.c.b.BEGIN_OBJECT) {
            return p.e(cVar, f8);
        }
        if (bVarH0 == com.airbnb.lottie.parser.moshi.c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.G()) * f8, ((float) cVar.G()) * f8);
            while (cVar.E()) {
                cVar.r0();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarH0);
    }
}
