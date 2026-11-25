package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    androidx.constraintlayout.core.widgets.e f3512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    m f3513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected androidx.constraintlayout.core.widgets.e.b f3514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    g f3515e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3516f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f3517g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f3518h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f3519i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected b f3520j = b.NONE;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3521a;

        static {
            int[] iArr = new int[androidx.constraintlayout.core.widgets.d.b.values().length];
            f3521a = iArr;
            try {
                iArr[androidx.constraintlayout.core.widgets.d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3521a[androidx.constraintlayout.core.widgets.d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3521a[androidx.constraintlayout.core.widgets.d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3521a[androidx.constraintlayout.core.widgets.d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3521a[androidx.constraintlayout.core.widgets.d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(androidx.constraintlayout.core.widgets.e eVar) {
        this.f3512b = eVar;
    }

    private void o(int i7, int i8) {
        int i9 = this.f3511a;
        if (i9 == 0) {
            this.f3515e.e(g(i8, i7));
            return;
        }
        if (i9 == 1) {
            this.f3515e.e(Math.min(g(this.f3515e.f3470m, i7), i8));
            return;
        }
        if (i9 == 2) {
            androidx.constraintlayout.core.widgets.e eVarU = this.f3512b.U();
            if (eVarU != null) {
                g gVar = (i7 == 0 ? eVarU.f3608e : eVarU.f3610f).f3515e;
                if (gVar.f3458j) {
                    androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
                    this.f3515e.e(g((int) ((gVar.f3455g * (i7 == 0 ? eVar.B : eVar.E)) + 0.5f), i7));
                    return;
                }
                return;
            }
            return;
        }
        if (i9 != 3) {
            return;
        }
        androidx.constraintlayout.core.widgets.e eVar2 = this.f3512b;
        p pVar = eVar2.f3608e;
        androidx.constraintlayout.core.widgets.e.b bVar = pVar.f3514d;
        androidx.constraintlayout.core.widgets.e.b bVar2 = androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && pVar.f3511a == 3) {
            n nVar = eVar2.f3610f;
            if (nVar.f3514d == bVar2 && nVar.f3511a == 3) {
                return;
            }
        }
        if (i7 == 0) {
            pVar = eVar2.f3610f;
        }
        if (pVar.f3515e.f3458j) {
            float fA = eVar2.A();
            this.f3515e.e(i7 == 1 ? (int) ((pVar.f3515e.f3455g / fA) + 0.5f) : (int) ((fA * pVar.f3515e.f3455g) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.d
    public void a(d dVar) {
    }

    protected final void b(f fVar, f fVar2, int i7) {
        fVar.f3460l.add(fVar2);
        fVar.f3454f = i7;
        fVar2.f3459k.add(fVar);
    }

    protected final void c(f fVar, f fVar2, int i7, g gVar) {
        fVar.f3460l.add(fVar2);
        fVar.f3460l.add(this.f3515e);
        fVar.f3456h = i7;
        fVar.f3457i = gVar;
        fVar2.f3459k.add(fVar);
        gVar.f3459k.add(fVar);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i7, int i8) {
        int iMax;
        if (i8 == 0) {
            androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
            int i9 = eVar.A;
            iMax = Math.max(eVar.f3650z, i7);
            if (i9 > 0) {
                iMax = Math.min(i9, i7);
            }
            if (iMax == i7) {
                return i7;
            }
        } else {
            androidx.constraintlayout.core.widgets.e eVar2 = this.f3512b;
            int i10 = eVar2.D;
            iMax = Math.max(eVar2.C, i7);
            if (i10 > 0) {
                iMax = Math.min(i10, i7);
            }
            if (iMax == i7) {
                return i7;
            }
        }
        return iMax;
    }

    protected final f h(androidx.constraintlayout.core.widgets.d dVar) {
        androidx.constraintlayout.core.widgets.d dVar2 = dVar.f3558f;
        if (dVar2 == null) {
            return null;
        }
        androidx.constraintlayout.core.widgets.e eVar = dVar2.f3556d;
        int i7 = a.f3521a[dVar2.f3557e.ordinal()];
        if (i7 == 1) {
            return eVar.f3608e.f3518h;
        }
        if (i7 == 2) {
            return eVar.f3608e.f3519i;
        }
        if (i7 == 3) {
            return eVar.f3610f.f3518h;
        }
        if (i7 == 4) {
            return eVar.f3610f.f3492k;
        }
        if (i7 != 5) {
            return null;
        }
        return eVar.f3610f.f3519i;
    }

    protected final f i(androidx.constraintlayout.core.widgets.d dVar, int i7) {
        androidx.constraintlayout.core.widgets.d dVar2 = dVar.f3558f;
        if (dVar2 == null) {
            return null;
        }
        androidx.constraintlayout.core.widgets.e eVar = dVar2.f3556d;
        p pVar = i7 == 0 ? eVar.f3608e : eVar.f3610f;
        int i8 = a.f3521a[dVar2.f3557e.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f3519i;
        }
        return pVar.f3518h;
    }

    public long j() {
        g gVar = this.f3515e;
        if (gVar.f3458j) {
            return gVar.f3455g;
        }
        return 0L;
    }

    public boolean k() {
        int size = this.f3518h.f3460l.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            if (this.f3518h.f3460l.get(i8).f3452d != this) {
                i7++;
            }
        }
        int size2 = this.f3519i.f3460l.size();
        for (int i9 = 0; i9 < size2; i9++) {
            if (this.f3519i.f3460l.get(i9).f3452d != this) {
                i7++;
            }
        }
        return i7 >= 2;
    }

    public boolean l() {
        return this.f3515e.f3458j;
    }

    public boolean m() {
        return this.f3517g;
    }

    abstract void n();

    abstract boolean p();

    protected void q(d dVar, androidx.constraintlayout.core.widgets.d dVar2, androidx.constraintlayout.core.widgets.d dVar3, int i7) {
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f3458j && fVarH2.f3458j) {
            int iG = fVarH.f3455g + dVar2.g();
            int iG2 = fVarH2.f3455g - dVar3.g();
            int i8 = iG2 - iG;
            if (!this.f3515e.f3458j && this.f3514d == androidx.constraintlayout.core.widgets.e.b.MATCH_CONSTRAINT) {
                o(i7, i8);
            }
            g gVar = this.f3515e;
            if (gVar.f3458j) {
                if (gVar.f3455g == i8) {
                    this.f3518h.e(iG);
                    this.f3519i.e(iG2);
                    return;
                }
                androidx.constraintlayout.core.widgets.e eVar = this.f3512b;
                float fE = i7 == 0 ? eVar.E() : eVar.g0();
                if (fVarH == fVarH2) {
                    iG = fVarH.f3455g;
                    iG2 = fVarH2.f3455g;
                    fE = 0.5f;
                }
                this.f3518h.e((int) (iG + 0.5f + (((iG2 - iG) - this.f3515e.f3455g) * fE)));
                this.f3519i.e(this.f3518h.f3455g + this.f3515e.f3455g);
            }
        }
    }

    protected void r(d dVar) {
    }

    protected void s(d dVar) {
    }

    public long t(int i7) {
        int i8;
        g gVar = this.f3515e;
        if (!gVar.f3458j) {
            return 0L;
        }
        long j7 = gVar.f3455g;
        if (k()) {
            i8 = this.f3518h.f3454f - this.f3519i.f3454f;
        } else {
            if (i7 != 0) {
                return j7 - ((long) this.f3519i.f3454f);
            }
            i8 = this.f3518h.f3454f;
        }
        return j7 + ((long) i8);
    }
}
