package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.graphics.g2;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f10606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f10607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f10608c;

    public PatternPathMotion() {
        Path path = new Path();
        this.f10607b = path;
        this.f10608c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f10606a = path;
    }

    private static float b(float f8, float f9) {
        return (float) Math.sqrt((f8 * f8) + (f9 * f9));
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f8, float f9, float f10, float f11) {
        float f12 = f10 - f8;
        float f13 = f11 - f9;
        float fB = b(f12, f13);
        double dAtan2 = Math.atan2(f13, f12);
        this.f10608c.setScale(fB, fB);
        this.f10608c.postRotate((float) Math.toDegrees(dAtan2));
        this.f10608c.postTranslate(f8, f9);
        Path path = new Path();
        this.f10607b.transform(this.f10608c, path);
        return path;
    }

    public Path c() {
        return this.f10606a;
    }

    public void d(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f8 = fArr[0];
        float f9 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f10 = fArr[0];
        float f11 = fArr[1];
        if (f10 == f8 && f11 == f9) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f10608c.setTranslate(-f10, -f11);
        float f12 = f8 - f10;
        float f13 = f9 - f11;
        float fB = 1.0f / b(f12, f13);
        this.f10608c.postScale(fB, fB);
        this.f10608c.postRotate((float) Math.toDegrees(-Math.atan2(f13, f12)));
        path.transform(this.f10608c, this.f10607b);
        this.f10606a = path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f10607b = new Path();
        this.f10608c = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10792k);
        try {
            String strM = androidx.core.content.res.q.m(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strM != null) {
                d(g2.e(strM));
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public PatternPathMotion(Path path) {
        this.f10607b = new Path();
        this.f10608c = new Matrix();
        d(path);
    }
}
