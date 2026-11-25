package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.o;
import androidx.constraintlayout.core.motion.utils.v;
import androidx.constraintlayout.core.motion.utils.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    static final String P = "KeyAttribute";
    private static final String Q = "KeyAttributes";
    private static final boolean R = false;
    public static final int S = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f2701y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2702z = -1;
    private int A = 0;
    private float B = Float.NaN;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private float E = Float.NaN;
    private float F = Float.NaN;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f2700J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;

    public c() {
        this.f2698k = 1;
        this.f2699l = new HashMap<>();
    }

    private float w(int i7) {
        if (i7 == 100) {
            return this.f2695h;
        }
        switch (i7) {
            case 303:
                return this.B;
            case 304:
                return this.L;
            case 305:
                return this.M;
            case 306:
                return this.N;
            case 307:
                return this.C;
            case 308:
                return this.E;
            case 309:
                return this.F;
            case 310:
                return this.D;
            case 311:
                return this.f2700J;
            case 312:
                return this.K;
            case 313:
                return this.G;
            case 314:
                return this.H;
            case 315:
                return this.O;
            case w.a.f3016q /* 316 */:
                return this.I;
            default:
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        if (i7 == 100) {
            this.f2695h = i8;
            return true;
        }
        if (i7 == 301) {
            this.f2702z = i8;
            return true;
        }
        if (i7 == 302) {
            this.A = i8;
            return true;
        }
        if (a(i7, i8)) {
            return true;
        }
        return super.a(i7, i8);
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        if (i7 == 100) {
            this.I = f8;
            return true;
        }
        switch (i7) {
            case 303:
                this.B = f8;
                return true;
            case 304:
                this.L = f8;
                return true;
            case 305:
                this.M = f8;
                return true;
            case 306:
                this.N = f8;
                return true;
            case 307:
                this.C = f8;
                return true;
            case 308:
                this.E = f8;
                return true;
            case 309:
                this.F = f8;
                return true;
            case 310:
                this.D = f8;
                return true;
            case 311:
                this.f2700J = f8;
                return true;
            case 312:
                this.K = f8;
                return true;
            case 313:
                this.G = f8;
                return true;
            case 314:
                this.H = f8;
                return true;
            case 315:
                this.O = f8;
                return true;
            case w.a.f3016q /* 316 */:
                this.I = f8;
                return true;
            default:
                return super.b(i7, f8);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (i7 == 101) {
            this.f2697j = str;
            return true;
        }
        if (i7 != 317) {
            return super.c(i7, str);
        }
        this.f2701y = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        return v.a(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.core.motion.key.b
    public void f(HashMap<String, o> map) {
        for (String str : map.keySet()) {
            o oVar = map.get(str);
            if (oVar != null) {
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
                        case -987906986:
                            if (!str.equals("pivotX")) {
                                b8 = -1;
                            }
                            break;
                        case -987906985:
                            b8 = str.equals("pivotY") ? (byte) 8 : (byte) -1;
                            break;
                        case -908189618:
                            b8 = str.equals("scaleX") ? (byte) 9 : (byte) -1;
                            break;
                        case -908189617:
                            b8 = str.equals("scaleY") ? (byte) 10 : (byte) -1;
                            break;
                        case -4379043:
                            b8 = str.equals("elevation") ? com.google.common.base.c.f19313m : (byte) -1;
                            break;
                        case 92909918:
                            b8 = str.equals("alpha") ? com.google.common.base.c.f19314n : (byte) -1;
                            break;
                        case 803192288:
                            b8 = str.equals("pathRotate") ? com.google.common.base.c.f19315o : (byte) -1;
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    switch (b8) {
                        case 0:
                            if (!Float.isNaN(this.E)) {
                                oVar.g(this.f2695h, this.E);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.F)) {
                                oVar.g(this.f2695h, this.F);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.D)) {
                                oVar.g(this.f2695h, this.D);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.L)) {
                                oVar.g(this.f2695h, this.L);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.M)) {
                                oVar.g(this.f2695h, this.M);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.N)) {
                                oVar.g(this.f2695h, this.N);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.O)) {
                                oVar.g(this.f2695h, this.O);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.E)) {
                                oVar.g(this.f2695h, this.G);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.F)) {
                                oVar.g(this.f2695h, this.H);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.f2700J)) {
                                oVar.g(this.f2695h, this.f2700J);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.K)) {
                                oVar.g(this.f2695h, this.K);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.C)) {
                                oVar.g(this.f2695h, this.C);
                            }
                            break;
                        case 12:
                            if (!Float.isNaN(this.B)) {
                                oVar.g(this.f2695h, this.B);
                            }
                            break;
                        case 13:
                            if (!Float.isNaN(this.I)) {
                                oVar.g(this.f2695h, this.I);
                            }
                            break;
                        default:
                            System.err.println("not supported by KeyAttributes " + str);
                            break;
                    }
                } else {
                    androidx.constraintlayout.core.motion.b bVar = this.f2699l.get(str.substring(7));
                    if (bVar != null) {
                        ((o.c) oVar).k(this.f2695h, bVar);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.B)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.C)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.D)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.E)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("pivotX");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("pivotY");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.f2700J)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("progress");
        }
        if (this.f2699l.size() > 0) {
            Iterator<String> it = this.f2699l.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void q(HashMap<String, Integer> map) {
        if (!Float.isNaN(this.B)) {
            map.put("alpha", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.C)) {
            map.put("elevation", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.D)) {
            map.put("rotationZ", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.E)) {
            map.put("rotationX", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.F)) {
            map.put("rotationY", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.G)) {
            map.put("pivotX", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.H)) {
            map.put("pivotY", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.L)) {
            map.put("translationX", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.M)) {
            map.put("translationY", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.N)) {
            map.put("translationZ", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.I)) {
            map.put("pathRotate", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.f2700J)) {
            map.put("scaleX", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.K)) {
            map.put("scaleY", Integer.valueOf(this.f2702z));
        }
        if (!Float.isNaN(this.O)) {
            map.put("progress", Integer.valueOf(this.f2702z));
        }
        if (this.f2699l.size() > 0) {
            Iterator<String> it = this.f2699l.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.f2702z));
            }
        }
    }

    public int v() {
        return this.f2702z;
    }

    public void x() {
        HashSet<String> hashSet = new HashSet<>();
        i(hashSet);
        System.out.println(" ------------- " + this.f2695h + " -------------");
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            int iA = v.a(strArr[i7]);
            System.out.println(strArr[i7] + ":" + w(iA));
        }
    }
}
