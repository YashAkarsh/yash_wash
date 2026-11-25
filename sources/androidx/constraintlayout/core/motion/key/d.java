package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.e0;
import androidx.constraintlayout.core.motion.utils.h;
import androidx.constraintlayout.core.motion.utils.o;
import androidx.constraintlayout.core.motion.utils.v;
import androidx.constraintlayout.core.motion.utils.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {
    private static final String R = "KeyCycle";
    static final String S = "KeyCycle";
    public static final String T = "wavePeriod";
    public static final String U = "waveOffset";
    public static final String V = "wavePhase";
    public static final String W = "waveShape";
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f2703a0 = 3;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f2704b0 = 4;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f2705c0 = 5;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f2706d0 = 6;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f2707e0 = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f2709y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2710z = 0;
    private int A = -1;
    private String B = null;
    private float C = Float.NaN;
    private float D = 0.0f;
    private float E = 0.0f;
    private float F = Float.NaN;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f2708J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private float P = Float.NaN;
    private float Q = Float.NaN;

    public d() {
        this.f2698k = 4;
        this.f2699l = new HashMap<>();
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        if (i7 == 401) {
            this.f2710z = i8;
            return true;
        }
        if (i7 == 421) {
            this.A = i8;
            return true;
        }
        if (b(i7, i8)) {
            return true;
        }
        return super.a(i7, i8);
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        if (i7 == 315) {
            this.F = f8;
            return true;
        }
        if (i7 == 403) {
            this.G = f8;
            return true;
        }
        if (i7 == 416) {
            this.f2708J = f8;
            return true;
        }
        switch (i7) {
            case 304:
                this.O = f8;
                return true;
            case 305:
                this.P = f8;
                return true;
            case 306:
                this.Q = f8;
                return true;
            case 307:
                this.H = f8;
                return true;
            case 308:
                this.K = f8;
                return true;
            case 309:
                this.L = f8;
                return true;
            case 310:
                this.I = f8;
                return true;
            case 311:
                this.M = f8;
                return true;
            case 312:
                this.N = f8;
                return true;
            default:
                switch (i7) {
                    case w.c.f3063u /* 423 */:
                        this.C = f8;
                        return true;
                    case w.c.f3064v /* 424 */:
                        this.D = f8;
                        return true;
                    case w.c.f3065w /* 425 */:
                        this.E = f8;
                        return true;
                    default:
                        return super.b(i7, f8);
                }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (i7 == 420) {
            this.f2709y = str;
            return true;
        }
        if (i7 != 422) {
            return super.c(i7, str);
        }
        this.B = str;
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        byte b8;
        str.hashCode();
        switch (str.hashCode()) {
            case -1581616630:
                b8 = !str.equals(w.c.P) ? (byte) -1 : (byte) 0;
                break;
            case -1310311125:
                b8 = !str.equals("easing") ? (byte) -1 : (byte) 1;
                break;
            case -1249320806:
                b8 = !str.equals("rotationX") ? (byte) -1 : (byte) 2;
                break;
            case -1249320805:
                b8 = !str.equals("rotationY") ? (byte) -1 : (byte) 3;
                break;
            case -1249320804:
                b8 = !str.equals("rotationZ") ? (byte) -1 : (byte) 4;
                break;
            case -1225497657:
                b8 = !str.equals("translationX") ? (byte) -1 : (byte) 5;
                break;
            case -1225497656:
                b8 = !str.equals("translationY") ? (byte) -1 : (byte) 6;
                break;
            case -1225497655:
                b8 = !str.equals("translationZ") ? (byte) -1 : (byte) 7;
                break;
            case -1019779949:
                b8 = !str.equals(w.c.R) ? (byte) -1 : (byte) 8;
                break;
            case -1001078227:
                b8 = !str.equals("progress") ? (byte) -1 : (byte) 9;
                break;
            case -991726143:
                b8 = !str.equals(w.c.Q) ? (byte) -1 : (byte) 10;
                break;
            case -987906986:
                b8 = !str.equals("pivotX") ? (byte) -1 : com.google.common.base.c.f19313m;
                break;
            case -987906985:
                b8 = !str.equals("pivotY") ? (byte) -1 : com.google.common.base.c.f19314n;
                break;
            case -908189618:
                b8 = !str.equals("scaleX") ? (byte) -1 : com.google.common.base.c.f19315o;
                break;
            case -908189617:
                b8 = !str.equals("scaleY") ? (byte) -1 : com.google.common.base.c.f19316p;
                break;
            case 92909918:
                b8 = !str.equals("alpha") ? (byte) -1 : com.google.common.base.c.f19317q;
                break;
            case 106629499:
                b8 = !str.equals(w.c.S) ? (byte) -1 : com.google.common.base.c.f19318r;
                break;
            case 579057826:
                b8 = !str.equals("curveFit") ? (byte) -1 : (byte) 17;
                break;
            case 803192288:
                b8 = !str.equals("pathRotate") ? (byte) -1 : com.google.common.base.c.f19321u;
                break;
            case 1532805160:
                b8 = !str.equals("waveShape") ? (byte) -1 : (byte) 19;
                break;
            case 1941332754:
                b8 = !str.equals("visibility") ? (byte) -1 : com.google.common.base.c.f19324x;
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
                return w.c.f3062t;
            case 1:
                return w.c.f3060r;
            case 2:
                return 308;
            case 3:
                return 309;
            case 4:
                return 310;
            case 5:
                return 304;
            case 6:
                return 305;
            case 7:
                return 306;
            case 8:
                return w.c.f3064v;
            case 9:
                return 315;
            case 10:
                return w.c.f3063u;
            case 11:
                return 313;
            case 12:
                return 314;
            case 13:
                return 311;
            case 14:
                return 312;
            case 15:
                return 403;
            case 16:
                return w.c.f3065w;
            case 17:
                return w.c.f3044b;
            case 18:
                return w.c.f3059q;
            case 19:
                return 421;
            case 20:
                return w.c.f3045c;
            default:
                return -1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void f(HashMap<String, o> map) {
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.G)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f2708J)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("translationZ");
        }
        if (this.f2699l.size() > 0) {
            Iterator<String> it = this.f2699l.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public void v(HashMap<String, h> map) {
        h hVar;
        h hVar2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                androidx.constraintlayout.core.motion.b bVar = this.f2699l.get(str.substring(7));
                if (bVar != null && bVar.m() == 901 && (hVar = map.get(str)) != null) {
                    hVar.g(this.f2695h, this.A, this.B, -1, this.C, this.D, this.E, bVar.n(), bVar);
                }
            } else {
                float fX = x(str);
                if (!Float.isNaN(fX) && (hVar2 = map.get(str)) != null) {
                    hVar2.f(this.f2695h, this.A, this.B, -1, this.C, this.D, this.E, fX);
                }
            }
        }
    }

    public void w() {
        System.out.println("MotionKeyCycle{mWaveShape=" + this.A + ", mWavePeriod=" + this.C + ", mWaveOffset=" + this.D + ", mWavePhase=" + this.E + ", mRotation=" + this.I + '}');
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public float x(String str) {
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
            case -1249320804:
                if (str.equals("rotationZ")) {
                    b8 = 2;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b8 = 3;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b8 = 4;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b8 = 5;
                }
                break;
            case -1019779949:
                if (str.equals(w.c.R)) {
                    b8 = 6;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    b8 = 7;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b8 = 8;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b8 = 9;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b8 = 10;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
            case 106629499:
                if (str.equals(w.c.S)) {
                    b8 = com.google.common.base.c.f19314n;
                }
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    b8 = com.google.common.base.c.f19315o;
                }
                break;
        }
        switch (b8) {
            case 0:
                return this.K;
            case 1:
                return this.L;
            case 2:
                return this.I;
            case 3:
                return this.O;
            case 4:
                return this.P;
            case 5:
                return this.Q;
            case 6:
                return this.D;
            case 7:
                return this.F;
            case 8:
                return this.M;
            case 9:
                return this.N;
            case 10:
                return this.H;
            case 11:
                return this.G;
            case 12:
                return this.E;
            case 13:
                return this.f2708J;
            default:
                return Float.NaN;
        }
    }

    public void y() {
        HashSet<String> hashSet = new HashSet<>();
        i(hashSet);
        e0.c(" ------------- " + this.f2695h + " -------------");
        e0.c("MotionKeyCycle{Shape=" + this.A + ", Period=" + this.C + ", Offset=" + this.D + ", Phase=" + this.E + '}');
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            v.a(strArr[i7]);
            e0.c(strArr[i7] + ":" + x(strArr[i7]));
        }
    }
}
