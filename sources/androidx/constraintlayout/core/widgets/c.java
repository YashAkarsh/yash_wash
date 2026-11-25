package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f3529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e f3530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f3531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f3532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected e f3533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected e f3534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected e f3535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected ArrayList<e> f3536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f3537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f3538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f3539k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f3540l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f3541m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f3542n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f3543o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3544p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f3545q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f3546r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f3547s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f3548t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f3549u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f3550v;

    public c(e eVar, int i7, boolean z7) {
        this.f3529a = eVar;
        this.f3544p = i7;
        this.f3545q = z7;
    }

    private void b() {
        int i7 = this.f3544p * 2;
        e eVar = this.f3529a;
        this.f3543o = true;
        e eVar2 = eVar;
        boolean z7 = false;
        while (!z7) {
            this.f3537i++;
            e[] eVarArr = eVar.P0;
            int i8 = this.f3544p;
            e eVar3 = null;
            eVarArr[i8] = null;
            eVar.O0[i8] = null;
            if (eVar.l0() != 8) {
                this.f3540l++;
                e.b bVarZ = eVar.z(this.f3544p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarZ != bVar) {
                    this.f3541m += eVar.M(this.f3544p);
                }
                int iG = this.f3541m + eVar.Y[i7].g();
                this.f3541m = iG;
                int i9 = i7 + 1;
                this.f3541m = iG + eVar.Y[i9].g();
                int iG2 = this.f3542n + eVar.Y[i7].g();
                this.f3542n = iG2;
                this.f3542n = iG2 + eVar.Y[i9].g();
                if (this.f3530b == null) {
                    this.f3530b = eVar;
                }
                this.f3532d = eVar;
                e.b[] bVarArr = eVar.f3603b0;
                int i10 = this.f3544p;
                if (bVarArr[i10] == bVar) {
                    int i11 = eVar.f3648y[i10];
                    if (i11 == 0 || i11 == 3 || i11 == 2) {
                        this.f3538j++;
                        float f8 = eVar.N0[i10];
                        if (f8 > 0.0f) {
                            this.f3539k += f8;
                        }
                        if (k(eVar, i10)) {
                            if (f8 < 0.0f) {
                                this.f3546r = true;
                            } else {
                                this.f3547s = true;
                            }
                            if (this.f3536h == null) {
                                this.f3536h = new ArrayList<>();
                            }
                            this.f3536h.add(eVar);
                        }
                        if (this.f3534f == null) {
                            this.f3534f = eVar;
                        }
                        e eVar4 = this.f3535g;
                        if (eVar4 != null) {
                            eVar4.O0[this.f3544p] = eVar;
                        }
                        this.f3535g = eVar;
                    }
                    if (this.f3544p == 0) {
                        if (eVar.f3644w != 0 || eVar.f3650z != 0 || eVar.A != 0) {
                            this.f3543o = false;
                        }
                    } else if (eVar.f3646x != 0 || eVar.C != 0 || eVar.D != 0) {
                        this.f3543o = false;
                    }
                    if (eVar.f3611f0 != 0.0f) {
                        this.f3543o = false;
                        this.f3549u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.P0[this.f3544p] = eVar;
            }
            d dVar = eVar.Y[i7 + 1].f3558f;
            if (dVar != null) {
                e eVar5 = dVar.f3556d;
                d dVar2 = eVar5.Y[i7].f3558f;
                if (dVar2 != null && dVar2.f3556d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z7 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f3530b;
        if (eVar6 != null) {
            this.f3541m -= eVar6.Y[i7].g();
        }
        e eVar7 = this.f3532d;
        if (eVar7 != null) {
            this.f3541m -= eVar7.Y[i7 + 1].g();
        }
        this.f3531c = eVar;
        if (this.f3544p == 0 && this.f3545q) {
            this.f3533e = eVar;
        } else {
            this.f3533e = this.f3529a;
        }
        this.f3548t = this.f3547s && this.f3546r;
    }

    private static boolean k(e eVar, int i7) {
        int i8;
        return eVar.l0() != 8 && eVar.f3603b0[i7] == e.b.MATCH_CONSTRAINT && ((i8 = eVar.f3648y[i7]) == 0 || i8 == 3);
    }

    public void a() {
        if (!this.f3550v) {
            b();
        }
        this.f3550v = true;
    }

    public e c() {
        return this.f3529a;
    }

    public e d() {
        return this.f3534f;
    }

    public e e() {
        return this.f3530b;
    }

    public e f() {
        return this.f3533e;
    }

    public e g() {
        return this.f3531c;
    }

    public e h() {
        return this.f3535g;
    }

    public e i() {
        return this.f3532d;
    }

    public float j() {
        return this.f3539k;
    }
}
