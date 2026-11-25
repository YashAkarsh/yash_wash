package kotlin.time;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static final long a(long j7, long j8, long j9) {
        if (!d.Z(j8) || (j7 ^ j9) >= 0) {
            return j7;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    public static final long b(long j7, long j8) {
        long jK = d.K(j8);
        if (((j7 - 1) | 1) == Long.MAX_VALUE) {
            return a(j7, j8, jK);
        }
        if ((1 | (jK - 1)) == Long.MAX_VALUE) {
            return c(j7, j8);
        }
        long j9 = j7 + jK;
        if (((j7 ^ j9) & (jK ^ j9)) < 0) {
            return j7 < 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return j9;
    }

    private static final long c(long j7, long j8) {
        long jL = d.l(j8, 2);
        return ((d.K(jL) - 1) | 1) == Long.MAX_VALUE ? (long) (j7 + d.k0(j8, g.NANOSECONDS)) : b(b(j7, jL), jL);
    }

    public static final long d(long j7, long j8) {
        if ((1 | (j8 - 1)) == Long.MAX_VALUE) {
            return d.t0(f.n0(j8, g.DAYS));
        }
        long j9 = j7 - j8;
        if (((j9 ^ j7) & (~(j9 ^ j8))) >= 0) {
            d.a aVar = d.f35456b;
            return f.n0(j9, g.NANOSECONDS);
        }
        long j10 = 1000000;
        long j11 = (j7 / j10) - (j8 / j10);
        long j12 = (j7 % j10) - (j8 % j10);
        d.a aVar2 = d.f35456b;
        return d.d0(f.n0(j11, g.MILLISECONDS), f.n0(j12, g.NANOSECONDS));
    }
}
