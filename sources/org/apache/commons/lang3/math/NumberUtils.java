package org.apache.commons.lang3.math;

import com.alibaba.android.arouter.utils.b;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes3.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);

    public static int compare(byte b8, byte b9) {
        return b8 - b9;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (!str.trim().startsWith("--")) {
            return new BigDecimal(str);
        }
        throw new NumberFormatException(str + " is not a valid number.");
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    public static BigInteger createBigInteger(String str) {
        int i7;
        if (str == null) {
            return null;
        }
        boolean zStartsWith = str.startsWith("-");
        int i8 = 16;
        if (str.startsWith("0x", zStartsWith ? 1 : 0) || str.startsWith("0X", zStartsWith ? 1 : 0)) {
            i7 = (zStartsWith ? 1 : 0) + 2;
        } else if (str.startsWith("#", zStartsWith ? 1 : 0)) {
            i7 = (zStartsWith ? 1 : 0) + 1;
        } else if (str.startsWith("0", zStartsWith ? 1 : 0)) {
            int length = str.length();
            int i9 = (zStartsWith ? 1 : 0) + 1;
            if (length > i9) {
                i8 = 8;
                i7 = i9;
            } else {
                i8 = 10;
                i7 = zStartsWith ? 1 : 0;
            }
        } else {
            i8 = 10;
            i7 = zStartsWith ? 1 : 0;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i7), i8);
        return zStartsWith ? bigInteger.negate() : bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0199 A[Catch: NumberFormatException -> 0x01a5, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x01a5, blocks: (B:105:0x018f, B:107:0x0199), top: B:159:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:159:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x013d, code lost:
    
        if (r2 == 'l') goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Number createNumber(java.lang.String r17) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return str.length() > 0;
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i7 = 0; i7 < str.length(); i7++) {
            if (!Character.isDigit(str.charAt(i7))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z7 = true;
        int i7 = charArray[0] == '-' ? 1 : 0;
        int i8 = i7 + 1;
        if (length > i8 && charArray[i7] == '0') {
            char c8 = charArray[i8];
            if (c8 == 'x' || c8 == 'X') {
                int i9 = i7 + 2;
                if (i9 == length) {
                    return false;
                }
                while (i9 < charArray.length) {
                    char c9 = charArray[i9];
                    if ((c9 < '0' || c9 > '9') && ((c9 < 'a' || c9 > 'f') && (c9 < 'A' || c9 > 'F'))) {
                        return false;
                    }
                    i9++;
                }
                return true;
            }
            if (Character.isDigit(c8)) {
                while (i8 < charArray.length) {
                    char c10 = charArray[i8];
                    if (c10 < '0' || c10 > '7') {
                        return false;
                    }
                    i8++;
                }
                return true;
            }
        }
        int i10 = length - 1;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            if (i7 >= i10 && (i7 >= i10 + 1 || !z8 || z9)) {
                if (i7 >= charArray.length) {
                    if (z8 || !z9) {
                        return false;
                    }
                    return z7;
                }
                char c11 = charArray[i7];
                if (c11 >= '0' && c11 <= '9') {
                    return z7;
                }
                if (c11 == 'e' || c11 == 'E') {
                    return false;
                }
                if (c11 == '.') {
                    if (z11 || z10) {
                        return false;
                    }
                    return z9;
                }
                if (!z8 && (c11 == 'd' || c11 == 'D' || c11 == 'f' || c11 == 'F')) {
                    return z9;
                }
                if ((c11 == 'l' || c11 == 'L') && z9 && !z10 && !z11) {
                    return z7;
                }
                return false;
            }
            char c12 = charArray[i7];
            if (c12 >= '0' && c12 <= '9') {
                z8 = false;
                z9 = true;
            } else if (c12 == '.') {
                if (z11 || z10) {
                    break;
                }
                z11 = true;
            } else if (c12 != 'e' && c12 != 'E') {
                if (c12 != '+' && c12 != '-') {
                    return false;
                }
                if (!z8) {
                    return false;
                }
                z8 = false;
                z9 = false;
            } else {
                if (z10 || !z9) {
                    return false;
                }
                z8 = true;
                z10 = true;
            }
            i7++;
            z7 = true;
        }
        return false;
    }

    public static boolean isParsable(String str) {
        if (StringUtils.endsWith(str, b.f12515h)) {
            return false;
        }
        return StringUtils.startsWith(str, "-") ? isDigits(StringUtils.replaceOnce(str.substring(1), b.f12515h, "")) : isDigits(StringUtils.replaceOnce(str, b.f12515h, ""));
    }

    public static byte max(byte b8, byte b9, byte b10) {
        if (b9 > b8) {
            b8 = b9;
        }
        return b10 > b8 ? b10 : b8;
    }

    public static byte min(byte b8, byte b9, byte b10) {
        if (b9 < b8) {
            b8 = b9;
        }
        return b10 < b8 ? b10 : b8;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    private static void validateArray(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    public static int compare(int i7, int i8) {
        if (i7 == i8) {
            return 0;
        }
        return i7 < i8 ? -1 : 1;
    }

    private static String getMantissa(String str, int i7) {
        char cCharAt = str.charAt(0);
        return cCharAt == '-' || cCharAt == '+' ? str.substring(1, i7) : str.substring(0, i7);
    }

    public static int max(int i7, int i8, int i9) {
        if (i8 > i7) {
            i7 = i8;
        }
        return i9 > i7 ? i9 : i7;
    }

    public static int min(int i7, int i8, int i9) {
        if (i8 < i7) {
            i7 = i8;
        }
        return i9 < i7 ? i9 : i7;
    }

    public static byte toByte(String str, byte b8) {
        if (str == null) {
            return b8;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b8;
        }
    }

    public static double toDouble(String str, double d8) {
        if (str == null) {
            return d8;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d8;
        }
    }

    public static float toFloat(String str, float f8) {
        if (str == null) {
            return f8;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f8;
        }
    }

    public static int toInt(String str, int i7) {
        if (str == null) {
            return i7;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    public static long toLong(String str, long j7) {
        if (str == null) {
            return j7;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j7;
        }
    }

    public static short toShort(String str, short s7) {
        if (str == null) {
            return s7;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s7;
        }
    }

    public static int compare(long j7, long j8) {
        if (j7 == j8) {
            return 0;
        }
        return j7 < j8 ? -1 : 1;
    }

    public static long max(long j7, long j8, long j9) {
        if (j8 > j7) {
            j7 = j8;
        }
        return j9 > j7 ? j9 : j7;
    }

    public static long min(long j7, long j8, long j9) {
        if (j8 < j7) {
            j7 = j8;
        }
        return j9 < j7 ? j9 : j7;
    }

    public static int compare(short s7, short s8) {
        if (s7 == s8) {
            return 0;
        }
        return s7 < s8 ? -1 : 1;
    }

    public static short max(short s7, short s8, short s9) {
        if (s8 > s7) {
            s7 = s8;
        }
        return s9 > s7 ? s9 : s7;
    }

    public static short min(short s7, short s8, short s9) {
        if (s8 < s7) {
            s7 = s8;
        }
        return s9 < s7 ? s9 : s7;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j7 = jArr[0];
        for (int i7 = 1; i7 < jArr.length; i7++) {
            long j8 = jArr[i7];
            if (j8 > j7) {
                j7 = j8;
            }
        }
        return j7;
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j7 = jArr[0];
        for (int i7 = 1; i7 < jArr.length; i7++) {
            long j8 = jArr[i7];
            if (j8 < j7) {
                j7 = j8;
            }
        }
        return j7;
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i7 = iArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            if (i9 > i7) {
                i7 = i9;
            }
        }
        return i7;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i7 = iArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            if (i9 < i7) {
                i7 = i9;
            }
        }
        return i7;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s7 = sArr[0];
        for (int i7 = 1; i7 < sArr.length; i7++) {
            short s8 = sArr[i7];
            if (s8 > s7) {
                s7 = s8;
            }
        }
        return s7;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s7 = sArr[0];
        for (int i7 = 1; i7 < sArr.length; i7++) {
            short s8 = sArr[i7];
            if (s8 < s7) {
                s7 = s8;
            }
        }
        return s7;
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b8 = bArr[0];
        for (int i7 = 1; i7 < bArr.length; i7++) {
            byte b9 = bArr[i7];
            if (b9 > b8) {
                b8 = b9;
            }
        }
        return b8;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b8 = bArr[0];
        for (int i7 = 1; i7 < bArr.length; i7++) {
            byte b9 = bArr[i7];
            if (b9 < b8) {
                b8 = b9;
            }
        }
        return b8;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d8 = dArr[0];
        for (int i7 = 1; i7 < dArr.length; i7++) {
            if (Double.isNaN(dArr[i7])) {
                return Double.NaN;
            }
            double d9 = dArr[i7];
            if (d9 > d8) {
                d8 = d9;
            }
        }
        return d8;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d8 = dArr[0];
        for (int i7 = 1; i7 < dArr.length; i7++) {
            if (Double.isNaN(dArr[i7])) {
                return Double.NaN;
            }
            double d9 = dArr[i7];
            if (d9 < d8) {
                d8 = d9;
            }
        }
        return d8;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f8 = fArr[0];
        for (int i7 = 1; i7 < fArr.length; i7++) {
            if (Float.isNaN(fArr[i7])) {
                return Float.NaN;
            }
            float f9 = fArr[i7];
            if (f9 > f8) {
                f8 = f9;
            }
        }
        return f8;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f8 = fArr[0];
        for (int i7 = 1; i7 < fArr.length; i7++) {
            if (Float.isNaN(fArr[i7])) {
                return Float.NaN;
            }
            float f9 = fArr[i7];
            if (f9 < f8) {
                f8 = f9;
            }
        }
        return f8;
    }

    public static double max(double d8, double d9, double d10) {
        return Math.max(Math.max(d8, d9), d10);
    }

    public static double min(double d8, double d9, double d10) {
        return Math.min(Math.min(d8, d9), d10);
    }

    public static float max(float f8, float f9, float f10) {
        return Math.max(Math.max(f8, f9), f10);
    }

    public static float min(float f8, float f9, float f10) {
        return Math.min(Math.min(f8, f9), f10);
    }
}
