package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.h2;
import com.google.android.gms.location.zzbq;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z extends a1 {
    private final v Q;

    public z(Context context, Looper looper, com.google.android.gms.common.api.k.b bVar, com.google.android.gms.common.api.k.c cVar, String str, com.google.android.gms.common.internal.f fVar) {
        super(context, looper, bVar, cVar, str, fVar);
        this.Q = new v(context, this.P);
    }

    public final void A0(com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.l> aVar, i iVar) throws RemoteException {
        this.Q.h(aVar, iVar);
    }

    public final void B0(PendingIntent pendingIntent, i iVar) throws RemoteException {
        this.Q.j(pendingIntent, iVar);
    }

    public final void C0(com.google.android.gms.common.api.internal.n.a<com.google.android.gms.location.k> aVar, i iVar) throws RemoteException {
        this.Q.i(aVar, iVar);
    }

    public final void D0(boolean z7) throws RemoteException {
        this.Q.k(z7);
    }

    public final void E0(Location location) throws RemoteException {
        this.Q.l(location);
    }

    public final void F0(i iVar) throws RemoteException {
        this.Q.m(iVar);
    }

    public final void G0(LocationSettingsRequest locationSettingsRequest, com.google.android.gms.common.api.internal.e.b<LocationSettingsResult> bVar, String str) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.b(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        com.google.android.gms.common.internal.u.b(bVar != null, "listener can't be null.");
        ((m) M()).G0(locationSettingsRequest, new y(bVar), null);
    }

    public final void H0(long j7, PendingIntent pendingIntent) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.k(pendingIntent);
        com.google.android.gms.common.internal.u.b(j7 >= 0, "detectionIntervalMillis must be >= 0");
        ((m) M()).y3(j7, true, pendingIntent);
    }

    public final void I0(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e.b<Status> bVar) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.l(activityTransitionRequest, "activityTransitionRequest must be specified.");
        com.google.android.gms.common.internal.u.l(pendingIntent, "PendingIntent must be specified.");
        com.google.android.gms.common.internal.u.l(bVar, "ResultHolder not provided.");
        ((m) M()).j5(activityTransitionRequest, pendingIntent, new com.google.android.gms.common.api.internal.x(bVar));
    }

    public final void J0(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e.b<Status> bVar) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.l(bVar, "ResultHolder not provided.");
        ((m) M()).b1(pendingIntent, new com.google.android.gms.common.api.internal.x(bVar));
    }

    public final void K0(PendingIntent pendingIntent) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.k(pendingIntent);
        ((m) M()).l2(pendingIntent);
    }

    public final void L0(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e.b<Status> bVar) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.l(pendingIntent, "PendingIntent must be specified.");
        com.google.android.gms.common.internal.u.l(bVar, "ResultHolder not provided.");
        ((m) M()).V2(pendingIntent, new com.google.android.gms.common.api.internal.x(bVar));
    }

    public final void M0(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e.b<Status> bVar) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.l(geofencingRequest, "geofencingRequest can't be null.");
        com.google.android.gms.common.internal.u.l(pendingIntent, "PendingIntent must be specified.");
        com.google.android.gms.common.internal.u.l(bVar, "ResultHolder not provided.");
        ((m) M()).A5(geofencingRequest, pendingIntent, new w(bVar));
    }

    public final void N0(zzbq zzbqVar, com.google.android.gms.common.api.internal.e.b<Status> bVar) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.l(zzbqVar, "removeGeofencingRequest can't be null.");
        com.google.android.gms.common.internal.u.l(bVar, "ResultHolder not provided.");
        ((m) M()).v3(zzbqVar, new x(bVar));
    }

    public final void O0(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e.b<Status> bVar) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.l(pendingIntent, "PendingIntent must be specified.");
        com.google.android.gms.common.internal.u.l(bVar, "ResultHolder not provided.");
        ((m) M()).b6(pendingIntent, new x(bVar), G().getPackageName());
    }

    public final void P0(List<String> list, com.google.android.gms.common.api.internal.e.b<Status> bVar) throws RemoteException {
        z();
        com.google.android.gms.common.internal.u.b(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        com.google.android.gms.common.internal.u.l(bVar, "ResultHolder not provided.");
        ((m) M()).n4((String[]) list.toArray(new String[0]), new x(bVar), G().getPackageName());
    }

    public final Location Q0(String str) throws RemoteException {
        return g1.b.d(s(), h2.f16360c) ? this.Q.a(str) : this.Q.b();
    }

    @Override // com.google.android.gms.common.internal.e
    public final boolean a0() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.e, com.google.android.gms.common.api.a.f
    public final void f() {
        synchronized (this.Q) {
            if (a()) {
                try {
                    this.Q.n();
                    this.Q.o();
                } catch (Exception e8) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e8);
                }
                super.f();
            } else {
                super.f();
            }
            throw th;
        }
    }

    public final LocationAvailability v0() throws RemoteException {
        return this.Q.c();
    }

    public final void w0(zzba zzbaVar, com.google.android.gms.common.api.internal.n<com.google.android.gms.location.k> nVar, i iVar) throws RemoteException {
        synchronized (this.Q) {
            this.Q.e(zzbaVar, nVar, iVar);
        }
    }

    public final void x0(LocationRequest locationRequest, com.google.android.gms.common.api.internal.n<com.google.android.gms.location.l> nVar, i iVar) throws RemoteException {
        synchronized (this.Q) {
            this.Q.d(locationRequest, nVar, iVar);
        }
    }

    public final void y0(zzba zzbaVar, PendingIntent pendingIntent, i iVar) throws RemoteException {
        this.Q.f(zzbaVar, pendingIntent, iVar);
    }

    public final void z0(LocationRequest locationRequest, PendingIntent pendingIntent, i iVar) throws RemoteException {
        this.Q.g(locationRequest, pendingIntent, iVar);
    }
}
