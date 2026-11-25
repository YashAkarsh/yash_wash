package org.hamcrest.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class d<T> extends org.hamcrest.b<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f39710d = Pattern.compile("%([0-9]+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.hamcrest.k<T> f39712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f39713c;

    public d(String str, org.hamcrest.k<T> kVar, Object[] objArr) {
        this.f39711a = str;
        this.f39712b = kVar;
        this.f39713c = (Object[]) objArr.clone();
    }

    @org.hamcrest.i
    public static <T> org.hamcrest.k<T> e(String str, org.hamcrest.k<T> kVar, Object... objArr) {
        return new d(str, kVar, objArr);
    }

    @Override // org.hamcrest.b, org.hamcrest.k
    public void a(Object obj, org.hamcrest.g gVar) {
        this.f39712b.a(obj, gVar);
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        Matcher matcher = f39710d.matcher(this.f39711a);
        int iEnd = 0;
        while (matcher.find()) {
            gVar.d(this.f39711a.substring(iEnd, matcher.start()));
            gVar.e(this.f39713c[Integer.parseInt(matcher.group(1))]);
            iEnd = matcher.end();
        }
        if (iEnd < this.f39711a.length()) {
            gVar.d(this.f39711a.substring(iEnd));
        }
    }

    @Override // org.hamcrest.k
    public boolean c(Object obj) {
        return this.f39712b.c(obj);
    }
}
