package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23400c;

    public b0(String str, String str2) {
        super(r.TEXT);
        this.f23399b = str;
        this.f23400c = str2;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return this.f23399b;
    }

    public String e() {
        return this.f23400c;
    }

    public String f() {
        return this.f23399b;
    }
}
