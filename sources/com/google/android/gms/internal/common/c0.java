package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends a0 {
    public static boolean a(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
