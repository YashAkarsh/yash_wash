package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes3.dex */
public class CharSetUtils {
    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet charSet = CharSet.getInstance(strArr);
            for (char c8 : str.toCharArray()) {
                if (charSet.contains(c8)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        int i7 = 0;
        for (char c8 : str.toCharArray()) {
            if (charSet.contains(c8)) {
                i7++;
            }
        }
        return i7;
    }

    private static boolean deepEmpty(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (StringUtils.isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        return (str.isEmpty() || deepEmpty(strArr)) ? "" : modify(str, strArr, true);
    }

    private static String modify(String str, String[] strArr, boolean z7) {
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (charSet.contains(charArray[i7]) == z7) {
                sb.append(charArray[i7]);
            }
        }
        return sb.toString();
    }

    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c8 = ' ';
        for (int i7 = 0; i7 < length; i7++) {
            char c9 = charArray[i7];
            if (c9 != c8 || i7 == 0 || !charSet.contains(c9)) {
                sb.append(c9);
                c8 = c9;
            }
        }
        return sb.toString();
    }
}
