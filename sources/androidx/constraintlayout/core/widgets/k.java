package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3714a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3715b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3716c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3717d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3718e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3719f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f3720g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f3721h = 64;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3722i = 128;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f3723j = 256;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3724k = 512;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f3725l = 1024;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f3726m = 257;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static boolean[] f3727n = new boolean[3];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int f3728o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final int f3729p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final int f3730q = 2;

    static void a(f fVar, androidx.constraintlayout.core.e eVar, e eVar2) {
        eVar2.f3638t = -1;
        eVar2.f3640u = -1;
        e.b bVar = fVar.f3603b0[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar2.f3603b0[0] == e.b.MATCH_PARENT) {
            int i7 = eVar2.Q.f3559g;
            int iM0 = fVar.m0() - eVar2.S.f3559g;
            d dVar = eVar2.Q;
            dVar.f3561i = eVar.u(dVar);
            d dVar2 = eVar2.S;
            dVar2.f3561i = eVar.u(dVar2);
            eVar.f(eVar2.Q.f3561i, i7);
            eVar.f(eVar2.S.f3561i, iM0);
            eVar2.f3638t = 2;
            eVar2.C1(i7, iM0);
        }
        if (fVar.f3603b0[1] == bVar2 || eVar2.f3603b0[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i8 = eVar2.R.f3559g;
        int iD = fVar.D() - eVar2.T.f3559g;
        d dVar3 = eVar2.R;
        dVar3.f3561i = eVar.u(dVar3);
        d dVar4 = eVar2.T;
        dVar4.f3561i = eVar.u(dVar4);
        eVar.f(eVar2.R.f3561i, i8);
        eVar.f(eVar2.T.f3561i, iD);
        if (eVar2.f3627n0 > 0 || eVar2.l0() == 8) {
            d dVar5 = eVar2.U;
            dVar5.f3561i = eVar.u(dVar5);
            eVar.f(eVar2.U.f3561i, eVar2.f3627n0 + i8);
        }
        eVar2.f3640u = 2;
        eVar2.X1(i8, iD);
    }

    public static final boolean b(int i7, int i8) {
        return (i7 & i8) == i8;
    }
}
