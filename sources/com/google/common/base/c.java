package com.google.common.base;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public final class c {
    public static final byte A = 23;
    public static final byte B = 24;
    public static final byte C = 25;
    public static final byte D = 26;
    public static final byte E = 27;
    public static final byte F = 28;
    public static final byte G = 29;
    public static final byte H = 30;
    public static final byte I = 31;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final byte f19300J = 32;
    public static final byte K = 32;
    public static final byte L = 127;
    public static final char M = 0;
    public static final char N = 127;
    private static final char O = ' ';

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f19301a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f19302b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f19303c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f19304d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f19305e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f19306f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f19307g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f19308h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f19309i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f19310j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f19311k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte f19312l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte f19313m = 11;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte f19314n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte f19315o = 13;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte f19316p = 14;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte f19317q = 15;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte f19318r = 16;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte f19319s = 17;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte f19320t = 17;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final byte f19321u = 18;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final byte f19322v = 19;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte f19323w = 19;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte f19324x = 20;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final byte f19325y = 21;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final byte f19326z = 22;

    private c() {
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int iB;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = charSequence.charAt(i7);
            char cCharAt2 = charSequence2.charAt(i7);
            if (cCharAt != cCharAt2 && ((iB = b(cCharAt)) >= 26 || iB != b(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    private static int b(char c8) {
        return (char) ((c8 | O) - 97);
    }

    public static boolean c(char c8) {
        return c8 >= 'a' && c8 <= 'z';
    }

    public static boolean d(char c8) {
        return c8 >= 'A' && c8 <= 'Z';
    }

    public static char e(char c8) {
        return d(c8) ? (char) (c8 ^ O) : c8;
    }

    public static String f(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return g((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i7 = 0; i7 < length; i7++) {
            cArr[i7] = e(charSequence.charAt(i7));
        }
        return String.valueOf(cArr);
    }

    public static String g(String str) {
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            if (d(str.charAt(i7))) {
                char[] charArray = str.toCharArray();
                while (i7 < length) {
                    char c8 = charArray[i7];
                    if (d(c8)) {
                        charArray[i7] = (char) (c8 ^ O);
                    }
                    i7++;
                }
                return String.valueOf(charArray);
            }
            i7++;
        }
        return str;
    }

    public static char h(char c8) {
        return c(c8) ? (char) (c8 ^ O) : c8;
    }

    public static String i(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return j((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i7 = 0; i7 < length; i7++) {
            cArr[i7] = h(charSequence.charAt(i7));
        }
        return String.valueOf(cArr);
    }

    public static String j(String str) {
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            if (c(str.charAt(i7))) {
                char[] charArray = str.toCharArray();
                while (i7 < length) {
                    char c8 = charArray[i7];
                    if (c(c8)) {
                        charArray[i7] = (char) (c8 ^ O);
                    }
                    i7++;
                }
                return String.valueOf(charArray);
            }
            i7++;
        }
        return str;
    }

    public static String k(CharSequence charSequence, int i7, String str) {
        String string;
        e0.E(charSequence);
        int length = i7 - str.length();
        e0.m(length >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", i7, str.length());
        int length2 = charSequence.length();
        CharSequence charSequence2 = charSequence;
        if (length2 <= i7) {
            string = charSequence.toString();
            if (string.length() <= i7) {
                charSequence2 = string;
                return string;
            }
        }
        charSequence2 = string;
        StringBuilder sb = new StringBuilder(i7);
        sb.append(charSequence2, 0, length);
        sb.append(str);
        return sb.toString();
    }
}
