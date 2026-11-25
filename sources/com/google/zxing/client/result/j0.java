package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f23467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f23469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f23470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f23471i;

    public j0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        q.c(this.f23464b, sb);
        q.c(this.f23465c, sb);
        q.c(this.f23466d, sb);
        q.c(Boolean.toString(this.f23467e), sb);
        return sb.toString();
    }

    public String e() {
        return this.f23469g;
    }

    public String f() {
        return this.f23470h;
    }

    public String g() {
        return this.f23468f;
    }

    public String h() {
        return this.f23465c;
    }

    public String i() {
        return this.f23466d;
    }

    public String j() {
        return this.f23471i;
    }

    public String k() {
        return this.f23464b;
    }

    public boolean l() {
        return this.f23467e;
    }

    public j0(String str, String str2, String str3, boolean z7) {
        this(str, str2, str3, z7, null, null, null, null);
    }

    public j0(String str, String str2, String str3, boolean z7, String str4, String str5, String str6, String str7) {
        super(r.WIFI);
        this.f23464b = str2;
        this.f23465c = str;
        this.f23466d = str3;
        this.f23467e = z7;
        this.f23468f = str4;
        this.f23469g = str5;
        this.f23470h = str6;
        this.f23471i = str7;
    }
}
