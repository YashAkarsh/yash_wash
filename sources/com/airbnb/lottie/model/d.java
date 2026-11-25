package com.airbnb.lottie.model;

import c.x0;
import com.airbnb.lottie.model.content.n;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n> f12077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f12078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f12079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f12080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f12081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f12082f;

    public d(List<n> list, char c8, double d8, double d9, String str, String str2) {
        this.f12077a = list;
        this.f12078b = c8;
        this.f12079c = d8;
        this.f12080d = d9;
        this.f12081e = str;
        this.f12082f = str2;
    }

    public static int e(char c8, String str, String str2) {
        return ((((0 + c8) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<n> a() {
        return this.f12077a;
    }

    double b() {
        return this.f12079c;
    }

    String c() {
        return this.f12081e;
    }

    public double d() {
        return this.f12080d;
    }

    public int hashCode() {
        return e(this.f12078b, this.f12082f, this.f12081e);
    }
}
