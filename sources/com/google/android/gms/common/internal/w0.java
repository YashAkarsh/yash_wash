package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class w0 implements com.google.android.gms.common.api.n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.common.api.n f15814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.tasks.n f15815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ t.a f15816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ z0 f15817d;

    w0(com.google.android.gms.common.api.n nVar, com.google.android.gms.tasks.n nVar2, t.a aVar, z0 z0Var) {
        this.f15814a = nVar;
        this.f15815b = nVar2;
        this.f15816c = aVar;
        this.f15817d = z0Var;
    }

    @Override // com.google.android.gms.common.api.n.a
    public final void a(Status status) {
        if (!status.G0()) {
            this.f15815b.b(c.a(status));
        } else {
            this.f15815b.c(this.f15816c.a(this.f15814a.e(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
