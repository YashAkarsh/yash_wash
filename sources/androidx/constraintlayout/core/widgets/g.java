package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class g extends n {

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final int f3670o2 = 0;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final int f3671p2 = 1;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final int f3672q2 = 2;

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final int f3673r2 = 0;

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final int f3674s2 = 1;

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final int f3675t2 = 2;

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final int f3676u2 = 3;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f3677v2 = 0;

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final int f3678w2 = 1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final int f3679x2 = 2;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final int f3680y2 = 3;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    private e[] f3693m2;
    private int P1 = -1;
    private int Q1 = -1;
    private int R1 = -1;
    private int S1 = -1;
    private int T1 = -1;
    private int U1 = -1;
    private float V1 = 0.5f;
    private float W1 = 0.5f;
    private float X1 = 0.5f;
    private float Y1 = 0.5f;
    private float Z1 = 0.5f;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    private float f3681a2 = 0.5f;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private int f3682b2 = 0;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    private int f3683c2 = 0;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    private int f3684d2 = 2;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    private int f3685e2 = 2;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    private int f3686f2 = 0;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    private int f3687g2 = -1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    private int f3688h2 = 0;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    private ArrayList<a> f3689i2 = new ArrayList<>();

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    private e[] f3690j2 = null;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    private e[] f3691k2 = null;

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    private int[] f3692l2 = null;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    private int f3694n2 = 0;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3695a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f3698d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d f3699e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d f3700f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private d f3701g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f3702h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f3703i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f3704j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f3705k;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f3711q;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f3696b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3697c = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f3706l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f3707m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f3708n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f3709o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f3710p = 0;

        public a(int i7, d dVar, d dVar2, d dVar3, d dVar4, int i8) {
            this.f3702h = 0;
            this.f3703i = 0;
            this.f3704j = 0;
            this.f3705k = 0;
            this.f3711q = 0;
            this.f3695a = i7;
            this.f3698d = dVar;
            this.f3699e = dVar2;
            this.f3700f = dVar3;
            this.f3701g = dVar4;
            this.f3702h = g.this.s2();
            this.f3703i = g.this.u2();
            this.f3704j = g.this.t2();
            this.f3705k = g.this.r2();
            this.f3711q = i8;
        }

        private void h() {
            this.f3706l = 0;
            this.f3707m = 0;
            this.f3696b = null;
            this.f3697c = 0;
            int i7 = this.f3709o;
            for (int i8 = 0; i8 < i7 && this.f3708n + i8 < g.this.f3694n2; i8++) {
                e eVar = g.this.f3693m2[this.f3708n + i8];
                if (this.f3695a == 0) {
                    int iM0 = eVar.m0();
                    int i9 = g.this.f3682b2;
                    if (eVar.l0() == 8) {
                        i9 = 0;
                    }
                    this.f3706l += iM0 + i9;
                    int iE3 = g.this.e3(eVar, this.f3711q);
                    if (this.f3696b == null || this.f3697c < iE3) {
                        this.f3696b = eVar;
                        this.f3697c = iE3;
                        this.f3707m = iE3;
                    }
                } else {
                    int iF3 = g.this.f3(eVar, this.f3711q);
                    int iE4 = g.this.e3(eVar, this.f3711q);
                    int i10 = g.this.f3683c2;
                    if (eVar.l0() == 8) {
                        i10 = 0;
                    }
                    this.f3707m += iE4 + i10;
                    if (this.f3696b == null || this.f3697c < iF3) {
                        this.f3696b = eVar;
                        this.f3697c = iF3;
                        this.f3706l = iF3;
                    }
                }
            }
        }

        public void b(e eVar) {
            if (this.f3695a == 0) {
                int iF3 = g.this.f3(eVar, this.f3711q);
                if (eVar.H() == e.b.MATCH_CONSTRAINT) {
                    this.f3710p++;
                    iF3 = 0;
                }
                this.f3706l += iF3 + (eVar.l0() != 8 ? g.this.f3682b2 : 0);
                int iE3 = g.this.e3(eVar, this.f3711q);
                if (this.f3696b == null || this.f3697c < iE3) {
                    this.f3696b = eVar;
                    this.f3697c = iE3;
                    this.f3707m = iE3;
                }
            } else {
                int iF4 = g.this.f3(eVar, this.f3711q);
                int iE4 = g.this.e3(eVar, this.f3711q);
                if (eVar.j0() == e.b.MATCH_CONSTRAINT) {
                    this.f3710p++;
                    iE4 = 0;
                }
                this.f3707m += iE4 + (eVar.l0() != 8 ? g.this.f3683c2 : 0);
                if (this.f3696b == null || this.f3697c < iF4) {
                    this.f3696b = eVar;
                    this.f3697c = iF4;
                    this.f3706l = iF4;
                }
            }
            this.f3709o++;
        }

        public void c() {
            this.f3697c = 0;
            this.f3696b = null;
            this.f3706l = 0;
            this.f3707m = 0;
            this.f3708n = 0;
            this.f3709o = 0;
            this.f3710p = 0;
        }

        public void d(boolean z7, int i7, boolean z8) {
            e eVar;
            char c8;
            float f8;
            float f9;
            int i8 = this.f3709o;
            for (int i9 = 0; i9 < i8 && this.f3708n + i9 < g.this.f3694n2; i9++) {
                e eVar2 = g.this.f3693m2[this.f3708n + i9];
                if (eVar2 != null) {
                    eVar2.U0();
                }
            }
            if (i8 == 0 || this.f3696b == null) {
                return;
            }
            boolean z9 = z8 && i7 == 0;
            int i10 = -1;
            int i11 = -1;
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = z7 ? (i8 - 1) - i12 : i12;
                if (this.f3708n + i13 >= g.this.f3694n2) {
                    break;
                }
                e eVar3 = g.this.f3693m2[this.f3708n + i13];
                if (eVar3 != null && eVar3.l0() == 0) {
                    if (i10 == -1) {
                        i10 = i12;
                    }
                    i11 = i12;
                }
            }
            e eVar4 = null;
            if (this.f3695a != 0) {
                e eVar5 = this.f3696b;
                eVar5.B1(g.this.P1);
                int i14 = this.f3702h;
                if (i7 > 0) {
                    i14 += g.this.f3682b2;
                }
                if (z7) {
                    eVar5.S.a(this.f3700f, i14);
                    if (z8) {
                        eVar5.Q.a(this.f3698d, this.f3704j);
                    }
                    if (i7 > 0) {
                        this.f3700f.f3556d.Q.a(eVar5.S, 0);
                    }
                } else {
                    eVar5.Q.a(this.f3698d, i14);
                    if (z8) {
                        eVar5.S.a(this.f3700f, this.f3704j);
                    }
                    if (i7 > 0) {
                        this.f3698d.f3556d.S.a(eVar5.Q, 0);
                    }
                }
                for (int i15 = 0; i15 < i8 && this.f3708n + i15 < g.this.f3694n2; i15++) {
                    e eVar6 = g.this.f3693m2[this.f3708n + i15];
                    if (eVar6 != null) {
                        if (i15 == 0) {
                            eVar6.l(eVar6.R, this.f3699e, this.f3703i);
                            int i16 = g.this.Q1;
                            float f10 = g.this.W1;
                            if (this.f3708n == 0 && g.this.S1 != -1) {
                                i16 = g.this.S1;
                                f10 = g.this.Y1;
                            } else if (z8 && g.this.U1 != -1) {
                                i16 = g.this.U1;
                                f10 = g.this.f3681a2;
                            }
                            eVar6.W1(i16);
                            eVar6.V1(f10);
                        }
                        if (i15 == i8 - 1) {
                            eVar6.l(eVar6.T, this.f3701g, this.f3705k);
                        }
                        if (eVar4 != null) {
                            eVar6.R.a(eVar4.T, g.this.f3683c2);
                            if (i15 == i10) {
                                eVar6.R.B(this.f3703i);
                            }
                            eVar4.T.a(eVar6.R, 0);
                            if (i15 == i11 + 1) {
                                eVar4.T.B(this.f3705k);
                            }
                        }
                        if (eVar6 != eVar5) {
                            if (z7) {
                                int i17 = g.this.f3684d2;
                                if (i17 == 0) {
                                    eVar6.S.a(eVar5.S, 0);
                                } else if (i17 == 1) {
                                    eVar6.Q.a(eVar5.Q, 0);
                                } else if (i17 == 2) {
                                    eVar6.Q.a(eVar5.Q, 0);
                                    eVar6.S.a(eVar5.S, 0);
                                }
                            } else {
                                int i18 = g.this.f3684d2;
                                if (i18 == 0) {
                                    eVar6.Q.a(eVar5.Q, 0);
                                } else if (i18 == 1) {
                                    eVar6.S.a(eVar5.S, 0);
                                } else if (i18 == 2) {
                                    if (z9) {
                                        eVar6.Q.a(this.f3698d, this.f3702h);
                                        eVar6.S.a(this.f3700f, this.f3704j);
                                    } else {
                                        eVar6.Q.a(eVar5.Q, 0);
                                        eVar6.S.a(eVar5.S, 0);
                                    }
                                }
                            }
                        }
                        eVar4 = eVar6;
                    }
                }
                return;
            }
            e eVar7 = this.f3696b;
            eVar7.W1(g.this.Q1);
            int i19 = this.f3703i;
            if (i7 > 0) {
                i19 += g.this.f3683c2;
            }
            eVar7.R.a(this.f3699e, i19);
            if (z8) {
                eVar7.T.a(this.f3701g, this.f3705k);
            }
            if (i7 > 0) {
                this.f3699e.f3556d.T.a(eVar7.R, 0);
            }
            char c9 = 3;
            if (g.this.f3685e2 != 3 || eVar7.q0()) {
                eVar = eVar7;
                break;
            }
            int i20 = 0;
            while (true) {
                if (i20 < i8) {
                    int i21 = z7 ? (i8 - 1) - i20 : i20;
                    if (this.f3708n + i21 < g.this.f3694n2) {
                        eVar = g.this.f3693m2[this.f3708n + i21];
                        if (eVar.q0()) {
                            break;
                        } else {
                            i20++;
                        }
                    }
                }
                eVar = eVar7;
                break;
            }
            int i22 = 0;
            while (i22 < i8) {
                int i23 = z7 ? (i8 - 1) - i22 : i22;
                if (this.f3708n + i23 >= g.this.f3694n2) {
                    return;
                }
                e eVar8 = g.this.f3693m2[this.f3708n + i23];
                if (eVar8 == null) {
                    eVar8 = eVar4;
                    c8 = c9;
                } else {
                    if (i22 == 0) {
                        eVar8.l(eVar8.Q, this.f3698d, this.f3702h);
                    }
                    if (i23 == 0) {
                        int i24 = g.this.P1;
                        float f11 = g.this.V1;
                        if (z7) {
                            f11 = 1.0f - f11;
                        }
                        if (this.f3708n == 0 && g.this.R1 != -1) {
                            i24 = g.this.R1;
                            if (z7) {
                                f9 = g.this.X1;
                                f8 = 1.0f - f9;
                            } else {
                                f8 = g.this.X1;
                            }
                            f11 = f8;
                        } else if (z8 && g.this.T1 != -1) {
                            i24 = g.this.T1;
                            if (z7) {
                                f9 = g.this.Z1;
                                f8 = 1.0f - f9;
                            } else {
                                f8 = g.this.Z1;
                            }
                            f11 = f8;
                        }
                        eVar8.B1(i24);
                        eVar8.A1(f11);
                    }
                    if (i22 == i8 - 1) {
                        eVar8.l(eVar8.S, this.f3700f, this.f3704j);
                    }
                    if (eVar4 != null) {
                        eVar8.Q.a(eVar4.S, g.this.f3682b2);
                        if (i22 == i10) {
                            eVar8.Q.B(this.f3702h);
                        }
                        eVar4.S.a(eVar8.Q, 0);
                        if (i22 == i11 + 1) {
                            eVar4.S.B(this.f3704j);
                        }
                    }
                    if (eVar8 != eVar7) {
                        c8 = 3;
                        if (g.this.f3685e2 == 3 && eVar.q0() && eVar8 != eVar && eVar8.q0()) {
                            eVar8.U.a(eVar.U, 0);
                        } else {
                            int i25 = g.this.f3685e2;
                            if (i25 == 0) {
                                eVar8.R.a(eVar7.R, 0);
                            } else if (i25 == 1) {
                                eVar8.T.a(eVar7.T, 0);
                            } else if (z9) {
                                eVar8.R.a(this.f3699e, this.f3703i);
                                eVar8.T.a(this.f3701g, this.f3705k);
                            } else {
                                eVar8.R.a(eVar7.R, 0);
                                eVar8.T.a(eVar7.T, 0);
                            }
                        }
                    } else {
                        c8 = 3;
                    }
                }
                i22++;
                c9 = c8;
                eVar4 = eVar8;
            }
        }

        public int e() {
            return this.f3695a == 1 ? this.f3707m - g.this.f3683c2 : this.f3707m;
        }

        public int f() {
            return this.f3695a == 0 ? this.f3706l - g.this.f3682b2 : this.f3706l;
        }

        public void g(int i7) {
            int i8 = this.f3710p;
            if (i8 == 0) {
                return;
            }
            int i9 = this.f3709o;
            int i10 = i7 / i8;
            for (int i11 = 0; i11 < i9 && this.f3708n + i11 < g.this.f3694n2; i11++) {
                e eVar = g.this.f3693m2[this.f3708n + i11];
                if (this.f3695a == 0) {
                    if (eVar != null && eVar.H() == e.b.MATCH_CONSTRAINT && eVar.f3644w == 0) {
                        g.this.w2(eVar, e.b.FIXED, i10, eVar.j0(), eVar.D());
                    }
                } else if (eVar != null && eVar.j0() == e.b.MATCH_CONSTRAINT && eVar.f3646x == 0) {
                    g.this.w2(eVar, eVar.H(), eVar.m0(), e.b.FIXED, i10);
                }
            }
            h();
        }

        public void i(int i7) {
            this.f3708n = i7;
        }

        public void j(int i7, d dVar, d dVar2, d dVar3, d dVar4, int i8, int i9, int i10, int i11, int i12) {
            this.f3695a = i7;
            this.f3698d = dVar;
            this.f3699e = dVar2;
            this.f3700f = dVar3;
            this.f3701g = dVar4;
            this.f3702h = i8;
            this.f3703i = i9;
            this.f3704j = i10;
            this.f3705k = i11;
            this.f3711q = i12;
        }
    }

    private void c3(boolean z7) {
        e eVar;
        float f8;
        int i7;
        if (this.f3692l2 == null || this.f3691k2 == null || this.f3690j2 == null) {
            return;
        }
        for (int i8 = 0; i8 < this.f3694n2; i8++) {
            this.f3693m2[i8].U0();
        }
        int[] iArr = this.f3692l2;
        int i9 = iArr[0];
        int i10 = iArr[1];
        float f9 = this.V1;
        e eVar2 = null;
        int i11 = 0;
        while (i11 < i9) {
            if (z7) {
                i7 = (i9 - i11) - 1;
                f8 = 1.0f - this.V1;
            } else {
                f8 = f9;
                i7 = i11;
            }
            e eVar3 = this.f3691k2[i7];
            if (eVar3 != null && eVar3.l0() != 8) {
                if (i11 == 0) {
                    eVar3.l(eVar3.Q, this.Q, s2());
                    eVar3.B1(this.P1);
                    eVar3.A1(f8);
                }
                if (i11 == i9 - 1) {
                    eVar3.l(eVar3.S, this.S, t2());
                }
                if (i11 > 0 && eVar2 != null) {
                    eVar3.l(eVar3.Q, eVar2.S, this.f3682b2);
                    eVar2.l(eVar2.S, eVar3.Q, 0);
                }
                eVar2 = eVar3;
            }
            i11++;
            f9 = f8;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            e eVar4 = this.f3690j2[i12];
            if (eVar4 != null && eVar4.l0() != 8) {
                if (i12 == 0) {
                    eVar4.l(eVar4.R, this.R, u2());
                    eVar4.W1(this.Q1);
                    eVar4.V1(this.W1);
                }
                if (i12 == i10 - 1) {
                    eVar4.l(eVar4.T, this.T, r2());
                }
                if (i12 > 0 && eVar2 != null) {
                    eVar4.l(eVar4.R, eVar2.T, this.f3683c2);
                    eVar2.l(eVar2.T, eVar4.R, 0);
                }
                eVar2 = eVar4;
            }
        }
        for (int i13 = 0; i13 < i9; i13++) {
            for (int i14 = 0; i14 < i10; i14++) {
                int i15 = (i14 * i9) + i13;
                if (this.f3688h2 == 1) {
                    i15 = (i13 * i10) + i14;
                }
                e[] eVarArr = this.f3693m2;
                if (i15 < eVarArr.length && (eVar = eVarArr[i15]) != null && eVar.l0() != 8) {
                    e eVar5 = this.f3691k2[i13];
                    e eVar6 = this.f3690j2[i14];
                    if (eVar != eVar5) {
                        eVar.l(eVar.Q, eVar5.Q, 0);
                        eVar.l(eVar.S, eVar5.S, 0);
                    }
                    if (eVar != eVar6) {
                        eVar.l(eVar.R, eVar6.R, 0);
                        eVar.l(eVar.T, eVar6.T, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e3(e eVar, int i7) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.j0() == e.b.MATCH_CONSTRAINT) {
            int i8 = eVar.f3646x;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (eVar.E * i7);
                if (i9 != eVar.D()) {
                    eVar.N1(true);
                    w2(eVar, eVar.H(), eVar.m0(), e.b.FIXED, i9);
                }
                return i9;
            }
            if (i8 == 1) {
                return eVar.D();
            }
            if (i8 == 3) {
                return (int) ((eVar.m0() * eVar.f3611f0) + 0.5f);
            }
        }
        return eVar.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f3(e eVar, int i7) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.H() == e.b.MATCH_CONSTRAINT) {
            int i8 = eVar.f3644w;
            if (i8 == 0) {
                return 0;
            }
            if (i8 == 2) {
                int i9 = (int) (eVar.B * i7);
                if (i9 != eVar.m0()) {
                    eVar.N1(true);
                    w2(eVar, e.b.FIXED, i9, eVar.j0(), eVar.D());
                }
                return i9;
            }
            if (i8 == 1) {
                return eVar.m0();
            }
            if (i8 == 3) {
                return (int) ((eVar.D() * eVar.f3611f0) + 0.5f);
            }
        }
        return eVar.m0();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:106:0x010f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:119:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:122:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x00d3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0060  */
    /* JADX WARN: Code duplicated, block: B:47:0x006a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0078  */
    /* JADX WARN: Code duplicated, block: B:54:0x0080  */
    /* JADX WARN: Code duplicated, block: B:57:0x0088  */
    /* JADX WARN: Code duplicated, block: B:61:0x0090  */
    /* JADX WARN: Code duplicated, block: B:64:0x0097  */
    /* JADX WARN: Code duplicated, block: B:66:0x009a  */
    /* JADX WARN: Code duplicated, block: B:68:0x009f  */
    /* JADX WARN: Code duplicated, block: B:72:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:89:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:99:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:45:0x005e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void g3(androidx.constraintlayout.core.widgets.e[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.g.g3(androidx.constraintlayout.core.widgets.e[], int, int, int, int[]):void");
    }

    private void h3(e[] eVarArr, int i7, int i8, int i9, int[] iArr) {
        int i10;
        int i11;
        int i12;
        d dVar;
        int iT2;
        d dVar2;
        int iR2;
        int i13;
        if (i7 == 0) {
            return;
        }
        this.f3689i2.clear();
        a aVar = new a(i8, this.Q, this.R, this.S, this.T, i9);
        this.f3689i2.add(aVar);
        if (i8 == 0) {
            i10 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i15 < i7) {
                e eVar = eVarArr[i15];
                int iF3 = f3(eVar, i9);
                if (eVar.H() == e.b.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i16 = i10;
                boolean z7 = (i14 == i9 || (this.f3682b2 + i14) + iF3 > i9) && aVar.f3696b != null;
                if (!z7 && i15 > 0 && (i13 = this.f3687g2) > 0 && i15 % i13 == 0) {
                    z7 = true;
                }
                if (z7) {
                    aVar = new a(i8, this.Q, this.R, this.S, this.T, i9);
                    aVar.i(i15);
                    this.f3689i2.add(aVar);
                } else {
                    if (i15 > 0) {
                        i14 += this.f3682b2 + iF3;
                    }
                    aVar.b(eVar);
                    i15++;
                    i10 = i16;
                }
                i14 = iF3;
                aVar.b(eVar);
                i15++;
                i10 = i16;
            }
        } else {
            i10 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i7) {
                e eVar2 = eVarArr[i18];
                int iE3 = e3(eVar2, i9);
                if (eVar2.j0() == e.b.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i19 = i10;
                boolean z8 = (i17 == i9 || (this.f3683c2 + i17) + iE3 > i9) && aVar.f3696b != null;
                if (!z8 && i18 > 0 && (i11 = this.f3687g2) > 0 && i18 % i11 == 0) {
                    z8 = true;
                }
                if (z8) {
                    aVar = new a(i8, this.Q, this.R, this.S, this.T, i9);
                    aVar.i(i18);
                    this.f3689i2.add(aVar);
                } else {
                    if (i18 > 0) {
                        i17 += this.f3683c2 + iE3;
                    }
                    aVar.b(eVar2);
                    i18++;
                    i10 = i19;
                }
                i17 = iE3;
                aVar.b(eVar2);
                i18++;
                i10 = i19;
            }
        }
        int size = this.f3689i2.size();
        d dVar3 = this.Q;
        d dVar4 = this.R;
        d dVar5 = this.S;
        d dVar6 = this.T;
        int iS2 = s2();
        int iU2 = u2();
        int iT3 = t2();
        int iR3 = r2();
        e.b bVarH = H();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z9 = bVarH == bVar || j0() == bVar;
        if (i10 > 0 && z9) {
            for (int i20 = 0; i20 < size; i20++) {
                a aVar2 = this.f3689i2.get(i20);
                if (i8 == 0) {
                    aVar2.g(i9 - aVar2.f());
                } else {
                    aVar2.g(i9 - aVar2.e());
                }
            }
        }
        int i21 = iU2;
        int i22 = iT3;
        int iE = 0;
        int iF = 0;
        int i23 = 0;
        int i24 = iS2;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i25 = iR3;
        while (i23 < size) {
            a aVar3 = this.f3689i2.get(i23);
            if (i8 == 0) {
                if (i23 < size - 1) {
                    dVar2 = this.f3689i2.get(i23 + 1).f3696b.R;
                    iR2 = 0;
                } else {
                    dVar2 = this.T;
                    iR2 = r2();
                }
                d dVar9 = aVar3.f3696b.T;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i26 = iE;
                d dVar12 = dVar7;
                int i27 = iF;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i12 = i23;
                aVar3.j(i8, dVar10, dVar12, dVar13, dVar2, i24, i21, i22, iR2, i9);
                int iMax = Math.max(i27, aVar3.f());
                iE = i26 + aVar3.e();
                if (i12 > 0) {
                    iE += this.f3683c2;
                }
                dVar8 = dVar11;
                iF = iMax;
                i21 = 0;
                dVar7 = dVar9;
                dVar = dVar14;
                int i28 = iR2;
                dVar6 = dVar2;
                i25 = i28;
            } else {
                d dVar15 = dVar8;
                int i29 = iE;
                int i30 = iF;
                i12 = i23;
                if (i12 < size - 1) {
                    dVar = this.f3689i2.get(i12 + 1).f3696b.Q;
                    iT2 = 0;
                } else {
                    dVar = this.S;
                    iT2 = t2();
                }
                d dVar16 = aVar3.f3696b.S;
                aVar3.j(i8, dVar15, dVar7, dVar, dVar6, i24, i21, iT2, i25, i9);
                iF = i30 + aVar3.f();
                int iMax2 = Math.max(i29, aVar3.e());
                if (i12 > 0) {
                    iF += this.f3682b2;
                }
                iE = iMax2;
                i24 = 0;
                i22 = iT2;
                dVar8 = dVar16;
            }
            i23 = i12 + 1;
            dVar5 = dVar;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    private void i3(e[] eVarArr, int i7, int i8, int i9, int[] iArr) {
        int i10;
        int i11;
        int i12;
        d dVar;
        int iT2;
        d dVar2;
        int iR2;
        int i13;
        if (i7 == 0) {
            return;
        }
        this.f3689i2.clear();
        a aVar = new a(i8, this.Q, this.R, this.S, this.T, i9);
        this.f3689i2.add(aVar);
        if (i8 == 0) {
            int i14 = 0;
            i10 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i7) {
                int i17 = i14 + 1;
                e eVar = eVarArr[i16];
                int iF3 = f3(eVar, i9);
                if (eVar.H() == e.b.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i18 = i10;
                boolean z7 = (i15 == i9 || (this.f3682b2 + i15) + iF3 > i9) && aVar.f3696b != null;
                if (!z7 && i16 > 0 && (i13 = this.f3687g2) > 0 && i17 > i13) {
                    z7 = true;
                }
                if (z7) {
                    aVar = new a(i8, this.Q, this.R, this.S, this.T, i9);
                    aVar.i(i16);
                    this.f3689i2.add(aVar);
                    i14 = i17;
                    i15 = iF3;
                } else {
                    i15 = i16 > 0 ? i15 + this.f3682b2 + iF3 : iF3;
                    i14 = 0;
                }
                aVar.b(eVar);
                i16++;
                i10 = i18;
            }
        } else {
            int i19 = 0;
            i10 = 0;
            int i20 = 0;
            while (i20 < i7) {
                e eVar2 = eVarArr[i20];
                int iE3 = e3(eVar2, i9);
                if (eVar2.j0() == e.b.MATCH_CONSTRAINT) {
                    i10++;
                }
                int i21 = i10;
                boolean z8 = (i19 == i9 || (this.f3683c2 + i19) + iE3 > i9) && aVar.f3696b != null;
                if (!z8 && i20 > 0 && (i11 = this.f3687g2) > 0 && i11 < 0) {
                    z8 = true;
                }
                if (z8) {
                    aVar = new a(i8, this.Q, this.R, this.S, this.T, i9);
                    aVar.i(i20);
                    this.f3689i2.add(aVar);
                } else {
                    if (i20 > 0) {
                        i19 += this.f3683c2 + iE3;
                    }
                    aVar.b(eVar2);
                    i20++;
                    i10 = i21;
                }
                i19 = iE3;
                aVar.b(eVar2);
                i20++;
                i10 = i21;
            }
        }
        int size = this.f3689i2.size();
        d dVar3 = this.Q;
        d dVar4 = this.R;
        d dVar5 = this.S;
        d dVar6 = this.T;
        int iS2 = s2();
        int iU2 = u2();
        int iT3 = t2();
        int iR3 = r2();
        e.b bVarH = H();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z9 = bVarH == bVar || j0() == bVar;
        if (i10 > 0 && z9) {
            for (int i22 = 0; i22 < size; i22++) {
                a aVar2 = this.f3689i2.get(i22);
                if (i8 == 0) {
                    aVar2.g(i9 - aVar2.f());
                } else {
                    aVar2.g(i9 - aVar2.e());
                }
            }
        }
        int i23 = iU2;
        int i24 = iT3;
        int iE = 0;
        int iF = 0;
        int i25 = 0;
        int i26 = iS2;
        d dVar7 = dVar4;
        d dVar8 = dVar3;
        int i27 = iR3;
        while (i25 < size) {
            a aVar3 = this.f3689i2.get(i25);
            if (i8 == 0) {
                if (i25 < size - 1) {
                    dVar2 = this.f3689i2.get(i25 + 1).f3696b.R;
                    iR2 = 0;
                } else {
                    dVar2 = this.T;
                    iR2 = r2();
                }
                d dVar9 = aVar3.f3696b.T;
                d dVar10 = dVar8;
                d dVar11 = dVar8;
                int i28 = iE;
                d dVar12 = dVar7;
                int i29 = iF;
                d dVar13 = dVar5;
                d dVar14 = dVar5;
                i12 = i25;
                aVar3.j(i8, dVar10, dVar12, dVar13, dVar2, i26, i23, i24, iR2, i9);
                int iMax = Math.max(i29, aVar3.f());
                iE = i28 + aVar3.e();
                if (i12 > 0) {
                    iE += this.f3683c2;
                }
                dVar8 = dVar11;
                iF = iMax;
                i23 = 0;
                dVar7 = dVar9;
                dVar = dVar14;
                int i30 = iR2;
                dVar6 = dVar2;
                i27 = i30;
            } else {
                d dVar15 = dVar8;
                int i31 = iE;
                int i32 = iF;
                i12 = i25;
                if (i12 < size - 1) {
                    dVar = this.f3689i2.get(i12 + 1).f3696b.Q;
                    iT2 = 0;
                } else {
                    dVar = this.S;
                    iT2 = t2();
                }
                d dVar16 = aVar3.f3696b.S;
                aVar3.j(i8, dVar15, dVar7, dVar, dVar6, i26, i23, iT2, i27, i9);
                iF = i32 + aVar3.f();
                int iMax2 = Math.max(i31, aVar3.e());
                if (i12 > 0) {
                    iF += this.f3682b2;
                }
                iE = iMax2;
                i26 = 0;
                i24 = iT2;
                dVar8 = dVar16;
            }
            i25 = i12 + 1;
            dVar5 = dVar;
        }
        iArr[0] = iF;
        iArr[1] = iE;
    }

    private void j3(e[] eVarArr, int i7, int i8, int i9, int[] iArr) {
        a aVar;
        if (i7 == 0) {
            return;
        }
        if (this.f3689i2.size() == 0) {
            aVar = new a(i8, this.Q, this.R, this.S, this.T, i9);
            this.f3689i2.add(aVar);
        } else {
            a aVar2 = this.f3689i2.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i8, this.Q, this.R, this.S, this.T, s2(), u2(), t2(), r2(), i9);
        }
        for (int i10 = 0; i10 < i7; i10++) {
            aVar.b(eVarArr[i10]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void A3(int i7) {
        this.f3683c2 = i7;
    }

    public void B3(int i7) {
        this.Q1 = i7;
    }

    public void C3(int i7) {
        this.f3686f2 = i7;
    }

    public float d3() {
        return this.f3687g2;
    }

    @Override // androidx.constraintlayout.core.widgets.e
    public void g(androidx.constraintlayout.core.e eVar, boolean z7) {
        super.g(eVar, z7);
        boolean z8 = U() != null && ((f) U()).O2();
        int i7 = this.f3686f2;
        if (i7 != 0) {
            if (i7 == 1) {
                int size = this.f3689i2.size();
                int i8 = 0;
                while (i8 < size) {
                    this.f3689i2.get(i8).d(z8, i8, i8 == size + (-1));
                    i8++;
                }
            } else if (i7 == 2) {
                c3(z8);
            } else if (i7 == 3) {
                int size2 = this.f3689i2.size();
                int i9 = 0;
                while (i9 < size2) {
                    this.f3689i2.get(i9).d(z8, i9, i9 == size2 + (-1));
                    i9++;
                }
            }
        } else if (this.f3689i2.size() > 0) {
            this.f3689i2.get(0).d(z8, 0, true);
        }
        z2(false);
    }

    public void k3(float f8) {
        this.X1 = f8;
    }

    public void l3(int i7) {
        this.R1 = i7;
    }

    public void m3(float f8) {
        this.Y1 = f8;
    }

    @Override // androidx.constraintlayout.core.widgets.j, androidx.constraintlayout.core.widgets.e
    public void n(e eVar, HashMap<e, e> map) {
        super.n(eVar, map);
        g gVar = (g) eVar;
        this.P1 = gVar.P1;
        this.Q1 = gVar.Q1;
        this.R1 = gVar.R1;
        this.S1 = gVar.S1;
        this.T1 = gVar.T1;
        this.U1 = gVar.U1;
        this.V1 = gVar.V1;
        this.W1 = gVar.W1;
        this.X1 = gVar.X1;
        this.Y1 = gVar.Y1;
        this.Z1 = gVar.Z1;
        this.f3681a2 = gVar.f3681a2;
        this.f3682b2 = gVar.f3682b2;
        this.f3683c2 = gVar.f3683c2;
        this.f3684d2 = gVar.f3684d2;
        this.f3685e2 = gVar.f3685e2;
        this.f3686f2 = gVar.f3686f2;
        this.f3687g2 = gVar.f3687g2;
        this.f3688h2 = gVar.f3688h2;
    }

    public void n3(int i7) {
        this.S1 = i7;
    }

    public void o3(int i7) {
        this.f3684d2 = i7;
    }

    public void p3(float f8) {
        this.V1 = f8;
    }

    public void q3(int i7) {
        this.f3682b2 = i7;
    }

    public void r3(int i7) {
        this.P1 = i7;
    }

    public void s3(float f8) {
        this.Z1 = f8;
    }

    public void t3(int i7) {
        this.T1 = i7;
    }

    public void u3(float f8) {
        this.f3681a2 = f8;
    }

    @Override // androidx.constraintlayout.core.widgets.n
    public void v2(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        boolean z7;
        if (this.B1 > 0 && !x2()) {
            A2(0, 0);
            z2(false);
            return;
        }
        int iS2 = s2();
        int iT2 = t2();
        int iU2 = u2();
        int iR2 = r2();
        int[] iArr = new int[2];
        int i13 = (i8 - iS2) - iT2;
        int i14 = this.f3688h2;
        if (i14 == 1) {
            i13 = (i10 - iU2) - iR2;
        }
        int i15 = i13;
        if (i14 == 0) {
            if (this.P1 == -1) {
                this.P1 = 0;
            }
            if (this.Q1 == -1) {
                this.Q1 = 0;
            }
        } else {
            if (this.P1 == -1) {
                this.P1 = 0;
            }
            if (this.Q1 == -1) {
                this.Q1 = 0;
            }
        }
        e[] eVarArr = this.A1;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            i11 = this.B1;
            if (i16 >= i11) {
                break;
            }
            if (this.A1[i16].l0() == 8) {
                i17++;
            }
            i16++;
        }
        if (i17 > 0) {
            eVarArr = new e[i11 - i17];
            int i18 = 0;
            for (int i19 = 0; i19 < this.B1; i19++) {
                e eVar = this.A1[i19];
                if (eVar.l0() != 8) {
                    eVarArr[i18] = eVar;
                    i18++;
                }
            }
            i12 = i18;
        } else {
            i12 = i11;
        }
        this.f3693m2 = eVarArr;
        this.f3694n2 = i12;
        int i20 = this.f3686f2;
        if (i20 == 0) {
            z7 = true;
            j3(eVarArr, i12, this.f3688h2, i15, iArr);
        } else if (i20 == 1) {
            z7 = true;
            h3(eVarArr, i12, this.f3688h2, i15, iArr);
        } else if (i20 == 2) {
            z7 = true;
            g3(eVarArr, i12, this.f3688h2, i15, iArr);
        } else if (i20 != 3) {
            z7 = true;
        } else {
            z7 = true;
            i3(eVarArr, i12, this.f3688h2, i15, iArr);
        }
        int iMin = iArr[0] + iS2 + iT2;
        int iMin2 = iArr[z7 ? 1 : 0] + iU2 + iR2;
        if (i7 == 1073741824) {
            iMin = i8;
        } else if (i7 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i8);
        } else if (i7 != 0) {
            iMin = 0;
        }
        if (i9 == 1073741824) {
            iMin2 = i10;
        } else if (i9 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i10);
        } else if (i9 != 0) {
            iMin2 = 0;
        }
        A2(iMin, iMin2);
        c2(iMin);
        y1(iMin2);
        if (this.B1 <= 0) {
            z7 = false;
        }
        z2(z7);
    }

    public void v3(int i7) {
        this.U1 = i7;
    }

    public void w3(int i7) {
        this.f3687g2 = i7;
    }

    public void x3(int i7) {
        this.f3688h2 = i7;
    }

    public void y3(int i7) {
        this.f3685e2 = i7;
    }

    public void z3(float f8) {
        this.W1 = f8;
    }
}
