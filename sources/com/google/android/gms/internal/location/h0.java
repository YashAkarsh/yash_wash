package com.google.android.gms.internal.location;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public static Looper a(@c.o0 Looper looper) {
        return looper != null ? looper : b();
    }

    public static Looper b() {
        com.google.android.gms.common.internal.u.r(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
