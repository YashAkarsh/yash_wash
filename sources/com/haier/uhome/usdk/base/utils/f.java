package com.haier.uhome.usdk.base.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.haier.library.common.util.u;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f31400a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f31401b = 14;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f31402c = "0";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f31403d = "^[1-9].*$";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f31404e = "^(0\\w{31})|([1-9]\\w{63})$";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f31405f = Pattern.compile("([A-Fa-f0-9]{2}:){5}[A-Fa-f0-9]{2}");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f31406g = ":";

    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f31408b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.haier.uhome.usdk.base.api.h f31407a = com.haier.uhome.usdk.base.api.h.UNKNOWN;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f31409c = "";

        public int b() {
            return this.f31408b;
        }

        public String c() {
            return this.f31409c;
        }

        public String toString() {
            return "DeviceTypeInfo{mainType=" + this.f31407a + ", middleType=" + this.f31408b + ", specialId=" + this.f31409c + '}';
        }

        public com.haier.uhome.usdk.base.api.h a() {
            return this.f31407a;
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str) || !str.matches(f31404e)) {
            e3.a.h("parse %s type and specialId failed.", str);
            return null;
        }
        try {
            a aVar = new a();
            if (str.startsWith("0")) {
                a(str, aVar);
            } else if (str.matches(f31403d)) {
                b(str, aVar);
            }
            return aVar;
        } catch (Exception e8) {
            e3.a.h("Invalid uplusId:%s -> %s", str, e8);
            return null;
        }
    }

    private static void b(String str, a aVar) {
        aVar.f31407a = com.haier.uhome.usdk.base.api.h.a(a(str, 16, 1, 4, 0));
        aVar.f31408b = a(str, 18, 1, 4, 0);
        if ((a(str, 62, 1, 4, 0) & 128) == 0) {
            aVar.f31409c = String.format("%s%s%s%s", str.substring(20, 30), a(a(str, 30, 1, 4, 0)), a(a(str, 32, 1, 4, 0)), a(a(str, 34, 1, 4, 0)));
        } else {
            aVar.f31409c = "";
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.length() > 64 || str.length() < 8;
    }

    public static String d(String str) {
        if (com.haier.library.common.util.c.m(str)) {
            return "";
        }
        return str.contains(f31406g) ? str.replaceAll(f31406g, "") : str;
    }

    public static String e(String str) {
        if (com.haier.library.common.util.c.m(str)) {
            return null;
        }
        return f31405f.matcher(str).matches() ? str.replaceAll(f31406g, "") : str;
    }

    public static int f(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            e3.a.v("convert <%d> to  Int get exception,", str);
            return 0;
        }
    }

    public static byte[] g(String str) {
        if (com.haier.library.common.util.c.m(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            e3.a.h("", new Object[0]);
            return new byte[0];
        }
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.h("parserSelfDiscoveryInfo name is empty", new Object[0]);
            return null;
        }
        if (!str.startsWith(com.haier.uhome.usdk.base.a.T) && !str.startsWith(com.haier.uhome.usdk.base.a.U) && !str.startsWith(com.haier.uhome.usdk.base.a.V)) {
            e3.a.h("parserSelfDiscoveryInfo illegal format, name = %s", str);
            return null;
        }
        String[] strArrSplit = str.split("-");
        if (strArrSplit.length < 3) {
            String str2 = strArrSplit[1];
            e3.a.d("parserSelfDiscoveryInfo illegal format, name = %s  softApName = %s", str, str2, new Object[0]);
            return str2;
        }
        String strSubstring = strArrSplit[2].substring(1);
        e3.a.d("parserSelfDiscoveryInfo  name = %s  selfDiscoveryInfo = %s", str, strSubstring, new Object[0]);
        return strSubstring;
    }

    public static String i(String str) {
        if (com.haier.library.common.util.c.j(str)) {
            return "";
        }
        return str.length() > 2 ? str.substring(0, str.indexOf(45, 2)) : str;
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.v("parserSoftApName name is empty", new Object[0]);
            return null;
        }
        if (!str.startsWith(com.haier.uhome.usdk.base.a.T) && !str.startsWith(com.haier.uhome.usdk.base.a.U) && !str.startsWith(com.haier.uhome.usdk.base.a.V)) {
            e3.a.h("parserSoftApName illegal format, name = %s", str);
            return str;
        }
        String[] strArrSplit = str.split("-");
        if (strArrSplit.length < 3) {
            String str2 = strArrSplit[1];
            e3.a.d("parserSoftApName illegal format, name = %s  softApName = %s", str, str2, new Object[0]);
            return str2;
        }
        String strSubstring = strArrSplit[2].substring(1);
        e3.a.d("parserSoftApName  name = %s  selfDiscoveryInfo = %s", str, strSubstring, new Object[0]);
        return strSubstring;
    }

    public static String c() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.getDefault()).format(new Date());
    }

    private static void a(String str, a aVar) {
        aVar.f31407a = com.haier.uhome.usdk.base.api.h.a(a(str, 14, 2, 2, 6));
        aVar.f31408b = a(str, 16, 2, 2, 6);
        aVar.f31409c = String.format(Locale.ENGLISH, "%010d%s%s", Integer.valueOf((((((a(str, 18, 2, 2, 6) << 8) + a(str, 20, 2, 2, 6)) << 8) + a(str, 22, 2, 2, 6)) << 8) + a(str, 24, 2, 2, 6)), a(a(str, 26, 2, 4, 4)), a(a(str, 28, 2, 4, 4)));
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 32) {
            return false;
        }
        try {
            return str.getBytes("utf-8").length <= 32;
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
            return true;
        }
    }

    public static File b(Context context) {
        return a(context, com.haier.uhome.usdk.base.a.M);
    }

    public static int b() {
        return new SecureRandom().nextInt() & 65535;
    }

    public static List<String> a(List<String> list) {
        if (u.h(list)) {
            return new ArrayList();
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (TextUtils.isEmpty(next) || !next.matches(f31404e)) {
                e3.a.h("reorganizeConfigUplusIdList uplusId[%s] is invalid ", next);
                it.remove();
            }
        }
        return list;
    }

    private static String a(int i7) {
        return i7 > 0 ? String.format("%c", Integer.valueOf(i7)) : "0";
    }

    private static int a(String str, int i7, int i8, int i9, int i10) {
        int i11 = i7 + i8;
        return ((Integer.parseInt(str.substring(i7, i11), 16) << i9) + (Integer.parseInt(str.substring(i11, i8 + i11), 16) >> i10)) & 255;
    }

    public static String a(Context context) {
        if (context == null) {
            return "0.0.0";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e8) {
            e3.a.v("to string for get activity Version name fail! -> %s", e8);
            return "0.0.0";
        }
    }

    public static File a(Context context, String str) {
        if (context != null) {
            return new File(String.format("%s/%s", context.getFilesDir().getAbsolutePath(), str));
        }
        throw new IllegalArgumentException("Context should not be null");
    }

    public static long a() {
        return ((long) new SecureRandom().nextInt()) & 4294967295L;
    }

    public static int a(long j7, long j8) {
        int iCeil;
        if (j7 < j8) {
            iCeil = (int) Math.ceil(j7 / 1000.0d);
        } else {
            iCeil = (int) (j7 / 1000);
        }
        return Math.min(iCeil, ((int) j8) / 1000);
    }
}
