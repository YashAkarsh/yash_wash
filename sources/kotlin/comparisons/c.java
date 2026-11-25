package kotlin.comparisons;

import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class c extends b {
    @g1(version = "1.1")
    @kotlin.internal.f
    private static final byte A(byte b8, byte b9, byte b10) {
        return (byte) Math.max((int) b8, Math.max((int) b9, (int) b10));
    }

    @g1(version = "1.4")
    public static final byte B(byte b8, @a7.d byte... other) {
        l0.p(other, "other");
        for (byte b9 : other) {
            b8 = (byte) Math.max((int) b8, (int) b9);
        }
        return b8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final double C(double d8, double d9) {
        return Math.max(d8, d9);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final double D(double d8, double d9, double d10) {
        return Math.max(d8, Math.max(d9, d10));
    }

    @g1(version = "1.4")
    public static final double E(double d8, @a7.d double... other) {
        l0.p(other, "other");
        for (double d9 : other) {
            d8 = Math.max(d8, d9);
        }
        return d8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final float F(float f8, float f9) {
        return Math.max(f8, f9);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final float G(float f8, float f9, float f10) {
        return Math.max(f8, Math.max(f9, f10));
    }

    @g1(version = "1.4")
    public static final float H(float f8, @a7.d float... other) {
        l0.p(other, "other");
        for (float f9 : other) {
            f8 = Math.max(f8, f9);
        }
        return f8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final int I(int i7, int i8) {
        return Math.max(i7, i8);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final int J(int i7, int i8, int i9) {
        return Math.max(i7, Math.max(i8, i9));
    }

    @g1(version = "1.4")
    public static final int K(int i7, @a7.d int... other) {
        l0.p(other, "other");
        for (int i8 : other) {
            i7 = Math.max(i7, i8);
        }
        return i7;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final long L(long j7, long j8) {
        return Math.max(j7, j8);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final long M(long j7, long j8, long j9) {
        return Math.max(j7, Math.max(j8, j9));
    }

    @g1(version = "1.4")
    public static final long N(long j7, @a7.d long... other) {
        l0.p(other, "other");
        for (long j8 : other) {
            j7 = Math.max(j7, j8);
        }
        return j7;
    }

    @a7.d
    @g1(version = "1.1")
    public static <T extends Comparable<? super T>> T O(@a7.d T a8, @a7.d T b8) {
        l0.p(a8, "a");
        l0.p(b8, "b");
        return a8.compareTo(b8) >= 0 ? a8 : b8;
    }

    @a7.d
    @g1(version = "1.1")
    public static final <T extends Comparable<? super T>> T P(@a7.d T a8, @a7.d T b8, @a7.d T c8) {
        l0.p(a8, "a");
        l0.p(b8, "b");
        l0.p(c8, "c");
        return (T) O(a8, O(b8, c8));
    }

    @a7.d
    @g1(version = "1.4")
    public static final <T extends Comparable<? super T>> T Q(@a7.d T a8, @a7.d T... other) {
        l0.p(a8, "a");
        l0.p(other, "other");
        for (T t7 : other) {
            a8 = (T) O(a8, t7);
        }
        return a8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final short R(short s7, short s8) {
        return (short) Math.max((int) s7, (int) s8);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final short S(short s7, short s8, short s9) {
        return (short) Math.max((int) s7, Math.max((int) s8, (int) s9));
    }

    @g1(version = "1.4")
    public static final short T(short s7, @a7.d short... other) {
        l0.p(other, "other");
        for (short s8 : other) {
            s7 = (short) Math.max((int) s7, (int) s8);
        }
        return s7;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final byte U(byte b8, byte b9) {
        return (byte) Math.min((int) b8, (int) b9);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final byte V(byte b8, byte b9, byte b10) {
        return (byte) Math.min((int) b8, Math.min((int) b9, (int) b10));
    }

    @g1(version = "1.4")
    public static final byte W(byte b8, @a7.d byte... other) {
        l0.p(other, "other");
        for (byte b9 : other) {
            b8 = (byte) Math.min((int) b8, (int) b9);
        }
        return b8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final double X(double d8, double d9) {
        return Math.min(d8, d9);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final double Y(double d8, double d9, double d10) {
        return Math.min(d8, Math.min(d9, d10));
    }

    @g1(version = "1.4")
    public static final double Z(double d8, @a7.d double... other) {
        l0.p(other, "other");
        for (double d9 : other) {
            d8 = Math.min(d8, d9);
        }
        return d8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final float a0(float f8, float f9) {
        return Math.min(f8, f9);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final float b0(float f8, float f9, float f10) {
        return Math.min(f8, Math.min(f9, f10));
    }

    @g1(version = "1.4")
    public static final float c0(float f8, @a7.d float... other) {
        l0.p(other, "other");
        for (float f9 : other) {
            f8 = Math.min(f8, f9);
        }
        return f8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final int d0(int i7, int i8) {
        return Math.min(i7, i8);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final int e0(int i7, int i8, int i9) {
        return Math.min(i7, Math.min(i8, i9));
    }

    @g1(version = "1.4")
    public static final int f0(int i7, @a7.d int... other) {
        l0.p(other, "other");
        for (int i8 : other) {
            i7 = Math.min(i7, i8);
        }
        return i7;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final long g0(long j7, long j8) {
        return Math.min(j7, j8);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final long h0(long j7, long j8, long j9) {
        return Math.min(j7, Math.min(j8, j9));
    }

    @g1(version = "1.4")
    public static final long i0(long j7, @a7.d long... other) {
        l0.p(other, "other");
        for (long j8 : other) {
            j7 = Math.min(j7, j8);
        }
        return j7;
    }

    @a7.d
    @g1(version = "1.1")
    public static final <T extends Comparable<? super T>> T j0(@a7.d T a8, @a7.d T b8) {
        l0.p(a8, "a");
        l0.p(b8, "b");
        return a8.compareTo(b8) <= 0 ? a8 : b8;
    }

    @a7.d
    @g1(version = "1.1")
    public static final <T extends Comparable<? super T>> T k0(@a7.d T a8, @a7.d T b8, @a7.d T c8) {
        l0.p(a8, "a");
        l0.p(b8, "b");
        l0.p(c8, "c");
        return (T) j0(a8, j0(b8, c8));
    }

    @a7.d
    @g1(version = "1.4")
    public static final <T extends Comparable<? super T>> T l0(@a7.d T a8, @a7.d T... other) {
        l0.p(a8, "a");
        l0.p(other, "other");
        for (T t7 : other) {
            a8 = (T) j0(a8, t7);
        }
        return a8;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final short m0(short s7, short s8) {
        return (short) Math.min((int) s7, (int) s8);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final short n0(short s7, short s8, short s9) {
        return (short) Math.min((int) s7, Math.min((int) s8, (int) s9));
    }

    @g1(version = "1.4")
    public static final short o0(short s7, @a7.d short... other) {
        l0.p(other, "other");
        for (short s8 : other) {
            s7 = (short) Math.min((int) s7, (int) s8);
        }
        return s7;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final byte z(byte b8, byte b9) {
        return (byte) Math.max((int) b8, (int) b9);
    }
}
