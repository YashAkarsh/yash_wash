package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f16856a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f16857b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f16858c = new Matrix();

    @Override // android.animation.TypeEvaluator
    @m0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f8, @m0 Matrix matrix, @m0 Matrix matrix2) {
        matrix.getValues(this.f16856a);
        matrix2.getValues(this.f16857b);
        for (int i7 = 0; i7 < 9; i7++) {
            float[] fArr = this.f16857b;
            float f9 = fArr[i7];
            float f10 = this.f16856a[i7];
            fArr[i7] = f10 + ((f9 - f10) * f8);
        }
        this.f16858c.setValues(this.f16857b);
        return this.f16858c;
    }
}
