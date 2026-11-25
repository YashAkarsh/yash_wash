package com.google.common.primitives;

import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
public final class l0 extends Number implements Comparable<l0>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f22401b = Long.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l0 f22402c = new l0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l0 f22403d = new l0(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l0 f22404e = new l0(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f22405a;

    private l0(long j7) {
        this.f22405a = j7;
    }

    public static l0 d(long j7) {
        return new l0(j7);
    }

    @u1.a
    public static l0 j(long j7) {
        com.google.common.base.e0.p(j7 >= 0, "value (%s) is outside the range for an unsigned long value", j7);
        return d(j7);
    }

    @u1.a
    public static l0 k(String str) {
        return l(str, 10);
    }

    @u1.a
    public static l0 l(String str, int i7) {
        return d(m0.j(str, i7));
    }

    @u1.a
    public static l0 m(BigInteger bigInteger) {
        com.google.common.base.e0.E(bigInteger);
        com.google.common.base.e0.u(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return d(bigInteger.longValue());
    }

    public BigInteger a() {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.f22405a & Long.MAX_VALUE);
        return this.f22405a < 0 ? bigIntegerValueOf.setBit(63) : bigIntegerValueOf;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(l0 l0Var) {
        com.google.common.base.e0.E(l0Var);
        return m0.a(this.f22405a, l0Var.f22405a);
    }

    public l0 c(l0 l0Var) {
        return d(m0.c(this.f22405a, ((l0) com.google.common.base.e0.E(l0Var)).f22405a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j7 = this.f22405a;
        double d8 = Long.MAX_VALUE & j7;
        return j7 < 0 ? d8 + 9.223372036854776E18d : d8;
    }

    public l0 e(l0 l0Var) {
        return d(this.f22405a - ((l0) com.google.common.base.e0.E(l0Var)).f22405a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof l0) && this.f22405a == ((l0) obj).f22405a;
    }

    public l0 f(l0 l0Var) {
        return d(m0.k(this.f22405a, ((l0) com.google.common.base.e0.E(l0Var)).f22405a));
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j7 = this.f22405a;
        float f8 = Long.MAX_VALUE & j7;
        return j7 < 0 ? f8 + 9.223372E18f : f8;
    }

    public l0 g(l0 l0Var) {
        return d(this.f22405a + ((l0) com.google.common.base.e0.E(l0Var)).f22405a);
    }

    public l0 h(l0 l0Var) {
        return d(this.f22405a * ((l0) com.google.common.base.e0.E(l0Var)).f22405a);
    }

    public int hashCode() {
        return d0.k(this.f22405a);
    }

    public String i(int i7) {
        return m0.q(this.f22405a, i7);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.f22405a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.f22405a;
    }

    public String toString() {
        return m0.p(this.f22405a);
    }
}
