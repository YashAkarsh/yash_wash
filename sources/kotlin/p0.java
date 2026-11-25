package kotlin;

/* JADX INFO: loaded from: classes2.dex */
class p0 extends o0 {
    @g1(version = "1.2")
    @kotlin.internal.f
    private static final float A0(kotlin.jvm.internal.a0 a0Var, int i7) {
        kotlin.jvm.internal.l0.p(a0Var, "<this>");
        return Float.intBitsToFloat(i7);
    }

    @kotlin.internal.f
    private static final boolean B0(double d8) {
        return (Double.isInfinite(d8) || Double.isNaN(d8)) ? false : true;
    }

    @kotlin.internal.f
    private static final boolean C0(float f8) {
        return (Float.isInfinite(f8) || Float.isNaN(f8)) ? false : true;
    }

    @kotlin.internal.f
    private static final boolean D0(double d8) {
        return Double.isInfinite(d8);
    }

    @kotlin.internal.f
    private static final boolean E0(float f8) {
        return Float.isInfinite(f8);
    }

    @kotlin.internal.f
    private static final boolean F0(double d8) {
        return Double.isNaN(d8);
    }

    @kotlin.internal.f
    private static final boolean G0(float f8) {
        return Float.isNaN(f8);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int H0(int i7, int i8) {
        return Integer.rotateLeft(i7, i8);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final long I0(long j7, int i7) {
        return Long.rotateLeft(j7, i7);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int J0(int i7, int i8) {
        return Integer.rotateRight(i7, i8);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final long K0(long j7, int i7) {
        return Long.rotateRight(j7, i7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int L0(int i7) {
        return Integer.highestOneBit(i7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final long M0(long j7) {
        return Long.highestOneBit(j7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int N0(int i7) {
        return Integer.lowestOneBit(i7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final long O0(long j7) {
        return Long.lowestOneBit(j7);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final int P0(float f8) {
        return Float.floatToIntBits(f8);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final long Q0(double d8) {
        return Double.doubleToLongBits(d8);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final int R0(float f8) {
        return Float.floatToRawIntBits(f8);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final long S0(double d8) {
        return Double.doubleToRawLongBits(d8);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int t0(int i7) {
        return Integer.numberOfLeadingZeros(i7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int u0(long j7) {
        return Long.numberOfLeadingZeros(j7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int v0(int i7) {
        return Integer.bitCount(i7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int w0(long j7) {
        return Long.bitCount(j7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int x0(int i7) {
        return Integer.numberOfTrailingZeros(i7);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int y0(long j7) {
        return Long.numberOfTrailingZeros(j7);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final double z0(kotlin.jvm.internal.x xVar, long j7) {
        kotlin.jvm.internal.l0.p(xVar, "<this>");
        return Double.longBitsToDouble(j7);
    }
}
