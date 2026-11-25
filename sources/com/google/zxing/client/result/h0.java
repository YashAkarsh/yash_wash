package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f23456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f23457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final char f23458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f23459j;

    public h0(String str, String str2, String str3, String str4, String str5, String str6, int i7, char c8, String str7) {
        super(r.VIN);
        this.f23451b = str;
        this.f23452c = str2;
        this.f23453d = str3;
        this.f23454e = str4;
        this.f23455f = str5;
        this.f23456g = str6;
        this.f23457h = i7;
        this.f23458i = c8;
        this.f23459j = str7;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f23452c);
        sb.append(' ');
        sb.append(this.f23453d);
        sb.append(' ');
        sb.append(this.f23454e);
        sb.append('\n');
        String str = this.f23455f;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f23457h);
        sb.append(' ');
        sb.append(this.f23458i);
        sb.append(' ');
        sb.append(this.f23459j);
        sb.append('\n');
        return sb.toString();
    }

    public String e() {
        return this.f23455f;
    }

    public int f() {
        return this.f23457h;
    }

    public char g() {
        return this.f23458i;
    }

    public String h() {
        return this.f23459j;
    }

    public String i() {
        return this.f23451b;
    }

    public String j() {
        return this.f23456g;
    }

    public String k() {
        return this.f23453d;
    }

    public String l() {
        return this.f23454e;
    }

    public String m() {
        return this.f23452c;
    }
}
