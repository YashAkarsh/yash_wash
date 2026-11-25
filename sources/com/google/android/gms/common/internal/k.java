package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private final String f15755b;

    @c1.a
    public k(@c.m0 String str) {
        this(str, null);
    }

    private final String r(String str) {
        String str2 = this.f15755b;
        return str2 == null ? str : str2.concat(str);
    }

    private final String s(String str, Object... objArr) {
        String str2 = String.format(str, objArr);
        String str3 = this.f15755b;
        return str3 == null ? str2 : str3.concat(str2);
    }

    @c1.a
    public boolean a(int i7) {
        return Log.isLoggable(this.f15754a, i7);
    }

    @c1.a
    public boolean b() {
        return false;
    }

    @c1.a
    public void c(@c.m0 String str, @c.m0 String str2) {
        if (a(3)) {
            Log.d(str, r(str2));
        }
    }

    @c1.a
    public void d(@c.m0 String str, @c.m0 String str2, @c.m0 Throwable th) {
        if (a(3)) {
            Log.d(str, r(str2), th);
        }
    }

    @c1.a
    public void e(@c.m0 String str, @c.m0 String str2) {
        if (a(6)) {
            Log.e(str, r(str2));
        }
    }

    @c1.a
    public void f(@c.m0 String str, @c.m0 String str2, @c.m0 Throwable th) {
        if (a(6)) {
            Log.e(str, r(str2), th);
        }
    }

    @c1.a
    public void g(@c.m0 String str, @c.m0 String str2, @c.m0 Object... objArr) {
        if (a(6)) {
            Log.e(str, s(str2, objArr));
        }
    }

    @c1.a
    public void h(@c.m0 String str, @c.m0 String str2) {
        if (a(4)) {
            Log.i(str, r(str2));
        }
    }

    @c1.a
    public void i(@c.m0 String str, @c.m0 String str2, @c.m0 Throwable th) {
        if (a(4)) {
            Log.i(str, r(str2), th);
        }
    }

    @c1.a
    public void j(@c.m0 String str, @c.m0 String str2) {
    }

    @c1.a
    public void k(@c.m0 String str, @c.m0 String str2, @c.m0 Throwable th) {
    }

    @c1.a
    public void l(@c.m0 String str, @c.m0 String str2) {
        if (a(2)) {
            Log.v(str, r(str2));
        }
    }

    @c1.a
    public void m(@c.m0 String str, @c.m0 String str2, @c.m0 Throwable th) {
        if (a(2)) {
            Log.v(str, r(str2), th);
        }
    }

    @c1.a
    public void n(@c.m0 String str, @c.m0 String str2) {
        if (a(5)) {
            Log.w(str, r(str2));
        }
    }

    @c1.a
    public void o(@c.m0 String str, @c.m0 String str2, @c.m0 Throwable th) {
        if (a(5)) {
            Log.w(str, r(str2), th);
        }
    }

    @c1.a
    public void p(@c.m0 String str, @c.m0 String str2, @c.m0 Object... objArr) {
        if (a(5)) {
            Log.w(this.f15754a, s(str2, objArr));
        }
    }

    @c1.a
    public void q(@c.m0 String str, @c.m0 String str2, @c.m0 Throwable th) {
        if (a(7)) {
            Log.e(str, r(str2), th);
            Log.wtf(str, r(str2), th);
        }
    }

    @c1.a
    public k(@c.m0 String str, @c.o0 String str2) {
        u.l(str, "log tag cannot be null");
        u.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f15754a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f15755b = null;
        } else {
            this.f15755b = str2;
        }
    }
}
