package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ArcMotion extends PathMotion {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f10541g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f10542h = 70.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f10543i = (float) Math.tan(Math.toRadians(35.0d));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f10544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f10545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f10546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f10547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f10548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f10549f;

    public ArcMotion() {
        this.f10544a = 0.0f;
        this.f10545b = 0.0f;
        this.f10546c = f10542h;
        this.f10547d = 0.0f;
        this.f10548e = 0.0f;
        this.f10549f = f10543i;
    }

    private static float h(float f8) {
        if (f8 < 0.0f || f8 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f8 / 2.0f));
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f8, float f9, float f10, float f11) {
        float f12;
        float f13;
        float f14;
        Path path = new Path();
        path.moveTo(f8, f9);
        float f15 = f10 - f8;
        float f16 = f11 - f9;
        float f17 = (f15 * f15) + (f16 * f16);
        float f18 = (f8 + f10) / 2.0f;
        float f19 = (f9 + f11) / 2.0f;
        float f20 = 0.25f * f17;
        boolean z7 = f9 > f11;
        if (Math.abs(f15) < Math.abs(f16)) {
            float fAbs = Math.abs(f17 / (f16 * 2.0f));
            if (z7) {
                f13 = fAbs + f11;
                f12 = f10;
            } else {
                f13 = fAbs + f9;
                f12 = f8;
            }
            f14 = this.f10548e;
        } else {
            float f21 = f17 / (f15 * 2.0f);
            if (z7) {
                f13 = f9;
                f12 = f21 + f8;
            } else {
                f12 = f10 - f21;
                f13 = f11;
            }
            f14 = this.f10547d;
        }
        float f22 = f20 * f14 * f14;
        float f23 = f18 - f12;
        float f24 = f19 - f13;
        float f25 = (f23 * f23) + (f24 * f24);
        float f26 = this.f10549f;
        float f27 = f20 * f26 * f26;
        if (f25 >= f22) {
            f22 = f25 > f27 ? f27 : 0.0f;
        }
        if (f22 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f22 / f25);
            f12 = ((f12 - f18) * fSqrt) + f18;
            f13 = f19 + (fSqrt * (f13 - f19));
        }
        path.cubicTo((f8 + f12) / 2.0f, (f9 + f13) / 2.0f, (f12 + f10) / 2.0f, (f13 + f11) / 2.0f, f10, f11);
        return path;
    }

    public float b() {
        return this.f10546c;
    }

    public float c() {
        return this.f10544a;
    }

    public float d() {
        return this.f10545b;
    }

    public void e(float f8) {
        this.f10546c = f8;
        this.f10549f = h(f8);
    }

    public void f(float f8) {
        this.f10544a = f8;
        this.f10547d = h(f8);
    }

    public void g(float f8) {
        this.f10545b = f8;
        this.f10548e = h(f8);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10544a = 0.0f;
        this.f10545b = 0.0f;
        this.f10546c = f10542h;
        this.f10547d = 0.0f;
        this.f10548e = 0.0f;
        this.f10549f = f10543i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10791j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        g(androidx.core.content.res.q.j(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        f(androidx.core.content.res.q.j(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        e(androidx.core.content.res.q.j(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, f10542h));
        typedArrayObtainStyledAttributes.recycle();
    }
}
