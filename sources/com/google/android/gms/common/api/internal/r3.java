package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionResult f15398b;

    r3(ConnectionResult connectionResult, int i7) {
        com.google.android.gms.common.internal.u.k(connectionResult);
        this.f15398b = connectionResult;
        this.f15397a = i7;
    }

    final int a() {
        return this.f15397a;
    }

    final ConnectionResult b() {
        return this.f15398b;
    }
}
