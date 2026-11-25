package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends a0 implements k {
    public j() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.a0
    protected final boolean i0(int i7, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i7 == 1) {
            p6(parcel.readInt(), parcel.createStringArray());
        } else if (i7 == 2) {
            m1(parcel.readInt(), parcel.createStringArray());
        } else {
            if (i7 != 3) {
                return false;
            }
            t5(parcel.readInt(), (PendingIntent) u0.b(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
