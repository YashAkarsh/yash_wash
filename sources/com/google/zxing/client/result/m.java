package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f23489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f23490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f23491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f23492e;

    m(double d8, double d9, double d10, String str) {
        super(r.GEO);
        this.f23489b = d8;
        this.f23490c = d9;
        this.f23491d = d10;
        this.f23492e = str;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f23489b);
        sb.append(", ");
        sb.append(this.f23490c);
        if (this.f23491d > 0.0d) {
            sb.append(", ");
            sb.append(this.f23491d);
            sb.append('m');
        }
        if (this.f23492e != null) {
            sb.append(" (");
            sb.append(this.f23492e);
            sb.append(')');
        }
        return sb.toString();
    }

    public double e() {
        return this.f23491d;
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.f23489b);
        sb.append(',');
        sb.append(this.f23490c);
        if (this.f23491d > 0.0d) {
            sb.append(',');
            sb.append(this.f23491d);
        }
        if (this.f23492e != null) {
            sb.append('?');
            sb.append(this.f23492e);
        }
        return sb.toString();
    }

    public double g() {
        return this.f23489b;
    }

    public double h() {
        return this.f23490c;
    }

    public String i() {
        return this.f23492e;
    }
}
