package com.google.android.gms.common.api;

import c.o0;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.t;

/* JADX INFO: loaded from: classes.dex */
final class g0<R extends t> extends BasePendingResult<R> {
    public g0(@o0 k kVar) {
        super(kVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final R k(Status status) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
