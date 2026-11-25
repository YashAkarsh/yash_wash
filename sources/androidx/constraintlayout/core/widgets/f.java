package androidx.constraintlayout.core.widgets;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f extends o {

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    private static final int f3659g2 = 8;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    private static final boolean f3660h2 = false;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    private static final boolean f3661i2 = false;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    static final boolean f3662j2 = false;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    static int f3663k2;
    androidx.constraintlayout.core.widgets.analyzer.b B1;
    public androidx.constraintlayout.core.widgets.analyzer.e C1;
    private int D1;
    protected androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b E1;
    private boolean F1;
    public androidx.constraintlayout.core.f G1;
    protected androidx.constraintlayout.core.e H1;
    int I1;
    int J1;
    int K1;
    int L1;
    public int M1;
    public int N1;
    c[] O1;
    c[] P1;
    public boolean Q1;
    public boolean R1;
    public boolean S1;
    public int T1;
    public int U1;
    private int V1;
    public boolean W1;
    private boolean X1;
    private boolean Y1;
    int Z1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    private WeakReference<d> f3664a2;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private WeakReference<d> f3665b2;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    private WeakReference<d> f3666c2;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    private WeakReference<d> f3667d2;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    HashSet<e> f3668e2;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.b.a f3669f2;

    public f() {
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.e();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3664a2 = null;
        this.f3665b2 = null;
        this.f3666c2 = null;
        this.f3667d2 = null;
        this.f3668e2 = new HashSet<>();
        this.f3669f2 = new androidx.constraintlayout.core.widgets.analyzer.b.a();
    }

    public static boolean R2(int i7, e eVar, androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b interfaceC0040b, androidx.constraintlayout.core.widgets.analyzer.b.a aVar, int i8) {
        int i9;
        int i10;
        if (interfaceC0040b == null) {
            return false;
        }
        if (eVar.l0() == 8 || (eVar instanceof h) || (eVar instanceof a)) {
            aVar.f3431e = 0;
            aVar.f3432f = 0;
            return false;
        }
        aVar.f3427a = eVar.H();
        aVar.f3428b = eVar.j0();
        aVar.f3429c = eVar.m0();
        aVar.f3430d = eVar.D();
        aVar.f3435i = false;
        aVar.f3436j = i8;
        e.b bVar = aVar.f3427a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z7 = bVar == bVar2;
        boolean z8 = aVar.f3428b == bVar2;
        boolean z9 = z7 && eVar.f3611f0 > 0.0f;
        boolean z10 = z8 && eVar.f3611f0 > 0.0f;
        if (z7 && eVar.r0(0) && eVar.f3644w == 0 && !z9) {
            aVar.f3427a = e.b.WRAP_CONTENT;
            if (z8 && eVar.f3646x == 0) {
                aVar.f3427a = e.b.FIXED;
            }
            z7 = false;
        }
        if (z8 && eVar.r0(1) && eVar.f3646x == 0 && !z10) {
            aVar.f3428b = e.b.WRAP_CONTENT;
            if (z7 && eVar.f3644w == 0) {
                aVar.f3428b = e.b.FIXED;
            }
            z8 = false;
        }
        if (eVar.G0()) {
            aVar.f3427a = e.b.FIXED;
            z7 = false;
        }
        if (eVar.H0()) {
            aVar.f3428b = e.b.FIXED;
            z8 = false;
        }
        if (z9) {
            if (eVar.f3648y[0] == 4) {
                aVar.f3427a = e.b.FIXED;
            } else if (!z8) {
                e.b bVar3 = aVar.f3428b;
                e.b bVar4 = e.b.FIXED;
                if (bVar3 == bVar4) {
                    i10 = aVar.f3430d;
                } else {
                    aVar.f3427a = e.b.WRAP_CONTENT;
                    interfaceC0040b.b(eVar, aVar);
                    i10 = aVar.f3432f;
                }
                aVar.f3427a = bVar4;
                aVar.f3429c = (int) (eVar.A() * i10);
            }
        }
        if (z10) {
            if (eVar.f3648y[1] == 4) {
                aVar.f3428b = e.b.FIXED;
            } else if (!z7) {
                e.b bVar5 = aVar.f3427a;
                e.b bVar6 = e.b.FIXED;
                if (bVar5 == bVar6) {
                    i9 = aVar.f3429c;
                } else {
                    aVar.f3428b = e.b.WRAP_CONTENT;
                    interfaceC0040b.b(eVar, aVar);
                    i9 = aVar.f3431e;
                }
                aVar.f3428b = bVar6;
                if (eVar.B() == -1) {
                    aVar.f3430d = (int) (i9 / eVar.A());
                } else {
                    aVar.f3430d = (int) (eVar.A() * i9);
                }
            }
        }
        interfaceC0040b.b(eVar, aVar);
        eVar.c2(aVar.f3431e);
        eVar.y1(aVar.f3432f);
        eVar.x1(aVar.f3434h);
        eVar.g1(aVar.f3433g);
        aVar.f3436j = androidx.constraintlayout.core.widgets.analyzer.b.a.f3424k;
        return aVar.f3435i;
    }

    private void T2() {
        this.M1 = 0;
        this.N1 = 0;
    }

    private void s2(e eVar) {
        int i7 = this.M1 + 1;
        c[] cVarArr = this.P1;
        if (i7 >= cVarArr.length) {
            this.P1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.P1[this.M1] = new c(eVar, 0, O2());
        this.M1++;
    }

    private void v2(d dVar, androidx.constraintlayout.core.i iVar) {
        this.H1.i(iVar, this.H1.u(dVar), 0, 5);
    }

    private void w2(d dVar, androidx.constraintlayout.core.i iVar) {
        this.H1.i(this.H1.u(dVar), iVar, 0, 5);
    }

    private void x2(e eVar) {
        int i7 = this.N1 + 1;
        c[] cVarArr = this.O1;
        if (i7 >= cVarArr.length) {
            this.O1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.O1[this.N1] = new c(eVar, 1, O2());
        this.N1++;
    }

    public void A2() {
        this.C1.f(H(), j0());
    }

    public boolean B2(boolean z7) {
        return this.C1.g(z7);
    }

    public boolean C2(boolean z7) {
        return this.C1.h(z7);
    }

    public boolean D2(boolean z7, int i7) {
        return this.C1.i(z7, i7);
    }

    public void E2(androidx.constraintlayout.core.f fVar) {
        this.G1 = fVar;
        this.H1.F(fVar);
    }

    public ArrayList<h> F2() {
        ArrayList<h> arrayList = new ArrayList<>();
        int size = this.A1.size();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = this.A1.get(i7);
            if (eVar instanceof h) {
                h hVar = (h) eVar;
                if (hVar.m2() == 0) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    public androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b G2() {
        return this.E1;
    }

    public int H2() {
        return this.V1;
    }

    public androidx.constraintlayout.core.e I2() {
        return this.H1;
    }

    public ArrayList<h> J2() {
        ArrayList<h> arrayList = new ArrayList<>();
        int size = this.A1.size();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = this.A1.get(i7);
            if (eVar instanceof h) {
                h hVar = (h) eVar;
                if (hVar.m2() == 1) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    public boolean K2() {
        return false;
    }

    public void L2() {
        this.C1.o();
    }

    public void M2() {
        this.C1.p();
    }

    public boolean N2() {
        return this.Y1;
    }

    public boolean O2() {
        return this.F1;
    }

    public boolean P2() {
        return this.X1;
    }

    public long Q2(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.I1 = i14;
        this.J1 = i15;
        return this.B1.d(this, i7, i14, i15, i8, i9, i10, i11, i12, i13);
    }

    @Override // androidx.constraintlayout.core.widgets.o, androidx.constraintlayout.core.widgets.e
    public void R0() {
        this.H1.Y();
        this.I1 = 0;
        this.K1 = 0;
        this.J1 = 0;
        this.L1 = 0;
        this.W1 = false;
        super.R0();
    }

    public boolean S2(int i7) {
        return (this.V1 & i7) == i7;
    }

    public void U2(androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0040b interfaceC0040b) {
        this.E1 = interfaceC0040b;
        this.C1.u(interfaceC0040b);
    }

    public void V2(int i7) {
        this.V1 = i7;
        androidx.constraintlayout.core.e.f2396v = S2(512);
    }

    public void W2(int i7, int i8, int i9, int i10) {
        this.I1 = i7;
        this.J1 = i8;
        this.K1 = i9;
        this.L1 = i10;
    }

    public void X2(int i7) {
        this.D1 = i7;
    }

    public void Y2(boolean z7) {
        this.F1 = z7;
    }

    public boolean Z2(androidx.constraintlayout.core.e eVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zS2 = S2(64);
        j2(eVar, zS2);
        int size = this.A1.size();
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            e eVar2 = this.A1.get(i7);
            eVar2.j2(eVar, zS2);
            if (eVar2.t0()) {
                z7 = true;
            }
        }
        return z7;
    }

    public void a3() {
        this.B1.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void b0(StringBuilder sb) {
        sb.append(this.f3628o + ":{\n");
        sb.append("  actualWidth:" + this.f3607d0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f3609e0);
        sb.append("\n");
        Iterator<e> it = l2().iterator();
        while (it.hasNext()) {
            it.next().b0(sb);
            sb.append(",\n");
        }
        sb.append(com.alipay.sdk.util.j.f13808d);
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public String f0() {
        return "ConstraintLayout";
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void i2(boolean z7, boolean z8) {
        super.i2(z7, z8);
        int size = this.A1.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.A1.get(i7).i2(z7, z8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:155:0x0314 A[PHI: r2 r16
      0x0314: PHI (r2v15 ??) = (r2v14 ??), (r2v19 ??), (r2v19 ??), (r2v19 ??) binds: [B:142:0x02d5, B:150:0x02fa, B:151:0x02fc, B:153:0x0302] A[DONT_GENERATE, DONT_INLINE]
      0x0314: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:142:0x02d5, B:150:0x02fa, B:151:0x02fc, B:153:0x0302] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.constraintlayout.core.widgets.o
    public void n2() {
        int i7;
        int i8;
        boolean z7;
        boolean zZ2;
        boolean z8;
        ?? r7;
        ?? r8;
        ?? r13;
        boolean z9;
        int i9;
        e.b bVar;
        int i10 = 0;
        this.f3615h0 = 0;
        this.f3617i0 = 0;
        this.X1 = false;
        this.Y1 = false;
        int size = this.A1.size();
        int iMax = Math.max(0, m0());
        int iMax2 = Math.max(0, D());
        e.b[] bVarArr = this.f3603b0;
        e.b bVar2 = bVarArr[1];
        e.b bVar3 = bVarArr[0];
        androidx.constraintlayout.core.f fVar = this.G1;
        if (fVar != null) {
            fVar.P++;
        }
        if (this.D1 == 0 && k.b(this.V1, 1)) {
            androidx.constraintlayout.core.widgets.analyzer.h.j(this, G2());
            for (int i11 = 0; i11 < size; i11++) {
                e eVar = this.A1.get(i11);
                if (eVar.F0() && !(eVar instanceof h) && !(eVar instanceof a) && !(eVar instanceof n) && !eVar.E0()) {
                    e.b bVarZ = eVar.z(0);
                    e.b bVarZ2 = eVar.z(1);
                    e.b bVar4 = e.b.MATCH_CONSTRAINT;
                    if (!(bVarZ == bVar4 && eVar.f3644w != 1 && bVarZ2 == bVar4 && eVar.f3646x != 1)) {
                        R2(0, eVar, this.E1, new androidx.constraintlayout.core.widgets.analyzer.b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.f3424k);
                    }
                }
            }
        }
        if (size <= 2 || !((bVar3 == (bVar = e.b.WRAP_CONTENT) || bVar2 == bVar) && k.b(this.V1, 1024) && androidx.constraintlayout.core.widgets.analyzer.i.c(this, G2()))) {
            i7 = iMax2;
            i8 = iMax;
            z7 = false;
        } else {
            if (bVar3 == bVar) {
                if (iMax >= m0() || iMax <= 0) {
                    iMax = m0();
                } else {
                    c2(iMax);
                    this.X1 = true;
                }
            }
            if (bVar2 == bVar) {
                if (iMax2 >= D() || iMax2 <= 0) {
                    iMax2 = D();
                } else {
                    y1(iMax2);
                    this.Y1 = true;
                }
            }
            i7 = iMax2;
            i8 = iMax;
            z7 = true;
        }
        boolean z10 = S2(64) || S2(128);
        androidx.constraintlayout.core.e eVar2 = this.H1;
        eVar2.f2408h = false;
        eVar2.f2409i = false;
        if (this.V1 != 0 && z10) {
            eVar2.f2409i = true;
        }
        ArrayList<e> arrayList = this.A1;
        e.b bVarH = H();
        e.b bVar5 = e.b.WRAP_CONTENT;
        boolean z11 = bVarH == bVar5 || j0() == bVar5;
        T2();
        for (int i12 = 0; i12 < size; i12++) {
            e eVar3 = this.A1.get(i12);
            if (eVar3 instanceof o) {
                ((o) eVar3).n2();
            }
        }
        boolean zS2 = S2(64);
        ?? r14 = z7;
        int i13 = 0;
        boolean zR2 = true;
        while (zR2) {
            int i14 = i13 + 1;
            try {
                this.H1.Y();
                T2();
                o(this.H1);
                for (int i15 = i10; i15 < size; i15++) {
                    this.A1.get(i15).o(this.H1);
                }
                zR2 = r2(this.H1);
                WeakReference<d> weakReference = this.f3664a2;
                if (weakReference != null && weakReference.get() != null) {
                    w2(this.f3664a2.get(), this.H1.u(this.R));
                    this.f3664a2 = null;
                }
                WeakReference<d> weakReference2 = this.f3666c2;
                if (weakReference2 != null && weakReference2.get() != null) {
                    v2(this.f3666c2.get(), this.H1.u(this.T));
                    this.f3666c2 = null;
                }
                WeakReference<d> weakReference3 = this.f3665b2;
                if (weakReference3 != null && weakReference3.get() != null) {
                    w2(this.f3665b2.get(), this.H1.u(this.Q));
                    this.f3665b2 = null;
                }
                WeakReference<d> weakReference4 = this.f3667d2;
                if (weakReference4 != null && weakReference4.get() != null) {
                    v2(this.f3667d2.get(), this.H1.u(this.S));
                    this.f3667d2 = null;
                }
                if (zR2) {
                    this.H1.T();
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                System.out.println("EXCEPTION : " + e8);
            }
            if (zR2) {
                zZ2 = Z2(this.H1, k.f3727n);
            } else {
                j2(this.H1, zS2);
                for (int i16 = 0; i16 < size; i16++) {
                    this.A1.get(i16).j2(this.H1, zS2);
                }
                zZ2 = false;
            }
            if (z11 && i14 < 8 && k.f3727n[2]) {
                int i17 = 0;
                int iMax3 = 0;
                int iMax4 = 0;
                while (i17 < size) {
                    e eVar4 = this.A1.get(i17);
                    iMax4 = Math.max(iMax4, eVar4.f3615h0 + eVar4.m0());
                    iMax3 = Math.max(iMax3, eVar4.f3617i0 + eVar4.D());
                    i17++;
                    zZ2 = zZ2;
                }
                z8 = zZ2;
                int iMax5 = Math.max(this.f3629o0, iMax4);
                int iMax6 = Math.max(this.f3631p0, iMax3);
                e.b bVar6 = e.b.WRAP_CONTENT;
                r14 = r14;
                if (bVar3 == bVar6 && m0() < iMax5) {
                    r14 = r14;
                    c2(iMax5);
                    this.f3603b0[0] = bVar6;
                    r14 = 1;
                    z8 = true;
                }
                if (bVar2 == bVar6 && D() < iMax6) {
                    y1(iMax6);
                    this.f3603b0[1] = bVar6;
                    r14 = 1;
                    z8 = true;
                }
            } else {
                z8 = zZ2;
            }
            int iMax7 = Math.max(this.f3629o0, m0());
            ?? r15 = r14;
            if (iMax7 > m0()) {
                c2(iMax7);
                this.f3603b0[0] = e.b.FIXED;
                r15 = 1;
                z8 = true;
            }
            int iMax8 = Math.max(this.f3631p0, D());
            if (iMax8 > D()) {
                y1(iMax8);
                r7 = 1;
                this.f3603b0[1] = e.b.FIXED;
                r8 = 1;
                z8 = true;
            } else {
                r7 = 1;
                r8 = r15;
            }
            if (r8 == 0) {
                e.b bVar7 = this.f3603b0[0];
                e.b bVar8 = e.b.WRAP_CONTENT;
                if (bVar7 == bVar8 && i8 > 0) {
                    r8 = r8;
                    if (m0() > i8) {
                        this.X1 = r7;
                        this.f3603b0[0] = e.b.FIXED;
                        c2(i8);
                        ?? r9 = r7;
                        z8 = r9 == true ? 1 : 0;
                        r8 = r9;
                    }
                }
                r8 = r8;
                r8 = r8;
                if (this.f3603b0[r7] != bVar8 || i7 <= 0 || D() <= i7) {
                    r13 = r8;
                    z9 = z8;
                    i9 = 8;
                } else {
                    this.Y1 = r7;
                    this.f3603b0[r7] = e.b.FIXED;
                    y1(i7);
                    i9 = 8;
                    z9 = true;
                    r13 = 1;
                }
            } else {
                r13 = r8;
                z9 = z8;
                i9 = 8;
            }
            zR2 = i14 > i9 ? false : z9;
            i13 = i14;
            i10 = 0;
            r14 = r13;
        }
        this.A1 = arrayList;
        if (r14 != 0) {
            e.b[] bVarArr2 = this.f3603b0;
            bVarArr2[0] = bVar3;
            bVarArr2[1] = bVar2;
        }
        W0(this.H1.G());
    }

    void q2(e eVar, int i7) {
        if (i7 == 0) {
            s2(eVar);
        } else if (i7 == 1) {
            x2(eVar);
        }
    }

    public boolean r2(androidx.constraintlayout.core.e eVar) {
        boolean zS2 = S2(64);
        g(eVar, zS2);
        int size = this.A1.size();
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            e eVar2 = this.A1.get(i7);
            eVar2.G1(0, false);
            eVar2.G1(1, false);
            if (eVar2 instanceof a) {
                z7 = true;
            }
        }
        if (z7) {
            for (int i8 = 0; i8 < size; i8++) {
                e eVar3 = this.A1.get(i8);
                if (eVar3 instanceof a) {
                    ((a) eVar3).s2();
                }
            }
        }
        this.f3668e2.clear();
        for (int i9 = 0; i9 < size; i9++) {
            e eVar4 = this.A1.get(i9);
            if (eVar4.f()) {
                if (eVar4 instanceof n) {
                    this.f3668e2.add(eVar4);
                } else {
                    eVar4.g(eVar, zS2);
                }
            }
        }
        while (this.f3668e2.size() > 0) {
            int size2 = this.f3668e2.size();
            Iterator<e> it = this.f3668e2.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.o2(this.f3668e2)) {
                    nVar.g(eVar, zS2);
                    this.f3668e2.remove(nVar);
                    break;
                }
            }
            if (size2 == this.f3668e2.size()) {
                Iterator<e> it2 = this.f3668e2.iterator();
                while (it2.hasNext()) {
                    it2.next().g(eVar, zS2);
                }
                this.f3668e2.clear();
            }
        }
        if (androidx.constraintlayout.core.e.f2396v) {
            HashSet<e> hashSet = new HashSet<>();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar5 = this.A1.get(i10);
                if (!eVar5.f()) {
                    hashSet.add(eVar5);
                }
            }
            e(this, eVar, hashSet, H() == e.b.WRAP_CONTENT ? 0 : 1, false);
            for (e eVar6 : hashSet) {
                k.a(this, eVar, eVar6);
                eVar6.g(eVar, zS2);
            }
        } else {
            for (int i11 = 0; i11 < size; i11++) {
                e eVar7 = this.A1.get(i11);
                if (eVar7 instanceof f) {
                    e.b[] bVarArr = eVar7.f3603b0;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar7.D1(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar7.Y1(e.b.FIXED);
                    }
                    eVar7.g(eVar, zS2);
                    if (bVar == bVar3) {
                        eVar7.D1(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar7.Y1(bVar2);
                    }
                } else {
                    k.a(this, eVar, eVar7);
                    if (!eVar7.f()) {
                        eVar7.g(eVar, zS2);
                    }
                }
            }
        }
        if (this.M1 > 0) {
            b.b(this, eVar, null, 0);
        }
        if (this.N1 > 0) {
            b.b(this, eVar, null, 1);
        }
        return true;
    }

    public void t2(d dVar) {
        WeakReference<d> weakReference = this.f3667d2;
        if (weakReference == null || weakReference.get() == null || dVar.f() > this.f3667d2.get().f()) {
            this.f3667d2 = new WeakReference<>(dVar);
        }
    }

    public void u2(d dVar) {
        WeakReference<d> weakReference = this.f3665b2;
        if (weakReference == null || weakReference.get() == null || dVar.f() > this.f3665b2.get().f()) {
            this.f3665b2 = new WeakReference<>(dVar);
        }
    }

    void y2(d dVar) {
        WeakReference<d> weakReference = this.f3666c2;
        if (weakReference == null || weakReference.get() == null || dVar.f() > this.f3666c2.get().f()) {
            this.f3666c2 = new WeakReference<>(dVar);
        }
    }

    void z2(d dVar) {
        WeakReference<d> weakReference = this.f3664a2;
        if (weakReference == null || weakReference.get() == null || dVar.f() > this.f3664a2.get().f()) {
            this.f3664a2 = new WeakReference<>(dVar);
        }
    }

    public f(int i7, int i8, int i9, int i10) {
        super(i7, i8, i9, i10);
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.e();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3664a2 = null;
        this.f3665b2 = null;
        this.f3666c2 = null;
        this.f3667d2 = null;
        this.f3668e2 = new HashSet<>();
        this.f3669f2 = new androidx.constraintlayout.core.widgets.analyzer.b.a();
    }

    public f(int i7, int i8) {
        super(i7, i8);
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.e();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3664a2 = null;
        this.f3665b2 = null;
        this.f3666c2 = null;
        this.f3667d2 = null;
        this.f3668e2 = new HashSet<>();
        this.f3669f2 = new androidx.constraintlayout.core.widgets.analyzer.b.a();
    }

    public f(String str, int i7, int i8) {
        super(i7, i8);
        this.B1 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
        this.C1 = new androidx.constraintlayout.core.widgets.analyzer.e(this);
        this.E1 = null;
        this.F1 = false;
        this.H1 = new androidx.constraintlayout.core.e();
        this.M1 = 0;
        this.N1 = 0;
        this.O1 = new c[4];
        this.P1 = new c[4];
        this.Q1 = false;
        this.R1 = false;
        this.S1 = false;
        this.T1 = 0;
        this.U1 = 0;
        this.V1 = 257;
        this.W1 = false;
        this.X1 = false;
        this.Y1 = false;
        this.Z1 = 0;
        this.f3664a2 = null;
        this.f3665b2 = null;
        this.f3666c2 = null;
        this.f3667d2 = null;
        this.f3668e2 = new HashSet<>();
        this.f3669f2 = new androidx.constraintlayout.core.widgets.analyzer.b.a();
        j1(str);
    }
}
