package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.b1;
import kotlin.collections.u0;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.t0;

/* JADX INFO: loaded from: classes2.dex */
class d0 extends c0 {
    @kotlin.internal.f
    private static final char W5(CharSequence charSequence, int i7) {
        l0.p(charSequence, "<this>");
        return charSequence.charAt(i7);
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character X5(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return e0.P7(charSequence);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character Y5(CharSequence charSequence, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iI3 = c0.i3(charSequence);
        if (iI3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rZ = selector.z(Character.valueOf(cCharAt));
        u0 it = new kotlin.ranges.k(1, iI3).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            R rZ2 = selector.z(Character.valueOf(cCharAt2));
            if (rZ.compareTo(rZ2) < 0) {
                cCharAt = cCharAt2;
                rZ = rZ2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character Z5(CharSequence charSequence, Comparator comparator) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        return e0.R7(charSequence, comparator);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character a6(CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return e0.d8(charSequence);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character b6(CharSequence charSequence, i5.l<? super Character, ? extends R> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iI3 = c0.i3(charSequence);
        if (iI3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rZ = selector.z(Character.valueOf(cCharAt));
        u0 it = new kotlin.ranges.k(1, iI3).iterator();
        while (it.hasNext()) {
            char cCharAt2 = charSequence.charAt(it.b());
            R rZ2 = selector.z(Character.valueOf(cCharAt2));
            if (rZ.compareTo(rZ2) > 0) {
                cCharAt = cCharAt2;
                rZ = rZ2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character c6(CharSequence charSequence, Comparator comparator) {
        l0.p(charSequence, "<this>");
        l0.p(comparator, "comparator");
        return e0.f8(charSequence, comparator);
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @t0
    @kotlin.internal.f
    private static final BigDecimal d6(CharSequence charSequence, i5.l<? super Character, ? extends BigDecimal> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Character.valueOf(charSequence.charAt(i7))));
            l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @t0
    @kotlin.internal.f
    private static final BigInteger e6(CharSequence charSequence, i5.l<? super Character, ? extends BigInteger> selector) {
        l0.p(charSequence, "<this>");
        l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Character.valueOf(charSequence.charAt(i7))));
            l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @a7.d
    public static final SortedSet<Character> f6(@a7.d CharSequence charSequence) {
        l0.p(charSequence, "<this>");
        return (SortedSet) e0.e9(charSequence, new TreeSet());
    }
}
