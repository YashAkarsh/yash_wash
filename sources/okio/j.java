package okio;

import kotlin.g2;

/* JADX INFO: loaded from: classes3.dex */
@h5.h(name = "-Util")
public final class j {
    public static final int a(byte b8, int i7) {
        return b8 & i7;
    }

    public static final long b(byte b8, long j7) {
        return ((long) b8) & j7;
    }

    public static final long c(int i7, long j7) {
        return ((long) i7) & j7;
    }

    public static final boolean d(@a7.d byte[] a8, int i7, @a7.d byte[] b8, int i8, int i9) {
        kotlin.jvm.internal.l0.p(a8, "a");
        kotlin.jvm.internal.l0.p(b8, "b");
        for (int i10 = 0; i10 < i9; i10++) {
            if (a8[i10 + i7] != b8[i10 + i8]) {
                return false;
            }
        }
        return true;
    }

    public static final void e(long j7, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException("size=" + j7 + " offset=" + j8 + " byteCount=" + j9);
        }
    }

    public static final long f(int i7, long j7) {
        return Math.min(i7, j7);
    }

    public static final long g(long j7, int i7) {
        return Math.min(j7, i7);
    }

    public static final int h(int i7) {
        return ((i7 & 255) << 24) | (((-16777216) & i7) >>> 24) | ((16711680 & i7) >>> 8) | ((65280 & i7) << 8);
    }

    public static final long i(long j7) {
        return ((j7 & 255) << 56) | (((-72057594037927936L) & j7) >>> 56) | ((71776119061217280L & j7) >>> 40) | ((280375465082880L & j7) >>> 24) | ((1095216660480L & j7) >>> 8) | ((4278190080L & j7) << 8) | ((16711680 & j7) << 24) | ((65280 & j7) << 40);
    }

    public static final short j(short s7) {
        int i7 = s7 & g2.f34732d;
        return (short) (((i7 & 255) << 8) | ((65280 & i7) >>> 8));
    }

    public static final int k(byte b8, int i7) {
        return b8 << i7;
    }

    public static final int l(byte b8, int i7) {
        return b8 >> i7;
    }

    @a7.d
    public static final String m(byte b8) {
        return new String(new char[]{v5.b.I()[(b8 >> 4) & 15], v5.b.I()[b8 & com.google.common.base.c.f19317q]});
    }

    @a7.d
    public static final String n(int i7) {
        if (i7 == 0) {
            return "0";
        }
        int i8 = 0;
        char[] cArr = {v5.b.I()[(i7 >> 28) & 15], v5.b.I()[(i7 >> 24) & 15], v5.b.I()[(i7 >> 20) & 15], v5.b.I()[(i7 >> 16) & 15], v5.b.I()[(i7 >> 12) & 15], v5.b.I()[(i7 >> 8) & 15], v5.b.I()[(i7 >> 4) & 15], v5.b.I()[i7 & 15]};
        while (i8 < 8 && cArr[i8] == '0') {
            i8++;
        }
        return new String(cArr, i8, 8 - i8);
    }

    @a7.d
    public static final String o(long j7) {
        if (j7 == 0) {
            return "0";
        }
        int i7 = 0;
        char[] cArr = {v5.b.I()[(int) ((j7 >> 60) & 15)], v5.b.I()[(int) ((j7 >> 56) & 15)], v5.b.I()[(int) ((j7 >> 52) & 15)], v5.b.I()[(int) ((j7 >> 48) & 15)], v5.b.I()[(int) ((j7 >> 44) & 15)], v5.b.I()[(int) ((j7 >> 40) & 15)], v5.b.I()[(int) ((j7 >> 36) & 15)], v5.b.I()[(int) ((j7 >> 32) & 15)], v5.b.I()[(int) ((j7 >> 28) & 15)], v5.b.I()[(int) ((j7 >> 24) & 15)], v5.b.I()[(int) ((j7 >> 20) & 15)], v5.b.I()[(int) ((j7 >> 16) & 15)], v5.b.I()[(int) ((j7 >> 12) & 15)], v5.b.I()[(int) ((j7 >> 8) & 15)], v5.b.I()[(int) ((j7 >> 4) & 15)], v5.b.I()[(int) (j7 & 15)]};
        while (i7 < 16 && cArr[i7] == '0') {
            i7++;
        }
        return new String(cArr, i7, 16 - i7);
    }
}
