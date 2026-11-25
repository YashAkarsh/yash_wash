package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.TelemetryData;

/* JADX INFO: loaded from: classes.dex */
public final class j extends com.google.android.gms.internal.base.a implements IInterface {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void t6(TelemetryData telemetryData) throws RemoteException {
        Parcel parcelI0 = i0();
        com.google.android.gms.internal.base.c.c(parcelI0, telemetryData);
        z3(1, parcelI0);
    }
}
