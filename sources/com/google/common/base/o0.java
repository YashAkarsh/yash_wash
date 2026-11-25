package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public final class o0 {
    private o0() {
    }

    public static String a(CharSequence charSequence, CharSequence charSequence2) {
        e0.E(charSequence);
        e0.E(charSequence2);
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i7 = 0;
        while (i7 < iMin && charSequence.charAt(i7) == charSequence2.charAt(i7)) {
            i7++;
        }
        int i8 = i7 - 1;
        if (k(charSequence, i8) || k(charSequence2, i8)) {
            i7--;
        }
        return charSequence.subSequence(0, i7).toString();
    }

    public static String b(CharSequence charSequence, CharSequence charSequence2) {
        e0.E(charSequence);
        e0.E(charSequence2);
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i7 = 0;
        while (i7 < iMin && charSequence.charAt((charSequence.length() - i7) - 1) == charSequence2.charAt((charSequence2.length() - i7) - 1)) {
            i7++;
        }
        if (k(charSequence, (charSequence.length() - i7) - 1) || k(charSequence2, (charSequence2.length() - i7) - 1)) {
            i7--;
        }
        return charSequence.subSequence(charSequence.length() - i7, charSequence.length()).toString();
    }

    public static String c(String str) {
        return d0.b(str);
    }

    public static boolean d(String str) {
        return d0.j(str);
    }

    public static String e(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        int i7 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i8 = 0; i8 < objArr.length; i8++) {
                objArr[i8] = f(objArr[i8]);
            }
        }
        StringBuilder sb = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i9 = 0;
        while (i7 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i9)) != -1) {
            sb.append((CharSequence) strValueOf, i9, iIndexOf);
            sb.append(objArr[i7]);
            i9 = iIndexOf + 2;
            i7++;
        }
        sb.append((CharSequence) strValueOf, i9, strValueOf.length());
        if (i7 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i7]);
            for (int i10 = i7 + 1; i10 < objArr.length; i10++) {
                sb.append(", ");
                sb.append(objArr[i10]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String f(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e8) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e8);
            return "<" + str + " threw " + e8.getClass().getName() + ">";
        }
    }

    public static String g(String str) {
        return d0.g(str);
    }

    public static String h(String str, int i7, char c8) {
        e0.E(str);
        if (str.length() >= i7) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i7);
        sb.append(str);
        for (int length = str.length(); length < i7; length++) {
            sb.append(c8);
        }
        return sb.toString();
    }

    public static String i(String str, int i7, char c8) {
        e0.E(str);
        if (str.length() >= i7) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i7);
        for (int length = str.length(); length < i7; length++) {
            sb.append(c8);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String j(String str, int i7) {
        e0.E(str);
        if (i7 <= 1) {
            e0.k(i7 >= 0, "invalid count: %s", i7);
            return i7 == 0 ? "" : str;
        }
        int length = str.length();
        long j7 = ((long) length) * ((long) i7);
        int i8 = (int) j7;
        if (i8 != j7) {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j7);
        }
        char[] cArr = new char[i8];
        str.getChars(0, length, cArr, 0);
        while (true) {
            int i9 = i8 - length;
            if (length >= i9) {
                System.arraycopy(cArr, 0, cArr, length, i9);
                return new String(cArr);
            }
            System.arraycopy(cArr, 0, cArr, length, length);
            length <<= 1;
        }
    }

    @s1.d
    static boolean k(CharSequence charSequence, int i7) {
        return i7 >= 0 && i7 <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i7)) && Character.isLowSurrogate(charSequence.charAt(i7 + 1));
    }
}
