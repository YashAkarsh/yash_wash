package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes3.dex */
public class CharUtils {
    public static final char CR = '\r';
    public static final char LF = '\n';
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        char c8 = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c8 >= strArr.length) {
                return;
            }
            strArr[c8] = String.valueOf(c8);
            c8 = (char) (c8 + 1);
        }
    }

    public static int compare(char c8, char c9) {
        return c8 - c9;
    }

    public static boolean isAscii(char c8) {
        return c8 < 128;
    }

    public static boolean isAsciiAlpha(char c8) {
        return isAsciiAlphaUpper(c8) || isAsciiAlphaLower(c8);
    }

    public static boolean isAsciiAlphaLower(char c8) {
        return c8 >= 'a' && c8 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c8) {
        return c8 >= 'A' && c8 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c8) {
        return isAsciiAlpha(c8) || isAsciiNumeric(c8);
    }

    public static boolean isAsciiControl(char c8) {
        return c8 < ' ' || c8 == 127;
    }

    public static boolean isAsciiNumeric(char c8) {
        return c8 >= '0' && c8 <= '9';
    }

    public static boolean isAsciiPrintable(char c8) {
        return c8 >= ' ' && c8 < 127;
    }

    public static char toChar(Character ch) {
        if (ch != null) {
            return ch.charValue();
        }
        throw new IllegalArgumentException("The Character must not be null");
    }

    @Deprecated
    public static Character toCharacterObject(char c8) {
        return Character.valueOf(c8);
    }

    public static int toIntValue(char c8) {
        if (isAsciiNumeric(c8)) {
            return c8 - '0';
        }
        throw new IllegalArgumentException("The character " + c8 + " is not in the range '0' - '9'");
    }

    public static String toString(char c8) {
        return c8 < 128 ? CHAR_STRING_ARRAY[c8] : new String(new char[]{c8});
    }

    public static String unicodeEscaped(char c8) {
        StringBuilder sb = new StringBuilder(6);
        sb.append("\\u");
        char[] cArr = HEX_DIGITS;
        sb.append(cArr[(c8 >> '\f') & 15]);
        sb.append(cArr[(c8 >> '\b') & 15]);
        sb.append(cArr[(c8 >> 4) & 15]);
        sb.append(cArr[c8 & 15]);
        return sb.toString();
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static char toChar(Character ch, char c8) {
        return ch == null ? c8 : ch.charValue();
    }

    public static int toIntValue(char c8, int i7) {
        return !isAsciiNumeric(c8) ? i7 : c8 - '0';
    }

    public static String toString(Character ch) {
        if (ch == null) {
            return null;
        }
        return toString(ch.charValue());
    }

    public static char toChar(String str) {
        if (!StringUtils.isEmpty(str)) {
            return str.charAt(0);
        }
        throw new IllegalArgumentException("The String must not be empty");
    }

    public static int toIntValue(Character ch) {
        if (ch != null) {
            return toIntValue(ch.charValue());
        }
        throw new IllegalArgumentException("The character must not be null");
    }

    public static int toIntValue(Character ch, int i7) {
        return ch == null ? i7 : toIntValue(ch.charValue(), i7);
    }

    public static char toChar(String str, char c8) {
        return StringUtils.isEmpty(str) ? c8 : str.charAt(0);
    }

    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }
}
