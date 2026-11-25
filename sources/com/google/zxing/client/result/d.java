package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f23404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f23405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f23407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String[] f23408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String[] f23409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String[] f23410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f23411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f23412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String[] f23413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String[] f23414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f23415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f23416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f23417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String[] f23418p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String[] f23419q;

    public d(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.d(this.f23404b, sb);
        q.d(this.f23405c, sb);
        q.c(this.f23406d, sb);
        q.c(this.f23417o, sb);
        q.c(this.f23415m, sb);
        q.d(this.f23413k, sb);
        q.d(this.f23407e, sb);
        q.d(this.f23409g, sb);
        q.c(this.f23411i, sb);
        q.d(this.f23418p, sb);
        q.c(this.f23416n, sb);
        q.d(this.f23419q, sb);
        q.c(this.f23412j, sb);
        return sb.toString();
    }

    public String[] e() {
        return this.f23414l;
    }

    public String[] f() {
        return this.f23413k;
    }

    public String g() {
        return this.f23416n;
    }

    public String[] h() {
        return this.f23410h;
    }

    public String[] i() {
        return this.f23409g;
    }

    public String[] j() {
        return this.f23419q;
    }

    public String k() {
        return this.f23411i;
    }

    public String[] l() {
        return this.f23404b;
    }

    public String[] m() {
        return this.f23405c;
    }

    public String n() {
        return this.f23412j;
    }

    public String o() {
        return this.f23415m;
    }

    public String[] p() {
        return this.f23407e;
    }

    public String[] q() {
        return this.f23408f;
    }

    public String r() {
        return this.f23406d;
    }

    public String s() {
        return this.f23417o;
    }

    public String[] t() {
        return this.f23418p;
    }

    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(r.ADDRESSBOOK);
        if (strArr3 != null && strArr4 != null && strArr3.length != strArr4.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        }
        if (strArr5 != null && strArr6 != null && strArr5.length != strArr6.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        }
        if (strArr7 != null && strArr8 != null && strArr7.length != strArr8.length) {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
        this.f23404b = strArr;
        this.f23405c = strArr2;
        this.f23406d = str;
        this.f23407e = strArr3;
        this.f23408f = strArr4;
        this.f23409g = strArr5;
        this.f23410h = strArr6;
        this.f23411i = str2;
        this.f23412j = str3;
        this.f23413k = strArr7;
        this.f23414l = strArr8;
        this.f23415m = str4;
        this.f23416n = str5;
        this.f23417o = str6;
        this.f23418p = strArr9;
        this.f23419q = strArr10;
    }
}
