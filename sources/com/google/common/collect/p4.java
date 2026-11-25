package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class p4<C extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f20870a;

    private static final class b extends p4<BigInteger> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final b f20871b = new b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final BigInteger f20872c = BigInteger.valueOf(Long.MIN_VALUE);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final BigInteger f20873d = BigInteger.valueOf(Long.MAX_VALUE);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f20874e = 0;

        b() {
            super(true);
        }

        private Object readResolve() {
            return f20871b;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public long b(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(f20872c).min(f20873d).longValue();
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public BigInteger g(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public BigInteger h(BigInteger bigInteger, long j7) {
            f2.c(j7, "distance");
            return bigInteger.add(BigInteger.valueOf(j7));
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public BigInteger i(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    private static final class c extends p4<Integer> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final c f20875b = new c();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20876c = 0;

        c() {
            super(true);
        }

        private Object readResolve() {
            return f20875b;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public long b(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Integer e() {
            return Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Integer f() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Integer g(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Integer h(Integer num, long j7) {
            f2.c(j7, "distance");
            return Integer.valueOf(com.google.common.primitives.c0.d(num.longValue() + j7));
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Integer i(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    private static final class d extends p4<Long> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final d f20877b = new d();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20878c = 0;

        d() {
            super(true);
        }

        private Object readResolve() {
            return f20877b;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public long b(Long l7, Long l8) {
            long jLongValue = l8.longValue() - l7.longValue();
            if (l8.longValue() > l7.longValue() && jLongValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l8.longValue() >= l7.longValue() || jLongValue <= 0) {
                return jLongValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public Long e() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Long f() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Long g(Long l7) {
            long jLongValue = l7.longValue();
            if (jLongValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue + 1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Long h(Long l7, long j7) {
            f2.c(j7, "distance");
            long jLongValue = l7.longValue() + j7;
            if (jLongValue < 0) {
                com.google.common.base.e0.e(l7.longValue() < 0, "overflow");
            }
            return Long.valueOf(jLongValue);
        }

        @Override // com.google.common.collect.p4
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Long i(Long l7) {
            long jLongValue = l7.longValue();
            if (jLongValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public static p4<BigInteger> a() {
        return b.f20871b;
    }

    public static p4<Integer> c() {
        return c.f20875b;
    }

    public static p4<Long> d() {
        return d.f20877b;
    }

    public abstract long b(C c8, C c9);

    @u1.a
    public C e() {
        throw new NoSuchElementException();
    }

    @u1.a
    public C f() {
        throw new NoSuchElementException();
    }

    public abstract C g(C c8);

    C h(C c8, long j7) {
        f2.c(j7, "distance");
        for (long j8 = 0; j8 < j7; j8++) {
            c8 = (C) g(c8);
        }
        return c8;
    }

    public abstract C i(C c8);

    protected p4() {
        this(false);
    }

    private p4(boolean z7) {
        this.f20870a = z7;
    }
}
