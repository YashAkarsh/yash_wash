package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ArrayList<p> f3437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f3438l;

    public c(androidx.constraintlayout.core.widgets.e eVar, int i7) {
        super(eVar);
        this.f3437k = new ArrayList<>();
        this.f3516f = i7;
        u();
    }

    private void u() {
        androidx.constraintlayout.core.widgets.e eVar;
        androidx.constraintlayout.core.widgets.e eVar2 = this.f3512b;
        androidx.constraintlayout.core.widgets.e eVarV = eVar2.V(this.f3516f);
        while (true) {
            androidx.constraintlayout.core.widgets.e eVar3 = eVarV;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                eVarV = eVar2.V(this.f3516f);
            }
        }
        this.f3512b = eVar;
        this.f3437k.add(eVar.a0(this.f3516f));
        androidx.constraintlayout.core.widgets.e eVarR = eVar.R(this.f3516f);
        while (eVarR != null) {
            this.f3437k.add(eVarR.a0(this.f3516f));
            eVarR = eVarR.R(this.f3516f);
        }
        for (p pVar : this.f3437k) {
            int i7 = this.f3516f;
            if (i7 == 0) {
                pVar.f3512b.f3604c = this;
            } else if (i7 == 1) {
                pVar.f3512b.f3606d = this;
            }
        }
        if ((this.f3516f == 0 && ((androidx.constraintlayout.core.widgets.f) this.f3512b.U()).O2()) && this.f3437k.size() > 1) {
            ArrayList<p> arrayList = this.f3437k;
            this.f3512b = arrayList.get(arrayList.size() - 1).f3512b;
        }
        this.f3438l = this.f3516f == 0 ? this.f3512b.G() : this.f3512b.i0();
    }

    private androidx.constraintlayout.core.widgets.e v() {
        for (int i7 = 0; i7 < this.f3437k.size(); i7++) {
            p pVar = this.f3437k.get(i7);
            if (pVar.f3512b.l0() != 8) {
                return pVar.f3512b;
            }
        }
        return null;
    }

    private androidx.constraintlayout.core.widgets.e w() {
        for (int size = this.f3437k.size() - 1; size >= 0; size--) {
            p pVar = this.f3437k.get(size);
            if (pVar.f3512b.l0() != 8) {
                return pVar.f3512b;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x01be  */
    /* JADX WARN: Code duplicated, block: B:294:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec A[ADDED_TO_REGION] */
    @Override // androidx.constraintlayout.core.widgets.analyzer.p, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f8;
        boolean z7;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        float f9;
        if (this.f3518h.f3458j && this.f3519i.f3458j) {
            androidx.constraintlayout.core.widgets.e eVarU = this.f3512b.U();
            boolean zO2 = eVarU instanceof androidx.constraintlayout.core.widgets.f ? ((androidx.constraintlayout.core.widgets.f) eVarU).O2() : false;
            int i20 = this.f3519i.f3455g - this.f3518h.f3455g;
            int size = this.f3437k.size();
            int i21 = 0;
            while (true) {
                i7 = -1;
                i8 = 8;
                if (i21 >= size) {
                    i21 = -1;
                    break;
                } else if (this.f3437k.get(i21).f3512b.l0() != 8) {
                    break;
                } else {
                    i21++;
                }
            }
            int i22 = size - 1;
            for (int i23 = i22; i23 >= 0; i23--) {
                if (this.f3437k.get(i23).f3512b.l0() != 8) {
                    i7 = i23;
                    break;
                }
            }
            int i24 = 0;
            while (true) {
                if (i24 >= 2) {
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    f8 = 0.0f;
                    break;
                }
                int i25 = 0;
                i10 = 0;
                i11 = 0;
                int i26 = 0;
                f8 = 0.0f;
                while (i25 < size) {
                    p pVar = this.f3437k.get(i25);
                    if (pVar.f3512b.l0() != i8) {
                        i26++;
                        if (i25 > 0 && i25 >= i21) {
                            i10 += pVar.f3518h.f3454f;
                        }
                        g gVar = pVar.f3515e;
                        int i27 = gVar.f3455g;
                        boolean z8 = pVar.f3514d != androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                        if (z8) {
                            int i28 = this.f3516f;
                            if (i28 == 0 && !pVar.f3512b.f3608e.f3515e.f3458j) {
                                return;
                            }
                            if (i28 == 1 && !pVar.f3512b.f3610f.f3515e.f3458j) {
                                return;
                            } else {
                                i18 = i27;
                            }
                        } else {
                            i18 = i27;
                            if (pVar.f3511a == 1 && i24 == 0) {
                                i19 = gVar.f3470m;
                                i11++;
                            } else {
                                if (gVar.f3458j) {
                                    i19 = i18;
                                }
                                if (z8) {
                                    i10 += i19;
                                } else {
                                    i11++;
                                    f9 = pVar.f3512b.N0[this.f3516f];
                                    if (f9 >= 0.0f) {
                                        f8 += f9;
                                    }
                                }
                                if (i25 >= i22 && i25 < i7) {
                                    i10 += -pVar.f3519i.f3454f;
                                }
                            }
                            z8 = true;
                            if (z8) {
                                i11++;
                                f9 = pVar.f3512b.N0[this.f3516f];
                                if (f9 >= 0.0f) {
                                    f8 += f9;
                                }
                            } else {
                                i10 += i19;
                            }
                            if (i25 >= i22) {
                            }
                        }
                        i19 = i18;
                        if (z8) {
                            i11++;
                            f9 = pVar.f3512b.N0[this.f3516f];
                            if (f9 >= 0.0f) {
                                f8 += f9;
                            }
                        } else {
                            i10 += i19;
                        }
                        if (i25 >= i22) {
                        }
                    }
                    i25++;
                    i8 = 8;
                }
                if (i10 < i20 || i11 == 0) {
                    i9 = i26;
                    break;
                } else {
                    i24++;
                    i8 = 8;
                }
            }
            int i29 = this.f3518h.f3455g;
            if (zO2) {
                i29 = this.f3519i.f3455g;
            }
            if (i10 > i20) {
                i29 = zO2 ? i29 + ((int) (((i10 - i20) / 2.0f) + 0.5f)) : i29 - ((int) (((i10 - i20) / 2.0f) + 0.5f));
            }
            if (i11 > 0) {
                float f10 = i20 - i10;
                int i30 = (int) ((f10 / i11) + 0.5f);
                int i31 = 0;
                int i32 = 0;
                while (i31 < size) {
                    p pVar2 = this.f3437k.get(i31);
                    int i33 = i30;
                    int i34 = i10;
                    if (pVar2.f3512b.l0() != 8 && pVar2.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                        g gVar2 = pVar2.f3515e;
                        if (gVar2.f3458j) {
                            zO2 = zO2;
                            i29 = i29;
                            f10 = f10;
                        } else {
                            int i35 = f8 > 0.0f ? (int) (((pVar2.f3512b.N0[this.f3516f] * f10) / f8) + 0.5f) : i33;
                            if (this.f3516f == 0) {
                                androidx.constraintlayout.core.widgets.e eVar = pVar2.f3512b;
                                i17 = eVar.A;
                                i16 = eVar.f3650z;
                            } else {
                                androidx.constraintlayout.core.widgets.e eVar2 = pVar2.f3512b;
                                int i36 = eVar2.D;
                                i16 = eVar2.C;
                                i17 = i36;
                            }
                            int iMax = Math.max(i16, pVar2.f3511a == 1 ? Math.min(i35, gVar2.f3470m) : i35);
                            if (i17 > 0) {
                                iMax = Math.min(i17, iMax);
                            }
                            if (iMax != i35) {
                                i32++;
                                i35 = iMax;
                            }
                            pVar2.f3515e.e(i35);
                        }
                    } else {
                        zO2 = zO2;
                        i29 = i29;
                        f10 = f10;
                    }
                    i31++;
                    i30 = i33;
                    i10 = i34;
                    i29 = i29;
                    f10 = f10;
                    zO2 = zO2;
                    i9 = i9;
                }
                z7 = zO2;
                i12 = i9;
                i13 = i29;
                int i37 = i10;
                if (i32 > 0) {
                    i11 -= i32;
                    int i38 = 0;
                    for (int i39 = 0; i39 < size; i39++) {
                        p pVar3 = this.f3437k.get(i39);
                        if (pVar3.f3512b.l0() != 8) {
                            if (i39 > 0 && i39 >= i21) {
                                i38 += pVar3.f3518h.f3454f;
                            }
                            i38 += pVar3.f3515e.f3455g;
                            if (i39 < i22 && i39 < i7) {
                                i38 += -pVar3.f3519i.f3454f;
                            }
                        }
                    }
                    i10 = i38;
                } else {
                    i10 = i37;
                }
                i15 = 2;
                if (this.f3438l == 2 && i32 == 0) {
                    i14 = 0;
                    this.f3438l = 0;
                } else {
                    i14 = 0;
                }
            } else {
                z7 = zO2;
                i12 = i9;
                i13 = i29;
                i14 = 0;
                i15 = 2;
            }
            if (i10 > i20) {
                this.f3438l = i15;
            }
            if (i12 > 0 && i11 == 0 && i21 == i7) {
                this.f3438l = i15;
            }
            int i40 = this.f3438l;
            if (i40 == 1) {
                int i41 = i12;
                int i42 = i41 > 1 ? (i20 - i10) / (i41 - 1) : i41 == 1 ? (i20 - i10) / 2 : i14;
                if (i11 > 0) {
                    i42 = i14;
                }
                int i43 = i13;
                for (int i44 = i14; i44 < size; i44++) {
                    p pVar4 = this.f3437k.get(z7 ? size - (i44 + 1) : i44);
                    if (pVar4.f3512b.l0() == 8) {
                        pVar4.f3518h.e(i43);
                        pVar4.f3519i.e(i43);
                    } else {
                        if (i44 > 0) {
                            i43 = z7 ? i43 - i42 : i43 + i42;
                        }
                        if (i44 > 0 && i44 >= i21) {
                            i43 = z7 ? i43 - pVar4.f3518h.f3454f : i43 + pVar4.f3518h.f3454f;
                        }
                        if (z7) {
                            pVar4.f3519i.e(i43);
                        } else {
                            pVar4.f3518h.e(i43);
                        }
                        g gVar3 = pVar4.f3515e;
                        int i45 = gVar3.f3455g;
                        if (pVar4.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && pVar4.f3511a == 1) {
                            i45 = gVar3.f3470m;
                        }
                        i43 = z7 ? i43 - i45 : i43 + i45;
                        if (z7) {
                            pVar4.f3518h.e(i43);
                        } else {
                            pVar4.f3519i.e(i43);
                        }
                        pVar4.f3517g = true;
                        if (i44 < i22 && i44 < i7) {
                            i43 = z7 ? i43 - (-pVar4.f3519i.f3454f) : i43 + (-pVar4.f3519i.f3454f);
                        }
                    }
                }
                return;
            }
            int i46 = i12;
            if (i40 == 0) {
                int i47 = (i20 - i10) / (i46 + 1);
                if (i11 > 0) {
                    i47 = i14;
                }
                int i48 = i13;
                for (int i49 = i14; i49 < size; i49++) {
                    p pVar5 = this.f3437k.get(z7 ? size - (i49 + 1) : i49);
                    if (pVar5.f3512b.l0() == 8) {
                        pVar5.f3518h.e(i48);
                        pVar5.f3519i.e(i48);
                    } else {
                        int i50 = z7 ? i48 - i47 : i48 + i47;
                        if (i49 > 0 && i49 >= i21) {
                            i50 = z7 ? i50 - pVar5.f3518h.f3454f : i50 + pVar5.f3518h.f3454f;
                        }
                        if (z7) {
                            pVar5.f3519i.e(i50);
                        } else {
                            pVar5.f3518h.e(i50);
                        }
                        g gVar4 = pVar5.f3515e;
                        int iMin = gVar4.f3455g;
                        if (pVar5.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && pVar5.f3511a == 1) {
                            iMin = Math.min(iMin, gVar4.f3470m);
                        }
                        i48 = z7 ? i50 - iMin : i50 + iMin;
                        if (z7) {
                            pVar5.f3518h.e(i48);
                        } else {
                            pVar5.f3519i.e(i48);
                        }
                        if (i49 < i22 && i49 < i7) {
                            i48 = z7 ? i48 - (-pVar5.f3519i.f3454f) : i48 + (-pVar5.f3519i.f3454f);
                        }
                    }
                }
                return;
            }
            if (i40 == 2) {
                float fE = this.f3516f == 0 ? this.f3512b.E() : this.f3512b.g0();
                if (z7) {
                    fE = 1.0f - fE;
                }
                int i51 = (int) (((i20 - i10) * fE) + 0.5f);
                if (i51 < 0 || i11 > 0) {
                    i51 = i14;
                }
                int i52 = z7 ? i13 - i51 : i13 + i51;
                for (int i53 = i14; i53 < size; i53++) {
                    p pVar6 = this.f3437k.get(z7 ? size - (i53 + 1) : i53);
                    if (pVar6.f3512b.l0() == 8) {
                        pVar6.f3518h.e(i52);
                        pVar6.f3519i.e(i52);
                    } else {
                        if (i53 > 0 && i53 >= i21) {
                            i52 = z7 ? i52 - pVar6.f3518h.f3454f : i52 + pVar6.f3518h.f3454f;
                        }
                        if (z7) {
                            pVar6.f3519i.e(i52);
                        } else {
                            pVar6.f3518h.e(i52);
                        }
                        g gVar5 = pVar6.f3515e;
                        int i54 = gVar5.f3455g;
                        if (pVar6.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && pVar6.f3511a == 1) {
                            i54 = gVar5.f3470m;
                        }
                        i52 = z7 ? i52 - i54 : i52 + i54;
                        if (z7) {
                            pVar6.f3518h.e(i52);
                        } else {
                            pVar6.f3519i.e(i52);
                        }
                        if (i53 < i22 && i53 < i7) {
                            i52 = z7 ? i52 - (-pVar6.f3519i.f3454f) : i52 + (-pVar6.f3519i.f3454f);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void d() {
        Iterator<p> it = this.f3437k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f3437k.size();
        if (size < 1) {
            return;
        }
        androidx.constraintlayout.core.widgets.e eVar = this.f3437k.get(0).f3512b;
        androidx.constraintlayout.core.widgets.e eVar2 = this.f3437k.get(size - 1).f3512b;
        if (this.f3516f == 0) {
            androidx.constraintlayout.core.widgets.d dVar = eVar.Q;
            androidx.constraintlayout.core.widgets.d dVar2 = eVar2.S;
            f fVarI = i(dVar, 0);
            int iG = dVar.g();
            androidx.constraintlayout.core.widgets.e eVarV = v();
            if (eVarV != null) {
                iG = eVarV.Q.g();
            }
            if (fVarI != null) {
                b(this.f3518h, fVarI, iG);
            }
            f fVarI2 = i(dVar2, 0);
            int iG2 = dVar2.g();
            androidx.constraintlayout.core.widgets.e eVarW = w();
            if (eVarW != null) {
                iG2 = eVarW.S.g();
            }
            if (fVarI2 != null) {
                b(this.f3519i, fVarI2, -iG2);
            }
        } else {
            androidx.constraintlayout.core.widgets.d dVar3 = eVar.R;
            androidx.constraintlayout.core.widgets.d dVar4 = eVar2.T;
            f fVarI3 = i(dVar3, 1);
            int iG3 = dVar3.g();
            androidx.constraintlayout.core.widgets.e eVarV2 = v();
            if (eVarV2 != null) {
                iG3 = eVarV2.R.g();
            }
            if (fVarI3 != null) {
                b(this.f3518h, fVarI3, iG3);
            }
            f fVarI4 = i(dVar4, 1);
            int iG4 = dVar4.g();
            androidx.constraintlayout.core.widgets.e eVarW2 = w();
            if (eVarW2 != null) {
                iG4 = eVarW2.T.g();
            }
            if (fVarI4 != null) {
                b(this.f3519i, fVarI4, -iG4);
            }
        }
        this.f3518h.f3449a = this;
        this.f3519i.f3449a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    public void e() {
        for (int i7 = 0; i7 < this.f3437k.size(); i7++) {
            this.f3437k.get(i7).e();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void f() {
        this.f3513c = null;
        Iterator<p> it = this.f3437k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    public long j() {
        int size = this.f3437k.size();
        long j7 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            p pVar = this.f3437k.get(i7);
            j7 = j7 + ((long) pVar.f3518h.f3454f) + pVar.j() + ((long) pVar.f3519i.f3454f);
        }
        return j7;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void n() {
        this.f3518h.f3458j = false;
        this.f3519i.f3458j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    boolean p() {
        int size = this.f3437k.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!this.f3437k.get(i7).p()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f3516f == 0 ? "horizontal : " : "vertical : ");
        for (p pVar : this.f3437k) {
            sb.append("<");
            sb.append(pVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
