package com.haier.uhome.search.a;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f29687a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29688b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f29689c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29690d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f29691e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29692f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f29693g = 64;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f29694h = 128;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f29695i = 256;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f29696j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f29697k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f29698l = 3;
    private String A;
    private int B;
    private String C;
    private int D;
    private String E;
    private String F;
    private int G;
    private String H;
    private String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f29699J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private com.haier.uhome.search.service.a.a<com.haier.library.sumhttp.response.i> S;
    private String T;
    private String U;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f29700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f29701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f29702o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.h f29703p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f29704q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f29705r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f29706s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f29707t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f29708u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f29709v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f29710w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f29711x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f29712y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f29713z;

    public String A() {
        return this.L;
    }

    public String B() {
        return this.N;
    }

    public String C() {
        return this.O;
    }

    public String D() {
        return this.P;
    }

    public String E() {
        return this.R;
    }

    public String F() {
        return this.T;
    }

    public String G() {
        return this.M;
    }

    public String H() {
        return this.I;
    }

    public String I() {
        return this.U;
    }

    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e8) {
            e3.a.g("Clone configure device info error", e8);
            return null;
        }
    }

    public String a() {
        return this.f29700m;
    }

    public String b() {
        return this.f29701n;
    }

    public int c() {
        return this.f29711x;
    }

    public String d() {
        return this.f29702o;
    }

    public com.haier.uhome.usdk.base.api.h e() {
        return this.f29703p;
    }

    public int f() {
        return this.f29704q;
    }

    public String g() {
        return this.f29705r;
    }

    public boolean h() {
        return this.f29706s;
    }

    public int i() {
        return this.f29707t;
    }

    public int j() {
        return this.f29709v;
    }

    public long k() {
        return this.f29710w;
    }

    public String l() {
        return this.f29712y;
    }

    public int m() {
        return this.f29713z;
    }

    public String n() {
        return this.A;
    }

    public int o() {
        return this.B;
    }

    public String p() {
        return this.C;
    }

    public int q() {
        return this.D;
    }

    public String r() {
        return this.E;
    }

    public String s() {
        return this.F;
    }

    public int t() {
        return this.G;
    }

    public String toString() {
        return "ConfigurableDeviceInfo{mDevId='" + this.f29700m + "', mBleDevId='" + this.f29701n + "', mName='" + this.f29702o + "', mTypeMain=" + this.f29703p + ", mTypeMinor=" + this.f29704q + ", mProductCode='" + this.f29705r + "', isSelfBound=" + this.f29706s + ", mConfigTypeCode=" + this.f29707t + ", allConfigTypes=" + this.f29708u + ", mRssi=" + this.f29709v + ", mUpdateTime=" + this.f29710w + ", configStatus=" + this.f29711x + ", mUplusId='" + this.f29712y + "', mVerificationMethod=" + this.f29713z + ", mOnLineVersion='" + this.A + "', mDevState=" + this.B + ", mIpV4='" + this.C + "', mPortV4=" + this.D + ", protocolVers='" + this.E + "', devUuid='" + this.F + "', channel=" + this.G + ", companyId='" + this.H + "', hotSpotName='" + this.I + "', searchChannel=" + this.f29699J + ", securityVersion='" + this.K + "', protoVer='" + this.L + "', keyVer='" + this.N + "', hwVer='" + this.O + "', hwPlatform='" + this.P + "', modelShortID='" + this.Q + "', appTypeName='" + this.T + "', appTypeCode='" + this.R + "', actuator=" + this.S + ", machineID='" + this.U + "'}";
    }

    public String u() {
        return this.H;
    }

    public int v() {
        return this.f29699J;
    }

    public String w() {
        return this.K;
    }

    public int x() {
        return this.f29708u;
    }

    public String y() {
        return this.Q;
    }

    public com.haier.uhome.search.service.a.a<com.haier.library.sumhttp.response.i> z() {
        return this.S;
    }

    public void a(String str) {
        this.f29700m = str;
    }

    public boolean b(String str) {
        if (a(this.f29701n, str)) {
            return false;
        }
        this.f29701n = str;
        return true;
    }

    public boolean c(String str) {
        if (a(this.f29702o, str)) {
            return false;
        }
        this.f29702o = str;
        return true;
    }

    public boolean d(String str) {
        if (a(this.f29705r, str)) {
            return false;
        }
        this.f29705r = str;
        return true;
    }

    public boolean e(String str) {
        if (a(this.f29712y, str)) {
            return false;
        }
        this.f29712y = str;
        com.haier.uhome.usdk.base.utils.f.a aVarA = com.haier.uhome.usdk.base.utils.f.a(str);
        if (aVarA == null) {
            return true;
        }
        this.f29703p = aVarA.a();
        this.f29704q = aVarA.b();
        return true;
    }

    public boolean f(String str) {
        if (a(this.A, str)) {
            return false;
        }
        this.A = str;
        return true;
    }

    public boolean g(String str) {
        if (a(this.C, str)) {
            return false;
        }
        this.C = str;
        return true;
    }

    public void h(String str) {
        this.E = str;
    }

    public boolean i(String str) {
        if (a(this.F, str)) {
            return false;
        }
        this.F = str;
        return true;
    }

    public void j(String str) {
        this.H = str;
    }

    public void k(String str) {
        this.K = str;
    }

    public void l(String str) {
        this.Q = str;
    }

    public void m(String str) {
        this.L = str;
    }

    public void n(String str) {
        this.N = str;
    }

    public void o(String str) {
        this.O = str;
    }

    public void p(String str) {
        this.P = str;
    }

    public void q(String str) {
        this.R = str;
    }

    public void r(String str) {
        this.T = str;
    }

    public void s(String str) {
        this.M = str;
    }

    public void t(String str) {
        this.I = str;
    }

    public void u(String str) {
        this.U = str;
    }

    public boolean a(int i7) {
        if (!a(Integer.valueOf(this.f29711x), Integer.valueOf(i7))) {
            this.f29711x = i7;
            return true;
        }
        this.f29711x = i7;
        return false;
    }

    public void h(int i7) {
        this.G = i7;
    }

    public boolean j(int i7) {
        if (a(Integer.valueOf(this.f29708u), Integer.valueOf(i7))) {
            return false;
        }
        this.f29708u = i7;
        return true;
    }

    public boolean b(int i7) {
        if (a(Integer.valueOf(this.f29704q), Integer.valueOf(i7))) {
            return false;
        }
        this.f29704q = i7;
        return true;
    }

    public boolean c(int i7) {
        if (a(Integer.valueOf(this.f29707t), Integer.valueOf(i7))) {
            return false;
        }
        this.f29707t = i7;
        return true;
    }

    public void d(int i7) {
        this.f29709v = i7;
    }

    public boolean f(int i7) {
        if (a(Integer.valueOf(this.B), Integer.valueOf(i7))) {
            return false;
        }
        this.B = i7;
        return true;
    }

    public boolean g(int i7) {
        if (a(Integer.valueOf(this.D), Integer.valueOf(i7))) {
            return false;
        }
        this.D = i7;
        return true;
    }

    public void i(int i7) {
        this.f29699J = i7;
    }

    public boolean a(com.haier.uhome.usdk.base.api.h hVar) {
        if (a(this.f29703p, hVar)) {
            return false;
        }
        this.f29703p = hVar;
        return true;
    }

    public boolean e(int i7) {
        if (a(Integer.valueOf(this.f29713z), Integer.valueOf(i7))) {
            return false;
        }
        this.f29713z = i7;
        return true;
    }

    public void a(boolean z7) {
        this.f29706s = z7;
    }

    public void a(long j7) {
        this.f29710w = j7;
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public void a(com.haier.uhome.search.service.a.a<com.haier.library.sumhttp.response.i> aVar) {
        this.S = aVar;
    }
}
