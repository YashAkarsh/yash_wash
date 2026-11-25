package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f23401d = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23403c;

    public c0(String str, String str2) {
        super(r.URI);
        this.f23402b = i(str);
        this.f23403c = str2;
    }

    private static boolean g(String str, int i7) {
        int i8 = i7 + 1;
        int iIndexOf = str.indexOf(47, i8);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return u.e(str, i8, iIndexOf - i8);
    }

    private static String i(String str) {
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(58);
        return (iIndexOf < 0 || g(strTrim, iIndexOf)) ? "http://".concat(strTrim) : strTrim;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.c(this.f23403c, sb);
        q.c(this.f23402b, sb);
        return sb.toString();
    }

    public String e() {
        return this.f23403c;
    }

    public String f() {
        return this.f23402b;
    }

    public boolean h() {
        return f23401d.matcher(this.f23402b).find();
    }
}
