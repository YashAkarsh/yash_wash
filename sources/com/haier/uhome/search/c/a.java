package com.haier.uhome.search.c;

import android.text.TextUtils;
import com.haier.library.common.util.c;
import com.haier.uhome.search.service.entity.b;
import com.haier.uhome.search.service.entity.e;
import com.haier.uhome.usdk.base.utils.f;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29777a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f29778b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29779c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29780d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29781e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29782f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f29783g = Pattern.compile("^uplus-\\w{1,6}-[0-9A-Za-z]{2,4}-[0-9A-Fa-f]{4}-v\\d{1,2}-[a-z]+$");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f29784h = Pattern.compile("^U-[A-Z]{1,6}[0-9A-F]{4}$");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f29785i = Pattern.compile("^U-[A-Z]{1,6}[0-9A-F]{4}-[0-9][0-9a-zA-Z]{0,14}$");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f29786j = Pattern.compile("^U-[A-Z]{1,6}[0-9A-F]{4}(-[0-9a-zA-Z]{5})?(-[0-9a-zA-Z]{4})?$");

    public static int a(int i7) {
        return (i7 == 1 || i7 == 2 || i7 == 3 || i7 == 4) ? 8 : 0;
    }

    public static int b(int i7) {
        if (i7 == 1) {
            return 8;
        }
        if (i7 == 2) {
            return 9;
        }
        if (i7 == 3) {
            return 136;
        }
        if (i7 == 4) {
            return 137;
        }
        if (i7 == 5) {
            return 16;
        }
        return i7 == 6 ? 393 : 0;
    }

    public static boolean c(String str) {
        return f29785i.matcher(str).matches();
    }

    public static boolean d(String str) {
        return f29786j.matcher(str).matches();
    }

    public static String e(String str) {
        if (b(str)) {
            return str.substring(0, str.length() - 4);
        }
        return c(str) ? str.substring(0, str.lastIndexOf("-") - 4) : "";
    }

    public static int f(String str) {
        if (!c(str)) {
            return -1;
        }
        int iLastIndexOf = str.lastIndexOf("-") + 1;
        return m(str.substring(iLastIndexOf, iLastIndexOf + 1));
    }

    public static int g(String str) {
        if (f29783g.matcher(str).matches()) {
            return m(str.split("-")[4].substring(1));
        }
        return -1;
    }

    public static int[] h(String str) {
        if (!f29783g.matcher(str).matches()) {
            return new int[]{-1, -1};
        }
        String[] strArrSplit = str.split("-");
        return new int[]{c.i(strArrSplit[2], 0, 2), c.h(strArrSplit[2], 2)};
    }

    public static e i(String str) {
        if (c.j(str)) {
            return null;
        }
        String[] strArrSplit = str.split("-");
        e eVar = new e();
        if (strArrSplit.length > 3) {
            eVar.f(strArrSplit[3]);
        }
        char[] charArray = strArrSplit[2].toCharArray();
        char[] cArr = new char[5];
        System.arraycopy(charArray, 0, cArr, 0, charArray.length);
        eVar.a(Character.toString(cArr[0]));
        eVar.b(Character.toString(cArr[1]));
        eVar.c(Character.toString(cArr[2]));
        eVar.d(Character.toString(cArr[3]));
        eVar.e(Character.toString(cArr[4]));
        return eVar;
    }

    public static int j(String str) {
        return a(f.f(str));
    }

    public static int k(String str) {
        return b(f.f(str));
    }

    public static String l(String str) {
        if (c.j(str)) {
            return "";
        }
        if (b(str)) {
            return str.substring(2, str.length() - 4);
        }
        if (c(str) || d(str)) {
            return str.substring(2, str.indexOf(45, 2) - 4);
        }
        return null;
    }

    private static int m(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e8) {
            e3.a.g("Parse dev function from dev ap error", e8);
            return -1;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.h("parserSelfDiscoveryInfo name is empty", new Object[0]);
            return "";
        }
        if (!c(str)) {
            return (!b(str) || str.length() < 4) ? "" : str.substring(str.length() - 4);
        }
        int iLastIndexOf = str.lastIndexOf("-");
        return str.substring(iLastIndexOf - 4, iLastIndexOf);
    }

    public static boolean b(String str) {
        return f29784h.matcher(str).matches();
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.delete(str.length() - 4, str.length());
        sb.append(str2);
        return sb.toString();
    }

    public static boolean a(String str, b bVar) {
        if (b(str)) {
            bVar.c(str);
            bVar.f(8);
            bVar.n(8);
            return true;
        }
        if (c(str)) {
            bVar.c(f.h(str));
            int iF = f(str);
            int iA = a(iF);
            bVar.f(iA != 0 ? iA : 8);
            bVar.n(b(iF));
            return true;
        }
        int iJ = 0;
        if (!d(str)) {
            return false;
        }
        bVar.c(f.i(str));
        e eVarI = i(str);
        if (eVarI != null) {
            iJ = j(eVarI.b());
            bVar.n(k(eVarI.b()));
            bVar.o(eVarI.a());
            bVar.p(eVarI.b());
            bVar.q(eVarI.c());
            bVar.r(eVarI.d());
            bVar.s(eVarI.e());
            bVar.t(eVarI.f());
        }
        bVar.f(iJ != 0 ? iJ : 8);
        return true;
    }
}
