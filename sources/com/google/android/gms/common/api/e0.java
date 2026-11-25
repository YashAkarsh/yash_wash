package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.t;

/* JADX INFO: loaded from: classes.dex */
final class e0<R extends t> extends BasePendingResult<R> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final R f15095r;

    public e0(R r7) {
        super(Looper.getMainLooper());
        this.f15095r = r7;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final R k(Status status) {
        if (status.p0() == this.f15095r.G().p0()) {
            return this.f15095r;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
