package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class s extends com.google.android.gms.common.api.j<com.google.android.gms.common.api.a.d.C0181d> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f16408k = 0;

    public s(@c.m0 Activity activity) {
        super(activity, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, com.google.android.gms.common.api.j.a.f15488c);
    }

    @c.m0
    public com.google.android.gms.tasks.m<n> A(@c.m0 final LocationSettingsRequest locationSettingsRequest) {
        return i(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(locationSettingsRequest) { // from class: com.google.android.gms.location.k1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final LocationSettingsRequest f16375a;

            {
                this.f16375a = locationSettingsRequest;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).G0(this.f16375a, new l1((com.google.android.gms.tasks.n) obj2), null);
            }
        }).f(2426).a());
    }

    public s(@c.m0 Context context) {
        super(context, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, com.google.android.gms.common.api.j.a.f15488c);
    }
}
