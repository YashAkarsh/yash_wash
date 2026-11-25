package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@Deprecated
public class d {
    @c1.a
    @m0
    public static String a(@m0 PowerManager.WakeLock wakeLock, @m0 String str) {
        String strValueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (true == TextUtils.isEmpty(str)) {
            str = "";
        }
        String strValueOf2 = String.valueOf(str);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }
}
