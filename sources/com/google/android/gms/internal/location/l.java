package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class l extends a implements m {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.m
    public final void A5(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, k kVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, geofencingRequest);
        u0.c(parcelI0, pendingIntent);
        u0.d(parcelI0, kVar);
        y0(57, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void C3(zzl zzlVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, zzlVar);
        y0(75, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final LocationAvailability F1(String str) throws RemoteException {
        Parcel parcelI0 = i0();
        parcelI0.writeString(str);
        Parcel parcelU0 = u0(34, parcelI0);
        LocationAvailability locationAvailability = (LocationAvailability) u0.b(parcelU0, LocationAvailability.CREATOR);
        parcelU0.recycle();
        return locationAvailability;
    }

    @Override // com.google.android.gms.internal.location.m
    public final void G0(LocationSettingsRequest locationSettingsRequest, o oVar, String str) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, locationSettingsRequest);
        u0.d(parcelI0, oVar);
        parcelI0.writeString(null);
        y0(63, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void V2(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.k kVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, pendingIntent);
        u0.d(parcelI0, kVar);
        y0(69, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final Location W2(String str) throws RemoteException {
        Parcel parcelI0 = i0();
        parcelI0.writeString(str);
        Parcel parcelU0 = u0(80, parcelI0);
        Location location = (Location) u0.b(parcelU0, Location.CREATOR);
        parcelU0.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.m
    public final void a5(i iVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.d(parcelI0, iVar);
        y0(67, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void b1(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.k kVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, pendingIntent);
        u0.d(parcelI0, kVar);
        y0(73, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void b6(PendingIntent pendingIntent, k kVar, String str) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, pendingIntent);
        u0.d(parcelI0, kVar);
        parcelI0.writeString(str);
        y0(2, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void c6(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, com.google.android.gms.common.api.internal.k kVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, pendingIntent);
        u0.c(parcelI0, sleepSegmentRequest);
        u0.d(parcelI0, kVar);
        y0(79, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void f4(Location location) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, location);
        y0(13, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void j5(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.k kVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, activityTransitionRequest);
        u0.c(parcelI0, pendingIntent);
        u0.d(parcelI0, kVar);
        y0(72, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void k1(zzbc zzbcVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, zzbcVar);
        y0(59, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void l2(PendingIntent pendingIntent) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, pendingIntent);
        y0(6, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void n4(String[] strArr, k kVar, String str) throws RemoteException {
        Parcel parcelI0 = i0();
        parcelI0.writeStringArray(strArr);
        u0.d(parcelI0, kVar);
        parcelI0.writeString(str);
        y0(3, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final Location o() throws RemoteException {
        Parcel parcelU0 = u0(7, i0());
        Location location = (Location) u0.b(parcelU0, Location.CREATOR);
        parcelU0.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.m
    public final void u(boolean z7) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.a(parcelI0, z7);
        y0(12, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void v3(zzbq zzbqVar, k kVar) throws RemoteException {
        Parcel parcelI0 = i0();
        u0.c(parcelI0, zzbqVar);
        u0.d(parcelI0, kVar);
        y0(74, parcelI0);
    }

    @Override // com.google.android.gms.internal.location.m
    public final void y3(long j7, boolean z7, PendingIntent pendingIntent) throws RemoteException {
        Parcel parcelI0 = i0();
        parcelI0.writeLong(j7);
        u0.a(parcelI0, true);
        u0.c(parcelI0, pendingIntent);
        y0(5, parcelI0);
    }
}
