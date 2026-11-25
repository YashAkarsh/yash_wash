package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3527a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3528b = false;

    /* JADX WARN: Code duplicated, block: B:101:0x016e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0171  */
    /* JADX WARN: Code duplicated, block: B:105:0x0177  */
    /* JADX WARN: Code duplicated, block: B:107:0x0198  */
    /* JADX WARN: Code duplicated, block: B:202:0x034c  */
    /* JADX WARN: Code duplicated, block: B:222:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:25:0x0044 A[PHI: r8 r16
      0x0044: PHI (r8v3 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0044: PHI (r16v3 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0046 A[PHI: r8 r16
      0x0046: PHI (r8v43 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0046: PHI (r16v6 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:325:0x03a5 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.core.e] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.constraintlayout.core.i] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.core.widgets.e] */
    static void a(f fVar, androidx.constraintlayout.core.e eVar, int i7, int i8, c cVar) {
        boolean z7;
        boolean z8;
        boolean z9;
        Object obj;
        int i9;
        int i10;
        d dVar;
        androidx.constraintlayout.core.i iVar;
        androidx.constraintlayout.core.i iVar2;
        d dVar2;
        androidx.constraintlayout.core.i iVar3;
        ?? r7;
        androidx.constraintlayout.core.i iVar4;
        int size;
        d dVar3;
        int i11;
        int i12 = i7;
        e eVar2 = cVar.f3529a;
        e eVar3 = cVar.f3531c;
        e eVar4 = cVar.f3530b;
        e eVar5 = cVar.f3532d;
        e eVar6 = cVar.f3533e;
        float f8 = cVar.f3539k;
        boolean z10 = fVar.f3603b0[i12] == e.b.WRAP_CONTENT;
        if (i12 == 0) {
            int i13 = eVar6.J0;
            z7 = i13 == 0;
            z8 = i13 == 1;
            if (i13 == 2) {
                z9 = true;
            } else {
                z9 = false;
            }
        } else {
            int i14 = eVar6.K0;
            z7 = i14 == 0;
            z8 = i14 == 1;
            if (i14 == 2) {
                z9 = true;
            } else {
                z9 = false;
            }
        }
        boolean z11 = z8;
        boolean z12 = false;
        boolean z13 = z7;
        ?? r8 = eVar2;
        while (true) {
            obj = null;
            if (z12) {
                break;
            }
            d dVar4 = r8.Y[i8];
            int i15 = z9 ? 1 : 4;
            int iG = dVar4.g();
            e.b bVar = r8.f3603b0[i12];
            float f9 = f8;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            boolean z14 = bVar == bVar2 && r8.f3648y[i12] == 0;
            d dVar5 = dVar4.f3558f;
            if (dVar5 != null && r8 != eVar2) {
                iG += dVar5.g();
            }
            int i16 = iG;
            if (z9 && r8 != eVar2 && r8 != eVar4) {
                i15 = 8;
            }
            d dVar6 = dVar4.f3558f;
            if (dVar6 != null) {
                if (r8 == eVar4) {
                    eVar.i(dVar4.f3561i, dVar6.f3561i, i16, 6);
                } else {
                    eVar.i(dVar4.f3561i, dVar6.f3561i, i16, 8);
                }
                if (z14 && !z9) {
                    i15 = 5;
                }
                eVar.e(dVar4.f3561i, dVar4.f3558f.f3561i, i16, (r8 == eVar4 && z9 && r8.A0(i12)) ? 5 : i15);
            } else {
                eVar2 = eVar2;
            }
            if (z10) {
                if (r8.l0() == 8 || r8.f3603b0[i12] != bVar2) {
                    i11 = 0;
                } else {
                    d[] dVarArr = r8.Y;
                    i11 = 0;
                    eVar.i(dVarArr[i8 + 1].f3561i, dVarArr[i8].f3561i, 0, 5);
                }
                eVar.i(r8.Y[i8].f3561i, fVar.Y[i8].f3561i, i11, 8);
            }
            d dVar7 = r8.Y[i8 + 1].f3558f;
            if (dVar7 != null) {
                e eVar7 = dVar7.f3556d;
                d dVar8 = eVar7.Y[i8].f3558f;
                if (dVar8 != null && dVar8.f3556d == r8) {
                    obj = eVar7;
                }
            }
            if (obj != null) {
                r8 = obj;
                z12 = z12;
            } else {
                z12 = true;
            }
            eVar6 = eVar6;
            f8 = f9;
            eVar2 = eVar2;
            r8 = r8;
        }
        e eVar8 = eVar6;
        float f10 = f8;
        e eVar9 = eVar2;
        if (eVar5 != null) {
            int i17 = i8 + 1;
            if (eVar3.Y[i17].f3558f != null) {
                d dVar9 = eVar5.Y[i17];
                if ((eVar5.f3603b0[i12] == e.b.MATCH_CONSTRAINT && eVar5.f3648y[i12] == 0) && !z9) {
                    d dVar10 = dVar9.f3558f;
                    if (dVar10.f3556d == fVar) {
                        eVar.e(dVar9.f3561i, dVar10.f3561i, -dVar9.g(), 5);
                    } else if (z9) {
                        dVar3 = dVar9.f3558f;
                        if (dVar3.f3556d == fVar) {
                            eVar.e(dVar9.f3561i, dVar3.f3561i, -dVar9.g(), 4);
                        }
                    }
                } else if (z9) {
                    dVar3 = dVar9.f3558f;
                    if (dVar3.f3556d == fVar) {
                        eVar.e(dVar9.f3561i, dVar3.f3561i, -dVar9.g(), 4);
                    }
                }
                eVar.k(dVar9.f3561i, eVar3.Y[i17].f3558f.f3561i, -dVar9.g(), 6);
            }
        }
        if (z10) {
            int i18 = i8 + 1;
            androidx.constraintlayout.core.i iVar5 = fVar.Y[i18].f3561i;
            d dVar11 = eVar3.Y[i18];
            eVar.i(iVar5, dVar11.f3561i, dVar11.g(), 8);
        }
        ArrayList<e> arrayList = cVar.f3536h;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f11 = (!cVar.f3546r || cVar.f3548t) ? f10 : cVar.f3538j;
            float f12 = 0.0f;
            float f13 = 0.0f;
            e eVar10 = null;
            int i19 = 0;
            while (i19 < size) {
                e eVar11 = arrayList.get(i19);
                float f14 = eVar11.N0[i12];
                if (f14 < f12) {
                    if (cVar.f3548t) {
                        d[] dVarArr2 = eVar11.Y;
                        eVar.e(dVarArr2[i8 + 1].f3561i, dVarArr2[i8].f3561i, 0, 4);
                    } else {
                        f14 = 1.0f;
                        f12 = 0.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i19++;
                    size = size;
                    arrayList = arrayList;
                    f12 = 0.0f;
                }
                if (f14 == f12) {
                    d[] dVarArr3 = eVar11.Y;
                    eVar.e(dVarArr3[i8 + 1].f3561i, dVarArr3[i8].f3561i, 0, 8);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (eVar10 != null) {
                        d[] dVarArr4 = eVar10.Y;
                        androidx.constraintlayout.core.i iVar6 = dVarArr4[i8].f3561i;
                        int i20 = i8 + 1;
                        androidx.constraintlayout.core.i iVar7 = dVarArr4[i20].f3561i;
                        d[] dVarArr5 = eVar11.Y;
                        androidx.constraintlayout.core.i iVar8 = dVarArr5[i8].f3561i;
                        androidx.constraintlayout.core.i iVar9 = dVarArr5[i20].f3561i;
                        androidx.constraintlayout.core.b bVarV = eVar.v();
                        bVarV.p(f13, f11, f14, iVar6, iVar7, iVar8, iVar9);
                        eVar.d(bVarV);
                    }
                    eVar10 = eVar11;
                    f13 = f14;
                }
                i19++;
                size = size;
                arrayList = arrayList;
                f12 = 0.0f;
            }
        }
        if (eVar4 != null && (eVar4 == eVar5 || z9)) {
            d dVar12 = eVar9.Y[i8];
            int i21 = i8 + 1;
            d dVar13 = eVar3.Y[i21];
            d dVar14 = dVar12.f3558f;
            androidx.constraintlayout.core.i iVar10 = dVar14 != null ? dVar14.f3561i : null;
            d dVar15 = dVar13.f3558f;
            androidx.constraintlayout.core.i iVar11 = dVar15 != null ? dVar15.f3561i : null;
            d dVar16 = eVar4.Y[i8];
            if (eVar5 != null) {
                dVar13 = eVar5.Y[i21];
            }
            if (iVar10 != null && iVar11 != null) {
                eVar.c(dVar16.f3561i, iVar10, dVar16.g(), i12 == 0 ? eVar8.f3633q0 : eVar8.f3635r0, iVar11, dVar13.f3561i, dVar13.g(), 7);
            }
        } else if (!z13 || eVar4 == null) {
            int i22 = 8;
            if (z11 && eVar4 != null) {
                int i23 = cVar.f3538j;
                boolean z15 = i23 > 0 && cVar.f3537i == i23;
                e eVar12 = eVar4;
                e eVar13 = eVar12;
                while (eVar13 != null) {
                    e eVar14 = eVar13.P0[i12];
                    while (eVar14 != null && eVar14.l0() == i22) {
                        eVar14 = eVar14.P0[i12];
                    }
                    if (eVar13 == eVar4 || eVar13 == eVar5 || eVar14 == null) {
                        eVar12 = eVar12;
                        i10 = i22;
                    } else {
                        e eVar15 = eVar14 == eVar5 ? null : eVar14;
                        d dVar17 = eVar13.Y[i8];
                        androidx.constraintlayout.core.i iVar12 = dVar17.f3561i;
                        d dVar18 = dVar17.f3558f;
                        if (dVar18 != null) {
                            androidx.constraintlayout.core.i iVar13 = dVar18.f3561i;
                        }
                        int i24 = i8 + 1;
                        androidx.constraintlayout.core.i iVar14 = eVar12.Y[i24].f3561i;
                        int iG2 = dVar17.g();
                        int iG3 = eVar13.Y[i24].g();
                        if (eVar15 != null) {
                            dVar = eVar15.Y[i8];
                            androidx.constraintlayout.core.i iVar15 = dVar.f3561i;
                            d dVar19 = dVar.f3558f;
                            iVar2 = dVar19 != null ? dVar19.f3561i : null;
                            iVar = iVar15;
                        } else {
                            dVar = eVar5.Y[i8];
                            iVar = dVar != null ? dVar.f3561i : null;
                            iVar2 = eVar13.Y[i24].f3561i;
                        }
                        if (dVar != null) {
                            iG3 += dVar.g();
                        }
                        int i25 = iG3;
                        int iG4 = eVar12.Y[i24].g() + iG2;
                        int i26 = z15 ? 8 : 4;
                        if (iVar12 == null || iVar14 == null || iVar == null || iVar2 == null) {
                            i10 = 8;
                        } else {
                            i10 = 8;
                            eVar.c(iVar12, iVar14, iG4, 0.5f, iVar, iVar2, i25, i26);
                        }
                        eVar14 = eVar15;
                    }
                    eVar12 = eVar13.l0() != i10 ? eVar13 : eVar12;
                    eVar13 = eVar14;
                    i22 = i10;
                    i12 = i7;
                }
                d dVar20 = eVar4.Y[i8];
                d dVar21 = eVar9.Y[i8].f3558f;
                int i27 = i8 + 1;
                d dVar22 = eVar5.Y[i27];
                d dVar23 = eVar3.Y[i27].f3558f;
                if (dVar21 == null) {
                    i9 = 5;
                } else if (eVar4 != eVar5) {
                    i9 = 5;
                    eVar.e(dVar20.f3561i, dVar21.f3561i, dVar20.g(), 5);
                } else {
                    i9 = 5;
                    if (dVar23 != null) {
                        eVar.c(dVar20.f3561i, dVar21.f3561i, dVar20.g(), 0.5f, dVar22.f3561i, dVar23.f3561i, dVar22.g(), 5);
                    }
                }
                if (dVar23 != null && eVar4 != eVar5) {
                    eVar.e(dVar22.f3561i, dVar23.f3561i, -dVar22.g(), i9);
                }
            }
        } else {
            int i28 = cVar.f3538j;
            boolean z16 = i28 > 0 && cVar.f3537i == i28;
            e eVar16 = eVar4;
            e eVar17 = eVar16;
            while (eVar17 != null) {
                e eVar18 = eVar17.P0[i12];
                while (eVar18 != null && eVar18.l0() == 8) {
                    eVar18 = eVar18.P0[i12];
                }
                if (eVar18 != null || eVar17 == eVar5) {
                    d dVar24 = eVar17.Y[i8];
                    androidx.constraintlayout.core.i iVar16 = dVar24.f3561i;
                    d dVar25 = dVar24.f3558f;
                    androidx.constraintlayout.core.i iVar17 = dVar25 != null ? dVar25.f3561i : null;
                    if (eVar16 != eVar17) {
                        iVar17 = eVar16.Y[i8 + 1].f3561i;
                    } else if (eVar17 == eVar4) {
                        d dVar26 = eVar9.Y[i8].f3558f;
                        iVar17 = dVar26 != null ? dVar26.f3561i : null;
                    }
                    int iG5 = dVar24.g();
                    int i29 = i8 + 1;
                    int iG6 = eVar17.Y[i29].g();
                    if (eVar18 != null) {
                        dVar2 = eVar18.Y[i8];
                        iVar3 = dVar2.f3561i;
                    } else {
                        dVar2 = eVar3.Y[i29].f3558f;
                        if (dVar2 != null) {
                            iVar3 = dVar2.f3561i;
                        } else {
                            iVar3 = null;
                        }
                        androidx.constraintlayout.core.i iVar18 = eVar17.Y[i29].f3561i;
                        if (dVar2 != null) {
                            iG6 += dVar2.g();
                        }
                        int iG7 = iG5 + eVar16.Y[i29].g();
                        if (iVar16 == null && iVar17 != null && iVar3 != null && iVar18 != null) {
                            if (eVar17 == eVar4) {
                                iG7 = eVar4.Y[i8].g();
                            }
                            eVar18 = eVar18;
                            eVar.c(iVar16, iVar17, iG7, 0.5f, iVar3, iVar18, eVar17 == eVar5 ? eVar5.Y[i29].g() : iG6, z16 ? 8 : 5);
                        }
                        if (eVar17.l0() != 8) {
                            eVar17 = eVar16;
                        }
                        eVar16 = eVar17;
                        eVar17 = eVar18;
                    }
                    androidx.constraintlayout.core.i iVar19 = eVar17.Y[i29].f3561i;
                    if (dVar2 != null) {
                        iG6 += dVar2.g();
                    }
                    int iG8 = iG5 + eVar16.Y[i29].g();
                    if (iVar16 == null) {
                    }
                }
                if (eVar17.l0() != 8) {
                    eVar17 = eVar16;
                }
                eVar16 = eVar17;
                eVar17 = eVar18;
            }
        }
        if ((!z13 && !z11) || eVar4 == null || eVar4 == eVar5) {
            return;
        }
        d[] dVarArr6 = eVar4.Y;
        d dVar27 = dVarArr6[i8];
        if (eVar5 == null) {
            eVar5 = eVar4;
        }
        int i30 = i8 + 1;
        d dVar28 = eVar5.Y[i30];
        d dVar29 = dVar27.f3558f;
        androidx.constraintlayout.core.i iVar20 = dVar29 != null ? dVar29.f3561i : null;
        d dVar30 = dVar28.f3558f;
        if (dVar30 != null) {
            iVar4 = dVar30.f3561i;
        } else {
            r7 = 0;
        }
        if (eVar3 != eVar5) {
            d dVar31 = eVar3.Y[i30].f3558f;
            if (dVar31 != null) {
                r7 = iVar4;
                obj = dVar31.f3561i;
            }
            r7 = iVar4;
            r7 = obj;
        }
        if (eVar4 == eVar5) {
            dVar28 = dVarArr6[i30];
        }
        if (iVar20 == null || r7 == 0) {
            return;
        }
        eVar.c(dVar27.f3561i, iVar20, dVar27.g(), 0.5f, r7, dVar28.f3561i, eVar5.Y[i30].g(), 5);
    }

    public static void b(f fVar, androidx.constraintlayout.core.e eVar, ArrayList<e> arrayList, int i7) {
        int i8;
        c[] cVarArr;
        int i9;
        if (i7 == 0) {
            i8 = fVar.M1;
            cVarArr = fVar.P1;
            i9 = 0;
        } else {
            i8 = fVar.N1;
            cVarArr = fVar.O1;
            i9 = 2;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            c cVar = cVarArr[i10];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.f3529a)) {
                a(fVar, eVar, i7, i9, cVar);
            }
        }
    }
}
