package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends com.google.android.gms.common.api.j<com.google.android.gms.common.api.a.d.C0181d> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f16364k = 0;

    public i(@c.m0 Activity activity) {
        super(activity, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, com.google.android.gms.common.api.j.a.f15488c);
    }

    @c.w0("android.permission.ACCESS_FINE_LOCATION")
    @c.m0
    public com.google.android.gms.tasks.m<Void> A(@c.m0 GeofencingRequest geofencingRequest, @c.m0 final PendingIntent pendingIntent) {
        final GeofencingRequest geofencingRequestP0 = geofencingRequest.p0(r());
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(geofencingRequestP0, pendingIntent) { // from class: com.google.android.gms.location.k0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final GeofencingRequest f16373a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final PendingIntent f16374b;

            {
                this.f16373a = geofencingRequestP0;
                this.f16374b = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).M0(this.f16373a, this.f16374b, new n0((com.google.android.gms.tasks.n) obj2));
            }
        }).f(2424).a());
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> B(@c.m0 final PendingIntent pendingIntent) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(pendingIntent) { // from class: com.google.android.gms.location.l0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final PendingIntent f16380a;

            {
                this.f16380a = pendingIntent;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).O0(this.f16380a, new n0((com.google.android.gms.tasks.n) obj2));
            }
        }).f(2425).a());
    }

    @c.m0
    public com.google.android.gms.tasks.m<Void> C(@c.m0 final List<String> list) {
        return o(com.google.android.gms.common.api.internal.a0.a().c(new com.google.android.gms.common.api.internal.v(list) { // from class: com.google.android.gms.location.m0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List f16390a;

            {
                this.f16390a = list;
            }

            @Override // com.google.android.gms.common.api.internal.v
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((com.google.android.gms.internal.location.z) obj).P0(this.f16390a, new n0((com.google.android.gms.tasks.n) obj2));
            }
        }).f(2425).a());
    }

    public i(@c.m0 Context context) {
        super(context, m.f16384a, com.google.android.gms.common.api.a.d.f15078l0, com.google.android.gms.common.api.j.a.f15488c);
    }
}
