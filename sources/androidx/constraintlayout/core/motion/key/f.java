package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.e0;
import androidx.constraintlayout.core.motion.utils.o;
import androidx.constraintlayout.core.motion.utils.t;
import androidx.constraintlayout.core.motion.utils.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    static final String Q = "KeyTimeCycle";
    private static final String R = "KeyTimeCycle";
    public static final int S = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f2715y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2716z = -1;
    private float A = Float.NaN;
    private float B = Float.NaN;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private float E = Float.NaN;
    private float F = Float.NaN;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f2714J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private int M = 0;
    private String N = null;
    private float O = Float.NaN;
    private float P = 0.0f;

    public f() {
        this.f2698k = 3;
        this.f2699l = new HashMap<>();
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        if (i7 == 100) {
            this.f2695h = i8;
            return true;
        }
        if (i7 != 421) {
            return super.a(i7, i8);
        }
        this.M = i8;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        if (i7 == 315) {
            this.L = t(Float.valueOf(f8));
            return true;
        }
        if (i7 == 401) {
            this.f2716z = u(Float.valueOf(f8));
            return true;
        }
        if (i7 == 403) {
            this.A = f8;
            return true;
        }
        if (i7 == 416) {
            this.F = t(Float.valueOf(f8));
            return true;
        }
        if (i7 == 423) {
            this.O = t(Float.valueOf(f8));
            return true;
        }
        if (i7 == 424) {
            this.P = t(Float.valueOf(f8));
            return true;
        }
        switch (i7) {
            case 304:
                this.I = t(Float.valueOf(f8));
                return true;
            case 305:
                this.f2714J = t(Float.valueOf(f8));
                return true;
            case 306:
                this.K = t(Float.valueOf(f8));
                return true;
            case 307:
                this.B = t(Float.valueOf(f8));
                return true;
            case 308:
                this.D = t(Float.valueOf(f8));
                return true;
            case 309:
                this.E = t(Float.valueOf(f8));
                return true;
            case 310:
                this.C = t(Float.valueOf(f8));
                return true;
            case 311:
                this.G = t(Float.valueOf(f8));
                return true;
            case 312:
                this.H = t(Float.valueOf(f8));
                return true;
            default:
                return super.b(i7, f8);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (i7 == 420) {
            this.f2715y = str;
            return true;
        }
        if (i7 != 421) {
            return super.c(i7, str);
        }
        this.M = 7;
        this.N = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean d(int i7, boolean z7) {
        return super.d(i7, z7);
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        return y.a(str);
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void f(HashMap<String, o> map) {
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return new f().h(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.A)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.B)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.C)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.D)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.E)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f2714J)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("translationZ");
        }
        if (this.f2699l.size() > 0) {
            Iterator<String> it = this.f2699l.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void v(HashMap<String, t> map) {
        for (String str : map.keySet()) {
            t tVar = map.get(str);
            if (tVar != null) {
                byte b8 = 7;
                if (!str.startsWith("CUSTOM")) {
                    switch (str.hashCode()) {
                        case -1249320806:
                            b8 = str.equals("rotationX") ? (byte) 0 : (byte) -1;
                            break;
                        case -1249320805:
                            b8 = str.equals("rotationY") ? (byte) 1 : (byte) -1;
                            break;
                        case -1249320804:
                            b8 = str.equals("rotationZ") ? (byte) 2 : (byte) -1;
                            break;
                        case -1225497657:
                            b8 = str.equals("translationX") ? (byte) 3 : (byte) -1;
                            break;
                        case -1225497656:
                            b8 = str.equals("translationY") ? (byte) 4 : (byte) -1;
                            break;
                        case -1225497655:
                            b8 = str.equals("translationZ") ? (byte) 5 : (byte) -1;
                            break;
                        case -1001078227:
                            b8 = str.equals("progress") ? (byte) 6 : (byte) -1;
                            break;
                        case -908189618:
                            if (!str.equals("scaleX")) {
                                b8 = -1;
                            }
                            break;
                        case -908189617:
                            b8 = str.equals("scaleY") ? (byte) 8 : (byte) -1;
                            break;
                        case -4379043:
                            b8 = str.equals("elevation") ? (byte) 9 : (byte) -1;
                            break;
                        case 92909918:
                            b8 = str.equals("alpha") ? (byte) 10 : (byte) -1;
                            break;
                        case 803192288:
                            b8 = str.equals("pathRotate") ? com.google.common.base.c.f19313m : (byte) -1;
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    switch (b8) {
                        case 0:
                            if (!Float.isNaN(this.D)) {
                                tVar.c(this.f2695h, this.D, this.O, this.M, this.P);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.E)) {
                                tVar.c(this.f2695h, this.E, this.O, this.M, this.P);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.C)) {
                                tVar.c(this.f2695h, this.C, this.O, this.M, this.P);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.I)) {
                                tVar.c(this.f2695h, this.I, this.O, this.M, this.P);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.f2714J)) {
                                tVar.c(this.f2695h, this.f2714J, this.O, this.M, this.P);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.K)) {
                                tVar.c(this.f2695h, this.K, this.O, this.M, this.P);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.L)) {
                                tVar.c(this.f2695h, this.L, this.O, this.M, this.P);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.G)) {
                                tVar.c(this.f2695h, this.G, this.O, this.M, this.P);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.H)) {
                                tVar.c(this.f2695h, this.H, this.O, this.M, this.P);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.K)) {
                                tVar.c(this.f2695h, this.K, this.O, this.M, this.P);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.A)) {
                                tVar.c(this.f2695h, this.A, this.O, this.M, this.P);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.F)) {
                                tVar.c(this.f2695h, this.F, this.O, this.M, this.P);
                            }
                            break;
                        default:
                            e0.f("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    androidx.constraintlayout.core.motion.b bVar = this.f2699l.get(str.substring(7));
                    if (bVar != null) {
                        ((t.b) tVar).g(this.f2695h, bVar, this.O, this.M, this.P);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public f h(b bVar) {
        super.h(bVar);
        f fVar = (f) bVar;
        this.f2715y = fVar.f2715y;
        this.f2716z = fVar.f2716z;
        this.M = fVar.M;
        this.O = fVar.O;
        this.P = fVar.P;
        this.L = fVar.L;
        this.A = fVar.A;
        this.B = fVar.B;
        this.C = fVar.C;
        this.F = fVar.F;
        this.D = fVar.D;
        this.E = fVar.E;
        this.G = fVar.G;
        this.H = fVar.H;
        this.I = fVar.I;
        this.f2714J = fVar.f2714J;
        this.K = fVar.K;
        return this;
    }
}
