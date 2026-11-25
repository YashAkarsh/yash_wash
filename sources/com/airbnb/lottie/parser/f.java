package com.airbnb.lottie.parser;

import android.graphics.Color;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class f implements k0<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12191a = new f();

    private f() {
    }

    @Override // com.airbnb.lottie.parser.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        boolean z7 = cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY;
        if (z7) {
            cVar.e();
        }
        double dG = cVar.G();
        double dG2 = cVar.G();
        double dG3 = cVar.G();
        double dG4 = cVar.G();
        if (z7) {
            cVar.r();
        }
        if (dG <= 1.0d && dG2 <= 1.0d && dG3 <= 1.0d) {
            dG *= 255.0d;
            dG2 *= 255.0d;
            dG3 *= 255.0d;
            if (dG4 <= 1.0d) {
                dG4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dG4, (int) dG, (int) dG2, (int) dG3));
    }
}
