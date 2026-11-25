package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class o3 implements com.google.android.gms.common.api.k.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15363a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.common.api.k f15364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    public final com.google.android.gms.common.api.k.c f15365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ p3 f15366f;

    public o3(p3 p3Var, int i7, @c.o0 com.google.android.gms.common.api.k kVar, com.google.android.gms.common.api.k.c cVar) {
        this.f15366f = p3Var;
        this.f15363a = i7;
        this.f15364d = kVar;
        this.f15365e = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.q
    public final void u0(@c.m0 ConnectionResult connectionResult) {
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(connectionResult)));
        this.f15366f.t(connectionResult, this.f15363a);
    }
}
