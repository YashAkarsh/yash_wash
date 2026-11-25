package com.airbnb.lottie.parser;

import android.graphics.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l implements k0<com.airbnb.lottie.model.content.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12205a;

    public l(int i7) {
        this.f12205a = i7;
    }

    private void b(com.airbnb.lottie.model.content.c cVar, List<Float> list) {
        int i7 = this.f12205a * 4;
        if (list.size() <= i7) {
            return;
        }
        int size = (list.size() - i7) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i8 = 0;
        while (i7 < list.size()) {
            if (i7 % 2 == 0) {
                dArr[i8] = list.get(i7).floatValue();
            } else {
                dArr2[i8] = list.get(i7).floatValue();
                i8++;
            }
            i7++;
        }
        for (int i9 = 0; i9 < cVar.c(); i9++) {
            int i10 = cVar.a()[i9];
            cVar.a()[i9] = Color.argb(c(cVar.b()[i9], dArr, dArr2), Color.red(i10), Color.green(i10), Color.blue(i10));
        }
    }

    @c.e0(from = 0, to = 255)
    private int c(double d8, double[] dArr, double[] dArr2) {
        double dI;
        for (int i7 = 1; i7 < dArr.length; i7++) {
            int i8 = i7 - 1;
            double d9 = dArr[i8];
            double d10 = dArr[i7];
            if (d10 >= d8) {
                dI = com.airbnb.lottie.utils.i.i(dArr2[i8], dArr2[i7], (d8 - d9) / (d10 - d9));
                return (int) (dI * 255.0d);
            }
        }
        dI = dArr2[dArr2.length - 1];
        return (int) (dI * 255.0d);
    }

    @Override // com.airbnb.lottie.parser.k0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.model.content.c a(com.airbnb.lottie.parser.moshi.c cVar, float f8) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z7 = cVar.h0() == com.airbnb.lottie.parser.moshi.c.b.BEGIN_ARRAY;
        if (z7) {
            cVar.e();
        }
        while (cVar.E()) {
            arrayList.add(Float.valueOf((float) cVar.G()));
        }
        if (z7) {
            cVar.r();
        }
        if (this.f12205a == -1) {
            this.f12205a = arrayList.size() / 4;
        }
        int i7 = this.f12205a;
        float[] fArr = new float[i7];
        int[] iArr = new int[i7];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < this.f12205a * 4; i10++) {
            int i11 = i10 / 4;
            double dFloatValue = arrayList.get(i10).floatValue();
            int i12 = i10 % 4;
            if (i12 == 0) {
                fArr[i11] = (float) dFloatValue;
            } else if (i12 == 1) {
                i8 = (int) (dFloatValue * 255.0d);
            } else if (i12 == 2) {
                i9 = (int) (dFloatValue * 255.0d);
            } else if (i12 == 3) {
                iArr[i11] = Color.argb(255, i8, i9, (int) (dFloatValue * 255.0d));
            }
        }
        com.airbnb.lottie.model.content.c cVar2 = new com.airbnb.lottie.model.content.c(fArr, iArr);
        b(cVar2, arrayList);
        return cVar2;
    }
}
