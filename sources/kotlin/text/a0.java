package kotlin.text;

import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class a0 extends z {
    @a7.d
    public static final Void U0(@a7.d String input) {
        l0.p(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @g1(version = "1.1")
    @a7.e
    public static final Byte V0(@a7.d String str) {
        l0.p(str, "<this>");
        return W0(str, 10);
    }

    @g1(version = "1.1")
    @a7.e
    public static final Byte W0(@a7.d String str, int i7) {
        int iIntValue;
        l0.p(str, "<this>");
        Integer numY0 = Y0(str, i7);
        if (numY0 == null || (iIntValue = numY0.intValue()) < -128 || iIntValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) iIntValue);
    }

    @g1(version = "1.1")
    @a7.e
    public static Integer X0(@a7.d String str) {
        l0.p(str, "<this>");
        return Y0(str, 10);
    }

    @g1(version = "1.1")
    @a7.e
    public static final Integer Y0(@a7.d String str, int i7) {
        boolean z7;
        int i8;
        int i9;
        l0.p(str, "<this>");
        d.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        int i11 = -2147483647;
        if (l0.t(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i11 = Integer.MIN_VALUE;
                z7 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z7 = false;
            }
        } else {
            z7 = false;
            i8 = 0;
        }
        int i12 = -59652323;
        while (i8 < length) {
            int iB = d.b(str.charAt(i8), i7);
            if (iB < 0) {
                return null;
            }
            if ((i10 < i12 && (i12 != -59652323 || i10 < (i12 = i11 / i7))) || (i9 = i10 * i7) < i11 + iB) {
                return null;
            }
            i10 = i9 - iB;
            i8++;
        }
        return z7 ? Integer.valueOf(i10) : Integer.valueOf(-i10);
    }

    @g1(version = "1.1")
    @a7.e
    public static Long Z0(@a7.d String str) {
        l0.p(str, "<this>");
        return a1(str, 10);
    }

    @g1(version = "1.1")
    @a7.e
    public static final Long a1(@a7.d String str, int i7) {
        boolean z7;
        l0.p(str, "<this>");
        d.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char cCharAt = str.charAt(0);
        long j7 = -9223372036854775807L;
        if (l0.t(cCharAt, 48) < 0) {
            z7 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j7 = Long.MIN_VALUE;
                i8 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z7 = false;
                i8 = 1;
            }
        } else {
            z7 = false;
        }
        long j8 = -256204778801521550L;
        long j9 = 0;
        long j10 = -256204778801521550L;
        while (i8 < length) {
            int iB = d.b(str.charAt(i8), i7);
            if (iB < 0) {
                return null;
            }
            if (j9 < j10) {
                if (j10 == j8) {
                    j10 = j7 / ((long) i7);
                    if (j9 < j10) {
                    }
                }
                return null;
            }
            long j11 = j9 * ((long) i7);
            long j12 = iB;
            if (j11 < j7 + j12) {
                return null;
            }
            j9 = j11 - j12;
            i8++;
            j8 = -256204778801521550L;
        }
        return z7 ? Long.valueOf(j9) : Long.valueOf(-j9);
    }

    @g1(version = "1.1")
    @a7.e
    public static final Short b1(@a7.d String str) {
        l0.p(str, "<this>");
        return c1(str, 10);
    }

    @g1(version = "1.1")
    @a7.e
    public static final Short c1(@a7.d String str, int i7) {
        int iIntValue;
        l0.p(str, "<this>");
        Integer numY0 = Y0(str, i7);
        if (numY0 == null || (iIntValue = numY0.intValue()) < -32768 || iIntValue > 32767) {
            return null;
        }
        return Short.valueOf((short) iIntValue);
    }
}
