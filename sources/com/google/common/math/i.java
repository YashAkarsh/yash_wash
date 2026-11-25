package com.google.common.math;

import com.google.common.base.e0;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f22105a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f22106b = new l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f22107c = 0.0d;

    private static double d(double d8) {
        if (d8 >= 1.0d) {
            return 1.0d;
        }
        if (d8 <= -1.0d) {
            return -1.0d;
        }
        return d8;
    }

    private double e(double d8) {
        if (d8 > 0.0d) {
            return d8;
        }
        return Double.MIN_VALUE;
    }

    public void a(double d8, double d9) {
        this.f22105a.a(d8);
        if (!com.google.common.primitives.e.n(d8) || !com.google.common.primitives.e.n(d9)) {
            this.f22107c = Double.NaN;
        } else if (this.f22105a.i() > 1) {
            this.f22107c += (d8 - this.f22105a.k()) * (d9 - this.f22106b.k());
        }
        this.f22106b.a(d9);
    }

    public void b(h hVar) {
        if (hVar.a() == 0) {
            return;
        }
        this.f22105a.b(hVar.k());
        if (this.f22106b.i() == 0) {
            this.f22107c = hVar.i();
        } else {
            this.f22107c += hVar.i() + ((hVar.k().d() - this.f22105a.k()) * (hVar.l().d() - this.f22106b.k()) * hVar.a());
        }
        this.f22106b.b(hVar.l());
    }

    public long c() {
        return this.f22105a.i();
    }

    public final e f() {
        e0.g0(c() > 1);
        if (Double.isNaN(this.f22107c)) {
            return e.a();
        }
        double dS = this.f22105a.s();
        if (dS > 0.0d) {
            return this.f22106b.s() > 0.0d ? e.f(this.f22105a.k(), this.f22106b.k()).b(this.f22107c / dS) : e.b(this.f22106b.k());
        }
        e0.g0(this.f22106b.s() > 0.0d);
        return e.i(this.f22105a.k());
    }

    public final double g() {
        e0.g0(c() > 1);
        if (Double.isNaN(this.f22107c)) {
            return Double.NaN;
        }
        double dS = this.f22105a.s();
        double dS2 = this.f22106b.s();
        e0.g0(dS > 0.0d);
        e0.g0(dS2 > 0.0d);
        return d(this.f22107c / Math.sqrt(e(dS * dS2)));
    }

    public double h() {
        e0.g0(c() != 0);
        return this.f22107c / c();
    }

    public final double i() {
        e0.g0(c() > 1);
        return this.f22107c / (c() - 1);
    }

    public h j() {
        return new h(this.f22105a.q(), this.f22106b.q(), this.f22107c);
    }

    public k k() {
        return this.f22105a.q();
    }

    public k l() {
        return this.f22106b.q();
    }
}
