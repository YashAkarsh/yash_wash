package com.google.common.math;

import com.google.common.base.e0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22120a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f22121b = 0.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f22122c = 0.0d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f22123d = Double.NaN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f22124e = Double.NaN;

    static double h(double d8, double d9) {
        if (com.google.common.primitives.e.n(d8)) {
            return d9;
        }
        if (com.google.common.primitives.e.n(d9) || d8 == d9) {
            return d8;
        }
        return Double.NaN;
    }

    public void a(double d8) {
        long j7 = this.f22120a;
        if (j7 == 0) {
            this.f22120a = 1L;
            this.f22121b = d8;
            this.f22123d = d8;
            this.f22124e = d8;
            if (com.google.common.primitives.e.n(d8)) {
                return;
            }
            this.f22122c = Double.NaN;
            return;
        }
        this.f22120a = j7 + 1;
        if (com.google.common.primitives.e.n(d8) && com.google.common.primitives.e.n(this.f22121b)) {
            double d9 = this.f22121b;
            double d10 = d8 - d9;
            double d11 = d9 + (d10 / this.f22120a);
            this.f22121b = d11;
            this.f22122c += d10 * (d8 - d11);
        } else {
            this.f22121b = h(this.f22121b, d8);
            this.f22122c = Double.NaN;
        }
        this.f22123d = Math.min(this.f22123d, d8);
        this.f22124e = Math.max(this.f22124e, d8);
    }

    public void b(k kVar) {
        if (kVar.a() == 0) {
            return;
        }
        long j7 = this.f22120a;
        if (j7 == 0) {
            this.f22120a = kVar.a();
            this.f22121b = kVar.d();
            this.f22122c = kVar.w();
            this.f22123d = kVar.j();
            this.f22124e = kVar.c();
            return;
        }
        this.f22120a = j7 + kVar.a();
        if (com.google.common.primitives.e.n(this.f22121b) && com.google.common.primitives.e.n(kVar.d())) {
            double d8 = kVar.d();
            double d9 = this.f22121b;
            double d10 = d8 - d9;
            this.f22121b = d9 + ((kVar.a() * d10) / this.f22120a);
            this.f22122c += kVar.w() + (d10 * (kVar.d() - this.f22121b) * kVar.a());
        } else {
            this.f22121b = h(this.f22121b, kVar.d());
            this.f22122c = Double.NaN;
        }
        this.f22123d = Math.min(this.f22123d, kVar.j());
        this.f22124e = Math.max(this.f22124e, kVar.c());
    }

    public void c(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void d(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void e(double... dArr) {
        for (double d8 : dArr) {
            a(d8);
        }
    }

    public void f(int... iArr) {
        for (int i7 : iArr) {
            a(i7);
        }
    }

    public void g(long... jArr) {
        for (long j7 : jArr) {
            a(j7);
        }
    }

    public long i() {
        return this.f22120a;
    }

    public double j() {
        e0.g0(this.f22120a != 0);
        return this.f22124e;
    }

    public double k() {
        e0.g0(this.f22120a != 0);
        return this.f22121b;
    }

    public double l() {
        e0.g0(this.f22120a != 0);
        return this.f22123d;
    }

    public final double m() {
        return Math.sqrt(n());
    }

    public final double n() {
        e0.g0(this.f22120a != 0);
        if (Double.isNaN(this.f22122c)) {
            return Double.NaN;
        }
        if (this.f22120a == 1) {
            return 0.0d;
        }
        return c.b(this.f22122c) / this.f22120a;
    }

    public final double o() {
        return Math.sqrt(p());
    }

    public final double p() {
        e0.g0(this.f22120a > 1);
        if (Double.isNaN(this.f22122c)) {
            return Double.NaN;
        }
        return c.b(this.f22122c) / (this.f22120a - 1);
    }

    public k q() {
        return new k(this.f22120a, this.f22121b, this.f22122c, this.f22123d, this.f22124e);
    }

    public final double r() {
        return this.f22121b * this.f22120a;
    }

    double s() {
        return this.f22122c;
    }
}
