package com.google.zxing.client.result;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final u[] f23511a = {new f(), new c(), new j(), new b(), new f0(), new e(), new g0(), new i(), new y(), new a0(), new v(), new x(), new n(), new k0(), new e0(), new d0(), new p(), new t(), new l(), new i0()};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f23512b = Pattern.compile("\\d+");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f23513c = Pattern.compile(m0.a.f37445e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f23514d = Pattern.compile("=");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f23515e = "\ufeff";

    private static void a(CharSequence charSequence, Map<String, String> map) {
        String[] strArrSplit = f23514d.split(charSequence, 2);
        if (strArrSplit.length == 2) {
            try {
                map.put(strArrSplit[0], p(strArrSplit[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    private static int b(CharSequence charSequence, int i7) {
        int i8 = 0;
        for (int i9 = i7 - 1; i9 >= 0 && charSequence.charAt(i9) == '\\'; i9--) {
            i8++;
        }
        return i8;
    }

    protected static String c(com.google.zxing.r rVar) {
        String strG = rVar.g();
        return strG.startsWith(f23515e) ? strG.substring(1) : strG;
    }

    protected static boolean d(CharSequence charSequence, int i7) {
        return charSequence != null && i7 > 0 && i7 == charSequence.length() && f23512b.matcher(charSequence).matches();
    }

    protected static boolean e(CharSequence charSequence, int i7, int i8) {
        int i9;
        return charSequence != null && i8 > 0 && charSequence.length() >= (i9 = i8 + i7) && f23512b.matcher(charSequence.subSequence(i7, i9)).matches();
    }

    static String[] f(String str, String str2, char c8, boolean z7) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i7 = 0;
        while (i7 < length) {
            int iIndexOf = str2.indexOf(str, i7);
            if (iIndexOf < 0) {
                break;
            }
            int length2 = iIndexOf + str.length();
            boolean z8 = true;
            ArrayList arrayList2 = arrayList;
            int length3 = length2;
            while (z8) {
                int iIndexOf2 = str2.indexOf(c8, length3);
                if (iIndexOf2 < 0) {
                    length3 = str2.length();
                } else if (b(str2, iIndexOf2) % 2 != 0) {
                    length3 = iIndexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String strO = o(str2.substring(length2, iIndexOf2));
                    if (z7) {
                        strO = strO.trim();
                    }
                    if (!strO.isEmpty()) {
                        arrayList2.add(strO);
                    }
                    length3 = iIndexOf2 + 1;
                }
                z8 = false;
            }
            i7 = length3;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    static String g(String str, String str2, char c8, boolean z7) {
        String[] strArrF = f(str, str2, c8, z7);
        if (strArrF == null) {
            return null;
        }
        return strArrF[0];
    }

    protected static void h(String str, StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    protected static void i(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                sb.append('\n');
                sb.append(str);
            }
        }
    }

    protected static String[] j(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static int l(char c8) {
        if (c8 >= '0' && c8 <= '9') {
            return c8 - '0';
        }
        char c9 = 'a';
        if (c8 < 'a' || c8 > 'f') {
            c9 = 'A';
            if (c8 < 'A' || c8 > 'F') {
                return -1;
            }
        }
        return (c8 - c9) + 10;
    }

    static Map<String, String> m(String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            return null;
        }
        HashMap map = new HashMap(3);
        for (String str2 : f23513c.split(str.substring(iIndexOf + 1))) {
            a(str2, map);
        }
        return map;
    }

    public static q n(com.google.zxing.r rVar) {
        for (u uVar : f23511a) {
            q qVarK = uVar.k(rVar);
            if (qVarK != null) {
                return qVarK;
            }
        }
        return new b0(rVar.g(), null);
    }

    protected static String o(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z7 = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z7 || cCharAt != '\\') {
                sb.append(cCharAt);
                z7 = false;
            } else {
                z7 = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    static String p(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e8) {
            throw new IllegalStateException(e8);
        }
    }

    public abstract q k(com.google.zxing.r rVar);
}
