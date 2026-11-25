package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class l1 implements com.google.android.gms.common.api.internal.e.b<LocationSettingsResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.tasks.n<n> f16381a;

    public l1(com.google.android.gms.tasks.n<n> nVar) {
        this.f16381a = nVar;
    }

    @Override // com.google.android.gms.common.api.internal.e.b
    public final void a(Status status) {
        this.f16381a.b(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.e.b
    public final /* bridge */ /* synthetic */ void b(LocationSettingsResult locationSettingsResult) {
        LocationSettingsResult locationSettingsResult2 = locationSettingsResult;
        Status statusG = locationSettingsResult2.G();
        if (statusG.G0()) {
            this.f16381a.c(new n(locationSettingsResult2));
        } else if (statusG.s0()) {
            this.f16381a.b(new com.google.android.gms.common.api.q(statusG));
        } else {
            this.f16381a.b(new com.google.android.gms.common.api.b(statusG));
        }
    }
}
