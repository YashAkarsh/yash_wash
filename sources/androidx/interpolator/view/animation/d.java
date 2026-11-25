package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f8178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f8179b;

    protected d(float[] fArr) {
        this.f8178a = fArr;
        this.f8179b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f8) {
        if (f8 >= 1.0f) {
            return 1.0f;
        }
        if (f8 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f8178a;
        int iMin = Math.min((int) ((fArr.length - 1) * f8), fArr.length - 2);
        float f9 = this.f8179b;
        float f10 = (f8 - (iMin * f9)) / f9;
        float[] fArr2 = this.f8178a;
        float f11 = fArr2[iMin];
        return f11 + (f10 * (fArr2[iMin + 1] - f11));
    }
}
