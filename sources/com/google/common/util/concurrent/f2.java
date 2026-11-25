package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
abstract class f2 extends y1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    double f22669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    double f22670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f22671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f22672f;

    static final class b extends f2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final double f22673g;

        b(y1.a aVar, double d8) {
            super(aVar);
            this.f22673g = d8;
        }

        @Override // com.google.common.util.concurrent.f2
        double v() {
            return this.f22671e;
        }

        @Override // com.google.common.util.concurrent.f2
        void w(double d8, double d9) {
            double d10 = this.f22670d;
            double d11 = this.f22673g * d8;
            this.f22670d = d11;
            if (d10 == Double.POSITIVE_INFINITY) {
                this.f22669c = d11;
            } else {
                this.f22669c = d10 != 0.0d ? (this.f22669c * d11) / d10 : 0.0d;
            }
        }

        @Override // com.google.common.util.concurrent.f2
        long y(double d8, double d9) {
            return 0L;
        }
    }

    static final class c extends f2 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f22674g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private double f22675h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private double f22676i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private double f22677j;

        c(y1.a aVar, long j7, TimeUnit timeUnit, double d8) {
            super(aVar);
            this.f22674g = timeUnit.toMicros(j7);
            this.f22677j = d8;
        }

        private double z(double d8) {
            return this.f22671e + (d8 * this.f22675h);
        }

        @Override // com.google.common.util.concurrent.f2
        double v() {
            return this.f22674g / this.f22670d;
        }

        @Override // com.google.common.util.concurrent.f2
        void w(double d8, double d9) {
            double d10 = this.f22670d;
            double d11 = this.f22677j * d9;
            long j7 = this.f22674g;
            double d12 = (j7 * 0.5d) / d9;
            this.f22676i = d12;
            double d13 = ((j7 * 2.0d) / (d9 + d11)) + d12;
            this.f22670d = d13;
            this.f22675h = (d11 - d9) / (d13 - d12);
            if (d10 == Double.POSITIVE_INFINITY) {
                this.f22669c = 0.0d;
                return;
            }
            if (d10 != 0.0d) {
                d13 = (this.f22669c * d13) / d10;
            }
            this.f22669c = d13;
        }

        @Override // com.google.common.util.concurrent.f2
        long y(double d8, double d9) {
            long jZ;
            double d10 = d8 - this.f22676i;
            if (d10 > 0.0d) {
                double dMin = Math.min(d10, d9);
                jZ = (long) (((z(d10) + z(d10 - dMin)) * dMin) / 2.0d);
                d9 -= dMin;
            } else {
                jZ = 0;
            }
            return jZ + ((long) (this.f22671e * d9));
        }
    }

    @Override // com.google.common.util.concurrent.y1
    final double i() {
        return TimeUnit.SECONDS.toMicros(1L) / this.f22671e;
    }

    @Override // com.google.common.util.concurrent.y1
    final void j(double d8, long j7) {
        x(j7);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d8;
        this.f22671e = micros;
        w(d8, micros);
    }

    @Override // com.google.common.util.concurrent.y1
    final long m(long j7) {
        return this.f22672f;
    }

    @Override // com.google.common.util.concurrent.y1
    final long p(int i7, long j7) {
        x(j7);
        long j8 = this.f22672f;
        double d8 = i7;
        double dMin = Math.min(d8, this.f22669c);
        this.f22672f = com.google.common.math.f.w(this.f22672f, y(this.f22669c, dMin) + ((long) ((d8 - dMin) * this.f22671e)));
        this.f22669c -= dMin;
        return j8;
    }

    abstract double v();

    abstract void w(double d8, double d9);

    void x(long j7) {
        long j8 = this.f22672f;
        if (j7 > j8) {
            this.f22669c = Math.min(this.f22670d, this.f22669c + ((j7 - j8) / v()));
            this.f22672f = j7;
        }
    }

    abstract long y(double d8, double d9);

    private f2(y1.a aVar) {
        super(aVar);
        this.f22672f = 0L;
    }
}
