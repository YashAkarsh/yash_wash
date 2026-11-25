package com.airbnb.lottie.parser;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e0 implements k0<com.airbnb.lottie.model.content.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f12189a = new e0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.airbnb.lottie.parser.moshi.c.a f12190b = com.airbnb.lottie.parser.moshi.c.a.a("c", "v", "i", "o");

    private e0() {
    }

    @Override // com.airbnb.lottie.parser.k0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.model.content.l a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY) {
            cVar.e();
        }
        cVar.q();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zF = false;
        while (cVar.E()) {
            int iO0 = cVar.o0(f12190b);
            if (iO0 == 0) {
                zF = cVar.F();
            } else if (iO0 == 1) {
                listF = p.f(cVar, f8);
            } else if (iO0 == 2) {
                listF2 = p.f(cVar, f8);
            } else if (iO0 != 3) {
                cVar.p0();
                cVar.r0();
            } else {
                listF3 = p.f(cVar, f8);
            }
        }
        cVar.u();
        if (cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.END_ARRAY) {
            cVar.r();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new com.airbnb.lottie.model.content.l(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i7 = 1; i7 < size; i7++) {
            PointF pointF2 = listF.get(i7);
            int i8 = i7 - 1;
            arrayList.add(new com.airbnb.lottie.model.a(com.airbnb.lottie.utils.i.a(listF.get(i8), listF3.get(i8)), com.airbnb.lottie.utils.i.a(pointF2, listF2.get(i7)), pointF2));
        }
        if (zF) {
            PointF pointF3 = listF.get(0);
            int i9 = size - 1;
            arrayList.add(new com.airbnb.lottie.model.a(com.airbnb.lottie.utils.i.a(listF.get(i9), listF3.get(i9)), com.airbnb.lottie.utils.i.a(pointF3, listF2.get(0)), pointF3));
        }
        return new com.airbnb.lottie.model.content.l(pointF, zF, arrayList);
    }
}
