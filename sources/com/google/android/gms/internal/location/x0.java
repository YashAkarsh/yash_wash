package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
abstract class x0 extends com.google.android.gms.location.u0<Status> {
    public x0(com.google.android.gms.common.api.k kVar) {
        super(kVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.api.t k(Status status) {
        return status;
    }
}
