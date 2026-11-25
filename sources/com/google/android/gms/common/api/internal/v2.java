package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class v2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ y2 f15447a;

    v2(y2 y2Var) {
        this.f15447a = y2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15447a.f15464i.b(new ConnectionResult(4));
    }
}
