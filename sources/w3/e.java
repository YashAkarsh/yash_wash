package w3;

import com.jiao.project.bluetoothofabroadwasherapp.enums.g;

/* JADX INFO: loaded from: classes2.dex */
public class e implements t3.c {
    private boolean A;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f40520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f40521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f40522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f40523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f40524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f40525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f40526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f40527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f40528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f40529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f40530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f40531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f40532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f40533r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f40534s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f40535t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f40536u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f40537v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f40538w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f40539x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f40540y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f40541z;

    public e(byte[] bArr) {
        if (bArr != null && bArr.length == 29 && bArr[10] == 109) {
            if (bArr[11] == 1) {
                this.f40520e = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[12]);
                this.f40521f = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 6) == 1;
                this.f40522g = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 5) == 1;
                this.f40523h = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 4) == 1;
                this.f40524i = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 1) == 1;
                this.f40525j = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 0) == 1;
                this.f40526k = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 3) == 1;
                this.f40527l = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 2) == 1;
                this.f40528m = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[14], 0) == 1;
                this.f40529n = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[15]);
                this.f40530o = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[16]) == 1;
                this.f40531p = bArr[17];
                this.f40532q = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[18]);
                this.f40533r = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[19]);
                this.f40534s = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[20]);
                this.f40535t = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[21]);
                this.f40536u = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[22]);
                this.f40537v = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[23]);
                this.f40538w = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[24]);
                this.f40539x = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[25]);
                this.f40540y = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[26]);
                this.f40541z = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[14], 1) == 1;
                this.A = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 7) == 1;
            }
        }
    }

    @Override // t3.c
    public boolean a() {
        return false;
    }

    @Override // t3.c
    public String b() {
        return t3.c.f40371b;
    }

    @Override // t3.c
    public String c() {
        return this.A ? g.b(this.f40531p) : "命令未执行";
    }

    public int d() {
        return this.f40536u;
    }

    public int e() {
        return this.f40531p;
    }

    public int f() {
        return this.f40539x;
    }

    public int g() {
        return this.f40520e;
    }

    public int h() {
        return this.f40535t;
    }

    public int i() {
        return this.f40532q;
    }

    public int j() {
        return this.f40533r;
    }

    public int k() {
        return this.f40538w;
    }

    public boolean l() {
        return this.f40528m;
    }

    public int m() {
        return this.f40540y;
    }

    public int n() {
        return this.f40537v;
    }

    public int o() {
        return this.f40529n;
    }

    public int p() {
        return this.f40534s;
    }

    public boolean q() {
        return this.f40521f;
    }

    public boolean r() {
        return this.f40522g;
    }

    public boolean s() {
        return this.f40525j;
    }

    public boolean t() {
        return this.f40524i;
    }

    public boolean u() {
        return this.A;
    }

    public boolean v() {
        return this.f40530o;
    }

    public boolean w() {
        return this.f40523h;
    }

    public boolean x() {
        return this.f40527l;
    }

    public boolean y() {
        return this.f40541z;
    }

    public boolean z() {
        return this.f40526k;
    }
}
