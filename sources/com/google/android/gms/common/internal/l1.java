package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f15762a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("sLock")
    private static boolean f15763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private static String f15764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f15765d;

    public static int a(Context context) {
        c(context);
        return f15765d;
    }

    @c.o0
    public static String b(Context context) {
        c(context);
        return f15764c;
    }

    private static void c(Context context) {
        synchronized (f15762a) {
            if (f15763b) {
                return;
            }
            f15763b = true;
            try {
                Bundle bundle = com.google.android.gms.common.wrappers.d.a(context).c(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f15764c = bundle.getString("com.google.app.id");
                f15765d = bundle.getInt("com.google.android.gms.version");
            } catch (PackageManager.NameNotFoundException e8) {
                Log.wtf("MetadataValueReader", "This should never happen.", e8);
            }
        }
    }
}
