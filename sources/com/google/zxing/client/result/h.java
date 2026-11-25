package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f23446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f23447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f23448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f23450f;

    h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.d(this.f23446b, sb);
        q.d(this.f23447c, sb);
        q.d(this.f23448d, sb);
        q.c(this.f23449e, sb);
        q.c(this.f23450f, sb);
        return sb.toString();
    }

    public String[] e() {
        return this.f23448d;
    }

    public String f() {
        return this.f23450f;
    }

    public String[] g() {
        return this.f23447c;
    }

    @Deprecated
    public String h() {
        String[] strArr = this.f23446b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String i() {
        return androidx.core.net.d.f6068b;
    }

    public String j() {
        return this.f23449e;
    }

    public String[] k() {
        return this.f23446b;
    }

    h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(r.EMAIL_ADDRESS);
        this.f23446b = strArr;
        this.f23447c = strArr2;
        this.f23448d = strArr3;
        this.f23449e = str;
        this.f23450f = str2;
    }
}
