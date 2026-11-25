package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f12990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12991b;

    public k(int i7) {
        this.f12991b = i7 - 1;
        this.f12990a = new String[i7];
        a("$ref", 0, 4, 1185263);
        String str = com.alibaba.fastjson.a.f12529c;
        a(str, 0, str.length(), com.alibaba.fastjson.a.f12529c.hashCode());
    }

    public static int e(char[] cArr, int i7, int i8) {
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            i10 = (i10 * 31) + cArr[i7];
            i9++;
            i7++;
        }
        return i10;
    }

    private static String f(String str, int i7, int i8) {
        char[] cArr = new char[i8];
        str.getChars(i7, i8 + i7, cArr, 0);
        return new String(cArr);
    }

    public String a(String str, int i7, int i8, int i9) {
        return b(str, i7, i8, i9, false);
    }

    public String b(String str, int i7, int i8, int i9, boolean z7) {
        int i10 = this.f12991b & i9;
        String str2 = this.f12990a[i10];
        if (str2 == null) {
            if (i8 != str.length()) {
                str = f(str, i7, i8);
            }
            String strIntern = str.intern();
            this.f12990a[i10] = strIntern;
            return strIntern;
        }
        if (i9 == str2.hashCode() && i8 == str2.length() && str.startsWith(str2, i7)) {
            return str2;
        }
        String strF = f(str, i7, i8);
        if (z7) {
            this.f12990a[i10] = strF;
        }
        return strF;
    }

    public String c(char[] cArr, int i7, int i8) {
        return d(cArr, i7, i8, e(cArr, i7, i8));
    }

    public String d(char[] cArr, int i7, int i8, int i9) {
        int i10 = this.f12991b & i9;
        String str = this.f12990a[i10];
        if (str == null) {
            String strIntern = new String(cArr, i7, i8).intern();
            this.f12990a[i10] = strIntern;
            return strIntern;
        }
        boolean z7 = false;
        if (i9 == str.hashCode() && i8 == str.length()) {
            for (int i11 = 0; i11 < i8; i11++) {
                if (cArr[i7 + i11] == str.charAt(i11)) {
                }
            }
            z7 = true;
        }
        return z7 ? str : new String(cArr, i7, i8);
    }
}
