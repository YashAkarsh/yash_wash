package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
public class l extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int[] f3479k = new int[2];

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3480a;

        static {
            int[] iArr = new int[p.b.values().length];
            f3480a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3480a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3480a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(androidx.constraintlayout.core.widgets.e eVar) {
        super(eVar);
        this.f3518h.f3453e = f.a.LEFT;
        this.f3519i.f3453e = f.a.RIGHT;
        this.f3516f = 0;
    }

    private void u(int[] iArr, int i7, int i8, int i9, int i10, float f8, int i11) {
        int i12 = i8 - i7;
        int i13 = i10 - i9;
        if (i11 != -1) {
            if (i11 == 0) {
                iArr[0] = (int) ((i13 * f8) + 0.5f);
                iArr[1] = i13;
                return;
            } else {
                if (i11 != 1) {
                    return;
                }
                iArr[0] = i12;
                iArr[1] = (int) ((i12 * f8) + 0.5f);
                return;
            }
        }
        int i14 = (int) ((i13 * f8) + 0.5f);
        int i15 = (int) ((i12 / f8) + 0.5f);
        if (i14 <= i12) {
            iArr[0] = i14;
            iArr[1] = i13;
        } else if (i15 <= i13) {
            iArr[0] = i12;
            iArr[1] = i15;
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02de  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ed  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.p, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        int iG;
        int i7;
        int iG2;
        float f8;
        float fA;
        float fA2;
        int i8;
        int i9 = a.f3480a[this.f3520j.ordinal()];
        if (i9 == 1) {
            s(dVar);
        } else if (i9 == 2) {
            r(dVar);
        } else if (i9 == 3) {
            androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
            q(dVar, eVar.Q, eVar.S, 0);
            return;
        }
        if (!this.f3515e.f3458j && this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
            androidx.constraintlayout.core.widgets.e eVar2 = this.f3512b;
            int i10 = eVar2.f3644w;
            if (i10 == 2) {
                androidx.constraintlayout.core.widgets.e eVarU = eVar2.U();
                if (eVarU != null) {
                    g gVar = eVarU.f3608e.f3515e;
                    if (gVar.f3458j) {
                        this.f3515e.e((int) ((gVar.f3455g * this.f3512b.B) + 0.5f));
                    }
                }
            } else if (i10 == 3) {
                int i11 = eVar2.f3646x;
                if (i11 == 0 || i11 == 3) {
                    n nVar = eVar2.f3610f;
                    f fVar = nVar.f3518h;
                    f fVar2 = nVar.f3519i;
                    boolean z7 = eVar2.Q.f3558f != null;
                    boolean z8 = eVar2.R.f3558f != null;
                    boolean z9 = eVar2.S.f3558f != null;
                    boolean z10 = eVar2.T.f3558f != null;
                    int iB = eVar2.B();
                    if (z7 && z8 && z9 && z10) {
                        float fA3 = this.f3512b.A();
                        if (fVar.f3458j && fVar2.f3458j) {
                            f fVar3 = this.f3518h;
                            if (fVar3.f3451c && this.f3519i.f3451c) {
                                u(f3479k, fVar3.f3460l.get(0).f3455g + this.f3518h.f3454f, this.f3519i.f3460l.get(0).f3455g - this.f3519i.f3454f, fVar.f3455g + fVar.f3454f, fVar2.f3455g - fVar2.f3454f, fA3, iB);
                                this.f3515e.e(f3479k[0]);
                                this.f3512b.f3610f.f3515e.e(f3479k[1]);
                                return;
                            }
                            return;
                        }
                        f fVar4 = this.f3518h;
                        if (fVar4.f3458j) {
                            f fVar5 = this.f3519i;
                            if (fVar5.f3458j) {
                                if (!fVar.f3451c || !fVar2.f3451c) {
                                    return;
                                }
                                u(f3479k, fVar4.f3455g + fVar4.f3454f, fVar5.f3455g - fVar5.f3454f, fVar.f3460l.get(0).f3455g + fVar.f3454f, fVar2.f3460l.get(0).f3455g - fVar2.f3454f, fA3, iB);
                                this.f3515e.e(f3479k[0]);
                                this.f3512b.f3610f.f3515e.e(f3479k[1]);
                            }
                        }
                        f fVar6 = this.f3518h;
                        if (!fVar6.f3451c || !this.f3519i.f3451c || !fVar.f3451c || !fVar2.f3451c) {
                            return;
                        }
                        u(f3479k, fVar6.f3460l.get(0).f3455g + this.f3518h.f3454f, this.f3519i.f3460l.get(0).f3455g - this.f3519i.f3454f, fVar.f3460l.get(0).f3455g + fVar.f3454f, fVar2.f3460l.get(0).f3455g - fVar2.f3454f, fA3, iB);
                        this.f3515e.e(f3479k[0]);
                        this.f3512b.f3610f.f3515e.e(f3479k[1]);
                    } else if (z7 && z9) {
                        if (!this.f3518h.f3451c || !this.f3519i.f3451c) {
                            return;
                        }
                        float fA4 = this.f3512b.A();
                        int i12 = this.f3518h.f3460l.get(0).f3455g + this.f3518h.f3454f;
                        int i13 = this.f3519i.f3460l.get(0).f3455g - this.f3519i.f3454f;
                        if (iB == -1 || iB == 0) {
                            int iG3 = g(i13 - i12, 0);
                            int i14 = (int) ((iG3 * fA4) + 0.5f);
                            int iG4 = g(i14, 1);
                            if (i14 != iG4) {
                                iG3 = (int) ((iG4 / fA4) + 0.5f);
                            }
                            this.f3515e.e(iG3);
                            this.f3512b.f3610f.f3515e.e(iG4);
                        } else if (iB == 1) {
                            int iG5 = g(i13 - i12, 0);
                            int i15 = (int) ((iG5 / fA4) + 0.5f);
                            int iG6 = g(i15, 1);
                            if (i15 != iG6) {
                                iG5 = (int) ((iG6 * fA4) + 0.5f);
                            }
                            this.f3515e.e(iG5);
                            this.f3512b.f3610f.f3515e.e(iG6);
                        }
                    } else if (z8 && z10) {
                        if (!fVar.f3451c || !fVar2.f3451c) {
                            return;
                        }
                        float fA5 = this.f3512b.A();
                        int i16 = fVar.f3460l.get(0).f3455g + fVar.f3454f;
                        int i17 = fVar2.f3460l.get(0).f3455g - fVar2.f3454f;
                        if (iB == -1) {
                            iG = g(i17 - i16, 1);
                            i7 = (int) ((iG / fA5) + 0.5f);
                            iG2 = g(i7, 0);
                            if (i7 != iG2) {
                                iG = (int) ((iG2 * fA5) + 0.5f);
                            }
                            this.f3515e.e(iG2);
                            this.f3512b.f3610f.f3515e.e(iG);
                        } else if (iB == 0) {
                            int iG7 = g(i17 - i16, 1);
                            int i18 = (int) ((iG7 * fA5) + 0.5f);
                            int iG8 = g(i18, 0);
                            if (i18 != iG8) {
                                iG7 = (int) ((iG8 / fA5) + 0.5f);
                            }
                            this.f3515e.e(iG8);
                            this.f3512b.f3610f.f3515e.e(iG7);
                        } else if (iB == 1) {
                            iG = g(i17 - i16, 1);
                            i7 = (int) ((iG / fA5) + 0.5f);
                            iG2 = g(i7, 0);
                            if (i7 != iG2) {
                                iG = (int) ((iG2 * fA5) + 0.5f);
                            }
                            this.f3515e.e(iG2);
                            this.f3512b.f3610f.f3515e.e(iG);
                        }
                    }
                } else {
                    int iB2 = eVar2.B();
                    if (iB2 != -1) {
                        if (iB2 == 0) {
                            androidx.constraintlayout.core.widgets.e eVar3 = this.f3512b;
                            fA2 = eVar3.f3610f.f3515e.f3455g / eVar3.A();
                            i8 = (int) (fA2 + 0.5f);
                        } else if (iB2 != 1) {
                            i8 = 0;
                        } else {
                            androidx.constraintlayout.core.widgets.e eVar4 = this.f3512b;
                            f8 = eVar4.f3610f.f3515e.f3455g;
                            fA = eVar4.A();
                        }
                        this.f3515e.e(i8);
                    } else {
                        androidx.constraintlayout.core.widgets.e eVar5 = this.f3512b;
                        f8 = eVar5.f3610f.f3515e.f3455g;
                        fA = eVar5.A();
                    }
                    fA2 = f8 * fA;
                    i8 = (int) (fA2 + 0.5f);
                    this.f3515e.e(i8);
                }
            }
        }
        f fVar7 = this.f3518h;
        if (fVar7.f3451c) {
            f fVar8 = this.f3519i;
            if (fVar8.f3451c) {
                if (fVar7.f3458j && fVar8.f3458j && this.f3515e.f3458j) {
                    return;
                }
                if (!this.f3515e.f3458j && this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                    androidx.constraintlayout.core.widgets.e eVar6 = this.f3512b;
                    if (eVar6.f3644w == 0 && !eVar6.B0()) {
                        f fVar9 = this.f3518h.f3460l.get(0);
                        f fVar10 = this.f3519i.f3460l.get(0);
                        int i19 = fVar9.f3455g;
                        f fVar11 = this.f3518h;
                        int i20 = i19 + fVar11.f3454f;
                        int i21 = fVar10.f3455g + this.f3519i.f3454f;
                        fVar11.e(i20);
                        this.f3519i.e(i21);
                        this.f3515e.e(i21 - i20);
                        return;
                    }
                }
                if (!this.f3515e.f3458j && this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && this.f3511a == 1 && this.f3518h.f3460l.size() > 0 && this.f3519i.f3460l.size() > 0) {
                    int iMin = Math.min((this.f3519i.f3460l.get(0).f3455g + this.f3519i.f3454f) - (this.f3518h.f3460l.get(0).f3455g + this.f3518h.f3454f), this.f3515e.f3470m);
                    androidx.constraintlayout.core.widgets.e eVar7 = this.f3512b;
                    int i22 = eVar7.A;
                    int iMax = Math.max(eVar7.f3650z, iMin);
                    if (i22 > 0) {
                        iMax = Math.min(i22, iMax);
                    }
                    this.f3515e.e(iMax);
                }
                if (this.f3515e.f3458j) {
                    f fVar12 = this.f3518h.f3460l.get(0);
                    f fVar13 = this.f3519i.f3460l.get(0);
                    int i23 = fVar12.f3455g + this.f3518h.f3454f;
                    int i24 = fVar13.f3455g + this.f3519i.f3454f;
                    float fE = this.f3512b.E();
                    if (fVar12 == fVar13) {
                        i23 = fVar12.f3455g;
                        i24 = fVar13.f3455g;
                        fE = 0.5f;
                    }
                    this.f3518h.e((int) (i23 + 0.5f + (((i24 - i23) - this.f3515e.f3455g) * fE)));
                    this.f3519i.e(this.f3518h.f3455g + this.f3515e.f3455g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void d() {
        androidx.constraintlayout.core.widgets.e eVarU;
        androidx.constraintlayout.core.widgets.e eVarU2;
        androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
        if (eVar.f3600a) {
            this.f3515e.e(eVar.m0());
        }
        if (this.f3515e.f3458j) {
            androidx.constraintlayout.core.widgets.e.b bVar = this.f3514d;
            androidx.constraintlayout.core.widgets.e.b bVar2 = androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT;
            if (bVar == bVar2 && (eVarU = this.f3512b.U()) != null && (eVarU.H() == androidx.constraintlayout.core.widgets.e.b.FIXED || eVarU.H() == bVar2)) {
                b(this.f3518h, eVarU.f3608e.f3518h, this.f3512b.Q.g());
                b(this.f3519i, eVarU.f3608e.f3519i, -this.f3512b.S.g());
                return;
            }
        } else {
            androidx.constraintlayout.core.widgets.e.b bVarH = this.f3512b.H();
            this.f3514d = bVarH;
            if (bVarH != androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT;
                if (bVarH == bVar3 && (eVarU2 = this.f3512b.U()) != null && (eVarU2.H() == androidx.constraintlayout.core.widgets.e.b.FIXED || eVarU2.H() == bVar3)) {
                    int iM0 = (eVarU2.m0() - this.f3512b.Q.g()) - this.f3512b.S.g();
                    b(this.f3518h, eVarU2.f3608e.f3518h, this.f3512b.Q.g());
                    b(this.f3519i, eVarU2.f3608e.f3519i, -this.f3512b.S.g());
                    this.f3515e.e(iM0);
                    return;
                }
                if (this.f3514d == androidx.constraintlayout.core.widgets.e.b.FIXED) {
                    this.f3515e.e(this.f3512b.m0());
                }
            }
        }
        g gVar = this.f3515e;
        if (gVar.f3458j) {
            androidx.constraintlayout.core.widgets.e eVar2 = this.f3512b;
            if (eVar2.f3600a) {
                androidx.constraintlayout.core.widgets.d[] dVarArr = eVar2.Y;
                androidx.constraintlayout.core.widgets.d dVar = dVarArr[0];
                androidx.constraintlayout.core.widgets.d dVar2 = dVar.f3558f;
                if (dVar2 != null && dVarArr[1].f3558f != null) {
                    if (eVar2.B0()) {
                        this.f3518h.f3454f = this.f3512b.Y[0].g();
                        this.f3519i.f3454f = -this.f3512b.Y[1].g();
                        return;
                    }
                    f fVarH = h(this.f3512b.Y[0]);
                    if (fVarH != null) {
                        b(this.f3518h, fVarH, this.f3512b.Y[0].g());
                    }
                    f fVarH2 = h(this.f3512b.Y[1]);
                    if (fVarH2 != null) {
                        b(this.f3519i, fVarH2, -this.f3512b.Y[1].g());
                    }
                    this.f3518h.f3450b = true;
                    this.f3519i.f3450b = true;
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f3518h, fVarH3, this.f3512b.Y[0].g());
                        b(this.f3519i, this.f3518h, this.f3515e.f3455g);
                        return;
                    }
                    return;
                }
                androidx.constraintlayout.core.widgets.d dVar3 = dVarArr[1];
                if (dVar3.f3558f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f3519i, fVarH4, -this.f3512b.Y[1].g());
                        b(this.f3518h, this.f3519i, -this.f3515e.f3455g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof androidx.constraintlayout.core.widgets.i) || eVar2.U() == null || this.f3512b.r(androidx.constraintlayout.core.widgets.d.b.CENTER).f3558f != null) {
                    return;
                }
                b(this.f3518h, this.f3512b.U().f3608e.f3518h, this.f3512b.o0());
                b(this.f3519i, this.f3518h, this.f3515e.f3455g);
                return;
            }
        }
        if (this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
            androidx.constraintlayout.core.widgets.e eVar3 = this.f3512b;
            int i7 = eVar3.f3644w;
            if (i7 == 2) {
                androidx.constraintlayout.core.widgets.e eVarU3 = eVar3.U();
                if (eVarU3 != null) {
                    g gVar2 = eVarU3.f3610f.f3515e;
                    this.f3515e.f3460l.add(gVar2);
                    gVar2.f3459k.add(this.f3515e);
                    g gVar3 = this.f3515e;
                    gVar3.f3450b = true;
                    gVar3.f3459k.add(this.f3518h);
                    this.f3515e.f3459k.add(this.f3519i);
                }
            } else if (i7 == 3) {
                if (eVar3.f3646x == 3) {
                    this.f3518h.f3449a = this;
                    this.f3519i.f3449a = this;
                    n nVar = eVar3.f3610f;
                    nVar.f3518h.f3449a = this;
                    nVar.f3519i.f3449a = this;
                    gVar.f3449a = this;
                    if (eVar3.D0()) {
                        this.f3515e.f3460l.add(this.f3512b.f3610f.f3515e);
                        this.f3512b.f3610f.f3515e.f3459k.add(this.f3515e);
                        n nVar2 = this.f3512b.f3610f;
                        nVar2.f3515e.f3449a = this;
                        this.f3515e.f3460l.add(nVar2.f3518h);
                        this.f3515e.f3460l.add(this.f3512b.f3610f.f3519i);
                        this.f3512b.f3610f.f3518h.f3459k.add(this.f3515e);
                        this.f3512b.f3610f.f3519i.f3459k.add(this.f3515e);
                    } else if (this.f3512b.B0()) {
                        this.f3512b.f3610f.f3515e.f3460l.add(this.f3515e);
                        this.f3515e.f3459k.add(this.f3512b.f3610f.f3515e);
                    } else {
                        this.f3512b.f3610f.f3515e.f3460l.add(this.f3515e);
                    }
                } else {
                    g gVar4 = eVar3.f3610f.f3515e;
                    gVar.f3460l.add(gVar4);
                    gVar4.f3459k.add(this.f3515e);
                    this.f3512b.f3610f.f3518h.f3459k.add(this.f3515e);
                    this.f3512b.f3610f.f3519i.f3459k.add(this.f3515e);
                    g gVar5 = this.f3515e;
                    gVar5.f3450b = true;
                    gVar5.f3459k.add(this.f3518h);
                    this.f3515e.f3459k.add(this.f3519i);
                    this.f3518h.f3460l.add(this.f3515e);
                    this.f3519i.f3460l.add(this.f3515e);
                }
            }
        }
        androidx.constraintlayout.core.widgets.e eVar4 = this.f3512b;
        androidx.constraintlayout.core.widgets.d[] dVarArr2 = eVar4.Y;
        androidx.constraintlayout.core.widgets.d dVar4 = dVarArr2[0];
        androidx.constraintlayout.core.widgets.d dVar5 = dVar4.f3558f;
        if (dVar5 != null && dVarArr2[1].f3558f != null) {
            if (eVar4.B0()) {
                this.f3518h.f3454f = this.f3512b.Y[0].g();
                this.f3519i.f3454f = -this.f3512b.Y[1].g();
                return;
            }
            f fVarH5 = h(this.f3512b.Y[0]);
            f fVarH6 = h(this.f3512b.Y[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f3520j = p.b.CENTER;
            return;
        }
        if (dVar5 != null) {
            f fVarH7 = h(dVar4);
            if (fVarH7 != null) {
                b(this.f3518h, fVarH7, this.f3512b.Y[0].g());
                c(this.f3519i, this.f3518h, 1, this.f3515e);
                return;
            }
            return;
        }
        androidx.constraintlayout.core.widgets.d dVar6 = dVarArr2[1];
        if (dVar6.f3558f != null) {
            f fVarH8 = h(dVar6);
            if (fVarH8 != null) {
                b(this.f3519i, fVarH8, -this.f3512b.Y[1].g());
                c(this.f3518h, this.f3519i, -1, this.f3515e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof androidx.constraintlayout.core.widgets.i) || eVar4.U() == null) {
            return;
        }
        b(this.f3518h, this.f3512b.U().f3608e.f3518h, this.f3512b.o0());
        c(this.f3519i, this.f3518h, 1, this.f3515e);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    public void e() {
        f fVar = this.f3518h;
        if (fVar.f3458j) {
            this.f3512b.f2(fVar.f3455g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void f() {
        this.f3513c = null;
        this.f3518h.c();
        this.f3519i.c();
        this.f3515e.c();
        this.f3517g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void n() {
        this.f3517g = false;
        this.f3518h.c();
        this.f3518h.f3458j = false;
        this.f3519i.c();
        this.f3519i.f3458j = false;
        this.f3515e.f3458j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    boolean p() {
        return this.f3514d != androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT || this.f3512b.f3644w == 0;
    }

    public String toString() {
        return "HorizontalRun " + this.f3512b.y();
    }
}
