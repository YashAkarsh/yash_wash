package w3;

/* JADX INFO: loaded from: classes2.dex */
public class b implements t3.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f40498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f40499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f40500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f40501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f40502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f40503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f40504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f40505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f40506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f40507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f40508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f40509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f40510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f40511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f40512s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f40513t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f40514u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f40515v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f40516w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f40517x;

    public b(byte[] bArr) {
        if (bArr != null && bArr.length == 31 && bArr[10] == 109 && bArr[11] == 1) {
            this.f40498e = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[12]);
            this.f40499f = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 4) == 1;
            this.f40500g = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[16], 0) == 1;
            this.f40501h = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 2) == 1;
            this.f40502i = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 1) == 1;
            this.f40503j = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[13], 0) == 1;
            this.f40504k = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[14], bArr[15]);
            this.f40505l = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[27]) + 3;
            this.f40506m = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[17]) + 3;
            this.f40507n = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[18]);
            this.f40508o = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[19]);
            this.f40509p = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[20]);
            this.f40510q = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[21]);
            this.f40511r = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[22], bArr[23]);
            this.f40512s = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[24]);
            this.f40513t = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[25]);
            this.f40514u = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[26], 1) == 1;
            this.f40515v = com.haier.hailicommontlib.mvp.model.utils.c.j(bArr[26], 0) == 1;
            this.f40516w = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[28]);
            this.f40517x = com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[29]);
        }
    }

    @Override // t3.c
    public boolean a() {
        return this.f40501h;
    }

    @Override // t3.c
    public String b() {
        return t3.c.f40372c;
    }

    @Override // t3.c
    public String c() {
        return com.jiao.project.bluetoothofabroadwasherapp.enums.e.b(this.f40513t);
    }

    public int d() {
        return this.f40510q;
    }

    public int e() {
        return this.f40513t;
    }

    public int f() {
        return this.f40504k;
    }

    public int g() {
        return this.f40511r;
    }

    public int h() {
        return this.f40507n;
    }

    public int i() {
        return this.f40509p;
    }

    public int j() {
        return this.f40512s;
    }

    public int k() {
        return this.f40508o;
    }

    public int l() {
        return this.f40516w;
    }

    public int m() {
        return this.f40517x;
    }

    public int n() {
        return this.f40498e;
    }

    public int o() {
        return this.f40505l;
    }

    public int p() {
        return this.f40506m;
    }

    public boolean q() {
        return this.f40499f;
    }

    public boolean r() {
        return this.f40514u;
    }

    public boolean s() {
        return this.f40502i;
    }

    public boolean t() {
        return this.f40515v;
    }

    public boolean u() {
        return this.f40503j;
    }

    public boolean v() {
        return this.f40501h;
    }

    public boolean w() {
        return this.f40500g;
    }
}
