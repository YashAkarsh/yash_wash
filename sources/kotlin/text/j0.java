package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    @a7.d
    public static final String a(char c8) {
        String strValueOf = String.valueOf(c8);
        l0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        l0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c8));
        }
        if (c8 == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        l0.n(upperCase, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = upperCase.substring(1);
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        l0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return cCharAt + lowerCase;
    }
}
