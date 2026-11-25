package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends l implements b {
    public static b u0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
        return iInterfaceQueryLocalInterface instanceof b ? (b) iInterfaceQueryLocalInterface : new i0(iBinder);
    }
}
