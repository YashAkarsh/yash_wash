package kotlin.text;

import java.util.Locale;
import kotlin.a1;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.q2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String A(char c8) {
        String strValueOf = String.valueOf(c8);
        l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        l0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    public static final String B(char c8, @a7.d Locale locale) {
        l0.p(locale, "locale");
        String strValueOf = String.valueOf(c8);
        l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        l0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final char C(char c8) {
        return Character.toUpperCase(c8);
    }

    @a1
    public static int a(int i7) {
        if (new kotlin.ranges.k(2, 36).m(i7)) {
            return i7;
        }
        throw new IllegalArgumentException("radix " + i7 + " was not in valid range " + new kotlin.ranges.k(2, 36));
    }

    public static final int b(char c8, int i7) {
        return Character.digit((int) c8, i7);
    }

    @a7.d
    public static final a c(char c8) {
        return a.f35282c.a(Character.getType(c8));
    }

    @a7.d
    public static final b d(char c8) {
        return b.f35308b.b(Character.getDirectionality(c8));
    }

    @kotlin.internal.f
    private static final boolean e(char c8) {
        return Character.isDefined(c8);
    }

    @kotlin.internal.f
    private static final boolean f(char c8) {
        return Character.isDigit(c8);
    }

    @kotlin.internal.f
    private static final boolean g(char c8) {
        return Character.isHighSurrogate(c8);
    }

    @kotlin.internal.f
    private static final boolean h(char c8) {
        return Character.isISOControl(c8);
    }

    @kotlin.internal.f
    private static final boolean i(char c8) {
        return Character.isIdentifierIgnorable(c8);
    }

    @kotlin.internal.f
    private static final boolean j(char c8) {
        return Character.isJavaIdentifierPart(c8);
    }

    @kotlin.internal.f
    private static final boolean k(char c8) {
        return Character.isJavaIdentifierStart(c8);
    }

    @kotlin.internal.f
    private static final boolean l(char c8) {
        return Character.isLetter(c8);
    }

    @kotlin.internal.f
    private static final boolean m(char c8) {
        return Character.isLetterOrDigit(c8);
    }

    @kotlin.internal.f
    private static final boolean n(char c8) {
        return Character.isLowSurrogate(c8);
    }

    @kotlin.internal.f
    private static final boolean o(char c8) {
        return Character.isLowerCase(c8);
    }

    @kotlin.internal.f
    private static final boolean p(char c8) {
        return Character.isTitleCase(c8);
    }

    @kotlin.internal.f
    private static final boolean q(char c8) {
        return Character.isUpperCase(c8);
    }

    public static final boolean r(char c8) {
        return Character.isWhitespace(c8) || Character.isSpaceChar(c8);
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final String s(char c8) {
        String strValueOf = String.valueOf(c8);
        l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    public static final String t(char c8, @a7.d Locale locale) {
        l0.p(locale, "locale");
        String strValueOf = String.valueOf(c8);
        l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final char u(char c8) {
        return Character.toLowerCase(c8);
    }

    @a7.d
    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    public static final String v(char c8, @a7.d Locale locale) {
        l0.p(locale, "locale");
        String strB = B(c8, locale);
        if (strB.length() <= 1) {
            String strValueOf = String.valueOf(c8);
            l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            l0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return !l0.g(strB, upperCase) ? strB : String.valueOf(Character.toTitleCase(c8));
        }
        if (c8 == 329) {
            return strB;
        }
        char cCharAt = strB.charAt(0);
        l0.n(strB, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strB.substring(1);
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return cCharAt + lowerCase;
    }

    @g1(version = "1.5")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final char w(char c8) {
        return Character.toTitleCase(c8);
    }

    @kotlin.k(message = "Use lowercaseChar() instead.", replaceWith = @b1(expression = "lowercaseChar()", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @kotlin.internal.f
    private static final char x(char c8) {
        return Character.toLowerCase(c8);
    }

    @kotlin.k(message = "Use titlecaseChar() instead.", replaceWith = @b1(expression = "titlecaseChar()", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @kotlin.internal.f
    private static final char y(char c8) {
        return Character.toTitleCase(c8);
    }

    @kotlin.k(message = "Use uppercaseChar() instead.", replaceWith = @b1(expression = "uppercaseChar()", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @kotlin.internal.f
    private static final char z(char c8) {
        return Character.toUpperCase(c8);
    }
}
