package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class x extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.android.gms.common.api.internal.e.b<Status> f16177a;

    public x(com.google.android.gms.common.api.internal.e.b<Status> bVar) {
        this.f16177a = bVar;
    }

    private final void u0(int i7) {
        if (this.f16177a == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times", new Exception());
            return;
        }
        this.f16177a.b(com.google.android.gms.location.p.b(com.google.android.gms.location.p.a(i7)));
        this.f16177a = null;
    }

    @Override // com.google.android.gms.internal.location.k
    public final void m1(int i7, String[] strArr) {
        u0(i7);
    }

    @Override // com.google.android.gms.internal.location.k
    public final void p6(int i7, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult", new Exception());
    }

    @Override // com.google.android.gms.internal.location.k
    public final void t5(int i7, PendingIntent pendingIntent) {
        u0(i7);
    }
}
