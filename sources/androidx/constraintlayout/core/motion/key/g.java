package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class g extends b {
    private static final String R = "KeyTrigger";
    public static final String S = "viewTransitionOnCross";
    public static final String T = "viewTransitionOnPositiveCross";
    public static final String U = "viewTransitionOnNegativeCross";
    public static final String V = "postLayout";
    public static final String W = "triggerSlack";
    public static final String X = "triggerCollisionView";
    public static final String Y = "triggerCollisionId";
    public static final String Z = "triggerID";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f2717a0 = "positiveCross";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f2718b0 = "negativeCross";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f2719c0 = "triggerReceiver";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f2720d0 = "CROSS";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f2721e0 = 301;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f2722f0 = 302;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f2723g0 = 303;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f2724h0 = 304;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f2725i0 = 305;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f2726j0 = 306;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f2727k0 = 307;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f2728l0 = 308;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f2729m0 = 309;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f2730n0 = 310;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f2731o0 = 311;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f2732p0 = 312;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int f2733q0 = 5;
    private int A;
    private String B;
    private String C;
    private int D;
    private int E;
    float F;
    private boolean G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f2734J;
    private float K;
    private boolean L;
    int M;
    int N;
    int O;
    androidx.constraintlayout.core.motion.utils.e P;
    androidx.constraintlayout.core.motion.utils.e Q;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f2735y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f2736z = null;

    public g() {
        int i7 = b.f2683m;
        this.A = i7;
        this.B = null;
        this.C = null;
        this.D = i7;
        this.E = i7;
        this.F = 0.1f;
        this.G = true;
        this.H = true;
        this.I = true;
        this.f2734J = Float.NaN;
        this.L = false;
        this.M = i7;
        this.N = i7;
        this.O = i7;
        this.P = new androidx.constraintlayout.core.motion.utils.e();
        this.Q = new androidx.constraintlayout.core.motion.utils.e();
        this.f2698k = 5;
        this.f2699l = new HashMap<>();
    }

    private void x(String str, androidx.constraintlayout.core.motion.f fVar) {
        boolean z7 = str.length() == 1;
        if (!z7) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f2699l.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z7 || lowerCase.matches(str)) {
                androidx.constraintlayout.core.motion.b bVar = this.f2699l.get(str2);
                if (bVar != null) {
                    bVar.a(fVar);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        if (i7 == 307) {
            this.E = i8;
            return true;
        }
        if (i7 == 308) {
            this.D = u(Integer.valueOf(i8));
            return true;
        }
        if (i7 == 311) {
            this.A = i8;
            return true;
        }
        switch (i7) {
            case 301:
                this.O = i8;
                return true;
            case 302:
                this.N = i8;
                return true;
            case 303:
                this.M = i8;
                return true;
            default:
                return super.a(i7, i8);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        if (i7 != 305) {
            return super.b(i7, f8);
        }
        this.F = f8;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (i7 == 309) {
            this.C = str;
            return true;
        }
        if (i7 == 310) {
            this.B = str;
            return true;
        }
        if (i7 != 312) {
            return super.c(i7, str);
        }
        this.f2736z = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.b, androidx.constraintlayout.core.motion.utils.w
    public boolean d(int i7, boolean z7) {
        if (i7 != 304) {
            return super.d(i7, z7);
        }
        this.L = z7;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public int e(String str) {
        str.hashCode();
        switch (str) {
            case "positiveCross":
                return 309;
            case "viewTransitionOnPositiveCross":
                return 302;
            case "triggerCollisionId":
                return 307;
            case "triggerID":
                return 308;
            case "negativeCross":
                return 310;
            case "triggerCollisionView":
                return 306;
            case "viewTransitionOnNegativeCross":
                return 303;
            case "triggerSlack":
                return 305;
            case "viewTransitionOnCross":
                return 301;
            case "postLayout":
                return 304;
            case "triggerReceiver":
                return 311;
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
        return new g().h(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    public void i(HashSet<String> hashSet) {
    }

    public void v(float f8, androidx.constraintlayout.core.motion.f fVar) {
    }

    @Override // androidx.constraintlayout.core.motion.key.b
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public g h(b bVar) {
        super.h(bVar);
        g gVar = (g) bVar;
        this.f2735y = gVar.f2735y;
        this.f2736z = gVar.f2736z;
        this.A = gVar.A;
        this.B = gVar.B;
        this.C = gVar.C;
        this.D = gVar.D;
        this.E = gVar.E;
        this.F = gVar.F;
        this.G = gVar.G;
        this.H = gVar.H;
        this.I = gVar.I;
        this.f2734J = gVar.f2734J;
        this.K = gVar.K;
        this.L = gVar.L;
        this.P = gVar.P;
        this.Q = gVar.Q;
        return this;
    }
}
