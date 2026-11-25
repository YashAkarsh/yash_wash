package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class a implements Interpolator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f6539c = 0.002f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f6540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f6541b;

    a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i7 = ((int) (length / 0.002f)) + 1;
        this.f6540a = new float[i7];
        this.f6541b = new float[i7];
        float[] fArr = new float[2];
        for (int i8 = 0; i8 < i7; i8++) {
            pathMeasure.getPosTan((i8 * length) / (i7 - 1), fArr, null);
            this.f6540a[i8] = fArr[0];
            this.f6541b[i8] = fArr[1];
        }
    }

    private static Path a(float f8, float f9, float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f8, f9, f10, f11, 1.0f, 1.0f);
        return path;
    }

    private static Path b(float f8, float f9) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f8, f9, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f8) {
        if (f8 <= 0.0f) {
            return 0.0f;
        }
        if (f8 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f6540a.length - 1;
        int i7 = 0;
        while (length - i7 > 1) {
            int i8 = (i7 + length) / 2;
            if (f8 < this.f6540a[i8]) {
                length = i8;
            } else {
                i7 = i8;
            }
        }
        float[] fArr = this.f6540a;
        float f9 = fArr[length];
        float f10 = fArr[i7];
        float f11 = f9 - f10;
        if (f11 == 0.0f) {
            return this.f6541b[i7];
        }
        float f12 = (f8 - f10) / f11;
        float[] fArr2 = this.f6541b;
        float f13 = fArr2[i7];
        return f13 + (f12 * (fArr2[length] - f13));
    }

    a(float f8, float f9) {
        this(b(f8, f9));
    }

    a(float f8, float f9, float f10, float f11) {
        this(a(f8, f9, f10, f11));
    }
}
