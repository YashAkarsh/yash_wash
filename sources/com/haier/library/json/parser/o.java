package com.haier.library.json.parser;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a[] f26778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26779b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f26780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final char[] f26781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f26782c;

        a(String str, int i7) {
            this.f26780a = str;
            this.f26781b = str.toCharArray();
            this.f26782c = i7;
        }
    }

    public o(int i7) {
        this.f26779b = i7 - 1;
        this.f26778a = new a[i7];
        a("$ref", 0, 4, 1185263);
        a(com.haier.library.json.a.f26646c, 0, 5, 62680954);
    }

    public static int c(char[] cArr, int i7, int i8) {
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            i10 = (i10 * 31) + cArr[i7];
            i9++;
            i7++;
        }
        return i10;
    }

    private static String d(String str, int i7, int i8) {
        char[] cArr = new char[i8];
        str.getChars(i7, i8 + i7, cArr, 0);
        return new String(cArr);
    }

    public String a(String str, int i7, int i8, int i9) {
        int i10 = this.f26779b & i9;
        a aVar = this.f26778a[i10];
        if (aVar != null) {
            return (i9 == aVar.f26782c && i8 == aVar.f26781b.length && str.regionMatches(i7, aVar.f26780a, 0, i8)) ? aVar.f26780a : d(str, i7, i8);
        }
        if (i8 != str.length()) {
            str = d(str, i7, i8);
        }
        String strIntern = str.intern();
        this.f26778a[i10] = new a(strIntern, i9);
        return strIntern;
    }

    public String b(char[] cArr, int i7, int i8, int i9) {
        int i10 = this.f26779b & i9;
        a aVar = this.f26778a[i10];
        if (aVar == null) {
            String strIntern = new String(cArr, i7, i8).intern();
            this.f26778a[i10] = new a(strIntern, i9);
            return strIntern;
        }
        boolean z7 = false;
        if (i9 == aVar.f26782c && i8 == aVar.f26781b.length) {
            for (int i11 = 0; i11 < i8; i11++) {
                if (cArr[i7 + i11] == aVar.f26781b[i11]) {
                }
            }
            z7 = true;
        }
        return z7 ? aVar.f26780a : new String(cArr, i7, i8);
    }
}
