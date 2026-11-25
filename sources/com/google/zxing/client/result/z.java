package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23522d;

    public z(String str, String str2, String str3) {
        super(r.TEL);
        this.f23520b = str;
        this.f23521c = str2;
        this.f23522d = str3;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        q.c(this.f23520b, sb);
        q.c(this.f23522d, sb);
        return sb.toString();
    }

    public String e() {
        return this.f23520b;
    }

    public String f() {
        return this.f23521c;
    }

    public String g() {
        return this.f23522d;
    }
}
