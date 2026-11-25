package com.google.zxing.client.result;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends q {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f23472q = "KG";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f23473r = "LB";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f23479g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f23480h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f23481i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f23482j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f23483k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f23484l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f23485m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f23486n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f23487o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Map<String, String> f23488p;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(r.PRODUCT);
        this.f23474b = str;
        this.f23475c = str2;
        this.f23476d = str3;
        this.f23477e = str4;
        this.f23478f = str5;
        this.f23479g = str6;
        this.f23480h = str7;
        this.f23481i = str8;
        this.f23482j = str9;
        this.f23483k = str10;
        this.f23484l = str11;
        this.f23485m = str12;
        this.f23486n = str13;
        this.f23487o = str14;
        this.f23488p = map;
    }

    private static boolean e(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int u(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return String.valueOf(this.f23474b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return e(this.f23475c, kVar.f23475c) && e(this.f23476d, kVar.f23476d) && e(this.f23477e, kVar.f23477e) && e(this.f23478f, kVar.f23478f) && e(this.f23480h, kVar.f23480h) && e(this.f23481i, kVar.f23481i) && e(this.f23482j, kVar.f23482j) && e(this.f23483k, kVar.f23483k) && e(this.f23484l, kVar.f23484l) && e(this.f23485m, kVar.f23485m) && e(this.f23486n, kVar.f23486n) && e(this.f23487o, kVar.f23487o) && e(this.f23488p, kVar.f23488p);
    }

    public String f() {
        return this.f23480h;
    }

    public String g() {
        return this.f23481i;
    }

    public String h() {
        return this.f23477e;
    }

    public int hashCode() {
        return ((((((((((((u(this.f23475c) ^ 0) ^ u(this.f23476d)) ^ u(this.f23477e)) ^ u(this.f23478f)) ^ u(this.f23480h)) ^ u(this.f23481i)) ^ u(this.f23482j)) ^ u(this.f23483k)) ^ u(this.f23484l)) ^ u(this.f23485m)) ^ u(this.f23486n)) ^ u(this.f23487o)) ^ u(this.f23488p);
    }

    public String i() {
        return this.f23479g;
    }

    public String j() {
        return this.f23485m;
    }

    public String k() {
        return this.f23487o;
    }

    public String l() {
        return this.f23486n;
    }

    public String m() {
        return this.f23475c;
    }

    public String n() {
        return this.f23478f;
    }

    public String o() {
        return this.f23474b;
    }

    public String p() {
        return this.f23476d;
    }

    public Map<String, String> q() {
        return this.f23488p;
    }

    public String r() {
        return this.f23482j;
    }

    public String s() {
        return this.f23484l;
    }

    public String t() {
        return this.f23483k;
    }
}
