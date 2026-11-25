package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class n implements Comparable<n> {
    public static final String D = "MotionPaths";
    public static final boolean E = false;
    static final int F = 1;
    static final int G = 2;
    static String[] H = {"position", "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4114c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.d f4127p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f4129r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f4130s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f4131t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f4132u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f4133v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4112a = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4113b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4115d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4116e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4117f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f4118g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f4119h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f4120i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f4121j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f4122k = Float.NaN;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f4123l = Float.NaN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f4124m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f4125n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f4126o = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f4128q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f4134w = Float.NaN;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4135x = Float.NaN;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4136y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    LinkedHashMap<String, androidx.constraintlayout.widget.a> f4137z = new LinkedHashMap<>();
    int A = 0;
    double[] B = new double[18];
    double[] C = new double[18];

    private boolean e(float a8, float b8) {
        if (Float.isNaN(a8) || Float.isNaN(b8)) {
            return Float.isNaN(a8) != Float.isNaN(b8);
        }
        return Math.abs(a8 - b8) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap<String, androidx.constraintlayout.motion.utils.d> splines, int mFramePosition) {
        for (String str : splines.keySet()) {
            androidx.constraintlayout.motion.utils.d dVar = splines.get(str);
            str.hashCode();
            byte b8 = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b8 = 0;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b8 = 1;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b8 = 2;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b8 = 3;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b8 = 4;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        b8 = 5;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b8 = 6;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b8 = 7;
                    }
                    break;
                case -760884510:
                    if (str.equals(f.f3957l)) {
                        b8 = 8;
                    }
                    break;
                case -760884509:
                    if (str.equals(f.f3958m)) {
                        b8 = 9;
                    }
                    break;
                case -40300674:
                    if (str.equals(f.f3954i)) {
                        b8 = 10;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        b8 = com.google.common.base.c.f19313m;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        b8 = com.google.common.base.c.f19314n;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b8 = com.google.common.base.c.f19315o;
                    }
                    break;
            }
            switch (b8) {
                case 0:
                    dVar.g(mFramePosition, Float.isNaN(this.f4118g) ? 0.0f : this.f4118g);
                    break;
                case 1:
                    dVar.g(mFramePosition, Float.isNaN(this.f4119h) ? 0.0f : this.f4119h);
                    break;
                case 2:
                    dVar.g(mFramePosition, Float.isNaN(this.f4124m) ? 0.0f : this.f4124m);
                    break;
                case 3:
                    dVar.g(mFramePosition, Float.isNaN(this.f4125n) ? 0.0f : this.f4125n);
                    break;
                case 4:
                    dVar.g(mFramePosition, Float.isNaN(this.f4126o) ? 0.0f : this.f4126o);
                    break;
                case 5:
                    dVar.g(mFramePosition, Float.isNaN(this.f4135x) ? 0.0f : this.f4135x);
                    break;
                case 6:
                    dVar.g(mFramePosition, Float.isNaN(this.f4120i) ? 1.0f : this.f4120i);
                    break;
                case 7:
                    dVar.g(mFramePosition, Float.isNaN(this.f4121j) ? 1.0f : this.f4121j);
                    break;
                case 8:
                    dVar.g(mFramePosition, Float.isNaN(this.f4122k) ? 0.0f : this.f4122k);
                    break;
                case 9:
                    dVar.g(mFramePosition, Float.isNaN(this.f4123l) ? 0.0f : this.f4123l);
                    break;
                case 10:
                    dVar.g(mFramePosition, Float.isNaN(this.f4117f) ? 0.0f : this.f4117f);
                    break;
                case 11:
                    dVar.g(mFramePosition, Float.isNaN(this.f4116e) ? 0.0f : this.f4116e);
                    break;
                case 12:
                    dVar.g(mFramePosition, Float.isNaN(this.f4134w) ? 0.0f : this.f4134w);
                    break;
                case 13:
                    dVar.g(mFramePosition, Float.isNaN(this.f4112a) ? 1.0f : this.f4112a);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.f4137z.containsKey(str2)) {
                            androidx.constraintlayout.widget.a aVar = this.f4137z.get(str2);
                            if (dVar instanceof androidx.constraintlayout.motion.utils.d.b) {
                                ((androidx.constraintlayout.motion.utils.d.b) dVar).n(mFramePosition, aVar);
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + mFramePosition + ", value" + aVar.k() + dVar);
                            }
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    public void b(View view) {
        this.f4114c = view.getVisibility();
        this.f4112a = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f4115d = false;
        this.f4116e = view.getElevation();
        this.f4117f = view.getRotation();
        this.f4118g = view.getRotationX();
        this.f4119h = view.getRotationY();
        this.f4120i = view.getScaleX();
        this.f4121j = view.getScaleY();
        this.f4122k = view.getPivotX();
        this.f4123l = view.getPivotY();
        this.f4124m = view.getTranslationX();
        this.f4125n = view.getTranslationY();
        this.f4126o = view.getTranslationZ();
    }

    public void c(androidx.constraintlayout.widget.d.a c8) {
        androidx.constraintlayout.widget.d.C0049d c0049d = c8.f4767c;
        int i7 = c0049d.f4896c;
        this.f4113b = i7;
        int i8 = c0049d.f4895b;
        this.f4114c = i8;
        this.f4112a = (i8 == 0 || i7 != 0) ? c0049d.f4897d : 0.0f;
        androidx.constraintlayout.widget.d.e eVar = c8.f4770f;
        this.f4115d = eVar.f4923m;
        this.f4116e = eVar.f4924n;
        this.f4117f = eVar.f4912b;
        this.f4118g = eVar.f4913c;
        this.f4119h = eVar.f4914d;
        this.f4120i = eVar.f4915e;
        this.f4121j = eVar.f4916f;
        this.f4122k = eVar.f4917g;
        this.f4123l = eVar.f4918h;
        this.f4124m = eVar.f4920j;
        this.f4125n = eVar.f4921k;
        this.f4126o = eVar.f4922l;
        this.f4127p = androidx.constraintlayout.core.motion.utils.d.c(c8.f4768d.f4883d);
        androidx.constraintlayout.widget.d.c cVar = c8.f4768d;
        this.f4134w = cVar.f4888i;
        this.f4128q = cVar.f4885f;
        this.f4136y = cVar.f4881b;
        this.f4135x = c8.f4767c.f4898e;
        for (String str : c8.f4771g.keySet()) {
            androidx.constraintlayout.widget.a aVar = c8.f4771g.get(str);
            if (aVar.n()) {
                this.f4137z.put(str, aVar);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(n o7) {
        return Float.compare(this.f4129r, o7.f4129r);
    }

    void f(n points, HashSet<String> keySet) {
        if (e(this.f4112a, points.f4112a)) {
            keySet.add("alpha");
        }
        if (e(this.f4116e, points.f4116e)) {
            keySet.add("elevation");
        }
        int i7 = this.f4114c;
        int i8 = points.f4114c;
        if (i7 != i8 && this.f4113b == 0 && (i7 == 0 || i8 == 0)) {
            keySet.add("alpha");
        }
        if (e(this.f4117f, points.f4117f)) {
            keySet.add(f.f3954i);
        }
        if (!Float.isNaN(this.f4134w) || !Float.isNaN(points.f4134w)) {
            keySet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f4135x) || !Float.isNaN(points.f4135x)) {
            keySet.add("progress");
        }
        if (e(this.f4118g, points.f4118g)) {
            keySet.add("rotationX");
        }
        if (e(this.f4119h, points.f4119h)) {
            keySet.add("rotationY");
        }
        if (e(this.f4122k, points.f4122k)) {
            keySet.add(f.f3957l);
        }
        if (e(this.f4123l, points.f4123l)) {
            keySet.add(f.f3958m);
        }
        if (e(this.f4120i, points.f4120i)) {
            keySet.add("scaleX");
        }
        if (e(this.f4121j, points.f4121j)) {
            keySet.add("scaleY");
        }
        if (e(this.f4124m, points.f4124m)) {
            keySet.add("translationX");
        }
        if (e(this.f4125n, points.f4125n)) {
            keySet.add("translationY");
        }
        if (e(this.f4126o, points.f4126o)) {
            keySet.add("translationZ");
        }
    }

    void g(n points, boolean[] mask, String[] custom) {
        mask[0] = mask[0] | e(this.f4129r, points.f4129r);
        mask[1] = mask[1] | e(this.f4130s, points.f4130s);
        mask[2] = mask[2] | e(this.f4131t, points.f4131t);
        mask[3] = mask[3] | e(this.f4132u, points.f4132u);
        mask[4] = e(this.f4133v, points.f4133v) | mask[4];
    }

    void h(double[] data, int[] toUse) {
        float[] fArr = {this.f4129r, this.f4130s, this.f4131t, this.f4132u, this.f4133v, this.f4112a, this.f4116e, this.f4117f, this.f4118g, this.f4119h, this.f4120i, this.f4121j, this.f4122k, this.f4123l, this.f4124m, this.f4125n, this.f4126o, this.f4134w};
        int i7 = 0;
        for (int i8 : toUse) {
            if (i8 < 18) {
                data[i7] = fArr[i8];
                i7++;
            }
        }
    }

    int i(String name, double[] value, int offset) {
        androidx.constraintlayout.widget.a aVar = this.f4137z.get(name);
        if (aVar.p() == 1) {
            value[offset] = aVar.k();
            return 1;
        }
        int iP = aVar.p();
        float[] fArr = new float[iP];
        aVar.l(fArr);
        int i7 = 0;
        while (i7 < iP) {
            value[offset] = fArr[i7];
            i7++;
            offset++;
        }
        return iP;
    }

    int j(String name) {
        return this.f4137z.get(name).p();
    }

    boolean k(String name) {
        return this.f4137z.containsKey(name);
    }

    void l(float x7, float y7, float w7, float h7) {
        this.f4130s = x7;
        this.f4131t = y7;
        this.f4132u = w7;
        this.f4133v = h7;
    }

    public void m(Rect rect, View view, int rotation, float prevous) {
        l(rect.left, rect.top, rect.width(), rect.height());
        b(view);
        this.f4122k = Float.NaN;
        this.f4123l = Float.NaN;
        if (rotation == 1) {
            this.f4117f = prevous - 90.0f;
        } else {
            if (rotation != 2) {
                return;
            }
            this.f4117f = prevous + 90.0f;
        }
    }

    public void n(Rect cw, androidx.constraintlayout.widget.d constraintSet, int rotation, int viewId) {
        l(cw.left, cw.top, cw.width(), cw.height());
        c(constraintSet.q0(viewId));
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    if (rotation != 4) {
                        return;
                    }
                }
            }
            float f8 = this.f4117f + 90.0f;
            this.f4117f = f8;
            if (f8 > 180.0f) {
                this.f4117f = f8 - 360.0f;
                return;
            }
            return;
        }
        this.f4117f -= 90.0f;
    }

    public void o(View view) {
        l(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        b(view);
    }
}
