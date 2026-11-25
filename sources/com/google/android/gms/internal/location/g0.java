package com.google.android.gms.internal.location;

import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements com.google.android.gms.location.r {
    @Override // com.google.android.gms.location.r
    public final com.google.android.gms.common.api.n<LocationSettingsResult> a(com.google.android.gms.common.api.k kVar, LocationSettingsRequest locationSettingsRequest) {
        return kVar.l(new f0(this, kVar, locationSettingsRequest, null));
    }
}
