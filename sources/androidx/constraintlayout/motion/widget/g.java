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
public class g extends f {
    static final String U = "KeyAttribute";
    private static final String V = "KeyAttributes";
    private static final boolean W = false;
    public static final int X = 1;
    private String D;
    private int E = -1;
    private boolean F = false;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f3977J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private float P = Float.NaN;
    private float Q = Float.NaN;
    private float R = Float.NaN;
    private float S = Float.NaN;
    private float T = Float.NaN;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f3978a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f3979b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f3980c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f3981d = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f3982e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f3983f = 8;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f3984g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f3985h = 9;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f3986i = 10;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f3987j = 12;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f3988k = 13;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f3989l = 14;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f3990m = 15;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int f3991n = 16;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final int f3992o = 17;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f3993p = 18;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final int f3994q = 19;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final int f3995r = 20;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static SparseIntArray f3996s;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3996s = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            f3996s.append(R.styleable.KeyAttribute_android_elevation, 2);
            f3996s.append(R.styleable.KeyAttribute_android_rotation, 4);
            f3996s.append(R.styleable.KeyAttribute_android_rotationX, 5);
            f3996s.append(R.styleable.KeyAttribute_android_rotationY, 6);
            f3996s.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            f3996s.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            f3996s.append(R.styleable.KeyAttribute_android_scaleX, 7);
            f3996s.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            f3996s.append(R.styleable.KeyAttribute_transitionEasing, 9);
            f3996s.append(R.styleable.KeyAttribute_motionTarget, 10);
            f3996s.append(R.styleable.KeyAttribute_framePosition, 12);
            f3996s.append(R.styleable.KeyAttribute_curveFit, 13);
            f3996s.append(R.styleable.KeyAttribute_android_scaleY, 14);
            f3996s.append(R.styleable.KeyAttribute_android_translationX, 15);
            f3996s.append(R.styleable.KeyAttribute_android_translationY, 16);
            f3996s.append(R.styleable.KeyAttribute_android_translationZ, 17);
            f3996s.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        private a() {
        }

        public static void a(g c8, TypedArray a8) {
            int indexCount = a8.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = a8.getIndex(i7);
                switch (f3996s.get(index)) {
                    case 1:
                        c8.G = a8.getFloat(index, c8.G);
                        break;
                    case 2:
                        c8.H = a8.getDimension(index, c8.H);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e(g.U, "unused attribute 0x" + Integer.toHexString(index) + "   " + f3996s.get(index));
                        break;
                    case 4:
                        c8.I = a8.getFloat(index, c8.I);
                        break;
                    case 5:
                        c8.f3977J = a8.getFloat(index, c8.f3977J);
                        break;
                    case 6:
                        c8.K = a8.getFloat(index, c8.K);
                        break;
                    case 7:
                        c8.O = a8.getFloat(index, c8.O);
                        break;
                    case 8:
                        c8.N = a8.getFloat(index, c8.N);
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
                        c8.P = a8.getFloat(index, c8.P);
                        break;
                    case 15:
                        c8.Q = a8.getDimension(index, c8.Q);
                        break;
                    case 16:
                        c8.R = a8.getDimension(index, c8.R);
                        break;
                    case 17:
                        c8.S = a8.getDimension(index, c8.S);
                        break;
                    case 18:
                        c8.T = a8.getFloat(index, c8.T);
                        break;
                    case 19:
                        c8.L = a8.getDimension(index, c8.L);
                        break;
                    case 20:
                        c8.M = a8.getDimension(index, c8.M);
                        break;
                }
            }
        }
    }

    public g() {
        this.f3975d = 1;
        this.f3976e = new HashMap<>();
    }

    int T() {
        return this.E;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, androidx.constraintlayout.motion.utils.d> splines) {
        for (String str : splines.keySet()) {
            androidx.constraintlayout.motion.utils.d dVar = splines.get(str);
            if (dVar != null) {
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
                        case -760884510:
                            b8 = str.equals(f.f3957l) ? (byte) 8 : (byte) -1;
                            break;
                        case -760884509:
                            b8 = str.equals(f.f3958m) ? (byte) 9 : (byte) -1;
                            break;
                        case -40300674:
                            b8 = str.equals(f.f3954i) ? (byte) 10 : (byte) -1;
                            break;
                        case -4379043:
                            b8 = str.equals("elevation") ? com.google.common.base.c.f19313m : (byte) -1;
                            break;
                        case 37232917:
                            b8 = str.equals("transitionPathRotate") ? com.google.common.base.c.f19314n : (byte) -1;
                            break;
                        case 92909918:
                            b8 = str.equals("alpha") ? com.google.common.base.c.f19315o : (byte) -1;
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    switch (b8) {
                        case 0:
                            if (!Float.isNaN(this.f3977J)) {
                                dVar.g(this.f3972a, this.f3977J);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.K)) {
                                dVar.g(this.f3972a, this.K);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.Q)) {
                                dVar.g(this.f3972a, this.Q);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.R)) {
                                dVar.g(this.f3972a, this.R);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.S)) {
                                dVar.g(this.f3972a, this.S);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.T)) {
                                dVar.g(this.f3972a, this.T);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.O)) {
                                dVar.g(this.f3972a, this.O);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.P)) {
                                dVar.g(this.f3972a, this.P);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.f3977J)) {
                                dVar.g(this.f3972a, this.L);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.K)) {
                                dVar.g(this.f3972a, this.M);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.I)) {
                                dVar.g(this.f3972a, this.I);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.H)) {
                                dVar.g(this.f3972a, this.H);
                            }
                            break;
                        case 12:
                            if (!Float.isNaN(this.N)) {
                                dVar.g(this.f3972a, this.N);
                            }
                            break;
                        case 13:
                            if (!Float.isNaN(this.G)) {
                                dVar.g(this.f3972a, this.G);
                            }
                            break;
                    }
                } else {
                    androidx.constraintlayout.widget.a aVar = this.f3976e.get(str.substring(7));
                    if (aVar != null) {
                        ((androidx.constraintlayout.motion.utils.d.b) dVar).n(this.f3972a, aVar);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new g().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        g gVar = (g) src;
        this.E = gVar.E;
        this.F = gVar.F;
        this.G = gVar.G;
        this.H = gVar.H;
        this.I = gVar.I;
        this.f3977J = gVar.f3977J;
        this.K = gVar.K;
        this.L = gVar.L;
        this.M = gVar.M;
        this.N = gVar.N;
        this.O = gVar.O;
        this.P = gVar.P;
        this.Q = gVar.Q;
        this.R = gVar.R;
        this.S = gVar.S;
        this.T = gVar.T;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
        if (!Float.isNaN(this.G)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.H)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.I)) {
            attributes.add(f.f3954i);
        }
        if (!Float.isNaN(this.f3977J)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.K)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.L)) {
            attributes.add(f.f3957l);
        }
        if (!Float.isNaN(this.M)) {
            attributes.add(f.f3958m);
        }
        if (!Float.isNaN(this.Q)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.R)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.S)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.N)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.O)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.P)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.T)) {
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
        a.a(this, context.obtainStyledAttributes(attrs, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void i(HashMap<String, Integer> interpolation) {
        if (this.E == -1) {
            return;
        }
        if (!Float.isNaN(this.G)) {
            interpolation.put("alpha", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.H)) {
            interpolation.put("elevation", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.I)) {
            interpolation.put(f.f3954i, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.f3977J)) {
            interpolation.put("rotationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.K)) {
            interpolation.put("rotationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.L)) {
            interpolation.put(f.f3957l, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.M)) {
            interpolation.put(f.f3958m, Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.Q)) {
            interpolation.put("translationX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.R)) {
            interpolation.put("translationY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.S)) {
            interpolation.put("translationZ", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.N)) {
            interpolation.put("transitionPathRotate", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.O)) {
            interpolation.put("scaleX", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.P)) {
            interpolation.put("scaleY", Integer.valueOf(this.E));
        }
        if (!Float.isNaN(this.T)) {
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
            case -760884510:
                if (tag.equals(f.f3957l)) {
                    b8 = 9;
                }
                break;
            case -760884509:
                if (tag.equals(f.f3958m)) {
                    b8 = 10;
                }
                break;
            case -40300674:
                if (tag.equals(f.f3954i)) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case -4379043:
                if (tag.equals("elevation")) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 37232917:
                if (tag.equals("transitionPathRotate")) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
            case 92909918:
                if (tag.equals("alpha")) {
                    b8 = com.google.common.base.c.f19316p;
                }
                break;
            case 579057826:
                if (tag.equals("curveFit")) {
                    b8 = com.google.common.base.c.f19317q;
                }
                break;
            case 1941332754:
                if (tag.equals("visibility")) {
                    b8 = com.google.common.base.c.f19318r;
                }
                break;
        }
        switch (b8) {
            case 0:
                this.T = m(value);
                break;
            case 1:
                this.D = value.toString();
                break;
            case 2:
                this.f3977J = m(value);
                break;
            case 3:
                this.K = m(value);
                break;
            case 4:
                this.Q = m(value);
                break;
            case 5:
                this.R = m(value);
                break;
            case 6:
                this.S = m(value);
                break;
            case 7:
                this.O = m(value);
                break;
            case 8:
                this.P = m(value);
                break;
            case 9:
                this.L = m(value);
                break;
            case 10:
                this.M = m(value);
                break;
            case 11:
                this.I = m(value);
                break;
            case 12:
                this.H = m(value);
                break;
            case 13:
                this.N = m(value);
                break;
            case 14:
                this.G = m(value);
                break;
            case 15:
                this.E = n(value);
                break;
            case 16:
                this.F = l(value);
                break;
        }
    }
}
