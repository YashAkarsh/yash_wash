package org.apache.commons.lang3.text;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WordUtils {
    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, null);
    }

    public static String initials(String str) {
        return initials(str, null);
    }

    private static boolean isDelimiter(char c8, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c8);
        }
        for (char c9 : cArr) {
            if (c8 == c9) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean zIsWhitespace = true;
        int i7 = 0;
        while (i7 < charArray.length) {
            char c8 = charArray[i7];
            if (Character.isUpperCase(c8) || Character.isTitleCase(c8)) {
                charArray[i7] = Character.toLowerCase(c8);
            } else {
                if (!Character.isLowerCase(c8)) {
                    zIsWhitespace = Character.isWhitespace(c8);
                } else if (zIsWhitespace) {
                    charArray[i7] = Character.toTitleCase(c8);
                } else {
                    charArray[i7] = Character.toUpperCase(c8);
                }
                i7++;
            }
            zIsWhitespace = false;
            i7++;
        }
        return new String(charArray);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, null);
    }

    public static String wrap(String str, int i7) {
        return wrap(str, i7, null, false);
    }

    public static String capitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z7 = true;
        for (int i7 = 0; i7 < charArray.length; i7++) {
            char c8 = charArray[i7];
            if (isDelimiter(c8, cArr)) {
                z7 = true;
            } else if (z7) {
                charArray[i7] = Character.toTitleCase(c8);
                z7 = false;
            }
        }
        return new String(charArray);
    }

    public static String capitalizeFully(String str, char... cArr) {
        return (StringUtils.isEmpty(str) || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[(length / 2) + 1];
        boolean z7 = true;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (isDelimiter(cCharAt, cArr)) {
                z7 = true;
            } else if (z7) {
                cArr2[i7] = cCharAt;
                i7++;
                z7 = false;
            }
        }
        return new String(cArr2, 0, i7);
    }

    public static String uncapitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z7 = true;
        for (int i7 = 0; i7 < charArray.length; i7++) {
            char c8 = charArray[i7];
            if (isDelimiter(c8, cArr)) {
                z7 = true;
            } else if (z7) {
                charArray[i7] = Character.toLowerCase(c8);
                z7 = false;
            }
        }
        return new String(charArray);
    }

    public static String wrap(String str, int i7, String str2, boolean z7) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = SystemUtils.LINE_SEPARATOR;
        }
        if (i7 < 1) {
            i7 = 1;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 32);
        int i8 = 0;
        while (i8 < length) {
            if (str.charAt(i8) == ' ') {
                i8++;
            } else {
                if (length - i8 <= i7) {
                    break;
                }
                int i9 = i7 + i8;
                int iLastIndexOf = str.lastIndexOf(32, i9);
                if (iLastIndexOf >= i8) {
                    sb.append(str.substring(i8, iLastIndexOf));
                    sb.append(str2);
                    i8 = iLastIndexOf + 1;
                } else {
                    if (z7) {
                        sb.append(str.substring(i8, i9));
                        sb.append(str2);
                    } else {
                        int iIndexOf = str.indexOf(32, i9);
                        if (iIndexOf >= 0) {
                            sb.append(str.substring(i8, iIndexOf));
                            sb.append(str2);
                            i9 = iIndexOf + 1;
                        } else {
                            sb.append(str.substring(i8));
                            i8 = length;
                        }
                    }
                    i8 = i9;
                }
            }
        }
        sb.append(str.substring(i8));
        return sb.toString();
    }
}
