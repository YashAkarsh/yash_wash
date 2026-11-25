package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class g1 implements com.google.android.gms.common.api.u<Status> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ z f15216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f15217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.api.k f15218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ j1 f15219d;

    g1(j1 j1Var, z zVar, boolean z7, com.google.android.gms.common.api.k kVar) {
        this.f15219d = j1Var;
        this.f15216a = zVar;
        this.f15217b = z7;
        this.f15218c = kVar;
    }

    @Override // com.google.android.gms.common.api.u
    public final /* bridge */ /* synthetic */ void a(@c.m0 com.google.android.gms.common.api.t tVar) {
        Status status = (Status) tVar;
        com.google.android.gms.auth.api.signin.internal.b.b(this.f15219d.f15293i).i();
        if (status.G0() && this.f15219d.u()) {
            j1 j1Var = this.f15219d;
            j1Var.i();
            j1Var.g();
        }
        this.f15216a.o(status);
        if (this.f15217b) {
            this.f15218c.i();
        }
    }
}
