package org.apache.commons.lang3.text;

import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes3.dex */
public class FormattableUtils {
    private static final String SIMPLEST_FORMAT = "%s";

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i7, int i8, int i9) {
        return append(charSequence, formatter, i7, i8, i9, ' ', null);
    }

    public static String toString(Formattable formattable) {
        return String.format(SIMPLEST_FORMAT, formattable);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i7, int i8, int i9, char c8) {
        return append(charSequence, formatter, i7, i8, i9, c8, null);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i7, int i8, int i9, CharSequence charSequence2) {
        return append(charSequence, formatter, i7, i8, i9, ' ', charSequence2);
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i7, int i8, int i9, char c8, CharSequence charSequence2) {
        Validate.isTrue(charSequence2 == null || i9 < 0 || charSequence2.length() <= i9, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, Integer.valueOf(i9));
        StringBuilder sb = new StringBuilder(charSequence);
        if (i9 >= 0 && i9 < charSequence.length()) {
            CharSequence charSequence3 = (CharSequence) ObjectUtils.defaultIfNull(charSequence2, "");
            sb.replace(i9 - charSequence3.length(), charSequence.length(), charSequence3.toString());
        }
        boolean z7 = (i7 & 1) == 1;
        for (int length = sb.length(); length < i8; length++) {
            sb.insert(z7 ? length : 0, c8);
        }
        formatter.format(sb.toString(), new Object[0]);
        return formatter;
    }
}
