package com.google.android.gms.common.wrappers;

import android.content.Context;
import c.m0;
import c.o0;
import g1.v;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f15998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private static Boolean f15999b;

    @c1.a
    public static synchronized boolean a(@m0 Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f15998a;
        if (context2 != null && (bool = f15999b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f15999b = null;
        if (v.n()) {
            f15999b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f15999b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f15999b = Boolean.FALSE;
            }
        }
        f15998a = applicationContext;
        return f15999b.booleanValue();
    }
}
