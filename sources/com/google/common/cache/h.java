package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f19680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19683f;

    public h(long j7, long j8, long j9, long j10, long j11, long j12) {
        com.google.common.base.e0.d(j7 >= 0);
        com.google.common.base.e0.d(j8 >= 0);
        com.google.common.base.e0.d(j9 >= 0);
        com.google.common.base.e0.d(j10 >= 0);
        com.google.common.base.e0.d(j11 >= 0);
        com.google.common.base.e0.d(j12 >= 0);
        this.f19678a = j7;
        this.f19679b = j8;
        this.f19680c = j9;
        this.f19681d = j10;
        this.f19682e = j11;
        this.f19683f = j12;
    }

    public double a() {
        long j7 = this.f19680c + this.f19681d;
        if (j7 == 0) {
            return 0.0d;
        }
        return this.f19682e / j7;
    }

    public long b() {
        return this.f19683f;
    }

    public long c() {
        return this.f19678a;
    }

    public double d() {
        long jM = m();
        if (jM == 0) {
            return 1.0d;
        }
        return this.f19678a / jM;
    }

    public long e() {
        return this.f19680c + this.f19681d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f19678a == hVar.f19678a && this.f19679b == hVar.f19679b && this.f19680c == hVar.f19680c && this.f19681d == hVar.f19681d && this.f19682e == hVar.f19682e && this.f19683f == hVar.f19683f;
    }

    public long f() {
        return this.f19681d;
    }

    public double g() {
        long j7 = this.f19680c;
        long j8 = this.f19681d;
        long j9 = j7 + j8;
        if (j9 == 0) {
            return 0.0d;
        }
        return j8 / j9;
    }

    public long h() {
        return this.f19680c;
    }

    public int hashCode() {
        return com.google.common.base.y.b(Long.valueOf(this.f19678a), Long.valueOf(this.f19679b), Long.valueOf(this.f19680c), Long.valueOf(this.f19681d), Long.valueOf(this.f19682e), Long.valueOf(this.f19683f));
    }

    public h i(h hVar) {
        return new h(Math.max(0L, this.f19678a - hVar.f19678a), Math.max(0L, this.f19679b - hVar.f19679b), Math.max(0L, this.f19680c - hVar.f19680c), Math.max(0L, this.f19681d - hVar.f19681d), Math.max(0L, this.f19682e - hVar.f19682e), Math.max(0L, this.f19683f - hVar.f19683f));
    }

    public long j() {
        return this.f19679b;
    }

    public double k() {
        long jM = m();
        if (jM == 0) {
            return 0.0d;
        }
        return this.f19679b / jM;
    }

    public h l(h hVar) {
        return new h(this.f19678a + hVar.f19678a, this.f19679b + hVar.f19679b, this.f19680c + hVar.f19680c, this.f19681d + hVar.f19681d, this.f19682e + hVar.f19682e, this.f19683f + hVar.f19683f);
    }

    public long m() {
        return this.f19678a + this.f19679b;
    }

    public long n() {
        return this.f19682e;
    }

    public String toString() {
        return com.google.common.base.x.c(this).e("hitCount", this.f19678a).e("missCount", this.f19679b).e("loadSuccessCount", this.f19680c).e("loadExceptionCount", this.f19681d).e("totalLoadTime", this.f19682e).e("evictionCount", this.f19683f).toString();
    }
}
