package com.haier.uhome.search.service.entity;

import com.haier.uhome.search.json.notify.UnconnectedDevInfo;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f29856a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29857b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f29858c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29859d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f29860e = 5;
    private int A;
    private int B;
    private String C;
    private int D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f29861J;
    private String K;
    private String L;
    private int M;
    private String N;
    private String O;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f29865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f29866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f29867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f29868l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f29869m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f29870n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f29871o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f29872p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f29873q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f29874r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f29875s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f29876t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f29877u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f29878v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f29879w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f29880x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f29881y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f29882z;

    public String A() {
        return this.F;
    }

    public String B() {
        return this.G;
    }

    public String C() {
        return this.H;
    }

    public int D() {
        try {
            return Integer.valueOf(this.H).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public String E() {
        return this.I;
    }

    public String F() {
        return this.f29861J;
    }

    public String G() {
        return this.K;
    }

    public String H() {
        return this.L;
    }

    public int I() {
        return this.M;
    }

    public String J() {
        return this.N;
    }

    public String K() {
        return this.O;
    }

    public String a() {
        return this.f29862f;
    }

    public String b() {
        return this.f29863g;
    }

    public String c() {
        return this.f29864h;
    }

    public int d() {
        return this.f29865i;
    }

    public int e() {
        return this.f29866j;
    }

    public String f() {
        return this.f29867k;
    }

    public int g() {
        return this.f29868l;
    }

    public int h() {
        return this.f29869m;
    }

    public int i() {
        return this.f29870n;
    }

    public String j() {
        return this.f29871o;
    }

    public String k() {
        return this.f29872p;
    }

    public int l() {
        return this.f29873q;
    }

    public String m() {
        return this.f29874r;
    }

    public String n() {
        return this.f29875s;
    }

    public int o() {
        return this.f29876t;
    }

    public String p() {
        return this.f29877u;
    }

    public String q() {
        return this.f29878v;
    }

    public int r() {
        return this.f29879w;
    }

    public int s() {
        return this.f29880x;
    }

    public int t() {
        return this.f29881y;
    }

    public String toString() {
        return "ConfigDevInfoDto{devId='" + this.f29862f + "', bleDevId='" + this.f29863g + "', name='" + this.f29864h + "', typeMain=" + this.f29865i + ", typeMinor=" + this.f29866j + ", productCode='" + this.f29867k + "', accessoryWifi=" + this.f29868l + ", rssi=" + this.f29869m + ", configStatus=" + this.f29870n + ", protocolVers='" + this.f29871o + "', wifiMac='" + this.f29872p + "', configType=" + this.f29873q + ", uplusId='" + this.f29874r + "', companyId='" + this.f29875s + "', channel=" + this.f29876t + ", hotSpotName='" + this.f29877u + "', devAp='" + this.f29878v + "', configMode=" + this.f29879w + ", configState=" + this.f29880x + ", searchType=" + this.f29881y + ", ipV4='" + this.f29882z + "', portV4=" + this.A + ", verificationMethod=" + this.B + ", onLineVersion='" + this.C + "', devState=" + this.D + ", devUuid='" + this.E + "', securityVersion='" + this.F + "', protoVer='" + this.G + "', configVer='" + this.H + "', keyVer='" + this.I + "', hwPlatform='" + this.f29861J + "', hwVer='" + this.K + "', modelShortID='" + this.L + "', allConfigTypes=" + this.M + ", appTypeName='" + this.N + "', machineID='" + this.O + "'}";
    }

    public String u() {
        return this.f29882z;
    }

    public int v() {
        return this.A;
    }

    public int w() {
        return this.B;
    }

    public String x() {
        return this.C;
    }

    public int y() {
        return this.D;
    }

    public String z() {
        return this.E;
    }

    public void a(String str) {
        this.f29862f = str;
    }

    public void b(String str) {
        this.f29863g = str;
    }

    public void c(String str) {
        this.f29864h = str;
    }

    public void d(String str) {
        this.f29867k = str;
    }

    public void e(int i7) {
        this.f29870n = i7;
    }

    public void f(String str) {
        this.f29872p = str;
    }

    public void g(String str) {
        this.f29874r = str;
    }

    public void h(String str) {
        this.f29875s = str;
    }

    public void i(String str) {
        this.f29877u = str;
    }

    public void j(String str) {
        this.f29878v = str;
    }

    public void k(String str) {
        this.f29882z = str;
    }

    public void l(int i7) {
        this.B = i7;
    }

    public void m(int i7) {
        this.D = i7;
    }

    public void n(String str) {
        this.F = str;
    }

    public void o(String str) {
        this.G = str;
    }

    public void p(String str) {
        this.H = str;
    }

    public void q(String str) {
        this.I = str;
    }

    public void r(String str) {
        this.f29861J = str;
    }

    public void s(String str) {
        this.K = str;
    }

    public void t(String str) {
        this.L = str;
    }

    public void u(String str) {
        this.N = str;
    }

    public void v(String str) {
        this.O = str;
    }

    public void a(int i7) {
        this.f29865i = i7;
    }

    public void b(int i7) {
        this.f29866j = i7;
    }

    public void c(int i7) {
        this.f29868l = i7;
    }

    public void d(int i7) {
        this.f29869m = i7;
    }

    public void e(String str) {
        this.f29871o = str;
    }

    public void f(int i7) {
        this.f29873q = i7;
    }

    public void g(int i7) {
        this.f29876t = i7;
    }

    public void h(int i7) {
        this.f29879w = i7;
    }

    public void i(int i7) {
        this.f29880x = i7;
    }

    public void j(int i7) {
        this.f29881y = i7;
    }

    public void k(int i7) {
        this.A = i7;
    }

    public void l(String str) {
        this.C = str;
    }

    public void m(String str) {
        this.E = str;
    }

    public void n(int i7) {
        this.M = i7;
    }

    public static b a(UnconnectedDevInfo unconnectedDevInfo) {
        b bVar = new b();
        bVar.f(unconnectedDevInfo.getMac());
        bVar.j(unconnectedDevInfo.getDevAp());
        if (com.haier.library.common.util.c.l(unconnectedDevInfo.getSsid())) {
            bVar.i(unconnectedDevInfo.getSsid());
        } else {
            bVar.i(unconnectedDevInfo.getSoftApSSID());
        }
        bVar.h(unconnectedDevInfo.getConfigMode());
        bVar.i(unconnectedDevInfo.getConfigState());
        bVar.d(unconnectedDevInfo.getProductCode());
        bVar.j(3);
        return bVar;
    }

    public static b a(c cVar) {
        b bVar = new b();
        bVar.c(cVar.c());
        bVar.a(cVar.d());
        bVar.v(cVar.d());
        bVar.b(cVar.e());
        bVar.h(cVar.b());
        bVar.e(cVar.g());
        bVar.j(1);
        return bVar;
    }
}
