package com.google.common.primitives;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class j0 extends Number implements Comparable<j0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0 f22394b = d(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j0 f22395c = d(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j0 f22396d = d(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22397a;

    private j0(int i7) {
        this.f22397a = i7 & (-1);
    }

    public static j0 d(int i7) {
        return new j0(i7);
    }

    public static j0 j(long j7) {
        com.google.common.base.e0.p((4294967295L & j7) == j7, "value (%s) is outside the range for an unsigned integer value", j7);
        return d((int) j7);
    }

    public static j0 k(String str) {
        return l(str, 10);
    }

    public static j0 l(String str, int i7) {
        return d(k0.k(str, i7));
    }

    public static j0 m(BigInteger bigInteger) {
        com.google.common.base.e0.E(bigInteger);
        com.google.common.base.e0.u(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return d(bigInteger.intValue());
    }

    public BigInteger a() {
        return BigInteger.valueOf(longValue());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(j0 j0Var) {
        com.google.common.base.e0.E(j0Var);
        return k0.b(this.f22397a, j0Var.f22397a);
    }

    public j0 c(j0 j0Var) {
        return d(k0.d(this.f22397a, ((j0) com.google.common.base.e0.E(j0Var)).f22397a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    public j0 e(j0 j0Var) {
        return d(this.f22397a - ((j0) com.google.common.base.e0.E(j0Var)).f22397a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof j0) && this.f22397a == ((j0) obj).f22397a;
    }

    public j0 f(j0 j0Var) {
        return d(k0.l(this.f22397a, ((j0) com.google.common.base.e0.E(j0Var)).f22397a));
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    public j0 g(j0 j0Var) {
        return d(this.f22397a + ((j0) com.google.common.base.e0.E(j0Var)).f22397a);
    }

    @s1.c
    public j0 h(j0 j0Var) {
        return d(this.f22397a * ((j0) com.google.common.base.e0.E(j0Var)).f22397a);
    }

    public int hashCode() {
        return this.f22397a;
    }

    public String i(int i7) {
        return k0.t(this.f22397a, i7);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.f22397a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return k0.r(this.f22397a);
    }

    public String toString() {
        return i(10);
    }
}
