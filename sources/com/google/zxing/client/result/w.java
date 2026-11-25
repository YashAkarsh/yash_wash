package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f23516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f23517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23519e;

    public w(String str, String str2, String str3, String str4) {
        super(r.SMS);
        this.f23516b = new String[]{str};
        this.f23517c = new String[]{str2};
        this.f23518d = str3;
        this.f23519e = str4;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.d(this.f23516b, sb);
        q.c(this.f23518d, sb);
        q.c(this.f23519e, sb);
        return sb.toString();
    }

    public String e() {
        return this.f23519e;
    }

    public String[] f() {
        return this.f23516b;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("sms:");
        boolean z7 = true;
        for (int i7 = 0; i7 < this.f23516b.length; i7++) {
            if (z7) {
                z7 = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f23516b[i7]);
            String[] strArr = this.f23517c;
            if (strArr != null && strArr[i7] != null) {
                sb.append(";via=");
                sb.append(this.f23517c[i7]);
            }
        }
        boolean z8 = this.f23519e != null;
        boolean z9 = this.f23518d != null;
        if (z8 || z9) {
            sb.append('?');
            if (z8) {
                sb.append("body=");
                sb.append(this.f23519e);
            }
            if (z9) {
                if (z8) {
                    sb.append(kotlin.text.h0.f35378d);
                }
                sb.append("subject=");
                sb.append(this.f23518d);
            }
        }
        return sb.toString();
    }

    public String h() {
        return this.f23518d;
    }

    public String[] i() {
        return this.f23517c;
    }

    public w(String[] strArr, String[] strArr2, String str, String str2) {
        super(r.SMS);
        this.f23516b = strArr;
        this.f23517c = strArr2;
        this.f23518d = str;
        this.f23519e = str2;
    }
}
