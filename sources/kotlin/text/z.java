package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class z extends y {
    @g1(version = "1.2")
    @a7.e
    public static final BigInteger A0(@a7.d String str) {
        l0.p(str, "<this>");
        return B0(str, 10);
    }

    @g1(version = "1.2")
    @a7.e
    public static final BigInteger B0(@a7.d String str, int i7) {
        l0.p(str, "<this>");
        d.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i8 = str.charAt(0) == '-' ? 1 : 0; i8 < length; i8++) {
                if (d.b(str.charAt(i8), i7) < 0) {
                    return null;
                }
            }
        } else if (d.b(str.charAt(0), i7) < 0) {
            return null;
        }
        return new BigInteger(str, d.a(i7));
    }

    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean C0(String str) {
        l0.p(str, "<this>");
        return Boolean.parseBoolean(str);
    }

    @g1(version = "1.4")
    @h5.h(name = "toBooleanNullable")
    @kotlin.internal.f
    private static final boolean D0(String str) {
        return Boolean.parseBoolean(str);
    }

    @kotlin.internal.f
    private static final byte E0(String str) {
        l0.p(str, "<this>");
        return Byte.parseByte(str);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final byte F0(String str, int i7) {
        l0.p(str, "<this>");
        return Byte.parseByte(str, d.a(i7));
    }

    @kotlin.internal.f
    private static final double G0(String str) {
        l0.p(str, "<this>");
        return Double.parseDouble(str);
    }

    @g1(version = "1.1")
    @a7.e
    public static final Double H0(@a7.d String str) {
        l0.p(str, "<this>");
        try {
            if (r.f35442b.k(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @kotlin.internal.f
    private static final float I0(String str) {
        l0.p(str, "<this>");
        return Float.parseFloat(str);
    }

    @g1(version = "1.1")
    @a7.e
    public static final Float J0(@a7.d String str) {
        l0.p(str, "<this>");
        try {
            if (r.f35442b.k(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @kotlin.internal.f
    private static final int K0(String str) {
        l0.p(str, "<this>");
        return Integer.parseInt(str);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final int L0(String str, int i7) {
        l0.p(str, "<this>");
        return Integer.parseInt(str, d.a(i7));
    }

    @kotlin.internal.f
    private static final long M0(String str) {
        l0.p(str, "<this>");
        return Long.parseLong(str);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final long N0(String str, int i7) {
        l0.p(str, "<this>");
        return Long.parseLong(str, d.a(i7));
    }

    @kotlin.internal.f
    private static final short O0(String str) {
        l0.p(str, "<this>");
        return Short.parseShort(str);
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final short P0(String str, int i7) {
        l0.p(str, "<this>");
        return Short.parseShort(str, d.a(i7));
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final String Q0(byte b8, int i7) {
        String string = Integer.toString(b8, d.a(d.a(i7)));
        l0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final String R0(int i7, int i8) {
        String string = Integer.toString(i7, d.a(i8));
        l0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final String S0(long j7, int i7) {
        String string = Long.toString(j7, d.a(i7));
        l0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final String T0(short s7, int i7) {
        String string = Integer.toString(s7, d.a(d.a(i7)));
        l0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    private static final <T> T t0(String str, i5.l<? super String, ? extends T> lVar) {
        try {
            if (r.f35442b.k(str)) {
                return lVar.z(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal u0(String str) {
        l0.p(str, "<this>");
        return new BigDecimal(str);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal v0(String str, MathContext mathContext) {
        l0.p(str, "<this>");
        l0.p(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @g1(version = "1.2")
    @a7.e
    public static final BigDecimal w0(@a7.d String str) {
        l0.p(str, "<this>");
        try {
            if (r.f35442b.k(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @g1(version = "1.2")
    @a7.e
    public static final BigDecimal x0(@a7.d String str, @a7.d MathContext mathContext) {
        l0.p(str, "<this>");
        l0.p(mathContext, "mathContext");
        try {
            if (r.f35442b.k(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger y0(String str) {
        l0.p(str, "<this>");
        return new BigInteger(str);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger z0(String str, int i7) {
        l0.p(str, "<this>");
        return new BigInteger(str, d.a(i7));
    }
}
