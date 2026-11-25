package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "UNumbersKt")
public final class f2 {
    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int A(int i7) {
        return w1.h(Integer.lowestOneBit(i7));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final short B(short s7) {
        return g2.h((short) Integer.lowestOneBit(s7 & g2.f34732d));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int a(byte b8) {
        return Integer.numberOfLeadingZeros(b8 & 255) - 24;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int b(long j7) {
        return Long.numberOfLeadingZeros(j7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int c(int i7) {
        return Integer.numberOfLeadingZeros(i7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int d(short s7) {
        return Integer.numberOfLeadingZeros(s7 & g2.f34732d) - 16;
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int e(byte b8) {
        return Integer.bitCount(w1.h(b8 & 255));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int f(long j7) {
        return Long.bitCount(j7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int g(int i7) {
        return Integer.bitCount(i7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int h(short s7) {
        return Integer.bitCount(w1.h(s7 & g2.f34732d));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int i(byte b8) {
        return Integer.numberOfTrailingZeros(b8 | 256);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int j(long j7) {
        return Long.numberOfTrailingZeros(j7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int k(int i7) {
        return Integer.numberOfTrailingZeros(i7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int l(short s7) {
        return Integer.numberOfTrailingZeros(s7 | g2.f34731c);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final long m(long j7, int i7) {
        return a2.h(Long.rotateLeft(j7, i7));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final byte n(byte b8, int i7) {
        return s1.h(q0.Z0(b8, i7));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final int o(int i7, int i8) {
        return w1.h(Integer.rotateLeft(i7, i8));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final short p(short s7, int i7) {
        return g2.h(q0.a1(s7, i7));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final long q(long j7, int i7) {
        return a2.h(Long.rotateRight(j7, i7));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final byte r(byte b8, int i7) {
        return s1.h(q0.b1(b8, i7));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final int s(int i7, int i8) {
        return w1.h(Integer.rotateRight(i7, i8));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class, t.class})
    @kotlin.internal.f
    private static final short t(short s7, int i7) {
        return g2.h(q0.c1(s7, i7));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final byte u(byte b8) {
        return s1.h((byte) Integer.highestOneBit(b8 & 255));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final long v(long j7) {
        return a2.h(Long.highestOneBit(j7));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final int w(int i7) {
        return w1.h(Integer.highestOneBit(i7));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final short x(short s7) {
        return g2.h((short) Integer.highestOneBit(s7 & g2.f34732d));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final byte y(byte b8) {
        return s1.h((byte) Integer.lowestOneBit(b8 & 255));
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class, s.class})
    @kotlin.internal.f
    private static final long z(long j7) {
        return a2.h(Long.lowestOneBit(j7));
    }
}
