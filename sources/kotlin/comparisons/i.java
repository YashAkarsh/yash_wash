package kotlin.comparisons;

import kotlin.b2;
import kotlin.g1;
import kotlin.g2;
import kotlin.h2;
import kotlin.jvm.internal.l0;
import kotlin.o2;
import kotlin.q2;
import kotlin.t;
import kotlin.t1;
import kotlin.x1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final short a(short s7, short s8) {
        return l0.t(s7 & g2.f34732d, 65535 & s8) >= 0 ? s7 : s8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static int b(int i7, int i8) {
        return o2.c(i7, i8) >= 0 ? i7 : i8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final byte c(byte b8, byte b9) {
        return l0.t(b8 & 255, b9 & 255) >= 0 ? b8 : b9;
    }

    @g1(version = "1.4")
    @t
    public static final int d(int i7, @a7.d int... other) {
        l0.p(other, "other");
        int iO = x1.o(other);
        for (int i8 = 0; i8 < iO; i8++) {
            i7 = b(i7, x1.m(other, i8));
        }
        return i7;
    }

    @g1(version = "1.4")
    @t
    public static final long e(long j7, @a7.d long... other) {
        l0.p(other, "other");
        int iO = b2.o(other);
        for (int i7 = 0; i7 < iO; i7++) {
            j7 = j(j7, b2.m(other, i7));
        }
        return j7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final short f(short s7, short s8, short s9) {
        return a(s7, a(s8, s9));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final int g(int i7, int i8, int i9) {
        return b(i7, b(i8, i9));
    }

    @g1(version = "1.4")
    @t
    public static final byte h(byte b8, @a7.d byte... other) {
        l0.p(other, "other");
        int iO = t1.o(other);
        for (int i7 = 0; i7 < iO; i7++) {
            b8 = c(b8, t1.m(other, i7));
        }
        return b8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final byte i(byte b8, byte b9, byte b10) {
        return c(b8, c(b9, b10));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static long j(long j7, long j8) {
        return o2.g(j7, j8) >= 0 ? j7 : j8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final long k(long j7, long j8, long j9) {
        return j(j7, j(j8, j9));
    }

    @g1(version = "1.4")
    @t
    public static final short l(short s7, @a7.d short... other) {
        l0.p(other, "other");
        int iO = h2.o(other);
        for (int i7 = 0; i7 < iO; i7++) {
            s7 = a(s7, h2.m(other, i7));
        }
        return s7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final short m(short s7, short s8) {
        return l0.t(s7 & g2.f34732d, 65535 & s8) <= 0 ? s7 : s8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static int n(int i7, int i8) {
        return o2.c(i7, i8) <= 0 ? i7 : i8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static final byte o(byte b8, byte b9) {
        return l0.t(b8 & 255, b9 & 255) <= 0 ? b8 : b9;
    }

    @g1(version = "1.4")
    @t
    public static final int p(int i7, @a7.d int... other) {
        l0.p(other, "other");
        int iO = x1.o(other);
        for (int i8 = 0; i8 < iO; i8++) {
            i7 = n(i7, x1.m(other, i8));
        }
        return i7;
    }

    @g1(version = "1.4")
    @t
    public static final long q(long j7, @a7.d long... other) {
        l0.p(other, "other");
        int iO = b2.o(other);
        for (int i7 = 0; i7 < iO; i7++) {
            j7 = v(j7, b2.m(other, i7));
        }
        return j7;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final short r(short s7, short s8, short s9) {
        return m(s7, m(s8, s9));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final int s(int i7, int i8, int i9) {
        return n(i7, n(i8, i9));
    }

    @g1(version = "1.4")
    @t
    public static final byte t(byte b8, @a7.d byte... other) {
        l0.p(other, "other");
        int iO = t1.o(other);
        for (int i7 = 0; i7 < iO; i7++) {
            b8 = o(b8, t1.m(other, i7));
        }
        return b8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final byte u(byte b8, byte b9, byte b10) {
        return o(b8, o(b9, b10));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    public static long v(long j7, long j8) {
        return o2.g(j7, j8) <= 0 ? j7 : j8;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @kotlin.internal.f
    private static final long w(long j7, long j8, long j9) {
        return v(j7, v(j8, j9));
    }

    @g1(version = "1.4")
    @t
    public static final short x(short s7, @a7.d short... other) {
        l0.p(other, "other");
        int iO = h2.o(other);
        for (int i7 = 0; i7 < iO; i7++) {
            s7 = m(s7, h2.m(other, i7));
        }
        return s7;
    }
}
