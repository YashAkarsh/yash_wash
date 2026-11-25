package kotlin.random;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.ranges.k;
import kotlin.ranges.n;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    @a7.d
    @g1(version = "1.3")
    public static final f a(int i7) {
        return new i(i7, i7 >> 31);
    }

    @a7.d
    @g1(version = "1.3")
    public static final f b(long j7) {
        return new i((int) j7, (int) (j7 >> 32));
    }

    @a7.d
    public static final String c(@a7.d Object from, @a7.d Object until) {
        l0.p(from, "from");
        l0.p(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void d(double d8, double d9) {
        if (!(d9 > d8)) {
            throw new IllegalArgumentException(c(Double.valueOf(d8), Double.valueOf(d9)).toString());
        }
    }

    public static final void e(int i7, int i8) {
        if (!(i8 > i7)) {
            throw new IllegalArgumentException(c(Integer.valueOf(i7), Integer.valueOf(i8)).toString());
        }
    }

    public static final void f(long j7, long j8) {
        if (!(j8 > j7)) {
            throw new IllegalArgumentException(c(Long.valueOf(j7), Long.valueOf(j8)).toString());
        }
    }

    public static final int g(int i7) {
        return 31 - Integer.numberOfLeadingZeros(i7);
    }

    @g1(version = "1.3")
    public static final int h(@a7.d f fVar, @a7.d k range) {
        l0.p(fVar, "<this>");
        l0.p(range, "range");
        if (!range.isEmpty()) {
            if (range.h() < Integer.MAX_VALUE) {
                return fVar.n(range.g(), range.h() + 1);
            }
            return range.g() > Integer.MIN_VALUE ? fVar.n(range.g() - 1, range.h()) + 1 : fVar.l();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @g1(version = "1.3")
    public static final long i(@a7.d f fVar, @a7.d n range) {
        l0.p(fVar, "<this>");
        l0.p(range, "range");
        if (!range.isEmpty()) {
            if (range.h() < Long.MAX_VALUE) {
                return fVar.q(range.g(), range.h() + 1);
            }
            return range.g() > Long.MIN_VALUE ? fVar.q(range.g() - 1, range.h()) + 1 : fVar.o();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int j(int i7, int i8) {
        return (i7 >>> (32 - i8)) & ((-i8) >> 31);
    }
}
