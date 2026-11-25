package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.res.q;
import androidx.core.graphics.g2;
import c.x0;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class g implements Interpolator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f10919c = 0.002f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10920d = 3000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double f10921e = 1.0E-5d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f10922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f10923b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(float f8, float f9, float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f8, f9, f10, f11, 1.0f, 1.0f);
        b(path);
    }

    private void b(Path path) {
        int i7 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f10922a = new float[iMin];
        this.f10923b = new float[iMin];
        float[] fArr = new float[2];
        for (int i8 = 0; i8 < iMin; i8++) {
            pathMeasure.getPosTan((i8 * length) / (iMin - 1), fArr, null);
            this.f10922a[i8] = fArr[0];
            this.f10923b[i8] = fArr[1];
        }
        if (Math.abs(this.f10922a[0]) <= 1.0E-5d && Math.abs(this.f10923b[0]) <= 1.0E-5d) {
            int i9 = iMin - 1;
            if (Math.abs(this.f10922a[i9] - 1.0f) <= 1.0E-5d && Math.abs(this.f10923b[i9] - 1.0f) <= 1.0E-5d) {
                float f8 = 0.0f;
                int i10 = 0;
                while (i7 < iMin) {
                    float[] fArr2 = this.f10922a;
                    int i11 = i10 + 1;
                    float f9 = fArr2[i10];
                    if (f9 < f8) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f9);
                    }
                    fArr2[i7] = f9;
                    i7++;
                    f8 = f9;
                    i10 = i11;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f10922a[0]);
        sb.append(",");
        sb.append(this.f10923b[0]);
        sb.append(" end:");
        int i12 = iMin - 1;
        sb.append(this.f10922a[i12]);
        sb.append(",");
        sb.append(this.f10923b[i12]);
        throw new IllegalArgumentException(sb.toString());
    }

    private void c(float f8, float f9) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f8, f9, 1.0f, 1.0f);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (q.r(xmlPullParser, "pathData")) {
            String strM = q.m(typedArray, xmlPullParser, "pathData", 4);
            Path pathE = g2.e(strM);
            if (pathE != null) {
                b(pathE);
                return;
            }
            throw new InflateException("The path is null, which is created from " + strM);
        }
        if (!q.r(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!q.r(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fJ = q.j(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float fJ2 = q.j(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zR = q.r(xmlPullParser, "controlX2");
        if (zR != q.r(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zR) {
            a(fJ, fJ2, q.j(typedArray, xmlPullParser, "controlX2", 2, 0.0f), q.j(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            c(fJ, fJ2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f8) {
        if (f8 <= 0.0f) {
            return 0.0f;
        }
        if (f8 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f10922a.length - 1;
        int i7 = 0;
        while (length - i7 > 1) {
            int i8 = (i7 + length) / 2;
            if (f8 < this.f10922a[i8]) {
                length = i8;
            } else {
                i7 = i8;
            }
        }
        float[] fArr = this.f10922a;
        float f9 = fArr[length];
        float f10 = fArr[i7];
        float f11 = f9 - f10;
        if (f11 == 0.0f) {
            return this.f10923b[i7];
        }
        float f12 = (f8 - f10) / f11;
        float[] fArr2 = this.f10923b;
        float f13 = fArr2[i7];
        return f13 + (f12 * (fArr2[length] - f13));
    }

    public g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, a.f10870r0);
        d(typedArrayS, xmlPullParser);
        typedArrayS.recycle();
    }
}
