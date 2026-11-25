package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class z extends BasePendingResult<Status> {
    @Deprecated
    public z(@c.m0 Looper looper) {
        super(looper);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    @c.m0
    protected final /* bridge */ /* synthetic */ com.google.android.gms.common.api.t k(@c.m0 Status status) {
        return status;
    }

    @c1.a
    public z(@c.m0 com.google.android.gms.common.api.k kVar) {
        super(kVar);
    }
}
