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
public class h extends f {
    private static final String X = "KeyCycle";
    static final String Y = "KeyCycle";
    public static final String Z = "wavePeriod";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f3997a0 = "waveOffset";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f3998b0 = "wavePhase";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f3999c0 = "waveShape";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f4000d0 = 0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f4001e0 = 1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f4002f0 = 2;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f4003g0 = 3;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f4004h0 = 4;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f4005i0 = 5;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f4006j0 = 6;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f4007k0 = 4;
    private String D = null;
    private int E = 0;
    private int F = -1;
    private String G = null;
    private float H = Float.NaN;
    private float I = 0.0f;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f4008J = 0.0f;
    private float K = Float.NaN;
    private int L = -1;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private float P = Float.NaN;
    private float Q = Float.NaN;
    private float R = Float.NaN;
    private float S = Float.NaN;
    private float T = Float.NaN;
    private float U = Float.NaN;
    private float V = Float.NaN;
    private float W = Float.NaN;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f4009a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f4010b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f4011c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f4012d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f4013e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f4014f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f4015g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f4016h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f4017i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f4018j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f4019k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f4020l = 12;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f4021m = 13;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int f4022n = 14;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final int f4023o = 15;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final int f4024p = 16;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final int f4025q = 17;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final int f4026r = 18;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final int f4027s = 19;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final int f4028t = 20;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final int f4029u = 21;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static SparseIntArray f4030v;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4030v = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            f4030v.append(R.styleable.KeyCycle_framePosition, 2);
            f4030v.append(R.styleable.KeyCycle_transitionEasing, 3);
            f4030v.append(R.styleable.KeyCycle_curveFit, 4);
            f4030v.append(R.styleable.KeyCycle_waveShape, 5);
            f4030v.append(R.styleable.KeyCycle_wavePeriod, 6);
            f4030v.append(R.styleable.KeyCycle_waveOffset, 7);
            f4030v.append(R.styleable.KeyCycle_waveVariesBy, 8);
            f4030v.append(R.styleable.KeyCycle_android_alpha, 9);
            f4030v.append(R.styleable.KeyCycle_android_elevation, 10);
            f4030v.append(R.styleable.KeyCycle_android_rotation, 11);
            f4030v.append(R.styleable.KeyCycle_android_rotationX, 12);
            f4030v.append(R.styleable.KeyCycle_android_rotationY, 13);
            f4030v.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            f4030v.append(R.styleable.KeyCycle_android_scaleX, 15);
            f4030v.append(R.styleable.KeyCycle_android_scaleY, 16);
            f4030v.append(R.styleable.KeyCycle_android_translationX, 17);
            f4030v.append(R.styleable.KeyCycle_android_translationY, 18);
            f4030v.append(R.styleable.KeyCycle_android_translationZ, 19);
            f4030v.append(R.styleable.KeyCycle_motionProgress, 20);
            f4030v.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(h c8, TypedArray a8) {
            int indexCount = a8.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = a8.getIndex(i7);
                switch (f4030v.get(index)) {
                    case 1:
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
                    case 2:
                        c8.f3972a = a8.getInt(index, c8.f3972a);
                        break;
                    case 3:
                        c8.D = a8.getString(index);
                        break;
                    case 4:
                        c8.E = a8.getInteger(index, c8.E);
                        break;
                    case 5:
                        if (a8.peekValue(index).type == 3) {
                            c8.G = a8.getString(index);
                            c8.F = 7;
                        } else {
                            c8.F = a8.getInt(index, c8.F);
                        }
                        break;
                    case 6:
                        c8.H = a8.getFloat(index, c8.H);
                        break;
                    case 7:
                        if (a8.peekValue(index).type == 5) {
                            c8.I = a8.getDimension(index, c8.I);
                        } else {
                            c8.I = a8.getFloat(index, c8.I);
                        }
                        break;
                    case 8:
                        c8.L = a8.getInt(index, c8.L);
                        break;
                    case 9:
                        c8.M = a8.getFloat(index, c8.M);
                        break;
                    case 10:
                        c8.N = a8.getDimension(index, c8.N);
                        break;
                    case 11:
                        c8.O = a8.getFloat(index, c8.O);
                        break;
                    case 12:
                        c8.Q = a8.getFloat(index, c8.Q);
                        break;
                    case 13:
                        c8.R = a8.getFloat(index, c8.R);
                        break;
                    case 14:
                        c8.P = a8.getFloat(index, c8.P);
                        break;
                    case 15:
                        c8.S = a8.getFloat(index, c8.S);
                        break;
                    case 16:
                        c8.T = a8.getFloat(index, c8.T);
                        break;
                    case 17:
                        c8.U = a8.getDimension(index, c8.U);
                        break;
                    case 18:
                        c8.V = a8.getDimension(index, c8.V);
                        break;
                    case 19:
                        c8.W = a8.getDimension(index, c8.W);
                        break;
                    case 20:
                        c8.K = a8.getFloat(index, c8.K);
                        break;
                    case 21:
                        c8.f4008J = a8.getFloat(index, c8.f4008J) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4030v.get(index));
                        break;
                }
            }
        }
    }

    public h() {
        this.f3975d = 4;
        this.f3976e = new HashMap<>();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, androidx.constraintlayout.motion.utils.d> splines) {
        c.n("KeyCycle", "add " + splines.size() + " values", 2);
        for (String str : splines.keySet()) {
            androidx.constraintlayout.motion.utils.d dVar = splines.get(str);
            if (dVar != null) {
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
                    case -40300674:
                        if (str.equals(f.f3954i)) {
                            b8 = 8;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            b8 = 9;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            b8 = 10;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            b8 = com.google.common.base.c.f19313m;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            b8 = com.google.common.base.c.f19314n;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            b8 = com.google.common.base.c.f19315o;
                        }
                        break;
                }
                switch (b8) {
                    case 0:
                        dVar.g(this.f3972a, this.Q);
                        break;
                    case 1:
                        dVar.g(this.f3972a, this.R);
                        break;
                    case 2:
                        dVar.g(this.f3972a, this.U);
                        break;
                    case 3:
                        dVar.g(this.f3972a, this.V);
                        break;
                    case 4:
                        dVar.g(this.f3972a, this.W);
                        break;
                    case 5:
                        dVar.g(this.f3972a, this.K);
                        break;
                    case 6:
                        dVar.g(this.f3972a, this.S);
                        break;
                    case 7:
                        dVar.g(this.f3972a, this.T);
                        break;
                    case 8:
                        dVar.g(this.f3972a, this.O);
                        break;
                    case 9:
                        dVar.g(this.f3972a, this.N);
                        break;
                    case 10:
                        dVar.g(this.f3972a, this.P);
                        break;
                    case 11:
                        dVar.g(this.f3972a, this.M);
                        break;
                    case 12:
                        dVar.g(this.f3972a, this.I);
                        break;
                    case 13:
                        dVar.g(this.f3972a, this.f4008J);
                        break;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                        }
                        break;
                }
            }
        }
    }

    public void a0(HashMap<String, androidx.constraintlayout.motion.utils.c> oscSet) {
        androidx.constraintlayout.motion.utils.c cVar;
        androidx.constraintlayout.motion.utils.c cVar2;
        for (String str : oscSet.keySet()) {
            if (str.startsWith("CUSTOM")) {
                androidx.constraintlayout.widget.a aVar = this.f3976e.get(str.substring(7));
                if (aVar != null && aVar.j() == androidx.constraintlayout.widget.a.b.FLOAT_TYPE && (cVar = oscSet.get(str)) != null) {
                    cVar.g(this.f3972a, this.F, this.G, this.L, this.H, this.I, this.f4008J, aVar.k(), aVar);
                }
            } else {
                float fB0 = b0(str);
                if (!Float.isNaN(fB0) && (cVar2 = oscSet.get(str)) != null) {
                    cVar2.f(this.f3972a, this.F, this.G, this.L, this.H, this.I, this.f4008J, fB0);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new h().c(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public float b0(String key) {
        key.hashCode();
        byte b8 = -1;
        switch (key.hashCode()) {
            case -1249320806:
                if (key.equals("rotationX")) {
                    b8 = 0;
                }
                break;
            case -1249320805:
                if (key.equals("rotationY")) {
                    b8 = 1;
                }
                break;
            case -1225497657:
                if (key.equals("translationX")) {
                    b8 = 2;
                }
                break;
            case -1225497656:
                if (key.equals("translationY")) {
                    b8 = 3;
                }
                break;
            case -1225497655:
                if (key.equals("translationZ")) {
                    b8 = 4;
                }
                break;
            case -1001078227:
                if (key.equals("progress")) {
                    b8 = 5;
                }
                break;
            case -908189618:
                if (key.equals("scaleX")) {
                    b8 = 6;
                }
                break;
            case -908189617:
                if (key.equals("scaleY")) {
                    b8 = 7;
                }
                break;
            case -40300674:
                if (key.equals(f.f3954i)) {
                    b8 = 8;
                }
                break;
            case -4379043:
                if (key.equals("elevation")) {
                    b8 = 9;
                }
                break;
            case 37232917:
                if (key.equals("transitionPathRotate")) {
                    b8 = 10;
                }
                break;
            case 92909918:
                if (key.equals("alpha")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case 156108012:
                if (key.equals("waveOffset")) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 1530034690:
                if (key.equals("wavePhase")) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
        }
        switch (b8) {
            case 0:
                return this.Q;
            case 1:
                return this.R;
            case 2:
                return this.U;
            case 3:
                return this.V;
            case 4:
                return this.W;
            case 5:
                return this.K;
            case 6:
                return this.S;
            case 7:
                return this.T;
            case 8:
                return this.O;
            case 9:
                return this.N;
            case 10:
                return this.P;
            case 11:
                return this.M;
            case 12:
                return this.I;
            case 13:
                return this.f4008J;
            default:
                if (key.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + key);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        h hVar = (h) src;
        this.D = hVar.D;
        this.E = hVar.E;
        this.F = hVar.F;
        this.G = hVar.G;
        this.H = hVar.H;
        this.I = hVar.I;
        this.f4008J = hVar.f4008J;
        this.K = hVar.K;
        this.L = hVar.L;
        this.M = hVar.M;
        this.N = hVar.N;
        this.O = hVar.O;
        this.P = hVar.P;
        this.Q = hVar.Q;
        this.R = hVar.R;
        this.S = hVar.S;
        this.T = hVar.T;
        this.U = hVar.U;
        this.V = hVar.V;
        this.W = hVar.W;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
        if (!Float.isNaN(this.M)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.N)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.O)) {
            attributes.add(f.f3954i);
        }
        if (!Float.isNaN(this.Q)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.R)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.S)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.T)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.P)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.U)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.V)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.W)) {
            attributes.add("translationZ");
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
        a.b(this, context.obtainStyledAttributes(attrs, R.styleable.KeyCycle));
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
            case 1530034690:
                if (tag.equals("wavePhase")) {
                    b8 = com.google.common.base.c.f19318r;
                }
                break;
            case 1532805160:
                if (tag.equals("waveShape")) {
                    b8 = 17;
                }
                break;
        }
        switch (b8) {
            case 0:
                this.K = m(value);
                break;
            case 1:
                this.D = value.toString();
                break;
            case 2:
                this.Q = m(value);
                break;
            case 3:
                this.R = m(value);
                break;
            case 4:
                this.U = m(value);
                break;
            case 5:
                this.V = m(value);
                break;
            case 6:
                this.W = m(value);
                break;
            case 7:
                this.S = m(value);
                break;
            case 8:
                this.T = m(value);
                break;
            case 9:
                this.O = m(value);
                break;
            case 10:
                this.N = m(value);
                break;
            case 11:
                this.P = m(value);
                break;
            case 12:
                this.M = m(value);
                break;
            case 13:
                this.I = m(value);
                break;
            case 14:
                this.H = m(value);
                break;
            case 15:
                this.E = n(value);
                break;
            case 16:
                this.f4008J = m(value);
                break;
            case 17:
                if (!(value instanceof Integer)) {
                    this.F = 7;
                    this.G = value.toString();
                } else {
                    this.F = n(value);
                }
                break;
        }
    }
}
