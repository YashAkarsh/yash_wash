package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f3492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f3493l;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3494a;

        static {
            int[] iArr = new int[p.b.values().length];
            f3494a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3494a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3494a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(androidx.constraintlayout.core.widgets.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f3492k = fVar;
        this.f3493l = null;
        this.f3518h.f3453e = f.a.TOP;
        this.f3519i.f3453e = f.a.BOTTOM;
        fVar.f3453e = f.a.BASELINE;
        this.f3516f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p, androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
        float f8;
        float fA;
        float fA2;
        int i7;
        int i8 = a.f3494a[this.f3520j.ordinal()];
        if (i8 == 1) {
            s(dVar);
        } else if (i8 == 2) {
            r(dVar);
        } else if (i8 == 3) {
            androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
            q(dVar, eVar.R, eVar.T, 1);
            return;
        }
        g gVar = this.f3515e;
        if (gVar.f3451c && !gVar.f3458j && this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
            androidx.constraintlayout.core.widgets.e eVar2 = this.f3512b;
            int i9 = eVar2.f3646x;
            if (i9 == 2) {
                androidx.constraintlayout.core.widgets.e eVarU = eVar2.U();
                if (eVarU != null) {
                    g gVar2 = eVarU.f3610f.f3515e;
                    if (gVar2.f3458j) {
                        this.f3515e.e((int) ((gVar2.f3455g * this.f3512b.E) + 0.5f));
                    }
                }
            } else if (i9 == 3 && eVar2.f3608e.f3515e.f3458j) {
                int iB = eVar2.B();
                if (iB != -1) {
                    if (iB == 0) {
                        androidx.constraintlayout.core.widgets.e eVar3 = this.f3512b;
                        fA2 = eVar3.f3608e.f3515e.f3455g * eVar3.A();
                        i7 = (int) (fA2 + 0.5f);
                    } else if (iB != 1) {
                        i7 = 0;
                    } else {
                        androidx.constraintlayout.core.widgets.e eVar4 = this.f3512b;
                        f8 = eVar4.f3608e.f3515e.f3455g;
                        fA = eVar4.A();
                    }
                    this.f3515e.e(i7);
                } else {
                    androidx.constraintlayout.core.widgets.e eVar5 = this.f3512b;
                    f8 = eVar5.f3608e.f3515e.f3455g;
                    fA = eVar5.A();
                }
                fA2 = f8 / fA;
                i7 = (int) (fA2 + 0.5f);
                this.f3515e.e(i7);
            }
        }
        f fVar = this.f3518h;
        if (fVar.f3451c) {
            f fVar2 = this.f3519i;
            if (fVar2.f3451c) {
                if (fVar.f3458j && fVar2.f3458j && this.f3515e.f3458j) {
                    return;
                }
                if (!this.f3515e.f3458j && this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                    androidx.constraintlayout.core.widgets.e eVar6 = this.f3512b;
                    if (eVar6.f3644w == 0 && !eVar6.D0()) {
                        f fVar3 = this.f3518h.f3460l.get(0);
                        f fVar4 = this.f3519i.f3460l.get(0);
                        int i10 = fVar3.f3455g;
                        f fVar5 = this.f3518h;
                        int i11 = i10 + fVar5.f3454f;
                        int i12 = fVar4.f3455g + this.f3519i.f3454f;
                        fVar5.e(i11);
                        this.f3519i.e(i12);
                        this.f3515e.e(i12 - i11);
                        return;
                    }
                }
                if (!this.f3515e.f3458j && this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT && this.f3511a == 1 && this.f3518h.f3460l.size() > 0 && this.f3519i.f3460l.size() > 0) {
                    f fVar6 = this.f3518h.f3460l.get(0);
                    int i13 = (this.f3519i.f3460l.get(0).f3455g + this.f3519i.f3454f) - (fVar6.f3455g + this.f3518h.f3454f);
                    g gVar3 = this.f3515e;
                    int i14 = gVar3.f3470m;
                    if (i13 < i14) {
                        gVar3.e(i13);
                    } else {
                        gVar3.e(i14);
                    }
                }
                if (this.f3515e.f3458j && this.f3518h.f3460l.size() > 0 && this.f3519i.f3460l.size() > 0) {
                    f fVar7 = this.f3518h.f3460l.get(0);
                    f fVar8 = this.f3519i.f3460l.get(0);
                    int i15 = fVar7.f3455g + this.f3518h.f3454f;
                    int i16 = fVar8.f3455g + this.f3519i.f3454f;
                    float fG0 = this.f3512b.g0();
                    if (fVar7 == fVar8) {
                        i15 = fVar7.f3455g;
                        i16 = fVar8.f3455g;
                        fG0 = 0.5f;
                    }
                    this.f3518h.e((int) (i15 + 0.5f + (((i16 - i15) - this.f3515e.f3455g) * fG0)));
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
            this.f3515e.e(eVar.D());
        }
        if (!this.f3515e.f3458j) {
            this.f3514d = this.f3512b.j0();
            if (this.f3512b.q0()) {
                this.f3493l = new androidx.constraintlayout.core.widgets.analyzer.a(this);
            }
            androidx.constraintlayout.core.widgets.e.b bVar = this.f3514d;
            if (bVar != androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                if (bVar == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT && (eVarU2 = this.f3512b.U()) != null && eVarU2.j0() == androidx.constraintlayout.core.widgets.e.b.FIXED) {
                    int iD = (eVarU2.D() - this.f3512b.R.g()) - this.f3512b.T.g();
                    b(this.f3518h, eVarU2.f3610f.f3518h, this.f3512b.R.g());
                    b(this.f3519i, eVarU2.f3610f.f3519i, -this.f3512b.T.g());
                    this.f3515e.e(iD);
                    return;
                }
                if (this.f3514d == androidx.constraintlayout.core.widgets.e.b.FIXED) {
                    this.f3515e.e(this.f3512b.D());
                }
            }
        } else if (this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_PARENT && (eVarU = this.f3512b.U()) != null && eVarU.j0() == androidx.constraintlayout.core.widgets.e.b.FIXED) {
            b(this.f3518h, eVarU.f3610f.f3518h, this.f3512b.R.g());
            b(this.f3519i, eVarU.f3610f.f3519i, -this.f3512b.T.g());
            return;
        }
        g gVar = this.f3515e;
        boolean z7 = gVar.f3458j;
        if (z7) {
            androidx.constraintlayout.core.widgets.e eVar2 = this.f3512b;
            if (eVar2.f3600a) {
                androidx.constraintlayout.core.widgets.d[] dVarArr = eVar2.Y;
                androidx.constraintlayout.core.widgets.d dVar = dVarArr[2];
                androidx.constraintlayout.core.widgets.d dVar2 = dVar.f3558f;
                if (dVar2 != null && dVarArr[3].f3558f != null) {
                    if (eVar2.D0()) {
                        this.f3518h.f3454f = this.f3512b.Y[2].g();
                        this.f3519i.f3454f = -this.f3512b.Y[3].g();
                    } else {
                        f fVarH = h(this.f3512b.Y[2]);
                        if (fVarH != null) {
                            b(this.f3518h, fVarH, this.f3512b.Y[2].g());
                        }
                        f fVarH2 = h(this.f3512b.Y[3]);
                        if (fVarH2 != null) {
                            b(this.f3519i, fVarH2, -this.f3512b.Y[3].g());
                        }
                        this.f3518h.f3450b = true;
                        this.f3519i.f3450b = true;
                    }
                    if (this.f3512b.q0()) {
                        b(this.f3492k, this.f3518h, this.f3512b.t());
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f3518h, fVarH3, this.f3512b.Y[2].g());
                        b(this.f3519i, this.f3518h, this.f3515e.f3455g);
                        if (this.f3512b.q0()) {
                            b(this.f3492k, this.f3518h, this.f3512b.t());
                            return;
                        }
                        return;
                    }
                    return;
                }
                androidx.constraintlayout.core.widgets.d dVar3 = dVarArr[3];
                if (dVar3.f3558f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f3519i, fVarH4, -this.f3512b.Y[3].g());
                        b(this.f3518h, this.f3519i, -this.f3515e.f3455g);
                    }
                    if (this.f3512b.q0()) {
                        b(this.f3492k, this.f3518h, this.f3512b.t());
                        return;
                    }
                    return;
                }
                androidx.constraintlayout.core.widgets.d dVar4 = dVarArr[4];
                if (dVar4.f3558f != null) {
                    f fVarH5 = h(dVar4);
                    if (fVarH5 != null) {
                        b(this.f3492k, fVarH5, 0);
                        b(this.f3518h, this.f3492k, -this.f3512b.t());
                        b(this.f3519i, this.f3518h, this.f3515e.f3455g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof androidx.constraintlayout.core.widgets.i) || eVar2.U() == null || this.f3512b.r(androidx.constraintlayout.core.widgets.d.b.CENTER).f3558f != null) {
                    return;
                }
                b(this.f3518h, this.f3512b.U().f3610f.f3518h, this.f3512b.p0());
                b(this.f3519i, this.f3518h, this.f3515e.f3455g);
                if (this.f3512b.q0()) {
                    b(this.f3492k, this.f3518h, this.f3512b.t());
                    return;
                }
                return;
            }
        }
        if (z7 || this.f3514d != androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            androidx.constraintlayout.core.widgets.e eVar3 = this.f3512b;
            int i7 = eVar3.f3646x;
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
            } else if (i7 == 3 && !eVar3.D0()) {
                androidx.constraintlayout.core.widgets.e eVar4 = this.f3512b;
                if (eVar4.f3644w != 3) {
                    g gVar4 = eVar4.f3608e.f3515e;
                    this.f3515e.f3460l.add(gVar4);
                    gVar4.f3459k.add(this.f3515e);
                    g gVar5 = this.f3515e;
                    gVar5.f3450b = true;
                    gVar5.f3459k.add(this.f3518h);
                    this.f3515e.f3459k.add(this.f3519i);
                }
            }
        }
        androidx.constraintlayout.core.widgets.e eVar5 = this.f3512b;
        androidx.constraintlayout.core.widgets.d[] dVarArr2 = eVar5.Y;
        androidx.constraintlayout.core.widgets.d dVar5 = dVarArr2[2];
        androidx.constraintlayout.core.widgets.d dVar6 = dVar5.f3558f;
        if (dVar6 != null && dVarArr2[3].f3558f != null) {
            if (eVar5.D0()) {
                this.f3518h.f3454f = this.f3512b.Y[2].g();
                this.f3519i.f3454f = -this.f3512b.Y[3].g();
            } else {
                f fVarH6 = h(this.f3512b.Y[2]);
                f fVarH7 = h(this.f3512b.Y[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f3520j = p.b.CENTER;
            }
            if (this.f3512b.q0()) {
                c(this.f3492k, this.f3518h, 1, this.f3493l);
            }
        } else if (dVar6 != null) {
            f fVarH8 = h(dVar5);
            if (fVarH8 != null) {
                b(this.f3518h, fVarH8, this.f3512b.Y[2].g());
                c(this.f3519i, this.f3518h, 1, this.f3515e);
                if (this.f3512b.q0()) {
                    c(this.f3492k, this.f3518h, 1, this.f3493l);
                }
                androidx.constraintlayout.core.widgets.e.b bVar2 = this.f3514d;
                androidx.constraintlayout.core.widgets.e.b bVar3 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f3512b.A() > 0.0f) {
                    l lVar = this.f3512b.f3608e;
                    if (lVar.f3514d == bVar3) {
                        lVar.f3515e.f3459k.add(this.f3515e);
                        this.f3515e.f3460l.add(this.f3512b.f3608e.f3515e);
                        this.f3515e.f3449a = this;
                    }
                }
            }
        } else {
            androidx.constraintlayout.core.widgets.d dVar7 = dVarArr2[3];
            if (dVar7.f3558f != null) {
                f fVarH9 = h(dVar7);
                if (fVarH9 != null) {
                    b(this.f3519i, fVarH9, -this.f3512b.Y[3].g());
                    c(this.f3518h, this.f3519i, -1, this.f3515e);
                    if (this.f3512b.q0()) {
                        c(this.f3492k, this.f3518h, 1, this.f3493l);
                    }
                }
            } else {
                androidx.constraintlayout.core.widgets.d dVar8 = dVarArr2[4];
                if (dVar8.f3558f != null) {
                    f fVarH10 = h(dVar8);
                    if (fVarH10 != null) {
                        b(this.f3492k, fVarH10, 0);
                        c(this.f3518h, this.f3492k, -1, this.f3493l);
                        c(this.f3519i, this.f3518h, 1, this.f3515e);
                    }
                } else if (!(eVar5 instanceof androidx.constraintlayout.core.widgets.i) && eVar5.U() != null) {
                    b(this.f3518h, this.f3512b.U().f3610f.f3518h, this.f3512b.p0());
                    c(this.f3519i, this.f3518h, 1, this.f3515e);
                    if (this.f3512b.q0()) {
                        c(this.f3492k, this.f3518h, 1, this.f3493l);
                    }
                    androidx.constraintlayout.core.widgets.e.b bVar4 = this.f3514d;
                    androidx.constraintlayout.core.widgets.e.b bVar5 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f3512b.A() > 0.0f) {
                        l lVar2 = this.f3512b.f3608e;
                        if (lVar2.f3514d == bVar5) {
                            lVar2.f3515e.f3459k.add(this.f3515e);
                            this.f3515e.f3460l.add(this.f3512b.f3608e.f3515e);
                            this.f3515e.f3449a = this;
                        }
                    }
                }
            }
        }
        if (this.f3515e.f3460l.size() == 0) {
            this.f3515e.f3451c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    public void e() {
        f fVar = this.f3518h;
        if (fVar.f3458j) {
            this.f3512b.g2(fVar.f3455g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    void f() {
        this.f3513c = null;
        this.f3518h.c();
        this.f3519i.c();
        this.f3492k.c();
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
        this.f3492k.c();
        this.f3492k.f3458j = false;
        this.f3515e.f3458j = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.p
    boolean p() {
        return this.f3514d != androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT || this.f3512b.f3646x == 0;
    }

    public String toString() {
        return "VerticalRun " + this.f3512b.y();
    }
}
