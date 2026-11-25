package com.haier.library.common.util;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26563a = " ";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f26564b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f26565c = "\n";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f26566d = "\r";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f26567e = "0123456789abcdef";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f26568f = "^(\\d\\.){2}\\d{2}$";

    private c() {
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            for (byte b8 : bArr) {
                String hexString = Integer.toHexString(b8 & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
        }
        return sb.toString();
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            e3.a.u("invalid version first=%s ,second=%s", str, str2, new Object[0]);
            return false;
        }
        if (!str.matches(f26568f) || !str2.matches(f26568f)) {
            e3.a.u("invalid version first=%s ,second=%s", str, str2, new Object[0]);
            return false;
        }
        try {
            return str.compareTo(str2) > 0;
        } catch (Exception e8) {
            e3.a.h(e(e8), new Object[0]);
            return false;
        }
    }

    public static boolean c(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? charSequence.equals(charSequence2) : p(charSequence, false, 0, charSequence2, 0, charSequence.length());
    }

    public static boolean d(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        return p(charSequence, true, 0, charSequence2, 0, charSequence.length());
    }

    public static String e(Exception exc) {
        if (exc == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
                try {
                    exc.printStackTrace(printWriter);
                    String string = byteArrayOutputStream.toString();
                    printWriter.close();
                    byteArrayOutputStream.close();
                    return string;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            printWriter.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (Exception e8) {
            e3.a.e("exception2String get excp %s", e8);
            return exc.getMessage();
        }
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static byte[] g(String str) {
        if (!k(str)) {
            e3.a.v("hex2Binary source not hex only!", new Object[0]);
            return new byte[0];
        }
        if (str.length() % 2 != 0) {
            e3.a.v("hex2Binary source length not div 2 !", new Object[0]);
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 * 2;
            bArr[i7] = (byte) (((byte) f26567e.indexOf(lowerCase.charAt(i8 + 1))) | ((byte) (f26567e.indexOf(lowerCase.charAt(i8)) << 4)));
        }
        return bArr;
    }

    public static int h(String str, int i7) {
        return i(str, i7, str.length());
    }

    public static int i(String str, int i7, int i8) {
        try {
            return Integer.valueOf(str.substring(i7, i8), 16).intValue();
        } catch (Exception unused) {
            e3.a.v("hex2Int error %s(%d-%d) is not integer.", str, Integer.valueOf(i7), Integer.valueOf(i8));
            return -1;
        }
    }

    public static boolean j(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i7 = 0; i7 < length; i7++) {
                if (!Character.isWhitespace(charSequence.charAt(i7))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean k(String str) {
        if (m(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length();
        for (int i7 = 0; i7 < length; i7++) {
            if (-1 == f26567e.indexOf(lowerCase.charAt(i7))) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(CharSequence charSequence) {
        return !j(charSequence);
    }

    public static boolean m(String str) {
        return str == null || TextUtils.isEmpty(str.trim());
    }

    public static String n(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String o(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null) {
            for (byte b8 : bArr) {
                sb.append("0x");
                String upperCase = Integer.toHexString(b8 & 255).toUpperCase();
                if (upperCase.length() < 2) {
                    sb.append(0);
                }
                sb.append(upperCase);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    private static boolean p(CharSequence charSequence, boolean z7, int i7, CharSequence charSequence2, int i8, int i9) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z7, i7, (String) charSequence2, i8, i9);
        }
        int length = charSequence.length() - i7;
        int length2 = charSequence2.length() - i8;
        if (i7 < 0 || i8 < 0 || i9 < 0 || length < i9 || length2 < i9) {
            return false;
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

    public static String q(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String strSubstring = str.startsWith(str2) ? str.substring(str2.length()) : str;
        return str.endsWith(str2) ? strSubstring.substring(0, strSubstring.length() - str2.length()) : strSubstring;
    }
}
