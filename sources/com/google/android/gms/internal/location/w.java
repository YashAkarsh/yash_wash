package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class w extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.gms.common.api.internal.e.b<Status> f16175a;

    public w(com.google.android.gms.common.api.internal.e.b<Status> bVar) {
        this.f16175a = bVar;
    }

    @Override // com.google.android.gms.internal.location.k
    public final void m1(int i7, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult", new Exception());
    }

    @Override // com.google.android.gms.internal.location.k
    public final void p6(int i7, String[] strArr) {
        if (this.f16175a == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times", new Exception());
            return;
        }
        this.f16175a.b(com.google.android.gms.location.p.b(com.google.android.gms.location.p.a(i7)));
        this.f16175a = null;
    }

    @Override // com.google.android.gms.internal.location.k
    public final void t5(int i7, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult", new Exception());
    }
}
