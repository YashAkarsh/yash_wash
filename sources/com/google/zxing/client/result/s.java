package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23510c;

    s(String str) {
        this(str, str);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return this.f23509b;
    }

    public String e() {
        return this.f23510c;
    }

    public String f() {
        return this.f23509b;
    }

    s(String str, String str2) {
        super(r.PRODUCT);
        this.f23509b = str;
        this.f23510c = str2;
    }
}
