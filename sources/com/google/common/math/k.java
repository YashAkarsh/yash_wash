package com.google.common.math;

import com.google.common.base.e0;
import com.google.common.base.x;
import com.google.common.base.y;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class k implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f22113f = 40;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f22114g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f22115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f22116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f22117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f22118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f22119e;

    k(long j7, double d8, double d9, double d10, double d11) {
        this.f22115a = j7;
        this.f22116b = d8;
        this.f22117c = d9;
        this.f22118d = d10;
        this.f22119e = d11;
    }

    public static k b(byte[] bArr) {
        e0.E(bArr);
        e0.m(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return r(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double e(Iterable<? extends Number> iterable) {
        return f(iterable.iterator());
    }

    public static double f(Iterator<? extends Number> it) {
        e0.d(it.hasNext());
        double dDoubleValue = it.next().doubleValue();
        long j7 = 1;
        while (it.hasNext()) {
            double dDoubleValue2 = it.next().doubleValue();
            j7++;
            dDoubleValue = (com.google.common.primitives.e.n(dDoubleValue2) && com.google.common.primitives.e.n(dDoubleValue)) ? dDoubleValue + ((dDoubleValue2 - dDoubleValue) / j7) : l.h(dDoubleValue, dDoubleValue2);
        }
        return dDoubleValue;
    }

    public static double g(double... dArr) {
        e0.d(dArr.length > 0);
        double dH = dArr[0];
        for (int i7 = 1; i7 < dArr.length; i7++) {
            double d8 = dArr[i7];
            dH = (com.google.common.primitives.e.n(d8) && com.google.common.primitives.e.n(dH)) ? dH + ((d8 - dH) / ((double) (i7 + 1))) : l.h(dH, d8);
        }
        return dH;
    }

    public static double h(int... iArr) {
        e0.d(iArr.length > 0);
        double dH = iArr[0];
        for (int i7 = 1; i7 < iArr.length; i7++) {
            double d8 = iArr[i7];
            dH = (com.google.common.primitives.e.n(d8) && com.google.common.primitives.e.n(dH)) ? dH + ((d8 - dH) / ((double) (i7 + 1))) : l.h(dH, d8);
        }
        return dH;
    }

    public static double i(long... jArr) {
        e0.d(jArr.length > 0);
        double dH = jArr[0];
        for (int i7 = 1; i7 < jArr.length; i7++) {
            double d8 = jArr[i7];
            dH = (com.google.common.primitives.e.n(d8) && com.google.common.primitives.e.n(dH)) ? dH + ((d8 - dH) / ((double) (i7 + 1))) : l.h(dH, d8);
        }
        return dH;
    }

    public static k k(Iterable<? extends Number> iterable) {
        l lVar = new l();
        lVar.c(iterable);
        return lVar.q();
    }

    public static k l(Iterator<? extends Number> it) {
        l lVar = new l();
        lVar.d(it);
        return lVar.q();
    }

    public static k m(double... dArr) {
        l lVar = new l();
        lVar.e(dArr);
        return lVar.q();
    }

    public static k n(int... iArr) {
        l lVar = new l();
        lVar.f(iArr);
        return lVar.q();
    }

    public static k o(long... jArr) {
        l lVar = new l();
        lVar.g(jArr);
        return lVar.q();
    }

    static k r(ByteBuffer byteBuffer) {
        e0.E(byteBuffer);
        e0.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new k(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long a() {
        return this.f22115a;
    }

    public double c() {
        e0.g0(this.f22115a != 0);
        return this.f22119e;
    }

    public double d() {
        e0.g0(this.f22115a != 0);
        return this.f22116b;
    }

    public boolean equals(Object obj) {
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f22115a == kVar.f22115a && Double.doubleToLongBits(this.f22116b) == Double.doubleToLongBits(kVar.f22116b) && Double.doubleToLongBits(this.f22117c) == Double.doubleToLongBits(kVar.f22117c) && Double.doubleToLongBits(this.f22118d) == Double.doubleToLongBits(kVar.f22118d) && Double.doubleToLongBits(this.f22119e) == Double.doubleToLongBits(kVar.f22119e);
    }

    public int hashCode() {
        return y.b(Long.valueOf(this.f22115a), Double.valueOf(this.f22116b), Double.valueOf(this.f22117c), Double.valueOf(this.f22118d), Double.valueOf(this.f22119e));
    }

    public double j() {
        e0.g0(this.f22115a != 0);
        return this.f22118d;
    }

    public double p() {
        return Math.sqrt(q());
    }

    public double q() {
        e0.g0(this.f22115a > 0);
        if (Double.isNaN(this.f22117c)) {
            return Double.NaN;
        }
        if (this.f22115a == 1) {
            return 0.0d;
        }
        return c.b(this.f22117c) / a();
    }

    public double t() {
        return Math.sqrt(u());
    }

    public String toString() {
        return a() > 0 ? x.c(this).e("count", this.f22115a).b("mean", this.f22116b).b("populationStandardDeviation", p()).b("min", this.f22118d).b("max", this.f22119e).toString() : x.c(this).e("count", this.f22115a).toString();
    }

    public double u() {
        e0.g0(this.f22115a > 1);
        if (Double.isNaN(this.f22117c)) {
            return Double.NaN;
        }
        return c.b(this.f22117c) / (this.f22115a - 1);
    }

    public double v() {
        return this.f22116b * this.f22115a;
    }

    double w() {
        return this.f22117c;
    }

    public byte[] x() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        y(byteBufferOrder);
        return byteBufferOrder.array();
    }

    void y(ByteBuffer byteBuffer) {
        e0.E(byteBuffer);
        e0.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.f22115a).putDouble(this.f22116b).putDouble(this.f22117c).putDouble(this.f22118d).putDouble(this.f22119e);
    }
}
