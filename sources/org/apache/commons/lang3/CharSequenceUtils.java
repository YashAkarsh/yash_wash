package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes3.dex */
public class CharSequenceUtils {
    private static final int NOT_FOUND = -1;

    static int indexOf(CharSequence charSequence, int i7, int i8) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(i7, i8);
        }
        int length = charSequence.length();
        if (i8 < 0) {
            i8 = 0;
        }
        while (i8 < length) {
            if (charSequence.charAt(i8) == i7) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    static int lastIndexOf(CharSequence charSequence, int i7, int i8) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(i7, i8);
        }
        int length = charSequence.length();
        if (i8 < 0) {
            return -1;
        }
        if (i8 >= length) {
            i8 = length - 1;
        }
        while (i8 >= 0) {
            if (charSequence.charAt(i8) == i7) {
                return i8;
            }
            i8--;
        }
        return -1;
    }

    static boolean regionMatches(CharSequence charSequence, boolean z7, int i7, CharSequence charSequence2, int i8, int i9) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z7, i7, (String) charSequence2, i8, i9);
        }
        while (true) {
            int i10 = i9 - 1;
            if (i9 <= 0) {
                return true;
            }
            int i11 = i7 + 1;
            char cCharAt = charSequence.charAt(i7);
            int i12 = i8 + 1;
            char cCharAt2 = charSequence2.charAt(i8);
            if (cCharAt != cCharAt2) {
                if (!z7) {
                    return false;
                }
                if (Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                    return false;
                }
            }
            i7 = i11;
            i9 = i10;
            i8 = i12;
        }
    }

    public static CharSequence subSequence(CharSequence charSequence, int i7) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i7, charSequence.length());
    }

    static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i7 = 0; i7 < length; i7++) {
            cArr[i7] = charSequence.charAt(i7);
        }
        return cArr;
    }

    static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i7) {
        return charSequence.toString().indexOf(charSequence2.toString(), i7);
    }

    static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i7) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i7);
    }
}
