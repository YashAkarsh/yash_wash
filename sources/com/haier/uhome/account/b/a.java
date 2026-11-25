package com.haier.uhome.account.b;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(String str) {
        return a(3, 15, str) && g(str);
    }

    public static boolean b(String str) {
        return a(6, 20, str);
    }

    public static boolean c(String str) {
        return a("^\\w+([.+-]\\w+)*@\\w+([.-]\\w+)*(\\.\\w{2,5})+$", str);
    }

    public static boolean d(String str) {
        return a("^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,16}$", str);
    }

    public static boolean e(String str) {
        return a("^1[0-9]{10}$", str);
    }

    public static boolean f(String str) {
        return a("^\\w+([.+-]\\w+)*@\\w+([.-]\\w+)*(\\.\\w{2,5})+$", str);
    }

    public static boolean g(String str) {
        return a("[^'\"-\\/:;*?<>|%&#+]{1,}", str);
    }

    public static boolean h(String str) {
        return a("[0-9]*", str);
    }

    public static boolean a(int i7, int i8, String str) {
        return str.length() >= i7 && str.length() <= i8;
    }

    public static boolean a(Object obj) {
        return obj == null || obj.equals("");
    }

    private static boolean a(String str, CharSequence charSequence) {
        return Pattern.compile(str).matcher(charSequence).matches();
    }
}
