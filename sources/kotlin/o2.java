package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "UnsignedKt")
public final class o2 {
    @a1
    public static final int a(double d8) {
        if (Double.isNaN(d8) || d8 <= f(0)) {
            return 0;
        }
        if (d8 >= f(-1)) {
            return -1;
        }
        return d8 <= 2.147483647E9d ? w1.h((int) d8) : w1.h(w1.h((int) (d8 - ((double) Integer.MAX_VALUE))) + w1.h(Integer.MAX_VALUE));
    }

    @a1
    public static final long b(double d8) {
        if (Double.isNaN(d8) || d8 <= j(0L)) {
            return 0L;
        }
        if (d8 >= j(-1L)) {
            return -1L;
        }
        return d8 < 9.223372036854776E18d ? a2.h((long) d8) : a2.h(a2.h((long) (d8 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @a1
    public static final int c(int i7, int i8) {
        return kotlin.jvm.internal.l0.t(i7 ^ Integer.MIN_VALUE, i8 ^ Integer.MIN_VALUE);
    }

    @a1
    public static final int d(int i7, int i8) {
        return w1.h((int) ((((long) i7) & 4294967295L) / (((long) i8) & 4294967295L)));
    }

    @a1
    public static final int e(int i7, int i8) {
        return w1.h((int) ((((long) i7) & 4294967295L) % (((long) i8) & 4294967295L)));
    }

    @a1
    public static final double f(int i7) {
        return ((double) (Integer.MAX_VALUE & i7)) + (((double) ((i7 >>> 31) << 30)) * ((double) 2));
    }

    @a1
    public static final int g(long j7, long j8) {
        return kotlin.jvm.internal.l0.u(j7 ^ Long.MIN_VALUE, j8 ^ Long.MIN_VALUE);
    }

    @a1
    public static final long h(long j7, long j8) {
        if (j8 < 0) {
            return g(j7, j8) < 0 ? a2.h(0L) : a2.h(1L);
        }
        if (j7 >= 0) {
            return a2.h(j7 / j8);
        }
        long j9 = ((j7 >>> 1) / j8) << 1;
        return a2.h(j9 + ((long) (g(a2.h(j7 - (j9 * j8)), a2.h(j8)) < 0 ? 0 : 1)));
    }

    @a1
    public static final long i(long j7, long j8) {
        if (j8 < 0) {
            return g(j7, j8) < 0 ? j7 : a2.h(j7 - j8);
        }
        if (j7 >= 0) {
            return a2.h(j7 % j8);
        }
        long j9 = j7 - ((((j7 >>> 1) / j8) << 1) * j8);
        if (g(a2.h(j9), a2.h(j8)) < 0) {
            j8 = 0;
        }
        return a2.h(j9 - j8);
    }

    @a1
    public static final double j(long j7) {
        return ((j7 >>> 11) * ((double) 2048)) + (j7 & 2047);
    }

    @a7.d
    public static final String k(long j7) {
        return l(j7, 10);
    }

    @a7.d
    public static final String l(long j7, int i7) {
        if (j7 >= 0) {
            String string = Long.toString(j7, kotlin.text.d.a(i7));
            kotlin.jvm.internal.l0.o(string, "toString(this, checkRadix(radix))");
            return string;
        }
        long j8 = i7;
        long j9 = ((j7 >>> 1) / j8) << 1;
        long j10 = j7 - (j9 * j8);
        if (j10 >= j8) {
            j10 -= j8;
            j9++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j9, kotlin.text.d.a(i7));
        kotlin.jvm.internal.l0.o(string2, "toString(this, checkRadix(radix))");
        sb.append(string2);
        String string3 = Long.toString(j10, kotlin.text.d.a(i7));
        kotlin.jvm.internal.l0.o(string3, "toString(this, checkRadix(radix))");
        sb.append(string3);
        return sb.toString();
    }
}
