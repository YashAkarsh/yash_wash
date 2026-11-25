package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.t;

/* JADX INFO: loaded from: classes.dex */
final class f0<R extends t> extends BasePendingResult<R> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final R f15097r;

    public f0(k kVar, R r7) {
        super(kVar);
        this.f15097r = r7;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final R k(Status status) {
        return this.f15097r;
    }
}
