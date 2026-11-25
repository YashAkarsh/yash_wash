package com.facebook.appevents.ml;

/* JADX INFO: loaded from: classes.dex */
final class Operator {
    Operator() {
    }

    static float[] add(float[] fArr, float[] fArr2, int i7, int i8, int i9) {
        for (int i10 = 0; i10 < i7 * i8; i10++) {
            for (int i11 = 0; i11 < i9; i11++) {
                int i12 = (i10 * i9) + i11;
                fArr[i12] = fArr[i12] + fArr2[i11];
            }
        }
        return fArr;
    }

    static float[] concatenate(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[fArr.length + fArr2.length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    static float[] conv1D(float[] fArr, float[] fArr2, int i7, int i8, int i9, int i10, int i11) {
        int i12 = (i8 - i10) + 1;
        float[] fArr3 = new float[i7 * i12 * i11];
        for (int i13 = 0; i13 < i7; i13++) {
            for (int i14 = 0; i14 < i11; i14++) {
                for (int i15 = 0; i15 < i12; i15++) {
                    float f8 = 0.0f;
                    for (int i16 = 0; i16 < i10; i16++) {
                        for (int i17 = 0; i17 < i9; i17++) {
                            f8 += fArr[(i8 * i9 * i13) + ((i16 + i15) * i9) + i17] * fArr2[(((i16 * i9) + i17) * i11) + i14];
                        }
                    }
                    fArr3[(i11 * i12 * i13) + (i15 * i11) + i14] = f8;
                }
            }
        }
        return fArr3;
    }

    static float[] dense(float[] fArr, float[] fArr2, float[] fArr3, int i7, int i8, int i9) {
        float[] fArrMul = mul(fArr, fArr2, i7, i8, i9);
        for (int i10 = 0; i10 < i7; i10++) {
            for (int i11 = 0; i11 < i9; i11++) {
                int i12 = (i10 * i9) + i11;
                fArrMul[i12] = fArrMul[i12] + fArr3[i11];
            }
        }
        return fArrMul;
    }

    static float[] embedding(int[] iArr, float[] fArr, int i7, int i8, int i9) {
        float[] fArr2 = new float[i7 * i8 * i9];
        for (int i10 = 0; i10 < i7; i10++) {
            for (int i11 = 0; i11 < i8; i11++) {
                int i12 = iArr[(i10 * i8) + i11];
                for (int i13 = 0; i13 < i9; i13++) {
                    fArr2[(i9 * i8 * i10) + (i9 * i11) + i13] = fArr[(i12 * i9) + i13];
                }
            }
        }
        return fArr2;
    }

    static float[] maxPool1D(float[] fArr, int i7, int i8, int i9) {
        int i10 = (i7 - i9) + 1;
        float[] fArr2 = new float[i10 * i8];
        for (int i11 = 0; i11 < i8; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                for (int i13 = i12; i13 < i12 + i9; i13++) {
                    int i14 = (i12 * i8) + i11;
                    fArr2[i14] = Math.max(fArr2[i14], fArr[(i13 * i8) + i11]);
                }
            }
        }
        return fArr2;
    }

    static float[] mul(float[] fArr, float[] fArr2, int i7, int i8, int i9) {
        float[] fArr3 = new float[i7 * i9];
        for (int i10 = 0; i10 < i7; i10++) {
            for (int i11 = 0; i11 < i9; i11++) {
                int i12 = (i10 * i9) + i11;
                fArr3[i12] = 0.0f;
                for (int i13 = 0; i13 < i8; i13++) {
                    fArr3[i12] = fArr3[i12] + (fArr[(i10 * i8) + i13] * fArr2[(i13 * i9) + i11]);
                }
            }
        }
        return fArr3;
    }

    static void relu(float[] fArr, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (fArr[i8] < 0.0f) {
                fArr[i8] = 0.0f;
            }
        }
    }

    static void softmax(float[] fArr, int i7) {
        float f8 = Float.MIN_VALUE;
        for (int i8 = 0; i8 < i7; i8++) {
            float f9 = fArr[i8];
            if (f9 > f8) {
                f8 = f9;
            }
        }
        for (int i9 = 0; i9 < i7; i9++) {
            fArr[i9] = (float) Math.exp(fArr[i9] - f8);
        }
        float f10 = 0.0f;
        for (int i10 = 0; i10 < i7; i10++) {
            f10 += fArr[i10];
        }
        for (int i11 = 0; i11 < i7; i11++) {
            fArr[i11] = fArr[i11] / f10;
        }
    }

    static float[] transpose2D(float[] fArr, int i7, int i8) {
        float[] fArr2 = new float[i7 * i8];
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i8; i10++) {
                fArr2[(i10 * i7) + i9] = fArr[(i9 * i8) + i10];
            }
        }
        return fArr2;
    }

    static float[] transpose3D(float[] fArr, int i7, int i8, int i9) {
        float[] fArr2 = new float[i7 * i8 * i9];
        for (int i10 = 0; i10 < i7; i10++) {
            for (int i11 = 0; i11 < i8; i11++) {
                for (int i12 = 0; i12 < i9; i12++) {
                    fArr2[(i12 * i7 * i8) + (i11 * i7) + i10] = fArr[(i10 * i8 * i9) + (i11 * i9) + i12];
                }
            }
        }
        return fArr2;
    }
}
