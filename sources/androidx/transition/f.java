package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
class f implements TypeEvaluator<float[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f10692a;

    f(float[] fArr) {
        this.f10692a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f8, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f10692a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i7 = 0; i7 < fArr3.length; i7++) {
            float f9 = fArr[i7];
            fArr3[i7] = f9 + ((fArr2[i7] - f9) * f8);
        }
        return fArr3;
    }
}
