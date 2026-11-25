package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.g2;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@com.google.android.gms.common.internal.y
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c1.a
    @c.m0
    public static final String f15575b = "com.google.android.gms";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c1.a
    @c.m0
    public static final String f15576c = "com.android.vending";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c1.a
    static final String f15577d = "d";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c1.a
    static final String f15578e = "n";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    public static final int f15574a = l.f15857a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final h f15579f = new h();

    @c1.a
    h() {
    }

    @c1.a
    @c.m0
    public static h i() {
        return f15579f;
    }

    @c1.a
    public void a(@c.m0 Context context) {
        l.a(context);
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public int b(@c.m0 Context context) {
        return l.d(context);
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public int c(@c.m0 Context context) {
        return l.e(context);
    }

    @c.o0
    @Deprecated
    @c1.a
    @com.google.android.gms.common.internal.y
    public Intent d(int i7) {
        return e(null, i7, null);
    }

    @c.o0
    @c1.a
    @com.google.android.gms.common.internal.y
    public Intent e(@c.o0 Context context, int i7, @c.o0 String str) {
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3) {
                return null;
            }
            return g2.c("com.google.android.gms");
        }
        if (context != null && g1.l.l(context)) {
            return g2.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f15574a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(com.google.android.gms.common.wrappers.d.a(context).f(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return g2.b("com.google.android.gms", sb.toString());
    }

    @c.o0
    @c1.a
    public PendingIntent f(@c.m0 Context context, int i7, int i8) {
        return g(context, i7, i8, null);
    }

    @c.o0
    @c1.a
    @com.google.android.gms.common.internal.y
    public PendingIntent g(@c.m0 Context context, int i7, int i8, @c.o0 String str) {
        Intent intentE = e(context, i7, str);
        if (intentE == null) {
            return null;
        }
        return com.google.android.gms.internal.common.o.a(context, i8, intentE, com.google.android.gms.internal.common.o.f16120a | 134217728);
    }

    @c1.a
    @c.m0
    public String h(int i7) {
        return l.g(i7);
    }

    @com.google.android.gms.common.internal.l
    @c1.a
    public int j(@c.m0 Context context) {
        return k(context, f15574a);
    }

    @c1.a
    public int k(@c.m0 Context context, int i7) {
        int iM = l.m(context, i7);
        if (l.o(context, iM)) {
            return 18;
        }
        return iM;
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public boolean l(@c.m0 Context context, int i7) {
        return l.o(context, i7);
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public boolean m(@c.m0 Context context, int i7) {
        return l.p(context, i7);
    }

    @c1.a
    public boolean n(@c.m0 Context context, @c.m0 String str) {
        return l.u(context, str);
    }

    @c1.a
    public boolean o(int i7) {
        return l.s(i7);
    }

    @c1.a
    public void p(@c.m0 Context context, int i7) throws i, j {
        l.c(context, i7);
    }
}
