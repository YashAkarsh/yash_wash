package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class x1 implements com.google.android.gms.common.api.internal.e.b<Status> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.tasks.n<Void> f16421a;

    public x1(com.google.android.gms.tasks.n<Void> nVar) {
        com.google.android.gms.common.internal.u.k(nVar);
        this.f16421a = nVar;
    }

    @Override // com.google.android.gms.common.api.internal.e.b
    public final void a(@c.o0 Status status) {
        if (status == null) {
            return;
        }
        this.f16421a.b(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.e.b
    public final /* bridge */ /* synthetic */ void b(Status status) {
        com.google.android.gms.common.api.internal.b0.b(status, null, this.f16421a);
    }
}
