package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class a1 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a1 f13018a = new a1();

    @Override // com.alibaba.fastjson.serializer.y0
    public final void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.Z1(k1.WriteNullListAsEmpty);
            return;
        }
        int i8 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            j1Var.write(91);
            while (i8 < iArr.length) {
                if (i8 != 0) {
                    j1Var.write(44);
                }
                j1Var.N1(iArr[i8]);
                i8++;
            }
            j1Var.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            j1Var.write(91);
            while (i8 < sArr.length) {
                if (i8 != 0) {
                    j1Var.write(44);
                }
                j1Var.N1(sArr[i8]);
                i8++;
            }
            j1Var.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            j1Var.write(91);
            while (i8 < jArr.length) {
                if (i8 != 0) {
                    j1Var.write(44);
                }
                j1Var.W1(jArr[i8]);
                i8++;
            }
            j1Var.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            j1Var.write(91);
            while (i8 < zArr.length) {
                if (i8 != 0) {
                    j1Var.write(44);
                }
                j1Var.s0(zArr[i8]);
                i8++;
            }
            j1Var.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            j1Var.write(91);
            while (i8 < fArr.length) {
                if (i8 != 0) {
                    j1Var.write(44);
                }
                float f8 = fArr[i8];
                if (Float.isNaN(f8)) {
                    j1Var.X1();
                } else {
                    j1Var.append(Float.toString(f8));
                }
                i8++;
            }
            j1Var.write(93);
            return;
        }
        if (!(obj instanceof double[])) {
            if (obj instanceof byte[]) {
                j1Var.v0((byte[]) obj);
                return;
            } else {
                j1Var.c2((char[]) obj);
                return;
            }
        }
        double[] dArr = (double[]) obj;
        j1Var.write(91);
        while (i8 < dArr.length) {
            if (i8 != 0) {
                j1Var.write(44);
            }
            double d8 = dArr[i8];
            if (Double.isNaN(d8)) {
                j1Var.X1();
            } else {
                j1Var.append(Double.toString(d8));
            }
            i8++;
        }
        j1Var.write(93);
    }
}
