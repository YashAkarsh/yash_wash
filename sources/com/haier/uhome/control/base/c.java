package com.haier.uhome.control.base;

import android.text.TextUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f28858b = "[0-9a-fA-F]{12}";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f28857a = "_1-";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f28859c = String.format("%s(%s)\\d+", f28858b, f28857a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f28860d = Collections.singletonList("01c12002400081034080000000100000");

    private c() {
    }

    public static String a(String str, int i7) {
        return String.format(Locale.ENGLISH, "%s%s%d", str, f28857a, Integer.valueOf(i7));
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str) || !Pattern.matches(f28859c, str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str.substring(str.lastIndexOf(f28857a) + 3));
        } catch (NumberFormatException unused) {
            e3.a.e("parseSubNo %s Error~", str);
            return 0;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches(f28859c, str);
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = f28860d.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && Pattern.matches(f28859c, str)) {
            return str.substring(0, str.indexOf(f28857a));
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !Pattern.matches(f28858b, str) || !Pattern.matches(f28859c, str2)) {
            return false;
        }
        return str.equals(a(str2));
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.equals(a(str2)) || str2.equals(a(str));
    }
}
