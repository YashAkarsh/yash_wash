package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface k extends IInterface {
    @Nullable
    Tile G4(int i7, int i8, int i9) throws RemoteException;
}
