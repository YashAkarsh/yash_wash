package i4;

import android.os.Build;
import c.m0;
import c.o0;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.function.IntFunction;
import kotlin.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static long a(int i7) {
        return 1 << i7;
    }

    public static int b(byte[] bArr) {
        return (t(bArr[0]) << 24) + (t(bArr[1]) << 16) + (t(bArr[2]) << 8) + t(bArr[3]);
    }

    public static int c(byte[] bArr) {
        return Integer.reverseBytes(b(bArr));
    }

    public static void d(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z7, @m0 Object obj) {
        if (!z7) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static String f(int i7, IntFunction<String> intFunction) {
        StringBuilder sb = new StringBuilder();
        int i8 = 0;
        while (i7 != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i7);
            i7 &= ~iNumberOfTrailingZeros;
            if (i8 > 0) {
                sb.append(", ");
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append((String) intFunction.apply(iNumberOfTrailingZeros));
            }
            i8++;
        }
        v(sb, "[", "]");
        return sb.toString();
    }

    public static int g(ByteBuffer byteBuffer, int i7) {
        return r(byteBuffer.getShort(i7));
    }

    public static long h(ByteBuffer byteBuffer, int i7) {
        return s(byteBuffer.getInt(i7));
    }

    public static int i(ByteBuffer byteBuffer, int i7) {
        return t(byteBuffer.get(i7));
    }

    public static boolean j(long j7, int i7) {
        return (j7 & a(i7)) != 0;
    }

    public static boolean k(byte b8, byte b9, byte b10) {
        return (b8 & b10) == (b9 & b10);
    }

    public static boolean l(long j7, long j8, long j9) {
        return (j7 & j9) == (j8 & j9);
    }

    public static boolean m(UUID uuid, UUID uuid2, @o0 UUID uuid3) {
        if (uuid3 == null) {
            return Objects.equals(uuid, uuid2);
        }
        return l(uuid.getLeastSignificantBits(), uuid2.getLeastSignificantBits(), uuid3.getLeastSignificantBits()) && l(uuid.getMostSignificantBits(), uuid2.getMostSignificantBits(), uuid3.getMostSignificantBits());
    }

    public static boolean n(byte[] bArr, byte[] bArr2, @o0 byte[] bArr3) {
        if (bArr == null || bArr2 == null) {
            return bArr == bArr2;
        }
        e(bArr.length == bArr2.length, "Inputs must be of same size");
        if (bArr3 == null) {
            return Arrays.equals(bArr, bArr2);
        }
        e(bArr.length == bArr3.length, "Mask must be of same size as inputs");
        for (int i7 = 0; i7 < bArr3.length; i7++) {
            if (!k(bArr[i7], bArr2[i7], bArr3[i7])) {
                return false;
            }
        }
        return true;
    }

    public static long o(int[] iArr) {
        long j7 = 0;
        for (int i7 : iArr) {
            j7 |= (long) (1 << i7);
        }
        return j7;
    }

    public static void p(ByteBuffer byteBuffer, int i7, byte[] bArr) {
        int iPosition = byteBuffer.position();
        byteBuffer.position(i7);
        byteBuffer.put(bArr);
        byteBuffer.position(iPosition);
    }

    public static int q(byte b8, byte b9) {
        return ((b8 & 255) << 8) | (b9 & 255);
    }

    public static int r(short s7) {
        return s7 & g2.f34732d;
    }

    public static long s(int i7) {
        return ((long) i7) & 4294967295L;
    }

    public static int t(byte b8) {
        return b8 & 255;
    }

    public static int[] u(long j7) {
        int[] iArr = new int[Long.bitCount(j7)];
        int i7 = 0;
        int i8 = 0;
        while (j7 > 0) {
            if ((j7 & 1) == 1) {
                iArr[i7] = i8;
                i7++;
            }
            j7 >>= 1;
            i8++;
        }
        return iArr;
    }

    public static void v(StringBuilder sb, String str, String str2) {
        sb.insert(0, str);
        sb.append(str2);
    }
}
