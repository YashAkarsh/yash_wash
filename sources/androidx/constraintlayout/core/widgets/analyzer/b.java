package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f3413d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f3414e = 30;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3415f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3416g = 1073741824;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3417h = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3418i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3419j = -2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3420k = -3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<androidx.constraintlayout.core.widgets.e> f3421a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f3422b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.f f3423c;

    public static class a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f3424k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f3425l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static int f3426m = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.e.b f3427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.constraintlayout.core.widgets.e.b f3428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3431e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3432f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3433g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f3434h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f3435i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3436j;
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.b$b, reason: collision with other inner class name */
    public interface InterfaceC0040b {
        void a();

        void b(androidx.constraintlayout.core.widgets.e eVar, a aVar);
    }

    public b(androidx.constraintlayout.core.widgets.f fVar) {
        this.f3423c = fVar;
    }

    private boolean a(InterfaceC0040b interfaceC0040b, androidx.constraintlayout.core.widgets.e eVar, int i7) {
        this.f3422b.f3427a = eVar.H();
        this.f3422b.f3428b = eVar.j0();
        this.f3422b.f3429c = eVar.m0();
        this.f3422b.f3430d = eVar.D();
        a aVar = this.f3422b;
        aVar.f3435i = false;
        aVar.f3436j = i7;
        androidx.constraintlayout.core.widgets.e.b bVar = aVar.f3427a;
        androidx.constraintlayout.core.widgets.e.b bVar2 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
        boolean z7 = bVar == bVar2;
        boolean z8 = aVar.f3428b == bVar2;
        boolean z9 = z7 && eVar.f3611f0 > 0.0f;
        boolean z10 = z8 && eVar.f3611f0 > 0.0f;
        if (z9 && eVar.f3648y[0] == 4) {
            aVar.f3427a = androidx.constraintlayout.core.widgets.e.b.FIXED;
        }
        if (z10 && eVar.f3648y[1] == 4) {
            aVar.f3428b = androidx.constraintlayout.core.widgets.e.b.FIXED;
        }
        interfaceC0040b.b(eVar, aVar);
        eVar.c2(this.f3422b.f3431e);
        eVar.y1(this.f3422b.f3432f);
        eVar.x1(this.f3422b.f3434h);
        eVar.g1(this.f3422b.f3433g);
        a aVar2 = this.f3422b;
        aVar2.f3436j = a.f3424k;
        return aVar2.f3435i;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0098 A[PHI: r10
      0x0098: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0062, B:34:0x0068, B:36:0x006c, B:54:0x0095, B:52:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    private void b(androidx.constraintlayout.core.widgets.f fVar) {
        boolean z7;
        l lVar;
        n nVar;
        int size = fVar.A1.size();
        boolean zS2 = fVar.S2(64);
        InterfaceC0040b interfaceC0040bG2 = fVar.G2();
        for (int i7 = 0; i7 < size; i7++) {
            androidx.constraintlayout.core.widgets.e eVar = fVar.A1.get(i7);
            if (!(eVar instanceof androidx.constraintlayout.core.widgets.h) && !(eVar instanceof androidx.constraintlayout.core.widgets.a) && !eVar.E0() && (!zS2 || (lVar = eVar.f3608e) == null || (nVar = eVar.f3610f) == null || !lVar.f3515e.f3458j || !nVar.f3515e.f3458j)) {
                androidx.constraintlayout.core.widgets.e.b bVarZ = eVar.z(0);
                androidx.constraintlayout.core.widgets.e.b bVarZ2 = eVar.z(1);
                androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                boolean z8 = bVarZ == bVar && eVar.f3644w != 1 && bVarZ2 == bVar && eVar.f3646x != 1;
                if (!z8 && fVar.S2(1) && !(eVar instanceof androidx.constraintlayout.core.widgets.n)) {
                    if (bVarZ == bVar && eVar.f3644w == 0 && bVarZ2 != bVar && !eVar.B0()) {
                        z8 = true;
                    }
                    if (bVarZ2 == bVar && eVar.f3646x == 0 && bVarZ != bVar && !eVar.B0()) {
                        z8 = true;
                    }
                    z7 = (!(bVarZ == bVar || bVarZ2 == bVar) || eVar.f3611f0 <= 0.0f) ? z8 : true;
                }
                if (!z7) {
                    a(interfaceC0040bG2, eVar, a.f3424k);
                    androidx.constraintlayout.core.f fVar2 = fVar.G1;
                    if (fVar2 != null) {
                        fVar2.f2422c++;
                    }
                }
            }
        }
        interfaceC0040bG2.a();
    }

    private void c(androidx.constraintlayout.core.widgets.f fVar, String str, int i7, int i8, int i9) {
        int iQ = fVar.Q();
        int iP = fVar.P();
        fVar.P1(0);
        fVar.O1(0);
        fVar.c2(i8);
        fVar.y1(i9);
        fVar.P1(iQ);
        fVar.O1(iP);
        this.f3423c.X2(i7);
        this.f3423c.n2();
    }

    public long d(androidx.constraintlayout.core.widgets.f fVar, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        boolean zD2;
        int i16;
        int i17;
        boolean z7;
        int i18;
        InterfaceC0040b interfaceC0040b;
        boolean z8;
        androidx.constraintlayout.core.f fVar2;
        InterfaceC0040b interfaceC0040bG2 = fVar.G2();
        int size = fVar.A1.size();
        int iM0 = fVar.m0();
        int iD = fVar.D();
        boolean zB = androidx.constraintlayout.core.widgets.k.b(i7, 128);
        boolean z9 = zB || androidx.constraintlayout.core.widgets.k.b(i7, 64);
        if (z9) {
            for (int i19 = 0; i19 < size; i19++) {
                androidx.constraintlayout.core.widgets.e eVar = fVar.A1.get(i19);
                androidx.constraintlayout.core.widgets.e.b bVarH = eVar.H();
                androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                boolean z10 = (bVarH == bVar) && (eVar.j0() == bVar) && eVar.A() > 0.0f;
                if ((eVar.B0() && z10) || ((eVar.D0() && z10) || (eVar instanceof androidx.constraintlayout.core.widgets.n) || eVar.B0() || eVar.D0())) {
                    z9 = false;
                    break;
                }
            }
        }
        if (z9 && (fVar2 = androidx.constraintlayout.core.e.C) != null) {
            fVar2.f2424e++;
        }
        boolean z11 = z9 & ((i10 == 1073741824 && i12 == 1073741824) || zB);
        int i20 = 2;
        if (z11) {
            int iMin = Math.min(fVar.O(), i11);
            int iMin2 = Math.min(fVar.N(), i13);
            if (i10 == 1073741824 && fVar.m0() != iMin) {
                fVar.c2(iMin);
                fVar.L2();
            }
            if (i12 == 1073741824 && fVar.D() != iMin2) {
                fVar.y1(iMin2);
                fVar.L2();
            }
            if (i10 == 1073741824 && i12 == 1073741824) {
                zD2 = fVar.B2(zB);
                i16 = 2;
            } else {
                boolean zC2 = fVar.C2(zB);
                if (i10 == 1073741824) {
                    zC2 &= fVar.D2(zB, 0);
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                if (i12 == 1073741824) {
                    zD2 = fVar.D2(zB, 1) & zC2;
                    i16++;
                } else {
                    zD2 = zC2;
                }
            }
            if (zD2) {
                fVar.i2(i10 == 1073741824, i12 == 1073741824);
            }
        } else {
            zD2 = false;
            i16 = 0;
        }
        if (zD2 && i16 == 2) {
            return 0L;
        }
        int iH2 = fVar.H2();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = this.f3421a.size();
        if (size > 0) {
            c(fVar, "First pass", 0, iM0, iD);
        }
        if (size2 > 0) {
            androidx.constraintlayout.core.widgets.e.b bVarH2 = fVar.H();
            androidx.constraintlayout.core.widgets.e.b bVar2 = androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT;
            boolean z12 = bVarH2 == bVar2;
            boolean z13 = fVar.j0() == bVar2;
            int iMax = Math.max(fVar.m0(), this.f3423c.Q());
            int iMax2 = Math.max(fVar.D(), this.f3423c.P());
            int i21 = 0;
            boolean zY2 = false;
            while (i21 < size2) {
                androidx.constraintlayout.core.widgets.e eVar2 = this.f3421a.get(i21);
                if (eVar2 instanceof androidx.constraintlayout.core.widgets.n) {
                    int iM1 = eVar2.m0();
                    int iD2 = eVar2.D();
                    boolean zA = a(interfaceC0040bG2, eVar2, a.f3425l) | zY2;
                    androidx.constraintlayout.core.f fVar3 = fVar.G1;
                    if (fVar3 != null) {
                        fVar3.f2423d++;
                    }
                    int iM2 = eVar2.m0();
                    int iD3 = eVar2.D();
                    if (iM2 != iM1) {
                        eVar2.c2(iM2);
                        if (z12 && eVar2.X() > iMax) {
                            iMax = Math.max(iMax, eVar2.X() + eVar2.r(androidx.constraintlayout.core.widgets.d.b.RIGHT).g());
                        }
                        z8 = true;
                    } else {
                        z8 = zA;
                    }
                    if (iD3 != iD2) {
                        eVar2.y1(iD3);
                        if (z13 && eVar2.v() > iMax2) {
                            iMax2 = Math.max(iMax2, eVar2.v() + eVar2.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM).g());
                        }
                        z8 = true;
                    }
                    zY2 = z8 | ((androidx.constraintlayout.core.widgets.n) eVar2).y2();
                }
                i21++;
                iH2 = iH2;
                iD = iD;
                iM0 = iM0;
                i20 = 2;
            }
            int i22 = iH2;
            int i23 = iM0;
            int i24 = iD;
            int i25 = i20;
            int i26 = 0;
            while (i26 < i25) {
                int i27 = 0;
                while (i27 < size2) {
                    androidx.constraintlayout.core.widgets.e eVar3 = this.f3421a.get(i27);
                    if (((eVar3 instanceof androidx.constraintlayout.core.widgets.i) && !(eVar3 instanceof androidx.constraintlayout.core.widgets.n)) || (eVar3 instanceof androidx.constraintlayout.core.widgets.h) || eVar3.l0() == 8 || ((z11 && eVar3.f3608e.f3515e.f3458j && eVar3.f3610f.f3515e.f3458j) || (eVar3 instanceof androidx.constraintlayout.core.widgets.n))) {
                        z7 = z11;
                        i18 = size2;
                        interfaceC0040b = interfaceC0040bG2;
                    } else {
                        int iM3 = eVar3.m0();
                        int iD4 = eVar3.D();
                        int iT = eVar3.t();
                        int i28 = a.f3425l;
                        z7 = z11;
                        if (i26 == 1) {
                            i28 = a.f3426m;
                        }
                        boolean zA2 = a(interfaceC0040bG2, eVar3, i28) | zY2;
                        androidx.constraintlayout.core.f fVar4 = fVar.G1;
                        i18 = size2;
                        interfaceC0040b = interfaceC0040bG2;
                        if (fVar4 != null) {
                            fVar4.f2423d++;
                        }
                        int iM4 = eVar3.m0();
                        int iD5 = eVar3.D();
                        if (iM4 != iM3) {
                            eVar3.c2(iM4);
                            if (z12 && eVar3.X() > iMax) {
                                iMax = Math.max(iMax, eVar3.X() + eVar3.r(androidx.constraintlayout.core.widgets.d.b.RIGHT).g());
                            }
                            zA2 = true;
                        }
                        if (iD5 != iD4) {
                            eVar3.y1(iD5);
                            if (z13 && eVar3.v() > iMax2) {
                                iMax2 = Math.max(iMax2, eVar3.v() + eVar3.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM).g());
                            }
                            zA2 = true;
                        }
                        zY2 = (!eVar3.q0() || iT == eVar3.t()) ? zA2 : true;
                    }
                    i27++;
                    interfaceC0040bG2 = interfaceC0040b;
                    z11 = z7;
                    size2 = i18;
                }
                boolean z14 = z11;
                int i29 = size2;
                InterfaceC0040b interfaceC0040b2 = interfaceC0040bG2;
                if (!zY2) {
                    break;
                }
                i26++;
                c(fVar, "intermediate pass", i26, i23, i24);
                interfaceC0040bG2 = interfaceC0040b2;
                z11 = z14;
                size2 = i29;
                i25 = 2;
                zY2 = false;
            }
            i17 = i22;
        } else {
            i17 = iH2;
        }
        fVar.V2(i17);
        return 0L;
    }

    public void e(androidx.constraintlayout.core.widgets.f fVar) {
        this.f3421a.clear();
        int size = fVar.A1.size();
        for (int i7 = 0; i7 < size; i7++) {
            androidx.constraintlayout.core.widgets.e eVar = fVar.A1.get(i7);
            androidx.constraintlayout.core.widgets.e.b bVarH = eVar.H();
            androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
            if (bVarH == bVar || eVar.j0() == bVar) {
                this.f3421a.add(eVar);
            }
        }
        fVar.L2();
    }
}
