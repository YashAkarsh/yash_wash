package androidx.constraintlayout.core;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static boolean A = false;
    private static int B = 1000;
    public static f C = null;
    public static long D = 0;
    public static long E = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f2392r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f2393s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f2394t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final boolean f2395u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f2396v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f2397w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f2398x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f2399y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f2400z = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f2404d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    androidx.constraintlayout.core.b[] f2407g;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final c f2414n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a f2417q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2401a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2402b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, i> f2403c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2405e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2406f = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2408h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2409i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean[] f2410j = new boolean[32];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f2411k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2412l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2413m = 32;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private i[] f2415o = new i[B];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2416p = 0;

    interface a {
        void a(e eVar, i iVar, boolean z7);

        void b(e eVar);

        void c(e eVar, androidx.constraintlayout.core.b bVar, boolean z7);

        void clear();

        void d(a aVar);

        i e(e eVar, boolean[] zArr);

        void f(i iVar);

        i getKey();

        boolean isEmpty();
    }

    class b extends androidx.constraintlayout.core.b {
        public b(c cVar) {
            this.f2386e = new j(this, cVar);
        }
    }

    public e() {
        this.f2407g = null;
        this.f2407g = new androidx.constraintlayout.core.b[32];
        W();
        c cVar = new c();
        this.f2414n = cVar;
        this.f2404d = new h(cVar);
        if (A) {
            this.f2417q = new b(cVar);
        } else {
            this.f2417q = new androidx.constraintlayout.core.b(cVar);
        }
    }

    private void A() {
        B();
        String str = "";
        for (int i7 = 0; i7 < this.f2412l; i7++) {
            str = (str + this.f2407g[i7]) + "\n";
        }
        System.out.println(str + this.f2404d + "\n");
    }

    private void B() {
        System.out.println("Display Rows (" + this.f2412l + "x" + this.f2411k + ")\n");
    }

    private int E(a aVar) throws Exception {
        boolean z7;
        int i7 = 0;
        while (true) {
            if (i7 >= this.f2412l) {
                z7 = false;
                break;
            }
            androidx.constraintlayout.core.b bVar = this.f2407g[i7];
            if (bVar.f2382a.f2480j != i.b.UNRESTRICTED && bVar.f2383b < 0.0f) {
                z7 = true;
                break;
            }
            i7++;
        }
        if (!z7) {
            return 0;
        }
        boolean z8 = false;
        int i8 = 0;
        while (!z8) {
            f fVar = C;
            if (fVar != null) {
                fVar.f2434o++;
            }
            i8++;
            float f8 = Float.MAX_VALUE;
            int i9 = -1;
            int i10 = -1;
            int i11 = 0;
            for (int i12 = 0; i12 < this.f2412l; i12++) {
                androidx.constraintlayout.core.b bVar2 = this.f2407g[i12];
                if (bVar2.f2382a.f2480j != i.b.UNRESTRICTED && !bVar2.f2387f && bVar2.f2383b < 0.0f) {
                    int i13 = 9;
                    if (f2400z) {
                        int iB = bVar2.f2386e.b();
                        int i14 = 0;
                        while (i14 < iB) {
                            i iVarH = bVar2.f2386e.h(i14);
                            float fM = bVar2.f2386e.m(iVarH);
                            if (fM > 0.0f) {
                                int i15 = 0;
                                while (i15 < i13) {
                                    float f9 = iVarH.f2478h[i15] / fM;
                                    if ((f9 < f8 && i15 == i11) || i15 > i11) {
                                        i10 = iVarH.f2473c;
                                        i11 = i15;
                                        i9 = i12;
                                        f8 = f9;
                                    }
                                    i15++;
                                    i13 = 9;
                                }
                            }
                            i14++;
                            i13 = 9;
                        }
                    } else {
                        for (int i16 = 1; i16 < this.f2411k; i16++) {
                            i iVar = this.f2414n.f2391d[i16];
                            float fM2 = bVar2.f2386e.m(iVar);
                            if (fM2 > 0.0f) {
                                for (int i17 = 0; i17 < 9; i17++) {
                                    float f10 = iVar.f2478h[i17] / fM2;
                                    if ((f10 < f8 && i17 == i11) || i17 > i11) {
                                        i10 = i16;
                                        i11 = i17;
                                        i9 = i12;
                                        f8 = f10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i9 != -1) {
                androidx.constraintlayout.core.b bVar3 = this.f2407g[i9];
                bVar3.f2382a.f2474d = -1;
                f fVar2 = C;
                if (fVar2 != null) {
                    fVar2.f2433n++;
                }
                bVar3.C(this.f2414n.f2391d[i10]);
                i iVar2 = bVar3.f2382a;
                iVar2.f2474d = i9;
                iVar2.n(this, bVar3);
            } else {
                z8 = true;
            }
            if (i8 > this.f2411k / 2) {
                z8 = true;
            }
        }
        return i8;
    }

    private String H(int i7) {
        int i8 = i7 * 4;
        int i9 = i8 / 1024;
        int i10 = i9 / 1024;
        if (i10 > 0) {
            return "" + i10 + " Mb";
        }
        if (i9 > 0) {
            return "" + i9 + " Kb";
        }
        return "" + i8 + " bytes";
    }

    private String I(int i7) {
        if (i7 == 1) {
            return "LOW";
        }
        if (i7 == 2) {
            return "MEDIUM";
        }
        if (i7 == 3) {
            return "HIGH";
        }
        if (i7 == 4) {
            return "HIGHEST";
        }
        if (i7 == 5) {
            return "EQUALITY";
        }
        if (i7 == 8) {
            return "FIXED";
        }
        return i7 == 6 ? "BARRIER" : "NONE";
    }

    public static f L() {
        return C;
    }

    private void S() {
        int i7 = this.f2405e * 2;
        this.f2405e = i7;
        this.f2407g = (androidx.constraintlayout.core.b[]) Arrays.copyOf(this.f2407g, i7);
        c cVar = this.f2414n;
        cVar.f2391d = (i[]) Arrays.copyOf(cVar.f2391d, this.f2405e);
        int i8 = this.f2405e;
        this.f2410j = new boolean[i8];
        this.f2406f = i8;
        this.f2413m = i8;
        f fVar = C;
        if (fVar != null) {
            fVar.f2427h++;
            fVar.f2439t = Math.max(fVar.f2439t, i8);
            f fVar2 = C;
            fVar2.f2419J = fVar2.f2439t;
        }
    }

    private final int V(a aVar, boolean z7) {
        f fVar = C;
        if (fVar != null) {
            fVar.f2431l++;
        }
        for (int i7 = 0; i7 < this.f2411k; i7++) {
            this.f2410j[i7] = false;
        }
        boolean z8 = false;
        int i8 = 0;
        while (!z8) {
            f fVar2 = C;
            if (fVar2 != null) {
                fVar2.f2432m++;
            }
            i8++;
            if (i8 >= this.f2411k * 2) {
                return i8;
            }
            if (aVar.getKey() != null) {
                this.f2410j[aVar.getKey().f2473c] = true;
            }
            i iVarE = aVar.e(this, this.f2410j);
            if (iVarE != null) {
                boolean[] zArr = this.f2410j;
                int i9 = iVarE.f2473c;
                if (zArr[i9]) {
                    return i8;
                }
                zArr[i9] = true;
            }
            if (iVarE != null) {
                float f8 = Float.MAX_VALUE;
                int i10 = -1;
                for (int i11 = 0; i11 < this.f2412l; i11++) {
                    androidx.constraintlayout.core.b bVar = this.f2407g[i11];
                    if (bVar.f2382a.f2480j != i.b.UNRESTRICTED && !bVar.f2387f && bVar.y(iVarE)) {
                        float fM = bVar.f2386e.m(iVarE);
                        if (fM < 0.0f) {
                            float f9 = (-bVar.f2383b) / fM;
                            if (f9 < f8) {
                                i10 = i11;
                                f8 = f9;
                            }
                        }
                    }
                }
                if (i10 > -1) {
                    androidx.constraintlayout.core.b bVar2 = this.f2407g[i10];
                    bVar2.f2382a.f2474d = -1;
                    f fVar3 = C;
                    if (fVar3 != null) {
                        fVar3.f2433n++;
                    }
                    bVar2.C(iVarE);
                    i iVar = bVar2.f2382a;
                    iVar.f2474d = i10;
                    iVar.n(this, bVar2);
                }
            } else {
                z8 = true;
            }
        }
        return i8;
    }

    private void W() {
        int i7 = 0;
        if (A) {
            while (i7 < this.f2412l) {
                androidx.constraintlayout.core.b bVar = this.f2407g[i7];
                if (bVar != null) {
                    this.f2414n.f2388a.a(bVar);
                }
                this.f2407g[i7] = null;
                i7++;
            }
            return;
        }
        while (i7 < this.f2412l) {
            androidx.constraintlayout.core.b bVar2 = this.f2407g[i7];
            if (bVar2 != null) {
                this.f2414n.f2389b.a(bVar2);
            }
            this.f2407g[i7] = null;
            i7++;
        }
    }

    private i a(i.b bVar, String str) {
        i iVarB = this.f2414n.f2390c.b();
        if (iVarB == null) {
            iVarB = new i(bVar, str);
            iVarB.l(bVar, str);
        } else {
            iVarB.h();
            iVarB.l(bVar, str);
        }
        int i7 = this.f2416p;
        int i8 = B;
        if (i7 >= i8) {
            int i9 = i8 * 2;
            B = i9;
            this.f2415o = (i[]) Arrays.copyOf(this.f2415o, i9);
        }
        i[] iVarArr = this.f2415o;
        int i10 = this.f2416p;
        this.f2416p = i10 + 1;
        iVarArr[i10] = iVarB;
        return iVarB;
    }

    private void g(androidx.constraintlayout.core.b bVar) {
        bVar.g(this, 0);
    }

    private final void m(androidx.constraintlayout.core.b bVar) {
        int i7;
        if (f2398x && bVar.f2387f) {
            bVar.f2382a.i(this, bVar.f2383b);
        } else {
            androidx.constraintlayout.core.b[] bVarArr = this.f2407g;
            int i8 = this.f2412l;
            bVarArr[i8] = bVar;
            i iVar = bVar.f2382a;
            iVar.f2474d = i8;
            this.f2412l = i8 + 1;
            iVar.n(this, bVar);
        }
        if (f2398x && this.f2401a) {
            int i9 = 0;
            while (i9 < this.f2412l) {
                if (this.f2407g[i9] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.core.b bVar2 = this.f2407g[i9];
                if (bVar2 != null && bVar2.f2387f) {
                    bVar2.f2382a.i(this, bVar2.f2383b);
                    if (A) {
                        this.f2414n.f2388a.a(bVar2);
                    } else {
                        this.f2414n.f2389b.a(bVar2);
                    }
                    this.f2407g[i9] = null;
                    int i10 = i9 + 1;
                    int i11 = i10;
                    while (true) {
                        i7 = this.f2412l;
                        if (i10 >= i7) {
                            break;
                        }
                        androidx.constraintlayout.core.b[] bVarArr2 = this.f2407g;
                        int i12 = i10 - 1;
                        androidx.constraintlayout.core.b bVar3 = bVarArr2[i10];
                        bVarArr2[i12] = bVar3;
                        i iVar2 = bVar3.f2382a;
                        if (iVar2.f2474d == i10) {
                            iVar2.f2474d = i12;
                        }
                        i11 = i10;
                        i10++;
                    }
                    if (i11 < i7) {
                        this.f2407g[i11] = null;
                    }
                    this.f2412l = i7 - 1;
                    i9--;
                }
                i9++;
            }
            this.f2401a = false;
        }
    }

    private void n(androidx.constraintlayout.core.b bVar, int i7) {
        o(bVar, i7, 0);
    }

    private void r() {
        for (int i7 = 0; i7 < this.f2412l; i7++) {
            androidx.constraintlayout.core.b bVar = this.f2407g[i7];
            bVar.f2382a.f2476f = bVar.f2383b;
        }
    }

    public static androidx.constraintlayout.core.b w(e eVar, i iVar, i iVar2, float f8) {
        return eVar.v().m(iVar, iVar2, f8);
    }

    private i y(String str, i.b bVar) {
        f fVar = C;
        if (fVar != null) {
            fVar.f2435p++;
        }
        if (this.f2411k + 1 >= this.f2406f) {
            S();
        }
        i iVarA = a(bVar, null);
        iVarA.j(str);
        int i7 = this.f2402b + 1;
        this.f2402b = i7;
        this.f2411k++;
        iVarA.f2473c = i7;
        if (this.f2403c == null) {
            this.f2403c = new HashMap<>();
        }
        this.f2403c.put(str, iVarA);
        this.f2414n.f2391d[this.f2402b] = iVarA;
        return iVarA;
    }

    void C() {
        int iE = 0;
        for (int i7 = 0; i7 < this.f2405e; i7++) {
            androidx.constraintlayout.core.b bVar = this.f2407g[i7];
            if (bVar != null) {
                iE += bVar.E();
            }
        }
        int iE2 = 0;
        for (int i8 = 0; i8 < this.f2412l; i8++) {
            androidx.constraintlayout.core.b bVar2 = this.f2407g[i8];
            if (bVar2 != null) {
                iE2 += bVar2.E();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Linear System -> Table size: ");
        sb.append(this.f2405e);
        sb.append(" (");
        int i9 = this.f2405e;
        sb.append(H(i9 * i9));
        sb.append(") -- row sizes: ");
        sb.append(H(iE));
        sb.append(", actual size: ");
        sb.append(H(iE2));
        sb.append(" rows: ");
        sb.append(this.f2412l);
        sb.append("/");
        sb.append(this.f2413m);
        sb.append(" cols: ");
        sb.append(this.f2411k);
        sb.append("/");
        sb.append(this.f2406f);
        sb.append(" ");
        sb.append(0);
        sb.append(" occupied cells, ");
        sb.append(H(0));
        printStream.println(sb.toString());
    }

    public void D() {
        B();
        String str = "";
        for (int i7 = 0; i7 < this.f2412l; i7++) {
            if (this.f2407g[i7].f2382a.f2480j == i.b.UNRESTRICTED) {
                str = (str + this.f2407g[i7].F()) + "\n";
            }
        }
        System.out.println(str + this.f2404d + "\n");
    }

    public void F(f fVar) {
        C = fVar;
    }

    public c G() {
        return this.f2414n;
    }

    a J() {
        return this.f2404d;
    }

    public int K() {
        int iE = 0;
        for (int i7 = 0; i7 < this.f2412l; i7++) {
            androidx.constraintlayout.core.b bVar = this.f2407g[i7];
            if (bVar != null) {
                iE += bVar.E();
            }
        }
        return iE;
    }

    public int M() {
        return this.f2412l;
    }

    public int N() {
        return this.f2402b;
    }

    public int O(Object obj) {
        i iVarJ = ((androidx.constraintlayout.core.widgets.d) obj).j();
        if (iVarJ != null) {
            return (int) (iVarJ.f2476f + 0.5f);
        }
        return 0;
    }

    androidx.constraintlayout.core.b P(int i7) {
        return this.f2407g[i7];
    }

    float Q(String str) {
        i iVarR = R(str, i.b.UNRESTRICTED);
        if (iVarR == null) {
            return 0.0f;
        }
        return iVarR.f2476f;
    }

    i R(String str, i.b bVar) {
        if (this.f2403c == null) {
            this.f2403c = new HashMap<>();
        }
        i iVar = this.f2403c.get(str);
        return iVar == null ? y(str, bVar) : iVar;
    }

    public void T() throws Exception {
        f fVar = C;
        if (fVar != null) {
            fVar.f2428i++;
        }
        if (this.f2404d.isEmpty()) {
            r();
            return;
        }
        if (!this.f2408h && !this.f2409i) {
            U(this.f2404d);
            return;
        }
        f fVar2 = C;
        if (fVar2 != null) {
            fVar2.f2441v++;
        }
        boolean z7 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= this.f2412l) {
                z7 = true;
                break;
            } else if (!this.f2407g[i7].f2387f) {
                break;
            } else {
                i7++;
            }
        }
        if (!z7) {
            U(this.f2404d);
            return;
        }
        f fVar3 = C;
        if (fVar3 != null) {
            fVar3.f2440u++;
        }
        r();
    }

    void U(a aVar) throws Exception {
        f fVar = C;
        if (fVar != null) {
            fVar.f2445z++;
            fVar.A = Math.max(fVar.A, this.f2411k);
            f fVar2 = C;
            fVar2.B = Math.max(fVar2.B, this.f2412l);
        }
        E(aVar);
        V(aVar, false);
        r();
    }

    public void X(androidx.constraintlayout.core.b bVar) {
        i iVar;
        int i7;
        if (!bVar.f2387f || (iVar = bVar.f2382a) == null) {
            return;
        }
        int i8 = iVar.f2474d;
        if (i8 != -1) {
            while (true) {
                i7 = this.f2412l;
                if (i8 >= i7 - 1) {
                    break;
                }
                androidx.constraintlayout.core.b[] bVarArr = this.f2407g;
                int i9 = i8 + 1;
                androidx.constraintlayout.core.b bVar2 = bVarArr[i9];
                i iVar2 = bVar2.f2382a;
                if (iVar2.f2474d == i9) {
                    iVar2.f2474d = i8;
                }
                bVarArr[i8] = bVar2;
                i8 = i9;
            }
            this.f2412l = i7 - 1;
        }
        i iVar3 = bVar.f2382a;
        if (!iVar3.f2477g) {
            iVar3.i(this, bVar.f2383b);
        }
        if (A) {
            this.f2414n.f2388a.a(bVar);
        } else {
            this.f2414n.f2389b.a(bVar);
        }
    }

    public void Y() {
        c cVar;
        int i7 = 0;
        while (true) {
            cVar = this.f2414n;
            i[] iVarArr = cVar.f2391d;
            if (i7 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i7];
            if (iVar != null) {
                iVar.h();
            }
            i7++;
        }
        cVar.f2390c.c(this.f2415o, this.f2416p);
        this.f2416p = 0;
        Arrays.fill(this.f2414n.f2391d, (Object) null);
        HashMap<String, i> map = this.f2403c;
        if (map != null) {
            map.clear();
        }
        this.f2402b = 0;
        this.f2404d.clear();
        this.f2411k = 1;
        for (int i8 = 0; i8 < this.f2412l; i8++) {
            androidx.constraintlayout.core.b bVar = this.f2407g[i8];
            if (bVar != null) {
                bVar.f2384c = false;
            }
        }
        W();
        this.f2412l = 0;
        if (A) {
            this.f2417q = new b(this.f2414n);
        } else {
            this.f2417q = new androidx.constraintlayout.core.b(this.f2414n);
        }
    }

    public void b(androidx.constraintlayout.core.widgets.e eVar, androidx.constraintlayout.core.widgets.e eVar2, float f8, int i7) {
        androidx.constraintlayout.core.widgets.d.b bVar = androidx.constraintlayout.core.widgets.d.b.LEFT;
        i iVarU = u(eVar.r(bVar));
        androidx.constraintlayout.core.widgets.d.b bVar2 = androidx.constraintlayout.core.widgets.d.b.TOP;
        i iVarU2 = u(eVar.r(bVar2));
        androidx.constraintlayout.core.widgets.d.b bVar3 = androidx.constraintlayout.core.widgets.d.b.RIGHT;
        i iVarU3 = u(eVar.r(bVar3));
        androidx.constraintlayout.core.widgets.d.b bVar4 = androidx.constraintlayout.core.widgets.d.b.BOTTOM;
        i iVarU4 = u(eVar.r(bVar4));
        i iVarU5 = u(eVar2.r(bVar));
        i iVarU6 = u(eVar2.r(bVar2));
        i iVarU7 = u(eVar2.r(bVar3));
        i iVarU8 = u(eVar2.r(bVar4));
        androidx.constraintlayout.core.b bVarV = v();
        double d8 = f8;
        double d9 = i7;
        bVarV.v(iVarU2, iVarU4, iVarU6, iVarU8, (float) (Math.sin(d8) * d9));
        d(bVarV);
        androidx.constraintlayout.core.b bVarV2 = v();
        bVarV2.v(iVarU, iVarU3, iVarU5, iVarU7, (float) (Math.cos(d8) * d9));
        d(bVarV2);
    }

    public void c(i iVar, i iVar2, int i7, float f8, i iVar3, i iVar4, int i8, int i9) {
        androidx.constraintlayout.core.b bVarV = v();
        bVarV.k(iVar, iVar2, i7, f8, iVar3, iVar4, i8);
        if (i9 != 8) {
            bVarV.g(this, i9);
        }
        d(bVarV);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0098  */
    public void d(androidx.constraintlayout.core.b bVar) {
        i iVarA;
        if (bVar == null) {
            return;
        }
        f fVar = C;
        if (fVar != null) {
            fVar.f2429j++;
            if (bVar.f2387f) {
                fVar.f2430k++;
            }
        }
        boolean z7 = true;
        if (this.f2412l + 1 >= this.f2413m || this.f2411k + 1 >= this.f2406f) {
            S();
        }
        boolean z8 = false;
        if (!bVar.f2387f) {
            bVar.b(this);
            if (bVar.isEmpty()) {
                return;
            }
            bVar.w();
            if (bVar.i(this)) {
                i iVarT = t();
                bVar.f2382a = iVarT;
                int i7 = this.f2412l;
                m(bVar);
                if (this.f2412l == i7 + 1) {
                    this.f2417q.d(bVar);
                    V(this.f2417q, true);
                    if (iVarT.f2474d == -1) {
                        if (bVar.f2382a == iVarT && (iVarA = bVar.A(iVarT)) != null) {
                            f fVar2 = C;
                            if (fVar2 != null) {
                                fVar2.f2433n++;
                            }
                            bVar.C(iVarA);
                        }
                        if (!bVar.f2387f) {
                            bVar.f2382a.n(this, bVar);
                        }
                        if (A) {
                            this.f2414n.f2388a.a(bVar);
                        } else {
                            this.f2414n.f2389b.a(bVar);
                        }
                        this.f2412l--;
                    }
                } else {
                    z7 = false;
                }
            } else {
                z7 = false;
            }
            if (!bVar.x()) {
                return;
            } else {
                z8 = z7;
            }
        }
        if (z8) {
            return;
        }
        m(bVar);
    }

    public androidx.constraintlayout.core.b e(i iVar, i iVar2, int i7, int i8) {
        if (f2397w && i8 == 8 && iVar2.f2477g && iVar.f2474d == -1) {
            iVar.i(this, iVar2.f2476f + i7);
            return null;
        }
        androidx.constraintlayout.core.b bVarV = v();
        bVarV.r(iVar, iVar2, i7);
        if (i8 != 8) {
            bVarV.g(this, i8);
        }
        d(bVarV);
        return bVarV;
    }

    public void f(i iVar, int i7) {
        if (f2397w && iVar.f2474d == -1) {
            float f8 = i7;
            iVar.i(this, f8);
            for (int i8 = 0; i8 < this.f2402b + 1; i8++) {
                i iVar2 = this.f2414n.f2391d[i8];
                if (iVar2 != null && iVar2.f2484n && iVar2.f2485o == iVar.f2473c) {
                    iVar2.i(this, iVar2.f2486p + f8);
                }
            }
            return;
        }
        int i9 = iVar.f2474d;
        if (i9 == -1) {
            androidx.constraintlayout.core.b bVarV = v();
            bVarV.l(iVar, i7);
            d(bVarV);
            return;
        }
        androidx.constraintlayout.core.b bVar = this.f2407g[i9];
        if (bVar.f2387f) {
            bVar.f2383b = i7;
            return;
        }
        if (bVar.f2386e.b() == 0) {
            bVar.f2387f = true;
            bVar.f2383b = i7;
        } else {
            androidx.constraintlayout.core.b bVarV2 = v();
            bVarV2.q(iVar, i7);
            d(bVarV2);
        }
    }

    public void h(i iVar, i iVar2, int i7, boolean z7) {
        androidx.constraintlayout.core.b bVarV = v();
        i iVarX = x();
        iVarX.f2475e = 0;
        bVarV.t(iVar, iVar2, iVarX, i7);
        d(bVarV);
    }

    public void i(i iVar, i iVar2, int i7, int i8) {
        androidx.constraintlayout.core.b bVarV = v();
        i iVarX = x();
        iVarX.f2475e = 0;
        bVarV.t(iVar, iVar2, iVarX, i7);
        if (i8 != 8) {
            o(bVarV, (int) (bVarV.f2386e.m(iVarX) * (-1.0f)), i8);
        }
        d(bVarV);
    }

    public void j(i iVar, i iVar2, int i7, boolean z7) {
        androidx.constraintlayout.core.b bVarV = v();
        i iVarX = x();
        iVarX.f2475e = 0;
        bVarV.u(iVar, iVar2, iVarX, i7);
        d(bVarV);
    }

    public void k(i iVar, i iVar2, int i7, int i8) {
        androidx.constraintlayout.core.b bVarV = v();
        i iVarX = x();
        iVarX.f2475e = 0;
        bVarV.u(iVar, iVar2, iVarX, i7);
        if (i8 != 8) {
            o(bVarV, (int) (bVarV.f2386e.m(iVarX) * (-1.0f)), i8);
        }
        d(bVarV);
    }

    public void l(i iVar, i iVar2, i iVar3, i iVar4, float f8, int i7) {
        androidx.constraintlayout.core.b bVarV = v();
        bVarV.n(iVar, iVar2, iVar3, iVar4, f8);
        if (i7 != 8) {
            bVarV.g(this, i7);
        }
        d(bVarV);
    }

    void o(androidx.constraintlayout.core.b bVar, int i7, int i8) {
        bVar.h(s(i8, null), i7);
    }

    public void p(i iVar, i iVar2, int i7) {
        if (iVar.f2474d != -1 || i7 != 0) {
            e(iVar, iVar2, i7, 8);
            return;
        }
        if (iVar2.f2484n) {
            iVar2 = this.f2414n.f2391d[iVar2.f2485o];
        }
        if (iVar.f2484n) {
            i iVar3 = this.f2414n.f2391d[iVar.f2485o];
        } else {
            iVar.k(this, iVar2, 0.0f);
        }
    }

    final void q() {
        int i7;
        int i8 = 0;
        while (i8 < this.f2412l) {
            androidx.constraintlayout.core.b bVar = this.f2407g[i8];
            if (bVar.f2386e.b() == 0) {
                bVar.f2387f = true;
            }
            if (bVar.f2387f) {
                i iVar = bVar.f2382a;
                iVar.f2476f = bVar.f2383b;
                iVar.g(bVar);
                int i9 = i8;
                while (true) {
                    i7 = this.f2412l;
                    if (i9 >= i7 - 1) {
                        break;
                    }
                    androidx.constraintlayout.core.b[] bVarArr = this.f2407g;
                    int i10 = i9 + 1;
                    bVarArr[i9] = bVarArr[i10];
                    i9 = i10;
                }
                this.f2407g[i7 - 1] = null;
                this.f2412l = i7 - 1;
                i8--;
                if (A) {
                    this.f2414n.f2388a.a(bVar);
                } else {
                    this.f2414n.f2389b.a(bVar);
                }
            }
            i8++;
        }
    }

    public i s(int i7, String str) {
        f fVar = C;
        if (fVar != null) {
            fVar.f2436q++;
        }
        if (this.f2411k + 1 >= this.f2406f) {
            S();
        }
        i iVarA = a(i.b.ERROR, str);
        int i8 = this.f2402b + 1;
        this.f2402b = i8;
        this.f2411k++;
        iVarA.f2473c = i8;
        iVarA.f2475e = i7;
        this.f2414n.f2391d[i8] = iVarA;
        this.f2404d.f(iVarA);
        return iVarA;
    }

    public i t() {
        f fVar = C;
        if (fVar != null) {
            fVar.f2438s++;
        }
        if (this.f2411k + 1 >= this.f2406f) {
            S();
        }
        i iVarA = a(i.b.SLACK, null);
        int i7 = this.f2402b + 1;
        this.f2402b = i7;
        this.f2411k++;
        iVarA.f2473c = i7;
        this.f2414n.f2391d[i7] = iVarA;
        return iVarA;
    }

    public i u(Object obj) {
        i iVarJ = null;
        if (obj == null) {
            return null;
        }
        if (this.f2411k + 1 >= this.f2406f) {
            S();
        }
        if (obj instanceof androidx.constraintlayout.core.widgets.d) {
            androidx.constraintlayout.core.widgets.d dVar = (androidx.constraintlayout.core.widgets.d) obj;
            iVarJ = dVar.j();
            if (iVarJ == null) {
                dVar.z(this.f2414n);
                iVarJ = dVar.j();
            }
            int i7 = iVarJ.f2473c;
            if (i7 == -1 || i7 > this.f2402b || this.f2414n.f2391d[i7] == null) {
                if (i7 != -1) {
                    iVarJ.h();
                }
                int i8 = this.f2402b + 1;
                this.f2402b = i8;
                this.f2411k++;
                iVarJ.f2473c = i8;
                iVarJ.f2480j = i.b.UNRESTRICTED;
                this.f2414n.f2391d[i8] = iVarJ;
            }
        }
        return iVarJ;
    }

    public androidx.constraintlayout.core.b v() {
        androidx.constraintlayout.core.b bVarB;
        if (A) {
            bVarB = this.f2414n.f2388a.b();
            if (bVarB == null) {
                bVarB = new b(this.f2414n);
                E++;
            } else {
                bVarB.D();
            }
        } else {
            bVarB = this.f2414n.f2389b.b();
            if (bVarB == null) {
                bVarB = new androidx.constraintlayout.core.b(this.f2414n);
                D++;
            } else {
                bVarB.D();
            }
        }
        i.f();
        return bVarB;
    }

    public i x() {
        f fVar = C;
        if (fVar != null) {
            fVar.f2437r++;
        }
        if (this.f2411k + 1 >= this.f2406f) {
            S();
        }
        i iVarA = a(i.b.SLACK, null);
        int i7 = this.f2402b + 1;
        this.f2402b = i7;
        this.f2411k++;
        iVarA.f2473c = i7;
        this.f2414n.f2391d[i7] = iVarA;
        return iVarA;
    }

    public void z() {
        B();
        String str = " num vars " + this.f2402b + "\n";
        for (int i7 = 0; i7 < this.f2402b + 1; i7++) {
            i iVar = this.f2414n.f2391d[i7];
            if (iVar != null && iVar.f2477g) {
                str = str + " $[" + i7 + "] => " + iVar + " = " + iVar.f2476f + "\n";
            }
        }
        String str2 = str + "\n";
        for (int i8 = 0; i8 < this.f2402b + 1; i8++) {
            i[] iVarArr = this.f2414n.f2391d;
            i iVar2 = iVarArr[i8];
            if (iVar2 != null && iVar2.f2484n) {
                str2 = str2 + " ~[" + i8 + "] => " + iVar2 + " = " + iVarArr[iVar2.f2485o] + " + " + iVar2.f2486p + "\n";
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i9 = 0; i9 < this.f2412l; i9++) {
            str3 = (str3 + this.f2407g[i9].F()) + "\n #  ";
        }
        if (this.f2404d != null) {
            str3 = str3 + "Goal: " + this.f2404d + "\n";
        }
        System.out.println(str3);
    }
}
