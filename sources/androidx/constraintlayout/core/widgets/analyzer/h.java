package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3471a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f3472b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f3474d = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b.a f3473c = new b.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f3475e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f3476f = 0;

    private static boolean a(int i7, androidx.constraintlayout.core.widgets.e eVar) {
        androidx.constraintlayout.core.widgets.e.b bVar;
        androidx.constraintlayout.core.widgets.e.b bVar2;
        androidx.constraintlayout.core.widgets.e.b bVarH = eVar.H();
        androidx.constraintlayout.core.widgets.e.b bVarJ0 = eVar.j0();
        androidx.constraintlayout.core.widgets.f fVar = eVar.U() != null ? (androidx.constraintlayout.core.widgets.f) eVar.U() : null;
        if (fVar != null) {
            fVar.H();
            androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.FIXED;
        }
        if (fVar != null) {
            fVar.j0();
            androidx.constraintlayout.core.widgets.e.b bVar4 = androidx.constraintlayout.core.widgets.e.b.FIXED;
        }
        androidx.constraintlayout.core.widgets.e.b bVar5 = androidx.constraintlayout.core.widgets.e.b.FIXED;
        boolean z7 = bVarH == bVar5 || eVar.G0() || bVarH == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT || (bVarH == (bVar2 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) && eVar.f3644w == 0 && eVar.f3611f0 == 0.0f && eVar.r0(0)) || (bVarH == bVar2 && eVar.f3644w == 1 && eVar.u0(0, eVar.m0()));
        boolean z8 = bVarJ0 == bVar5 || eVar.H0() || bVarJ0 == androidx.constraintlayout.core.widgets.e.b.WRAP_CONTENT || (bVarJ0 == (bVar = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) && eVar.f3646x == 0 && eVar.f3611f0 == 0.0f && eVar.r0(1)) || (bVarJ0 == bVar && eVar.f3646x == 1 && eVar.u0(1, eVar.D()));
        if (eVar.f3611f0 <= 0.0f || !(z7 || z8)) {
            return z7 && z8;
        }
        return true;
    }

    private static void b(int i7, androidx.constraintlayout.core.widgets.e eVar, b.InterfaceC0040b interfaceC0040b, boolean z7) {
        androidx.constraintlayout.core.widgets.d dVar;
        androidx.constraintlayout.core.widgets.d dVar2;
        androidx.constraintlayout.core.widgets.d dVar3;
        androidx.constraintlayout.core.widgets.d dVar4;
        if (eVar.z0()) {
            return;
        }
        boolean z8 = true;
        f3475e++;
        if (!(eVar instanceof androidx.constraintlayout.core.widgets.f) && eVar.F0()) {
            int i8 = i7 + 1;
            if (a(i8, eVar)) {
                androidx.constraintlayout.core.widgets.f.R2(i8, eVar, interfaceC0040b, new b.a(), b.a.f3424k);
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR = eVar.r(androidx.constraintlayout.core.widgets.d.b.LEFT);
        androidx.constraintlayout.core.widgets.d dVarR2 = eVar.r(androidx.constraintlayout.core.widgets.d.b.RIGHT);
        int iF = dVarR.f();
        int iF2 = dVarR2.f();
        if (dVarR.e() != null && dVarR.o()) {
            Iterator<androidx.constraintlayout.core.widgets.d> it = dVarR.e().iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.core.widgets.d next = it.next();
                androidx.constraintlayout.core.widgets.e eVar2 = next.f3556d;
                int i9 = i7 + 1;
                boolean zA = a(i9, eVar2);
                if (eVar2.F0() && zA) {
                    androidx.constraintlayout.core.widgets.f.R2(i9, eVar2, interfaceC0040b, new b.a(), b.a.f3424k);
                }
                boolean z9 = ((next == eVar2.Q && (dVar4 = eVar2.S.f3558f) != null && dVar4.o()) || (next == eVar2.S && (dVar3 = eVar2.Q.f3558f) != null && dVar3.o())) ? z8 : false;
                androidx.constraintlayout.core.widgets.e.b bVarH = eVar2.H();
                androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                if (bVarH != bVar || zA) {
                    if (!eVar2.F0()) {
                        androidx.constraintlayout.core.widgets.d dVar5 = eVar2.Q;
                        if (next == dVar5 && eVar2.S.f3558f == null) {
                            int iG = dVar5.g() + iF;
                            eVar2.q1(iG, eVar2.m0() + iG);
                            b(i9, eVar2, interfaceC0040b, z7);
                        } else {
                            androidx.constraintlayout.core.widgets.d dVar6 = eVar2.S;
                            if (next == dVar6 && dVar5.f3558f == null) {
                                int iG2 = iF - dVar6.g();
                                eVar2.q1(iG2 - eVar2.m0(), iG2);
                                b(i9, eVar2, interfaceC0040b, z7);
                            } else if (z9 && !eVar2.B0()) {
                                f(i9, interfaceC0040b, eVar2, z7);
                            }
                        }
                    }
                } else if (eVar2.H() == bVar && eVar2.A >= 0 && eVar2.f3650z >= 0 && ((eVar2.l0() == 8 || (eVar2.f3644w == 0 && eVar2.A() == 0.0f)) && !eVar2.B0() && !eVar2.E0() && z9 && !eVar2.B0())) {
                    g(i9, eVar, interfaceC0040b, eVar2, z7);
                }
                z8 = true;
            }
        }
        if (eVar instanceof androidx.constraintlayout.core.widgets.h) {
            return;
        }
        if (dVarR2.e() != null && dVarR2.o()) {
            Iterator<androidx.constraintlayout.core.widgets.d> it2 = dVarR2.e().iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.core.widgets.d next2 = it2.next();
                androidx.constraintlayout.core.widgets.e eVar3 = next2.f3556d;
                int i10 = i7 + 1;
                boolean zA2 = a(i10, eVar3);
                if (eVar3.F0() && zA2) {
                    androidx.constraintlayout.core.widgets.f.R2(i10, eVar3, interfaceC0040b, new b.a(), b.a.f3424k);
                }
                boolean z10 = (next2 == eVar3.Q && (dVar2 = eVar3.S.f3558f) != null && dVar2.o()) || (next2 == eVar3.S && (dVar = eVar3.Q.f3558f) != null && dVar.o());
                androidx.constraintlayout.core.widgets.e.b bVarH2 = eVar3.H();
                androidx.constraintlayout.core.widgets.e.b bVar2 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                if (bVarH2 != bVar2 || zA2) {
                    if (!eVar3.F0()) {
                        androidx.constraintlayout.core.widgets.d dVar7 = eVar3.Q;
                        if (next2 == dVar7 && eVar3.S.f3558f == null) {
                            int iG3 = dVar7.g() + iF2;
                            eVar3.q1(iG3, eVar3.m0() + iG3);
                            b(i10, eVar3, interfaceC0040b, z7);
                        } else {
                            androidx.constraintlayout.core.widgets.d dVar8 = eVar3.S;
                            if (next2 == dVar8 && dVar7.f3558f == null) {
                                int iG4 = iF2 - dVar8.g();
                                eVar3.q1(iG4 - eVar3.m0(), iG4);
                                b(i10, eVar3, interfaceC0040b, z7);
                            } else if (z10 && !eVar3.B0()) {
                                f(i10, interfaceC0040b, eVar3, z7);
                            }
                        }
                    }
                } else if (eVar3.H() == bVar2 && eVar3.A >= 0 && eVar3.f3650z >= 0 && (eVar3.l0() == 8 || (eVar3.f3644w == 0 && eVar3.A() == 0.0f))) {
                    if (!eVar3.B0() && !eVar3.E0() && z10 && !eVar3.B0()) {
                        g(i10, eVar, interfaceC0040b, eVar3, z7);
                    }
                }
            }
        }
        eVar.N0();
    }

    public static String c(int i7) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i7; i8++) {
            sb.append("  ");
        }
        sb.append("+-(" + i7 + ") ");
        return sb.toString();
    }

    private static void d(int i7, androidx.constraintlayout.core.widgets.a aVar, b.InterfaceC0040b interfaceC0040b, int i8, boolean z7) {
        if (aVar.m2()) {
            if (i8 == 0) {
                b(i7 + 1, aVar, interfaceC0040b, z7);
            } else {
                k(i7 + 1, aVar, interfaceC0040b);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:107:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:109:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:112:0x01dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x01df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x01e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:116:0x0204  */
    /* JADX WARN: Code duplicated, block: B:118:0x0225 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:120:0x0227 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x0122  */
    /* JADX WARN: Code duplicated, block: B:80:0x0127  */
    /* JADX WARN: Code duplicated, block: B:83:0x0135  */
    /* JADX WARN: Code duplicated, block: B:84:0x013e  */
    /* JADX WARN: Code duplicated, block: B:87:0x014f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0151  */
    /* JADX WARN: Code duplicated, block: B:90:0x0157  */
    /* JADX WARN: Code duplicated, block: B:92:0x015f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0161  */
    /* JADX WARN: Code duplicated, block: B:94:0x016c  */
    /* JADX WARN: Code duplicated, block: B:96:0x017a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0185  */
    /* JADX WARN: Code duplicated, block: B:99:0x019a  */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    public static boolean e(androidx.constraintlayout.core.widgets.f fVar, androidx.constraintlayout.core.e eVar, int i7, int i8, androidx.constraintlayout.core.widgets.c cVar, boolean z7, boolean z8, boolean z9) {
        int iF;
        int iF2;
        int iF3;
        int i9;
        int iG;
        androidx.constraintlayout.core.widgets.e eVar2;
        boolean z10;
        ?? r7;
        int iG2;
        int iD;
        androidx.constraintlayout.core.widgets.d dVar;
        androidx.constraintlayout.core.widgets.e eVar3;
        androidx.constraintlayout.core.widgets.d dVar2;
        float fG0;
        int i10;
        if (z9) {
            return false;
        }
        if (i7 == 0) {
            if (!fVar.G0()) {
                return false;
            }
        } else if (!fVar.H0()) {
            return false;
        }
        boolean zO2 = fVar.O2();
        androidx.constraintlayout.core.widgets.e eVarC = cVar.c();
        androidx.constraintlayout.core.widgets.e eVarG = cVar.g();
        androidx.constraintlayout.core.widgets.e eVarE = cVar.e();
        androidx.constraintlayout.core.widgets.e eVarI = cVar.i();
        androidx.constraintlayout.core.widgets.e eVarF = cVar.f();
        androidx.constraintlayout.core.widgets.d dVar3 = eVarC.Y[i8];
        int i11 = i8 + 1;
        androidx.constraintlayout.core.widgets.d dVar4 = eVarG.Y[i11];
        androidx.constraintlayout.core.widgets.d dVar5 = dVar3.f3558f;
        if (dVar5 == null || dVar4.f3558f == null || !dVar5.o() || !dVar4.f3558f.o() || eVarE == null || eVarI == null || (iF3 = (iF2 = dVar4.f3558f.f() - eVarI.Y[i11].g()) - (iF = dVar3.f3558f.f() + eVarE.Y[i8].g())) <= 0) {
            return false;
        }
        b.a aVar = new b.a();
        boolean z11 = false;
        int i12 = 0;
        int i13 = 0;
        int iG3 = 0;
        androidx.constraintlayout.core.widgets.e eVar4 = eVarC;
        while (true) {
            androidx.constraintlayout.core.widgets.e eVar5 = null;
            if (z11) {
                androidx.constraintlayout.core.widgets.e eVar6 = eVarC;
                if (i12 == 0 || i12 != i13 || iF3 < iG3) {
                    return false;
                }
                int i14 = iF3 - iG3;
                if (!z7) {
                    if (z8 && i12 > 2) {
                        i9 = 1;
                        i14 = (i14 / i12) - 1;
                    }
                    if (i12 == i9) {
                        if (i7 == 0) {
                            fG0 = eVarF.E();
                        } else {
                            fG0 = eVarF.g0();
                        }
                        i10 = (int) (iF + 0.5f + (i14 * fG0));
                        if (i7 == 0) {
                            eVarE.q1(i10, eVarE.m0() + i10);
                        } else {
                            eVarE.t1(i10, eVarE.D() + i10);
                        }
                        b(1, eVarE, fVar.G2(), zO2);
                        return true;
                    }
                    if (z7) {
                        if (z8) {
                            return true;
                        }
                        if (i12 == 2) {
                            return false;
                        }
                        if (i7 == 0) {
                            eVarE.q1(iF, eVarE.m0() + iF);
                            eVarI.q1(iF2 - eVarI.m0(), iF2);
                            b(1, eVarE, fVar.G2(), zO2);
                            b(1, eVarI, fVar.G2(), zO2);
                            return true;
                        }
                        eVarE.t1(iF, eVarE.D() + iF);
                        eVarI.t1(iF2 - eVarI.D(), iF2);
                        k(1, eVarE, fVar.G2());
                        k(1, eVarI, fVar.G2());
                        return true;
                    }
                    iG = iF + i14;
                    eVar2 = eVar6;
                    z10 = false;
                    while (!z10) {
                        if (eVar2.l0() == 8) {
                            iG2 = iG + eVar2.Y[i8].g();
                            if (i7 == 0) {
                                r7 = i9;
                                eVar2.q1(iG2, eVar2.m0() + iG2);
                                b(1, eVar2, fVar.G2(), zO2);
                                iD = eVar2.m0();
                            } else {
                                r7 = i9;
                                eVar2.t1(iG2, eVar2.D() + iG2);
                                k(1, eVar2, fVar.G2());
                                iD = eVar2.D();
                            }
                            iG = iG2 + iD + eVar2.Y[i11].g() + i14;
                        } else if (i7 == 0) {
                            eVar2.q1(iG, iG);
                            b(r7, eVar2, fVar.G2(), zO2);
                        } else {
                            eVar2.t1(iG, iG);
                            k(r7, eVar2, fVar.G2());
                        }
                        eVar2.g(eVar, false);
                        dVar = eVar2.Y[i11].f3558f;
                        if (dVar != null) {
                            eVar3 = dVar.f3556d;
                            dVar2 = eVar3.Y[i8].f3558f;
                            if (dVar2 != null || dVar2.f3556d != eVar2) {
                                eVar3 = null;
                            }
                        } else {
                            eVar3 = null;
                        }
                        if (eVar3 != null) {
                            eVar2 = eVar3;
                        } else {
                            z10 = true;
                        }
                        r7 = 1;
                    }
                    r7 = i9;
                    return r7;
                }
                i14 /= i12 + 1;
                i9 = 1;
                if (i12 == i9) {
                    if (i7 == 0) {
                        fG0 = eVarF.E();
                    } else {
                        fG0 = eVarF.g0();
                    }
                    i10 = (int) (iF + 0.5f + (i14 * fG0));
                    if (i7 == 0) {
                        eVarE.q1(i10, eVarE.m0() + i10);
                    } else {
                        eVarE.t1(i10, eVarE.D() + i10);
                    }
                    b(1, eVarE, fVar.G2(), zO2);
                    return true;
                }
                if (z7) {
                    if (z8) {
                        return true;
                    }
                    if (i12 == 2) {
                        return false;
                    }
                    if (i7 == 0) {
                        eVarE.q1(iF, eVarE.m0() + iF);
                        eVarI.q1(iF2 - eVarI.m0(), iF2);
                        b(1, eVarE, fVar.G2(), zO2);
                        b(1, eVarI, fVar.G2(), zO2);
                        return true;
                    }
                    eVarE.t1(iF, eVarE.D() + iF);
                    eVarI.t1(iF2 - eVarI.D(), iF2);
                    k(1, eVarE, fVar.G2());
                    k(1, eVarI, fVar.G2());
                    return true;
                }
                iG = iF + i14;
                eVar2 = eVar6;
                z10 = false;
                while (!z10) {
                    if (eVar2.l0() == 8) {
                        iG2 = iG + eVar2.Y[i8].g();
                        if (i7 == 0) {
                            r7 = i9;
                            eVar2.q1(iG2, eVar2.m0() + iG2);
                            b(1, eVar2, fVar.G2(), zO2);
                            iD = eVar2.m0();
                        } else {
                            r7 = i9;
                            eVar2.t1(iG2, eVar2.D() + iG2);
                            k(1, eVar2, fVar.G2());
                            iD = eVar2.D();
                        }
                        iG = iG2 + iD + eVar2.Y[i11].g() + i14;
                    } else if (i7 == 0) {
                        eVar2.q1(iG, iG);
                        b(r7, eVar2, fVar.G2(), zO2);
                    } else {
                        eVar2.t1(iG, iG);
                        k(r7, eVar2, fVar.G2());
                    }
                    eVar2.g(eVar, false);
                    dVar = eVar2.Y[i11].f3558f;
                    if (dVar != null) {
                        eVar3 = dVar.f3556d;
                        dVar2 = eVar3.Y[i8].f3558f;
                        if (dVar2 != null) {
                            eVar3 = null;
                        } else {
                            eVar3 = null;
                        }
                    } else {
                        eVar3 = null;
                    }
                    if (eVar3 != null) {
                        eVar2 = eVar3;
                    } else {
                        z10 = true;
                    }
                    r7 = 1;
                }
                r7 = i9;
                return r7;
            }
            if (!a(1, eVar4)) {
                return false;
            }
            androidx.constraintlayout.core.widgets.e eVar7 = eVarC;
            if (eVar4.f3603b0[i7] == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                return false;
            }
            if (eVar4.F0()) {
                androidx.constraintlayout.core.widgets.f.R2(1, eVar4, fVar.G2(), aVar, b.a.f3424k);
            }
            iG3 = iG3 + eVar4.Y[i8].g() + (i7 == 0 ? eVar4.m0() : eVar4.D()) + eVar4.Y[i11].g();
            i13++;
            if (eVar4.l0() != 8) {
                i12++;
            }
            androidx.constraintlayout.core.widgets.d dVar6 = eVar4.Y[i11].f3558f;
            if (dVar6 != null) {
                androidx.constraintlayout.core.widgets.e eVar8 = dVar6.f3556d;
                androidx.constraintlayout.core.widgets.d dVar7 = eVar8.Y[i8].f3558f;
                if (dVar7 != null && dVar7.f3556d == eVar4) {
                    eVar5 = eVar8;
                }
            }
            if (eVar5 != null) {
                eVar4 = eVar5;
                z11 = z11;
            } else {
                z11 = true;
            }
            eVarC = eVar7;
        }
    }

    private static void f(int i7, b.InterfaceC0040b interfaceC0040b, androidx.constraintlayout.core.widgets.e eVar, boolean z7) {
        float fE = eVar.E();
        int iF = eVar.Q.f3558f.f();
        int iF2 = eVar.S.f3558f.f();
        int iG = eVar.Q.g() + iF;
        int iG2 = iF2 - eVar.S.g();
        if (iF == iF2) {
            fE = 0.5f;
        } else {
            iF = iG;
            iF2 = iG2;
        }
        int iM0 = eVar.m0();
        int i8 = (iF2 - iF) - iM0;
        if (iF > iF2) {
            i8 = (iF - iF2) - iM0;
        }
        int i9 = ((int) (i8 > 0 ? (fE * i8) + 0.5f : fE * i8)) + iF;
        int i10 = i9 + iM0;
        if (iF > iF2) {
            i10 = i9 - iM0;
        }
        eVar.q1(i9, i10);
        b(i7 + 1, eVar, interfaceC0040b, z7);
    }

    private static void g(int i7, androidx.constraintlayout.core.widgets.e eVar, b.InterfaceC0040b interfaceC0040b, androidx.constraintlayout.core.widgets.e eVar2, boolean z7) {
        float fE = eVar2.E();
        int iF = eVar2.Q.f3558f.f() + eVar2.Q.g();
        int iF2 = eVar2.S.f3558f.f() - eVar2.S.g();
        if (iF2 >= iF) {
            int iM0 = eVar2.m0();
            if (eVar2.l0() != 8) {
                int i8 = eVar2.f3644w;
                if (i8 == 2) {
                    iM0 = (int) (eVar2.E() * 0.5f * (eVar instanceof androidx.constraintlayout.core.widgets.f ? eVar.m0() : eVar.U().m0()));
                } else if (i8 == 0) {
                    iM0 = iF2 - iF;
                }
                iM0 = Math.max(eVar2.f3650z, iM0);
                int i9 = eVar2.A;
                if (i9 > 0) {
                    iM0 = Math.min(i9, iM0);
                }
            }
            int i10 = iF + ((int) ((fE * ((iF2 - iF) - iM0)) + 0.5f));
            eVar2.q1(i10, iM0 + i10);
            b(i7 + 1, eVar2, interfaceC0040b, z7);
        }
    }

    private static void h(int i7, b.InterfaceC0040b interfaceC0040b, androidx.constraintlayout.core.widgets.e eVar) {
        float fG0 = eVar.g0();
        int iF = eVar.R.f3558f.f();
        int iF2 = eVar.T.f3558f.f();
        int iG = eVar.R.g() + iF;
        int iG2 = iF2 - eVar.T.g();
        if (iF == iF2) {
            fG0 = 0.5f;
        } else {
            iF = iG;
            iF2 = iG2;
        }
        int iD = eVar.D();
        int i8 = (iF2 - iF) - iD;
        if (iF > iF2) {
            i8 = (iF - iF2) - iD;
        }
        int i9 = (int) (i8 > 0 ? (fG0 * i8) + 0.5f : fG0 * i8);
        int i10 = iF + i9;
        int i11 = i10 + iD;
        if (iF > iF2) {
            i10 = iF - i9;
            i11 = i10 - iD;
        }
        eVar.t1(i10, i11);
        k(i7 + 1, eVar, interfaceC0040b);
    }

    private static void i(int i7, androidx.constraintlayout.core.widgets.e eVar, b.InterfaceC0040b interfaceC0040b, androidx.constraintlayout.core.widgets.e eVar2) {
        float fG0 = eVar2.g0();
        int iF = eVar2.R.f3558f.f() + eVar2.R.g();
        int iF2 = eVar2.T.f3558f.f() - eVar2.T.g();
        if (iF2 >= iF) {
            int iD = eVar2.D();
            if (eVar2.l0() != 8) {
                int i8 = eVar2.f3646x;
                if (i8 == 2) {
                    iD = (int) (fG0 * 0.5f * (eVar instanceof androidx.constraintlayout.core.widgets.f ? eVar.D() : eVar.U().D()));
                } else if (i8 == 0) {
                    iD = iF2 - iF;
                }
                iD = Math.max(eVar2.C, iD);
                int i9 = eVar2.D;
                if (i9 > 0) {
                    iD = Math.min(i9, iD);
                }
            }
            int i10 = iF + ((int) ((fG0 * ((iF2 - iF) - iD)) + 0.5f));
            eVar2.t1(i10, iD + i10);
            k(i7 + 1, eVar2, interfaceC0040b);
        }
    }

    public static void j(androidx.constraintlayout.core.widgets.f fVar, b.InterfaceC0040b interfaceC0040b) {
        androidx.constraintlayout.core.widgets.e.b bVarH = fVar.H();
        androidx.constraintlayout.core.widgets.e.b bVarJ0 = fVar.j0();
        f3475e = 0;
        f3476f = 0;
        fVar.V0();
        ArrayList<androidx.constraintlayout.core.widgets.e> arrayListL2 = fVar.l2();
        int size = arrayListL2.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayListL2.get(i7).V0();
        }
        boolean zO2 = fVar.O2();
        if (bVarH == androidx.constraintlayout.core.widgets.e.b.FIXED) {
            fVar.q1(0, fVar.m0());
        } else {
            fVar.r1(0);
        }
        boolean z7 = false;
        boolean z8 = false;
        for (int i8 = 0; i8 < size; i8++) {
            androidx.constraintlayout.core.widgets.e eVar = arrayListL2.get(i8);
            if (eVar instanceof androidx.constraintlayout.core.widgets.h) {
                androidx.constraintlayout.core.widgets.h hVar = (androidx.constraintlayout.core.widgets.h) eVar;
                if (hVar.m2() == 1) {
                    if (hVar.n2() != -1) {
                        hVar.v2(hVar.n2());
                    } else if (hVar.p2() != -1 && fVar.G0()) {
                        hVar.v2(fVar.m0() - hVar.p2());
                    } else if (fVar.G0()) {
                        hVar.v2((int) ((hVar.q2() * fVar.m0()) + 0.5f));
                    }
                    z7 = true;
                }
            } else if ((eVar instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) eVar).r2() == 0) {
                z8 = true;
            }
        }
        if (z7) {
            for (int i9 = 0; i9 < size; i9++) {
                androidx.constraintlayout.core.widgets.e eVar2 = arrayListL2.get(i9);
                if (eVar2 instanceof androidx.constraintlayout.core.widgets.h) {
                    androidx.constraintlayout.core.widgets.h hVar2 = (androidx.constraintlayout.core.widgets.h) eVar2;
                    if (hVar2.m2() == 1) {
                        b(0, hVar2, interfaceC0040b, zO2);
                    }
                }
            }
        }
        b(0, fVar, interfaceC0040b, zO2);
        if (z8) {
            for (int i10 = 0; i10 < size; i10++) {
                androidx.constraintlayout.core.widgets.e eVar3 = arrayListL2.get(i10);
                if (eVar3 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) eVar3;
                    if (aVar.r2() == 0) {
                        d(0, aVar, interfaceC0040b, 0, zO2);
                    }
                }
            }
        }
        if (bVarJ0 == androidx.constraintlayout.core.widgets.e.b.FIXED) {
            fVar.t1(0, fVar.D());
        } else {
            fVar.s1(0);
        }
        boolean z9 = false;
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            androidx.constraintlayout.core.widgets.e eVar4 = arrayListL2.get(i11);
            if (eVar4 instanceof androidx.constraintlayout.core.widgets.h) {
                androidx.constraintlayout.core.widgets.h hVar3 = (androidx.constraintlayout.core.widgets.h) eVar4;
                if (hVar3.m2() == 0) {
                    if (hVar3.n2() != -1) {
                        hVar3.v2(hVar3.n2());
                    } else if (hVar3.p2() != -1 && fVar.H0()) {
                        hVar3.v2(fVar.D() - hVar3.p2());
                    } else if (fVar.H0()) {
                        hVar3.v2((int) ((hVar3.q2() * fVar.D()) + 0.5f));
                    }
                    z9 = true;
                }
            } else if ((eVar4 instanceof androidx.constraintlayout.core.widgets.a) && ((androidx.constraintlayout.core.widgets.a) eVar4).r2() == 1) {
                z10 = true;
            }
        }
        if (z9) {
            for (int i12 = 0; i12 < size; i12++) {
                androidx.constraintlayout.core.widgets.e eVar5 = arrayListL2.get(i12);
                if (eVar5 instanceof androidx.constraintlayout.core.widgets.h) {
                    androidx.constraintlayout.core.widgets.h hVar4 = (androidx.constraintlayout.core.widgets.h) eVar5;
                    if (hVar4.m2() == 0) {
                        k(1, hVar4, interfaceC0040b);
                    }
                }
            }
        }
        k(0, fVar, interfaceC0040b);
        if (z10) {
            for (int i13 = 0; i13 < size; i13++) {
                androidx.constraintlayout.core.widgets.e eVar6 = arrayListL2.get(i13);
                if (eVar6 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) eVar6;
                    if (aVar2.r2() == 1) {
                        d(0, aVar2, interfaceC0040b, 1, zO2);
                    }
                }
            }
        }
        for (int i14 = 0; i14 < size; i14++) {
            androidx.constraintlayout.core.widgets.e eVar7 = arrayListL2.get(i14);
            if (eVar7.F0() && a(0, eVar7)) {
                androidx.constraintlayout.core.widgets.f.R2(0, eVar7, interfaceC0040b, f3473c, b.a.f3424k);
                if (!(eVar7 instanceof androidx.constraintlayout.core.widgets.h)) {
                    b(0, eVar7, interfaceC0040b, zO2);
                    k(0, eVar7, interfaceC0040b);
                } else if (((androidx.constraintlayout.core.widgets.h) eVar7).m2() == 0) {
                    k(0, eVar7, interfaceC0040b);
                } else {
                    b(0, eVar7, interfaceC0040b, zO2);
                }
            }
        }
    }

    private static void k(int i7, androidx.constraintlayout.core.widgets.e eVar, b.InterfaceC0040b interfaceC0040b) {
        androidx.constraintlayout.core.widgets.d dVar;
        androidx.constraintlayout.core.widgets.d dVar2;
        androidx.constraintlayout.core.widgets.d dVar3;
        androidx.constraintlayout.core.widgets.d dVar4;
        if (eVar.L0()) {
            return;
        }
        f3476f++;
        if (!(eVar instanceof androidx.constraintlayout.core.widgets.f) && eVar.F0()) {
            int i8 = i7 + 1;
            if (a(i8, eVar)) {
                androidx.constraintlayout.core.widgets.f.R2(i8, eVar, interfaceC0040b, new b.a(), b.a.f3424k);
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR = eVar.r(androidx.constraintlayout.core.widgets.d.b.TOP);
        androidx.constraintlayout.core.widgets.d dVarR2 = eVar.r(androidx.constraintlayout.core.widgets.d.b.BOTTOM);
        int iF = dVarR.f();
        int iF2 = dVarR2.f();
        if (dVarR.e() != null && dVarR.o()) {
            Iterator<androidx.constraintlayout.core.widgets.d> it = dVarR.e().iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.core.widgets.d next = it.next();
                androidx.constraintlayout.core.widgets.e eVar2 = next.f3556d;
                int i9 = i7 + 1;
                boolean zA = a(i9, eVar2);
                if (eVar2.F0() && zA) {
                    androidx.constraintlayout.core.widgets.f.R2(i9, eVar2, interfaceC0040b, new b.a(), b.a.f3424k);
                }
                boolean z7 = (next == eVar2.R && (dVar4 = eVar2.T.f3558f) != null && dVar4.o()) || (next == eVar2.T && (dVar3 = eVar2.R.f3558f) != null && dVar3.o());
                androidx.constraintlayout.core.widgets.e.b bVarJ0 = eVar2.j0();
                androidx.constraintlayout.core.widgets.e.b bVar = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                if (bVarJ0 != bVar || zA) {
                    if (!eVar2.F0()) {
                        androidx.constraintlayout.core.widgets.d dVar5 = eVar2.R;
                        if (next == dVar5 && eVar2.T.f3558f == null) {
                            int iG = dVar5.g() + iF;
                            eVar2.t1(iG, eVar2.D() + iG);
                            k(i9, eVar2, interfaceC0040b);
                        } else {
                            androidx.constraintlayout.core.widgets.d dVar6 = eVar2.T;
                            if (next == dVar6 && dVar5.f3558f == null) {
                                int iG2 = iF - dVar6.g();
                                eVar2.t1(iG2 - eVar2.D(), iG2);
                                k(i9, eVar2, interfaceC0040b);
                            } else if (z7 && !eVar2.D0()) {
                                h(i9, interfaceC0040b, eVar2);
                            }
                        }
                    }
                } else if (eVar2.j0() == bVar && eVar2.D >= 0 && eVar2.C >= 0 && (eVar2.l0() == 8 || (eVar2.f3646x == 0 && eVar2.A() == 0.0f))) {
                    if (!eVar2.D0() && !eVar2.E0() && z7 && !eVar2.D0()) {
                        i(i9, eVar, interfaceC0040b, eVar2);
                    }
                }
            }
        }
        if (eVar instanceof androidx.constraintlayout.core.widgets.h) {
            return;
        }
        if (dVarR2.e() != null && dVarR2.o()) {
            Iterator<androidx.constraintlayout.core.widgets.d> it2 = dVarR2.e().iterator();
            while (it2.hasNext()) {
                androidx.constraintlayout.core.widgets.d next2 = it2.next();
                androidx.constraintlayout.core.widgets.e eVar3 = next2.f3556d;
                int i10 = i7 + 1;
                boolean zA2 = a(i10, eVar3);
                if (eVar3.F0() && zA2) {
                    androidx.constraintlayout.core.widgets.f.R2(i10, eVar3, interfaceC0040b, new b.a(), b.a.f3424k);
                }
                boolean z8 = (next2 == eVar3.R && (dVar2 = eVar3.T.f3558f) != null && dVar2.o()) || (next2 == eVar3.T && (dVar = eVar3.R.f3558f) != null && dVar.o());
                androidx.constraintlayout.core.widgets.e.b bVarJ1 = eVar3.j0();
                androidx.constraintlayout.core.widgets.e.b bVar2 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                if (bVarJ1 != bVar2 || zA2) {
                    if (!eVar3.F0()) {
                        androidx.constraintlayout.core.widgets.d dVar7 = eVar3.R;
                        if (next2 == dVar7 && eVar3.T.f3558f == null) {
                            int iG3 = dVar7.g() + iF2;
                            eVar3.t1(iG3, eVar3.D() + iG3);
                            k(i10, eVar3, interfaceC0040b);
                        } else {
                            androidx.constraintlayout.core.widgets.d dVar8 = eVar3.T;
                            if (next2 == dVar8 && dVar7.f3558f == null) {
                                int iG4 = iF2 - dVar8.g();
                                eVar3.t1(iG4 - eVar3.D(), iG4);
                                k(i10, eVar3, interfaceC0040b);
                            } else if (z8 && !eVar3.D0()) {
                                h(i10, interfaceC0040b, eVar3);
                            }
                        }
                    }
                } else if (eVar3.j0() == bVar2 && eVar3.D >= 0 && eVar3.C >= 0 && (eVar3.l0() == 8 || (eVar3.f3646x == 0 && eVar3.A() == 0.0f))) {
                    if (!eVar3.D0() && !eVar3.E0() && z8 && !eVar3.D0()) {
                        i(i10, eVar, interfaceC0040b, eVar3);
                    }
                }
            }
        }
        androidx.constraintlayout.core.widgets.d dVarR3 = eVar.r(androidx.constraintlayout.core.widgets.d.b.BASELINE);
        if (dVarR3.e() != null && dVarR3.o()) {
            int iF3 = dVarR3.f();
            for (androidx.constraintlayout.core.widgets.d dVar9 : dVarR3.e()) {
                androidx.constraintlayout.core.widgets.e eVar4 = dVar9.f3556d;
                int i11 = i7 + 1;
                boolean zA3 = a(i11, eVar4);
                if (eVar4.F0() && zA3) {
                    androidx.constraintlayout.core.widgets.f.R2(i11, eVar4, interfaceC0040b, new b.a(), b.a.f3424k);
                }
                if (eVar4.j0() != androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT || zA3) {
                    if (!eVar4.F0() && dVar9 == eVar4.U) {
                        eVar4.o1(dVar9.g() + iF3);
                        k(i11, eVar4, interfaceC0040b);
                    }
                }
            }
        }
        eVar.O0();
    }
}
