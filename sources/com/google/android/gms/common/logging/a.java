package com.google.android.gms.common.logging;

import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.k;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f15869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15870d;

    @c1.a
    public a(@m0 String str, @m0 String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.f15868b = string;
        this.f15867a = str;
        this.f15869c = new k(str);
        int i7 = 2;
        while (i7 <= 7 && !Log.isLoggable(this.f15867a, i7)) {
            i7++;
        }
        this.f15870d = i7;
    }

    @c1.a
    public void a(@m0 String str, @o0 Object... objArr) {
        if (g(3)) {
            Log.d(this.f15867a, d(str, objArr));
        }
    }

    @c1.a
    public void b(@m0 String str, @m0 Throwable th, @o0 Object... objArr) {
        Log.e(this.f15867a, d(str, objArr), th);
    }

    @c1.a
    public void c(@m0 String str, @o0 Object... objArr) {
        Log.e(this.f15867a, d(str, objArr));
    }

    @c1.a
    @m0
    protected String d(@m0 String str, @o0 Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f15868b.concat(str);
    }

    @c1.a
    @m0
    public String e() {
        return this.f15867a;
    }

    @c1.a
    public void f(@m0 String str, @o0 Object... objArr) {
        Log.i(this.f15867a, d(str, objArr));
    }

    @c1.a
    public boolean g(int i7) {
        return this.f15870d <= i7;
    }

    @c1.a
    public void h(@m0 String str, @m0 Throwable th, @o0 Object... objArr) {
        if (g(2)) {
            Log.v(this.f15867a, d(str, objArr), th);
        }
    }

    @c1.a
    public void i(@m0 String str, @o0 Object... objArr) {
        if (g(2)) {
            Log.v(this.f15867a, d(str, objArr));
        }
    }

    @c1.a
    public void j(@m0 String str, @o0 Object... objArr) {
        Log.w(this.f15867a, d(str, objArr));
    }

    @c1.a
    public void k(@m0 String str, @m0 Throwable th, @o0 Object... objArr) {
        Log.wtf(this.f15867a, d(str, objArr), th);
    }

    @c1.a
    public void l(@m0 Throwable th) {
        Log.wtf(this.f15867a, th);
    }
}
