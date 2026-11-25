package com.haier.globalwasher.modle.utils;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24639a = "^[a-zA-Z]\\w{5,17}$";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f24640b = "^[a-zA-Z0-9]{6,16}$";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f24641c = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f24642d = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f24643e = "^[一-龥]{1,9}$";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f24644f = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f24645g = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f24646h = "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";

    public static boolean a(String str) {
        return Pattern.matches(f24643e, str);
    }

    public static boolean b(String str) {
        return Pattern.matches(f24642d, str);
    }

    public static boolean c(String str) {
        return Pattern.matches(f24644f, str);
    }

    public static boolean d(String str) {
        return Pattern.matches(f24646h, str);
    }

    public static boolean e(String str, String str2) {
        return Pattern.matches(str, str2);
    }

    public static boolean f(String str) {
        return Pattern.matches(f24640b, str);
    }

    public static boolean g(String str) {
        return Pattern.matches(f24645g, str);
    }

    public static boolean h(String str) {
        return Pattern.matches(f24639a, str);
    }
}
