package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzbq;

/* JADX INFO: loaded from: classes.dex */
public interface m extends IInterface {
    void A5(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, k kVar) throws RemoteException;

    void C3(zzl zzlVar) throws RemoteException;

    LocationAvailability F1(String str) throws RemoteException;

    void G0(LocationSettingsRequest locationSettingsRequest, o oVar, String str) throws RemoteException;

    void V2(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.k kVar) throws RemoteException;

    Location W2(@c.o0 String str) throws RemoteException;

    void a5(i iVar) throws RemoteException;

    void b1(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.k kVar) throws RemoteException;

    void b6(PendingIntent pendingIntent, k kVar, String str) throws RemoteException;

    void c6(PendingIntent pendingIntent, @c.o0 SleepSegmentRequest sleepSegmentRequest, com.google.android.gms.common.api.internal.k kVar) throws RemoteException;

    void f4(Location location) throws RemoteException;

    void j5(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.k kVar) throws RemoteException;

    void k1(zzbc zzbcVar) throws RemoteException;

    void l2(PendingIntent pendingIntent) throws RemoteException;

    void n4(String[] strArr, k kVar, String str) throws RemoteException;

    @Deprecated
    Location o() throws RemoteException;

    void u(boolean z7) throws RemoteException;

    void v3(zzbq zzbqVar, k kVar) throws RemoteException;

    void y3(long j7, boolean z7, PendingIntent pendingIntent) throws RemoteException;
}
