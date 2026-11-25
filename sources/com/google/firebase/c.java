package com.google.firebase;

import c.m0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.y;

/* JADX INFO: loaded from: classes2.dex */
@c1.a
public class c implements y {
    @Override // com.google.android.gms.common.api.internal.y
    @m0
    public final Exception a(@m0 Status status) {
        return status.p0() == 8 ? new b(status.J0()) : new a(status.J0());
    }
}
