package androidx.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class j implements b.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final boolean f2495n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final boolean f2496o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static float f2497p = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2498a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2499b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2500c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f2501d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int[] f2502e = new int[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f2503f = new int[16];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float[] f2504g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int[] f2505h = new int[16];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f2506i = new int[16];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f2507j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f2508k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b f2509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final c f2510m;

    j(b bVar, c cVar) {
        this.f2509l = bVar;
        this.f2510m = cVar;
        clear();
    }

    private void a(i iVar, int i7) {
        int[] iArr;
        int i8 = iVar.f2473c % this.f2500c;
        int[] iArr2 = this.f2501d;
        int i9 = iArr2[i8];
        if (i9 == -1) {
            iArr2[i8] = i7;
        } else {
            while (true) {
                iArr = this.f2502e;
                int i10 = iArr[i9];
                if (i10 == -1) {
                    break;
                } else {
                    i9 = i10;
                }
            }
            iArr[i9] = i7;
        }
        this.f2502e[i7] = -1;
    }

    private void p(int i7, i iVar, float f8) {
        this.f2503f[i7] = iVar.f2473c;
        this.f2504g[i7] = f8;
        this.f2505h[i7] = -1;
        this.f2506i[i7] = -1;
        iVar.a(this.f2509l);
        iVar.f2483m++;
        this.f2507j++;
    }

    private void q() {
        for (int i7 = 0; i7 < this.f2500c; i7++) {
            if (this.f2501d[i7] != -1) {
                String str = hashCode() + " hash [" + i7 + "] => ";
                int i8 = this.f2501d[i7];
                boolean z7 = false;
                while (!z7) {
                    str = str + " " + this.f2503f[i8];
                    int i9 = this.f2502e[i8];
                    if (i9 != -1) {
                        i8 = i9;
                    } else {
                        z7 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int r() {
        for (int i7 = 0; i7 < this.f2499b; i7++) {
            if (this.f2503f[i7] == -1) {
                return i7;
            }
        }
        return -1;
    }

    private void s() {
        int i7 = this.f2499b * 2;
        this.f2503f = Arrays.copyOf(this.f2503f, i7);
        this.f2504g = Arrays.copyOf(this.f2504g, i7);
        this.f2505h = Arrays.copyOf(this.f2505h, i7);
        this.f2506i = Arrays.copyOf(this.f2506i, i7);
        this.f2502e = Arrays.copyOf(this.f2502e, i7);
        for (int i8 = this.f2499b; i8 < i7; i8++) {
            this.f2503f[i8] = -1;
            this.f2502e[i8] = -1;
        }
        this.f2499b = i7;
    }

    private void t(int i7, i iVar, float f8) {
        int iR = r();
        p(iR, iVar, f8);
        if (i7 != -1) {
            this.f2505h[iR] = i7;
            int[] iArr = this.f2506i;
            iArr[iR] = iArr[i7];
            iArr[i7] = iR;
        } else {
            this.f2505h[iR] = -1;
            if (this.f2507j > 0) {
                this.f2506i[iR] = this.f2508k;
                this.f2508k = iR;
            } else {
                this.f2506i[iR] = -1;
            }
        }
        int i8 = this.f2506i[iR];
        if (i8 != -1) {
            this.f2505h[i8] = iR;
        }
        a(iVar, iR);
    }

    private void u(i iVar) {
        int[] iArr;
        int i7;
        int i8 = iVar.f2473c;
        int i9 = i8 % this.f2500c;
        int[] iArr2 = this.f2501d;
        int i10 = iArr2[i9];
        if (i10 == -1) {
            return;
        }
        if (this.f2503f[i10] == i8) {
            int[] iArr3 = this.f2502e;
            iArr2[i9] = iArr3[i10];
            iArr3[i10] = -1;
            return;
        }
        while (true) {
            iArr = this.f2502e;
            i7 = iArr[i10];
            if (i7 == -1 || this.f2503f[i7] == i8) {
                break;
            } else {
                i10 = i7;
            }
        }
        if (i7 == -1 || this.f2503f[i7] != i8) {
            return;
        }
        iArr[i10] = iArr[i7];
        iArr[i7] = -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int b() {
        return this.f2507j;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int c(i iVar) {
        if (this.f2507j != 0 && iVar != null) {
            int i7 = iVar.f2473c;
            int i8 = this.f2501d[i7 % this.f2500c];
            if (i8 == -1) {
                return -1;
            }
            if (this.f2503f[i8] == i7) {
                return i8;
            }
            do {
                i8 = this.f2502e[i8];
                if (i8 == -1) {
                    break;
                }
            } while (this.f2503f[i8] != i7);
            if (i8 != -1 && this.f2503f[i8] == i7) {
                return i8;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void clear() {
        int i7 = this.f2507j;
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarH = h(i8);
            if (iVarH != null) {
                iVarH.g(this.f2509l);
            }
        }
        for (int i9 = 0; i9 < this.f2499b; i9++) {
            this.f2503f[i9] = -1;
            this.f2502e[i9] = -1;
        }
        for (int i10 = 0; i10 < this.f2500c; i10++) {
            this.f2501d[i10] = -1;
        }
        this.f2507j = 0;
        this.f2508k = -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d() {
        int i7 = this.f2507j;
        System.out.print("{ ");
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarH = h(i8);
            if (iVarH != null) {
                System.out.print(iVarH + " = " + k(i8) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean e(i iVar) {
        return c(iVar) != -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float f(b bVar, boolean z7) {
        float fM = m(bVar.f2382a);
        l(bVar.f2382a, z7);
        j jVar = (j) bVar.f2386e;
        int iB = jVar.b();
        int i7 = 0;
        int i8 = 0;
        while (i7 < iB) {
            int i9 = jVar.f2503f[i8];
            if (i9 != -1) {
                i(this.f2510m.f2391d[i9], jVar.f2504g[i8] * fM, z7);
                i7++;
            }
            i8++;
        }
        return fM;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void g(i iVar, float f8) {
        float f9 = f2497p;
        if (f8 > (-f9) && f8 < f9) {
            l(iVar, true);
            return;
        }
        if (this.f2507j == 0) {
            p(0, iVar, f8);
            a(iVar, 0);
            this.f2508k = 0;
            return;
        }
        int iC = c(iVar);
        if (iC != -1) {
            this.f2504g[iC] = f8;
            return;
        }
        if (this.f2507j + 1 >= this.f2499b) {
            s();
        }
        int i7 = this.f2507j;
        int i8 = this.f2508k;
        int i9 = -1;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = this.f2503f[i8];
            int i12 = iVar.f2473c;
            if (i11 == i12) {
                this.f2504g[i8] = f8;
                return;
            }
            if (i11 < i12) {
                i9 = i8;
            }
            i8 = this.f2506i[i8];
            if (i8 == -1) {
                break;
            }
        }
        t(i9, iVar, f8);
    }

    @Override // androidx.constraintlayout.core.b.a
    public i h(int i7) {
        int i8 = this.f2507j;
        if (i8 == 0) {
            return null;
        }
        int i9 = this.f2508k;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i7 && i9 != -1) {
                return this.f2510m.f2391d[this.f2503f[i9]];
            }
            i9 = this.f2506i[i9];
            if (i9 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void i(i iVar, float f8, boolean z7) {
        float f9 = f2497p;
        if (f8 <= (-f9) || f8 >= f9) {
            int iC = c(iVar);
            if (iC == -1) {
                g(iVar, f8);
                return;
            }
            float[] fArr = this.f2504g;
            float f10 = fArr[iC] + f8;
            fArr[iC] = f10;
            float f11 = f2497p;
            if (f10 <= (-f11) || f10 >= f11) {
                return;
            }
            fArr[iC] = 0.0f;
            l(iVar, z7);
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void j() {
        int i7 = this.f2507j;
        int i8 = this.f2508k;
        for (int i9 = 0; i9 < i7; i9++) {
            float[] fArr = this.f2504g;
            fArr[i8] = fArr[i8] * (-1.0f);
            i8 = this.f2506i[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float k(int i7) {
        int i8 = this.f2507j;
        int i9 = this.f2508k;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i7) {
                return this.f2504g[i9];
            }
            i9 = this.f2506i[i9];
            if (i9 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float l(i iVar, boolean z7) {
        int iC = c(iVar);
        if (iC == -1) {
            return 0.0f;
        }
        u(iVar);
        float f8 = this.f2504g[iC];
        if (this.f2508k == iC) {
            this.f2508k = this.f2506i[iC];
        }
        this.f2503f[iC] = -1;
        int[] iArr = this.f2505h;
        int i7 = iArr[iC];
        if (i7 != -1) {
            int[] iArr2 = this.f2506i;
            iArr2[i7] = iArr2[iC];
        }
        int i8 = this.f2506i[iC];
        if (i8 != -1) {
            iArr[i8] = iArr[iC];
        }
        this.f2507j--;
        iVar.f2483m--;
        if (z7) {
            iVar.g(this.f2509l);
        }
        return f8;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float m(i iVar) {
        int iC = c(iVar);
        if (iC != -1) {
            return this.f2504g[iC];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int n() {
        return 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void o(float f8) {
        int i7 = this.f2507j;
        int i8 = this.f2508k;
        for (int i9 = 0; i9 < i7; i9++) {
            float[] fArr = this.f2504g;
            fArr[i8] = fArr[i8] / f8;
            i8 = this.f2506i[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i7 = this.f2507j;
        for (int i8 = 0; i8 < i7; i8++) {
            i iVarH = h(i8);
            if (iVarH != null) {
                String str2 = str + iVarH + " = " + k(i8) + " ";
                int iC = c(iVarH);
                String str3 = str2 + "[p: ";
                String str4 = (this.f2505h[iC] != -1 ? str3 + this.f2510m.f2391d[this.f2503f[this.f2505h[iC]]] : str3 + "none") + ", n: ";
                str = (this.f2506i[iC] != -1 ? str4 + this.f2510m.f2391d[this.f2503f[this.f2506i[iC]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
