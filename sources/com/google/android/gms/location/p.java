package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16394a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16395b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16396c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16397d = 1001;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16398e = 1002;

    private p() {
    }

    public static int a(int i7) {
        if ((i7 < 0 || i7 > 1) && (i7 < 1000 || i7 >= 1006)) {
            return 1;
        }
        return i7;
    }

    @c.m0
    public static Status b(int i7) {
        if (i7 == 1) {
            i7 = 13;
        }
        return new Status(i7);
    }
}
