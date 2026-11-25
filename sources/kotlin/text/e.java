package kotlin.text;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
class e extends d {
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    public static final char D(int i7) {
        if (new kotlin.ranges.k(0, 9).m(i7)) {
            return (char) (i7 + 48);
        }
        throw new IllegalArgumentException("Int " + i7 + " is not a decimal digit");
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    public static final char E(int i7, int i8) {
        if (!new kotlin.ranges.k(2, 36).m(i8)) {
            throw new IllegalArgumentException("Invalid radix: " + i8 + ". Valid radix values are in range 2..36");
        }
        if (i7 >= 0 && i7 < i8) {
            return (char) (i7 < 10 ? i7 + 48 : ((char) (i7 + 65)) - '\n');
        }
        throw new IllegalArgumentException("Digit " + i7 + " does not represent a valid digit in radix " + i8);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    public static final int F(char c8) {
        int iB = d.b(c8, 10);
        if (iB >= 0) {
            return iB;
        }
        throw new IllegalArgumentException("Char " + c8 + " is not a decimal digit");
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    public static final int G(char c8, int i7) {
        Integer numI = I(c8, i7);
        if (numI != null) {
            return numI.intValue();
        }
        throw new IllegalArgumentException("Char " + c8 + " is not a digit in the given radix=" + i7);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Integer H(char c8) {
        Integer numValueOf = Integer.valueOf(d.b(c8, 10));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Integer I(char c8, int i7) {
        d.a(i7);
        Integer numValueOf = Integer.valueOf(d.b(c8, i7));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    public static final boolean J(char c8, char c9, boolean z7) {
        if (c8 == c9) {
            return true;
        }
        if (!z7) {
            return false;
        }
        char upperCase = Character.toUpperCase(c8);
        char upperCase2 = Character.toUpperCase(c9);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static /* synthetic */ boolean K(char c8, char c9, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return J(c8, c9, z7);
    }

    public static final boolean L(char c8) {
        return new kotlin.ranges.c((char) 55296, (char) 57343).m(c8);
    }

    @kotlin.internal.f
    private static final String M(char c8, String other) {
        l0.p(other, "other");
        return c8 + other;
    }

    @a7.d
    @g1(version = "1.5")
    public static final String N(char c8) {
        return j0.a(c8);
    }
}
