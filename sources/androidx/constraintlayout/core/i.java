package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class i implements Comparable<i> {
    public static final int A = 7;
    public static final int B = 8;
    private static int C = 1;
    private static int D = 1;
    private static int E = 1;
    private static int F = 1;
    private static int G = 1;
    static final int H = 9;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final boolean f2462r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final boolean f2463s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f2464t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f2465u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2466v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2467w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f2468x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2469y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f2470z = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float[] f2478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float[] f2479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    b f2480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    androidx.constraintlayout.core.b[] f2481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2482l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2483m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f2484n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f2485o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f2486p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    HashSet<androidx.constraintlayout.core.b> f2487q;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2488a;

        static {
            int[] iArr = new int[b.values().length];
            f2488a = iArr;
            try {
                iArr[b.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2488a[b.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2488a[b.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2488a[b.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2488a[b.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(String str, b bVar) {
        this.f2473c = -1;
        this.f2474d = -1;
        this.f2475e = 0;
        this.f2477g = false;
        this.f2478h = new float[9];
        this.f2479i = new float[9];
        this.f2481k = new androidx.constraintlayout.core.b[16];
        this.f2482l = 0;
        this.f2483m = 0;
        this.f2484n = false;
        this.f2485o = -1;
        this.f2486p = 0.0f;
        this.f2487q = null;
        this.f2472b = str;
        this.f2480j = bVar;
    }

    private static String e(b bVar, String str) {
        if (str != null) {
            return str + D;
        }
        int i7 = a.f2488a[bVar.ordinal()];
        if (i7 == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("U");
            int i8 = E + 1;
            E = i8;
            sb.append(i8);
            return sb.toString();
        }
        if (i7 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("C");
            int i9 = F + 1;
            F = i9;
            sb2.append(i9);
            return sb2.toString();
        }
        if (i7 == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("S");
            int i10 = C + 1;
            C = i10;
            sb3.append(i10);
            return sb3.toString();
        }
        if (i7 == 4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("e");
            int i11 = D + 1;
            D = i11;
            sb4.append(i11);
            return sb4.toString();
        }
        if (i7 != 5) {
            throw new AssertionError(bVar.name());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("V");
        int i12 = G + 1;
        G = i12;
        sb5.append(i12);
        return sb5.toString();
    }

    static void f() {
        D++;
    }

    public final void a(androidx.constraintlayout.core.b bVar) {
        int i7 = 0;
        while (true) {
            int i8 = this.f2482l;
            if (i7 >= i8) {
                androidx.constraintlayout.core.b[] bVarArr = this.f2481k;
                if (i8 >= bVarArr.length) {
                    this.f2481k = (androidx.constraintlayout.core.b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                androidx.constraintlayout.core.b[] bVarArr2 = this.f2481k;
                int i9 = this.f2482l;
                bVarArr2[i9] = bVar;
                this.f2482l = i9 + 1;
                return;
            }
            if (this.f2481k[i7] == bVar) {
                return;
            } else {
                i7++;
            }
        }
    }

    void b() {
        for (int i7 = 0; i7 < 9; i7++) {
            this.f2478h[i7] = 0.0f;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f2473c - iVar.f2473c;
    }

    public String d() {
        return this.f2472b;
    }

    public final void g(androidx.constraintlayout.core.b bVar) {
        int i7 = this.f2482l;
        int i8 = 0;
        while (i8 < i7) {
            if (this.f2481k[i8] == bVar) {
                while (i8 < i7 - 1) {
                    androidx.constraintlayout.core.b[] bVarArr = this.f2481k;
                    int i9 = i8 + 1;
                    bVarArr[i8] = bVarArr[i9];
                    i8 = i9;
                }
                this.f2482l--;
                return;
            }
            i8++;
        }
    }

    public void h() {
        this.f2472b = null;
        this.f2480j = b.UNKNOWN;
        this.f2475e = 0;
        this.f2473c = -1;
        this.f2474d = -1;
        this.f2476f = 0.0f;
        this.f2477g = false;
        this.f2484n = false;
        this.f2485o = -1;
        this.f2486p = 0.0f;
        int i7 = this.f2482l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f2481k[i8] = null;
        }
        this.f2482l = 0;
        this.f2483m = 0;
        this.f2471a = false;
        Arrays.fill(this.f2479i, 0.0f);
    }

    public void i(e eVar, float f8) {
        this.f2476f = f8;
        this.f2477g = true;
        this.f2484n = false;
        this.f2485o = -1;
        this.f2486p = 0.0f;
        int i7 = this.f2482l;
        this.f2474d = -1;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f2481k[i8].a(eVar, this, false);
        }
        this.f2482l = 0;
    }

    public void j(String str) {
        this.f2472b = str;
    }

    public void k(e eVar, i iVar, float f8) {
        this.f2484n = true;
        this.f2485o = iVar.f2473c;
        this.f2486p = f8;
        int i7 = this.f2482l;
        this.f2474d = -1;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f2481k[i8].G(eVar, this, false);
        }
        this.f2482l = 0;
        eVar.z();
    }

    public void l(b bVar, String str) {
        this.f2480j = bVar;
    }

    String m() {
        String str = this + "[";
        boolean z7 = false;
        boolean z8 = true;
        for (int i7 = 0; i7 < this.f2478h.length; i7++) {
            String str2 = str + this.f2478h[i7];
            float[] fArr = this.f2478h;
            float f8 = fArr[i7];
            if (f8 > 0.0f) {
                z7 = false;
            } else if (f8 < 0.0f) {
                z7 = true;
            }
            if (f8 != 0.0f) {
                z8 = false;
            }
            str = i7 < fArr.length - 1 ? str2 + ", " : str2 + "] ";
        }
        if (z7) {
            str = str + " (-)";
        }
        if (!z8) {
            return str;
        }
        return str + " (*)";
    }

    public final void n(e eVar, androidx.constraintlayout.core.b bVar) {
        int i7 = this.f2482l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f2481k[i8].c(eVar, bVar, false);
        }
        this.f2482l = 0;
    }

    public String toString() {
        if (this.f2472b != null) {
            return "" + this.f2472b;
        }
        return "" + this.f2473c;
    }

    public i(b bVar, String str) {
        this.f2473c = -1;
        this.f2474d = -1;
        this.f2475e = 0;
        this.f2477g = false;
        this.f2478h = new float[9];
        this.f2479i = new float[9];
        this.f2481k = new androidx.constraintlayout.core.b[16];
        this.f2482l = 0;
        this.f2483m = 0;
        this.f2484n = false;
        this.f2485o = -1;
        this.f2486p = 0.0f;
        this.f2487q = null;
        this.f2480j = bVar;
    }
}
