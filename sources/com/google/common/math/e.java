package com.google.common.math;

import com.google.common.base.e0;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public abstract class e {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f22077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final double f22078b;

        public e a(double d8, double d9) {
            e0.d(com.google.common.math.c.d(d8) && com.google.common.math.c.d(d9));
            double d10 = this.f22077a;
            if (d8 != d10) {
                return b((d9 - this.f22078b) / (d8 - d10));
            }
            e0.d(d9 != this.f22078b);
            return new C0282e(this.f22077a);
        }

        public e b(double d8) {
            e0.d(!Double.isNaN(d8));
            return com.google.common.math.c.d(d8) ? new d(d8, this.f22078b - (this.f22077a * d8)) : new C0282e(this.f22077a);
        }

        private b(double d8, double d9) {
            this.f22077a = d8;
            this.f22078b = d9;
        }
    }

    private static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f22079a = new c();

        private c() {
        }

        @Override // com.google.common.math.e
        public e c() {
            return this;
        }

        @Override // com.google.common.math.e
        public boolean d() {
            return false;
        }

        @Override // com.google.common.math.e
        public boolean e() {
            return false;
        }

        @Override // com.google.common.math.e
        public double g() {
            return Double.NaN;
        }

        @Override // com.google.common.math.e
        public double h(double d8) {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }
    }

    public static e a() {
        return c.f22079a;
    }

    public static e b(double d8) {
        e0.d(com.google.common.math.c.d(d8));
        return new d(0.0d, d8);
    }

    public static b f(double d8, double d9) {
        e0.d(com.google.common.math.c.d(d8) && com.google.common.math.c.d(d9));
        return new b(d8, d9);
    }

    public static e i(double d8) {
        e0.d(com.google.common.math.c.d(d8));
        return new C0282e(d8);
    }

    public abstract e c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract double g();

    public abstract double h(double d8);

    /* JADX INFO: renamed from: com.google.common.math.e$e, reason: collision with other inner class name */
    private static final class C0282e extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double f22083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @v1.b
        e f22084b;

        C0282e(double d8) {
            this.f22083a = d8;
            this.f22084b = null;
        }

        private e j() {
            return new d(0.0d, this.f22083a, this);
        }

        @Override // com.google.common.math.e
        public e c() {
            e eVar = this.f22084b;
            if (eVar != null) {
                return eVar;
            }
            e eVarJ = j();
            this.f22084b = eVarJ;
            return eVarJ;
        }

        @Override // com.google.common.math.e
        public boolean d() {
            return false;
        }

        @Override // com.google.common.math.e
        public boolean e() {
            return true;
        }

        @Override // com.google.common.math.e
        public double g() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.math.e
        public double h(double d8) {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f22083a));
        }

        C0282e(double d8, e eVar) {
            this.f22083a = d8;
            this.f22084b = eVar;
        }
    }

    private static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double f22080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final double f22081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @v1.b
        e f22082c;

        d(double d8, double d9) {
            this.f22080a = d8;
            this.f22081b = d9;
            this.f22082c = null;
        }

        private e j() {
            double d8 = this.f22080a;
            return d8 != 0.0d ? new d(1.0d / d8, (this.f22081b * (-1.0d)) / d8, this) : new C0282e(this.f22081b, this);
        }

        @Override // com.google.common.math.e
        public e c() {
            e eVar = this.f22082c;
            if (eVar != null) {
                return eVar;
            }
            e eVarJ = j();
            this.f22082c = eVarJ;
            return eVarJ;
        }

        @Override // com.google.common.math.e
        public boolean d() {
            return this.f22080a == 0.0d;
        }

        @Override // com.google.common.math.e
        public boolean e() {
            return false;
        }

        @Override // com.google.common.math.e
        public double g() {
            return this.f22080a;
        }

        @Override // com.google.common.math.e
        public double h(double d8) {
            return (d8 * this.f22080a) + this.f22081b;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f22080a), Double.valueOf(this.f22081b));
        }

        d(double d8, double d9, e eVar) {
            this.f22080a = d8;
            this.f22081b = d9;
            this.f22082c = eVar;
        }
    }
}
