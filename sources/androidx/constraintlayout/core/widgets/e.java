package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.state.r;
import androidx.constraintlayout.core.widgets.analyzer.p;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final boolean U0 = false;
    protected static final int V0 = 1;
    protected static final int W0 = 2;
    private static final boolean X0 = false;
    public static final int Y0 = 0;
    public static final int Z0 = 1;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f3573a1 = 2;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f3574b1 = 3;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final int f3575c1 = 4;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final int f3576d1 = -1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final int f3577e1 = 0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final int f3578f1 = 1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final int f3579g1 = 2;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final int f3580h1 = 0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final int f3581i1 = 4;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final int f3582j1 = 8;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f3583k1 = 0;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final int f3584l1 = 1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int f3585m1 = 2;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final int f3586n1 = 0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final int f3587o1 = 1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final int f3588p1 = 2;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final int f3589q1 = 3;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    private static final int f3590r1 = -2;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f3591s1 = 0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f3592t1 = 1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final int f3593u1 = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f3594v1 = 3;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final int f3595w1 = 4;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    static final int f3596x1 = 0;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    static final int f3597y1 = 1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static float f3598z1 = 0.5f;
    public int A;
    int A0;
    public float B;
    int B0;
    public int C;
    boolean C0;
    public int D;
    boolean D0;
    public float E;
    boolean E0;
    public boolean F;
    boolean F0;
    public boolean G;
    boolean G0;
    int H;
    boolean H0;
    float I;
    boolean I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int[] f3599J;
    int J0;
    private float K;
    int K0;
    private boolean L;
    boolean L0;
    private boolean M;
    boolean M0;
    private boolean N;
    public float[] N0;
    private int O;
    protected e[] O0;
    private int P;
    protected e[] P0;
    public d Q;
    e Q0;
    public d R;
    e R0;
    public d S;
    public int S0;
    public d T;
    public int T0;
    public d U;
    d V;
    d W;
    public d X;
    public d[] Y;
    protected ArrayList<d> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3600a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean[] f3601a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p[] f3602b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public b[] f3603b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f3604c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public e f3605c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f3606d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    int f3607d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.l f3608e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    int f3609e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.n f3610f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f3611f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f3612g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected int f3613g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f3614h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected int f3615h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3616i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    protected int f3617i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3618j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    int f3619j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f3620k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    int f3621k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3622l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    protected int f3623l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f3624m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected int f3625m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r f3626n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f3627n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3628o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected int f3629o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f3630p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected int f3631p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f3632q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    float f3633q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f3634r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    float f3635r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f3636s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Object f3637s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3638t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f3639t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3640u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private int f3641u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3642v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f3643v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3644w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private String f3645w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3646x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private String f3647x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f3648y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    int f3649y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3650z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    int f3651z0;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3653b;

        static {
            int[] iArr = new int[b.values().length];
            f3653b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3653b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3653b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3653b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.b.values().length];
            f3652a = iArr2;
            try {
                iArr2[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3652a[d.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3652a[d.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3652a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3652a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3652a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3652a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3652a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3652a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        this.f3600a = false;
        this.f3602b = new p[2];
        this.f3608e = null;
        this.f3610f = null;
        this.f3612g = new boolean[]{true, true};
        this.f3614h = false;
        this.f3616i = true;
        this.f3618j = false;
        this.f3620k = true;
        this.f3622l = -1;
        this.f3624m = -1;
        this.f3626n = new r(this);
        this.f3630p = false;
        this.f3632q = false;
        this.f3634r = false;
        this.f3636s = false;
        this.f3638t = -1;
        this.f3640u = -1;
        this.f3642v = 0;
        this.f3644w = 0;
        this.f3646x = 0;
        this.f3648y = new int[2];
        this.f3650z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.f3599J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new d(this, d.b.LEFT);
        this.R = new d(this, d.b.TOP);
        this.S = new d(this, d.b.RIGHT);
        this.T = new d(this, d.b.BOTTOM);
        this.U = new d(this, d.b.BASELINE);
        this.V = new d(this, d.b.CENTER_X);
        this.W = new d(this, d.b.CENTER_Y);
        d dVar = new d(this, d.b.CENTER);
        this.X = dVar;
        this.Y = new d[]{this.Q, this.S, this.R, this.T, this.U, dVar};
        this.Z = new ArrayList<>();
        this.f3601a0 = new boolean[2];
        b bVar = b.FIXED;
        this.f3603b0 = new b[]{bVar, bVar};
        this.f3605c0 = null;
        this.f3607d0 = 0;
        this.f3609e0 = 0;
        this.f3611f0 = 0.0f;
        this.f3613g0 = -1;
        this.f3615h0 = 0;
        this.f3617i0 = 0;
        this.f3619j0 = 0;
        this.f3621k0 = 0;
        this.f3623l0 = 0;
        this.f3625m0 = 0;
        this.f3627n0 = 0;
        float f8 = f3598z1;
        this.f3633q0 = f8;
        this.f3635r0 = f8;
        this.f3639t0 = 0;
        this.f3641u0 = 0;
        this.f3643v0 = false;
        this.f3645w0 = null;
        this.f3647x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new e[]{null, null};
        this.P0 = new e[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    private void Z0(StringBuilder sb, String str, d dVar) {
        if (dVar.f3558f == null) {
            return;
        }
        sb.append(str);
        sb.append(" : [ '");
        sb.append(dVar.f3558f);
        sb.append("',");
        sb.append(dVar.f3559g);
        sb.append(",");
        sb.append(dVar.f3560h);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private void a1(StringBuilder sb, String str, float f8, float f9) {
        if (f8 == f9) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f8);
        sb.append(",\n");
    }

    private void b1(StringBuilder sb, String str, int i7, int i8) {
        if (i7 == i8) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i7);
        sb.append(",\n");
    }

    private void c0(StringBuilder sb, String str, int i7, int i8, int i9, int i10, int i11, int i12, float f8, float f9) {
        sb.append(str);
        sb.append(" :  {\n");
        b1(sb, "      size", i7, 0);
        b1(sb, "      min", i8, 0);
        b1(sb, "      max", i9, Integer.MAX_VALUE);
        b1(sb, "      matchMin", i11, 0);
        b1(sb, "      matchDef", i12, 0);
        a1(sb, "      matchPercent", f8, 1.0f);
        sb.append("    },\n");
    }

    private void c1(StringBuilder sb, d dVar, float f8) {
        if (dVar.f3558f == null) {
            return;
        }
        sb.append("circle : [ '");
        sb.append(dVar.f3558f);
        sb.append("',");
        sb.append(dVar.f3559g);
        sb.append(",");
        sb.append(f8);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    private void d0(StringBuilder sb, String str, d dVar) {
        if (dVar.f3558f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(dVar.f3558f);
        sb.append("'");
        if (dVar.f3560h != Integer.MIN_VALUE || dVar.f3559g != 0) {
            sb.append(",");
            sb.append(dVar.f3559g);
            if (dVar.f3560h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(dVar.f3560h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    private void d1(StringBuilder sb, String str, float f8, int i7) {
        if (f8 == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f8);
        sb.append(",");
        sb.append(i7);
        sb.append("");
        sb.append("],\n");
    }

    private void e1(StringBuilder sb, String str, int i7, int i8, int i9, int i10, int i11, int i12, float f8, float f9) {
        sb.append(str);
        sb.append(" :  {\n");
        b1(sb, "size", i7, Integer.MIN_VALUE);
        b1(sb, "min", i8, 0);
        b1(sb, "max", i9, Integer.MAX_VALUE);
        b1(sb, "matchMin", i11, 0);
        b1(sb, "matchDef", i12, 0);
        b1(sb, "matchPercent", i12, 1);
        sb.append("},\n");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0177  */
    /* JADX WARN: Code duplicated, block: B:103:0x017f  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:112:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:241:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:243:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:249:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:251:0x0404  */
    /* JADX WARN: Code duplicated, block: B:258:0x041d  */
    /* JADX WARN: Code duplicated, block: B:267:0x043f  */
    /* JADX WARN: Code duplicated, block: B:277:0x0457  */
    /* JADX WARN: Code duplicated, block: B:280:0x045d  */
    /* JADX WARN: Code duplicated, block: B:281:0x045f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:284:0x0465 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:287:0x046a  */
    /* JADX WARN: Code duplicated, block: B:290:0x0470  */
    /* JADX WARN: Code duplicated, block: B:292:0x0474  */
    /* JADX WARN: Code duplicated, block: B:295:0x0479  */
    /* JADX WARN: Code duplicated, block: B:297:0x047d  */
    /* JADX WARN: Code duplicated, block: B:299:0x0480  */
    /* JADX WARN: Code duplicated, block: B:302:0x0487  */
    /* JADX WARN: Code duplicated, block: B:304:0x048d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:308:0x0495  */
    /* JADX WARN: Code duplicated, block: B:311:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:313:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:314:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:316:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:318:0x04b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:326:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:371:0x0550  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:67:0x0113  */
    /* JADX WARN: Code duplicated, block: B:69:0x0116  */
    /* JADX WARN: Code duplicated, block: B:70:0x0118  */
    /* JADX WARN: Code duplicated, block: B:72:0x011b  */
    /* JADX WARN: Code duplicated, block: B:73:0x011d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0120  */
    /* JADX WARN: Code duplicated, block: B:79:0x0126  */
    /* JADX WARN: Code duplicated, block: B:81:0x0131  */
    /* JADX WARN: Code duplicated, block: B:82:0x0133  */
    /* JADX WARN: Code duplicated, block: B:85:0x0138  */
    /* JADX WARN: Code duplicated, block: B:87:0x013b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0141  */
    /* JADX WARN: Code duplicated, block: B:90:0x0148  */
    /* JADX WARN: Code duplicated, block: B:93:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x014f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0156  */
    /* JADX WARN: Code duplicated, block: B:97:0x015e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0173  */
    private void i(androidx.constraintlayout.core.e eVar, boolean z7, boolean z8, boolean z9, boolean z10, androidx.constraintlayout.core.i iVar, androidx.constraintlayout.core.i iVar2, b bVar, boolean z11, d dVar, d dVar2, int i7, int i8, int i9, int i10, float f8, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i11, int i12, int i13, int i14, float f9, boolean z17) {
        int i15;
        boolean z18;
        int iMin;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z19;
        boolean z20;
        d.b bVarL;
        d.b bVar2;
        androidx.constraintlayout.core.i iVarU;
        androidx.constraintlayout.core.i iVarU2;
        boolean z21;
        int i22;
        char c8;
        int i23;
        d dVar3;
        int i24;
        int i25;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        int i26;
        e eVar2;
        boolean z26;
        e eVar3;
        int iMax;
        int i27;
        int i28;
        int iG;
        int iMin2;
        int i29;
        int i30;
        boolean z27;
        int i31;
        int i32;
        int i33;
        boolean z28;
        int i34;
        boolean z29;
        e eVar4;
        int i35;
        e eVar5;
        androidx.constraintlayout.core.i iVarU3 = eVar.u(dVar);
        androidx.constraintlayout.core.i iVarU4 = eVar.u(dVar2);
        androidx.constraintlayout.core.i iVarU5 = eVar.u(dVar.k());
        androidx.constraintlayout.core.i iVarU6 = eVar.u(dVar2.k());
        if (androidx.constraintlayout.core.e.L() != null) {
            androidx.constraintlayout.core.e.L().H++;
        }
        boolean zP = dVar.p();
        boolean zP2 = dVar2.p();
        boolean zP3 = this.X.p();
        int i36 = zP2 ? (zP ? 1 : 0) + 1 : zP ? 1 : 0;
        if (zP3) {
            i36++;
        }
        int i37 = z12 ? 3 : i11;
        int i38 = a.f3653b[bVar.ordinal()];
        if (i38 != 1 && i38 != 2 && i38 != 3 && i38 == 4) {
            i15 = i37;
            z18 = i15 != 4;
            iMin = this.f3622l;
            if (iMin == -1 && z7) {
                this.f3622l = -1;
                z18 = false;
            } else {
                iMin = i8;
            }
            i16 = this.f3624m;
            if (i16 != -1 && !z7) {
                this.f3624m = -1;
                iMin = i16;
                z18 = false;
            }
            if (this.f3641u0 == 8) {
                iMin = 0;
                z18 = false;
            }
            if (z17) {
                if (zP && !zP2 && !zP3) {
                    eVar.f(iVarU3, i7);
                } else if (zP && !zP2) {
                    eVar.e(iVarU3, iVarU5, dVar.g(), 8);
                }
            }
            if (!z18) {
                if (z11) {
                    eVar.e(iVarU4, iVarU3, 0, 3);
                    if (i9 > 0) {
                        eVar.i(iVarU4, iVarU3, i9, 8);
                    }
                    if (i10 < Integer.MAX_VALUE) {
                        eVar.k(iVarU4, iVarU3, i10, 8);
                    }
                } else {
                    eVar.e(iVarU4, iVarU3, iMin, 8);
                }
                i18 = i14;
                i20 = i36;
                z19 = z18;
                z20 = z10;
                i21 = i13;
            } else if (i36 == 2 && !z12 && (i15 == 1 || i15 == 0)) {
                int iMax2 = Math.max(i13, iMin);
                if (i14 > 0) {
                    iMax2 = Math.min(i14, iMax2);
                }
                eVar.e(iVarU4, iVarU3, iMax2, 8);
                z20 = z10;
                i18 = i14;
                i20 = i36;
                z19 = false;
                i21 = i13;
            } else {
                if (i13 == -2) {
                    i17 = iMin;
                } else {
                    i17 = i13;
                }
                if (i14 == -2) {
                    i18 = iMin;
                } else {
                    i18 = i14;
                }
                if (iMin > 0 && i15 != 1) {
                    iMin = 0;
                }
                if (i17 > 0) {
                    eVar.i(iVarU4, iVarU3, i17, 8);
                    iMin = Math.max(iMin, i17);
                }
                if (i18 > 0) {
                    if (z8 || i15 != 1) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    if (z21) {
                        i19 = 8;
                        eVar.k(iVarU4, iVarU3, i18, 8);
                    } else {
                        i19 = 8;
                    }
                    iMin = Math.min(iMin, i18);
                } else {
                    i19 = 8;
                }
                if (i15 == 1) {
                    if (z8) {
                        eVar.e(iVarU4, iVarU3, iMin, i19);
                    } else if (z14) {
                        eVar.e(iVarU4, iVarU3, iMin, 5);
                        eVar.k(iVarU4, iVarU3, iMin, i19);
                    } else {
                        eVar.e(iVarU4, iVarU3, iMin, 5);
                        eVar.k(iVarU4, iVarU3, iMin, i19);
                    }
                    i20 = i36;
                    z19 = z18;
                    z20 = z10;
                    i21 = i17;
                } else if (i15 == 2) {
                    bVarL = dVar.l();
                    bVar2 = d.b.TOP;
                    if (bVarL != bVar2 || dVar.l() == d.b.BOTTOM) {
                        iVarU = eVar.u(this.f3605c0.r(bVar2));
                        iVarU2 = eVar.u(this.f3605c0.r(d.b.BOTTOM));
                    } else {
                        iVarU = eVar.u(this.f3605c0.r(d.b.LEFT));
                        iVarU2 = eVar.u(this.f3605c0.r(d.b.RIGHT));
                    }
                    androidx.constraintlayout.core.i iVar3 = iVarU;
                    androidx.constraintlayout.core.b bVarV = eVar.v();
                    i20 = i36 == true ? 1 : 0;
                    i21 = i17;
                    eVar.d(bVarV.n(iVarU4, iVarU3, iVarU2, iVar3, f9));
                    if (z8) {
                        z18 = false;
                    }
                    z19 = z18;
                    z20 = z10;
                } else {
                    i20 = i36;
                    i21 = i17;
                    z19 = z18;
                    z20 = true;
                }
            }
            if (z17 || z14) {
                i22 = 0;
                c8 = 2;
                if (i20 >= c8 && z8 && z20) {
                    eVar.i(iVarU3, iVar, i22, 8);
                    int i39 = (z7 || this.U.f3558f == null) ? 1 : i22;
                    if (z7 || (dVar3 = this.U.f3558f) == null) {
                        i23 = i39;
                    } else {
                        e eVar6 = dVar3.f3556d;
                        if (eVar6.f3611f0 != 0.0f) {
                            b[] bVarArr = eVar6.f3603b0;
                            b bVar3 = bVarArr[i22];
                            b bVar4 = b.MATCH_CONSTRAINT;
                            if (bVar3 == bVar4 && bVarArr[1] == bVar4) {
                                i23 = 1;
                            } else {
                                i23 = i22;
                            }
                        } else {
                            i23 = i22;
                        }
                    }
                    if (i23 != 0) {
                        eVar.i(iVar2, iVarU4, i22, 8);
                        return;
                    }
                    return;
                }
                return;
            }
            if (zP || zP2 || zP3) {
                if (!zP || zP2) {
                    if (zP || !zP2) {
                        if (zP && zP2) {
                            e eVar7 = dVar.f3558f.f3556d;
                            e eVar8 = dVar2.f3558f.f3556d;
                            e eVarU = U();
                            int i40 = 6;
                            if (z19) {
                                if (i15 == 0) {
                                    if (i18 != 0 || i21 != 0) {
                                        z28 = false;
                                        i32 = 5;
                                        i34 = 5;
                                        z29 = true;
                                        z22 = true;
                                    } else if (iVarU5.f2477g && iVarU6.f2477g) {
                                        eVar.e(iVarU3, iVarU5, dVar.g(), 8);
                                        eVar.e(iVarU4, iVarU6, -dVar2.g(), 8);
                                        return;
                                    } else {
                                        z29 = false;
                                        z22 = false;
                                        i32 = 8;
                                        i34 = 8;
                                        z28 = true;
                                    }
                                    if ((eVar7 instanceof androidx.constraintlayout.core.widgets.a) || (eVar8 instanceof androidx.constraintlayout.core.widgets.a)) {
                                        iVar2 = iVar2;
                                        i24 = i32;
                                        i40 = 6;
                                        z24 = z28;
                                        z23 = z29;
                                        i25 = 4;
                                    } else {
                                        z24 = z28;
                                        z23 = z29;
                                        i25 = i34;
                                        i24 = i32;
                                        i40 = 6;
                                    }
                                } else if (i15 == 2) {
                                    if (!(eVar7 instanceof androidx.constraintlayout.core.widgets.a) && !(eVar8 instanceof androidx.constraintlayout.core.widgets.a)) {
                                        iVar2 = iVar2;
                                        i40 = 6;
                                        i24 = 5;
                                        i25 = 5;
                                    }
                                    z23 = true;
                                    z22 = true;
                                    z24 = false;
                                } else if (i15 == 1) {
                                    i24 = 8;
                                    i25 = 4;
                                    z23 = true;
                                    z22 = true;
                                    z24 = false;
                                } else if (i15 == 3) {
                                    if (this.H == -1) {
                                        if (z15) {
                                            iVar2 = iVar2;
                                            i40 = z8 ? 5 : 4;
                                        } else {
                                            iVar2 = iVar2;
                                            i40 = 8;
                                        }
                                        i24 = 8;
                                    } else if (z12) {
                                        if (i12 == 2 || i12 == 1) {
                                            i32 = 5;
                                            i33 = 4;
                                        } else {
                                            i32 = 8;
                                            i33 = 5;
                                        }
                                        i25 = i33;
                                        z23 = true;
                                        z22 = true;
                                        z24 = true;
                                        i24 = i32;
                                        i40 = 6;
                                    } else {
                                        if (i18 > 0) {
                                            iVar2 = iVar2;
                                            i40 = 6;
                                            i24 = 5;
                                        } else {
                                            if (i18 != 0 || i21 != 0) {
                                                i24 = 5;
                                            } else if (z15) {
                                                i24 = (eVar7 == eVarU || eVar8 == eVarU) ? 5 : 4;
                                            } else {
                                                iVar2 = iVar2;
                                                i40 = 6;
                                                i24 = 5;
                                                i25 = 8;
                                            }
                                            i25 = 4;
                                        }
                                        z23 = true;
                                        z22 = true;
                                        z24 = true;
                                    }
                                    i25 = 5;
                                    z23 = true;
                                    z22 = true;
                                    z24 = true;
                                } else {
                                    iVar2 = iVar2;
                                    i40 = 6;
                                    i24 = 5;
                                    i25 = 4;
                                    z23 = false;
                                    z22 = false;
                                    z24 = false;
                                }
                                if (z22 || iVarU5 != iVarU6 || eVar7 == eVarU) {
                                    z25 = true;
                                } else {
                                    z22 = false;
                                    z25 = false;
                                }
                                if (z23) {
                                    if (z19 && !z13 && !z15 && iVarU5 == iVar && iVarU6 == iVar2) {
                                        z26 = false;
                                        i31 = 8;
                                        i30 = 8;
                                        z27 = false;
                                    } else {
                                        z26 = z8;
                                        i30 = i40;
                                        z27 = z25;
                                        i31 = i24;
                                    }
                                    i26 = i15;
                                    eVar2 = eVarU;
                                    eVar.c(iVarU3, iVarU5, dVar.g(), f8, iVarU6, iVarU4, dVar2.g(), i30);
                                    i24 = i31;
                                    z25 = z27;
                                } else {
                                    i26 = i15;
                                    eVar2 = eVarU;
                                    z26 = z8;
                                }
                                if (this.f3641u0 != 8 && !dVar2.n()) {
                                    return;
                                }
                                if (z22) {
                                    if (z26 && iVarU5 != iVarU6 && !z19 && ((eVar7 instanceof androidx.constraintlayout.core.widgets.a) || (eVar8 instanceof androidx.constraintlayout.core.widgets.a))) {
                                        i24 = 6;
                                    }
                                    eVar.i(iVarU3, iVarU5, dVar.g(), i24);
                                    iVarU4 = iVarU4;
                                    eVar.k(iVarU4, iVarU6, -dVar2.g(), i24);
                                } else {
                                    iVarU4 = iVarU4;
                                }
                                if (z26 || !z16 || (eVar7 instanceof androidx.constraintlayout.core.widgets.a) || (eVar8 instanceof androidx.constraintlayout.core.widgets.a)) {
                                    eVar3 = eVar2;
                                } else {
                                    eVar3 = eVar2;
                                    if (eVar8 != eVar3) {
                                        i24 = 6;
                                        iMax = 6;
                                        z25 = true;
                                    }
                                    if (z25) {
                                        if (z24 && (!z15 || z9)) {
                                            if (eVar7 != eVar3 || eVar8 == eVar3) {
                                                i29 = 6;
                                            } else {
                                                i29 = iMax;
                                            }
                                            if ((eVar7 instanceof h) || (eVar8 instanceof h)) {
                                                i29 = 5;
                                            }
                                            if ((eVar7 instanceof androidx.constraintlayout.core.widgets.a) || (eVar8 instanceof androidx.constraintlayout.core.widgets.a)) {
                                                i29 = 5;
                                            }
                                            if (z15) {
                                                i29 = 5;
                                            }
                                            iMax = Math.max(i29, iMax);
                                        }
                                        if (z26) {
                                            iMin2 = Math.min(i24, iMax);
                                            if (z12 || z15 || !(eVar7 == eVar3 || eVar8 == eVar3)) {
                                                iMax = iMin2;
                                            } else {
                                                iMax = 4;
                                            }
                                        }
                                        eVar.e(iVarU3, iVarU5, dVar.g(), iMax);
                                        eVar.e(iVarU4, iVarU6, -dVar2.g(), iMax);
                                    }
                                    if (z26) {
                                        if (iVar == iVarU5) {
                                            iG = dVar.g();
                                        } else {
                                            iG = 0;
                                        }
                                        if (iVarU5 != iVar) {
                                            eVar.i(iVarU3, iVar, iG, 5);
                                        }
                                    }
                                    if (z26 || !z19 || i9 != 0 || i21 != 0) {
                                        i27 = 5;
                                        i28 = 0;
                                    } else if (z19 && i26 == 3) {
                                        i28 = 0;
                                        eVar.i(iVarU4, iVarU3, 0, 8);
                                        i27 = 5;
                                    } else {
                                        i28 = 0;
                                        i27 = 5;
                                        eVar.i(iVarU4, iVarU3, 0, 5);
                                    }
                                }
                                iMax = i25;
                                if (z25) {
                                    if (z24) {
                                        if (eVar7 != eVar3) {
                                            i29 = 6;
                                        } else {
                                            i29 = 6;
                                        }
                                        if (eVar7 instanceof h) {
                                            i29 = 5;
                                        } else {
                                            i29 = 5;
                                        }
                                        if (eVar7 instanceof androidx.constraintlayout.core.widgets.a) {
                                            i29 = 5;
                                        } else {
                                            i29 = 5;
                                        }
                                        if (z15) {
                                            i29 = 5;
                                        }
                                        iMax = Math.max(i29, iMax);
                                    }
                                    if (z26) {
                                        iMin2 = Math.min(i24, iMax);
                                        if (z12) {
                                            iMax = iMin2;
                                        } else {
                                            iMax = iMin2;
                                        }
                                    }
                                    eVar.e(iVarU3, iVarU5, dVar.g(), iMax);
                                    eVar.e(iVarU4, iVarU6, -dVar2.g(), iMax);
                                }
                                if (z26) {
                                    if (iVar == iVarU5) {
                                        iG = dVar.g();
                                    } else {
                                        iG = 0;
                                    }
                                    if (iVarU5 != iVar) {
                                        eVar.i(iVarU3, iVar, iG, 5);
                                    }
                                }
                                if (z26) {
                                    i27 = 5;
                                    i28 = 0;
                                } else {
                                    i27 = 5;
                                    i28 = 0;
                                }
                            } else if (iVarU5.f2477g && iVarU6.f2477g) {
                                eVar.c(iVarU3, iVarU5, dVar.g(), f8, iVarU6, iVarU4, dVar2.g(), 8);
                                if (z8 && z20) {
                                    int iG2 = dVar2.f3558f != null ? dVar2.g() : 0;
                                    if (iVarU6 != iVar2) {
                                        eVar.i(iVar2, iVarU4, iG2, 5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            i24 = 5;
                            i25 = 4;
                            z23 = true;
                            z22 = true;
                            z24 = false;
                            if (z22) {
                                z25 = true;
                            } else {
                                z25 = true;
                            }
                            if (z23) {
                                if (z19) {
                                    z26 = z8;
                                    i30 = i40;
                                    z27 = z25;
                                    i31 = i24;
                                } else {
                                    z26 = z8;
                                    i30 = i40;
                                    z27 = z25;
                                    i31 = i24;
                                }
                                i26 = i15;
                                eVar2 = eVarU;
                                eVar.c(iVarU3, iVarU5, dVar.g(), f8, iVarU6, iVarU4, dVar2.g(), i30);
                                i24 = i31;
                                z25 = z27;
                            } else {
                                i26 = i15;
                                eVar2 = eVarU;
                                z26 = z8;
                            }
                            if (this.f3641u0 != 8) {
                            }
                            if (z22) {
                                if (z26) {
                                    i24 = 6;
                                }
                                eVar.i(iVarU3, iVarU5, dVar.g(), i24);
                                iVarU4 = iVarU4;
                                eVar.k(iVarU4, iVarU6, -dVar2.g(), i24);
                            } else {
                                iVarU4 = iVarU4;
                            }
                            if (z26) {
                                eVar3 = eVar2;
                                iMax = i25;
                            } else {
                                eVar3 = eVar2;
                                iMax = i25;
                            }
                            if (z25) {
                                if (z24) {
                                    if (eVar7 != eVar3) {
                                        i29 = 6;
                                    } else {
                                        i29 = 6;
                                    }
                                    if (eVar7 instanceof h) {
                                        i29 = 5;
                                    } else {
                                        i29 = 5;
                                    }
                                    if (eVar7 instanceof androidx.constraintlayout.core.widgets.a) {
                                        i29 = 5;
                                    } else {
                                        i29 = 5;
                                    }
                                    if (z15) {
                                        i29 = 5;
                                    }
                                    iMax = Math.max(i29, iMax);
                                }
                                if (z26) {
                                    iMin2 = Math.min(i24, iMax);
                                    if (z12) {
                                        iMax = iMin2;
                                    } else {
                                        iMax = iMin2;
                                    }
                                }
                                eVar.e(iVarU3, iVarU5, dVar.g(), iMax);
                                eVar.e(iVarU4, iVarU6, -dVar2.g(), iMax);
                            }
                            if (z26) {
                                if (iVar == iVarU5) {
                                    iG = dVar.g();
                                } else {
                                    iG = 0;
                                }
                                if (iVarU5 != iVar) {
                                    eVar.i(iVarU3, iVar, iG, 5);
                                }
                            }
                            if (z26) {
                                i27 = 5;
                                i28 = 0;
                            } else {
                                i27 = 5;
                                i28 = 0;
                            }
                        }
                        i35 = i27;
                    } else {
                        eVar.e(iVarU4, iVarU6, -dVar2.g(), 8);
                        if (z8) {
                            if (this.f3618j && iVarU3.f2477g && (eVar4 = this.f3605c0) != null) {
                                f fVar = (f) eVar4;
                                if (z7) {
                                    fVar.u2(dVar);
                                } else {
                                    fVar.z2(dVar);
                                }
                            } else {
                                i27 = 5;
                                eVar.i(iVarU3, iVar, 0, 5);
                                i28 = 0;
                            }
                        }
                    }
                    i28 = 0;
                    i27 = 5;
                } else {
                    z26 = z8;
                    i28 = 0;
                    i35 = (z8 && (dVar.f3558f.f3556d instanceof androidx.constraintlayout.core.widgets.a)) ? 8 : 5;
                    iVarU4 = iVarU4;
                }
                if (z26 || !z20) {
                    return;
                }
                int iG3 = dVar2.f3558f != null ? dVar2.g() : i28;
                if (iVarU6 != iVar2) {
                    if (!this.f3618j || !iVarU4.f2477g || (eVar5 = this.f3605c0) == null) {
                        eVar.i(iVar2, iVarU4, iG3, i35);
                        return;
                    }
                    f fVar2 = (f) eVar5;
                    if (z7) {
                        fVar2.t2(dVar2);
                        return;
                    } else {
                        fVar2.y2(dVar2);
                        return;
                    }
                }
                return;
            }
            i27 = 5;
            i28 = 0;
            z26 = z8;
            i35 = i27;
            if (z26) {
                return;
            } else {
                return;
            }
        }
        i15 = i37;
        iMin = this.f3622l;
        if (iMin == -1) {
            iMin = i8;
        } else {
            iMin = i8;
        }
        i16 = this.f3624m;
        if (i16 != -1) {
            this.f3624m = -1;
            iMin = i16;
            z18 = false;
        }
        if (this.f3641u0 == 8) {
            iMin = 0;
            z18 = false;
        }
        if (z17) {
            if (zP) {
                if (zP) {
                    eVar.e(iVarU3, iVarU5, dVar.g(), 8);
                }
            } else if (zP) {
                eVar.e(iVarU3, iVarU5, dVar.g(), 8);
            }
        }
        if (!z18) {
            if (z11) {
                eVar.e(iVarU4, iVarU3, 0, 3);
                if (i9 > 0) {
                    eVar.i(iVarU4, iVarU3, i9, 8);
                }
                if (i10 < Integer.MAX_VALUE) {
                    eVar.k(iVarU4, iVarU3, i10, 8);
                }
            } else {
                eVar.e(iVarU4, iVarU3, iMin, 8);
            }
            i18 = i14;
            i20 = i36;
            z19 = z18;
            z20 = z10;
            i21 = i13;
        } else if (i36 == 2) {
            if (i13 == -2) {
                i17 = iMin;
            } else {
                i17 = i13;
            }
            if (i14 == -2) {
                i18 = iMin;
            } else {
                i18 = i14;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i17 > 0) {
                eVar.i(iVarU4, iVarU3, i17, 8);
                iMin = Math.max(iMin, i17);
            }
            if (i18 > 0) {
                if (z8) {
                    z21 = true;
                } else {
                    z21 = true;
                }
                if (z21) {
                    i19 = 8;
                    eVar.k(iVarU4, iVarU3, i18, 8);
                } else {
                    i19 = 8;
                }
                iMin = Math.min(iMin, i18);
            } else {
                i19 = 8;
            }
            if (i15 == 1) {
                if (z8) {
                    eVar.e(iVarU4, iVarU3, iMin, i19);
                } else if (z14) {
                    eVar.e(iVarU4, iVarU3, iMin, 5);
                    eVar.k(iVarU4, iVarU3, iMin, i19);
                } else {
                    eVar.e(iVarU4, iVarU3, iMin, 5);
                    eVar.k(iVarU4, iVarU3, iMin, i19);
                }
                i20 = i36;
                z19 = z18;
                z20 = z10;
                i21 = i17;
            } else if (i15 == 2) {
                bVarL = dVar.l();
                bVar2 = d.b.TOP;
                if (bVarL != bVar2) {
                    iVarU = eVar.u(this.f3605c0.r(bVar2));
                    iVarU2 = eVar.u(this.f3605c0.r(d.b.BOTTOM));
                } else {
                    iVarU = eVar.u(this.f3605c0.r(bVar2));
                    iVarU2 = eVar.u(this.f3605c0.r(d.b.BOTTOM));
                }
                androidx.constraintlayout.core.i iVar4 = iVarU;
                androidx.constraintlayout.core.b bVarV2 = eVar.v();
                i20 = i36 == true ? 1 : 0;
                i21 = i17;
                eVar.d(bVarV2.n(iVarU4, iVarU3, iVarU2, iVar4, f9));
                if (z8) {
                    z18 = false;
                }
                z19 = z18;
                z20 = z10;
            } else {
                i20 = i36;
                i21 = i17;
                z19 = z18;
                z20 = true;
            }
        } else {
            if (i13 == -2) {
                i17 = iMin;
            } else {
                i17 = i13;
            }
            if (i14 == -2) {
                i18 = iMin;
            } else {
                i18 = i14;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i17 > 0) {
                eVar.i(iVarU4, iVarU3, i17, 8);
                iMin = Math.max(iMin, i17);
            }
            if (i18 > 0) {
                if (z8) {
                    z21 = true;
                } else {
                    z21 = true;
                }
                if (z21) {
                    i19 = 8;
                    eVar.k(iVarU4, iVarU3, i18, 8);
                } else {
                    i19 = 8;
                }
                iMin = Math.min(iMin, i18);
            } else {
                i19 = 8;
            }
            if (i15 == 1) {
                if (z8) {
                    eVar.e(iVarU4, iVarU3, iMin, i19);
                } else if (z14) {
                    eVar.e(iVarU4, iVarU3, iMin, 5);
                    eVar.k(iVarU4, iVarU3, iMin, i19);
                } else {
                    eVar.e(iVarU4, iVarU3, iMin, 5);
                    eVar.k(iVarU4, iVarU3, iMin, i19);
                }
                i20 = i36;
                z19 = z18;
                z20 = z10;
                i21 = i17;
            } else if (i15 == 2) {
                bVarL = dVar.l();
                bVar2 = d.b.TOP;
                if (bVarL != bVar2) {
                    iVarU = eVar.u(this.f3605c0.r(bVar2));
                    iVarU2 = eVar.u(this.f3605c0.r(d.b.BOTTOM));
                } else {
                    iVarU = eVar.u(this.f3605c0.r(bVar2));
                    iVarU2 = eVar.u(this.f3605c0.r(d.b.BOTTOM));
                }
                androidx.constraintlayout.core.i iVar5 = iVarU;
                androidx.constraintlayout.core.b bVarV3 = eVar.v();
                i20 = i36 == true ? 1 : 0;
                i21 = i17;
                eVar.d(bVarV3.n(iVarU4, iVarU3, iVarU2, iVar5, f9));
                if (z8) {
                    z18 = false;
                }
                z19 = z18;
                z20 = z10;
            } else {
                i20 = i36;
                i21 = i17;
                z19 = z18;
                z20 = true;
            }
        }
        if (z17) {
            i22 = 0;
            c8 = 2;
        } else {
            i22 = 0;
            c8 = 2;
        }
        if (i20 >= c8) {
        }
    }

    private boolean x0(int i7) {
        d dVar;
        d dVar2;
        int i8 = i7 * 2;
        d[] dVarArr = this.Y;
        d dVar3 = dVarArr[i8];
        d dVar4 = dVar3.f3558f;
        return (dVar4 == null || dVar4.f3558f == dVar3 || (dVar2 = (dVar = dVarArr[i8 + 1]).f3558f) == null || dVar2.f3558f != dVar) ? false : true;
    }

    public float A() {
        return this.f3611f0;
    }

    public boolean A0(int i7) {
        return this.f3601a0[i7];
    }

    public void A1(float f8) {
        this.f3633q0 = f8;
    }

    public int B() {
        return this.f3613g0;
    }

    public boolean B0() {
        d dVar = this.Q;
        d dVar2 = dVar.f3558f;
        if (dVar2 != null && dVar2.f3558f == dVar) {
            return true;
        }
        d dVar3 = this.S;
        d dVar4 = dVar3.f3558f;
        return dVar4 != null && dVar4.f3558f == dVar3;
    }

    public void B1(int i7) {
        this.J0 = i7;
    }

    public boolean C() {
        return this.L;
    }

    public boolean C0() {
        return this.M;
    }

    public void C1(int i7, int i8) {
        this.f3615h0 = i7;
        int i9 = i8 - i7;
        this.f3607d0 = i9;
        int i10 = this.f3629o0;
        if (i9 < i10) {
            this.f3607d0 = i10;
        }
    }

    public int D() {
        if (this.f3641u0 == 8) {
            return 0;
        }
        return this.f3609e0;
    }

    public boolean D0() {
        d dVar = this.R;
        d dVar2 = dVar.f3558f;
        if (dVar2 != null && dVar2.f3558f == dVar) {
            return true;
        }
        d dVar3 = this.T;
        d dVar4 = dVar3.f3558f;
        return dVar4 != null && dVar4.f3558f == dVar3;
    }

    public void D1(b bVar) {
        this.f3603b0[0] = bVar;
    }

    public float E() {
        return this.f3633q0;
    }

    public boolean E0() {
        return this.N;
    }

    public void E1(int i7, int i8, int i9, float f8) {
        this.f3644w = i7;
        this.f3650z = i8;
        if (i9 == Integer.MAX_VALUE) {
            i9 = 0;
        }
        this.A = i9;
        this.B = f8;
        if (f8 <= 0.0f || f8 >= 1.0f || i7 != 0) {
            return;
        }
        this.f3644w = 2;
    }

    public e F() {
        if (!B0()) {
            return null;
        }
        e eVar = this;
        e eVar2 = null;
        while (eVar2 == null && eVar != null) {
            d dVarR = eVar.r(d.b.LEFT);
            d dVarK = dVarR == null ? null : dVarR.k();
            e eVarI = dVarK == null ? null : dVarK.i();
            if (eVarI == U()) {
                return eVar;
            }
            d dVarK2 = eVarI == null ? null : eVarI.r(d.b.RIGHT).k();
            if (dVarK2 == null || dVarK2.i() == eVar) {
                eVar = eVarI;
            } else {
                eVar2 = eVar;
            }
        }
        return eVar2;
    }

    public boolean F0() {
        return this.f3616i && this.f3641u0 != 8;
    }

    public void F1(float f8) {
        this.N0[0] = f8;
    }

    public int G() {
        return this.J0;
    }

    public boolean G0() {
        return this.f3630p || (this.Q.o() && this.S.o());
    }

    protected void G1(int i7, boolean z7) {
        this.f3601a0[i7] = z7;
    }

    public b H() {
        return this.f3603b0[0];
    }

    public boolean H0() {
        return this.f3632q || (this.R.o() && this.T.o());
    }

    public void H1(boolean z7) {
        this.M = z7;
    }

    public int I() {
        d dVar = this.Q;
        int i7 = dVar != null ? 0 + dVar.f3559g : 0;
        d dVar2 = this.S;
        return dVar2 != null ? i7 + dVar2.f3559g : i7;
    }

    public boolean I0() {
        return this.f3605c0 == null;
    }

    public void I1(boolean z7) {
        this.N = z7;
    }

    public int J() {
        return this.O;
    }

    public boolean J0() {
        return this.f3646x == 0 && this.f3611f0 == 0.0f && this.C == 0 && this.D == 0 && this.f3603b0[1] == b.MATCH_CONSTRAINT;
    }

    public void J1(int i7, int i8) {
        this.O = i7;
        this.P = i8;
        N1(false);
    }

    public int K() {
        return this.P;
    }

    public boolean K0() {
        return this.f3644w == 0 && this.f3611f0 == 0.0f && this.f3650z == 0 && this.A == 0 && this.f3603b0[0] == b.MATCH_CONSTRAINT;
    }

    public void K1(int i7, int i8) {
        if (i8 == 0) {
            c2(i7);
        } else if (i8 == 1) {
            y1(i7);
        }
    }

    public int L() {
        return o0();
    }

    public boolean L0() {
        return this.f3636s;
    }

    public void L1(int i7) {
        this.f3599J[1] = i7;
    }

    public int M(int i7) {
        if (i7 == 0) {
            return m0();
        }
        if (i7 == 1) {
            return D();
        }
        return 0;
    }

    public boolean M0() {
        return this.F;
    }

    public void M1(int i7) {
        this.f3599J[0] = i7;
    }

    public int N() {
        return this.f3599J[1];
    }

    public void N0() {
        this.f3634r = true;
    }

    public void N1(boolean z7) {
        this.f3616i = z7;
    }

    public int O() {
        return this.f3599J[0];
    }

    public void O0() {
        this.f3636s = true;
    }

    public void O1(int i7) {
        if (i7 < 0) {
            this.f3631p0 = 0;
        } else {
            this.f3631p0 = i7;
        }
    }

    public int P() {
        return this.f3631p0;
    }

    public boolean P0(int i7) {
        char c8 = i7 == 0 ? (char) 1 : (char) 0;
        b[] bVarArr = this.f3603b0;
        b bVar = bVarArr[i7];
        b bVar2 = bVarArr[c8];
        b bVar3 = b.MATCH_CONSTRAINT;
        return bVar == bVar3 && bVar2 == bVar3;
    }

    public void P1(int i7) {
        if (i7 < 0) {
            this.f3629o0 = 0;
        } else {
            this.f3629o0 = i7;
        }
    }

    public int Q() {
        return this.f3629o0;
    }

    public boolean Q0() {
        b[] bVarArr = this.f3603b0;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public void Q1(int i7, int i8) {
        this.f3623l0 = i7;
        this.f3625m0 = i8;
    }

    public e R(int i7) {
        d dVar;
        d dVar2;
        if (i7 != 0) {
            if (i7 == 1 && (dVar2 = (dVar = this.T).f3558f) != null && dVar2.f3558f == dVar) {
                return dVar2.f3556d;
            }
            return null;
        }
        d dVar3 = this.S;
        d dVar4 = dVar3.f3558f;
        if (dVar4 == null || dVar4.f3558f != dVar3) {
            return null;
        }
        return dVar4.f3556d;
    }

    public void R0() {
        this.Q.x();
        this.R.x();
        this.S.x();
        this.T.x();
        this.U.x();
        this.V.x();
        this.W.x();
        this.X.x();
        this.f3605c0 = null;
        this.K = 0.0f;
        this.f3607d0 = 0;
        this.f3609e0 = 0;
        this.f3611f0 = 0.0f;
        this.f3613g0 = -1;
        this.f3615h0 = 0;
        this.f3617i0 = 0;
        this.f3623l0 = 0;
        this.f3625m0 = 0;
        this.f3627n0 = 0;
        this.f3629o0 = 0;
        this.f3631p0 = 0;
        float f8 = f3598z1;
        this.f3633q0 = f8;
        this.f3635r0 = f8;
        b[] bVarArr = this.f3603b0;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f3637s0 = null;
        this.f3639t0 = 0;
        this.f3641u0 = 0;
        this.f3647x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f3638t = -1;
        this.f3640u = -1;
        int[] iArr = this.f3599J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f3644w = 0;
        this.f3646x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.f3650z = 0;
        this.C = 0;
        this.f3614h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.f3612g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.f3601a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f3616i = true;
        int[] iArr2 = this.f3648y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f3622l = -1;
        this.f3624m = -1;
    }

    public void R1(int i7, int i8) {
        this.f3615h0 = i7;
        this.f3617i0 = i8;
    }

    public int S() {
        int iMax;
        int i7 = this.f3609e0;
        if (this.f3603b0[1] != b.MATCH_CONSTRAINT) {
            return i7;
        }
        if (this.f3646x == 1) {
            iMax = Math.max(this.C, i7);
        } else {
            iMax = this.C;
            if (iMax > 0) {
                this.f3609e0 = iMax;
            } else {
                iMax = 0;
            }
        }
        int i8 = this.D;
        return (i8 <= 0 || i8 >= iMax) ? iMax : i8;
    }

    public void S0() {
        U0();
        V1(f3598z1);
        A1(f3598z1);
    }

    public void S1(e eVar) {
        this.f3605c0 = eVar;
    }

    public int T() {
        int iMax;
        int i7 = this.f3607d0;
        if (this.f3603b0[0] != b.MATCH_CONSTRAINT) {
            return i7;
        }
        if (this.f3644w == 1) {
            iMax = Math.max(this.f3650z, i7);
        } else {
            iMax = this.f3650z;
            if (iMax > 0) {
                this.f3607d0 = iMax;
            } else {
                iMax = 0;
            }
        }
        int i8 = this.A;
        return (i8 <= 0 || i8 >= iMax) ? iMax : i8;
    }

    public void T0(d dVar) {
        if (U() != null && (U() instanceof f) && ((f) U()).K2()) {
            return;
        }
        d dVarR = r(d.b.LEFT);
        d dVarR2 = r(d.b.RIGHT);
        d dVarR3 = r(d.b.TOP);
        d dVarR4 = r(d.b.BOTTOM);
        d dVarR5 = r(d.b.CENTER);
        d dVarR6 = r(d.b.CENTER_X);
        d dVarR7 = r(d.b.CENTER_Y);
        if (dVar == dVarR5) {
            if (dVarR.p() && dVarR2.p() && dVarR.k() == dVarR2.k()) {
                dVarR.x();
                dVarR2.x();
            }
            if (dVarR3.p() && dVarR4.p() && dVarR3.k() == dVarR4.k()) {
                dVarR3.x();
                dVarR4.x();
            }
            this.f3633q0 = 0.5f;
            this.f3635r0 = 0.5f;
        } else if (dVar == dVarR6) {
            if (dVarR.p() && dVarR2.p() && dVarR.k().i() == dVarR2.k().i()) {
                dVarR.x();
                dVarR2.x();
            }
            this.f3633q0 = 0.5f;
        } else if (dVar == dVarR7) {
            if (dVarR3.p() && dVarR4.p() && dVarR3.k().i() == dVarR4.k().i()) {
                dVarR3.x();
                dVarR4.x();
            }
            this.f3635r0 = 0.5f;
        } else if (dVar == dVarR || dVar == dVarR2) {
            if (dVarR.p() && dVarR.k() == dVarR2.k()) {
                dVarR5.x();
            }
        } else if ((dVar == dVarR3 || dVar == dVarR4) && dVarR3.p() && dVarR3.k() == dVarR4.k()) {
            dVarR5.x();
        }
        dVar.x();
    }

    void T1(int i7, int i8) {
        if (i8 == 0) {
            this.f3619j0 = i7;
        } else if (i8 == 1) {
            this.f3621k0 = i7;
        }
    }

    public e U() {
        return this.f3605c0;
    }

    public void U0() {
        e eVarU = U();
        if (eVarU != null && (eVarU instanceof f) && ((f) U()).K2()) {
            return;
        }
        int size = this.Z.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.Z.get(i7).x();
        }
    }

    public void U1(String str) {
        this.f3647x0 = str;
    }

    public e V(int i7) {
        d dVar;
        d dVar2;
        if (i7 != 0) {
            if (i7 == 1 && (dVar2 = (dVar = this.R).f3558f) != null && dVar2.f3558f == dVar) {
                return dVar2.f3556d;
            }
            return null;
        }
        d dVar3 = this.Q;
        d dVar4 = dVar3.f3558f;
        if (dVar4 == null || dVar4.f3558f != dVar3) {
            return null;
        }
        return dVar4.f3556d;
    }

    public void V0() {
        this.f3630p = false;
        this.f3632q = false;
        this.f3634r = false;
        this.f3636s = false;
        int size = this.Z.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.Z.get(i7).y();
        }
    }

    public void V1(float f8) {
        this.f3635r0 = f8;
    }

    int W(int i7) {
        if (i7 == 0) {
            return this.f3619j0;
        }
        if (i7 == 1) {
            return this.f3621k0;
        }
        return 0;
    }

    public void W0(androidx.constraintlayout.core.c cVar) {
        this.Q.z(cVar);
        this.R.z(cVar);
        this.S.z(cVar);
        this.T.z(cVar);
        this.U.z(cVar);
        this.X.z(cVar);
        this.V.z(cVar);
        this.W.z(cVar);
    }

    public void W1(int i7) {
        this.K0 = i7;
    }

    public int X() {
        return o0() + this.f3607d0;
    }

    public void X0() {
        this.f3634r = false;
        this.f3636s = false;
    }

    public void X1(int i7, int i8) {
        this.f3617i0 = i7;
        int i9 = i8 - i7;
        this.f3609e0 = i9;
        int i10 = this.f3631p0;
        if (i9 < i10) {
            this.f3609e0 = i10;
        }
    }

    protected int Y() {
        return this.f3615h0 + this.f3623l0;
    }

    public StringBuilder Y0(StringBuilder sb) {
        sb.append("{\n");
        Z0(sb, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.Q);
        Z0(sb, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.R);
        Z0(sb, "right", this.S);
        Z0(sb, "bottom", this.T);
        Z0(sb, "baseline", this.U);
        Z0(sb, "centerX", this.V);
        Z0(sb, "centerY", this.W);
        c1(sb, this.X, this.K);
        e1(sb, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f3607d0, this.f3629o0, this.f3599J[0], this.f3622l, this.f3650z, this.f3644w, this.B, this.N0[0]);
        e1(sb, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f3609e0, this.f3631p0, this.f3599J[1], this.f3624m, this.C, this.f3646x, this.E, this.N0[1]);
        d1(sb, "dimensionRatio", this.f3611f0, this.f3613g0);
        a1(sb, "horizontalBias", this.f3633q0, f3598z1);
        a1(sb, "verticalBias", this.f3635r0, f3598z1);
        sb.append("}\n");
        return sb;
    }

    public void Y1(b bVar) {
        this.f3603b0[1] = bVar;
    }

    protected int Z() {
        return this.f3617i0 + this.f3625m0;
    }

    public void Z1(int i7, int i8, int i9, float f8) {
        this.f3646x = i7;
        this.C = i8;
        if (i9 == Integer.MAX_VALUE) {
            i9 = 0;
        }
        this.D = i9;
        this.E = f8;
        if (f8 <= 0.0f || f8 >= 1.0f || i7 != 0) {
            return;
        }
        this.f3646x = 2;
    }

    public p a0(int i7) {
        if (i7 == 0) {
            return this.f3608e;
        }
        if (i7 == 1) {
            return this.f3610f;
        }
        return null;
    }

    public void a2(float f8) {
        this.N0[1] = f8;
    }

    public void b0(StringBuilder sb) {
        sb.append("  " + this.f3628o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.f3607d0);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f3609e0);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f3615h0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f3617i0);
        sb.append("\n");
        d0(sb, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.Q);
        d0(sb, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.R);
        d0(sb, "right", this.S);
        d0(sb, "bottom", this.T);
        d0(sb, "baseline", this.U);
        d0(sb, "centerX", this.V);
        d0(sb, "centerY", this.W);
        c0(sb, "    width", this.f3607d0, this.f3629o0, this.f3599J[0], this.f3622l, this.f3650z, this.f3644w, this.B, this.N0[0]);
        c0(sb, "    height", this.f3609e0, this.f3631p0, this.f3599J[1], this.f3624m, this.C, this.f3646x, this.E, this.N0[1]);
        d1(sb, "    dimensionRatio", this.f3611f0, this.f3613g0);
        a1(sb, "    horizontalBias", this.f3633q0, f3598z1);
        a1(sb, "    verticalBias", this.f3635r0, f3598z1);
        b1(sb, "    horizontalChainStyle", this.J0, 0);
        b1(sb, "    verticalChainStyle", this.K0, 0);
        sb.append("  }");
    }

    public void b2(int i7) {
        this.f3641u0 = i7;
    }

    public void c2(int i7) {
        this.f3607d0 = i7;
        int i8 = this.f3629o0;
        if (i7 < i8) {
            this.f3607d0 = i8;
        }
    }

    public void d2(boolean z7) {
        this.F = z7;
    }

    public void e(f fVar, androidx.constraintlayout.core.e eVar, HashSet<e> hashSet, int i7, boolean z7) {
        if (z7) {
            if (!hashSet.contains(this)) {
                return;
            }
            k.a(fVar, eVar, this);
            hashSet.remove(this);
            g(eVar, fVar.S2(64));
        }
        if (i7 == 0) {
            HashSet<d> hashSetE = this.Q.e();
            if (hashSetE != null) {
                Iterator<d> it = hashSetE.iterator();
                while (it.hasNext()) {
                    it.next().f3556d.e(fVar, eVar, hashSet, i7, true);
                }
            }
            HashSet<d> hashSetE2 = this.S.e();
            if (hashSetE2 != null) {
                Iterator<d> it2 = hashSetE2.iterator();
                while (it2.hasNext()) {
                    it2.next().f3556d.e(fVar, eVar, hashSet, i7, true);
                }
                return;
            }
            return;
        }
        HashSet<d> hashSetE3 = this.R.e();
        if (hashSetE3 != null) {
            Iterator<d> it3 = hashSetE3.iterator();
            while (it3.hasNext()) {
                it3.next().f3556d.e(fVar, eVar, hashSet, i7, true);
            }
        }
        HashSet<d> hashSetE4 = this.T.e();
        if (hashSetE4 != null) {
            Iterator<d> it4 = hashSetE4.iterator();
            while (it4.hasNext()) {
                it4.next().f3556d.e(fVar, eVar, hashSet, i7, true);
            }
        }
        HashSet<d> hashSetE5 = this.U.e();
        if (hashSetE5 != null) {
            Iterator<d> it5 = hashSetE5.iterator();
            while (it5.hasNext()) {
                it5.next().f3556d.e(fVar, eVar, hashSet, i7, true);
            }
        }
    }

    public int e0() {
        return p0();
    }

    public void e2(int i7) {
        if (i7 < 0 || i7 > 3) {
            return;
        }
        this.f3642v = i7;
    }

    boolean f() {
        return (this instanceof n) || (this instanceof h);
    }

    public String f0() {
        return this.f3647x0;
    }

    public void f1(boolean z7) {
        this.f3643v0 = z7;
    }

    public void f2(int i7) {
        this.f3615h0 = i7;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15391. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void g(androidx.constraintlayout.core.e r54, boolean r55) {
        /*
            Method dump skipped, instruction units count: 1539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.g(androidx.constraintlayout.core.e, boolean):void");
    }

    public float g0() {
        return this.f3635r0;
    }

    public void g1(int i7) {
        this.f3627n0 = i7;
        this.L = i7 > 0;
    }

    public void g2(int i7) {
        this.f3617i0 = i7;
    }

    public boolean h() {
        return this.f3641u0 != 8;
    }

    public e h0() {
        if (!D0()) {
            return null;
        }
        e eVar = this;
        e eVar2 = null;
        while (eVar2 == null && eVar != null) {
            d dVarR = eVar.r(d.b.TOP);
            d dVarK = dVarR == null ? null : dVarR.k();
            e eVarI = dVarK == null ? null : dVarK.i();
            if (eVarI == U()) {
                return eVar;
            }
            d dVarK2 = eVarI == null ? null : eVarI.r(d.b.BOTTOM).k();
            if (dVarK2 == null || dVarK2.i() == eVar) {
                eVar = eVarI;
            } else {
                eVar2 = eVar;
            }
        }
        return eVar2;
    }

    public void h1(Object obj) {
        this.f3637s0 = obj;
    }

    public void h2(boolean z7, boolean z8, boolean z9, boolean z10) {
        if (this.H == -1) {
            if (z9 && !z10) {
                this.H = 0;
            } else if (!z9 && z10) {
                this.H = 1;
                if (this.f3613g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.p() || !this.T.p())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.p() || !this.S.p())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.p() || !this.T.p() || !this.Q.p() || !this.S.p())) {
            if (this.R.p() && this.T.p()) {
                this.H = 0;
            } else if (this.Q.p() && this.S.p()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i7 = this.f3650z;
            if (i7 > 0 && this.C == 0) {
                this.H = 0;
            } else {
                if (i7 != 0 || this.C <= 0) {
                    return;
                }
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public int i0() {
        return this.K0;
    }

    public void i1(int i7) {
        if (i7 >= 0) {
            this.f3639t0 = i7;
        } else {
            this.f3639t0 = 0;
        }
    }

    public void i2(boolean z7, boolean z8) {
        int i7;
        int i8;
        boolean zM = z7 & this.f3608e.m();
        boolean zM2 = z8 & this.f3610f.m();
        androidx.constraintlayout.core.widgets.analyzer.l lVar = this.f3608e;
        int i9 = lVar.f3518h.f3455g;
        androidx.constraintlayout.core.widgets.analyzer.n nVar = this.f3610f;
        int i10 = nVar.f3518h.f3455g;
        int i11 = lVar.f3519i.f3455g;
        int i12 = nVar.f3519i.f3455g;
        int i13 = i12 - i10;
        if (i11 - i9 < 0 || i13 < 0 || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE) {
            i11 = 0;
            i9 = 0;
            i12 = 0;
            i10 = 0;
        }
        int i14 = i11 - i9;
        int i15 = i12 - i10;
        if (zM) {
            this.f3615h0 = i9;
        }
        if (zM2) {
            this.f3617i0 = i10;
        }
        if (this.f3641u0 == 8) {
            this.f3607d0 = 0;
            this.f3609e0 = 0;
            return;
        }
        if (zM) {
            if (this.f3603b0[0] == b.FIXED && i14 < (i8 = this.f3607d0)) {
                i14 = i8;
            }
            this.f3607d0 = i14;
            int i16 = this.f3629o0;
            if (i14 < i16) {
                this.f3607d0 = i16;
            }
        }
        if (zM2) {
            if (this.f3603b0[1] == b.FIXED && i15 < (i7 = this.f3609e0)) {
                i15 = i7;
            }
            this.f3609e0 = i15;
            int i17 = this.f3631p0;
            if (i15 < i17) {
                this.f3609e0 = i17;
            }
        }
    }

    public void j(d.b bVar, e eVar, d.b bVar2) {
        k(bVar, eVar, bVar2, 0);
    }

    public b j0() {
        return this.f3603b0[1];
    }

    public void j1(String str) {
        this.f3645w0 = str;
    }

    public void j2(androidx.constraintlayout.core.e eVar, boolean z7) {
        androidx.constraintlayout.core.widgets.analyzer.n nVar;
        androidx.constraintlayout.core.widgets.analyzer.l lVar;
        int iO = eVar.O(this.Q);
        int iO2 = eVar.O(this.R);
        int iO3 = eVar.O(this.S);
        int iO4 = eVar.O(this.T);
        if (z7 && (lVar = this.f3608e) != null) {
            androidx.constraintlayout.core.widgets.analyzer.f fVar = lVar.f3518h;
            if (fVar.f3458j) {
                androidx.constraintlayout.core.widgets.analyzer.f fVar2 = lVar.f3519i;
                if (fVar2.f3458j) {
                    iO = fVar.f3455g;
                    iO3 = fVar2.f3455g;
                }
            }
        }
        if (z7 && (nVar = this.f3610f) != null) {
            androidx.constraintlayout.core.widgets.analyzer.f fVar3 = nVar.f3518h;
            if (fVar3.f3458j) {
                androidx.constraintlayout.core.widgets.analyzer.f fVar4 = nVar.f3519i;
                if (fVar4.f3458j) {
                    iO2 = fVar3.f3455g;
                    iO4 = fVar4.f3455g;
                }
            }
        }
        int i7 = iO4 - iO2;
        if (iO3 - iO < 0 || i7 < 0 || iO == Integer.MIN_VALUE || iO == Integer.MAX_VALUE || iO2 == Integer.MIN_VALUE || iO2 == Integer.MAX_VALUE || iO3 == Integer.MIN_VALUE || iO3 == Integer.MAX_VALUE || iO4 == Integer.MIN_VALUE || iO4 == Integer.MAX_VALUE) {
            iO = 0;
            iO4 = 0;
            iO2 = 0;
            iO3 = 0;
        }
        v1(iO, iO2, iO3, iO4);
    }

    public void k(d.b bVar, e eVar, d.b bVar2, int i7) {
        d.b bVar3;
        d.b bVar4;
        boolean z7;
        d.b bVar5 = d.b.CENTER;
        if (bVar == bVar5) {
            if (bVar2 != bVar5) {
                d.b bVar6 = d.b.LEFT;
                if (bVar2 == bVar6 || bVar2 == d.b.RIGHT) {
                    k(bVar6, eVar, bVar2, 0);
                    k(d.b.RIGHT, eVar, bVar2, 0);
                    r(bVar5).a(eVar.r(bVar2), 0);
                    return;
                }
                d.b bVar7 = d.b.TOP;
                if (bVar2 == bVar7 || bVar2 == d.b.BOTTOM) {
                    k(bVar7, eVar, bVar2, 0);
                    k(d.b.BOTTOM, eVar, bVar2, 0);
                    r(bVar5).a(eVar.r(bVar2), 0);
                    return;
                }
                return;
            }
            d.b bVar8 = d.b.LEFT;
            d dVarR = r(bVar8);
            d.b bVar9 = d.b.RIGHT;
            d dVarR2 = r(bVar9);
            d.b bVar10 = d.b.TOP;
            d dVarR3 = r(bVar10);
            d.b bVar11 = d.b.BOTTOM;
            d dVarR4 = r(bVar11);
            boolean z8 = true;
            if ((dVarR == null || !dVarR.p()) && (dVarR2 == null || !dVarR2.p())) {
                k(bVar8, eVar, bVar8, 0);
                k(bVar9, eVar, bVar9, 0);
                z7 = true;
            } else {
                z7 = false;
            }
            if ((dVarR3 == null || !dVarR3.p()) && (dVarR4 == null || !dVarR4.p())) {
                k(bVar10, eVar, bVar10, 0);
                k(bVar11, eVar, bVar11, 0);
            } else {
                z8 = false;
            }
            if (z7 && z8) {
                r(bVar5).a(eVar.r(bVar5), 0);
                return;
            }
            if (z7) {
                d.b bVar12 = d.b.CENTER_X;
                r(bVar12).a(eVar.r(bVar12), 0);
                return;
            } else {
                if (z8) {
                    d.b bVar13 = d.b.CENTER_Y;
                    r(bVar13).a(eVar.r(bVar13), 0);
                    return;
                }
                return;
            }
        }
        d.b bVar14 = d.b.CENTER_X;
        if (bVar == bVar14 && (bVar2 == (bVar4 = d.b.LEFT) || bVar2 == d.b.RIGHT)) {
            d dVarR5 = r(bVar4);
            d dVarR6 = eVar.r(bVar2);
            d dVarR7 = r(d.b.RIGHT);
            dVarR5.a(dVarR6, 0);
            dVarR7.a(dVarR6, 0);
            r(bVar14).a(dVarR6, 0);
            return;
        }
        d.b bVar15 = d.b.CENTER_Y;
        if (bVar == bVar15 && (bVar2 == (bVar3 = d.b.TOP) || bVar2 == d.b.BOTTOM)) {
            d dVarR8 = eVar.r(bVar2);
            r(bVar3).a(dVarR8, 0);
            r(d.b.BOTTOM).a(dVarR8, 0);
            r(bVar15).a(dVarR8, 0);
            return;
        }
        if (bVar == bVar14 && bVar2 == bVar14) {
            d.b bVar16 = d.b.LEFT;
            r(bVar16).a(eVar.r(bVar16), 0);
            d.b bVar17 = d.b.RIGHT;
            r(bVar17).a(eVar.r(bVar17), 0);
            r(bVar14).a(eVar.r(bVar2), 0);
            return;
        }
        if (bVar == bVar15 && bVar2 == bVar15) {
            d.b bVar18 = d.b.TOP;
            r(bVar18).a(eVar.r(bVar18), 0);
            d.b bVar19 = d.b.BOTTOM;
            r(bVar19).a(eVar.r(bVar19), 0);
            r(bVar15).a(eVar.r(bVar2), 0);
            return;
        }
        d dVarR9 = r(bVar);
        d dVarR10 = eVar.r(bVar2);
        if (dVarR9.v(dVarR10)) {
            d.b bVar20 = d.b.BASELINE;
            if (bVar == bVar20) {
                d dVarR11 = r(d.b.TOP);
                d dVarR12 = r(d.b.BOTTOM);
                if (dVarR11 != null) {
                    dVarR11.x();
                }
                if (dVarR12 != null) {
                    dVarR12.x();
                }
            } else if (bVar == d.b.TOP || bVar == d.b.BOTTOM) {
                d dVarR13 = r(bVar20);
                if (dVarR13 != null) {
                    dVarR13.x();
                }
                d dVarR14 = r(bVar5);
                if (dVarR14.k() != dVarR10) {
                    dVarR14.x();
                }
                d dVarH = r(bVar).h();
                d dVarR15 = r(bVar15);
                if (dVarR15.p()) {
                    dVarH.x();
                    dVarR15.x();
                }
            } else if (bVar == d.b.LEFT || bVar == d.b.RIGHT) {
                d dVarR16 = r(bVar5);
                if (dVarR16.k() != dVarR10) {
                    dVarR16.x();
                }
                d dVarH2 = r(bVar).h();
                d dVarR17 = r(bVar14);
                if (dVarR17.p()) {
                    dVarH2.x();
                    dVarR17.x();
                }
            }
            dVarR9.a(dVarR10, i7);
        }
    }

    public int k0() {
        int i7 = this.Q != null ? 0 + this.R.f3559g : 0;
        return this.S != null ? i7 + this.T.f3559g : i7;
    }

    public void k1(androidx.constraintlayout.core.e eVar, String str) {
        this.f3645w0 = str;
        androidx.constraintlayout.core.i iVarU = eVar.u(this.Q);
        androidx.constraintlayout.core.i iVarU2 = eVar.u(this.R);
        androidx.constraintlayout.core.i iVarU3 = eVar.u(this.S);
        androidx.constraintlayout.core.i iVarU4 = eVar.u(this.T);
        iVarU.j(str + ".left");
        iVarU2.j(str + ".top");
        iVarU3.j(str + ".right");
        iVarU4.j(str + ".bottom");
        eVar.u(this.U).j(str + ".baseline");
    }

    public void l(d dVar, d dVar2, int i7) {
        if (dVar.i() == this) {
            k(dVar.l(), dVar2.i(), dVar2.l(), i7);
        }
    }

    public int l0() {
        return this.f3641u0;
    }

    public void l1(int i7, int i8) {
        this.f3607d0 = i7;
        int i9 = this.f3629o0;
        if (i7 < i9) {
            this.f3607d0 = i9;
        }
        this.f3609e0 = i8;
        int i10 = this.f3631p0;
        if (i8 < i10) {
            this.f3609e0 = i10;
        }
    }

    public void m(e eVar, float f8, int i7) {
        d.b bVar = d.b.CENTER;
        v0(bVar, eVar, bVar, i7, 0);
        this.K = f8;
    }

    public int m0() {
        if (this.f3641u0 == 8) {
            return 0;
        }
        return this.f3607d0;
    }

    public void m1(float f8, int i7) {
        this.f3611f0 = f8;
        this.f3613g0 = i7;
    }

    public void n(e eVar, HashMap<e, e> map) {
        this.f3638t = eVar.f3638t;
        this.f3640u = eVar.f3640u;
        this.f3644w = eVar.f3644w;
        this.f3646x = eVar.f3646x;
        int[] iArr = this.f3648y;
        int[] iArr2 = eVar.f3648y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f3650z = eVar.f3650z;
        this.A = eVar.A;
        this.C = eVar.C;
        this.D = eVar.D;
        this.E = eVar.E;
        this.F = eVar.F;
        this.G = eVar.G;
        this.H = eVar.H;
        this.I = eVar.I;
        int[] iArr3 = eVar.f3599J;
        this.f3599J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = eVar.K;
        this.L = eVar.L;
        this.M = eVar.M;
        this.Q.x();
        this.R.x();
        this.S.x();
        this.T.x();
        this.U.x();
        this.V.x();
        this.W.x();
        this.X.x();
        this.f3603b0 = (b[]) Arrays.copyOf(this.f3603b0, 2);
        this.f3605c0 = this.f3605c0 == null ? null : map.get(eVar.f3605c0);
        this.f3607d0 = eVar.f3607d0;
        this.f3609e0 = eVar.f3609e0;
        this.f3611f0 = eVar.f3611f0;
        this.f3613g0 = eVar.f3613g0;
        this.f3615h0 = eVar.f3615h0;
        this.f3617i0 = eVar.f3617i0;
        this.f3619j0 = eVar.f3619j0;
        this.f3621k0 = eVar.f3621k0;
        this.f3623l0 = eVar.f3623l0;
        this.f3625m0 = eVar.f3625m0;
        this.f3627n0 = eVar.f3627n0;
        this.f3629o0 = eVar.f3629o0;
        this.f3631p0 = eVar.f3631p0;
        this.f3633q0 = eVar.f3633q0;
        this.f3635r0 = eVar.f3635r0;
        this.f3637s0 = eVar.f3637s0;
        this.f3639t0 = eVar.f3639t0;
        this.f3641u0 = eVar.f3641u0;
        this.f3643v0 = eVar.f3643v0;
        this.f3645w0 = eVar.f3645w0;
        this.f3647x0 = eVar.f3647x0;
        this.f3649y0 = eVar.f3649y0;
        this.f3651z0 = eVar.f3651z0;
        this.A0 = eVar.A0;
        this.B0 = eVar.B0;
        this.C0 = eVar.C0;
        this.D0 = eVar.D0;
        this.E0 = eVar.E0;
        this.F0 = eVar.F0;
        this.G0 = eVar.G0;
        this.H0 = eVar.H0;
        this.J0 = eVar.J0;
        this.K0 = eVar.K0;
        this.L0 = eVar.L0;
        this.M0 = eVar.M0;
        float[] fArr = this.N0;
        float[] fArr2 = eVar.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        e[] eVarArr = this.O0;
        e[] eVarArr2 = eVar.O0;
        eVarArr[0] = eVarArr2[0];
        eVarArr[1] = eVarArr2[1];
        e[] eVarArr3 = this.P0;
        e[] eVarArr4 = eVar.P0;
        eVarArr3[0] = eVarArr4[0];
        eVarArr3[1] = eVarArr4[1];
        e eVar2 = eVar.Q0;
        this.Q0 = eVar2 == null ? null : map.get(eVar2);
        e eVar3 = eVar.R0;
        this.R0 = eVar3 != null ? map.get(eVar3) : null;
    }

    public int n0() {
        return this.f3642v;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    public void n1(String str) {
        float fAbs;
        int i7 = 0;
        if (str == null || str.length() == 0) {
            this.f3611f0 = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i8 = 0;
        int i9 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equalsIgnoreCase("W")) {
                i8 = strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i9 = i8;
            i8 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i8);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = i7;
                }
            } else {
                String strSubstring3 = str.substring(i8, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = i7;
                } else {
                    float f8 = Float.parseFloat(strSubstring3);
                    float f9 = Float.parseFloat(strSubstring4);
                    if (f8 <= 0.0f || f9 <= 0.0f) {
                        fAbs = i7;
                    } else {
                        fAbs = i9 == 1 ? Math.abs(f9 / f8) : Math.abs(f8 / f9);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i7 = (fAbs > i7 ? 1 : (fAbs == i7 ? 0 : -1));
        if (i7 > 0) {
            this.f3611f0 = fAbs;
            this.f3613g0 = i9;
        }
    }

    public void o(androidx.constraintlayout.core.e eVar) {
        eVar.u(this.Q);
        eVar.u(this.R);
        eVar.u(this.S);
        eVar.u(this.T);
        if (this.f3627n0 > 0) {
            eVar.u(this.U);
        }
    }

    public int o0() {
        e eVar = this.f3605c0;
        return (eVar == null || !(eVar instanceof f)) ? this.f3615h0 : ((f) eVar).I1 + this.f3615h0;
    }

    public void o1(int i7) {
        if (this.L) {
            int i8 = i7 - this.f3627n0;
            int i9 = this.f3609e0 + i8;
            this.f3617i0 = i8;
            this.R.A(i8);
            this.T.A(i9);
            this.U.A(i7);
            this.f3632q = true;
        }
    }

    public void p() {
        this.f3616i = true;
    }

    public int p0() {
        e eVar = this.f3605c0;
        return (eVar == null || !(eVar instanceof f)) ? this.f3617i0 : ((f) eVar).J1 + this.f3617i0;
    }

    public void p1(int i7, int i8, int i9, int i10, int i11, int i12) {
        v1(i7, i8, i9, i10);
        g1(i11);
        if (i12 == 0) {
            this.f3630p = true;
            this.f3632q = false;
        } else if (i12 == 1) {
            this.f3630p = false;
            this.f3632q = true;
        } else if (i12 == 2) {
            this.f3630p = true;
            this.f3632q = true;
        } else {
            this.f3630p = false;
            this.f3632q = false;
        }
    }

    public void q() {
        if (this.f3608e == null) {
            this.f3608e = new androidx.constraintlayout.core.widgets.analyzer.l(this);
        }
        if (this.f3610f == null) {
            this.f3610f = new androidx.constraintlayout.core.widgets.analyzer.n(this);
        }
    }

    public boolean q0() {
        return this.L;
    }

    public void q1(int i7, int i8) {
        if (this.f3630p) {
            return;
        }
        this.Q.A(i7);
        this.S.A(i8);
        this.f3615h0 = i7;
        this.f3607d0 = i8 - i7;
        this.f3630p = true;
    }

    public d r(d.b bVar) {
        switch (a.f3652a[bVar.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean r0(int i7) {
        if (i7 == 0) {
            return (this.Q.f3558f != null ? 1 : 0) + (this.S.f3558f != null ? 1 : 0) < 2;
        }
        return ((this.R.f3558f != null ? 1 : 0) + (this.T.f3558f != null ? 1 : 0)) + (this.U.f3558f != null ? 1 : 0) < 2;
    }

    public void r1(int i7) {
        this.Q.A(i7);
        this.f3615h0 = i7;
    }

    public ArrayList<d> s() {
        return this.Z;
    }

    public boolean s0() {
        int size = this.Z.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (this.Z.get(i7).n()) {
                return true;
            }
        }
        return false;
    }

    public void s1(int i7) {
        this.R.A(i7);
        this.f3617i0 = i7;
    }

    public int t() {
        return this.f3627n0;
    }

    public boolean t0() {
        return (this.f3622l == -1 && this.f3624m == -1) ? false : true;
    }

    public void t1(int i7, int i8) {
        if (this.f3632q) {
            return;
        }
        this.R.A(i7);
        this.T.A(i8);
        this.f3617i0 = i7;
        this.f3609e0 = i8 - i7;
        if (this.L) {
            this.U.A(i7 + this.f3627n0);
        }
        this.f3632q = true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f3647x0 != null) {
            str = "type: " + this.f3647x0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f3645w0 != null) {
            str2 = "id: " + this.f3645w0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f3615h0);
        sb.append(", ");
        sb.append(this.f3617i0);
        sb.append(") - (");
        sb.append(this.f3607d0);
        sb.append(" x ");
        sb.append(this.f3609e0);
        sb.append(")");
        return sb.toString();
    }

    public float u(int i7) {
        if (i7 == 0) {
            return this.f3633q0;
        }
        if (i7 == 1) {
            return this.f3635r0;
        }
        return -1.0f;
    }

    public boolean u0(int i7, int i8) {
        d dVar;
        d dVar2;
        if (i7 == 0) {
            d dVar3 = this.Q.f3558f;
            return dVar3 != null && dVar3.o() && (dVar2 = this.S.f3558f) != null && dVar2.o() && (this.S.f3558f.f() - this.S.g()) - (this.Q.f3558f.f() + this.Q.g()) >= i8;
        }
        d dVar4 = this.R.f3558f;
        return dVar4 != null && dVar4.o() && (dVar = this.T.f3558f) != null && dVar.o() && (this.T.f3558f.f() - this.T.g()) - (this.R.f3558f.f() + this.R.g()) >= i8;
        return false;
    }

    public void u1(int i7, int i8, int i9) {
        if (i9 == 0) {
            C1(i7, i8);
        } else if (i9 == 1) {
            X1(i7, i8);
        }
    }

    public int v() {
        return p0() + this.f3609e0;
    }

    public void v0(d.b bVar, e eVar, d.b bVar2, int i7, int i8) {
        r(bVar).b(eVar.r(bVar2), i7, i8, true);
    }

    public void v1(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13 = i9 - i7;
        int i14 = i10 - i8;
        this.f3615h0 = i7;
        this.f3617i0 = i8;
        if (this.f3641u0 == 8) {
            this.f3607d0 = 0;
            this.f3609e0 = 0;
            return;
        }
        b[] bVarArr = this.f3603b0;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i13 < (i12 = this.f3607d0)) {
            i13 = i12;
        }
        if (bVarArr[1] == bVar2 && i14 < (i11 = this.f3609e0)) {
            i14 = i11;
        }
        this.f3607d0 = i13;
        this.f3609e0 = i14;
        int i15 = this.f3631p0;
        if (i14 < i15) {
            this.f3609e0 = i15;
        }
        int i16 = this.f3629o0;
        if (i13 < i16) {
            this.f3607d0 = i16;
        }
        int i17 = this.A;
        if (i17 > 0 && bVar == b.MATCH_CONSTRAINT) {
            this.f3607d0 = Math.min(this.f3607d0, i17);
        }
        int i18 = this.D;
        if (i18 > 0 && this.f3603b0[1] == b.MATCH_CONSTRAINT) {
            this.f3609e0 = Math.min(this.f3609e0, i18);
        }
        int i19 = this.f3607d0;
        if (i13 != i19) {
            this.f3622l = i19;
        }
        int i20 = this.f3609e0;
        if (i14 != i20) {
            this.f3624m = i20;
        }
    }

    public Object w() {
        return this.f3637s0;
    }

    public boolean w0() {
        return this.f3643v0;
    }

    public void w1(d.b bVar, int i7) {
        int i8 = a.f3652a[bVar.ordinal()];
        if (i8 == 1) {
            this.Q.f3560h = i7;
            return;
        }
        if (i8 == 2) {
            this.R.f3560h = i7;
            return;
        }
        if (i8 == 3) {
            this.S.f3560h = i7;
        } else if (i8 == 4) {
            this.T.f3560h = i7;
        } else {
            if (i8 != 5) {
                return;
            }
            this.U.f3560h = i7;
        }
    }

    public int x() {
        return this.f3639t0;
    }

    public void x1(boolean z7) {
        this.L = z7;
    }

    public String y() {
        return this.f3645w0;
    }

    public boolean y0() {
        return this.G;
    }

    public void y1(int i7) {
        this.f3609e0 = i7;
        int i8 = this.f3631p0;
        if (i7 < i8) {
            this.f3609e0 = i8;
        }
    }

    public b z(int i7) {
        if (i7 == 0) {
            return H();
        }
        if (i7 == 1) {
            return j0();
        }
        return null;
    }

    public boolean z0() {
        return this.f3634r;
    }

    public void z1(boolean z7) {
        this.G = z7;
    }

    public e(String str) {
        this.f3600a = false;
        this.f3602b = new p[2];
        this.f3608e = null;
        this.f3610f = null;
        this.f3612g = new boolean[]{true, true};
        this.f3614h = false;
        this.f3616i = true;
        this.f3618j = false;
        this.f3620k = true;
        this.f3622l = -1;
        this.f3624m = -1;
        this.f3626n = new r(this);
        this.f3630p = false;
        this.f3632q = false;
        this.f3634r = false;
        this.f3636s = false;
        this.f3638t = -1;
        this.f3640u = -1;
        this.f3642v = 0;
        this.f3644w = 0;
        this.f3646x = 0;
        this.f3648y = new int[2];
        this.f3650z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.f3599J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new d(this, d.b.LEFT);
        this.R = new d(this, d.b.TOP);
        this.S = new d(this, d.b.RIGHT);
        this.T = new d(this, d.b.BOTTOM);
        this.U = new d(this, d.b.BASELINE);
        this.V = new d(this, d.b.CENTER_X);
        this.W = new d(this, d.b.CENTER_Y);
        d dVar = new d(this, d.b.CENTER);
        this.X = dVar;
        this.Y = new d[]{this.Q, this.S, this.R, this.T, this.U, dVar};
        this.Z = new ArrayList<>();
        this.f3601a0 = new boolean[2];
        b bVar = b.FIXED;
        this.f3603b0 = new b[]{bVar, bVar};
        this.f3605c0 = null;
        this.f3607d0 = 0;
        this.f3609e0 = 0;
        this.f3611f0 = 0.0f;
        this.f3613g0 = -1;
        this.f3615h0 = 0;
        this.f3617i0 = 0;
        this.f3619j0 = 0;
        this.f3621k0 = 0;
        this.f3623l0 = 0;
        this.f3625m0 = 0;
        this.f3627n0 = 0;
        float f8 = f3598z1;
        this.f3633q0 = f8;
        this.f3635r0 = f8;
        this.f3639t0 = 0;
        this.f3641u0 = 0;
        this.f3643v0 = false;
        this.f3645w0 = null;
        this.f3647x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new e[]{null, null};
        this.P0 = new e[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
        j1(str);
    }

    public e(int i7, int i8, int i9, int i10) {
        this.f3600a = false;
        this.f3602b = new p[2];
        this.f3608e = null;
        this.f3610f = null;
        this.f3612g = new boolean[]{true, true};
        this.f3614h = false;
        this.f3616i = true;
        this.f3618j = false;
        this.f3620k = true;
        this.f3622l = -1;
        this.f3624m = -1;
        this.f3626n = new r(this);
        this.f3630p = false;
        this.f3632q = false;
        this.f3634r = false;
        this.f3636s = false;
        this.f3638t = -1;
        this.f3640u = -1;
        this.f3642v = 0;
        this.f3644w = 0;
        this.f3646x = 0;
        this.f3648y = new int[2];
        this.f3650z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.f3599J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new d(this, d.b.LEFT);
        this.R = new d(this, d.b.TOP);
        this.S = new d(this, d.b.RIGHT);
        this.T = new d(this, d.b.BOTTOM);
        this.U = new d(this, d.b.BASELINE);
        this.V = new d(this, d.b.CENTER_X);
        this.W = new d(this, d.b.CENTER_Y);
        d dVar = new d(this, d.b.CENTER);
        this.X = dVar;
        this.Y = new d[]{this.Q, this.S, this.R, this.T, this.U, dVar};
        this.Z = new ArrayList<>();
        this.f3601a0 = new boolean[2];
        b bVar = b.FIXED;
        this.f3603b0 = new b[]{bVar, bVar};
        this.f3605c0 = null;
        this.f3611f0 = 0.0f;
        this.f3613g0 = -1;
        this.f3619j0 = 0;
        this.f3621k0 = 0;
        this.f3623l0 = 0;
        this.f3625m0 = 0;
        this.f3627n0 = 0;
        float f8 = f3598z1;
        this.f3633q0 = f8;
        this.f3635r0 = f8;
        this.f3639t0 = 0;
        this.f3641u0 = 0;
        this.f3643v0 = false;
        this.f3645w0 = null;
        this.f3647x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new e[]{null, null};
        this.P0 = new e[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        this.f3615h0 = i7;
        this.f3617i0 = i8;
        this.f3607d0 = i9;
        this.f3609e0 = i10;
        d();
    }

    public e(String str, int i7, int i8, int i9, int i10) {
        this(i7, i8, i9, i10);
        j1(str);
    }

    public e(int i7, int i8) {
        this(0, 0, i7, i8);
    }

    public e(String str, int i7, int i8) {
        this(i7, i8);
        j1(str);
    }
}
