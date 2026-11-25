package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class l extends f {
    static final String V = "KeyTimeCycle";
    private static final String W = "KeyTimeCycle";
    public static final String X = "wavePeriod";
    public static final String Y = "waveOffset";
    public static final String Z = "waveShape";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f4055a0 = 0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f4056b0 = 1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f4057c0 = 2;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f4058d0 = 3;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f4059e0 = 4;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f4060f0 = 5;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f4061g0 = 6;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f4062h0 = 3;
    private String D;
    private int E = -1;
    private float F = Float.NaN;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f4063J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private float P = Float.NaN;
    private float Q = Float.NaN;
    private int R = 0;
    private String S = null;
    private float T = Float.NaN;
    private float U = 0.0f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f4064a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f4065b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f4066c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f4067d = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f4068e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f4069f = 8;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f4070g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f4071h = 9;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f4072i = 10;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f4073j = 12;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f4074k = 13;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f4075l = 14;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f4076m = 15;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int f4077n = 16;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final int f4078o = 17;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f4079p = 18;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final int f4080q = 19;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final int f4081r = 20;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final int f4082s = 21;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static SparseIntArray f4083t;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4083t = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            f4083t.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            f4083t.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            f4083t.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            f4083t.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            f4083t.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            f4083t.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            f4083t.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            f4083t.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            f4083t.append(R.styleable.KeyTimeCycle_framePosition, 12);
            f4083t.append(R.styleable.KeyTimeCycle_curveFit, 13);
            f4083t.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            f4083t.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            f4083t.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            f4083t.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            f4083t.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            f4083t.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            f4083t.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            f4083t.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        private a() {
        }

        public static void a(l c8, TypedArray a8) {
            int indexCount = a8.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = a8.getIndex(i7);
                switch (f4083t.get(index)) {
                    case 1:
                        c8.F = a8.getFloat(index, c8.F);
                        break;
                    case 2:
                        c8.G = a8.getDimension(index, c8.G);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4083t.get(index));
                        break;
                    case 4:
                        c8.H = a8.getFloat(index, c8.H);
                        break;
                    case 5:
                        c8.I = a8.getFloat(index, c8.I);
                        break;
                    case 6:
                        c8.f4063J = a8.getFloat(index, c8.f4063J);
                        break;
                    case 7:
                        c8.L = a8.getFloat(index, c8.L);
                        break;
                    case 8:
                        c8.K = a8.getFloat(index, c8.K);
                        break;
                    case 9:
                        c8.D = a8.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.W1) {
                            int resourceId = a8.getResourceId(index, c8.f3973b);
                            c8.f3973b = resourceId;
                            if (resourceId == -1) {
                                c8.f3974c = a8.getString(index);
                            }
                        } else if (a8.peekValue(index).type == 3) {
                            c8.f3974c = a8.getString(index);
                        } else {
                            c8.f3973b = a8.getResourceId(index, c8.f3973b);
                        }
                        break;
                    case 12:
                        c8.f3972a = a8.getInt(index, c8.f3972a);
                        break;
                    case 13:
                        c8.E = a8.getInteger(index, c8.E);
                        break;
                    case 14:
                        c8.M = a8.getFloat(index, c8.M);
                        break;
                    case 15:
                        c8.N = a8.getDimension(index, c8.N);
                        break;
                    case 16:
                        c8.O = a8.getDimension(index, c8.O);
                        break;
                    case 17:
                        c8.P = a8.getDimension(index, c8.P);
                        break;
                    case 18:
                        c8.Q = a8.getFloat(index, c8.Q);
                        break;
                    case 19:
                        if (a8.peekValue(index).type == 3) {
                            c8.S = a8.getString(index);
                            c8.R = 7;
                        } else {
                            c8.R = a8.getInt(index, c8.R);
                        }
                        break;
                    case 20:
                        c8.T = a8.getFloat(index, c8.T);
                        break;
                    case 21:
                        if (a8.peekValue(index).type == 5) {
                            c8.U = a8.getDimension(index, c8.U);
                        } else {
                            c8.U = a8.getFloat(index, c8.U);
                        }
                        break;
                }
            }
        }
    }

    public l() {
        this.f3975d = 3;
        this.f3976e = new HashMap<>();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void W(HashMap<String, androidx.constraintlayout.motion.utils.f> splines) {
        for (String str : splines.keySet()) {
            androidx.constraintlayout.motion.utils.f fVar = splines.get(str);
            if (fVar != null) {
                byte b8 = 7;
                if (!str.startsWith("CUSTOM")) {
                    switch (str.hashCode()) {
                        case -1249320806:
                            b8 = str.equals("rotationX") ? (byte) 0 : (byte) -1;
                            break;
                        case -1249320805:
                            b8 = str.equals("rotationY") ? (byte) 1 : (byte) -1;
                            break;
                        case -1225497657:
                            b8 = str.equals("translationX") ? (byte) 2 : (byte) -1;
                            break;
                        case -1225497656:
                            b8 = str.equals("translationY") ? (byte) 3 : (byte) -1;
                            break;
                        case -1225497655:
                            b8 = str.equals("translationZ") ? (byte) 4 : (byte) -1;
                            break;
                        case -1001078227:
                            b8 = str.equals("progress") ? (byte) 5 : (byte) -1;
                            break;
                        case -908189618:
                            b8 = str.equals("scaleX") ? (byte) 6 : (byte) -1;
                            break;
                        case -908189617:
                            if (!str.equals("scaleY")) {
                                b8 = -1;
                            }
                            break;
                        case -40300674:
                            b8 = str.equals(f.f3954i) ? (byte) 8 : (byte) -1;
                            break;
                        case -4379043:
                            b8 = str.equals("elevation") ? (byte) 9 : (byte) -1;
                            break;
                        case 37232917:
                            b8 = str.equals("transitionPathRotate") ? (byte) 10 : (byte) -1;
                            break;
                        case 92909918:
                            b8 = str.equals("alpha") ? com.google.common.base.c.f19313m : (byte) -1;
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    switch (b8) {
                        case 0:
                            if (!Float.isNaN(this.I)) {
                                fVar.c(this.f3972a, this.I, this.T, this.R, this.U);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.f4063J)) {
                                fVar.c(this.f3972a, this.f4063J, this.T, this.R, this.U);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.N)) {
                                fVar.c(this.f3972a, this.N, this.T, this.R, this.U);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.O)) {
                                fVar.c(this.f3972a, this.O, this.T, this.R, this.U);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.P)) {
                                fVar.c(this.f3972a, this.P, this.T, this.R, this.U);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.Q)) {
                                fVar.c(this.f3972a, this.Q, this.T, this.R, this.U);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.L)) {
                                fVar.c(this.f3972a, this.L, this.T, this.R, this.U);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.M)) {
                                fVar.c(this.f3972a, this.M, this.T, this.R, this.U);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.H)) {
                                fVar.c(this.f3972a, this.H, this.T, this.R, this.U);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.G)) {
                                fVar.c(this.f3972a, this.G, this.T, this.R, this.U);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.K)) {
                                fVar.c(this.f3972a, this.K, this.T, this.R, this.U);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.F)) {
                                fVar.c(this.f3972a, this.F, this.T, this.R, this.U);
                            }
                            break;
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    androidx.constraintlayout.widget.a aVar = this.f3976e.get(str.substring(7));
                    if (aVar != null) {
                        ((androidx.constraintlayout.motion.utils.f.b) fVar).k(this.f3972a, aVar, this.T, this.R, this.U);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, androidx.constraintlayout.motion.utils.d> splines) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new l().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        l lVar = (l) src;
        this.D = lVar.D;
        this.E = lVar.E;
        this.R = lVar.R;
        this.T = lVar.T;
        this.U = lVar.U;
        this.Q = lVar.Q;
        this.F = lVar.F;
        this.G = lVar.G;
        this.H = lVar.H;
        this.K = lVar.K;
        this.I = lVar.I;
        this.f4063J = lVar.f4063J;
        this.L = lVar.L;
        this.M = lVar.M;
        this.N = lVar.N;
        this.O = lVar.O;
        this.P = lVar.P;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
        if (!Float.isNaN(this.F)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.G)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.H)) {
            attributes.add(f.f3954i);
        }
        if (!Float.isNaN(this.I)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.f4063J)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.N)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.O)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.P)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.K)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.L)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.M)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.Q)) {
            attributes.add("progress");
        }
        if (this.f3976e.size() > 0) {
            Iterator<String> it = this.f3976e.keySet().iterator();
            while (it.hasNext()) {
                attributes.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void f(Context context, AttributeSet attrs) {
        a.a(this, context.obtainStyledAttributes(attrs, R.styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void i(HashMap<String, Integer> interpolation) {
        if (this.E == -1) {
            return;
        }
        if (!Float.isNaN(this.F)) {
            interpolation.put("alpha", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.G)) {
            interpolation.put("elevation", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.H)) {
            interpolation.put(f.f3954i, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.I)) {
            interpolation.put("rotationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.f4063J)) {
            interpolation.put("rotationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.N)) {
            interpolation.put("translationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.O)) {
            interpolation.put("translationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.P)) {
            interpolation.put("translationZ", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.K)) {
            interpolation.put("transitionPathRotate", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.L)) {
            interpolation.put("scaleX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.L)) {
            interpolation.put("scaleY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.Q)) {
            interpolation.put("progress", Integer.valueOf(this.E));
        }
        if (this.f3976e.size() > 0) {
            Iterator<String> it = this.f3976e.keySet().iterator();
            while (it.hasNext()) {
                interpolation.put("CUSTOM," + it.next(), Integer.valueOf(this.E));
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.f
    public void j(String tag, Object value) {
        tag.hashCode();
        byte b8 = -1;
        switch (tag.hashCode()) {
            case -1913008125:
                if (tag.equals(f.A)) {
                    b8 = 0;
                }
                break;
            case -1812823328:
                if (tag.equals("transitionEasing")) {
                    b8 = 1;
                }
                break;
            case -1249320806:
                if (tag.equals("rotationX")) {
                    b8 = 2;
                }
                break;
            case -1249320805:
                if (tag.equals("rotationY")) {
                    b8 = 3;
                }
                break;
            case -1225497657:
                if (tag.equals("translationX")) {
                    b8 = 4;
                }
                break;
            case -1225497656:
                if (tag.equals("translationY")) {
                    b8 = 5;
                }
                break;
            case -1225497655:
                if (tag.equals("translationZ")) {
                    b8 = 6;
                }
                break;
            case -908189618:
                if (tag.equals("scaleX")) {
                    b8 = 7;
                }
                break;
            case -908189617:
                if (tag.equals("scaleY")) {
                    b8 = 8;
                }
                break;
            case -40300674:
                if (tag.equals(f.f3954i)) {
                    b8 = 9;
                }
                break;
            case -4379043:
                if (tag.equals("elevation")) {
                    b8 = 10;
                }
                break;
            case 37232917:
                if (tag.equals("transitionPathRotate")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case 92909918:
                if (tag.equals("alpha")) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 156108012:
                if (tag.equals("waveOffset")) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
            case 184161818:
                if (tag.equals("wavePeriod")) {
                    b8 = com.google.common.base.c.f19316p;
                }
                break;
            case 579057826:
                if (tag.equals("curveFit")) {
                    b8 = com.google.common.base.c.f19317q;
                }
                break;
            case 1532805160:
                if (tag.equals("waveShape")) {
                    b8 = com.google.common.base.c.f19318r;
                }
                break;
        }
        switch (b8) {
            case 0:
                this.Q = m(value);
                break;
            case 1:
                this.D = value.toString();
                break;
            case 2:
                this.I = m(value);
                break;
            case 3:
                this.f4063J = m(value);
                break;
            case 4:
                this.N = m(value);
                break;
            case 5:
                this.O = m(value);
                break;
            case 6:
                this.P = m(value);
                break;
            case 7:
                this.L = m(value);
                break;
            case 8:
                this.M = m(value);
                break;
            case 9:
                this.H = m(value);
                break;
            case 10:
                this.G = m(value);
                break;
            case 11:
                this.K = m(value);
                break;
            case 12:
                this.F = m(value);
                break;
            case 13:
                this.U = m(value);
                break;
            case 14:
                this.T = m(value);
                break;
            case 15:
                this.E = n(value);
                break;
            case 16:
                if (!(value instanceof Integer)) {
                    this.R = 7;
                    this.S = value.toString();
                } else {
                    this.R = n(value);
                }
                break;
        }
    }
}
