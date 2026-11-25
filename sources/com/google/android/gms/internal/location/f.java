package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.zzbq;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f implements com.google.android.gms.location.h {
    @Override // com.google.android.gms.location.h
    @Deprecated
    public final com.google.android.gms.common.api.n<Status> a(com.google.android.gms.common.api.k kVar, List<com.google.android.gms.location.f> list, PendingIntent pendingIntent) {
        GeofencingRequest.a aVar = new GeofencingRequest.a();
        aVar.b(list);
        aVar.d(5);
        return kVar.m(new c(this, kVar, aVar.c(), pendingIntent));
    }

    @Override // com.google.android.gms.location.h
    public final com.google.android.gms.common.api.n<Status> b(com.google.android.gms.common.api.k kVar, PendingIntent pendingIntent) {
        return e(kVar, zzbq.K(pendingIntent));
    }

    @Override // com.google.android.gms.location.h
    public final com.google.android.gms.common.api.n<Status> c(com.google.android.gms.common.api.k kVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return kVar.m(new c(this, kVar, geofencingRequest, pendingIntent));
    }

    @Override // com.google.android.gms.location.h
    public final com.google.android.gms.common.api.n<Status> d(com.google.android.gms.common.api.k kVar, List<String> list) {
        return e(kVar, zzbq.s(list));
    }

    public final com.google.android.gms.common.api.n<Status> e(com.google.android.gms.common.api.k kVar, zzbq zzbqVar) {
        return kVar.m(new d(this, kVar, zzbqVar));
    }
}
