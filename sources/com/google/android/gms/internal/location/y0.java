package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class y0 implements com.google.android.gms.location.b {
    @Override // com.google.android.gms.location.b
    public final com.google.android.gms.common.api.n<Status> a(com.google.android.gms.common.api.k kVar, PendingIntent pendingIntent) {
        return kVar.m(new w0(this, kVar, pendingIntent));
    }

    @Override // com.google.android.gms.location.b
    public final com.google.android.gms.common.api.n<Status> b(com.google.android.gms.common.api.k kVar, long j7, PendingIntent pendingIntent) {
        return kVar.m(new v0(this, kVar, j7, pendingIntent));
    }
}
