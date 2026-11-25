package com.airbnb.lottie;

import android.graphics.Bitmap;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private Bitmap f11880f;

    @x0({x0.a.LIBRARY})
    public i(int i7, int i8, String str, String str2, String str3) {
        this.f11875a = i7;
        this.f11876b = i8;
        this.f11877c = str;
        this.f11878d = str2;
        this.f11879e = str3;
    }

    @o0
    public Bitmap a() {
        return this.f11880f;
    }

    public String b() {
        return this.f11879e;
    }

    public String c() {
        return this.f11878d;
    }

    public int d() {
        return this.f11876b;
    }

    public String e() {
        return this.f11877c;
    }

    public int f() {
        return this.f11875a;
    }

    public void g(@o0 Bitmap bitmap) {
        this.f11880f = bitmap;
    }
}
