package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public final class k extends l {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.m0
    public static final String f15853k = "GooglePlayServicesErrorDialog";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Deprecated
    public static final int f15854l = l.f15857a;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.m0
    @Deprecated
    public static final String f15855m = "com.google.android.gms";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @c.m0
    public static final String f15856n = "com.android.vending";

    private k() {
    }

    @Deprecated
    public static void A(int i7, @c.m0 Context context) {
        g gVarX = g.x();
        if (l.o(context, i7) || l.p(context, i7)) {
            gVarX.J(context);
        } else {
            gVarX.C(context, i7);
        }
    }

    @c.m0
    @Deprecated
    public static PendingIntent f(int i7, @c.m0 Context context, int i8) {
        return l.f(i7, context, i8);
    }

    @g1.d0
    @c.m0
    @Deprecated
    public static String g(int i7) {
        return l.g(i7);
    }

    @c.m0
    public static Context i(@c.m0 Context context) {
        return l.i(context);
    }

    @c.m0
    public static Resources j(@c.m0 Context context) {
        return l.j(context);
    }

    @com.google.android.gms.common.internal.l
    @Deprecated
    public static int l(@c.m0 Context context) {
        return l.l(context);
    }

    @c1.a
    @Deprecated
    public static int m(@c.m0 Context context, int i7) {
        return l.m(context, i7);
    }

    @Deprecated
    public static boolean s(int i7) {
        return l.s(i7);
    }

    @c.o0
    @Deprecated
    public static Dialog v(int i7, @c.m0 Activity activity, int i8) {
        return w(i7, activity, i8, null);
    }

    @c.o0
    @Deprecated
    public static Dialog w(int i7, @c.m0 Activity activity, int i8, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        if (true == l.o(activity, i7)) {
            i7 = 18;
        }
        return g.x().t(activity, i7, i8, onCancelListener);
    }

    @Deprecated
    public static boolean x(int i7, @c.m0 Activity activity, int i8) {
        return y(i7, activity, i8, null);
    }

    @Deprecated
    public static boolean y(int i7, @c.m0 Activity activity, int i8, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        return z(i7, activity, null, i8, onCancelListener);
    }

    public static boolean z(int i7, @c.m0 Activity activity, @c.o0 Fragment fragment, int i8, @c.o0 DialogInterface.OnCancelListener onCancelListener) {
        if (true == l.o(activity, i7)) {
            i7 = 18;
        }
        g gVarX = g.x();
        if (fragment == null) {
            return gVarX.B(activity, i7, i8, onCancelListener);
        }
        Dialog dialogE = gVarX.E(activity, i7, com.google.android.gms.common.internal.n0.c(fragment, g.x().e(activity, i7, "d"), i8), onCancelListener);
        if (dialogE == null) {
            return false;
        }
        gVarX.H(activity, dialogE, f15853k, onCancelListener);
        return true;
    }
}
