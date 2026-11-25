package com.google.android.gms.internal.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16120a;

    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    static {
        int i7 = Build.VERSION.SDK_INT;
        int i8 = 33554432;
        if (i7 < 31) {
            if (i7 >= 30) {
                String str = Build.VERSION.CODENAME;
                if (str.length() != 1 || str.charAt(0) < 'S' || str.charAt(0) > 'Z') {
                    i8 = 0;
                }
            } else {
                i8 = 0;
            }
        }
        f16120a = i8;
    }

    public static PendingIntent a(Context context, int i7, Intent intent, int i8) {
        return PendingIntent.getActivity(context, i7, intent, i8);
    }
}
