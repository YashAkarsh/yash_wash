package kotlin;

/* JADX INFO: loaded from: classes2.dex */
class q0 extends p0 {
    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int T0(byte b8) {
        return Integer.numberOfLeadingZeros(b8 & 255) - 24;
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int U0(short s7) {
        return Integer.numberOfLeadingZeros(s7 & g2.f34732d) - 16;
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int V0(byte b8) {
        return Integer.bitCount(b8 & 255);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int W0(short s7) {
        return Integer.bitCount(s7 & g2.f34732d);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int X0(byte b8) {
        return Integer.numberOfTrailingZeros(b8 | 256);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final int Y0(short s7) {
        return Integer.numberOfTrailingZeros(s7 | g2.f34731c);
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    public static final byte Z0(byte b8, int i7) {
        int i8 = i7 & 7;
        return (byte) (((b8 & 255) >>> (8 - i8)) | (b8 << i8));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    public static final short a1(short s7, int i7) {
        int i8 = i7 & 15;
        return (short) (((s7 & 65535) >>> (16 - i8)) | (s7 << i8));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    public static final byte b1(byte b8, int i7) {
        int i8 = i7 & 7;
        return (byte) (((b8 & 255) >>> i8) | (b8 << (8 - i8)));
    }

    @g1(version = i2.a.f34096f)
    @q2(markerClass = {s.class})
    public static final short c1(short s7, int i7) {
        int i8 = i7 & 15;
        return (short) (((s7 & 65535) >>> i8) | (s7 << (16 - i8)));
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final byte d1(byte b8) {
        return (byte) Integer.highestOneBit(b8 & 255);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final short e1(short s7) {
        return (short) Integer.highestOneBit(s7 & g2.f34732d);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final byte f1(byte b8) {
        return (byte) Integer.lowestOneBit(b8);
    }

    @g1(version = "1.4")
    @q2(markerClass = {s.class})
    @kotlin.internal.f
    private static final short g1(short s7) {
        return (short) Integer.lowestOneBit(s7);
    }
}
