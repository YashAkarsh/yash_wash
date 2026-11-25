package com.google.common.math;

import com.google.common.base.e0;
import com.google.common.base.x;
import com.google.common.base.y;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class h implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f22100d = 88;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f22101e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f22102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f22103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f22104c;

    h(k kVar, k kVar2, double d8) {
        this.f22102a = kVar;
        this.f22103b = kVar2;
        this.f22104c = d8;
    }

    private static double b(double d8) {
        if (d8 >= 1.0d) {
            return 1.0d;
        }
        if (d8 <= -1.0d) {
            return -1.0d;
        }
        return d8;
    }

    private static double c(double d8) {
        if (d8 > 0.0d) {
            return d8;
        }
        return Double.MIN_VALUE;
    }

    public static h d(byte[] bArr) {
        e0.E(bArr);
        e0.m(bArr.length == f22100d, "Expected PairedStats.BYTES = %s, got %s", f22100d, bArr.length);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new h(k.r(byteBufferOrder), k.r(byteBufferOrder), byteBufferOrder.getDouble());
    }

    public long a() {
        return this.f22102a.a();
    }

    public e e() {
        e0.g0(a() > 1);
        if (Double.isNaN(this.f22104c)) {
            return e.a();
        }
        double dW = this.f22102a.w();
        if (dW > 0.0d) {
            return this.f22103b.w() > 0.0d ? e.f(this.f22102a.d(), this.f22103b.d()).b(this.f22104c / dW) : e.b(this.f22103b.d());
        }
        e0.g0(this.f22103b.w() > 0.0d);
        return e.i(this.f22102a.d());
    }

    public boolean equals(Object obj) {
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f22102a.equals(hVar.f22102a) && this.f22103b.equals(hVar.f22103b) && Double.doubleToLongBits(this.f22104c) == Double.doubleToLongBits(hVar.f22104c);
    }

    public double f() {
        e0.g0(a() > 1);
        if (Double.isNaN(this.f22104c)) {
            return Double.NaN;
        }
        double dW = k().w();
        double dW2 = l().w();
        e0.g0(dW > 0.0d);
        e0.g0(dW2 > 0.0d);
        return b(this.f22104c / Math.sqrt(c(dW * dW2)));
    }

    public double g() {
        e0.g0(a() != 0);
        return this.f22104c / a();
    }

    public double h() {
        e0.g0(a() > 1);
        return this.f22104c / (a() - 1);
    }

    public int hashCode() {
        return y.b(this.f22102a, this.f22103b, Double.valueOf(this.f22104c));
    }

    double i() {
        return this.f22104c;
    }

    public byte[] j() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(f22100d).order(ByteOrder.LITTLE_ENDIAN);
        this.f22102a.y(byteBufferOrder);
        this.f22103b.y(byteBufferOrder);
        byteBufferOrder.putDouble(this.f22104c);
        return byteBufferOrder.array();
    }

    public k k() {
        return this.f22102a;
    }

    public k l() {
        return this.f22103b;
    }

    public String toString() {
        return a() > 0 ? x.c(this).f("xStats", this.f22102a).f("yStats", this.f22103b).b("populationCovariance", g()).toString() : x.c(this).f("xStats", this.f22102a).f("yStats", this.f22103b).toString();
    }
}
